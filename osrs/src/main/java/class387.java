import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("op")
public final class class387 {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	public static AbstractArchive field3643;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Lcr;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("ah")
	static int field3645;
	@ObfuscatedName("js")
	static int field3646;

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)I",
		garbageValue = "19345"
	)
	public static int method1985(String var0) {
		return var0.length() + 2;
	}
}
