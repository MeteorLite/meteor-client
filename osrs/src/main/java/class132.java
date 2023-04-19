import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
class class132 implements Callable {
   @ObfuscatedName("wc")
   @ObfuscatedSignature(
      descriptor = "Lnf;"
   )
   public static class354 field1277;
   @ObfuscatedName("fx")
   static long field1276;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lfh;"
   )
   @ObfuscatedName("this$0")
   final class133 this$0;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lsg;"
   )
   @ObfuscatedName("val$p")
   final Buffer val$p;
   // $FF: synthetic field
   @ObfuscatedName("val$version")
   final int val$version;

   @ObfuscatedSignature(
      descriptor = "(Lfh;Lsg;I)V"
   )
   class132(class133 var1, Buffer var2, int var3) {
      this.this$0 = var1;
      this.val$p = var2;
      this.val$version = var3;
   }

    @ObfuscatedName("call")
    public Object call() {
      this.this$0.method769(this.val$p, this.val$version);
      return null;
   }
}
