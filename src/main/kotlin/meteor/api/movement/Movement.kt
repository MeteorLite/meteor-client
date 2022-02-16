package meteor.api.movement

import Main.client
import meteor.Logger
import meteor.api.commons.Rand
import meteor.api.commons.Time
import meteor.api.entities.Players
import meteor.api.game.Vars
import meteor.api.movement.pathfinder.*
import meteor.api.scene.Tiles
import meteor.api.widgets.Widgets
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Polygon
import java.util.ArrayList

object Movement {
    private val logger: Logger = Logger("Movement")
    private val TILE_BLOCKED_COLOR = Color(0, 128, 255, 128)
    private val TRANSPORT_COLOR = Color(0, 255, 0, 128)
    private const val STAMINA_VARBIT = 25
    private const val RUN_VARP = 173
    fun setDestination(worldX: Int, worldY: Int) {
        walkTo(worldX,worldY)
       // MovementPackets.sendMovement(worldX, worldY, isRunEnabled)
        client.destinationX = worldX - client.baseX
        client.destinationY = worldY - client.baseY
    }

    val destination: WorldPoint?
        get() {
            val local: LocalPoint = client.localDestinationLocation ?: return null
            return WorldPoint.fromLocal(client, local)
        }
    val isWalking: Boolean
        get() {

            val destination: LocalPoint? = client.localDestinationLocation
            return (Players.local.isMoving
                    && destination != null && destination.distanceTo(Players.local.localLocation) > 4)
        }

    fun walk(point: Point) {
        client.interact(0, MenuAction.WALK.id, point.x, point.y)
    }

    fun walk(point: WorldPoint,  sleep: Int = 0) {

        var walkPoint = point

        val tile = Tiles.getTiles { it?.worldLocation == point }.firstOrNull()
        if (tile == null) {
            val nearestTile = Tiles.tiles.minByOrNull { it.distanceTo(walkPoint) }
            if (nearestTile != null) {
                walkPoint = nearestTile.worldLocation
            } else {
                return
            }

            walk(WorldPoint(walkPoint.x, walkPoint.y,0))
        }

        if (sleep > 0) {
            Time.sleepUntil({ isWalking }, sleep.toLong())
        }

    }

    fun walk(worldArea: WorldArea) {
        val local: Player = Players.local
        if (worldArea.contains(local.worldLocation)) {
            return
        }
        val walkPointList: List<WorldPoint> = worldArea.toWorldPointList()
        val losPoints: MutableList<WorldPoint> = ArrayList<WorldPoint>()
        for (point in walkPointList) {
            if (!Reachable.isWalkable(point)) {
                continue
            }
            losPoints.add(point)
        }
        val walkPoint: WorldPoint = losPoints[Rand.nextInt(0, walkPointList.size - 1)]
        walk(walkPoint)
    }

    fun walk(locatable: Locatable) {
        walk(locatable.worldLocation)
    }

    fun walkTo(worldPoint: WorldPoint, radius: Int): Boolean {
        val wp = WorldPoint(
            worldPoint.x + Rand.nextInt(-radius, radius),
            worldPoint.y + Rand.nextInt(-radius, radius),
            worldPoint.plane
        )
        return Walker.walkTo(wp, false)
    }

    fun walkTo(worldArea: WorldArea): Boolean {
        val wpList: List<WorldPoint> = worldArea.toWorldPointList()
        val wp: WorldPoint = wpList[Rand.nextInt(0, wpList.size - 1)]
        return Walker.walkTo(wp, false)
    }

    fun walkTo(worldPoint: WorldPoint): Boolean {
        return Walker.walkTo(worldPoint, false)
    }

    fun walkTo(locatable: Locatable): Boolean {
        return walkTo(locatable.worldLocation)
    }

    fun walkTo(bankLocation: BankLocation): Boolean {
        return walkTo(bankLocation.getArea()!!.toWorldPoint())
    }

    @JvmOverloads
    fun walkTo(x: Int, y: Int, plane: Int = client.plane): Boolean {
        return walkTo(WorldPoint(x, y, plane))
    }

