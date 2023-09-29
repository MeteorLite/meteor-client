import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("vz")
public class class547 {
	@ObfuscatedName("al")
	int field4291;
	@ObfuscatedName("ak")
	int field4290;
	@ObfuscatedName("ax")
	int field4296;
	@ObfuscatedName("ao")
	int field4293;
	@ObfuscatedName("ah")
	int field4289;
	@ObfuscatedName("ar")
	int field4295;
	@ObfuscatedName("ab")
	int field4287;
	@ObfuscatedName("am")
	int field4292;
	@ObfuscatedName("av")
	boolean field4285;
	@ObfuscatedName("ag")
	int field4288;
	@ObfuscatedName("aa")
	int field4286;
	@ObfuscatedName("ap")
	int field4294;
	@ObfuscatedName("ay")
	int field4297;

	public class547() {
		this.field4287 = 0;
		this.field4292 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIZI)V",
		garbageValue = "-1556835629"
	)
	public void method2734(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
		this.field4291 = var1;
		this.field4290 = var2;
		this.field4296 = var3;
		this.field4293 = var4;
		this.field4289 = var5;
		this.field4295 = var6;
		this.field4287 = var7;
		this.field4292 = var8;
		this.field4285 = var9;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "826854600"
	)
	public void method2735(int var1, int var2, int var3, int var4) {
		this.field4288 = var1;
		this.field4286 = var2;
		this.field4294 = var3;
		this.field4297 = var4;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lpp;Lpu;B)V",
		garbageValue = "0"
	)
	public void method2736(class409 var1, Font var2) {
		if (var2 != null) {
			int var3 = var2.ascent;
			int var4 = Math.min(this.field4293, (int)(0.9F * (float)var3));
			int var5 = var1.method2097(this.field4296);
			int var6 = var1.method2098(this.field4293);
			int var7 = var5 + (this.field4291 - this.field4289);
			int var8 = var6 + var3 + (this.field4290 - this.field4295);
			Rasterizer2D.Rasterizer2D_setClip(this.field4291, this.field4290, this.field4296 + this.field4291, this.field4293 + this.field4290);
			int var9 = this.field4292;
			int var10 = this.field4287;
			if (var9 > var10) {
				int var11 = var9;
				var9 = var10;
				var10 = var11;
			}

			class413 var21 = var1.method2078(0, var9);
			class413 var12 = var1.method2078(var9, var10);
			class413 var13 = var1.method2078(var10, var1.method2069());
			class413 var14 = var1.method2078(0, this.field4287);
			int var16;
			int var18;
			if (!var12.method2147()) {
				int var15 = var2.maxAscent + var2.maxDescent;

				for (var16 = 0; var16 < var12.method2148(); ++var16) {
					class411 var17 = var12.method2152(var16);
					var18 = var7 + var17.field3715;
					int var19 = var2.charWidth(var17.field3713);
					int var20 = var8 + var17.field3714 - var3;
					Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4297);
				}
			}

			if (!var21.method2147()) {
				var2.method2126(var21, var7, var8, this.field4288, this.field4286, -1);
			}

			if (!var12.method2147()) {
				var2.method2126(var12, var7, var8, this.field4294, this.field4286, -1);
			}

			if (!var13.method2147()) {
				var2.method2126(var13, var7, var8, this.field4288, this.field4286, -1);
			}

			if (this.field4285) {
				class500 var22 = var14.method2151();
				var16 = var7 + (Integer)var22.field4079;
				int var23 = var8 + (Integer)var22.field4080;
				var18 = var23 - var4;
				Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4288);
				if (this.field4286 != -1) {
					Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4286);
				}
			}

		}
	}
}