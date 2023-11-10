import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("nq")
public class class339 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lni;"
	)
	public class341 field2934;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lmp;"
	)
	class336 field2929;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbd;"
	)
	class27 field2928;
	@ObfuscatedName("ao")
	public Object[] field2932;
	@ObfuscatedName("ab")
	public Object[] field2931;
	@ObfuscatedName("au")
	public Object[] field2933;
	@ObfuscatedName("aa")
	public Object[] field2930;

	class339() {
		this.field2934 = new class341();
		this.field2929 = new class336();
		this.field2928 = new class27();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;I)V",
		garbageValue = "-687709037"
	)
	static void method1743(Component var0) {
		var0.removeMouseListener(MouseHandler.MouseHandler_instance);
		var0.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var0.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "99"
	)
	public static void method1744(String var0, String var1, String var2, int var3, int var4) throws IOException {
		if (var1 != null && !var1.isEmpty()) {
			var0 = var0 + "-" + var1;
		}

		UserComparator6.field1202 = var4;
		class521.cacheGamebuild = var3;

		try {
			class90.field893 = System.getProperty("os.name");
		} catch (Exception var19) {
			class90.field893 = "Unknown";
		}

		ClanChannel.field1413 = class90.field893.toLowerCase();
		Login.userHomeDirectory = null;

		try {
			Login.userHomeDirectory = System.getProperty("jagex.userhome");
		} catch (Exception var18) {
		}

		if (Login.userHomeDirectory == null) {
			try {
				Login.userHomeDirectory = System.getProperty("user.home");
			} catch (Exception var17) {
			}
		}

		if (Login.userHomeDirectory != null) {
			Login.userHomeDirectory = Login.userHomeDirectory + "/";
		}

		try {
			if (ClanChannel.field1413.startsWith("win")) {
				if (Login.userHomeDirectory == null) {
					Login.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (Login.userHomeDirectory == null) {
				Login.userHomeDirectory = System.getenv("HOME");
			}

			if (Login.userHomeDirectory != null) {
				Login.userHomeDirectory = Login.userHomeDirectory + "/";
			}
		} catch (Exception var16) {
		}

		if (Login.userHomeDirectory == null) {
			Login.userHomeDirectory = "~/";
		}

		GameObject.field2480 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Login.userHomeDirectory, "/tmp/", ""};
		class85.field859 = new String[]{".jagex_cache_" + class521.cacheGamebuild, ".file_store_" + class521.cacheGamebuild};
		int var13 = 0;

		label107:
		while (var13 < 4) {
			JagexCache.cacheDir = class181.method918(var0, var2, var13);
			if (!JagexCache.cacheDir.exists()) {
				JagexCache.cacheDir.mkdirs();
			}

			File[] var6 = JagexCache.cacheDir.listFiles();
			if (var6 == null) {
				break;
			}

			File[] var7 = var6;
			int var8 = 0;

			while (true) {
				if (var8 >= var7.length) {
					break label107;
				}

				File var9 = var7[var8];

				boolean var10;
				try {
					RandomAccessFile var11 = new RandomAccessFile(var9, "rw");
					int var12 = var11.read();
					var11.seek(0L);
					var11.write(var12);
					var11.seek(0L);
					var11.close();
					var10 = true;
				} catch (Exception var15) {
					var10 = false;
				}

				if (!var10) {
					++var13;
					break;
				}

				++var8;
			}
		}

		File var5 = JagexCache.cacheDir;
		FileSystem.FileSystem_cacheDir = var5;
		if (!FileSystem.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;
			PacketWriter.method643();
			JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class10.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class10.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			KeyHandler.JagexCache_idxFiles = new BufferedFile[UserComparator6.field1202];

			for (int var14 = 0; var14 < UserComparator6.field1202; ++var14) {
				KeyHandler.JagexCache_idxFiles[var14] = new BufferedFile(new AccessFile(class10.getFile("main_file_cache.idx" + var14), "rw", 1048576L), 6000, 0);
			}

		}
	}
}