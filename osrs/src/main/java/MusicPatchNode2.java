import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("mx")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("da")
	static boolean field2778;
	@ObfuscatedName("ac")
	byte[] field2779;
	@ObfuscatedName("al")
	byte[] field2780;
	@ObfuscatedName("ak")
	int field2783;
	@ObfuscatedName("ax")
	int field2787;
	@ObfuscatedName("ao")
	int field2785;
	@ObfuscatedName("ah")
	int field2782;
	@ObfuscatedName("ar")
	int field2786;
	@ObfuscatedName("ab")
	int field2781;
	@ObfuscatedName("am")
	int field2784;

	MusicPatchNode2() {
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "15"
	)
	static void method1657(boolean var0) {
		byte var1 = 0;
		boolean var2 = class91.clientPreferences.method560() >= Client.param21;
		if (!var2) {
			var1 = 12;
		} else if (class159.client.method357() || class159.client.method359() || class159.client.method358()) {
			var1 = 10;
		}

		GameEngine.method166(var1);
		if (var0) {
			Login.Login_username = "";
			Login.Login_password = "";
			ClientPreferences.field1059 = 0;
			class186.otp = "";
		}

		class188.method955();
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	static void method1658() {
		Client.mouseLastLastPressedTimeMillis = -1L;
		class233.mouseRecorder.index = 0;
		KeyHandler.hasFocus = true;
		Client.hadFocus = true;
		Client.timeOfPreviousKeyPress = -1L;
		class36.reflectionChecks = new IterableNodeDeque();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1153 = null;
		Client.packetWriter.field1154 = null;
		Client.packetWriter.field1156 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1152 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		class91.method483();
		class138.method733(0);
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		WallDecoration.field2303 = null;
		Client.minimapState = 0;
		Client.field539 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		class11.method39();

		int var0;
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
		InvDefinition.friendSystem.clear();
		if (VarpDefinition.field1501 > 5000) {
		}

		for (var0 = 0; var0 < VarpDefinition.field1501; ++var0) {
			VarpDefinition var3 = class150.VarpDefinition_get(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		class33.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			class33.field89.method1743(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			ArchiveDisk.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		class91.method483();
		Client.playerAppearance.method1750((int[])null, (int[])null, new int[]{0, 0, 0, 0, 0}, 0, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		Tile.method1231();
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field408[var0] = true;
		}

		class517.method2533();
		class358.friendsChat = null;
		VerticalAlignment.guestClanSettings = null;
		Arrays.fill(Client.currentClanSettings, (Object)null);
		ClanChannelMember.guestClanChannel = null;
		Arrays.fill(Client.currentClanChannels, (Object)null);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		Varps.grandExchangeEvents = null;
		Client.reloadJS5 = false;
	}
}