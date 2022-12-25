package meteor.ui.composables.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eventbus.events.ConfigChanged
import kotlinx.coroutines.launch
import meteor.Main
import meteor.rs.Applet
import meteor.ui.composables.preferences.consoleOpen
import meteor.ui.composables.preferences.intColor
import meteor.ui.composables.preferences.outPut
import java.awt.BorderLayout
import javax.swing.JPanel


var loaded = false
var applet = java.applet.Applet()
var subscribed = false

@Composable
fun OSRSPanel() {
    if (!subscribed) {
        Main.eventBus.subscribe<ConfigChanged>(eventbus.Events.CONFIG_CHANGED) {
            if (it.data.group == "MeteorLite")
                if (it.data.key == "console")
                    consoleOpen.value = Main.meteorConfig.console()
        }
        subscribed = true
    }
    
    LazyColumn {
        item {
            Row {
                SwingPanel(
                    Color.Black,
                    modifier = Modifier.fillParentMaxWidth().fillParentMaxHeight(if (consoleOpen.value) 0.75f else 1f),
                    factory = {
                        JPanel().apply {
                            layout = BorderLayout()
                            if (!loaded) {
                                applet = Applet.applet

                                add(Applet.applet)
                                Applet.applet.init()
                                Applet.applet.start()
                                Main.finishStartup()
                                loaded = true
                            } else
                                add(Applet.applet)
                        }
                    })
            }
        }
        when {
            consoleOpen.value -> {

                item {


                    val scrollState = rememberScrollState(0)
                    val scope = rememberCoroutineScope()

                        Row {
                            BasicTextField(

                                modifier = Modifier.fillMaxWidth().background(Color.Black)
                                    .fillParentMaxHeight(if (consoleOpen.value) 0.25f else 0f)
                                    .padding(all = 1.dp)
                                    .verticalScroll(scrollState).onFocusEvent {
                                        scope.launch {
                                            scrollState.scrollTo(scrollState.maxValue)
                                        }
                                    },
                                value = outPut.value,
                                onValueChange = {

                                    outPut.value = it
                                },

                                maxLines = 3000,
                                textStyle = TextStyle(
                                    color = intColor,
                                    fontSize = 14.sp,
                                    textDirection = TextDirection.Ltr,
                                    letterSpacing = 2.sp
                                )
                            )
                        }

                }
            }
        }
    }
}
