import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class173 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("e4")
	static EvictingDualNodeHashTable e4;

	static {
		e4 = new EvictingDualNodeHashTable(64);
	}
}