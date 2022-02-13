package meteor.api.widgets

import Main.client

import meteor.api.entities.Players
import meteor.api.game.GameThread
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.List
import java.util.function.Supplier

object Minigames {
    private val MINIGAMES_TAB_BUTTON = Supplier { Widgets.get(707, 6) }
    private val MINIGAMES_DESTINATION = Supplier { Widgets.get(76, 8) }
    fun teleport(destination: Destination) {
        val minigamesTeleportButton = Widgets.get(WidgetInfo.MINIGAME_TELEPORT_BUTTON)
        val teleportGraphics = List.of(800, 802, 803, 804)
        if (isOpen && minigamesTeleportButton != null) {
            if (Destination.current != destination) {
                GameThread.invoke { client.runScript(124, destination.index) }
                return
            }
            if (teleportGraphics.contains(Players.local.graphic)) {
                return
            }
            client.interact(1, 57, destination.index, 4980762)
        } else {
            open()
        }
    }

    fun open(): Boolean {
        if (!isTabOpen) {
            Tabs.open(Tab.QUESTS)
            return false
        }
        if (!isOpen) {
            val widget = MINIGAMES_TAB_BUTTON.get()
            if (widget != null && !GameThread.invokeLater { widget.isHidden }) {
                widget.interact("Grouping")
                return false
            }
        }
        return isOpen
    }

    val isOpen: Boolean
        get() {
            val minigamesButton = Widgets.get(WidgetInfo.MINIGAME_TELEPORT_BUTTON)
            return minigamesButton != null && !GameThread.invokeLater { minigamesButton.isHidden }
        }
    val isTabOpen: Boolean
        get() = Tabs.isOpen(Tab.CLAN_CHAT)

    enum class Destination(val index: Int, var ID: String) {
        BARBARIAN_ASSAULT(1, "Barbarian Assault"), BLAST_FURNACE(2, "Blast Furnace"), BURTHORPE_GAMES_ROOM(
            3,
            "Burthorpe Games Room"
        ),
        CASTLE_WARS(4, "Castle Wars"), CLAN_WARS(5, "Clan Wars"), DAGANNOTH_KINGS(
            6,
            "Dagannoth Kings"
        ),
        FISHING_TRAWLER(7, "Fishing Trawler"), GOD_WARS(8, "God Wars"), LAST_MAN_STANDING(
            9,
            "Last Man Standing"
        ),
        NIGHTMARE_ZONE(10, "Nightmare Zone"), PEST_CONTROL(11, "Pest Control"), PLAYER_OWNED_HOUSES(
            12,
            "Player Owned Houses"
        ),
        RAT_PITS(13, "Rat Pits"), SHADES_OF_MORTTON(14, "Shades of Mort'ton"), SHIELD_OF_ARRAV(
            15,
            "Shield of Arrav"
        ),
        THEATRE_OF_BLOOD(16, "Theatre of Blood"), TITHE_FARM(17, "Tithe Farm"), TROUBLE_BREWING(
            18,
            "Trouble Brewing"
        ),
        TZHAAR_FIGHT_PIT(19, "TzHaar Fight Pit"), VOLCANIC_MINE(20, "Volcanic Mine"), NONE(-1, "None");

        companion object {
            val current: Destination
                get() {
                    val selectedTeleport = MINIGAMES_DESTINATION.get()
                    return if (selectedTeleport != null && !GameThread.invokeLater { selectedTeleport.isHidden }) {
                        byName(selectedTeleport.text)
                    } else NONE
                }

            fun byName(name: String): Destination {
                return Arrays.stream(values())
                    .filter { x: Destination -> x.name == name }
                    .findFirst()
                    .orElse(NONE)
            }
        }
    }
}