import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("of")
public class class365 {
	@ObfuscatedName("jt")
	static int field3199;
	@ObfuscatedName("la")
	@Export("cameraPitch")
	static int cameraPitch;

	static {
		int var0 = 0;
		int var1 = 0;
		class360[] var2 = class30.method121();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class360 var4 = var2[var3];
			if (var4.field3181 > var0) {
				var0 = var4.field3181;
			}

			if (var4.field3182 > var1) {
				var1 = var4.field3182;
			}
		}

	}
}