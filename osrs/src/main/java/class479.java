import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ss")
public class class479 extends class481 {
	@ObfuscatedName("aw")
	int field3956;
	@ObfuscatedName("ay")
	int field3957;

	public class479(int var1, int var2, int var3, int var4) {
		super(var3, var4);
		this.field3956 = 0;
		this.field3957 = 0;
		this.field3956 = var1;
		this.field3957 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-84"
	)
	public int method2346() {
		double var1 = this.method2352();
		return (int)Math.round(var1 * (double)(this.field3957 - this.field3956) + (double)this.field3956);
	}
}
