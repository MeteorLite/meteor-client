import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class211 implements class29 {
	@ObfuscatedName("km")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("crossSprites")
	static SpritePixels[] crossSprites;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	Widget field1852;
	@ObfuscatedName("ay")
	boolean field1851;
	@ObfuscatedName("ar")
	boolean field1850;

	public class211() {
		this.field1852 = null;
		this.field1851 = false;
		this.field1850 = false;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1364202239"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		if (this.field1852 == null) {
			return false;
		} else {
			class27 var2 = this.field1852.method1807();
			if (var2 == null) {
				return false;
			} else {
				if (var2.method108(var1)) {
					switch(var1) {
					case 81:
						this.field1850 = true;
						break;
					case 82:
						this.field1851 = true;
						break;
					default:
						if (this.method1076(var1)) {
							class200.invalidateWidget(this.field1852);
						}
					}
				}

				return var2.method106(var1);
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1960624058"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		switch(var1) {
		case 81:
			this.field1850 = false;
			return false;
		case 82:
			this.field1851 = false;
			return false;
		default:
			return false;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "932068520"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		if (this.field1852 == null) {
			return false;
		} else {
			boolean var2;
			if ((var1 < ' ' || var1 >= 127) && (var1 <= 127 || var1 >= 160) && (var1 <= 160 || var1 > 255)) {
				label76: {
					if (var1 != 0) {
						char[] var3 = class385.cp1252AsciiExtension;

						for (int var4 = 0; var4 < var3.length; ++var4) {
							char var5 = var3[var4];
							if (var5 == var1) {
								var2 = true;
								break label76;
							}
						}
					}

					var2 = false;
				}
			} else {
				var2 = true;
			}

			if (!var2) {
				return false;
			} else {
				class330 var7 = this.field1852.method1805();
				if (var7 != null && var7.method1750()) {
					class27 var6 = this.field1852.method1807();
					if (var6 == null) {
						return false;
					} else {
						if (var6.method109(var1) && var7.method1711(var1)) {
							class200.invalidateWidget(this.field1852);
						}

						return var6.method107(var1);
					}
				} else {
					return false;
				}
			}
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ZB)Z",
		garbageValue = "-93"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lmt;B)V",
		garbageValue = "-84"
	)
	public void method1069(Widget var1) {
		this.method1071();
		if (var1 != null) {
			this.field1852 = var1;
			class328 var2 = var1.method1808();
			if (var2 != null) {
				var2.field2886.method1694(true);
				if (var2.field2885 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method474(var1);
					var3.setArgs(var2.field2885);
					ClientPacket.getScriptEvents().addFirst(var3);
				}
			}
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)Lmt;",
		garbageValue = "-52"
	)
	public Widget method1070() {
		return this.field1852;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2127531849"
	)
	public void method1071() {
		if (this.field1852 != null) {
			class328 var1 = this.field1852.method1808();
			Widget var2 = this.field1852;
			this.field1852 = null;
			if (var1 != null) {
				var1.field2886.method1694(false);
				if (var1.field2885 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method474(var2);
					var3.setArgs(var1.field2885);
					ClientPacket.getScriptEvents().addFirst(var3);
				}

			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "7161"
	)
	boolean method1076(int var1) {
		if (this.field1852 == null) {
			return false;
		} else {
			class330 var2 = this.field1852.method1805();
			if (var2 != null && var2.method1750()) {
				switch(var1) {
				case 13:
					this.method1071();
					return true;
				case 48:
					if (this.field1851) {
						var2.method1717();
					}

					return true;
				case 65:
					if (this.field1851) {
						var2.method1736(ClanChannelMember.method772());
					}

					return true;
				case 66:
					if (this.field1851) {
						var2.method1735(ClanChannelMember.method772());
					}

					return true;
				case 67:
					if (this.field1851) {
						var2.method1737(ClanChannelMember.method772());
					}

					return true;
				case 84:
					if (var2.method1756() == 0) {
						var2.method1711(10);
					} else if (this.field1850 && var2.method1760()) {
						var2.method1711(10);
					} else {
						class328 var3 = this.field1852.method1808();
						ScriptEvent var4 = new ScriptEvent();
						var4.method474(this.field1852);
						var4.setArgs(var3.field2882);
						ClientPacket.getScriptEvents().addFirst(var4);
						this.method1071();
					}

					return true;
				case 85:
					if (this.field1851) {
						var2.method1714();
					} else {
						var2.method1712();
					}

					return true;
				case 96:
					if (this.field1851) {
						var2.method1725(this.field1850);
					} else {
						var2.method1723(this.field1850);
					}

					return true;
				case 97:
					if (this.field1851) {
						var2.method1726(this.field1850);
					} else {
						var2.method1724(this.field1850);
					}

					return true;
				case 98:
					if (this.field1851) {
						var2.method1738();
					} else {
						var2.method1727(this.field1850);
					}

					return true;
				case 99:
					if (this.field1851) {
						var2.method1739();
					} else {
						var2.method1728(this.field1850);
					}

					return true;
				case 101:
					if (this.field1851) {
						var2.method1715();
					} else {
						var2.method1713();
					}

					return true;
				case 102:
					if (this.field1851) {
						var2.method1721(this.field1850);
					} else {
						var2.method1719(this.field1850);
					}

					return true;
				case 103:
					if (this.field1851) {
						var2.method1722(this.field1850);
					} else {
						var2.method1720(this.field1850);
					}

					return true;
				case 104:
					if (this.field1851) {
						var2.method1731(this.field1850);
					} else {
						var2.method1729(this.field1850);
					}

					return true;
				case 105:
					if (this.field1851) {
						var2.method1732(this.field1850);
					} else {
						var2.method1730(this.field1850);
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
}
