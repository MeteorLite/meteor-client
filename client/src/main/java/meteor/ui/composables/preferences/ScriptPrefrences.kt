package meteor.ui.composables.preferences

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import com.wakaztahir.codeeditor.theme.CodeTheme
import com.wakaztahir.codeeditor.theme.SyntaxColors
import meteor.plugins.scriptcreator.ScriptCreatorPlugin
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

var scriptCreator = mutableStateOf(false)
var md = mutableStateOf(false)
val engine: ScriptEngine = ScriptEngineManager().getEngineByExtension("kts")
val record = mutableStateOf(false)
val playRecording = mutableStateOf(false)
var tickCounter = 0
val setString = mutableStateOf("")
val savedString = mutableStateOf(TextFieldValue(""))
var codeState =  mutableStateOf("")
var newCode = mutableStateOf("")
var outPut = mutableStateOf("")
var savedScript = mutableStateOf("")


internal class Personal(val plugin: ScriptCreatorPlugin = ScriptCreatorPlugin()) : CodeTheme(
    colors = SyntaxColors(
        type = Color(plugin.config.type().rgb),
        keyword = Color(plugin.config.keyword().rgb),
        literal = Color(plugin.config.literal().rgb),
        comment = Color(plugin.config.comment().rgb),
        string = Color(plugin.config.string().rgb),
        punctuation = Color(plugin.config.punctuation().rgb),
        plain = Color(plugin.config.plain().rgb),
        tag = Color(plugin.config.tag().rgb),
        declaration = Color(plugin.config.declaration().rgb),
        source = Color(plugin.config.source().rgb),
        attrName = Color(plugin.config.attrName().rgb),
        attrValue = Color(plugin.config.attrValue().rgb),
        nocode = Color(plugin.config.nocode().rgb),
    )
) {


    fun getTheme(): CodeTheme = Personal()
}

