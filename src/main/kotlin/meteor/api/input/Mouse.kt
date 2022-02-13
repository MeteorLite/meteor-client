package meteor.api.input

import Main.client

import meteor.Logger
import meteor.api.commons.Rand
import meteor.api.commons.Time
import java.awt.Canvas
import java.awt.Point
import java.awt.event.MouseEvent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.function.Supplier

object Mouse {
    private val log: Logger = Logger("Mouse")
    private const val MENU_REPLACE_DELAY = 80
    val CLICK_POINT_SUPPLIER = Supplier { Point(Rand.nextInt(520, 568), Rand.nextInt(55, 70)) }
    private var exited = true
    private val CLICK_EXECUTOR: Executor = Executors.newSingleThreadExecutor()
    fun click(x: Int, y: Int, left: Boolean) {
        if (client.isClientThread()) {
            CLICK_EXECUTOR.execute { handleClick(x, y, left) }
        } else {
            handleClick(x, y, left)
        }
    }

    private fun handleClick(x: Int, y: Int, left: Boolean) {
        val start = System.currentTimeMillis()
        val canvas: Canvas = client.getCanvas()
        if (exited) {
            entered(x, y, canvas, System.currentTimeMillis())
        }
        moved(x, y, canvas, System.currentTimeMillis())
        Time.sleep(2, 30)
        pressed(x, y, canvas, System.currentTimeMillis(), if (left) MouseEvent.BUTTON1 else MouseEvent.BUTTON3)
        Time.sleep(2, 30)
        val currTime = System.currentTimeMillis()
        released(x, y, canvas, currTime, if (left) MouseEvent.BUTTON1 else MouseEvent.BUTTON3)
        clicked(x, y, canvas, currTime, if (left) MouseEvent.BUTTON1 else MouseEvent.BUTTON3)
        if (Rand.nextBool() && !exited) {
            exited(x, y, canvas, System.currentTimeMillis())
        }
        val sleep = MENU_REPLACE_DELAY - (System.currentTimeMillis() - start)
        if (sleep > 0) {
            Time.sleep(sleep)
        } else {
            Time.sleep(MENU_REPLACE_DELAY.toLong())
        }
    }

    fun click(point: Point, left: Boolean) {
        click(point.getX().toInt(), point.getY().toInt(), left)
    }

    fun clickRandom(left: Boolean) {
        click(CLICK_POINT_SUPPLIER.get(), left)
    }

    @Synchronized
    fun pressed(x: Int, y: Int, canvas: Canvas, time: Long, button: Int) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_PRESSED, time, 0, x, y, 1, false, button)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }

    @Synchronized
    fun released(x: Int, y: Int, canvas: Canvas, time: Long, button: Int) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_RELEASED, time, 0, x, y, 1, false, button)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }

    @Synchronized
    fun clicked(x: Int, y: Int, canvas: Canvas, time: Long, button: Int) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_CLICKED, time, 0, x, y, 1, false, button)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }

    @Synchronized
    fun released(x: Int, y: Int, canvas: Canvas, time: Long) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_RELEASED, time, 0, x, y, 1, false)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }

    @Synchronized
    fun clicked(x: Int, y: Int, canvas: Canvas, time: Long) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_CLICKED, time, 0, x, y, 1, false)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }

    @Synchronized
    fun exited(x: Int, y: Int, canvas: Canvas, time: Long) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_EXITED, time, 0, x, y, 0, false)
        event.source = "meteor"
        canvas.dispatchEvent(event)
        exited = true
    }

    @Synchronized
    fun entered(x: Int, y: Int, canvas: Canvas, time: Long) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_ENTERED, time, 0, x, y, 0, false)
        event.source = "meteor"
        canvas.dispatchEvent(event)
        exited = false
    }

    @Synchronized
    fun moved(x: Int, y: Int, canvas: Canvas, time: Long) {
        val event = MouseEvent(canvas, MouseEvent.MOUSE_MOVED, time, 0, x, y, 0, false)
        event.source = "meteor"
        canvas.dispatchEvent(event)
    }
}