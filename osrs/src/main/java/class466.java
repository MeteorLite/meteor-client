import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rd")
public class class466 {
	@ObfuscatedName("ah")
	static final int[] field3897;
	@ObfuscatedName("ax")
	static final int[] field3898;

	static {
		field3897 = new int[2048];
		field3898 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field3897[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field3898[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
