/*
 *  Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 *  Copyright (c) 2017, Adam <Adam@sigterm.info>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES
 *  LOSS OF USE, DATA, OR PROFITS OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.pestcontrol

import lombok.AccessLevel
import lombok.Getter
import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import meteor.util.OverlayUtil
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D
import meteor.plugins.pestcontrol.Portal.*

@Slf4j
class PestControlOverlay(plugin: PestControlPlugin) :
    Overlay() {
    private val plugin: PestControlPlugin

    // Pest control game
    var game: Game? = null

    private var log = Logger("PestControlOverlay")

    init {
        position = OverlayPosition.DYNAMIC
        this.plugin = plugin
    }

    override fun render(graphics: Graphics2D): Dimension? {
        // See if we are in a game or not
        if (client.getWidget(WidgetInfo.PEST_CONTROL_BLUE_SHIELD) == null) {
            if (game != null) {
                log.info("Pest control game has ended")
                game = null
            }
            return null
        }
        if (game == null) {
            log.info("Pest control game has started")
            game = Game()
        }
        renderSpinners(graphics)
        renderPortalWidgets(graphics)
        return null
    }

    private fun renderSpinners(graphics: Graphics2D) {
        for (npc in plugin.spinners) {
            OverlayUtil.renderActorOverlay(graphics, npc, npc.name!!, Color.CYAN)
        }
    }

    private fun renderPortalWidgets(graphics: Graphics2D) {
        val purple: PortalContext = game!!.purple
        val blue: PortalContext = game!!.blue
        val yellow: PortalContext = game!!.yellow
        val red: PortalContext = game!!.red
        val purpleHealth: Widget = client.getWidget(PURPLE.hitpoints)!!
        val blueHealth: Widget = client.getWidget(BLUE.hitpoints)!!
        val yellowHealth: Widget = client.getWidget(YELLOW.hitpoints)!!
        val redHealth: Widget = client.getWidget(RED.hitpoints)!!

        // Check for dead portals
        if (isZero(purpleHealth)) {
            game!!.die(purple)
        }
        if (isZero(blueHealth)) {
            game!!.die(blue)
        }
        if (isZero(yellowHealth)) {
            game!!.die(yellow)
        }
        if (isZero(redHealth)) {
            game!!.die(red)
        }

        // display "ATK" overlay on recorded portals without shields
        renderAttack(graphics, purple)
        renderAttack(graphics, blue)
        renderAttack(graphics, yellow)
        renderAttack(graphics, red)

        // display "NEXT" overlay on predicted portals
        for (portal in game!!.getNextPortals()) {
            renderWidgetOverlay(graphics, portal, "NEXT", Color.ORANGE)
        }
        renderProgressWidget(graphics)
    }

    private fun renderProgressWidget(graphics: Graphics2D) {
        val bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR)!!.getChild(0)
        val bounds = bar.bounds.bounds2D
        val prgs = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_PROGRESS)!!.getChild(0)
        val perc = (prgs.bounds.getWidth() / bounds.width * 100).toInt()
        var color = Color.GREEN
        if (perc < 25) {
            color = Color.RED
        }
        val text = "$perc%"
        val fm = graphics.fontMetrics
        val textBounds = fm.getStringBounds(text, graphics)
        val x = (bounds.x - textBounds.width).toInt()
        val y = (bounds.y + fm.height - 2).toInt()
        graphics.color = Color.BLACK
        graphics.drawString(text, x + 1, y + 1)
        graphics.color = color
        graphics.drawString(text, x, y)
    }

    private fun renderWidgetOverlay(graphics: Graphics2D, portal: Portal, text: String, color: Color) {
        val shield: Widget = client.getWidget(portal.shield)!!
        val icon: Widget = client.getWidget(portal.icon)!!
        val hp: Widget = client.getWidget(portal.hitpoints)!!
        val bar = client.getWidget(WidgetInfo.PEST_CONTROL_ACTIVITY_BAR)!!.getChild(0)
        val barBounds = bar.bounds.bounds2D

        // create one rectangle from two different widget bounds
        var bounds = union(shield.bounds.bounds2D, icon.bounds.bounds2D)
        bounds = union(bounds, hp.bounds.bounds2D)
        graphics.color = color
        graphics.draw(Rectangle2D.Double(bounds.x, bounds.y - 2, bounds.width, bounds.height - 3))
        val fm = graphics.fontMetrics
        val textBounds = fm.getStringBounds(text, graphics)
        val x = (bounds.x + bounds.width / 2 - textBounds.width / 2).toInt()
        val y = (bounds.y + bounds.height + textBounds.height + barBounds.height).toInt()
        graphics.color = Color.BLACK
        graphics.drawString(text, x + 1, y + 5)
        graphics.color = color
        graphics.drawString(text, x, y + 4)
    }

    private fun renderAttack(graphics: Graphics2D, portal: PortalContext) {
        if (portal.shielded || portal.dead) { return }
        renderWidgetOverlay(graphics, portal.portal!!, "ATK", Color.RED)
    }

    companion object {
        private fun union(src1: Rectangle2D, src2: Rectangle2D): Rectangle2D {
            val x1 = Math.min(src1.minX, src2.minX)
            val y1 = Math.min(src1.minY, src2.minY)
            val x2 = Math.max(src1.maxX, src2.maxX)
            val y2 = Math.max(src1.maxY, src2.maxY)
            val result: Rectangle2D = Rectangle2D.Double()
            result.setFrameFromDiagonal(x1, y1, x2, y2)
            return result
        }

        private fun isZero(widget: Widget): Boolean {
            return widget.text.trim { it <= ' ' } == "0"
        }
    }
}