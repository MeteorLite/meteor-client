package meteor.plugins.objecthider

import dev.hoot.api.game.Game
import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.Constants
import net.runelite.api.GameState
import java.util.*
import java.util.stream.Collectors

@PluginDescriptor(name = "Object Hider", description = "Hides various objects", enabledByDefault = false)
class ObjectHiderPlugin : Plugin() {

    var config = configuration<ObjectHiderConfig>()
    private var objectIds = listOf<Int>()
    private var objectNames = listOf<String>()


    override fun onStart() {
        if (config.objectIds() != "") {
            try {
                objectIds = Arrays.stream(config.objectIds().split(",".toRegex()).toTypedArray())
                    .map { s: String -> s.trim { it <= ' ' }.toInt() }
                    .collect(Collectors.toList())
            } catch (ex: Exception) {
                // Don't care
            }
        }
        try {
            objectNames = Arrays.stream(config.objectNames().split(",".toRegex()).toTypedArray())
                .map { obj: String -> obj.trim { it <= ' ' } }
                .map { obj: String -> obj.lowercase(Locale.getDefault()) }
                .collect(Collectors.toList())
        } catch (ex: Exception) {
            // Don't care
        }
        if (client.gameState == GameState.LOGGED_IN) {
            ClientThread.invoke { hide() }
        }
    }

    override fun onStop() {
        objectIds = listOf()
        objectNames = listOf()
        ClientThread.invoke(Runnable {
            if (client.gameState == GameState.LOGGED_IN) {
                client.gameState = GameState.LOADING
            }
        })
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (Game.getState() == GameState.LOGGED_IN) {
            hide()
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != CONFIG_GROUP) {
            return
        }
        if (it.key == "objectIds") {
            if (config.objectIds() != "") {
                try {
                    objectIds = Arrays.stream(config.objectIds().split(",".toRegex()).toTypedArray())
                        .map { s: String -> s.trim { it <= ' ' }.toInt() }
                        .collect(Collectors.toList())
                } catch (ex: Exception) {
                }
            }
        } else if (it.key == "objectNames") {
            try {
                objectNames = Arrays.stream(config.objectNames().split(",".toRegex()).toTypedArray())
                    .map { obj: String -> obj.trim { it <= ' ' } }
                    .map { obj: String -> obj.lowercase(Locale.getDefault()) }
                    .collect(Collectors.toList())
            } catch (ex: Exception) {
            }
        }
        ClientThread.invoke {
            if (client.gameState == GameState.LOGGED_IN) {
                client.gameState = GameState.LOADING
            }
        }
    }

    private fun hide() {
        val scene = client.scene
        val tiles = scene.tiles
        for (z in 0..3) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    val tile = tiles[z][x][y] ?: continue
                    val gameObjects = tile.gameObjects
                    val decorativeObject = tile.decorativeObject
                    val wallObject = tile.wallObject
                    val groundObject = tile.groundObject
                    for (gameObject in gameObjects) {
                        if (gameObject != null) {
                            if (config.hideAllGameObjects() || objectIds.contains(gameObject.id) ||
                                !objectNames.isEmpty() && objectNames.contains(
                                    client.getObjectDefinition(gameObject.id).name.lowercase(
                                        Locale.getDefault()
                                    )
                                )
                            ) {
                                scene.removeGameObject(z, x, y)
                            }
                        }
                    }
                    if (decorativeObject != null) {
                        if (config.hideAllDecorativeObjects() || objectIds.contains(decorativeObject.id) ||
                            !objectNames.isEmpty() && objectNames.contains(
                                client.getObjectDefinition(decorativeObject.id).name.lowercase(
                                    Locale.getDefault()
                                )
                            )
                        ) {
                            scene.removeDecorativeObject(z, x, y)
                        }
                    }
                    if (wallObject != null) {
                        if (config.hideAllWallObjects() || objectIds.contains(wallObject.id) ||
                            !objectNames.isEmpty() && objectNames.contains(
                                client.getObjectDefinition(wallObject.id).name.lowercase(
                                    Locale.getDefault()
                                )
                            )
                        ) {
                            scene.removeWallObject(z, x, y)
                        }
                    }
                    if (groundObject != null && config.hideAllGroundObjects()) {
                        if (config.hideAllGroundObjects() || objectIds.contains(groundObject.id) ||
                            !objectNames.isEmpty() && objectNames.contains(
                                client.getObjectDefinition(groundObject.id).name.lowercase(
                                    Locale.getDefault()
                                )
                            )
                        ) {
                            scene.removeGroundObject(z, x, y)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val CONFIG_GROUP = "objecthider"
    }
}