import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class245 implements WorldMapSection {
    @ObfuscatedName("ho")
    @ObfuscatedSignature(
            descriptor = "Ldi;"
    )
    static UrlRequester urlRequester;
    @ObfuscatedName("ks")
    static int oculusOrbFocalPointX;
   @ObfuscatedName("f")
   int field2308;
   @ObfuscatedName("w")
   int field2304;
   @ObfuscatedName("v")
   int field2312;
   @ObfuscatedName("s")
   int field2306;
   @ObfuscatedName("z")
   int field2307;
   @ObfuscatedName("j")
   int field2305;
   @ObfuscatedName("i")
   int field2303;
   @ObfuscatedName("n")
   int field2309;
   @ObfuscatedName("l")
   int field2311;
   @ObfuscatedName("k")
   int field2310;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lii;I)V",
            garbageValue = "1606915966"
    )
    public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2307) {
         var1.regionLowX = this.field2307;
      }

      if (var1.regionHighX < this.field2307) {
         var1.regionHighX = this.field2307;
      }

      if (var1.regionLowY > this.field2305) {
         var1.regionLowY = this.field2305;
      }

      if (var1.regionHighY < this.field2305) {
         var1.regionHighY = this.field2305;
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(IIII)Z",
            garbageValue = "1059252076"
    )
    public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.field2308 && var1 < this.field2308 + this.field2304) {
         return var2 >= (this.field2312 << 6) + (this.field2303 << 3) && var2 <= (this.field2312 << 6) + (this.field2303 << 3) + 7 && var3 >= (this.field2306 << 6) + (this.field2309 << 3) && var3 <= (this.field2306 << 6) + (this.field2309 << 3) + 7;
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
      return var1 >= (this.field2307 << 6) + (this.field2311 << 3) && var1 <= (this.field2307 << 6) + (this.field2311 << 3) + 7 && var2 >= (this.field2305 << 6) + (this.field2310 << 3) && var2 <= (this.field2305 << 6) + (this.field2310 << 3) + 7;
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
         int[] var4 = new int[]{var2 + (this.field2307 * 64 - this.field2312 * 64) + (this.field2311 * 8 - this.field2303 * 8), var3 + (this.field2305 * 64 - this.field2306 * 64) + (this.field2310 * 8 - this.field2309 * 8)};
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
         int var3 = this.field2312 * 64 - this.field2307 * 64 + (this.field2303 * 8 - this.field2311 * 8) + var1;
         int var4 = var2 + (this.field2306 * 64 - this.field2305 * 64) + (this.field2309 * 8 - this.field2310 * 8);
         return new Coord(this.field2308, var3, var4);
      }
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "158933591"
    )
    public void read(Buffer var1) {
      this.field2308 = var1.readUnsignedByte();
      this.field2304 = var1.readUnsignedByte();
      this.field2312 = var1.readUnsignedShort();
      this.field2303 = var1.readUnsignedByte();
      this.field2306 = var1.readUnsignedShort();
      this.field2309 = var1.readUnsignedByte();
      this.field2307 = var1.readUnsignedShort();
      this.field2311 = var1.readUnsignedByte();
      this.field2305 = var1.readUnsignedShort();
      this.field2310 = var1.readUnsignedByte();
      this.method1417();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "432580282"
   )
   void method1417() {
   }
}
