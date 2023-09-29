import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("me")
public class class330 implements Comparator {
	class330() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lmu;Lmu;B)I",
		garbageValue = "1"
	)
	int method1728(class323 var1, class323 var2) {
		return var1.field2844 - var2.field2844;
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method1728((class323)var1, (class323)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "-1"
	)
	static int method1729(int var0, Script var1, boolean var2) {
		if (var0 == 6754) {
			int var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			NPCComposition var4 = class190.getNpcDefinition(var3);
			Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
			return 1;
		} else {
			NPCComposition var5;
			if (var0 == 6764) {
				Interpreter.Interpreter_intStackSize -= 2;
				var5 = class190.getNpcDefinition(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
				int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method1020(var6);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method1022(var6);
				return 1;
			} else if (var0 == 6765) {
				var5 = class190.getNpcDefinition(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel * -1524379573 * 1597602147 : 0;
				return 1;
			} else {
				return 2;
			}
		}
	}

	@ObfuscatedName("od")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1170534602"
	)
	static void method1730(boolean var0) {
		Client.leftClickOpensMenu = var0;
	}
}