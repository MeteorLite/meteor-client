import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qn")
public class class418 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lqn;"
	)
	static final class418 field3759;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lqn;"
	)
	static final class418 field3758;
	@ObfuscatedName("ao")
	final String field3760;

	static {
		field3759 = new class418("Basic");
		field3758 = new class418("Bearer");
	}

	class418(String var1) {
		this.field3760 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "75"
	)
	String method2162() {
		return this.field3760;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lrq;",
		garbageValue = "-2125486223"
	)
	static class453[] method2163() {
		return new class453[]{class453.field3896, class453.field3893, class453.field3894, class453.field3895};
	}
}