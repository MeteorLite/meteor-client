import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class59 {
	@ObfuscatedName("wn")
	@ObfuscatedSignature(
		descriptor = "Loo;"
	)
	static JagNetThread field309;
	@ObfuscatedName("ah")
	@Export("SpriteBuffer_spriteWidths")
	public static int[] SpriteBuffer_spriteWidths;
	@ObfuscatedName("af")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("cz")
	static String field307;
	@ObfuscatedName("hp")
	static String field308;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lbc;"
	)
	VorbisFloor field310;
	@ObfuscatedName("al")
	boolean field311;
	@ObfuscatedName("ak")
	int[] field313;
	@ObfuscatedName("ax")
	int[] field314;
	@ObfuscatedName("ao")
	boolean[] field312;

	@ObfuscatedSignature(
		descriptor = "(Lbc;Z[I[I[Z)V"
	)
	class59(VorbisFloor var1, boolean var2, int[] var3, int[] var4, boolean[] var5) {
		this.field310 = var1;
		this.field311 = var2;
		this.field313 = var3;
		this.field314 = var4;
		this.field312 = var5;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([FII)V",
		garbageValue = "2130530034"
	)
	void method324(float[] var1, int var2) {
		int var3 = this.field310.field175.length;
		VorbisFloor var10000 = this.field310;
		int var4 = VorbisFloor.field171[this.field310.multiplier - 1];
		boolean[] var5 = this.field312;
		this.field312[1] = true;
		var5[0] = true;

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		for (var6 = 2; var6 < var3; ++var6) {
			var7 = this.field310.method202(this.field313, var6);
			var8 = this.field310.method203(this.field313, var6);
			var9 = this.field310.method204(this.field313[var7], this.field314[var7], this.field313[var8], this.field314[var8], this.field313[var6]);
			var10 = this.field314[var6];
			int var11 = var4 - var9;
			int var13 = (var11 < var9 ? var11 : var9) << 1;
			if (var10 != 0) {
				boolean[] var14 = this.field312;
				this.field312[var8] = true;
				var14[var7] = true;
				this.field312[var6] = true;
				if (var10 >= var13) {
					this.field314[var6] = var11 > var9 ? var9 + (var10 - var9) : var11 + (var9 - var10) - 1;
				} else {
					this.field314[var6] = (var10 & 1) != 0 ? var9 - (var10 + 1) / 2 : var10 / 2 + var9;
				}
			} else {
				this.field312[var6] = false;
				this.field314[var6] = var9;
			}
		}

		this.VarbisFloor_sort(0, var3 - 1);
		var6 = 0;
		var7 = this.field310.multiplier * this.field314[0];

		for (var8 = 1; var8 < var3; ++var8) {
			if (this.field312[var8]) {
				var9 = this.field313[var8];
				var10 = this.field310.multiplier * this.field314[var8];
				this.field310.method205(var6, var7, var9, var10, var1, var2);
				if (var9 >= var2) {
					return;
				}

				var6 = var9;
				var7 = var10;
			}
		}

		var10000 = this.field310;
		float var16 = VorbisFloor.VorbisFloor_decibelStatics[var7];

		for (var9 = var6; var9 < var2; ++var9) {
			var1[var9] *= var16;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "467756903"
	)
	boolean method325() {
		return this.field311;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2030001337"
	)
	@Export("VarbisFloor_sort")
	void VarbisFloor_sort(int var1, int var2) {
		if (var1 < var2) {
			int var3 = var1;
			int var4 = this.field313[var1];
			int var5 = this.field314[var1];
			boolean var6 = this.field312[var1];

			for (int var7 = var1 + 1; var7 <= var2; ++var7) {
				int var8 = this.field313[var7];
				if (var8 < var4) {
					this.field313[var3] = var8;
					this.field314[var3] = this.field314[var7];
					this.field312[var3] = this.field312[var7];
					++var3;
					this.field313[var7] = this.field313[var3];
					this.field314[var7] = this.field314[var3];
					this.field312[var7] = this.field312[var3];
				}
			}

			this.field313[var3] = var4;
			this.field314[var3] = var5;
			this.field312[var3] = var6;
			this.VarbisFloor_sort(var1, var3 - 1);
			this.VarbisFloor_sort(var3 + 1, var2);
		}
	}
}