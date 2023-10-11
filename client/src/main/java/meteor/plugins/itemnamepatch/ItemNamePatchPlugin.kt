/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.itemnamepatch

import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import rscplus.ItemNamePatchLevel
import rscplus.ItemNamePatch

@PluginDescriptor(
    name = "Item Name Patch", configGroup = "itemnamepatch",
    description = "Changes the displayed name for items for quality of life",
    enabledByDefault = true
)
class ItemNamePatchPlugin : Plugin() {
    val config = configuration<ItemNamePatchConfig>()

    override fun onStart() {
        client.itemPatchLevel = config.patchLevel()
        updateItemNames()
    }

    override fun onStop() {
        client.itemPatchLevel = ItemNamePatchLevel.DISABLED
        updateItemNames()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGGED_IN)
            updateItemNames()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "itemnamepatch") {
            client.itemPatchLevel = config.patchLevel();
            updateItemNames()
        }
    }

    fun updateItemNames() {
        when (client.itemPatchLevel) {
            null -> client.itemNames = ItemNamePatch.item_name_original
            ItemNamePatchLevel.DISABLED -> client.itemNames = ItemNamePatch.item_name_original
            ItemNamePatchLevel.PRACTICAL -> client.itemNames = ItemNamePatch.item_name_patch1
            ItemNamePatchLevel.GRAMMAR -> client.itemNames = ItemNamePatch.item_name_patch2
            ItemNamePatchLevel.REWORD -> client.itemNames = ItemNamePatch.item_name_patch3
        }
    }
}