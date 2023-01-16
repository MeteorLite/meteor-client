package net.runelite.client.plugins.externals.oneclick.config

import net.runelite.client.plugins.externals.oneclick.clickables.Clickable
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.*
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.farming.FarmingRun
import net.runelite.client.plugins.externals.oneclick.clickables.skilling.farming.TitheFarm
import java.util.*
import java.util.Set
import java.util.stream.Collectors
import kotlin.collections.List

enum class Skilling(val clazz: Class<out Clickable>) {
    BIRDHOUSES(Birdhouses::class.java), BONES(Bones::class.java), FARMING_RUN(FarmingRun::class.java), HIGH_ALCH(
        HighAlch::class.java
    ),
    KARAMBWANS(Karams::class.java), RUNES(Runes::class.java), TIARA(Tiaras::class.java), TITHE_FARM(
        TitheFarm::class.java
    );

    companion object {
        fun createInstances(skillings: Array<Skilling>): List<Clickable> {
            val set = mutableSetOf(*skillings)
            return set.stream()
                .filter { obj: Skilling -> Objects.nonNull(obj) }
                .map { skilling: Skilling ->
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