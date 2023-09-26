import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sp")
public class class493 extends class495 {
	@ObfuscatedName("ra")
	@ObfuscatedSignature(
		descriptor = "Lgc;"
	)
	@Export("mouseWheel")
	static class176 mouseWheel;
	@ObfuscatedName("ac")
	int field4001;
	@ObfuscatedName("al")
	int field4002;

	public class493(int var1, int var2, int var3, int var4) {
		super(var3, var4);
		this.field4001 = 0;
		this.field4002 = 0;
		this.field4001 = var1;
		this.field4002 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-502803957"
	)
	public int method2409() {
		double var1 = this.method2414();
		return (int)Math.round((double)this.field4001 + var1 * (double)(this.field4002 - this.field4001));
	}
}