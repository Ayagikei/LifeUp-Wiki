@file:JvmName("OpenCCScript")
@file:CompilerOptions("-jvm-target", "11")
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("com.github.houbb:opencc4j:1.7.2")
// @file:DependsOn("com.example:library:1.2.3")


import com.github.houbb.opencc4j.util.ZhTwConverterUtil
import java.io.File

fun start() {
    val originDir = File("\\docs\\zh-cn")
    val destDir = File("\\docs\\zh-hant")
    if (originDir.exists()) {
        println("originDir exist ${originDir.absolutePath}")
    }else{
        println("warning: originDir not exist ${originDir.absolutePath}")
    }
    originDir.walkTopDown().forEach {
        println("waking on ${it.absolutePath}")
        val destFile = File(it.absolutePath.replace(originDir.absolutePath, destDir.absolutePath))
        if (destFile.exists() && destFile.lastModified() == it.lastModified() && destFile.length() == it.length()) {
            return@forEach
        }
        if (it.extension == "md") {
            convert(it, destFile)
            destFile.setLastModified(it.lastModified())
        } else {
            if (it.isDirectory && destFile.exists()) {
                return@forEach
            }
            it.copyTo(
                File(it.absolutePath.replace(originDir.absolutePath, destDir.absolutePath)),
                overwrite = true
            )
            destFile.setLastModified(it.lastModified())
        }
    }
}


fun convert(input: File, outputFile: File) {
    val text = input.readText()
    val output = ZhTwConverterUtil.toTraditional(text).replace("zh-cn", "zh-hant")
    if (outputFile.parentFile?.exists()?.not() == true) {
        outputFile.parentFile?.mkdirs()
    }
    outputFile.delete()
    outputFile.createNewFile()
    outputFile.writeText(output)
}

println("start running...")
start()