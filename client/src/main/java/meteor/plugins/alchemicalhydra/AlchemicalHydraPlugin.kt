package meteor.plugins.alchemicalhydra

import eventbus.events.*
import meteor.game.SpriteManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import meteor.outline.ModelOutlineRenderer
import java.util.*

@PluginDescriptor(
    name = "Alchemical Hydra",
    description = "Automatically swap prayers for hydra  + and overlay so its all in one",
    tags = ["Hydra", "Lazy", "4 headed asshole"],
    enabledByDefault = false
)
class AlchemicalHydraPlugin : Plugin() {

    val poisonProjectiles: MutableMap<LocalPoint, Projectile> = HashMap()

    var hydra: Hydra? = null
    var immuneActive = true
    private var inHydraInstance = false
    private var lastAttackTick = 0
    var lightningList = ArrayList<GraphicsObject>()
    var redVent: GameObject? = null
    var greenVent: GameObject? = null
    var blueVent: GameObject? = null
    private var inFight = false
    var ventTicks = 0
    var config = configuration<HydraConfig>()
    private val spriteManager = SpriteManager
    private val clientThread = ClientThread
    private val renderer = ModelOutlineRenderer()
    private val overlay = overlay(HydraOverlay(this, spriteManager, config))
    private val sceneOverlay = overlay(HydraSceneOverlay(this, config))
    private val extraOverlay = overlay(HydraExtraOverlay(this, config, renderer))
    override fun onStart() {
        reset()
        initConfig()
        inHydraInstance = checkArea()
        lastAttackTick = -1
        poisonProjectiles.clear()
        overlayManager.add(extraOverlay)
    }

    override fun onStop() {
        reset()
        inHydraInstance = false
        hydra = null
        poisonProjectiles.clear()
        removeOverlays()
        lastAttackTick = -1
        overlayManager.remove(extraOverlay)
    }

    private fun reset() {
        immuneActive = true
        lightningList.clear()
        redVent = null
        greenVent = null
        blueVent = null
        ventTicks = 0
    }

    private fun initConfig() {
        overlay.safeCol = config.safeCol()
        overlay.medCol = config.medCol()
        overlay.badCol = config.badCol()
        sceneOverlay.poisonBorder = config.poisonBorderCol()
        sceneOverlay.poisonFill = config.poisonCol()
        sceneOverlay.badFountain = config.fountainColA()
        sceneOverlay.goodFountain = config.fountainColB()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != "betterHydra") {
            return
        }
        when (it.key) {
            "safeCol" -> {
                overlay.safeCol = config.safeCol()
                return
            }
            "medCol" -> {
                overlay.medCol = config.medCol()
                return
            }
            "badCol" -> {
                overlay.badCol = config.badCol()
                return
            }
            "poisonBorderCol" -> sceneOverlay.poisonBorder = config.poisonBorderCol()
            "poisonCol" -> sceneOverlay.poisonFill = config.poisonCol()
            "fountainColA" -> sceneOverlay.badFountain = config.fountainColA()
            "fountainColB" -> sceneOverlay.goodFountain = config.fountainColB()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOGGED_IN) {
            inHydraInstance = checkArea()
            if (!inHydraInstance) {
                if (hydra != null) {
                    removeOverlays()
                    hydra = null
                }
            } else {
                for (npc in client.npcs) {
                    if (npc.id == NpcID.ALCHEMICAL_HYDRA) {
                        hydra = Hydra(npc)
                        break
                    }
                }
                addOverlays()
            }
        }
        if (it.gameState == GameState.LOADING) {
            inFight = false
        }
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        if (inHydraInstance) {
            if (it.npc.id == NpcID.ALCHEMICAL_HYDRA) {
                hydra = Hydra(it.npc)
                addOverlays()
            }
        }
        if (it.npc.id == 8615) {
            immuneActive = true
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        if (it.npc.id == 8615 || it.npc.id == 8616 || it.npc.id == 8617 || it.npc.id == 8618 || it.npc.id == 8619 || it.npc.id == 8620 || it.npc.id == 8621 || it.npc.id == 8622) {
            immuneActive = true
        }
    }

