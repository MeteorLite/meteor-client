import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("hx")
@Implements("ParamComposition")
public class ParamComposition extends DualNode {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("ParamDefinition_archive")
	static AbstractArchive ParamDefinition_archive;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("ParamDefinition_cached")
	static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("an")
	static int field1678;
	@ObfuscatedName("ao")
	@Export("type")
	char type;
	@ObfuscatedName("at")
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("ac")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("ai")
	@Export("autoDisable")
	boolean autoDisable;

	static {
		ParamDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	ParamComposition() {
		this.autoDisable = true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-990843992"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "-59"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ltm;II)V",
		garbageValue = "-1461368185"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.type = ViewportMouse.method1348(var1.readByte());
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-785538560"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-50"
	)
	static void method1017() {
		int var0;
		if (Client.field419 == class92.field940) {
			class130.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			AbstractUserComparator.sceneMinimapSprite = new SpritePixels(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.field419 = class92.field930;
		} else if (class92.field930 == Client.field419) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.field419 = class92.field935;
		} else if (class92.field935 == Client.field419) {
			AttackOption.field1096 = class133.newArchive(0, false, true, true, false);
			class318.archive7 = class133.newArchive(1, false, true, true, false);
			class1.archive2 = class133.newArchive(2, true, false, true, false);
			ObjectSound.archive4 = class133.newArchive(3, false, true, true, false);
			class28.field81 = class133.newArchive(4, false, true, true, false);
			class499.archive9 = class133.newArchive(5, true, true, true, false);
			class385.archive6 = class133.newArchive(6, true, true, true, false);
			Message.archive11 = class133.newArchive(7, false, true, true, false);
			PcmPlayer.archive8 = class133.newArchive(8, false, true, true, false);
			class147.field1348 = class133.newArchive(9, false, true, true, false);
			class141.archive10 = class133.newArchive(10, false, true, true, false);
			class388.field3655 = class133.newArchive(11, false, true, true, false);
			GrandExchangeOffer.archive12 = class133.newArchive(12, false, true, true, false);
			Player.archive13 = class133.newArchive(13, true, false, true, false);
			class106.field1107 = class133.newArchive(14, false, true, true, false);
			Tiles.field838 = class133.newArchive(15, false, true, true, false);
			class10.field28 = class133.newArchive(17, true, true, true, false);
			WorldMapElement.field1509 = class133.newArchive(18, false, true, true, false);
			ClanChannelMember.field1339 = class133.newArchive(19, false, true, true, false);
			class227.field2040 = class133.newArchive(20, false, true, true, false);
			class343.field3148 = class133.newArchive(21, false, true, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.field419 = class92.field939;
		} else if (class92.field939 == Client.field419) {
			byte var43 = 0;
			var0 = var43 + AttackOption.field1096.percentage() * 4 / 100;
			var0 += class318.archive7.percentage() * 4 / 100;
			var0 += class1.archive2.percentage() * 2 / 100;
			var0 += ObjectSound.archive4.percentage() * 2 / 100;
			var0 += class28.field81.percentage() * 6 / 100;
			var0 += class499.archive9.percentage() * 4 / 100;
			var0 += class385.archive6.percentage() * 2 / 100;
			var0 += Message.archive11.percentage() * 55 / 100;
			var0 += PcmPlayer.archive8.percentage() * 2 / 100;
			var0 += class147.field1348.percentage() * 2 / 100;
			var0 += class141.archive10.percentage() * 2 / 100;
			var0 += class388.field3655.percentage() * 2 / 100;
			var0 += GrandExchangeOffer.archive12.percentage() * 2 / 100;
			var0 += Player.archive13.percentage() * 2 / 100;
			var0 += class106.field1107.percentage() * 2 / 100;
			var0 += Tiles.field838.percentage() * 2 / 100;
			var0 += ClanChannelMember.field1339.percentage() / 100;
			var0 += WorldMapElement.field1509.percentage() / 100;
			var0 += class227.field2040.percentage() / 100;
			var0 += class343.field3148.percentage() / 100;
			var0 += class10.field28.method1887() && class10.field28.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class466.method2348(AttackOption.field1096, "Animations");
				class466.method2348(class318.archive7, "Skeletons");
				class466.method2348(class28.field81, "Sound FX");
				class466.method2348(class499.archive9, "Maps");
				class466.method2348(class385.archive6, "Music Tracks");
				class466.method2348(Message.archive11, "Models");
				class466.method2348(PcmPlayer.archive8, "Sprites");
				class466.method2348(class388.field3655, "Music Jingles");
				class466.method2348(class106.field1107, "Music Samples");
				class466.method2348(Tiles.field838, "Music Patches");
				class466.method2348(ClanChannelMember.field1339, "World Map");
				class466.method2348(WorldMapElement.field1509, "World Map Geography");
				class466.method2348(class227.field2040, "World Map Ground");
				class387.field3652 = new GraphicsDefaults();
				class387.field3652.decode(class10.field28);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.field419 = class92.field928;
			}
		} else {
			int var2;
			Archive var3;
			Archive var29;
			if (class92.field928 == Client.field419) {
				class504.method2502(22050, !Client.isLowDetail, 2);
				ArrayList var48 = new ArrayList(3);
				AddRequestTask.pcmPlayer1 = TileItem.method612(GameEngine.taskHandler, 0, 2048);
				class162.pcmStreamMixer = new PcmStreamMixer();
				PcmStreamMixer var37 = new PcmStreamMixer();
				var37.addSubStream(class162.pcmStreamMixer);

				for (var2 = 0; var2 < 3; ++var2) {
					MidiPcmStream var39 = new MidiPcmStream();
					var39.method1638(9, 128);
					var37.addSubStream(var39);
					var48.add(var39);
				}

				AddRequestTask.pcmPlayer1.setStream(var37);
				var29 = Tiles.field838;
				var3 = class106.field1107;
				Archive var40 = class28.field81;
				class305.field2777 = var29;
				class305.field2775 = var3;
				class305.field2776 = var40;
				class305.midiPcmStream = var48;
				class330.decimator = new Decimator(22050, PcmPlayer.field181);
				Login.Login_loadingText = "Prepared sound engine";
				Login.Login_loadingPercent = 35;
				Client.field419 = class92.field932;
				PacketBufferNode.field2613 = new Fonts(PcmPlayer.archive8, Player.archive13);
			} else {
				int var30;
				if (Client.field419 == class92.field932) {
					FontName[] var47 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_plain12};
					var30 = var47.length;
					Fonts var49 = PacketBufferNode.field2613;
					FontName[] var38 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_plain12};
					Client.fontsMap = var49.createMap(var38);
					if (Client.fontsMap.size() < var30) {
						Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var30 + "%";
						Login.Login_loadingPercent = 40;
					} else {
						HealthBarUpdate.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
						SecureRandomCallable.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
						class59.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
						class18.field51 = Client.field645.get();
						Login.Login_loadingText = "Loaded fonts";
						Login.Login_loadingPercent = 40;
						Client.field419 = class92.field941;
					}
				} else {
					Archive var1;
					int var31;
					Archive var32;
					if (Client.field419 == class92.field941) {
						var1 = class141.archive10;
						var29 = PcmPlayer.archive8;
						var31 = 0;
						String[] var4 = Login.field770;

						int var5;
						String var41;
						for (var5 = 0; var5 < var4.length; ++var5) {
							var41 = var4[var5];
							if (var1.tryLoadFileByNames(var41, "")) {
								++var31;
							}
						}

						var4 = Login.field769;

						for (var5 = 0; var5 < var4.length; ++var5) {
							var41 = var4[var5];
							if (var29.tryLoadFileByNames(var41, "")) {
								++var31;
							}
						}

						var4 = Login.field771;

						for (var5 = 0; var5 < var4.length; ++var5) {
							var41 = var4[var5];
							if (var29.getGroupId(var41) != -1 && var29.tryLoadFileByNames(var41, "")) {
								++var31;
							}
						}

						var32 = PcmPlayer.archive8;
						int var33 = Login.field770.length + Login.field769.length;
						String[] var42 = Login.field771;

						for (int var8 = 0; var8 < var42.length; ++var8) {
							String var44 = var42[var8];
							if (var32.getGroupId(var44) != -1) {
								++var33;
							}
						}

						if (var31 < var33) {
							Login.Login_loadingText = "Loading title screen - " + var31 * 100 / var33 + "%";
							Login.Login_loadingPercent = 50;
						} else {
							Login.Login_loadingText = "Loaded title screen";
							Login.Login_loadingPercent = 50;
							MusicSong.updateGameState(5);
							Client.field419 = class92.field936;
						}
					} else if (class92.field936 == Client.field419) {
						if (!class1.archive2.isFullyLoaded()) {
							Login.Login_loadingText = "Loading config - " + class1.archive2.loadPercent() + "%";
							Login.Login_loadingPercent = 60;
						} else if (!class343.field3148.isFullyLoaded()) {
							Login.Login_loadingText = "Loading config - " + (80 + GrandExchangeOffer.archive12.loadPercent() / 6) + "%";
							Login.Login_loadingPercent = 60;
						} else {
							class326.method1714(class1.archive2);
							SecureRandomFuture.method435(class1.archive2);
							Archive var46 = class1.archive2;
							var1 = Message.archive11;
							KitDefinition.KitDefinition_archive = var46;
							KitDefinition.KitDefinition_modelsArchive = var1;
							KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
							var29 = class1.archive2;
							var3 = Message.archive11;
							boolean var50 = Client.isLowDetail;
							ObjectComposition.ObjectDefinition_archive = var29;
							ObjectComposition.ObjectDefinition_modelsArchive = var3;
							ObjectComposition.ObjectDefinition_isLowDetail = var50;
							var32 = class1.archive2;
							Archive var6 = Message.archive11;
							NPCComposition.NpcDefinition_archive = var32;
							NPCComposition.field1586 = var6;
							Archive var7 = class1.archive2;
							StructComposition.StructDefinition_archive = var7;
							Archive var35 = class1.archive2;
							Archive var9 = Message.archive11;
							boolean var10 = Client.isMembersWorld;
							Font var11 = HealthBarUpdate.fontPlain11;
							class384.ItemDefinition_archive = var35;
							ItemComposition.ItemDefinition_modelArchive = var9;
							ItemComposition.ItemDefinition_inMembersWorld = var10;
							HealthBar.ItemDefinition_fileCount = class384.ItemDefinition_archive.getGroupFileCount(10);
							class452.ItemDefinition_fontPlain11 = var11;
							class227.method1215(class1.archive2, AttackOption.field1096, class318.archive7);
							Archive var12 = class1.archive2;
							Archive var13 = Message.archive11;
							SpotAnimationDefinition.SpotAnimationDefinition_archive = var12;
							SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var13;
							ServerPacket.method1612(class1.archive2);
							FileSystem.method911(class1.archive2);
							Archive var14 = ObjectSound.archive4;
							Archive var15 = Message.archive11;
							Archive var16 = PcmPlayer.archive8;
							Archive var17 = Player.archive13;
							int var18 = 0;
							if (var14 != null) {
								Decimator.Widget_archive = var14;
								class47.field226 = var15;
								Language.Widget_spritesArchive = var16;
								class155.Widget_fontsArchive = var17;
								var18 = Decimator.Widget_archive.getGroupCount();
							}

							PacketBufferNode.Widget_interfaceComponents = new Widget[var18][];
							class316.Widget_loadedInterfaces = new boolean[var18];
							ModeWhere.method1978(class1.archive2);
							Archive var36 = class1.archive2;
							EnumComposition.EnumDefinition_archive = var36;
							Archive var19 = class1.archive2;
							VarcInt.VarcInt_archive = var19;
							Archive var20 = class1.archive2;
							class139.method756(class1.archive2);
							BufferedSource.method2268(class1.archive2);
							ModelData0.method1382(class1.archive2);
							class47.HitSplatDefinition_cachedSprites = new class497(WorldMapSectionType.field2417, 54, ClanChannelMember.clientLanguage, class1.archive2);
							SwapSongTask.HitSplatDefinition_cached = new class497(WorldMapSectionType.field2417, 47, ClanChannelMember.clientLanguage, class1.archive2);
							KeyHandler.varcs = new Varcs();
							Archive var21 = class1.archive2;
							Archive var22 = PcmPlayer.archive8;
							Archive var23 = Player.archive13;
							HitSplatDefinition.HitSplatDefinition_archive = var21;
							HitSplatDefinition.field1689 = var22;
							HitSplatDefinition.HitSplatDefinition_fontsArchive = var23;
							class152.method796(class1.archive2, PcmPlayer.archive8);
							Archive var24 = class1.archive2;
							Archive var25 = PcmPlayer.archive8;
							WorldMapElement.WorldMapElement_archive = var25;
							if (var24.isFullyLoaded()) {
								WorldMapElement.WorldMapElement_count = var24.getGroupFileCount(35);
								WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

								for (int var26 = 0; var26 < WorldMapElement.WorldMapElement_count; ++var26) {
									byte[] var27 = var24.takeFile(35, var26);
									WorldMapElement.WorldMapElement_cached[var26] = new WorldMapElement(var26);
									if (var27 != null) {
										WorldMapElement.WorldMapElement_cached[var26].decode(new Buffer(var27));
										WorldMapElement.WorldMapElement_cached[var26].method949();
									}
								}
							}

							Login.Login_loadingText = "Loaded config";
							Login.Login_loadingPercent = 60;
							Client.field419 = class92.field926;
						}
					} else if (Client.field419 == class92.field926) {
						var0 = 0;
						if (Client.compass == null) {
							Client.compass = Tiles.SpriteBuffer_getSprite(PcmPlayer.archive8, class387.field3652.compass, 0);
						} else {
							++var0;
						}

						if (class167.redHintArrowSprite == null) {
							class167.redHintArrowSprite = Tiles.SpriteBuffer_getSprite(PcmPlayer.archive8, class387.field3652.field3850, 0);
						} else {
							++var0;
						}

						if (class299.mapSceneSprites == null) {
							class299.mapSceneSprites = class28.method110(PcmPlayer.archive8, class387.field3652.mapScenes, 0);
						} else {
							++var0;
						}

						if (class178.headIconPkSprites == null) {
							class178.headIconPkSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.headIconsPk, 0);
						} else {
							++var0;
						}

						if (class502.headIconPrayerSprites == null) {
							class502.headIconPrayerSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.field3848, 0);
						} else {
							++var0;
						}

						if (ArchiveLoader.headIconHintSprites == null) {
							ArchiveLoader.headIconHintSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.field3852, 0);
						} else {
							++var0;
						}

						if (Message.mapMarkerSprites == null) {
							Message.mapMarkerSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.field3857, 0);
						} else {
							++var0;
						}

