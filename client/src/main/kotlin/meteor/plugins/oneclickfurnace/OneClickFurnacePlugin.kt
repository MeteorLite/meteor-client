package meteor.plugins.oneclickfurnace

import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.queries.BankItemQuery
import net.runelite.api.queries.GameObjectQuery
import net.runelite.api.queries.NPCQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.widgets.WidgetItem



@PluginDescriptor(
    name = "One Click Furnace",
    description = "Smelts / crafts",
    tags = ["one", "click", "oneclick", "cannonballs", "smithing"],
    enabledByDefault = false
)

class OneClickFurnacePlugin : Plugin() {
    //if quantities aren't right set them?
    private var bankingState = 1
    private var timeout = 0
    private val config = configuration<OneClickFurnaceConfig>()

    override fun onStart() {
        bankingState = 1
        timeout = 0
    }


    override fun onGameTick(it: GameTick) {

        if (client.localPlayer!!.animation == 899 || client.localPlayer!!.animation == 827) timeout = 10
        if (timeout > 0) timeout--
        if (getInventoryItem(config.method().material) == null) timeout = 0
    }


    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption().equals("<col=00ff00>One Click Furnace")) handleClick(it)
    }

   override fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) return
        val text = "<col=00ff00>One Click Furnace"
        client.insertMenuItem(text, "", MenuAction.UNKNOWN.id, 0, 0, 0, true)
        client.setTempMenuEntry(
            client.menuEntries.firstOrNull { x: MenuEntry -> x.option == text }
        )
    }

    private fun handleClick(event: MenuOptionClicked) {
        if (config.consumeClicks()) {
            if (timeout > 0 || client.localPlayer!!.isMoving && !bankOpen()) {
                return
            }
        }
        if (widgetHandler() != null) {
            setMenuEntry(event, widgetHandler())
            return
        }
        if (bankOpen()) {
            //set bank quantity to 1
            if (client.getVarbitValue(6590) != 0) {
                setMenuEntry(event, createMenuEntry(1, MenuAction.CC_OP, -1, 786460, false))
                return
            }
            //set bank tab to main tab
            if (client.getVarbitValue(Varbits.CURRENT_BANK_TAB) != 0) {
                setMenuEntry(
                    event,
                    createMenuEntry(1, MenuAction.CC_OP, 10, WidgetInfo.BANK_TAB_CONTAINER.id, false)
                )
                return
            }
            when (bankingState) {
                1 -> {
                    if (getInventoryItem(config.method().product) != null) {
                        if (config.method() == CraftingMethods.Molten_Glass) {
                            setMenuEntry(event, depositAll())
                            bankingState = 2
                            return
                        }
                        setMenuEntry(event, depositProduct())
                        bankingState = 2
                        return
                    }
                    bankingState = 2
                    if (config.method().material2 != -1) {
                        setMenuEntry(event, withdrawX())
                        bankingState = 3
                        return
                    }
                    bankingState = 3
                    setMenuEntry(event, withdrawAll())
                    bankingState = 4
                    return
                }

                2 -> {
                    if (config.method().material2 != -1) {
                        setMenuEntry(event, withdrawX())
                        bankingState = 3
                        return
                    }
                    bankingState = 3
                    setMenuEntry(event, withdrawAll())
                    bankingState = 4
                    return
                }

                3 -> {
                    setMenuEntry(event, withdrawAll())
                    bankingState = 4
                    return
                }

                4 -> {
                    if (useFurnace() == null) {
                        client.addChatMessage(ChatMessageType.BROADCAST, "", "Furnace not found. Try Edge or Priff", "")
                        return
                    }
                    setMenuEntry(event, useFurnace())
                    return
                }
            }
        }
        if (getInventoryItem(config.method().material) != null) {
            if (config.method().material2 == -1 || config.method().material2 != -1 && getInventoryItem(config.method().material2) != null) {
                if (useFurnace() == null) {
                    client.addChatMessage(ChatMessageType.BROADCAST, "", "Furnace not found. Try Edge or Priff", "")
                    return
                }
                setMenuEntry(event, useFurnace())
                return
            }
        }
        setMenuEntry(event, bank())
    }

    private fun getGameObject(name: String): GameObject? {
        return GameObjectQuery()
            .nameEquals(name)
            .result(client)
            .nearestTo(client.localPlayer)
    }

    private fun getNPC(name: String): NPC? {
        return NPCQuery()
            .nameEquals(name)
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
            tileObject.localLocation.sceneX, tileObject.localLocation.sceneY
        )
    }

    private fun bank(): MenuEntry {
        bankingState = 1
        val banker = getNPC("Banker")
            return createMenuEntry(banker?.index!!, MenuAction.NPC_THIRD_OPTION, 0, 0, false)
    }

    private fun depositProduct(): MenuEntry {
        val item = getInventoryItem(config.method().product)
        return createMenuEntry(
            8,
            MenuAction.CC_OP_LOW_PRIORITY,
            item!!.index,
            WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id,
            false
        )
    }

    private fun depositAll(): MenuEntry {
        return createMenuEntry(1, MenuAction.CC_OP, -1, WidgetInfo.BANK_DEPOSIT_INVENTORY.id, false)
    }

    private fun withdrawX(): MenuEntry {
        val bankIndex = getBankIndex(config.method().material2)
        return createMenuEntry(5, MenuAction.CC_OP, bankIndex, WidgetInfo.BANK_ITEM_CONTAINER.id, false)
    }

    private fun withdrawAll(): MenuEntry {
        val bankIndex = getBankIndex(config.method().material)
        return createMenuEntry(
            7,
            MenuAction.CC_OP_LOW_PRIORITY,
            bankIndex,
            WidgetInfo.BANK_ITEM_CONTAINER.id,
            false
        )
    }

    private fun useFurnace(): MenuEntry? {
        val furnace = getGameObject("Furnace") ?: return null
        return createMenuEntry(
            furnace.id,
            MenuAction.GAME_OBJECT_SECOND_OPTION,
            getLocation(furnace).x,
            getLocation(furnace).y,
            false
        )
    }

    private fun widgetHandler(): MenuEntry? {
        return if (client.getWidget(270, 1) != null || client.getWidget(446, 1) != null || client.getWidget(
                6,
                1
            ) != null
        ) {
            createMenuEntry(1, MenuAction.CC_OP, -1, config.method().opcode, false)
        } else null
    }

    private fun getInventoryItem(id: Int): Widget? {
        client.runScript(6009, 9764864, 28, 1, -1) //rebuild inventory ty pajeet
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        val bankInventoryWidget: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        if (bankInventoryWidget != null) {
            if (!bankInventoryWidget.isHidden) {
                return getWidgetItem(bankInventoryWidget, id)
            }
        }
        return inventoryWidget?.let { getWidgetItem(it, id) }
    }

    private fun getWidgetItem(widget: Widget, id: Int): Widget? {
        for (item in widget.dynamicChildren) {
            if (item.itemId == id) {
                return item
            }
        }
        return null
    }

    private fun getBankIndex(ID: Int): Int {
        val bankItem: WidgetItem? = BankItemQuery()
            .idEquals(ID)
            .result(client)
            .first()
        return bankItem?.widget?.index ?: -1
    }

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

    private fun bankOpen(): Boolean {
        return client.getItemContainer(InventoryID.BANK) != null
    }

    private fun setMenuEntry(event: MenuOptionClicked, menuEntry: MenuEntry?) {
        event.menuEntry.identifier =  menuEntry?.identifier!!
        event.menuEntry.type = menuEntry.type
        event.menuEntry.param0 = menuEntry.param0
        event.menuEntry.param1 = menuEntry.param1
    }
}