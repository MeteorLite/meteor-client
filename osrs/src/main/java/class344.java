import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ng")
public class class344 {
	@ObfuscatedName("ay")
	static int[][][] field3130;
	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("th")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([BILjava/lang/CharSequence;I)I",
		garbageValue = "-1554381486"
	)
	public static int method1877(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "2094869525"
	)
	static int method1878(int var0, Script var1, boolean var2) {
		if (var0 == 6754) {
			int var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			NPCComposition var4 = VerticalAlignment.getNpcDefinition(var3);
			Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
			return 1;
		} else {
			NPCComposition var5;
			if (var0 == 6764) {
				DbTableType.Interpreter_intStackSize -= 2;
				var5 = VerticalAlignment.getNpcDefinition(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
				int var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5.method949(var6);
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5.method951(var6);
				return 1;
			} else if (var0 == 6765) {
				var5 = VerticalAlignment.getNpcDefinition(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel  : 0;
				return 1;
			} else {
				return 2;
			}
		}
	}
}