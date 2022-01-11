package meteor.ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import meteor.ui.Components.Toolbar.Position.*
import meteor.ui.UI.toolbarPosition

object Modifiers {
    fun toolbarDragListener(): Modifier {
        var offCurrent: Offset? = null
        return Modifier.pointerInput(Unit) {
            detectDragGestures(
                    onDrag = { change, offset ->
                        offCurrent = if (offCurrent == null)
                            offset
                        else
                            offCurrent?.plus(change.positionChange())
                        change.consumeAllChanges()
                        if (offCurrent!!.y < (((UI.contentSize.height / 4) * 2) * -1))
                            toolbarPosition.value = TOP
                        if (offCurrent!!.y > ((UI.contentSize.height / 4) * 2))
                            toolbarPosition.value = BOTTOM
                        if (offCurrent!!.x < ((UI.contentSize.width / 4) * 2) * -1)
                            toolbarPosition.value = LEFT
                        if (offCurrent!!.x > ((UI.contentSize.width / 4) * 2))
                            toolbarPosition.value = RIGHT
                    },
                    onDragStart = {
                        offCurrent = null
                    },
                    onDragEnd = {
                        /*  Debug dragging

                            println("Screen width: ${composeWindow.width}, height: ${composeWindow.height}")
                            println(offCurrent)
                        */
                    })
        }
    }
}