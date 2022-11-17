/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.cannonreloader

import com.google.common.collect.ImmutableList
import eventbus.events.*
import meteor.Main
import meteor.game.ItemManager
import meteor.game.SpriteManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.ui.overlay.infobox.InfoBoxPriority
import meteor.ui.overlay.infobox.LoopTimer
import meteor.util.QuantityFormatter.formatNumber
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import net.runelite.client.chat.ChatColorType
import net.runelite.client.chat.ChatMessageBuilder
import meteor.chat.QueuedMessage
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import org.apache.commons.lang3.ArrayUtils
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.regex.Pattern


//import kotlin.random.Random

@PluginDescriptor(name = "CannonReloader", description = "Reloads cannon", tags = ["combat", "minigame", "bosses", "pve", "pvm"])
class CannonReloaderPlugin : Plugin() {

    private val NUMBER_PATTERN = Pattern.compile("([0-9]+)")
    private val MAX_CBALLS = 30
    private val MAX_DISTANCE = 2500
    private var nextReloadCount = 10
    private var skipProjectileCheckThisTick = false

    private var cballsLeft = 0

    private val r = Random()

    private var cannonPlaced = false
    private var cannonPosition: WorldPoint? = null
    private var cannon: GameObject? = null
    private var tickDelay = 0
    private val clientThread = ClientThread
    val config = configuration<CannonReloaderConfig>()


    override fun onStart() {
    nextReloadCount = r.nextInt(config.maxReloadAmount() - config.minReloadAmount()) + config.minReloadAmount()
    }

    override fun onStop() {
        cannonPlaced = false
        cannonPosition = null
        cballsLeft = 0
        skipProjectileCheckThisTick = false
    }


    override fun onGameObjectSpawned(event: GameObjectSpawned) {
        val gameObject = event.gameObject
        val localPlayer = client.localPlayer
        if (gameObject.id == ObjectID.CANNON_BASE && !cannonPlaced) {
            if (localPlayer != null && localPlayer.worldLocation.distanceTo(gameObject.worldLocation) <= 2 && localPlayer.animation == AnimationID.BURYING_BONES) {
                cannonPosition = gameObject.worldLocation
                cannon = gameObject
            }
        }
        //Object ID = 14916
        if (gameObject.id == ObjectID.BROKEN_MULTICANNON_14916 && cannonPlaced) {
            if (cannonPosition == gameObject.worldLocation) {
                clientThread.invoke {
                    client.invokeMenuAction(
                        "Repair",
                        "<col=ffff>Broken multicannon",
                        gameObject.id,
                        MenuAction.GAME_OBJECT_FIRST_OPTION.id,
                        cannon!!.sceneMinLocation.x,
                        cannon!!.sceneMinLocation.y
                    )
                }
                tickDelay = 3
            }
        }
    }

    override fun onProjectileMoved(event: ProjectileMoved) {
        val projectile = event.projectile
        if ((projectile.id == ProjectileID.CANNONBALL || projectile.id == ProjectileID.GRANITE_CANNONBALL) && cannonPosition != null) {
            val projectileLoc = WorldPoint.fromLocal(client, projectile.x1, projectile.y1, client.plane)

            //Check to see if projectile x,y is 0 else it will continuously decrease while ball is flying.
            if (projectileLoc == cannonPosition && projectile.x == 0.0 && projectile.y == 0.0) {
                // When there's a chat message about cannon reloaded/unloaded/out of ammo,
                // the message event runs before the projectile event. However they run
                // in the opposite order on the server. So if both fires in the same tick,
                // we don't want to update the cannonball counter if it was set to a specific
                // amount.
                if (!skipProjectileCheckThisTick) {
                    cballsLeft--
                }
            }
        }
    }
    override fun onChatMessage(event: ChatMessage) {
        if (event.type != ChatMessageType.SPAM && event.type != ChatMessageType.GAMEMESSAGE) {
            return
        }
        if (event.message == "You add the furnace.") {
            cannonPlaced = true
            cballsLeft = 0
        }
        if (event.message.contains("You pick up the cannon")) {
            cannonPlaced = false
            cballsLeft = 0
        }
        if (event.message.startsWith("You load the cannon with")) {
            nextReloadCount = r.nextInt(config.maxReloadAmount() - config.minReloadAmount()) + config.minReloadAmount()
            val m = NUMBER_PATTERN.matcher(event.message)

            if (m.find()) {
                // The cannon will usually refill to MAX_CBALLS, but if the
                // player didn't have enough cannonballs in their inventory,
                // it could fill up less than that. Filling the cannon to
                // cballsLeft + amt is not always accurate though because our
                // counter doesn't decrease if the player has been too far away
                // from the cannon due to the projectiels not being in memory,
                // so our counter can be higher than it is supposed to be.

                val amt = Integer.parseInt(m.group())

                if (cballsLeft + amt >= MAX_CBALLS) {
                    skipProjectileCheckThisTick = true;
                    cballsLeft = MAX_CBALLS;
                } else {
                    cballsLeft += amt;
                }
            }
        }

            if (event.message.contains("Your cannon is out of ammo!")) {
                skipProjectileCheckThisTick = true

                // If the player was out of range of the cannon, some cannonballs
                // may have been used without the client knowing, so having this
                // extra check is a good idea.
                cballsLeft = 0
            }
            if (event.message.startsWith("You unload your cannon and receive Cannonball")
                || event.message.startsWith("You unload your cannon and receive Granite cannonball")
            ) {
                skipProjectileCheckThisTick = true
                cballsLeft = 0
            }
        }


    override fun onGameTick(it: GameTick) {
        skipProjectileCheckThisTick = false
        if (tickDelay > 0) {
            tickDelay--
            return
        }
        if (!cannonPlaced || cannonPosition == null || cballsLeft > nextReloadCount) {
            return
        }
        clientThread.invoke {
            client.invokeMenuAction(
                "Fire",
                "<col=ffff>Dwarf multicannon",
                ObjectID.DWARF_MULTICANNON,
                MenuAction.GAME_OBJECT_FIRST_OPTION.id,
                cannon!!.sceneMinLocation.x,
                cannon!!.sceneMinLocation.y
            )
        }
        tickDelay = 3
         nextReloadCount = r.nextInt(config.maxReloadAmount() - config.minReloadAmount()) + config.minReloadAmount()
    }
}

