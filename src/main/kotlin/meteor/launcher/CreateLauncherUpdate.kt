package meteor.launcher

import com.google.gson.GsonBuilder
import java.io.FileInputStream
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest
import kotlin.math.ceil

object CreateLauncherUpdate {
    val update = LauncherUpdate()
    val releaseDir = java.io.File(".\\build\\release\\")
    val modulesFile = java.io.File("./build/compose/binaries/main/app/meteor-client/runtime/lib/modules")

    @JvmStatic
    fun main(args: Array<String>) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        update.version = "1.2.3-4"
        update.updateInfo = "small potatoes"

        if (releaseDir.exists())
            releaseDir.deleteRecursively()

        releaseDir.mkdirs()

        crawlDirectory(java.io.File("./build/compose/binaries/main/app/meteor-client/"))
        handleModuleFiles()
        java.io.File("./build/release/release.json").writeText(gson.toJson(update))
    }

    fun handleModuleFiles() {
        val modulesChunks = divideModules()
        for ((count, chunk) in modulesChunks.withIndex()) {
           val file = File()
           file.name = "modules\\modules-$count"
           var targetFile = java.io.File("./build/release/modules/modules-$count")
           java.io.File("./build/release/modules/").mkdirs()
           targetFile.writeBytes(chunk)
           file.size = chunk.size.toLong()
           file.hash = getCheckSumFromFile(MessageDigest.getInstance("SHA-256"), targetFile)
           update.modulesParts.add(file)
        }
    }

    fun divideModules(): ArrayList<ByteArray> {
        val source = modulesFile.readBytes()
        var bytesRead = 0
        val chunksize = 45 * 1024 * 1024

        val chunksArray = ArrayList<ByteArray>()
         for (i in 1..ceil(source.size / chunksize.toDouble()).toInt()) {
             when (i) {
                 1,2 -> chunksArray.add(ByteArray(chunksize))
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

    fun crawlDirectory(dir: java.io.File) {
        for (file in dir.listFiles()!!) {
            if (file.isDirectory) {
                if (file.listFiles()!!.isNotEmpty())
                    crawlDirectory(file)
            } else {
                val f = File()
                f.name = "meteor-client\\" + file.absolutePath.split("app\\meteor-client\\")[1]
                f.size = Files.size(Path.of(file.toURI()));
                f.hash = getCheckSumFromFile(MessageDigest.getInstance("SHA-256"), file)

                if (!f.name.endsWith("\\modules"))
                    update.files.add(f)
                val targetFile = java.io.File("$releaseDir\\${file.absolutePath.split("app\\meteor-client\\")[1]}")
                val targetDir = java.io.File(targetFile.parent)
                try {
                    targetDir.mkdirs()
                    Files.copy(file.toPath(), targetFile.toPath())
                } catch (_: java.nio.file.FileAlreadyExistsException) { }
            }
        }
    }

    fun getCheckSumFromFile(digest: MessageDigest, file: java.io.File): String {
        val fis = FileInputStream(file)
        val byteArray = updateDigest(digest, fis).digest()
        fis.close()
        val hexCode = encodeHex(byteArray)
        return String(hexCode)
    }

    fun encodeHex(data: ByteArray): CharArray {
        val l = data.size
        val out = CharArray(l shl 1)
        // two characters form the hex value.
        var i = 0
        var j = 0
        while (i < l) {
            out[j++] = DIGITS_UPPER[0xF0 and data[i].toInt() ushr 4]
            out[j++] = DIGITS_UPPER[0x0F and data[i].toInt()]
            i++
        }
        return out
    }

    /**
     * Reads through an InputStream and updates the digest for the data
     *
     * @param digest The MessageDigest to use (e.g. MD5)
     * @param data Data to digest
     * @return the digest
     */
    private fun updateDigest(digest: MessageDigest, data: InputStream): MessageDigest {
        val buffer = ByteArray(1024)
        var read = data.read(buffer, 0, 1024)
        while (read > -1) {
            digest.update(buffer, 0, read)
            read = data.read(buffer, 0, 1024)
        }
        return digest
    }

    private val DIGITS_UPPER =
        charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
}