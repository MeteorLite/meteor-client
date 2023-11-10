import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("sc")
public class class476 {
	@ObfuscatedName("ab")
	static final int[] field3936;
	@ObfuscatedName("au")
	static final int[] field3937;

	static {
		field3936 = new int[16384];
		field3937 = new int[16384];
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field3936[var2] = (int)(16384.0D * Math.sin((double)var2 * var0));
			field3937[var2] = (int)(16384.0D * Math.cos((double)var2 * var0));
		}

	}
}