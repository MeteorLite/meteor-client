package meteor.api.entities

import Main.client
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.SceneEntity
import net.runelite.api.Tile
import net.runelite.api.coords.WorldPoint
import java.util.Comparator
import java.util.function.Predicate
import kotlin.collections.ArrayList

abstract class Entities<T : SceneEntity?> {
    protected abstract fun all(filter: Predicate<in T>): List<T>
    fun all(vararg names: String): List<T> {
        return all { x: T ->
            if (x!!.name == null) {
                return@all false
            }
            for (name in names) {
                if (name == x.name) {
                    return@all true
                }
            }
            false
        }
    }

    fun all(vararg ids: Int): List<T> {
        return all { x: T ->
            for (id in ids) {
                if (id == x!!.id) {
                    return@all true
                }
            }
            false
        }
    }

    fun nearest(to: WorldPoint?, filter: Predicate<in T>): T? {
        return all { x: T -> x!!.id != -1 && filter.test(x) }.stream()
            .min(Comparator.comparingInt { t: T? -> t!!.worldLocation.distanceTo(to) })
            .orElse(null)
    }

    fun nearest(to: WorldPoint, vararg names: String): T? {
        return nearest(to) { x: T ->
            if (x!!.name == null) {
                return@nearest false
            }
            for (name in names) {
                if (name == x.name) {
                    return@nearest true
                }
            }
            false
        }
    }

    fun nearest(to: WorldPoint, vararg ids: Int): T? {
        return nearest(to) { x: T ->
            for (id in ids) {
                if (id == x!!.id) {
                    return@nearest true
                }
            }
            false
        }
    }

    companion object {
        val hoveredEntities: List<SceneEntity>
            get() {
                val menuEntries: Array<MenuEntry> = client.menuEntries
                if (menuEntries.size == 0) {
                    return emptyList()
                }
                val out: ArrayList<SceneEntity?> = ArrayList()
                for (menuEntry in menuEntries) {
                    val menuAction = MenuAction.of(menuEntry.type)
                    when (menuAction) {
                        MenuAction.EXAMINE_OBJECT, MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.SPELL_CAST_ON_GAME_OBJECT, MenuAction.GAME_OBJECT_FIRST_OPTION, MenuAction.GAME_OBJECT_SECOND_OPTION, MenuAction.GAME_OBJECT_THIRD_OPTION, MenuAction.GAME_OBJECT_FOURTH_OPTION, MenuAction.GAME_OBJECT_FIFTH_OPTION -> {
                            val x = menuEntry.param0
                            val y = menuEntry.param1
                            val id = menuEntry.getIdentifier()
                            val tile: Tile =
                                client.scene.tiles[client.plane][x][y]
                            out.addAll(Objects.getAt(tile, id))
                        }
                        MenuAction.EXAMINE_NPC, MenuAction.ITEM_USE_ON_NPC, MenuAction.SPELL_CAST_ON_NPC, MenuAction.NPC_FIRST_OPTION, MenuAction.NPC_SECOND_OPTION, MenuAction.NPC_THIRD_OPTION, MenuAction.NPC_FOURTH_OPTION, MenuAction.NPC_FIFTH_OPTION -> {
                            val id = menuEntry.getIdentifier()
                            out.add(client.cachedNPCs[id])
                        }
                        MenuAction.EXAMINE_ITEM_GROUND, MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.SPELL_CAST_ON_GROUND_ITEM, MenuAction.GROUND_ITEM_FIRST_OPTION, MenuAction.GROUND_ITEM_SECOND_OPTION, MenuAction.GROUND_ITEM_THIRD_OPTION, MenuAction.GROUND_ITEM_FOURTH_OPTION, MenuAction.GROUND_ITEM_FIFTH_OPTION -> {
                            val x = menuEntry.param0
                            val y = menuEntry.param1
                            val id = menuEntry.getIdentifier()
                            val tile: Tile? =
                                client.scene.tiles[client.plane][x][y]
                            out.addAll(Loot.getAt(tile, id))
                        }
                        MenuAction.ITEM_USE_ON_PLAYER, MenuAction.SPELL_CAST_ON_PLAYER, MenuAction.PLAYER_FIRST_OPTION, MenuAction.PLAYER_SECOND_OPTION, MenuAction.PLAYER_THIRD_OPTION, MenuAction.PLAYER_FOURTH_OPTION, MenuAction.PLAYER_FIFTH_OPTION, MenuAction.PLAYER_SIXTH_OPTION, MenuAction.PLAYER_SEVENTH_OPTION, MenuAction.PLAYER_EIGTH_OPTION -> {
                            out.add(client.cachedPlayers[menuEntry.getIdentifier()])
                        }
                        else -> {}
                    }
                }
                return out.toList() as List<SceneEntity>
            }
    }
}