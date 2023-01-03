import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
   @ObfuscatedName("h")
   int chunkXLow;
   @ObfuscatedName("e")
   int chunkYLow;
   @ObfuscatedName("v")
   int chunkX;
   @ObfuscatedName("x")
   int chunkY;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "16"
   )
   void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2384.value) {
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
         super.groupId = var1.method2362();
         super.fileId = var1.method2362();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1703912011"
   )
   void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2359 = new byte[super.planes][64][64];
      super.field2360 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class251.field2380.value) {
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
      garbageValue = "-1726020547"
   )
   int getChunkXLow() {
      return this.chunkXLow;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "660980173"
   )
   int getChunkYLow() {
      return this.chunkYLow;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1808236663"
   )
   int getChunkX() {
      return this.chunkX;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1429277578"
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
         if (super.regionX == var2.regionX && super.regionY == var2.regionY) {
            return this.chunkX == var2.chunkX && this.chunkY == var2.chunkY;
         } else {
            return false;
         }
      }
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "-55"
   )
   static int method1402(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         var4 = ObjTypeCustomisation.getWidget(var3);
      } else {
         var4 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
      }

      if (var0 == 1000) {
         class87.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 3];
         class69.invalidateWidget(var4);
         BuddyRankComparator.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1001) {
         class87.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 3];
         class69.invalidateWidget(var4);
         BuddyRankComparator.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         if (var5 != var4.isHidden) {
            var4.isHidden = var5;
            class69.invalidateWidget(var4);
         }

         return 1;
      } else if (var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         return 1;
      } else if (var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
