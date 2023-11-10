import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sm")
public class class490 extends class492 {
	@ObfuscatedName("at")
	int field3998;
	@ObfuscatedName("ah")
	int field3997;

	public class490(int var1, int var2, int var3, int var4) {
		super(var3, var4);
		this.field3998 = 0;
		this.field3997 = 0;
		this.field3998 = var1;
		this.field3997 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-287739597"
	)
	public int method2385() {
		double var1 = this.method2390();
		return (int)Math.round(var1 * (double)(this.field3997 - this.field3998) + (double)this.field3998);
	}
}