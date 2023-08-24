import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sc")
public abstract class class480 {
	@ObfuscatedName("gv")
	@Export("worldPort")
	static int worldPort;
	@ObfuscatedName("ap")
	int field3974;
	@ObfuscatedName("aa")
	int field3972;
	@ObfuscatedName("af")
	double field3971;
	@ObfuscatedName("ad")
	int field3973;

	class480(int var1, int var2) {
		this.field3974 = 0;
		this.field3972 = 0;
		this.field3971 = 0.0D;
		this.field3973 = 0;
		this.field3974 = var1;
		this.field3972 = 0;
		this.field3973 = var2 >= 0 && var2 <= 27 ? var2 : 0;
		this.field3971 = class302.method1623(this.field3972, this.field3974, this.field3973);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-299202193"
	)
	public void method2376() {
		if (this.field3972 < this.field3974) {
			++this.field3972;
			this.field3971 = class302.method1623(this.field3972, this.field3974, this.field3973);
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "1467440127"
	)
	double method2377() {
		return this.field3971;
	}
}