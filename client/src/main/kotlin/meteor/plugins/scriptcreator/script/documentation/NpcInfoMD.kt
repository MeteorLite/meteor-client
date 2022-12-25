package meteor.plugins.scriptcreator.script.documentation

val npcInfoMD = """
    
    
    ## `Npc` Api

    Object for interacting with NPCs in a game or application.

    ### `first` function
    ```kotlin
    inline infix fun <reified T> first(id: T): T?
    ```
    Get the first instance of an NPC with the given `id`.

    #### Parameters

    - `id`: The ID of the NPC to get.

    #### Returns

    The first instance of the NPC, or `null` if it is not present.

    ### `exists` function
    ```kotlin
    inline infix fun <reified T> exists(id: T): Boolean
    inline infix fun <reified T> exists(id: Iterable<T>): Boolean
    ```
    Check if an NPC with the given `id` or any of the NPCs in the given list of IDs are present.

    #### Parameters

    - `id`: The ID of the NPC to check for, or a list of IDs of NPCs to check for.

    #### Returns

    `true` if the NPC is present, or if any of the NPCs in the given list are present, `false` otherwise.

""".trimIndent()