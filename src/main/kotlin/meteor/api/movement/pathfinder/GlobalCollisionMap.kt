package meteor.api.movement.pathfinder

import meteor.api.movement.pathfinder.BitSet4D
import java.io.File
import java.io.IOException
import java.util.zip.GZIPOutputStream
import java.io.FileOutputStream
import meteor.api.movement.pathfinder.GlobalCollisionMap
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.util.*
import kotlin.experimental.and

class GlobalCollisionMap : CollisionMap {
    val regions = arrayOfNulls<BitSet4D>(256 * 256)

    constructor() {}
    constructor(data: ByteArray?) {
        val buffer = ByteBuffer.wrap(data)
        while (buffer.hasRemaining()) {
            val region: Int = (buffer.short and 0xffff.toShort()).toInt()
            regions[region] = BitSet4D(buffer, 64, 64, 4, 2)
        }
    }

    fun writeToFile(): File {
        val bytes = toBytes()
        val fileLoc = File("collision-map")
        if (!fileLoc.isFile) {
            try {
                fileLoc.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        try {
            ByteArrayOutputStream(bytes.size).use { bos ->
                GZIPOutputStream(bos).use { gos ->
                    FileOutputStream(fileLoc).use { fos ->
                        gos.write(bytes)
                        gos.finish()
                        fos.write(bos.toByteArray())
                        gos.flush()
                        fos.flush()
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileLoc
    }

    fun toBytes(): ByteArray {
        val regionCount = Arrays.stream(regions).filter { obj: BitSet4D? -> Objects.nonNull(obj) }
            .count().toInt()
        val buffer = ByteBuffer.allocate(regionCount * (2 + 64 * 64 * 4 * 2 / 8))
        for (i in regions.indices) {
            if (regions[i] != null) {
                buffer.putShort(i.toShort())
                regions[i]!!.write(buffer)
            }
        }
        return buffer.array()
    }

    operator fun set(x: Int, y: Int, z: Int, w: Int, value: Boolean) {
        val region = regions[x / 64 * 256 + y / 64] ?: return
        region[x % 64, y % 64, z, w] = value
    }

    fun getRegion(x: Int, y: Int): BitSet4D? {
        val regionId = x / 64 * 256 + y / 64
        return regions[regionId]
    }

    fun createRegion(region: Int) {
        regions[region] = BitSet4D(64, 64, 4, 2)
        regions[region]!!.setAll(true)
    }

    operator fun get(x: Int, y: Int, z: Int, w: Int): Boolean {
        val region = getRegion(x, y) ?: return true
        val regionX = x % 64
        val regionY = y % 64
        return region[regionX, regionY, z, w]
    }

    fun overwrite(globalCollisionMap: GlobalCollisionMap) {
        System.arraycopy(globalCollisionMap.regions, 0, regions, 0, regions.size)
    }

    override fun n(x: Int, y: Int, z: Int): Boolean {
        return get(x, y, z, 0)
    }

    override fun e(x: Int, y: Int, z: Int): Boolean {
        return get(x, y, z, 1)
    }
}