import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public enum class82 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lct;"
	)
	field1062(0, -1),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lct;"
	)
	field1068(1, 1),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lct;"
	)
	field1069(2, 7),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lct;"
	)
	field1064(3, 8),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lct;"
	)
	field1065(4, 9);

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "[Lqi;"
	)
	@Export("worldSelectBackSprites")
	static SpritePixels[] worldSelectBackSprites;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 329325289
	)
	final int field1066;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1713247665
	)
	final int field1067;

	class82(int var3, int var4) {
		this.field1066 = var3;
		this.field1067 = var4;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1067;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)Lnn;",
		garbageValue = "15"
	)
	public static class388 method2262() {
		synchronized(class388.field4429) {
			if (class388.field4434 == 0) {
				return new class388();
			} else {
				class388.field4429[--class388.field4434].method7157();
				return class388.field4429[class388.field4434];
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(DDII)[D",
		garbageValue = "75865369"
	)
	public static double[] method2261(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			var6[var8] = BoundaryObject.method4649((double)var7, var0, var2);
			++var7;
		}

		return var6;
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "-120"
	)
	@Export("worldToScreen")
	static final void worldToScreen(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var3 = class120.getTileHeight(var0, var1, Tiles.Client_plane) - var2;
			var0 -= TaskHandler.cameraX;
			var3 -= SecureRandomFuture.cameraY;
			var1 -= ApproximateRouteStrategy.cameraZ;
			int var4 = Rasterizer3D.Rasterizer3D_sine[class163.cameraPitch];
			int var5 = Rasterizer3D.Rasterizer3D_cosine[class163.cameraPitch];
			int var6 = Rasterizer3D.Rasterizer3D_sine[class10.cameraYaw];
			int var7 = Rasterizer3D.Rasterizer3D_cosine[class10.cameraYaw];
			int var8 = var6 * var1 + var0 * var7 >> 16;
			var1 = var7 * var1 - var0 * var6 >> 16;
			var0 = var8;
			var8 = var5 * var3 - var4 * var1 >> 16;
			var1 = var5 * var1 + var3 * var4 >> 16;
			if (var1 >= 50) {
				Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
				Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
			} else {
				Client.viewportTempX = -1;
				Client.viewportTempY = -1;
			}

		} else {
			Client.viewportTempX = -1;
			Client.viewportTempY = -1;
		}
	}
}
