import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nw")
public class class379 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	public static final class379 field4437;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	static final class379 field4433;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 568981163
	)
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1688777027
	)
	final int field4434;

	static {
		field4437 = new class379(0);
		field4433 = new class379(1);
	}

	class379(int var1) {
		this.field4434 = var1;
	}
}
