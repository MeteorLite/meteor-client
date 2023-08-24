import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rw")
public class class465 {
	@ObfuscatedName("al")
	static final int[] field3909;
	@ObfuscatedName("an")
	static final int[] field3910;

	static {
		field3909 = new int[2048];
		field3910 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field3909[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field3910[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}