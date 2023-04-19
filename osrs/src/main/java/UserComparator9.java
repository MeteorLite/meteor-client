import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
    @ObfuscatedName("af")
    final boolean reversed;

   public UserComparator9(boolean var1) {
      this.reversed = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lpb;Lpb;I)I",
            garbageValue = "150312401"
    )
    int compareBuddy(Buddy var1, Buddy var2) {
      if (Client.worldId == var1.world && var2.world == Client.worldId) {
         return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
      } else {
         return this.compareUser(var1, var2);
      }
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-798861149"
   )
   static void method703() {
      if (class441.field3833 == null) {
         class441.field3833 = new int[65536];
         double var0 = 0.949999988079071D;

         for(int var2 = 0; var2 < 65536; ++var2) {
            double var3 = 0.0078125D + (double)(var2 >> 10 & 63) / 64.0D;
            double var5 = (double)(var2 >> 7 & 7) / 8.0D + 0.0625D;
            double var7 = (double)(var2 & 127) / 128.0D;
            double var9 = var7;
            double var11 = var7;
            double var13 = var7;
            if (var5 != 0.0D) {
               double var15;
               if (var7 < 0.5D) {
                  var15 = var7 * (var5 + 1.0D);
               } else {
                  var15 = var5 + var7 - var5 * var7;
               }

               double var17 = var7 * 2.0D - var15;
               double var19 = var3 + 0.3333333333333333D;
               if (var19 > 1.0D) {
                  --var19;
               }

               double var23 = var3 - 0.3333333333333333D;
               if (var23 < 0.0D) {
                  ++var23;
               }

               if (var19 * 6.0D < 1.0D) {
                  var9 = var17 + var19 * 6.0D * (var15 - var17);
               } else if (var19 * 2.0D < 1.0D) {
                  var9 = var15;
               } else if (var19 * 3.0D < 2.0D) {
                  var9 = var17 + 6.0D * (var15 - var17) * (0.6666666666666666D - var19);
               } else {
                  var9 = var17;
               }

               if (var3 * 6.0D < 1.0D) {
                  var11 = 6.0D * (var15 - var17) * var3 + var17;
               } else if (var3 * 2.0D < 1.0D) {
                  var11 = var15;
               } else if (var3 * 3.0D < 2.0D) {
                  var11 = (var15 - var17) * (0.6666666666666666D - var3) * 6.0D + var17;
               } else {
                  var11 = var17;
               }

               if (var23 * 6.0D < 1.0D) {
                  var13 = var23 * 6.0D * (var15 - var17) + var17;
               } else if (var23 * 2.0D < 1.0D) {
                  var13 = var15;
               } else if (var23 * 3.0D < 2.0D) {
                  var13 = 6.0D * (0.6666666666666666D - var23) * (var15 - var17) + var17;
               } else {
                  var13 = var17;
               }
            }

            var9 = Math.pow(var9, var0);
            var11 = Math.pow(var11, var0);
            var13 = Math.pow(var13, var0);
            int var25 = (int)(var9 * 256.0D);
            int var16 = (int)(var11 * 256.0D);
            int var26 = (int)(var13 * 256.0D);
            int var18 = var26 + (var16 << 8) + (var25 << 16);
            class441.field3833[var2] = var18 & 16777215;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(II)Lec;",
      garbageValue = "-500821406"
   )
   static class127 method705(int var0) {
      class127 var1 = (class127)StructComposition.findEnumerated(class121.method721(), var0);
      if (var1 == null) {
         var1 = class127.field1252;
      }

      return var1;
   }
}
