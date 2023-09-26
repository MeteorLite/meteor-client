import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.datatransfer.Clipboard;
import java.security.SecureRandom;

@ObfuscatedName("ib")
public class class224 implements class29 {
	@ObfuscatedName("ik")
	@Export("secureRandom")
	static SecureRandom secureRandom;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	Widget field1883;
	@ObfuscatedName("al")
	boolean field1882;
	@ObfuscatedName("ak")
	boolean field1881;

	public class224() {
		this.field1883 = null;
		this.field1882 = false;
		this.field1881 = false;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1448724719"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		if (this.field1883 == null) {
			return false;
		} else {
			class27 var2 = this.field1883.method1879();
			if (var2 == null) {
				return false;
			} else {
				if (var2.method109(var1)) {
					switch(var1) {
					case 81:
						this.field1881 = true;
						break;
					case 82:
						this.field1882 = true;
						break;
					default:
						if (this.method1140(var1)) {
							ClanChannelMember.invalidateWidget(this.field1883);
						}
					}
				}

				return var2.method107(var1);
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-974805318"
	)
	public boolean vmethod3989(int var1) {
		switch(var1) {
		case 81:
			this.field1881 = false;
			return false;
		case 82:
			this.field1882 = false;
			return false;
		default:
			return false;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "19"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		if (this.field1883 == null) {
			return false;
		} else {
			boolean var2;
			if (var1 >= ' ' && var1 < 127 || var1 > 127 && var1 < 160 || var1 > 160 && var1 <= 255) {
				var2 = true;
			} else {
				label81: {
					if (var1 != 0) {
						char[] var3 = class399.cp1252AsciiExtension;

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
				class344 var7 = this.field1883.method1877();
				if (var7 != null && var7.method1819()) {
					class27 var6 = this.field1883.method1879();
					if (var6 == null) {
						return false;
					} else {
						if (var6.method110(var1) && var7.method1780(var1)) {
							ClanChannelMember.invalidateWidget(this.field1883);
						}

						return var6.method108(var1);
					}
				} else {
					return false;
				}
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ZI)Z",
		garbageValue = "-672025946"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)V",
		garbageValue = "-782706277"
	)
	public void method1132(Widget var1) {
		this.method1134();
		if (var1 != null) {
			this.field1883 = var1;
			class342 var2 = var1.method1880();
			if (var2 != null) {
				var2.field2936.method1763(true);
				if (var2.field2933 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method470(var1);
					var3.setArgs(var2.field2933);
					class7.getScriptEvents().addFirst(var3);
				}
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(B)Lnm;",
		garbageValue = "-68"
	)
	public Widget method1133() {
		return this.field1883;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-83"
	)
	public void method1134() {
		if (this.field1883 != null) {
			class342 var1 = this.field1883.method1880();
			Widget var2 = this.field1883;
			this.field1883 = null;
			if (var1 != null) {
				var1.field2936.method1763(false);
				if (var1.field2933 != null) {
					ScriptEvent var3 = new ScriptEvent();
					var3.method470(var2);
					var3.setArgs(var1.field2933);
					class7.getScriptEvents().addFirst(var3);
				}

			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "104826143"
	)
	boolean method1140(int var1) {
		if (this.field1883 == null) {
			return false;
		} else {
			class344 var2 = this.field1883.method1877();
			if (var2 != null && var2.method1819()) {
				Clipboard var5;
				switch(var1) {
				case 13:
					this.method1134();
					return true;
				case 48:
					if (this.field1882) {
						var2.method1786();
					}

					return true;
				case 65:
					if (this.field1882) {
						var5 = class159.client.getClipboard();
						var2.method1805(var5);
					}

					return true;
				case 66:
					if (this.field1882) {
						var5 = class159.client.getClipboard();
						var2.method1804(var5);
					}

					return true;
				case 67:
					if (this.field1882) {
						var5 = class159.client.getClipboard();
						var2.method1806(var5);
					}

					return true;
				case 84:
					if (var2.method1825() == 0) {
						var2.method1780(10);
					} else if (this.field1881 && var2.method1829()) {
						var2.method1780(10);
					} else {
						class342 var3 = this.field1883.method1880();
						ScriptEvent var4 = new ScriptEvent();
						var4.method470(this.field1883);
						var4.setArgs(var3.field2934);
						class7.getScriptEvents().addFirst(var4);
						this.method1134();
					}

					return true;
				case 85:
					if (this.field1882) {
						var2.method1783();
					} else {
						var2.method1781();
					}

					return true;
				case 96:
					if (this.field1882) {
						var2.method1794(this.field1881);
					} else {
						var2.method1792(this.field1881);
					}

					return true;
				case 97:
					if (this.field1882) {
						var2.method1795(this.field1881);
					} else {
						var2.method1793(this.field1881);
					}

					return true;
				case 98:
					if (this.field1882) {
						var2.method1807();
					} else {
						var2.method1796(this.field1881);
					}

					return true;
				case 99:
					if (this.field1882) {
						var2.method1808();
					} else {
						var2.method1797(this.field1881);
					}

					return true;
				case 101:
					if (this.field1882) {
						var2.method1784();
					} else {
						var2.method1782();
					}

					return true;
				case 102:
					if (this.field1882) {
						var2.method1790(this.field1881);
					} else {
						var2.method1788(this.field1881);
					}

					return true;
				case 103:
					if (this.field1882) {
						var2.method1791(this.field1881);
					} else {
						var2.method1789(this.field1881);
					}

					return true;
				case 104:
					if (this.field1882) {
						var2.method1800(this.field1881);
					} else {
						var2.method1798(this.field1881);
					}

					return true;
				case 105:
					if (this.field1882) {
						var2.method1801(this.field1881);
					} else {
						var2.method1799(this.field1881);
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

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "([BI)Lds;",
		garbageValue = "-1039632832"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0 ? EnumComposition.method999(var8) : 1);
				var1.switches[var7] = var9;

				while (var8-- > 0) {
					int var10 = var2.readInt();
					int var11 = var2.readInt();
					var9.put(new IntegerNode(var11), (long)var10);
				}
			}
		}

		var2.offset = 0;
		var1.field820 = var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "120"
	)
	static int method1141(int var0, Script var1, boolean var2) {
		return 2;
	}
}