import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rz")
public class class466 {
	@ObfuscatedName("ac")
	float field3911;
	@ObfuscatedName("al")
	float field3915;
	@ObfuscatedName("ak")
	float field3914;
	@ObfuscatedName("ax")
	float field3920;
	@ObfuscatedName("ao")
	float field3917;
	@ObfuscatedName("ah")
	float field3913;
	@ObfuscatedName("ar")
	float field3918;
	@ObfuscatedName("ab")
	float field3910;
	@ObfuscatedName("am")
	float field3916;
	@ObfuscatedName("av")
	float field3919;
	@ObfuscatedName("ag")
	float field3912;
	@ObfuscatedName("aa")
	float field3909;

	static {
		new class466();
	}

	class466() {
		this.method2352();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1690063443"
	)
	void method2352() {
		this.field3909 = 0.0F;
		this.field3912 = 0.0F;
		this.field3919 = 0.0F;
		this.field3910 = 0.0F;
		this.field3918 = 0.0F;
		this.field3913 = 0.0F;
		this.field3920 = 0.0F;
		this.field3914 = 0.0F;
		this.field3915 = 0.0F;
		this.field3916 = 1.0F;
		this.field3917 = 1.0F;
		this.field3911 = 1.0F;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "-16"
	)
	void method2353(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3915;
		float var5 = this.field3917;
		float var6 = this.field3910;
		float var7 = this.field3912;
		this.field3915 = var2 * var4 - var3 * this.field3914;
		this.field3914 = var3 * var4 + var2 * this.field3914;
		this.field3917 = var2 * var5 - this.field3913 * var3;
		this.field3913 = var5 * var3 + var2 * this.field3913;
		this.field3910 = var2 * var6 - this.field3916 * var3;
		this.field3916 = var6 * var3 + this.field3916 * var2;
		this.field3912 = var7 * var2 - this.field3909 * var3;
		this.field3909 = var3 * var7 + this.field3909 * var2;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "121"
	)
	void method2354(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3911;
		float var5 = this.field3920;
		float var6 = this.field3918;
		float var7 = this.field3919;
		this.field3911 = var3 * this.field3914 + var2 * var4;
		this.field3914 = var2 * this.field3914 - var4 * var3;
		this.field3920 = var5 * var2 + var3 * this.field3913;
		this.field3913 = var2 * this.field3913 - var5 * var3;
		this.field3918 = var6 * var2 + var3 * this.field3916;
		this.field3916 = var2 * this.field3916 - var6 * var3;
		this.field3919 = this.field3909 * var3 + var7 * var2;
		this.field3909 = this.field3909 * var2 - var3 * var7;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "1352671223"
	)
	void method2355(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3911;
		float var5 = this.field3920;
		float var6 = this.field3918;
		float var7 = this.field3919;
		this.field3911 = var2 * var4 - var3 * this.field3915;
		this.field3915 = var3 * var4 + this.field3915 * var2;
		this.field3920 = var5 * var2 - this.field3917 * var3;
		this.field3917 = var5 * var3 + var2 * this.field3917;
		this.field3918 = var6 * var2 - this.field3910 * var3;
		this.field3910 = var6 * var3 + this.field3910 * var2;
		this.field3919 = var7 * var2 - var3 * this.field3912;
		this.field3912 = var3 * var7 + var2 * this.field3912;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "1852296601"
	)
	void method2356(float var1, float var2, float var3) {
		this.field3919 += var1;
		this.field3912 += var2;
		this.field3909 += var3;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3911 + "," + this.field3920 + "," + this.field3918 + "," + this.field3919 + "\n" + this.field3915 + "," + this.field3917 + "," + this.field3910 + "," + this.field3912 + "\n" + this.field3914 + "," + this.field3913 + "," + this.field3916 + "," + this.field3909;
	}
}