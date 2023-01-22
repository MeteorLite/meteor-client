
package meteor.plugins.antidrag

import com.google.common.base.Supplier
import eventbus.events.ConfigChanged
import eventbus.events.FocusChanged
import eventbus.events.GameStateChanged
import eventbus.events.WidgetLoaded

import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.util.HotkeyListener
import net.runelite.api.GameState
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(
    name = "Anti Drag",
    enabledByDefault = false,
    description = "Prevent dragging an item for a specified delay",
    tags = ["antidrag", "delay", "inventory", "items"]
)
class AntiDragPlugin : Plugin() {

    private val config = configuration<AntiDragConfig>()

    //When an overlay is enabled dynamically, do NOT wrap it in the overlay() function.
    private val overlay = AntiDragOverlay()

    private val keyManager = KeyManager
    private var toggleDrag = false

    private val toggleListener: HotkeyListener = object : HotkeyListener({config.key()} ) {
        override fun hotkeyPressed() {
            toggleDrag = !toggleDrag
            if (toggleDrag) {
                if (config.overlay()) {
                    //Also we don't do this at all if wrapping with overlay()
                    overlayManager.add(overlay)
                }
                setDragDelay()
            } else {
                overlayManager.remove(overlay)
                resetDragDelay()
            }
        }
    }
    private val holdListener: HotkeyListener = object : HotkeyListener({ config.key() }) {
        override fun hotkeyPressed() {
            if (config.overlay()) {
                overlayManager.add(overlay)
            }
            setDragDelay()
        }

        override fun hotkeyReleased() {
            overlayManager.remove(overlay)
            resetDragDelay()
        }
    }

    override fun onStart() {
        overlay.color = config.color()
        updateKeyListeners()
        if (config.alwaysOn()) {
            setDragDelay()
        }
    }

    override fun onStop() {
        keyManager.unregisterKeyListener(holdListener)
        keyManager.unregisterKeyListener(toggleListener)
        toggleDrag = false
        overlayManager.remove(overlay)
        resetDragDelay()
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.BANK_GROUP_ID || it.groupId == WidgetID.DEPOSIT_BOX_GROUP_ID || it.groupId == WidgetID.BANK_INVENTORY_GROUP_ID) {
            setBankDragDelay(if (config.alwaysOn()) config.bankDragDelay() else DEFAULT_DELAY)
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group.equals("betterAntiDrag")) {
            when (it.key) {
                "toggleKeyBind", "holdKeyBind" -> updateKeyListeners()
                "alwaysOn" -> {
                    client.setInventoryDragDelay(if (config.alwaysOn()) config.dragDelay() else DEFAULT_DELAY)
                    setBankDragDelay(if (config.alwaysOn()) config.bankDragDelay() else DEFAULT_DELAY)
                }
                "dragDelay", "bankDragDelay" -> setDragDelay()
                "color" -> overlay.color = config.color()
            }
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGIN_SCREEN) {
            keyManager.unregisterKeyListener(toggleListener)
            keyManager.unregisterKeyListener(holdListener)
        } else if (it.gameState == GameState.LOGGING_IN) {
            updateKeyListeners()
        }
    }

    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused && config.reqFocus() && !config.alwaysOn()) {
            resetDragDelay()
            overlayManager.remove(overlay)
        }
    }

    private fun updateKeyListeners() {
        if (config.holdKeyBind()) {
            keyManager.registerKeyListener(holdListener, this.javaClass)
        } else {
            keyManager.unregisterKeyListener(holdListener)
        }
        if (config.toggleKeyBind()) {
            keyManager.registerKeyListener(toggleListener, this.javaClass)
        } else {
            keyManager.unregisterKeyListener(toggleListener)
        }
    }

    private fun setBankDragDelay(delay: Int) {
        val bankItemContainer: Widget? = client.getWidget(WidgetInfo.BANK_ITEM_CONTAINER)
        val bankInventoryItemsContainer: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        val bankDepositContainer: Widget? = client.getWidget(WidgetInfo.DEPOSIT_BOX_INVENTORY_ITEMS_CONTAINER)
        if (bankItemContainer != null) {
            val items = bankItemContainer.dynamicChildren
            for (item in items) {
                item.dragDeadTime = delay
            }
        }
        if (bankInventoryItemsContainer != null) {
            val items = bankInventoryItemsContainer.dynamicChildren
            for (item in items) {
                item.dragDeadTime = delay
            }
        }
        if (bankDepositContainer != null) {
            val items = bankDepositContainer.dynamicChildren
            for (item in items) {
                item.dragDeadTime = delay
            }
        }
    }

    private fun setDragDelay() {
        client.setInventoryDragDelay(config.dragDelay())
        setBankDragDelay(config.bankDragDelay())
    }

    private fun resetDragDelay() {
        client.setInventoryDragDelay(DEFAULT_DELAY)
        setBankDragDelay(DEFAULT_DELAY)
    }

    companion object {
        private const val DEFAULT_DELAY = 5
    }
}