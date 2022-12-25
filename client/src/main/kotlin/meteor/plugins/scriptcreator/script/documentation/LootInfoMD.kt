package meteor.plugins.scriptcreator.script.documentation

val lootInfoMD = """
   
## `Loot` Api

Object for interacting with loot in a game or application.

### `first` function
```kotlin
inline infix fun <reified T> first(id: T): T?
```
Get the first instance of loot with the given `id`.

#### Parameters

- `id`: The ID of the loot to get.

#### Returns

The first instance of the loot, or `null` if it is not present.

### `exists` function
```kotlin
inline infix fun <reified T> exists(id: T): Boolean
inline infix fun <reified T> exists(id: Iterable<T>): Boolean
```
Check if loot with the given `id` or any of the loot in the given list of IDs are present.

#### Parameters

- `id`: The ID of the loot to check for, or a list of IDs of loot to check for.

#### Returns

`true` if the loot is present, or if any of the loot in the given list are present, `false` otherwise.
 
""".trimIndent()