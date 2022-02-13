package meteor.api.items

import Main.client
import meteor.api.game.GameThread
import meteor.api.game.Vars
import meteor.api.widgets.Dialog
import meteor.api.widgets.Widgets
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.ItemContainer
import net.runelite.api.VarClientStr
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.util.ArrayList
import java.util.function.Predicate
import java.util.function.Supplier

object Trade {
    private val OUR_ITEMS = Supplier<Widget?> { Widgets[WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID, 25] }
    private val THEIR_ITEMS = Supplier<Widget?> { Widgets[WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID, 28] }
    private val INVENTORY = Supplier<Widget?> { Widgets[WidgetID.PLAYER_TRADE_INVENTORY_GROUP_ID, 0] }
    private val ACCEPT_1 = Supplier<Widget?> { Widgets[WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID, 10] }
    private val ACCEPT_2 = Supplier<Widget?> { Widgets[WidgetInfo.SECOND_TRADING_WITH_ACCEPT_BUTTON] }
    private val DECLINE_1 = Supplier<Widget?> { Widgets[WidgetID.PLAYER_TRADE_SCREEN_GROUP_ID, 13] }
    private val DECLINE_2 = Supplier<Widget?> {
        Widgets.get(
            WidgetID.PLAYER_TRADE_CONFIRM_GROUP_ID,
            WidgetID.TradeScreen.SECOND_DECLINE_FUNC
        )
    }
    val isOpen: Boolean
        get() = isFirstScreenOpen || isSecondScreenOpen
    val isSecondScreenOpen: Boolean
        get() {
            val accept = ACCEPT_2.get()
            return accept != null && accept.isHidden
        }
    val isFirstScreenOpen: Boolean
        get() {
            val accept = ACCEPT_1.get()
            return accept != null && accept.isHidden
        }

    fun accept() {
        acceptFirstScreen()
        acceptSecondScreen()
    }

    fun acceptFirstScreen() {
        val button = ACCEPT_1.get()
        if (button != null && button.isHidden) {
            button.interact("Accept")
        }
    }

    fun acceptSecondScreen() {
        val button = ACCEPT_2.get()
        if (button != null && button.isHidden) {
            button.interact("Accept")
        }
    }

    fun decline() {
        declineFirstScreen()
        declineSecondScreen()
    }

    fun declineFirstScreen() {
        val button = DECLINE_1.get()
        if (button != null && button.isHidden) {
            button.interact("Decline")
        }
    }

    fun declineSecondScreen() {
        val button = DECLINE_2.get()
        if (button != null && button.isHidden) {
            button.interact("Decline")
        }
    }

    fun offer(filter: Predicate<Item>, quantity: Int) {
        val item = getInventory(filter).stream().findFirst().orElse(null) ?: return
        when (quantity) {
            1 -> item.interact("Offer")
            5 -> item.interact("Offer-5")
            10 -> item.interact("Offer-10")
            else -> if (quantity > item.quantity) {
                item.interact("Offer-All")
            } else {
                item.interact("Offer-X")
                Dialog.enterInput(quantity)
            }
        }
    }

    fun offer(id: Int, quantity: Int) {
        offer({ x: Item -> x.id == id }, quantity)
    }

    fun offer(name: String, quantity: Int) {
        offer({ x: Item -> x.name != null && x.name == name }, quantity)
    }

    /**
     * Pass true as first parameter if you want to get the other side's items
     */
    fun getAll(theirs: Boolean, filter: Predicate<Item>): List<Item?> {
        val items: MutableList<Item?> = ArrayList()
        val container: ItemContainer = client
            .getItemContainer(if (theirs) InventoryID.TRADEOTHER else InventoryID.TRADE)
            ?: return items
        Inventory.cacheItems(container)
        val containerItems = container.items
        var i = 0
        val containerItemsLength = containerItems.size
        while (i < containerItemsLength) {
            val item = containerItems[i]
            if (item.id != -1 && item.name != null && item.name != "null") {
                val containerWidget = if (theirs) THEIR_ITEMS.get() else OUR_ITEMS.get()
                item.widgetId = item.calculateWidgetId(containerWidget)
                item.slot = i
                if (filter.test(item)) {
                    items.add(item)
                }
            }
            i++
        }
        return items
    }

    fun getInventory(filter: Predicate<Item>): List<Item?> {
        val items: ArrayList<Item> = ArrayList()
        val container: ItemContainer = client.getItemContainer(InventoryID.INVENTORY)
            ?: return items
        Inventory.cacheItems(container)
        val containerItems = container.items
        var i = 0
        val containerItemsLength = containerItems.size
        while (i < containerItemsLength) {
            val item = containerItems[i]
            if (item.id != -1 && item.name != null && item.name != "null") {
                item.widgetId = item.calculateWidgetId(INVENTORY.get())
                item.slot = i
                if (filter.test(item)) {
                    items.add(item)
                }
            }
            i++
        }
        return items
    }

    fun getAll(theirs: Boolean): List<Item?> {
        return getAll(theirs) { x: Item? -> true }
    }

    fun getAll(theirs: Boolean, vararg ids: Int): List<Item?> {
        return getAll(theirs) { x: Item ->
            for (id in ids) {
                if (id == x.id) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getAll(theirs: Boolean, vararg names: String): List<Item?> {
        return getAll(theirs) { x: Item ->
            if (x.name == null) {
                return@getAll false
            }
            for (name in names) {
                if (name == x.name) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getFirst(theirs: Boolean, filter: Predicate<Item>): Item? {
        return getAll(theirs, filter).stream().findFirst().orElse(null)
    }

    fun getFirst(theirs: Boolean, vararg ids: Int): Item? {
        return getFirst(theirs) { x: Item ->
            for (id in ids) {
                if (id == x.id) {
                    return@getFirst true
                }
            }
            false
        }
    }

    fun getFirst(theirs: Boolean, vararg names: String): Item? {
        return getFirst(theirs) { x: Item ->
            if (x.name == null) {
                return@getFirst false
            }
            for (name in names) {
                if (name == x.name) {
                    return@getFirst true
                }
            }
            false
        }
    }

    fun contains(theirs: Boolean, filter: Predicate<Item>): Boolean {
        return getFirst(theirs, filter) != null
    }

    fun contains(theirs: Boolean, vararg ids: Int): Boolean {
        return contains(theirs) { x: Item ->
            for (id in ids) {
                if (id == x.id) {
                    return@contains true
                }
            }
            false
        }
    }

    fun contains(theirs: Boolean, vararg names: String): Boolean {
        return contains(theirs) { x: Item ->
            if (x.name == null) {
                return@contains false
            }
            for (name in names) {
                if (name == x.name) {
                    return@contains true
                }
            }
            false
        }
    }

    val tradingPlayer: String
        get() = Vars.getVarcStr(VarClientStr.DUEL_OPPONENT_NAME)
}