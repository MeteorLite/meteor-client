import java.util.ArrayList;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ot")
@Implements("ByteArrayPool")
public class ByteArrayPool {
   @ObfuscatedName("an")
   @Export("ByteArrayPool_smallCount")
   static int ByteArrayPool_smallCount = 0;
   @ObfuscatedName("ao")
   @Export("ByteArrayPool_mediumCount")
   static int ByteArrayPool_mediumCount = 0;
   @ObfuscatedName("av")
   @Export("ByteArrayPool_largeCount")
   static int ByteArrayPool_largeCount = 0;
   @ObfuscatedName("aq")
   static int field3610 = 0;
   @ObfuscatedName("ap")
   static int field3613 = 1000;
   @ObfuscatedName("ar")
   static int field3614 = 250;
   @ObfuscatedName("ak")
   static int field3615 = 100;
   @ObfuscatedName("ax")
   static int field3608 = 50;
   @ObfuscatedName("as")
   @Export("ByteArrayPool_small")
   static byte[][] ByteArrayPool_small = new byte[1000][];
   @ObfuscatedName("ay")
   @Export("ByteArrayPool_medium")
   static byte[][] ByteArrayPool_medium = new byte[250][];
   @ObfuscatedName("am")
   @Export("ByteArrayPool_large")
   static byte[][] ByteArrayPool_large = new byte[100][];
   @ObfuscatedName("az")
   static byte[][] field3619 = new byte[50][];
   @ObfuscatedName("at")
   public static ArrayList field3616 = new ArrayList();

   static {
      SpriteMask.method1629();
      new HashMap();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IZI)[B",
      garbageValue = "1201755418"
   )
   @Export("ByteArrayPool_getArrayBool")
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
      } else if ((var0 == 30000 || var0 < 30000 && var1) && field3610 > 0) {
         var2 = field3619[--field3610];
         field3619[field3610] = null;
         return var2;
      } else {
         int var4;
         if (InterfaceParent.ByteArrayPool_arrays != null) {
            for(var4 = 0; var4 < class212.ByteArrayPool_alternativeSizes.length; ++var4) {
               if ((class212.ByteArrayPool_alternativeSizes[var4] == var0 || var0 < class212.ByteArrayPool_alternativeSizes[var4] && var1) && SoundSystem.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
                  byte[] var3 = InterfaceParent.ByteArrayPool_arrays[var4][--SoundSystem.ByteArrayPool_altSizeArrayCounts[var4]];
                  InterfaceParent.ByteArrayPool_arrays[var4][SoundSystem.ByteArrayPool_altSizeArrayCounts[var4]] = null;
                  return var3;
               }
            }
         }

         if (var1 && class212.ByteArrayPool_alternativeSizes != null) {
            for(var4 = 0; var4 < class212.ByteArrayPool_alternativeSizes.length; ++var4) {
               if (var0 <= class212.ByteArrayPool_alternativeSizes[var4] && SoundSystem.ByteArrayPool_altSizeArrayCounts[var4] < InterfaceParent.ByteArrayPool_arrays[var4].length) {
                  return new byte[class212.ByteArrayPool_alternativeSizes[var4]];
               }
            }
         }

         return new byte[var0];
      }
   }
}
