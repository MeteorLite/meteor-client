package meteor.plugins.guardiansoftherift

import dev.hoot.api.entities.TileObjects
import dev.hoot.api.items.Inventory
import dev.hoot.api.movement.pathfinder.Walker
import eventbus.events.*
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint

@PluginDescriptor(
    name = "Guardians Of The Rift",
    description = "Helpful overlays for the minigame"
)
class GuardiansOfTheRiftPlugin : Plugin() {
    var overlay = overlay(GuardiansOfTheRiftOverlay(this))
    var statsOverlay = overlay(GameStatsOverlay(this))

    private var countdownMessage = "The rift will become active in 30 seconds."
    private var gameStartMessage = "The rift becomes active!"
    private var collectionPhaseEndMessage = "Creatures from the Abyss begin their attack!"
    private var gameEndMessage = "The Great Guardian successfully closed the rift!"
    private var defeatMessage = "The Great Guardian was defeated!"
    private var currentPointsMessage = "Total elemental energy"


    private var GUARDIAN_AIR: GameObject? = null
    private var GUARDIAN_MIND: GameObject? = null
    private var GUARDIAN_BODY: GameObject? = null
    private var GUARDIAN_CHAOS: GameObject? = null
    private var GUARDIAN_DEATH: GameObject? = null
    private var GUARDIAN_LAW: GameObject? = null
    private var GUARDIAN_BLOOD: GameObject? = null
    private var GUARDIAN_FIRE: GameObject? = null
    private var GUARDIAN_NATURE: GameObject? = null
    private var GUARDIAN_EARTH: GameObject? = null
    private var GUARDIAN_WATER: GameObject? = null
    private var GUARDIAN_COSMIC: GameObject? = null

    private var GUARDIAN_REMAINS_1 = 43717
    private var GUARDIAN_PARTS_1 = 43715
    private var GUARDIAN_PARTS_2 = 43716

    private var TELEPORT_ORB = 43729

    var currentElementalrune = -1
    var currentCatalyticrune = -1
    private var currentElementalRuneSpriteID = -1
    private var currentCatalyticRuneSpriteID = -1

    var currentTeleportOrb: GameObject? = null
    var currentTeleportOrbTile: Tile? = null
    var pathToOrb: ArrayList<WorldPoint>? = ArrayList()

    var showRemains = false
    var gameLength = 0
    var countLength = false
    var altars = ArrayList<GameObject>()

    var elementalStoneID = 26881
    var catalyticStoneID = 26880
    var greatGuardianID = 11403

    var countdownTicks = 30000 / 600
    var countDownCount = false
    var countDownLength = countdownTicks

    var collectionTicks = 120000 / 600
    var collectionCount = false
    var collectionLength = collectionTicks

    var battlePhase = false

    var elementalPoints = 0
    var catalyticPoints = 0
    var elementalPriority = false

    fun hasGuardianStones(): Boolean {
        if (Inventory.contains(elementalStoneID, catalyticStoneID))
            return true
        return false
    }

    fun setAltars(): Boolean {
        GUARDIAN_AIR = TileObjects.getNearest(43701) as GameObject?
        GUARDIAN_MIND = TileObjects.getNearest(43705) as GameObject?
        GUARDIAN_BODY = TileObjects.getNearest(43709) as GameObject?
        GUARDIAN_CHAOS = TileObjects.getNearest(43706) as GameObject?
        GUARDIAN_DEATH = TileObjects.getNearest(43707) as GameObject?
        GUARDIAN_LAW = TileObjects.getNearest(43712) as GameObject?
        GUARDIAN_BLOOD = TileObjects.getNearest(43708) as GameObject?
        GUARDIAN_FIRE = TileObjects.getNearest(43704) as GameObject?
        GUARDIAN_NATURE = TileObjects.getNearest(43711) as GameObject?
        GUARDIAN_EARTH = TileObjects.getNearest(43703) as GameObject?
        GUARDIAN_WATER = TileObjects.getNearest(43702) as GameObject?
        GUARDIAN_COSMIC = TileObjects.getNearest(43710) as GameObject?
        try {
            altars.add(GUARDIAN_AIR!!)
            altars.add(GUARDIAN_MIND!!)
            altars.add(GUARDIAN_BODY!!)
            altars.add(GUARDIAN_CHAOS!!)
            altars.add(GUARDIAN_DEATH!!)
            altars.add(GUARDIAN_LAW!!)
            altars.add(GUARDIAN_BLOOD!!)
            altars.add(GUARDIAN_FIRE!!)
            altars.add(GUARDIAN_NATURE!!)
            altars.add(GUARDIAN_EARTH!!)
            altars.add(GUARDIAN_WATER!!)
            altars.add(GUARDIAN_COSMIC!!)
        } catch (e: Exception) {
            altars.clear()
            return false
        }
        return true
    }


    fun getRemains(): ArrayList<TileObject> {
        val remains = TileObjects.getAll(GUARDIAN_REMAINS_1, GUARDIAN_PARTS_1, GUARDIAN_PARTS_2)
        return remains as ArrayList<TileObject>
    }

