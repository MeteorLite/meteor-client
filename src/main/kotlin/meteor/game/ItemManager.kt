/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.game

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.google.common.collect.ImmutableMap
import eventbus.events.GameStateChanged
import eventbus.events.PostItemComposition
import meteor.Logger
import meteor.Main.client
import meteor.Main.httpClient
import meteor.plugins.EventSubscriber
import meteor.rs.ClientThread
import meteor.util.AsyncBufferedImage
import net.runelite.api.*
import net.runelite.http.api.item.ItemClient
import net.runelite.http.api.item.ItemPrice
import net.runelite.http.api.item.ItemStats
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import javax.annotation.Nonnull
import kotlin.system.exitProcess

object ItemManager : EventSubscriber() {
    private val itemClient: ItemClient = ItemClient(httpClient)
    var itemImages: LoadingCache<ImageKey, AsyncBufferedImage>
    var itemCompositions: LoadingCache<Int, ItemComposition>
    var itemOutlines: LoadingCache<OutlineKey, BufferedImage>
    var log = Logger.getLogger(ItemManager::class.java)
    private var itemPrices = emptyMap<Int, ItemPrice>()
    private var itemStats = emptyMap<Int, ItemStats>()

    init {
        try {
            loadPrices()
            loadStats()
            itemImages = CacheBuilder.newBuilder()
                .maximumSize(128L)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build(object : CacheLoader<ImageKey, AsyncBufferedImage>() {
                    override fun load(key: ImageKey): AsyncBufferedImage {
                        return loadImage(key.itemId, key.itemQuantity, key.stackable)
                    }
                })
            itemCompositions = CacheBuilder.newBuilder()
                .maximumSize(1024L)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build(object : CacheLoader<Int?, ItemComposition>() {
                    override fun load(key: Int?): ItemComposition {
                        return client.getItemComposition(key!!)
                    }
                })
            itemOutlines = CacheBuilder.newBuilder()
                .maximumSize(128L)
                .expireAfterAccess(1, TimeUnit.HOURS)
                .build(object : CacheLoader<OutlineKey, BufferedImage>() {
                    override fun load(key: OutlineKey): BufferedImage {
                        return loadItemOutline(key.itemId, key.itemQuantity, key.outlineColor)
                    }
                })
        } catch (e: Exception) {
            println("No route for RuneLite item prices http-api... System.exit")
            exitProcess(1)
        }
        subscribe()
    }

    private fun loadPrices() {
        try {
            val prices = itemClient.prices
            if (prices != null) {
                val map = ImmutableMap
                    .builder<Int, ItemPrice>()
                for (price in prices) {
                    map.put(price.id, price)
                }
                itemPrices = map.build()
            }
        } catch (e: Exception) {
            log.warn("error loading prices!")
            e.printStackTrace()
        }
    }

    private fun loadStats() {
        try {
            val stats = itemClient.stats
            if (stats != null) {
                itemStats = ImmutableMap.copyOf(stats)
            }
        } catch (e: Exception) {
            log.warn("error loading stats!")
            e.printStackTrace()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.HOPPING
            || it.gameState == GameState.LOGIN_SCREEN
        ) {
            itemCompositions.invalidateAll()
        }
    }

    override fun onPostItemComposition(it: PostItemComposition) {
        itemCompositions.put(it.itemComposition.id, it.itemComposition)
    }

    /**
     * Invalidates internal item manager item composition cache (but not client item composition
     * cache)
     *
     * @see Client.getItemCompositionCache
     */
    fun invalidateItemCompositionCache() {
        itemCompositions.invalidateAll()
    }

    /**
     * Look up an item's price
     *
     * @param itemID item id
     * @return item price
     */
    fun getItemPrice(itemID: Int): Int {
        return getItemPriceWithSource(itemID, false)
    }

    /**
     * Look up an item's price
     *
     * @param itemID       item id
     * @param useWikiPrice use the actively traded/wiki price
     * @return item price
     */
    fun getItemPriceWithSource(itemID: Int, useWikiPrice: Boolean): Int {
        var itemID = itemID
        if (itemID == ItemID.COINS_995) {
            return 1
        }
        if (itemID == ItemID.PLATINUM_TOKEN) {
            return 1000
        }
        val itemComposition = getItemComposition(itemID)
        if (itemComposition!!.note != -1) {
            itemID = itemComposition.linkedNoteId
        }
        itemID = WORN_ITEMS.getOrDefault(itemID, itemID)!!
        var price = 0
        val mappedItems: Collection<ItemMapping>? = ItemMapping.getMapping(itemID)
        if (mappedItems == null) {
            val ip = itemPrices[itemID]
            if (ip != null) {
                price = if (useWikiPrice && ip.wikiPrice > 0) ip.wikiPrice else ip.price
            }
        } else {
            for (mappedItem in mappedItems) {
                price += (getItemPriceWithSource(mappedItem.tradeableItem, useWikiPrice) * mappedItem
                    .quantity).toInt()
            }
        }
        return price
    }

