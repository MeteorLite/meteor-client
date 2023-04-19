import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
    @ObfuscatedName("af")
    int group;
    @ObfuscatedName("an")
    int type;
   @ObfuscatedName("aw")
   boolean field848 = false;

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "([BB)V",
            garbageValue = "7"
    )
    public static synchronized void ByteArrayPool_release(byte[] var0) {
      if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < ByteArrayPool.field3659) {
         ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
      } else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < ByteArrayPool.field3660) {
         ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
      } else if (var0.length == 10000 && ByteArrayPool.ByteArrayPool_largeCount < ByteArrayPool.field3661) {
         ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
      } else if (var0.length == 30000 && ByteArrayPool.field3666 < ByteArrayPool.field3655) {
         ByteArrayPool.field3664[++ByteArrayPool.field3666 - 1] = var0;
      } else {
         if (UserComparator3.ByteArrayPool_arrays != null) {
            for(int var1 = 0; var1 < ClanChannel.ByteArrayPool_alternativeSizes.length; ++var1) {
               if (var0.length == ClanChannel.ByteArrayPool_alternativeSizes[var1] && class136.ByteArrayPool_altSizeArrayCounts[var1] < UserComparator3.ByteArrayPool_arrays[var1].length) {
                  UserComparator3.ByteArrayPool_arrays[var1][class136.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1880388281"
   )
   public static void method488() {
      StructComposition.StructDefinition_cached.clear();
   }

    @ObfuscatedName("at")
    public static int Entity_unpackID(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
