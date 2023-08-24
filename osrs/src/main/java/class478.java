import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sy")
public class class478 extends class480 {
	@ObfuscatedName("au")
	int field3969;
	@ObfuscatedName("ae")
	int field3968;

	public class478(int var1, int var2, int var3, int var4) {
		super(var3, var4);
		this.field3969 = 0;
		this.field3968 = 0;
		this.field3969 = var1;
		this.field3968 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1901048798"
	)
	public int method2371() {
		double var1 = this.method2377();
		return (int)Math.round((double)this.field3969 + var1 * (double)(this.field3968 - this.field3969));
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-2077618476"
	)
	static void method2372(String var0) {
		Login.field764 = HorizontalAlignment.method977(var0);
	}
}