package meteor.plugins.scriptcreator.script.documentation

val useOnInfoMD = """
## useOn function

Use an item on a specified entity, player, loot, or object.

### Parameters
 - The NPC the item is used on. `npc`
 - The Player the item is used on. `player`
 - The Loot the item is used on. `loot`
 - The Object the item is used on. `obj`

### Usage


// Use an item on an NPC
```
item useOn npc
```
// Use an item on a player
```
item useOn player
```
// Use an item on loot
```
item useOn loot
```
// Use an item on an object
```
item useOn obj
```

""".trimIndent()