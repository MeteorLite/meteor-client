import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tl")
final class class499 implements class498 {
	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("archive9")
	static Archive archive9;

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ltm;I)V",
		garbageValue = "465506048"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2486((Integer)var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)Ljava/lang/Object;",
		garbageValue = "-295239457"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Integer;Ltm;S)V",
		garbageValue = "128"
	)
	void method2486(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "1972049883"
	)
	static int method2489(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 != 1927 && var0 != 2927) {
			int var4;
			if (var0 == 1928) {
				var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
				var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (var4 >= 1 && var4 <= 10) {
					class102 var5 = new class102(var4, var3.id, var3.childIndex, var3.itemId);
					Interpreter.field715.add(var5);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else if (var0 == 2928) {
				SoundCache.Interpreter_intStackSize -= 3;
				int var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				int var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				if (var8 >= 1 && var8 <= 10) {
					class102 var6 = new class102(var8, var7, var4, class92.getWidget(var7).itemId);
					Interpreter.field715.add(var6);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else {
				return 2;
			}
		} else if (Interpreter.field708 >= 10) {
			throw new RuntimeException();
		} else {
			if (var0 >= 2000) {
				var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			} else {
				var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
			}

			if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var9 = new ScriptEvent();
				var9.widget = var3;
				var9.args = var3.onResize;
				var9.field864 = Interpreter.field708 + 1;
				Client.scriptEvents.addFirst(var9);
				return 1;
			}
		}
	}
}