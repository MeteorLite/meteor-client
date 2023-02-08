import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
    @ObfuscatedName("f")
    int chunkXLow;
    @ObfuscatedName("w")
    int chunkYLow;
    @ObfuscatedName("v")
    int chunkX;
    @ObfuscatedName("s")
    int chunkY;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "16"
    )
    void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2381.value) {
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
         super.groupId = var1.method2419();
         super.fileId = var1.method2419();
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "9"
    )
    void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2358 = new byte[super.planes][64][64];
      super.field2355 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class255.field2377.value) {
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

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-476588904"
    )
    int getChunkXLow() {
      return this.chunkXLow;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-31"
    )
    int getChunkYLow() {
      return this.chunkYLow;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "64"
    )
    int getChunkX() {
      return this.chunkX;
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-120"
    )
    int getChunkY() {
      return this.chunkY;
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_1)) {
         return false;
      } else {
         WorldMapData_1 var2 = (WorldMapData_1)var1;
         if (var2.regionX == super.regionX && super.regionY == var2.regionY) {
            return var2.chunkX == this.chunkX && this.chunkY == var2.chunkY;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1996834961"
   )
   public static byte[] method1412(Object var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if (var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if (var0 instanceof AbstractByteArrayCopier) {
         AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
