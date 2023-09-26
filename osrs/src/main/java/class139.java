import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@ObfuscatedName("fk")
public class class139 extends DualNode {
	@ObfuscatedName("ac")
	int field1293;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "[[Lfz;"
	)
	public class132[][] field1297;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "[[Lfz;"
	)
	class132[][] field1292;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lju;"
	)
	public Skeleton field1298;
	@ObfuscatedName("ao")
	int field1294;
	@ObfuscatedName("ah")
	boolean field1291;
	@ObfuscatedName("am")
	Future field1296;
	@ObfuscatedName("av")
	List field1295;

	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;IZ)V",
		garbageValue = "0"
	)
	public class139(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1297 = null;
		this.field1292 = null;
		this.field1294 = 0;
		this.field1293 = var3;
		byte[] var5 = var1.takeFile(this.field1293 >> 16 & 65535, this.field1293 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9 = var2.getFile(var8, 0);
		this.field1298 = new Skeleton(var8, var9);
		this.field1295 = new ArrayList();
		this.field1296 = SoundCache.field214.submit(new class136(this, var6, var7));
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;II)V",
		garbageValue = "2000104113"
	)
	void method736(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1294 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		this.field1292 = new class132[this.field1298.method1276().method1260()][];
		this.field1297 = new class132[this.field1298.method1275()][];
		class131[] var4 = new class131[var3];

		int var5;
		int var7;
		for (var5 = 0; var5 < var3; ++var5) {
			class133 var6 = class406.method2057(var1.readUnsignedByte());
			var7 = var1.readShortSmart();
			class134 var8 = class179.method927(var1.readUnsignedByte());
			class132 var9 = new class132();
			var9.method709(var1, var2);
			var4[var5] = new class131(this, var9, var6, var8, var7);
			int var10 = var6.method718();
			class132[][] var11;
			if (var6 == class133.field1260) {
				var11 = this.field1292;
			} else {
				var11 = this.field1297;
			}

			if (var11[var7] == null) {
				var11[var7] = new class132[var10];
			}

			if (var6 == class133.field1261) {
				this.field1291 = true;
			}
		}

		var5 = var3 / MusicPatchPcmStream.field2855;
		int var12 = var3 % MusicPatchPcmStream.field2855;
		int var13 = 0;

		for (int var14 = 0; var14 < MusicPatchPcmStream.field2855; ++var14) {
			var7 = var13;
			var13 += var5;
			if (var12 > 0) {
				++var13;
				--var12;
			}

			if (var13 == var7) {
				break;
			}

			this.field1295.add(SoundCache.field214.submit(new class138(this, var7, var13, var4)));
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "2"
	)
	public boolean method738() {
		if (this.field1296 == null && this.field1295 == null) {
			return true;
		} else {
			if (this.field1296 != null) {
				if (!this.field1296.isDone()) {
					return false;
				}

				this.field1296 = null;
			}

			boolean var1 = true;

			for (int var2 = 0; var2 < this.field1295.size(); ++var2) {
				if (!((Future)this.field1295.get(var2)).isDone()) {
					var1 = false;
				} else {
					this.field1295.remove(var2);
					--var2;
				}
			}

			if (!var1) {
				return false;
			} else {
				this.field1295 = null;
				return true;
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-17"
	)
	public int method739() {
		return this.field1294;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-19"
	)
	public boolean method740() {
		return this.field1291;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ILed;III)V",
		garbageValue = "2056920821"
	)
	public void method741(int var1, class129 var2, int var3, int var4) {
		class465 var5 = ParamComposition.method1053();
		this.method742(var5, var3, var2, var1);
		this.method744(var5, var3, var2, var1);
		this.method743(var5, var3, var2, var1);
		var2.method697(var5);
		var5.method2336();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lrb;ILed;II)V",
		garbageValue = "8414091"
	)
	void method742(class465 var1, int var2, class129 var3, int var4) {
		float[] var5 = var3.method701(this.field1294);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1292[var2] != null) {
			class132 var9 = this.field1292[var2][0];
			class132 var10 = this.field1292[var2][1];
			class132 var11 = this.field1292[var2][2];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		class464 var16 = Friend.method2240();
		var16.method2332(1.0F, 0.0F, 0.0F, var6);
		class464 var14 = Friend.method2240();
		var14.method2332(0.0F, 1.0F, 0.0F, var7);
		class464 var15 = Friend.method2240();
		var15.method2332(0.0F, 0.0F, 1.0F, var8);
		class464 var12 = Friend.method2240();
		var12.method2334(var15);
		var12.method2334(var16);
		var12.method2334(var14);
		class465 var13 = ParamComposition.method1053();
		var13.method2347(var12);
		var1.method2346(var13);
		var16.method2330();
		var14.method2330();
		var15.method2330();
		var12.method2330();
		var13.method2336();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lrb;ILed;II)V",
		garbageValue = "1859229364"
	)
	void method743(class465 var1, int var2, class129 var3, int var4) {
		float[] var5 = var3.method702(this.field1294);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1292[var2] != null) {
			class132 var9 = this.field1292[var2][3];
			class132 var10 = this.field1292[var2][4];
			class132 var11 = this.field1292[var2][5];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		var1.field3908[12] = var6;
		var1.field3908[13] = var7;
		var1.field3908[14] = var8;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lrb;ILed;IB)V",
		garbageValue = "2"
	)
	void method744(class465 var1, int var2, class129 var3, int var4) {
		float[] var5 = var3.method703(this.field1294);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1292[var2] != null) {
			class132 var9 = this.field1292[var2][6];
			class132 var10 = this.field1292[var2][7];
			class132 var11 = this.field1292[var2][8];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		class465 var12 = ParamComposition.method1053();
		var12.method2344(var6, var7, var8);
		var1.method2346(var12);
		var12.method2336();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "8"
	)
	public static void method735(String var0, String var1, String var2, int var3, int var4) throws IOException {
		if (var1 != null && !var1.isEmpty()) {
			var0 = var0 + "-" + var1;
		}

		UrlRequester.field1162 = var4;
		FileSystem.cacheGamebuild = var3;

		try {
			GrandExchangeOfferNameComparator.field3614 = System.getProperty("os.name");
		} catch (Exception var19) {
			GrandExchangeOfferNameComparator.field3614 = "Unknown";
		}

		class223.field1863 = GrandExchangeOfferNameComparator.field3614.toLowerCase();
		DevicePcmPlayerProvider.userHomeDirectory = null;

		try {
			DevicePcmPlayerProvider.userHomeDirectory = System.getProperty("jagex.userhome");
		} catch (Exception var18) {
		}

		if (DevicePcmPlayerProvider.userHomeDirectory == null) {
			try {
				DevicePcmPlayerProvider.userHomeDirectory = System.getProperty("user.home");
			} catch (Exception var17) {
			}
		}

		if (DevicePcmPlayerProvider.userHomeDirectory != null) {
			DevicePcmPlayerProvider.userHomeDirectory = DevicePcmPlayerProvider.userHomeDirectory + "/";
		}

		try {
			if (class223.field1863.startsWith("win")) {
				if (DevicePcmPlayerProvider.userHomeDirectory == null) {
					DevicePcmPlayerProvider.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (DevicePcmPlayerProvider.userHomeDirectory == null) {
				DevicePcmPlayerProvider.userHomeDirectory = System.getenv("HOME");
			}

			if (DevicePcmPlayerProvider.userHomeDirectory != null) {
				DevicePcmPlayerProvider.userHomeDirectory = DevicePcmPlayerProvider.userHomeDirectory + "/";
			}
		} catch (Exception var16) {
		}

		if (DevicePcmPlayerProvider.userHomeDirectory == null) {
			DevicePcmPlayerProvider.userHomeDirectory = "~/";
		}

		FriendsList.field3812 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", DevicePcmPlayerProvider.userHomeDirectory, "/tmp/", ""};
		class27.field74 = new String[]{".jagex_cache_" + FileSystem.cacheGamebuild, ".file_store_" + FileSystem.cacheGamebuild};
		int var13 = 0;

		label107:
		while (var13 < 4) {
			class500.cacheDir = InvDefinition.method954(var0, var2, var13);
			if (!class500.cacheDir.exists()) {
				class500.cacheDir.mkdirs();
			}

			File[] var6 = class500.cacheDir.listFiles();
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

		File var5 = class500.cacheDir;
		FileSystem.FileSystem_cacheDir = var5;
		if (!FileSystem.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;
			UserComparator5.method674();
			JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(WallDecoration.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(WallDecoration.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			UserComparator8.JagexCache_idxFiles = new BufferedFile[UrlRequester.field1162];

			for (int var14 = 0; var14 < UrlRequester.field1162; ++var14) {
				UserComparator8.JagexCache_idxFiles[var14] = new BufferedFile(new AccessFile(WallDecoration.getFile("main_file_cache.idx" + var14), "rw", 1048576L), 6000, 0);
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1287194553"
	)
	static void method737() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "16777215"
	)
	static final void method745() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				class6.updateActorSequence(var3, 1);
			}
		}

	}
}