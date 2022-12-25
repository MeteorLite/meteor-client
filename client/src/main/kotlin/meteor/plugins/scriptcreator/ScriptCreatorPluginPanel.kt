package meteor.plugins.scriptcreator


import androidx.compose.foundation.*
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
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.markdown.MarkdownParseOptions
import com.halilibo.richtext.ui.RichText
import com.wakaztahir.codeeditor.model.CodeLang
import com.wakaztahir.codeeditor.prettify.PrettifyParser
import com.wakaztahir.codeeditor.theme.CodeTheme
import com.wakaztahir.codeeditor.theme.SyntaxColors
import com.wakaztahir.codeeditor.utils.parseCodeAsAnnotatedString
import compose.icons.Octicons
import compose.icons.octicons.FileDirectory16
import compose.icons.octicons.Play24
import compose.icons.octicons.Question24
import compose.icons.octicons.Stop24
import dev.hoot.api.commons.FileUtil
import meteor.plugins.scriptcreator.script.documentation.*
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
                Text("Load", color = intColor, fontSize = 12.sp, letterSpacing = 3.sp)
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        tint = intColor,
                        imageVector = Octicons.FileDirectory16,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            when {

                                !FileUtil.exists(plugin, savedScript.value) -> {
                                    FileUtil.serialize(
                                        ScriptCreatorPlugin(),
                                        savedScript.value+".kts",
                                        codeState.value
                                    )
                                }

                            }



                        }.size(40.dp, 30.dp)
                    )


                    Text("Save", color = Color.Black, fontSize = 8.sp)
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
                        color = intColor,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 1.sp,
                        background = surface
                    ),
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
                        .background(surface, RoundedCornerShape(4.dp)),
                    value = savedString.value,
                    onValueChange = {
                        savedString.value = it
                        savedScript.value = it.text
                    })
            }
            Spacer(Modifier.width(20.dp))

            Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(100.dp)) {
                Icon(
                    tint = Color.Green,
                    imageVector = Octicons.Play24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        plugin.startScript()
                    }.size(25.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    tint = Color.Red,
                    imageVector = Octicons.Stop24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        plugin.stop()

                    }.size(25.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    tint = Color.Blue,
                    imageVector = Octicons.Question24,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        if (!md.value)  md.value = true else if (md.value)  md.value = false

                    }.size(25.dp)
                )
                CursorDropdownMenu(
                    expanded = md.value,
                    onDismissRequest = {
                            md.value = false

                    },
                ) {
                    DropdownMenuItem({ setSelectedCategory("Bank") }) {
                        Text("Bank")
                    }
                    DropdownMenuItem({ setSelectedCategory("Gear") }) {
                        Text("Gear")
                    }
                    DropdownMenuItem({ setSelectedCategory("Item") }) {
                        Text("Item")
                    }
                    DropdownMenuItem({ setSelectedCategory("Key") }) {
                        Text("Key")
                    }
                    DropdownMenuItem({ setSelectedCategory("Loot") }) {
                        Text("Loot")
                    }
                    DropdownMenuItem({ setSelectedCategory("Npc") }) {
                        Text("Npc")
                    }
                    DropdownMenuItem({ setSelectedCategory("Exit Info") }) {
                        Text("Exit Info")
                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Divider(Modifier.width(500.dp), color = intColor, thickness = 4.dp, startIndent = 3.dp)
        Spacer(Modifier.height(4.dp))
    }


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


    fun setSelectedCategory(selectedCategory: String) {
        bankInfo.value = false
        gearInfo.value = false
        itemInfo.value = false
        keyInfo.value = false
        lootInfo.value = false
        npcInfo.value = false
        objectInfo.value = false
        when (selectedCategory) {
            "Bank" -> bankInfo.value = true
            "Gear" -> gearInfo.value = true
            "Item" -> itemInfo.value = true
            "Key" -> keyInfo.value = true
            "Loot" -> lootInfo.value = true
            "Npc" -> npcInfo.value = true
            "Object" -> objectInfo.value = true
            "Exit Info" -> {
                bankInfo.value = false
                gearInfo.value = false
                itemInfo.value = false
                keyInfo.value = false
                lootInfo.value = false
                npcInfo.value = false
                objectInfo.value = false
            }
        }
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

        var textFieldValue by remember(key1 = setString.value) { mutableStateOf(TextFieldValue(parse(codeState.value)))}
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
                            color = intColor

                        )
                    }
                }
            }
            LazyColumn(Modifier.fillMaxWidth().fillMaxHeight()) {


                item {
                    if (bankInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(bankInfoMD, MarkdownParseOptions(true))
                        }
                    }

                    if (gearInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(gearInfoMD, MarkdownParseOptions(true))
                        }
                    }

                    if (itemInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(itemInfoMD, MarkdownParseOptions(true))
                        }
                    }

                    if (keyInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(keyInfoMD, MarkdownParseOptions(true))
                        }
                    }

                    if (lootInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(lootInfoMD, MarkdownParseOptions(true))
                        }
                    }

                    if (npcInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(npcInfoMD, MarkdownParseOptions(true))
                        }
                    }
                    if (objectInfo.value) {
                        RichText(
                            modifier = Modifier.padding(16.dp).background(surface, RoundedCornerShape(4.dp))
                        ) {
                            Markdown(objectInfoMD, MarkdownParseOptions(true))
                        }
                    }
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().fillParentMaxHeight(),
                        value = textFieldValue,
                        onValueChange = {
                            codeState.value = it.text.replace("\t", "   ")
                           textFieldValue = it.copy(annotatedString = parse(it.text))
                        },
                        textStyle = TextStyle(fontSize = config.fontSize().sp),
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