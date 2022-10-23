/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
 * Copyright (c) 2019, Hydrox6 <ikada@protonmail.ch>
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
package meteor.plugins.bank

import com.google.common.annotations.VisibleForTesting
import com.google.common.collect.HashMultiset
import com.google.common.collect.Multiset
import eventbus.events.*
import meteor.Logger
import meteor.config.legacy.Keybind
import meteor.game.ItemManager
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.QuantityFormatter
import net.runelite.api.*
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.event.KeyEvent
import java.text.ParseException
import java.util.regex.Pattern

@PluginDescriptor(
    name = "Bank",
    description = "Modifications to the banking interface",
    tags = ["grand", "exchange", "high", "alchemy", "prices", "deposit", "pin"]
)
class BankPlugin : Plugin() {

    private val clientThread = ClientThread
    private val itemManager = ItemManager
    var config = configuration<BankConfig>()
    private val bankSearch = BankSearch
    private val searchHotkeyListener: KeyListener = object : KeyListener {
        override fun keyTyped(e: KeyEvent) {}
        override fun keyPressed(e: KeyEvent) {
            val keybind: Keybind = config.searchKeybind()
            if (keybind.matches(e)) {
                val bankContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER)
                if (bankContainer == null || bankContainer.isSelfHidden) {
                    return
                }
                bankSearch.initSearch()
                e.consume()
            }
        }

