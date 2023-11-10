import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rq")
public final class class461 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lrq;"
	)
	static class461[] field3900;
	@ObfuscatedName("ah")
	static int field3899;
	@ObfuscatedName("ao")
	float field3903;
	@ObfuscatedName("ab")
	float field3902;
	@ObfuscatedName("au")
	float field3904;
	@ObfuscatedName("aa")
	float field3901;

	static {
		field3900 = new class461[0];
		FontName.method2459(100);
		new class461();
	}

	class461() {
		this.method2312();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-905673513"
	)
	public void method2309() {
		synchronized(field3900) {
			if (IgnoreList.field3815 < field3899 - 1) {
				field3900[++IgnoreList.field3815 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "1133120924"
	)
	void method2310(float var1, float var2, float var3, float var4) {
		this.field3903 = var1;
		this.field3902 = var2;
		this.field3904 = var3;
		this.field3901 = var4;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "1735434078"
	)
	public void method2311(float var1, float var2, float var3, float var4) {
		float var5 = (float)Math.sin((double)(var4 * 0.5F));
		float var6 = (float)Math.cos((double)(0.5F * var4));
		this.field3903 = var1 * var5;
		this.field3902 = var5 * var2;
		this.field3904 = var3 * var5;
		this.field3901 = var6;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "210229291"
	)
	final void method2312() {
		this.field3904 = 0.0F;
		this.field3902 = 0.0F;
		this.field3903 = 0.0F;
		this.field3901 = 1.0F;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lrq;I)V",
		garbageValue = "992983838"
	)
	public final void method2313(class461 var1) {
		this.method2310(this.field3904 * var1.field3902 + var1.field3901 * this.field3903 + this.field3901 * var1.field3903 - var1.field3904 * this.field3902, var1.field3902 * this.field3901 + (this.field3902 * var1.field3901 - var1.field3903 * this.field3904) + this.field3903 * var1.field3904, this.field3901 * var1.field3904 + (var1.field3903 * this.field3902 + this.field3904 * var1.field3901 - this.field3903 * var1.field3902), var1.field3901 * this.field3901 - var1.field3903 * this.field3903 - var1.field3902 * this.field3902 - var1.field3904 * this.field3904);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class461)) {
			return false;
		} else {
			class461 var2 = (class461)var1;
			return var2.field3903 == this.field3903 && var2.field3902 == this.field3902 && this.field3904 == var2.field3904 && var2.field3901 == this.field3901;
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = 31.0F * var2 + this.field3903;
		var2 = this.field3902 + 31.0F * var2;
		var2 = 31.0F * var2 + this.field3904;
		var2 = this.field3901 + 31.0F * var2;
		return (int)var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3903 + "," + this.field3902 + "," + this.field3904 + "," + this.field3901;
	}
}