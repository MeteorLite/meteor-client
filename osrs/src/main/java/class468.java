import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sz")
public enum class468 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lsz;"
	)
	field3924(0, 1),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lsz;"
	)
	field3926(2, 2),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lsz;"
	)
	field3925(3, 3),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lsz;"
	)
	field3927(1, 10);

	@ObfuscatedName("ao")
	final int field3929;
	@ObfuscatedName("ah")
	final int field3928;

	class468(int var3, int var4) {
		this.field3929 = var3;
		this.field3928 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3928;
	}
}