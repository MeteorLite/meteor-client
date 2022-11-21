package meteor.plugins.coxhelper

import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import net.runelite.api.Player
import java.util.*

@Getter
class Victim(val player: Player, val type: Type) {
    var ticks: Int = type.ticks

    fun updateTicks() {
        if (ticks > 0) {
            ticks--
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(player.name, type)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val victim = o as Victim
        return player.name == victim.player.name &&
                type == victim.type
    }

    @AllArgsConstructor
    @Getter(AccessLevel.PACKAGE)
    enum class Type( val ticks: Int = 0) {
        BURN(41), ACID(23), TELEPORT(10);

    }
}