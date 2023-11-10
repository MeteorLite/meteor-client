import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sp")
public class class488 extends class491 {
	@ObfuscatedName("at")
	int field3989;
	@ObfuscatedName("ah")
	int field3988;
	@ObfuscatedName("ar")
	double field3986;
	@ObfuscatedName("ao")
	double field3985;
	@ObfuscatedName("ab")
	double field3984;
	@ObfuscatedName("au")
	double field3987;
	@ObfuscatedName("aa")
	double field3983;

	public class488(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		super(var9, var10);
		this.field3989 = 0;
		this.field3988 = 0;
		this.field3986 = 0.0D;
		this.field3985 = 0.0D;
		this.field3984 = 0.0D;
		this.field3987 = 0.0D;
		this.field3983 = 0.0D;
		this.field3989 = var3;
		this.field3988 = var6;
		if ((var5 - var8) * (var7 - var1) == (var4 - var7) * (var8 - var2)) {
			this.field3986 = (double)var4;
			this.field3985 = (double)var5;
		} else {
			double var11 = (double)((float)(var7 + var1)) / 2.0D;
			double var13 = (double)((float)(var8 + var2)) / 2.0D;
			double var15 = (double)((float)(var4 + var7)) / 2.0D;
			double var17 = (double)((float)(var5 + var8)) / 2.0D;
			double var19 = (double)(var7 - var1) * -1.0D / (double)(var8 - var2);
			double var21 = (double)(var4 - var7) * -1.0D / (double)(var5 - var8);
			this.field3986 = (var19 * var11 - var21 * var15 + var17 - var13) / (var19 - var21);
			this.field3985 = var13 + var19 * (this.field3986 - var11);
			this.field3984 = Math.sqrt(Math.pow(this.field3986 - (double)var1, 2.0D) + Math.pow(this.field3985 - (double)var2, 2.0D));
			this.field3987 = Math.atan2((double)var2 - this.field3985, (double)var1 - this.field3986);
			double var23 = Math.atan2((double)var8 - this.field3985, (double)var7 - this.field3986);
			this.field3983 = Math.atan2((double)var5 - this.field3985, (double)var4 - this.field3986);
			boolean var25 = this.field3987 <= var23 && var23 <= this.field3983 || this.field3983 <= var23 && var23 <= this.field3987;
			if (!var25) {
				this.field3983 += (double)(this.field3987 - this.field3983 > 0.0D ? 2 : -2) * 3.141592653589793D;
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "2"
	)
	public int vmethod2386() {
		double var1 = this.method2390();
		double var3 = this.field3987 + var1 * (this.field3983 - this.field3987);
		return (int)Math.round(this.field3986 + this.field3984 * Math.cos(var3));
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "124"
	)
	public int vmethod2387() {
		double var1 = this.method2390();
		double var3 = var1 * (this.field3983 - this.field3987) + this.field3987;
		return (int)Math.round(this.field3985 + this.field3984 * Math.sin(var3));
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1254922863"
	)
	@Export("vmethod2320")
	public int vmethod2320() {
		double var1 = this.method2390();
		return (int)Math.round((double)this.field3989 + var1 * (double)(this.field3988 - this.field3989));
	}
}