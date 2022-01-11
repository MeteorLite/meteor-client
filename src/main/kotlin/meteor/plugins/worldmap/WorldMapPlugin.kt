/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.worldmap

import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.StatChanged
import eventbus.events.WidgetLoaded
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.agility.AgilityShortcut
import meteor.rs.ClientThread
import meteor.ui.worldmap.WorldMapPointManager
import meteor.util.ImageUtil
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import net.runelite.api.util.Text
import net.runelite.api.widgets.WidgetID
import org.rationalityfrontline.kevent.Event
import java.awt.image.BufferedImage
import java.util.*
import java.util.function.Predicate

@PluginDescriptor(
    name = "World Map",
    description = "Enhance the world map to display additional information",
    tags = ["agility", "dungeon", "fairy", "farming", "rings", "teleports"],
    enabledByDefault = true,
    configGroup = "World Map"
)
class WorldMapPlugin : Plugin() {
    override val config = configuration<WorldMapConfig>()

    var clientThread = ClientThread
    private val worldMapPointManager = WorldMapPointManager
    private var agilityLevel = 0
    private var woodcuttingLevel = 0


    override fun onStop() {
        agilityLevel = client.getRealSkillLevel(Skill.AGILITY)
        woodcuttingLevel = client.getRealSkillLevel(Skill.WOODCUTTING)
        if (client.gameState == GameState.LOGGED_IN) {
            updateShownIcons()
        }
    }

    override fun onStart() {
        worldMapPointManager.removeIf(WorldMapPoint::class.java::isInstance)
        agilityLevel = 0
        woodcuttingLevel = 0
    }


    override fun onConfigChanged():((Event<ConfigChanged>)->Unit) = {
        val it = it.data
        if (it.group != CONFIG_KEY) {
            updateShownIcons()
        }
    }

    override fun onGameStateChanged(): ((Event<GameStateChanged>)->Unit) = {
        val it = it.data
        if (it.new == GameState.LOGGED_IN)
            updateShownIcons()
    }

    override fun onStatChanged():((Event<StatChanged>)->Unit) = {
        val it = it.data
        when (it.skill) {
            Skill.AGILITY -> {
                val newAgilityLevel = it.boostedLevel
                if (newAgilityLevel != agilityLevel) {
                    agilityLevel = newAgilityLevel
                    updateAgilityIcons()
                }
            }
            Skill.WOODCUTTING -> {
                val newWoodcutLevel = it.boostedLevel
                if (newWoodcutLevel != woodcuttingLevel) {
                    woodcuttingLevel = newWoodcutLevel
                    updateRareTreeIcons()
                }
            }
        }
    }


    override fun onWidgetLoaded():((Event<WidgetLoaded>)->Unit) = {
        val it = it.data
        if (it.groupId == WidgetID.WORLD_MAP_GROUP_ID) {
            updateQuestStartPointIcons()
        }
    }

