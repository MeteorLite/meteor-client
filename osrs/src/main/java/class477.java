import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("sx")
public class class477 {
	@ObfuscatedName("ax")
	static final int[] field3939;
	@ObfuscatedName("as")
	static final int[] field3938;

	static {
		field3939 = new int[2048];
		field3938 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field3939[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field3938[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}