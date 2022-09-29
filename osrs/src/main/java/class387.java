import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
public class class387 {
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "Ler;"
	)
	static ClanChannel field4426;
	@ObfuscatedName("c")
	float field4423;
	@ObfuscatedName("p")
	float field4424;
	@ObfuscatedName("f")
	float field4425;

	static {
		new class387(0.0F, 0.0F, 0.0F);
		new class387(1.0F, 1.0F, 1.0F);
		new class387(1.0F, 0.0F, 0.0F);
		new class387(0.0F, 1.0F, 0.0F);
		new class387(0.0F, 0.0F, 1.0F);
		FloorOverlayDefinition.method3912(100);
	}

	class387(float var1, float var2, float var3) {
		this.field4423 = var1;
		this.field4424 = var2;
		this.field4425 = var3;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)F",
		garbageValue = "-980077570"
	)
	final float method7130() {
		return (float)Math.sqrt((double)(this.field4423 * this.field4423 + this.field4424 * this.field4424 + this.field4425 * this.field4425));
	}

	public String toString() {
		return this.field4423 + ", " + this.field4424 + ", " + this.field4425;
	}
}
