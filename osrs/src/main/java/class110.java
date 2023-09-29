import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class110 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1123;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1128;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1127;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1135;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1130;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1125;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1132;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1122;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1129;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1134;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1124;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1121;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1131;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1136;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1133;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lex;"
	)
	static final class110 field1126;
	@ObfuscatedName("an")
	int field1137;

	static {
		field1123 = new class110(0);
		field1128 = new class110(1);
		field1127 = new class110(2);
		field1135 = new class110(3);
		field1130 = new class110(4);
		field1125 = new class110(5);
		field1132 = new class110(6);
		field1122 = new class110(7);
		field1129 = new class110(8);
		field1134 = new class110(9);
		field1124 = new class110(10);
		field1121 = new class110(11);
		field1131 = new class110(12);
		field1136 = new class110(13);
		field1133 = new class110(14);
		field1126 = new class110(15);
	}

	class110(int var1) {
		this.field1137 = var1;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)I",
		garbageValue = "48072594"
	)
	static int method624(Widget var0) {
		if (var0.type != 11) {
			--class180.Interpreter_stringStackSize;
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			return 1;
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var0.method1868(var1);
			return 1;
		}
	}
}