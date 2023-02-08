import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ne")
public final class class366 {
   @ObfuscatedName("f")
   public static final char[] base37Table = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   @ObfuscatedName("w")
   static long[] field3578 = new long[12];
   @ObfuscatedName("jv")
   static int cameraZ;
   @ObfuscatedName("pi")
   static int field3575;

   static {
      for(int var0 = 0; var0 < field3578.length; ++var0) {
         field3578[var0] = (long)Math.pow(37.0D, (double)var0);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-77"
   )
   public static int method1928(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
           descriptor = "(B)V",
           garbageValue = "8"
   )
   static void load() {
      int var0;
      if (Client.titleLoadingStage == 0) {
         WorldMapAreaData.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionMap(104, 104);
         }

         class31.sceneMinimapSprite = new SpritePixels(512, 512);
         Login.Login_loadingText = "Starting game engine...";
         Login.Login_loadingPercent = 5;
         Client.titleLoadingStage = 20;
      } else if (Client.titleLoadingStage == 20) {
         Login.Login_loadingText = "Prepared visibility map";
         Login.Login_loadingPercent = 10;
         Client.titleLoadingStage = 30;
      } else if (Client.titleLoadingStage == 30) {
         class13.field44 = ReflectionCheck.newArchive(0, false, true, true, false);
         FriendsChat.archive7 = ReflectionCheck.newArchive(1, false, true, true, false);
         class372.archive2 = ReflectionCheck.newArchive(2, true, false, true, false);
         class144.archive4 = ReflectionCheck.newArchive(3, false, true, true, false);
         DynamicObject.field826 = ReflectionCheck.newArchive(4, false, true, true, false);
         NetCache.archive9 = ReflectionCheck.newArchive(5, true, true, true, false);
         class153.archive6 = ReflectionCheck.newArchive(6, true, true, true, false);
         class151.archive11 = ReflectionCheck.newArchive(7, false, true, true, false);
         WorldMapEvent.archive8 = ReflectionCheck.newArchive(8, false, true, true, false);
         class148.field1333 = ReflectionCheck.newArchive(9, false, true, true, false);
         ApproximateRouteStrategy.archive10 = ReflectionCheck.newArchive(10, false, true, true, false);
         MusicPatchNode.field2782 = ReflectionCheck.newArchive(11, false, true, true, false);
         class12.archive12 = ReflectionCheck.newArchive(12, false, true, true, false);
         PendingSpawn.archive13 = ReflectionCheck.newArchive(13, true, false, true, false);
         class174.archive14 = ReflectionCheck.newArchive(14, false, true, true, false);
         class286.archive15 = ReflectionCheck.newArchive(15, false, true, true, false);
         CollisionMap.archive17 = ReflectionCheck.newArchive(17, true, true, true, false);
         class419.archive18 = ReflectionCheck.newArchive(18, false, true, true, false);
         GameEngine.archive19 = ReflectionCheck.newArchive(19, false, true, true, false);
         class27.archive20 = ReflectionCheck.newArchive(20, false, true, true, false);
         Canvas.field75 = ReflectionCheck.newArchive(21, false, true, true, true);
         Login.Login_loadingText = "Connecting to update server";
         Login.Login_loadingPercent = 20;
         Client.titleLoadingStage = 40;
      } else if (Client.titleLoadingStage == 40) {
         byte var34 = 0;
         var0 = var34 + class13.field44.percentage() * 4 / 100;
         var0 += FriendsChat.archive7.percentage() * 4 / 100;
         var0 += class372.archive2.percentage() * 2 / 100;
         var0 += class144.archive4.percentage() * 2 / 100;
         var0 += DynamicObject.field826.percentage() * 6 / 100;
         var0 += NetCache.archive9.percentage() * 4 / 100;
         var0 += class153.archive6.percentage() * 2 / 100;
         var0 += class151.archive11.percentage() * 55 / 100;
         var0 += WorldMapEvent.archive8.percentage() * 2 / 100;
         var0 += class148.field1333.percentage() * 2 / 100;
         var0 += ApproximateRouteStrategy.archive10.percentage() * 2 / 100;
         var0 += MusicPatchNode.field2782.percentage() * 2 / 100;
         var0 += class12.archive12.percentage() * 2 / 100;
         var0 += PendingSpawn.archive13.percentage() * 2 / 100;
         var0 += class174.archive14.percentage() * 2 / 100;
         var0 += class286.archive15.percentage() * 2 / 100;
         var0 += GameEngine.archive19.percentage() / 100;
         var0 += class419.archive18.percentage() / 100;
         var0 += class27.archive20.percentage() / 100;
         var0 += Canvas.field75.percentage() / 100;
         var0 += CollisionMap.archive17.method1794() && CollisionMap.archive17.isFullyLoaded() ? 1 : 0;
         if (var0 != 100) {
            if (var0 != 0) {
               Login.Login_loadingText = "Checking for updates - " + var0 + "%";
            }

            Login.Login_loadingPercent = 30;
         } else {
            WorldMapSprite.method1455(class13.field44, "Animations");
            WorldMapSprite.method1455(FriendsChat.archive7, "Skeletons");
            WorldMapSprite.method1455(DynamicObject.field826, "Sound FX");
            WorldMapSprite.method1455(NetCache.archive9, "Maps");
            WorldMapSprite.method1455(class153.archive6, "Music Tracks");
            WorldMapSprite.method1455(class151.archive11, "Models");
            WorldMapSprite.method1455(WorldMapEvent.archive8, "Sprites");
            WorldMapSprite.method1455(MusicPatchNode.field2782, "Music Jingles");
            WorldMapSprite.method1455(class174.archive14, "Music Samples");
            WorldMapSprite.method1455(class286.archive15, "Music Patches");
            WorldMapSprite.method1455(GameEngine.archive19, "World Map");
            WorldMapSprite.method1455(class419.archive18, "World Map Geography");
            WorldMapSprite.method1455(class27.archive20, "World Map Ground");
            ScriptFrame.spriteIds = new GraphicsDefaults();
            ScriptFrame.spriteIds.decode(CollisionMap.archive17);
            Login.Login_loadingText = "Loaded update list";
            Login.Login_loadingPercent = 30;
            Client.titleLoadingStage = 45;
         }
      } else {
         Archive var2;
         Archive var3;
         Archive var29;
         if (Client.titleLoadingStage == 45) {
            class348.method1872(22050, !Client.isLowDetail, 2);
            MidiPcmStream var36 = new MidiPcmStream();
            var36.method1562(9, 128);
            SoundSystem.pcmPlayer0 = ObjectSound.method407(GameEngine.taskHandler, 0, 22050);
            SoundSystem.pcmPlayer0.setStream(var36);
            var29 = class286.archive15;
            var2 = class174.archive14;
            var3 = DynamicObject.field826;
            class290.musicPatchesArchive = var29;
            class290.musicSamplesArchive = var2;
            class290.soundEffectsArchive = var3;
            class290.midiPcmStream = var36;
            WorldMapSectionType.pcmPlayer1 = ObjectSound.method407(GameEngine.taskHandler, 1, 2048);
            class209.pcmStreamMixer = new PcmStreamMixer();
            WorldMapSectionType.pcmPlayer1.setStream(class209.pcmStreamMixer);
            class257.decimator = new Decimator(22050, class284.field2683);
            Login.Login_loadingText = "Prepared sound engine";
            Login.Login_loadingPercent = 35;
            Client.titleLoadingStage = 50;
            class165.WorldMapElement_fonts = new Fonts(WorldMapEvent.archive8, PendingSpawn.archive13);
         } else if (Client.titleLoadingStage == 50) {
            var0 = FontName.method2294().length;
            Client.fontsMap = class165.WorldMapElement_fonts.createMap(FontName.method2294());
            if (Client.fontsMap.size() < var0) {
               Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
               Login.Login_loadingPercent = 40;
            } else {
               class276.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
               MenuAction.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
               class19.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
               UserComparator9.platformInfo = Client.platformInfoProvider.get();
               Login.Login_loadingText = "Loaded fonts";
               Login.Login_loadingPercent = 40;
               Client.titleLoadingStage = 60;
            }
         } else {
            int var23;
            if (Client.titleLoadingStage == 60) {
               var0 = WorldMapSectionType.method1439(ApproximateRouteStrategy.archive10, WorldMapEvent.archive8);
               var2 = WorldMapEvent.archive8;
               var23 = Login.field774.length + Login.field775.length;
               String[] var30 = Login.field738;

               for(int var31 = 0; var31 < var30.length; ++var31) {
                  String var32 = var30[var31];
                  if (var2.getGroupId(var32) != -1) {
                     ++var23;
                  }
               }

               if (var0 < var23) {
                  Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var23 + "%";
                  Login.Login_loadingPercent = 50;
               } else {
                  Login.Login_loadingText = "Loaded title screen";
                  Login.Login_loadingPercent = 50;
                  class246.updateGameState(5);
                  Client.titleLoadingStage = 70;
               }
            } else if (Client.titleLoadingStage == 70) {
               if (!class372.archive2.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading config - " + class372.archive2.loadPercent() + "%";
                  Login.Login_loadingPercent = 60;
               } else if (!Canvas.field75.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading config - " + (80 + class12.archive12.loadPercent() / 6) + "%";
                  Login.Login_loadingPercent = 60;
               } else {
                  class88.method495(class372.archive2);
                  Archive var35 = class372.archive2;
                  FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var35;
                  var29 = class372.archive2;
                  var2 = class151.archive11;
                  KitDefinition.KitDefinition_archive = var29;
                  KitDefinition.KitDefinition_modelsArchive = var2;
                  KitDefinition.KitDefinition_fileCount = KitDefinition.KitDefinition_archive.getGroupFileCount(3);
                  var3 = class372.archive2;
                  Archive var4 = class151.archive11;
                  boolean var5 = Client.isLowDetail;
                  ObjectComposition.ObjectDefinition_archive = var3;
                  ObjectComposition.ObjectDefinition_modelsArchive = var4;
                  ObjectComposition.ObjectDefinition_isLowDetail = var5;
                  WorldMapSprite.method1456(class372.archive2, class151.archive11);
                  Archive var6 = class372.archive2;
                  StructComposition.StructDefinition_archive = var6;
                  Archive var33 = class372.archive2;
                  Archive var8 = class151.archive11;
                  boolean var9 = Client.isMembersWorld;
                  Font var10 = class276.fontPlain11;
                  class4.ItemDefinition_archive = var33;
                  ItemComposition.ItemDefinition_modelArchive = var8;
                  ItemComposition.ItemDefinition_inMembersWorld = var9;
                  ItemComposition.ItemDefinition_fileCount = class4.ItemDefinition_archive.getGroupFileCount(10);
                  class138.ItemDefinition_fontPlain11 = var10;
                  class6.method18(class372.archive2, class13.field44, FriendsChat.archive7);
                  Archive var11 = class372.archive2;
                  Archive var12 = class151.archive11;
                  SpotAnimationDefinition.SpotAnimationDefinition_archive = var11;
                  SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var12;
                  class9.method32(class372.archive2);
                  WorldMapIcon_0.method1427(class372.archive2);
                  Archive var13 = class144.archive4;
                  Archive var14 = class151.archive11;
                  Archive var15 = WorldMapEvent.archive8;
                  Archive var16 = PendingSpawn.archive13;
                  UserComparator8.Widget_archive = var13;
                  class145.field1322 = var14;
                  World.Widget_spritesArchive = var15;
                  Script.Widget_fontsArchive = var16;
                  WorldMapLabel.Widget_interfaceComponents = new Widget[UserComparator8.Widget_archive.getGroupCount()][];
                  class431.Widget_loadedInterfaces = new boolean[UserComparator8.Widget_archive.getGroupCount()];
                  Archive var17 = class372.archive2;
                  InvDefinition.InvDefinition_archive = var17;
                  class81.method457(class372.archive2);
                  class68.method414(class372.archive2);
                  class153.method819(class372.archive2);
                  Archive var18 = class372.archive2;
                  ParamComposition.ParamDefinition_archive = var18;
                  DevicePcmPlayerProvider.method81(class372.archive2);
                  ObjectComposition.method1029(class372.archive2);
                  class491.HitSplatDefinition_cachedSprites = new class458(class134.field1270, 54, class36.clientLanguage, class372.archive2);
                  MoveSpeed.HitSplatDefinition_cached = new class458(class134.field1270, 47, class36.clientLanguage, class372.archive2);
                  class9.varcs = new Varcs();
                  Archive var19 = class372.archive2;
                  Archive var20 = WorldMapEvent.archive8;
                  Archive var21 = PendingSpawn.archive13;
                  class498.HitSplatDefinition_archive = var19;
                  HitSplatDefinition.field1649 = var20;
                  HitSplatDefinition.HitSplatDefinition_fontsArchive = var21;
                  Login.method426(class372.archive2, WorldMapEvent.archive8);
                  class85.method469(class372.archive2, WorldMapEvent.archive8);
                  Login.Login_loadingText = "Loaded config";
                  Login.Login_loadingPercent = 60;
                  Client.titleLoadingStage = 80;
               }
            } else if (Client.titleLoadingStage == 80) {
               var0 = 0;
               if (SoundSystem.compass == null) {
                  SoundSystem.compass = BZip2State.SpriteBuffer_getSprite(WorldMapEvent.archive8, ScriptFrame.spriteIds.compass, 0);
               } else {
                  ++var0;
               }

               if (PacketBufferNode.redHintArrowSprite == null) {
                  PacketBufferNode.redHintArrowSprite = BZip2State.SpriteBuffer_getSprite(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3758, 0);
               } else {
                  ++var0;
               }

               IndexedSprite[] var1;
               IndexedSprite var7;
               IndexedSprite[] var25;
               int var26;
               if (VarpDefinition.mapSceneSprites == null) {
                  var2 = WorldMapEvent.archive8;
                  var23 = ScriptFrame.spriteIds.mapScenes;
                  if (!Buffer.method2444(var2, var23, 0)) {
                     var1 = null;
                  } else {
                     var25 = new IndexedSprite[class488.SpriteBuffer_spriteCount];

                     for(var26 = 0; var26 < class488.SpriteBuffer_spriteCount; ++var26) {
                        var7 = var25[var26] = new IndexedSprite();
                        var7.width = class488.SpriteBuffer_spriteWidth;
                        var7.height = class488.SpriteBuffer_spriteHeight;
                        var7.xOffset = class488.SpriteBuffer_xOffsets[var26];
                        var7.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var26];
                        var7.subWidth = FriendsList.SpriteBuffer_spriteWidths[var26];
                        var7.subHeight = class132.SpriteBuffer_spriteHeights[var26];
                        var7.palette = class100.SpriteBuffer_spritePalette;
                        var7.pixels = class140.SpriteBuffer_pixels[var26];
                     }

                     class100.method595();
                     var1 = var25;
                  }

                  VarpDefinition.mapSceneSprites = var1;
               } else {
                  ++var0;
               }

               if (ClanChannel.headIconPkSprites == null) {
                  ClanChannel.headIconPkSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.headIconsPk, 0);
               } else {
                  ++var0;
               }

               if (class367.headIconPrayerSprites == null) {
                  class367.headIconPrayerSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3753, 0);
               } else {
                  ++var0;
               }

               if (WorldMapSectionType.headIconHintSprites == null) {
                  WorldMapSectionType.headIconHintSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3754, 0);
               } else {
                  ++var0;
               }

