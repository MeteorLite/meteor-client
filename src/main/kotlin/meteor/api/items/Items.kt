package meteor.api.items


import net.runelite.api.Item
import java.util.function.Predicate

abstract class Items {
    protected abstract fun all(filter: Predicate<Item>): List<Item?>
    fun all(vararg names: String): List<Item?> {
        return all { x: Item ->
            if (x.name == null) {
                return@all false
            }
            for (name in names) {
                if (name == x.name) {
                    return@all true
                }
            }
            false
        }
    }

    fun all(vararg ids: Int): List<Item?> {
        return all { x: Item ->
            for (id in ids) {
                if (id == x.id) {
                    return@all true
                }
            }
            false
        }
    }

    fun first(filter: Predicate<Item>): Item? {
        return all(filter).stream().findFirst().orElse(null)
    }

    fun first(vararg ids: Int): Item? {
        return first { x: Item ->
            for (id in ids) {
                if (id == x.id) {
                    return@first true
                }
            }
            false
        }
    }

    fun first(vararg names: String): Item? {
        return first { x: Item ->
            if (x.name == null) {
                return@first false
            }
            for (name in names) {
                if (name == x.name) {
                    return@first true
                }
            }
            false
        }
    }

    fun exists(filter: Predicate<Item>): Boolean {
        return first(filter) != null
    }

    fun exists(name: String?): Boolean {
        return first(name!!) != null
    }

    fun exists(id: Int): Boolean {
        return first(id) != null
    }
}