import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("uo")
public class class532 {
	@ObfuscatedName("ae")
	int field4262;
	@ObfuscatedName("ao")
	int field4266;
	@ObfuscatedName("at")
	int field4269;
	@ObfuscatedName("ac")
	int field4260;
	@ObfuscatedName("ai")
	int field4263;
	@ObfuscatedName("az")
	int field4270;
	@ObfuscatedName("ap")
	int field4267;
	@ObfuscatedName("aa")
	int field4259;
	@ObfuscatedName("af")
	boolean field4258;
	@ObfuscatedName("ad")
	int field4261;
	@ObfuscatedName("aq")
	int field4268;
	@ObfuscatedName("al")
	int field4264;
	@ObfuscatedName("an")
	int field4265;

	public class532() {
		this.field4267 = 0;
		this.field4259 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIZB)V",
		garbageValue = "115"
	)
	public void method2694(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
		this.field4262 = var1;
		this.field4266 = var2;
		this.field4269 = var3;
		this.field4260 = var4;
		this.field4263 = var5;
		this.field4270 = var6;
		this.field4267 = var7;
		this.field4259 = var8;
		this.field4258 = var9;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1659604987"
	)
	public void method2695(int var1, int var2, int var3, int var4) {
		this.field4261 = var1;
		this.field4268 = var2;
		this.field4264 = var3;
		this.field4265 = var4;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lpj;Lpi;B)V",
		garbageValue = "-101"
	)
	public void method2696(class394 var1, Font var2) {
		if (var2 != null) {
			int var3 = var2.ascent;
			int var4 = Math.min(this.field4260, (int)((float)var3 * 0.9F));
			int var5 = var1.method2069(this.field4269);
			int var6 = var1.method2070(this.field4260);
			int var7 = var5 + (this.field4262 - this.field4263);
			int var8 = var6 + var3 + (this.field4266 - this.field4270);
			Rasterizer2D.Rasterizer2D_setClip(this.field4262, this.field4266, this.field4262 + this.field4269, this.field4260 + this.field4266);
			int var9 = this.field4259;
			int var10 = this.field4267;
			if (var9 > var10) {
				int var11 = var9;
				var9 = var10;
				var10 = var11;
			}

			class398 var21 = var1.method2049(0, var9);
			class398 var12 = var1.method2049(var9, var10);
			class398 var13 = var1.method2049(var10, var1.method2040());
			class398 var14 = var1.method2049(0, this.field4267);
			int var16;
			int var18;
			if (!var12.method2115()) {
				int var15 = var2.maxAscent + var2.maxDescent;

				for (var16 = 0; var16 < var12.method2116(); ++var16) {
					class396 var17 = var12.method2120(var16);
					var18 = var7 + var17.field3681;
					int var19 = var2.charWidth(var17.field3680);
					int var20 = var8 + var17.field3682 - var3;
					Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4265);
				}
			}

			if (!var21.method2115()) {
				var2.method2094(var21, var7, var8, this.field4261, this.field4268, -1);
			}

			if (!var12.method2115()) {
				var2.method2094(var12, var7, var8, this.field4264, this.field4268, -1);
			}

			if (!var13.method2115()) {
				var2.method2094(var13, var7, var8, this.field4261, this.field4268, -1);
			}

			if (this.field4258) {
				class485 var22 = var14.method2119();
				var16 = var7 + (Integer)var22.field4049;
				int var23 = var8 + (Integer)var22.field4048;
				var18 = var23 - var4;
				Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4261);
				if (this.field4268 != -1) {
					Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4268);
				}
			}

		}
	}
}