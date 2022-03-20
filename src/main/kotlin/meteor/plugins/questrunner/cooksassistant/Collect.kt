package meteor.plugins.questrunner.cooksassistant

import Main.client
import meteor.api.coords.RectangularArea
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.api.items.Inventory
import meteor.plugins.PluginManager
import meteor.plugins.questrunner.QuestRunnerPlugin
import meteor.plugins.questrunner.Util.interactObject
import meteor.plugins.questrunner.Util.openObstacle
import meteor.plugins.questrunner.Util.pickupItem
import meteor.plugins.questrunner.Util.travelWorldArea
import net.runelite.api.ItemID
import net.runelite.api.ObjectID
import net.runelite.api.coords.WorldPoint

object Collect {
    val runner = PluginManager.get<QuestRunnerPlugin>().get<CooksAssistantRunner>()

    private const val wheat = ObjectID.WHEAT_15507
    val wheatFieldEntranceArea = RectangularArea(3159, 3286,3167, 3294)
    val randomWheatFieldEntrancePoint = wheatFieldEntranceArea.getRandomTile()
    const val closedWheatGate = ObjectID.GATE_1560

    private val windmillArea = RectangularArea(3163, 3300,3170, 3304)
    private const val closedWindmillDoor = ObjectID.LARGE_DOOR_1521
    private const val firstFloorLadder = ObjectID.LADDER_12964
    private const val secondFloorLadder = ObjectID.LADDER_12965
    private const val hopper = ObjectID.HOPPER_24961
    private const val grain = ItemID.GRAIN
    private const val thirdFloorLadder = ObjectID.LADDER_12966
    private const val hopperControls = ObjectID.HOPPER_CONTROLS_24964
    private const val flourBin = 1781

    private val cowArea = RectangularArea(3243, 3263,3251, 3270)
    private val randomCowAreaPoint = cowArea.getRandomTile()
    const val closedGate = ObjectID.GATE_1558
    private const val dairyCow = ObjectID.DAIRY_COW

    private val chickenArea = RectangularArea(3238, 3290,3241, 3292)
    val egg = ItemID.EGG

    fun potOfFlour() {
        val grain = Inventory.getFirst(grain)
        when (client.plane) {
            0 -> {
                if (grain == null && !runner.hopperIsFilled) {
                    wheat()
                    return
                }

                if (travelWorldArea(windmillArea))
                    return

                if (interactObject(closedWindmillDoor, "Open"))
                    return

                if (interactObject(flourBin, "Empty"))
                    return

                if (interactObject(firstFloorLadder, "Climb-up"))
                    return

            }
            1 -> {
                val secondFloorLadder = Objects.getNearest(secondFloorLadder)
                if (secondFloorLadder != null) {
                    if (runner.hopperIsFilled)
                        secondFloorLadder.interact("Climb-down")
                    else
                        secondFloorLadder.interact("Climb-up")
                    return
                }
            }
            2 -> {
                val hopper = Objects.getNearest(hopper)
                if (hopper != null && grain != null && !runner.grainAlreadyLoaded && !runner.hopperIsFilled) {
                    grain.useOn(hopper)
                    return
                }
                if (!runner.hopperIsFilled) {
                    if (interactObject(hopperControls, 0)) // Operate
                        return
                }
                else {
                    if (interactObject(thirdFloorLadder, "Climb-down"))
                        return
                }
            }
        }
    }

    fun wheat() {
        if (travelWorldArea(wheatFieldEntranceArea))
            return

        if (openObstacle(closedWheatGate, WorldPoint(3162, 3290, 0)))
            return

        interactObject(wheat, "Pick")
    }

    fun egg() {
        if (openObstacle(closedGate, WorldPoint(3253, 3266, 0)))
            return

        if (travelWorldArea(chickenArea))
            return

        if (openObstacle(closedGate, WorldPoint(3236, 3296, 0)))
            return

        pickupItem(egg)
    }

    fun bucketOfMilk() {
        if (randomWheatFieldEntrancePoint.distanceTo(Players.local.worldLocation) < 14)
            if (openObstacle(closedWindmillDoor))
                return

        if (travelWorldArea(cowArea))
            return

        if (openObstacle(closedGate, WorldPoint(3253, 3266, 0)))
            return

        interactObject(dairyCow, "Milk", waitTicks = 5)
    }
}