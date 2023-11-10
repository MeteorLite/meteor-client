import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;

@ObfuscatedName("os")
public class class381 {
	@ObfuscatedName("at")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lrv;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("ar")
	int[] field3630;
	@ObfuscatedName("ao")
	int[] field3629;
	@ObfuscatedName("ab")
	int field3628;

	public class381() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field3630 = new int[2048];
		this.field3629 = new int[2048];
		this.field3628 = 0;
		class162.method845();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-18604685"
	)
	void method1983(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = class384.method1990(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var2 * var8] = (int)(256.0D * (var3[var9] * var3[var8] / var4));
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		SpritePixels var11 = new SpritePixels(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Luz;",
		garbageValue = "1127436045"
	)
	SpritePixels method1984(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method1983(var1);
		}

		return (SpritePixels)this.spriteMap.get(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1542973383"
	)
	public final void method1985(int var1, int var2) {
		if (this.field3628 < this.field3630.length) {
			this.field3630[this.field3628] = var1;
			this.field3629[this.field3628] = var2;
			++this.field3628;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-26946"
	)
	public final void method1986() {
		this.field3628 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IILuz;FB)V",
		garbageValue = "127"
	)
	public final void method1987(int var1, int var2, SpritePixels var3, float var4) {
		int var5 = (int)(var4 * 18.0F);
		SpritePixels var6 = this.method1984(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field3628; ++var10) {
			var11 = this.field3630[var10];
			var12 = this.field3629[var10];
			int var13 = (int)((float)(var11 - var1) * var4) - var5;
			int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method2301(var8, var9);
			this.method1988(var6, var3, var9);
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
					if (var11 > ChatChannel.field835.length) {
						var11 = ChatChannel.field835.length;
					}

					var12 = ChatChannel.field835[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Luz;Luz;Lrv;I)V",
		garbageValue = "-1645913083"
	)
	void method1988(SpritePixels var1, SpritePixels var2, Bounds var3) {
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
			int var7 = var3.lowX + var2.subWidth * var3.lowY;

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