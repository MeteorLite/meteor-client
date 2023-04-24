package meteor.plugins.autoclicker

import com.google.common.base.Supplier
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.CalcUtils
import meteor.util.HotkeyListener
import net.runelite.api.GameState
import net.runelite.api.Point
import java.awt.Component
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.*

@PluginDescriptor(
    name = "AutoClicker",
    description = "Auto clicks. Lovely to pair with 1-click plugins.",
    enabledByDefault = false
)

class AutoClickerPlugin : Plugin() {

    val config = configuration<AutoClickerConfig>()

    private val overlay = overlay(AutoClickerOverlay(this))

    private var executorService: ExecutorService? = null
    private var clickService: ExecutorService? = null
    private var savedPoint: Point? = null
    private var random: Random? = null


    override fun onStart() {
        instance = this
        KeyManager.registerKeyListener(hotkeyListener, this.javaClass)
        executorService = Executors.newSingleThreadExecutor()
        clickService = Executors.newSingleThreadExecutor()
        random = Random()

    }

    override fun onStop() {
        KeyManager.unregisterKeyListener(hotkeyListener)
        executorService?.shutdown()
        clickService?.shutdown()
        run = false
        inputDisabled = false
        overlayManager.remove(overlay)
    }

    val clickerPlugin: Plugin
        get() = this

    fun setupMouseListener() {
        if (!setupMouseListener) {
            val c = client.canvas
            val mL = c.mouseListeners
            val mML: Array<MouseMotionListener> = c.mouseMotionListeners
            for (mouseListener in mL) {
                mouseListeners.add(mouseListener)
                c.removeMouseListener(mouseListener)
            }
            for (mouseMotionListener in mML) {
                mouseMotionListeners.add(mouseMotionListener)
                c.removeMouseMotionListener(mouseMotionListener)
            }
            c.addMouseListener(SMouseListener().also { myMouseListener = it })
            c.addMouseMotionListener(SMouseMotionListener().also { myMouseMotionListener = it })
            setupMouseListener = true
        }
    }

