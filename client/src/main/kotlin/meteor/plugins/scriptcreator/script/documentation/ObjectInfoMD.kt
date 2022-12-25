package meteor.plugins.scriptcreator.script.documentation

val objectInfoMD = """
    
    ## `Object` Api

    Object for interacting with objects in a game or application.

    ### `first` function
    ```kotlin
    inline infix fun <reified T> first(id: T): T?
    ```
    Get the first instance of an object with the given `id`.

    #### Parameters

    - `id`: The ID of the object to get.

    #### Returns

    The first instance of the object, or `null` if it is not present.

    ### `exists` function
    ```kotlin
    inline infix fun <reified T> exists(id: T): Boolean
    inline infix fun <reified T> exists(id: Iterable<T>): Boolean
    ```
    Check if an object with the given `id` or any of the objects in the given list of IDs are present.

    #### Parameters

    - `id`: The ID of the object to check for, or a list of IDs of objects to check for.

    #### Returns

    `true` if the object is present, or if any of the objects in the given list are present, `false` otherwise.

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
    ## `Key` Api

    Object for interacting with keyboard keys in a game or application.

    ### `type` function
    ```kotlin
    infix fun type(number: Int)
    infix fun type(text: String)
    ```
    Type the given `number` or `text` using the keyboard.

    #### Parameters

    - `number`: The number to type as a `Int`.
    - `text`: The text to type as a `String`.

    ### Description

    The `type` function allows you to type a given `number` or `text` using the keyboard. If a `number` is provided, it will be converted to a `String` and typed as such. If `text` is provided, each character in the `String` will be typed individually. After the `number` or `text` has been typed, the `sendEnter` function will be called to send an enter key press.

    #### Usage
    ```kotlin
    // Type the number 12345
    Key type 12345

    // Type the text "Hello World"
    Key type "Hello World"
    ```

""".trimIndent()