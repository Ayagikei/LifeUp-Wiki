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
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.system.exitProcess


fun main() {
    val commitFilePath = "last_commit.txt"
    val lastCommit = getLastCommit(commitFilePath)
    val currentCommit = getCurrentCommit()

    if (lastCommit != null) {
        println("Last commit: $lastCommit")
        println("Current commit: $currentCommit")

        val changedFiles = getChangedFiles(lastCommit, currentCommit)
        println("Changed files: $changedFiles")

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
        for (file in changedFiles) {
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
    } else {
        println("No last commit found, please ensure $commitFilePath exists and contains a valid commit hash.")
    }
}

fun getLastCommit(filePath: String): String? {
    return try {
        Files.readAllLines(Paths.get(filePath)).firstOrNull()
    } catch (e: Exception) {
        null
    }
}

fun getCurrentCommit(): String {
    val command = "git rev-parse HEAD"
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    return reader.readLine()
}

fun getChangedFiles(lastCommit: String, currentCommit: String): List<String> {
    val command = "git diff --name-only $lastCommit $currentCommit"
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val changedFiles = mutableListOf<String>()

    reader.useLines { lines ->
        lines.forEach { changedFiles.add(it) }
    }

    return changedFiles
}

fun saveCurrentCommit(filePath: String, commit: String) {
    File(filePath).writeText(commit)
}

main()

exitProcess(0)