    private val hotkeyListener: HotkeyListener = object : HotkeyListener({ config.toggle() }) {
        override fun hotkeyPressed() {
            run = !run
            if (!run) {
                inputDisabled = false
                return
            }
            savedPoint = client.mouseCanvasPosition
            if (config.disableRealMouse()) inputDisabled = true
            setupMouseListener()
            executorService?.submit(Runnable {
                while (run) {
                    val mousePoint = client.mouseCanvasPosition
                    if (config.mouseOnNPC()) {
                        val shouldContinue = AtomicBoolean(false)
                        ClientThread.invokeLater {
                            val npcs = client.npcs
                            for (npc in npcs) {
                                if (npc == null) continue
                                if (npc.id == config.mouseOnNPCID()) {
                                    if (npc.convexHull.contains(mousePoint.x.toDouble(), mousePoint.y.toDouble())) {
                                        shouldContinue.set(true)
                                        break
                                    }
                                }
                            }
                        }
                        if (!shouldContinue.get()) {
                            try {
                                Thread.sleep(betweenClicksDelay)
                            } catch (e: InterruptedException) {
                                e.printStackTrace()
                            }
                            continue
                        }
                    }
                    if (random!!.nextInt(100) < config.frequencyAFK()) {
                        try {
                            Thread.sleep(randWeightedInt(config.minDelayAFK(), config.maxDelayAFK()).toLong())
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                    if (client.gameState == GameState.LOGGED_IN) {
                        ClientThread.invokeLater {
                            if ((!config.skipOnMoving() || client.localPlayer!!
                                    .idlePoseAnimation == client.localPlayer!!.poseAnimation) &&
                                (!config.skipOnInteraction() || client.localPlayer!!.interacting == null) &&
                                (!config.skipOnAnimating() || client.localPlayer!!.animation == -1)
                            ) {
                                if (config.onlyWhenIdle()) {
                                    if (client.localPlayer!!.isIdle)
                                        if (config.followMouse()) {
                                            clickService?.submit { click(client.mouseCanvasPosition) }
                                        } else clickService?.submit { click(savedPoint) }
                                } else {
                                    if (config.followMouse()) {
                                        clickService?.submit { click(client.mouseCanvasPosition) }
                                    } else clickService?.submit { click(savedPoint) }
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(betweenClicksDelay)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                inputDisabled = false
            })
        }
    }
    val betweenClicksDelay: Long
        get() = CalcUtils.getHumanizedDelay(config.weightedDistribution(), config.minDelay(), config.maxDelay(), config.deviation(), config.target()).roundToLong()

    fun click(p: Point?) {
        assert(!client.isClientThread)
        var original = client.mouseCanvasPosition
        var moved = false
        if (client.isStretchedEnabled) {
            val stretched = client.stretchedDimensions
            val real = client.realDimensions
            val width = stretched.width / real.getWidth()
            val height = stretched.height / real.getHeight()
            val point = Point((p!!.x * width).toInt(), (p.y * height).toInt())
            original = Point((original.x * width).toInt(), (original.y * height).toInt())
            if (original.distanceTo(point) > 0) {
                mouseEvent(MouseEvent.MOUSE_MOVED, point)
                moved = true
            }
            mouseEvent(MouseEvent.MOUSE_PRESSED, point)
            mouseEvent(MouseEvent.MOUSE_RELEASED, point)
            mouseEvent(MouseEvent.MOUSE_CLICKED, point)
            if (moved) {
                mouseEvent(MouseEvent.MOUSE_MOVED, original)
            }
            return
        }
        if (original.distanceTo(p) > 0) {
            mouseEvent(MouseEvent.MOUSE_MOVED, p!!)
            moved = true
        }
        mouseEvent(MouseEvent.MOUSE_PRESSED, p!!)
        mouseEvent(MouseEvent.MOUSE_RELEASED, p)
        mouseEvent(MouseEvent.MOUSE_CLICKED, p)
        if (moved) {
            mouseEvent(MouseEvent.MOUSE_MOVED, original)
        }
    }

    private fun mouseEvent(id: Int, point: Point) {
        val e: MouseEvent = SMouseEvent(
            client.canvas, id,
            System.currentTimeMillis(),
            0, point.x, point.y,
            1, false, 1
        )
        client.canvas.dispatchEvent(e)
    }

    private fun randWeightedInt(min: Int, max: Int): Int {
        val ra = randBellWeight(min, max)
        val sorted = min(max, max(min, ra))
        return if (min >= 0 && max > 0) abs(sorted) else sorted
    }

    private fun randBellWeight(min: Int, max: Int): Int {
        var max = max
        if (max <= min) max = min + 1
        return nextSkewedBoundedDouble(
            min.toDouble(),
            max.toDouble(),
            config.weightSkewAFK() / 10.0,
            config.weightBiasAFK() / 10.0
        ).toInt()
    }

    private fun nextSkewedBoundedDouble(min: Double, max: Double, skew: Double, bias: Double): Double {
        val range = max - min
        val mid = min + range / 2.0
        val unitGaussian = random!!.nextGaussian()
        val biasFactor = exp(bias)
        return mid + range * (biasFactor / (biasFactor + exp(-unitGaussian / skew)) - 0.5)
    }

    internal class SMouseEvent(
        source: Component?,
        id: Int,
        `when`: Long,
        modifiers: Int,
        x: Int,
        y: Int,
        clickCount: Int,
        popupTrigger: Boolean,
        button: Int
    ) : MouseEvent(source, id, `when`, modifiers, x, y, clickCount, popupTrigger, button)

    private class SMouseMotionListener : MouseMotionListener {
        override fun mouseDragged(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseMotionListeners) {
                    mouseListener.mouseDragged(e)
                }
            } else {
                e.consume()
            }
        }

        override fun mouseMoved(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseMotionListeners) {
                    mouseListener.mouseMoved(e)
                }
            } else {
                e.consume()
            }
        }
    }

    private class SMouseListener : MouseListener {
        override fun mouseClicked(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseListeners) {
                    mouseListener.mouseClicked(e)
                }
            } else e.consume()
        }

        override fun mousePressed(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseListeners) {
                    mouseListener.mousePressed(e)
                }
            } else e.consume()
        }

        override fun mouseReleased(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseListeners) {
                    mouseListener.mouseReleased(e)
                }
            } else e.consume()
        }

        override fun mouseEntered(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseListeners) {
                    mouseListener.mouseEntered(e)
                }
            } else e.consume()
        }

        override fun mouseExited(e: MouseEvent) {
            if (e is SMouseEvent || !shouldDisableMouseInput()) {
                for (mouseListener in mouseListeners) {
                    mouseListener.mouseExited(e)
                }
            } else e.consume()
        }
    }

    companion object {
        var run = false
        private var instance: AutoClickerPlugin? = null
        private val mouseListeners = ArrayList<MouseListener>()
        private val mouseMotionListeners: ArrayList<MouseMotionListener> = ArrayList<MouseMotionListener>()
        private var myMouseMotionListener: SMouseMotionListener? = null
        private var myMouseListener: SMouseListener? = null
        private var setupMouseListener = false
        private var inputDisabled = false
        fun shouldDisableMouseInput(): Boolean {
            return inputDisabled
        }
    }
}