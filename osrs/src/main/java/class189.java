import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class189 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	static EvictingDualNodeHashTable field1494;
	@ObfuscatedName("ao")
	public static int field1493;

	static {
		field1494 = new EvictingDualNodeHashTable(64);
	}
}