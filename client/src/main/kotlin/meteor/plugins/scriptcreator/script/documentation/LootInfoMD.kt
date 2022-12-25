package meteor.plugins.scriptcreator.script.documentation

val lootInfoMD = """
   
## `Loot` Api



### `first` function

Get the first instance of loot with the given `id`.

#### Parameters

- `id`: The ID of the loot to get.

#### Returns

The first instance of the loot, or `null` if it is not present.

#### Usage
```
val loot123 = Loot first 123
if (loot123 != null) {
    // loot with ID 123 is present
}
```
### `exists` function

Check if loot with the given `id` or any of the loot in the given list of IDs are present.

#### Parameters

- `id`: The ID of the loot to check for, or a list of IDs of loot to check for.

#### Returns

`true` if the loot is present, or if any of the loot in the given list are present, `false` otherwise.

#### Usage
```
if (Loot exists 123) {
    // loot with ID 123 is present
}

if (Loot exists listOf(123, 456, 789)) {
    // any of the loot with IDs 123, 456, or 789 are present    
}```
""".trimIndent()