    override fun onNpcChanged(it: NpcChanged) {
        if (it.npc.id == 8619 || it.npc.id == 8620) {
            immuneActive = true
        }
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        val actor = it.actor
        if (this.client.localPlayer != null) {
            if (it.actor.name != null && it.actor is NPC) {
                if (it.actor.name.lowercase(Locale.getDefault()).contains("alchemical hydra")
                    && (it.actor.animation == 9111 || it.actor.animation == 9112 || it.actor.animation == 9113)
                ) {
                    if (config.attackChange()) {
                        client.playSoundEffect(3924, config.attackChangeVolume())
                    }
                }
            } else if (it.actor is Player && it.actor.animation == 839) {
                if (this.client.isInInstancedRegion) {
                    if (WorldPoint.fromLocalInstance(
                            client,
                            this.client.localPlayer!!.localLocation
                        ).regionID == 5536
                    ) {
                        ventTicks = 10
                    }
                } else {
                    ventTicks = 0
                }
            }
        }
        if (!inHydraInstance || hydra == null || actor === client.localPlayer) {
            return
        }
        val phase = hydra!!.phase
        if (actor.animation == phase.deathAnim2 && phase != HydraPhase.THREE || actor.animation == phase.deathAnim1 && phase == HydraPhase.THREE) {
            when (phase) {
                HydraPhase.ONE -> {
                    hydra!!.changePhase(HydraPhase.TWO)
                    return
                }
                HydraPhase.TWO -> {
                    hydra!!.changePhase(HydraPhase.THREE)
                    return
                }
                HydraPhase.THREE -> {
                    hydra!!.changePhase(HydraPhase.FOUR)
                    return
                }
                HydraPhase.FOUR -> {
                    hydra = null
                    poisonProjectiles.clear()
                    removeOverlays()
                    return
                }
            }
        } else if (actor.animation == phase.specAnimationId && phase.specAnimationId != 0) {
            if (hydra !=null) {
                hydra?.nextSpecial = (hydra!!.nextSpecial + 9)
            }
        }
        if (poisonProjectiles.isEmpty()) {
            return
        }
        val exPoisonProjectiles: MutableSet<LocalPoint> = HashSet()
        for ((key, value) in poisonProjectiles) {
            if (value.endCycle < client.gameCycle) {
                exPoisonProjectiles.add(key)
            }
        }
        for (toRemove in exPoisonProjectiles) {
            poisonProjectiles.remove(toRemove)
        }
    }

    override fun onProjectileMoved(it: ProjectileMoved) {
        if (!inHydraInstance || hydra == null || client.gameCycle >= it.projectile.startCycle) {
            return
        }
        val projectile = it.projectile
        val id = projectile.id
        if (hydra!!.phase.specProjectileId != 0 && hydra!!.phase.specProjectileId == id) {
            if (hydra!!.attackCount == hydra!!.nextSpecial) {
                hydra!!.nextSpecial = (hydra!!.nextSpecial + 9)
            }
            poisonProjectiles[it.position] = projectile
        } else if (client.tickCount != lastAttackTick && (id == Hydra.AttackStyle.MAGIC.projectileID || id == Hydra.AttackStyle.RANGED.projectileID)) {
            hydra!!.handleAttack(id)
            lastAttackTick = client.tickCount
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.message == "The chemicals neutralise the Alchemical Hydra's defences!") {
            hydra!!.weakened = true
            immuneActive = false
        } else if (it.message == "The Alchemical Hydra temporarily stuns you.") {
            if (config.stun()) {
                overlay.stunTicks = STUN_LENGTH
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        if (overlay.stunTicks > 0) {
            overlay.stunTicks = overlay.stunTicks - 1
        }
        if (config.autoPray() && hydra != null && inFight && !client.isPrayerActive(hydra!!.nextAttack.prayer)) {
            activatePrayer(hydra!!.nextAttack.prayer)
            if (config.offensivePrayerToggle()) {
                activatePrayer(config.offensivePrayer().prayer)
            }
        }
        if (ventTicks > 0) {
            ventTicks--
            if (ventTicks == 0) {
                ventTicks = 8
            }
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        when (it.gameObject.id) {
            34568 -> redVent = it.gameObject
            34569 -> greenVent = it.gameObject
            34570 -> blueVent = it.gameObject
        }
    }

    override fun onWallObjectSpawned(it: WallObjectSpawned) {
        if (it.wallObject.id == 34556) {
            inFight = true
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        when (it.gameObject.id) {
            34568 -> redVent = null
            34569 -> greenVent = null
            34570 -> blueVent = null
        }
    }

    private fun checkArea(): Boolean {
        return Arrays.equals(client.mapRegions, HYDRA_REGIONS) && client.isInInstancedRegion
    }

    private fun addOverlays() {
        if (config.counting() || config.stun()) {
            overlayManager.add(overlay)
        }
        if (config.counting() || config.fountain()) {
            overlayManager.add(sceneOverlay)
        }
    }

    private fun removeOverlays() {
        overlayManager.remove(overlay)
        overlayManager.remove(sceneOverlay)
    }

    private fun activatePrayer(prayer: Prayer?) {
        if (prayer == null) {
            return
        }

        //check if prayer is already active this tick
        if (client.isPrayerActive(prayer)) {
            return
        }
        val widgetInfo = prayer.widgetInfo ?: return
        val prayerWidget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        clientThread.invoke {
            client.invokeMenuAction(
                "Activate",
                prayerWidget.name,
                1,
                MenuAction.CC_OP.id,
                prayerWidget.itemId,
                prayerWidget.id
            )
        }
    }

    companion object {
        private val HYDRA_REGIONS = intArrayOf(
            5279, 5280,
            5535, 5536
        )
        private const val STUN_LENGTH = 7
    }
}