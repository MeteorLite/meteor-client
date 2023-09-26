import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("st")
public class class475 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lst;"
	)
	public static final class475 field3933;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lst;"
	)
	static final class475 field3934;
	@ObfuscatedName("ak")
	String field3935;

	static {
		field3933 = new class475("application/json");
		field3934 = new class475("text/plain");
	}

	class475(String var1) {
		this.field3935 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "733315880"
	)
	public String method2373() {
		return this.field3935;
	}
}