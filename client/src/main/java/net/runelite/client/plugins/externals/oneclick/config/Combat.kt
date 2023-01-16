package net.runelite.client.plugins.externals.oneclick.config

import net.runelite.client.plugins.externals.oneclick.clickables.Clickable
import net.runelite.client.plugins.externals.oneclick.clickables.combat.Slayer
import net.runelite.client.plugins.externals.oneclick.clickables.combat.Vorkath
import java.util.*
import java.util.Set
import java.util.stream.Collectors
import kotlin.collections.List

enum class Combat(val clazz: Class<out Clickable>) {
    SLAYER(Slayer::class.java), VORKATH(Vorkath::class.java);

    companion object {
        fun createInstances(combats: Array<Combat>): List<Clickable> {
            val set = mutableSetOf(*combats)
            return set.stream()
                .filter { obj: Combat -> Objects.nonNull(obj) }
                .map { skilling: Combat ->
                    try {
                        return@map skilling.clazz.newInstance()
                    } catch (e: InstantiationException) {
                        throw RuntimeException(e)
                    } catch (e: IllegalAccessException) {
                        throw RuntimeException(e)
                    }
                }
                .collect(Collectors.toList())
        }
    }
}