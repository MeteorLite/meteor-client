import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rx")
public class class464 {
	@ObfuscatedName("ac")
	static final int[] field3907;
	@ObfuscatedName("ai")
	static final int[] field3908;

	static {
		field3907 = new int[16384];
		field3908 = new int[16384];
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field3907[var2] = (int)(16384.0D * Math.sin((double)var2 * var0));
			field3908[var2] = (int)(16384.0D * Math.cos(var0 * (double)var2));
		}

	}
}