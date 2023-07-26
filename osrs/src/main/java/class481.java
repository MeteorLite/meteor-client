import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sk")
public abstract class class481 {
	@ObfuscatedName("az")
	int field3961;
	@ObfuscatedName("av")
	int field3960;
	@ObfuscatedName("ap")
	double field3958;
	@ObfuscatedName("aq")
	int field3959;

	class481(int var1, int var2) {
		this.field3961 = 0;
		this.field3960 = 0;
		this.field3958 = 0.0D;
		this.field3959 = 0;
		this.field3961 = var1;
		this.field3960 = 0;
		this.field3959 = var2 >= 0 && var2 <= 27 ? var2 : 0;
		this.field3958 = class339.method1823(this.field3960, this.field3961, this.field3959);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1393993433"
	)
	public void method2351() {
		if (this.field3960 < this.field3961) {
			++this.field3960;
			this.field3958 = class339.method1823(this.field3960, this.field3961, this.field3959);
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "-116783534"
	)
	double method2352() {
		return this.field3958;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SB)V",
		garbageValue = "7"
	)
	public static void method2350(String[] var0, short[] var1) {
		class215.sortItemsByName(var0, var1, 0, var0.length - 1);
	}
}
