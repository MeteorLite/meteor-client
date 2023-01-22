package meteor.plugins.scriptcreator.script.documentation

val eventInfoMD = """
    
    ## Usage of Game Events 


    ```kotlin
    onGameTick {
    // code to be executed every game tick
    }
    ``` 

    ```kotlin
    onNpcLootReceived { event ->
    val loot = event.loot
    // code to handle NPC loot received event
    }
    ```
    ```kotlin
    onPlayerLootReceived { event ->
    val loot = event.loot
    // code to handle player loot received event
    }
    ```
    
    
    
""".trimIndent()