import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
public class class426 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "777593325"
	)
	static int method2177(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		}

		class159.invalidateWidget(var3);
		int var4;
		int var5;
		if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
			if (var0 == 1201) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1202) {
				var3.modelType = 3;
				var3.modelId = class229.localPlayer.appearance.getChatHeadId();
				return 1;
			} else if (var0 == 1207) {
				boolean var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
				class18.method70(var3, class229.localPlayer.appearance, var7);
				return 1;
			} else if (var0 == 1208) {
				var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (var3.field3125 == null) {
					throw new RuntimeException("");
				} else {
					AbstractWorldMapData.method1323(var3, var4);
					return 1;
				}
			} else if (var0 == 1209) {
				DbTableType.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				if (var3.field3125 == null) {
					throw new RuntimeException("");
				} else {
					ZoneOperation.method1633(var3, var4, var5);
					return 1;
				}
			} else if (var0 == 1210) {
				var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (var3.field3125 == null) {
					throw new RuntimeException("");
				} else {
					class302.method1626(var3, class229.localPlayer.appearance.field2947, var4);
					return 1;
				}
			} else {
				return 2;
			}
		} else {
			DbTableType.Interpreter_intStackSize -= 2;
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemComposition var6 = class214.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == 1205) {
				var3.itemQuantityMode = 0;
			} else if (var0 == 1212 | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.modelRotation > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.modelRotation;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}
}