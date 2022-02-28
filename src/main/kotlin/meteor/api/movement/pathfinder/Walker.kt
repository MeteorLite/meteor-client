package meteor.api.movement.pathfinder

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import meteor.Logger
import meteor.api.commons.Rand
import meteor.api.commons.Time
import meteor.api.entities.Players
import meteor.api.game.Game
import meteor.api.movement.Movement
import meteor.api.movement.Reachable
import meteor.api.scene.Tiles
import net.runelite.api.Player
import net.runelite.api.Tile
import net.runelite.api.WallObject
import net.runelite.api.coords.WorldPoint
import java.util.ArrayList
import java.util.Comparator
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit

object Walker {
    private val logger: Logger = Logger("Walker")
    private const val MAX_INTERACT_DISTANCE = 20
    private const val MIN_TILES_WALKED_IN_STEP = 7
    private const val MAX_TILES_WALKED_IN_STEP = 14
    private const val MIN_TILES_WALKED_BEFORE_RECHOOSE = 10
    private const val MIN_TILES_LEFT_BEFORE_RECHOOSE = 3
    private const val MAX_MIN_ENERGY = 50
    private const val MIN_ENERGY = 5
    val PATH_CACHE: LoadingCache<WorldPoint, List<WorldPoint>> = CacheBuilder.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .build(object : CacheLoader<WorldPoint, List<WorldPoint>>() {
            override fun load(key: WorldPoint): List<WorldPoint> {
                logger.debug("Loading path to {}", key)
                return buildPath(key, false)
            }
        })
    val LOCAL_PATH_CACHE: LoadingCache<WorldPoint, List<WorldPoint>> = CacheBuilder.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)
        .build(object : CacheLoader<WorldPoint, List<WorldPoint>>() {
            override fun load(key: WorldPoint): List<WorldPoint> {
                logger.debug("Loading local path to {}", key)
                return buildPath(key, true)
            }
        })

    fun walkTo(destination: WorldPoint, localRegion: Boolean): Boolean {
        val local: Player = Players.local
        if (destination == local.worldLocation) {
            return true
        }
        val transports: Map<WorldPoint, MutableList<Transport>> = buildTransportLinks()
        val teleports: LinkedHashMap<WorldPoint, Teleport> = buildTeleportLinks(destination)
        val path: List<WorldPoint>? = if (!localRegion) {
            try {
                PATH_CACHE.get(destination)
            } catch (e: ExecutionException) {
                logger.error("Failed to get cached path", e)
                return false
            }
        } else {
            try {
                LOCAL_PATH_CACHE.get(destination)
            } catch (e: ExecutionException) {
                logger.error("Failed to get cached path", e)
                return false
            }
        }
        if (path == null) {
            logger.error("Path is null")
            return false
        }
        if (path.isEmpty()) {
            logger.error("Path was empty")
            return false
        }
        val startPosition: WorldPoint? = path[0]
        val teleport = teleports[startPosition]
        if (teleport != null) {
            logger.debug("Casting teleport {}", teleport)
            teleport.handler.run()
            Time.sleep(5000)
            return false
        }

        // Refresh path if our direction changed
        if (!local.isAnimating && !path.contains(local.worldLocation)) {
            logger.debug("Direction changed, resetting cached path towards {}", destination)
            LOCAL_PATH_CACHE.refresh(destination)
            PATH_CACHE.refresh(destination)
            return false
        }
        return walkAlong(destination, path, transports)
    }

    fun walkAlong(
        destination: WorldPoint,
        path: List<WorldPoint?>?,
        transports: Map<WorldPoint, MutableList<Transport>>
    ): Boolean {
        val local: Player = Players.local
        val endTile: WorldPoint? = path!![path.size - 1]
        if (endTile != null) {
            if (endTile != destination && endTile.distanceTo(destination) > 5) {
                logger.debug("Destination {} was not in path, recalculating", destination)
                PATH_CACHE.refresh(destination)
                LOCAL_PATH_CACHE.refresh(destination)
            }
        }
        if (local.worldLocation.distanceTo(endTile) > 0) {
            val remainingPath: List<WorldPoint?> = remainingPath(path)
            return if (handleTransports(remainingPath, transports)) {
                false
            } else stepAlong(remainingPath)
        }
        return false
    }

    fun stepAlong(path: List<WorldPoint?>): Boolean {
        val reachablePath: List<WorldPoint?> = reachablePath(path)
        if (reachablePath.isEmpty()) {
            return false
        }
        var nextTileIdx = reachablePath.size - 1
        if (nextTileIdx <= MIN_TILES_WALKED_IN_STEP) {
            return step(reachablePath[nextTileIdx]!!)
        }
        if (nextTileIdx > MAX_TILES_WALKED_IN_STEP) {
            nextTileIdx = MAX_TILES_WALKED_IN_STEP
        }
        val targetDistance: Int = Rand.nextInt(MIN_TILES_WALKED_IN_STEP, nextTileIdx)
        return step(reachablePath[targetDistance]!!)
    }

    fun reachablePath(remainingPath: List<WorldPoint?>): List<WorldPoint?> {
        val local: Player = Players.local
        val out: MutableList<WorldPoint?> = ArrayList<WorldPoint?>()
        for (p in remainingPath) {
            val tile: Tile = Tiles.getAt(p!!) ?: break
            out.add(p)
        }
        return if (out.isEmpty() || out.size == 1 && out[0] == local.worldLocation) {
            emptyList<WorldPoint>()
        } else out
    }

    fun step(destination: WorldPoint): Boolean {
        val local: Player = Players.local
        logger.debug("Stepping towards $destination")
        Movement.walk(destination)
        if (local.worldLocation == destination) {
            return false
        }
        if (!Movement.isRunEnabled && (Main.client.energy >= Rand.nextInt(
                MIN_ENERGY,
                MAX_MIN_ENERGY
            ) || local.healthScale > -1 && Main.client.energy > 0)
        ) {
            Movement.toggleRun()
            Time.sleepUntil(Movement::isRunEnabled, 2000)
            return true
        }
        if (!Movement.isRunEnabled && Main.client.energy > 0 && Movement.isStaminaBoosted) {
            Movement.toggleRun()
            Time.sleepUntil(Movement::isRunEnabled, 2000)
            return true
        }
        return true
    }

    fun recalculateDistance(targetDistance: Int): Int {
        var rechoose: Int =
            MIN_TILES_WALKED_BEFORE_RECHOOSE + Rand.nextInt(0, targetDistance - MIN_TILES_WALKED_BEFORE_RECHOOSE + 1)
        rechoose = Math.min(rechoose, targetDistance - MIN_TILES_LEFT_BEFORE_RECHOOSE)
        return rechoose
    }

    fun handleTransports(path: List<WorldPoint?>, transports: Map<WorldPoint, MutableList<Transport>>): Boolean {
        val local: Player = Players.local
        for (i in 0 until MAX_INTERACT_DISTANCE) {
            if (i + 1 >= path.size) {
                break
            }
            val a: WorldPoint = path[i]!!
            val b: WorldPoint? = path[i + 1]
            val tileA: Tile = Tiles.getAt(a) ?: return false
            val transportTargets: List<Transport?>? = transports[a]
            if (transportTargets != null) {
                val transport = transportTargets.stream().filter { x: Transport? -> x!!.destination == b }
                    .findFirst().orElse(null)
                if (transport != null && local.worldLocation.distanceTo(transport.source) <= transport.sourceRadius) {
                    logger.debug("Trying to use transport at {}", transport.source)
                    transport.handler.run()
                    Time.sleep(2800)
                    return true
                }
            }
            val tileB: Tile = b?.let { Tiles.getAt(it) } ?: return false
            if (Reachable.isDoored(tileA, tileB)) {
                val wall: WallObject = tileA.wallObject
                wall.interact("Open")
                logger.debug("Handling door {}", wall.worldLocation)
                Time.sleepUntil({
                    (tileA.wallObject == null
                            || !wall.hasAction("Open"))
                }, 2000)
                return true
            }
            if (Reachable.isDoored(tileB, tileA)) {
                val wall: WallObject = tileB.wallObject
                wall.interact("Open")
                logger.debug("Handling door {}", wall.worldLocation)
                Time.sleepUntil({
                    (tileB.wallObject == null
                            || !wall.hasAction("Open"))
                }, 2000)
                return true
            }
        }
        return false
    }

    fun remainingPath(path: List<WorldPoint?>?): List<WorldPoint?> {
        val local: Player = Players.local
        val nearest: WorldPoint = path!!.stream()
            .min(Comparator.comparingInt<WorldPoint?> { x: WorldPoint -> x.distanceTo(local.worldLocation) })
            .orElse(null) ?: return emptyList<WorldPoint>()
        return path.subList(path.indexOf(nearest), path.size)
    }

    fun calculatePath(
        startPoints: List<WorldPoint>,
        destination: WorldPoint,
        transports: Map<WorldPoint, List<Transport>>,
        local: Boolean
    ): List<WorldPoint> {
        val collisionMap: CollisionMap = (if (local) LocalCollisionMap() else Game.globalCollisionMap)
        logger.debug("Calculating path towards {}", destination)
        return Pathfinder(
            collisionMap, transports, startPoints,
            destination
        ).find()
    }

    fun buildTransportLinks(): Map<WorldPoint, ArrayList<Transport>> {
        val out: MutableMap<WorldPoint, ArrayList<Transport>> = HashMap()
        for (transport in TransportLoader.buildTransports()) {
            out.computeIfAbsent(
                transport.source
            ) { x: WorldPoint -> ArrayList() }.add(transport)
        }
        return out
    }

    fun buildPath(destination: WorldPoint, localRegion: Boolean): List<WorldPoint> {
        val local: Player = Players.local
        val transports: Map<WorldPoint, ArrayList<Transport>> = buildTransportLinks()
        val teleports: LinkedHashMap<WorldPoint, Teleport> = buildTeleportLinks(destination)
        val startPoints: ArrayList<WorldPoint> = ArrayList<WorldPoint>(teleports.keys)
        startPoints.add(local.worldLocation)
        return calculatePath(startPoints, destination, transports, localRegion)
    }

    fun buildTeleportLinks(destination: WorldPoint): LinkedHashMap<WorldPoint, Teleport> {
        val out: LinkedHashMap<WorldPoint, Teleport> = LinkedHashMap()
        val local: Player = Players.local
        for (teleport in TeleportLoader.buildTeleports()) {
            if (teleport.destination.distanceTo(local.worldLocation) > 50
                && local.worldLocation.distanceTo(destination) > teleport.destination.distanceTo(destination) + 20
            ) {
                out.putIfAbsent(teleport.destination, teleport)
            }
        }
        return out
    }
}