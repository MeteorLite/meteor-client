package meteor.plugins.scriptcreator


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wakaztahir.codeeditor.model.CodeLang
import com.wakaztahir.codeeditor.prettify.PrettifyParser
import com.wakaztahir.codeeditor.utils.parseCodeAsAnnotatedString
import compose.icons.Octicons
import compose.icons.octicons.*
import dev.hoot.api.commons.FileUtil
import meteor.plugins.scriptcreator.script.documentation.InfoDropDown
import meteor.plugins.scriptcreator.script.documentation.showReadMe
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*


class ScriptCreatorPluginPanel : PluginPanel() {

    val plugin = ScriptCreatorPlugin()
    val config = plugin.config

    @Composable
    override fun Header() {

        var expanded by remember { mutableStateOf(false) }
        Spacer(Modifier.height(6.dp))
        Row(
            modifier = Modifier.width(500.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.width(100.dp).height(IntrinsicSize.Max),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(Modifier.height(5.dp))
                Text("Load", color = uiColor.value, fontSize = 12.sp, letterSpacing = 3.sp)
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        tint = uiColor.value,
                        imageVector = Octicons.FileDirectory16,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            if (!FileUtil.exists(plugin, savedScript.value)) {
                                FileUtil.serialize(
                                    ScriptCreatorPlugin(),
                                    "${savedScript.value}.kts",
                                    codeState.value
                                )
                            }
                        }.size(40.dp, 30.dp)
                    )
                    Text("Save", color = Color.Black, fontSize = 10.sp)
                }
            }


            Column(Modifier.width(250.dp)) {
                Box(modifier = Modifier.width(225.dp).height(IntrinsicSize.Max).wrapContentSize(Alignment.TopStart)) {

                    Text(
                        setString.value,
                        color = uiColor.value,
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp,
                        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
                            .clickable(onClick = { expanded = true })
                            .background(
                                surface, RoundedCornerShape(4.dp)
                            )
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(250.dp).padding(horizontal = 5.dp)
                    ) {
                        FileUtil.getPluginDirectory(ScriptCreatorPlugin()).listFiles()
                            ?.forEach { it ->
                                DropdownMenuItem(
                                    modifier = Modifier.height(17.dp),
                                    onClick = {
                                        codeState.value = FileUtil.deserialize(plugin, it.name)
                                        expanded = false
                                        setString.value = it.nameWithoutExtension
                                    }, content = {
                                        Text(text = it.nameWithoutExtension, color = uiColor.value, fontSize = 14.sp)
                                    })
                            }
                    }
                }
                Spacer(Modifier.height(4.dp))
                BasicTextField(
                    textStyle = TextStyle(
                        color = secondColor.value,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 1.sp,
                        background = surface
                    ),
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
                        .background(surface, RoundedCornerShape(4.dp)),
                    value = savedString.value,
                    onValueChange = {
                        savedScript.value = it.text
                    })
            }
            Spacer(Modifier.width(20.dp))

            Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(100.dp)) {
                Icon(
                    tint = if (!playRecording .value) Color.Green else Color.Red,
                    imageVector =if (!playRecording.value)  Octicons.Play24 else Octicons.Stop24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                          if  (!playRecording.value)  plugin.startScript() else if (playRecording.value) plugin.stopScript()

                    }.size(22.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    tint =if (!record.value) Color.White else Color.Red,
                    imageVector =if (!record.value) Octicons.DeviceCameraVideo24 else Octicons.XCircleFill24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (!record.value)  record.value = true else if (record.value)  record.value = false
                        tickCounter = 0
                    }.size(22.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    tint = Color.Yellow,
                    imageVector = Octicons.Question24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (!md.value)  md.value = true else if (md.value)  md.value = false
                    }.size(22.dp)
                )
                InfoDropDown()
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Divider(Modifier.width(500.dp), color = uiColor.value, thickness = 4.dp, startIndent = 3.dp)
        Spacer(Modifier.height(4.dp))
    }

    @Composable
    override fun Content() {

        val language = CodeLang.Kotlin
        val parser = remember { PrettifyParser() }
        val themeState by remember { mutableStateOf(Personal()) }
        val theme = remember(themeState) { themeState.getTheme() }


        fun parse(code: String): AnnotatedString {
            return parseCodeAsAnnotatedString(
                parser = parser,
                theme = theme,
                lang = language,
                code = code.replace("\t", "   ")
            )
        }

        var textFieldValue by remember(key1 = setString.value,key2 = newCode.value) { mutableStateOf(TextFieldValue(parse(codeState.value)))}
        var lineTops by remember { mutableStateOf(emptyArray<Float>()) }
        val density = LocalDensity.current

        Row(Modifier.width(500.dp).fillMaxHeight()) {
            if (lineTops.isNotEmpty()) {
                Box(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    lineTops.forEachIndexed { index, top ->
                        Text(
                            fontSize = config.fontSize() .sp,
                            modifier = Modifier.offset(y = with(density) { top.toDp() }),
                            text = index.toString(),
                            color = uiColor.value

                        )
                    }
                }
            }
            LazyColumn(Modifier.fillMaxWidth().fillMaxHeight()) {

                item {
                    showReadMe()
                    ErrorDialog()
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().fillParentMaxHeight(),
                        value = textFieldValue,
                        onValueChange = {
                            codeState.value = it.text.replace("\t", "   ")
                           textFieldValue = it.copy(annotatedString = parse(it.text))
                        },
                        textStyle = TextStyle(fontSize = config.fontSize().sp,),
                        maxLines = 1000,

                        onTextLayout = { result ->
                            lineTops = Array(result.lineCount) { result. getLineTop(it) }
                        }
                    )
                }
            }
        }
    }
}