import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class173 extends DualNode {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	static EvictingDualNodeHashTable field1440;

	static {
		field1440 = new EvictingDualNodeHashTable(64);
	}
}