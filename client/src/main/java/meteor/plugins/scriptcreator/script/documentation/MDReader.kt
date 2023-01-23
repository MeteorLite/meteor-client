package meteor.plugins.scriptcreator.script.documentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CursorDropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.markdown.MarkdownParseOptions
import com.halilibo.richtext.ui.RichText
import meteor.ui.composables.preferences.md
import meteor.ui.composables.preferences.surface

var useOnInfo = mutableStateOf(false)
val interactInfo = mutableStateOf(false)
val eventInfo = mutableStateOf(false)
val bankInfo = mutableStateOf(false)
val gearInfo = mutableStateOf(false)
val itemInfo = mutableStateOf(false)
val keyInfo = mutableStateOf(false)
val lootInfo = mutableStateOf(false)
val npcInfo = mutableStateOf(false)
val objectInfo = mutableStateOf(false)
fun infoFalse() = run {
    interactInfo.value = false
    eventInfo.value = false
    useOnInfo.value = false
    bankInfo.value = false
    gearInfo.value = false
    itemInfo.value = false
    keyInfo.value = false
    lootInfo.value = false
    npcInfo.value = false
    objectInfo.value = false
}



data class ReadMeInfo(val value: MutableState<Boolean>, val markdown: String)

val readMeInfos = arrayOf(
    ReadMeInfo(eventInfo, eventInfoMD),
    ReadMeInfo(useOnInfo, useOnInfoMD),
    ReadMeInfo(interactInfo, interactInfoMD),
    ReadMeInfo(bankInfo, bankInfoMD),
    ReadMeInfo(gearInfo, gearInfoMD),
    ReadMeInfo(itemInfo, itemInfoMD),
    ReadMeInfo(keyInfo, keyInfoMD),
    ReadMeInfo(lootInfo, lootInfoMD),
    ReadMeInfo(npcInfo, npcInfoMD),
    ReadMeInfo(objectInfo, objectInfoMD)
)


@Composable
fun showReadMe(){
    for (info in readMeInfos) {
        when{
            info.value.value -> RichText(modifier = Modifier.padding(16.dp)
                .background(surface, RoundedCornerShape(4.dp))) {
                Markdown(info.markdown, MarkdownParseOptions(true))
            }
        }
    }
}

enum class Category(val info: String) {
    EventInfo("Event Info"),
    UseOn("Use On"),
    Interact("Interact"),
    Bank("Bank"),
    Gear("Gear"),
    Item("Item"),
    Key("Key"),
    Loot("Loot"),
    Npc("Npc"),
    Object("Object"),
    ExitInfo("Exit Info")
}

fun setSelectedCategory(selectedCategory: Category) {
    infoFalse()
    when (selectedCategory) {
        Category.EventInfo -> eventInfo.value = true
        Category.UseOn -> useOnInfo.value = true
        Category.Interact -> interactInfo.value = true
        Category.Bank -> bankInfo.value = true
        Category.Gear -> gearInfo.value = true
        Category.Item -> itemInfo.value = true
        Category.Key -> keyInfo.value = true
        Category.Loot -> lootInfo.value = true
        Category.Npc -> npcInfo.value = true
        Category.Object -> objectInfo.value = true
        Category.ExitInfo -> {
            infoFalse()
        }
    }
}
@Composable
fun InfoDropDown(){
    CursorDropdownMenu(
        expanded = md.value,
        onDismissRequest = {
            md.value = false
        },
    ) {
        val categories = Category.values()
        for (category in categories) {
            DropdownMenuItem({
                setSelectedCategory(category)
            }) {
                Text(category.name)
            }
        }
    }
}
