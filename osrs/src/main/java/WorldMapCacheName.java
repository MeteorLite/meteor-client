import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("jz")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final WorldMapCacheName field2095;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final WorldMapCacheName field2093;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final WorldMapCacheName field2094;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	static final WorldMapCacheName field2097;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ljz;"
	)
	public static final WorldMapCacheName field2092;
	@ObfuscatedName("gt")
	@Export("worldPort")
	static int worldPort;
	@ObfuscatedName("au")
	@Export("name")
	public final String name;

	static {
		field2095 = new WorldMapCacheName("details");
		field2093 = new WorldMapCacheName("compositemap");
		field2094 = new WorldMapCacheName("compositetexture");
		field2097 = new WorldMapCacheName("area");
		field2092 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Luz;",
		garbageValue = "-120"
	)
	static SpritePixels method1353() {
		SpritePixels var0 = new SpritePixels();
		var0.width = class541.SpriteBuffer_spriteWidth;
		var0.height = GrandExchangeOfferWorldComparator.SpriteBuffer_spriteHeight;
		var0.xOffset = class541.SpriteBuffer_xOffsets[0];
		var0.yOffset = class541.SpriteBuffer_yOffsets[0];
		var0.subWidth = class541.SpriteBuffer_spriteWidths[0];
		var0.subHeight = class520.SpriteBuffer_spriteHeights[0];
		int var1 = var0.subHeight * var0.subWidth;
		byte[] var2 = class396.SpriteBuffer_pixels[0];
		var0.pixels = new int[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var0.pixels[var3] = class541.SpriteBuffer_spritePalette[var2[var3] & 255];
		}

		class458.method2306();
		return var0;
	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1839929572"
	)
	static void method1354() {
		int var0;
		if (Client.field414 == class92.field942) {
			class36.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			class102.sceneMinimapSprite = new SpritePixels(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.field414 = class92.field935;
		} else if (Client.field414 == class92.field935) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.field414 = class92.field940;
		} else if (class92.field940 == Client.field414) {
			UserComparator7.field1190 = Skeleton.newArchive(0, false, true, true, false);
			class145.field1338 = Skeleton.newArchive(1, false, true, true, false);
			class344.archive2 = Skeleton.newArchive(2, true, false, true, false);
			class313.archive4 = Skeleton.newArchive(3, false, true, true, false);
			Language.field3643 = Skeleton.newArchive(4, false, true, true, false);
			WorldMapSection0.archive9 = Skeleton.newArchive(5, true, true, true, false);
			class514.archive6 = Skeleton.newArchive(6, true, true, true, false);
			class19.field59 = Skeleton.newArchive(7, false, true, true, false);
			GrandExchangeOfferOwnWorldComparator.archive8 = Skeleton.newArchive(8, false, true, true, false);
			Canvas.field68 = Skeleton.newArchive(9, false, true, true, false);
			WorldMapDecorationType.archive10 = Skeleton.newArchive(10, false, true, true, false);
			PcmPlayer.field181 = Skeleton.newArchive(11, false, true, true, false);
			class47.archive12 = Skeleton.newArchive(12, false, true, true, false);
			VarbitComposition.archive13 = Skeleton.newArchive(13, true, false, true, false);
			StructComposition.field1637 = Skeleton.newArchive(14, false, true, true, false);
			class7.field12 = Skeleton.newArchive(15, false, true, true, false);
			SoundSystem.field209 = Skeleton.newArchive(17, true, true, true, false);
			BuddyRankComparator.field1200 = Skeleton.newArchive(18, false, true, true, false);
			SpotAnimationDefinition.field1597 = Skeleton.newArchive(19, false, true, true, false);
			WorldMapData_0.field1938 = Skeleton.newArchive(20, false, true, true, false);
			class267.field2224 = Skeleton.newArchive(21, false, true, true, false);
			WorldMapAreaData.field2099 = SequenceDefinition.method1054(22, false, true, true, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.field414 = class92.field938;
		} else if (class92.field938 == Client.field414) {
			byte var42 = 0;
			var0 = var42 + UserComparator7.field1190.percentage() * 4 / 100;
			var0 += class145.field1338.percentage() * 4 / 100;
			var0 += class344.archive2.percentage() * 2 / 100;
			var0 += class313.archive4.percentage() * 2 / 100;
			var0 += Language.field3643.percentage() * 6 / 100;
			var0 += WorldMapSection0.archive9.percentage() * 4 / 100;
			var0 += class514.archive6.percentage() * 2 / 100;
			var0 += class19.field59.percentage() * 54 / 100;
			var0 += GrandExchangeOfferOwnWorldComparator.archive8.percentage() * 2 / 100;
			var0 += Canvas.field68.percentage() * 2 / 100;
			var0 += WorldMapDecorationType.archive10.percentage() * 2 / 100;
			var0 += PcmPlayer.field181.percentage() * 2 / 100;
			var0 += class47.archive12.percentage() * 2 / 100;
			var0 += VarbitComposition.archive13.percentage() * 2 / 100;
			var0 += StructComposition.field1637.percentage() * 2 / 100;
			var0 += class7.field12.percentage() * 2 / 100;
			var0 += SpotAnimationDefinition.field1597.percentage() / 100;
			var0 += BuddyRankComparator.field1200.percentage() / 100;
			var0 += WorldMapData_0.field1938.percentage() / 100;
			var0 += class267.field2224.percentage() / 100;
			var0 += WorldMapAreaData.field2099.percentage() / 100;
			var0 += SoundSystem.field209.method1912() && SoundSystem.field209.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class357.method1900(UserComparator7.field1190, "Animations");
				class357.method1900(class145.field1338, "Skeletons");
				class357.method1900(Language.field3643, "Sound FX");
				class357.method1900(WorldMapSection0.archive9, "Maps");
				class357.method1900(class514.archive6, "Music Tracks");
				class357.method1900(class19.field59, "Models");
				class357.method1900(GrandExchangeOfferOwnWorldComparator.archive8, "Sprites");
				class357.method1900(PcmPlayer.field181, "Music Jingles");
				class357.method1900(StructComposition.field1637, "Music Samples");
				class357.method1900(class7.field12, "Music Patches");
				class357.method1900(SpotAnimationDefinition.field1597, "World Map");
				class357.method1900(BuddyRankComparator.field1200, "World Map Geography");
				class357.method1900(WorldMapData_0.field1938, "World Map Ground");
				class376.field3614 = new GraphicsDefaults();
				class376.field3614.decode(SoundSystem.field209);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.field414 = class92.field933;
			}
		} else {
			Archive var7;
			Archive var8;
			Archive var25;
			if (class92.field933 == Client.field414) {
				boolean var41 = !Client.isLowDetail;
				PcmPlayer.field179 = 22050;
				WorldMapRectangle.PcmPlayer_stereo = var41;
				PcmPlayer.field180 = 2;
				ArrayList var34 = new ArrayList(3);
				TaskHandler var32 = GameEngine.taskHandler;
				short var40 = 2048;
				if (var40 < 256) {
					var40 = 256;
				}

				PcmPlayer var33;
				try {
					PcmPlayer var36 = PcmPlayer.pcmPlayerProvider.player();
					var36.samples = new int[256 * (WorldMapRectangle.PcmPlayer_stereo ? 2 : 1)];
					var36.field196 = var40;
					var36.init();
					var36.capacity = (var40 & -1024) + 1024;
					if (var36.capacity > 16384) {
						var36.capacity = 16384;
					}

					var36.open(var36.capacity);
					if (PcmPlayer.field180 > 0 && DelayFadeTask.soundSystem == null) {
						DelayFadeTask.soundSystem = new SoundSystem();
						class342.soundSystemExecutor = Executors.newScheduledThreadPool(1);
						class342.soundSystemExecutor.scheduleAtFixedRate(DelayFadeTask.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
					}

					if (DelayFadeTask.soundSystem != null) {
						if (DelayFadeTask.soundSystem.players[0] != null) {
							throw new IllegalArgumentException();
						}

						DelayFadeTask.soundSystem.players[0] = var36;
					}

					var33 = var36;
				} catch (Throwable var30) {
					var33 = new PcmPlayer();
				}

				MusicPatchPcmStream.pcmPlayer1 = var33;
				LoginScreenAnimation.pcmStreamMixer = new PcmStreamMixer();
				PcmStreamMixer var37 = new PcmStreamMixer();
				var37.addSubStream(LoginScreenAnimation.pcmStreamMixer);

				for (int var6 = 0; var6 < 3; ++var6) {
					MidiPcmStream var38 = new MidiPcmStream();
					var38.method1662(9, 128);
					var37.addSubStream(var38);
					var34.add(var38);
				}

				MusicPatchPcmStream.pcmPlayer1.setStream(var37);
				var25 = class7.field12;
				var7 = StructComposition.field1637;
				var8 = Language.field3643;
				class316.field2792 = var25;
				class316.field2791 = var7;
				class168.field1428 = var8;
				class316.midiPcmStream = var34;
				class521.decimator = new Decimator(22050, PcmPlayer.field179);
				Login.Login_loadingText = "Prepared sound engine";
				Login.Login_loadingPercent = 35;
				Client.field414 = class92.field943;
				class140.field1318 = new Fonts(GrandExchangeOfferOwnWorldComparator.archive8, VarbitComposition.archive13);
			} else if (Client.field414 == class92.field943) {
				var0 = FontName.method2458().length;
				Client.fontsMap = class140.field1318.createMap(FontName.method2458());
				if (Client.fontsMap.size() < var0) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					class369.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					ItemLayer.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					GrandExchangeOfferTotalQuantityComparator.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					class60.field312 = Client.field645.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.field414 = class92.field932;
				}
			} else {
				int var26;
				if (Client.field414 == class92.field932) {
					var0 = User.method2239(WorldMapDecorationType.archive10, GrandExchangeOfferOwnWorldComparator.archive8);
					var26 = class189.method954(GrandExchangeOfferOwnWorldComparator.archive8);
					if (var0 < var26) {
						Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var26 + "%";
						Login.Login_loadingPercent = 50;
					} else {
						Login.Login_loadingText = "Loaded title screen";
						Login.Login_loadingPercent = 50;
						WorldMapSection2.updateGameState(5);
						Client.field414 = class92.field934;
					}
				} else {
					Archive var2;
					boolean var4;
					if (class92.field934 != Client.field414) {
						if (class92.field937 == Client.field414) {
							var0 = 0;
							if (ItemLayer.compass == null) {
								ItemLayer.compass = IgnoreList.SpriteBuffer_getSprite(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.compass, 0);
							} else {
								++var0;
							}

							if (class11.redHintArrowSprite == null) {
								class11.redHintArrowSprite = IgnoreList.SpriteBuffer_getSprite(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3884, 0);
							} else {
								++var0;
							}

							int var28;
							IndexedSprite[] var31;
							byte[] var35;
							if (VarpDefinition.mapSceneSprites == null) {
								var2 = GrandExchangeOfferOwnWorldComparator.archive8;
								var28 = class376.field3614.mapScenes;
								var35 = var2.takeFile(var28, 0);
								if (var35 == null) {
									var4 = false;
								} else {
									class162.SpriteBuffer_decode(var35);
									var4 = true;
								}

								if (!var4) {
									var31 = null;
								} else {
									var31 = DbTable.method2519();
								}

								VarpDefinition.mapSceneSprites = var31;
							} else {
								++var0;
							}

							if (UrlRequest.headIconPkSprites == null) {
								UrlRequest.headIconPkSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.headIconsPk, 0);
							} else {
								++var0;
							}

							if (AbstractByteArrayCopier.headIconPrayerSprites == null) {
								AbstractByteArrayCopier.headIconPrayerSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3882, 0);
							} else {
								++var0;
							}

							if (class60.headIconHintSprites == null) {
								class60.headIconHintSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3890, 0);
							} else {
								++var0;
							}

							if (class12.mapMarkerSprites == null) {
								class12.mapMarkerSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3881, 0);
							} else {
								++var0;
							}

							if (VarpDefinition.crossSprites == null) {
								VarpDefinition.crossSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3883, 0);
							} else {
								++var0;
							}

							if (HorizontalAlignment.mapDotSprites == null) {
								HorizontalAlignment.mapDotSprites = VertexNormal.method1568(GrandExchangeOfferOwnWorldComparator.archive8, class376.field3614.field3885, 0);
							} else {
								++var0;
							}

							if (class31.scrollBarSprites == null) {
								var2 = GrandExchangeOfferOwnWorldComparator.archive8;
								var28 = class376.field3614.field3891;
								var35 = var2.takeFile(var28, 0);
								if (var35 == null) {
									var4 = false;
								} else {
									class162.SpriteBuffer_decode(var35);
									var4 = true;
								}

								if (!var4) {
									var31 = null;
								} else {
									var31 = DbTable.method2519();
								}

								class31.scrollBarSprites = var31;
							} else {
								++var0;
							}

							if (class134.field1307 == null) {
								var2 = GrandExchangeOfferOwnWorldComparator.archive8;
								var28 = class376.field3614.field3887;
								var35 = var2.takeFile(var28, 0);
								if (var35 == null) {
									var4 = false;
								} else {
									class162.SpriteBuffer_decode(var35);
									var4 = true;
								}

								if (!var4) {
									var31 = null;
								} else {
									var31 = DbTable.method2519();
								}

								class134.field1307 = var31;
							} else {
								++var0;
							}

							if (var0 < 11) {
								Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
								Login.Login_loadingPercent = 70;
							} else {
								AbstractFont.AbstractFont_modIconSprites = class134.field1307;
								class11.redHintArrowSprite.normalize();
								var26 = (int)(Math.random() * 21.0D) - 10;
								int var29 = (int)(Math.random() * 21.0D) - 10;
								var28 = (int)(Math.random() * 21.0D) - 10;
								int var39 = (int)(Math.random() * 41.0D) - 20;
								VarpDefinition.mapSceneSprites[0].shiftColors(var26 + var39, var39 + var29, var39 + var28);
								Login.Login_loadingText = "Loaded sprites";
								Login.Login_loadingPercent = 70;
								Client.field414 = class92.field947;
							}
						} else if (class92.field947 == Client.field414) {
							if (!Canvas.field68.isFullyLoaded()) {
								Login.Login_loadingText = "Loading textures - " + "0%";
								Login.Login_loadingPercent = 90;
							} else {
								class292.textureProvider = new TextureProvider(Canvas.field68, GrandExchangeOfferOwnWorldComparator.archive8, 20, WorldMapIcon_1.clientPreferences.getBrightness(), Client.isLowDetail ? 64 : 128);
								Rasterizer3D.method1414(class292.textureProvider);
								Rasterizer3D.method1415(WorldMapIcon_1.clientPreferences.getBrightness());
								Client.field414 = class92.field939;
							}
						} else if (class92.field939 == Client.field414) {
							var0 = class292.textureProvider.getLoadedPercentage();
							if (var0 < 100) {
								Login.Login_loadingText = "Loading textures - " + var0 + "%";
								Login.Login_loadingPercent = 90;
							} else {
								Login.Login_loadingText = "Loaded textures";
								Login.Login_loadingPercent = 90;
								Client.field414 = class92.field944;
							}
						} else if (Client.field414 == class92.field944) {
							Message.mouseRecorder = new MouseRecorder();
							GameEngine.taskHandler.newThreadTask(Message.mouseRecorder, 10);
							Login.Login_loadingText = "Loaded input handler";
							Login.Login_loadingPercent = 92;
							Client.field414 = class92.field945;
						} else if (class92.field945 == Client.field414) {
							if (!WorldMapDecorationType.archive10.tryLoadFileByNames("huffman", "")) {
								Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
								Login.Login_loadingPercent = 94;
							} else {
								Huffman var44 = new Huffman(WorldMapDecorationType.archive10.takeFileByNames("huffman", ""));
								class27.method110(var44);
								Login.Login_loadingText = "Loaded wordpack";
								Login.Login_loadingPercent = 94;
								Client.field414 = class92.field941;
							}
						} else if (Client.field414 == class92.field941) {
							if (!class313.archive4.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + class313.archive4.loadPercent() * 4 / 5 + "%";
								Login.Login_loadingPercent = 96;
							} else if (!WorldMapAreaData.field2099.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + WorldMapAreaData.field2099.loadPercent() * 4 / 5 + "%";
								Login.Login_loadingPercent = 96;
							} else if (!class47.archive12.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + (80 + class47.archive12.loadPercent() / 6) + "%";
								Login.Login_loadingPercent = 96;
							} else if (!VarbitComposition.archive13.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + (96 + VarbitComposition.archive13.loadPercent() / 50) + "%";
								Login.Login_loadingPercent = 96;
							} else {
								Login.Login_loadingText = "Loaded interfaces";
								Login.Login_loadingPercent = 98;
								if (class47.archive12.isValidFileName("version.dat", "")) {
									Buffer var43 = new Buffer(class47.archive12.takeFileByNames("version.dat", ""));
									var43.readUnsignedShort();
								}

								Client.field414 = class92.field946;
							}
						} else if (Client.field414 == class92.field946) {
							Login.Login_loadingPercent = 100;
							if (SpotAnimationDefinition.field1597.getGroupCount() > 0 && !SpotAnimationDefinition.field1597.tryLoadGroupByName(field2095.name)) {
								Login.Login_loadingText = "Loading world map - " + SpotAnimationDefinition.field1597.groupLoadPercentByName(field2095.name) / 10 + "%";
							} else {
								if (NewShit.worldMap == null) {
									NewShit.worldMap = new WorldMap();
									NewShit.worldMap.init(SpotAnimationDefinition.field1597, BuddyRankComparator.field1200, WorldMapData_0.field1938, GrandExchangeOfferTotalQuantityComparator.fontBold12, Client.fontsMap, VarpDefinition.mapSceneSprites);
								}

								Login.Login_loadingText = "Loaded world map";
								Client.field414 = class92.field936;
							}
						} else {
							if (Client.field414 == class92.field936) {
								WorldMapSection2.updateGameState(10);
							}

						}
					} else if (!class344.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + class344.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else if (!class267.field2224.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + (80 + class47.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var27 = class344.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var27;
						Archive var1 = class344.archive2;
						FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var1;
						InvDefinition.method879(class344.archive2, class19.field59);
						class406.method2058(class344.archive2, class19.field59, Client.isLowDetail);
						LoginScreenAnimation.method526(class344.archive2, class19.field59);
						class18.method65(class344.archive2);
						var2 = class344.archive2;
						Archive var3 = class19.field59;
						var4 = Client.isMembersWorld;
						Font var5 = class369.fontPlain11;
						DbRowType.ItemDefinition_archive = var2;
						ItemComposition.ItemDefinition_modelArchive = var3;
						class129.ItemDefinition_inMembersWorld = var4;
						ItemComposition.ItemDefinition_fileCount = DbRowType.ItemDefinition_archive.getGroupFileCount(10);
						TaskHandler.ItemDefinition_fontPlain11 = var5;
						var25 = class344.archive2;
						var7 = UserComparator7.field1190;
						var8 = class145.field1338;
						class369.SequenceDefinition_archive = var25;
						SequenceDefinition.SequenceDefinition_animationsArchive = var7;
						SequenceDefinition.SequenceDefinition_skeletonsArchive = var8;
						UserComparator8.method670(class344.archive2, class19.field59);
						Archive var9 = class344.archive2;
						VarbitComposition.VarbitDefinition_archive = var9;
						ViewportMouse.method1566(class344.archive2);
						HealthBarDefinition.widgetDefinition = new WidgetDefinition(class313.archive4, class19.field59, GrandExchangeOfferOwnWorldComparator.archive8, VarbitComposition.archive13, WorldMapAreaData.field2099);
						Archive var10 = class344.archive2;
						InvDefinition.InvDefinition_archive = var10;
						Archive var11 = class344.archive2;
						EnumComposition.EnumDefinition_archive = var11;
						Archive var12 = class344.archive2;
						class30.VarcInt_archive = var12;
						Archive var13 = class344.archive2;
						VertexNormal.method1567(class344.archive2);
						Archive var14 = class344.archive2;
						DbTableType.field4134 = var14;
						Archive var15 = class344.archive2;
						DbRowType.field4140 = var15;
						class399.Widget_cachedModels = new class509(Messages.field1156, 54, class85.clientLanguage, class344.archive2);
						Players.Widget_cachedFonts = new class509(Messages.field1156, 47, class85.clientLanguage, class344.archive2);
						class176.varcs = new Varcs();
						Archive var16 = class344.archive2;
						Archive var17 = GrandExchangeOfferOwnWorldComparator.archive8;
						Archive var18 = VarbitComposition.archive13;
						HitSplatDefinition.HitSplatDefinition_archive = var16;
						HitSplatDefinition.field1640 = var17;
						HitSplatDefinition.HitSplatDefinition_fontsArchive = var18;
						Archive var19 = class344.archive2;
						Archive var20 = GrandExchangeOfferOwnWorldComparator.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var19;
						SecureRandomCallable.field851 = var20;
						Archive var21 = class344.archive2;
						Archive var22 = GrandExchangeOfferOwnWorldComparator.archive8;
						class432.WorldMapElement_archive = var22;
						if (var21.isFullyLoaded()) {
							class137.WorldMapElement_count = var21.getGroupFileCount(35);
							WorldMapElement.WorldMapElement_cached = new WorldMapElement[class137.WorldMapElement_count];

							for (int var23 = 0; var23 < class137.WorldMapElement_count; ++var23) {
								byte[] var24 = var21.takeFile(35, var23);
								WorldMapElement.WorldMapElement_cached[var23] = new WorldMapElement(var23);
								if (var24 != null) {
									WorldMapElement.WorldMapElement_cached[var23].decode(new Buffer(var24));
									WorldMapElement.WorldMapElement_cached[var23].method894();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.field414 = class92.field937;
					}
				}
			}
		}
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		descriptor = "(Lds;IILiz;I)V",
		garbageValue = "398904459"
	)
	static final void method1355(Player var0, int var1, int var2, MoveSpeed var3) {
		int var4 = var0.pathX[0];
		int var5 = var0.pathY[0];
		int var6 = var0.transformedSize();
		if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
			if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
				class229 var7 = Client.field654;
				int var10 = var0.transformedSize();
				Client.field651.approxDestinationX = var1;
				Client.field651.approxDestinationY = var2;
				Client.field651.approxDestinationSizeX = 1;
				Client.field651.approxDestinationSizeY = 1;
				ApproximateRouteStrategy var11 = Client.field651;
				int var12 = var7.method1170(var4, var5, var10, var11, Client.collisionMaps[var0.plane], true, Client.field592, Client.field591);
				if (var12 >= 1) {
					for (int var13 = 0; var13 < var12 - 1; ++var13) {
						var0.method495(Client.field592[var13], Client.field591[var13], var3);
					}

				}
			}
		}
	}

	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1657545960"
	)
	static void method1356() {
		if (Client.oculusOrbOnLocalPlayer && class229.localPlayer != null) {
			int var0 = class229.localPlayer.pathX[0];
			int var1 = class229.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			LoginScreenAnimation.oculusOrbFocalPointX = class229.localPlayer.x;
			int var2 = WorldMapDecorationType.getTileHeight(class229.localPlayer.x, class229.localPlayer.y, ItemLayer.Client_plane) - Client.camFollowHeight;
			if (var2 < class12.field41) {
				class12.field41 = var2;
			}

			ScriptFrame.oculusOrbFocalPointY = class229.localPlayer.y;
			Client.oculusOrbOnLocalPlayer = false;
		}

	}
}