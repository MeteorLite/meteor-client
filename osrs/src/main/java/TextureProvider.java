import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lks;"
	)
	@Export("textures")
	Texture[] textures;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("deque")
	NodeDeque deque;
	@ObfuscatedName("ar")
	@Export("capacity")
	int capacity;
	@ObfuscatedName("ao")
	@Export("remaining")
	int remaining;
	@ObfuscatedName("ab")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("au")
	@Export("textureSize")
	int textureSize;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("archive")
	AbstractArchive archive;

	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;IDI)V"
	)
	public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
		this.deque = new NodeDeque();
		this.remaining = 0;
		this.brightness = 1.0D;
		this.textureSize = 128;
		this.archive = var2;
		this.capacity = var3;
		this.remaining = this.capacity;
		this.brightness = var4;
		this.textureSize = var6;
		int[] var7 = var1.getGroupFileIds(0);
		if (var7 != null) {
			int var8 = var7.length;
			this.textures = new Texture[var1.getGroupFileCount(0)];

			for (int var9 = 0; var9 < var8; ++var9) {
				Buffer var10 = new Buffer(var1.takeFile(0, var7[var9]));
				this.textures[var7[var9]] = new Texture(var10);
			}
		} else {
			this.textures = new Texture[0];
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "81"
	)
	@Export("getLoadedPercentage")
	public int getLoadedPercentage() {
		if (this.textures.length == 0) {
			return 100;
		} else {
			int var1 = 0;
			int var2 = 0;
			Texture[] var3 = this.textures;

			for (int var4 = 0; var4 < var3.length; ++var4) {
				Texture var5 = var3[var4];
				if (var5 != null && var5.fileIds != null) {
					var1 += var5.fileIds.length;
					int[] var6 = var5.fileIds;

					for (int var7 = 0; var7 < var6.length; ++var7) {
						int var8 = var6[var7];
						if (this.archive.method1930(var8)) {
							++var2;
						}
					}
				}
			}

			if (var1 == 0) {
				return 0;
			} else {
				return var2 * 100 / var1;
			}
		}
	}

	@ObfuscatedName("ah")
	@Export("setBrightness")
	public void setBrightness(double var1) {
		this.brightness = var1;
		this.clear();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)[I",
		garbageValue = "2146690386"
	)
	@Export("getTexturePixels")
	public int[] getTexturePixels(int var1) {
		Texture var2 = this.textures[var1];
		if (var2 != null) {
			if (var2.pixels != null) {
				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}

			boolean var3 = var2.load(this.brightness, this.textureSize, this.archive);
			if (var3) {
				if (this.remaining == 0) {
					Texture var4 = (Texture)this.deque.removeFirst();
					var4.reset();
				} else {
					--this.remaining;
				}

				this.deque.addLast(var2);
				var2.isLoaded = true;
				return var2.pixels;
			}
		}

		return null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-799593144"
	)
	@Export("getAverageTextureRGB")
	public int getAverageTextureRGB(int var1) {
		return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-293103198"
	)
	@Export("vmethod3989")
	public boolean vmethod3989(int var1) {
		return this.textures[var1].field2171;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "32621"
	)
	@Export("isLowDetail")
	public boolean isLowDetail(int var1) {
		return this.textureSize == 64;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1262125265"
	)
	@Export("clear")
	public void clear() {
		for (int var1 = 0; var1 < this.textures.length; ++var1) {
			if (this.textures[var1] != null) {
				this.textures[var1].reset();
			}
		}

		this.deque = new NodeDeque();
		this.remaining = this.capacity;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2003638345"
	)
	@Export("animate")
	public void animate(int var1) {
		for (int var2 = 0; var2 < this.textures.length; ++var2) {
			Texture var3 = this.textures[var2];
			if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
				var3.animate(var1);
				var3.isLoaded = false;
			}
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1703102437"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = class131.getPreferencesFile("", Messages.field1156.name, true);
			Buffer var1 = WorldMapIcon_1.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-73"
	)
	static final void method1529() {
		class314.method1649(FloorOverlayDefinition.field1772, class323.field2851, Projectile.field783);
		class303.method1628(class127.field1224, CollisionMap.field1901);
		if (FloorOverlayDefinition.field1772 == ViewportMouse.cameraX && SecureRandomFuture.cameraY == class323.field2851 && class36.cameraZ == Projectile.field783 && class127.field1224 == Varcs.cameraPitch && CollisionMap.field1901 == class192.cameraYaw) {
			Client.field400 = false;
			Client.isCameraLocked = false;
			Client.field402 = false;
			Client.field404 = false;
			Messages.cameraMoveToX = 0;
			AbstractWorldMapData.cameraMoveToY = 0;
			class302.cameraMoveToHeight = 0;
			class60.cameraMoveToSpeed = 0;
			class134.cameraMoveToAcceleration = 0;
			class1.cameraLookAtAcceleration = 0;
			WorldMapIcon_0.cameraLookAtSpeed = 0;
			ScriptFrame.cameraLookAtX = 0;
			class216.cameraLookAtY = 0;
			class127.cameraLookAtHeight = 0;
			Client.field644 = null;
			Client.field642 = null;
			Client.field643 = null;
		}

	}
}