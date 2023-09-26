import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.math.BigInteger;

@ObfuscatedName("cl")
public class class76 {
	@ObfuscatedName("ac")
	static final BigInteger field738;
	@ObfuscatedName("al")
	static final BigInteger field739;

	static {
		field738 = new BigInteger("10001", 16);
		field739 = new BigInteger("cc90697b065845f69ec9f317c5c2120b275cdf1e7dbc83f9bd6f48b14bc9225b7400ccc4d6942e14ada8e923e99c75bfa6f001f0a92bdbf435c59a0e86120e2526ebdc45626349cbc249b24e878b5eb1a2ff432b56dafa8eb5a6282883286733f87bdb2e843f8848ec651045f7295208ea0627602d4352099e730d2b57905e95", 16);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1393359399"
	)
	static void method430(int var0) {
		class465.field3904 = var0;
		class465.field3907 = new class465[var0];
		class465.field3905 = 0;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1583079321"
	)
	public static int method431(int var0) {
		return class317.field2775[var0];
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "0"
	)
	static int method432(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		}

		ClanChannelMember.invalidateWidget(var3);
		int var4;
		int var5;
		if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
			if (var0 == 1201) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1202) {
				var3.modelType = 3;
				var3.modelId = TextureProvider.localPlayer.appearance.getChatHeadId();
				return 1;
			} else if (var0 == 1207) {
				boolean var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				Strings.method1908(var3, TextureProvider.localPlayer.appearance, var7);
				return 1;
			} else if (var0 == 1208) {
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3.field3127 == null) {
					throw new RuntimeException("");
				} else {
					ZoneOperation.method1645(var3, var4);
					return 1;
				}
			} else if (var0 == 1209) {
				Interpreter.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				if (var3.field3127 == null) {
					throw new RuntimeException("");
				} else {
					UrlRequest.method664(var3, var4, var5);
					return 1;
				}
			} else if (var0 == 1210) {
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3.field3127 == null) {
					throw new RuntimeException("");
				} else {
					UrlRequester.method653(var3, TextureProvider.localPlayer.appearance.field2950, var4);
					return 1;
				}
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 2;
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
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