package meteor.plugins.meteor

import com.formdev.flatlaf.FlatLaf
import dev.hoot.api.InteractMethod
import dev.hoot.api.InteractionException
import dev.hoot.api.MouseBehavior
import dev.hoot.api.commons.Rand
import dev.hoot.api.commons.Time
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.GameThread
import dev.hoot.api.movement.Movement
import dev.hoot.api.widgets.DialogOption
import dev.hoot.api.widgets.Widgets
import eventbus.events.ConfigChanged
import eventbus.events.DialogProcessed
import eventbus.events.MenuOptionClicked
import meteor.Configuration
import meteor.Logger
import meteor.api.packets.ClientPackets

import meteor.config.ConfigManager

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.themes.MeteorliteTheme
import net.runelite.api.Constants
import net.runelite.api.MenuAction
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Point
import java.awt.Rectangle

@PluginDescriptor(name = "Meteor", enabledByDefault = true, disabledOnStartup = false)
class Meteor : Plugin() {
    var config = configuration<MeteorConfig>()
    val log = Logger("Meteor")
    override fun onInvokeMenuAction(it: AutomatedMenu) {
        val debug = ("O=" + it.option
                + " | T=" + it.target
                + " | ID=" + it.identifier
                + " | OP=" + it.opcode
                + " | P0=" + it.param0
                + " | P1=" + it.param1
                + " | X=" + it.clickX
                + " | Y=" + it.clickY
                + " | TAG=" + it.entityTag)
        log.debug("[Automated] {}", debug)
        val clickPoint = getClickPoint(it)
        val mouseHandler = client.mouseHandler
        try {
            if (config.mouseBehavior() != MouseBehavior.DISABLED) {
                mouseHandler.sendMovement(clickPoint.x, clickPoint.y)
                ClientPackets.queueClickPacket(clickPoint.x, clickPoint.y)
            }
            GameThread.invoke {
                try {
                    val packetBufferNode = ClientPackets.createClientPacket(it)
                    if (packetBufferNode != null) packetBufferNode.send() else println("No valid packet to write")
                } catch (ex: InteractionException) {
                    log.debug("{}, falling back to invoke", ex.message!!)
                    processAction(it, clickPoint.x, clickPoint.y)
                }
            }
        } catch (ex: InteractionException) {
            log.error("Interaction failed: {}", ex.message!!)
            client.pendingAutomation = null
        } finally {
            val duration = System.currentTimeMillis() - it.timestamp
            Time.sleep(Constants.CLIENT_TICK_LENGTH + duration)
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.automated && it.getMenuAction() == MenuAction.WALK && config.interactMethod() == InteractMethod.MOUSE_EVENTS) {
            Movement.setDestination(it.getParam0(), it.getParam1())
            it.menuEntry.type = MenuAction.CANCEL
            it.menuEntry.param0 = 0
            it.menuEntry.param1 = 0
        }
        val action = ("O=" + it.getMenuOption()
                + " | T=" + it.getMenuTarget()
                + " | ID=" + it.getId()
                + " | OP=" + it.getMenuAction()!!.id
                + " | P0=" + it.getParam0()
                + " | P1=" + it.getParam1()
                + " | X=" + it.canvasX
                + " | Y=" + it.canvasY)
        log.debug("[Menu Action] {}", action)
    }

    override fun onDialogProcessed(it: DialogProcessed) {
        val dialogOption = DialogOption.of(it.option.widgetUid, it.option.menuIndex)
        if (dialogOption != null) {
            log.debug("Dialog processed {}", dialogOption)
        } else {
            log.debug("Unknown or unmapped dialog {}", it)
        }
    }

    private fun processAction(entry: AutomatedMenu, x: Int, y: Int) {
        GameThread.invoke {
            client.invokeMenuAction(
                entry.option, entry.target, entry.identifier,
                entry.opcode.id, entry.param0, entry.param1, x, y
            )
        }
    }

    private fun getClickPoint(e: AutomatedMenu): Point {
        if (config.mouseBehavior() == MouseBehavior.OFF_SCREEN) {
            return Point(0, 0)
        }
        if (config.mouseBehavior() == MouseBehavior.MOUSE_POS) {
            return Point(client.mouseHandler.currentX, client.mouseHandler.currentY)
        }
        if (e.clickX != -1 && e.clickY != -1 && config.mouseBehavior() == MouseBehavior.CLICKBOXES) {
            val clickPoint = Point(e.clickX, e.clickY)
            if (!clickInsideMinimap(clickPoint)) {
                return clickPoint
            }
        }
        val bounds = client.canvas.bounds
        val randomPoint = Point(Rand.nextInt(0, bounds.width), Rand.nextInt(0, bounds.height))
        return if (clickInsideMinimap(randomPoint)) {
            getClickPoint(e)
        } else randomPoint
    }

    private fun clickInsideMinimap(point: Point): Boolean {
        val minimap = minimap
        if (minimap.contains(point)) {
            log.debug("Click {} was inside minimap", point)
            return true
        }
        return false
    }

    private val minimap: Rectangle
        get() {
            val minimap = Widgets.get(WidgetInfo.FIXED_VIEWPORT_MINIMAP_DRAW_AREA)
            if (Widgets.isVisible(minimap)) {
                return minimap.bounds
            }
            val minimap1 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_DRAW_AREA)
            if (Widgets.isVisible(minimap1)) {
                return minimap1.bounds
            }
            val minimap2 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_STONES_DRAW_AREA)
            if (Widgets.isVisible(minimap2)) {
                return minimap2.bounds
            }
            val bounds = client.canvas.bounds
            return Rectangle(bounds.width - MINIMAP_WIDTH, 0, MINIMAP_WIDTH, MINIMAP_HEIGHT)
        }

    private fun interactReady(): Boolean {
        return client.pendingAutomation == null
    }

    private val MINIMAP_WIDTH = 250
    private val MINIMAP_HEIGHT = 180


    override fun onConfigChanged(it: ConfigChanged) {
        when {
            !config.theme() && it.key == "Light theme/Dark theme" -> {

                ConfigManager.setConfiguration(Configuration.MASTER_GROUP,"MeteorColor", Color.BLACK)
                MeteorliteTheme.installLight()
                FlatLaf.updateUI()
            }
            config.theme() && it.key == "Light theme/Dark theme" -> {

                MeteorliteTheme.installDark()
                FlatLaf.updateUI()
                ConfigManager.setConfiguration(Configuration.MASTER_GROUP,"MeteorColor", Color.CYAN)
            }
        }
    }
}