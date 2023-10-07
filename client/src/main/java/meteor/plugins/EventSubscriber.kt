package meteor.plugins


import eventbus.events.*
import kotlinx.coroutines.DelicateCoroutinesApi
import meteor.Main
import meteor.events.*
import org.rationalityfrontline.kevent.*

open class EventSubscriber() : KEventSubscriber {
    var eventListening: Boolean = false
    open fun onGameStateChanged(it: GameStateChanged) {}
    open fun onConfigChanged(it: ConfigChanged) {}
    open fun onPluginChanged(it: PluginChanged) {}
    open fun onInventoryUpdated(it: InventoryUpdated) {}
    open fun onClientTick(it: ClientTick) {}

    @OptIn(DelicateCoroutinesApi::class)
    open fun executeIfListening(unit: () -> (Unit)) {
        if (eventListening)
            unit()
    }

    fun subscribeEvents() {
        subscribeEvent<ConfigChanged> { executeIfListening { onConfigChanged(it) } }
        subscribeEvent<GameStateChanged> { executeIfListening { onGameStateChanged(it) } }
        subscribeEvent<PluginChanged> { executeIfListening { onPluginChanged(it) } }
        subscribeEvent<InventoryUpdated> { executeIfListening { onInventoryUpdated(it) } }
        subscribeEvent<ClientTick> { executeIfListening { onClientTick(it) } }
    }

    private inline fun <reified T : Any> subscribeEvent(noinline unit: (T) -> Unit) {
        subscribe(threadMode = SubscriberThreadMode.POSTING) { event -> unit.invoke(event.data) }
    }


    fun unsubscribe() {
        unsubscribeAll()
        eventListening = false
    }

    fun subscribe() {
        subscribeEvents()

        //Plugin eventListening is handled by PluginManager plugin start/stop
        if (this !is Plugin)
            eventListening = true
    }

    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
}