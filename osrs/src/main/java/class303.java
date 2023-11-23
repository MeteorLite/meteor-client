import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
public class class303 {
	@ObfuscatedName("ac")
	static int field2512;

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "86"
	)
	static final void method1628(int var0, int var1) {
		if (var0 < 128) {
			var0 = 128;
		} else if (var0 > 383) {
			var0 = 383;
		}

		if (Varcs.cameraPitch < var0) {
			Varcs.cameraPitch = (var0 - Varcs.cameraPitch) * class134.cameraMoveToAcceleration / 1000 + Varcs.cameraPitch + class60.cameraMoveToSpeed;
			if (Varcs.cameraPitch > var0) {
				Varcs.cameraPitch = var0;
			}
		} else if (Varcs.cameraPitch > var0) {
			Varcs.cameraPitch -= (Varcs.cameraPitch - var0) * class134.cameraMoveToAcceleration / 1000 + class60.cameraMoveToSpeed;
			if (Varcs.cameraPitch < var0) {
				Varcs.cameraPitch = var0;
			}
		}

		var1 &= 2047;
		int var2 = var1 - class192.cameraYaw;
		if (var2 > 1024) {
			var2 -= 2048;
		} else if (var2 < -1024) {
			var2 += 2048;
		}

		if (var2 > 0) {
			class192.cameraYaw = class192.cameraYaw + class60.cameraMoveToSpeed + var2 * class134.cameraMoveToAcceleration / 1000;
			class192.cameraYaw &= 2047;
		} else if (var2 < 0) {
			class192.cameraYaw -= class60.cameraMoveToSpeed + -var2 * class134.cameraMoveToAcceleration / 1000;
			class192.cameraYaw &= 2047;
		}

		int var3 = var1 - class192.cameraYaw;
		if (var3 > 1024) {
			var3 -= 2048;
		} else if (var3 < -1024) {
			var3 += 2048;
		}

		if (var3 < 0 && var2 > 0 || var3 > 0 && var2 < 0) {
			class192.cameraYaw = var1;
		}

	}
}