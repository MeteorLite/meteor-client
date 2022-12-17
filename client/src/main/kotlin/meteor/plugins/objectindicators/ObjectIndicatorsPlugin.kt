/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.plugins.objectindicators

import com.google.common.base.Strings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import eventbus.events.*
import meteor.Logger
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import java.util.stream.Collectors

@PluginDescriptor(
    name = "Object Markers",
    description = "Enable marking of objects using the Shift key",
    tags = ["overlay", "objects", "mark", "marker"],
    enabledByDefault = false
)
class ObjectIndicatorsPlugin : Plugin() {
    var log = Logger("Object Markers")
    internal val objects: MutableList<ColorTileObject> = ArrayList()
    private val points: MutableMap<Int, MutableSet<ObjectPoint>> = HashMap()

    private val overlay = overlay(ObjectIndicatorsOverlay(this))

    val config = configuration<ObjectIndicatorsConfig>()

    private val gson = Gson()
    override fun onStop() {
        points.clear()
        //objects.clear()
    }

    override fun onWallObjectSpawned(it: WallObjectSpawned) {
        checkObjectPoints(it.wallObject)
    }

    override fun onWallObjectChanged(it: WallObjectChanged) {
        val previous: WallObject = it.previous
        val wallObject: WallObject = it.wallObject
        objects.removeIf { o: ColorTileObject -> o.tileObject == previous }
        checkObjectPoints(wallObject)
    }

    override fun onWallObjectDespawned(it: WallObjectDespawned) {
        objects.removeIf { o: ColorTileObject -> o.tileObject == it.wallObject }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        checkObjectPoints(it.gameObject)
    }

    override fun onDecorativeObjectSpawned(it: DecorativeObjectSpawned) {
        checkObjectPoints(it.decorativeObject)
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        objects.removeIf { o: ColorTileObject -> o.tileObject == it.gameObject }
    }

    override fun onDecorativeObjectDespawned(it: DecorativeObjectDespawned) {
        objects.removeIf { o: ColorTileObject -> o.tileObject == it.decorativeObject }
    }

    override fun onGroundObjectSpawned(it: GroundObjectSpawned) {
        checkObjectPoints(it.groundObject)
    }

    override fun onGroundObjectDespawned(it: GroundObjectDespawned) {
        objects.removeIf { o: ColorTileObject -> o.tileObject == it.groundObject }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        val gameState: GameState = it.gameState
        if (gameState == GameState.LOADING) {
            // Reload points with new map regions
            points.clear()
            for (regionId in client.mapRegions) {
                // load points for region
                val regionPoints = loadPoints(regionId)
                if (regionPoints != null) {
                    points[regionId] = regionPoints
                }
            }
        }
        if (it.gameState != GameState.LOGGED_IN && it.gameState != GameState.CONNECTION_LOST) {
            objects.clear()
        }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (it.opcode != MenuAction.EXAMINE_OBJECT.id || !client.isKeyPressed(KeyCode.KC_SHIFT)) {
            return
        }
        val tile: Tile = client.scene.tiles[client.plane][it.param0][it.param1]
        val tileObject: TileObject = findTileObject(tile, it.identifier) ?: return
        client.createMenuEntry(-1)
            .setOption(
                if (objects.stream().anyMatch { it.tileObject == tileObject }) UNMARK else MARK
            )
            .setTarget(it.target)
            .setParam0(it.param0)
            .setParam1(it.param1)
            .setIdentifier(it.identifier)
            .setType(MenuAction.RUNELITE)
            .onClick { entry: MenuEntry? ->
                if (entry != null) {
                    this.markObject(entry)
                }
            }
    }

    private fun markObject(entry: MenuEntry) {
        val scene: Scene = client.scene
        val tiles: Array<Array<Array<Tile>>> = scene.tiles
        val x: Int = entry.param0
        val y: Int = entry.param1
        val z = client.plane
        val tile: Tile = tiles[z][x][y]
        val obj: TileObject = findTileObject(tile, entry.identifier) ?: return

        // object.getId() is always the base object id, getObjectComposition transforms it to
        // the correct object we see
        val objectDefinition: ObjectComposition? = getObjectComposition(obj.id)
        val name: String? = objectDefinition?.name
        // Name is probably never "null" - however prevent adding it if it is, as it will
        // become ambiguous as objects with no name are assigned name "null"
        if (Strings.isNullOrEmpty(name) || name == "null") {
            return
        }
        if (objectDefinition != null) {
            markObject(objectDefinition, name!!, obj)
        }
    }

    private fun checkObjectPoints(obj: TileObject) {
        val worldPoint: WorldPoint =
            WorldPoint.fromLocalInstance(client, obj.localLocation, obj.plane)
        val objectPoints = points[worldPoint.regionID] ?: return
        val objectComposition: ObjectComposition = client.getObjectDefinition(obj.id)
        if (objectComposition.impostorIds == null) {
            // Multiloc names are instead checked in the overlay
            val name: String = objectComposition.name
            if (Strings.isNullOrEmpty(name) || name == "null") {
                // was marked, but name has changed
                return
            }
        }
        for (objectPoint in objectPoints) {
            if (worldPoint.regionX == objectPoint.regionX && worldPoint.regionY == objectPoint.regionY && worldPoint.plane == objectPoint.z && objectPoint.id == obj.id) {
                log.debug("Marking object {} due to matching {}", obj, objectPoint)
                objects.add(
                    ColorTileObject(
                        obj,
                        objectComposition,
                        objectPoint.name,
                        objectPoint.color
                    )
                )
                break
            }
        }
    }

