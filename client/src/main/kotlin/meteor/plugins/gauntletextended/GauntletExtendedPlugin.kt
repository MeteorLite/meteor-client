/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/xKylee>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.gauntletextended

import eventbus.events.*
import meteor.Main
import meteor.api.items.Items
import meteor.api.items.Items.getFirst
import meteor.game.SkillIconManager
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.gauntletextended.entity.*
import meteor.plugins.gauntletextended.overlay.*
import meteor.plugins.gauntletextended.resource.ResourceManager
import meteor.rs.ClientThread
import meteor.ui.overlay.OverlayManager
import meteor.util.HotkeyListener
import net.runelite.api.*
import net.runelite.api.queries.GameObjectQuery
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import ui.overlay.outline.ModelOutlineRenderer
import java.util.*
import java.util.List
import java.util.function.Consumer

@PluginDescriptor(
    name = "Gauntlet Extended",
    enabledByDefault = false,
    description = "All-in-one plugin for the Gauntlet.",
    tags = ["gauntlet"]
)
class GauntletExtendedPlugin : Plugin() {
    var isFirstPlayerPhase = true
    override var client = Main.client
    private val clientThread = ClientThread
    var config = configuration<GauntletExtendedConfig>()
    private val resourceManager = ResourceManager(this, config)
    private val skillIconManager = SkillIconManager
    override val overlayManager = OverlayManager
    private val renderer = ModelOutlineRenderer()
    private val overlayTimer = OverlayTimer(this, config)
    private val overlayGauntlet = OverlayGauntlet(this, config, renderer)
    private val overlayHunllef = OverlayHunllef(this, config, renderer)
    private val overlayPrayerWidget = OverlayPrayerWidget(this, config)
    private val overlayPrayerBox = OverlayPrayerBox(this, config)

    val resources: MutableSet<Resource> = HashSet()

    val utilities: MutableSet<GameObject> = HashSet()

    val tornadoes: MutableSet<Tornado> = HashSet()

    val demibosses: MutableSet<Demiboss> = HashSet()

    val strongNpcs: MutableSet<NPC> = HashSet()

    val weakNpcs: MutableSet<NPC> = HashSet()
    private val entitySets =
        Arrays.asList<MutableSet<*>>(resources, utilities, tornadoes, demibosses, strongNpcs, weakNpcs)

    var missile: Missile? = null

    var hunllef: Hunllef? = null

    var wrongAttackStyle = false

    var switchWeapon = false
    private var inGauntlet = false
    private var inHunllef = false
    override fun onStart() {
        if (client.gameState == GameState.LOGGED_IN) {
            clientThread.invoke { pluginEnabled() }
        }
        KeyManager.registerKeyListener(eat, this.javaClass)
        KeyManager.registerKeyListener(drink, this.javaClass)
    }

