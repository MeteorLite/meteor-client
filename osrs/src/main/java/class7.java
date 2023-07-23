import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class7 {
	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("aw")
	ExecutorService field10;
	@ObfuscatedName("ay")
	Future field11;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	final Buffer field13;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lam;"
	)
	final class3 field12;

	@ObfuscatedSignature(
		descriptor = "(Lty;Lam;)V"
	)
	public class7(Buffer var1, class3 var2) {
		this.field10 = Executors.newSingleThreadExecutor();
		this.field13 = var1;
		this.field12 = var2;
		this.method17();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1852017365"
	)
	public boolean method14() {
		return this.field11.isDone();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "94"
	)
	public void method15() {
		this.field10.shutdown();
		this.field10 = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Lty;",
		garbageValue = "1875881919"
	)
	public Buffer method16() {
		try {
			return (Buffer)this.field11.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1250861800"
	)
	void method17() {
		this.field11 = this.field10.submit(new class1(this, this.field13, this.field12));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "-8386743"
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

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-89265387"
	)
	public static void method18(int var0) {
		if (!class306.musicSongs.isEmpty()) {
			Iterator var1 = class306.musicSongs.iterator();

			while (var1.hasNext()) {
				MusicSong var2 = (MusicSong)var1.next();
				if (var2 != null) {
					var2.musicTrackVolume = var0;
				}
			}

			MusicSong var3 = (MusicSong)class306.musicSongs.get(0);
			if (var3 != null && var3.midiPcmStream != null && var3.midiPcmStream.isReady() && !var3.field2851) {
				var3.midiPcmStream.setPcmStreamVolume(var0);
				var3.field2853 = (float)var0;
			}
		}

	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		descriptor = "(Lig;IIII)V",
		garbageValue = "-1636583906"
	)
	static void method19(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && class150.clientPreferences.getAreaSoundEffectsVolume() != 0) {
			if (var0.animMayaFrameSounds != null && var0.animMayaFrameSounds.containsKey(var1)) {
				SoundSystem.method220((Integer)var0.animMayaFrameSounds.get(var1), var2, var3);
			}
		}
	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIIZI)V",
		garbageValue = "-670080014"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuItemIds[Client.menuOptionsCount] = var6;
				Client.menuShiftClick[Client.menuOptionsCount] = var7;
				++Client.menuOptionsCount;
			}

		}
	}

	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIB)V",
		garbageValue = "-59"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (Login.loadInterface(var0)) {
			WorldMapDecoration.field2419 = null;
			class47.drawInterface(ArchiveLoader.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (WorldMapDecoration.field2419 != null) {
				class47.drawInterface(WorldMapDecoration.field2419, -1412584499, var1, var2, var3, var4, class300.field2731, WorldMapIcon_0.field2371, var7);
				WorldMapDecoration.field2419 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field403[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field403[var8] = true;
				}
			}

		}
	}
}
