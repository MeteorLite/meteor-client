package meteor.api.items

import Main.client
import meteor.api.commons.Time
import meteor.api.game.Vars
import meteor.api.widgets.Dialog
import meteor.api.widgets.Widgets
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.ItemContainer
import net.runelite.api.Varbits
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.util.ArrayList
import java.util.function.Predicate
import java.util.function.Supplier

class Bank : Items() {
    override fun all(filter: Predicate<Item>): List<Item?> {
        val items: MutableList<Item?> = ArrayList()
        val container: ItemContainer = client.getItemContainer(InventoryID.BANK)
            ?: return items
        Inventory.cacheItems(container)
        val containerItems = container.items
        var i = 0
        val containerItemsLength = containerItems.size
        while (i < containerItemsLength) {
            val item = containerItems[i]
            if (item.id != -1 && item.name != null && item.name != "null") {
                item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_ITEM_CONTAINER)
                item.slot = i
                if (filter.test(item)) {
                    items.add(item)
                }
            }
            i++
        }
        return items
    }

    enum class Component(val groupId: Int, val childId: Int) {
        BANK_REARRANGE_SWAP(WidgetID.BANK_GROUP_ID, 17), BANK_REARRANGE_INSERT(
            WidgetID.BANK_GROUP_ID,
            19
        ),
        BANK_WITHDRAW_ITEM(
            WidgetID.BANK_GROUP_ID, 22
        ),
        BANK_WITHDRAW_NOTE(WidgetID.BANK_GROUP_ID, 24), BANK_QUANTITY_BUTTONS_CONTAINER(
            WidgetID.BANK_GROUP_ID, 26
        ),
        BANK_QUANTITY_ONE(WidgetID.BANK_GROUP_ID, 28), BANK_QUANTITY_FIVE(
            WidgetID.BANK_GROUP_ID,
            30
        ),
        BANK_QUANTITY_TEN(
            WidgetID.BANK_GROUP_ID, 32
        ),
        BANK_QUANTITY_X(WidgetID.BANK_GROUP_ID, 34), BANK_QUANTITY_ALL(
            WidgetID.BANK_GROUP_ID,
            36
        ),
        BANK_PLACEHOLDERS_BUTTON(
            WidgetID.BANK_GROUP_ID, 38
        ),
        EMPTY(-1, -1);
    }

    enum class QuantityMode(val widget: Component, private val bitValue: Int) {
        ONE(Component.BANK_QUANTITY_ONE, 0), FIVE(Component.BANK_QUANTITY_FIVE, 1), TEN(
            Component.BANK_QUANTITY_TEN,
            2
        ),
        X(
            Component.BANK_QUANTITY_X, 3
        ),
        ALL(Component.BANK_QUANTITY_ALL, 4), UNKNOWN(Component.EMPTY, -1);

        companion object {
            val current: QuantityMode
                get() = when (Vars.getBit(QUANTITY_MODE_VARP)) {
                    0 -> ONE
                    1 -> FIVE
                    2 -> TEN
                    3 -> X
                    4 -> ALL
                    else -> UNKNOWN
                }
        }
    }

    enum class WithdrawMode {
        NOTED, ITEM, DEFAULT
    }

    private enum class WithdrawOption(val menuIndex: Int) {
        ONE(2), FIVE(3), TEN(4), LAST_QUANTITY(5), X(6), ALL(7), ALL_BUT_1(8);

        @JvmName("getMenuIndex1")
        fun getMenuIndex(): Int {
            //Special case
            return if (quantityMode == QuantityMode.ONE && this == ONE) {
                1
            } else menuIndex
        }

        companion object {
            fun ofAmount(item: Item, amount: Int): WithdrawOption {
                if (amount <= 1) {
                    return ONE
                }
                if (amount == 5) {
                    return FIVE
                }
                if (amount == 10) {
                    return TEN
                }
                return if (amount > item.quantity) {
                    ALL
                } else X
            }
        }
    }

    companion object {
        private val BANK = Bank()
        private const val WITHDRAW_MODE_VARBIT = 3958
        private const val QUANTITY_MODE_VARP = 6590
        private val MAIN_TAB = Supplier<Widget> { Widgets.get(12, 11, 0) }
        private val BANK_CAPACITY = Supplier<Widget> { Widgets.get(12, 9) }
        private val RELEASE_PLACEHOLDERS = Supplier<Widget> { Widgets.get(12, 56) }
        private val SETTINGS_CONTAINER = Supplier<Widget> { Widgets.get(12, 48) }
        private val WITHDRAW_ITEM = Supplier<Widget> { Widgets.get(12, Component.BANK_WITHDRAW_ITEM.childId) }
        private val WITHDRAW_NOTE = Supplier<Widget> { Widgets.get(12, Component.BANK_WITHDRAW_NOTE.childId) }
        var quantityMode: QuantityMode
            get() = QuantityMode.current
            set(quantityMode) {
                if (Companion.quantityMode != quantityMode) {
                    val component: Widget? = Widgets.get(quantityMode.widget.groupId, quantityMode.widget.childId)
                    if (Widgets.isVisible(component)) {
                        component?.interact(0)
                    }
                }
            }
        val freeSlots: Int
            get() = if (!isOpen) {
                -1
            } else capacity - occupiedSlots
        val capacity: Int
            get() {
                val widget = BANK_CAPACITY.get()
                return if (Widgets.isVisible(widget)) {
                    widget.text.toInt()
                } else -1
            }
        val occupiedSlots: Int
            get() {
                val widget: Widget? = Widgets.get(WidgetInfo.BANK_ITEM_COUNT_TOP)
                return if (Widgets.isVisible(widget)) {
                    widget!!.text.toInt()
                } else -1
            }

        fun releasePlaceholders() {
            if (!isSettingsOpen) {
                toggleSettings()
                Time.sleepUntil({ isSettingsOpen } , 5000)
            }
            val widget = RELEASE_PLACEHOLDERS.get()
            widget.interact(5)
        }

        fun toggleSettings() {
            Widgets[WidgetInfo.BANK_SETTINGS_BUTTON]?.interact(0)
        }

        val isSettingsOpen: Boolean
            get() = Widgets.isVisible(SETTINGS_CONTAINER.get())

        fun depositInventory() {
            Widgets[WidgetInfo.BANK_DEPOSIT_INVENTORY]?.interact("Deposit inventory")
        }

        fun depositEquipment() {
            Widgets[WidgetInfo.BANK_DEPOSIT_EQUIPMENT]?.interact("Deposit worn items")
        }

        val isOpen: Boolean
            get() = Widgets.isVisible(Widgets.get(WidgetInfo.BANK_ITEM_CONTAINER))
        val isEmpty: Boolean
            get() = all.isEmpty()

        fun depositAll(name: String?) {
            depositAll { x: Item -> x.name == name }
        }

        fun depositAll(id: Int) {
            depositAll { x: Item -> x.id == id }
        }

        fun depositAll(filter: Predicate<Item>) {
            deposit(filter, Int.MAX_VALUE)
        }

        fun deposit(name: String?, amount: Int) {
            deposit({ x: Item -> x.name == name }, amount)
        }

        fun deposit(id: Int, amount: Int) {
            deposit({ x: Item -> x.id == id }, amount)
        }

        fun deposit(filter: Predicate<Item>, amount: Int) {
            val item = getInventory(filter).stream()
                .findFirst()
                .orElse(null) ?: return
            val withdrawOption = WithdrawOption.ofAmount(item, amount)
            item.interact(withdrawOption.menuIndex + 1)
            if (withdrawOption == WithdrawOption.X) {
                Dialog.enterInput(amount)
            }
        }

        fun withdrawAll(name: String?, withdrawMode: WithdrawMode) {
            withdrawAll({ x: Item -> x.name == name }, withdrawMode)
        }

        fun withdrawAll(id: Int, withdrawMode: WithdrawMode) {
            withdrawAll({ x: Item -> x.id == id }, withdrawMode)
        }

        fun withdrawAll(filter: Predicate<Item>, withdrawMode: WithdrawMode) {
            withdraw(filter, Int.MAX_VALUE, withdrawMode)
        }

        fun withdraw(name: String?, amount: Int, withdrawMode: WithdrawMode) {
            withdraw({ x: Item -> x.name == name }, amount, withdrawMode)
        }

        fun withdraw(id: Int, amount: Int, withdrawMode: WithdrawMode) {
            withdraw({ x: Item -> x.id == id }, amount, withdrawMode)
        }

        fun withdraw(filter: Predicate<Item>, amount: Int, withdrawMode: WithdrawMode) {
            val item = getFirst(filter.and { x: Item -> !x.isPlaceholder })
                ?: return
            val withdrawOption = WithdrawOption.ofAmount(item, amount)
            if (withdrawMode == WithdrawMode.NOTED && !isNotedWithdrawMode) {
                setWithdrawMode(true)
                Time.sleepUntil({ isNotedWithdrawMode }, 1200)
            }
            if (withdrawMode == WithdrawMode.ITEM && isNotedWithdrawMode) {
                setWithdrawMode(false)
                Time.sleepUntil({ !isNotedWithdrawMode }, 1200)
            }
            item.interact(withdrawOption.getMenuIndex())
            if (withdrawOption == WithdrawOption.X) {
                Time.sleepUntil(Dialog::isEnterInputOpen, 1200)
                Dialog.enterInput(amount)
            }
        }

        fun withdrawLastQuantity(name: String?, withdrawMode: WithdrawMode) {
            withdrawLastQuantity({ x: Item -> name == x.name }, withdrawMode)
        }

        fun withdrawLastQuantity(id: Int, withdrawMode: WithdrawMode) {
            withdrawLastQuantity({ x: Item -> x.id == id }, withdrawMode)
        }

        fun withdrawLastQuantity(filter: Predicate<Item>, withdrawMode: WithdrawMode) {
            val item = getFirst(filter.and { x: Item -> !x.isPlaceholder })
                ?: return
            val withdrawOption = WithdrawOption.LAST_QUANTITY
            if (withdrawMode == WithdrawMode.NOTED && !isNotedWithdrawMode) {
                setWithdrawMode(true)
            }
            if (withdrawMode == WithdrawMode.ITEM && isNotedWithdrawMode) {
                setWithdrawMode(false)
            }
            item.interact(withdrawOption.getMenuIndex())
        }

        fun setWithdrawMode(noted: Boolean) {
            val widget = if (noted) WITHDRAW_NOTE.get() else WITHDRAW_ITEM.get()
            if (widget != null) {
                widget.interact(0)
            }
        }

        val isNotedWithdrawMode: Boolean
            get() = Vars.getBit(WITHDRAW_MODE_VARBIT) === 1

        fun getInventory(filter: Predicate<Item>): List<Item?> {
            val items: MutableList<Item?> = ArrayList()
            val container: ItemContainer = client.getItemContainer(InventoryID.INVENTORY)
                ?: return items
            Inventory.cacheItems(container)
            val containerItems = container.items
            var i = 0
            val containerItemsLength = containerItems.size
            while (i < containerItemsLength) {
                val item = containerItems[i]
                if (item.id != -1 && item.name != null && item.name != "null") {
                    item.widgetId = item.calculateWidgetId(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
                    item.slot = i
                    if (filter.test(item)) {
                        items.add(item)
                    }
                }
                i++
            }
            return items
        }

        fun getAll(filter: Predicate<Item>): List<Item?> {
            return BANK.all(filter)
        }

        val all: List<Item?>
            get() = getAll { x: Item? -> true }

        fun getAll(vararg ids: Int): List<Item?> {
            return BANK.all(*ids)
        }

        fun getAll(vararg names: String): List<Item?> {
            return BANK.all(*names)
        }

        fun getFirst(filter: Predicate<Item>?): Item {
            return BANK.first(filter!!)!!
        }

        fun getFirst(vararg ids: Int): Item? {
            return BANK.first(*ids)
        }

        fun getFirst(vararg names: String): Item? {
            return BANK.first(*names)
        }

        operator fun contains(filter: Predicate<Item>): Boolean {
            return BANK.exists(filter)
        }

        operator fun contains(id: Int): Boolean {
            return BANK.exists(id)
        }

        operator fun contains(name: String?): Boolean {
            return BANK.exists(name)
        }

        val tabs: List<Widget>
            get() = Widgets.getChildren(WidgetInfo.BANK_TAB_CONTAINER) { x -> x.hasAction("Collapse tab") }

        fun hasTabs(): Boolean {
            return !tabs.isEmpty()
        }

        fun collapseTabs() {
            for (i in tabs.indices) {
                val tab = tabs[i]
                client.interact(6, 1007, 11 + i, tab.id)
            }
        }

        fun collapseTab(index: Int) {
            val tabContainer: Widget? = Widgets[WidgetInfo.BANK_TAB_CONTAINER]
            if (!Widgets.isVisible(tabContainer)) {
                return
            }
            val tabIdx = 11 + index
            val tab = tabContainer!!.getChild(tabIdx)
            if (!Widgets.isVisible(tab)) {
                return
            }
            client.interact(6, 1007, tabIdx, tab.id)
        }

        val isMainTabOpen: Boolean
            get() = Vars.getBit(Varbits.CURRENT_BANK_TAB.id) === 0

        fun openMainTab() {
            val mainTab = MAIN_TAB.get()
            if (Widgets.isVisible(mainTab)) {
                mainTab.interact(0)
            }
        }
    }
}