						if (class152.crossSprites == null) {
							class152.crossSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.field3854, 0);
						} else {
							++var0;
						}

						if (FloorOverlayDefinition.mapDotSprites == null) {
							FloorOverlayDefinition.mapDotSprites = WorldMapArchiveLoader.method2379(PcmPlayer.archive8, class387.field3652.field3847, 0);
						} else {
							++var0;
						}

						if (GrandExchangeOfferOwnWorldComparator.scrollBarSprites == null) {
							GrandExchangeOfferOwnWorldComparator.scrollBarSprites = class28.method110(PcmPlayer.archive8, class387.field3652.field3851, 0);
						} else {
							++var0;
						}

						if (class451.field3876 == null) {
							class451.field3876 = class28.method110(PcmPlayer.archive8, class387.field3652.field3849, 0);
						} else {
							++var0;
						}

						if (var0 < 11) {
							Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
							Login.Login_loadingPercent = 70;
						} else {
							AbstractFont.AbstractFont_modIconSprites = class451.field3876;
							class167.redHintArrowSprite.normalize();
							var30 = (int)(Math.random() * 21.0D) - 10;
							var2 = (int)(Math.random() * 21.0D) - 10;
							var31 = (int)(Math.random() * 21.0D) - 10;
							int var34 = (int)(Math.random() * 41.0D) - 20;
							class299.mapSceneSprites[0].shiftColors(var34 + var30, var2 + var34, var34 + var31);
							Login.Login_loadingText = "Loaded sprites";
							Login.Login_loadingPercent = 70;
							Client.field419 = class92.field931;
						}
					} else if (Client.field419 == class92.field931) {
						if (!class147.field1348.isFullyLoaded()) {
							Login.Login_loadingText = "Loading textures - " + "0%";
							Login.Login_loadingPercent = 90;
						} else {
							class129.textureProvider = new TextureProvider(class147.field1348, PcmPlayer.archive8, 20, class449.clientPreferences.getBrightness(), Client.isLowDetail ? 64 : 128);
							Rasterizer3D.method1186(class129.textureProvider);
							Rasterizer3D.method1187(class449.clientPreferences.getBrightness());
							Client.field419 = class92.field929;
						}
					} else if (class92.field929 == Client.field419) {
						var0 = class129.textureProvider.getLoadedPercentage();
						if (var0 < 100) {
							Login.Login_loadingText = "Loading textures - " + var0 + "%";
							Login.Login_loadingPercent = 90;
						} else {
							Login.Login_loadingText = "Loaded textures";
							Login.Login_loadingPercent = 90;
							Client.field419 = class92.field937;
						}
					} else if (Client.field419 == class92.field937) {
						class126.mouseRecorder = new MouseRecorder();
						GameEngine.taskHandler.newThreadTask(class126.mouseRecorder, 10);
						Login.Login_loadingText = "Loaded input handler";
						Login.Login_loadingPercent = 92;
						Client.field419 = class92.field933;
					} else if (class92.field933 == Client.field419) {
						if (!class141.archive10.tryLoadFileByNames("huffman", "")) {
							Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
							Login.Login_loadingPercent = 94;
						} else {
							Huffman var45 = new Huffman(class141.archive10.takeFileByNames("huffman", ""));
							UserComparator9.method683(var45);
							Login.Login_loadingText = "Loaded wordpack";
							Login.Login_loadingPercent = 94;
							Client.field419 = class92.field934;
						}
					} else if (class92.field934 == Client.field419) {
						if (!ObjectSound.archive4.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + ObjectSound.archive4.loadPercent() * 4 / 5 + "%";
							Login.Login_loadingPercent = 96;
						} else if (!GrandExchangeOffer.archive12.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (80 + GrandExchangeOffer.archive12.loadPercent() / 6) + "%";
							Login.Login_loadingPercent = 96;
						} else if (!Player.archive13.isFullyLoaded()) {
							Login.Login_loadingText = "Loading interfaces - " + (96 + Player.archive13.loadPercent() / 50) + "%";
							Login.Login_loadingPercent = 96;
						} else {
							Login.Login_loadingText = "Loaded interfaces";
							Login.Login_loadingPercent = 98;
							if (GrandExchangeOffer.archive12.isValidFileName("version.dat", "")) {
								Buffer var28 = new Buffer(GrandExchangeOffer.archive12.takeFileByNames("version.dat", ""));
								var28.readUnsignedShort();
							}

							Client.field419 = class92.field938;
						}
					} else if (Client.field419 == class92.field938) {
						Login.Login_loadingPercent = 100;
						if (ClanChannelMember.field1339.getGroupCount() > 0 && !ClanChannelMember.field1339.tryLoadGroupByName(WorldMapCacheName.field2471.name)) {
							Login.Login_loadingText = "Loading world map - " + ClanChannelMember.field1339.groupLoadPercentByName(WorldMapCacheName.field2471.name) / 10 + "%";
						} else {
							if (Canvas.worldMap == null) {
								Canvas.worldMap = new WorldMap();
								Canvas.worldMap.init(ClanChannelMember.field1339, WorldMapElement.field1509, class227.field2040, class59.fontBold12, Client.fontsMap, class299.mapSceneSprites);
							}

							Login.Login_loadingText = "Loaded world map";
							Client.field419 = class92.field927;
						}
					} else {
						if (class92.field927 == Client.field419) {
							MusicSong.updateGameState(10);
						}

					}
				}
			}
		}
	}
}