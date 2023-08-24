import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class126 {
	@ObfuscatedName("at")
	public static final float field1204;
	@ObfuscatedName("ac")
	public static final float field1203;
	@ObfuscatedName("ai")
	static float[] field1206;
	@ObfuscatedName("az")
	static float[] field1207;
	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		descriptor = "Lgz;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;

	static {
		field1204 = Math.ulp(1.0F);
		field1203 = field1204 * 2.0F;
		field1206 = new float[4];
		field1207 = new float[5];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "-1457731236"
	)
	public static byte[] method699(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1320879691"
	)
	public static void method700() {
		ParamComposition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lmi;IIIB)V",
		garbageValue = "-45"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field3047 == null) {
			throw new RuntimeException();
		} else {
			var0.field3047[var1] = var2;
			var0.field3046[var1] = var3;
		}
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		descriptor = "(IIIS)V",
		garbageValue = "158"
	)
	static final void method702(int var0, int var1, int var2) {
		if (NPCComposition.cameraX < var0) {
			NPCComposition.cameraX = (var0 - NPCComposition.cameraX) * MouseHandler.cameraMoveToAcceleration / 1000 + NPCComposition.cameraX + class344.cameraMoveToSpeed;
			if (NPCComposition.cameraX > var0) {
				NPCComposition.cameraX = var0;
			}
		}

		if (NPCComposition.cameraX > var0) {
			NPCComposition.cameraX -= (NPCComposition.cameraX - var0) * MouseHandler.cameraMoveToAcceleration / 1000 + class344.cameraMoveToSpeed;
			if (NPCComposition.cameraX < var0) {
				NPCComposition.cameraX = var0;
			}
		}

		if (class133.cameraY < var1) {
			class133.cameraY = (var1 - class133.cameraY) * MouseHandler.cameraMoveToAcceleration / 1000 + class133.cameraY + class344.cameraMoveToSpeed;
			if (class133.cameraY > var1) {
				class133.cameraY = var1;
			}
		}

		if (class133.cameraY > var1) {
			class133.cameraY -= (class133.cameraY - var1) * MouseHandler.cameraMoveToAcceleration / 1000 + class344.cameraMoveToSpeed;
			if (class133.cameraY < var1) {
				class133.cameraY = var1;
			}
		}

		if (class139.cameraZ < var2) {
			class139.cameraZ = (var2 - class139.cameraZ) * MouseHandler.cameraMoveToAcceleration / 1000 + class139.cameraZ + class344.cameraMoveToSpeed;
			if (class139.cameraZ > var2) {
				class139.cameraZ = var2;
			}
		}

		if (class139.cameraZ > var2) {
			class139.cameraZ -= (class139.cameraZ - var2) * MouseHandler.cameraMoveToAcceleration / 1000 + class344.cameraMoveToSpeed;
			if (class139.cameraZ < var2) {
				class139.cameraZ = var2;
			}
		}

	}
}