import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public abstract class class228 extends Rasterizer2D {
	@ObfuscatedName("au")
	boolean field2045;
	@ObfuscatedName("ae")
	boolean field2044;
	@ObfuscatedName("az")
	int[] field2046;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Ljl;"
	)
	Clips field2047;

	@ObfuscatedSignature(
		descriptor = "(Ljl;)V"
	)
	class228(Clips var1) {
		this.field2045 = false;
		this.field2044 = false;
		this.field2046 = Rasterizer3D.Rasterizer3D_colorPalette;
		this.field2047 = var1;
	}

	@ObfuscatedName("au")
	void method1220(int[] var1, int var2, int var3, float[] var4) {
		Rasterizer2D.method2620(var1, var2, var3, var4);
	}

	@ObfuscatedName("at")
	void method1223(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, byte var13, byte var14, byte var15, byte var16) {
		var10 = method1221(var10, var13, var14, var15, var16);
		var11 = method1221(var11, var13, var14, var15, var16);
		var12 = method1221(var12, var13, var14, var15, var16);
		this.vmethod1374(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
	}

	@ObfuscatedName("ac")
	void method1224(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, byte var11, byte var12, byte var13, byte var14) {
		int var15 = method1221(var10, var11, var12, var13, var14);
		var10 = this.field2046[var15];
		this.vmethod1366(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
	}

	@ObfuscatedName("ai")
	@Export("vmethod1374")
	abstract void vmethod1374(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12);

	@ObfuscatedName("az")
	@Export("vmethod1366")
	abstract void vmethod1366(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10);

	@ObfuscatedName("ap")
	@Export("vmethod1378")
	abstract void vmethod1378(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22);

	@ObfuscatedName("aa")
	@Export("vmethod1362")
	abstract void vmethod1362(int var1, int var2, int var3, int var4, int var5, int var6, float var7, float var8, float var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21, int var22);

	@ObfuscatedName("ae")
	static int method1221(int var0, byte var1, byte var2, byte var3, byte var4) {
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

	@ObfuscatedName("ao")
	static final int method1222(int var0, int var1) {
		var1 = (var0 & 127) * var1 >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}
}