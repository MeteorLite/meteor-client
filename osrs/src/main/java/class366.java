import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ok")
public class class366 {
   @ObfuscatedName("aj")
   static char[] field3546 = new char[64];
   @ObfuscatedName("al")
   static char[] field3542;
   @ObfuscatedName("ac")
   static char[] field3543;
   @ObfuscatedName("ab")
   static int[] field3545;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lfi;"
   )
   static ClanSettings field3544;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3546[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3546[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3546[var0] = (char)(var0 + 48 - 52);
      }

      field3546[62] = '+';
      field3546[63] = '/';
      field3542 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3542[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3542[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3542[var0] = (char)(var0 + 48 - 52);
      }

      field3542[62] = '*';
      field3542[63] = '-';
      field3543 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3543[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3543[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3543[var0] = (char)(var0 + 48 - 52);
      }

      field3543[62] = '-';
      field3543[63] = '_';
      field3545 = new int[128];

      for(var0 = 0; var0 < field3545.length; ++var0) {
         field3545[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3545[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3545[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3545[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3545;
      field3545[43] = 62;
      var2[42] = 62;
      int[] var1 = field3545;
      field3545[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "([BI)V",
      garbageValue = "681579235"
   )
   @Export("ByteArrayPool_release")
   public static synchronized void ByteArrayPool_release(byte[] var0) {
      if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < ByteArrayPool.field3613) {
         ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
      } else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < ByteArrayPool.field3614) {
         ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
      } else if (var0.length == 10000 && ByteArrayPool.ByteArrayPool_largeCount < ByteArrayPool.field3615) {
         ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
      } else if (var0.length == 30000 && ByteArrayPool.field3610 < ByteArrayPool.field3608) {
         ByteArrayPool.field3619[++ByteArrayPool.field3610 - 1] = var0;
      } else {
         if (InterfaceParent.ByteArrayPool_arrays != null) {
            for(int var1 = 0; var1 < class212.ByteArrayPool_alternativeSizes.length; ++var1) {
               if (var0.length == class212.ByteArrayPool_alternativeSizes[var1] && SoundSystem.ByteArrayPool_altSizeArrayCounts[var1] < InterfaceParent.ByteArrayPool_arrays[var1].length) {
                  InterfaceParent.ByteArrayPool_arrays[var1][SoundSystem.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }
}
