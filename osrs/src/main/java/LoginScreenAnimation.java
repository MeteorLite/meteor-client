import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "[Lqu;"
	)
	IndexedSprite[] field1227;
	@ObfuscatedName("s")
	int[] field1212;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 352288685
	)
	int field1216;
	@ObfuscatedName("m")
	int[] field1217;
	@ObfuscatedName("x")
	int[] field1218;
	@ObfuscatedName("j")
	int[] field1219;
	@ObfuscatedName("v")
	int[] field1220;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -706104967
	)
	int field1213;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -400222839
	)
	int field1222;
	@ObfuscatedName("u")
	int[] field1223;
	@ObfuscatedName("d")
	int[] field1224;
	@ObfuscatedName("b")
	int[] field1214;
	@ObfuscatedName("a")
	int[] field1215;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -92322127
	)
	int field1221;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1619933712
	)
	int field1228;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 990926517
	)
	int field1229;

	@ObfuscatedSignature(
		descriptor = "([Lqu;)V"
	)
	LoginScreenAnimation(IndexedSprite[] var1) {
		this.field1212 = new int[256];
		this.field1216 = 0;
		this.field1213 = 0;
		this.field1222 = 0;
		this.field1221 = 0;
		this.field1228 = 0;
		this.field1229 = 0;
		this.field1227 = var1;
		this.initColors();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "255"
	)
	@Export("initColors")
	void initColors() {
		this.field1218 = new int[256];

		int var1;
		for (var1 = 0; var1 < 64; ++var1) {
			this.field1218[var1] = var1 * 262144;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1218[var1 + 64] = var1 * 1024 + 16711680;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1218[var1 + 128] = var1 * 4 + 16776960;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1218[var1 + 192] = 16777215;
		}

		this.field1219 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1219[var1] = var1 * 1024;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1219[var1 + 64] = var1 * 4 + 65280;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1219[var1 + 128] = var1 * 262144 + 65535;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1219[var1 + 192] = 16777215;
		}

		this.field1220 = new int[256];

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1220[var1] = var1 * 4;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1220[var1 + 64] = var1 * 262144 + 255;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1220[var1 + 128] = var1 * 1024 + 16711935;
		}

		for (var1 = 0; var1 < 64; ++var1) {
			this.field1220[var1 + 192] = 16777215;
		}

		this.field1217 = new int[256];
		this.field1221 = 0;
		this.field1214 = new int[32768];
		this.field1215 = new int[32768];
		this.method2357((IndexedSprite)null);
		this.field1223 = new int[32768];
		this.field1224 = new int[32768];
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "2"
	)
	void method2356() {
		this.field1218 = null;
		this.field1219 = null;
		this.field1220 = null;
		this.field1217 = null;
		this.field1214 = null;
		this.field1215 = null;
		this.field1223 = null;
		this.field1224 = null;
		this.field1221 = 0;
		this.field1228 = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1216071083"
	)
	@Export("draw")
	void draw(int var1, int var2) {
		if (this.field1223 == null) {
			this.initColors();
		}

		if (this.field1229 == 0) {
			this.field1229 = var2;
		}

		int var3 = var2 - this.field1229;
		if (var3 >= 256) {
			var3 = 0;
		}

		this.field1229 = var2;
		if (var3 > 0) {
			this.method2358(var3);
		}

		this.method2382(var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-66"
	)
	final void method2358(int var1) {
		this.field1221 += 128 * var1;
		int var2;
		if (this.field1221 > this.field1214.length) {
			this.field1221 -= this.field1214.length;
			var2 = (int)(Math.random() * 12.0D);
			this.method2357(this.field1227[var2]);
		}

		var2 = 0;
		int var3 = var1 * 128;
		int var4 = (256 - var1) * 128;

		int var6;
		for (int var5 = 0; var5 < var4; ++var5) {
			var6 = this.field1223[var2 + var3] - this.field1214[var2 + this.field1221 & this.field1214.length - 1] * var1 / 6;
			if (var6 < 0) {
				var6 = 0;
			}

			this.field1223[var2++] = var6;
		}

		byte var15 = 10;
		var6 = 128 - var15;

		int var7;
		int var10;
		for (var7 = 256 - var1; var7 < 256; ++var7) {
			int var8 = var7 * 128;

			for (int var9 = 0; var9 < 128; ++var9) {
				var10 = (int)(Math.random() * 100.0D);
				if (var10 < 50 && var9 > var15 && var9 < var6) {
					this.field1223[var9 + var8] = 255;
				} else {
					this.field1223[var9 + var8] = 0;
				}
			}
		}

		if (this.field1213 * 16 > 0) {
			this.field1213 = this.field1213 * 16 - var1 * 4;
		}

		if (this.field1222 * 16 > 0) {
			this.field1222 = this.field1222 * 16 - var1 * 4;
		}

		if (this.field1213 * 16 == 0 && this.field1222 * 16 == 0) {
			var7 = (int)(Math.random() * (double)(2000 / var1));
			if (var7 == 0) {
				this.field1213 = 1024;
			}

			if (var7 == 1) {
				this.field1222 = 1024;
			}
		}

		for (var7 = 0; var7 < 256 - var1; ++var7) {
			this.field1212[var7] = this.field1212[var7 + var1];
		}

		for (var7 = 256 - var1; var7 < 256; ++var7) {
			this.field1212[var7] = (int)(Math.sin((double)this.field1216 / 14.0D) * 16.0D + Math.sin((double)this.field1216 / 15.0D) * 14.0D + Math.sin((double)this.field1216 / 16.0D) * 12.0D);
			++this.field1216;
		}

		this.field1228 = this.field1228 * 10000 + var1 * 10000;
		var7 = ((Client.cycle & 1) + var1) / 2;
		if (var7 > 0) {
			short var16 = 128;
			byte var17 = 2;
			var10 = 128 - var17 - var17;

			int var11;
			int var12;
			int var13;
			for (var11 = 0; var11 < this.field1228 * 100; ++var11) {
				var12 = (int)(Math.random() * (double)var10) + var17;
				var13 = (int)(Math.random() * (double)var16) + var16;
				this.field1223[var12 + (var13 << 7)] = 192;
			}

			this.field1228 = 0;

			int var14;
			for (var11 = 0; var11 < 256; ++var11) {
				var12 = 0;
				var13 = var11 * 128;

				for (var14 = -var7; var14 < 128; ++var14) {
					if (var7 + var14 < 128) {
						var12 += this.field1223[var14 + var13 + var7];
					}

					if (var14 - (var7 + 1) >= 0) {
						var12 -= this.field1223[var14 + var13 - (var7 + 1)];
					}

					if (var14 >= 0) {
						this.field1224[var14 + var13] = var12 / (var7 * 2 + 1);
					}
				}
			}

			for (var11 = 0; var11 < 128; ++var11) {
				var12 = 0;

				for (var13 = -var7; var13 < 256; ++var13) {
					var14 = var13 * 128;
					if (var13 + var7 < 256) {
						var12 += this.field1224[var14 + var11 + var7 * 128];
					}

					if (var13 - (var7 + 1) >= 0) {
						var12 -= this.field1224[var11 + var14 - (var7 + 1) * 128];
					}

					if (var13 >= 0) {
						this.field1223[var11 + var14] = var12 / (var7 * 2 + 1);
					}
				}
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "1448503937"
	)
	final int method2359(int var1, int var2, int var3) {
		int var4 = 256 - var3;
		return (var3 * (var2 & 65280) + var4 * (var1 & 65280) & 16711680) + (var3 * (var2 & 16711935) + var4 * (var1 & 16711935) & -16711936) >> 8;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "98"
	)
	final void method2382(int var1) {
		int var2 = this.field1217.length;
		if (this.field1213 * 16 > 0) {
			this.method2360(this.field1213 * 16, this.field1219);
		} else if (this.field1222 * 16 > 0) {
			this.method2360(this.field1222 * 16, this.field1220);
		} else {
			for (int var3 = 0; var3 < var2; ++var3) {
				this.field1217[var3] = this.field1218[var3];
			}
		}

		this.method2361(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I[IB)V",
		garbageValue = "37"
	)
	final void method2360(int var1, int[] var2) {
		int var3 = this.field1217.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (var1 > 768) {
				this.field1217[var4] = this.method2359(this.field1218[var4], var2[var4], 1024 - var1);
			} else if (var1 > 256) {
				this.field1217[var4] = var2[var4];
			} else {
				this.field1217[var4] = this.method2359(var2[var4], this.field1218[var4], 256 - var1);
			}
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "46"
	)
	final void method2361(int var1) {
		int var2 = 0;

		for (int var3 = 1; var3 < 255; ++var3) {
			int var4 = (256 - var3) * this.field1212[var3] / 256;
			int var5 = var4 + var1;
			int var6 = 0;
			int var7 = 128;
			if (var5 < 0) {
				var6 = -var5;
				var5 = 0;
			}

			if (var5 + 128 >= class20.rasterProvider.width) {
				var7 = class20.rasterProvider.width - var5;
			}

			int var8 = var5 + (var3 + 8) * class20.rasterProvider.width;
			var2 += var6;

			for (int var9 = var6; var9 < var7; ++var9) {
				int var10 = this.field1223[var2++];
				int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
				if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
					int var12 = var10;
					int var13 = 256 - var10;
					var10 = this.field1217[var10];
					int var14 = class20.rasterProvider.pixels[var8];
					class20.rasterProvider.pixels[var8++] = -16777216 | ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var13 * (var14 & 65280) + var12 * (var10 & 65280) & 16711680) >> 8;
				} else {
					++var8;
				}
			}

			var2 += 128 - var7;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(Lqu;I)V",
		garbageValue = "192117785"
	)
	final void method2357(IndexedSprite var1) {
		int var2;
		for (var2 = 0; var2 < this.field1214.length; ++var2) {
			this.field1214[var2] = 0;
		}

		int var3;
		for (var2 = 0; var2 < 5000; ++var2) {
			var3 = (int)(Math.random() * 128.0D * 256.0D);
			this.field1214[var3] = (int)(Math.random() * 256.0D);
		}

		int var4;
		int var5;
		for (var2 = 0; var2 < 20; ++var2) {
			for (var3 = 1; var3 < 255; ++var3) {
				for (var4 = 1; var4 < 127; ++var4) {
					var5 = var4 + (var3 << 7);
					this.field1215[var5] = (this.field1214[var5 - 128] + this.field1214[var5 + 1] + this.field1214[var5 + 128] + this.field1214[var5 - 1]) / 4;
				}
			}

			int[] var8 = this.field1214;
			this.field1214 = this.field1215;
			this.field1215 = var8;
		}

		if (var1 != null) {
			var2 = 0;

			for (var3 = 0; var3 < var1.subHeight; ++var3) {
				for (var4 = 0; var4 < var1.subWidth; ++var4) {
					if (var1.pixels[var2++] != 0) {
						var5 = var4 + var1.xOffset + 16;
						int var6 = var3 + var1.yOffset + 16;
						int var7 = var5 + (var6 << 7);
						this.field1214[var7] = 0;
					}
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;ZII)V",
		garbageValue = "1346716690"
	)
	static void method2375(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.clearLoginScreen) {
			if (var3 == 4) {
				class139.method3101(4);
			}

		} else {
			if (var3 == 0) {
				ObjectSound.method1848(var2);
			} else {
				class139.method3101(var3);
			}

			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			TextureProvider.leftTitleSprite = class21.method322(var4);
			PcmPlayer.rightTitleSprite = TextureProvider.leftTitleSprite.mirrorHorizontally();
			Player.method2322(var1, Client.worldProperties);
			Login.titleboxSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Calendar.field3331 = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
			class147.field1693 = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
			WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
			DevicePcmPlayerProvider.runesSprite = SpriteMask.method5693(var1, "runes", "");
			LoginType.title_muteSprite = SpriteMask.method5693(var1, "title_mute", "");
			WorldMapDecoration.options_buttons_0Sprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			SoundSystem.field324 = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			UserComparator7.options_buttons_2Sprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			class116.field1428 = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			ReflectionCheck.field256 = WorldMapDecoration.options_buttons_0Sprite.subWidth;
			WorldMapID.field2874 = WorldMapDecoration.options_buttons_0Sprite.subHeight;
			VertexNormal.field2637 = new LoginScreenAnimation(DevicePcmPlayerProvider.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
				Login.field907 = new String[8];
				Login.field891 = 0;
			}

			class347.field4201 = 0;
			class28.otp = "";
			Login.field916 = true;
			Login.worldSelectOpen = false;
			if (!Player.clientPreferences.method2393()) {
				Archive var5 = class14.archive6;
				int var6 = var5.getGroupId("scape main");
				int var7 = var5.getFileId(var6, "");
				class274.musicPlayerStatus = 1;
				class274.musicTrackArchive = var5;
				class274.musicTrackGroupId = var6;
				StructComposition.musicTrackFileId = var7;
				class269.musicTrackVolume = 255;
				TriBool.musicTrackBoolean = false;
				VarcInt.pcmSampleLength = 2;
			} else {
				TaskHandler.method3435(2);
			}

			class117.method2859(false);
			Login.clearLoginScreen = true;
			Login.xPadding = (class123.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			ModeWhere.loginBoxCenter = Login.loginBoxX + 180;
			TextureProvider.leftTitleSprite.drawAt(Login.xPadding, 0);
			PcmPlayer.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			MilliClock.logoSprite.drawAt(Login.xPadding + 382 - MilliClock.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2068729513"
	)
	static void method2379() {
		if (Decimator.worldMap != null) {
			Decimator.worldMap.method7508(Tiles.Client_plane, class128.baseX * 64 + (class67.localPlayer.x >> 7), WorldMapData_1.baseY * 64 + (class67.localPlayer.y >> 7), false);
			Decimator.worldMap.loadCache();
		}

	}
}
