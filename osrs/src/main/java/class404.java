import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("oh")
public class class404 {
	@ObfuscatedName("x")
	static final int[] field4492;
	@ObfuscatedName("j")
	static final int[] field4493;

	static {
		field4492 = new int[2048];
		field4493 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4492[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
			field4493[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
		}

	}
}
