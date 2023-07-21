import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
public class class328 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lmo;"
	)
	public class330 field2886;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lmy;"
	)
	class325 field2881;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	class27 field2880;
	@ObfuscatedName("am")
	public Object[] field2884;
	@ObfuscatedName("as")
	public Object[] field2885;
	@ObfuscatedName("aj")
	public Object[] field2883;
	@ObfuscatedName("ag")
	public Object[] field2882;

	class328() {
		this.field2886 = new class330();
		this.field2881 = new class325();
		this.field2880 = new class27();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "([FIFI)F",
		garbageValue = "39231924"
	)
	static float method1677(float[] var0, int var1, float var2) {
		float var3 = var0[var1];

		for (int var4 = var1 - 1; var4 >= 0; --var4) {
			var3 = var2 * var3 + var0[var4];
		}

		return var3;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2079868844"
	)
	static void method1678(int var0) {
		if (var0 != Login.loginIndex) {
			Login.loginIndex = var0;
		}
	}
}