    val isRunEnabled: Boolean
        get() = client.getVarpValue(RUN_VARP) === 1

    @JvmOverloads
    fun drawPath(graphics2D: Graphics2D?, destination: WorldPoint, localRegion: Boolean = false) {
        Walker.buildPath(destination,false)
            .forEach { it.outline(client, graphics2D, Color.RED, null) }
        destination.outline(client, graphics2D, Color.GREEN, "Destination")
    }

    @JvmOverloads
    fun drawCollisions(graphics2D: Graphics2D, collisionMap: CollisionMap? = GlobalCollisionMap()) {
        val client: Client = client
        val tiles: List<Tile> = Tiles.tiles
        if (tiles.isEmpty()) {
            return
        }

        if (collisionMap == null) {
            return
        }
        for (tile in tiles) {
            val poly: Polygon = Perspective.getCanvasTilePoly(client, tile.localLocation) ?: continue
            val sb = StringBuilder("")
            graphics2D.color = Color.WHITE
            if (!collisionMap.n(tile.worldLocation)) {
                sb.append("n")
            }
            if (!collisionMap.s(tile.worldLocation)) {
                sb.append("s")
            }
            if (!collisionMap.w(tile.worldLocation)) {
                sb.append("w")
            }
            if (!collisionMap.e(tile.worldLocation)) {
                sb.append("e")
            }
            val s = sb.toString()
            if (s.isEmpty()) {
                continue
            }
            if (s != "nswe") {
                graphics2D.color = Color.WHITE
                if (s.contains("n")) {
                    graphics2D.drawLine(poly.xpoints[3], poly.ypoints[3], poly.xpoints[2], poly.ypoints[2])
                }
                if (s.contains("s")) {
                    graphics2D.drawLine(poly.xpoints[0], poly.ypoints[0], poly.xpoints[1], poly.ypoints[1])
                }
                if (s.contains("w")) {
                    graphics2D.drawLine(poly.xpoints[0], poly.ypoints[0], poly.xpoints[3], poly.ypoints[3])
                }
                if (s.contains("e")) {
                    graphics2D.drawLine(poly.xpoints[1], poly.ypoints[1], poly.xpoints[2], poly.ypoints[2])
                }
                continue
            }
            graphics2D.color = TILE_BLOCKED_COLOR
            graphics2D.fill(poly)
        }
    }

    fun toggleRun() {
        Widgets.get(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB)?.interact("Toggle Run")
    }

    val isStaminaBoosted: Boolean
        get() = Vars.getBit(STAMINA_VARBIT) === 1

    @JvmOverloads
    fun calculateDistance(destination: WorldPoint, localRegion: Boolean = false): Int {
        val path: List<WorldPoint> = Walker.buildPath(destination,false)
        if (path.size < 2) {
            return 0
        }
        val it: Iterator<WorldPoint> = path.iterator()
        val prev: WorldPoint = it.next()
        var current: WorldPoint
        var distance = 0

        // WorldPoint#distanceTo() returns max int when planes are different, but since the pathfinder can traverse
        // obstacles, we just add one to the distance to account for whatever obstacle is in between the current point
        // and the next.
        while (it.hasNext()) {
            current = it.next()
            if (prev.plane != current.plane) {
                distance += 1
            } else {
                distance += Math.max(Math.abs(prev.x - current.x), Math.abs(prev.y - current.y))
            }
        }
        return distance
    }

    /**
     * Uses the regional collisionmap
     */
    object Local {
        fun walkTo(worldPoint: WorldPoint): Boolean {
            return Walker.walkTo(worldPoint, true)
        }

        fun walkTo(locatable: Locatable): Boolean {
            return walkTo(locatable.worldLocation)
        }

        fun walkTo(bankLocation: BankLocation): Boolean {
            return walkTo(bankLocation.getArea()!!.toWorldPoint())
        }

        @JvmOverloads
        fun walkTo(x: Int, y: Int, plane: Int = client.plane): Boolean {
            return walkTo(WorldPoint(x, y, plane))
        }
    }
}