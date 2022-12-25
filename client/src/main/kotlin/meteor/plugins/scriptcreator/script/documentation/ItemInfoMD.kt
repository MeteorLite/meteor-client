package meteor.plugins.scriptcreator.script.documentation



val itemInfoMD = """
    ## `Item` Api

    Object for interacting with a player's inventory.

    ### `has` function

    ```kotlin
    inline infix fun <reified T> has(id: T): Boolean
    ```

    ## Usage
    ```kotlin
    // Check if the player's inventory contains a specific item
    if (Item has 12345) {
        // Do something
    }

    ```
    ### Description

    Check if an item with the given `id` is present in the player's inventory.

    #### Parameters

    - `id`: The ID of the item to check for.

    #### Returns

    `true` if the item is present, `false` otherwise.

    ### `hasAll` function
    ```kotlin
    inline infix fun <reified T> hasAll(id: MutableList<T>): Boolean
    ```
    Check if all items in the given list are present in the player's inventory.

    #### Parameters

    - `id`: The list of IDs of items to check for.

    #### Returns

    `true` if all items are present, `false` otherwise.

    ### `hasAny` function
    ```kolin
    inline infix fun <reified T> hasAny(id: MutableList<T>): Boolean
    ```
    Check if any of the items in the given list are present in the player's inventory.

    #### Parameters

    - `id`: The list of IDs of items to check for.

    #### Returns

    `true` if any of the items are present, `false` otherwise.

    ### `first` function
    ```kotlin
    inline infix fun <reified T> first(id: T): T?
    ```
    Get the first instance of an item with the given `id` in the player's inventory.

    #### Parameters

    - `id`: The ID of the item to get.

    #### Returns

    The first instance of the item, or `null` if it is not present.

    ### `firstIn` function

    ```kotlin
    inline infix fun <reified T> firstIn(id: List<T>): T?
    ```
    Get the first instance of an item from the given list of IDs in the player's inventory.

    #### Parameters

    - `id`: The list of IDs of items to get.

    #### Returns

    The first instance of the item, or `null` if it is not present.

    ### `carrying` function
    ```kotlin
    inline infix fun <reified T> carrying(id: T): Boolean
    ```
    Check if the player is carrying an item with the given `id` in their inventory.

    #### Parameters

    - `id`: The ID of the item to check for.

    #### Returns

    `true` if the player is carrying the item, `false` otherwise.

""".trimIndent()
