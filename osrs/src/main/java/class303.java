import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public class class303 {
	@ObfuscatedName("au")
	static int[] field2755;

	static {
		new Object();
		field2755 = new int[33];
		field2755[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2755[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Laz;",
		garbageValue = "-2002695578"
	)
	public static class6[] method1624() {
		return new class6[]{class6.field6};
	}
}