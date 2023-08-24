import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;

@ObfuscatedName("ga")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("au")
	@Export("FileSystem_hasPermissions")
	static boolean FileSystem_hasPermissions;
	@ObfuscatedName("ae")
	@Export("FileSystem_cacheDir")
	static File FileSystem_cacheDir;
	@ObfuscatedName("ao")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[Lew;",
		garbageValue = "-66"
	)
	static class128[] method912() {
		return new class128[]{class128.field1229, class128.field1226, class128.field1227, class128.field1228, class128.field1225};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V",
		garbageValue = "1743339101"
	)
	public static void method911(AbstractArchive var0) {
		VarpDefinition.VarpDefinition_archive = var0;
		VarpDefinition.field1498 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-1"
	)
	static void method913() {
		try {
			File var0 = new File(class36.userHomeDirectory, "random.dat");
			int var2;
			if (var0.exists()) {
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			} else {
				label34:
				for (int var1 = 0; var1 < JagexCache.field1464.length; ++var1) {
					for (var2 = 0; var2 < DelayFadeTask.field3712.length; ++var2) {
						File var3 = new File(DelayFadeTask.field3712[var2] + JagexCache.field1464[var1] + File.separatorChar + "random.dat");
						if (var3.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
							break label34;
						}
					}
				}
			}

			if (JagexCache.JagexCache_randomDat == null) {
				RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
				var2 = var4.read();
				var4.seek(0L);
				var4.write(var2);
				var4.seek(0L);
				var4.close();
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			}
		} catch (IOException var5) {
		}

	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "(Lib;IIII)V",
		garbageValue = "-1577193721"
	)
	static void method914(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && class449.clientPreferences.getAreaSoundEffectsVolume() != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				MouseHandler.method172(var0.soundEffects[var1], var2, var3);
			}
		}
	}

	@ObfuscatedName("or")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1893759044"
	)
	static void method915() {
		for (int var0 = 0; var0 < Client.field609.size(); ++var0) {
			if (ClientPreferences.method571((Integer)Client.field609.get(var0)) != 2) {
				Client.field609.remove(var0);
				--var0;
			}
		}

	}
}