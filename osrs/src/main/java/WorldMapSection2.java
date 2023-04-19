import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      descriptor = "[Lmq;"
   )
   static Widget[] field2292;
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
   @ObfuscatedName("aq")
   int field2293;
   @ObfuscatedName("al")
   int field2299;
   @ObfuscatedName("at")
   int field2300;
   @ObfuscatedName("aa")
   int field2302;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljs;I)V",
            garbageValue = "1131699138"
    )
    public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2293) {
         var1.regionLowX = this.field2293;
      }

      if (var1.regionHighX < this.field2300) {
         var1.regionHighX = this.field2300;
      }

      if (var1.regionLowY > this.field2299) {
         var1.regionLowY = this.field2299;
      }

      if (var1.regionHighY < this.field2302) {
         var1.regionHighY = this.field2302;
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IIIB)Z",
            garbageValue = "3"
    )
    public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
         return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
      return var1 >> 6 >= this.field2293 && var1 >> 6 <= this.field2300 && var2 >> 6 >= this.field2299 && var2 >> 6 <= this.field2302;
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
         int[] var4 = new int[]{var2 + (this.field2293 * 64 - this.regionStartX * 64), var3 + (this.field2299 * 64 - this.regionStartY * 64)};
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
         int var3 = this.regionStartX * 64 - this.field2293 * 64 + var1;
         int var4 = var2 + (this.regionStartY * 64 - this.field2299 * 64);
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
      this.field2293 = var1.readUnsignedShort();
      this.field2299 = var1.readUnsignedShort();
      this.field2300 = var1.readUnsignedShort();
      this.field2302 = var1.readUnsignedShort();
      this.postRead();
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "344912093"
    )
    void postRead() {
   }
}
