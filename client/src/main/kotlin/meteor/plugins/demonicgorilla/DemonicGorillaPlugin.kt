package meteor.plugins.demonicgorilla

import com.google.common.collect.ImmutableSet
import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.HitsplatID.BLOCK_ME
import net.runelite.api.HitsplatID.DAMAGE_ME
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import java.util.*
import javax.inject.Singleton
import kotlin.collections.HashMap

@Suppress("DEPRECATION", "unused")
@PluginDescriptor(
    name = "Demonic Gorillas",
    description = "Count demonic gorilla attacks and display their next possible attack styles",
    tags = ["combat", "overlay", "pve", "pvm"]
)
@Singleton
class DemonicGorillaPlugin : Plugin() {

    private val overlay = overlay(DemonicGorillaOverlay(this))
    private val clientThread = ClientThread
    var gorillas: MutableMap<NPC, DemonicGorilla> = HashMap()
    private var recentBoulders: MutableList<WorldPoint>? = null
    private var pendingAttacks: MutableList<PendingGorillaAttack>? = null
    private var memorizedPlayers: MutableMap<Player, MemorizedPlayer>? = null

    override fun onStart() {
        recentBoulders = ArrayList<WorldPoint>()
        pendingAttacks = ArrayList()
        memorizedPlayers = HashMap()
        clientThread.invoke { reset() }
    }

    override fun onStop() {
        recentBoulders = null
        pendingAttacks = null
        memorizedPlayers = null
    }

    private fun clear() {
        recentBoulders!!.clear()
        pendingAttacks!!.clear()
        memorizedPlayers!!.clear()
        gorillas.clear()
    }

    private fun reset() {
        recentBoulders!!.clear()
        pendingAttacks!!.clear()
        resetGorillas()
        resetPlayers()
    }

    private fun resetGorillas() {
        gorillas.clear()
        for (npc in client.npcs) {
            if (isNpcGorilla(npc.id)) gorillas[npc] = DemonicGorilla(npc)
        }
    }

    private fun resetPlayers() {
        memorizedPlayers?.clear()
        for (player in client.players) memorizedPlayers?.set(player, MemorizedPlayer(player))
    }

    private fun checkGorillaAttackStyleSwitch(
        gorilla: DemonicGorilla?,
        vararg protectedStyles:DemonicGorilla.AttackStyle
    ) {
        if (gorilla!!.attacksUntilSwitch <= 0 ||
            gorilla.nextPossibleAttackStyles.isEmpty()
        ) {
            gorilla.nextPossibleAttackStyles = DemonicGorilla.ALL_REGULAR_ATTACK_STYLES
                .filter { x: DemonicGorilla.AttackStyle ->
                    protectedStyles.none { y: DemonicGorilla.AttackStyle -> x == y }
                }
            gorilla.attacksUntilSwitch = DemonicGorilla.ATTACKS_PER_SWITCH
            gorilla.isChangedAttackStyleThisTick = true
        }
    }

    private fun getProtectedStyle(player: Player): DemonicGorilla.AttackStyle? {
        val headIcon = player.overheadIcon ?: return null
        return when (headIcon) {
            HeadIcon.MELEE -> DemonicGorilla.AttackStyle.MELEE
            HeadIcon.RANGED -> DemonicGorilla.AttackStyle.RANGED
            HeadIcon.MAGIC -> DemonicGorilla.AttackStyle.MAGIC
            else -> {
                null
            }
        }
    }

    private fun onGorillaAttack(gorilla: DemonicGorilla?, attackStyle: DemonicGorilla.AttackStyle?) {
        gorilla?.isInitiatedCombat = true
        val target = gorilla?.npc?.interacting as Player
        val protectedStyle: DemonicGorilla.AttackStyle? = getProtectedStyle(target)
        val correctPrayer = attackStyle == protectedStyle
        if (attackStyle == DemonicGorilla.AttackStyle.BOULDER) {
            gorilla.nextPossibleAttackStyles = gorilla
                .nextPossibleAttackStyles
                .filter { x: DemonicGorilla.AttackStyle? -> x != DemonicGorilla.AttackStyle.MELEE }
        } else {
            if (correctPrayer) {
                gorilla.attacksUntilSwitch = (gorilla.attacksUntilSwitch - 1)
            } else {
                var damagesOnTick = client.tickCount
                if (attackStyle == DemonicGorilla.AttackStyle.MAGIC) {
                    val mp = memorizedPlayers!![target]
                    val lastPlayerArea: WorldArea? = mp?.lastWorldArea
                    if (lastPlayerArea != null) {
                        val dist: Int = gorilla.npc.worldArea.distanceTo(lastPlayerArea)
                        damagesOnTick += (dist + 12) / 8
                    }
                } else if (attackStyle == DemonicGorilla.AttackStyle.RANGED) {
                    val mp = memorizedPlayers!![target]
                    val lastPlayerArea: WorldArea? = mp?.lastWorldArea
                    if (lastPlayerArea != null) {
                        val dist: Int = gorilla.npc.worldArea.distanceTo(lastPlayerArea)
                        damagesOnTick += (dist + 9) / 6
                    }
                }
                pendingAttacks!!.add(PendingGorillaAttack(gorilla, attackStyle, target, damagesOnTick))
            }
            gorilla.nextPossibleAttackStyles = gorilla
                .nextPossibleAttackStyles
                .filter { x: DemonicGorilla.AttackStyle? -> x == attackStyle }

            if (gorilla.nextPossibleAttackStyles.isEmpty()) {
                gorilla.nextPossibleAttackStyles =
                    DemonicGorilla.ALL_REGULAR_ATTACK_STYLES
                        .filter { x: DemonicGorilla.AttackStyle? -> x == attackStyle }
                gorilla.attacksUntilSwitch = (3 - if (correctPrayer) 1 else 0)
            }
        }
        checkGorillaAttackStyleSwitch(gorilla, protectedStyle!!)
        val tickCounter = client.tickCount
        gorilla.nextAttackTick = (tickCounter + 5)
    }

