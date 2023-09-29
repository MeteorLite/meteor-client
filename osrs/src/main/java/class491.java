import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("so")
public class class491 extends class494 {
	@ObfuscatedName("aq")
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("ac")
	int field3992;
	@ObfuscatedName("al")
	int field3993;
	@ObfuscatedName("ak")
	double field3988;
	@ObfuscatedName("ax")
	double field3991;
	@ObfuscatedName("ao")
	double field3989;
	@ObfuscatedName("ah")
	double field3987;
	@ObfuscatedName("ar")
	double field3990;

	public class491(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		super(var9, var10);
		this.field3992 = 0;
		this.field3993 = 0;
		this.field3988 = 0.0D;
		this.field3991 = 0.0D;
		this.field3989 = 0.0D;
		this.field3987 = 0.0D;
		this.field3990 = 0.0D;
		this.field3992 = var3;
		this.field3993 = var6;
		if ((var5 - var8) * (var7 - var1) == (var4 - var7) * (var8 - var2)) {
			this.field3988 = (double)var4;
			this.field3991 = (double)var5;
		} else {
			double var11 = (double)((float)(var7 + var1)) / 2.0D;
			double var13 = (double)((float)(var8 + var2)) / 2.0D;
			double var15 = (double)((float)(var4 + var7)) / 2.0D;
			double var17 = (double)((float)(var5 + var8)) / 2.0D;
			double var19 = -1.0D * (double)(var7 - var1) / (double)(var8 - var2);
			double var21 = (double)(var4 - var7) * -1.0D / (double)(var5 - var8);
			this.field3988 = (var19 * var11 - var21 * var15 + var17 - var13) / (var19 - var21);
			this.field3991 = var13 + (this.field3988 - var11) * var19;
			this.field3989 = Math.sqrt(Math.pow(this.field3988 - (double)var1, 2.0D) + Math.pow(this.field3991 - (double)var2, 2.0D));
			this.field3987 = Math.atan2((double)var2 - this.field3991, (double)var1 - this.field3988);
			double var23 = Math.atan2((double)var8 - this.field3991, (double)var7 - this.field3988);
			this.field3990 = Math.atan2((double)var5 - this.field3991, (double)var4 - this.field3988);
			boolean var25 = this.field3987 <= var23 && var23 <= this.field3990 || this.field3990 <= var23 && var23 <= this.field3987;
			if (!var25) {
				this.field3990 += 3.141592653589793D * (double)(this.field3987 - this.field3990 > 0.0D ? 2 : -2);
			}

		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-437522182"
	)
	public int vmethod2349() {
		double var1 = this.method2414();
		double var3 = this.field3987 + var1 * (this.field3990 - this.field3987);
		return (int)Math.round(this.field3988 + this.field3989 * Math.cos(var3));
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1670157872"
	)
	public int vmethod2347() {
		double var1 = this.method2414();
		double var3 = (this.field3990 - this.field3987) * var1 + this.field3987;
		return (int)Math.round(this.field3991 + this.field3989 * Math.sin(var3));
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "54"
	)
	@Export("vmethod2320")
	public int vmethod2320() {
		double var1 = this.method2414();
		return (int)Math.round(var1 * (double)(this.field3993 - this.field3992) + (double)this.field3992);
	}
}