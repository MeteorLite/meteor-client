import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pu")
public class class395 {
	@ObfuscatedName("au")
	int field3678;

	@ObfuscatedSignature(
		descriptor = "(IZ)V",
		garbageValue = "1"
	)
	class395(int var1, boolean var2) {
		this.field3678 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "28670"
	)
	public int method2078() {
		return this.field3678;
	}
}