import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ry")
public class class465 {
	@ObfuscatedName("as")
	static final int[] field3896;
	@ObfuscatedName("aj")
	static final int[] field3895;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	static IndexedSprite field3894;

	static {
		field3896 = new int[16384];
		field3895 = new int[16384];
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field3896[var2] = (int)(16384.0D * Math.sin(var0 * (double)var2));
			field3895[var2] = (int)(16384.0D * Math.cos(var0 * (double)var2));
		}

	}
}
