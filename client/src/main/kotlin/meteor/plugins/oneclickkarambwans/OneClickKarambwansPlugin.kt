package meteor.plugins.oneclickkarambwans

import eventbus.events.ClientTick
import eventbus.events.MenuOptionClicked
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.queries.GameObjectQuery
import net.runelite.api.queries.NPCQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Predicate

@PluginDescriptor(
    name = "One Click Karambwans",
    description = "Set recent fairy ring to DKP. Supports Fish Barrel",
    tags = ["karambwans,one click,zanaris,fishing,oneclick"],
    enabledByDefault = false
)

class OneClickKarambwansPlugin : Plugin() {
    private val FAIRY_RING_KARAMJA_ID = 29495
    private var state = "BARREL"
    private val config = configuration<OneClickKarambwansConfig>()

    override fun onStart() {
        state = "BARREL"
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption().equals("<col=00ff00>One Click Karambwans")) {
            handleClick(it)
        }
    }

    override fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) return
        val text = "<col=00ff00>One Click Karambwans"
        client.insertMenuItem(text, "", MenuAction.UNKNOWN.id, 0, 0, 0, true)
        client.setTempMenuEntry(
            Arrays.stream<MenuEntry>(client.menuEntries)
                .filter(Predicate<MenuEntry> { x: MenuEntry -> x.option == text }).findFirst().orElse(null)
        )
    }

    private fun handleClick(it: MenuOptionClicked) {
        val FAIRY_RING_ANIMATION1 = 3265
        val FAIRY_RING_ANIMATION2 = 3266
        if (((client.localPlayer!!.isMoving
                    || (client.localPlayer!!.poseAnimation
                    != client.localPlayer!!.idlePoseAnimation
                    ) || client.localPlayer!!.animation == AnimationID.FISHING_KARAMBWAN) || client.localPlayer!!.animation == FAIRY_RING_ANIMATION1 || client.localPlayer!!.animation == FAIRY_RING_ANIMATION2)
            and !bankOpen()
        ) {
            print("Consume event because not idle?")
            it.consume()
            return
        }
        if (getInventoryItem(ItemID.RAW_KARAMBWANJI) == null || getInventoryItem(ItemID.KARAMBWAN_VESSEL_3159) == null && getInventoryItem(
                ItemID.KARAMBWAN_VESSEL
            ) == null
        ) {
            print("Consume event because no karambwanji or vessel")
            it.consume()
            return
        }
        if (emptySlots == 0) {
            print("Trying to tele to bank")
            if (getGameObject(FAIRY_RING_KARAMJA_ID) != null) {
                it.menuEntry = teleToBankMES()
                return
            }
            if (!bankOpen()) {
                it.menuEntry = bankMES()
                return
            }
        }
        if (getInventoryItem(ItemID.RAW_KARAMBWAN) == null && getGameObject(FAIRY_RING_KARAMJA_ID) == null) {
            print("trying to access/tele to fairy ring")
            if (useFairyRingMES() != null) {
                it.menuEntry = useFairyRingMES()!!
                return
            }
            it.menuEntry = teleToFairyRingMES()!!
            return
        }
        if (bankOpen()) {
            val CLUE_BOTTLE_SET = setOf<Int>(
                ItemID.CLUE_BOTTLE_BEGINNER,
                ItemID.CLUE_BOTTLE_EASY,
                ItemID.CLUE_BOTTLE_MEDIUM,
                ItemID.CLUE_BOTTLE_HARD,
                ItemID.CLUE_BOTTLE_ELITE
            )
            for (ClueBottle in CLUE_BOTTLE_SET) {
                if (getInventoryItem(ClueBottle) != null) {
                    it.menuEntry = depositClueBottleMES(ClueBottle)
                    return
                }
            }
            if (getInventoryItem(ItemID.OPEN_FISH_BARREL) != null) {
                when (state) {
                    "BARREL" -> {
                        it.menuEntry = emptyBarrelMES()
                        state = "INVENTORY"
                    }

                    "INVENTORY" -> {
                        it.menuEntry = depositKarambwansMES()
                        state = "BARREL"
                    }
                }
            } else {
                it.menuEntry = depositKarambwansMES()
            }
            return
        }
        if (getGameObject(FAIRY_RING_KARAMJA_ID) != null) {
            print("Trying to fish ")
            it.menuEntry = fishingSpotMES()
        }
    }

    private fun fishingSpotMES(): MenuEntry {
        return createMenuEntry(
            fishingSpot?.index!!,
            MenuAction.NPC_FIRST_OPTION,
            getNPCLocation(fishingSpot!!).getX(),
            getNPCLocation(fishingSpot!!).getY(),
            false
        )
    }

    private fun teleToBankMES(): MenuEntry {
        state =
            "BARREL" //reset state before banking, workaround in case of spam clicking in bank messing up state before game has registered the container change
        if (client.getItemContainer(InventoryID.EQUIPMENT)!!.contains(ItemID.MAX_CAPE) || client.getItemContainer(
                InventoryID.EQUIPMENT
            )!!.contains(ItemID.MAX_CAPE_13342)
        ) {
            return createMenuEntry(4, MenuAction.CC_OP, -1, WidgetInfo.EQUIPMENT_CAPE.id, false)
        }
        if (client.getItemContainer(InventoryID.EQUIPMENT)!!.contains(ItemID.CRAFTING_CAPE) || client.getItemContainer(
                InventoryID.EQUIPMENT
            )!!.contains(ItemID.CRAFTING_CAPET)
        ) {
            return createMenuEntry(3, MenuAction.CC_OP, -1, WidgetInfo.EQUIPMENT_CAPE.id, false)
        }
        val craftingCape = getInventoryItem(ItemID.CRAFTING_CAPE)
        val craftingCapeT = getInventoryItem(ItemID.CRAFTING_CAPET)
        if (craftingCape != null) {
            return createMenuEntry(
                craftingCape.id,
                MenuAction.ITEM_THIRD_OPTION,
                craftingCape.index,
                WidgetInfo.INVENTORY.id,
                false
            )
        }
        if (craftingCapeT != null) {
            return createMenuEntry(
                craftingCapeT.id,
                MenuAction.ITEM_THIRD_OPTION,
                craftingCapeT.index,
                WidgetInfo.INVENTORY.id,
                false
            )
        }
        return if (config.bankAtSeers()) {
            createMenuEntry(
                2,
                MenuAction.CC_OP,
                -1,
                WidgetInfo.SPELL_CAMELOT_TELEPORT.id,
                false
            )
        } else createMenuEntry(
            FAIRY_RING_KARAMJA_ID,
            MenuAction.GAME_OBJECT_FIRST_OPTION,
            getLocation(getGameObject(FAIRY_RING_KARAMJA_ID)).getX(),
            getLocation(getGameObject(FAIRY_RING_KARAMJA_ID)).getY(),
            false
        )
    }

    private fun bankMES(): MenuEntry {
        val craftingBank = getGameObject(14886)
        if (craftingBank != null) {
            return createMenuEntry(
                craftingBank.id,
                MenuAction.GAME_OBJECT_FIRST_OPTION,
                getLocation(craftingBank).getX(),
                getLocation(craftingBank).getY(),
                false
            )
        }
        val lunarBank = getGameObject(16700)
        if (lunarBank != null) {
            return createMenuEntry(
                lunarBank.id,
                MenuAction.GAME_OBJECT_SECOND_OPTION,
                getLocation(lunarBank).getX(),
                getLocation(lunarBank).getY(),
                false
            )
        }
        val seersBank = getGameObject(25808)
        if (seersBank != null) {
            return createMenuEntry(
                seersBank.id,
                MenuAction.GAME_OBJECT_SECOND_OPTION,
                getLocation(seersBank).getX(),
                getLocation(seersBank).getY(),
                false
            )
        }
        val zanarisBank = getGameObject(26711)
        return createMenuEntry(
            zanarisBank!!.id,
            MenuAction.GAME_OBJECT_FIRST_OPTION,
            getLocation(zanarisBank).getX(),
            getLocation(zanarisBank).getY(),
            false
        )
    }

    private fun useFairyRingMES(): MenuEntry? {
        var fairyRing: GameObject? = null
        val zanarisToKaramjaFR = getGameObject(29560)
        val legendsToKaramjaFr = getGameObject(29495)
        val pohFairyRing = getGameObject(29228)
        val pohFairyRingTreeCombo = getGameObject(29229)
        if (pohFairyRingTreeCombo != null) //if tree fairy ring combo is present, different opcode to other fairy rings.
        {
            return createMenuEntry(
                pohFairyRingTreeCombo.id,
                MenuAction.GAME_OBJECT_FOURTH_OPTION,
                getLocation(pohFairyRingTreeCombo).getX(),
                getLocation(pohFairyRingTreeCombo).getY(),
                false
            )
        }
        if (zanarisToKaramjaFR != null) {
            fairyRing = zanarisToKaramjaFR
        }
        if (legendsToKaramjaFr != null) {
            fairyRing = legendsToKaramjaFr
        }
        if (pohFairyRing != null) {
            fairyRing = pohFairyRing
        }
        return if (fairyRing != null) {
            createMenuEntry(
                fairyRing.id,
                MenuAction.GAME_OBJECT_THIRD_OPTION,
                getLocation(fairyRing).getX(),
                getLocation(fairyRing).getY(),
                false
            )
        } else null
    }

    private fun teleToFairyRingMES(): MenuEntry? {
        if (config.pohFairyRing()) {
            return teleToPOHMES()
        }
        return if (useQuestCapeTeleMES() != null) {
            useQuestCapeTeleMES()
        } else null
    }

    private fun useQuestCapeTeleMES(): MenuEntry? {
        val questCape = getInventoryItem(ItemID.QUEST_POINT_CAPE)
        val questCapeT = getInventoryItem(ItemID.QUEST_POINT_CAPE_T)
        if (questCapeT != null) {
            return createMenuEntry(4, MenuAction.CC_OP, questCapeT.index, WidgetInfo.INVENTORY.id, false)
        }
        if (questCape != null) {
            return createMenuEntry(4, MenuAction.CC_OP, questCape.index, WidgetInfo.INVENTORY.id, false)
        }
        return if (client.getItemContainer(InventoryID.EQUIPMENT) != null
            && (client.getItemContainer(InventoryID.EQUIPMENT)!!.contains(ItemID.QUEST_POINT_CAPE)
                    || client.getItemContainer(InventoryID.EQUIPMENT)!!.contains(ItemID.QUEST_POINT_CAPE_T))
        ) {
            createMenuEntry(3, MenuAction.CC_OP, -1, WidgetInfo.EQUIPMENT_CAPE.id, false)
        } else null
    }

    private fun teleToPOHMES(): MenuEntry {
        val tab = getInventoryItem(ItemID.TELEPORT_TO_HOUSE)
        val conCape = getInventoryItem(ItemID.CONSTRUCT_CAPE)
        val conCapeT = getInventoryItem(ItemID.CONSTRUCT_CAPET)
        if (conCape != null) {
            return createMenuEntry(6, MenuAction.CC_OP_LOW_PRIORITY, conCape.index, WidgetInfo.INVENTORY.id, false)
        }
        if (conCapeT != null) {
            return createMenuEntry(
                6,
                MenuAction.CC_OP_LOW_PRIORITY,
                conCapeT.index,
                WidgetInfo.INVENTORY.id,
                false
            )
        }
        if (tab != null) {
            return createMenuEntry(2, MenuAction.CC_OP, tab.index, WidgetInfo.INVENTORY.id, false)
        }
        if (client.getItemContainer(InventoryID.EQUIPMENT) != null) {
            if (client.getItemContainer(InventoryID.EQUIPMENT)!!.contains(ItemID.MAX_CAPE) || client.getItemContainer(
                    InventoryID.EQUIPMENT
                )!!.contains(ItemID.MAX_CAPE_13342)
            ) {
                return createMenuEntry(5, MenuAction.CC_OP, -1, WidgetInfo.EQUIPMENT_CAPE.id, false)
            }
            if (client.getItemContainer(InventoryID.EQUIPMENT)!!
                    .contains(ItemID.CONSTRUCT_CAPE) || client.getItemContainer(InventoryID.EQUIPMENT)!!
                    .contains(ItemID.CONSTRUCT_CAPET)
            ) {
                return createMenuEntry(4, MenuAction.CC_OP, -1, WidgetInfo.EQUIPMENT_CAPE.id, false)
            }
        }
        return createMenuEntry(1, MenuAction.CC_OP, -1, WidgetInfo.SPELL_TELEPORT_TO_HOUSE.id, false)
    }

    private fun depositKarambwansMES(): MenuEntry {
        return createMenuEntry(
            8,
            MenuAction.CC_OP_LOW_PRIORITY,
            getInventoryItem(ItemID.RAW_KARAMBWAN)!!.index,
            983043,
            false
        )
    }

    private fun depositClueBottleMES(ID: Int): MenuEntry {
        return createMenuEntry(
            2,
            MenuAction.CC_OP,
            getInventoryItem(ID)!!.index,
            983043,
            false
        )
    }

    private fun emptyBarrelMES(): MenuEntry {
        return createMenuEntry(
            9,
            MenuAction.CC_OP_LOW_PRIORITY,
            getInventoryItem(ItemID.OPEN_FISH_BARREL)!!.index,
            983043, false
        )
    }

    private fun bankOpen(): Boolean {
        return client.getItemContainer(InventoryID.BANK) != null
    }

    private fun getInventoryItem(id: Int): Widget? {
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        val bankInventoryWidget: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        if (inventoryWidget != null && !inventoryWidget.isHidden) {
            return getWidgetItem(inventoryWidget, id)
        }
        return if (bankInventoryWidget != null && !bankInventoryWidget.isHidden) {
            getWidgetItem(bankInventoryWidget, id)
        } else null
    }

    private fun getWidgetItem(widget: Widget, id: Int): Widget? {
        for (item in widget.dynamicChildren) {
            if (item.itemId == id) {
                return item
            }
        }
        return null
    }

    private val emptySlots: Int
            get() {
            val inventory: Widget? = client.getWidget(WidgetInfo.INVENTORY.id)
            val bankInventory: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)
            if (inventory != null && !inventory.isHidden && inventory.dynamicChildren != null) {
                val inventoryItems =
                    client.getWidget(WidgetInfo.INVENTORY.id)?.dynamicChildren?.let { listOf<Widget>(*it) }
                if (inventoryItems != null) {
                    return inventoryItems.stream().filter { item: Widget -> item.itemId == 6512 }.count().toInt()
                }
            }
            if (bankInventory != null && !bankInventory.isHidden && bankInventory.dynamicChildren != null) {
                val inventoryItems = listOf<Widget>(
                    *client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)!!.dynamicChildren
                )
                return inventoryItems.stream().filter { item: Widget -> item.itemId == 6512 }.count().toInt()
            }
            return -1
        }

    private fun getGameObject(it: Int): GameObject? {
        return GameObjectQuery()
            .idEquals(it)
            .result(client)
            .nearestTo(client.localPlayer)
    }

    private fun getLocation(tileObject: TileObject?): Point {
        if (tileObject == null) {
            return Point(0, 0)
        }
        return if (tileObject is GameObject) {
            tileObject.sceneMinLocation
        } else Point(
            tileObject.localLocation.sceneX,
            tileObject.localLocation.sceneY
        )
    }

    private fun getNPCLocation(npc: NPC): Point {
        return Point(npc.localLocation.sceneX, npc.localLocation.sceneY)
    }

    private val fishingSpot: NPC?
            get() = NPCQuery()
            .idEquals(NpcID.FISHING_SPOT_4712)
            .result(client)
            .nearestTo(client.localPlayer)

    fun createMenuEntry(
        identifier: Int,
        type: MenuAction?,
        param0: Int,
        param1: Int,
        forceLeftClick: Boolean
    ): MenuEntry {
        return client.createMenuEntry(0).setOption("").setTarget("").setIdentifier(identifier).setType(type)
            .setParam0(param0).setParam1(param1).setForceLeftClick(forceLeftClick)
    }

    private fun print(msg: String) {
        if (config.debug()) {
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", msg, "")
        }
    }
}