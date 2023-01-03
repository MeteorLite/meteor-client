import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Tiles")
public final class Tiles {
   @ObfuscatedName("h")
   static int[][][] Tiles_heights = new int[4][105][105];
   @ObfuscatedName("e")
   static byte[][][] Tiles_renderFlags = new byte[4][104][104];
   @ObfuscatedName("v")
   static int Tiles_minPlane = 99;
   @ObfuscatedName("x")
   static short[][][] Tiles_underlays;
   @ObfuscatedName("q")
   static byte[][][] Tiles_shapes;
   @ObfuscatedName("u")
   static int[][] field819;
   @ObfuscatedName("b")
   static int[] Tiles_hue;
   @ObfuscatedName("g")
   static int[] Tiles_lightness;
   @ObfuscatedName("l")
   static final int[] field821 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("t")
   static final int[] field825 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("c")
   static final int[] field824 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("p")
   static final int[] field818 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("d")
   static final int[] field826 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("y")
   static final int[] field814 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("z")
   static int rndHue = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("w")
   static int rndLightness = (int)(Math.random() * 33.0D) - 16;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "([BIIB)Z",
      garbageValue = "-120"
   )
   static final boolean method461(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label57:
      while(true) {
         int var6 = var4.method2403();
         if (var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.readUShortSmart();
               if (var9 == 0) {
                  continue label57;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = VarpDefinition.getObjectDefinition(var5);
                  if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
                     if (!var15.needsModelFiles()) {
                        ++Client.field631;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.readUShortSmart();
            if (var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "([BIIIIIIILhc;[Lgw;)V"
   )
   static final void method460(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2403();
         if (var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.readUShortSmart();
            if (var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = VarpDefinition.getObjectDefinition(var11);
               int var22 = var2 + ItemComposition.method1043(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.sizeX;
               int var29 = var21.sizeY;
               int var30;
               if ((var20 & 1) == 1) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if (var27 == 0) {
                  var24 = var26;
               } else if (var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if (var27 == 2) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var3 + var24;
               if (var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if ((Tiles_renderFlags[1][var22][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionMap var32 = null;
                  if (var31 >= 0) {
                     var32 = var9[var31];
                  }

                  UrlRequester.addObjects(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "648133530"
   )
   static void load() {
      int var0;
      if (Client.titleLoadingStage == 0) {
         ReflectionCheck.scene = new Scene(4, 104, 104, Tiles_heights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionMap(104, 104);
         }

         GameObject.sceneMinimapSprite = new SpritePixels(512, 512);
         Login.Login_loadingText = "Starting game engine...";
         Login.Login_loadingPercent = 5;
         Client.titleLoadingStage = 20;
      } else if (Client.titleLoadingStage == 20) {
         Login.Login_loadingText = "Prepared visibility map";
         Login.Login_loadingPercent = 10;
         Client.titleLoadingStage = 30;
      } else if (Client.titleLoadingStage == 30) {
         HealthBar.field1045 = MusicPatchNode.newArchive(0, false, true, true, false);
         class9.archive7 = MusicPatchNode.newArchive(1, false, true, true, false);
         HitSplatDefinition.archive2 = MusicPatchNode.newArchive(2, true, false, true, false);
         FloorUnderlayDefinition.archive4 = MusicPatchNode.newArchive(3, false, true, true, false);
         WorldMapSection0.field2342 = MusicPatchNode.newArchive(4, false, true, true, false);
         class4.archive9 = MusicPatchNode.newArchive(5, true, true, true, false);
         class162.archive6 = MusicPatchNode.newArchive(6, true, true, true, false);
         class301.archive11 = MusicPatchNode.newArchive(7, false, true, true, false);
         ClientPreferences.archive8 = MusicPatchNode.newArchive(8, false, true, true, false);
         Frames.field2062 = MusicPatchNode.newArchive(9, false, true, true, false);
         ClanChannelMember.archive10 = MusicPatchNode.newArchive(10, false, true, true, false);
         class21.field63 = MusicPatchNode.newArchive(11, false, true, true, false);
         class71.archive12 = MusicPatchNode.newArchive(12, false, true, true, false);
         class358.archive13 = MusicPatchNode.newArchive(13, true, false, true, false);
         VarpDefinition.archive14 = MusicPatchNode.newArchive(14, false, true, true, false);
         class89.archive15 = MusicPatchNode.newArchive(15, false, true, true, false);
         VerticalAlignment.archive17 = MusicPatchNode.newArchive(17, true, true, true, false);
         class170.archive18 = MusicPatchNode.newArchive(18, false, true, true, false);
         FontName.archive19 = MusicPatchNode.newArchive(19, false, true, true, false);
         WorldMapArea.archive20 = MusicPatchNode.newArchive(20, false, true, true, false);
         Ignored.field3698 = MusicPatchNode.newArchive(21, false, true, true, true);
         Login.Login_loadingText = "Connecting to update server";
         Login.Login_loadingPercent = 20;
         Client.titleLoadingStage = 40;
      } else if (Client.titleLoadingStage == 40) {
         byte var23 = 0;
         var0 = var23 + HealthBar.field1045.percentage() * 4 / 100;
         var0 += class9.archive7.percentage() * 4 / 100;
         var0 += HitSplatDefinition.archive2.percentage() * 2 / 100;
         var0 += FloorUnderlayDefinition.archive4.percentage() * 2 / 100;
         var0 += WorldMapSection0.field2342.percentage() * 6 / 100;
         var0 += class4.archive9.percentage() * 4 / 100;
         var0 += class162.archive6.percentage() * 2 / 100;
         var0 += class301.archive11.percentage() * 55 / 100;
         var0 += ClientPreferences.archive8.percentage() * 2 / 100;
         var0 += Frames.field2062.percentage() * 2 / 100;
         var0 += ClanChannelMember.archive10.percentage() * 2 / 100;
         var0 += class21.field63.percentage() * 2 / 100;
         var0 += class71.archive12.percentage() * 2 / 100;
         var0 += class358.archive13.percentage() * 2 / 100;
         var0 += VarpDefinition.archive14.percentage() * 2 / 100;
         var0 += class89.archive15.percentage() * 2 / 100;
         var0 += FontName.archive19.percentage() / 100;
         var0 += class170.archive18.percentage() / 100;
         var0 += WorldMapArea.archive20.percentage() / 100;
         var0 += Ignored.field3698.percentage() / 100;
         var0 += VerticalAlignment.archive17.method1781() && VerticalAlignment.archive17.isFullyLoaded() ? 1 : 0;
         if (var0 != 100) {
            if (var0 != 0) {
               Login.Login_loadingText = "Checking for updates - " + var0 + "%";
            }

            Login.Login_loadingPercent = 30;
         } else {
            class18.method59(HealthBar.field1045, "Animations");
            class18.method59(class9.archive7, "Skeletons");
            class18.method59(WorldMapSection0.field2342, "Sound FX");
            class18.method59(class4.archive9, "Maps");
            class18.method59(class162.archive6, "Music Tracks");
            class18.method59(class301.archive11, "Models");
            class18.method59(ClientPreferences.archive8, "Sprites");
            class18.method59(class21.field63, "Music Jingles");
            class18.method59(VarpDefinition.archive14, "Music Samples");
            class18.method59(class89.archive15, "Music Patches");
            class18.method59(FontName.archive19, "World Map");
            class18.method59(class170.archive18, "World Map Geography");
            class18.method59(WorldMapArea.archive20, "World Map Ground");
            UserComparator5.spriteIds = new GraphicsDefaults();
            UserComparator5.spriteIds.decode(VerticalAlignment.archive17);
            Login.Login_loadingText = "Loaded update list";
            Login.Login_loadingPercent = 30;
            Client.titleLoadingStage = 45;
         }
      } else if (Client.titleLoadingStage == 45) {
         boolean var22 = !Client.isLowDetail;
         PcmPlayer.field198 = 22050;
         class286.PcmPlayer_stereo = var22;
         class34.field95 = 2;
         MidiPcmStream var19 = new MidiPcmStream();
         var19.method1542(9, 128);
         TileItem.pcmPlayer0 = ScriptFrame.method329(class242.taskHandler, 0, 22050);
         TileItem.pcmPlayer0.setStream(var19);
         WorldMapDecoration.method1442(class89.archive15, VarpDefinition.archive14, WorldMapSection0.field2342, var19);
         UserComparator8.pcmPlayer1 = ScriptFrame.method329(class242.taskHandler, 1, 2048);
         ApproximateRouteStrategy.pcmStreamMixer = new PcmStreamMixer();
         UserComparator8.pcmPlayer1.setStream(ApproximateRouteStrategy.pcmStreamMixer);
         DevicePcmPlayerProvider.decimator = new Decimator(22050, PcmPlayer.field198);
         Login.Login_loadingText = "Prepared sound engine";
         Login.Login_loadingPercent = 35;
         Client.titleLoadingStage = 50;
         MouseRecorder.WorldMapElement_fonts = new Fonts(ClientPreferences.archive8, class358.archive13);
      } else if (Client.titleLoadingStage == 50) {
         var0 = FontName.method2256().length;
         Client.fontsMap = MouseRecorder.WorldMapElement_fonts.createMap(FontName.method2256());
         if (Client.fontsMap.size() < var0) {
            Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
            Login.Login_loadingPercent = 40;
         } else {
            class151.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
            AbstractWorldMapData.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
            class146.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
            class213.platformInfo = Client.platformInfoProvider.get();
            Login.Login_loadingText = "Loaded fonts";
            Login.Login_loadingPercent = 40;
            Client.titleLoadingStage = 60;
         }
      } else {
         Archive var2;
         int var3;
         if (Client.titleLoadingStage == 60) {
            var0 = class134.method731(ClanChannelMember.archive10, ClientPreferences.archive8);
            var2 = ClientPreferences.archive8;
            var3 = Login.field740.length + Login.field742.length;
            String[] var20 = Login.field760;

            for(int var5 = 0; var5 < var20.length; ++var5) {
               String var21 = var20[var5];
               if (var2.getGroupId(var21) != -1) {
                  ++var3;
               }
            }

            if (var0 < var3) {
               Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var3 + "%";
               Login.Login_loadingPercent = 50;
            } else {
               Login.Login_loadingText = "Loaded title screen";
               Login.Login_loadingPercent = 50;
               class140.updateGameState(5);
               Client.titleLoadingStage = 70;
            }
         } else if (Client.titleLoadingStage == 70) {
            if (!HitSplatDefinition.archive2.isFullyLoaded()) {
               Login.Login_loadingText = "Loading config - " + HitSplatDefinition.archive2.loadPercent() + "%";
               Login.Login_loadingPercent = 60;
            } else if (!Ignored.field3698.isFullyLoaded()) {
               Login.Login_loadingText = "Loading config - " + (80 + class71.archive12.loadPercent() / 6) + "%";
               Login.Login_loadingPercent = 60;
            } else {
               Archive var24 = HitSplatDefinition.archive2;
               FloorOverlayDefinition.FloorOverlayDefinition_archive = var24;
               class140.method751(HitSplatDefinition.archive2);
               Archive var1 = HitSplatDefinition.archive2;
               var2 = class301.archive11;
               KitDefinition.KitDefinition_archive = var1;
               KitDefinition.KitDefinition_modelsArchive = var2;
               class71.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
               UrlRequester.method645(HitSplatDefinition.archive2, class301.archive11, Client.isLowDetail);
               PacketWriter.method635(HitSplatDefinition.archive2, class301.archive11, Client.field360 <= 209, UserComparator5.spriteIds.field3738);
               Archive var15 = HitSplatDefinition.archive2;
               StructComposition.StructDefinition_archive = var15;
               class346.method1862(HitSplatDefinition.archive2, class301.archive11, Client.isMembersWorld, class151.fontPlain11);
               WorldMapIcon_1.method1319(HitSplatDefinition.archive2, HealthBar.field1045, class9.archive7);
               WorldMapSectionType.method1427(HitSplatDefinition.archive2, class301.archive11);
               class182.method936(HitSplatDefinition.archive2);
               Archive var4 = HitSplatDefinition.archive2;
               VarpDefinition.VarpDefinition_archive = var4;
               VarpDefinition.field1468 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
               SequenceDefinition.method1061(FloorUnderlayDefinition.archive4, class301.archive11, ClientPreferences.archive8, class358.archive13);
               Messages.method626(HitSplatDefinition.archive2);
               WorldMapIcon_1.method1318(HitSplatDefinition.archive2);
               Archive var16 = HitSplatDefinition.archive2;
               VarcInt.VarcInt_archive = var16;
               class151.method812(HitSplatDefinition.archive2);
               HealthBar.method572(HitSplatDefinition.archive2);
               Ignored.method2080(HitSplatDefinition.archive2);
               class458.method2310(HitSplatDefinition.archive2);
               class137.HitSplatDefinition_cachedSprites = new class451(LoginPacket.field2681, 54, class173.clientLanguage, HitSplatDefinition.archive2);
               class34.HitSplatDefinition_cached = new class451(LoginPacket.field2681, 47, class173.clientLanguage, HitSplatDefinition.archive2);
               WorldMapArea.varcs = new Varcs();
               Archive var6 = HitSplatDefinition.archive2;
               Archive var7 = ClientPreferences.archive8;
               Archive var8 = class358.archive13;
               class18.HitSplatDefinition_archive = var6;
               HitSplatDefinition.field1650 = var7;
               HitSplatDefinition.HitSplatDefinition_fontsArchive = var8;
               class126.method709(HitSplatDefinition.archive2, ClientPreferences.archive8);
               Archive var9 = HitSplatDefinition.archive2;
               Archive var10 = ClientPreferences.archive8;
               WorldMapElement.WorldMapElement_archive = var10;
               if (var9.isFullyLoaded()) {
                  WorldMapElement.WorldMapElement_count = var9.getGroupFileCount(35);
                  WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

                  for(int var11 = 0; var11 < WorldMapElement.WorldMapElement_count; ++var11) {
                     byte[] var12 = var9.takeFile(35, var11);
                     WorldMapElement.WorldMapElement_cached[var11] = new WorldMapElement(var11);
                     if (var12 != null) {
                        WorldMapElement.WorldMapElement_cached[var11].decode(new Buffer(var12));
                        WorldMapElement.WorldMapElement_cached[var11].method914();
                     }
                  }
               }

               Login.Login_loadingText = "Loaded config";
               Login.Login_loadingPercent = 60;
               Client.titleLoadingStage = 80;
            }
         } else if (Client.titleLoadingStage == 80) {
            var0 = 0;
            if (class201.compass == null) {
               class201.compass = class125.SpriteBuffer_getSprite(ClientPreferences.archive8, UserComparator5.spriteIds.compass, 0);
            } else {
               ++var0;
            }

            if (class139.redHintArrowSprite == null) {
               class139.redHintArrowSprite = class125.SpriteBuffer_getSprite(ClientPreferences.archive8, UserComparator5.spriteIds.field3741, 0);
            } else {
               ++var0;
            }

            if (class32.mapSceneSprites == null) {
               class32.mapSceneSprites = AbstractWorldMapData.method1431(ClientPreferences.archive8, UserComparator5.spriteIds.mapScenes, 0);
            } else {
               ++var0;
            }

            if (World.headIconPkSprites == null) {
               World.headIconPkSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.headIconsPk, 0);
            } else {
               ++var0;
            }

            if (class410.headIconPrayerSprites == null) {
               class410.headIconPrayerSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.field3738, 0);
            } else {
               ++var0;
            }

            if (class358.headIconHintSprites == null) {
               class358.headIconHintSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.field3740, 0);
            } else {
               ++var0;
            }

            if (class144.mapMarkerSprites == null) {
               class144.mapMarkerSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.field3744, 0);
            } else {
               ++var0;
            }

            if (MouseHandler.crossSprites == null) {
               MouseHandler.crossSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.field3742, 0);
            } else {
               ++var0;
            }

            if (class281.mapDotSprites == null) {
               class281.mapDotSprites = SequenceDefinition.method1062(ClientPreferences.archive8, UserComparator5.spriteIds.field3743, 0);
            } else {
               ++var0;
            }

            if (class89.scrollBarSprites == null) {
               class89.scrollBarSprites = AbstractWorldMapData.method1431(ClientPreferences.archive8, UserComparator5.spriteIds.field3739, 0);
            } else {
               ++var0;
            }

            if (Coord.modIconSprites == null) {
               Coord.modIconSprites = AbstractWorldMapData.method1431(ClientPreferences.archive8, UserComparator5.spriteIds.field3745, 0);
            } else {
               ++var0;
            }

            if (var0 < 11) {
               Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
               Login.Login_loadingPercent = 70;
            } else {
               AbstractFont.AbstractFont_modIconSprites = Coord.modIconSprites;
               class139.redHintArrowSprite.normalize();
               int var13 = (int)(Math.random() * 21.0D) - 10;
               int var17 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               int var18 = (int)(Math.random() * 41.0D) - 20;
               class32.mapSceneSprites[0].shiftColors(var13 + var18, var17 + var18, var18 + var3);
               Login.Login_loadingText = "Loaded sprites";
               Login.Login_loadingPercent = 70;
               Client.titleLoadingStage = 90;
            }
         } else if (Client.titleLoadingStage == 90) {
            if (!Frames.field2062.isFullyLoaded()) {
               Login.Login_loadingText = "Loading textures - " + "0%";
               Login.Login_loadingPercent = 90;
            } else {
               Skeleton.textureProvider = new TextureProvider(Frames.field2062, ClientPreferences.archive8, 20, StructComposition.clientPreferences.method541(), Client.isLowDetail ? 64 : 128);
               Rasterizer3D.Rasterizer3D_setTextureLoader(Skeleton.textureProvider);
               Rasterizer3D.Rasterizer3D_setBrightness(StructComposition.clientPreferences.method541());
               Client.titleLoadingStage = 100;
            }
         } else if (Client.titleLoadingStage == 100) {
            var0 = Skeleton.textureProvider.getLoadedPercentage();
            if (var0 < 100) {
               Login.Login_loadingText = "Loading textures - " + var0 + "%";
               Login.Login_loadingPercent = 90;
            } else {
               Login.Login_loadingText = "Loaded textures";
               Login.Login_loadingPercent = 90;
               Client.titleLoadingStage = 110;
            }
         } else if (Client.titleLoadingStage == 110) {
            class271.mouseRecorder = new MouseRecorder();
            class242.taskHandler.newThreadTask(class271.mouseRecorder, 10);
            Login.Login_loadingText = "Loaded input handler";
            Login.Login_loadingPercent = 92;
            Client.titleLoadingStage = 120;
         } else if (Client.titleLoadingStage == 120) {
            if (!ClanChannelMember.archive10.tryLoadFileByNames("huffman", "")) {
               Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
               Login.Login_loadingPercent = 94;
            } else {
               Huffman var14 = new Huffman(ClanChannelMember.archive10.takeFileByNames("huffman", ""));
               Interpreter.method417(var14);
               Login.Login_loadingText = "Loaded wordpack";
               Login.Login_loadingPercent = 94;
               Client.titleLoadingStage = 130;
            }
         } else if (Client.titleLoadingStage == 130) {
            if (!FloorUnderlayDefinition.archive4.isFullyLoaded()) {
               Login.Login_loadingText = "Loading interfaces - " + FloorUnderlayDefinition.archive4.loadPercent() * 4 / 5 + "%";
               Login.Login_loadingPercent = 96;
            } else if (!class71.archive12.isFullyLoaded()) {
               Login.Login_loadingText = "Loading interfaces - " + (80 + class71.archive12.loadPercent() / 6) + "%";
               Login.Login_loadingPercent = 96;
            } else if (!class358.archive13.isFullyLoaded()) {
               Login.Login_loadingText = "Loading interfaces - " + (96 + class358.archive13.loadPercent() / 50) + "%";
               Login.Login_loadingPercent = 96;
            } else {
               Login.Login_loadingText = "Loaded interfaces";
               Login.Login_loadingPercent = 98;
               Client.titleLoadingStage = 140;
            }
         } else if (Client.titleLoadingStage == 140) {
            Login.Login_loadingPercent = 100;
            if (!FontName.archive19.tryLoadGroupByName(WorldMapCacheName.field2403.name)) {
               Login.Login_loadingText = "Loading world map - " + FontName.archive19.groupLoadPercentByName(WorldMapCacheName.field2403.name) / 10 + "%";
            } else {
               if (KitDefinition.worldMap == null) {
                  KitDefinition.worldMap = new WorldMap();
                  KitDefinition.worldMap.init(FontName.archive19, class170.archive18, WorldMapArea.archive20, class146.fontBold12, Client.fontsMap, class32.mapSceneSprites);
               }

               Login.Login_loadingText = "Loaded world map";
               Client.titleLoadingStage = 150;
            }
         } else if (Client.titleLoadingStage == 150) {
            class140.updateGameState(10);
         }
      }
   }
}
