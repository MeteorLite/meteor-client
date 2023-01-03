import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nt")
class class383 implements Comparator {
   @ObfuscatedName("lv")
   @Export("Client_plane")
   static int Client_plane;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class384 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lni;)V"
   )
   class383(class384 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lnz;Lnz;B)I",
      garbageValue = "0"
   )
   int method2010(class385 var1, class385 var2) {
      if (var1.field3667 > var2.field3667) {
         return 1;
      } else {
         return var1.field3667 < var2.field3667 ? -1 : 0;
      }
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method2010((class385)var1, (class385)var2);
   }
}
