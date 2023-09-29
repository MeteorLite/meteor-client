import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rd")
public final class class464 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lrd;"
	)
	static class464[] field3898;
	@ObfuscatedName("al")
	static int field3897;
	@ObfuscatedName("ak")
	static int field3896;
	@ObfuscatedName("ax")
	float field3902;
	@ObfuscatedName("ao")
	float field3900;
	@ObfuscatedName("ah")
	float field3899;
	@ObfuscatedName("ar")
	float field3901;

	static {
		field3898 = new class464[0];
		class146.method768(100);
		new class464();
	}

	class464() {
		this.method2333();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1744815510"
	)
	public void method2330() {
		synchronized(field3898) {
			if (field3896 < field3897 - 1) {
				field3898[++field3896 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "1915313855"
	)
	void method2331(float var1, float var2, float var3, float var4) {
		this.field3902 = var1;
		this.field3900 = var2;
		this.field3899 = var3;
		this.field3901 = var4;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "-1238110919"
	)
	public void method2332(float var1, float var2, float var3, float var4) {
		float var5 = (float)Math.sin((double)(0.5F * var4));
		float var6 = (float)Math.cos((double)(0.5F * var4));
		this.field3902 = var1 * var5;
		this.field3900 = var5 * var2;
		this.field3899 = var5 * var3;
		this.field3901 = var6;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "33554432"
	)
	final void method2333() {
		this.field3899 = 0.0F;
		this.field3900 = 0.0F;
		this.field3902 = 0.0F;
		this.field3901 = 1.0F;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lrd;I)V",
		garbageValue = "255330704"
	)
	public final void method2334(class464 var1) {
		this.method2331(this.field3901 * var1.field3902 + this.field3902 * var1.field3901 + var1.field3900 * this.field3899 - var1.field3899 * this.field3900, this.field3902 * var1.field3899 + this.field3901 * var1.field3900 + (this.field3900 * var1.field3901 - this.field3899 * var1.field3902), var1.field3899 * this.field3901 + (var1.field3901 * this.field3899 + this.field3900 * var1.field3902 - this.field3902 * var1.field3900), var1.field3901 * this.field3901 - this.field3902 * var1.field3902 - var1.field3900 * this.field3900 - var1.field3899 * this.field3899);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class464)) {
			return false;
		} else {
			class464 var2 = (class464)var1;
			return this.field3902 == var2.field3902 && var2.field3900 == this.field3900 && this.field3899 == var2.field3899 && this.field3901 == var2.field3901;
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = this.field3902 + var2 * 31.0F;
		var2 = this.field3900 + var2 * 31.0F;
		var2 = 31.0F * var2 + this.field3899;
		var2 = this.field3901 + var2 * 31.0F;
		return (int)var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3902 + "," + this.field3900 + "," + this.field3899 + "," + this.field3901;
	}
}