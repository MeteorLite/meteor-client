package meteor.plugins

import Main
import meteor.config.Config
import meteor.config.ConfigManager
import meteor.ui.overlay.Overlay
import org.rationalityfrontline.kevent.KEVENT as EventBus

open class Plugin : EventSubscriber() {
    val client = Main.client
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

    inline fun <reified T : Config> configuration(): T {
        val config = ConfigManager.getConfig(T::class.java) as T
        ConfigManager.setDefaultConfiguration(config, false)
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

    open val config: Config? = null

    fun unsubscribe() {
        eventListening = false
    }

    fun subscribe() {
        eventListening = true
    }

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