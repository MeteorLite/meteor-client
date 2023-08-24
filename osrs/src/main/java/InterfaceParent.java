import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("au")
	@Export("group")
	int group;
	@ObfuscatedName("ae")
	@Export("type")
	int type;
	@ObfuscatedName("ao")
	boolean field858;

	InterfaceParent() {
		this.field858 = false;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)I",
		garbageValue = "1893248685"
	)
	public static int method473(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var1;
		} else if (var2 == 1) {
			return 7 - var0 - (var3 - 1);
		} else {
			return var2 == 2 ? 7 - var1 - (var4 - 1) : var0;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-612957518"
	)
	static int method474(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
		}

		class218.invalidateWidget(var3);
		int var4;
		int var5;
		if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
			if (var0 == 1201) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1202) {
				var3.modelType = 3;
				var3.modelId = VarbitComposition.localPlayer.appearance.getChatHeadId();
				return 1;
			} else if (var0 == 1207) {
				boolean var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
				class160.method846(var3, VarbitComposition.localPlayer.appearance, var7);
				return 1;
			} else if (var0 == 1208) {
				var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (var3.field3101 == null) {
					throw new RuntimeException("");
				} else {
					ReflectionCheck.method174(var3, var4);
					return 1;
				}
			} else if (var0 == 1209) {
				SoundCache.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				if (var3.field3101 == null) {
					throw new RuntimeException("");
				} else {
					Tiles.method460(var3, var4, var5);
					return 1;
				}
			} else if (var0 == 1210) {
				var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (var3.field3101 == null) {
					throw new RuntimeException("");
				} else {
					class135.method742(var3, VarbitComposition.localPlayer.appearance.field2916, var4);
					return 1;
				}
			} else {
				return 2;
			}
		} else {
			SoundCache.Interpreter_intStackSize -= 2;
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemComposition var6 = InvDefinition.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == 1205) {
				var3.itemQuantityMode = 0;
			} else if (var0 == 1212 | var6.isStackable == 1) {
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

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "-104"
	)
	static int method476(int var0, Script var1, boolean var2) {
		if (var0 == 7463) {
			boolean var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
			SecureRandomFuture.method444(var3);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jg")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-59"
	)
	static void method475() {
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class92.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

	}
}