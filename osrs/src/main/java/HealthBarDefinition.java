import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("HealthBarDefinition")
public class HealthBarDefinition extends DualNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static AbstractArchive field1520;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("z")
   public int field1517;
    @ObfuscatedName("n")
    public int int1 = 255;
    @ObfuscatedName("l")
    public int int2 = 255;
    @ObfuscatedName("k")
    public int int3 = -1;
   @ObfuscatedName("c")
   public int field1519 = 1;
    @ObfuscatedName("r")
    public int int5 = 70;
    @ObfuscatedName("b")
    int frontSpriteID = -1;
    @ObfuscatedName("m")
    int backSpriteID = -1;
    @ObfuscatedName("t")
    public int width = 30;
    @ObfuscatedName("h")
    public int widthPadding = 0;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "-2019372676"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Lrd;II)V",
            garbageValue = "655885225"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         var1.readUnsignedShort();
      } else if (var2 == 2) {
         this.int1 = var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.int2 = var1.readUnsignedByte();
      } else if (var2 == 4) {
         this.int3 = 0;
      } else if (var2 == 5) {
         this.int5 = var1.readUnsignedShort();
      } else if (var2 == 6) {
         var1.readUnsignedByte();
      } else if (var2 == 7) {
         this.frontSpriteID = var1.method2419();
      } else if (var2 == 8) {
         this.backSpriteID = var1.method2419();
      } else if (var2 == 11) {
         this.int3 = var1.readUnsignedShort();
      } else if (var2 == 14) {
         this.width = var1.readUnsignedByte();
      } else if (var2 == 15) {
         this.widthPadding = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "-350000117"
   )
   public SpritePixels getFrontSprite() {
      if (this.frontSpriteID < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HealthBarDefinition_cachedSprites.get((long)this.frontSpriteID);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1520, this.frontSpriteID, 0);
            if (var1 != null) {
               HealthBarDefinition_cachedSprites.put(var1, (long)this.frontSpriteID);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "-1607255134"
   )
   public SpritePixels getBackSprite() {
      if (this.backSpriteID < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HealthBarDefinition_cachedSprites.get((long)this.backSpriteID);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1520, this.backSpriteID, 0);
            if (var1 != null) {
               HealthBarDefinition_cachedSprites.put(var1, (long)this.backSpriteID);
            }

            return var1;
         }
      }
   }

    @ObfuscatedName("ff")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "75"
    )
    static final void logOut() {
      Client.packetWriter.close();
      WorldMapElement.method925();
      FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
      class134.method730();
      ObjectComposition.ObjectDefinition_cached.clear();
      ObjectComposition.ObjectDefinition_cachedModelData.clear();
      ObjectComposition.ObjectDefinition_cachedEntities.clear();
      ObjectComposition.ObjectDefinition_cachedModels.clear();
      class168.method892();
      TaskHandler.method888();
      ObjectSound.method411();
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
      WorldMapDecorationType.method1777();
      FaceNormal.method1245();
      class491.HitSplatDefinition_cachedSprites.method2326();
      MoveSpeed.HitSplatDefinition_cached.method2326();
      HitSplatDefinition.HitSplatDefinition_cached.clear();
      HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
      HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
      class31.method119();
      UrlRequest.method643();
      ParamComposition.ParamDefinition_cached.clear();
      class85.method471();
      DbTableType.DBTableType_cache.clear();
      DbRowType.DBRowType_cache.clear();
      Client.Widget_cachedModels.clear();
      Client.Widget_cachedFonts.clear();
      VertexNormal.method1297();
      Widget.Widget_cachedSprites.clear();
      Widget.Widget_cachedModels.clear();
      Widget.Widget_cachedFonts.clear();
      Widget.Widget_cachedSpriteMasks.clear();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      Client.archive5.method2055();
      class13.field44.clearFiles();
      FriendsChat.archive7.clearFiles();
      class144.archive4.clearFiles();
      DynamicObject.field826.clearFiles();
      NetCache.archive9.clearFiles();
      class153.archive6.clearFiles();
      class151.archive11.clearFiles();
      WorldMapEvent.archive8.clearFiles();
      class148.field1333.clearFiles();
      ApproximateRouteStrategy.archive10.clearFiles();
      MusicPatchNode.field2782.clearFiles();
      class12.archive12.clearFiles();
      Canvas.field75.clearFiles();
      WorldMapAreaData.scene.clear();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      Client.field617.method1066();
      System.gc();
      class28.method110(2);
      Client.currentTrackGroupId = -1;
      Client.playingJingle = false;
      UserComparator4.method647();
      class246.updateGameState(10);
   }
}
