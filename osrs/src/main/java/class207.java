import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class207 extends Node {
   @ObfuscatedName("sx")
   @ObfuscatedSignature(
      descriptor = "Ltg;"
   )
   @Export("privateChatMode")
   static PrivateChatMode privateChatMode;
   @ObfuscatedName("ac")
   public int field1807;
   @ObfuscatedName("ab")
   public int field1808;
   @ObfuscatedName("an")
   public int field1810;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   public Widget field1809;

   @ObfuscatedSignature(
      descriptor = "(IIILmy;)V"
   )
   public class207(int var1, int var2, int var3, Widget var4) {
      this.field1810 = var1;
      this.field1807 = var2;
      this.field1808 = var3;
      this.field1809 = var4;
   }

   @ObfuscatedName("aj")
   public static String method1083(long var0) {
      if (var0 > 0L && var0 < 6582952005840035281L) {
         if (0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5 = new StringBuilder(var2);

            while(var0 != 0L) {
               long var6 = var0;
               var0 /= 37L;
               var5.append(class369.base37Table[(int)(var6 - var0 * 37L)]);
            }

            return var5.reverse().toString();
         }
      } else {
         return null;
      }
   }
}
