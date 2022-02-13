package meteor.api.widgets

import Main.client
import meteor.api.game.GameThread
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

object Widgets {
    operator fun get(widgetInfo: WidgetInfo?): Widget? {
        return client.getWidget(widgetInfo)
    }

    operator fun get(group: Int, id: Int): Widget? {
        return client.getWidget(group, id)
    }

    operator fun get(group: Int, id: Int, child: Int): Widget? {
        return if (Widgets[group, id] == null) null else Widgets[group, id]!!.getChild(child)
    }

    operator fun get(group: Int): List<Widget?> {
        val widgets: Array<Widget> = client.getWidgets().get(group)
            ?: return emptyList<Widget>()
        return Arrays.asList(*widgets)
    }

    operator fun get(group: Int, filter: Predicate<Widget?>?): Widget? {
        return Widgets[group].stream().filter(filter).findFirst().orElse(null)
    }

    fun getChildren(widget: Widget?, filter: Predicate<Widget>?): List<Widget> {
        if (widget == null) {
            return emptyList()
        }
        val children = widget.children ?: return emptyList()
        return Arrays.stream(children).filter(filter).collect(Collectors.toList())
    }

    fun getChildren(widgetInfo: WidgetInfo?, filter: Predicate<Widget>?): List<Widget> {
        return getChildren(Widgets[widgetInfo], filter)
    }

    fun getChildren(group: Int, child: Int, filter: Predicate<Widget>?): List<Widget> {
        return getChildren(Widgets[group, child], filter)
    }

    fun getAll(group: Int, filter: Predicate<Widget?>?): List<Widget?> {
        return Widgets[group].stream().filter(filter).collect(Collectors.toList())
    }

    fun fromId(packedId: Int): Widget? {
        return client.getWidget(packedId)
    }

    fun isVisible(widget: Widget?): Boolean {
        return (widget != null) && !GameThread.invokeLater { widget.isHidden }!!
    }
}