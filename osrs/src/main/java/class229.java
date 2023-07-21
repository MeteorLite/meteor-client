import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public abstract class class229 extends Rasterizer2D {
	@ObfuscatedName("aw")
	boolean field2020;
	@ObfuscatedName("ay")
	boolean field2021;
	@ObfuscatedName("ag")
	int[] field2022;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Ljq;"
	)
	class245 field2023;

	@ObfuscatedSignature(
		descriptor = "(Ljq;)V"
	)
	class229(class245 var1) {
		this.field2020 = false;
		this.field2021 = false;
		this.field2022 = Rasterizer3D.Rasterizer3D_colorPalette;
		this.field2023 = var1;
	}

	@ObfuscatedName("aw")
	void method1196(int[] var1, int var2, int var3, float[] var4) {
		Rasterizer2D.method2601(var1, var2, var3, var4);
	}

	@ObfuscatedName("am")
	void method1199(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, byte var13, byte var14, byte var15, byte var16) {
		var10 = method1197(var10, var13, var14, var15, var16);
		var11 = method1197(var11, var13, var14, var15, var16);
		var12 = method1197(var12, var13, var14, var15, var16);
		this.vmethod1374(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
	}

	@ObfuscatedName("as")
	void method1200(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, byte var11, byte var12, byte var13, byte var14) {
		int var15 = method1197(var10, var11, var12, var13, var14);
		var10 = this.field2022[var15];
		this.vmethod1366(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
	}

	@ObfuscatedName("aj")
	@Export("vmethod1374")
	abstract void vmethod1374(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12);

	@ObfuscatedName("ag")
	@Export("vmethod1366")
	abstract void vmethod1366(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10);

	@ObfuscatedName("az")
	@Export("vmethod1378")
	abstract void vmethod1378(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22);

	@ObfuscatedName("av")
	@Export("vmethod1362")
	abstract void vmethod1362(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22);

	@ObfuscatedName("ay")
	static int method1197(int var0, byte var1, byte var2, byte var3, byte var4) {
		int var5 = var0 >> 10 & 63;
		int var6 = var0 >> 7 & 7;
		int var7 = var0 & 127;
		int var8 = var4 & 255;
		if (var1 != -1) {
			var5 += var8 * (var1 - var5) >> 7;
		}

		if (var2 != -1) {
			var6 += var8 * (var2 - var6) >> 7;
		}

		if (var3 != -1) {
			var7 += var8 * (var3 - var7) >> 7;
		}

		return (var5 << 10 | var6 << 7 | var7) & 65535;
	}

	@ObfuscatedName("ar")
	static final int method1198(int var0, int var1) {
		var1 = (var0 & 127) * var1 >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}
}
