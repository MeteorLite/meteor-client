/*
 * Copyright (c) 2018 Hydrox6 <ikada@protonmail.ch>
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
package meteor.plugins.poison

import eventbus.events.ConfigChanged
import eventbus.events.VarbitChanged
import meteor.game.AlternateSprites
import meteor.game.FontManager.runescapeSmallFont
import meteor.game.SpriteManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import meteor.rs.ClientThread
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.util.ColorUtil.wrapWithColorTag
import meteor.util.ImageUtil.getImageSpritePixels
import meteor.util.ImageUtil.loadImageResource
import meteor.util.ImageUtil.resizeCanvas
import net.runelite.api.GameState
import net.runelite.api.SpriteID
import net.runelite.api.VarPlayer
import java.awt.Color
import java.awt.image.BufferedImage
import java.text.MessageFormat
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.math.ceil

@PluginDescriptor(
    name = "Poison",
    description = "Tracks current damage values for Poison and Venom",
    tags = ["combat", "poison", "venom", "heart", "hp"]
)
class PoisonPlugin : Plugin() {
    private val clientThread = ClientThread
    private val poisonOverlay = PoisonOverlay(this)
    private val infoBoxManager = InfoBoxManager
    private val spriteManager = SpriteManager
    private val config = configuration<PoisonConfig>()

    var lastDamage = 0
    private var envenomed = false
    private var infobox: PoisonInfobox? = null
    private var poisonNaturalCure: Instant? = null
    private var nextPoisonTick: Instant? = null
    private var heart: BufferedImage? = null
    override fun onStart() {
        overlayManager.add(poisonOverlay)
        if (client.gameState == GameState.LOGGED_IN) {
            clientThread.invoke { checkHealthIcon() }
        }
    }

    override fun onStop() {
        overlayManager.remove(poisonOverlay)
        if (infobox != null) {
            infoBoxManager.removeInfoBox(infobox)
            infobox = null
        }
        envenomed = false
        lastDamage = 0
        poisonNaturalCure = null
        nextPoisonTick = null
        clientThread.invoke { resetHealthIcon() }
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        if (it.varpId == VarPlayer.POISON.id) {
            val poisonValue = it.value
            nextPoisonTick = Instant.now().plus(Duration.of(POISON_TICK_MILLIS.toLong(), ChronoUnit.MILLIS))
            val damage = nextDamage(poisonValue)
            lastDamage = damage
            envenomed = poisonValue >= VENOM_THRESHOLD
            poisonNaturalCure = if (poisonValue < VENOM_THRESHOLD) {
                Instant.now().plus(
                    Duration.of(
                        (POISON_TICK_MILLIS * poisonValue).toLong(),
                        ChronoUnit.MILLIS
                    )
                )
            } else {
                null
            }
            if (config.showInfoboxes()) {
                if (infobox != null) {
                    infoBoxManager.removeInfoBox(infobox)
                    infobox = null
                }
                if (damage > 0) {
                    val image = getSplat(
                        if (envenomed) SpriteID.HITSPLAT_DARK_GREEN_VENOM else SpriteID.HITSPLAT_GREEN_POISON,
                        damage
                    )
                    if (image != null) {
                        infobox = PoisonInfobox(image, this)
                        infoBoxManager.addInfoBox(infobox!!)
                    }
                }
            }
            checkHealthIcon()
        } else if (it.varpId == VarPlayer.DISEASE_VALUE.id) {
            checkHealthIcon()
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != PoisonConfig.GROUP) {
            return
        }
        if (!config.showInfoboxes() && infobox != null) {
            infoBoxManager.removeInfoBox(infobox)
            infobox = null
        }
        if (config.changeHealthIcon()) {
            clientThread.invoke { checkHealthIcon() }
        } else {
            clientThread.invoke { resetHealthIcon() }
        }
    }

    private fun getSplat(id: Int, damage: Int): BufferedImage? {
        //Get a copy of the hitsplat to get a clean one each time
        val rawSplat = spriteManager.getSprite(id, 0) ?: return null
        val splat = BufferedImage(
            rawSplat.colorModel,
            rawSplat.copyData(null),
            rawSplat.colorModel.isAlphaPremultiplied,
            null
        )
        val g = splat.graphics
        g.font = runescapeSmallFont

        // Align the text in the centre of the hitsplat
        val metrics = g.fontMetrics
        val text = damage.toString()
        val x = (splat.width - metrics.stringWidth(text)) / 2
        val y = (splat.height - metrics.height) / 2 + metrics.ascent
        g.color = Color.BLACK
        g.drawString(damage.toString(), x + 1, y + 1)
        g.color = Color.WHITE
        g.drawString(damage.toString(), x, y)
        return splat
    }

    fun createTooltip(): String {
        val line1 = MessageFormat.format(
            "Next {0} damage: {1}</br>Time until damage: {2}",
            if (envenomed) "venom" else "poison",
            wrapWithColorTag(lastDamage.toString(), Color.RED),
            getFormattedTime(nextPoisonTick)
        )
        val line2 = if (envenomed) "" else MessageFormat.format(
            "</br>Time until cure: {0}",
            getFormattedTime(poisonNaturalCure)
        )
        return line1 + line2
    }

    private fun checkHealthIcon() {
        if (!config.changeHealthIcon()) {
            return
        }
        val newHeart: BufferedImage?
        val poison = client.getVarpValue(VarPlayer.IS_POISONED)
        newHeart = if (poison >= VENOM_THRESHOLD) {
            HEART_VENOM
        } else if (poison > 0) {
            HEART_POISON
        } else if (client.getVarpValue(VarPlayer.DISEASE_VALUE) > 0) {
            HEART_DISEASE
        } else {
            resetHealthIcon()
            return
        }

        // Only update sprites when the heart icon actually changes
        if (newHeart !== heart) {
            heart = newHeart
            client.widgetSpriteCache.reset()
            client.spriteOverrides[SpriteID.MINIMAP_ORB_HITPOINTS_ICON] = getImageSpritePixels(
                heart!!
            )
        }
    }

    private fun resetHealthIcon() {
        if (heart == null) {
            return
        }
        client.widgetSpriteCache.reset()
        client.spriteOverrides.remove(SpriteID.MINIMAP_ORB_HITPOINTS_ICON)
        heart = null
    }

    companion object {
        const val POISON_TICK_MILLIS = 18200
        private const val VENOM_THRESHOLD = 1000000
        private const val VENOM_MAXIUMUM_DAMAGE = 20
        var HEART_DISEASE: BufferedImage = resizeCanvas(
            loadImageResource(
                AlternateSprites::class.java, AlternateSprites.DISEASE_HEART
            ), 26, 26
        )
        var HEART_POISON: BufferedImage = resizeCanvas(
            loadImageResource(
                AlternateSprites::class.java, AlternateSprites.POISON_HEART
            ), 26, 26
        )
        var HEART_VENOM: BufferedImage = resizeCanvas(
            loadImageResource(
                AlternateSprites::class.java, AlternateSprites.VENOM_HEART
            ), 26, 26
        )

        private fun nextDamage(poisonValue: Int): Int {
            var it: Int = poisonValue
            var damage: Int
            if (it >= VENOM_THRESHOLD) {
                //Venom Damage starts at 6, and increments in twos;
                //The VarPlayer increments in values of 1, however.
                it -= VENOM_THRESHOLD - 3
                damage = it * 2
                //Venom Damage caps at 20, but the VarPlayer keeps increasing
                if (damage > VENOM_MAXIUMUM_DAMAGE) {
                    damage = VENOM_MAXIUMUM_DAMAGE
                }
            } else {
                damage = ceil((it / 5.0f).toDouble()).toInt()
            }
            return damage
        }

        private fun getFormattedTime(endTime: Instant?): String {
            val timeLeft = Duration.between(Instant.now(), endTime)
            val seconds = (timeLeft.toMillis() / 1000L).toInt()
            val minutes = seconds / 60
            val secs = seconds % 60
            return String.format("%d:%02d", minutes, secs)
        }
    }
}