    override fun onStop() {
        inGauntlet = false
        inHunllef = false
        hunllef = null
        missile = null
        wrongAttackStyle = false
        switchWeapon = false
        overlayTimer.reset()
        resourceManager.reset()
        entitySets.forEach(Consumer { obj: MutableSet<*> -> obj.clear()
            KeyManager.unregisterKeyListener(eat)
            KeyManager.unregisterKeyListener(drink)})
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != "gauntlet") {
            return
        }
        when (it.key) {
            "resourceIconSize" -> if (!resources.isEmpty()) {
                resources.forEach(Consumer { r: Resource -> r.setIconSize(config.resourceIconSize()) })
            }
            "resourceTracker" -> if (inGauntlet && !inHunllef) {
                resourceManager.reset()
                resourceManager.init()
            }
            "projectileIconSize" -> if (missile != null) {
                missile!!.setIconSize(config.projectileIconSize())
            }
            "hunllefAttackStyleIconSize" -> if (hunllef != null) {
                hunllef!!.setIconSize(config.hunllefAttackStyleIconSize())
            }
            else -> {}
        }
    }

    override fun onVarbitChanged(it: VarbitChanged) {
        if (isHunllefVarbitSet) {
            if (!inHunllef) {
                initHunllef()
            }
        } else if (isGauntletVarbitSet) {
            if (!inGauntlet) {
                initGauntlet()
            }
        } else {
            if (inGauntlet || inHunllef) {
                onStop()
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        if (hunllef == null) {
            return
        }
        hunllef!!.decrementTicksUntilNextAttack()
        if (missile != null && missile!!.projectile.remainingCycles <= 0) {
            missile = null
        }
        if (!tornadoes.isEmpty()) {
            tornadoes.forEach(Consumer { obj: Tornado -> obj.updateTimeLeft() })
        }
        if (config.autoPray() && hunllef != null && inHunllef && !client
                .isPrayerActive(hunllef!!.attackPhase.prayer)
        ) {
            activatePrayer(hunllef!!.attackPhase.prayer)
        }
        if (inHunllef && hunllef!!.npc.composition?.getOverheadIcon() == HeadIcon.MAGIC && isItemEquipped(MAGE_WEAPONS)) {
            if (Items.inventoryContainsAny(RANGE_WEAPONS)) {
                rangeWeapon()
            } else if (Items.inventoryContainsAny(MELEE_WEAPONS)) {
                meleeWeapon()
            }
        }
        if (inHunllef && hunllef!!.npc.composition?.getOverheadIcon() == HeadIcon.MELEE && isItemEquipped(
                MELEE_WEAPONS
            )
        ) {
            if (Items.inventoryContainsAny(MAGE_WEAPONS)) {
                mageWeapon()
            } else if (Items.inventoryContainsAny(RANGE_WEAPONS)) {
                rangeWeapon()
            }
        }
        if (inHunllef && hunllef!!.npc.composition?.getOverheadIcon() == HeadIcon.RANGED && isItemEquipped(
                RANGE_WEAPONS
            )
        ) {
            if (Items.inventoryContainsAny(MELEE_WEAPONS)) {
                meleeWeapon()
            } else if (Items.inventoryContainsAny(MAGE_WEAPONS)) {
                mageWeapon()
            }
        }
        if (isItemEquipped(RANGE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
            activatePrayer(config.rangeoffensivePrayer().prayer)
        }
        if (isItemEquipped(MAGE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
            activatePrayer(config.magicoffensivePrayer().prayer)
        }
        if (isItemEquipped(MELEE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
            activatePrayer(config.meleeoffensivePrayer().prayer)
        }
        val currentPrayerPoints = client.getBoostedSkillLevel(Skill.PRAYER)
        val nextRestoreVal = 10
        if (config.potionToggle() && currentPrayerPoints <= nextRestoreVal) {
            drinkPotion()
        }
        val currentHitpoints = client.getBoostedSkillLevel(Skill.HITPOINTS)
        val nextTickHeal = 20
        if (config.autoTickEatToggle() && currentHitpoints <= nextTickHeal) {
            autoEat()
            autoTickEat()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.LOADING -> {
                resources.clear()
                utilities.clear()
            }
            GameState.LOGIN_SCREEN, GameState.HOPPING -> onStop()
            else -> {return }
        }
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.GAUNTLET_TIMER_GROUP_ID) {
            overlayTimer.setGauntletStart()
            resourceManager.init()
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject = it.gameObject
        val id = gameObject.id
        if (RESOURCE_IDS.contains(id)) {
            resources.add(Resource(gameObject, skillIconManager, config.resourceIconSize()))
        } else if (UTILITY_IDS.contains(id)) {
            utilities.add(gameObject)
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        val gameObject = it.gameObject
        val id = gameObject.id
        if (RESOURCE_IDS.contains(gameObject.id)) {
            resources.removeIf { o: Resource -> o.gameObject === gameObject }
        } else if (UTILITY_IDS.contains(id)) {
            utilities.remove(gameObject)
        }
    }

    override fun onNpcSpawned(it: NpcSpawned) {
        val npc = it.npc
        val id = npc.id
        if (HUNLLEF_IDS.contains(id)) {
            hunllef = Hunllef(npc, skillIconManager, config.hunllefAttackStyleIconSize(), this)
        } else if (TORNADO_IDS.contains(id)) {
            tornadoes.add(Tornado(npc))
        } else if (DEMIBOSS_IDS.contains(id)) {
            demibosses.add(Demiboss(npc))
        } else if (STRONG_NPC_IDS.contains(id)) {
            strongNpcs.add(npc)
        } else if (WEAK_NPC_IDS.contains(id)) {
            weakNpcs.add(npc)
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        val npc = it.npc
        val id = npc.id
        if (HUNLLEF_IDS.contains(id)) {
            hunllef = null
        } else if (TORNADO_IDS.contains(id)) {
            tornadoes.removeIf { t: Tornado -> t.npc === npc }
        } else if (DEMIBOSS_IDS.contains(id)) {
            demibosses.removeIf { d: Demiboss -> d.npc === npc }
        } else if (STRONG_NPC_IDS.contains(id)) {
            strongNpcs.remove(npc)
        } else if (WEAK_NPC_IDS.contains(id)) {
            weakNpcs.remove(npc)
        }
    }

    override fun onProjectileSpawned(it: ProjectileSpawned) {
        if (hunllef == null) {
            return
        }
        val projectile = it.projectile
        val id = projectile.id
        if (!PROJECTILE_IDS.contains(id)) {
            return
        }
        missile = Missile(projectile, skillIconManager, config.projectileIconSize())
        hunllef!!.updateAttackCount()
        if (PROJECTILE_PRAYER_IDS.contains(id) && config.hunllefPrayerAudio()) {
            client.playSoundEffect(SoundEffectID.MAGIC_SPLASH_BOING)
        }
    }

    override fun onChatMessage(it: ChatMessage) {
        val type = it.type
        if (type == ChatMessageType.SPAM || type == ChatMessageType.GAMEMESSAGE) {
            resourceManager.parseChatMessage(it.message)
        }
    }

    override fun onActorDeath(it: ActorDeath) {
        if (it.actor !== client.localPlayer) {
            return
        }
        overlayTimer.onPlayerDeath()
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        if (!isHunllefVarbitSet || hunllef == null) {
            return
        }
        val actor = it.actor
        val animationId = actor.animation
        if (actor is Player) {
            if (!ATTACK_ANIM_IDS.contains(animationId)) {
                return
            }
            val validAttack = isAttackAnimationValid(animationId)
            if (validAttack) {
                wrongAttackStyle = false
                hunllef!!.updatePlayerAttackCount()
                if (hunllef!!.playerAttackCount == 1) {
                    switchWeapon = true
                }
            } else {
                wrongAttackStyle = true
            }
        } else if (actor is NPC) {
            if (animationId == HUNLEFF_TORNADO) {
                hunllef!!.updateAttackCount()
            }
        }
    }

    private fun isAttackAnimationValid(animationId: Int): Boolean {
        val headIcon = hunllef!!.npc.composition?.getOverheadIcon() ?: return true
        when (headIcon) {
            HeadIcon.MELEE -> if (MELEE_ANIM_IDS.contains(animationId)) {
                return false
            }
            HeadIcon.RANGED -> if (animationId == BOW_ATTACK_ANIMATION) {
                return false
            }
            HeadIcon.MAGIC -> if (animationId == HIGH_LEVEL_MAGIC_ATTACK) {
                return false
            }
            else -> {return true}
        }
        return true
    }

    private fun pluginEnabled() {
        if (isGauntletVarbitSet) {
            overlayTimer.setGauntletStart()
            resourceManager.init()
            addSpawnedEntities()
            initGauntlet()
        }
        if (isHunllefVarbitSet) {
            initHunllef()
        }
    }

    private fun addSpawnedEntities() {
        for (gameObject in GameObjectQuery().result(client)) {
            val gameObjectSpawned = GameObjectSpawned(null, gameObject)
            onGameObjectSpawned(gameObjectSpawned)
        }
        for (npc in client.npcs) {
            onNpcSpawned(NpcSpawned(npc))
        }
    }

    private fun initGauntlet() {
        inGauntlet = true
        overlayManager.add(overlayTimer)
        overlayManager.add(overlayGauntlet)
    }

    private fun initHunllef() {
        inHunllef = true
        overlayTimer.setHunllefStart()
        resourceManager.reset()
        overlayManager.remove(overlayGauntlet)
        overlayManager.add(overlayHunllef)
        overlayManager.add(overlayPrayerWidget)
        overlayManager.add(overlayPrayerBox)
    }

    fun activatePrayer(prayer: Prayer?) {
        if (prayer == null) {
            return
        }

        //check if prayer is already active this tick
        if (client.isPrayerActive(prayer)) {
            return
        }
        val widgetInfo = prayer.widgetInfo ?: return
        val prayer_widget = client.getWidget(widgetInfo) ?: return
        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return
        }
        clientThread.invoke {
            client.invokeMenuAction(
                "Activate",
                prayer_widget.name,
                1,
                MenuAction.CC_OP.id,
                prayer_widget.itemId,
                prayer_widget.id
            )
        }
    }

    fun meleeWeapon() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        for (mw in MELEE_WEAPONS) {
            val mi = getFirst(InventoryID.INVENTORY, mw)
            mi?.interact("Wield")
        }
    }

    fun rangeWeapon() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        for (rw in RANGE_WEAPONS) {
            val ri = getFirst(InventoryID.INVENTORY, rw)
            ri?.interact("Wield")
        }
    }

    fun mageWeapon() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        for (mw in MAGE_WEAPONS) {
            val mi = getFirst(InventoryID.INVENTORY, mw)
            mi?.interact("Wield")
        }
    }

    fun drinkPotion() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        for (potion in POTIONS) {
            val item = getFirst(InventoryID.INVENTORY, potion)
            item?.interact("Drink")
        }
    }

    fun autoEat() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        val item = getFirst(InventoryID.INVENTORY, ItemID.PADDLEFISH)
        item?.interact("Eat")
    }

    fun autoTickEat() {
        val inventory = client.getWidget(WidgetInfo.INVENTORY) ?: return
        for (food in TICK_FOOD) {
            val item = getFirst(InventoryID.INVENTORY, food)
            item?.interact("Eat")
        }
    }

    fun isItemEquipped(itemIds: Collection<Int>): Boolean {
        assert(client.isClientThread)
        val equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT)
        if (equipmentContainer != null) {
            val items = equipmentContainer.items
            for (item in items) {
                if (item == null) continue
                if (itemIds.contains(item.id)) {
                    return true
                }
            }
        }
        return false
    }

    private val isGauntletVarbitSet: Boolean
        private get() = client.getVarbitValue(9178) == 1
    private val isHunllefVarbitSet: Boolean
        private get() = client.getVarbitValue(9177) == 1

    companion object {
        const val ONEHAND_SLASH_AXE_ANIMATION = 395
        const val ONEHAND_CRUSH_PICKAXE_ANIMATION = 400
        const val ONEHAND_CRUSH_AXE_ANIMATION = 401
        const val UNARMED_PUNCH_ANIMATION = 422
        const val UNARMED_KICK_ANIMATION = 423
        const val BOW_ATTACK_ANIMATION = 426
        const val ONEHAND_STAB_HALBERD_ANIMATION = 428
        const val ONEHAND_SLASH_HALBERD_ANIMATION = 440
        const val ONEHAND_SLASH_SWORD_ANIMATION = 390
        const val ONEHAND_STAB_SWORD_ANIMATION = 386
        const val HIGH_LEVEL_MAGIC_ATTACK = 1167
        const val HUNLEFF_TORNADO = 8418
        private val MELEE_ANIM_IDS = List.of(
            ONEHAND_STAB_SWORD_ANIMATION, ONEHAND_SLASH_SWORD_ANIMATION,
            ONEHAND_SLASH_AXE_ANIMATION, ONEHAND_CRUSH_PICKAXE_ANIMATION,
            ONEHAND_CRUSH_AXE_ANIMATION, UNARMED_PUNCH_ANIMATION,
            UNARMED_KICK_ANIMATION, ONEHAND_STAB_HALBERD_ANIMATION,
            ONEHAND_SLASH_HALBERD_ANIMATION
        )
        private val MELEE_WEAPONS = mutableListOf(
            ItemID.CORRUPTED_HALBERD_BASIC, ItemID.CORRUPTED_HALBERD_ATTUNED,
            ItemID.CORRUPTED_HALBERD_PERFECTED, ItemID.CRYSTAL_HALBERD_BASIC, ItemID.CRYSTAL_HALBERD_ATTUNED,
            ItemID.CRYSTAL_HALBERD_PERFECTED
        )
        private val RANGE_WEAPONS = mutableListOf(
            ItemID.CORRUPTED_BOW_BASIC, ItemID.CORRUPTED_BOW_ATTUNED,
            ItemID.CORRUPTED_BOW_PERFECTED, ItemID.CRYSTAL_BOW_BASIC, ItemID.CRYSTAL_BOW_ATTUNED,
            ItemID.CRYSTAL_BOW_PERFECTED
        )
        private val MAGE_WEAPONS = mutableListOf(
            ItemID.CORRUPTED_STAFF_BASIC, ItemID.CORRUPTED_STAFF_ATTUNED,
            ItemID.CORRUPTED_STAFF_PERFECTED, ItemID.CRYSTAL_STAFF_BASIC,
            ItemID.CRYSTAL_BOW_ATTUNED, ItemID.CRYSTAL_BOW_PERFECTED
        )
        private val POTIONS = List.of(
            ItemID.EGNIOL_POTION_1, ItemID.EGNIOL_POTION_2, ItemID.EGNIOL_POTION_3, ItemID.EGNIOL_POTION_4
        )
        private val FOOD = java.util.Set.of(
            ItemID.PADDLEFISH
        )
        private val TICK_FOOD = List.of(
            ItemID.CRYSTAL_PADDLEFISH, ItemID.CORRUPTED_PADDLEFISH
        )
        private val ATTACK_ANIM_IDS: MutableSet<Int> = HashSet()

        init {
            ATTACK_ANIM_IDS.addAll(MELEE_ANIM_IDS)
            ATTACK_ANIM_IDS.add(BOW_ATTACK_ANIMATION)
            ATTACK_ANIM_IDS.add(HIGH_LEVEL_MAGIC_ATTACK)
        }

        private val PROJECTILE_MAGIC_IDS = java.util.Set.of(
            ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK
        )
        private val PROJECTILE_RANGE_IDS = java.util.Set.of(
            ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK
        )
        private val PROJECTILE_PRAYER_IDS = java.util.Set.of(
            ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK
        )
        private val PROJECTILE_IDS: MutableSet<Int> = HashSet()

        init {
            PROJECTILE_IDS.addAll(PROJECTILE_MAGIC_IDS)
            PROJECTILE_IDS.addAll(PROJECTILE_RANGE_IDS)
            PROJECTILE_IDS.addAll(PROJECTILE_PRAYER_IDS)
        }

        private val HUNLLEF_IDS = java.util.Set.of(
            NpcID.CRYSTALLINE_HUNLLEF, NpcID.CRYSTALLINE_HUNLLEF_9022,
            NpcID.CRYSTALLINE_HUNLLEF_9023, NpcID.CRYSTALLINE_HUNLLEF_9024,
            NpcID.CORRUPTED_HUNLLEF, NpcID.CORRUPTED_HUNLLEF_9036,
            NpcID.CORRUPTED_HUNLLEF_9037, NpcID.CORRUPTED_HUNLLEF_9038
        )
        private val TORNADO_IDS = java.util.Set.of(NullNpcID.NULL_9025, NullNpcID.NULL_9039)
        private val DEMIBOSS_IDS = java.util.Set.of(
            NpcID.CRYSTALLINE_BEAR, NpcID.CORRUPTED_BEAR,
            NpcID.CRYSTALLINE_DARK_BEAST, NpcID.CORRUPTED_DARK_BEAST,
            NpcID.CRYSTALLINE_DRAGON, NpcID.CORRUPTED_DRAGON
        )
        private val STRONG_NPC_IDS = java.util.Set.of(
            NpcID.CRYSTALLINE_SCORPION, NpcID.CORRUPTED_SCORPION,
            NpcID.CRYSTALLINE_UNICORN, NpcID.CORRUPTED_UNICORN,
            NpcID.CRYSTALLINE_WOLF, NpcID.CORRUPTED_WOLF
        )
        private val WEAK_NPC_IDS = java.util.Set.of(
            NpcID.CRYSTALLINE_BAT, NpcID.CORRUPTED_BAT,
            NpcID.CRYSTALLINE_RAT, NpcID.CORRUPTED_RAT,
            NpcID.CRYSTALLINE_SPIDER, NpcID.CORRUPTED_SPIDER
        )
        private val RESOURCE_IDS = java.util.Set.of(
            ObjectID.CRYSTAL_DEPOSIT, ObjectID.CORRUPT_DEPOSIT,
            ObjectID.PHREN_ROOTS, ObjectID.PHREN_ROOTS_36066,
            ObjectID.FISHING_SPOT_36068, ObjectID.FISHING_SPOT_35971,
            ObjectID.GRYM_ROOT, ObjectID.GRYM_ROOT_36070,
            ObjectID.LINUM_TIRINUM, ObjectID.LINUM_TIRINUM_36072
        )
        private val UTILITY_IDS = java.util.Set.of(
            ObjectID.SINGING_BOWL_35966, ObjectID.SINGING_BOWL_36063,
            ObjectID.RANGE_35980, ObjectID.RANGE_36077,
            ObjectID.WATER_PUMP_35981, ObjectID.WATER_PUMP_36078
        )
    }
    private val eat: HotkeyListener =
        object : HotkeyListener({ config.eat() }) {
            override fun hotkeyPressed() {
                Items.getFirst(ItemID.PADDLEFISH,ItemID.CRYSTAL_PADDLEFISH, ItemID.CORRUPTED_PADDLEFISH)?.eat()
            }
        }
    private val drink: HotkeyListener =
        object : HotkeyListener({ config.drink() }) {
            override fun hotkeyPressed() {
                Items.getFirst(
                    ItemID.EGNIOL_POTION_1,
                    ItemID.EGNIOL_POTION_2,
                    ItemID.EGNIOL_POTION_3,
                    ItemID.EGNIOL_POTION_4
                )?.drink()
            }
        }

}