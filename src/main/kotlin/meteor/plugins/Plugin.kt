package meteor.plugins

import meteor.Main
import meteor.config.Config
import meteor.config.ConfigManager
import meteor.config.ConfigManager.getConfig
import meteor.config.ConfigManager.setDefaultConfiguration
import meteor.ui.overlay.Overlay

open class Plugin : EventSubscriber() {
    open val config: Config? = null
    var javaConfig: Config? = null

    var client = Main.client
    val overlayManager = Main.overlayManager
    val overlays = ArrayList<Overlay>()
    val enabled: Boolean
        get() = eventListening

    fun getDescriptor(): PluginDescriptor {
        return javaClass.getAnnotation(PluginDescriptor::class.java)
    }

    open fun getName(): String? {
        return getDescriptor().name
    }

    fun javaConfiguration(clazz: Class<out Config>) : Config {
        val c: Config = getConfig(clazz)!!
        setDefaultConfiguration(c, false)
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
        for (overlay in overlays)
            overlayManager.add(overlay)
    }

    fun stop() {
        unsubscribe()
        for (overlay in overlays)
            overlayManager.remove(overlay)
    }

    open fun onStart() {}
    open fun onStop() {}

    fun isEnabled() : Boolean {
        val enabledConfig: String? = ConfigManager.getConfiguration(javaClass.simpleName, "pluginEnabled")
        val descriptor: PluginDescriptor? = javaClass.getAnnotation(PluginDescriptor::class.java)
        if (enabledConfig == null) {
            if (descriptor != null) {
                val enabledByDefault = descriptor.enabledByDefault || descriptor.cantDisable
                ConfigManager.setConfiguration(javaClass.simpleName, "pluginEnabled", enabledByDefault)
            }
        }

        if (enabledConfig != null && descriptor!!.disabledOnStartup) {
            ConfigManager.setConfiguration(javaClass.simpleName, "pluginEnabled", false)
        }

        var isEnabled = false

        if (ConfigManager.getConfiguration(javaClass.simpleName, "pluginEnabled").toBoolean())
            isEnabled = true else if (javaClass.getAnnotation(PluginDescriptor::class.java).cantDisable) isEnabled = true

        return isEnabled
    }
}