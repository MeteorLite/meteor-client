import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("at")
	public int field3832;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lvj;"
	)
	@Export("friendUsername")
	public Username friendUsername;
	@ObfuscatedName("ar")
	@Export("worldId")
	public short worldId;

	@ObfuscatedSignature(
		descriptor = "(Lvj;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3832 = (int)(SpotAnimationDefinition.method962() / 1000L);
		this.friendUsername = var1;
		this.worldId = (short)var2;
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		descriptor = "(Lhx;IIILdf;B)V",
		garbageValue = "-64"
	)
	static void method2227(SequenceDefinition var0, int var1, int var2, int var3, Actor var4) {
		if (Client.soundEffectCount < 50) {
			if (var0.animMayaFrameSounds != null && var0.animMayaFrameSounds.containsKey(var1)) {
				int var5 = (Integer)var0.animMayaFrameSounds.get(var1) & 15;
				if ((var5 <= 0 || WorldMapIcon_1.clientPreferences.getAreaSoundEffectsVolume() != 0) && (var5 != 0 || WorldMapIcon_1.clientPreferences.getCurrentSoundEffectsVolume() != 0)) {
					int var6 = (Integer)var0.animMayaFrameSounds.get(var1);
					boolean var9 = var4 == class229.localPlayer;
					if (var6 != 0) {
						int var10 = var6 & 15;
						int var11;
						int var12;
						if (var10 == 0) {
							if (!var9) {
								return;
							}

							Client.soundLocations[Client.soundEffectCount] = 0;
						} else {
							var11 = (var2 - 64) / 128;
							var12 = (var3 - 64) / 128;
							Client.soundLocations[Client.soundEffectCount] = var10 + (var12 << 8) + (var11 << 16);
						}

						var11 = var6 >> 8;
						var12 = var6 >> 4 & 7;
						Client.soundEffectIds[Client.soundEffectCount] = var11;
						Client.queuedSoundEffectLoops[Client.soundEffectCount] = var12;
						Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
						Client.soundEffects[Client.soundEffectCount] = null;
						++Client.soundEffectCount;
					}

				}
			}
		}
	}
}