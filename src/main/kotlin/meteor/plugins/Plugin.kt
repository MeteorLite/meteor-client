package meteor.plugins

import meteor.Main
import meteor.config.ConfigManager
import meteor.config.ConfigManager.getConfig
import meteor.config.ConfigManager.setDefaultConfiguration
import meteor.ui.composables.pluginsOpen
import meteor.ui.overlay.Overlay
import net.runelite.client.config.Config

open class Plugin : EventSubscriber() {
    open val config: Config? = null
    var javaConfig: Config? = null

    var client = Main.client
    val overlayManager = Main.overlayManager
    val overlays = ArrayList<Overlay>()
    var running = false

    fun getDescriptor(): PluginDescriptor {
        return javaClass.getAnnotation(PluginDescriptor::class.java)
    }

    open fun getName(): String? {
        return getDescriptor().name
    }

    fun javaConfiguration(clazz: Class<out Config>): Config {
        val c: Config = getConfig(clazz)!!
        setDefaultConfiguration(c.javaClass, false)
        javaConfig = c
        return c
    }

    inline fun <reified T : Config> configuration(): T {
        val config = getConfig(T::class.java) as T
        setDefaultConfiguration(config, false)
        return config
    }

    inline fun <reified T : Overlay> overlay(overlay: T): T {
        overlays.add(overlay)
        return overlay
    }

    fun start() {
        subscribe()
        eventListening = true
        for (overlay in overlays)
            overlayManager.add(overlay)
        running = true
    }

    fun stop() {
        unsubscribe()
        eventListening = false
        for (overlay in overlays)
            overlayManager.remove(overlay)
        running = false
    }

    open fun onStart() {}
    open fun onStop() {}

    fun shouldEnable(): Boolean {
        val enabledConfig: String? = ConfigManager.getConfiguration(javaClass.simpleName, "pluginEnabled")
        val descriptor: PluginDescriptor? = javaClass.getAnnotation(PluginDescriptor::class.java)
        if (enabledConfig == null) {
            if (descriptor != null) {
                val enabledByDefault = descriptor.enabledByDefault || descriptor.cantDisable
                ConfigManager.setConfiguration(javaClass.simpleName, "pluginEnabled", enabledByDefault)
            }
        }

        var isEnabled = false

        if (ConfigManager.getConfiguration(javaClass.simpleName, "pluginEnabled").toBoolean())
            isEnabled = true

        return isEnabled
    }

    open fun togglePluginPanel() {
        if (pluginsOpen.value) closePluginPanel() else openPluginPanel()
    }

    open fun openPluginPanel() {
        pluginsOpen.value = true
    }

    open fun closePluginPanel() {
        pluginsOpen.value = false
    }
}