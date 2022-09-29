import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mw")
public class class360 {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)Lps;",
		garbageValue = "579230649"
	)
	public static class434 method6732(int var0) {
		int var1 = class432.field4684[var0];
		if (var1 == 1) {
			return class434.field4691;
		} else if (var1 == 2) {
			return class434.field4689;
		} else {
			return var1 == 3 ? class434.field4688 : null;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;Ljava/lang/String;Ljava/lang/String;I)Lmv;",
		garbageValue = "-746551807"
	)
	public static Font method6731(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		return class448.method8182(var0, var1, var4, var5);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZB)I",
		garbageValue = "-91"
	)
	static int method6733(int var0, Script var1, boolean var2) {
		Widget var3 = SpotAnimationDefinition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == 2800) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SoundCache.Widget_unpackTargetMask(class97.getWidgetFlags(var3));
			return 1;
		} else if (var0 != 2801) {
			if (var0 == 2802) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1908548296"
	)
	static final void method6734() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				ClientPreferences.updateActorSequence(var2, var2.definition.size);
			}
		}

	}
}
