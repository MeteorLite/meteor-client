import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
public enum class354 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	field3145(0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	field3147(1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	field3146(2),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	field3143(3),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	field3148(4);

	@ObfuscatedName("kg")
	static int field3144;
	@ObfuscatedName("ah")
	final int field3149;

	class354(int var3) {
		this.field3149 = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3149;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lud;IIII)V",
		garbageValue = "902612467"
	)
	static void method1895(SpritePixels var0, int var1, int var2, int var3) {
		DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var6 = (long)(var3 << 16 | var1 << 8 | var2);
		var4.put(var0, var6, var0.pixels.length * 4);
	}
}