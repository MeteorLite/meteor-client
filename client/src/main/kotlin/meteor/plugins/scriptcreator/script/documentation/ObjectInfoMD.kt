package meteor.plugins.scriptcreator.script.documentation
val objectInfoMD = """
    
    ## `Object` Api

   

    ### `first` function
    
    Get the first instance of an object with the given `id`.

    #### Parameters

    - `id`: The ID of the object to get.

    #### Returns

    The first instance of the object, or `null` if it is not present.

    ## Usage
    ```
    val object = Object first 12345
    ```
    
    ### `exists` function
    
    Check if an object with the given `id` or any of the objects in the given list of IDs are present.

    #### Parameters

    - `id`: The ID of the object to check for, or a list of IDs of objects to check for.

    #### Returns

    `true` if the object is present, or if any of the objects in the given list are present, `false` otherwise.

    ## Usage
    ```
    val exists = Object exists 12345
    val existsList = Object exists [12345, 67890]
    ```
    
""".trimIndent()