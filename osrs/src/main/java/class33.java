import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class33 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("ho")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("c")
	static double method644(double var0) {
		return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;IIS)V",
		garbageValue = "25840"
	)
	public static void method641(String var0, String var1, int var2, int var3) throws IOException {
		JagexCache.idxCount = var3;
		class151.cacheGamebuild = var2;

		try {
			class124.operatingSystemName = System.getProperty("os.name");
		} catch (Exception var35) {
			class124.operatingSystemName = "Unknown";
		}

		ItemContainer.formattedOperatingSystemName = class124.operatingSystemName.toLowerCase();

		try {
			JagexCache.userHomeDirectory = System.getProperty("user.home");
			if (JagexCache.userHomeDirectory != null) {
				JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
			}
		} catch (Exception var34) {
		}

		try {
			if (ItemContainer.formattedOperatingSystemName.startsWith("win")) {
				if (JagexCache.userHomeDirectory == null) {
					JagexCache.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (JagexCache.userHomeDirectory == null) {
				JagexCache.userHomeDirectory = System.getenv("HOME");
			}

			if (JagexCache.userHomeDirectory != null) {
				JagexCache.userHomeDirectory = JagexCache.userHomeDirectory + "/";
			}
		} catch (Exception var33) {
		}

		if (JagexCache.userHomeDirectory == null) {
			JagexCache.userHomeDirectory = "~/";
		}

		JagexCache.cacheParentPaths = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", JagexCache.userHomeDirectory, "/tmp/", ""};
		JagexCache.cacheSubPaths = new String[]{".jagex_cache_" + class151.cacheGamebuild, ".file_store_" + class151.cacheGamebuild};
		int var18 = 0;

		label318:
		while (var18 < 4) {
			String var6 = var18 == 0 ? "" : "" + var18;
			JagexCache.JagexCache_locationFile = new File(JagexCache.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
			String var7 = null;
			String var8 = null;
			boolean var9 = false;
			Buffer var11;
			int var12;
			int var14;
			File var42;
			if (JagexCache.JagexCache_locationFile.exists()) {
				try {
					AccessFile var10 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

					for (var11 = new Buffer((int)var10.length()); var11.offset < var11.array.length; var11.offset += var12) {
						var12 = var10.read(var11.array, var11.offset, var11.array.length - var11.offset);
						if (var12 == -1) {
							throw new IOException();
						}
					}

					var11.offset = 0;
					var12 = var11.readUnsignedByte();
					if (var12 < 1 || var12 > 3) {
						throw new IOException("" + var12);
					}

					int var13 = 0;
					if (var12 > 1) {
						var13 = var11.readUnsignedByte();
					}

					if (var12 <= 2) {
						var7 = var11.readStringCp1252NullCircumfixed();
						if (var13 == 1) {
							var8 = var11.readStringCp1252NullCircumfixed();
						}
					} else {
						var7 = var11.readCESU8();
						if (var13 == 1) {
							var8 = var11.readCESU8();
						}
					}

					var10.close();
				} catch (IOException var38) {
					var38.printStackTrace();
				}

				if (var7 != null) {
					var42 = new File(var7);
					if (!var42.exists()) {
						var7 = null;
					}
				}

				if (var7 != null) {
					var42 = new File(var7, "test.dat");

					boolean var45;
					try {
						RandomAccessFile var19 = new RandomAccessFile(var42, "rw");
						var14 = var19.read();
						var19.seek(0L);
						var19.write(var14);
						var19.seek(0L);
						var19.close();
						var42.delete();
						var45 = true;
					} catch (Exception var32) {
						var45 = false;
					}

					if (!var45) {
						var7 = null;
					}
				}
			}

			if (var7 == null && var18 == 0) {
				label293:
				for (int var20 = 0; var20 < JagexCache.cacheSubPaths.length; ++var20) {
					for (int var21 = 0; var21 < JagexCache.cacheParentPaths.length; ++var21) {
						File var22 = new File(JagexCache.cacheParentPaths[var21] + JagexCache.cacheSubPaths[var20] + File.separatorChar + var0 + File.separatorChar);
						if (var22.exists()) {
							File var23 = new File(var22, "test.dat");

							boolean var47;
							try {
								RandomAccessFile var15 = new RandomAccessFile(var23, "rw");
								int var16 = var15.read();
								var15.seek(0L);
								var15.write(var16);
								var15.seek(0L);
								var15.close();
								var23.delete();
								var47 = true;
							} catch (Exception var31) {
								var47 = false;
							}

							if (var47) {
								var7 = var22.toString();
								var9 = true;
								break label293;
							}
						}
					}
				}
			}

			if (var7 == null) {
				var7 = JagexCache.userHomeDirectory + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
				var9 = true;
			}

			File var41;
			if (var8 != null) {
				var41 = new File(var8);
				var42 = new File(var7);

				try {
					File[] var52 = var41.listFiles();
					File[] var49 = var52;

					for (var14 = 0; var14 < var49.length; ++var14) {
						File var48 = var49[var14];
						File var24 = new File(var42, var48.getName());
						boolean var17 = var48.renameTo(var24);
						if (!var17) {
							throw new IOException();
						}
					}
				} catch (Exception var37) {
					var37.printStackTrace();
				}

				var9 = true;
			}

			if (var9) {
				var41 = new File(var7);
				var11 = null;

				try {
					AccessFile var53 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
					Buffer var50 = new Buffer(500);
					var50.writeByte(3);
					var50.writeByte(var11 != null ? 1 : 0);
					var50.writeCESU8(var41.getPath());
					if (var11 != null) {
						var50.writeCESU8("");
					}

					var53.write(var50.array, 0, var50.offset);
					var53.close();
				} catch (IOException var30) {
					var30.printStackTrace();
				}
			}

			File var5 = new File(var7);
			JagexCache.cacheDir = var5;
			if (!JagexCache.cacheDir.exists()) {
				JagexCache.cacheDir.mkdirs();
			}

			File[] var40 = JagexCache.cacheDir.listFiles();
			if (var40 != null) {
				File[] var43 = var40;

				for (int var25 = 0; var25 < var43.length; ++var25) {
					File var26 = var43[var25];

					boolean var51;
					try {
						RandomAccessFile var46 = new RandomAccessFile(var26, "rw");
						var12 = var46.read();
						var46.seek(0L);
						var46.write(var12);
						var46.seek(0L);
						var46.close();
						var51 = true;
					} catch (Exception var29) {
						var51 = false;
					}

					if (!var51) {
						++var18;
						continue label318;
					}
				}
			}
			break;
		}

		Player.method2324(JagexCache.cacheDir);

		try {
			File var4 = new File(JagexCache.userHomeDirectory, "random.dat");
			int var28;
			if (var4.exists()) {
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var4, "rw", 25L), 24, 0);
			} else {
				label244:
				for (int var27 = 0; var27 < JagexCache.cacheSubPaths.length; ++var27) {
					for (var28 = 0; var28 < JagexCache.cacheParentPaths.length; ++var28) {
						File var44 = new File(JagexCache.cacheParentPaths[var28] + JagexCache.cacheSubPaths[var27] + File.separatorChar + "random.dat");
						if (var44.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var44, "rw", 25L), 24, 0);
							break label244;
						}
					}
				}
			}

			if (JagexCache.JagexCache_randomDat == null) {
				RandomAccessFile var39 = new RandomAccessFile(var4, "rw");
				var28 = var39.read();
				var39.seek(0L);
				var39.write(var28);
				var39.seek(0L);
				var39.close();
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var4, "rw", 25L), 24, 0);
			}
		} catch (IOException var36) {
		}

		JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(class21.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
		JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(class21.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
		JagexCache.JagexCache_idxFiles = new BufferedFile[JagexCache.idxCount];

		for (var18 = 0; var18 < JagexCache.idxCount; ++var18) {
			JagexCache.JagexCache_idxFiles[var18] = new BufferedFile(new AccessFile(class21.getFile("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ldi;FS)F",
		garbageValue = "255"
	)
	static float method636(class118 var0, float var1) {
		if (var0 != null && var0.method2876() != 0) {
			if (var1 < (float)var0.field1467[0].field1407) {
				return var0.field1454 == class117.field1451 ? var0.field1467[0].field1409 : Renderable.method4464(var0, var1, true);
			} else if (var1 > (float)var0.field1467[var0.method2876() - 1].field1407) {
				return var0.field1455 == class117.field1451 ? var0.field1467[var0.method2876() - 1].field1409 : Renderable.method4464(var0, var1, false);
			} else if (var0.field1453) {
				return var0.field1467[0].field1409;
			} else {
				class114 var2 = var0.method2892(var1);
				boolean var3 = false;
				boolean var4 = false;
				if (var2 == null) {
					return 0.0F;
				} else {
					if (0.0D == (double)var2.field1410 && (double)var2.field1411 == 0.0D) {
						var3 = true;
					} else if (var2.field1410 == Float.MAX_VALUE && var2.field1411 == Float.MAX_VALUE) {
						var4 = true;
					} else if (var2.field1414 != null) {
						if (var0.field1452) {
							float[] var5 = new float[4];
							float[] var6 = new float[4];
							var5[0] = (float)var2.field1407;
							var6[0] = var2.field1409;
							var5[1] = var5[0] + 0.33333334F * var2.field1410;
							var6[1] = var6[0] + 0.33333334F * var2.field1411;
							var5[3] = (float)var2.field1414.field1407;
							var6[3] = var2.field1414.field1409;
							var5[2] = var5[3] - 0.33333334F * var2.field1414.field1406;
							var6[2] = var6[3] - var2.field1414.field1412 * 0.33333334F;
							if (var0.field1456) {
								UrlRequester.method2679(var0, var5, var6);
							} else {
								InterfaceParent.method2237(var0, var5, var6);
							}

							var0.field1452 = false;
						}
					} else {
						var3 = true;
					}

					if (var3) {
						return var2.field1409;
					} else if (var4) {
						return (float)var2.field1407 != var1 && var2.field1414 != null ? var2.field1414.field1409 : var2.field1409;
					} else if (var0.field1456) {
						float var12;
						if (var0 == null) {
							var12 = 0.0F;
						} else {
							float var11;
							if (var0.field1458 == var1) {
								var11 = 0.0F;
							} else if (var1 == var0.field1459) {
								var11 = 1.0F;
							} else {
								var11 = (var1 - var0.field1458) / (var0.field1459 - var0.field1458);
							}

							float var7;
							if (var0.field1457) {
								var7 = var11;
							} else {
								float[] var8 = new float[]{var0.field1460[0] - var11, var0.field1460[1], var0.field1460[2], var0.field1460[3]};
								float[] var9 = new float[5];
								int var10 = class163.method3466(var8, 3, 0.0F, true, 1.0F, true, var9);
								if (var10 == 1) {
									var7 = var9[0];
								} else {
									var7 = 0.0F;
								}
							}

							var12 = (var0.field1462[1] + var7 * (var7 * var0.field1462[3] + var0.field1462[2])) * var7 + var0.field1462[0];
						}

						return var12;
					} else {
						return class28.method410(var0, var1);
					}
				}
			}
		} else {
			return 0.0F;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;I)I",
		garbageValue = "1727737026"
	)
	static int method642(AbstractArchive var0, AbstractArchive var1) {
		int var2 = 0;
		String[] var3 = Login.field896;

		int var4;
		String var5;
		for (var4 = 0; var4 < var3.length; ++var4) {
			var5 = var3[var4];
			if (var0.tryLoadFileByNames(var5, "")) {
				++var2;
			}
		}

		var3 = Login.field927;

		for (var4 = 0; var4 < var3.length; ++var4) {
			var5 = var3[var4];
			if (var1.tryLoadFileByNames(var5, "")) {
				++var2;
			}
		}

		return var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "-848662673"
	)
	static long method630() {
		try {
			URL var0 = new URL(SecureRandomCallable.method2205("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while(var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-135389463"
	)
	static void method639(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "43898482"
	)
	static void method640() {
		ItemContainer.itemContainers = new NodeHashTable(32);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Lqq;J)V"
	)
	static void method643(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.writeShort((int)var1);
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	static void method647() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (FloorOverlayDefinition.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = Calendar.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = SpotAnimationDefinition.getWidget(var4);
					if (var5 != null) {
						class403.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
