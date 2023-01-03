import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class162 extends class173 {
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   @Export("archive6")
   static Archive archive6;
   @ObfuscatedName("h")
   String field1405;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfk;"
   )
   final class163 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfk;Ljava/lang/String;Ljava/lang/String;)V"
   )
   class162(class163 var1, String var2, String var3) {
      super(var1, var2);
      this.this$0 = var1;
      this.field1405 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "16"
   )
   @Export("vmethod3379")
   public int vmethod3379() {
      return 1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "380048809"
   )
   @Export("vmethod3380")
   public String vmethod3380() {
      return this.field1405;
   }
}
