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

import meteor.game.SpriteManager
import meteor.ui.components.ComponentConstants
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.ui.overlay.PanelComponent
import meteor.ui.overlay.components.InfoBoxComponent
import meteor.ui.overlay.components.TitleComponent
import meteor.ui.table.TableAlignment
import meteor.ui.table.TableComponent
import meteor.util.ColorUtil
import meteor.util.ImageUtil
import net.runelite.api.Client
import net.runelite.api.NpcID
import net.runelite.api.Prayer
import net.runelite.api.SpriteID

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.image.BufferedImage


class CoxInfoBox(
    private val plugin: CoxPlugin,
) : Overlay() {
    var config = plugin.configuration<CoxConfig>()
    private val olm = Olm
    private val spriteManager = SpriteManager
    private val prayAgainstPanel: PanelComponent = PanelComponent()
    private val panelComponent: PanelComponent = PanelComponent()

    init {

        position = OverlayPosition.BOTTOM_RIGHT
        priority = OverlayPriority.HIGH
    }

    override fun render(graphics: Graphics2D): Dimension? {
        panelComponent.children.clear()
        if (plugin.inRaid()) {
            prayAgainstPanel.children.clear()
            val prayer = Olm.prayer
            if (System.currentTimeMillis() < Olm.lastPrayTime + 120000 && prayer != null && config.prayAgainstOlm()) {
                val scale = config.prayAgainstOlmSize()
                val prayComponent = InfoBoxComponent()
                val prayImg: BufferedImage = ImageUtil.resizeImage(
                    getPrayerImage(Olm.prayer!!)!!, scale, scale
                )
                prayComponent.image = prayImg
                prayComponent.color = Color.WHITE
                prayComponent.backgroundColor =
                    if (client.isPrayerActive(prayer)) ComponentConstants.STANDARD_BACKGROUND_COLOR else NOT_ACTIVATED_BACKGROUND_COLOR
                prayComponent.setPreferredSize(Dimension(scale + 4, scale + 4))
                prayAgainstPanel.children.add(prayComponent)
                prayAgainstPanel.setPreferredSize(Dimension(scale + 4, scale + 4))
                prayAgainstPanel.border = Rectangle(0, 0, 0, 0)
                return prayAgainstPanel.render(graphics)
            } else {
                Olm.prayer = null
            }
            if (config.vangHealth() && plugin.vanguards > 0) {
                panelComponent.children.add(
                    TitleComponent.Builder()
                        .text("Vanguards")
                        .color(Color.pink)
                        .build()
                )
                val tableComponent = TableComponent()
                tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT)
                for (npcs in plugin.npcContainers.values) {
                    val percent = npcs!!.npc.healthRatio.toFloat() / npcs.npc.healthScale * 100
                    when (npcs.npc.id) {
                        NpcID.VANGUARD_7527 -> tableComponent.addRow(
                            ColorUtil.prependColorTag("Melee", npcs.attackStyle.color!!),
                            percent.toInt().toString()
                        )
                        NpcID.VANGUARD_7528 -> tableComponent.addRow(
                            ColorUtil.prependColorTag("Range", npcs.attackStyle.color!!),
                            percent.toInt().toString()
                        )
                        NpcID.VANGUARD_7529 -> tableComponent.addRow(
                            ColorUtil.prependColorTag("Mage", npcs.attackStyle.color!!),
                            percent.toInt().toString()
                        )
                    }
                }
                panelComponent.children.add(tableComponent)
                return panelComponent.render(graphics)
            }
        }
        if (client.localPlayer!!.worldLocation.regionID == 4919) {
            Olm.prayer = null
        }
        return null
    }

    private fun getPrayerImage(prayer: Prayer): BufferedImage? {
        return when (prayer) {
            Prayer.PROTECT_FROM_MAGIC -> spriteManager.getSprite(
                SpriteID.PRAYER_PROTECT_FROM_MAGIC,
                0
            )
            Prayer.PROTECT_FROM_MELEE -> spriteManager.getSprite(
                SpriteID.PRAYER_PROTECT_FROM_MELEE,
                0
            )
            Prayer.PROTECT_FROM_MISSILES -> spriteManager.getSprite(
                SpriteID.PRAYER_PROTECT_FROM_MISSILES,
                0
            )
            else -> spriteManager.getSprite(SpriteID.BARBARIAN_ASSAULT_EAR_ICON, 0)
        }
    }

    companion object {
        private val NOT_ACTIVATED_BACKGROUND_COLOR = Color(150, 0, 0, 150)
    }
}