    fun getAlchValue(composition: ItemComposition): Int {
        if (composition.id == ItemID.COINS_995) {
            return 1
        }
        return if (composition.id == ItemID.PLATINUM_TOKEN) {
            1000
        } else 1.coerceAtLeast(composition.haPrice)
    }

    fun getRepairValue(itemId: Int): Int {
        return getRepairValue(itemId, false)
    }

    private fun getRepairValue(itemId: Int, fullValue: Boolean): Int {
        val b: ItemReclaimCost? = ItemReclaimCost.of(itemId)
        return if (b != null) {
            if (fullValue || b.itemID == ItemID.GRANITE_MAUL_24225 || b.itemID == ItemID.GRANITE_MAUL_24227) {
                b.value
            } else (b.value * (75.0f / 100.0f)).toInt()
        } else 0
    }

    /**
     * Look up an item's stats
     *
     * @param itemId item id
     * @return item stats
     */
    fun getItemStats(itemId: Int, allowNote: Boolean): ItemStats? {
        val itemComposition: ItemComposition? = getItemComposition(itemId)
        return if (itemComposition == null || itemComposition.name == null || (!allowNote
                    && itemComposition.note != -1)
        ) {
            null
        } else itemStats[canonicalize(itemId)]
    }

    /**
     * Search for tradeable items based on item name
     *
     * @param itemName item name
     * @return
     */
    fun search(itemName: String): List<ItemPrice> {
        var itemName = itemName
        itemName = itemName.lowercase(Locale.getDefault())
        val result: MutableList<ItemPrice> = ArrayList()
        for (itemPrice in itemPrices.values) {
            val name = itemPrice.name
            if (name.lowercase(Locale.getDefault()).contains(itemName)) {
                result.add(itemPrice)
            }
        }
        return result
    }

    /**
     * Look up an item's composition
     *
     * @param itemId item id
     * @return item composition
     */
    @Nonnull
    fun getItemComposition(itemId: Int): ItemComposition? {
        assert(client.isClientThread) { "getItemComposition must be called on client thread" }
        return itemCompositions.getUnchecked(itemId)
    }

    /**
     * Get an item's un-noted, un-placeholdered ID
     */
    fun canonicalize(itemID: Int): Int {
        val itemComposition = getItemComposition(itemID)
        if (itemComposition!!.note != -1) {
            return itemComposition.linkedNoteId
        }
        return if (itemComposition.placeholderTemplateId != -1) {
            itemComposition.placeholderId
        } else WORN_ITEMS.getOrDefault(itemID, itemID)!!
    }

    /**
     * Loads item sprite from game, makes transparent, and generates image
     *
     * @param itemId
     * @return
     */
    private fun loadImage(itemId: Int, quantity: Int, stackable: Boolean): AsyncBufferedImage {
        val img = AsyncBufferedImage(
            Constants.ITEM_SPRITE_WIDTH,
            Constants.ITEM_SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB
        )
        ClientThread.invoke {
            if (client.gameState.ordinal < GameState.LOGIN_SCREEN.ordinal) {
                return@invoke
            }
            val sprite = client
                .createItemSprite(
                    itemId, quantity, 1, SpritePixels.DEFAULT_SHADOW_COLOR,
                    if (stackable) 1 else 0, false, Constants.CLIENT_DEFAULT_ZOOM
                ) ?: return@invoke
            sprite.toBufferedImage(img)
            img.loaded()
            return@invoke
        }
        return img
    }

    /**
     * Get item sprite image as BufferedImage.
     *
     *
     * This method may return immediately with a blank image if not called on the game thread. The
     * image will be filled in later. If this is used for a UI label/button, it should be added using
     * AsyncBufferedImage::addTo to ensure it is painted properly
     *
     * @param itemId
     * @return
     */
    fun getImage(itemId: Int): AsyncBufferedImage? {
        return getImage(itemId, 1, false)
    }

    /**
     * Get item sprite image as BufferedImage.
     *
     *
     * This method may return immediately with a blank image if not called on the game thread. The
     * image will be filled in later. If this is used for a UI label/button, it should be added using
     * AsyncBufferedImage::addTo to ensure it is painted properly
     *
     * @param itemId
     * @param quantity
     * @return
     */
    fun getImage(itemId: Int, quantity: Int, stackable: Boolean): AsyncBufferedImage? {
        return try {
            itemImages[ImageKey(itemId, quantity, stackable)]
        } catch (ex: ExecutionException) {
            null
        }
    }

