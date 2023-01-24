package meteor.plugins.guardiansoftherift

import meteor.api.NPCs
import meteor.game.ItemManager
import meteor.ui.overlay.Overlay
import meteor.util.AsyncBufferedImage
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.geom.GeneralPath
import java.awt.geom.Path2D


class GuardiansOfTheRiftOverlay(var plugin: GuardiansOfTheRiftPlugin) : Overlay() {
    val itemManager = ItemManager
    override fun render(graphics: Graphics2D): Dimension? {
        val guardian = NPCs.getFirst(plugin.greatGuardianID)

        guardian?.let {
            graphics.color = Color.GREEN
            if (plugin.hasGuardianStones())
                it.convexHull?.let { hull ->
                    graphics.draw(hull)
                }
            plugin.currentTeleportOrb?.let { orb ->
                orb.convexHull?.let { clickbox ->
                    graphics.color = Color(255, 0, 255)
                    graphics.draw(clickbox)
                }
            }
            if (!plugin.pathToOrb.isNullOrEmpty())
                renderPath(graphics, plugin.pathToOrb!!)

            renderAltars(graphics)
        }
        return null
    }


    private fun renderPath(graphics: Graphics2D, path: List<WorldPoint>) {
        try {
            val pathToDraw = ArrayList<LocalPoint>(path.size)
            for (element in path) {
                pathToDraw.add(LocalPoint.fromWorld(client, element)!!)
            }
            val generalPath = GeneralPath(Path2D.WIND_EVEN_ODD, pathToDraw.size)
            for (currentTile in pathToDraw) {
                val pathPoint = Perspective.localToCanvas(client, currentTile, client.plane)
                if (pathPoint == null) {
                    graphics.color = Color(255, 0, 255)
                    graphics.draw(generalPath)
                    generalPath.reset()
                } else {
                    if (generalPath.currentPoint == null) {
                        generalPath.moveTo(pathPoint.x.toFloat(), pathPoint.y.toFloat())
                    } else {
                        generalPath.lineTo(pathPoint.x.toFloat(), pathPoint.y.toFloat())
                    }
                }
            }
            if (generalPath.currentPoint != null) {
                graphics.color = Color(255, 0, 255)
                graphics.draw(generalPath)
            }
        } catch (_: Exception) {
        }
    }

    private fun canCraftRune(itemID: Int): Boolean {
        if (itemID == ItemID.AIR_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 1
        if (itemID == ItemID.MIND_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 2
        if (itemID == ItemID.WATER_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 5
        if (itemID == ItemID.EARTH_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 9
        if (itemID == ItemID.FIRE_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 14
        if (itemID == ItemID.BODY_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 20
        if (itemID == ItemID.COSMIC_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 27 && Quest.LOST_CITY.getState(client) == QuestState.FINISHED
        if (itemID == ItemID.CHAOS_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 35
        if (itemID == ItemID.NATURE_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 44
        if (itemID == ItemID.LAW_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 54 && Quest.TROLL_STRONGHOLD.getState(client) == QuestState.FINISHED
        if (itemID == ItemID.DEATH_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 65 && Quest.MOURNINGS_END_PART_II.getState(client) == QuestState.FINISHED
        if (itemID == ItemID.BLOOD_RUNE)
            return client.getRealSkillLevel(Skill.RUNECRAFT) >= 77 && Quest.SINS_OF_THE_FATHER.getState(client) == QuestState.FINISHED
        return false
    }

    private fun renderAltar(graphics: Graphics2D, altar: TileObject, runeID: Int) {
        var color = Color.GREEN
        if (plugin.elementalPriority) {
            when (runeID) {
                plugin.currentElementalrune -> {
                    if (!canCraftRune(plugin.currentElementalrune))
                        color = Color.RED
                }
                plugin.currentCatalyticrune -> {
                    color = if (canCraftRune(plugin.currentCatalyticrune))
                        Color.YELLOW
                    else
                        Color.RED
                }
            }
        } else {
            when (runeID) {
                plugin.currentCatalyticrune -> {
                    if (!canCraftRune(plugin.currentCatalyticrune))
                        color = Color.RED
                }
                plugin.currentElementalrune -> {
                    if (canCraftRune(plugin.currentCatalyticrune))
                        color = Color.YELLOW
                    if (!canCraftRune(plugin.currentElementalrune))
                        color = Color.RED
                }
            }
        }

        if (plugin.hasGuardianStones())
            color = Color.RED

        graphics.color = color
        renderRuneIcon(graphics, itemManager.getImage(runeID, 1, false), altar)
        altar.clickbox?.let { clickbox -> graphics.draw(clickbox) }
    }

    private fun renderAltars(graphics: Graphics2D) {

        for (altar in plugin.getActiveAltars()) {
            when (altar.id) {
                43701 -> renderAltar(graphics, altar, ItemID.AIR_RUNE)
                43702 -> renderAltar(graphics, altar, ItemID.WATER_RUNE)
                43703 -> renderAltar(graphics, altar, ItemID.EARTH_RUNE)
                43704 -> renderAltar(graphics, altar, ItemID.FIRE_RUNE)
                43705 -> renderAltar(graphics, altar, ItemID.MIND_RUNE)
                43706 -> renderAltar(graphics, altar, ItemID.CHAOS_RUNE)
                43707 -> renderAltar(graphics, altar, ItemID.DEATH_RUNE)
                43708 -> renderAltar(graphics, altar, ItemID.BLOOD_RUNE)
                43709 -> renderAltar(graphics, altar, ItemID.BODY_RUNE)
                43710 -> renderAltar(graphics, altar, ItemID.COSMIC_RUNE)
                43711 -> renderAltar(graphics, altar, ItemID.NATURE_RUNE)
                43712 -> renderAltar(graphics, altar, ItemID.LAW_RUNE)
            }
        }
    }

    fun renderRuneIcon(graphics: Graphics2D, image: AsyncBufferedImage?, obj: TileObject) {
        image?.let {
            val canvasLoc = Perspective.getCanvasImageLocation(client, obj.localLocation, it, 150)
            if (canvasLoc != null) {
                graphics.drawImage(it, canvasLoc.x, canvasLoc.y, null)
            }
        }
    }
}