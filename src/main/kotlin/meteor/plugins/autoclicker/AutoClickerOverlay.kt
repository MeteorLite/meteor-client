package meteor.plugins.autoclicker

import meteor.plugins.xptracker.XpInfoBoxOverlay.Companion.OPTION_CONFIGURE
import meteor.ui.components.LineComponent
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition.BOTTOM_LEFT
import meteor.ui.overlay.PanelComponent
import meteor.util.ColorUtil
import net.runelite.api.MenuAction
import ui.table.TableAlignment
import ui.table.TableComponent
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class AutoClickerOverlay(plugin: AutoClickerPlugin) :
    OverlayPanel() {

    private val config = plugin.configuration<AutoClickerConfig>()

    init {
        position = BOTTOM_LEFT

        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "AutoClicker"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!AutoClickerPlugin.Companion.run || config.disableUI()) {
            return null
        }
        val panelComponent = PanelComponent()
        val tableComponent = TableComponent()
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT)
        tableComponent.addRow("Running...")
        if (!tableComponent.isEmpty) {
            panelComponent.backgroundColor = ColorUtil.fromHex("#121212")!! //Material Dark default
            panelComponent.setPreferredSize(Dimension(270, 200))
            panelComponent.border = Rectangle(5, 5, 5, 5)
            panelComponent.children.add(
                LineComponent.Builder()
                    .left("Soxs' AutoClicker")
                    .leftColor(ColorUtil.fromHex("#40C4FF")!!)
                    .build()
            )
            panelComponent.children.add(tableComponent)
        }
        return super.render(graphics)
    }
}