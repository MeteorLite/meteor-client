/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package meteor.plugins.devtools

import meteor.game.FontManager.runescapeFont
import meteor.plugins.devtools.MovementFlag.Companion.getSetFlags
import meteor.ui.overlay.*
import meteor.util.OverlayUtil
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics2D
import java.util.function.Consumer

class DevToolsOverlay(val plugin: DevToolsPlugin) : Overlay() {
    var config = plugin.config
    var toolTipManager = TooltipManager


    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_WIDGETS
        priority = OverlayPriority.HIGHEST

    }


    override fun render(graphics: Graphics2D): Dimension? {
        graphics.font = FONT
        if (config.playersActive()) {
            renderPlayers(graphics)
        }
        if (config.npcsActive()) {
            renderNpcs(graphics)
        }
        if (config.groundItemsActive() || config.groundObjectsActive()
            || config.gameObjectsActive() || config.wallsActive()
            || config.decorationsActive() || config.tileLocationsActive()
            || config.movementFlagsActive()
        ) {
            renderTileObjects(graphics)
        }
        if (config.inventoryActive()) {
            renderInventory(graphics)
        }
        if (config.projectilesActive()) {
            renderProjectiles(graphics)
        }
        if (config.graphcisObjectsActive()) {
            renderGraphicsObjects(graphics)
        }
        if (config.roofsActive()) {
            renderRoofs(graphics)
        }
        return null
    }

    private fun renderRoofs(graphics: Graphics2D) {
        val scene = client.scene
        val tiles = scene.tiles
        val settings = client.tileSettings
        val z = client.plane
        val text = "R"
        for (x in 0 until Constants.SCENE_SIZE) {
            for (y in 0 until Constants.SCENE_SIZE) {
                val tile = tiles[z][x][y] ?: continue
                val flag = settings[z][x][y].toInt()
                if (flag and Constants.TILE_FLAG_UNDER_ROOF == 0) {
                    continue
                }
                val loc = Perspective.getCanvasTextLocation(client, graphics, tile.localLocation, text, z) ?: continue
                OverlayUtil.renderTextLocation(graphics, loc, text, Color.RED)
            }
        }
    }

    private fun renderPlayers(graphics: Graphics2D) {
        val players = client.players
        val local = client.localPlayer
        for (p in players) {
            if (p !== local) {
                val text = p.name + " (A: " + p.animation + ") (P: " + p.poseAnimation + ") (G: " + p.graphic + ")"
                OverlayUtil.renderActorOverlay(graphics, p, text, BLUE)
            }
        }
        val text =
            local!!.name + " (A: " + local.animation + ") (P: " + local.poseAnimation + ") (G: " + local.graphic + ")"
        OverlayUtil.renderActorOverlay(graphics, local, text, CYAN)
    }

    private fun renderNpcs(graphics: Graphics2D) {
        val npcs = client.npcs
        for (npc in npcs) {
            var composition = npc.composition
            var color = if (composition.combatLevel > 1) YELLOW else ORANGE
            if (composition.configs != null) {
                val transformedComposition = composition.transform()
                if (transformedComposition == null) {
                    color = GRAY
                } else {
                    composition = transformedComposition
                }
            }
            val text = composition.name + " (ID:" + composition.id + ")" +
                    " (A: " + npc.animation + ") (P: " + npc.poseAnimation + ") (G: " + npc.graphic + ")"
            OverlayUtil.renderActorOverlay(graphics, npc, text, color)
        }
    }

    private fun renderTileObjects(graphics: Graphics2D) {
        val scene = client.scene
        val tiles = scene.tiles
        val z = client.plane
        for (x in 0 until Constants.SCENE_SIZE) {
            for (y in 0 until Constants.SCENE_SIZE) {
                val tile = tiles[z][x][y] ?: continue
                val player = client.localPlayer ?: continue
                if (config.groundItemsActive()) {
                    renderGroundItems(graphics, tile, player)
                }
                if (config.groundObjectsActive()) {
                    renderTileObject(graphics, tile.groundObject, player, PURPLE)
                }
                if (config.gameObjectsActive()) {
                    renderGameObjects(graphics, tile, player)
                }
                if (config.wallsActive()) {
                    renderTileObject(graphics, tile.wallObject, player, GRAY)
                }
                if (config.decorationsActive()) {
                    renderDecorObject(graphics, tile, player)
                }
                if (config.tileLocationsActive()) {
                    renderTileTooltip(graphics, tile)
                }
                if (config.movementFlagsActive()) {
                    renderMovementInfo(graphics, tile)
                }
            }
        }
    }

    private fun renderTileTooltip(graphics: Graphics2D, tile: Tile) {
        val poly = Perspective.getCanvasTilePoly(client, tile.localLocation)
        if (poly != null && poly.contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)) {
            val worldLocation = tile.worldLocation
            val tooltip = String.format(
                "World location: ${worldLocation.x}, ${worldLocation.y}, ${worldLocation.plane}</br>" +
                        "Region ID: ${worldLocation.regionID}</br>" +
                        "location: ${worldLocation.regionX}, ${worldLocation.regionY}"
            )
            toolTipManager.add(Tooltip(tooltip))
            OverlayUtil.renderPolygon(graphics, poly, GREEN)
        }
    }

    private fun renderMovementInfo(graphics: Graphics2D, tile: Tile) {
        val poly = Perspective.getCanvasTilePoly(client, tile.localLocation)
        if (poly == null || !poly.contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)) {
            return
        }
        if (client.collisionMaps != null) {
            val flags = client.collisionMaps!![client.plane].flags
            val data = flags[tile.sceneLocation.x][tile.sceneLocation.y]
            val movementFlags: Set<MovementFlag> = getSetFlags(data)
            if (movementFlags.isEmpty()) {
                toolTipManager.add(Tooltip("No movement flags"))
            } else {
                movementFlags.forEach(Consumer { flag: MovementFlag ->

                    toolTipManager.add(
                        Tooltip(flag.toString())
                    )
                })
            }
            renderPolygon(graphics, poly, GREEN)
        }
    }


    private fun renderGroundItems(graphics: Graphics2D, tile: Tile, player: Player) {
        val itemLayer = tile.itemLayer
        if (itemLayer != null) {
            if (player.localLocation.distanceTo(itemLayer.localLocation) <= MAX_DISTANCE) {
                var current: Node = itemLayer.bottom
                while (current is TileItem) {
                    val item = current
                    OverlayUtil.renderTileOverlay(graphics, itemLayer, "ID: " + item.getId() + " Qty:" + item.quantity, RED)
                    current = current.getNext()
                }
            }
        }
    }

    private fun renderGameObjects(graphics: Graphics2D, tile: Tile, player: Player) {
        val gameObjects = tile.gameObjects
        if (gameObjects != null) {
            for (gameObject in gameObjects) {
                if (gameObject != null && gameObject.sceneMinLocation == tile.sceneLocation) {
                    renderTileObject(graphics, gameObject, player, GREEN)
                }
            }
        }
    }

    private fun renderTileObject(graphics: Graphics2D, tileObject: TileObject?, player: Player, color: Color) {
        if (tileObject != null) {
            if (player.localLocation.distanceTo(tileObject.localLocation) <= MAX_DISTANCE) {
                OverlayUtil.renderTileOverlay(graphics, tileObject, "ID: " + tileObject.id, color)
            }
        }
    }

    private fun renderDecorObject(graphics: Graphics2D, tile: Tile, player: Player) {
        val decorObject = tile.decorativeObject
        if (decorObject != null) {
            if (player.localLocation.distanceTo(decorObject.localLocation) <= MAX_DISTANCE) {
                OverlayUtil.renderTileOverlay(graphics, decorObject, "ID: " + decorObject.id, DEEP_PURPLE)
            }
            var p = decorObject.convexHull
            if (p != null) {
                graphics.draw(p)
            }
            p = decorObject.convexHull2
            if (p != null) {
                graphics.draw(p)
            }
        }
    }

    private fun renderInventory(graphics: Graphics2D) {
        val inventoryWidget = client.getWidget(WidgetInfo.INVENTORY)
        if (inventoryWidget == null || inventoryWidget.isHidden) {
            return
        }
        for (item in inventoryWidget.children!!) {
            val slotBounds = item.bounds
            var idText = "" + item.itemId
            if (idText.toInt() == 6512)
                idText = ""
            val fm = graphics.fontMetrics
            val textBounds = fm.getStringBounds(idText, graphics)
            val textX = (slotBounds.getX() + slotBounds.getWidth() / 2 - textBounds.width / 2).toInt()
            val textY = (slotBounds.getY() + slotBounds.getHeight() / 2 + textBounds.height / 2).toInt()
            graphics.color = Color(255, 255, 255, 65)
            graphics.fill(slotBounds)
            graphics.color = Color.BLACK
            graphics.drawString(idText, textX + 1, textY + 1)
            graphics.color = YELLOW
            graphics.drawString(idText, textX, textY)
        }
    }

    private fun renderProjectiles(graphics: Graphics2D) {
        val projectiles = client.projectiles
        for (projectile in projectiles) {
            val projectileId = projectile.id
            val text = "(ID: $projectileId)"
            val x = projectile.x.toInt()
            val y = projectile.y.toInt()
            val projectilePoint = LocalPoint(x, y)
            val textLocation = Perspective.getCanvasTextLocation(client, graphics, projectilePoint, text, 0)
            if (textLocation != null) {
                OverlayUtil.renderTextLocation(graphics, textLocation, text, Color.RED)
            }
        }
    }

    private fun renderGraphicsObjects(graphics: Graphics2D) {
        val graphicsObjects = client.graphicsObjects
        for (graphicsObject in graphicsObjects) {
            val lp = graphicsObject.location
            val poly = Perspective.getCanvasTilePoly(client, lp)
            if (poly != null) {
                OverlayUtil.renderPolygon(graphics, poly, Color.MAGENTA)
            }
            val infoString = "(ID: " + graphicsObject.id + ")"
            val textLocation = Perspective.getCanvasTextLocation(
                client, graphics, lp, infoString, 0
            )
            if (textLocation != null) {
                OverlayUtil.renderTextLocation(graphics, textLocation, infoString, Color.WHITE)
            }
        }
    }

    companion object {
        private val FONT = runescapeFont.deriveFont(Font.BOLD, 16f)
        private val RED = Color(221, 44, 0)
        private val GREEN = Color(0, 200, 83)
        private val ORANGE = Color(255, 109, 0)
        private val YELLOW = Color(255, 214, 0)
        private val CYAN = Color(0, 184, 212)
        private val BLUE = Color(41, 98, 255)
        private val DEEP_PURPLE = Color(98, 0, 234)
        private val PURPLE = Color(170, 0, 255)
        private val GRAY = Color(158, 158, 158)
        private const val MAX_DISTANCE = 2400
    }
}