import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("md")
@Implements("Varps")
public class Varps {
	@ObfuscatedName("wl")
	@ObfuscatedSignature(
		descriptor = "Lox;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("ac")
	@Export("Varps_masks")
	static int[] Varps_masks;
	@ObfuscatedName("ak")
	@Export("Varps_temp")
	public static int[] Varps_temp;
	@ObfuscatedName("ax")
	@Export("Varps_main")
	public static int[] Varps_main;

	static {
		Varps_masks = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			Varps_masks[var1] = var0 - 1;
			var0 += var0;
		}

		Varps_temp = new int[5000];
		Varps_main = new int[5000];
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "-62"
	)
	static int method1735(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == 2700) {
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == 2701) {
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2702) {
			int var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2706) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else if (var0 == 2707) {
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.method1867() ? 1 : 0;
			return 1;
		} else if (var0 == 2708) {
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			return class110.method624(var3);
		} else if (var0 == 2709) {
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			return Canvas.method88(var3);
		} else {
			return 2;
		}
	}
}