/*
 * Copyright (c) 2018, Unmoon <https://github.com/Unmoon>
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
package meteor.plugins.blastmine

import com.google.common.collect.ImmutableSet
import meteor.Main
import meteor.game.ItemManager.getImage
import meteor.ui.components.ProgressPieComponent
import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.util.ColorUtil.colorWithAlpha
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class BlastMineRockOverlay internal constructor(plugin: BlastMinePlugin, config: BlastMinePluginConfig) : Overlay() {
    private val plugin: BlastMinePlugin
    private val config: BlastMinePluginConfig
    private val chiselIcon: BufferedImage?
    private val dynamiteIcon: BufferedImage?
    private val tinderboxIcon: BufferedImage?

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        this.plugin = plugin
        this.config = config
        chiselIcon = getImage(ItemID.CHISEL)
        dynamiteIcon = getImage(ItemID.DYNAMITE)
        tinderboxIcon = getImage(ItemID.TINDERBOX)
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val rocks = plugin.rocks
        if (rocks.isEmpty()) {
            return null
        }
        val tiles = client.scene.tiles
        for (rock in rocks.values) {
            if (rock.gameObject.canvasLocation == null ||
                    rock.gameObject.worldLocation.distanceTo(client.localPlayer!!.worldLocation) > MAX_DISTANCE) {
                continue
            }
            when (rock.type) {
                BlastMineRockType.NORMAL -> drawIconOnRock(graphics, rock, chiselIcon)
                BlastMineRockType.CHISELED -> drawIconOnRock(graphics, rock, dynamiteIcon)
                BlastMineRockType.LOADED -> drawIconOnRock(graphics, rock, tinderboxIcon)
                BlastMineRockType.LIT -> {
                    drawTimerOnRock(graphics, rock, config.timerColor)
                    drawAreaWarning(graphics, rock, config.warningColor, tiles)
                }

                else -> {}
            }
        }
        return null
    }

    private fun drawIconOnRock(graphics: Graphics2D, rock: BlastMineRock, icon: BufferedImage?) {
        if (!config.showRockIconOverlay()) {
            return
        }
        val loc = Perspective.getCanvasImageLocation(client, rock.gameObject.localLocation, icon!!, 150)
        if (loc != null) {
            graphics.drawImage(icon, loc.x, loc.y, null)
        }
    }

    private fun drawTimerOnRock(graphics: Graphics2D, rock: BlastMineRock, color: Color?) {
        if (!config.showTimerOverlay()) {
            return
        }
        val loc = Perspective.localToCanvas(client, rock.gameObject.localLocation, rock.gameObject.plane, 150)
        if (loc != null) {
            val timeLeft = 1 - rock.remainingFuseTimeRelative
            val pie = ProgressPieComponent()
            pie.fill = color
            pie.borderColor = color
            pie.position = loc
            pie.progress = timeLeft
            pie.render(graphics)
        }
    }

    private fun drawAreaWarning(graphics: Graphics2D, rock: BlastMineRock, color: Color?, tiles: Array<Array<Array<Tile>>>) {
        if (!config.showWarningOverlay()) {
            return
        }
        val z = client.plane
        var x = rock.gameObject.localLocation.x / Perspective.LOCAL_TILE_SIZE
        var y = rock.gameObject.localLocation.y / Perspective.LOCAL_TILE_SIZE
        val orientation = tiles[z][x][y].wallObject.orientationA
        when (orientation) {
            1 -> x--
            4 -> x++
            8 -> y--
            else -> y++
        }
        for (i in -WARNING_DISTANCE..WARNING_DISTANCE) {
            for (j in -WARNING_DISTANCE..WARNING_DISTANCE) {
                val gameObject = tiles[z][x + i][y + j].gameObjects[0]

                //check if tile is empty, or is a wall...
                if (gameObject == null || !WALL_OBJECTS.contains(gameObject.id)) {
                    val localTile = LocalPoint(
                            (x + i) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2,
                            (y + j) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_TILE_SIZE / 2)
                    val poly = Perspective.getCanvasTilePoly(client, localTile)
                    if (poly != null) {
                        graphics.color = colorWithAlpha(color!!, (color.alpha / 2.5).toInt())
                        graphics.fillPolygon(poly)
                    }
                }
            }
        }
    }

    companion object {
        private const val MAX_DISTANCE = 16
        private const val WARNING_DISTANCE = 2
        private val WALL_OBJECTS = ImmutableSet.of(
                NullObjectID.NULL_28570, NullObjectID.NULL_28571, NullObjectID.NULL_28572, NullObjectID.NULL_28573, NullObjectID.NULL_28574,
                NullObjectID.NULL_28575, NullObjectID.NULL_28576, NullObjectID.NULL_28577, NullObjectID.NULL_28578,
                ObjectID.HARD_ROCK, ObjectID.HARD_ROCK_28580, ObjectID.CAVITY, ObjectID.CAVITY_28582,
                ObjectID.POT_OF_DYNAMITE, ObjectID.POT_OF_DYNAMITE_28584, ObjectID.POT_OF_DYNAMITE_28585, ObjectID.POT_OF_DYNAMITE_28586,
                ObjectID.SHATTERED_ROCKFACE, ObjectID.SHATTERED_ROCKFACE_28588)
    }
}