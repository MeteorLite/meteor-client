import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rq")
public enum class453 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lrq;"
	)
	field3896(0, 1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lrq;"
	)
	field3893(2, 2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lrq;"
	)
	field3894(3, 3),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lrq;"
	)
	field3895(1, 10);

	@ObfuscatedName("ac")
	final int field3897;
	@ObfuscatedName("ai")
	final int field3898;

	class453(int var3, int var4) {
		this.field3897 = var3;
		this.field3898 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3898;
	}
}