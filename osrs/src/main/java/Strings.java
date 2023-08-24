import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nr")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("fs")
	public static String field3315;
	@ObfuscatedName("kl")
	public static String field3423;
	@ObfuscatedName("kk")
	public static String field3422;
	@ObfuscatedName("kc")
	public static String field3414;

	static {
		field3315 = "Please visit the support page for assistance.";
		field3423 = "";
		field3422 = "Page has opened in the browser.";
		field3414 = "";
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "64"
	)
	static final void method1877(String var0) {
		UserComparator8.method673(var0 + " is already on your friend list");
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "-116"
	)
	static final int method1878(int var0, int var1) {
		int var2 = var1 * 57 + var0;
		var2 ^= var2 << 13;
		int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}
}