    private fun checkGorillaAttacks() {
        val tickCounter = client.tickCount
        if (gorillas.values.isNotEmpty())
            for (gorilla in gorillas.values) {
                val interacting: Actor? = gorilla.npc.interacting
                val mp = memorizedPlayers!![interacting]
                if (interacting != null) {
                    if (gorilla.lastTickInteracting != null) {
                        gorilla.isInitiatedCombat = false
                    } else if (mp?.lastWorldArea != null &&
                        !gorilla.isInitiatedCombat && tickCounter < gorilla.nextAttackTick &&
                        gorilla.npc.worldArea.isInMeleeDistance(mp.lastWorldArea)
                    ) {
                        gorilla.isInitiatedCombat = true
                        gorilla.nextAttackTick = tickCounter + 1
                    }
                    val animationId = gorilla.npc.animation
                    if (gorilla.isTakenDamageRecently &&
                        tickCounter >= gorilla.nextAttackTick + 4
                    ) {
                        // The gorilla was flinched, so its next attack gets delayed
                        gorilla.nextAttackTick = tickCounter + DemonicGorilla.ATTACK_RATE / 2
                        gorilla.isInitiatedCombat = true
                        if (mp?.lastWorldArea != null &&
                            !gorilla.npc.worldArea.isInMeleeDistance(mp.lastWorldArea) &&
                            !gorilla.npc.worldArea.intersectsWith(mp.lastWorldArea)
                        ) {
                            // Gorillas stop meleeing when they get flinched
                            // and the target isn't in melee distance
                            gorilla.nextPossibleAttackStyles = gorilla
                                .nextPossibleAttackStyles
                                .filter { x: DemonicGorilla.AttackStyle? -> x != DemonicGorilla.AttackStyle.MELEE }

                            checkGorillaAttackStyleSwitch(
                                gorilla, DemonicGorilla.AttackStyle.MELEE,
                                getProtectedStyle(interacting as Player)!!
                            )

                        }
                    } else if (animationId != gorilla.lastTickAnimation) {
                        if (animationId == AnimationID.DEMONIC_GORILLA_MELEE_ATTACK) {
                            onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.MELEE)
                        } else if (animationId == AnimationID.DEMONIC_GORILLA_MAGIC_ATTACK) {
                            onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.MAGIC)
                        } else if (animationId == AnimationID.DEMONIC_GORILLA_RANGED_ATTACK) {
                            onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.RANGED)
                        } else if (animationId == AnimationID.DEMONIC_GORILLA_AOE_ATTACK) {
                            // Note that AoE animation is the same as prayer switch animation
                            // so we need to check if the prayer was switched or not.
                            // It also does this animation when it spawns, so
                            // we need the interacting != null check.
                            if (gorilla.overheadIcon == gorilla.lastTickOverheadIcon) {
                                // Confirmed, the gorilla used the AoE attack
                                onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.BOULDER)
                            } else {
                                if (tickCounter >= gorilla.nextAttackTick) {
                                    gorilla.isChangedPrayerThisTick = true

                                    // This part is more complicated because the gorilla may have
                                    // used an attack, but the prayer switch animation takes
                                    // priority over normal attack animations.
                                    val projectileId = gorilla.recentProjectileId
                                    if (projectileId == ProjectileID.DEMONIC_GORILLA_MAGIC) {
                                        onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.MAGIC)
                                    } else if (projectileId == ProjectileID.DEMONIC_GORILLA_RANGED) {
                                        onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.RANGED)
                                    } else if (mp != null) {
                                        val lastPlayerArea = mp.lastWorldArea
                                        if (lastPlayerArea != null && recentBoulders!!
                                                .any { x: WorldPoint -> x.distanceTo(lastPlayerArea) == 0 }
                                        ) {
                                            // A boulder started falling on the gorillas target,
                                            // so we assume it was the gorilla who shot it
                                            onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.BOULDER)
                                        } else if (mp.recentHitsplats.isNotEmpty()) {
                                            // It wasn't any of the three other attacks,
                                            // but the player took damage, so we assume
                                            // it's a melee attack
                                            onGorillaAttack(gorilla, DemonicGorilla.AttackStyle.MELEE)
                                        }
                                    }
                                }

                                // The next attack tick is always delayed if the
                                // gorilla switched prayer
                                gorilla.nextAttackTick = tickCounter + DemonicGorilla.ATTACK_RATE
                                gorilla.isChangedPrayerThisTick = true
                            }
                        }
                    }
                    if (gorilla.disabledMeleeMovementForTicks > 0) {
                        gorilla.disabledMeleeMovementForTicks = gorilla.disabledMeleeMovementForTicks - 1
                    } else if (gorilla.isInitiatedCombat && gorilla.npc.interacting != null &&
                        !gorilla.isChangedAttackStyleThisTick && gorilla.nextPossibleAttackStyles.size >= 2 &&
                        gorilla.nextPossibleAttackStyles
                            .any { x: DemonicGorilla.AttackStyle? -> x == DemonicGorilla.AttackStyle.MELEE }
                    ) {
                        // If melee is a possibility, we can check if the gorilla
                        // is or isn't moving toward the player to determine if
                        // it is actually attempting to melee or not.
                        // We only run this check if the gorilla is in combat
                        // because otherwise it attempts to travel to melee
                        // distance before attacking its target.
                        if (mp?.lastWorldArea != null && gorilla.lastWorldArea != null) {
                            val predictedNewArea = gorilla.lastWorldArea!!.calculateNextTravellingPoint(
                                client, mp.lastWorldArea, true
                            ) { x: WorldPoint? ->
                                // Gorillas can't normally walk through other gorillas
                                // or other players
                                val area1 = WorldArea(x, 1, 1)
                                gorillas.values.none { y: DemonicGorilla? ->
                                    if (y === gorilla) {
                                        return@none false
                                    }
                                    val area2 =
                                        if (y!!.npc.index < gorilla.npc.index) y.npc.worldArea else y.lastWorldArea
                                    area2 != null && area1.intersectsWith(area2)
                                } && memorizedPlayers!!.values.none { y: MemorizedPlayer ->
                                    val area2 = y.lastWorldArea
                                    area2 != null && area1.intersectsWith(area2)
                                }
                            }
                            if (predictedNewArea != null) {
                                val distance = gorilla.npc.worldArea.distanceTo(mp.lastWorldArea)
                                val predictedMovement = predictedNewArea.toWorldPoint()
                                if (distance <= DemonicGorilla.MAX_ATTACK_RANGE && mp.lastWorldArea?.hasLineOfSightTo(
                                        client,
                                        gorilla.lastWorldArea
                                    ) == true
                                ) {
                                    if (predictedMovement.distanceTo(gorilla.lastWorldArea!!.toWorldPoint()) != 0) {
                                        if (predictedMovement.distanceTo(gorilla.npc.worldLocation) == 0) {
                                            gorilla.nextPossibleAttackStyles = gorilla
                                                .nextPossibleAttackStyles
                                                .filter { x: DemonicGorilla.AttackStyle? -> x == DemonicGorilla.AttackStyle.MELEE }
                                        } else {
                                            gorilla.nextPossibleAttackStyles = gorilla
                                                .nextPossibleAttackStyles
                                                .filter { x: DemonicGorilla.AttackStyle? -> x != DemonicGorilla.AttackStyle.MELEE }
                                        }
                                    } else if (tickCounter >= gorilla.nextAttackTick && gorilla.recentProjectileId == -1 &&
                                        recentBoulders!!
                                            .none { x: WorldPoint -> x.distanceTo(mp.lastWorldArea) == 0 }
                                    ) {
                                        gorilla.nextPossibleAttackStyles = gorilla
                                            .nextPossibleAttackStyles
                                            .filter { x: DemonicGorilla.AttackStyle? -> x == DemonicGorilla.AttackStyle.MELEE }
                                    }
                                }
                            }
                        }
                    }
                    if (gorilla.isTakenDamageRecently) {
                        gorilla.isInitiatedCombat = true
                    }
                    if (gorilla.overheadIcon != gorilla.lastTickOverheadIcon) {
                        if (gorilla.isChangedAttackStyleLastTick ||
                            gorilla.isChangedAttackStyleThisTick
                        ) {
                            // Apparently if it changes attack style and changes
                            // prayer on the same tick or 1 tick apart, it won't
                            // be able to move for the next 2 ticks if it attempts
                            // to melee
                            gorilla.disabledMeleeMovementForTicks = 2
                        } else {
                            // If it didn't change attack style lately,
                            // it's only for the next 1 tick
                            gorilla.disabledMeleeMovementForTicks = 1
                        }
                    }
                    gorilla.lastTickAnimation = gorilla.npc.animation
                    gorilla.lastWorldArea = gorilla.npc.worldArea
                    gorilla.lastTickInteracting = gorilla.npc.interacting
                    gorilla.isTakenDamageRecently = false
                    gorilla.isChangedPrayerThisTick = false
                    gorilla.isChangedAttackStyleLastTick = gorilla.isChangedAttackStyleThisTick
                    gorilla.isChangedAttackStyleThisTick = false
                    gorilla.lastTickOverheadIcon = gorilla.overheadIcon
                    gorilla.recentProjectileId = -1
                }
            }
    }


     override fun onProjectileMoved(it: ProjectileMoved) {
        val projectile: Projectile = it.projectile
        val projectileId = projectile.id
        if (!DEMONIC_PROJECTILES.contains(Integer.valueOf(projectileId))) return
        val loc: WorldPoint = WorldPoint.fromLocal(client, projectile.x1, projectile.y1, client.plane)
        if (projectileId == 856) {
            recentBoulders?.add(loc)
        } else {
            for (gorilla in gorillas.values) {
                if (gorilla.npc.worldLocation?.distanceTo(loc) == 0) gorilla.recentProjectileId = projectile.id
            }
        }
    }

    private fun checkPendingAttacks() {
        val it = pendingAttacks!!.iterator()
        val tickCounter = client.tickCount
        while (it.hasNext()) {
            val attack = it.next()
            if (tickCounter >= attack.finishesOnTick) {
                var shouldDecreaseCounter = false
                val gorilla = attack.attacker
                val target = memorizedPlayers!![attack.target]
                if (target == null) {
                    shouldDecreaseCounter = true
                } else if (target.recentHitsplats.isEmpty()) {
                    shouldDecreaseCounter = true
                } else if (target.recentHitsplats
                        .any { x: Hitsplat? -> x?.hitsplatType == BLOCK_ME }
                ) {
                    shouldDecreaseCounter = true
                }
                if (shouldDecreaseCounter) {
                    gorilla?.attacksUntilSwitch = (gorilla?.attacksUntilSwitch?.minus(1)!!)
                    checkGorillaAttackStyleSwitch(gorilla)
                }
                it.remove()
            }
        }
    }

    private fun updatePlayers() {
        for (mp in memorizedPlayers!!.values) {
            mp.lastWorldArea = mp.player.worldArea
            mp.recentHitsplats.clear()
        }
    }

    override fun onHitsplatApplied(it: HitsplatApplied) {
        if (gorillas.isEmpty()) return
        if (it.actor is Player) {
            val player = it.actor as Player
            val mp = memorizedPlayers!![player]
            mp?.recentHitsplats?.add(it.hitsplat)
        } else if (it.actor is NPC) {
            val gorilla = gorillas[it.actor]
            val hitsplatType = it.hitsplat.hitsplatType
            if (gorilla != null && (hitsplatType == BLOCK_ME || hitsplatType == DAMAGE_ME)) gorilla.isTakenDamageRecently =
                true
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        val gs: GameState = it.gameState
        if (gs == GameState.LOGGING_IN || gs == GameState.CONNECTION_LOST || gs == GameState.HOPPING) reset()
    }

    override fun onPlayerSpawned(it: PlayerSpawned) {
        if (gorillas.isEmpty()) return
        val player: Player = it.player
        memorizedPlayers!![player] = MemorizedPlayer(player)
    }

    override fun onPlayerDespawned(it: PlayerDespawned) {
        if (gorillas.isEmpty()) return
        memorizedPlayers?.remove(it.player)
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc: NPC = it.npc
        if (isNpcGorilla(npc.id)) {
            if (gorillas.isEmpty()) resetPlayers()
            gorillas[npc] = DemonicGorilla(npc)
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        if (gorillas.remove(it.npc) != null && gorillas.isEmpty()) clear()
    }

    override fun onGameTick(it: GameTick) {
        checkGorillaAttacks()
        checkPendingAttacks()
        updatePlayers()
        recentBoulders!!.clear()
    }

    companion object {
        private val DEMONIC_PROJECTILES =
            ImmutableSet.of(Integer.valueOf(1302), Integer.valueOf(1304), Integer.valueOf(856)) as Set<Int>

        private fun isNpcGorilla(npcId: Int): Boolean {
            return npcId == 7144 || npcId == 7145 || npcId == 7146 || npcId == 7147 || npcId == 7148 || npcId == 7149
        }
    }
}