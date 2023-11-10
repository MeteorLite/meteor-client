import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Callable;

@ObfuscatedName("ah")
public class class1 implements Callable {
	@ObfuscatedName("ai")
	@Export("ByteArrayPool_arrays")
	static byte[][][] ByteArrayPool_arrays;
	@ObfuscatedName("ud")
	@Export("cameraLookAtAcceleration")
	static int cameraLookAtAcceleration;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	final Buffer field3;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lao;"
	)
	final class3 field2;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lac;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class7 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lac;Luj;Lao;)V"
	)
	class1(class7 var1, Buffer var2, class3 var3) {
		this.this$0 = var1;
		this.field3 = var2;
		this.field2 = var3;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		return this.field2.vmethod12(this.field3);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)Lgo;",
		garbageValue = "9"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1140575558"
	)
	static int method3(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		}

		String var4 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var9 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var9.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var9[var7] = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
			} else {
				var9[var7] = new Integer(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
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
			var3.field3115 = var9;
		} else if (var0 == 1427) {
			var3.onResize = var9;
		} else if (var0 == 1428) {
			var3.field3099 = var9;
		} else if (var0 == 1429) {
			var3.field3114 = var9;
		} else if (var0 == 1430) {
			var3.field3107 = var9;
		} else if (var0 == 1431) {
			var3.field3108 = var9;
		} else if (var0 == 1434) {
			var3.field3116 = var9;
		} else if (var0 == 1435) {
			var3.field3098 = var9;
		} else {
			if (var0 < 1436 || var0 > 1439) {
				return 2;
			}

			class339 var8 = var3.method1874();
			if (var8 != null) {
				if (var0 == 1436) {
					var8.field2931 = var9;
				} else if (var0 == 1437) {
					var8.field2933 = var9;
				} else if (var0 == 1438) {
					var8.field2930 = var9;
				} else if (var0 == 1439) {
					var8.field2932 = var9;
				}
			}
		}

		var3.hasListener = true;
		return 1;
	}
}