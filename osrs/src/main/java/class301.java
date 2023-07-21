import java.util.HashMap;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public final class class301 {
	@ObfuscatedName("ar")
	static final HashMap field2733;
	@ObfuscatedName("iz")
	static int field2732;

	static {
		field2733 = new HashMap();
		java.util.Calendar.getInstance(method1576("Europe/London"));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)Ljava/util/TimeZone;",
		garbageValue = "13393"
	)
	static TimeZone method1576(String var0) {
		synchronized(field2733) {
			TimeZone var2 = (TimeZone)field2733.get(var0);
			if (var2 == null) {
				var2 = TimeZone.getTimeZone(var0);
				field2733.put(var0, var2);
			}

			return var2;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-2109434245"
	)
	static int method1577(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 100) {
			Interpreter.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = VarbitComposition.getWidget(var3);
				if (var6.children == null) {
					var6.children = new Widget[var5 + 1];
				}

				if (var6.children.length <= var5) {
					Widget[] var7 = new Widget[var5 + 1];

					for (int var8 = 0; var8 < var6.children.length; ++var8) {
						var7[var8] = var6.children[var8];
					}

					var6.children = var7;
				}

				if (var5 > 0 && var6.children[var5 - 1] == null) {
					throw new RuntimeException("" + (var5 - 1));
				} else {
					Widget var12 = new Widget();
					var12.type = var4;
					var12.parentId = var12.id = var6.id;
					var12.childIndex = var5;
					var12.isIf3 = true;
					if (var4 == 12) {
						var12.method1804();
						var12.method1805().method1741(new class105(var12));
						var12.method1805().method1740(new class106(var12));
					}

					var6.children[var5] = var12;
					if (var2) {
						class36.scriptDotWidget = var12;
					} else {
						class351.scriptActiveWidget = var12;
					}

					class200.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == 101) {
				var9 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
				Widget var10 = VarbitComposition.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				class200.invalidateWidget(var10);
				return 1;
			} else if (var0 == 102) {
				var9 = VarbitComposition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
				var9.children = null;
				class200.invalidateWidget(var9);
				return 1;
			} else if (var0 != 200) {
				if (var0 == 201) {
					var9 = VarbitComposition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							class36.scriptDotWidget = var9;
						} else {
							class351.scriptActiveWidget = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Widget var11 = MouseRecorder.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						class36.scriptDotWidget = var11;
					} else {
						class351.scriptActiveWidget = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}
