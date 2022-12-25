package meteor.plugins.scriptcreator.script.documentation

val gearInfoMD = """

## `Gear` Api



### `contains` function

Check if gear with the given `id` or all of the gear in the given list of IDs are present in the player's inventory.

#### Parameters

- `id`: The ID of the gear to check for, or a list of IDs of gear to check for.

#### Returns

`true` if the gear is present, or if all of the gear in the given list are present, `false` otherwise.

#### Usage
```
if (gear contains 123) {
    // gear with ID 123 is present
}

if (gear contains listOf(123, 456, 789)) {
    // all gear with IDs 123, 456, and 789 are present
}
```
### `first` function

Get the first instance of gear with the given `id` in the player's inventory.

#### Parameters

- `id`: The ID of the gear to get.

#### Returns

The first instance of the gear, or `null` if it is not present.

#### Usage
```
val gear123 = gear first 123
if (gear123 != null) {
    // gear with ID 123 is present
}
```
""".trimIndent()