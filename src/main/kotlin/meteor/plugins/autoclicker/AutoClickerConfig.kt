package meteor.plugins.autoclicker

import meteor.config.legacy.ModifierlessKeybind
import net.runelite.client.config.*
import java.awt.event.InputEvent
import java.awt.event.KeyEvent

@ConfigGroup("autoclicker")
interface AutoClickerConfig : Config {
    @ConfigItem(
        keyName = "toggle",
        name = "Toggle",
        description = "Toggles the auto-clicker.",
        position = 1,
        section = title
    )
    fun toggle(): ModifierlessKeybind? {
        return ModifierlessKeybind(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK)
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "minDelay",
        name = "Minimum Delay (ms)",
        description = "Minimum delay between mouse clicks.",
        position = 6,
        section = clickerConfig
    )
    fun minDelay(): Int {
        return 1000
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "maxDelay",
        name = "Maximum Delay (ms)",
        description = "Maximum delay between mouse clicks.",
        position = 7,
        section = clickerConfig
    )
    fun maxDelay(): Int {
        return 2000
    }

    @Range(textInput = true)
    @ConfigItem(keyName = "target", name = "Delay Target", description = "", position = 8, section = clickerConfig)
    fun target(): Int {
        return 1500
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "deviation",
        name = "Delay Deviation",
        description = "",
        position = 9,
        section = clickerConfig
    )
    fun deviation(): Int {
        return 100
    }

    @Range(min = 0, max = 99, textInput = true)
    @ConfigItem(
        keyName = "frequencyAFK",
        name = "AFK Frequency (%)",
        description = "% chance to go AFK.",
        position = 11,
        section = afkDelayTitle
    )
    fun frequencyAFK(): Int {
        return 3
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "minDelayAFK",
        name = "Min AFK Delay (ms)",
        description = "Minimum AFK delay.",
        position = 12,
        section = afkDelayTitle
    )
    fun minDelayAFK(): Int {
        return 5000
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "maxDelayAFK",
        name = "Max AFK Delay (ms)",
        description = "Maximum AFK delay.",
        position = 13,
        section = afkDelayTitle
    )
    fun maxDelayAFK(): Int {
        return 20000
    }

    @Range(min = 5, max = 9)
    @ConfigItem(
        keyName = "weightSkewAFK",
        name = "AFK Skew (Tightness)",
        description = "The degree to which the AFK random weights cluster around the mode of the distribution; higher values mean tighter clustering.",
        position = 14,
        section = afkDelayTitle
    )
    fun weightSkewAFK(): Int {
        return 8
    }

    @Range(min = -10, max = 10)
    @ConfigItem(
        keyName = "weightBiasAFK",
        name = "AFK Bias (Offset)",
        description = "The tendency of the AFK mode to reach the min, max or midpoint value; positive values bias toward max, negative values toward min.",
        position = 15,
        section = afkDelayTitle
    )
    fun weightBiasAFK(): Int {
        return 8
    }

    @ConfigItem(
        keyName = "weightedDistribution",
        name = "Weighted Distribution",
        description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
        position = 16,
        section = clickerConfig
    )
    fun weightedDistribution(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "followMouse",
        name = "Follow Mouse",
        description = "Click at the mouse location.",
        position = 17,
        section = clickerConfig
    )
    fun followMouse(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "disableRealMouse",
        name = "Disable Real Mouse",
        description = "Disable the real mouse after the clicker has started, to prevent interference after setting it up.",
        position = 18,
        section = clickerConfig
    )
    fun disableRealMouse(): Boolean {
        return true
    }

    @ConfigItem(keyName = "disableUI", name = "Disable UI", description = "", position = 19, section = clickerConfig)
    fun disableUI(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "skipOnMoving",
        name = "Skip When Moving",
        description = "",
        position = 21,
        section = clickerFilters
    )
    fun skipOnMoving(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "skipOnInteraction",
        name = "Skip On Interaction",
        description = "",
        position = 22,
        section = clickerFilters
    )
    fun skipOnInteraction(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "skipOnAnimating",
        name = "Skip On Animating",
        description = "",
        position = 23,
        section = clickerFilters
    )
    fun skipOnAnimating(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "mouseOnNPC",
        name = "Mouse On NPC",
        description = "",
        position = 24,
        section = clickerFilters
    )
    fun mouseOnNPC(): Boolean {
        return false
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "mouseOnNPCID",
        name = "NPC ID",
        description = "",
        position = 25,
        section = clickerFilters,
        hidden = true,
        unhide = "mouseOnNPC"
    )
    fun mouseOnNPCID(): Int {
        return 0
    }

    companion object {
        @ConfigSection(keyName = "title", name = "AutoClicker", description = "", position = 0)
        const val title = "AutoClicker"

        @ConfigSection(keyName = "clickerConfig", name = "Clicker Config", description = "", position = 5)
        const val clickerConfig = "Clicker Config"

        @ConfigSection(keyName = "afkDelayTitle", name = "Random AFK", description = "", position = 10)
        const val afkDelayTitle = "Random AFK"

        @ConfigSection(keyName = "clickerFilters", name = "Clicker Filters", description = "", position = 20)
        const val clickerFilters = "Clicker Filters"
    }
}