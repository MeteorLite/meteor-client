package meteor.plugins.thieving


import meteor.Configuration
import meteor.config.legacy.*
import meteor.ui.components.ComponentConstants
import java.awt.BorderLayout
import java.awt.Color

@ConfigGroup(Configuration.MASTER_GROUP)
interface ThievingConfig : Config {

    @ConfigItem(
        keyName = "toolbarExpanded",
        name = "Draw stall icon",
        description = "show icon above stall when thievable",
        position = 0
    )
    fun stallIcon(): Boolean {
        return true
    }
    @ConfigItem(
            keyName = "stallTilePoly",
            name = "show tile poly above stall when thievable",
            description = "",
            position = 1
    )
    fun stallTilePoly(): Boolean {
        return true
    }

}
