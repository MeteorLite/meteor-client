/*
 * Copyright (c) 2018 Abex
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
package meteor.game

import meteor.Main
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import meteor.rs.ClientThread
import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxManager
import meteor.util.ImageUtil
import net.runelite.api.GameState
import net.runelite.api.SpritePixels
import java.awt.image.BufferedImage
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.SwingUtilities

object SpriteManager {
    private val client = Main.client
    private val clientThread = ClientThread
    private val infoBoxManager = InfoBoxManager
    private val cache: Cache<Long, BufferedImage> = CacheBuilder.newBuilder()
        .maximumSize(128L)
        .expireAfterAccess(1, TimeUnit.HOURS)
        .build()

    fun getSprite(archive: Int, file: Int): BufferedImage? {
        assert(client.isClientThread)
        if (client.gameState.ordinal < GameState.LOGIN_SCREEN.ordinal) {
            return null
        }
        val key = archive.toLong() shl 32 or file.toLong()
        val cached: BufferedImage? = cache.getIfPresent(key)
        if (cached != null) {
            return cached
        }
        val sp = client.getSprites(client.indexSprites, archive, 0) ?: return null
        val img: BufferedImage = sp[file].toBufferedImage()
        cache.put(key, img)
        return img
    }

    fun getSpriteAsync(archive: Int, file: Int, user: Consumer<BufferedImage>) {
        val cached: BufferedImage? = cache.getIfPresent(archive.toLong() shl 32 or file.toLong())
        if (cached != null) {
            user.accept(cached)
            return
        }
        clientThread.invoke {
            val img = getSprite(archive, file)
            img?.let { user.accept(img) }
        }
    }

    fun getSpriteAsync(archive: Int, file: Int, infoBox: InfoBox) {
        getSpriteAsync(archive, file) { img: BufferedImage ->
            infoBox.image = img
            infoBoxManager.updateInfoBoxImage(infoBox)
        }
    }

    /**
     * Calls setIcon on c, ensuring it is repainted when this changes
     */
    fun addSpriteTo(c: JButton, archive: Int, file: Int) {
        getSpriteAsync(archive, file) { img: BufferedImage ->
            SwingUtilities.invokeLater { c.icon = ImageIcon(img) }
        }
    }

    /**
     * Calls setIcon on c, ensuring it is repainted when this changes
     */
    fun addSpriteTo(c: JLabel, archive: Int, file: Int) {
        getSpriteAsync(archive, file) { img: BufferedImage ->
            SwingUtilities.invokeLater { c.icon = ImageIcon(img) }
        }
    }

    fun addSpriteOverrides(add: Array<SpriteOverride>) {
        if (add.size <= 0) {
            return
        }
        clientThread.invokeLater {
            val overrides = client.spriteOverrides
            val owner: Class<*> = add[0].javaClass
            for (o in add) {
                val image: BufferedImage = ImageUtil.loadImageResource(owner, o.fileName)
                val sp: SpritePixels = ImageUtil.getImageSpritePixels(image, client)
                overrides[o.spriteId] = sp
            }
        }
    }

    fun removeSpriteOverrides(remove: Array<SpriteOverride>) {
        clientThread.invokeLater {
            val overrides = client.spriteOverrides
            for (o in remove) {
                overrides.remove(o.spriteId)
            }
        }
    }
}