/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * Copyright (c) 2018, Hydrox6 <ikada@protonmail.ch>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
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
package meteor.plugins.itemcharges

import com.google.common.primitives.Ints
import eventbus.events.*
import lombok.extern.slf4j.Slf4j
import meteor.config.ConfigManager
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.*
import net.runelite.api.util.Text
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.image.BufferedImage
import java.util.*
import java.util.regex.Pattern

@PluginDescriptor(
    name = "Item Charges",
    description = "Show number of item charges remaining",
    tags = ["inventory", "notifications", "overlay"]
)
@Slf4j
class ItemChargePlugin : Plugin() {
    private val clientThread = ClientThread
    private val configManager = ConfigManager
    private val itemManager = ItemManager
    private val infoBoxManager = InfoBoxManager
    private val config = javaConfiguration(ItemChargeConfig::class.java) as ItemChargeConfig
    private val overlay = ItemChargeOverlay(this, config)

    // Limits destroy callback to once per tick
    private var lastCheckTick = 0
    private val infoboxes: MutableMap<EquipmentInventorySlot, ItemChargeInfobox> = EnumMap(
        EquipmentInventorySlot::class.java
    )

    override fun onStart() {
        overlayManager.add(overlay)
    }

    override fun onStop() {
        overlayManager.remove(overlay)
        infoBoxManager.removeIf { obj: InfoBox? -> ItemChargeInfobox::class.java.isInstance(obj) }
        infoboxes.clear()
        lastCheckTick = -1
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        // No VarbitChanged event fires on login if the explorer's ring is full (varbit value 0).
        // So, set the value to 0 when LOGGING_IN. This is before the VarbitChanged event would fire, so if it shouldn't
        // be 0 it will be updated later.
        if (it.gameState == GameState.LOGGING_IN) {
            updateExplorerRingCharges(0)
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != ItemChargeConfig.GROUP) {
            return
        }
        clientThread.invoke { updateInfoboxes() }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.type == ChatMessageType.GAMEMESSAGE || it.type == ChatMessageType.SPAM) {
            val message = Text.removeTags(it.message)
            val dodgyCheckMatcher = DODGY_CHECK_PATTERN.matcher(message)
            val dodgyProtectMatcher = DODGY_PROTECT_PATTERN.matcher(message)
            val dodgyBreakMatcher = DODGY_BREAK_PATTERN.matcher(message)
            val bindingNecklaceCheckMatcher = BINDING_CHECK_PATTERN.matcher(message)
            val bindingNecklaceUsedMatcher = BINDING_USED_PATTERN.matcher(message)
            val ringOfForgingCheckMatcher = RING_OF_FORGING_CHECK_PATTERN.matcher(message)
            val amuletOfChemistryCheckMatcher = AMULET_OF_CHEMISTRY_CHECK_PATTERN.matcher(message)
            val amuletOfChemistryUsedMatcher = AMULET_OF_CHEMISTRY_USED_PATTERN.matcher(message)
            val amuletOfChemistryBreakMatcher = AMULET_OF_CHEMISTRY_BREAK_PATTERN.matcher(message)
            val amuletOfBountyCheckMatcher = AMULET_OF_BOUNTY_CHECK_PATTERN.matcher(message)
            val amuletOfBountyUsedMatcher = AMULET_OF_BOUNTY_USED_PATTERN.matcher(message)
            val chronicleAddMatcher = CHRONICLE_ADD_PATTERN.matcher(message)
            val chronicleUseAndCheckMatcher = CHRONICLE_USE_AND_CHECK_PATTERN.matcher(message)
            val slaughterActivateMatcher = BRACELET_OF_SLAUGHTER_ACTIVATE_PATTERN.matcher(message)
            val slaughterCheckMatcher = BRACELET_OF_SLAUGHTER_CHECK_PATTERN.matcher(message)
            val expeditiousActivateMatcher = EXPEDITIOUS_BRACELET_ACTIVATE_PATTERN.matcher(message)
            val expeditiousCheckMatcher = EXPEDITIOUS_BRACELET_CHECK_PATTERN.matcher(message)
            val bloodEssenceCheckMatcher = BLOOD_ESSENCE_CHECK_PATTERN.matcher(message)
            val bloodEssenceExtractMatcher = BLOOD_ESSENCE_EXTRACT_PATTERN.matcher(message)
            val braceletOfClayCheckMatcher = BRACELET_OF_CLAY_CHECK_PATTERN.matcher(message)
            when {
                dodgyBreakMatcher.find() -> updateDodgyNecklaceCharges(MAX_DODGY_CHARGES)
                dodgyCheckMatcher.find() -> updateDodgyNecklaceCharges(dodgyCheckMatcher.group(1).toInt())
                dodgyProtectMatcher.find() -> updateDodgyNecklaceCharges(dodgyProtectMatcher.group(1).toInt())
                amuletOfChemistryCheckMatcher.find() ->
                    updateAmuletOfChemistryCharges(amuletOfChemistryCheckMatcher.group(1).toInt())
                amuletOfChemistryUsedMatcher.find() -> {
                    val match = amuletOfChemistryUsedMatcher.group(1)
                    var charges = 1
                    if (match != "one") {
                        charges = match.toInt()
                    }
                    updateAmuletOfChemistryCharges(charges)
                }
                amuletOfChemistryBreakMatcher.find() -> {
                    updateAmuletOfChemistryCharges(MAX_AMULET_OF_CHEMISTRY_CHARGES)
                }
                amuletOfBountyCheckMatcher.find() -> {
                    updateAmuletOfBountyCharges(amuletOfBountyCheckMatcher.group(1).toInt())
                }
                amuletOfBountyUsedMatcher.find() -> {
                    updateAmuletOfBountyCharges(amuletOfBountyUsedMatcher.group(1).toInt())
                }
                message == AMULET_OF_BOUNTY_BREAK_TEXT -> {
                    updateAmuletOfBountyCharges(MAX_AMULET_OF_BOUNTY_CHARGES)
                }
                message.contains(BINDING_BREAK_TEXT) -> {

                    // This chat message triggers before the used message so add 1 to the max charges to ensure proper sync
                    updateBindingNecklaceCharges(MAX_BINDING_CHARGES + 1)
                }
                bindingNecklaceUsedMatcher.find() -> {
                    val equipment = client.getItemContainer(InventoryID.EQUIPMENT)
                    if (equipment!!.contains(ItemID.BINDING_NECKLACE)) {
                        updateBindingNecklaceCharges(getItemCharges(ItemChargeConfig.KEY_BINDING_NECKLACE) - 1)
                    }
                }
                bindingNecklaceCheckMatcher.find() -> {
                    val match = bindingNecklaceCheckMatcher.group(1)
                    var charges = 1
                    if (match != "one") {
                        charges = match.toInt()
                    }
                    updateBindingNecklaceCharges(charges)
                }
                ringOfForgingCheckMatcher.find() -> {
                    val match = ringOfForgingCheckMatcher.group(1)
                    var charges = 1
                    if (match != "one") {
                        charges = match.toInt()
                    }
                    updateRingOfForgingCharges(charges)
                }
                message == RING_OF_FORGING_USED_TEXT || message == RING_OF_FORGING_VARROCK_PLATEBODY -> {
                    val inventory = client.getItemContainer(InventoryID.INVENTORY)
                    val equipment = client.getItemContainer(InventoryID.EQUIPMENT) ?: return

                    // Determine if the player smelted with a Ring of Forging equipped.
                    if (equipment.contains(ItemID.RING_OF_FORGING) && (message == RING_OF_FORGING_USED_TEXT || inventory!!.count(
                            ItemID.IRON_ORE
                        ) > 1)
                    ) {
                        val charges = Ints.constrainToRange(
                            getItemCharges(ItemChargeConfig.KEY_RING_OF_FORGING) - 1,
                            0,
                            MAX_RING_OF_FORGING_CHARGES
                        )
                        updateRingOfForgingCharges(charges)
                    }
                }
                message == RING_OF_FORGING_BREAK_TEXT -> {
                    updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES)
                }
                chronicleAddMatcher.find() -> {
                    val match = chronicleAddMatcher.group(1)
                    if (match == "one") {
                        setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1)
                    } else {
                        setItemCharges(ItemChargeConfig.KEY_CHRONICLE, match.toInt())
                    }
                }
                chronicleUseAndCheckMatcher.find() -> {
                    setItemCharges(ItemChargeConfig.KEY_CHRONICLE, chronicleUseAndCheckMatcher.group(1).toInt())
                }
                message == CHRONICLE_ONE_CHARGE_TEXT -> {
                    setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1)
                }
                message == CHRONICLE_EMPTY_TEXT || message == CHRONICLE_NO_CHARGES_TEXT -> {
                    setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 0)
                }
                message == CHRONICLE_FULL_TEXT -> {
                    setItemCharges(ItemChargeConfig.KEY_CHRONICLE, 1000)
                }
                slaughterActivateMatcher.find() -> {
                    val found = slaughterActivateMatcher.group(1)
                    if (found == null) {
                        updateBraceletOfSlaughterCharges(MAX_SLAYER_BRACELET_CHARGES)
                    } else {
                        updateBraceletOfSlaughterCharges(found.toInt())
                    }
                }
                slaughterCheckMatcher.find() -> {
                    updateBraceletOfSlaughterCharges(slaughterCheckMatcher.group(1).toInt())
                }
                expeditiousActivateMatcher.find() -> {
                    val found = expeditiousActivateMatcher.group(1)
                    if (found == null) {
                        updateExpeditiousBraceletCharges(MAX_SLAYER_BRACELET_CHARGES)
                    } else {
                        updateExpeditiousBraceletCharges(found.toInt())
                    }
                }
                expeditiousCheckMatcher.find() -> {
                    updateExpeditiousBraceletCharges(expeditiousCheckMatcher.group(1).toInt())
                }
                bloodEssenceCheckMatcher.find() -> {
                    updateBloodEssenceCharges(bloodEssenceCheckMatcher.group(1).toInt())
                }
                bloodEssenceExtractMatcher.find() -> {
                    updateBloodEssenceCharges(
                        getItemCharges(ItemChargeConfig.KEY_BLOOD_ESSENCE) - bloodEssenceExtractMatcher.group(
                            1
                        ).toInt()
                    )
                }
                message.contains(BLOOD_ESSENCE_ACTIVATE_TEXT) -> {
                    updateBloodEssenceCharges(MAX_BLOOD_ESSENCE_CHARGES)
                }
                braceletOfClayCheckMatcher.find() -> {
                    updateBraceletOfClayCharges(braceletOfClayCheckMatcher.group(1).toInt())
                }
                message == BRACELET_OF_CLAY_USE_TEXT || message == BRACELET_OF_CLAY_USE_TEXT_TRAHAEARN -> {
                    val equipment = client.getItemContainer(InventoryID.EQUIPMENT)

                    // Determine if the player mined with a Bracelet of Clay equipped.
                    if (equipment != null && equipment.contains(ItemID.BRACELET_OF_CLAY)) {
                        val charges = Ints.constrainToRange(
                            getItemCharges(ItemChargeConfig.KEY_BRACELET_OF_CLAY) - 1,
                            0,
                            MAX_BRACELET_OF_CLAY_CHARGES
                        )
                        updateBraceletOfClayCharges(charges)
                    }
                }
                message == BRACELET_OF_CLAY_BREAK_TEXT -> {
                    updateBraceletOfClayCharges(MAX_BRACELET_OF_CLAY_CHARGES)
                }
            }
        }
    }

    override fun onItemContainerChanged(it: ItemContainerChanged) {
        if (it.containerId != InventoryID.EQUIPMENT.id) {
            return
        }
        updateInfoboxes()
    }

    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        if ("destroyOnOpKey" != it.eventName) {
            return
        }
        val yesOption = client.intStack[client.intStackSize - 1]
        if (yesOption == 1) {
            checkDestroyWidget()
        }
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        if (it.varbitId == Varbits.EXPLORER_RING_ALCHS) {
            updateExplorerRingCharges(it.value)
        }
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.DIALOG_SPRITE_GROUP_ID) {
            clientThread.invokeLater {
                val sprite = client.getWidget(WidgetInfo.DIALOG_SPRITE_SPRITE)
                if (sprite != null) {
                    when (sprite.itemId) {
                        ItemID.DODGY_NECKLACE -> {
                            updateDodgyNecklaceCharges(MAX_DODGY_CHARGES)
                        }
                        ItemID.RING_OF_FORGING -> {
                            updateRingOfForgingCharges(MAX_RING_OF_FORGING_CHARGES)
                        }
                        ItemID.AMULET_OF_CHEMISTRY -> {
                            updateAmuletOfChemistryCharges(MAX_AMULET_OF_CHEMISTRY_CHARGES)
                        }
                        ItemID.BRACELET_OF_SLAUGHTER -> {
                            updateBraceletOfSlaughterCharges(MAX_SLAYER_BRACELET_CHARGES)
                        }
                        ItemID.EXPEDITIOUS_BRACELET -> {
                            updateExpeditiousBraceletCharges(MAX_SLAYER_BRACELET_CHARGES)
                        }
                    }
                }
            }
        }
    }

    private fun updateDodgyNecklaceCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_DODGY_NECKLACE, value)
        updateInfoboxes()
    }

    private fun updateAmuletOfChemistryCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_AMULET_OF_CHEMISTRY, value)
        updateInfoboxes()
    }

    private fun updateAmuletOfBountyCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_AMULET_OF_BOUNTY, value)
        updateInfoboxes()
    }

    private fun updateBindingNecklaceCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_BINDING_NECKLACE, value)
        updateInfoboxes()
    }

    private fun updateExplorerRingCharges(value: Int) {
        // Note: Varbit counts upwards. We count down from the maximum charges.
        setItemCharges(ItemChargeConfig.KEY_EXPLORERS_RING, MAX_EXPLORER_RING_CHARGES - value)
        updateInfoboxes()
    }

    private fun updateRingOfForgingCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_RING_OF_FORGING, value)
        updateInfoboxes()
    }

    private fun updateBraceletOfSlaughterCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_BRACELET_OF_SLAUGHTER, value)
        updateInfoboxes()
    }

    private fun updateExpeditiousBraceletCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_EXPEDITIOUS_BRACELET, value)
        updateInfoboxes()
    }

    private fun updateBloodEssenceCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_BLOOD_ESSENCE, value)
        updateInfoboxes()
    }

    private fun updateBraceletOfClayCharges(value: Int) {
        setItemCharges(ItemChargeConfig.KEY_BRACELET_OF_CLAY, value)
        updateInfoboxes()
    }

    private fun checkDestroyWidget() {
        val currentTick = client.tickCount
        if (lastCheckTick == currentTick) {
            return
        }
        lastCheckTick = currentTick
        val widgetDestroyItemName = client.getWidget(WidgetInfo.DESTROY_ITEM_NAME) ?: return
        if (widgetDestroyItemName.text == "Binding necklace") {
            updateBindingNecklaceCharges(MAX_BINDING_CHARGES)
        }
    }

    private fun updateInfoboxes() {
        val itemContainer = client.getItemContainer(InventoryID.EQUIPMENT) ?: return
        val items = itemContainer.items
        val showInfoboxes = config.showInfoboxes()
        for (slot in EquipmentInventorySlot.values()) {
            if (slot.slotIdx >= items.size) {
                break
            }
            val i = items[slot.slotIdx]
            val id = i.id
            var type: ItemChargeType? = null
            var charges = -1
            val itemWithCharge: ItemWithCharge? = ItemWithCharge.findItem(id)
            if (itemWithCharge != null) {
                type = itemWithCharge.type
                charges = itemWithCharge.charges
            } else {
                val itemWithConfig: ItemWithConfig? = ItemWithConfig.findItem(id)
                if (itemWithConfig != null) {
                    type = itemWithConfig.type
                    charges = getItemCharges(itemWithConfig.configKey)
                }
            }
            val enabled = type != null && type.enabled!!.test(config)
            if (showInfoboxes && enabled && charges > 0) {
                var infobox = infoboxes[slot]
                if (infobox != null) {
                    if (infobox.item == id) {
                        if (infobox.count == charges) {
                            continue
                        }
                        infobox.count = charges
                        continue
                    }
                    infoBoxManager.removeInfoBox(infobox)
                    infoboxes.remove(slot)
                }
                val name = itemManager.getItemComposition(id)!!.name
                val image: BufferedImage? = itemManager.getImage(id)
                infobox = ItemChargeInfobox(this, image, name, charges, id)
                infoBoxManager.addInfoBox(infobox)
                infoboxes[slot] = infobox
            } else {
                val infobox = infoboxes.remove(slot)
                if (infobox != null) {
                    infoBoxManager.removeInfoBox(infobox)
                }
            }
        }
    }

    fun getItemCharges(key: String?): Int {
        // Migrate old non-profile configurations
        val s = configManager.getConfiguration(ItemChargeConfig.GROUP, key!!, String::class.java)
        var i = s?.toInt()
        if (i != null) {
            configManager.unsetConfiguration(ItemChargeConfig.GROUP, key)
            configManager.setConfiguration(ItemChargeConfig.GROUP, key, i)
            return i
        }
        i = configManager.getConfiguration(ItemChargeConfig.GROUP, key, Int::class.java)
        return i ?: -1
    }

    private fun setItemCharges(key: String, value: Int) {
        configManager.setConfiguration(ItemChargeConfig.GROUP, key, value)
    }

    fun getColor(charges: Int): Color? {
        var color = Color.WHITE
        if (charges <= config.veryLowWarning()) {
            color = config.veryLowWarningColor()
        } else if (charges <= config.lowWarning()) {
            color = config.lowWarningolor()
        }
        return color
    }

    companion object {
        private val DODGY_CHECK_PATTERN = Pattern.compile(
            "Your dodgy necklace has (\\d+) charges? left\\."
        )
        private val DODGY_PROTECT_PATTERN = Pattern.compile(
            "Your dodgy necklace protects you\\..*It has (\\d+) charges? left\\."
        )
        private val DODGY_BREAK_PATTERN = Pattern.compile(
            "Your dodgy necklace protects you\\..*It then crumbles to dust\\."
        )
        private const val RING_OF_RECOIL_BREAK_MESSAGE = "Your Ring of Recoil has shattered."
        private val BINDING_CHECK_PATTERN = Pattern.compile(
            "You have ([0-9]+|one) charges? left before your Binding necklace disintegrates\\."
        )
        private val BINDING_USED_PATTERN = Pattern.compile(
            "You (partially succeed to )?bind the temple's power into (mud|lava|steam|dust|smoke|mist) runes\\."
        )
        private const val BINDING_BREAK_TEXT = "Your Binding necklace has disintegrated."
        private val RING_OF_FORGING_CHECK_PATTERN = Pattern.compile(
            "You can smelt ([0-9]+|one) more pieces? of iron ore before a ring melts\\."
        )
        private const val RING_OF_FORGING_USED_TEXT = "You retrieve a bar of iron."
        private const val RING_OF_FORGING_BREAK_TEXT = "Your Ring of Forging has melted."
        private const val RING_OF_FORGING_VARROCK_PLATEBODY =
            "The Varrock platebody enabled you to smelt your next ore simultaneously."
        private val AMULET_OF_CHEMISTRY_CHECK_PATTERN = Pattern.compile(
            "Your amulet of chemistry has (\\d) charges? left\\."
        )
        private val AMULET_OF_CHEMISTRY_USED_PATTERN = Pattern.compile(
            "Your amulet of chemistry helps you create a \\d-dose potion\\. It has (\\d|one) charges? left\\."
        )
        private val AMULET_OF_CHEMISTRY_BREAK_PATTERN = Pattern.compile(
            "Your amulet of chemistry helps you create a \\d-dose potion\\. It then crumbles to dust\\."
        )
        private val AMULET_OF_BOUNTY_CHECK_PATTERN = Pattern.compile(
            "Your amulet of bounty has (\\d+) charges? left\\."
        )
        private val AMULET_OF_BOUNTY_USED_PATTERN = Pattern.compile(
            "Your amulet of bounty saves some seeds for you\\. It has (\\d) charges? left\\."
        )
        private const val AMULET_OF_BOUNTY_BREAK_TEXT =
            "Your amulet of bounty saves some seeds for you. It then crumbles to dust."
        private val CHRONICLE_ADD_PATTERN = Pattern.compile(
            "You add (?:\\d+|a single) charges? to your book\\. It now has (\\d+|one) charges?\\."
        )
        private val CHRONICLE_USE_AND_CHECK_PATTERN = Pattern.compile(
            "Your book has (\\d+) charges left\\."
        )
        private const val CHRONICLE_FULL_TEXT = "Your book is fully charged! It has 1,000 charges already."
        private const val CHRONICLE_ONE_CHARGE_TEXT = "You have one charge left in your book."
        private const val CHRONICLE_EMPTY_TEXT = "Your book has run out of charges."
        private const val CHRONICLE_NO_CHARGES_TEXT =
            "Your book does not have any charges. Purchase some Teleport Cards from Diango."
        private val BRACELET_OF_SLAUGHTER_ACTIVATE_PATTERN = Pattern.compile(
            "Your bracelet of slaughter prevents your slayer count from decreasing. (?:(?:It has (\\d{1,2}) charges? left)|(It then crumbles to dust))\\."
        )
        private val BRACELET_OF_SLAUGHTER_CHECK_PATTERN = Pattern.compile(
            "Your bracelet of slaughter has (\\d{1,2}) charges? left\\."
        )
        private const val BRACELET_OF_SLAUGHTER_BREAK_TEXT = "Your Bracelet of Slaughter has crumbled to dust."
        private val EXPEDITIOUS_BRACELET_ACTIVATE_PATTERN = Pattern.compile(
            "Your expeditious bracelet helps you progress your slayer (?:task )?faster. (?:(?:It has (\\d{1,2}) charges? left)|(It then crumbles to dust))\\."
        )
        private val EXPEDITIOUS_BRACELET_CHECK_PATTERN = Pattern.compile(
            "Your expeditious bracelet has (\\d{1,2}) charges? left\\."
        )
        private const val EXPEDITIOUS_BRACELET_BREAK_TEXT = "Your Expeditious Bracelet has crumbled to dust."
        private val BLOOD_ESSENCE_CHECK_PATTERN = Pattern.compile(
            "Your blood essence has (\\d{1,4}) charges? remaining"
        )
        private val BLOOD_ESSENCE_EXTRACT_PATTERN = Pattern.compile(
            "You manage to extract power from the Blood Essence and craft (\\d{1,3}) extra runes?\\."
        )
        private const val BLOOD_ESSENCE_ACTIVATE_TEXT = "You activate the blood essence."
        private const val BRACELET_OF_CLAY_USE_TEXT = "You manage to mine some clay."
        private const val BRACELET_OF_CLAY_USE_TEXT_TRAHAEARN = "You manage to mine some soft clay."
        private const val BRACELET_OF_CLAY_BREAK_TEXT = "Your bracelet of clay crumbles to dust."
        private val BRACELET_OF_CLAY_CHECK_PATTERN = Pattern.compile(
            "You can mine (\\d{1,2}) more pieces? of soft clay before your bracelet crumbles to dust\\."
        )
        private const val MAX_DODGY_CHARGES = 10
        private const val MAX_BINDING_CHARGES = 16
        private const val MAX_EXPLORER_RING_CHARGES = 30
        private const val MAX_RING_OF_FORGING_CHARGES = 140
        private const val MAX_AMULET_OF_CHEMISTRY_CHARGES = 5
        private const val MAX_AMULET_OF_BOUNTY_CHARGES = 10
        private const val MAX_SLAYER_BRACELET_CHARGES = 30
        private const val MAX_BLOOD_ESSENCE_CHARGES = 1000
        private const val MAX_BRACELET_OF_CLAY_CHARGES = 28
    }
}