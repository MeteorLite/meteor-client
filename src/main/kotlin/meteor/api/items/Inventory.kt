package meteor.api.items

import Main.client
import meteor.api.game.GameThread
import net.runelite.api.InventoryID
import net.runelite.api.Item
import net.runelite.api.ItemContainer
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

object Inventory : Items() {
    override fun all(filter: Predicate<Item>): List<Item> {
        val items: MutableList<Item> = ArrayList()
        val container: ItemContainer = client.getItemContainer(InventoryID.INVENTORY)
            ?: return items
        cacheItems(container)
        for (item in container.items) {
            if (item.id != -1 && item.name != null && item.name != "null") {
                item.actionParam = item.slot
                item.widgetId = WidgetInfo.INVENTORY.packedId
                if (filter.test(item)) {
                    items.add(item)
                }
            }
        }
        return items
    }

    fun getAll(filter: Predicate<Item>): List<Item> {
        return all(filter)
    }

    val all: List<Item>
        get() = getAll { x: Item -> true }

    fun getAll(vararg ids: Int): List<Item?>? {
        return all(*ids)
    }

    fun getAll(vararg names: String): List<Item?> {
        return getAll { x: Item ->
            if (x.name == null) {
                return@getAll false
            }
            for (name in names) {
                if (name == x.name) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getFirst(filter: Predicate<Item>): Item? {
        return first(filter)
    }

    fun getFirst(vararg ids: Int): Item? {
        return first(*ids)
    }

    fun getFirst(vararg names: String): Item? {
        return first(*names)
    }

    operator fun contains(filter: Predicate<Item>): Boolean {
        return exists(filter)
    }

    operator fun contains(id: Int): Boolean {
        return exists(id)
    }

    operator fun contains(name: String?): Boolean {
        return exists(name)
    }

    val isFull: Boolean
        get() = freeSlots == 0
    val isEmpty: Boolean
        get() = freeSlots == 28
    val freeSlots: Int
        get() = 28 - all.size

    fun cacheItems(container: ItemContainer) {
        val uncached = Arrays.stream(container.items)
            .filter { x: Item -> !client.isItemDefinitionCached(x.id) }
            .collect(Collectors.toList())
        if (!uncached.isEmpty()) {
            GameThread.invokeLater {
                for (item in uncached) {
                    client.getItemComposition(item.id)
                }
                null
            }
        }
    }
}