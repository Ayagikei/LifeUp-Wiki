@file:JvmName("OpenCCScript")
@file:CompilerOptions("-jvm-target", "11")
@file:Repository("https://repo1.maven.org/maven2")
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.github.houbb:opencc4j:1.7.2")
@file:DependsOn("com.qiniu:qiniu-java-sdk:7.15.0")
@file:DependsOn("io.github.fishb1:apk-info:1.0.0")

import com.qiniu.storage.Configuration
import com.qiniu.storage.Region
import com.qiniu.storage.UploadManager
import com.qiniu.util.Auth
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.system.exitProcess


fun main() {
    val commitFilePath = "last_commit.txt"
    val fullUpload = envFlag("QINIU_FULL_UPLOAD")
    val lastCommit = if (fullUpload) null else getLastCommit(commitFilePath)
    val currentCommit = getCurrentCommit()

    if (fullUpload) {
        println("Full upload enabled via QINIU_FULL_UPLOAD.")
    }

    val filesToUpload = when {
        fullUpload -> getAllFilesUnderDocs("docs")
        lastCommit != null -> {
            println("Last commit: $lastCommit")
            println("Current commit: $currentCommit")

            val changedFiles = getChangedFiles(lastCommit, currentCommit)
            println("Changed files: $changedFiles")
            changedFiles
        }
        else -> {
            println("No last commit found, please ensure $commitFilePath exists and contains a valid commit hash.")
            println("Or set QINIU_FULL_UPLOAD=true to upload all files under docs/ once.")
            exitProcess(1)
        }
    }

        // get Qiniu credentials
        val accessKey = System.getenv("QINIU_ACCESS_KEY") ?: error("QINIU_ACCESS_KEY not set")
        val secretKey = System.getenv("QINIU_SECRET_KEY") ?: error("QINIU_SECRET_KEY not set")
        val bucketName = System.getenv("QINIU_BUCKET_NAME") ?: error("QINIU_BUCKET_NAME not set")

        val auth = Auth.create(accessKey, secretKey)
        val config = Configuration(Region.huanan())
        config.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2 // 指定分片上传版本

        val uploadManager = UploadManager(config)

        // 上传文件
        var allUploadedSuccessfully = true
        for (file in filesToUpload) {
            if(file.startsWith("docs/").not()){
                println("Skip $file")
                continue
            }
            val filePath = "$file"
            val key = filePath.substringAfter("docs/")  // 不包含docs

            // need to specify the key to override the existing file
            val token = auth.uploadToken(bucketName, key)

            try {
                val response = uploadManager.put(filePath, key, token)
                println("Successfully uploaded $file -> $key: ${response.bodyString()}")
            } catch (e: Exception) {
                println("Failed to upload $file: ${e.message}")
                allUploadedSuccessfully = false
                break
            }
        }

        if (allUploadedSuccessfully) {
            saveCurrentCommit(commitFilePath, currentCommit)
            println("Successfully updated commit info to $currentCommit")
        }else{
            println("Failed to upload all files, please check the error message above.")
            exitProcess(1)
        }
}

fun getLastCommit(filePath: String): String? {
    return try {
        Files.readAllLines(Paths.get(filePath)).firstOrNull()?.trim()?.takeIf { it.isNotBlank() }
    } catch (e: Exception) {
        null
    }
}

fun getCurrentCommit(): String {
    val result = runCommand(listOf("git", "rev-parse", "HEAD"))
    if (result.exitCode != 0) {
        error("Failed to get current commit: ${result.output.trim()}")
    }
    return result.output.trim()
}

fun getChangedFiles(lastCommit: String, currentCommit: String): List<String> {
    val result = runCommand(listOf("git", "diff", "--name-only", lastCommit, currentCommit))
    if (result.exitCode != 0) {
        println("Failed to get changed files via git diff (exit=${result.exitCode}).")
        println(result.output.trim())
        println("If you recently force-pushed or rewrote history, you may need a one-time full upload: set QINIU_FULL_UPLOAD=true.")
        exitProcess(result.exitCode)
    }
    return result.output
        .lineSequence()
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .toList()
}

fun saveCurrentCommit(filePath: String, commit: String) {
    File(filePath).writeText(commit)
}

data class CommandResult(val exitCode: Int, val output: String)

fun runCommand(command: List<String>): CommandResult {
    val process = ProcessBuilder(command)
        .redirectErrorStream(true)
        .start()
    val output = process.inputStream.bufferedReader().readText()
    val exitCode = process.waitFor()
    return CommandResult(exitCode, output)
}

fun envFlag(name: String): Boolean {
    val raw = System.getenv(name)?.trim().orEmpty()
    if (raw.isBlank()) return false
    return raw.equals("1", ignoreCase = true) ||
            raw.equals("true", ignoreCase = true) ||
            raw.equals("yes", ignoreCase = true) ||
            raw.equals("y", ignoreCase = true)
}

fun getAllFilesUnderDocs(docsDir: String): List<String> {
    val root = File(docsDir)
    if (!root.exists() || !root.isDirectory) {
        println("docs directory not found: $docsDir")
        exitProcess(1)
    }
    return root
        .walkTopDown()
        .filter { it.isFile }
        .map { file ->
            val relative = file.relativeTo(root).path.replace(File.separatorChar, '/')
            "$docsDir/$relative"
        }
        .toList()
        .sorted()
}

main()

exitProcess(0)
