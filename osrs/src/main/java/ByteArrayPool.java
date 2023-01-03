import java.util.ArrayList;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nf")
@Implements("ByteArrayPool")
public class ByteArrayPool {
   @ObfuscatedName("m")
   static int ByteArrayPool_smallCount = 0;
   @ObfuscatedName("q")
   static int ByteArrayPool_mediumCount = 0;
   @ObfuscatedName("f")
   static int ByteArrayPool_largeCount = 0;
   @ObfuscatedName("r")
   static int field3633 = 0;
   @ObfuscatedName("u")
   static int field3634 = 1000;
   @ObfuscatedName("b")
   static int field3629 = 250;
   @ObfuscatedName("j")
   static int field3636 = 100;
   @ObfuscatedName("g")
   static int field3635 = 50;
   @ObfuscatedName("i")
   static byte[][] ByteArrayPool_small = new byte[1000][];
   @ObfuscatedName("o")
   static byte[][] ByteArrayPool_medium = new byte[250][];
   @ObfuscatedName("n")
   static byte[][] ByteArrayPool_large = new byte[100][];
   @ObfuscatedName("k")
   static byte[][] field3640 = new byte[50][];
   @ObfuscatedName("t")
   public static ArrayList field3641 = new ArrayList();

   static {
      field3641.clear();
      field3641.add(100);
      field3641.add(5000);
      field3641.add(10000);
      field3641.add(30000);
      new HashMap();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IZB)[B",
      garbageValue = "80"
   )
   public static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
      byte[] var2;
      if ((var0 == 100 || var0 < 100 && var1) && ByteArrayPool_smallCount > 0) {
         var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
         ByteArrayPool_small[ByteArrayPool_smallCount] = null;
         return var2;
      } else if ((var0 == 5000 || var0 < 5000 && var1) && ByteArrayPool_mediumCount > 0) {
         var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
         ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
         return var2;
      } else if ((var0 == 10000 || var0 < 10000 && var1) && ByteArrayPool_largeCount > 0) {
         var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
         ByteArrayPool_large[ByteArrayPool_largeCount] = null;
         return var2;
      } else if ((var0 == 30000 || var0 < 30000 && var1) && field3633 > 0) {
         var2 = field3640[--field3633];
         field3640[field3633] = null;
         return var2;
      } else {
         int var4;
         if (SceneTilePaint.ByteArrayPool_arrays != null) {
            for(var4 = 0; var4 < Frames.ByteArrayPool_alternativeSizes.length; ++var4) {
               if ((Frames.ByteArrayPool_alternativeSizes[var4] == var0 || var0 < Frames.ByteArrayPool_alternativeSizes[var4] && var1) && ModelData0.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
                  byte[] var3 = SceneTilePaint.ByteArrayPool_arrays[var4][--ModelData0.ByteArrayPool_altSizeArrayCounts[var4]];
                  SceneTilePaint.ByteArrayPool_arrays[var4][ModelData0.ByteArrayPool_altSizeArrayCounts[var4]] = null;
                  return var3;
               }
            }
         }

         if (var1 && Frames.ByteArrayPool_alternativeSizes != null) {
            for(var4 = 0; var4 < Frames.ByteArrayPool_alternativeSizes.length; ++var4) {
               if (var0 <= Frames.ByteArrayPool_alternativeSizes[var4] && ModelData0.ByteArrayPool_altSizeArrayCounts[var4] < SceneTilePaint.ByteArrayPool_arrays[var4].length) {
                  return new byte[Frames.ByteArrayPool_alternativeSizes[var4]];
               }
            }
         }

         return new byte[var0];
      }
   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      descriptor = "(IIIZB)V",
      garbageValue = "101"
   )
   static final void method1996(int var0, int var1, int var2, boolean var3) {
      if (Players.loadInterface(var0)) {
         ItemContainer.resizeInterface(class71.Widget_interfaceComponents[var0], -1, var1, var2, var3);
      }
   }
}
