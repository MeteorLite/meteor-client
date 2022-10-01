package meteor.plugins.ctrlplayeroptions

import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.MenuEntry
import net.runelite.api.events.MenuOpened

@PluginDescriptor(
    name = "Ctrl Player Options",
    description = "Hides trade / report unless you hold shift",
    enabledByDefault = false
)
class CtrlPlayerOptions : Plugin() {
    override val config = configuration<CtrlPlayerOptionsConfig>()
    override fun onStart() {
        KeyManager.registerKeyListener(CtrlKeyListener, CtrlPlayerOptions::class.java)
    }

    override fun onStop() {
        KeyManager.unregisterKeyListener(CtrlKeyListener)
    }

    override fun onMenuOpened(it: MenuOpened) {
        val entryList = ArrayList<MenuEntry>()
        if (!CtrlKeyListener.ctrlPressed) {
            client.menuEntries.forEach {
                when (it.option) {
                    "Follow" -> {
                        if (!config.hideFollow()) entryList.add(it)
                    }
                    "Trade with" -> {
                        if (!config.hideTradeWith()) entryList.add(it)
                    }
                    "Report" -> {
                        if (!config.hideReport()) entryList.add(it)
                    }
                    else -> entryList.add(it)
                }
            }
            client.menuEntries = entryList.toArray(emptyArray())
        }
    }
}