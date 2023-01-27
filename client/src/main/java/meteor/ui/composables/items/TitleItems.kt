package meteor.ui.composables.items


import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.config.descriptor.ConfigDescriptor
import meteor.ui.composables.preferences.uiColor

fun LazyListScope.titleItems(descriptor: ConfigDescriptor){
        val title = descriptor.titles.sortedBy { it.title.position }.toMutableList()
    items(items = title) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(it.title.padding.dp),
                text = it.name(),
                style = TextStyle(
                    color = uiColor.value,
                    fontSize = it.title.size.sp,
                    textAlign = TextAlign.Center,
                )

            )
        }

    }
}