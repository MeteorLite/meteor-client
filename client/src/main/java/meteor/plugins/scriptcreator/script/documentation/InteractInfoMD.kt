package meteor.plugins.scriptcreator.script.documentation

val interactInfoMD = """
## interact function

Interact with an entity using the specified action.

### Parameters
action: The action to perform, such as "Use", "Attack", or "Pick up".
Returns
Nothing.

### Usage
```
// Interact with an NPC using the "Talk-to" action
Npc first "Bob" interact "Talk-to"

// Interact with an object using the "Mine" action
Object first "Rocks" interact "Mine"

// Interact with an item in the player's inventory using the "Use" action
Item first "Rope" interact "Use"
```
Note
The interact function can be used on any entity, item, or object that can be interacted with in the game. 
""".trimIndent()