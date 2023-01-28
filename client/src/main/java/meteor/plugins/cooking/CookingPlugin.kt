/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
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
package meteor.plugins.cooking

import eventbus.events.ChatMessage
import eventbus.events.GameTick
import eventbus.events.GraphicChanged
import lombok.AccessLevel
import lombok.Getter
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.ChatMessageType
import net.runelite.api.GraphicID
import net.runelite.api.ItemID
import java.time.Duration
import java.time.Instant

@PluginDescriptor(name = "Cooking", description = "Show cooking statistics", tags = ["overlay", "skilling", "cook"])
class CookingPlugin : Plugin() {
    private val config = configuration<CookingConfig>()
    private val overlay = CookingOverlay(this)
    private val infoBoxManager = InfoBoxManager
    private val itemManager = ItemManager

    @Getter(AccessLevel.PACKAGE)
    internal var session: CookingSession? = null
    override fun onStart() {
        session = null
        overlayManager.add(overlay)
    }

    override fun onStop() {
        infoBoxManager.removeIf { obj: InfoBox? -> FermentTimer::class.java.isInstance(obj) }
        overlayManager.remove(overlay)
        session = null
    }

    /*	@Override
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked)
	{
		OverlayMenuEntry overlayMenuEntry = overlayMenuClicked.getEntry();
		if (overlayMenuEntry.getMenuAction() == MenuAction.RUNELITE_OVERLAY
			&& overlayMenuClicked.getEntry().getOption().equals(CookingOverlay.COOKING_RESET)
			&& overlayMenuClicked.getOverlay() == overlay)
		{
			session = null;
		}
	}*/
    override fun onGameTick(it: GameTick) {
        if (session == null || config.statTimeout() == 0) {
            return
        }
        val statTimeout = Duration.ofMinutes(config.statTimeout().toLong())
        val sinceCooked = Duration.between(session!!.lastCookingAction, Instant.now())
        if (sinceCooked.compareTo(statTimeout) >= 0) {
            session = null
        }
    }

    override fun onGraphicChanged(it: GraphicChanged) {
        val player = client.localPlayer
        if (it.actor !== player) {
            return
        }
        if (player.graphic == GraphicID.WINE_MAKE && config.fermentTimer()) {
            val fermentTimerOpt = infoBoxManager.infoBoxes.stream()
                    .filter { obj: InfoBox? -> FermentTimer::class.java.isInstance(obj) }
                    .map { obj: InfoBox? -> FermentTimer::class.java.cast(obj) }
                    .findAny()
            if (fermentTimerOpt.isPresent) {
                val fermentTimer = fermentTimerOpt.get()
                fermentTimer.reset()
            } else {
                val fermentTimer = FermentTimer(itemManager.getImage(ItemID.JUG_OF_WINE), this)
                infoBoxManager.addInfoBox(fermentTimer)
            }
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.type != ChatMessageType.SPAM) {
            return
        }
        val message = it.message
        if (message.startsWith("You successfully cook")
                || message.startsWith("You successfully bake")
                || message.startsWith("You successfully fry")
                || message.startsWith("You manage to cook")
                || message.startsWith("You roast a")
                || message.startsWith("You spit-roast")
                || message.startsWith("You cook")
                || message.startsWith("Eventually the Jubbly")
                || message.startsWith("You half-cook")
                || message.startsWith("The undead meat is now cooked")
                || message.startsWith("The undead chicken is now cooked")
                || message.startsWith("You successfully scramble")
                || message.startsWith("You dry a piece of meat")) {
            if (session == null) {
                session = CookingSession()
            }
            session!!.updateLastCookingAction()
            session!!.increaseCookAmount()
        } else if (message.startsWith("You accidentally burn") || message == "You burn the mushroom in the fire." || message.startsWith("Unfortunately the Jubbly")
                || message.startsWith("You accidentally spoil")) {
            if (session == null) {
                session = CookingSession()
            }
            session!!.updateLastCookingAction()
            session!!.increaseBurnAmount()
        }
    }
}