import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sd")
public class class478 extends class480 {
	@ObfuscatedName("aw")
	int field3954;
	@ObfuscatedName("ay")
	int field3955;
	@ObfuscatedName("ar")
	int field3952;
	@ObfuscatedName("am")
	int field3951;
	@ObfuscatedName("as")
	int field3953;
	@ObfuscatedName("aj")
	int field3950;

	public class478(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		super(var7, var8);
		this.field3954 = 0;
		this.field3955 = 0;
		this.field3952 = 0;
		this.field3951 = 0;
		this.field3953 = 0;
		this.field3950 = 0;
		this.field3954 = var1;
		this.field3955 = var2;
		this.field3952 = var3;
		this.field3951 = var4;
		this.field3953 = var5;
		this.field3950 = var6;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "2587"
	)
	public int vmethod2349() {
		double var1 = this.method2352();
		return (int)Math.round((double)this.field3954 + (double)(this.field3951 - this.field3954) * var1);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1657628972"
	)
	public int vmethod2347() {
		double var1 = this.method2352();
		return (int)Math.round(var1 * (double)(this.field3953 - this.field3955) + (double)this.field3955);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "10605"
	)
	public int vmethod2320() {
		double var1 = this.method2352();
		return (int)Math.round(var1 * (double)(this.field3950 - this.field3952) + (double)this.field3952);
	}
}
