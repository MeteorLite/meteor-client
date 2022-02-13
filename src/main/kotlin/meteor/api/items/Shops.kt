package meteor.api.items


import meteor.api.game.GameThread
import meteor.api.widgets.Widgets
import net.runelite.api.widgets.Widget
import java.util.*
import java.util.function.Supplier
import java.util.function.ToIntFunction

object Shops {
    private val SHOP = Supplier<Widget> { Widgets.get(300, 0) }
    private val SHOP_ITEMS = Supplier<Widget> { Widgets.get(300, 16) }
    private val INVENTORY = Supplier<Widget> { Widgets.get(301, 0) }
    val isOpen: Boolean
        get() {
            val widget = SHOP.get()
            return widget != null && !GameThread.invokeLater { widget.isHidden }
        }

    fun getStock(itemId: Int): Int {
        val items = SHOP_ITEMS.get()
        if (items == null || GameThread.invokeLater { items.isHidden }) {
            return 0
        }
        val children = items.children ?: return 0
        return Arrays.stream(children)
            .filter { child: Widget -> child.itemId == itemId }
            .mapToInt(ToIntFunction<Widget> { obj: Widget -> obj.itemQuantity })
            .sum()
    }

    fun buyOne(itemId: Int) {
        buy(itemId, 1)
    }

    fun buyFive(itemId: Int) {
        buy(itemId, 5)
    }

    fun buyTen(itemId: Int) {
        buy(itemId, 10)
    }

    fun buyFifty(itemId: Int) {
        buy(itemId, 50)
    }

    fun sellOne(itemId: Int) {
        sell(itemId, 1)
    }

    fun sellFive(itemId: Int) {
        sell(itemId, 5)
    }

    fun sellTen(itemId: Int) {
        sell(itemId, 10)
    }

    fun sellFifty(itemId: Int) {
        sell(itemId, 50)
    }

    val items: List<Int>
        get() {
            val out: MutableList<Int> = ArrayList()
            val container = SHOP_ITEMS.get() ?: return out
            val items = container.children ?: return out
            for (item in items) {
                if (item.id != -1) {
                    out.add(item.id)
                }
            }
            return out
        }

    private fun buy(itemId: Int, amount: Int) {
        val container = SHOP_ITEMS.get()
        exchange(itemId, amount, container)
    }

    private fun sell(itemId: Int, amount: Int) {
        val container = INVENTORY.get()
        exchange(itemId, amount, container)
    }

    private fun exchange(itemId: Int, amount: Int, container: Widget?) {
        if (container == null) {
            return
        }
        val items = container.children ?: return
        for (item in items) {
            if (item.itemId == itemId) {
                val action = item.actions.stream()
                    .filter { x: String? -> x != null && x.contains(amount.toString()) }
                    .findFirst()
                    .orElse(null) ?: return
                item.interact(action)
                return
            }
        }
    }
}