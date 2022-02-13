package meteor.api.items

import Main.client
import meteor.api.commons.Time
import meteor.api.game.GameThread
import meteor.api.game.Vars
import meteor.api.widgets.Dialog
import meteor.api.widgets.Widgets
import net.runelite.api.*
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.util.ArrayList
import java.util.function.Predicate
import java.util.function.Supplier

object GrandExchange {
    private const val F2P_SLOTS = 3
    private const val P2P_SLOTS = 8
    private const val PRICE_VARBIT = 4398
    private const val QUANTITY_VARBIT = 4396
    private val COLLECT_BUTTON = Supplier<Widget> { Widgets[WidgetID.GRAND_EXCHANGE_GROUP_ID, 6, 0] }
    private val CONFIRM_BUTTON = Supplier<Widget> { Widgets[WidgetID.GRAND_EXCHANGE_GROUP_ID, 27] }

    // Widgets broke
    val view: View
        get() {
            val setupWindow: Widget? = Widgets[WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER]
            if (setupWindow != null && GameThread.invokeLater { setupWindow.isHidden }!!) {
                val text = setupWindow.getChild(18).text
                if (text == null || text.isEmpty()) {
                    return View.UNKNOWN
                }
                if (text == "Sell offer") {
                    return View.SELLING
                }
                return if (text == "Buy offer") {
                    View.BUYING
                } else View.UNKNOWN

                // Widgets broke
            }
            val geWindow: Widget? = Widgets[WidgetInfo.GRAND_EXCHANGE_WINDOW_CONTAINER]
            return if (geWindow != null && !GameThread.invokeLater { geWindow.isHidden }) {
                View.OFFERS
            } else View.CLOSED
        }
    val isOpen: Boolean
        get() = view != View.CLOSED && view != View.UNKNOWN
    val isSetupOpen: Boolean
        get() = view == View.BUYING || view == View.SELLING

    fun openBank() {
        val bank: TileObject? = TileObjects.getNearest { x ->
            x!!.getName() != null && x.getName().toLowerCase().contains("exchange booth") && x.hasAction("Bank")
        }
        if (bank != null) {
            bank.interact("Bank")
        }
    }

    val isSelling: Boolean
        get() = view == View.SELLING
    val isBuying: Boolean
        get() = view == View.BUYING
    val itemId: Int
        get() = Vars.getVarp(VarPlayer.CURRENT_GE_ITEM.id)

    fun setItem(id: Int) {
        GameThread.invoke { client.runScript(754, id, 84) }
    }

    var price: Int?
        get() = Vars.getBit(PRICE_VARBIT)
        set(price) {
            val enterPriceButton: Widget? = Widgets[WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER]
            if (enterPriceButton?.getChild(12) != null) {
                enterPriceButton.getChild(12).interact("Enter price")
                if (price != null) {
                    Dialog.enterInput(price)
                }
            }
        }
    var quantity: Int?
        get() = Vars.getBit(QUANTITY_VARBIT)
        set(quantity) {
            val enterPriceButton: Widget? = Widgets[WidgetInfo.GRAND_EXCHANGE_OFFER_CONTAINER]
            if (enterPriceButton?.getChild(7) != null) {
                enterPriceButton.getChild(7).interact("Enter quantity")
                if (quantity != null) {
                    Dialog.enterInput(quantity)
                }
            }
        }
    val guidePrice: Int
        get() {
            val priceWidget: Widget? = Widgets[WidgetInfo.GRAND_EXCHANGE_OFFER_PRICE]
            return priceWidget?.text?.replace("[^0-9]".toRegex(), "")?.toInt() ?: -1
        }

    fun open() {
        TileObjects.getNearest { x -> x!!.hasAction("Exchange") }?.interact("Exchange")
    }

    fun sell(filter: Predicate<Item>) {
        val item: Item? = Inventory.getFirst(filter)
        client.interact(1, 57, item!!.slot, 30605312)
    }

    fun sell(vararg ids: Int) {
        sell { x: Item? ->
            for (id in ids) {
                if (id == x!!.id) {
                    return@sell true
                }
            }
            false
        }
    }

    fun sell(vararg names: String) {
        sell { x: Item? ->
            if (x!!.name == null) {
                return@sell false
            }
            for (name in names) {
                if (name == x.name) {
                    return@sell true
                }
            }
            false
        }
    }

