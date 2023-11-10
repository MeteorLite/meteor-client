import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nr")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("fa")
	public static String field3326;
	@ObfuscatedName("ka")
	public static String field3442;
	@ObfuscatedName("kb")
	public static String field3443;
	@ObfuscatedName("ky")
	public static String field3465;

	static {
		field3326 = "Please visit the support page for assistance.";
		field3442 = "";
		field3443 = "Page has opened in the browser.";
		field3465 = "";
	}

	@ObfuscatedName("mk")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-80"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}