import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class59 {
	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		descriptor = "Lqi;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		descriptor = "Lpi;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("js")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lbo;"
	)
	VorbisFloor field311;
	@ObfuscatedName("ae")
	boolean field312;
	@ObfuscatedName("ao")
	int[] field314;
	@ObfuscatedName("at")
	int[] field315;
	@ObfuscatedName("ac")
	boolean[] field313;

	@ObfuscatedSignature(
		descriptor = "(Lbo;Z[I[I[Z)V"
	)
	class59(VorbisFloor var1, boolean var2, int[] var3, int[] var4, boolean[] var5) {
		this.field311 = var1;
		this.field312 = var2;
		this.field314 = var3;
		this.field315 = var4;
		this.field313 = var5;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([FIB)V",
		garbageValue = "44"
	)
	void method321(float[] var1, int var2) {
		int var3 = this.field311.field176.length;
		VorbisFloor var10000 = this.field311;
		int var4 = VorbisFloor.field172[this.field311.multiplier - 1];
		boolean[] var5 = this.field313;
		this.field313[1] = true;
		var5[0] = true;

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		for (var6 = 2; var6 < var3; ++var6) {
			var7 = this.field311.method192(this.field314, var6);
			var8 = this.field311.method193(this.field314, var6);
			var9 = this.field311.method194(this.field314[var7], this.field315[var7], this.field314[var8], this.field315[var8], this.field314[var6]);
			var10 = this.field315[var6];
			int var11 = var4 - var9;
			int var13 = (var11 < var9 ? var11 : var9) << 1;
			if (var10 != 0) {
				boolean[] var14 = this.field313;
				this.field313[var8] = true;
				var14[var7] = true;
				this.field313[var6] = true;
				if (var10 >= var13) {
					this.field315[var6] = var11 > var9 ? var9 + (var10 - var9) : var11 + (var9 - var10) - 1;
				} else {
					this.field315[var6] = (var10 & 1) != 0 ? var9 - (var10 + 1) / 2 : var10 / 2 + var9;
				}
			} else {
				this.field313[var6] = false;
				this.field315[var6] = var9;
			}
		}

		this.VarbisFloor_sort(0, var3 - 1);
		var6 = 0;
		var7 = this.field311.multiplier * this.field315[0];

		for (var8 = 1; var8 < var3; ++var8) {
			if (this.field313[var8]) {
				var9 = this.field314[var8];
				var10 = this.field311.multiplier * this.field315[var8];
				this.field311.method195(var6, var7, var9, var10, var1, var2);
				if (var9 >= var2) {
					return;
				}

				var6 = var9;
				var7 = var10;
			}
		}

		var10000 = this.field311;
		float var16 = VorbisFloor.VorbisFloor_decibelStatics[var7];

		for (var9 = var6; var9 < var2; ++var9) {
			var1[var9] *= var16;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "81"
	)
	boolean method322() {
		return this.field312;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1743044108"
	)
	@Export("VarbisFloor_sort")
	void VarbisFloor_sort(int var1, int var2) {
		if (var1 < var2) {
			int var3 = var1;
			int var4 = this.field314[var1];
			int var5 = this.field315[var1];
			boolean var6 = this.field313[var1];

			for (int var7 = var1 + 1; var7 <= var2; ++var7) {
				int var8 = this.field314[var7];
				if (var8 < var4) {
					this.field314[var3] = var8;
					this.field315[var3] = this.field315[var7];
					this.field313[var3] = this.field313[var7];
					++var3;
					this.field314[var7] = this.field314[var3];
					this.field315[var7] = this.field315[var3];
					this.field313[var7] = this.field313[var3];
				}
			}

			this.field314[var3] = var4;
			this.field315[var3] = var5;
			this.field313[var3] = var6;
			this.VarbisFloor_sort(var1, var3 - 1);
			this.VarbisFloor_sort(var3 + 1, var2);
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(CLon;B)I",
		garbageValue = "82"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}
}