import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;

@ObfuscatedName("bv")
public class class31 {
	@ObfuscatedName("ac")
	static Applet field83;
	@ObfuscatedName("al")
	static String field84;
	@ObfuscatedName("py")
	static int field82;

	static {
		field83 = null;
		field84 = "";
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Lds;",
		garbageValue = "0"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = class132.method708(var1, var0);
		Script var4 = MouseHandler.method175(var3, var0);
		if (var4 != null) {
			return var4;
		} else {
			var3 = class347.method1883(var2, var0);
			var4 = MouseHandler.method175(var3, var0);
			if (var4 != null) {
				return var4;
			} else {
				var3 = class20.method70(var0);
				var4 = MouseHandler.method175(var3, var0);
				return var4 != null ? var4 : null;
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "121"
	)
	static int method127(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		}

		String var4 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var9 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var9.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var9[var7] = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
			} else {
				var9[var7] = new Integer(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
		if (var7 != -1) {
			var9[0] = new Integer(var7);
		} else {
			var9 = null;
		}

		if (var0 == 1400) {
			var3.onClick = var9;
		} else if (var0 == 1401) {
			var3.onHold = var9;
		} else if (var0 == 1402) {
			var3.onRelease = var9;
		} else if (var0 == 1403) {
			var3.onMouseOver = var9;
		} else if (var0 == 1404) {
			var3.onMouseLeave = var9;
		} else if (var0 == 1405) {
			var3.onDrag = var9;
		} else if (var0 == 1406) {
			var3.onTargetLeave = var9;
		} else if (var0 == 1407) {
			var3.onVarTransmit = var9;
			var3.varTransmitTriggers = var5;
		} else if (var0 == 1408) {
			var3.onTimer = var9;
		} else if (var0 == 1409) {
			var3.onOp = var9;
		} else if (var0 == 1410) {
			var3.onDragComplete = var9;
		} else if (var0 == 1411) {
			var3.onClickRepeat = var9;
		} else if (var0 == 1412) {
			var3.onMouseRepeat = var9;
		} else if (var0 == 1414) {
			var3.onInvTransmit = var9;
			var3.invTransmitTriggers = var5;
		} else if (var0 == 1415) {
			var3.onStatTransmit = var9;
			var3.statTransmitTriggers = var5;
		} else if (var0 == 1416) {
			var3.onTargetEnter = var9;
		} else if (var0 == 1417) {
			var3.onScroll = var9;
		} else if (var0 == 1418) {
			var3.onChatTransmit = var9;
		} else if (var0 == 1419) {
			var3.onKey = var9;
		} else if (var0 == 1420) {
			var3.onFriendTransmit = var9;
		} else if (var0 == 1421) {
			var3.onClanTransmit = var9;
		} else if (var0 == 1422) {
			var3.onMiscTransmit = var9;
		} else if (var0 == 1423) {
			var3.onDialogAbort = var9;
		} else if (var0 == 1424) {
			var3.onSubChange = var9;
		} else if (var0 == 1425) {
			var3.onStockTransmit = var9;
		} else if (var0 == 1426) {
			var3.field3118 = var9;
		} else if (var0 == 1427) {
			var3.onResize = var9;
		} else if (var0 == 1428) {
			var3.field3113 = var9;
		} else if (var0 == 1429) {
			var3.field3096 = var9;
		} else if (var0 == 1430) {
			var3.field3100 = var9;
		} else if (var0 == 1431) {
			var3.field3104 = var9;
		} else if (var0 == 1434) {
			var3.field3117 = var9;
		} else if (var0 == 1435) {
			var3.field3105 = var9;
		} else {
			if (var0 < 1436 || var0 > 1439) {
				return 2;
			}

			class342 var8 = var3.method1880();
			if (var8 != null) {
				if (var0 == 1436) {
					var8.field2933 = var9;
				} else if (var0 == 1437) {
					var8.field2932 = var9;
				} else if (var0 == 1438) {
					var8.field2934 = var9;
				} else if (var0 == 1439) {
					var8.field2935 = var9;
				}
			}
		}

		var3.hasListener = true;
		return 1;
	}
}