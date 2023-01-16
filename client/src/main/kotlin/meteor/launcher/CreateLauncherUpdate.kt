package meteor.launcher

import com.google.gson.GsonBuilder
import meteor.launcher.model.File
import meteor.launcher.model.LauncherUpdate
import java.nio.file.Files
import java.nio.file.Path
import java.util.zip.CRC32
import kotlin.math.ceil

object CreateLauncherUpdate {
    private val release = LauncherUpdate()
    private val releaseDir = java.io.File(".\\client\\build\\release\\")
    private val modulesFile = java.io.File("./client/build/compose/binaries/main/app/client/runtime/lib/modules")

    @JvmStatic
    fun main(args: Array<String>) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        release.version = "164" // Last merged PR is version
        release.updateInfo = ""

        if (releaseDir.exists())
            releaseDir.deleteRecursively()

        releaseDir.mkdirs()
        java.io.File("./client/build/compose/binaries/main/app/client/client.bat")
            .writeText(
                "%USERPROFILE%\\.meteor\\launcher\\client.exe\n" +
                        "pause")
        crawlDirectory(java.io.File("./client/build/compose/binaries/main/app/client/"))
        handleModuleFiles()
        java.io.File("./client/build/release/release.json").writeText(gson.toJson(release))
    }

    private fun handleModuleFiles() {
        val modulesChunks = divideModules()
        for ((count, chunk) in modulesChunks.withIndex()) {
            val file = File()
            file.name = "modules\\modules-$count"
            val targetFile = java.io.File("./client/build/release/modules/modules-$count")
            java.io.File("./client/build/release/modules/").mkdirs()
            targetFile.writeBytes(chunk)
            file.size = chunk.size.toLong()
            file.hash = generateCRC(targetFile)
            release.modulesParts.add(file)
        }
    }

    private fun divideModules(): ArrayList<ByteArray> {
        val source = modulesFile.readBytes()
        var bytesRead = 0
        val chunksize = 45 * 1024 * 1024

        val chunksArray = ArrayList<ByteArray>()
        for (i in 1..ceil(source.size / chunksize.toDouble()).toInt()) {
            when (i) {
                1, 2 -> chunksArray.add(ByteArray(chunksize))
                3 -> {
                    val remainingBytes = (chunksize * 3) - source.size
                    chunksArray.add(ByteArray(remainingBytes))
                }
            }
        }

        for (i in chunksArray.indices) {
            if (bytesRead + chunksize > source.size) {
                System.arraycopy(source, bytesRead, chunksArray[i], 0, source.size - bytesRead)
            } else {
                System.arraycopy(source, bytesRead, chunksArray[i], 0, chunksize)
            }
            bytesRead += chunksize
        }
        return chunksArray
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

                if (!f.name.endsWith("\\modules"))
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

    private fun generateCRC(file: java.io.File): String {
        val crc32 = CRC32()
        crc32.update(file.readBytes())
        return crc32.value.toString()
    }
}
