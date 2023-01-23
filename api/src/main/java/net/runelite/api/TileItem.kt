/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

import dev.hoot.api.SceneEntity
import dev.hoot.api.events.AutomatedMenu
import eventbus.Events
import meteor.api.loot.Interact
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import net.runelite.api.util.Text
import java.awt.Point
import java.util.*
import java.util.stream.Collectors

/**
 * Represents an item inside an [ItemLayer].
 */
interface TileItem : Renderable {
    companion object {
        var client: Client? = null
    }

    val quantity: Int
    val isTradable: Boolean
    val isStackable: Boolean
    val isMembers: Boolean
    val notedId: Int
    val isNoted: Boolean
    val storePrice: Int
    val inventoryActions: Array<String>
    val tile: Tile
    var index: Int
    var clickPoint: Point

    fun getId(): Int
    fun getMenu(idx: Int) : AutomatedMenu
    fun getMenu(idx: Int, opcode: Int) : AutomatedMenu
    fun getComposition() : ItemComposition
    infix fun interact(idx: Int)
    fun interact(identifier: Int, opcode: Int, param0: Int, param1: Int)

    fun interact(idx: Int, opcode: Int)
    fun getRawActions() : Array<String>
    fun getActionOpcode(id: Int) : Int
    fun getTag() : Long
    fun pickup()
    fun getName(): String?
    fun getMenu(identifier: Int, opcode: Int, param0: Int, param1: Int): AutomatedMenu? {
        return if (this is SceneEntity) {
            AutomatedMenu(
                identifier, opcode, param0, param1, -1, -1,
                (this as SceneEntity).tag
            )
        } else {
            AutomatedMenu(identifier, opcode, param0, param1, -1, -1)
        }
    }

    fun distanceTo(locatable: Locatable): Int {
        return tile.distanceTo(locatable.worldLocation)
    }

    fun distanceTo(point: WorldPoint): Int {
        return tile.distanceTo(point)
    }

    fun getWorldLocation(): WorldPoint {
        return tile.worldLocation
    }

    fun getLocalLocation(): LocalPoint {
        return tile.localLocation
    }

    fun inventoryActions(): List<String> {
        return listOf(*inventoryActions)
    }

    fun hasInventoryAction(action: String): Boolean {
        return inventoryActions().contains(action)
    }

    fun getActions(): List<String>? {
        return Arrays.stream(getRawActions()).map { str: String? ->
            Text.removeTags(
                str
            )
        }.collect(Collectors.toList())
    }

    infix fun interact(action: String) {
        if (getActions() == null) {
            return
        }
        index = arrayListOf(*getRawActions()).indexOf(action)
        if (index == -1) {
            //log.warn("Action idx not found for $action")
            return
        }
        invoke()
    }

    fun take() {
        client!!.logger.info("[Take]")
        interact("Take")
    }

    fun invoke() {
        client!!.callbacks.post(Events.INTERACT, Interact(getMenu(index)))
    }
}