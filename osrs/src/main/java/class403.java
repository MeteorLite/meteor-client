import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
public final class class403 {
	@ObfuscatedName("ac")
	@Export("base37Table")
	static final char[] base37Table;
	@ObfuscatedName("al")
	static long[] field3688;
	@ObfuscatedName("ak")
	@Export("KitDefinition_fileCount")
	public static int KitDefinition_fileCount;

	static {
		base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		field3688 = new long[12];

		for (int var0 = 0; var0 < field3688.length; ++var0) {
			field3688[var0] = (long)Math.pow(37.0D, (double)var0);
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lbw;I)V",
		garbageValue = "-1869845736"
	)
	public static final void method2054(class51 var0) {
		class16.pcmPlayerProvider = var0;
	}
}