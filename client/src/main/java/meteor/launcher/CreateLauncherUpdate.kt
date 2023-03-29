package meteor.launcher

import com.google.gson.GsonBuilder
import meteor.launcher.model.File
import meteor.launcher.model.LauncherUpdate
import java.nio.file.Files
import java.nio.file.Path
import java.util.zip.CRC32
import kotlin.math.ceil

object CreateLauncherUpdate {
    private val releaseVersion = "269"
    private val runtimeVersion = "17.0.5"

    private val release = LauncherUpdate()
    private val releaseDir = java.io.File(".\\build\\release\\")

    @JvmStatic
    fun main(args: Array<String>) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        release.version = releaseVersion // Last merged PR is version
        release.updateInfo = ""

        if (releaseDir.exists())
            releaseDir.deleteRecursively()

        releaseDir.mkdirs()
        java.io.File("./build/compose/binaries/main/app/client/client.bat")
            .writeText(
                "\"%USERPROFILE%\\.meteor\\launcher\\client.exe\"\n" +
                        "pause")
        crawlDirectory(java.io.File("./build/compose/binaries/main/app/client/"))
        java.io.File("./build/release/release.json").writeText(gson.toJson(release))
        java.io.File("./build/release/runtime.version").writeText(runtimeVersion)
    }

    private fun crawlDirectory(dir: java.io.File) {
        for (file in dir.listFiles()!!) {
            if (file.isDirectory) {
                if (file.listFiles()!!.isNotEmpty())
                    if (!file.name.equals("legal")) {
                        crawlDirectory(file)
                    }
            } else {
                val f = File()
                f.name = "\\" + file.absolutePath.split("app\\client\\")[1]
                f.size = Files.size(Path.of(file.toURI()))
                f.hash = generateCRC(file)

                if (!f.name.contains("\\runtime\\")) {
                    release.files.add(f)
                    val targetFile = java.io.File("$releaseDir\\${file.absolutePath.split("app\\client\\")[1]}")
                    val targetDir = java.io.File(targetFile.parent)
                    try {
                        targetDir.mkdirs()
                        Files.copy(file.toPath(), targetFile.toPath())
                    } catch (_: java.nio.file.FileAlreadyExistsException) {
                    }
                }

            }
        }
    }

    private fun generateCRC(file: java.io.File): String {
        val crc32 = CRC32()
        crc32.update(file.readBytes())
        return crc32.value.toString()
    }
}
