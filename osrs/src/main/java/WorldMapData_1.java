import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
    @ObfuscatedName("af")
    int chunkXLow;
    @ObfuscatedName("an")
    int chunkYLow;
    @ObfuscatedName("aw")
    int chunkX;
    @ObfuscatedName("ac")
    int chunkY;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "1529906024"
    )
    void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2419.value) {
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
         super.groupId = var1.method2516();
         super.fileId = var1.method2516();
      }
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;S)V",
            garbageValue = "2348"
    )
    void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2390 = new byte[super.planes][64][64];
      super.field2396 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class262.field2417.value) {
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

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-907307158"
    )
    int getChunkXLow() {
      return this.chunkXLow;
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "652823069"
    )
    int getChunkYLow() {
      return this.chunkYLow;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "57"
    )
    int getChunkX() {
      return this.chunkX;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(S)I",
            garbageValue = "-12865"
    )
    int getChunkY() {
      return this.chunkY;
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_1)) {
         return false;
      } else {
         WorldMapData_1 var2 = (WorldMapData_1)var1;
         if (super.regionX == var2.regionX && var2.regionY == super.regionY) {
            return this.chunkX == var2.chunkX && this.chunkY == var2.chunkY;
         } else {
            return false;
         }
      }
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "4393"
   )
   static void method1486() {
      for(class206 var0 = (class206)Client.field569.last(); var0 != null; var0 = (class206)Client.field569.previous()) {
         var0.remove();
      }

   }
}
