package meteor.plugins.autorun

import net.runelite.client.config.*

@ConfigGroup("autorun")
interface AutoRunConfig : Config {
    @Range(min = 1, max = 50)
    @ConfigItem(
        keyName = "minRun",
        name = "Enable Run (Min.)",
        description = "The minimum run-energy to wait for before re-enabling run.",
        position = 10,
        section = "AutoRun"
    )
    fun minRun(): Int {
        return 5
    }

    @Range(min = 2, max = 99)
    @ConfigItem(
        keyName = "maxRun",
        name = "Enable Run (Max.)",
        description = "The maximum run-energy to wait for before re-enabling run.",
        position = 12,
        section = "AutoRun"
    )
    fun maxRun(): Int {
        return 35
    }


    @ConfigSection(keyName = "AutoRun", name = "AutoRun", description = "", position = 0)
    val AutoRun: String

}