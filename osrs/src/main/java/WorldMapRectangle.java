import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("au")
	@Export("width")
	int width;
	@ObfuscatedName("ae")
	@Export("height")
	int height;
	@ObfuscatedName("ao")
	@Export("x")
	int x;
	@ObfuscatedName("at")
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Ljd;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		descriptor = "(Ljd;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-213889891"
	)
	static int method1528(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
		if (var0 == 1600) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 1601) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else {
			class329 var7;
			if (var0 == 1602) {
				if (var3.type == 12) {
					var7 = var3.method1844();
					if (var7 != null) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var7.method1779().method2041();
						return 1;
					}
				}

				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.text;
				return 1;
			} else if (var0 == 1603) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollWidth;
				return 1;
			} else if (var0 == 1604) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollHeight;
				return 1;
			} else if (var0 == 1605) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelZoom;
				return 1;
			} else if (var0 == 1606) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleX;
				return 1;
			} else if (var0 == 1607) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleZ;
				return 1;
			} else if (var0 == 1608) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleY;
				return 1;
			} else if (var0 == 1609) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.transparencyTop;
				return 1;
			} else if (var0 == 1610) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.transparencyBot;
				return 1;
			} else if (var0 == 1611) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.color;
				return 1;
			} else if (var0 == 1612) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.color2;
				return 1;
			} else if (var0 == 1613) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
				return 1;
			} else if (var0 == 1614) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
				return 1;
			} else {
				class324 var4;
				if (var0 == 1617) {
					var4 = var3.method1845();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2892 * -1007608077 * 1891510843 : 0;
				}

				if (var0 == 1618) {
					var4 = var3.method1845();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2890 * -113152143 * 439316881 : 0;
					return 1;
				} else if (var0 == 1619) {
					var7 = var3.method1844();
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1780().method2041() : "";
					return 1;
				} else if (var0 == 1620) {
					var4 = var3.method1845();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2891 * 1092445257 * -767308295 : 0;
					return 1;
				} else if (var0 == 1621) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1790() : 0;
					return 1;
				} else if (var0 == 1622) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1791() : 0;
					return 1;
				} else if (var0 == 1623) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1792() : 0;
					return 1;
				} else if (var0 == 1624) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null && var7.method1782() ? 1 : 0;
					return 1;
				} else if (var0 != 1625) {
					if (var0 == 1626) {
						var7 = var3.method1844();
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1781().method2113() : "";
						return 1;
					} else if (var0 == 1627) {
						var7 = var3.method1844();
						int var5 = var7 != null ? var7.method1786() : 0;
						int var6 = var7 != null ? var7.method1785() : 0;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 1628) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1785() : 0;
						return 1;
					} else if (var0 == 1629) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1794() : 0;
						return 1;
					} else if (var0 == 1630) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1793() : 0;
						return 1;
					} else if (var0 == 1631) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1795() : 0;
						return 1;
					} else if (var0 == 1632) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1796() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 1633) {
							var8 = var3.method1846();
							Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = var8 != null ? var8.method98(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 1634) {
							var8 = var3.method1846();
							Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = var8 != null ? var8.method99((char)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null && var7.method1783() ? 1 : 0;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "853160118"
	)
	static void method1529() {
		if (Canvas.worldMap != null) {
			Canvas.worldMap.method2394(HealthBar.Client_plane, (VarbitComposition.localPlayer.x >> 7) + UrlRequester.baseX, (VarbitComposition.localPlayer.y >> 7) + class47.baseY, false);
			Canvas.worldMap.loadCache();
		}

	}
}