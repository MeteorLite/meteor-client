import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public enum class6 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lag;"
	)
	field6(0, 0);

	@ObfuscatedName("ay")
	final int field8;
	@ObfuscatedName("ar")
	final int field7;

	class6(int var3, int var4) {
		this.field8 = var3;
		this.field7 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field7;
	}

	@ObfuscatedName("as")
	public static int method12(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}
}
