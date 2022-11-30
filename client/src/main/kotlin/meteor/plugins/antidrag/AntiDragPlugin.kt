/*
 * Copyright (c) 2018, DennisDeV <https://github.com/DevDennis>
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
package meteor.plugins.antidrag

import com.google.inject.Provides
import eventbus.events.ConfigChanged
import eventbus.events.FocusChanged
import eventbus.events.ScriptPostFired
import eventbus.events.WidgetLoaded
import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.config.ConfigManager
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.GameState
import net.runelite.api.ScriptID
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.event.KeyEvent


@PluginDescriptor(
    name = "Anti Drag",
    description = "Prevent dragging an item for a specified delay",
    tags = ["antidrag", "delay", "inventory", "items"],
    enabledByDefault = false
)
@Slf4j
open class AntiDragPlugin : Plugin(), KeyListener {

    private val log = Logger("antidragplugin")
    private val clientThread = ClientThread
    private val config = configuration<AntiDragConfig>()
    private val keyManager = KeyManager
    private var shiftHeld = false
    private var ctrlHeld = false


    @Throws(Exception::class)
        override fun onStart() {
        if (client.gameState == GameState.LOGGED_IN) {
            clientThread.invokeLater {
                if (!config.onShiftOnly()) {
                    setDragDelay()
                }
            }
        }
        keyManager.registerKeyListener(this, AntiDragPlugin::class.java)
    }

    @Throws(Exception::class)
        override fun onStop() {
        clientThread.invoke { resetDragDelay() }
        keyManager.unregisterKeyListener(this)
    }

    override fun keyTyped(e: KeyEvent?) {}
    override fun keyPressed(e: KeyEvent) {
        if (e.keyCode == KeyEvent.VK_CONTROL && config.disableOnCtrl() && !config.onShiftOnly()) {
            resetDragDelay()
            ctrlHeld = true
        } else if (e.keyCode == KeyEvent.VK_SHIFT && config.onShiftOnly()) {
            setDragDelay()
            shiftHeld = true
        }
    }

    override fun keyReleased(e: KeyEvent) {
        if ((e.keyCode == KeyEvent.VK_CONTROL) && config.disableOnCtrl() && !config.onShiftOnly()) {
            setDragDelay()
            ctrlHeld = false
        } else if (e.keyCode == KeyEvent.VK_SHIFT && config.onShiftOnly()) {
            resetDragDelay()
            shiftHeld = false
        }
    }

    private val isOverriding: Boolean
        get() = (!config.onShiftOnly() || shiftHeld) && !ctrlHeld

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group.equals(CONFIG_GROUP)) {
            if (!config.disableOnCtrl()) {
                ctrlHeld = false
            }
            if (config.onShiftOnly()) {
                shiftHeld = false
                clientThread.invoke { resetDragDelay() }
            } else {
                clientThread.invoke { setDragDelay() }
            }
        }
    }

    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused) {
            shiftHeld = false
            ctrlHeld = false
            clientThread.invoke { resetDragDelay() }
        } else if (!config.onShiftOnly()) {
            clientThread.invoke { setDragDelay() }
        }
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (!isOverriding) {
            return
        }
        if (it.groupId == WidgetID.BANK_GROUP_ID || it.groupId == WidgetID.BANK_INVENTORY_GROUP_ID || it.groupId == WidgetID.DEPOSIT_BOX_GROUP_ID) {
            setBankDragDelay(config.dragDelay())
        } else if (it.groupId == WidgetID.INVENTORY_GROUP_ID) {
            setInvDragDelay(config.dragDelay())
        }
    }

    override fun onScriptPostFired(it: ScriptPostFired) {
        if (it.scriptId == ScriptID.INVENTORY_DRAWITEM) {
            val inv: Widget = client.getWidget(WidgetInfo.INVENTORY)!!
            val delay = config.dragDelay()
            val overriding = isOverriding
            for (child in inv.dynamicChildren) {
                // disable [clientscript,inventory_antidrag_update] listener
                child.setOnMouseRepeatListener(emptyArray<Any>())
                if (overriding) {
                    child.dragDeadTime = delay
                }
            }
        } else if (it.scriptId == ScriptID.RAIDS_STORAGE_PRIVATE_ITEMS) {
            setCoxDragDelay(config.dragDelay())
        }
    }

    private fun setBankDragDelay(delay: Int) {
        val bankItemContainer: Widget? = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER)
        val bankInventoryItemsContainer: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        val bankDepositContainer: Widget? = client.getWidget(WidgetInfo.DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER)
        val coxPrivateChest: Widget? = client.getWidget(WidgetInfo.RAIDS_PRIVATE_STORAGE_ITEM_CONTAINER)
        applyDragDelay(bankItemContainer, delay)
        applyDragDelay(bankInventoryItemsContainer, delay)
        applyDragDelay(bankDepositContainer, delay)
        applyDragDelay(coxPrivateChest, delay)
    }

    private fun setInvDragDelay(delay: Int) {
        val inventory: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        applyDragDelay(inventory, delay)
    }

    private fun setCoxDragDelay(delay: Int) {
        val coxChest: Widget? = client.getWidget(WidgetInfo.RAIDS_PRIVATE_STORAGE_ITEM_CONTAINER)
        applyDragDelay(coxChest, delay)
    }

    private fun setDragDelay() {
        val delay = config.dragDelay()
        log.debug("Set delay to {}", delay)
        client.setInventoryDragDelay(delay)
        setInvDragDelay(delay)
        setBankDragDelay(delay)
        setCoxDragDelay(delay)
    }

    private fun resetDragDelay() {
        log.debug("Reset delay to {}", DEFAULT_DELAY)
        client.setInventoryDragDelay(DEFAULT_DELAY)
        setInvDragDelay(DEFAULT_DELAY)
        setBankDragDelay(DEFAULT_DELAY)
        setCoxDragDelay(DEFAULT_DELAY)
    }

    companion object {
        const val CONFIG_GROUP = "antiDrag"
        private const val DEFAULT_DELAY = 5
        private fun applyDragDelay(widget: Widget?, delay: Int) {
            if (widget != null) {
                for (item in widget.dynamicChildren) {
                    item.dragDeadTime = delay
                }
            }
        }
    }
}