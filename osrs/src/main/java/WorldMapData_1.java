import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
   @ObfuscatedName("wm")
   @ObfuscatedSignature(
      descriptor = "Lrc;"
   )
   @Export("worldMap")
   static WorldMap worldMap;
   @ObfuscatedName("aj")
   @Export("chunkXLow")
   int chunkXLow;
   @ObfuscatedName("al")
   @Export("chunkYLow")
   int chunkYLow;
   @ObfuscatedName("ac")
   @Export("chunkX")
   int chunkX;
   @ObfuscatedName("ab")
   @Export("chunkY")
   int chunkY;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-2019675961"
   )
   @Export("init")
   void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2376.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         this.chunkXLow = var1.readUnsignedByte();
         this.chunkYLow = var1.readUnsignedByte();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         this.chunkX = var1.readUnsignedByte();
         this.chunkY = var1.readUnsignedByte();
         super.groupId = var1.method2423();
         super.fileId = var1.method2423();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-724858915"
   )
   @Export("readGeography")
   void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2347 = new byte[super.planes][64][64];
      super.field2350 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class258.field2373.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         int var5 = var1.readUnsignedByte();
         int var6 = var1.readUnsignedByte();
         if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
            for(int var7 = 0; var7 < 8; ++var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "567378271"
   )
   @Export("getChunkXLow")
   int getChunkXLow() {
      return this.chunkXLow;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-90"
   )
   @Export("getChunkYLow")
   int getChunkYLow() {
      return this.chunkYLow;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "71"
   )
   @Export("getChunkX")
   int getChunkX() {
      return this.chunkX;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "180"
   )
   @Export("getChunkY")
   int getChunkY() {
      return this.chunkY;
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_1)) {
         return false;
      } else {
         WorldMapData_1 var2 = (WorldMapData_1)var1;
         if (var2.regionX == super.regionX && super.regionY == var2.regionY) {
            return var2.chunkX == this.chunkX && var2.chunkY == this.chunkY;
         } else {
            return false;
         }
      }
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "409091364"
   )
   public static void method1414(AbstractArchive var0) {
      VarpDefinition.VarpDefinition_archive = var0;
      VarpDefinition.field1461 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
   }
}
