import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
    @ObfuscatedName("af")
    int minPlane;
    @ObfuscatedName("an")
    int planes;
    @ObfuscatedName("aw")
    int regionStartX;
    @ObfuscatedName("ac")
    int regionStartY;
    @ObfuscatedName("au")
    int regionEndX;
    @ObfuscatedName("ab")
    int regionEndY;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljs;I)V",
            garbageValue = "1131699138"
    )
    public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.regionEndX) {
         var1.regionLowX = this.regionEndX;
      }

      if (var1.regionHighX < this.regionEndX) {
         var1.regionHighX = this.regionEndX;
      }

      if (var1.regionLowY > this.regionEndY) {
         var1.regionLowY = this.regionEndY;
      }

      if (var1.regionHighY < this.regionEndY) {
         var1.regionHighY = this.regionEndY;
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IIIB)Z",
            garbageValue = "3"
    )
    public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
         return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
      } else {
         return false;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "-1795894381"
    )
    public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(IIIB)[I",
            garbageValue = "21"
    )
    public int[] getBorderTileLengths(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.regionEndX * 64 - this.regionStartX * 64), var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
         return var4;
      }
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IIB)Llb;",
            garbageValue = "-4"
    )
    public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
         int var4 = var2 + (this.regionStartY * 64 - this.regionEndY * 64);
         return new Coord(this.minPlane, var3, var4);
      }
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)V",
            garbageValue = "0"
    )
    public void read(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.postRead();
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "44"
    )
    void postRead() {
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-14812643"
   )
   static void method1539(int var0) {
      class425.field3796 = var0;
      class425.field3793 = new class425[var0];
      class425.field3794 = 0;
   }
}
