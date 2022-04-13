package meteor.ui.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import meteor.Main
import meteor.rs.Applet
import meteor.ui.UI
import java.awt.BorderLayout
import javax.swing.JPanel

object OSRS {
    lateinit var jpanel: JPanel

    @Composable
    fun OSRSPanel() {
        val mod: Modifier = Modifier.fillMaxWidth().fillMaxHeight()

        SwingPanel(
            Color.Black,
            modifier = mod,
            factory = {
                if (!this::jpanel.isInitialized) {
                    jpanel = JPanel()
                    jpanel.layout = BorderLayout()
                    jpanel.add(Applet.applet)
                    Applet.applet.init()
                    Applet.applet.start()
                    UI.loaded = true
                    Main.finishStartup()
                }
                jpanel
            })
    }
}