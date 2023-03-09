import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      descriptor = "[Lsn;"
   )
   @Export("worldSelectBackSprites")
   static SpritePixels[] worldSelectBackSprites;
   @ObfuscatedName("aj")
   @Export("minPlane")
   int minPlane;
   @ObfuscatedName("al")
   @Export("planes")
   int planes;
   @ObfuscatedName("ac")
   @Export("regionStartX")
   int regionStartX;
   @ObfuscatedName("ab")
   @Export("regionStartY")
   int regionStartY;
   @ObfuscatedName("an")
   @Export("regionEndX")
   int regionEndX;
   @ObfuscatedName("ao")
   @Export("regionEndY")
   int regionEndY;
   @ObfuscatedName("av")
   int field2252;
   @ObfuscatedName("aq")
   int field2249;
   @ObfuscatedName("ap")
   int field2253;
   @ObfuscatedName("ar")
   int field2254;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljw;B)V",
      garbageValue = "-27"
   )
   @Export("expandBounds")
   public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2252) {
         var1.regionLowX = this.field2252;
      }

      if (var1.regionHighX < this.field2253) {
         var1.regionHighX = this.field2253;
      }

      if (var1.regionLowY > this.field2249) {
         var1.regionLowY = this.field2249;
      }

      if (var1.regionHighY < this.field2254) {
         var1.regionHighY = this.field2254;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IIII)Z",
      garbageValue = "-779320103"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
         return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
      return var1 >> 6 >= this.field2252 && var1 >> 6 <= this.field2253 && var2 >> 6 >= this.field2249 && var2 >> 6 <= this.field2254;
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
         int[] var4 = new int[]{var2 + (this.field2252 * 64 - this.regionStartX * 64), var3 + (this.field2249 * 64 - this.regionStartY * 64)};
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
         int var3 = this.regionStartX * 64 - this.field2252 * 64 + var1;
         int var4 = var2 + (this.regionStartY * 64 - this.field2249 * 64);
         return new Coord(this.minPlane, var3, var4);
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "1437872186"
   )
   @Export("read")
   public void read(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.field2252 = var1.readUnsignedShort();
      this.field2249 = var1.readUnsignedShort();
      this.field2253 = var1.readUnsignedShort();
      this.field2254 = var1.readUnsignedShort();
      this.postRead();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1750529073"
   )
   @Export("postRead")
   void postRead() {
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)J",
      garbageValue = "30"
   )
   @Export("clockNow")
   public static final synchronized long clockNow() {
      long var0 = System.currentTimeMillis();
      if (var0 < class289.field2656) {
         class289.field2657 += class289.field2656 - var0;
      }

      class289.field2656 = var0;
      return class289.field2657 + var0;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(CS)Z",
      garbageValue = "21072"
   )
   public static boolean method1332(char var0) {
      if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if (var0 != 0) {
            char[] var1 = class365.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if (var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2040870462"
   )
   static void method1329() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var0.obj != null) {
            var0.set();
         }
      }

   }
}
