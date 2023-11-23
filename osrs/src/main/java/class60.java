import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class60 {
	@ObfuscatedName("ws")
	@ObfuscatedSignature(
		descriptor = "Lsb;"
	)
	static PlatformInfo field312;
	@ObfuscatedName("ab")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("io")
	@ObfuscatedSignature(
		descriptor = "Lel;"
	)
	@Export("urlRequester")
	static UrlRequester urlRequester;
	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		descriptor = "[Luz;"
	)
	@Export("headIconHintSprites")
	static SpritePixels[] headIconHintSprites;
	@ObfuscatedName("oc")
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("uz")
	@Export("cameraLookAtSpeed")
	static int cameraMoveToSpeed;
	@ObfuscatedName("at")
	byte[] field314;
	@ObfuscatedName("ah")
	int field315;
	@ObfuscatedName("ar")
	int field316;

	class60() {
		this.field314 = null;
		this.field315 = 0;
		this.field316 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1826933410"
	)
	int method335(int var1) {
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var1 >= 8 - this.field316; var1 -= var4) {
			var4 = 8 - this.field316;
			int var5 = (1 << var4) - 1;
			var2 += (this.field314[this.field315] >> this.field316 & var5) << var3;
			this.field316 = 0;
			++this.field315;
			var3 += var4;
		}

		if (var1 > 0) {
			var4 = (1 << var1) - 1;
			var2 += (this.field314[this.field315] >> this.field316 & var4) << var3;
			this.field316 += var1;
		}

		return var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "100"
	)
	int method336() {
		int var1 = this.field314[this.field315] >> this.field316 & 1;
		++this.field316;
		this.field315 += this.field316 >> 3;
		this.field316 &= 7;
		return var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "([BIB)V",
		garbageValue = "-31"
	)
	void method337(byte[] var1, int var2) {
		this.field314 = var1;
		this.field315 = var2;
		this.field316 = 0;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "3"
	)
	static int method338(int var0, Script var1, boolean var2) {
		Widget var3 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
		if (var0 == 2600) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 2601) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == 2602) {
			Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == 2603) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == 2604) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == 2605) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == 2606) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == 2607) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == 2608) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == 2609) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == 2610) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == 2611) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == 2612) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == 2613) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == 2614) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			class336 var4;
			if (var0 == 2617) {
				var4 = var3.method1872();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2923 : 0;
			}

			if (var0 == 2618) {
				var4 = var3.method1872();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2921 : 0;
				return 1;
			} else {
				class341 var7;
				if (var0 == 2619) {
					var7 = var3.method1871();
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1808().method2056() : "";
					return 1;
				} else if (var0 == 2620) {
					var4 = var3.method1872();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 != null ? var4.field2922: 0;
					return 1;
				} else if (var0 == 2621) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1818() : 0;
					return 1;
				} else if (var0 == 2622) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1819() : 0;
					return 1;
				} else if (var0 == 2623) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1820() : 0;
					return 1;
				} else if (var0 == 2624) {
					var7 = var3.method1871();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null && var7.method1810() ? 1 : 0;
					return 1;
				} else if (var0 != 2625) {
					if (var0 == 2626) {
						var7 = var3.method1871();
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1809().method2131() : "";
						return 1;
					} else if (var0 == 2627) {
						var7 = var3.method1871();
						int var5 = var7 != null ? var7.method1814() : 0;
						int var6 = var7 != null ? var7.method1813() : 0;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 2628) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1813() : 0;
						return 1;
					} else if (var0 == 2629) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1822() : 0;
						return 1;
					} else if (var0 == 2630) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1821() : 0;
						return 1;
					} else if (var0 == 2631) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1823() : 0;
						return 1;
					} else if (var0 == 2632) {
						var7 = var3.method1871();
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7 != null ? var7.method1824() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 2633) {
							var8 = var3.method1873();
							Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = var8 != null ? var8.method115(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 2634) {
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

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-128"
	)
	static final boolean method339() {
		return Client.isMenuOpen;
	}
}