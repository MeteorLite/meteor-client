import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class101 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1873768041"
	)
	public static boolean method598(int var0) {
		return var0 >= WorldMapDecorationType.field3123.id && var0 <= WorldMapDecorationType.field3122.id || var0 == WorldMapDecorationType.field3119.id;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2030205668"
	)
	static void method599() {
		ByteArrayPool.field3746.clear();
		ByteArrayPool.field3746.add(100);
		ByteArrayPool.field3746.add(5000);
		ByteArrayPool.field3746.add(10000);
		ByteArrayPool.field3746.add(30000);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-1662859603"
	)
	static int method600(int var0, Script var1, boolean var2) {
		if (var0 == 6754) {
			int var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			NPCComposition var4 = class90.getNpcDefinition(var3);
			Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
			return 1;
		} else {
			NPCComposition var5;
			if (var0 == 6764) {
				SoundCache.Interpreter_intStackSize -= 2;
				var5 = class90.getNpcDefinition(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
				int var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var5.method994(var6);
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var5.method996(var6);
				return 1;
			} else if (var0 == 6765) {
				var5 = class90.getNpcDefinition(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel * 989486243 * 599602955 : 0;
				return 1;
			} else {
				return 2;
			}
		}
	}
}