package meteor.plugins.autorun

import meteor.config.ConfigManager.getConfig
import meteor.config.legacy.*
import java.util.concurrent.ExecutorService
import java.lang.Runnable
import java.lang.InterruptedException

@ConfigGroup("autorun")
interface AutoRunConfig : Config {
    @Range(min = 1, max = 50)
    @ConfigItem(
        keyName = "minRun",
        name = "Enable Run (Min.)",
        description = "The minimum run-energy to wait for before re-enabling run.",
        position = 10,
        section = title
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
        section = title
    )
    fun maxRun(): Int {
        return 35
    }

    companion object {
        @ConfigSection(keyName = "title", name = "Soxs' AutoRun", description = "", position = 0)
        const val title = "Soxs' AutoRun"
    }
}