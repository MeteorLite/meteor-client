package meteor.plugins.crabfighter

import meteor.ui.components.LineComponent
import meteor.ui.overlay.*
import net.runelite.api.MenuAction
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

class CrabFighterOverlay(var plugin: CrabFighterPlugin, var config: CrabFighterConfig) : OverlayPanel() {
    private val OPTION_CONFIGURE = "Configure"


    init {
        position = OverlayPosition.BOTTOM_LEFT
        priority = OverlayPriority.HIGH
        layer = OverlayLayer.ABOVE_SCENE
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Crabs overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
//        try {
//            BigBufferedImage
//            var image: BufferedImage = ImageIO.read(File("images/crab.gif"))
//            fillImage(image, Color.pink)
//            renderImageLocation(graphics, Point(0,0), image)
//        } catch(ignored: IOException){
////            println(ignored.message!!)
//            panelComponent.children.add(LineComponent.Builder().left("ERROR: ").leftColor(Color.cyan).right(ignored.message.toString()).rightColor(Color.pink).build())
//
//        }

        val state =
            if(plugin.state_num == 0) {
                "ZERO"
            } else if(plugin.state_num == 1) {
                "Going to home"
            } else if(plugin.state_num == 2) {
                "Attacking NPCs"
            } else if(plugin.state_num == 3) {
                "Going to deaggro"
            } else if(plugin.state_num == 5) {
                "Moving"
            } else if(plugin.state_num == 6) {
                "Hopping Worlds"
            } else if(plugin.state_num == 4) {
                "Collecting items from floor"
            } else {
                ""
            }
        val npcs = plugin.aggroTheseNpcs
        var npcsWalking: Int = 0
        val timeout = plugin.timeout

        npcs.forEach {
            if(it.isMoving) {
                npcsWalking += 1
            }
        }

        panelComponent.children.add(LineComponent.Builder().left("State: ").leftColor(Color.cyan).right(state).rightColor(Color.pink).build())
        panelComponent.children.add(LineComponent.Builder().left("Wandering Crabs: ").leftColor(Color.cyan).right(npcsWalking.toString()).rightColor(Color.pink).build())
        panelComponent.children.add(LineComponent.Builder().left("Tracking Crabs: ").leftColor(Color.cyan).right(npcs.size.toString()).rightColor(Color.pink).build())
        panelComponent.children.add(LineComponent.Builder().left("Timeout: ").leftColor(Color.cyan).right(timeout.toString()).rightColor(Color.pink).build())

        graphics.color = Color.cyan
        graphics.background = Color.darkGray
        return super.render(graphics)
    }
}