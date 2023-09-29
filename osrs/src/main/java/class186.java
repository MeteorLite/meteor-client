import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadFactory;

@ObfuscatedName("hl")
final class class186 implements ThreadFactory {
	@ObfuscatedName("cl")
	@Export("otp")
	static String otp;

	public Thread newThread(Runnable var1) {
		return new Thread(var1, "OSRS Maya Anim Load");
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1663362302"
	)
	public static int method949(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[Lfj;",
		garbageValue = "865282797"
	)
	static class130[] method950() {
		return new class130[]{class130.field1221, class130.field1223, class130.field1222, class130.field1225, class130.field1224};
	}
}