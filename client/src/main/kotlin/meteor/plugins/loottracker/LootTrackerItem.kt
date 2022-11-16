
package meteor.plugins.loottracker

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import dev.hoot.api.game.Prices
import lombok.*
import meteor.Main
import meteor.Main.itemManager
import meteor.util.AsyncBufferedImage

class LootTrackerItem( val id: Int = 0, var quantity: MutableState<Int>){
    var asyncBufferedImage = mutableStateOf(itemManager.getImage(id, quantity.value,quantity.value>1)!!)
    var price = mutableStateOf(Prices.getItemPrice(id))
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LootTrackerItem

        if (id != other.id) return false

        return true }

    override fun hashCode(): Int {
        return id
    } }