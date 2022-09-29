import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class202 {
	@ObfuscatedName("hs")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "[Ldj;"
	)
	class116[] field2398;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -130963285
	)
	int field2399;

	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V"
	)
	class202(Buffer var1, int var2) {
		this.field2398 = new class116[var2];
		this.field2399 = var1.readUnsignedByte();

		for (int var3 = 0; var3 < this.field2398.length; ++var3) {
			class116 var4 = new class116(this.field2399, var1, false);
			this.field2398[var3] = var4;
		}

		this.method4246();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "383"
	)
	void method4246() {
		class116[] var1 = this.field2398;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class116 var3 = var1[var2];
			if (var3.field1435 >= 0) {
				var3.field1429 = this.field2398[var3.field1435];
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-35"
	)
	public int method4231() {
		return this.field2398.length;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IB)Ldj;",
		garbageValue = "-119"
	)
	class116 method4232(int var1) {
		return var1 >= this.method4231() ? null : this.field2398[var1];
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldj;",
		garbageValue = "-93858276"
	)
	class116[] method4241() {
		return this.field2398;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Ldy;II)V",
		garbageValue = "1751066855"
	)
	void method4230(class123 var1, int var2) {
		this.method4235(var1, var2, (boolean[])null, false);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Ldy;I[ZZI)V",
		garbageValue = "1903455852"
	)
	void method4235(class123 var1, int var2, boolean[] var3, boolean var4) {
		int var5 = var1.method2945();
		int var6 = 0;
		class116[] var7 = this.method4241();

		for (int var8 = 0; var8 < var7.length; ++var8) {
			class116 var9 = var7[var8];
			if (var3 == null || var4 == var3[var6]) {
				var1.method2930(var2, var9, var6, var5);
			}

			++var6;
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(ILkz;ZB)V",
		garbageValue = "10"
	)
	static void method4236(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = UserComparator10.getWorldMap().getMapArea(var0);
		int var4 = class67.localPlayer.plane;
		int var5 = class128.baseX * 64 + (class67.localPlayer.x >> 7);
		int var6 = WorldMapData_1.baseY * 64 + (class67.localPlayer.y >> 7);
		Coord var7 = new Coord(var4, var5, var6);
		UserComparator10.getWorldMap().method7430(var3, var7, var1, var2);
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2088105953"
	)
	@Export("load")
	static void load() {
		int var23;
		if (Client.titleLoadingStage == 0) {
			MusicPatchNode.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var23 = 0; var23 < 4; ++var23) {
				Client.collisionMaps[var23] = new CollisionMap(104, 104);
			}

			class11.sceneMinimapSprite = new SpritePixels(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			DevicePcmPlayerProvider.archive5 = class440.newArchive(0, false, true, true, false);
			HorizontalAlignment.field1926 = class440.newArchive(1, false, true, true, false);
			class119.archive2 = class440.newArchive(2, true, false, true, false);
			class301.archive7 = class440.newArchive(3, false, true, true, false);
			UserComparator10.archive4 = class440.newArchive(4, false, true, true, false);
			class434.archive9 = class440.newArchive(5, true, true, true, false);
			class14.archive6 = class440.newArchive(6, true, true, true, false);
			FaceNormal.archive11 = class440.newArchive(7, false, true, true, false);
			ChatChannel.archive8 = class440.newArchive(8, false, true, true, false);
			class83.field1081 = class440.newArchive(9, false, true, true, false);
			class163.archive10 = class440.newArchive(10, false, true, true, false);
			class283.field3325 = class440.newArchive(11, false, true, true, false);
			class102.archive12 = class440.newArchive(12, false, true, true, false);
			UserList.archive13 = class440.newArchive(13, true, false, true, false);
			class14.archive14 = class440.newArchive(14, false, true, true, false);
			class19.archive15 = class440.newArchive(15, false, true, true, false);
			HealthBar.archive17 = class440.newArchive(17, true, true, true, false);
			class67.archive18 = class440.newArchive(18, false, true, true, false);
			UserComparator10.archive19 = class440.newArchive(19, false, true, true, false);
			Huffman.archive20 = class440.newArchive(20, false, true, true, false);
			PcmPlayer.field308 = class440.newArchive(21, false, true, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var33 = 0;
			var23 = var33 + DevicePcmPlayerProvider.archive5.percentage() * 4 / 100;
			var23 += HorizontalAlignment.field1926.percentage() * 4 / 100;
			var23 += class119.archive2.percentage() * 2 / 100;
			var23 += class301.archive7.percentage() * 2 / 100;
			var23 += UserComparator10.archive4.percentage() * 6 / 100;
			var23 += class434.archive9.percentage() * 4 / 100;
			var23 += class14.archive6.percentage() * 2 / 100;
			var23 += FaceNormal.archive11.percentage() * 55 / 100;
			var23 += ChatChannel.archive8.percentage() * 2 / 100;
			var23 += class83.field1081.percentage() * 2 / 100;
			var23 += class163.archive10.percentage() * 2 / 100;
			var23 += class283.field3325.percentage() * 2 / 100;
			var23 += class102.archive12.percentage() * 2 / 100;
			var23 += UserList.archive13.percentage() * 2 / 100;
			var23 += class14.archive14.percentage() * 2 / 100;
			var23 += class19.archive15.percentage() * 2 / 100;
			var23 += UserComparator10.archive19.percentage() / 100;
			var23 += class67.archive18.percentage() / 100;
			var23 += Huffman.archive20.percentage() / 100;
			var23 += PcmPlayer.field308.percentage() / 100;
			var23 += HealthBar.archive17.method5963() && HealthBar.archive17.isFullyLoaded() ? 1 : 0;
			if (var23 != 100) {
				if (var23 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var23 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class122.method2926(DevicePcmPlayerProvider.archive5, "Animations");
				class122.method2926(HorizontalAlignment.field1926, "Skeletons");
				class122.method2926(UserComparator10.archive4, "Sound FX");
				class122.method2926(class434.archive9, "Maps");
				class122.method2926(class14.archive6, "Music Tracks");
				class122.method2926(FaceNormal.archive11, "Models");
				class122.method2926(ChatChannel.archive8, "Sprites");
				class122.method2926(class283.field3325, "Music Jingles");
				class122.method2926(class14.archive14, "Music Samples");
				class122.method2926(class19.archive15, "Music Patches");
				class122.method2926(UserComparator10.archive19, "World Map");
				class122.method2926(class67.archive18, "World Map Geography");
				class122.method2926(Huffman.archive20, "World Map Ground");
				class271.spriteIds = new GraphicsDefaults();
				class271.spriteIds.decode(HealthBar.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else {
			Archive var24;
			Archive var25;
			Archive var26;
			if (Client.titleLoadingStage == 45) {
				class166.method3490(22050, !Client.isLowDetail, 2);
				MidiPcmStream var30 = new MidiPcmStream();
				var30.method5495(9, 128);
				class241.pcmPlayer0 = WorldMapSection0.method5064(class11.taskHandler, 0, 22050);
				class241.pcmPlayer0.setStream(var30);
				var24 = class19.archive15;
				var25 = class14.archive14;
				var26 = UserComparator10.archive4;
				class274.musicPatchesArchive = var24;
				class274.musicSamplesArchive = var25;
				class274.soundEffectsArchive = var26;
				class139.midiPcmStream = var30;
				Client.pcmPlayer1 = WorldMapSection0.method5064(class11.taskHandler, 1, 2048);
				class16.pcmStreamMixer = new PcmStreamMixer();
				Client.pcmPlayer1.setStream(class16.pcmStreamMixer);
				class327.decimator = new Decimator(22050, PcmPlayer.field307);
				Login.Login_loadingText = "Prepared sound engine";
				Login.Login_loadingPercent = 35;
				Client.titleLoadingStage = 50;
				FloorOverlayDefinition.WorldMapElement_fonts = new Fonts(ChatChannel.archive8, UserList.archive13);
			} else {
				int var1;
				if (Client.titleLoadingStage == 50) {
					FontName[] var29 = new FontName[]{FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_plain11, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_verdana13};
					var1 = var29.length;
					Fonts var31 = FloorOverlayDefinition.WorldMapElement_fonts;
					FontName[] var32 = new FontName[]{FontName.FontName_bold12, FontName.FontName_plain12, FontName.FontName_plain11, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_verdana13};
					Client.fontsMap = var31.createMap(var32);
					if (Client.fontsMap.size() < var1) {
						Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
						Login.Login_loadingPercent = 40;
					} else {
						class156.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
						class1.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
						class29.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
						class9.platformInfo = Client.platformInfoProvider.get();
						Login.Login_loadingText = "Loaded fonts";
						Login.Login_loadingPercent = 40;
						Client.titleLoadingStage = 60;
					}
				} else if (Client.titleLoadingStage == 60) {
					var23 = class33.method642(class163.archive10, ChatChannel.archive8);
					var1 = Login.field896.length + Login.field927.length;
					if (var23 < var1) {
						Login.Login_loadingText = "Loading title screen - " + var23 * 100 / var1 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						Coord.updateGameState(5);
						Client.titleLoadingStage = 70;
					}
				} else if (Client.titleLoadingStage != 70) {
					if (Client.titleLoadingStage == 80) {
						var23 = 0;
						if (class14.compass == null) {
							class14.compass = class114.SpriteBuffer_getSprite(ChatChannel.archive8, class271.spriteIds.compass, 0);
						} else {
							++var23;
						}

						if (GraphicsObject.redHintArrowSprite == null) {
							GraphicsObject.redHintArrowSprite = class114.SpriteBuffer_getSprite(ChatChannel.archive8, class271.spriteIds.field4408, 0);
						} else {
							++var23;
						}

						if (WorldMapArea.mapSceneSprites == null) {
							WorldMapArea.mapSceneSprites = class390.method7253(ChatChannel.archive8, class271.spriteIds.mapScenes, 0);
						} else {
							++var23;
						}

						if (class6.headIconPkSprites == null) {
							class6.headIconPkSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.headIconsPk, 0);
						} else {
							++var23;
						}

						if (class28.headIconPrayerSprites == null) {
							class28.headIconPrayerSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.field4411, 0);
						} else {
							++var23;
						}

						if (class135.headIconHintSprites == null) {
							class135.headIconHintSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.field4417, 0);
						} else {
							++var23;
						}

						if (class97.mapMarkerSprites == null) {
							class97.mapMarkerSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.field4407, 0);
						} else {
							++var23;
						}

						if (SpotAnimationDefinition.crossSprites == null) {
							SpotAnimationDefinition.crossSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.field4413, 0);
						} else {
							++var23;
						}

						if (class296.mapDotSprites == null) {
							class296.mapDotSprites = AbstractRasterProvider.method8301(ChatChannel.archive8, class271.spriteIds.field4414, 0);
						} else {
							++var23;
						}

						if (ChatChannel.scrollBarSprites == null) {
							ChatChannel.scrollBarSprites = class390.method7253(ChatChannel.archive8, class271.spriteIds.field4416, 0);
						} else {
							++var23;
						}

						if (class65.modIconSprites == null) {
							class65.modIconSprites = class390.method7253(ChatChannel.archive8, class271.spriteIds.field4415, 0);
						} else {
							++var23;
						}

						if (var23 < 11) {
							Login.Login_loadingText = "Loading sprites - " + var23 * 100 / 12 + "%";
							Login.Login_loadingPercent = 70;
						} else {
							AbstractFont.AbstractFont_modIconSprites = class65.modIconSprites;
							GraphicsObject.redHintArrowSprite.normalize();
							var1 = (int)(Math.random() * 21.0D) - 10;
							int var2 = (int)(Math.random() * 21.0D) - 10;
							int var3 = (int)(Math.random() * 21.0D) - 10;
							int var4 = (int)(Math.random() * 41.0D) - 20;
							WorldMapArea.mapSceneSprites[0].shiftColors(var4 + var1, var4 + var2, var4 + var3);
							Login.Login_loadingText = "Loaded sprites";
							Login.Login_loadingPercent = 70;
							Client.titleLoadingStage = 90;
						}
					} else if (Client.titleLoadingStage == 90) {
						if (!class83.field1081.isFullyLoaded()) {
							Login.Login_loadingText = "Loading textures - " + "0%";
							Login.Login_loadingPercent = 90;
						} else {
							class130.textureProvider = new TextureProvider(class83.field1081, ChatChannel.archive8, 20, Player.clientPreferences.method2387(), Client.isLowDetail ? 64 : 128);
							Rasterizer3D.Rasterizer3D_setTextureLoader(class130.textureProvider);
							Rasterizer3D.Rasterizer3D_setBrightness(Player.clientPreferences.method2387());
							Client.titleLoadingStage = 100;
						}
					} else if (Client.titleLoadingStage == 100) {
						var23 = class130.textureProvider.getLoadedPercentage();
						if (var23 < 100) {
							Login.Login_loadingText = "Loading textures - " + var23 + "%";
							Login.Login_loadingPercent = 90;
						} else {
							Login.Login_loadingText = "Loaded textures";
							Login.Login_loadingPercent = 90;
							Client.titleLoadingStage = 110;
						}
					} else if (Client.titleLoadingStage == 110) {
						class268.mouseRecorder = new MouseRecorder();
						class11.taskHandler.newThreadTask(class268.mouseRecorder, 10);
						Login.Login_loadingText = "Loaded input handler";
						Login.Login_loadingPercent = 92;
						Client.titleLoadingStage = 120;
					} else if (Client.titleLoadingStage == 120) {
						if (!class163.archive10.tryLoadFileByNames("huffman", "")) {
							Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
							Login.Login_loadingPercent = 94;
						} else {
							Huffman var28 = new Huffman(class163.archive10.takeFileByNames("huffman", ""));
							class283.huffman = var28;
							Login.Login_loadingText = "Loaded wordpack";
							Login.Login_loadingPercent = 94;
							Client.titleLoadingStage = 130;
						}
					} else if (Client.titleLoadingStage == 130) {
						if (!class301.archive7.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + class301.archive7.loadPercent() * 4 / 5 + "%";
							Login.Login_loadingPercent = 96;
						} else if (!class102.archive12.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (80 + class102.archive12.loadPercent() / 6) + "%";
							Login.Login_loadingPercent = 96;
						} else if (!UserList.archive13.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (96 + UserList.archive13.loadPercent() / 50) + "%";
							Login.Login_loadingPercent = 96;
						} else {
							Login.Login_loadingText = "Loaded interfaces";
							Login.Login_loadingPercent = 98;
							Client.titleLoadingStage = 140;
						}
					} else if (Client.titleLoadingStage == 140) {
						Login.Login_loadingPercent = 100;
						if (!UserComparator10.archive19.tryLoadGroupByName(WorldMapCacheName.field2896.name)) {
							Login.Login_loadingText = "Loading world map - " + UserComparator10.archive19.groupLoadPercentByName(WorldMapCacheName.field2896.name) / 10 + "%";
						} else {
							if (Decimator.worldMap == null) {
								Decimator.worldMap = new WorldMap();
								Decimator.worldMap.init(UserComparator10.archive19, class67.archive18, Huffman.archive20, class29.fontBold12, Client.fontsMap, WorldMapArea.mapSceneSprites);
							}

							Login.Login_loadingText = "Loaded world map";
							Client.titleLoadingStage = 150;
						}
					} else if (Client.titleLoadingStage == 150) {
						Coord.updateGameState(10);
					}
				} else if (!class119.archive2.isFullyLoaded()) {
					Login.Login_loadingText = "Loading config - " + class119.archive2.loadPercent() + "%";
					Login.Login_loadingPercent = 60;
				} else if (!PcmPlayer.field308.isFullyLoaded()) {
					Login.Login_loadingText = "Loading config - " + (80 + class102.archive12.loadPercent() / 6) + "%";
					Login.Login_loadingPercent = 60;
				} else {
					class12.method178(class119.archive2);
					Archive var0 = class119.archive2;
					FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
					var24 = class119.archive2;
					var25 = FaceNormal.archive11;
					KitDefinition.KitDefinition_archive = var24;
					class431.KitDefinition_modelsArchive = var25;
					KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
					TaskHandler.method3429(class119.archive2, FaceNormal.archive11, Client.isLowDetail);
					var26 = class119.archive2;
					Archive var27 = FaceNormal.archive11;
					NPCComposition.NpcDefinition_archive = var26;
					NPCComposition.NpcDefinition_modelArchive = var27;
					class124.method2964(class119.archive2);
					FloorUnderlayDefinition.method3700(class119.archive2, FaceNormal.archive11, Client.isMembersWorld, class156.fontPlain11);
					Archive var5 = class119.archive2;
					Archive var6 = DevicePcmPlayerProvider.archive5;
					Archive var7 = HorizontalAlignment.field1926;
					SequenceDefinition.SequenceDefinition_archive = var5;
					JagexCache.SequenceDefinition_animationsArchive = var6;
					SequenceDefinition.SequenceDefinition_skeletonsArchive = var7;
					class28.method415(class119.archive2, FaceNormal.archive11);
					Archive var8 = class119.archive2;
					VarbitComposition.VarbitDefinition_archive = var8;
					Archive var9 = class119.archive2;
					VarpDefinition.VarpDefinition_archive = var9;
					VarpDefinition.field1841 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
					Archive var10 = class301.archive7;
					Archive var11 = FaceNormal.archive11;
					Archive var12 = ChatChannel.archive8;
					Archive var13 = UserList.archive13;
					MouseHandler.Widget_archive = var10;
					WorldMapSection2.Widget_modelsArchive = var11;
					Widget.Widget_spritesArchive = var12;
					class161.Widget_fontsArchive = var13;
					Calendar.Widget_interfaceComponents = new Widget[MouseHandler.Widget_archive.getGroupCount()][];
					class83.Widget_loadedInterfaces = new boolean[MouseHandler.Widget_archive.getGroupCount()];
					class182.method3702(class119.archive2);
					class7.method69(class119.archive2);
					Varcs.method2633(class119.archive2);
					Archive var14 = class119.archive2;
					Archive var15 = class119.archive2;
					ParamComposition.ParamDefinition_archive = var15;
					class399.method7302(class119.archive2);
					class11.method120(class119.archive2);
					class127.HitSplatDefinition_cachedSprites = new class429(class153.field1729, 54, class271.clientLanguage, class119.archive2);
					class150.HitSplatDefinition_cached = new class429(class153.field1729, 47, class271.clientLanguage, class119.archive2);
					LoginType.varcs = new Varcs();
					Archive var16 = class119.archive2;
					Archive var17 = ChatChannel.archive8;
					Archive var18 = UserList.archive13;
					HitSplatDefinition.HitSplatDefinition_archive = var16;
					HitSplatDefinition.field2049 = var17;
					Username.HitSplatDefinition_fontsArchive = var18;
					ArchiveLoader.method2211(class119.archive2, ChatChannel.archive8);
					Archive var19 = class119.archive2;
					Archive var20 = ChatChannel.archive8;
					WorldMapElement.WorldMapElement_archive = var20;
					if (var19.isFullyLoaded()) {
						WorldMapElement.WorldMapElement_count = var19.getGroupFileCount(35);
						WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

						for (int var21 = 0; var21 < WorldMapElement.WorldMapElement_count; ++var21) {
							byte[] var22 = var19.takeFile(35, var21);
							WorldMapElement.WorldMapElement_cached[var21] = new WorldMapElement(var21);
							if (var22 != null) {
								WorldMapElement.WorldMapElement_cached[var21].decode(new Buffer(var22));
								WorldMapElement.WorldMapElement_cached[var21].method3538();
							}
						}
					}

					Login.Login_loadingText = "Loaded config";
					Login.Login_loadingPercent = 60;
					Client.titleLoadingStage = 80;
				}
			}
		}
	}
}
