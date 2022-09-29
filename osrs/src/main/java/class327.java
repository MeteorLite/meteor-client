import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
public class class327 {
	@ObfuscatedName("sc")
	@ObfuscatedSignature(
		descriptor = "Lbg;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("c")
	@Export("spriteMap")
	final HashMap spriteMap;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("bounds")
	Bounds bounds;
	@ObfuscatedName("f")
	int[] field4125;
	@ObfuscatedName("n")
	int[] field4122;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1382063769
	)
	int field4123;

	public class327() {
		this.spriteMap = new HashMap();
		this.bounds = new Bounds(0, 0);
		this.field4125 = new int[2048];
		this.field4122 = new int[2048];
		this.field4123 = 0;
		InterfaceParent.field1040 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = class11.method121((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)(0.075F + (float)var1 * 0.425F / 16.0F));
			InterfaceParent.field1040[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < InterfaceParent.field1040.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = class11.method121((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < InterfaceParent.field1040.length; ++var1) {
				InterfaceParent.field1040[var1] = var5;
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1313706428"
	)
	void method6199(int var1) {
		int var2 = var1 * 2 + 1;
		double[] var3 = class82.method2261(0.0D, (double)((float)var1 / 3.0F), var1);
		double var4 = var3[var1] * var3[var1];
		int[] var6 = new int[var2 * var2];
		boolean var7 = false;

		for (int var8 = 0; var8 < var2; ++var8) {
			for (int var9 = 0; var9 < var2; ++var9) {
				int var10 = var6[var9 + var8 * var2] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
				if (!var7 && var10 > 0) {
					var7 = true;
				}
			}
		}

		SpritePixels var11 = new SpritePixels(var6, var2, var2);
		this.spriteMap.put(var1, var11);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)Lqi;",
		garbageValue = "-1092501019"
	)
	SpritePixels method6200(int var1) {
		if (!this.spriteMap.containsKey(var1)) {
			this.method6199(var1);
		}

		return (SpritePixels)this.spriteMap.get(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1438069586"
	)
	public final void method6201(int var1, int var2) {
		if (this.field4123 < this.field4125.length) {
			this.field4125[this.field4123] = var1;
			this.field4122[this.field4123] = var2;
			++this.field4123;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	public final void method6207() {
		this.field4123 = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IILqi;FI)V",
		garbageValue = "-975934270"
	)
	public final void method6203(int var1, int var2, SpritePixels var3, float var4) {
		int var5 = (int)(18.0F * var4);
		SpritePixels var6 = this.method6200(var5);
		int var7 = var5 * 2 + 1;
		Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
		Bounds var9 = new Bounds(0, 0);
		this.bounds.setHigh(var7, var7);
		System.nanoTime();

		int var10;
		int var11;
		int var12;
		for (var10 = 0; var10 < this.field4123; ++var10) {
			var11 = this.field4125[var10];
			var12 = this.field4122[var10];
			int var13 = (int)((float)(var11 - var1) * var4) - var5;
			int var14 = (int)((float)var3.subHeight - var4 * (float)(var12 - var2)) - var5;
			this.bounds.setLow(var13, var14);
			this.bounds.method7096(var8, var9);
			this.method6204(var6, var3, var9);
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
					if (var11 > InterfaceParent.field1040.length) {
						var11 = InterfaceParent.field1040.length;
					}

					var12 = InterfaceParent.field1040[var11 - 1];
					var3.pixels[var10] = -16777216 | var12;
				}
			}
		}

		System.nanoTime();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lqi;Lqi;Lnk;I)V",
		garbageValue = "-199663267"
	)
	void method6204(SpritePixels var1, SpritePixels var2, Bounds var3) {
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
