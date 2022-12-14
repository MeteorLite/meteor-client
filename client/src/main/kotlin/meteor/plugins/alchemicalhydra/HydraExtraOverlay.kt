package meteor.plugins.alchemicalhydra

import meteor.game.FontManager.runescapeBoldFont
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.OverlayUtil
import net.runelite.api.Perspective
import net.runelite.api.Point
import net.runelite.api.coords.LocalPoint
import meteor.plugins.alchemicalhydra.HydraConfig.ImmunityMode
import meteor.plugins.alchemicalhydra.HydraConfig.LightningMode
import ui.overlay.outline.ModelOutlineRenderer
import java.awt.*
import java.awt.image.BufferedImage
import java.awt.image.ImageObserver

class HydraExtraOverlay(
    private val plugin: AlchemicalHydraPlugin,
    private val config: HydraConfig,
    private val modelOutlineRenderer: ModelOutlineRenderer
) : Overlay() {
    init {
        position = OverlayPosition.DYNAMIC
        priority = OverlayPriority.HIGH
        layer = OverlayLayer.ABOVE_SCENE
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (config.hydraImmunityOutline() == ImmunityMode.HULL && plugin.immuneActive && plugin.hydra?.npc != null) {
            val poly = plugin.hydra?.npc!!.convexHull
            if (poly != null) {
                val color = config.hydraImmunityColor()
                val strokeWidth = config.hydraImmunityWidth()
                val outlineAlpha = 255
                val fillAlpha = 0
                graphics.color = Color(color!!.red, color.green, color.blue, outlineAlpha)
                graphics.stroke = BasicStroke(strokeWidth.toFloat())
                graphics.draw(poly)
                graphics.color = Color(color.red, color.green, color.blue, fillAlpha)
                graphics.fill(poly)
            }
        } else if (config.hydraImmunityOutline() == ImmunityMode.OUTLINE && plugin.immuneActive && plugin.hydra != null) {
            val color = config.hydraImmunityColor()
            modelOutlineRenderer.drawOutline(
                plugin.hydra!!.npc,
                config.hydraImmunityWidth(),
                color,
                config.hydraImmunityGlow()
            )
        }
        if (config.lightningHighlight() != LightningMode.OFF && plugin.hydra != null) {
            for (obj in this.client.graphicsObjects) {
                if (obj.id == 1666) {
                    val size = 1
                    var lp = obj.location
                    if (config.lightningHighlight() == LightningMode.TRUE_LOCATION) {
                        if (lp != null) {
                            lp = LocalPoint(lp.x + size * 128 / 2 - 64, lp.y + size * 128 / 2 - 64)
                            val tilePoly = Perspective.getCanvasTileAreaPoly(this.client, lp, size)
                            if (tilePoly != null) {
                                renderPoly(graphics, config.lightningColor(), tilePoly, config.lightningWidth())
                            }
                        }
                    } else {
                        modelOutlineRenderer.drawOutline(
                            obj,
                            config.lightningWidth(),
                            config.lightningColor(),
                            config.lightningGlow()
                        )
                    }
                }
            }
        }
        if (config.ventTicks() && plugin.ventTicks > 0 && plugin.hydra != null && this.client.isInInstancedRegion) {
            val text = plugin.ventTicks.toString()
            val oldFont = graphics.font
            graphics.font = runescapeBoldFont
            val color = Color.WHITE
            if (plugin.redVent != null && plugin.hydra!!.npc.id == 8615) {
                val textLoc = plugin.redVent!!.getCanvasTextLocation(graphics, text, 25)
                val pointShadow = Point(textLoc.x + 1, textLoc.y + 1)
                OverlayUtil.renderTextLocation(graphics, pointShadow, text, Color.BLACK)
                OverlayUtil.renderTextLocation(graphics, textLoc, text, color)
            } else if (plugin.greenVent != null && (plugin.hydra!!.npc.id == 8619 || plugin.hydra!!.npc.id == 8616)) {
                val textLoc = plugin.greenVent!!.getCanvasTextLocation(graphics, text, 25)
                val pointShadow = Point(textLoc.x + 1, textLoc.y + 1)
                OverlayUtil.renderTextLocation(graphics, pointShadow, text, Color.BLACK)
                OverlayUtil.renderTextLocation(graphics, textLoc, text, color)
            } else if (plugin.blueVent != null && (plugin.hydra!!.npc.id == 8620 || plugin.hydra!!.npc.id == 8617)) {
                val textLoc = plugin.blueVent!!.getCanvasTextLocation(graphics, text, 25)
                val pointShadow = Point(textLoc.x + 1, textLoc.y + 1)
                OverlayUtil.renderTextLocation(graphics, pointShadow, text, Color.BLACK)
                OverlayUtil.renderTextLocation(graphics, textLoc, text, color)
            }
            graphics.font = oldFont
        }
        if (config.showHpUntilPhaseChange() && plugin.hydra != null) {
            if (plugin.hydra!!.npc.id != 8621 && plugin.hydra!!.npc.id != 8616 && plugin.hydra!!.npc.id != 8617 && plugin.hydra!!.npc.id != 8618) {
                val npc = plugin.hydra!!.npc
                var healthThreshold = 0
                when (plugin.hydra!!.npc.id) {
                    8615 -> healthThreshold = 825
                    8619 -> healthThreshold = 550
                    8620 -> healthThreshold = 275
                }
                val ratio = npc.healthRatio
                val health = npc.healthScale
                if (ratio < 0 || health <= 0) {
                    return null
                }
                var exactHealth = 0
                if (ratio > 0) {
                    var minHealth = 1
                    var maxHealth: Int
                    if (health > 1) {
                        if (ratio > 1) {
                            minHealth = (1100 * (ratio - 1) + health - 2) / (health - 1)
                        }
                        maxHealth = (1100 * ratio - 1) / (health - 1)
                        if (maxHealth > 1100) {
                            maxHealth = 1100
                        }
                    } else {
                        maxHealth = 1100
                    }
                    exactHealth = (minHealth + maxHealth + 1) / 2
                }
                val hpLeft = exactHealth - healthThreshold
                var textColor = Color.WHITE
                if (hpLeft <= 83) {
                    textColor = Color.RED
                }
                val text = hpLeft.toString()
                val textLoc = plugin.hydra!!.npc.getCanvasTextLocation(graphics, text, 75)
                if (textLoc != null) {
                    val oldFont = graphics.font
                    graphics.font = runescapeBoldFont
                    val pointShadow = Point(textLoc.x + 1, textLoc.y + 1)
                    OverlayUtil.renderTextLocation(graphics, pointShadow, text, Color.BLACK)
                    OverlayUtil.renderTextLocation(graphics, textLoc, text, textColor!!)
                    graphics.font = oldFont
                }
            }
        }
        return null
    }

    private fun renderPoly(graphics: Graphics2D, color: Color?, polygon: Shape?, width: Int) {
        if (polygon != null) {
            graphics.color = color
            graphics.stroke = BasicStroke(width.toFloat())
            graphics.draw(polygon)
            graphics.color = Color(color!!.red, color.green, color.blue, 0)
            graphics.fill(polygon)
        }
    }

    override fun renderTextLocation( graphics: Graphics2D, txtLoc: Point, text: String, color: Color) {
        if (text.isEmpty()) return
        val x = txtLoc.x
        val y = txtLoc.y
        graphics.color = Color.BLACK
        run {
            graphics.drawString(text, x, y + 1)
            graphics.drawString(text, x, y - 1)
            graphics.drawString(text, x + 1, y)
            graphics.drawString(text, x - 1, y)
        }
        graphics.color = Color(color.red, color.green, color.blue)
        graphics.drawString(text, x, y)
    }

    override fun renderImageLocation(graphics: Graphics2D, imgLoc: Point, image: BufferedImage) {
        val x = imgLoc.x
        val y = imgLoc.y
        graphics.drawImage(image, x, y, null as ImageObserver?)
    }
}