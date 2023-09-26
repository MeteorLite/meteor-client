import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("uf")
public enum class541 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Luf;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Luf;"
	)
	field4258(1, 1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Luf;"
	)
	field4257(2, 2);

	@ObfuscatedName("ax")
	public final int field4260;
	@ObfuscatedName("ao")
	final int field4259;

	class541(int var3, int var4) {
		this.field4260 = var3;
		this.field4259 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4259;
	}
}