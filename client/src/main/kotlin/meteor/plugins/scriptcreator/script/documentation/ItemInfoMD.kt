package meteor.plugins.scriptcreator.script.documentation


val itemInfoMD = """
## `Item` Api



### `has` function

## Usage
```
// Check if the player's inventory contains a specific item
if (Item has 12345) {
    // Do something
}
```
### Description

Check if an item with the given `id` is present in the player's inventory.

#### Parameters

- `id`: The ID of the item to check for.

#### Returns

`true` if the item is present, `false` otherwise.

### `hasAll` function

Check if all items in the given list are present in the player's inventory.

#### Parameters

- `id`: The list of IDs of items to check for.

#### Returns

`true` if all items are present, `false` otherwise.

### `hasAny` function

Check if any of the items in the given list are present in the player's inventory.

#### Parameters

- `id`: The list of IDs of items to check for.

#### Returns

`true` if any of the items are present, `false` otherwise.

### `first` function

Get the first instance of an item with the given `id` in the player's inventory.

#### Parameters

- `id`: The ID of the item to get.

#### Returns

The first instance of the item, or `null` if it is not present.

### `firstIn` function

Get the first instance of an item from the given list of IDs in the player's inventory.

#### Parameters

- `id`: The list of IDs of items to get.

#### Returns

The first instance of the item, or `null` if it is not present.

#### Usage
```
// Get the first instance of an item in the list of IDs 12345, 67890, or 11111 in the player's inventory
val item = Item firstIn listOf(12345, 67890, 11111)
if (item != null) {
    // Do something with the item
}
```
### `carrying` function

Check if the player is carrying an item with the given `id` in their inventory.

#### Parameters

- `id`: The ID of the item to check for.

#### Returns

`true` if the player is carrying the item, `false` otherwise.

#### Usage
```
// Check if the player is carrying an item with ID 12345 in their inventory
if (Item carrying 12345) {
    // Do something
}
```
""".trimIndent()
