import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("Renderable")
public abstract class Renderable extends DualNode {
	@ObfuscatedName("dt")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("dp")
	@ObfuscatedGetter(
		intValue = 1165159491
	)
	@Export("height")
	public int height;

	protected Renderable() {
		this.height = 1000;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)Lha;",
		garbageValue = "13"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("cw")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lct;",
		garbageValue = "16663677"
	)
	static class82[] method4463() {
		return new class82[]{class82.field1062, class82.field1065, class82.field1069, class82.field1068, class82.field1064};
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Lbt;",
		garbageValue = "-95"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var5 = class120.method2925(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var4 = class221.method4682(var2, var0);
			var5 = class120.method2925(var4, var0);
			return var5 != null ? var5 : null;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ldi;FZI)F",
		garbageValue = "-1587158874"
	)
	static float method4464(class118 var0, float var1, boolean var2) {
		float var3 = 0.0F;
		if (var0 != null && var0.method2876() != 0) {
			float var4 = (float)var0.field1467[0].field1407;
			float var5 = (float)var0.field1467[var0.method2876() - 1].field1407;
			float var6 = var5 - var4;
			if ((double)var6 == 0.0D) {
				return var0.field1467[0].field1409;
			} else {
				float var7 = 0.0F;
				if (var1 > var5) {
					var7 = (var1 - var5) / var6;
				} else {
					var7 = (var1 - var4) / var6;
				}

				double var8 = (double)((int)var7);
				float var10 = Math.abs((float)((double)var7 - var8));
				float var11 = var10 * var6;
				var8 = Math.abs(var8 + 1.0D);
				double var12 = var8 / 2.0D;
				double var14 = (double)((int)var12);
				var10 = (float)(var12 - var14);
				float var16;
				float var17;
				if (var2) {
					if (var0.field1454 == class117.field1446) {
						if ((double)var10 != 0.0D) {
							var11 += var4;
						} else {
							var11 = var5 - var11;
						}
					} else if (var0.field1454 != class117.field1445 && var0.field1454 != class117.field1443) {
						if (var0.field1454 == class117.field1444) {
							var11 = var4 - var1;
							var16 = var0.field1467[0].field1406;
							var17 = var0.field1467[0].field1412;
							var3 = var0.field1467[0].field1409;
							if (0.0D != (double)var16) {
								var3 -= var11 * var17 / var16;
							}

							return var3;
						}
					} else {
						var11 = var5 - var11;
					}
				} else if (var0.field1455 == class117.field1446) {
					if ((double)var10 != 0.0D) {
						var11 = var5 - var11;
					} else {
						var11 += var4;
					}
				} else if (var0.field1455 != class117.field1445 && var0.field1455 != class117.field1443) {
					if (var0.field1455 == class117.field1444) {
						var11 = var1 - var5;
						var16 = var0.field1467[var0.method2876() - 1].field1410;
						var17 = var0.field1467[var0.method2876() - 1].field1411;
						var3 = var0.field1467[var0.method2876() - 1].field1409;
						if (0.0D != (double)var16) {
							var3 += var17 * var11 / var16;
						}

						return var3;
					}
				} else {
					var11 += var4;
				}

				var3 = class33.method636(var0, var11);
				float var18;
				if (var2 && var0.field1454 == class117.field1443) {
					var18 = var0.field1467[var0.method2876() - 1].field1409 - var0.field1467[0].field1409;
					var3 = (float)((double)var3 - var8 * (double)var18);
				} else if (!var2 && var0.field1455 == class117.field1443) {
					var18 = var0.field1467[var0.method2876() - 1].field1409 - var0.field1467[0].field1409;
					var3 = (float)((double)var3 + (double)var18 * var8);
				}

				return var3;
			}
		} else {
			return var3;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqf;B)I",
		garbageValue = "113"
	)
	static int method4461(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1519012832"
	)
	public static int method4462(int var0) {
		return (var0 & class440.field4720) - 1;
	}
}
