package meteor.plugins.demonicgorilla

import net.runelite.api.Player

internal class PendingGorillaAttack(
    val attacker: DemonicGorilla?,
    val attackStyle: DemonicGorilla.AttackStyle?,
    val target: Player?,
    val finishesOnTick: Int
)