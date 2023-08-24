import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("um")
public enum FillMode implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	field4230(1, 1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	field4231(2, 2);

	@ObfuscatedName("at")
	public final int field4233;
	@ObfuscatedName("ac")
	final int field4232;

	FillMode(int var3, int var4) {
		this.field4233 = var3;
		this.field4232 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4232;
	}
}