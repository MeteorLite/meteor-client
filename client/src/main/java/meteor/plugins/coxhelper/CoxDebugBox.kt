/*
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package meteor.plugins.coxhelper

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.ui.overlay.PanelComponent
import meteor.ui.table.TableAlignment
import meteor.ui.table.TableComponent

import java.awt.Dimension
import java.awt.Graphics2D

class CoxDebugBox(

    private val plugin: CoxPlugin


) : Overlay() {
    var config = plugin.config
    private val olm = Olm
    private val panelComponent: PanelComponent = PanelComponent()

    init {
        position = OverlayPosition.BOTTOM_LEFT
        priority = OverlayPriority.HIGH
        panelComponent.setPreferredSize(Dimension(270, 0))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (!config.olmDebug() || !plugin.inRaid()) {
            return null
        }
        panelComponent.children.clear()
        val tableComponent = TableComponent()
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT)
        tableComponent.addRow("ticks", client.tickCount.toString())
        tableComponent.addRow("active", Olm.active.toString())
        tableComponent.addRow("handAnim", Olm.handAnimation.toString())
        tableComponent.addRow("headAnim", Olm.headAnimation.toString())
        tableComponent.addRow("firstPhase", Olm.firstPhase.toString())
        tableComponent.addRow("finalPhase", Olm.finalPhase.toString())
        tableComponent.addRow("attackTicks", Olm.ticksUntilNextAttack.toString())
        tableComponent.addRow("attackCycle", Olm.attackCycle.toString())
        tableComponent.addRow("specialCycle", Olm.specialCycle.toString())
        tableComponent.addRow("portalTicks", Olm.portalTicks.toString())
        tableComponent.addRow("handCrippled", Olm.crippled.toString())
        tableComponent.addRow("crippleTicks", Olm.crippleTicks.toString())
        panelComponent.children.add(tableComponent)
        return panelComponent.render(graphics)
    }
}