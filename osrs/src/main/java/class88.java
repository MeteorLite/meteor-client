import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public enum class88 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field879(0, -1),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field873(1, 2),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field874(2, 3),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field876(3, 4),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field877(4, 5),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Ldv;"
   )
   field878(5, 6);

   @ObfuscatedName("av")
   final int field875;
   @ObfuscatedName("aq")
   final int field880;

   class88(int var3, int var4) {
      this.field875 = var3;
      this.field880 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field880;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lqo;FFFI)F",
      garbageValue = "-1526430028"
   )
   static float method478(class423 var0, float var1, float var2, float var3) {
      float var4 = class102.method598(var0.field3760, var0.field3761, var1);
      if (Math.abs(var4) < class123.field1167) {
         return var1;
      } else {
         float var5 = class102.method598(var0.field3760, var0.field3761, var2);
         if (Math.abs(var5) < class123.field1167) {
            return var2;
         } else {
            float var6 = 0.0F;
            float var7 = 0.0F;
            float var8 = 0.0F;
            float var13 = 0.0F;
            boolean var14 = true;
            boolean var15 = false;

            do {
               var15 = false;
               if (var14) {
                  var6 = var1;
                  var13 = var4;
                  var7 = var2 - var1;
                  var8 = var7;
                  var14 = false;
               }

               if (Math.abs(var13) < Math.abs(var5)) {
                  var1 = var2;
                  var2 = var6;
                  var6 = var1;
                  var4 = var5;
                  var5 = var13;
                  var13 = var4;
               }

               float var16 = class123.field1166 * Math.abs(var2) + var3 * 0.5F;
               float var17 = (var6 - var2) * 0.5F;
               boolean var18 = Math.abs(var17) > var16 && 0.0F != var5;
               if (var18) {
                  if (Math.abs(var8) >= var16 && Math.abs(var4) > Math.abs(var5)) {
                     float var12 = var5 / var4;
                     float var9;
                     float var10;
                     if (var1 == var6) {
                        var9 = var17 * 2.0F * var12;
                        var10 = 1.0F - var12;
                     } else {
                        var10 = var4 / var13;
                        float var11 = var5 / var13;
                        var9 = (var17 * 2.0F * var10 * (var10 - var11) - (var2 - var1) * (var11 - 1.0F)) * var12;
                        var10 = (var10 - 1.0F) * (var11 - 1.0F) * (var12 - 1.0F);
                     }

                     if ((double)var9 > 0.0D) {
                        var10 = -var10;
                     } else {
                        var9 = -var9;
                     }

                     var12 = var8;
                     var8 = var7;
                     if (var9 * 2.0F < var10 * var17 * 3.0F - Math.abs(var16 * var10) && var9 < Math.abs(var10 * var12 * 0.5F)) {
                        var7 = var9 / var10;
                     } else {
                        var7 = var17;
                        var8 = var17;
                     }
                  } else {
                     var7 = var17;
                     var8 = var17;
                  }

                  var1 = var2;
                  var4 = var5;
                  if (Math.abs(var7) > var16) {
                     var2 += var7;
                  } else if ((double)var17 > 0.0D) {
                     var2 += var16;
                  } else {
                     var2 -= var16;
                  }

                  var5 = class102.method598(var0.field3760, var0.field3761, var2);
                  if ((double)(var5 * (var13 / Math.abs(var13))) > 0.0D) {
                     var14 = true;
                     var15 = true;
                  } else {
                     var15 = true;
                  }
               }
            } while(var15);

            return var2;
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1282503334"
   )
   public static String method476(String var0) {
      return var0 != null && !var0.isEmpty() && var0.charAt(0) != '#' ? var0 : "";
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1078907147"
   )
   static void method477() {
      Login.worldSelectOpen = false;
      Login.leftTitleSprite.drawAt(Login.xPadding, 0);
      class419.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
      Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
   }
}
