import java.io.File;
import java.io.RandomAccessFile;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
   @ObfuscatedName("vf")
   static long field2243;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_small = new WorldMapLabelSize(2, 0, 4);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   public static final WorldMapLabelSize WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
   @ObfuscatedName("x")
   final int field2248;
   @ObfuscatedName("m")
   final int field2247;
   @ObfuscatedName("q")
   final int field2249;

   WorldMapLabelSize(int var1, int var2, int var3) {
      this.field2248 = var1;
      this.field2247 = var2;
      this.field2249 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(FI)Z",
      garbageValue = "-1921654209"
   )
   boolean method1308(float var1) {
      return var1 >= (float)this.field2249;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Liq;",
      garbageValue = "-1709132598"
   )
   static WorldMapLabelSize[] method1305() {
      return new WorldMapLabelSize[]{WorldMapLabelSize_medium, WorldMapLabelSize_large, WorldMapLabelSize_small};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/io/File;ZI)Z",
      garbageValue = "-823658761"
   )
   public static boolean method1307(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if (var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1850317115"
   )
   public static boolean isDigit(char var0) {
      return var0 >= '0' && var0 <= '9';
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "1"
   )
   static int method1306(int var0, Script var1, boolean var2) {
      if (var0 == 7463) {
         boolean var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         ItemLayer.method1108(var3);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "228437568"
   )
   static void method1310(int var0, int var1) {
      ZoneOperation.method1522(PendingSpawn.tempMenuAction, var0, var1);
      PendingSpawn.tempMenuAction = null;
   }
}
