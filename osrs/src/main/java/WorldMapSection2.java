import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("h")
   int minPlane;
   @ObfuscatedName("e")
   int planes;
   @ObfuscatedName("v")
   int regionStartX;
   @ObfuscatedName("x")
   int regionStartY;
   @ObfuscatedName("m")
   int regionEndX;
   @ObfuscatedName("q")
   int regionEndY;
   @ObfuscatedName("f")
   int field2263;
   @ObfuscatedName("r")
   int field2262;
   @ObfuscatedName("u")
   int field2259;
   @ObfuscatedName("b")
   int field2266;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lit;B)V",
      garbageValue = "86"
   )
   public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2263) {
         var1.regionLowX = this.field2263;
      }

      if (var1.regionHighX < this.field2259) {
         var1.regionHighX = this.field2259;
      }

      if (var1.regionLowY > this.field2262) {
         var1.regionLowY = this.field2262;
      }

      if (var1.regionHighY < this.field2266) {
         var1.regionHighY = this.field2266;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIII)Z",
      garbageValue = "986597458"
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
      descriptor = "(IIS)Z",
      garbageValue = "-11823"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 >= this.field2263 && var1 >> 6 <= this.field2259 && var2 >> 6 >= this.field2262 && var2 >> 6 <= this.field2266;
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
         int[] var4 = new int[]{var2 + (this.field2263 * 64 - this.regionStartX * 64), var3 + (this.field2262 * 64 - this.regionStartY * 64)};
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
         int var3 = this.regionStartX * 64 - this.field2263 * 64 + var1;
         int var4 = var2 + (this.regionStartY * 64 - this.field2262 * 64);
         return new Coord(this.minPlane, var3, var4);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1737950913"
   )
   public void read(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.field2263 = var1.readUnsignedShort();
      this.field2262 = var1.readUnsignedShort();
      this.field2259 = var1.readUnsignedShort();
      this.field2266 = var1.readUnsignedShort();
      this.postRead();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   void postRead() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1114752689"
   )
   public static boolean method1328(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-1887108041"
   )
   static int method1327(int var0, Script var1, boolean var2) {
      Widget var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
      if (var0 == 2800) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = PacketWriter.Widget_unpackTargetMask(Clock.getWidgetFlags(var3));
         return 1;
      } else if (var0 != 2801) {
         if (var0 == 2802) {
            if (var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         --var4;
         if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
