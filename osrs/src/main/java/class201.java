import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class201 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	static EvictingDualNodeHashTable field1580;
	@ObfuscatedName("jp")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;

	static {
		field1580 = new EvictingDualNodeHashTable(64);
	}
}