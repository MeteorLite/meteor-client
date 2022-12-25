package meteor.ui.composables.preferences

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue

var scriptCreator = mutableStateOf(false)
var md = mutableStateOf(false)
val setString = mutableStateOf("")
val savedString = mutableStateOf(TextFieldValue(""))
var codeState =  mutableStateOf("")
var outPut = mutableStateOf("")
var savedScript = mutableStateOf("")
val bankInfo = mutableStateOf(false)
val gearInfo = mutableStateOf(false)
val itemInfo = mutableStateOf(false)
val keyInfo = mutableStateOf(false)
val lootInfo = mutableStateOf(false)
val npcInfo = mutableStateOf(false)
val objectInfo = mutableStateOf(false)