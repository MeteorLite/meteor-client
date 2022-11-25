package meteor.plugins.loottracker

import androidx.compose.runtime.mutableStateOf
import com.google.gson.reflect.TypeToken
import compose.icons.Octicons
import compose.icons.octicons.Briefcase24
import dev.hoot.api.commons.FileUtil
import dev.hoot.api.game.Game
import dev.hoot.api.game.Prices
import eventbus.events.ClientTick
import eventbus.events.GameStateChanged
import meteor.Main
import meteor.Main.client
import meteor.Main.itemManager
import meteor.events.NpcLootReceived
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.GameState
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.Path


@PluginDescriptor(name = "Loot Tracker",enabledByDefault = true)
class LootTrackerPlugin: Plugin() {

    var lootObject: MutableList<LootTrackerObject> = mutableListOf()
    var priceObject: MutableList<PriceObject> = mutableListOf()
    var panel: PluginPanel? = null

    private var lootTrackerButton = ToolbarButton(
        "LootTracker",
        Octicons.Briefcase24,
        iconColor = uiColor.value,
        description = "Tracks loot",
        onClick = {
            onClick()
        },
        bottom = false
    )
    private fun nameInput(key:String, id: Int, quantity: Int) {
        lootObject.add(LootTrackerObject(key, id, quantity))
        FileUtil.writeJson(this, "${Main.client.localPlayer!!.name}-lootTracker.json", lootObject)
    }
    private fun priceInput(key:String, price: Int) {
        priceObject.add(PriceObject(key, price))
        FileUtil.writeJson(this, "${Main.client.localPlayer!!.name}-lootTracker-price.json", priceObject)
    }

    override fun onNpcLootReceived(it: NpcLootReceived) {
        val npc = it.npc
        val items = it.items
        val name = npc!!.name
        items.forEach { ist ->
            nameInput(name,ist.id,ist.quantity)
            priceInput(name,Prices.getItemPrice(ist.id))
            multiMap.value.entrySet().forEach {map->
                if(map.key == name)
                 map.value!!.forEach {
                     if (ist.id == it!!.id){
                         it.quantity.value = it.quantity.value + ist.quantity
                         it.asyncBufferedImage.value = itemManager.getImage(ist.id, it.quantity.value,it.quantity.value > 1)!!
                     }
                 }
            }
        }
        priceObject.forEach{
            priceMap.putIfAbsent(it.npc,it.price )
        }
        lootObject.forEach{
            multiMap.value.putIfAbsent(it.name, LootTrackerItem(id = it.id, quantity = mutableStateOf(it.quantity)))
        }

    }
    init{
        priceObject.forEach{
            priceMap.putIfAbsent(it.npc,it.price )
        }
        lootObject.forEach{
            multiMap.value.putIfAbsent(it.name, LootTrackerItem(id = it.id, quantity = mutableStateOf(it.quantity)))
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {


       if(Game.getState() == GameState.LOGGED_IN && client.localPlayer?.name != null){

            when {
                !FileUtil.exists(this, "${Main.client.localPlayer!!.name}-lootTracker.json") -> {
                    FileUtil.writeJson(this, "${Main.client.localPlayer!!.name}-lootTracker.json", lootObject)
                }
                else -> {
                    lootObject = FileUtil.readJson(
                        this,
                        "${Main.client.localPlayer!!.name}-lootTracker.json",
                        object : TypeToken<MutableList<LootTrackerObject>>() {})
                }
            }
            when {
                !FileUtil.exists(this, "${Main.client.localPlayer!!.name}-lootTracker-price.json") -> {

                    FileUtil.writeJson(this, "${Main.client.localPlayer!!.name}-lootTracker-price.json", priceObject)
                }
                else -> {
                    priceObject = FileUtil.readJson(
                        this,
                        "${Main.client.localPlayer!!.name}-lootTracker-price.json",
                        object : TypeToken<MutableList<PriceObject>>() {})
                }
            }
        }
    }



    fun onClick() {
        pluginPanel.value = panel
        togglePluginPanel(lootTrackerButton)

    }

    override fun onStart() {
        panel = LootTrackerPluginPanel()
        addButton(lootTrackerButton)


    }

    override fun onStop() {
        removeButton(lootTrackerButton)
        panel = null
    }



}