import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ps")
public final class class390 {
	@ObfuscatedName("wq")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	public static class369 field3656;
	@ObfuscatedName("au")
	final Object field3658;
	@ObfuscatedName("ae")
	int field3657;

	class390(Object var1, int var2) {
		this.field3658 = var1;
		this.field3657 = var2;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lmi;I)I",
		garbageValue = "-490718469"
	)
	static int method2030(Widget var0) {
		if (var0.type != 11) {
			Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize - 1] = "";
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
			Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var0.method1836(var1);
			return 1;
		}
	}
}