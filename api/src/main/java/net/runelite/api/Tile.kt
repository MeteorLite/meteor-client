/*
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
package net.runelite.api

import dev.hoot.api.util.Randomizer
import java.util.*

/**
 * Represents a tile in the game.
 */
interface Tile : Locatable {
    /**
     * Gets the decoration on the tile.
     *
     * @return the tile decoration
     */
    /**
     * Sets the object on the decorative layer of the tile.
     *
     * @param decorativeObject the decorative object
     */
    var decorativeObject: DecorativeObject?

    /**
     * Gets all game objects on the tile.
     *
     * @return the game objects
     */
    val gameObjects: Array<GameObject?>

    /**
     * Gets the items held on this tile.
     *
     * @return the item
     */
    val itemLayer: ItemLayer?
    /**
     * Gets the object on the ground layer of the tile.
     *
     * @return the ground object
     */
    /**
     * Sets the object on the ground layer of the tile.
     *
     * @param groundObject the ground object
     */
    var groundObject: GroundObject?
    /**
     * Gets the wall of the tile.
     *
     * @return the wall object
     */
    /**
     * Sets the object on the wall layer of the tile.
     *
     * @param wallObject the ground object
     */
    var wallObject: WallObject?

    /**
     * Gets the scene paint of the tile.
     *
     * @return the paint
     */
    val sceneTilePaint: SceneTilePaint?

    /**
     * Gets the model of the tile in the scene.
     *
     * @return the tile model
     */
    val sceneTileModel: SceneTileModel?

    /**
     * Gets the location coordinate of the tile in scene coords
     *
     * @return the scene location
     */
    val sceneLocation: Point

    /**
     * Gets the plane that this tile is on.
     *
     * @return the plane
     */
    val plane: Int

    /**
     * Get the plane this tile is rendered on, which is where the tile heights are from.
     *
     * @return
     */
    val renderLevel: Int

    /**
     * Get the minimum plane this tile will be rendered on.
     * Example: This tile is on plane 1. The local player is on plane 0, and hide roofs option is turned on.
     * If minPlane is 0, this tile will not be rendered.
     * If minPlane is 1, this tile will be rendered.
     *
     * @return the minPlane
     */
    val physicalLevel: Int

    /**
     * Computes and returns whether this tile has line of sight to another.
     *
     * @param other the other tile
     * @return true if there is no sight obstruction, false otherwise
     */
    fun hasLineOfSightTo(other: Tile?): Boolean

    /**
     * Computes and returns the path from this tile to another.
     *
     * @param other the other tile
     * @return the checkpoint tiles of the path, or null if no path found
     */
    fun pathTo(other: Tile): List<Tile?>

    /**
     * Get all the ground items for this tile
     *
     * @return the ground items
     */
    val groundItems: List<TileItem>

    /**
     * Return the tile under this one, if this tile is a bridge
     */
    val bridge: Tile?
    fun walkHere()
    val worldX: Int
    val worldY: Int
    override fun getClickPoint(): java.awt.Point {
        val tileArea = Perspective.getCanvasTilePoly(client!!, localLocation)
        localLocation
        var rand = Random()
        tileArea?.let {
            val r = tileArea.bounds
            var humanizedPoint: java.awt.Point
            do {
                humanizedPoint = Randomizer.getHumanizedRandomPointIn(r)
            } while (!tileArea.contains(humanizedPoint.x, humanizedPoint.y))
            if (humanizedPoint.x < 0)
                humanizedPoint.x = rand.nextInt(client!!.stretchedDimensions.width)
            if (humanizedPoint.x > client!!.stretchedDimensions.width)
                humanizedPoint.x = rand.nextInt(client!!.stretchedDimensions.width)
            if (humanizedPoint.y < 0)
                humanizedPoint.y = rand.nextInt(client!!.stretchedDimensions.height)
            if (humanizedPoint.y > client!!.stretchedDimensions.height)
                humanizedPoint.y = rand.nextInt(client!!.stretchedDimensions.height)
            return humanizedPoint
        }
        return java.awt.Point(0, 0)
    }

    companion object {
        var client: Client? = null
    }
}