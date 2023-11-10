import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public class class430 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lqr;"
	)
	static final class430 field3795;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lqr;"
	)
	static final class430 field3794;
	@ObfuscatedName("ar")
	final String field3796;

	static {
		field3795 = new class430("Basic");
		field3794 = new class430("Bearer");
	}

	class430(String var1) {
		this.field3796 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1414159306"
	)
	String method2179() {
		return this.field3796;
	}
}