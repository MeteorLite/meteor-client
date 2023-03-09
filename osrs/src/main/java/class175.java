import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class175 extends class178 {
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   static Archive field1434;
   @ObfuscatedName("aj")
   int field1435;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   final class167 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgs;Ljava/lang/String;I)V"
   )
   class175(class167 var1, String var2, int var3) {
      super(var1, var2);
      this.this$0 = var1;
      this.field1435 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "30"
   )
   public int vmethod3379() {
      return 0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1836009680"
   )
   @Export("vmethod3378")
   public int vmethod3378() {
      return this.field1435;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-636629491"
   )
   static boolean method907(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+') {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               return false;
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }
}