    fun getActiveAltars(): ArrayList<TileObject> {
        val activeAltars = ArrayList<TileObject>()
        for (altar in altars) {
            val animation = (altar.renderable as DynamicObject).animation
            if (animation != null) {
                if (animation.id == 9363)
                    activeAltars.add(altar)
            }
        }
        return activeAltars
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.LOADING -> reset()
            else -> {}
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        when (it.gameObject.id) {
            TELEPORT_ORB -> {
                currentTeleportOrb = it.gameObject
                currentTeleportOrbTile = it.tile
            }
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        when (it.gameObject.id) {
            TELEPORT_ORB -> {
                currentTeleportOrb = null
                currentTeleportOrbTile = null
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        if (countLength)
            gameLength++

        if (countDownCount)
            countDownLength--

        if (countDownLength == 0)
            countDownCount = false

        if (gameLength in 1..201) {
            collectionCount = true
            collectionLength = gameLength
        }


        if (collectionLength == 201)
            collectionCount = false

        if (altars.isEmpty())
            setAltars()

        if (currentTeleportOrb != null)
            pathToOrb = Walker.buildPath(currentTeleportOrb!!.worldLocation, true)
        else
            pathToOrb?.clear()

        val elemental = client.getWidget(746, 20)
        val catalytic = client.getWidget(746, 23)
        elemental?.let {
            if (!it.isHidden)
                currentElementalRuneSpriteID = it.spriteId
        }
        catalytic?.let {
            if (!it.isHidden)
                currentCatalyticRuneSpriteID = it.spriteId
        }

        when (currentElementalRuneSpriteID) {
            4353 -> currentElementalrune = ItemID.AIR_RUNE
            4354 -> currentElementalrune = ItemID.MIND_RUNE
            4355 -> currentElementalrune = ItemID.WATER_RUNE
            4356 -> currentElementalrune = ItemID.EARTH_RUNE
            4357 -> currentElementalrune = ItemID.FIRE_RUNE
            4358 -> currentElementalrune = ItemID.BODY_RUNE
            4359 -> currentElementalrune = ItemID.COSMIC_RUNE
            4360 -> currentElementalrune = ItemID.CHAOS_RUNE
            4361 -> currentElementalrune = ItemID.NATURE_RUNE
            4362 -> currentElementalrune = ItemID.LAW_RUNE
            4363 -> currentElementalrune = ItemID.DEATH_RUNE
            4364 -> currentElementalrune = ItemID.BLOOD_RUNE
            else -> currentElementalrune = -1
        }

        when (currentCatalyticRuneSpriteID) {
            4353 -> currentCatalyticrune = ItemID.AIR_RUNE
            4354 -> currentCatalyticrune = ItemID.MIND_RUNE
            4355 -> currentCatalyticrune = ItemID.WATER_RUNE
            4356 -> currentCatalyticrune = ItemID.EARTH_RUNE
            4357 -> currentCatalyticrune = ItemID.FIRE_RUNE
            4358 -> currentCatalyticrune = ItemID.BODY_RUNE
            4359 -> currentCatalyticrune = ItemID.COSMIC_RUNE
            4360 -> currentCatalyticrune = ItemID.CHAOS_RUNE
            4361 -> currentCatalyticrune = ItemID.NATURE_RUNE
            4362 -> currentCatalyticrune = ItemID.LAW_RUNE
            4363 -> currentCatalyticrune = ItemID.DEATH_RUNE
            4364 -> currentCatalyticrune = ItemID.BLOOD_RUNE
            else -> currentCatalyticrune = -1
        }

        elementalPriority = elementalPoints < catalyticPoints
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.message.contains(countdownMessage)) {
            countDownLength = countdownTicks
            countDownCount = true
        } else if (it.message.contains(gameStartMessage)) {
            ConfigManager.getPlayerConfiguration("elementalPoints")?.let {
                if (it.isNotEmpty())
                    elementalPoints = it.toInt()
            }
            ConfigManager.getPlayerConfiguration("catalyticPoints")?.let {
                if (it.isNotEmpty())
                    catalyticPoints = it.toInt()
            }
            showRemains = true
            gameLength = 0
            countLength = true
        } else if (it.message.contains(collectionPhaseEndMessage)) {
            battlePhase = true
        } else if (it.message.contains(gameEndMessage) || it.message.contains(defeatMessage)) {
            countLength = false
            gameLength = 0
            battlePhase = false
            reset()
        } else if (it.message.contains(currentPointsMessage)) {
            elementalPoints = it.message.split("energy: ")[1].split(".")[0].split(">")[1].split("<")[0].toInt()
            ConfigManager.setPlayerConfiguration("elementalPoints", elementalPoints)
            catalyticPoints = it.message.split("energy: ")[2].split(".")[0].split(">")[1].split("<")[0].toInt()
            ConfigManager.setPlayerConfiguration("catalyticPoints", catalyticPoints)
        }
    }

    fun reset() {
        altars.clear()

        currentTeleportOrbTile = null
        currentTeleportOrb = null
    }
}