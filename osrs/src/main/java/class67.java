import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class67 {
	@ObfuscatedName("c")
	static final BigInteger field884;
	@ObfuscatedName("p")
	static final BigInteger field885;
	@ObfuscatedName("ar")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("lq")
	@ObfuscatedSignature(
		descriptor = "Lcl;"
	)
	@Export("localPlayer")
	static Player localPlayer;

	static {
		field884 = new BigInteger("10001", 16);
		field885 = new BigInteger("a1c1ffb9e16606719eadaf20165984b079df035cc5af0dac8ed5651fb42882d28ccb204d8f7255cea576ee40aa26822536f0e7fa9bdc61ce668dbece134dd38d7230e4e81a23acda970e97fd2314d1b1c5234064a7284a218ee2dbf533eee6d84ca2c6b1824926f0b45336f706a9ba37e7eb8c7ff1415f312df4ece61d29cb4d", 16);
	}

	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "2"
	)
	static final void method2033() {
		if (Client.logoutTimer > 0) {
			ApproximateRouteStrategy.logOut();
		} else {
			Client.timer.method6707();
			Coord.updateGameState(40);
			RouteStrategy.field2237 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "-111"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Player.clientPreferences.method2385() != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		descriptor = "(Lcl;ZB)V",
		garbageValue = "0"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.idleSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = class259.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = class120.getTileHeight(var0.x, var0.y, Tiles.Client_plane);
					var0.playerCycle = Client.cycle;
					MusicPatchNode.scene.addNullableObject(Tiles.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.minX, var0.minY, var0.maxX, var0.maxY);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = class120.getTileHeight(var0.x, var0.y, Tiles.Client_plane);
					var0.playerCycle = Client.cycle;
					MusicPatchNode.scene.drawEntity(Tiles.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		descriptor = "(Lkw;B)Ljava/lang/String;",
		garbageValue = "-54"
	)
	@Export("Widget_getSpellActionName")
	static String Widget_getSpellActionName(Widget var0) {
		if (SoundCache.Widget_unpackTargetMask(class97.getWidgetFlags(var0)) == 0) {
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
		}
	}
}
