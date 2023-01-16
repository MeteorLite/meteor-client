package net.runelite.client.plugins.externals.oneclick.config

import lombok.Getter
import net.runelite.client.plugins.externals.oneclick.clickables.Clickable
import net.runelite.client.plugins.externals.oneclick.clickables.custom.CustomInventory
import java.util.*
import java.util.Set
import java.util.stream.Collectors

@Getter
enum class Custom(val clazz: Class<out Clickable>) {
    CUSTOM_INV(CustomInventory::class.java as Class<Clickable>);

    companion object {
        fun createInstances(customs: Array<Custom>): List<Clickable> {
            val set = mutableSetOf(*customs)
            return set.stream()
                .filter { obj: Custom -> Objects.nonNull(obj) }
                .map { skilling: Custom ->
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