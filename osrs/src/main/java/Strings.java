import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nz")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("fg")
	public static String field3291;
	@ObfuscatedName("kl")
	public static String field3412;
	@ObfuscatedName("ks")
	public static String field3419;
	@ObfuscatedName("kj")
	public static String field3410;

	static {
		field3291 = "Please visit the support page for assistance.";
		field3412 = "";
		field3419 = "Page has opened in the browser.";
		field3410 = "";
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "189737600"
	)
	static final float method1841(int var0) {
		float var1 = 10075.0F - (float)var0;
		return (1.0075567F * var1 - 75.56675F) / var1;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-2120353581"
	)
	static int method1842(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}
}
