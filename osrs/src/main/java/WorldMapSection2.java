import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Deprecated
@ObfuscatedName("iw")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
    @ObfuscatedName("f")
    int minPlane;
    @ObfuscatedName("w")
    int planes;
    @ObfuscatedName("v")
    int regionStartX;
    @ObfuscatedName("s")
    int regionStartY;
    @ObfuscatedName("z")
    int regionEndX;
    @ObfuscatedName("j")
    int regionEndY;
   @ObfuscatedName("i")
   int field2251;
   @ObfuscatedName("n")
   int field2250;
   @ObfuscatedName("l")
   int field2256;
   @ObfuscatedName("k")
   int field2257;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lii;I)V",
            garbageValue = "1606915966"
    )
    public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2251) {
         var1.regionLowX = this.field2251;
      }

      if (var1.regionHighX < this.field2256) {
         var1.regionHighX = this.field2256;
      }

      if (var1.regionLowY > this.field2250) {
         var1.regionLowY = this.field2250;
      }

      if (var1.regionHighY < this.field2257) {
         var1.regionHighY = this.field2257;
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(IIII)Z",
            garbageValue = "1059252076"
    )
    public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
         return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
      } else {
         return false;
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "1209851870"
    )
    public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 >= this.field2251 && var1 >> 6 <= this.field2256 && var2 >> 6 >= this.field2250 && var2 >> 6 <= this.field2257;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(IIII)[I",
            garbageValue = "-1188894867"
    )
    public int[] getBorderTileLengths(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field2251 * 64 - this.regionStartX * 64), var3 + (this.field2250 * 64 - this.regionStartY * 64)};
         return var4;
      }
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(III)Lko;",
            garbageValue = "-1946236139"
    )
    public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.regionStartX * 64 - this.field2251 * 64 + var1;
         int var4 = var2 + (this.regionStartY * 64 - this.field2250 * 64);
         return new Coord(this.minPlane, var3, var4);
      }
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "158933591"
    )
    public void read(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.field2251 = var1.readUnsignedShort();
      this.field2250 = var1.readUnsignedShort();
      this.field2256 = var1.readUnsignedShort();
      this.field2257 = var1.readUnsignedShort();
      this.postRead();
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1264343644"
    )
    void postRead() {
   }
}
