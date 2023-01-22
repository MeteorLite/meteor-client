package meteor.plugins.scriptcreator.script.documentation


val bankInfoMD = """
    ## `Bank` Api



    ### `contains` function
    ```kotlin
    inline infix fun <reified T> contains(id: T): Boolean
    ```
    Check if an item with the given `id` is present in the player's bank inventory.

    #### Parameters

    - `id`: The ID of the item to check for.

    #### Returns

    `true` if the item is present, `false` otherwise.
    ## Usage

    ```kotlin
    // Check if the player's bank contains a specific item
    if (Bank contains 12345) {
    // Do something
    }
    ```



    ### `containsAll` function
    ```kotlin
    inline infix fun <reified T> contains(id: MutableList<T>): Boolean
    ```
    Check if all items in the given list are present in the player's bank inventory.

    #### Parameters

    - `id`: The list of IDs of items to check for.

    #### Returns

    `true` if all items are present, `false` otherwise.

    ## Usage

    ```kotlin
    // Check if the player's bank contains all items in a list
    val items = mutableListOf(12345, 67890, 13579)
    if (Bank contains items) {
    // Do something
    }

    ```

    ### `first` function

    ```kotlin
    inline infix fun <reified T> first(id: T): T?
    ```

    Get the first instance of an item with the given `id` in the player's bank inventory.

    #### Parameters

    - `id`: The ID of the item to get.

    #### Returns

    The first instance of the item, or `null` if it is not present.

    ## Usage

    ```kotlin

    // Get the first instance of an item in the player's bank
    if (Bank first 12345 != null) {
    Bank first "Cake" withdraw 5
    }
    ```

    
""".trimIndent()