import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("so")
public abstract class class492 {
	@ObfuscatedName("ac")
	int field4000;
	@ObfuscatedName("al")
	int field4001;
	@ObfuscatedName("az")
	double field3999;
	@ObfuscatedName("ap")
	int field4002;

	class492(int var1, int var2) {
		this.field4000 = 0;
		this.field4001 = 0;
		this.field3999 = 0.0D;
		this.field4002 = 0;
		this.field4000 = var1;
		this.field4001 = 0;
		this.field4002 = var2 >= 0 && var2 <= 27 ? var2 : 0;
		this.field3999 = PlayerType.method1907(this.field4001, this.field4000, this.field4002);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1511635495"
	)
	public void method2389() {
		if (this.field4001 < this.field4000) {
			++this.field4001;
			this.field3999 = PlayerType.method1907(this.field4001, this.field4000, this.field4002);
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)D",
		garbageValue = "-60"
	)
	double method2390() {
		return this.field3999;
	}
}