    private fun findTileObject(tile: Tile?, id: Int): TileObject? {
        if (tile == null) {
            return null
        }
        val tileGameObjects: Array<GameObject>? = tile.gameObjects
        val tileDecorativeObject: DecorativeObject? = tile.decorativeObject
        val tileWallObject: WallObject? = tile.wallObject
        val groundObject: GroundObject? = tile.groundObject
        when {
            objectIdEquals(tileWallObject, id) -> {
                return tileWallObject
            }
            objectIdEquals(tileDecorativeObject, id) -> {
                return tileDecorativeObject
            }
            objectIdEquals(groundObject, id) -> {
                return groundObject
            }
            else -> {
                tileGameObjects!!.forEach { obj ->
                    if (objectIdEquals(obj, id)) {
                        return obj
                    }
                }
                return null
            }
        }
    }

    private fun objectIdEquals(tileObject: TileObject?, id: Int): Boolean {
        if (tileObject == null) {
            return false
        }
        if (tileObject.id == id) {
            return true
        }

        // Menu action EXAMINE_OBJECT sends the transformed object id, not the base id, unlike
        // all of the GAME_OBJECT_OPTION actions, so check the id against the impostor ids
        val comp: ObjectComposition = client.getObjectDefinition(tileObject.id)
        if (comp.impostorIds != null) {
            comp.impostorIds.forEach {
                if (it == id) {
                    return true
                }
            }
        }
        return false
    }

    /** mark or unmark an object
     *
     * @param objectComposition transformed composition of object based on vars
     * @param name name of objectComposition
     * @param `object` tile object, for multilocs object.getId() is the base id
     */
    private fun markObject(objectComposition: ObjectComposition, name: String, obj: TileObject) {
        val worldPoint: WorldPoint = WorldPoint.fromLocalInstance(client, obj.localLocation)
        val regionId: Int = worldPoint.regionID
        val color = config.markerColor()
        val point = ObjectPoint(
            obj.id,
            name,
            regionId,
            worldPoint.regionX,
            worldPoint.regionY,
            worldPoint.plane,
            color
        )
        val objectPoints = points.computeIfAbsent(regionId) { HashSet() }
        if (objects.removeIf { o: ColorTileObject -> o.tileObject === obj }) {
            // Find the object point that caused this object to be marked, there are two cases:
            // 1) object is a multiloc, the name may have changed since marking - match from base id
            // 2) not a multiloc, but an object has spawned with an identical name and a different
            //    id as what was originally marked
            if (!objectPoints.removeIf { op: ObjectPoint -> op.id == -1 || op.id == obj.id || op.name == objectComposition.name && op.regionX == worldPoint.regionX && op.regionY == worldPoint.regionY && op.z == worldPoint.plane }) {
                log.warn("unable to find object point for unmarked object {}", obj.id)
            }
            log.debug("Unmarking object: {}", point)
        } else {
            objectPoints.add(point)
            objects.add(
                ColorTileObject(
                    obj,
                    client.getObjectDefinition(obj.id),
                    name,
                    color
                )
            )
            log.debug("Marking object: {}", point)
        }
        savePoints(regionId, objectPoints)
    }

    private fun savePoints(id: Int, points: Set<ObjectPoint>) {
        if (points.isEmpty()) {
            ConfigManager.unsetConfiguration(CONFIG_GROUP, "region_$id")
        } else {
            val json = gson.toJson(points)
            ConfigManager.setConfiguration(CONFIG_GROUP, "region_$id", json)
        }
    }

    private fun loadPoints(id: Int): MutableSet<ObjectPoint>? {
        val json: String? = ConfigManager.getConfiguration(CONFIG_GROUP, "region_$id")
        if (Strings.isNullOrEmpty(json)) {
            return null
        }
        val points = gson.fromJson<Set<ObjectPoint>>(json, object : TypeToken<Set<ObjectPoint?>?>() {}.type)
        // Prior to multiloc support the plugin would mark objects named "null", which breaks
        // in most cases due to the specific object being identified being ambiguous, so remove
        // them
        return points.stream()
            .filter { point: ObjectPoint -> point.name != "null" }
            .collect(Collectors.toSet())
    }

    private fun getObjectComposition(id: Int): ObjectComposition? {
        val objectComposition: ObjectComposition = client.getObjectDefinition(id)
        return if (objectComposition.impostorIds == null) objectComposition else objectComposition.impostor
    }

    companion object {
        private const val CONFIG_GROUP = "objectindicators"
        private const val MARK = "Mark object"
        private const val UNMARK = "Unmark object"
    }
}