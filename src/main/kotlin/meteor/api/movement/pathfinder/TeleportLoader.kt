package meteor.api.movement.pathfinder

import meteor.api.commons.Worlds
import meteor.api.entities.Players
import meteor.api.game.Game
import meteor.api.game.GameThread
import meteor.api.input.Keyboard
import meteor.api.items.Equipment
import meteor.api.items.Inventory
import meteor.api.magic.Magic
import meteor.api.widgets.Dialog
import meteor.api.widgets.Widgets
import net.runelite.api.Item
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.Widget
import java.time.Instant
import java.util.ArrayList

object TeleportLoader {
    private const val BUILD_DELAY_SECONDS = 5
    private var lastBuild: Instant = Instant.now().minusSeconds(6)
    private var LAST_TELEPORT_LIST = emptyList<Teleport>()
    private val RING_OF_DUELING = intArrayOf(2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566)
    private val GAMES_NECKLACE = intArrayOf(3853, 3863, 3855, 3857, 3859, 3861, 3863, 3865, 3867)
    private val COMBAT_BRACELET = intArrayOf(11118, 11972, 11974, 11120, 11122, 11124)
    private val RING_OF_WEALTH = intArrayOf(11980, 11982, 11984, 11986, 11988)
    private val AMULET_OF_GLORY = intArrayOf(1712, 1706, 1708, 1710, 11976, 11978)
    private val NECKLACE_OF_PASSAGE = intArrayOf(21146, 21149, 21151, 21153, 21155)
    private val BURNING_AMULET = intArrayOf(21166, 21171, 21173, 21175, 21167)
    private val XERICS_TALISMAN = intArrayOf(13393)
    private val SLAYER_RING = intArrayOf(11866, 11867, 11868, 11869, 11870, 11871, 11872, 11873, 21268)
    private val DIGSITE_PENDANT = intArrayOf(11190, 11191, 11192, 11193, 11194)
    private val DRAKANS_MEDALLION = intArrayOf(22400)
    private val SKILLS_NECKLACE = intArrayOf(11105, 11111, 11109, 11107, 11970, 11968)
    fun buildTeleports(): List<Teleport> {
        if (lastBuild.plusSeconds(BUILD_DELAY_SECONDS.toLong()).isAfter(Instant.now())) {
            return LAST_TELEPORT_LIST
        }
        lastBuild = Instant.now()
        val teleports: MutableList<Teleport> = ArrayList()
        if (true) {
            if (Game.wildyLevel <= 20) {
                if (ringOfDueling()) {
                    teleports.add(
                        Teleport(
                            WorldPoint(3315, 3235, 0), 6,
                            { jewelryTeleport("Duel Arena", *RING_OF_DUELING) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2440, 3090, 0), 2,
                            { jewelryTeleport("Castle Wars", *RING_OF_DUELING) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3151, 3635, 0), 2,
                            { jewelryTeleport("Ferox Enclave", *RING_OF_DUELING) })
                    )
                }
                if (gamesNecklace()) {
                    teleports.add(
                        Teleport(WorldPoint(2898, 3553, 0), 2,
                            { jewelryTeleport("Burthorpe", *GAMES_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2520, 3571, 0), 6,
                            { jewelryTeleport("Barbarian Outpost", *GAMES_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2964, 4382, 2), 2,
                            { jewelryTeleport("Corporeal Beast", *GAMES_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3244, 9501, 2), 2,
                            { jewelryTeleport("Tears of Guthix", *GAMES_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(1624, 3938, 0), 1,
                            { jewelryTeleport("Wintertodt Camp", *GAMES_NECKLACE) })
                    )
                }
                if (necklaceOfPassage()) {
                    teleports.add(
                        Teleport(WorldPoint(3114, 3179, 0), 2,
                            { jewelryTeleport("Wizards' Tower", *NECKLACE_OF_PASSAGE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2430, 3348, 0), 2,
                            { jewelryTeleport("The Outpost", *NECKLACE_OF_PASSAGE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3405, 3157, 0), 2,
                            { jewelryTeleport("Eagles' Eyrie", *NECKLACE_OF_PASSAGE) })
                    )
                }
                for (tab in TeleportTab.values()) {
                    if (tab.canUse() && tab.point.distanceTo(Players.local.worldLocation) > 20) {
                        teleports.add(
                            Teleport(tab.point, 5
                            ) {
                                Inventory.getFirst(tab.itemId)?.interact("Break")
                            }
                        )
                    }
                }
            }
            if (Game.wildyLevel <= 30) {
                if (combatBracelet()) {
                    teleports.add(
                        Teleport(WorldPoint(2882, 3548, 0), 2,
                            { jewelryTeleport("Warriors' Guild", *COMBAT_BRACELET) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3191, 3367, 0), 2,
                            { jewelryTeleport("Champions' Guild", *COMBAT_BRACELET) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3052, 3488, 0), 2,
                            { jewelryTeleport("Monastery", *COMBAT_BRACELET) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2655, 3441, 0), 2,
                            { jewelryTeleport("Ranging Guild", *COMBAT_BRACELET) })
                    )
                }
                if (skillsNecklace()) {
                    teleports.add(
                        Teleport(WorldPoint(2611, 3390, 0), 6,
                            { jewelryPopupTeleport("Fishing Guild", *SKILLS_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3050, 9763, 0), 6,
                            { jewelryPopupTeleport("Mining Guild", *SKILLS_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2933, 3295, 0), 6,
                            { jewelryPopupTeleport("Crafting Guild", *SKILLS_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3143, 3440, 0), 6,
                            { jewelryPopupTeleport("Cooking Guild", *SKILLS_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(1662, 3505, 0), 6,
                            { jewelryPopupTeleport("Woodcutting Guild", *SKILLS_NECKLACE) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(1249, 3718, 0), 6,
                            { jewelryPopupTeleport("Farming Guild", *SKILLS_NECKLACE) })
                    )
                }
                if (ringOfWealth()) {
                    teleports.add(
                        Teleport(WorldPoint(3163, 3478, 0), 2,
                            { jewelryTeleport("Grand Exchange", *RING_OF_WEALTH) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2996, 3375, 0), 2,
                            { jewelryTeleport("Falador", *RING_OF_WEALTH) })
                    )
                }
                if (amuletOfGlory()) {
                    teleports.add(
                        Teleport(WorldPoint(3087, 3496, 0), 0,
                            { jewelryTeleport("Edgeville", *AMULET_OF_GLORY) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(2918, 3176, 0), 0,
                            { jewelryTeleport("Karamja", *AMULET_OF_GLORY) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3105, 3251, 0), 0,
                            { jewelryTeleport("Draynor Village", *AMULET_OF_GLORY) })
                    )
                    teleports.add(
                        Teleport(WorldPoint(3293, 3163, 0), 0,
                            { jewelryTeleport("Al Kharid", *AMULET_OF_GLORY) })
                    )
                }
            }
        }
        if (Game.wildyLevel <= 20) {
            for (teleportSpell in TeleportSpell.values()) {
                if (!teleportSpell.canCast()) {
                    continue
                }
                if (teleportSpell.point.distanceTo(Players.local.worldLocation) > 50) {
                    teleports.add(
                        Teleport(teleportSpell.point, 5
                        ) { Magic.cast(teleportSpell.spell) }
                    )
                }
            }
        }
        return java.util.List.copyOf(teleports.also { LAST_TELEPORT_LIST = it })
    }

    fun jewelryTeleport(target: String?, vararg ids: Int) {
        val inv: Item? = Inventory.getFirst(*ids)
        if (inv != null) {
            if (Dialog.isViewingOptions) {
                Dialog.chooseOption(target)
                return
            }
            inv.interact("Rub")
            return
        }
        Equipment.getFirst(*ids)?.interact(target)
    }

    fun jewelryPopupTeleport(target: String?, vararg ids: Int) {
        val inv: Item? = Inventory.getFirst(*ids)
        if (inv != null) {
            val baseWidget: Widget? = Widgets[187, 3]
            if (baseWidget != null && GameThread.invokeLater { !baseWidget.isHidden } == true) {
                val children = baseWidget.children ?: return
                for (i in children.indices) {
                    val teleportItem = children[i]
                    if (teleportItem.text.contains(target!!)) {
                        Keyboard.type(i + 1)
                        return
                    }
                }
            }
            inv.interact("Rub")
            return
        }
        Equipment.getFirst(*ids)?.interact(target)
    }

    fun ringOfDueling(): Boolean {
        return (Inventory.getFirst(*RING_OF_DUELING) != null
                || Equipment.getFirst(*RING_OF_DUELING) != null)
    }

    fun gamesNecklace(): Boolean {
        return (Inventory.getFirst(*GAMES_NECKLACE) != null
                || Equipment.getFirst(*GAMES_NECKLACE) != null)
    }

    fun combatBracelet(): Boolean {
        return (Inventory.getFirst(*COMBAT_BRACELET) != null
                || Equipment.getFirst(*COMBAT_BRACELET) != null)
    }

    fun skillsNecklace(): Boolean {
        return (Inventory.getFirst(*SKILLS_NECKLACE) != null
                || Equipment.getFirst(*SKILLS_NECKLACE) != null)
    }

    fun ringOfWealth(): Boolean {
        return (Inventory.getFirst(*RING_OF_WEALTH) != null
                || Equipment.getFirst(*RING_OF_WEALTH) != null)
    }

    fun amuletOfGlory(): Boolean {
        return (Inventory.getFirst(*AMULET_OF_GLORY) != null
                || Equipment.getFirst(*AMULET_OF_GLORY) != null)
    }

    fun necklaceOfPassage(): Boolean {
        return (Inventory.getFirst(*NECKLACE_OF_PASSAGE) != null
                || Equipment.getFirst(*NECKLACE_OF_PASSAGE) != null)
    }
}