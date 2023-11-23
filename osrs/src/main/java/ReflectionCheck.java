import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ObfuscatedName("bj")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("at")
	@Export("id")
	int id;
	@ObfuscatedName("ah")
	@Export("size")
	int size;
	@ObfuscatedName("ar")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("ao")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("ab")
	@Export("fields")
	Field[] fields;
	@ObfuscatedName("au")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("aa")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("ac")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "1"
	)
	static int method186(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		if (var0 == 1600) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 1601) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else {
			class341 var7;
			if (var0 == 1602) {
				if (var3.type == 12) {
					var7 = var3.method1871();
					if (var7 != null) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var7.method1807().method2056();
						return 1;
					}
				}

				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.text;
				return 1;
			} else if (var0 == 1603) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollWidth;
				return 1;
			} else if (var0 == 1604) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollHeight;
				return 1;
			} else if (var0 == 1605) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelZoom;
				return 1;
			} else if (var0 == 1606) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleX;
				return 1;
			} else if (var0 == 1607) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleZ;
				return 1;
			} else if (var0 == 1608) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleY;
				return 1;
			} else if (var0 == 1609) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.transparencyTop;
				return 1;
			} else if (var0 == 1610) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.transparencyBot;
				return 1;
			} else if (var0 == 1611) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.color;
				return 1;
			} else if (var0 == 1612) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.color2;
				return 1;
			} else if (var0 == 1613) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
				return 1;
			} else if (var0 == 1614) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
				return 1;
			} else {
				class336 var4;
				if (var0 == 1617) {
					var4 = var3.method1872();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2923 : 0;
				}

				if (var0 == 1618) {
					var4 = var3.method1872();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2921 : 0;
					return 1;
				} else if (var0 == 1619) {
					var7 = var3.method1871();
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1808().method2056() : "";
					return 1;
				} else if (var0 == 1620) {
					var4 = var3.method1872();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2922 : 0;
					return 1;
				} else if (var0 == 1621) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1818() : 0;
					return 1;
				} else if (var0 == 1622) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1819() : 0;
					return 1;
				} else if (var0 == 1623) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1820() : 0;
					return 1;
				} else if (var0 == 1624) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null && var7.method1810() ? 1 : 0;
					return 1;
				} else if (var0 != 1625) {
					if (var0 == 1626) {
						var7 = var3.method1871();
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1809().method2131() : "";
						return 1;
					} else if (var0 == 1627) {
						var7 = var3.method1871();
						int var5 = var7 != null ? var7.method1814() : 0;
						int var6 = var7 != null ? var7.method1813() : 0;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 1628) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1813() : 0;
						return 1;
					} else if (var0 == 1629) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1822() : 0;
						return 1;
					} else if (var0 == 1630) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1821() : 0;
						return 1;
					} else if (var0 == 1631) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1823() : 0;
						return 1;
					} else if (var0 == 1632) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1824() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 1633) {
							var8 = var3.method1873();
							Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = var8 != null ? var8.method115(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 1634) {
							var8 = var3.method1873();
							Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = var8 != null ? var8.method116((char)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null && var7.method1811() ? 1 : 0;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("lz")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "674487818"
	)
	static String method187(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0] : Client.menuActions[var0];
		}
	}
}