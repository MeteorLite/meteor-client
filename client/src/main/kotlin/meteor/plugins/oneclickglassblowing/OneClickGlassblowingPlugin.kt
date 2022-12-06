package meteor.plugins.oneclickglassblowing

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
import java.util.*

@PluginDescriptor(
    name = "One Click Glass",
    enabledByDefault = false,
    description = "One Click Glassblowing/Superglass Make. Default bank is North of Fossil Island. Check Discord for setup info"
)
class OneClickGlassblowingPlugin : Plugin() {

    private val config = configuration<OneClickGlassblowingConfig>()
    private var glassblowingStage = 1
    private var superglassMakeStage = 1
    private var seaweedCount = 0
    private var timeout = 0

    override fun onStart() {
        glassblowingStage = 1
        superglassMakeStage = 1
        seaweedCount = 0
    }


    override fun onGameTick(it: GameTick) {
        if (timeout > 0) {
            timeout--
        }
        if (client.localPlayer!!.animation == AnimationID.CRAFTING_GLASSBLOWING) {
            timeout = 4
        }
        if ((getInventoryItem(ItemID.MOLTEN_GLASS) == null) and !bankOpen()) {
            timeout = 0
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (timeout != 0) {
            it.consume()
            return
        }
        if (bankOpen()) {
            //set withdraw quantity to 1
            if (client.getVarbitValue(6590) != 0) {
                setMenuEntry(it, createMenuEntry(1, MenuAction.CC_OP, -1, 786460, false))
                return
            }
            //set bank tab to main tab
            if (client.getVarbitValue(Varbits.CURRENT_BANK_TAB) != 0) {
                setMenuEntry(
                    it,
                    createMenuEntry(1, MenuAction.CC_OP, 10, WidgetInfo.BANK_TAB_CONTAINER.id, false)
                )
                return
            }
        }
        if (it.getMenuOption().equals("<col=00ff00>One Click Molten Glass")) {
            if (config.mode() == Types.Mode.GLASSBLOWING) {
                blowGlassHandler(it)
                return
            }
            superGlassMakeHandler(it)
        }
    }


    override  fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) {
            return
        }
        val text = "<col=00ff00>One Click Molten Glass"
        client.insertMenuItem(text, "", MenuAction.UNKNOWN.id, 0, 0, 0, true)
        client.setTempMenuEntry(
            Arrays.stream<MenuEntry>(client.menuEntries)
                .filter { x: MenuEntry -> x.option == text }.findFirst().orElse(null)
        )
    }

    private fun blowGlassHandler(event: MenuOptionClicked) {
        println("glassblowingStage = $glassblowingStage timeout = $timeout")
        when (glassblowingStage) {
            1 -> {
                setMenuEntry(event, openBank())
                if (!bankOpen()) {
                    return
                }
                glassblowingStage = 2
                setMenuEntry(event, depositItems())
                glassblowingStage = 3
                return
            }

            2 -> {
                setMenuEntry(event, depositItems())
                glassblowingStage = 3
                return
            }

            3 -> {
                setMenuEntry(event, withdrawAllMoltenGlass())
                timeout = 1
                glassblowingStage = 4
                return
            }

            4 -> {
                if (client.getWidget(270, 1) != null) {
                    setMenuEntry(event, selectGlassblowingItem())
                    timeout = 4
                    return
                }
                if (usePipeOnGlass() != null) {
                    setMenuEntry(event, usePipeOnGlass())
                    return
                }
                if (getInventoryItem(ItemID.MOLTEN_GLASS) == null) {
                    setMenuEntry(event, openBank())
                    timeout = 1
                    glassblowingStage = 1
                }
            }
        }
    }

    private fun superGlassMakeHandler(event: MenuOptionClicked) {
        if (timeout > 0) return
        println("superglassMakeStage = $superglassMakeStage")
        when (superglassMakeStage) {
            1 -> {
                setMenuEntry(event, openBank())
                seaweedCount = 0
                timeout = 1
                if (!bankOpen()) {
                    return
                }
                superglassMakeStage = 2
                setMenuEntry(event, depositItems())
                superglassMakeStage = 3
                return
            }

            2 -> {
                setMenuEntry(event, depositItems())
                superglassMakeStage = 3
                return
            }

            3 -> {
                if ((config.superglassMakeMethod() == Types.SuperGlassMakeMethod.THREE_EIGHTEEN || config.superglassMakeMethod() == Types.SuperGlassMakeMethod.TWO_TWELVE)
                    && withdrawOneSeaweed() == null
                ) return
                if (config.superglassMakeMethod() == Types.SuperGlassMakeMethod.THIRTEEN_THIRTEEN && withdrawXsodaAshOrSeaweed() == null) return
                if (seaweedCount < config.superglassMakeMethod().seaweedCount) {
                    if (config.superglassMakeMethod() == Types.SuperGlassMakeMethod.THIRTEEN_THIRTEEN) {
                        setMenuEntry(event, withdrawXsodaAshOrSeaweed())
                        seaweedCount++
                        return
                    }
                    setMenuEntry(event, withdrawOneSeaweed())
                    seaweedCount++
                    return
                }
                superglassMakeStage = 4
                if (withdrawXSand() == null) return
                setMenuEntry(event, withdrawXSand())
                superglassMakeStage = 5
                return
            }

            4 -> {
                if (withdrawXSand() == null) return
                setMenuEntry(event, withdrawXSand())
                superglassMakeStage = 5
                return
            }

            5 -> {
                setMenuEntry(event, castSuperglassMake())
                timeout = 4
                superglassMakeStage = 1
            }
        }
    }

    private fun castSuperglassMake(): MenuEntry {
        return createMenuEntry(1, MenuAction.CC_OP, -1, WidgetInfo.SPELL_SUPERGLASS_MAKE.id, false)
    }

    private fun withdrawOneSeaweed(): MenuEntry? {
        return if (getBankIndex(ItemID.GIANT_SEAWEED) == -1) null else createMenuEntry(
            1,
            MenuAction.CC_OP,
            getBankIndex(ItemID.GIANT_SEAWEED),
            786445,
            true
        )
    }

    private fun withdrawXsodaAshOrSeaweed(): MenuEntry? {
        if (getBankIndex(ItemID.SODA_ASH) != -1) {
            return createMenuEntry(
                5,
                MenuAction.CC_OP,
                getBankIndex(ItemID.SODA_ASH),
                786445,
                true
            )
        }
        return if (getBankIndex(ItemID.SEAWEED) != -1) {
            createMenuEntry(
                5,
                MenuAction.CC_OP,
                getBankIndex(ItemID.SEAWEED),
                786445,
                true
            )
        } else null
    }

    private fun withdrawXSand(): MenuEntry? {
        return if (getBankIndex(ItemID.BUCKET_OF_SAND) == -1) null else createMenuEntry(
            5,
            MenuAction.CC_OP,
            getBankIndex(ItemID.BUCKET_OF_SAND),
            786445,
            true
        )
    }

    private fun openBank(): MenuEntry? {
        if (config.bankType() == Types.Banks.BOOTH) {
            val gameObject = getGameObject(config.bankID())
            if (gameObject != null) {
                return createMenuEntry(
                    gameObject.id,
                    MenuAction.GAME_OBJECT_SECOND_OPTION,
                    getLocation(gameObject).x,
                    getLocation(gameObject).y,
                    false
                )
            }
        }
        if (config.bankType() == Types.Banks.CHEST) {
            val gameObject = getGameObject(config.bankID())
            if (gameObject != null) {
                return createMenuEntry(
                    gameObject.id,
                    MenuAction.GAME_OBJECT_FIRST_OPTION,
                    getLocation(gameObject).x,
                    getLocation(gameObject).y,
                    false
                )
            }
        }
        if (config.bankType() == Types.Banks.NPC) {
            val npc = getNpc(config.bankID())
            if (npc != null) {
                return createMenuEntry(
                    npc.index,
                    MenuAction.NPC_THIRD_OPTION,
                    0,
                    0,
                    false
                )
            }
        }
        return null
    }

    private fun depositItems(): MenuEntry {
        return createMenuEntry(
            1,
            MenuAction.CC_OP,
            -1,
            786474,
            false
        )
    }

    private fun withdrawAllMoltenGlass(): MenuEntry? {
        return if (getBankIndex(ItemID.MOLTEN_GLASS) == -1) null else createMenuEntry(
            7,
            MenuAction.CC_OP,
            getBankIndex(ItemID.MOLTEN_GLASS),
            786445,
            true
        )
    }

    private fun usePipeOnGlass(): MenuEntry? {
        val moltenGlass = getInventoryItem(ItemID.MOLTEN_GLASS)
        val pipe = getInventoryItem(ItemID.GLASSBLOWING_PIPE)
        if (pipe == null || moltenGlass == null) return null
        setSelectedInventoryItem(pipe)
        return createMenuEntry(0, MenuAction.WIDGET_TARGET_ON_WIDGET, moltenGlass.index, 9764864, true)
    }

    private fun setSelectedInventoryItem(item: Widget) {
        client.selectedSpellWidget = WidgetInfo.INVENTORY.id
        client.selectedSpellChildIndex = item.index
        client.selectedSpellItemId = item.itemId
    }

    private fun selectGlassblowingItem(): MenuEntry {
        val MENU_ID = config.product().ID
        return createMenuEntry(
            1,
            MenuAction.CC_OP,
            -1,
            MENU_ID,
            false
        )
    }

    private fun getBankIndex(id: Int): Int {
        val bankItem: WidgetItem = BankItemQuery()
            .idEquals(id)
            .result(client)
            .first() ?: return -1
        return bankItem.widget.index
    }

    private fun getInventoryItem(id: Int): Widget? {
        client.runScript(6009, 9764864, 28, 1, -1) //rebuild inventory ty pajeet
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        val bankInventoryWidget: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        if (bankInventoryWidget != null && !bankInventoryWidget.isHidden) {
            return getWidgetItem(bankInventoryWidget, id)
        }
        return if (inventoryWidget != null) {
            getWidgetItem(inventoryWidget, id)
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

    private fun getGameObject(ID: Int): GameObject? {
        return GameObjectQuery()
            .idEquals(ID)
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

    private fun getNpc(id: Int): NPC? {
        return NPCQuery()
            .idEquals(id)
            .result(client)
            .nearestTo(client.localPlayer)
    }

    private fun bankOpen(): Boolean {
        return client.getItemContainer(InventoryID.BANK) != null
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

    private fun setMenuEntry(it: MenuOptionClicked, menuEntry: MenuEntry?) {
        it.menuEntry.identifier = menuEntry?.identifier!!
        it.menuEntry.type = menuEntry.type
        it.menuEntry.param0 = menuEntry.param0
        it.menuEntry.param1 = menuEntry.param1
    }
}