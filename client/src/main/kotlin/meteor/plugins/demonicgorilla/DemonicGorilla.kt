package meteor.plugins.demonicgorilla

import net.runelite.api.Actor
import net.runelite.api.HeadIcon
import net.runelite.api.NPC
import net.runelite.api.coords.WorldArea

class DemonicGorilla(val npc: NPC) {
    var nextPossibleAttackStyles: List<AttackStyle?> = listOf(*ALL_REGULAR_ATTACK_STYLES)
    var attacksUntilSwitch: Int = 3
    var nextAttackTick: Int = -100
    var lastTickAnimation = 0
    var lastWorldArea: WorldArea? = null
    var isInitiatedCombat = false
    var lastTickInteracting: Actor? = null
    var isTakenDamageRecently = false
    var recentProjectileId: Int = -1
    var isChangedPrayerThisTick = false
    var isChangedAttackStyleThisTick = false
    var isChangedAttackStyleLastTick = false
    var lastTickOverheadIcon: HeadIcon? = null
    var disabledMeleeMovementForTicks = 0

    enum class AttackStyle {
        MAGIC, RANGED, MELEE, BOULDER
    }

    val overheadIcon: HeadIcon?
        get() {
            val composition = npc.composition
            return composition?.overheadIcon
        }

    companion object {
        const val MAX_ATTACK_RANGE = 10
        const val ATTACK_RATE = 5
        const val ATTACKS_PER_SWITCH = 3
        val ALL_REGULAR_ATTACK_STYLES = arrayOf(AttackStyle.MELEE, AttackStyle.RANGED, AttackStyle.MAGIC)
    }
}