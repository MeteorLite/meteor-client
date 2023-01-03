import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public abstract class class173 {
   @ObfuscatedName("r")
   @Export("gameCyclesToDo")
   static int gameCyclesToDo;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   @Export("clientLanguage")
   static Language clientLanguage;
   @ObfuscatedName("x")
   String field1456;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfk;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class163 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfk;Ljava/lang/String;)V"
   )
   class173(class163 var1, String var2) {
      this.this$0 = var1;
      this.field1456 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "16"
   )
   @Export("vmethod3379")
   public abstract int vmethod3379();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "380048809"
   )
   @Export("vmethod3380")
   public String vmethod3380() {
      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-736426895"
   )
   @Export("vmethod3378")
   public int vmethod3378() {
      return -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1768788528"
   )
   public String method893() {
      return this.field1456;
   }
}
