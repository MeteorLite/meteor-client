import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ri")
public class class449 {
	@ObfuscatedName("aw")
	float field3849;
	@ObfuscatedName("ay")
	float field3850;
	@ObfuscatedName("ar")
	float field3848;

	static {
		new class449(0.0F, 0.0F, 0.0F);
		new class449(1.0F, 1.0F, 1.0F);
		new class449(1.0F, 0.0F, 0.0F);
		new class449(0.0F, 1.0F, 0.0F);
		new class449(0.0F, 0.0F, 1.0F);
	}

	class449(float var1, float var2, float var3) {
		this.field3849 = var1;
		this.field3850 = var2;
		this.field3848 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)F",
		garbageValue = "-57"
	)
	final float method2264() {
		return (float)Math.sqrt((double)(this.field3849 * this.field3849 + this.field3850 * this.field3850 + this.field3848 * this.field3848));
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3849 + ", " + this.field3850 + ", " + this.field3848;
	}
}
