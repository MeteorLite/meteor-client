package meteor.ui.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import meteor.Main
import meteor.rs.Applet

import java.awt.BorderLayout
import javax.swing.JPanel

object OSRS {
    var loaded = false
    var applet = java.applet.Applet()
    @Composable
    fun OSRSPanel() {
        val mod: Modifier = Modifier.fillMaxWidth().fillMaxHeight()

        SwingPanel(
            Color.Black,
            modifier = mod,
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