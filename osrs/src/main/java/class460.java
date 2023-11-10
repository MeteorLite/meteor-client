import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rb")
public class class460 {
	@ObfuscatedName("at")
	float field3898;
	@ObfuscatedName("ah")
	float field3896;
	@ObfuscatedName("ar")
	float field3897;

	static {
		new class460(0.0F, 0.0F, 0.0F);
		new class460(1.0F, 1.0F, 1.0F);
		new class460(1.0F, 0.0F, 0.0F);
		new class460(0.0F, 1.0F, 0.0F);
		new class460(0.0F, 0.0F, 1.0F);
	}

	class460(float var1, float var2, float var3) {
		this.field3898 = var1;
		this.field3896 = var2;
		this.field3897 = var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)F",
		garbageValue = "56"
	)
	final float method2307() {
		return (float)Math.sqrt((double)(this.field3897 * this.field3897 + this.field3896 * this.field3896 + this.field3898 * this.field3898));
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3898 + ", " + this.field3896 + ", " + this.field3897;
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-986184126"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (WorldMapIcon_1.clientPreferences.getCurrentSoundEffectsVolume() != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}
}