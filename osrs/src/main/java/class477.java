import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sc")
public class class477 extends class480 {
	@ObfuscatedName("aw")
	int field3948;
	@ObfuscatedName("ay")
	int field3949;
	@ObfuscatedName("ar")
	double field3946;
	@ObfuscatedName("am")
	double field3945;
	@ObfuscatedName("as")
	double field3947;
	@ObfuscatedName("aj")
	double field3944;
	@ObfuscatedName("ag")
	double field3943;

	public class477(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		super(var9, var10);
		this.field3948 = 0;
		this.field3949 = 0;
		this.field3946 = 0.0D;
		this.field3945 = 0.0D;
		this.field3947 = 0.0D;
		this.field3944 = 0.0D;
		this.field3943 = 0.0D;
		this.field3948 = var3;
		this.field3949 = var6;
		if ((var5 - var8) * (var7 - var1) == (var4 - var7) * (var8 - var2)) {
			this.field3946 = (double)var4;
			this.field3945 = (double)var5;
		} else {
			double var11 = (double)((float)(var7 + var1)) / 2.0D;
			double var13 = (double)((float)(var8 + var2)) / 2.0D;
			double var15 = (double)((float)(var4 + var7)) / 2.0D;
			double var17 = (double)((float)(var5 + var8)) / 2.0D;
			double var19 = (double)(var7 - var1) * -1.0D / (double)(var8 - var2);
			double var21 = (double)(var4 - var7) * -1.0D / (double)(var5 - var8);
			this.field3946 = (var11 * var19 - var15 * var21 + var17 - var13) / (var19 - var21);
			this.field3945 = var13 + (this.field3946 - var11) * var19;
			this.field3947 = Math.sqrt(Math.pow(this.field3946 - (double)var1, 2.0D) + Math.pow(this.field3945 - (double)var2, 2.0D));
			this.field3944 = Math.atan2((double)var2 - this.field3945, (double)var1 - this.field3946);
			double var23 = Math.atan2((double)var8 - this.field3945, (double)var7 - this.field3946);
			this.field3943 = Math.atan2((double)var5 - this.field3945, (double)var4 - this.field3946);
			boolean var25 = this.field3944 <= var23 && var23 <= this.field3943 || this.field3943 <= var23 && var23 <= this.field3944;
			if (!var25) {
				this.field3943 += 3.141592653589793D * (double)(this.field3944 - this.field3943 > 0.0D ? 2 : -2);
			}

		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "2587"
	)
	public int vmethod2349() {
		double var1 = this.method2352();
		double var3 = this.field3944 + (this.field3943 - this.field3944) * var1;
		return (int)Math.round(this.field3946 + this.field3947 * Math.cos(var3));
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1657628972"
	)
	public int vmethod2347() {
		double var1 = this.method2352();
		double var3 = (this.field3943 - this.field3944) * var1 + this.field3944;
		return (int)Math.round(this.field3945 + this.field3947 * Math.sin(var3));
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "10605"
	)
	@Export("vmethod2320")
	public int vmethod2320() {
		double var1 = this.method2352();
		return (int)Math.round((double)this.field3948 + var1 * (double)(this.field3949 - this.field3948));
	}

	@ObfuscatedName("oe")
	@ObfuscatedSignature(
		descriptor = "(II)Ltx;",
		garbageValue = "522363485"
	)
	static class507 method2342(int var0) {
		class507 var1 = (class507)Client.Widget_cachedModels.get((long)var0);
		if (var1 == null) {
			var1 = new class507(class176.field1459, ViewportMouse.method1319(var0), Message.method337(var0));
			Client.Widget_cachedModels.put(var1, (long)var0);
		}

		return var1;
	}
}
