import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("it")
public class class226 implements class29 {
	@ObfuscatedName("ac")
	char[] field1892;
	@ObfuscatedName("al")
	int[] field1897;
	@ObfuscatedName("ak")
	public int[] field1902;
	@ObfuscatedName("ax")
	@Export("pressedKeysCount")
	public int pressedKeysCount;
	@ObfuscatedName("ao")
	int[] field1898;
	@ObfuscatedName("ah")
	int field1894;
	@ObfuscatedName("ar")
	int field1896;
	@ObfuscatedName("ab")
	int field1893;
	@ObfuscatedName("am")
	int field1895;
	@ObfuscatedName("av")
	boolean[] field1891;
	@ObfuscatedName("ag")
	boolean[] field1890;
	@ObfuscatedName("aa")
	boolean[] field1889;
	@ObfuscatedName("ap")
	public char field1899;
	@ObfuscatedName("ay")
	public int field1901;

	public class226() {
		this.field1892 = new char[128];
		this.field1897 = new int[128];
		this.field1902 = new int[128];
		this.pressedKeysCount = 0;
		this.field1898 = new int[128];
		this.field1894 = 0;
		this.field1896 = 0;
		this.field1893 = 0;
		this.field1895 = 0;
		this.field1891 = new boolean[112];
		this.field1890 = new boolean[112];
		this.field1889 = new boolean[112];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1448724719"
	)
	@Export("vmethod3949")
	public boolean vmethod3949(int var1) {
		this.method1145(var1);
		this.field1891[var1] = true;
		this.field1890[var1] = true;
		this.field1889[var1] = false;
		this.field1902[++this.pressedKeysCount - 1] = var1;
		return true;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-974805318"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		this.field1891[var1] = false;
		this.field1890[var1] = false;
		this.field1889[var1] = true;
		this.field1898[++this.field1894 - 1] = var1;
		return true;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "19"
	)
	@Export("vmethod3951")
	public boolean vmethod3951(char var1) {
		int var2 = this.field1893 + 1 & 127;
		if (var2 != this.field1896) {
			this.field1897[this.field1893] = -1;
			this.field1892[this.field1893] = var1;
			this.field1893 = var2;
		}

		return false;
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
		descriptor = "(II)V",
		garbageValue = "1769728274"
	)
	void method1145(int var1) {
		int var2 = this.field1893 + 1 & 127;
		if (var2 != this.field1896) {
			this.field1897[this.field1893] = var1;
			this.field1892[this.field1893] = 0;
			this.field1893 = var2;
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	public void method1147() {
		this.field1896 = this.field1895;
		this.field1895 = this.field1893;
		this.pressedKeysCount = 0;
		this.field1894 = 0;
		Arrays.fill(this.field1890, false);
		Arrays.fill(this.field1889, false);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-192433797"
	)
	public final boolean method1148() {
		if (this.field1896 == this.field1895) {
			return false;
		} else {
			this.field1901 = this.field1897[this.field1896];
			this.field1899 = this.field1892[this.field1896];
			this.field1896 = this.field1896 + 1 & 127;
			return true;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1443777028"
	)
	public boolean method1149(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1890[var1] : false;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-978109184"
	)
	@Export("getKeyPressed")
	public boolean getKeyPressed(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1891[var1] : false;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1065204501"
	)
	public boolean method1151(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field1889[var1] : false;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "118"
	)
	public int[] method1152() {
		int[] var1 = new int[this.pressedKeysCount];

		for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
			var1[var2] = this.field1902[var2];
		}

		return var1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "-31"
	)
	public int[] method1153() {
		int[] var1 = new int[this.field1894];

		for (int var2 = 0; var2 < this.field1894; ++var2) {
			var1[var2] = this.field1898[var2];
		}

		return var1;
	}
}