               if (UserComparator6.mapMarkerSprites == null) {
                  UserComparator6.mapMarkerSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3757, 0);
               } else {
                  ++var0;
               }

               if (Calendar.crossSprites == null) {
                  Calendar.crossSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3756, 0);
               } else {
                  ++var0;
               }

               if (UrlRequest.mapDotSprites == null) {
                  UrlRequest.mapDotSprites = AABB.method1240(WorldMapEvent.archive8, ScriptFrame.spriteIds.field3759, 0);
               } else {
                  ++var0;
               }

               if (InvDefinition.scrollBarSprites == null) {
                  var2 = WorldMapEvent.archive8;
                  var23 = ScriptFrame.spriteIds.field3750;
                  if (!Buffer.method2444(var2, var23, 0)) {
                     var1 = null;
                  } else {
                     var25 = new IndexedSprite[class488.SpriteBuffer_spriteCount];

                     for(var26 = 0; var26 < class488.SpriteBuffer_spriteCount; ++var26) {
                        var7 = var25[var26] = new IndexedSprite();
                        var7.width = class488.SpriteBuffer_spriteWidth;
                        var7.height = class488.SpriteBuffer_spriteHeight;
                        var7.xOffset = class488.SpriteBuffer_xOffsets[var26];
                        var7.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var26];
                        var7.subWidth = FriendsList.SpriteBuffer_spriteWidths[var26];
                        var7.subHeight = class132.SpriteBuffer_spriteHeights[var26];
                        var7.palette = class100.SpriteBuffer_spritePalette;
                        var7.pixels = class140.SpriteBuffer_pixels[var26];
                     }

                     class100.method595();
                     var1 = var25;
                  }

                  InvDefinition.scrollBarSprites = var1;
               } else {
                  ++var0;
               }

               if (PlayerType.modIconSprites == null) {
                  var2 = WorldMapEvent.archive8;
                  var23 = ScriptFrame.spriteIds.field3761;
                  if (!Buffer.method2444(var2, var23, 0)) {
                     var1 = null;
                  } else {
                     var25 = new IndexedSprite[class488.SpriteBuffer_spriteCount];

                     for(var26 = 0; var26 < class488.SpriteBuffer_spriteCount; ++var26) {
                        var7 = var25[var26] = new IndexedSprite();
                        var7.width = class488.SpriteBuffer_spriteWidth;
                        var7.height = class488.SpriteBuffer_spriteHeight;
                        var7.xOffset = class488.SpriteBuffer_xOffsets[var26];
                        var7.yOffset = ApproximateRouteStrategy.SpriteBuffer_yOffsets[var26];
                        var7.subWidth = FriendsList.SpriteBuffer_spriteWidths[var26];
                        var7.subHeight = class132.SpriteBuffer_spriteHeights[var26];
                        var7.palette = class100.SpriteBuffer_spritePalette;
                        var7.pixels = class140.SpriteBuffer_pixels[var26];
                     }

                     class100.method595();
                     var1 = var25;
                  }

                  PlayerType.modIconSprites = var1;
               } else {
                  ++var0;
               }

               if (var0 < 11) {
                  Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  Login.Login_loadingPercent = 70;
               } else {
                  AbstractFont.AbstractFont_modIconSprites = PlayerType.modIconSprites;
                  PacketBufferNode.redHintArrowSprite.normalize();
                  int var24 = (int)(Math.random() * 21.0D) - 10;
                  int var27 = (int)(Math.random() * 21.0D) - 10;
                  var23 = (int)(Math.random() * 21.0D) - 10;
                  int var28 = (int)(Math.random() * 41.0D) - 20;
                  VarpDefinition.mapSceneSprites[0].shiftColors(var28 + var24, var28 + var27, var23 + var28);
                  Login.Login_loadingText = "Loaded sprites";
                  Login.Login_loadingPercent = 70;
                  Client.titleLoadingStage = 90;
               }
            } else if (Client.titleLoadingStage == 90) {
               if (!class148.field1333.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading textures - " + "0%";
                  Login.Login_loadingPercent = 90;
               } else {
                  GameBuild.textureProvider = new TextureProvider(class148.field1333, WorldMapEvent.archive8, 20, PacketWriter.clientPreferences.getBrightness(), Client.isLowDetail ? 64 : 128);
                  Rasterizer3D.Rasterizer3D_setTextureLoader(GameBuild.textureProvider);
                  Rasterizer3D.Rasterizer3D_setBrightness(PacketWriter.clientPreferences.getBrightness());
                  Client.titleLoadingStage = 100;
               }
            } else if (Client.titleLoadingStage == 100) {
               var0 = GameBuild.textureProvider.getLoadedPercentage();
               if (var0 < 100) {
                  Login.Login_loadingText = "Loading textures - " + var0 + "%";
                  Login.Login_loadingPercent = 90;
               } else {
                  Login.Login_loadingText = "Loaded textures";
                  Login.Login_loadingPercent = 90;
                  Client.titleLoadingStage = 110;
               }
            } else if (Client.titleLoadingStage == 110) {
               class36.mouseRecorder = new MouseRecorder();
               GameEngine.taskHandler.newThreadTask(class36.mouseRecorder, 10);
               Login.Login_loadingText = "Loaded input handler";
               Login.Login_loadingPercent = 92;
               Client.titleLoadingStage = 120;
            } else if (Client.titleLoadingStage == 120) {
               if (!ApproximateRouteStrategy.archive10.tryLoadFileByNames("huffman", "")) {
                  Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
                  Login.Login_loadingPercent = 94;
               } else {
                  Huffman var22 = new Huffman(ApproximateRouteStrategy.archive10.takeFileByNames("huffman", ""));
                  class312.huffman = var22;
                  Login.Login_loadingText = "Loaded wordpack";
                  Login.Login_loadingPercent = 94;
                  Client.titleLoadingStage = 130;
               }
            } else if (Client.titleLoadingStage == 130) {
               if (!class144.archive4.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading interfaces - " + class144.archive4.loadPercent() * 4 / 5 + "%";
                  Login.Login_loadingPercent = 96;
               } else if (!class12.archive12.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading interfaces - " + (80 + class12.archive12.loadPercent() / 6) + "%";
                  Login.Login_loadingPercent = 96;
               } else if (!PendingSpawn.archive13.isFullyLoaded()) {
                  Login.Login_loadingText = "Loading interfaces - " + (96 + PendingSpawn.archive13.loadPercent() / 50) + "%";
                  Login.Login_loadingPercent = 96;
               } else {
                  Login.Login_loadingText = "Loaded interfaces";
                  Login.Login_loadingPercent = 98;
                  Client.titleLoadingStage = 140;
               }
            } else if (Client.titleLoadingStage == 140) {
               Login.Login_loadingPercent = 100;
               if (!GameEngine.archive19.tryLoadGroupByName(WorldMapCacheName.field2395.name)) {
                  Login.Login_loadingText = "Loading world map - " + GameEngine.archive19.groupLoadPercentByName(WorldMapCacheName.field2395.name) / 10 + "%";
               } else {
                  if (GrandExchangeOfferUnitPriceComparator.worldMap == null) {
                     GrandExchangeOfferUnitPriceComparator.worldMap = new WorldMap();
                     GrandExchangeOfferUnitPriceComparator.worldMap.init(GameEngine.archive19, class419.archive18, class27.archive20, class19.fontBold12, Client.fontsMap, VarpDefinition.mapSceneSprites);
                  }

                  Login.Login_loadingText = "Loaded world map";
                  Client.titleLoadingStage = 150;
               }
            } else if (Client.titleLoadingStage == 150) {
               class246.updateGameState(10);
            }
         }
      }
   }
}
