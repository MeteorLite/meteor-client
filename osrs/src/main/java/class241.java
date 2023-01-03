import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class241 implements WorldMapSection {
   @ObfuscatedName("ik")
   static byte[][] regionMapArchives;
   @ObfuscatedName("h")
   int field2318;
   @ObfuscatedName("e")
   int field2313;
   @ObfuscatedName("v")
   int field2314;
   @ObfuscatedName("x")
   int field2312;
   @ObfuscatedName("m")
   int field2320;
   @ObfuscatedName("q")
   int field2316;
   @ObfuscatedName("f")
   int field2319;
   @ObfuscatedName("r")
   int field2315;
   @ObfuscatedName("u")
   int field2317;
   @ObfuscatedName("b")
   int field2321;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lit;B)V",
      garbageValue = "86"
   )
   public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2320) {
         var1.regionLowX = this.field2320;
      }

      if (var1.regionHighX < this.field2320) {
         var1.regionHighX = this.field2320;
      }

      if (var1.regionLowY > this.field2316) {
         var1.regionLowY = this.field2316;
      }

      if (var1.regionHighY < this.field2316) {
         var1.regionHighY = this.field2316;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIII)Z",
      garbageValue = "986597458"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.field2318 && var1 < this.field2318 + this.field2313) {
         return var2 >= (this.field2314 << 6) + (this.field2319 << 3) && var2 <= (this.field2314 << 6) + (this.field2319 << 3) + 7 && var3 >= (this.field2312 << 6) + (this.field2315 << 3) && var3 <= (this.field2312 << 6) + (this.field2315 << 3) + 7;
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIS)Z",
      garbageValue = "-11823"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.field2320 << 6) + (this.field2317 << 3) && var1 <= (this.field2320 << 6) + (this.field2317 << 3) + 7 && var2 >= (this.field2316 << 6) + (this.field2321 << 3) && var2 <= (this.field2316 << 6) + (this.field2321 << 3) + 7;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IIIB)[I",
      garbageValue = "-52"
   )
   public int[] getBorderTileLengths(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field2320 * 64 - this.field2314 * 64) + (this.field2317 * 8 - this.field2319 * 8), var3 + (this.field2316 * 64 - this.field2312 * 64) + (this.field2321 * 8 - this.field2315 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(III)Lky;",
      garbageValue = "1584933614"
   )
   public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.field2314 * 64 - this.field2320 * 64 + (this.field2319 * 8 - this.field2317 * 8) + var1;
         int var4 = var2 + (this.field2312 * 64 - this.field2316 * 64) + (this.field2315 * 8 - this.field2321 * 8);
         return new Coord(this.field2318, var3, var4);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1737950913"
   )
   public void read(Buffer var1) {
      this.field2318 = var1.readUnsignedByte();
      this.field2313 = var1.readUnsignedByte();
      this.field2314 = var1.readUnsignedShort();
      this.field2319 = var1.readUnsignedByte();
      this.field2312 = var1.readUnsignedShort();
      this.field2315 = var1.readUnsignedByte();
      this.field2320 = var1.readUnsignedShort();
      this.field2317 = var1.readUnsignedByte();
      this.field2316 = var1.readUnsignedShort();
      this.field2321 = var1.readUnsignedByte();
      this.method1407();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "556947124"
   )
   void method1407() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-31"
   )
   public static void method1410() {
      if (NetCache.NetCache_socket != null) {
         NetCache.NetCache_socket.close();
      }

   }
}
