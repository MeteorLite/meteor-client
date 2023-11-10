import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public class class310 {
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("fo")
	static long field2769;

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)I",
		garbageValue = "1270605570"
	)
	static int method1645(Widget var0) {
		if (var0.type != 11) {
			--class127.Interpreter_stringStackSize;
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var0.method1862(var1);
			return 1;
		}
	}
}