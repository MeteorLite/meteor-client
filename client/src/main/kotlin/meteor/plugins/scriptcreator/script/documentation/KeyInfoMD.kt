package meteor.plugins.scriptcreator.script.documentation

val keyInfoMD = """
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