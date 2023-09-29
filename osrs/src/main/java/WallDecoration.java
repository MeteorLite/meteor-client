import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.RandomAccessFile;

@ObfuscatedName("kq")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("wv")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	public static class384 field2303;
	@ObfuscatedName("ly")
	@Export("cameraYaw")
	static int cameraYaw;
	@ObfuscatedName("ac")
	@Export("z")
	int z;
	@ObfuscatedName("al")
	@Export("x")
	int x;
	@ObfuscatedName("ak")
	@Export("y")
	int y;
	@ObfuscatedName("ax")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ao")
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("ah")
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("ar")
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("av")
	@Export("tag")
	public long tag;
	@ObfuscatedName("ag")
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/io/File;",
		garbageValue = "97"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "16"
	)
	static final boolean method1425(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}