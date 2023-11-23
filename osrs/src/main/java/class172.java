import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class172 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("e3")
	static EvictingDualNodeHashTable e3;

	static {
		e3 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1030508482"
	)
	public static void method883() {
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
	}
}