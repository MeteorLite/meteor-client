package meteor.plugins.coxhelper

import lombok.Getter
import lombok.Setter
import meteor.Main.client
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import java.util.function.Consumer


object Olm {
    private val plugin = CoxPlugin()
    val config: CoxConfig = plugin.configuration()
    val healPools: MutableList<WorldPoint> = ArrayList<WorldPoint>()
    val portals: MutableList<WorldPoint> = ArrayList<WorldPoint>()
    val victims: MutableSet<Victim> = HashSet()
    var portalTicks = 10
    var active = false // in fight
    var firstPhase = false
    var finalPhase = false
    var phaseType = PhaseType.UNKNOWN
    var hand: GameObject? = null
    var handAnimation = OlmAnimation.UNKNOWN
    var head: GameObject? = null
    var headAnimation = OlmAnimation.UNKNOWN
    var ticksUntilNextAttack = -1
    var attackCycle: Int = 1
    var specialCycle = 1
    var crippled = false
    var crippleTicks = 45
    var prayer: Prayer? = null
    var lastPrayTime: Long = 0
    fun startPhase() {
        firstPhase = !active
        active = true
        ticksUntilNextAttack = -1
        attackCycle = 1
        specialCycle = 1
        crippled = false
        crippleTicks = 45
        prayer = null
        lastPrayTime = 0
        headAnimation = OlmAnimation.UNKNOWN
        handAnimation = OlmAnimation.UNKNOWN
    }

    fun hardRest() {
        active = false
        firstPhase = false
        finalPhase = false
        phaseType = PhaseType.UNKNOWN
        hand = null
        head = null
        headAnimation = OlmAnimation.UNKNOWN
        handAnimation = OlmAnimation.UNKNOWN
        ticksUntilNextAttack = -1
        attackCycle = 1
        specialCycle = 1
        healPools.clear()
        portals.clear()
        portalTicks = 10
        victims.clear()
        crippled = false
        crippleTicks = 45
        prayer = null
        lastPrayTime = 0
    }

    fun set_Prayer(pray: Prayer?) {
        prayer = pray
        lastPrayTime = System.currentTimeMillis()
    }

    private fun cripple() {
        crippled = true
        crippleTicks = 45
    }

    private fun uncripple() {
        crippled = false
        crippleTicks = 45
    }

    fun update() {
        updateVictims()
        updateCrippleSticks()
        updateSpecials()
        incrementTickCycle()
        headAnimations()
        handAnimations()
    }

    private fun incrementTickCycle() {
        if (ticksUntilNextAttack == 1) {
            ticksUntilNextAttack = 4
            incrementAttackCycle()
        } else if (ticksUntilNextAttack != -1) {
            ticksUntilNextAttack--
        }
    }

    private fun incrementAttackCycle() {
        if (attackCycle == 4) {
            attackCycle = 1
            incrementSpecialCycle()
        } else {
            attackCycle++
        }
    }

    private fun incrementSpecialCycle() {
        if (specialCycle == 3 && !finalPhase || specialCycle == 4) {
            specialCycle = 1
        } else {
            specialCycle++
        }
    }

    private fun specialSync(currentAnimation: OlmAnimation?) {
        ticksUntilNextAttack = 4
        attackCycle = 1
        when (currentAnimation) {
            OlmAnimation.LEFT_HAND_CRYSTALS1, OlmAnimation.LEFT_HAND_CRYSTALS2 -> specialCycle = 2
            OlmAnimation.LEFT_HAND_LIGHTNING1, OlmAnimation.LEFT_HAND_LIGHTNING2 -> specialCycle = 3
            OlmAnimation.LEFT_HAND_PORTALS1, OlmAnimation.LEFT_HAND_PORTALS2 -> specialCycle = if (finalPhase) 4 else 1
            OlmAnimation.LEFT_HAND_HEAL1, OlmAnimation.LEFT_HAND_HEAL2 -> specialCycle = 1
            else -> {
                OlmAnimation.UNKNOWN
            }
        }
    }

    private fun updateCrippleSticks() {
        if (!crippled) {
            return
        }
        crippleTicks--
        if (crippleTicks <= 0) {
            crippled = false
            crippleTicks = 45
        }
    }

    private fun updateVictims() {
        if (victims.size > 0) {
            victims.forEach(Consumer { obj: Victim -> obj.updateTicks() })
            victims.removeIf { victim: Victim -> victim.ticks <= 0 }
        }
    }

    private fun updateSpecials() {
        healPools.clear()
        portals.clear()
        client.clearHintArrow()
        for (o in client.graphicsObjects) {
            if (o.id == GraphicID.OLM_TELEPORT) {
                portals.add(WorldPoint.fromLocal(client, o.location))
            }
            if (o.id == GraphicID.OLM_HEAL) {
                healPools.add(WorldPoint.fromLocal(client, o.location))
            }
            if (!portals.isEmpty()) {
                portalTicks--
                if (portalTicks <= 0) {
                    client.clearHintArrow()
                    portalTicks = 10
                }
            }
        }
    }

    private fun headAnimations() {
        if (head == null || head?.renderable == null) {
            return
        }
        val currentAnimation: OlmAnimation =
            OlmAnimation.fromId((head?.renderable as DynamicObject).animationID)
        if (currentAnimation == headAnimation) {
            return
        }
        when (currentAnimation) {
            OlmAnimation.HEAD_RISING_2, OlmAnimation.HEAD_ENRAGED_RISING_2 -> {
                ticksUntilNextAttack = if (firstPhase) 6 else 8
                attackCycle = 1
                specialCycle = 1
            }
            OlmAnimation.HEAD_ENRAGED_LEFT, OlmAnimation.HEAD_ENRAGED_MIDDLE, OlmAnimation.HEAD_ENRAGED_RIGHT -> finalPhase =
                true
            else -> {
                OlmAnimation.UNKNOWN
            }
        }
        headAnimation = currentAnimation
    }

    private fun handAnimations() {
        if (hand == null || hand?.renderable == null) {
            return
        }
        val currentAnimation: OlmAnimation =
            OlmAnimation.fromId((hand?.renderable as DynamicObject).animationID)
        if (currentAnimation == handAnimation) {
            return
        }
        when (currentAnimation) {
            OlmAnimation.LEFT_HAND_CRYSTALS1, OlmAnimation.LEFT_HAND_CRYSTALS2, OlmAnimation.LEFT_HAND_LIGHTNING1, OlmAnimation.LEFT_HAND_LIGHTNING2, OlmAnimation.LEFT_HAND_PORTALS1, OlmAnimation.LEFT_HAND_PORTALS2, OlmAnimation.LEFT_HAND_HEAL1, OlmAnimation.LEFT_HAND_HEAL2 -> specialSync(
                currentAnimation
            )
            OlmAnimation.LEFT_HAND_CRIPPLING -> cripple()
            OlmAnimation.LEFT_HAND_UNCRIPPLING1, OlmAnimation.LEFT_HAND_UNCRIPPLING2 -> uncripple()
            else -> {
                OlmAnimation.UNKNOWN
            }
        }
        handAnimation = currentAnimation
    }

    enum class PhaseType {
        FLAME, ACID, CRYSTAL, UNKNOWN
    }

        const val HEAD_GAMEOBJECT_RISING = 29880
        const val HEAD_GAMEOBJECT_READY = 29881
        const val LEFT_HAND_GAMEOBJECT_RISING = 29883
        const val LEFT_HAND_GAMEOBJECT_READY = 29884
        const val RIGHT_HAND_GAMEOBJECT_RISING = 29886
        const val RIGHT_HAND_GAMEOBJECT_READY = 29887


}