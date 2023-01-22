package meteor.plugins.bankactions

import meteor.config.legacy.*

@ConfigGroup("bankactions")
interface BankActionsConfig : Config {
    @ConfigSection(
        name = "General",
        description = "General section.",
        position = 0,
        keyName = "generalSection"
    )
    val generalSection : String
    @ConfigItem(
        keyName = "ingredient",
        name = "Ingredient name",
        description = "Item to use e.g Ranarr weed",
        textField = true,
        position = 0,
        section = "General"
    )
    fun ingredient(): String {
        return "Ranarr weed"
    }

    @ConfigItem(
        keyName = "container",
        name = "Container name",
        description = "Items to use it on e.g Vial of water",
        textField = true,
        position = 1,
        section = "General"
    )
    fun container(): String {
        return "Vial of water"
    }

    @ConfigItem(
        keyName = "produceditem",
        name = "Produced item",
        description = "The name of the item that get produced e.g Ranarr potion (unf)",
        textField = true,
        position = 3,
        section = "General"
    )
    fun produceditem(): String {
        return "Ranarr potion (unf)"
    }

    @ConfigItem(
        keyName = "useoption",
        name = "use option",
        description = "The option name when using the item on another.",
        textField = true,
        position = 4,
        section = "General"
    )
    fun useoption(): String {
        return "Make"
    }
}