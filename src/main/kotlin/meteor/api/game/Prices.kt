package meteor.api.game

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import meteor.Logger
import meteor.game.ItemManager
import java.time.Duration
import java.util.concurrent.ExecutionException

object Prices {
    private val logger: Logger = Logger("Prices")

    private val itemManager: ItemManager? = null
    private val CACHE = CacheBuilder.newBuilder()
        .expireAfterWrite(Duration.ofMinutes(5))
        .build(object : CacheLoader<Int, Int>() {
            override fun load(itemId: Int): Int? {
                logger.debug("Caching item {} price", itemId)
                return GameThread.invokeLater { itemManager!!.getItemPrice(itemId) }
            }
        })

    fun getItemPrice(id: Int): Int? {
        return try {
            CACHE[id]
        } catch (e: ExecutionException) {
            -1
        }
    }
}