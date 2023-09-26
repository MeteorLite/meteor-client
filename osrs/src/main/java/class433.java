import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qf")
public class class433 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	static final class433 field3790;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	static final class433 field3791;
	@ObfuscatedName("lw")
	static int field3789;
	@ObfuscatedName("ak")
	final String field3792;

	static {
		field3790 = new class433("Basic");
		field3791 = new class433("Bearer");
	}

	class433(String var1) {
		this.field3792 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "36"
	)
	String method2195() {
		return this.field3792;
	}
}