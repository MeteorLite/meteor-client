import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("se")
public class class476 extends class479 {
	@ObfuscatedName("au")
	int field3961;
	@ObfuscatedName("ae")
	int field3960;
	@ObfuscatedName("ao")
	double field3957;
	@ObfuscatedName("at")
	double field3958;
	@ObfuscatedName("ac")
	double field3955;
	@ObfuscatedName("ai")
	double field3956;
	@ObfuscatedName("az")
	double field3959;

	public class476(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		super(var9, var10);
		this.field3961 = 0;
		this.field3960 = 0;
		this.field3957 = 0.0D;
		this.field3958 = 0.0D;
		this.field3955 = 0.0D;
		this.field3956 = 0.0D;
		this.field3959 = 0.0D;
		this.field3961 = var3;
		this.field3960 = var6;
		if ((var5 - var8) * (var7 - var1) == (var4 - var7) * (var8 - var2)) {
			this.field3957 = (double)var4;
			this.field3958 = (double)var5;
		} else {
			double var11 = (double)((float)(var7 + var1)) / 2.0D;
			double var13 = (double)((float)(var8 + var2)) / 2.0D;
			double var15 = (double)((float)(var4 + var7)) / 2.0D;
			double var17 = (double)((float)(var5 + var8)) / 2.0D;
			double var19 = -1.0D * (double)(var7 - var1) / (double)(var8 - var2);
			double var21 = (double)(var4 - var7) * -1.0D / (double)(var5 - var8);
			this.field3957 = (var19 * var11 - var21 * var15 + var17 - var13) / (var19 - var21);
			this.field3958 = var13 + var19 * (this.field3957 - var11);
			this.field3955 = Math.sqrt(Math.pow(this.field3957 - (double)var1, 2.0D) + Math.pow(this.field3958 - (double)var2, 2.0D));
			this.field3956 = Math.atan2((double)var2 - this.field3958, (double)var1 - this.field3957);
			double var23 = Math.atan2((double)var8 - this.field3958, (double)var7 - this.field3957);
			this.field3959 = Math.atan2((double)var5 - this.field3958, (double)var4 - this.field3957);
			boolean var25 = this.field3956 <= var23 && var23 <= this.field3959 || this.field3959 <= var23 && var23 <= this.field3956;
			if (!var25) {
				this.field3959 += (double)(this.field3956 - this.field3959 > 0.0D ? 2 : -2) * 3.141592653589793D;
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "818000115"
	)
	public int vmethod2349() {
		double var1 = this.method2377();
		double var3 = this.field3956 + (this.field3959 - this.field3956) * var1;
		return (int)Math.round(this.field3957 + this.field3955 * Math.cos(var3));
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "363084355"
	)
	public int vmethod2347() {
		double var1 = this.method2377();
		double var3 = this.field3956 + var1 * (this.field3959 - this.field3956);
		return (int)Math.round(this.field3958 + this.field3955 * Math.sin(var3));
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1706544959"
	)
	@Export("vmethod2320")
	public int vmethod2320() {
		double var1 = this.method2377();
		return (int)Math.round((double)this.field3961 + var1 * (double)(this.field3960 - this.field3961));
	}
}