    fun createBuyOffer() {
        val geRoot: List<Widget?> = Widgets[465]
        if (isFull) {
            return
        }
        if (geRoot == null) {
            return
        }
        for (i in 7..14) {
            val box = geRoot[i] ?: continue
            val buyButton = box.getChild(3)
            if (buyButton == null || GameThread.invokeLater { buyButton.isHidden }) {
                continue
            }
            buyButton.interact(0)
        }
    }

    fun abortOffer(itemId: Int) {
        val geRoot: List<Widget?> = Widgets[465]
        if (isEmpty) {
            return
        }
        if (geRoot == null) {
            return
        }
        for (i in 7..14) {
            val box = geRoot[i] ?: continue
            val abortBox = box.getChild(2)
            if (abortBox == null || !abortBox.hasAction("Abort offer") || GameThread.invokeLater { abortBox.isHidden }) {
                continue
            }
            val itemIdBox = box.getChild(18)
            if (itemIdBox == null || GameThread.invokeLater { itemIdBox.isHidden }) {
                continue
            }
            if (itemIdBox.itemId == itemId) {
                abortBox.interact("Abort offer")
                return
            }
        }
    }

    val isFull: Boolean
        get() = emptySlots == 0
    val isEmpty: Boolean
        get() = offers.size == 0
    val emptySlots: Int
        get() = if (Vars.getVarp(1780) <= 0) F2P_SLOTS - offers.size else P2P_SLOTS - offers.size
    val offers: List<GrandExchangeOffer>
        get() {
            val out: MutableList<GrandExchangeOffer> = ArrayList()
            val offers: Array<GrandExchangeOffer> = client.getGrandExchangeOffers()
            for (offer in offers) {
                if (offer.itemId > 0) {
                    out.add(offer)
                }
            }
            return out
        }

    fun canCollect(): Boolean {
        val collect = COLLECT_BUTTON.get()
        return !GameThread.invokeLater { collect.isHidden }
    }

    @JvmOverloads
    fun collect(toBank: Boolean = false) {
        val collect = COLLECT_BUTTON.get()
        if (!GameThread.invokeLater { collect.isHidden }!!) {
            collect.interact(if (toBank) "Collect to bank" else "Collect to inventory")
        }
    }

    fun confirm() {
        val confirm = CONFIRM_BUTTON.get()
        if (!GameThread.invokeLater { confirm.isHidden }!!) {
            confirm.interact("Confirm")
        }
    }

    val isSearchingItem: Boolean
        get() = Vars.getVarcInt(VarClientInt.INPUT_TYPE) === 14

    fun openItemSearch() {
        client.interact(1, 57, 0, 30474264)
    }

    fun sell(itemId: Int, quantity: Int, price: Int): Boolean {
        return exchange(false, itemId, quantity, price, true, false)
    }

    fun sell(itemId: Int, quantity: Int, price: Int, collect: Boolean, toBank: Boolean): Boolean {
        return exchange(false, itemId, quantity, price, collect, toBank)
    }

    fun buy(itemId: Int, quantity: Int, price: Int): Boolean {
        return exchange(true, itemId, quantity, price, true, false)
    }

    fun buy(itemId: Int, quantity: Int, price: Int, collect: Boolean, toBank: Boolean): Boolean {
        return exchange(true, itemId, quantity, price, collect, toBank)
    }

    @JvmOverloads
    fun exchange(
        buy: Boolean,
        itemId: Int,
        quantity: Int,
        price: Int,
        collect: Boolean = true,
        toBank: Boolean = false
    ): Boolean {
        if (!isOpen) {
            open()
            return false
        }
        if (collect && canCollect()) {
            collect(toBank)
            return false
        }
        if (buy) {
            if (!isBuying) {
                createBuyOffer()
                return false
            }
        } else {
            if (!isSelling) {
                sell(itemId)
                return false
            }
        }
        if (GrandExchange.itemId != itemId) {
            if (buy) {
                if (!isSearchingItem) {
                    openItemSearch()
                }
                setItem(itemId)
            } else {
                sell(itemId)
            }
            return false
        }
        if (GrandExchange.itemId == itemId) {
            if (GrandExchange.price != price) {
                GrandExchange.price = price
            }
            if (GrandExchange.quantity != quantity) {
                GrandExchange.quantity = quantity
            }
            Time.sleepUntil({ GrandExchange.price == price && GrandExchange.quantity == quantity }, 3000)
            if (GrandExchange.price == price && GrandExchange.quantity == quantity) {
                confirm()
                return true
            }
        }
        return false
    }

    enum class View {
        CLOSED, OFFERS, BUYING, SELLING, UNKNOWN
    }
}