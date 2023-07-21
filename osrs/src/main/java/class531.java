import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("um")
public class class531 {
	@ObfuscatedName("ay")
	int field4225;
	@ObfuscatedName("ar")
	int field4220;
	@ObfuscatedName("am")
	int field4218;
	@ObfuscatedName("as")
	int field4221;
	@ObfuscatedName("aj")
	int field4217;
	@ObfuscatedName("ag")
	int field4215;
	@ObfuscatedName("az")
	int field4226;
	@ObfuscatedName("av")
	int field4223;
	@ObfuscatedName("ap")
	boolean field4214;
	@ObfuscatedName("aq")
	int field4219;
	@ObfuscatedName("at")
	int field4222;
	@ObfuscatedName("ah")
	int field4216;
	@ObfuscatedName("ax")
	int field4224;

	public class531() {
		this.field4226 = 0;
		this.field4223 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIZI)V",
		garbageValue = "-1361284824"
	)
	public void method2675(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
		this.field4225 = var1;
		this.field4220 = var2;
		this.field4218 = var3;
		this.field4221 = var4;
		this.field4217 = var5;
		this.field4215 = var6;
		this.field4226 = var7;
		this.field4223 = var8;
		this.field4214 = var9;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "1931379058"
	)
	public void method2676(int var1, int var2, int var3, int var4) {
		this.field4219 = var1;
		this.field4222 = var2;
		this.field4216 = var3;
		this.field4224 = var4;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lpt;Lpc;I)V",
		garbageValue = "-1345335842"
	)
	public void method2677(class395 var1, Font var2) {
		if (var2 != null) {
			int var3 = var2.ascent;
			int var4 = Math.min(this.field4221, (int)((float)var3 * 0.9F));
			int var5 = var1.method2028(this.field4218);
			int var6 = var1.method2029(this.field4221);
			int var7 = var5 + (this.field4225 - this.field4217);
			int var8 = var3 + var6 + (this.field4220 - this.field4215);
			Rasterizer2D.Rasterizer2D_setClip(this.field4225, this.field4220, this.field4225 + this.field4218, this.field4220 + this.field4221);
			int var9 = this.field4223;
			int var10 = this.field4226;
			if (var9 > var10) {
				int var11 = var9;
				var9 = var10;
				var10 = var11;
			}

			class399 var21 = var1.method2008(0, var9);
			class399 var12 = var1.method2008(var9, var10);
			class399 var13 = var1.method2008(var10, var1.method1999());
			class399 var14 = var1.method2008(0, this.field4226);
			int var16;
			int var18;
			if (!var12.method2076()) {
				int var15 = var2.maxAscent + var2.maxDescent;

				for (var16 = 0; var16 < var12.method2077(); ++var16) {
					class397 var17 = var12.method2081(var16);
					var18 = var7 + var17.field3673;
					int var19 = var2.charWidth(var17.field3671);
					int var20 = var8 + var17.field3672 - var3;
					Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4224);
				}
			}

			if (!var21.method2076()) {
				var2.method2055(var21, var7, var8, this.field4219, this.field4222, -1);
			}

			if (!var12.method2076()) {
				var2.method2055(var12, var7, var8, this.field4216, this.field4222, -1);
			}

			if (!var13.method2076()) {
				var2.method2055(var13, var7, var8, this.field4219, this.field4222, -1);
			}

			if (this.field4214) {
				class486 var22 = var14.method2080();
				var16 = var7 + (Integer)var22.field4036;
				int var23 = var8 + (Integer)var22.field4037;
				var18 = var23 - var4;
				Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4219);
				if (this.field4222 != -1) {
					Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4222);
				}
			}

		}
	}
}
