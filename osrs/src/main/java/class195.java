import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class195 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("e8")
	public static EvictingDualNodeHashTable e8;
	@ObfuscatedName("ix")
	static int field1620;

	static {
		e8 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "13"
	)
	public static int method973(int var0) {
		return class476.field3937[var0 & 16383];
	}
}