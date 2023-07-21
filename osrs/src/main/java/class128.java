import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public enum class128 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	field1217(0, 0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	field1218(1, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	field1215(2, 2),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	field1214(3, 3),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Leu;"
	)
	field1216(4, 4);

	@ObfuscatedName("aj")
	final int field1220;
	@ObfuscatedName("ag")
	final int field1219;

	class128(int var3, int var4) {
		this.field1220 = var3;
		this.field1219 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1219;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)I",
		garbageValue = "-25"
	)
	static final int method706(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}
}