        override fun keyReleased(e: KeyEvent) {}
    }

    private val keyManager: KeyManager? = null
    private val log: Logger = Logger("Bank")
    private var forceRightClickFlag = false
    private var itemQuantities // bank item quantities for bank value search
            : Multiset<Int>? = null
    private var searchString: String? = null


    fun startup() {
        keyManager!!.registerKeyListener(searchHotkeyListener, this.javaClass)
    }

    fun shutdown() {
        keyManager!!.unregisterKeyListener(searchHotkeyListener)
        clientThread.invokeLater { bankSearch.reset(false) }
        forceRightClickFlag = false
        itemQuantities = null
        searchString = null
    }

    override fun onMenuShouldLeftClick(it: MenuShouldLeftClick) {
        if (!forceRightClickFlag) {

            forceRightClickFlag = false
            val menuEntries = client.menuEntries
            for (entry in menuEntries) {
                if (entry.option == DEPOSIT_WORN && config.rightClickBankEquip()
                    || entry.option == DEPOSIT_INVENTORY && config.rightClickBankInventory()
                    || entry.option == DEPOSIT_LOOT && config.rightClickBankLoot()
                ) {
                    it.isForceRightClick = true

                }
            }
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (it.option == DEPOSIT_WORN && config.rightClickBankEquip()
            || it.option == DEPOSIT_INVENTORY && config.rightClickBankInventory()
            || it.option == DEPOSIT_LOOT && config.rightClickBankLoot()
        ) {
            forceRightClickFlag = true
        }
    }

    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        val intStack = client.intStack
        val stringStack = client.stringStack
        val intStackSize = client.intStackSize
        val stringStackSize = client.stringStackSize
        when (it.eventName) {
            "bankSearchFilter" -> {
                val itemId = intStack[intStackSize - 1]
                val search = stringStack[stringStackSize - 1]
                if (valueSearch(itemId, search)) {
                    // return true
                    intStack[intStackSize - 2] = 1
                }
            }
        }
    }


    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId != WidgetID.SEED_VAULT_GROUP_ID || !config.seedVaultValue()) {
            updateSeedVaultTotal()
        }
    }

    override fun onScriptPostFired(it: ScriptPostFired) {
        if (it.scriptId == ScriptID.BANKMAIN_BUILD) {
            // Compute bank prices using only the shown items so that we can show bank value during searches
            val bankItemContainer = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER)
            val bankContainer = client.getItemContainer(InventoryID.BANK)
            val children = bankItemContainer!!.children
            var geTotal: Long = 0
            var haTotal: Long = 0
            if (bankContainer != null && children != null) {

                // The first components are the bank items, followed by tabs etc. There are always 816 components regardless
                // of bank size, but we only need to check up to the bank size.
                for (i in 0 until bankContainer.size()) {
                    val child = children[i]
                    if (child != null && !child.isSelfHidden && child.itemId > -1) {
                        val alchPrice = getHaPrice(child.itemId)
                        geTotal += itemManager.getItemPrice(child.itemId).toLong() * child.itemQuantity
                        haTotal += alchPrice.toLong() * child.itemQuantity
                    }
                }
                val bankTitle = client.getWidget(WidgetInfo.BANK_TITLE_BAR)
                bankTitle!!.text = bankTitle.text + createValueText(geTotal, haTotal)
            }
        } else if (it.scriptId == ScriptID.BANKMAIN_SEARCH_REFRESH) {
            // vanilla only lays out the bank every 40 client ticks, so if the search input has changed,
            // and the bank wasn't laid out this tick, lay it out early
            val inputText = client.getVar(VarClientStr.INPUT_TEXT)
            if (searchString !== inputText && client.gameCycle % 40 != 0) {
                clientThread.invokeLater { bankSearch.layoutBank() }
                searchString = inputText
            }
        }
    }


    override fun onItemContainerChanged(it: ItemContainerChanged) {
        val containerId = it.containerId
        if (containerId == InventoryID.BANK.id) {
            itemQuantities = null
        } else if (containerId == InventoryID.SEED_VAULT.id && config.seedVaultValue()) {
            updateSeedVaultTotal()
        }
    }


    private fun createValueText(gePrice: Long, haPrice: Long): String {
        val stringBuilder = StringBuilder()
        if (config.showGE() && gePrice != 0L) {
            stringBuilder.append(" (")
            if (config.showHA()) {
                stringBuilder.append("GE: ")
            }
            if (config.showExact()) {
                stringBuilder.append(QuantityFormatter.formatNumber(gePrice))
            } else {
                stringBuilder.append(QuantityFormatter.quantityToStackSize(gePrice))
            }
            stringBuilder.append(')')
        }
        if (config.showHA() && haPrice != 0L) {
            stringBuilder.append(" (")
            if (config.showGE()) {
                stringBuilder.append("HA: ")
            }
            if (config.showExact()) {
                stringBuilder.append(QuantityFormatter.formatNumber(haPrice))
            } else {
                stringBuilder.append(QuantityFormatter.quantityToStackSize(haPrice))
            }
            stringBuilder.append(')')
        }
        return stringBuilder.toString()
    }

    private fun updateSeedVaultTotal() {
        val titleContainer = client.getWidget(WidgetInfo.SEED_VAULT_TITLE_CONTAINER) ?: return
        val title = titleContainer.getChild(1) ?: return
        var prices = calculate(seedVaultItems) ?: return
        val titleText = createValueText(prices.gePrice, prices.highAlchPrice)
        title.text = SEED_VAULT_TITLE + titleText
    }

    private val seedVaultItems: Array<Item>?
        get() {
            val itemContainer = client.getItemContainer(InventoryID.SEED_VAULT) ?: return null
            return itemContainer.items
        }

    @VisibleForTesting
    fun valueSearch(itemId: Int, str: String?): Boolean {
        val matcher = VALUE_SEARCH_PATTERN.matcher(str)
        if (!matcher.matches()) {
            return false
        }

        // Count bank items and remember it for determining item quantity
        if (itemQuantities == null) {
            itemQuantities = bankItemSet
        }
        val itemComposition = itemManager.getItemComposition(itemId)
        val qty = itemQuantities!!.count(itemId)
        val gePrice = itemManager.getItemPrice(itemId).toLong() * qty
        val haPrice = itemComposition!!.haPrice.toLong() * qty
        var value = Math.max(gePrice, haPrice)
        val mode = matcher.group("mode")
        if (mode != null) {
            value = if (mode.equals("ge", ignoreCase = true)) gePrice else haPrice
        }
        val op = matcher.group("op")
        if (op != null) {
            val compare: Long
            compare = try {
                QuantityFormatter.parseQuantity(matcher.group("num"))
            } catch (e: ParseException) {
                return false
            }
            when (op) {
                ">" -> return value > compare
                "<" -> return value < compare
                "=" -> return value == compare
                ">=" -> return value >= compare
                "<=" -> return value <= compare
            }
        }
        val num1 = matcher.group("num1")
        val num2 = matcher.group("num2")
        if (num1 != null && num2 != null) {
            val compare1: Long
            val compare2: Long
            try {
                compare1 = QuantityFormatter.parseQuantity(num1)
                compare2 = QuantityFormatter.parseQuantity(num2)
            } catch (e: ParseException) {
                return false
            }
            return compare1 <= value && compare2 >= value
        }
        return false
    }

    private val bankItemSet: Multiset<Int>
        private get() {
            val itemContainer = client.getItemContainer(InventoryID.BANK)
                ?: return HashMultiset.create()
            val set: Multiset<Int> = HashMultiset.create()
            for (item in itemContainer.items) {
                if (item.id != ItemID.BANK_FILLER) {
                    set.add(item.id, item.quantity)
                }
            }
            return set
        }

    fun calculate(items: Array<Item>?): ContainerPrices? {
        if (items == null) {
            return null
        }
        var ge: Long = 0
        var alch: Long = 0
        for (item in items) {
            val qty = item.quantity
            val id = item.id
            if (id <= 0 || qty == 0) {
                continue
            }
            alch += getHaPrice(id).toLong() * qty
            ge += itemManager.getItemPrice(id).toLong() * qty
        }
        return ContainerPrices(ge, alch)
    }

    private fun getHaPrice(itemId: Int): Int {
        return when (itemId) {
            ItemID.COINS_995 -> 1
            ItemID.PLATINUM_TOKEN -> 1000
            else -> itemManager.getItemComposition(itemId)!!.haPrice
        }
    }

    companion object {
        private const val DEPOSIT_WORN = "Deposit worn items"
        private const val DEPOSIT_INVENTORY = "Deposit inventory"
        private const val DEPOSIT_LOOT = "Deposit loot"
        private const val SEED_VAULT_TITLE = "Seed Vault"
        private const val NUMBER_REGEX = "[0-9]+(\\.[0-9]+)?[kmb]?"
        private val VALUE_SEARCH_PATTERN = Pattern.compile(
            "^(?<mode>ge|ha|alch)?" +
                    " *(((?<op>[<>=]|>=|<=) *(?<num>" + NUMBER_REGEX + "))|" +
                    "((?<num1>" + NUMBER_REGEX + ") *- *(?<num2>" + NUMBER_REGEX + ")))$",
            Pattern.CASE_INSENSITIVE
        )
    }
}