package meteor.api.game

import Main.client
import meteor.api.commons.Time
import meteor.api.widgets.Tab
import meteor.api.widgets.Tabs
import meteor.api.widgets.Widgets
import net.runelite.api.VarPlayer
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.function.Supplier

object GameSettings {
    enum class Display(val widgetSupplier: Supplier<Widget?>) {
        FIXED(Supplier { Widgets[WidgetInfo.FIXED_VIEWPORT] }), RESIZABLE_MODERN(
            Supplier { Widgets[WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_MAGIC_TAB] }),
        RESIZABLE_CLASSIC(
            Supplier { Widgets[WidgetInfo.RESIZABLE_VIEWPORT_INTERFACE_CONTAINER] });

        companion object {
            fun setMode(displayMode: Display?) {
                if (!Tabs.isOpen(Tab.OPTIONS)) {
                    Tabs.open(Tab.OPTIONS)
                    Time.sleepUntil({ Tabs.isOpen(Tab.OPTIONS) }, 2000)
                }
                when (displayMode) {
                    FIXED -> GameThread.invoke { client.runScript(3998, 0) }
                    RESIZABLE_MODERN -> GameThread.invoke { client.runScript(3998, 1) }
                    RESIZABLE_CLASSIC -> GameThread.invoke {

                        // I have no fuckin idea but it works
                        client.runScript(441, 7602188, 7602213, 7602207, 7602209, 7602214, 7602215, 7602176)
                        client.interact(1, 57, 2, 7602213)
                    }
                }
            }

            val currentMode: Display?
                get() {
                    for (display in values()) {
                        val widget = display.widgetSupplier.get()
                        if (widget != null && !GameThread.invokeLater { widget.isHidden() }!!) {
                            return display
                        }
                    }
                    return null
                }
        }
    }

    enum class Audio(val widgetSupplier: Supplier<Widget?>, val levelVarp: Int) {
        MUSIC(Supplier { Widgets[116, 39] }, VarPlayer.MUSIC_VOLUME.id), EFFECTS(
            Supplier { Widgets[116, 53] }, VarPlayer.SOUND_EFFECT_VOLUME.id
        ),
        AREA(
            Supplier { Widgets[116, 67] }, VarPlayer.AREA_EFFECT_VOLUME.id
        );

        val level: Int
            get() = Vars.getVarp(levelVarp)

        fun setVolume(level: Int) {
            if (level != level) {
                if (!Tabs.isOpen(Tab.OPTIONS)) {
                    Tabs.open(Tab.OPTIONS)
                    Time.sleepUntil({ Tabs.isOpen(Tab.OPTIONS) }, 2000)
                }
                val widget = widgetSupplier.get()
                if (widget?.getChild(level) != null) {
                    widget.getChild(level).interact(0)
                }
            }
        }

        companion object {
            val isFullMuted: Boolean
                get() = MUSIC.level == 0 && AREA.level == 0 && EFFECTS.level == 0

            fun muteAll() {
                for (audio in values()) {
                    audio.setVolume(0)
                }
            }
        }
    }}