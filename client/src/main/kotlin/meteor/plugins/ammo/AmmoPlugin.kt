/*
 * Copyright (c) 2019 Hydrox6 <ikada@protonmail.ch>
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
package meteor.plugins.ammo

import eventbus.events.ItemContainerChanged
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.EquipmentInventorySlot
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.ItemComposition
import java.awt.image.BufferedImage

@PluginDescriptor(
    name = "Ammo",
    description = "Shows the current ammo the player has equipped",
    tags = ["bolts", "darts", "chinchompa", "equipment"]
)
class AmmoPlugin : Plugin() {
    private val clientThread = ClientThread
    private val infoBoxManager = InfoBoxManager
    private val itemManager = ItemManager
    private var counterBox: AmmoCounter? = null
    override fun onStart() {
        clientThread.invokeLater {
            val container = client.getItemContainer(InventoryID.EQUIPMENT)
            if (container != null) {
                checkInventory(container.items)
            }
        }
    }

    override fun onStop() {
        infoBoxManager.removeInfoBox(counterBox)
        counterBox = null
    }

    override fun onItemContainerChanged(it: ItemContainerChanged) {
        if (it.itemContainer != client.getItemContainer(InventoryID.EQUIPMENT)) {
            return
        }
        checkInventory(it.itemContainer.items)
    }

    private fun checkInventory(items: Array<Item>) {
        // Check for weapon slot items. This overrides the ammo slot,
        // as the player will use the thrown weapon (eg. chinchompas, knives, darts)
        if (items.size > EquipmentInventorySlot.WEAPON.slotIdx) {
            val weapon = items[EquipmentInventorySlot.WEAPON.slotIdx]
            val weaponComp = itemManager.getItemComposition(weapon.id)
            if (weaponComp!!.isStackable) {
                updateInfobox(weapon, weaponComp)
                return
            }
        }
        if (items.size <= EquipmentInventorySlot.AMMO.slotIdx) {
            removeInfobox()
            return
        }
        val ammo = items[EquipmentInventorySlot.AMMO.slotIdx]
        val comp = itemManager.getItemComposition(ammo.id)
        if (!comp!!.isStackable) {
            removeInfobox()
            return
        }
        updateInfobox(ammo, comp)
    }

    private fun updateInfobox(item: Item, comp: ItemComposition?) {
        if (counterBox != null && counterBox!!.itemID == item.id) {
            counterBox!!.count = item.quantity
            return
        }
        removeInfobox()
        val image: BufferedImage? = itemManager.getImage(item.id, 5, false)
        counterBox = AmmoCounter(this, item.id, item.quantity, comp!!.name, image)
        infoBoxManager.addInfoBox(counterBox!!)
    }

    private fun removeInfobox() {
        infoBoxManager.removeInfoBox(counterBox)
        counterBox = null
    }
}