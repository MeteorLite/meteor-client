import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class248 implements WorldMapSection {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      descriptor = "Lee;"
   )
   @Export("varcs")
   static Varcs varcs;
   @ObfuscatedName("aj")
   int field2309;
   @ObfuscatedName("al")
   int field2300;
   @ObfuscatedName("ac")
   int field2301;
   @ObfuscatedName("ab")
   int field2302;
   @ObfuscatedName("an")
   int field2299;
   @ObfuscatedName("ao")
   int field2304;
   @ObfuscatedName("av")
   int field2305;
   @ObfuscatedName("aq")
   int field2306;
   @ObfuscatedName("ap")
   int field2307;
   @ObfuscatedName("ar")
   int field2303;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljw;B)V",
      garbageValue = "-27"
   )
   @Export("expandBounds")
   public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2299) {
         var1.regionLowX = this.field2299;
      }

      if (var1.regionHighX < this.field2299) {
         var1.regionHighX = this.field2299;
      }

      if (var1.regionLowY > this.field2304) {
         var1.regionLowY = this.field2304;
      }

      if (var1.regionHighY < this.field2304) {
         var1.regionHighY = this.field2304;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IIII)Z",
      garbageValue = "-779320103"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.field2309 && var1 < this.field2300 + this.field2309) {
         return var2 >= (this.field2301 << 6) + (this.field2305 << 3) && var2 <= (this.field2301 << 6) + (this.field2305 << 3) + 7 && var3 >= (this.field2302 << 6) + (this.field2306 << 3) && var3 <= (this.field2302 << 6) + (this.field2306 << 3) + 7;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "207934155"
   )
   @Export("containsPosition")
   public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.field2299 << 6) + (this.field2307 << 3) && var1 <= (this.field2299 << 6) + (this.field2307 << 3) + 7 && var2 >= (this.field2304 << 6) + (this.field2303 << 3) && var2 <= (this.field2304 << 6) + (this.field2303 << 3) + 7;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IIII)[I",
      garbageValue = "-1684969021"
   )
   @Export("getBorderTileLengths")
   public int[] getBorderTileLengths(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field2299 * 64 - this.field2301 * 64) + (this.field2307 * 8 - this.field2305 * 8), var3 + (this.field2304 * 64 - this.field2302 * 64) + (this.field2303 * 8 - this.field2306 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(III)Llt;",
      garbageValue = "2016097062"
   )
   @Export("coord")
   public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.field2301 * 64 - this.field2299 * 64 + (this.field2305 * 8 - this.field2307 * 8) + var1;
         int var4 = var2 + (this.field2302 * 64 - this.field2304 * 64) + (this.field2306 * 8 - this.field2303 * 8);
         return new Coord(this.field2309, var3, var4);
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "1437872186"
   )
   @Export("read")
   public void read(Buffer var1) {
      this.field2309 = var1.readUnsignedByte();
      this.field2300 = var1.readUnsignedByte();
      this.field2301 = var1.readUnsignedShort();
      this.field2305 = var1.readUnsignedByte();
      this.field2302 = var1.readUnsignedShort();
      this.field2306 = var1.readUnsignedByte();
      this.field2299 = var1.readUnsignedShort();
      this.field2307 = var1.readUnsignedByte();
      this.field2304 = var1.readUnsignedShort();
      this.field2303 = var1.readUnsignedByte();
      this.method1420();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-43"
   )
   void method1420() {
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "-827704167"
   )
   public static void method1423(AbstractArchive var0) {
      VarbitComposition.VarbitDefinition_archive = var0;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1570579154"
   )
   public static void method1422() {
      try {
         JagexCache.JagexCache_dat2File.close();

         for(int var0 = 0; var0 < class188.idxCount; ++var0) {
            JagexCache.JagexCache_idxFiles[var0].close();
         }

         JagexCache.JagexCache_idx255File.close();
         JagexCache.JagexCache_randomDat.close();
      } catch (Exception var2) {
         ;
      }

   }
}
