import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("m")
	static int[] field1040;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1737189293
	)
	@Export("group")
	int group;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 737701507
	)
	@Export("type")
	int type;
	@ObfuscatedName("f")
	boolean field1036;

	InterfaceParent() {
		this.field1036 = false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(II)Lbj;",
		garbageValue = "502875656"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Ldi;[F[FB)V",
		garbageValue = "67"
	)
	static void method2237(class118 var0, float[] var1, float[] var2) {
		if (var0 != null) {
			var0.field1458 = var1[0];
			float var3 = var1[3] - var1[0];
			float var4 = var2[3] - var2[0];
			float var5 = var1[1] - var1[0];
			float var6 = 0.0F;
			float var7 = 0.0F;
			if ((double)var5 != 0.0D) {
				var6 = (var2[1] - var2[0]) / var5;
			}

			var5 = var1[3] - var1[2];
			if (0.0D != (double)var5) {
				var7 = (var2[3] - var2[2]) / var5;
			}

			float var8 = 1.0F / (var3 * var3);
			float var9 = var3 * var6;
			float var10 = var7 * var3;
			var0.field1460[0] = var8 * (var10 + var9 - var4 - var4) / var3;
			var0.field1460[1] = (var4 + var4 + var4 - var9 - var9 - var10) * var8;
			var0.field1460[2] = var6;
			var0.field1460[3] = var2[0];
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "294870217"
	)
	static int method2238(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? TextureProvider.scriptDotWidget : MenuAction.scriptActiveWidget;
		if (var0 == 1700) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == 1701) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 1702) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else if (var0 == 1707) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.method5790() ? 1 : 0;
			return 1;
		} else if (var0 == 1708) {
			return class118.method2875(var3);
		} else {
			return var0 == 1709 ? class347.method6510(var3) : 2;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZS)I",
		garbageValue = "256"
	)
	static int method2239(int var0, Script var1, boolean var2) {
		if (var0 == 5306) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SceneTilePaint.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == 5307) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					WallDecoration.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == 5308) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Player.clientPreferences.method2411();
				return 1;
			} else if (var0 != 5309) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					Player.clientPreferences.method2410(var3);
				}

				return 1;
			}
		}
	}
}
