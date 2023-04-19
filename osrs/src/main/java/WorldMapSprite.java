import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
    @ObfuscatedName("an")
    final int[] tileColors;

   WorldMapSprite() {
      this.tileColors = new int[4096];
   }

   WorldMapSprite(int[] var1) {
      this.tileColors = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(III)I",
            garbageValue = "222072056"
    )
    final int getTileColor(int var1, int var2) {
      return this.tileColors[var2 * 64 + var1];
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
      garbageValue = "20"
   )
   public static String method1524(CharSequence[] var0, int var1, int var2) {
      if (var2 == 0) {
         return "";
      } else if (var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null ? "null" : var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if (var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if (var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;II[BIB)I",
            garbageValue = "39"
    )
    public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if ((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if (var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if (var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if (var7 == 402) {
               var3[var6 + var4] = -125;
            } else if (var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if (var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if (var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if (var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if (var7 == 710) {
               var3[var6 + var4] = -120;
            } else if (var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if (var7 == 352) {
               var3[var6 + var4] = -118;
            } else if (var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if (var7 == 338) {
               var3[var6 + var4] = -116;
            } else if (var7 == 381) {
               var3[var6 + var4] = -114;
            } else if (var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if (var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if (var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if (var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if (var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if (var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if (var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if (var7 == 732) {
               var3[var6 + var4] = -104;
            } else if (var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if (var7 == 353) {
               var3[var6 + var4] = -102;
            } else if (var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if (var7 == 339) {
               var3[var6 + var4] = -100;
            } else if (var7 == 382) {
               var3[var6 + var4] = -98;
            } else if (var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}
