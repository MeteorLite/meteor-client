package meteor.plugins.scriptcreator.script.documentation

val npcInfoMD = """
## `Npc` Api


### `first` function
Get the first instance of an NPC with the given `id`.

#### Parameters

- `id`: The ID of the NPC to get.

#### Returns

The first instance of the NPC, or `null` if it is not present.

#### Usage
```
val npc = Npc first 123
if (npc != null) {
    // NPC with ID 123 is present
}
```
### `exists` function
Check if an NPC with the given `id` or any of the NPCs in the given list of IDs are present.

#### Parameters

- `id`: The ID of the NPC to check for, or a list of IDs of NPCs to check for.

#### Returns

`true` if the NPC is present, or if any of the NPCs in the given list are present, `false` otherwise.

#### Usage
```
if (Npc exists 123) {
    // NPC with ID 123 is present
}

if (Npc exists listOf(123, 456, 789)) {
    // at least one of the NPCs with IDs 123, 456, or 789 is present
}
```
""".trimIndent()