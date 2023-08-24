import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("iz")
public class class212 implements class29 {
	@ObfuscatedName("au")
	char[] field1882;
	@ObfuscatedName("ae")
	int[] field1888;
	@ObfuscatedName("ao")
	public int[] field1892;
	@ObfuscatedName("at")
	@Export("pressedKeysCount")
	public int pressedKeysCount;
	@ObfuscatedName("ac")
	int[] field1887;
	@ObfuscatedName("ai")
	int field1884;
	@ObfuscatedName("az")
	int field1886;
	@ObfuscatedName("ap")
	int field1885;
	@ObfuscatedName("aa")
	int field1883;
	@ObfuscatedName("af")
	boolean[] field1880;
	@ObfuscatedName("ad")
	boolean[] field1879;
	@ObfuscatedName("aq")
	boolean[] field1881;
	@ObfuscatedName("al")
	public char field1889;
	@ObfuscatedName("an")
	public int field1890;

	public class212() {
		this.field1882 = new char[128];
		this.field1888 = new int[128];
		this.field1892 = new int[128];
		this.pressedKeysCount = 0;
		this.field1887 = new int[128];
		this.field1884 = 0;
		this.field1886 = 0;
		this.field1885 = 0;
		this.field1883 = 0;
		this.field1880 = new boolean[112];
		this.field1879 = new boolean[112];
		this.field1881 = new boolean[112];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1089015731"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		this.method1102(var1);
		this.field1880[var1] = true;
		this.field1879[var1] = true;
		this.field1881[var1] = false;
		this.field1892[++this.pressedKeysCount - 1] = var1;
		return true;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1292750960"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		this.field1880[var1] = false;
		this.field1879[var1] = false;
		this.field1881[var1] = true;
		this.field1887[++this.field1884 - 1] = var1;
		return true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-352714805"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		int var2 = this.field1885 + 1 & 127;
		if (var2 != this.field1886) {
			this.field1888[this.field1885] = -1;
			this.field1882[this.field1885] = var1;
			this.field1885 = var2;
		}

		return false;
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
		descriptor = "(IB)V",
		garbageValue = "25"
	)
	void method1102(int var1) {
		int var2 = this.field1885 + 1 & 127;
		if (var2 != this.field1886) {
			this.field1888[this.field1885] = var1;
			this.field1882[this.field1885] = 0;
			this.field1885 = var2;
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "831915412"
	)
	public void method1104() {
		this.field1886 = this.field1883;
		this.field1883 = this.field1885;
		this.pressedKeysCount = 0;
		this.field1884 = 0;
		Arrays.fill(this.field1879, false);
		Arrays.fill(this.field1881, false);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1344001483"
	)
	public final boolean method1105() {
		if (this.field1886 == this.field1883) {
			return false;
		} else {
			this.field1890 = this.field1888[this.field1886];
			this.field1889 = this.field1882[this.field1886];
			this.field1886 = this.field1886 + 1 & 127;
			return true;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1783943803"
	)
	public boolean method1106(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1879[var1] : false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-182514708"
	)
	@Export("getKeyPressed")
	public boolean getKeyPressed(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1880[var1] : false;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "13"
	)
	public boolean method1108(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1881[var1] : false;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-390851826"
	)
	public int[] method1109() {
		int[] var1 = new int[this.pressedKeysCount];

		for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
			var1[var2] = this.field1892[var2];
		}

		return var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "60"
	)
	public int[] method1110() {
		int[] var1 = new int[this.field1884];

		for (int var2 = 0; var2 < this.field1884; ++var2) {
			var1[var2] = this.field1887[var2];
		}

		return var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIS)I",
		garbageValue = "24356"
	)
	static int method1099(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}

	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		descriptor = "([Lmi;IB)V",
		garbageValue = "-27"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class385.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					WorldMapSection1.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = class92.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					WorldMapSection1.runScriptEvent(var5);
				}
			}
		}

	}
}