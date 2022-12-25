package meteor.plugins.scriptcreator.script.documentation

val gearInfoMD = """
    
    ## `Gear` Api

    Object for interacting with gear in a player's inventory.

    ### `contains` function
    ```kotlin
    inline infix fun <reified T> contains(id: T): Boolean
    inline infix fun <reified T> contains(id: MutableList<T>): Boolean
    ```
    Check if gear with the given `id` or all of the gear in the given list of IDs are present in the player's inventory.

    #### Parameters

    - `id`: The ID of the gear to check for, or a list of IDs of gear to check for.

    #### Returns

    `true` if the gear is present, or if all of the gear in the given list are present, `false` otherwise.

    ### `first` function
    ```kotlin
    inline infix fun <reified T> first(id: T): T?
    ```
    Get the first instance of gear with the given `id` in the player's inventory.

    #### Parameters

    - `id`: The ID of the gear to get.

    #### Returns

    The first instance of the gear, or `null` if it is not present.


""".trimIndent()