import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public class class304 {
	@ObfuscatedName("aw")
	static int[] field2739;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Luu;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;

	static {
		new Object();
		field2739 = new int[33];
		field2739[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2739[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Lag;",
		garbageValue = "-98766558"
	)
	public static class6[] method1581() {
		return new class6[]{class6.field6};
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "([BI)[B",
		garbageValue = "754109388"
	)
	@Export("decompressBytes")
	static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readInt();
		if (var3 >= 0 && (AbstractArchive.maximumContainerSize == 0 || var3 <= AbstractArchive.maximumContainerSize)) {
			if (var2 == 0) {
				byte[] var4 = new byte[var3];
				var1.readBytes(var4, 0, var3);
				return var4;
			} else {
				int var6 = var1.readInt();
				if (var6 < 0 || AbstractArchive.maximumContainerSize != 0 && var6 > AbstractArchive.maximumContainerSize) {
					throw new RuntimeException();
				} else {
					byte[] var5 = new byte[var6];
					if (var2 == 1) {
						BZip2Decompressor.BZip2Decompressor_decompress(var5, var6, var0, var3, 9);
					} else {
						AbstractArchive.gzipDecompressor.decompress(var1, var5);
					}

					return var5;
				}
			}
		} else {
			throw new RuntimeException();
		}
	}
}
