import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public abstract class class178 {
   @ObfuscatedName("iv")
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("ab")
   String field1448;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class167 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgs;Ljava/lang/String;)V"
   )
   class178(class167 var1, String var2) {
      this.this$0 = var1;
      this.field1448 = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "30"
   )
   @Export("vmethod3379")
   public abstract int vmethod3379();

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "217789139"
   )
   @Export("vmethod3380")
   public String vmethod3380() {
      return null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1836009680"
   )
   @Export("vmethod3378")
   public int vmethod3378() {
      return -1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-52"
   )
   public String method914() {
      return this.field1448;
   }
}
