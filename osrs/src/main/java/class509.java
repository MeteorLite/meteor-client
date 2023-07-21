import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tq")
public class class509 {
	@ObfuscatedName("ar")
	static final int field4110;
	@ObfuscatedName("am")
	static final int field4109;

	static {
		field4110 = (int)(Math.pow(2.0D, 4.0D) - 1.0D);
		field4109 = (int)(Math.pow(2.0D, 8.0D) - 1.0D);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IZB)Ljava/lang/String;",
		garbageValue = "113"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? class327.method1676(var0, 10, var1) : Integer.toString(var0);
	}
}