    private fun updateAgilityIcons() {
        worldMapPointManager!!.removeIf(isType(MapPoint.Type.AGILITY_SHORTCUT))
        if (config.agilityShortcutLevelIcon() || config.agilityShortcutTooltips()) {
            Arrays.stream(AgilityShortcut.values())
                .filter { value: AgilityShortcut -> value.worldMapLocation != null }
                .map { l: AgilityShortcut ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.AGILITY_SHORTCUT)
                        .worldPoint(l.worldMapLocation!!)
                        .image(
                            if (agilityLevel > 0 && config.agilityShortcutLevelIcon()
                                && l.level > agilityLevel
                            ) NOPE_ICON!! else BLANK_ICON!!
                        )
                        .tooltip(if (config.agilityShortcutTooltips()) l.tooltip else null!!)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint? -> worldMapPointManager.add(worldMapPoint!!) }
        }
    }

    private fun updateAgilityCourseIcons() {
        worldMapPointManager!!.removeIf(isType(MapPoint.Type.AGILITY_COURSE))
        if (config.agilityCourseTooltip() || config.agilityCourseRooftop()) {
            Arrays.stream(AgilityCourseLocation.values())
                .filter { true }
                .map { l: AgilityCourseLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.AGILITY_COURSE)
                        .worldPoint(l.location)
                        .image(if (config.agilityCourseRooftop() && l.rooftopCourse) ROOFTOP_COURSE_ICON!! else BLANK_ICON!!)
                        .tooltip(if (config.agilityCourseTooltip()) l.tooltip else null)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint? -> worldMapPointManager.add(worldMapPoint) }
        }
    }

    private fun updateRareTreeIcons() {
        worldMapPointManager!!.removeIf(isType(MapPoint.Type.RARE_TREE))
        if (config.rareTreeLevelIcon() || config.rareTreeTooltips()) {
            Arrays.stream(RareTreeLocation.values()).forEach { rareTree: RareTreeLocation ->
                Arrays.stream(rareTree.locations)
                    .map { point: WorldPoint? ->
                        WorldMapPoint.builder()
                            .type(MapPoint.Type.RARE_TREE)
                            .worldPoint(point!!)
                            .image(if (woodcuttingLevel > 0 && config.rareTreeLevelIcon() && rareTree.levelReq > woodcuttingLevel) NOPE_ICON!! else BLANK_ICON!!)
                            .tooltip(if (config.rareTreeTooltips()) rareTree.tooltip else null)
                            .build()
                    }
                    .forEach { worldMapPoint: WorldMapPoint? -> worldMapPointManager.add(worldMapPoint) }
            }
        }
    }

    private fun updateShownIcons() {
        updateAgilityIcons()
        updateAgilityCourseIcons()
        updateRareTreeIcons()
        updateQuestStartPointIcons()
        worldMapPointManager.removeIf(isType(MapPoint.Type.FAIRY_RING))
        if (config.fairyRingIcon() || config.fairyRingTooltips()) {
            Arrays.stream(FairyRingLocation.values())
                .map { l: FairyRingLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.FAIRY_RING)
                        .worldPoint(l.location)
                        .image(if (config.fairyRingIcon()) FAIRY_TRAVEL_ICON!! else BLANK_ICON!!)
                        .tooltip(if (config.fairyRingTooltips()) "Fairy Ring - " + l.code else null)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.MINIGAME))
        if (config.minigameTooltip()) {
            Arrays.stream(MinigameLocation.values())
                .map { l: MinigameLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.MINIGAME)
                        .worldPoint(l.location)
                        .image(BLANK_ICON!!)
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.TRANSPORTATION))
        if (config.transportationTeleportTooltips()) {
            Arrays.stream(TransportationPointLocation.values())
                .map { l: TransportationPointLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.TRANSPORTATION)
                        .worldPoint(l.location!!)
                        .image(BLANK_ICON!!)
                        .target(l.target!!)
                        .jumpOnClick(l.target != null)
                        .name(Text.titleCase(l))
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.FARMING_PATCH))
        if (config.farmingPatchTooltips()) {
            Arrays.stream(FarmingPatchLocation.values()).forEach { location: FarmingPatchLocation ->
                Arrays.stream(location.locations)
                    .map { point: WorldPoint? ->
                        WorldMapPoint.builder()
                            .type(MapPoint.Type.FARMING_PATCH)
                            .worldPoint(point!!)
                            .image(BLANK_ICON!!)
                            .tooltip(location.tooltip)
                            .build()
                    }
                    .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
            }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.TELEPORT))
        Arrays.stream(TeleportLocationData.values())
            .filter { data: TeleportLocationData ->
                when (data.type) {
                    TeleportType.NORMAL_MAGIC -> return@filter config.normalTeleportIcon()
                    TeleportType.ANCIENT_MAGICKS -> return@filter config.ancientTeleportIcon()
                    TeleportType.LUNAR_MAGIC -> return@filter config.lunarTeleportIcon()
                    TeleportType.ARCEUUS_MAGIC -> return@filter config.arceuusTeleportIcon()
                    TeleportType.JEWELLERY -> return@filter config.jewelleryTeleportIcon()
                    TeleportType.SCROLL -> return@filter config.scrollTeleportIcon()
                    TeleportType.OTHER -> return@filter config.miscellaneousTeleportIcon()
                    else -> return@filter false
                }
            }
            .map { l: TeleportLocationData ->
                WorldMapPoint.builder()
                    .type(MapPoint.Type.TELEPORT)
                    .worldPoint(l.location)
                    .tooltip(l.tooltip)
                    .image(ImageUtil.loadImageResource(WorldMapPlugin::class.java, l.iconPath))
                    .build()
            }
            .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        worldMapPointManager.removeIf(isType(MapPoint.Type.RUNECRAFT_ALTAR))
        if (config.runecraftingAltarIcon()) {
            Arrays.stream(RunecraftingAltarLocation.values())
                .map { l: RunecraftingAltarLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.RUNECRAFT_ALTAR)
                        .worldPoint(l.location)
                        .image(ImageUtil.loadImageResource(WorldMapPlugin::class.java, l.iconPath))
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.MINING_SITE))
        if (config.miningSiteTooltips()) {
            Arrays.stream(MiningSiteLocation.values())
                .map { l: MiningSiteLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.MINING_SITE)
                        .worldPoint(l.location)
                        .image(if (l.iconRequired) MINING_SITE_ICON!! else BLANK_ICON!!)
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.DUNGEON))
        if (config.dungeonTooltips()) {
            Arrays.stream(DungeonLocation.values())
                .map { l: DungeonLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.DUNGEON)
                        .worldPoint(l.location)
                        .image(BLANK_ICON!!)
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.HUNTER))
        if (config.hunterAreaTooltips()) {
            Arrays.stream(HunterAreaLocation.values())
                .map { l: HunterAreaLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.HUNTER)
                        .worldPoint(l.location)
                        .image(BLANK_ICON!!)
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.FISHING))
        if (config.fishingSpotTooltips()) {
            Arrays.stream(FishingSpotLocation.values()).forEach {
                arrayOf(it)
                    .map { point:FishingSpotLocation ->
                        WorldMapPoint.builder()
                            .type(MapPoint.Type.FISHING)
                            .fishingPoint(point)
                            .image(BLANK_ICON!!)
                            .build()
                    }
                    .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
            }
        }
        worldMapPointManager.removeIf(isType(MapPoint.Type.KOUREND_TASK))
        if (config.kourendTaskTooltips()) {
            Arrays.stream(KourendTaskLocation.values())
                .map { l: KourendTaskLocation ->
                    WorldMapPoint.builder()
                        .type(MapPoint.Type.KOUREND_TASK)
                        .worldPoint(l.location)
                        .image(BLANK_ICON!!)
                        .tooltip(l.tooltip)
                        .build()
                }
                .forEach { worldMapPoint: WorldMapPoint -> worldMapPointManager.add(worldMapPoint) }
        }
    }

    private fun updateQuestStartPointIcons() {
        worldMapPointManager.removeIf(isType(MapPoint.Type.QUEST))
        if (!config.questStartTooltips()) {
            return
        }

        // Must setup the quest icons on the client thread, after the player has logged in.
        clientThread.invokeLater(Runnable invokeLater@{
            if (client.gameState != GameState.LOGGED_IN) {
                return@invokeLater
            }
            Arrays.stream(QuestStartLocation.values())
                .map { data: QuestStartLocation -> createQuestStartPoint(data) }
                .forEach { worldMapPoint: WorldMapPoint? -> worldMapPointManager.add(worldMapPoint) }

        })
    }

    private fun createQuestStartPoint(data: QuestStartLocation): WorldMapPoint {
        val quests = data.quests

        // Get first uncompleted quest. Else, return the last quest.
        var quest: Quest? = null
        for (q in quests) {
            if (q?.getState(client) != QuestState.FINISHED) {
                quest = q
                break
            }
        }
        if (quest == null) {
            quest = quests[quests.size - 1]
        }
        var icon = BLANK_ICON
        var tooltip: String? = ""
        if (quest != null) {
            tooltip = quest.getName()
            when (quest.getState(client)) {
                QuestState.FINISHED -> {
                    icon = FINISHED_ICON
                    tooltip += " - Finished"
                }
                QuestState.IN_PROGRESS -> {
                    icon = STARTED_ICON
                    tooltip += " - Started"
                }
                QuestState.NOT_STARTED -> {
                    icon = NOT_STARTED_ICON
                    tooltip += " - Not Started"
                }
            }
        }
        return WorldMapPoint.builder()
            .type(MapPoint.Type.QUEST)
            .worldPoint(data.location)
            .image(icon!!)
            .tooltip(tooltip)
            .build()
    }

    companion object {
        var BLANK_ICON: BufferedImage? = null
        const val CONFIG_KEY = "worldmap"
        const val CONFIG_KEY_FAIRY_RING_TOOLTIPS = "fairyRingTooltips"
        const val CONFIG_KEY_FAIRY_RING_ICON = "fairyRingIcon"
        const val CONFIG_KEY_AGILITY_SHORTCUT_TOOLTIPS = "agilityShortcutTooltips"
        const val CONFIG_KEY_AGILITY_SHORTCUT_LEVEL_ICON = "agilityShortcutIcon"
        const val CONFIG_KEY_AGILITY_COURSE_TOOLTIPS = "agilityCourseTooltips"
        const val CONFIG_KEY_AGILITY_COURSE_ROOFTOP_ICON = "agilityCourseRooftopIcon"
        const val CONFIG_KEY_NORMAL_TELEPORT_ICON = "standardSpellbookIcon"
        const val CONFIG_KEY_ANCIENT_TELEPORT_ICON = "ancientSpellbookIcon"
        const val CONFIG_KEY_LUNAR_TELEPORT_ICON = "lunarSpellbookIcon"
        const val CONFIG_KEY_ARCEUUS_TELEPORT_ICON = "arceuusSpellbookIcon"
        const val CONFIG_KEY_JEWELLERY_TELEPORT_ICON = "jewelleryIcon"
        const val CONFIG_KEY_SCROLL_TELEPORT_ICON = "scrollIcon"
        const val CONFIG_KEY_MISC_TELEPORT_ICON = "miscellaneousTeleportIcon"
        const val CONFIG_KEY_QUEST_START_TOOLTIPS = "questStartTooltips"
        const val CONFIG_KEY_MINIGAME_TOOLTIP = "minigameTooltip"
        const val CONFIG_KEY_FARMING_PATCH_TOOLTIPS = "farmingpatchTooltips"
        const val CONFIG_KEY_RARE_TREE_TOOLTIPS = "rareTreeTooltips"
        const val CONFIG_KEY_RARE_TREE_LEVEL_ICON = "rareTreeIcon"
        const val CONFIG_KEY_TRANSPORTATION_TELEPORT_TOOLTIPS = "transportationTooltips"
        const val CONFIG_KEY_RUNECRAFTING_ALTAR_ICON = "runecraftingAltarIcon"
        const val CONFIG_KEY_MINING_SITE_TOOLTIPS = "miningSiteTooltips"
        const val CONFIG_KEY_DUNGEON_TOOLTIPS = "dungeonTooltips"
        const val CONFIG_KEY_HUNTER_AREA_TOOLTIPS = "hunterAreaTooltips"
        const val CONFIG_KEY_FISHING_SPOT_TOOLTIPS = "fishingSpotTooltips"
        const val CONFIG_KEY_KOUREND_TASK_TOOLTIPS = "kourendTaskTooltips"
        private var FAIRY_TRAVEL_ICON: BufferedImage? = null
        private var NOPE_ICON: BufferedImage? = null
        private var NOT_STARTED_ICON: BufferedImage? = null
        private var STARTED_ICON: BufferedImage? = null
        private var FINISHED_ICON: BufferedImage? = null
        private var MINING_SITE_ICON: BufferedImage? = null
        private var ROOFTOP_COURSE_ICON: BufferedImage? = null

        init {
            //A size of 17 gives us a buffer when triggering tooltips
            val iconBufferSize = 17

            //Quest icons are a bit bigger.
            val questIconBufferSize = 22
            BLANK_ICON = BufferedImage(
                iconBufferSize,
                iconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            FAIRY_TRAVEL_ICON = BufferedImage(
                iconBufferSize, iconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val fairyTravelIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "fairy_ring_travel.png")
            FAIRY_TRAVEL_ICON!!.graphics.drawImage(fairyTravelIcon, 1, 1, null)
            NOPE_ICON = BufferedImage(
                iconBufferSize,
                iconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val nopeImage = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "nope_icon.png")
            NOPE_ICON!!.graphics.drawImage(nopeImage, 1, 1, null)
            NOT_STARTED_ICON = BufferedImage(
                questIconBufferSize, questIconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val notStartedIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "quest_not_started_icon.png")
            NOT_STARTED_ICON!!.graphics.drawImage(notStartedIcon, 4, 4, null)
            STARTED_ICON = BufferedImage(
                questIconBufferSize, questIconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val startedIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "quest_started_icon.png")
            STARTED_ICON!!.graphics.drawImage(startedIcon, 4, 4, null)
            FINISHED_ICON = BufferedImage(
                questIconBufferSize, questIconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val finishedIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "quest_completed_icon.png")
            FINISHED_ICON!!.graphics.drawImage(finishedIcon, 4, 4, null)
            MINING_SITE_ICON = BufferedImage(
                iconBufferSize, iconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val miningSiteIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "mining_site_icon.png")
            MINING_SITE_ICON!!.graphics.drawImage(miningSiteIcon, 1, 1, null)
            ROOFTOP_COURSE_ICON = BufferedImage(
                iconBufferSize, iconBufferSize,
                BufferedImage.TYPE_INT_ARGB
            )
            val rooftopCourseIcon = ImageUtil
                .loadImageResource(WorldMapPlugin::class.java, "rooftop_course_icon.png")
            ROOFTOP_COURSE_ICON!!.graphics.drawImage(rooftopCourseIcon, 1, 1, null)
        }

        private fun isType(type: MapPoint.Type): Predicate<WorldMapPoint> {
            return Predicate { w: WorldMapPoint ->  w.type == type }
        }
    }
}