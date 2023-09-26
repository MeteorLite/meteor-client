import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;

@ObfuscatedName("ow")
public class class384 {
	@ObfuscatedName("am")
	static int[] field3629;
	@ObfuscatedName("ac")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lrx;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("ak")
	int[] field3631;
	@ObfuscatedName("ax")
	int[] field3632;
	@ObfuscatedName("ao")
	int field3630;

	public class384() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3631 = new int[2048];
		this.field3632 = new int[2048];
		this.field3630 = 0;
		field3629 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = class538.method2658((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + (float)var1 * 0.425F / 16.0F));
			field3629[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < field3629.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = class538.method2658((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < field3629.length; ++var1) {
				field3629[var1] = var5;
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1432707829"
	)
	void method1995(int var1) {
		int var2 = var1 * 2 + 1;
		double var4 = (double)((float)var1 / 3.0F);
		int var6 = var1 * 2 + 1;
		double[] var7 = new double[var6];
		int var8 = -var1;

		for (int var9 = 0; var8 <= var1; ++var9) {
			double var16 = (double)(var8 - 0) / var4;
			double var14 = Math.exp(var16 * -var16 / 2.0D) / Math.sqrt(6.283185307179586D);
			double var12 = var14 / var4;
			var7[var9] = var12;
			++var8;
		}

		double[] var18 = var7;
		double var19 = var7[var1] * var7[var1];
		int[] var21 = new int[var2 * var2];
		boolean var22 = false;

		for (int var11 = 0; var11 < var2; ++var11) {
			for (int var23 = 0; var23 < var2; ++var23) {
				int var13 = var21[var23 + var11 * var2] = (int)(var18[var11] * var18[var23] / var19 * 256.0D);
				if (!var22 && var13 > 0) {
					var22 = true;
				}
			}
		}

		SpritePixels var24 = new SpritePixels(var21, var2, var2);
		this.spriteMap.put(var1, var24);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Lud;",
		garbageValue = "297405994"
	)
	SpritePixels method1996(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method1995(var1);
		}

		return (SpritePixels)this.spriteMap.get(var1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-659509092"
	)
	public final void method1997(int var1, int var2) {
		if (this.field3630 < this.field3631.length) {
			this.field3631[this.field3630] = var1;
			this.field3632[this.field3630] = var2;
			++this.field3630;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1095059460"
	)
	public final void method1998() {
		this.field3630 = 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IILud;FI)V",
		garbageValue = "1259929010"
	)
	public final void method1999(int var1, int var2, SpritePixels var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		SpritePixels var6 = this.method1996(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3630; ++var10) {
			var11 = this.field3631[var10];
			var12 = this.field3632[var10];
			int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method2322(var8, var9);
			this.method2000(var6, var3, var9);
		}

		System.nanoTime();
		System.nanoTime();

		for (var10 = 0; var10 < var3.pixels.length; ++var10) {
			if (var3.pixels[var10] == 0) {
				var3.pixels[var10] = -16777216;
			} else {
				var11 = (var3.pixels[var10] + 64 - 1) / 256;
				if (var11 <= 0) {
					var3.pixels[var10] = -16777216;
				} else {
					if (var11 > field3629.length) {
						var11 = field3629.length;
					}

					var12 = field3629[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lud;Lud;Lrx;I)V",
		garbageValue = "-493691057"
	)
	void method2000(SpritePixels var1, SpritePixels var2, Bounds var3) {
		if (var3.highX != 0 && var3.highY != 0) {
			int var4 = 0;
			int var5 = 0;
			if (var3.lowX == 0) {
				var4 = var1.subWidth - var3.highX;
			}

			if (var3.lowY == 0) {
				var5 = var1.subHeight - var3.highY;
			}

			int var6 = var4 + var5 * var1.subWidth;
			int var7 = var2.subWidth * var3.lowY + var3.lowX;

			for (int var8 = 0; var8 < var3.highY; ++var8) {
				for (int var9 = 0; var9 < var3.highX; ++var9) {
					int[] var10000 = var2.pixels;
					int var10001 = var7++;
					var10000[var10001] += var1.pixels[var6++];
				}

				var6 += var1.subWidth - var3.highX;
				var7 += var2.subWidth - var3.highX;
			}

		}
	}
}