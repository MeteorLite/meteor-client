import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ro")
public final class class449 {
	@ObfuscatedName("wp")
	@ObfuscatedSignature(
		descriptor = "Ldp;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "[Lro;"
	)
	static class449[] field3868;
	@ObfuscatedName("ae")
	static int field3867;
	@ObfuscatedName("at")
	float field3871;
	@ObfuscatedName("ac")
	float field3869;
	@ObfuscatedName("ai")
	float field3870;
	@ObfuscatedName("az")
	float field3872;

	static {
		field3868 = new class449[0];
		GrandExchangeOffer.method1954(100);
		new class449();
	}

	class449() {
		this.method2296();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1516285968"
	)
	public void method2293() {
		synchronized(field3868) {
			if (class338.field3112 < field3867 - 1) {
				field3868[++class338.field3112 - 1] = this;
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "-426853069"
	)
	void method2294(float var1, float var2, float var3, float var4) {
		this.field3871 = var1;
		this.field3869 = var2;
		this.field3870 = var3;
		this.field3872 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "-49952444"
	)
	public void method2295(float var1, float var2, float var3, float var4) {
		float var5 = (float)Math.sin((double)(var4 * 0.5F));
		float var6 = (float)Math.cos((double)(var4 * 0.5F));
		this.field3871 = var5 * var1;
		this.field3869 = var2 * var5;
		this.field3870 = var5 * var3;
		this.field3872 = var6;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "61"
	)
	final void method2296() {
		this.field3870 = 0.0F;
		this.field3869 = 0.0F;
		this.field3871 = 0.0F;
		this.field3872 = 1.0F;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lro;B)V",
		garbageValue = "-34"
	)
	public final void method2297(class449 var1) {
		this.method2294(this.field3871 * var1.field3872 + this.field3872 * var1.field3871 + this.field3870 * var1.field3869 - this.field3869 * var1.field3870, var1.field3870 * this.field3871 + this.field3872 * var1.field3869 + (var1.field3872 * this.field3869 - this.field3870 * var1.field3871), var1.field3870 * this.field3872 + (this.field3870 * var1.field3872 + this.field3869 * var1.field3871 - var1.field3869 * this.field3871), this.field3872 * var1.field3872 - this.field3871 * var1.field3871 - this.field3869 * var1.field3869 - var1.field3870 * this.field3870);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class449)) {
			return false;
		} else {
			class449 var2 = (class449)var1;
			return var2.field3871 == this.field3871 && var2.field3869 == this.field3869 && var2.field3870 == this.field3870 && this.field3872 == var2.field3872;
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = this.field3871 + var2 * 31.0F;
		var2 = this.field3869 + var2 * 31.0F;
		var2 = this.field3870 + 31.0F * var2;
		var2 = this.field3872 + 31.0F * var2;
		return (int)var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3871 + "," + this.field3869 + "," + this.field3870 + "," + this.field3872;
	}
}