    /**
     * Create item sprite and applies an outline.
     *
     * @param itemId       item id
     * @param itemQuantity item quantity
     * @param outlineColor outline color
     * @return image
     */
    private fun loadItemOutline(
        itemId: Int, itemQuantity: Int,
        outlineColor: Color?
    ): BufferedImage {
        val itemSprite = client
            .createItemSprite(itemId, itemQuantity, 1, 0, 0, false, Constants.CLIENT_DEFAULT_ZOOM)
        return itemSprite!!.toBufferedOutline(outlineColor)
    }

    /**
     * Get item outline with a specific color.
     *
     * @param itemId       item id
     * @param itemQuantity item quantity
     * @param outlineColor outline color
     * @return image
     */
    fun getItemOutline(
        itemId: Int, itemQuantity: Int,
        outlineColor: Color
    ): BufferedImage? {
        return try {
            itemOutlines[OutlineKey(itemId, itemQuantity, outlineColor)]
        } catch (e: ExecutionException) {
            null
        }
    }

    class ImageKey(val itemId: Int, val itemQuantity: Int, val stackable: Boolean)

    class OutlineKey(val itemId: Int, val itemQuantity: Int, val outlineColor: Color)

    private val WORN_ITEMS = ImmutableMap
        .builder<Int, Int>().put(ItemID.BOOTS_OF_LIGHTNESS_89, ItemID.BOOTS_OF_LIGHTNESS)
        .put(ItemID.PENANCE_GLOVES_10554, ItemID.PENANCE_GLOVES).put(ItemID.GRACEFUL_HOOD_11851, ItemID.GRACEFUL_HOOD)
        .put(ItemID.GRACEFUL_CAPE_11853, ItemID.GRACEFUL_CAPE).put(ItemID.GRACEFUL_TOP_11855, ItemID.GRACEFUL_TOP)
        .put(ItemID.GRACEFUL_LEGS_11857, ItemID.GRACEFUL_LEGS).put(ItemID.GRACEFUL_GLOVES_11859, ItemID.GRACEFUL_GLOVES)
        .put(ItemID.GRACEFUL_BOOTS_11861, ItemID.GRACEFUL_BOOTS)
        .put(ItemID.GRACEFUL_HOOD_13580, ItemID.GRACEFUL_HOOD_13579)
        .put(ItemID.GRACEFUL_CAPE_13582, ItemID.GRACEFUL_CAPE_13581)
        .put(ItemID.GRACEFUL_TOP_13584, ItemID.GRACEFUL_TOP_13583)
        .put(ItemID.GRACEFUL_LEGS_13586, ItemID.GRACEFUL_LEGS_13585)
        .put(ItemID.GRACEFUL_GLOVES_13588, ItemID.GRACEFUL_GLOVES_13587)
        .put(ItemID.GRACEFUL_BOOTS_13590, ItemID.GRACEFUL_BOOTS_13589)
        .put(ItemID.GRACEFUL_HOOD_13592, ItemID.GRACEFUL_HOOD_13591)
        .put(ItemID.GRACEFUL_CAPE_13594, ItemID.GRACEFUL_CAPE_13593)
        .put(ItemID.GRACEFUL_TOP_13596, ItemID.GRACEFUL_TOP_13595)
        .put(ItemID.GRACEFUL_LEGS_13598, ItemID.GRACEFUL_LEGS_13597)
        .put(ItemID.GRACEFUL_GLOVES_13600, ItemID.GRACEFUL_GLOVES_13599)
        .put(ItemID.GRACEFUL_BOOTS_13602, ItemID.GRACEFUL_BOOTS_13601)
        .put(ItemID.GRACEFUL_HOOD_13604, ItemID.GRACEFUL_HOOD_13603)
        .put(ItemID.GRACEFUL_CAPE_13606, ItemID.GRACEFUL_CAPE_13605)
        .put(ItemID.GRACEFUL_TOP_13608, ItemID.GRACEFUL_TOP_13607)
        .put(ItemID.GRACEFUL_LEGS_13610, ItemID.GRACEFUL_LEGS_13609)
        .put(ItemID.GRACEFUL_GLOVES_13612, ItemID.GRACEFUL_GLOVES_13611)
        .put(ItemID.GRACEFUL_BOOTS_13614, ItemID.GRACEFUL_BOOTS_13613)
        .put(ItemID.GRACEFUL_HOOD_13616, ItemID.GRACEFUL_HOOD_13615)
        .put(ItemID.GRACEFUL_CAPE_13618, ItemID.GRACEFUL_CAPE_13617)
        .put(ItemID.GRACEFUL_TOP_13620, ItemID.GRACEFUL_TOP_13619)
        .put(ItemID.GRACEFUL_LEGS_13622, ItemID.GRACEFUL_LEGS_13621)
        .put(ItemID.GRACEFUL_GLOVES_13624, ItemID.GRACEFUL_GLOVES_13623)
        .put(ItemID.GRACEFUL_BOOTS_13626, ItemID.GRACEFUL_BOOTS_13625)
        .put(ItemID.GRACEFUL_HOOD_13628, ItemID.GRACEFUL_HOOD_13627)
        .put(ItemID.GRACEFUL_CAPE_13630, ItemID.GRACEFUL_CAPE_13629)
        .put(ItemID.GRACEFUL_TOP_13632, ItemID.GRACEFUL_TOP_13631)
        .put(ItemID.GRACEFUL_LEGS_13634, ItemID.GRACEFUL_LEGS_13633)
        .put(ItemID.GRACEFUL_GLOVES_13636, ItemID.GRACEFUL_GLOVES_13635)
        .put(ItemID.GRACEFUL_BOOTS_13638, ItemID.GRACEFUL_BOOTS_13637)
        .put(ItemID.GRACEFUL_HOOD_13668, ItemID.GRACEFUL_HOOD_13667)
        .put(ItemID.GRACEFUL_CAPE_13670, ItemID.GRACEFUL_CAPE_13669)
        .put(ItemID.GRACEFUL_TOP_13672, ItemID.GRACEFUL_TOP_13671)
        .put(ItemID.GRACEFUL_LEGS_13674, ItemID.GRACEFUL_LEGS_13673)
        .put(ItemID.GRACEFUL_GLOVES_13676, ItemID.GRACEFUL_GLOVES_13675)
        .put(ItemID.GRACEFUL_BOOTS_13678, ItemID.GRACEFUL_BOOTS_13677)
        .put(ItemID.GRACEFUL_HOOD_21063, ItemID.GRACEFUL_HOOD_21061)
        .put(ItemID.GRACEFUL_CAPE_21066, ItemID.GRACEFUL_CAPE_21064)
        .put(ItemID.GRACEFUL_TOP_21069, ItemID.GRACEFUL_TOP_21067)
        .put(ItemID.GRACEFUL_LEGS_21072, ItemID.GRACEFUL_LEGS_21070)
        .put(ItemID.GRACEFUL_GLOVES_21075, ItemID.GRACEFUL_GLOVES_21073)
        .put(ItemID.GRACEFUL_BOOTS_21078, ItemID.GRACEFUL_BOOTS_21076)
        .put(ItemID.GRACEFUL_HOOD_24745, ItemID.GRACEFUL_HOOD_24743)
        .put(ItemID.GRACEFUL_CAPE_24748, ItemID.GRACEFUL_CAPE_24746)
        .put(ItemID.GRACEFUL_TOP_24751, ItemID.GRACEFUL_TOP_24749)
        .put(ItemID.GRACEFUL_LEGS_24754, ItemID.GRACEFUL_LEGS_24752)
        .put(ItemID.GRACEFUL_GLOVES_24757, ItemID.GRACEFUL_GLOVES_24755)
        .put(ItemID.GRACEFUL_BOOTS_24760, ItemID.GRACEFUL_BOOTS_24758)
        .put(ItemID.GRACEFUL_HOOD_25071, ItemID.GRACEFUL_HOOD_25069)
        .put(ItemID.GRACEFUL_CAPE_25074, ItemID.GRACEFUL_CAPE_25072)
        .put(ItemID.GRACEFUL_TOP_25077, ItemID.GRACEFUL_TOP_25075)
        .put(ItemID.GRACEFUL_LEGS_25080, ItemID.GRACEFUL_LEGS_25078)
        .put(ItemID.GRACEFUL_GLOVES_25083, ItemID.GRACEFUL_GLOVES_25081)
        .put(ItemID.GRACEFUL_BOOTS_25086, ItemID.GRACEFUL_BOOTS_25084).put(ItemID.MAX_CAPE_13342, ItemID.MAX_CAPE)
        .put(ItemID.SPOTTED_CAPE_10073, ItemID.SPOTTED_CAPE).put(ItemID.SPOTTIER_CAPE_10074, ItemID.SPOTTIER_CAPE)
        .put(ItemID.AGILITY_CAPET_13341, ItemID.AGILITY_CAPET).put(ItemID.AGILITY_CAPE_13340, ItemID.AGILITY_CAPE)
        .build()

    private val lowPriceThreshold = 1000
    private val activePriceThreshold = 5.0

    /**
     * Get the wiki price for an item, with checks to try and avoid excessive price manipulation
     *
     * @param itemPrice
     * @return
     */
    fun getWikiPrice(itemPrice: ItemPrice): Int {
        val wikiPrice = itemPrice.wikiPrice
        val jagPrice = itemPrice.price
        if (wikiPrice <= 0) {
            return jagPrice
        }
        if (wikiPrice <= lowPriceThreshold) {
            return wikiPrice
        }
        return if (wikiPrice < jagPrice * activePriceThreshold) wikiPrice else jagPrice
    }
}