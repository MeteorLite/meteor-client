import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ru")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("ac")
	@Export("compass")
	public int compass;
	@ObfuscatedName("al")
	public int field3881;
	@ObfuscatedName("ak")
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("ax")
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("ao")
	public int field3883;
	@ObfuscatedName("ah")
	public int field3879;
	@ObfuscatedName("ar")
	public int field3884;
	@ObfuscatedName("ab")
	public int field3876;
	@ObfuscatedName("am")
	public int field3882;
	@ObfuscatedName("av")
	public int field3885;
	@ObfuscatedName("ag")
	public int field3878;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3881 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3883 = -1;
		this.field3879 = -1;
		this.field3884 = -1;
		this.field3876 = -1;
		this.field3882 = -1;
		this.field3885 = -1;
		this.field3878 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;B)V",
		garbageValue = "5"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3874.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch(var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.readNullableLargeSmart();
				this.field3881 = var3.readNullableLargeSmart();
				this.mapScenes = var3.readNullableLargeSmart();
				this.headIconsPk = var3.readNullableLargeSmart();
				this.field3883 = var3.readNullableLargeSmart();
				this.field3879 = var3.readNullableLargeSmart();
				this.field3884 = var3.readNullableLargeSmart();
				this.field3876 = var3.readNullableLargeSmart();
				this.field3882 = var3.readNullableLargeSmart();
				this.field3885 = var3.readNullableLargeSmart();
				this.field3878 = var3.readNullableLargeSmart();
			}
		}
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "1779911274"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (class91.clientPreferences.getCurrentSoundEffectsVolume() != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}
}