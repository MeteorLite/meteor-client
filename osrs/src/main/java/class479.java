import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("sy")
public class class479 {
	@ObfuscatedName("ao")
	static final int[] field3939;
	@ObfuscatedName("ah")
	static final int[] field3938;

	static {
		field3939 = new int[16384];
		field3938 = new int[16384];
		double var0 = 3.834951969714103E-4D;

		for (int var2 = 0; var2 < 16384; ++var2) {
			field3939[var2] = (int)(16384.0D * Math.sin(var0 * (double)var2));
			field3938[var2] = (int)(16384.0D * Math.cos((double)var2 * var0));
		}

	}
}