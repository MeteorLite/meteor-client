import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("qh")
public class class441 {
   @ObfuscatedName("af")
   static int[] field3834 = new int['耀'];
   @ObfuscatedName("an")
   static int[] field3833;
   @ObfuscatedName("ac")
   public static int field3835;

   static {
      for(int var0 = 0; var0 < 32768; ++var0) {
         int[] var1 = field3834;
         double var4 = (double)(var0 >> 10 & 31) / 31.0D;
         double var6 = (double)(var0 >> 5 & 31) / 31.0D;
         double var8 = (double)(var0 & 31) / 31.0D;
         double var10 = var4;
         if (var6 < var4) {
            var10 = var6;
         }

         if (var8 < var10) {
            var10 = var8;
         }

         double var12 = var4;
         if (var6 > var4) {
            var12 = var6;
         }

         if (var8 > var12) {
            var12 = var8;
         }

         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = (var10 + var12) / 2.0D;
         if (var10 != var12) {
            if (var18 < 0.5D) {
               var16 = (var12 - var10) / (var10 + var12);
            }

            if (var18 >= 0.5D) {
               var16 = (var12 - var10) / (2.0D - var12 - var10);
            }

            if (var4 == var12) {
               var14 = (var6 - var8) / (var12 - var10);
            } else if (var6 == var12) {
               var14 = 2.0D + (var8 - var4) / (var12 - var10);
            } else if (var12 == var8) {
               var14 = (var4 - var6) / (var12 - var10) + 4.0D;
            }
         }

         int var20 = (int)(var14 * 256.0D / 6.0D);
         var20 &= 255;
         double var21 = var16 * 256.0D;
         if (var21 < 0.0D) {
            var21 = 0.0D;
         } else if (var21 > 255.0D) {
            var21 = 255.0D;
         }

         if (var18 > 0.7D) {
            var21 /= 2.0D;
            var21 = Math.floor(var21);
         }

         if (var18 > 0.75D) {
            var21 /= 2.0D;
            var21 = Math.floor(var21);
         }

         if (var18 > 0.85D) {
            var21 /= 2.0D;
            var21 = Math.floor(var21);
         }

         if (var18 > 0.95D) {
            var21 /= 2.0D;
            var21 = Math.floor(var21);
         }

         if (var18 > 0.995D) {
            var18 = 0.995D;
         }

         int var23 = (int)(var21 / 32.0D + (double)(var20 / 4 * 8));
         int var3 = (var23 << 7) + (int)(var18 * 128.0D);
         var1[var0] = var3;
      }

      UserComparator9.method703();
   }
}
