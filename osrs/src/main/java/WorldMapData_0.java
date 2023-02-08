import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
    @ObfuscatedName("tp")
    static int cameraLookAtX;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "-2018545200"
    )
    void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2380.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
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
      if (var2 != class255.field2378.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         if (var3 == super.regionX && var4 == super.regionY) {
            for(int var5 = 0; var5 < 64; ++var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  this.readTile(var5, var6, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_0)) {
         return false;
      } else {
         WorldMapData_0 var2 = (WorldMapData_0)var1;
         return var2.regionX == super.regionX && var2.regionY == super.regionY;
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return super.regionX | super.regionY << 8;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)[Lre;",
            garbageValue = "-1511545880"
    )
    public static FillMode[] FillMode_values() {
      return new FillMode[]{FillMode.field4073, FillMode.field4072, FillMode.SOLID};
   }
}
