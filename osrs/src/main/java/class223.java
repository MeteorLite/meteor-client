import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("il")
public class class223 implements class29 {
	@ObfuscatedName("gv")
	static int field1885;
	@ObfuscatedName("jn")
	static int field1886;
	@ObfuscatedName("at")
	char[] field1890;
	@ObfuscatedName("ah")
	int[] field1896;
	@ObfuscatedName("ar")
	public int[] field1900;
	@ObfuscatedName("ao")
	@Export("pressedKeysCount")
	public int pressedKeysCount;
	@ObfuscatedName("ab")
	int[] field1895;
	@ObfuscatedName("au")
	int field1894;
	@ObfuscatedName("aa")
	int field1891;
	@ObfuscatedName("ac")
	int field1892;
	@ObfuscatedName("al")
	int field1893;
	@ObfuscatedName("az")
	boolean[] field1889;
	@ObfuscatedName("ap")
	boolean[] field1887;
	@ObfuscatedName("av")
	boolean[] field1888;
	@ObfuscatedName("ax")
	public char field1897;
	@ObfuscatedName("as")
	public int field1899;

	public class223() {
		this.field1890 = new char[128];
		this.field1896 = new int[128];
		this.field1900 = new int[128];
		this.pressedKeysCount = 0;
		this.field1895 = new int[128];
		this.field1894 = 0;
		this.field1891 = 0;
		this.field1892 = 0;
		this.field1893 = 0;
		this.field1889 = new boolean[112];
		this.field1887 = new boolean[112];
		this.field1888 = new boolean[112];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "512"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		this.method1125(var1);
		this.field1889[var1] = true;
		this.field1887[var1] = true;
		this.field1888[var1] = false;
		this.field1900[++this.pressedKeysCount - 1] = var1;
		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1146773117"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		this.field1889[var1] = false;
		this.field1887[var1] = false;
		this.field1888[var1] = true;
		this.field1895[++this.field1894 - 1] = var1;
		return true;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "984376689"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		int var2 = this.field1892 + 1 & 127;
		if (var2 != this.field1891) {
			this.field1896[this.field1892] = -1;
			this.field1890[this.field1892] = var1;
			this.field1892 = var2;
		}

		return false;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ZB)Z",
		garbageValue = "-49"
	)
	@Export("vmethod3953")
	public boolean vmethod3953(boolean var1) {
		return false;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "19704"
	)
	void method1125(int var1) {
		int var2 = this.field1892 + 1 & 127;
		if (var2 != this.field1891) {
			this.field1896[this.field1892] = var1;
			this.field1890[this.field1892] = 0;
			this.field1892 = var2;
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1513942573"
	)
	public void method1127() {
		this.field1891 = this.field1893;
		this.field1893 = this.field1892;
		this.pressedKeysCount = 0;
		this.field1894 = 0;
		Arrays.fill(this.field1887, false);
		Arrays.fill(this.field1888, false);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1159556377"
	)
	public final boolean method1128() {
		if (this.field1893 == this.field1891) {
			return false;
		} else {
			this.field1899 = this.field1896[this.field1891];
			this.field1897 = this.field1890[this.field1891];
			this.field1891 = this.field1891 + 1 & 127;
			return true;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "21"
	)
	public boolean method1129(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1887[var1] : false;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1604984140"
	)
	@Export("getKeyPressed")
	public boolean getKeyPressed(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1889[var1] : false;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1100003987"
	)
	public boolean method1131(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1888[var1] : false;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1519174440"
	)
	public int[] method1132() {
		int[] var1 = new int[this.pressedKeysCount];

		for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
			var1[var2] = this.field1900[var2];
		}

		return var1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "353218827"
	)
	public int[] method1133() {
		int[] var1 = new int[this.field1894];

		for (int var2 = 0; var2 < this.field1894; ++var2) {
			var1[var2] = this.field1895[var2];
		}

		return var1;
	}
}