import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("cg")
public class class53 extends Node {
	@ObfuscatedName("cy")
	static int field256;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lbx;"
	)
	class47 field257;

	public class53() {
		this.field257 = null;
	}

	@ObfuscatedSignature(
		descriptor = "(Lcv;)V"
	)
	class53(VorbisSample var1) {
		if (var1 != null) {
			this.field257 = new class47(var1, (RawSound)null);
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Lbt;)V"
	)
	public class53(RawSound var1) {
		this.field257 = new class47((VorbisSample)null, var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-925391311"
	)
	public boolean method303() {
		return this.field257 == null;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Lbt;",
		garbageValue = "1961444927"
	)
	public RawSound method304() {
		if (this.field257 != null && this.field257.field226.tryLock()) {
			RawSound var1;
			try {
				var1 = this.method306();
			} finally {
				this.field257.field226.unlock();
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Lbt;",
		garbageValue = "-96589694"
	)
	public RawSound method305() {
		if (this.field257 != null) {
			this.field257.field226.lock();

			RawSound var1;
			try {
				var1 = this.method306();
			} finally {
				this.field257.field226.unlock();
			}

			return var1;
		} else {
			return null;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Lbt;",
		garbageValue = "-1970113950"
	)
	RawSound method306() {
		if (this.field257.field224 == null) {
			this.field257.field224 = this.field257.field225.toRawSound((int[])null);
			this.field257.field225 = null;
		}

		return this.field257.field224;
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1624794329"
	)
	static void method307() {
		Client.mouseLastLastPressedTimeMillis = -1L;
		Message.mouseRecorder.index = 0;
		class357.hasFocus = true;
		Client.hadFocus = true;
		Client.timeOfPreviousKeyPress = -1L;
		class36.reflectionChecks = new IterableNodeDeque();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1167 = null;
		Client.packetWriter.field1168 = null;
		Client.packetWriter.field1166 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1164 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		class160.method840();
		WorldMapEvent.method1382(0);
		LoginScreenAnimation.method523();
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		MidiPcmStream.field2799 = null;
		Client.minimapState = 0;
		Client.field535 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		Players.Players_count = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Players.cachedAppearanceBuffer[var0] = null;
			Players.playerMovementSpeeds[var0] = MoveSpeed.WALK;
		}

		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		for (var0 = 0; var0 < 65536; ++var0) {
			Client.npcs[var0] = null;
		}

		Client.combatTargetPlayerIndex = -1;
		Client.projectiles.clear();
		Client.graphicsObjects.clear();

		for (var0 = 0; var0 < 4; ++var0) {
			for (int var1 = 0; var1 < 104; ++var1) {
				for (int var2 = 0; var2 < 104; ++var2) {
					Client.groundItems[var0][var1][var2] = null;
				}
			}
		}

		Client.pendingSpawns = new NodeDeque();
		class12.friendSystem.clear();
		if (VarpDefinition.field1443 > 5000) {
		}

		for (var0 = 0; var0 < VarpDefinition.field1443; ++var0) {
			VarpDefinition var3 = FloorOverlayDefinition.VarpDefinition_get(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		class176.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			HealthBarDefinition.widgetDefinition.method1736(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			class302.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		class160.method840();
		Client.playerAppearance.method1746((int[])null, (int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		class59.method332();
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field407[var0] = true;
		}

		if (Client.packetWriter != null && Client.packetWriter.isaacCipher != null) {
			PacketBufferNode var5 = class113.getPacketBufferNode(ClientPacket.EVENT_MOUSE_IDLE, Client.packetWriter.isaacCipher);
			var5.packetBuffer.writeByte(ApproximateRouteStrategy.getWindowedMode());
			var5.packetBuffer.writeShort(Language.canvasWidth);
			var5.packetBuffer.writeShort(class47.canvasHeight);
			Client.packetWriter.addNode(var5);
		}

		class20.friendsChat = null;
		class478.guestClanSettings = null;
		Arrays.fill(Client.currentClanSettings, (Object)null);
		ItemContainer.guestClanChannel = null;
		Arrays.fill(Client.currentClanChannels, (Object)null);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		class6.grandExchangeEvents = null;
		Client.reloadJS5 = false;
	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "50042051"
	)
	static void method308() {
		if (Client.isSpellSelected) {
			Widget var0 = HealthBarDefinition.widgetDefinition.getWidgetChild(class348.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				class157.runScriptEvent(var1);
			}

			Client.selectedSpellItemId = -1;
			Client.isSpellSelected = false;
			class159.invalidateWidget(var0);
		}
	}
}