package meteor.api.entities

import Main.client

import net.runelite.api.Actor
import net.runelite.api.Projectile
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.util.Comparator
import java.util.function.Predicate
import java.util.function.ToIntFunction
import java.util.stream.Collectors

object Projectiles {
    fun getAll(filter: Predicate<Projectile>): List<Projectile?> {
        return client.getProjectiles().stream()
            .filter { projectile -> projectile != null && filter.test(projectile) }
            .collect(Collectors.toList())
    }

    fun getAll(vararg ids: Int): List<Projectile?> {
        return getAll { x: Projectile ->
            for (id in ids) {
                if (id == x.id) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getNearest(filter: Predicate<Projectile>): Projectile? {
        return getAll(filter).stream()
            .min(
                Comparator.comparingInt { p: Projectile? ->
                    WorldPoint.fromLocal(client, p!!.x.toInt(), p.y.toInt(), client.getPlane())
                        .distanceTo(Players.local.worldLocation)
                }
            )
            .orElse(null)
    }

    fun getNearest(vararg ids: Int): Projectile? {
        return getNearest { x: Projectile ->
            for (id in ids) {
                if (id == x.id) {
                    return@getNearest true
                }
            }
            false
        }
    }

    fun getNearest(target: Actor): Projectile? {
        return getNearest { x: Projectile -> x.interacting != null && x.interacting == target }
    }

    fun getNearest(startPoint: WorldPoint?): Projectile? {
        val localPoint = LocalPoint.fromWorld(client, startPoint) ?: return null
        return getNearest { x: Projectile -> x.x1 == localPoint.x && x.y1 == localPoint.y }
    }
}