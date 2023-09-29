import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
public class class284 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lku;"
	)
	static final class284 field2464;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lku;"
	)
	static final class284 field2465;
	@ObfuscatedName("am")
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("ak")
	final int field2466;

	static {
		field2464 = new class284(0);
		field2465 = new class284(1);
	}

	class284(int var1) {
		this.field2466 = var1;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "102"
	)
	static final void method1572() {
		class436.method2211("Your ignore list is full. Max of 100 for free users, and 400 for members");
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		descriptor = "(B)Lit;",
		garbageValue = "-33"
	)
	public static class226 method1573() {
		return Client.keyHandlerInstance;
	}
}