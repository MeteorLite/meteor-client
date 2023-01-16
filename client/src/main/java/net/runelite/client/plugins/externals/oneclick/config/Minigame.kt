package net.runelite.client.plugins.externals.oneclick.config

import lombok.AllArgsConstructor
import lombok.Getter
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable
import net.runelite.client.plugins.externals.oneclick.clickables.minigames.Healers
import net.runelite.client.plugins.externals.oneclick.clickables.minigames.TroubleBrewing
import java.util.*
import java.util.Set
import java.util.stream.Collectors
import kotlin.collections.List

@Getter
@AllArgsConstructor
enum class Minigame(val clazz: Class<out Clickable>) {
    BA_HEALERS(Healers::class.java), TR_BREWING(TroubleBrewing::class.java), MTA(net.runelite.client.plugins.externals.oneclick.clickables.minigames.MTA::class.java);

    companion object {
        fun createInstances(minigames: Array<Minigame>): List<Clickable> {
            val set = mutableSetOf(*minigames)
            return set.stream()
                .filter { obj: Minigame -> Objects.nonNull(obj) }
                .map { skilling: Minigame ->
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