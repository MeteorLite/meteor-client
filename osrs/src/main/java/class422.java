import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("pm")
public class class422 {
	@ObfuscatedName("r")
	static final int[] field4623;
	@ObfuscatedName("l")
	static final int[] field4617;

	static {
		field4623 = new int[2048];
		field4617 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4623[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
			field4617[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}
}
