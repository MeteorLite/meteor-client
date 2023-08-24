import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class210 implements class29 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	Widget field1874;
	@ObfuscatedName("ae")
	boolean field1872;
	@ObfuscatedName("ao")
	boolean field1873;

	public class210() {
		this.field1874 = null;
		this.field1872 = false;
		this.field1873 = false;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1089015731"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		if (this.field1874 == null) {
			return false;
		} else {
			class27 var2 = this.field1874.method1846();
			if (var2 == null) {
				return false;
			} else {
				if (var2.method102(var1)) {
					switch(var1) {
					case 81:
						this.field1873 = true;
						break;
					case 82:
						this.field1872 = true;
						break;
					default:
						if (this.method1095(var1)) {
							class218.invalidateWidget(this.field1874);
						}
					}
				}

				return var2.method100(var1);
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1292750960"
	)
	public boolean vmethod3989(int var1) {
		switch(var1) {
		case 81:
			this.field1873 = false;
			return false;
		case 82:
			this.field1872 = false;
			return false;
		default:
			return false;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-352714805"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		if (this.field1874 == null) {
			return false;
		} else {
			boolean var2;
			if (var1 >= ' ' && var1 < 127 || var1 > 127 && var1 < 160 || var1 > 160 && var1 <= 255) {
				var2 = true;
			} else {
				label81: {
					if (var1 != 0) {
						char[] var3 = class384.cp1252AsciiExtension;

						for (int var4 = 0; var4 < var3.length; ++var4) {
							char var5 = var3[var4];
							if (var5 == var1) {
								var2 = true;
								break label81;
							}
						}
					}

					var2 = false;
				}
			}

			if (!var2) {
				return false;
			} else {
				class329 var7 = this.field1874.method1844();
				if (var7 != null && var7.method1787()) {
					class27 var6 = this.field1874.method1846();
					if (var6 == null) {
						return false;
					} else {
						if (var6.method103(var1) && var7.method1748(var1)) {
							class218.invalidateWidget(this.field1874);
						}

						return var6.method101(var1);
					}
				} else {
					return false;
				}
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ZI)Z",
		garbageValue = "-1559971994"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lmi;I)V",
		garbageValue = "753644002"
	)
	public void method1088(Widget var1) {
		this.method1090();
		if (var1 != null) {
			this.field1874 = var1;
			class327 var2 = var1.method1847();
			if (var2 != null) {
				var2.field2902.method1731(true);
				if (var2.field2898 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method479(var1);
					var3.setArgs(var2.field2898);
					class30.getScriptEvents().addFirst(var3);
				}
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Lmi;",
		garbageValue = "-869248693"
	)
	public Widget method1089() {
		return this.field1874;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	public void method1090() {
		if (this.field1874 != null) {
			class327 var1 = this.field1874.method1847();
			Widget var2 = this.field1874;
			this.field1874 = null;
			if (var1 != null) {
				var1.field2902.method1731(false);
				if (var1.field2898 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method479(var2);
					var3.setArgs(var1.field2898);
					class30.getScriptEvents().addFirst(var3);
				}

			}
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-53"
	)
	boolean method1095(int var1) {
		if (this.field1874 == null) {
			return false;
		} else {
			class329 var2 = this.field1874.method1844();
			if (var2 != null && var2.method1787()) {
				switch(var1) {
				case 13:
					this.method1090();
					return true;
				case 48:
					if (this.field1872) {
						var2.method1754();
					}

					return true;
				case 65:
					if (this.field1872) {
						var2.method1773(GrandExchangeOfferTotalQuantityComparator.method1945());
					}

					return true;
				case 66:
					if (this.field1872) {
						var2.method1772(GrandExchangeOfferTotalQuantityComparator.method1945());
					}

					return true;
				case 67:
					if (this.field1872) {
						var2.method1774(GrandExchangeOfferTotalQuantityComparator.method1945());
					}

					return true;
				case 84:
					if (var2.method1793() == 0) {
						var2.method1748(10);
					} else if (this.field1873 && var2.method1797()) {
						var2.method1748(10);
					} else {
						class327 var3 = this.field1874.method1847();
						ScriptEvent var4 = new ScriptEvent();
						var4.method479(this.field1874);
						var4.setArgs(var3.field2901);
						class30.getScriptEvents().addFirst(var4);
						this.method1090();
					}

					return true;
				case 85:
					if (this.field1872) {
						var2.method1751();
					} else {
						var2.method1749();
					}

					return true;
				case 96:
					if (this.field1872) {
						var2.method1762(this.field1873);
					} else {
						var2.method1760(this.field1873);
					}

					return true;
				case 97:
					if (this.field1872) {
						var2.method1763(this.field1873);
					} else {
						var2.method1761(this.field1873);
					}

					return true;
				case 98:
					if (this.field1872) {
						var2.method1775();
					} else {
						var2.method1764(this.field1873);
					}

					return true;
				case 99:
					if (this.field1872) {
						var2.method1776();
					} else {
						var2.method1765(this.field1873);
					}

					return true;
				case 101:
					if (this.field1872) {
						var2.method1752();
					} else {
						var2.method1750();
					}

					return true;
				case 102:
					if (this.field1872) {
						var2.method1758(this.field1873);
					} else {
						var2.method1756(this.field1873);
					}

					return true;
				case 103:
					if (this.field1872) {
						var2.method1759(this.field1873);
					} else {
						var2.method1757(this.field1873);
					}

					return true;
				case 104:
					if (this.field1872) {
						var2.method1768(this.field1873);
					} else {
						var2.method1766(this.field1873);
					}

					return true;
				case 105:
					if (this.field1872) {
						var2.method1769(this.field1873);
					} else {
						var2.method1767(this.field1873);
					}

					return true;
				default:
					return false;
				}
			} else {
				return false;
			}
		}
	}

	@ObfuscatedName("np")
	@ObfuscatedSignature(
		descriptor = "(IIIILui;Lme;I)V",
		garbageValue = "-1589482115"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var3 * var8 + var9 * var2 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method2684(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}