package meteor.plugins

import meteor.config.ConfigManager
import meteor.config.legacy.Config
import meteor.ui.overlay.Overlay
import org.rationalityfrontline.kevent.KEVENT as EventBus

open class Plugin : EventSubscriber() {
    val client = Main.client
    private val overlayManager = Main.overlayManager
    val overlays = ArrayList<Overlay>()
    var enabled = false

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
        for (overlay in overlays)
            overlayManager.add(overlay)
        enabled = true
    }

    fun stop() {
        for (overlay in overlays)
            overlayManager.remove(overlay)
        enabled = false
    }

    open fun onStart() {}
    open fun onStop() {}

    open val config: Config? = null

    fun unsubscribe() {
        EventBus.removeSubscribersByTag(tag)
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