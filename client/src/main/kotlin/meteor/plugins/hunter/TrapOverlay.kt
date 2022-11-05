/*
 * Copyright (c) 2017, Robin Weymans <Robin.weymans@gmail.com>
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
package meteor.plugins.hunter

import meteor.ui.components.ProgressPieComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.ColorUtil.colorWithAlpha
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import javax.inject.Inject

/**
 * Represents the overlay that shows timers on traps that are placed by the player.
 */
class TrapOverlay( plugin: HunterPlugin, config: HunterConfig) : Overlay() {

    private val plugin: HunterPlugin
    private val config: HunterConfig
    private var colorOpen: Color? = null
    private var colorOpenBorder: Color? = null
    private var colorEmpty: Color? = null
    private var colorEmptyBorder: Color? = null
    private var colorFull: Color? = null
    private var colorFullBorder: Color? = null
    private var colorTrans: Color? = null
    private var colorTransBorder: Color? = null

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        this.plugin = plugin
        this.config = config
    }

    override fun render(graphics: Graphics2D): Dimension? {
        drawTraps(graphics)
        return null
    }

    /**
     * Updates the timer colors.
     */
    fun updateConfig() {
        colorEmptyBorder = config.getEmptyTrapColor()
        colorEmpty = colorWithAlpha(colorEmptyBorder!!, (colorEmptyBorder!!.alpha / 2.5).toInt())
        colorFullBorder = config.getFullTrapColor()
        colorFull = colorWithAlpha(colorFullBorder!!, (colorFullBorder!!.alpha / 2.5).toInt())
        colorOpenBorder = config.getOpenTrapColor()
        colorOpen = colorWithAlpha(colorOpenBorder!!, (colorOpenBorder!!.alpha / 2.5).toInt())
        colorTransBorder = config.getTransTrapColor()
        colorTrans = colorWithAlpha(colorTransBorder!!, (colorTransBorder!!.alpha / 2.5).toInt())
    }

    /**
     * Iterates over all the traps that were placed by the local player, and draws a circle or a timer
     * on the trap, depending on the trap interactState.
     *
     * @param graphics
     */
    private fun drawTraps(graphics: Graphics2D) {
        for ((_, trap) in plugin.traps) {
            when (trap.state) {
                HunterTrap.State.OPEN -> drawTimerOnTrap(
                    graphics,
                    trap,
                    colorOpen,
                    colorOpenBorder,
                    colorEmpty,
                    colorOpenBorder
                )
                HunterTrap.State.EMPTY -> drawTimerOnTrap(
                    graphics, trap, colorEmpty, colorEmptyBorder, colorEmpty,
                    colorEmptyBorder
                )
                HunterTrap.State.FULL -> drawTimerOnTrap(
                    graphics,
                    trap,
                    colorFull,
                    colorFullBorder,
                    colorFull,
                    colorFullBorder
                )
                HunterTrap.State.TRANSITION -> drawCircleOnTrap(graphics, trap, colorTrans, colorTransBorder)
            }
        }
    }

    /**
     * Draws a timer on a given trap.
     *
     * @param graphics
     * @param trap          The trap on which the timer needs to be drawn
     * @param fill          The fill color of the timer
     * @param border        The border color of the timer
     * @param fillTimeLow   The fill color of the timer when it is low
     * @param borderTimeLow The border color of the timer when it is low
     */
    private fun drawTimerOnTrap(
        graphics: Graphics2D, trap: HunterTrap, fill: Color?, border: Color?,
        fillTimeLow: Color?, borderTimeLow: Color?
    ) {
        if (trap.worldLocation.plane != client.plane) {
            return
        }
        val localLoc = LocalPoint.fromWorld(client, trap.worldLocation) ?: return
        val loc = Perspective.localToCanvas(client, localLoc, client.plane) ?: return
        val timeLeft = 1 - trap.trapTimeRelative
        val pie = ProgressPieComponent()
        pie.fill = if (timeLeft > TIMER_LOW) fill else fillTimeLow
        pie.borderColor = if (timeLeft > TIMER_LOW) border else borderTimeLow
        pie.position = loc
        pie.progress = timeLeft
        pie.render(graphics)
    }

    /**
     * Draws a timer on a given trap.
     *
     * @param graphics
     * @param trap     The trap on which the timer needs to be drawn
     * @param fill     The fill color of the timer
     * @param border   The border color of the timer
     */
    private fun drawCircleOnTrap(graphics: Graphics2D, trap: HunterTrap, fill: Color?, border: Color?) {
        if (trap.worldLocation.plane != client.plane) {
            return
        }
        val localLoc = LocalPoint.fromWorld(client, trap.worldLocation) ?: return
        val loc = Perspective.localToCanvas(client, localLoc, client.plane)
        val pie = ProgressPieComponent()
        pie.fill = fill
        pie.borderColor = border
        pie.position = loc
        pie.progress = 1.0
        pie.render(graphics)
    }

    companion object {
        /**
         * The timer is low when only 25% is left.
         */
        private const val TIMER_LOW = 0.25 // When the timer is under a quarter left, if turns red.
    }
}