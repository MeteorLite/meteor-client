package meteor.ui.composables.ui


import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.Color
import eventbus.events.DrawGameImage
import eventbus.events.GameWindowCreated
import meteor.Hooks
import meteor.Main
import meteor.rs.Applet
import net.runelite.rs.api.RSGameShell
import org.rationalityfrontline.kevent.KEVENT
import java.awt.BorderLayout
import java.awt.Canvas
import java.awt.Dimension
import javax.swing.JPanel


var loaded = false
var applet = java.applet.Applet()
var subscribed = false
var gamePanel = JPanel()
var canvas = Canvas()

@Composable
fun OSRSPanel() {
            Row {
                SwingPanel(
                    Color.Black,
                    modifier = Modifier.fillMaxSize(),
                    factory = {
                        if (!loaded) {
                            gamePanel.apply {
                                canvas.minimumSize = Dimension(500, 300)
                                canvas.maximumSize = Dimension(500, 300)
                                minimumSize = Dimension(500, 300)
                                size = Dimension()
                                canvas.size = Dimension()
                                layout = BorderLayout()
                                canvas.background = java.awt.Color.BLACK
                                add(canvas)
                                applet = Applet.applet
                                Main.client = Applet.asClient(Applet.applet)
                                Main.client.callbacks = Hooks()
                                Main.client.canvas = canvas
                                Main.client.gamePanel = this
                                Main.client.`main$api`()
                                canvas.addKeyListener((applet as RSGameShell).gameWindow.`gameShell$api`)
                                canvas.addMouseListener((applet as RSGameShell).gameWindow.`gameShell$api`)
                                canvas.addMouseMotionListener((applet as RSGameShell).gameWindow.`gameShell$api`)
                                canvas.addMouseWheelListener((applet as RSGameShell).gameWindow.`gameShell$api`)
                                loaded = true
                                Main.finishStartup()
                            }
                        } else {
                            gamePanel
                        }
                    })
            }
}
