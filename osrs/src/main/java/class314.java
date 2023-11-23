import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("my")
public class class314 {
	@ObfuscatedName("at")
	static int[] field2775;
	@ObfuscatedName("hu")
	static String field2776;

	static {
		new Object();
		field2775 = new int[33];
		field2775[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2775[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "26"
	)
	static final void method1649(int var0, int var1, int var2) {
		if (ViewportMouse.cameraX < var0) {
			ViewportMouse.cameraX = (var0 - ViewportMouse.cameraX) * class1.cameraLookAtAcceleration / 1000 + ViewportMouse.cameraX + WorldMapIcon_0.cameraLookAtSpeed;
			if (ViewportMouse.cameraX > var0) {
				ViewportMouse.cameraX = var0;
			}
		}

		if (ViewportMouse.cameraX > var0) {
			ViewportMouse.cameraX -= (ViewportMouse.cameraX - var0) * class1.cameraLookAtAcceleration / 1000 + WorldMapIcon_0.cameraLookAtSpeed;
			if (ViewportMouse.cameraX < var0) {
				ViewportMouse.cameraX = var0;
			}
		}

		if (SecureRandomFuture.cameraY < var1) {
			SecureRandomFuture.cameraY = (var1 - SecureRandomFuture.cameraY) * class1.cameraLookAtAcceleration / 1000 + SecureRandomFuture.cameraY + WorldMapIcon_0.cameraLookAtSpeed;
			if (SecureRandomFuture.cameraY > var1) {
				SecureRandomFuture.cameraY = var1;
			}
		}

		if (SecureRandomFuture.cameraY > var1) {
			SecureRandomFuture.cameraY -= (SecureRandomFuture.cameraY - var1) * class1.cameraLookAtAcceleration / 1000 + WorldMapIcon_0.cameraLookAtSpeed;
			if (SecureRandomFuture.cameraY < var1) {
				SecureRandomFuture.cameraY = var1;
			}
		}

		if (class36.cameraZ < var2) {
			class36.cameraZ = (var2 - class36.cameraZ) * class1.cameraLookAtAcceleration / 1000 + class36.cameraZ + WorldMapIcon_0.cameraLookAtSpeed;
			if (class36.cameraZ > var2) {
				class36.cameraZ = var2;
			}
		}

		if (class36.cameraZ > var2) {
			class36.cameraZ -= (class36.cameraZ - var2) * class1.cameraLookAtAcceleration / 1000 + WorldMapIcon_0.cameraLookAtSpeed;
			if (class36.cameraZ < var2) {
				class36.cameraZ = var2;
			}
		}

	}
}