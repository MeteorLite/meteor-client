import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class134 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1268;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1273;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1272;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1281;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1276;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1270;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1278;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1267;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1274;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1280;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1269;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1266;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1277;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1282;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1279;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1271;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	static final class134 field1275;
	@ObfuscatedName("au")
	final int field1285;
	@ObfuscatedName("ai")
	final int field1284;
	@ObfuscatedName("ae")
	final int field1283;

	static {
		field1268 = new class134(0, 0, (String)null, -1, -1);
		field1273 = new class134(1, 1, (String)null, 0, 2);
		field1272 = new class134(2, 2, (String)null, 1, 2);
		field1281 = new class134(3, 3, (String)null, 2, 2);
		field1276 = new class134(4, 4, (String)null, 3, 1);
		field1270 = new class134(5, 5, (String)null, 4, 1);
		field1278 = new class134(6, 6, (String)null, 5, 1);
		field1267 = new class134(7, 7, (String)null, 6, 3);
		field1274 = new class134(8, 8, (String)null, 7, 3);
		field1280 = new class134(9, 9, (String)null, 8, 3);
		field1269 = new class134(10, 10, (String)null, 0, 7);
		field1266 = new class134(11, 11, (String)null, 1, 7);
		field1277 = new class134(12, 12, (String)null, 2, 7);
		field1282 = new class134(13, 13, (String)null, 3, 7);
		field1279 = new class134(14, 14, (String)null, 4, 7);
		field1271 = new class134(15, 15, (String)null, 5, 7);
		field1275 = new class134(16, 16, (String)null, 0, 5);
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;II)V",
		garbageValue = "-1"
	)
	class134(int var1, int var2, String var3, int var4, int var5) {
		this.field1285 = var1;
		this.field1284 = var2;
		this.field1283 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1284;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-232140937"
	)
	int method724() {
		return this.field1283;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "385720754"
	)
	static int method725(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		if (var0 == 1600) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 1601) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else {
			class344 var7;
			if (var0 == 1602) {
				if (var3.type == 12) {
					var7 = var3.method1877();
					if (var7 != null) {
						Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var7.method1811().method2070();
						return 1;
					}
				}

				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var3.text;
				return 1;
			} else if (var0 == 1603) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
				return 1;
			} else if (var0 == 1604) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
				return 1;
			} else if (var0 == 1605) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
				return 1;
			} else if (var0 == 1606) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
				return 1;
			} else if (var0 == 1607) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
				return 1;
			} else if (var0 == 1608) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
				return 1;
			} else if (var0 == 1609) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
				return 1;
			} else if (var0 == 1610) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
				return 1;
			} else if (var0 == 1611) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
				return 1;
			} else if (var0 == 1612) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
				return 1;
			} else if (var0 == 1613) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
				return 1;
			} else if (var0 == 1614) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
				return 1;
			} else {
				class339 var4;
				if (var0 == 1617) {
					var4 = var3.method1878();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2923 * -1501316877 * 383918139 : 0;
				}

				if (var0 == 1618) {
					var4 = var3.method1878();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2925 * 1245217763 * 1917639115 : 0;
					return 1;
				} else if (var0 == 1619) {
					var7 = var3.method1877();
					Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1812().method2070() : "";
					return 1;
				} else if (var0 == 1620) {
					var4 = var3.method1878();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2924 * 1697101243 * 2044708723 : 0;
					return 1;
				} else if (var0 == 1621) {
					var7 = var3.method1877();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1822() : 0;
					return 1;
				} else if (var0 == 1622) {
					var7 = var3.method1877();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1823() : 0;
					return 1;
				} else if (var0 == 1623) {
					var7 = var3.method1877();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1824() : 0;
					return 1;
				} else if (var0 == 1624) {
					var7 = var3.method1877();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1814() ? 1 : 0;
					return 1;
				} else if (var0 != 1625) {
					if (var0 == 1626) {
						var7 = var3.method1877();
						Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1813().method2145() : "";
						return 1;
					} else if (var0 == 1627) {
						var7 = var3.method1877();
						int var5 = var7 != null ? var7.method1818() : 0;
						int var6 = var7 != null ? var7.method1817() : 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 1628) {
						var7 = var3.method1877();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1817() : 0;
						return 1;
					} else if (var0 == 1629) {
						var7 = var3.method1877();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1826() : 0;
						return 1;
					} else if (var0 == 1630) {
						var7 = var3.method1877();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1825() : 0;
						return 1;
					} else if (var0 == 1631) {
						var7 = var3.method1877();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1827() : 0;
						return 1;
					} else if (var0 == 1632) {
						var7 = var3.method1877();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1828() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 1633) {
							var8 = var3.method1879();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method105(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 1634) {
							var8 = var3.method1879();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method106((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1877();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1815() ? 1 : 0;
					return 1;
				}
			}
		}
	}
}