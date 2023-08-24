import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
public class class451 {
	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		descriptor = "[Luk;"
	)
	static IndexedSprite[] field3876;
	@ObfuscatedName("au")
	float field3887;
	@ObfuscatedName("ae")
	float field3880;
	@ObfuscatedName("ao")
	float field3883;
	@ObfuscatedName("at")
	float field3886;
	@ObfuscatedName("ac")
	float field3878;
	@ObfuscatedName("ai")
	float field3882;
	@ObfuscatedName("az")
	float field3888;
	@ObfuscatedName("ap")
	float field3884;
	@ObfuscatedName("aa")
	float field3877;
	@ObfuscatedName("af")
	float field3881;
	@ObfuscatedName("ad")
	float field3879;
	@ObfuscatedName("aq")
	float field3885;

	static {
		new class451();
	}

	class451() {
		this.method2314();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1136613952"
	)
	void method2314() {
		this.field3885 = 0.0F;
		this.field3879 = 0.0F;
		this.field3881 = 0.0F;
		this.field3884 = 0.0F;
		this.field3888 = 0.0F;
		this.field3882 = 0.0F;
		this.field3886 = 0.0F;
		this.field3883 = 0.0F;
		this.field3880 = 0.0F;
		this.field3877 = 1.0F;
		this.field3878 = 1.0F;
		this.field3887 = 1.0F;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "-67"
	)
	void method2315(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3880;
		float var5 = this.field3878;
		float var6 = this.field3884;
		float var7 = this.field3879;
		this.field3880 = var4 * var2 - var3 * this.field3883;
		this.field3883 = var2 * this.field3883 + var4 * var3;
		this.field3878 = var5 * var2 - this.field3882 * var3;
		this.field3882 = var5 * var3 + this.field3882 * var2;
		this.field3884 = var2 * var6 - var3 * this.field3877;
		this.field3877 = var6 * var3 + this.field3877 * var2;
		this.field3879 = var2 * var7 - var3 * this.field3885;
		this.field3885 = var7 * var3 + this.field3885 * var2;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "0"
	)
	void method2316(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3887;
		float var5 = this.field3886;
		float var6 = this.field3888;
		float var7 = this.field3881;
		this.field3887 = var3 * this.field3883 + var2 * var4;
		this.field3883 = this.field3883 * var2 - var4 * var3;
		this.field3886 = var3 * this.field3882 + var2 * var5;
		this.field3882 = this.field3882 * var2 - var3 * var5;
		this.field3888 = var6 * var2 + this.field3877 * var3;
		this.field3877 = this.field3877 * var2 - var3 * var6;
		this.field3881 = var2 * var7 + this.field3885 * var3;
		this.field3885 = this.field3885 * var2 - var7 * var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "-2078210991"
	)
	void method2317(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3887;
		float var5 = this.field3886;
		float var6 = this.field3888;
		float var7 = this.field3881;
		this.field3887 = var2 * var4 - var3 * this.field3880;
		this.field3880 = var2 * this.field3880 + var3 * var4;
		this.field3886 = var5 * var2 - var3 * this.field3878;
		this.field3878 = var3 * var5 + var2 * this.field3878;
		this.field3888 = var2 * var6 - var3 * this.field3884;
		this.field3884 = this.field3884 * var2 + var3 * var6;
		this.field3881 = var2 * var7 - this.field3879 * var3;
		this.field3879 = this.field3879 * var2 + var7 * var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "-586193895"
	)
	void method2318(float var1, float var2, float var3) {
		this.field3881 += var1;
		this.field3879 += var2;
		this.field3885 += var3;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3887 + "," + this.field3886 + "," + this.field3888 + "," + this.field3881 + "\n" + this.field3880 + "," + this.field3878 + "," + this.field3884 + "," + this.field3879 + "\n" + this.field3883 + "," + this.field3882 + "," + this.field3877 + "," + this.field3885;
	}
}