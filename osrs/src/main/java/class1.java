import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 implements Callable {
    @ObfuscatedName("ag")
    static java.awt.Font fontHelvetica13;
    @ObfuscatedName("fw")
    static int worldPort;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   final Buffer field3;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Ls;"
   )
   final class3 field0;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Ln;"
   )
   @ObfuscatedName("this$0")
   final class7 this$0;

   @ObfuscatedSignature(
      descriptor = "(Ln;Lrd;Ls;)V"
   )
   class1(class7 var1, Buffer var2, class3 var3) {
      this.this$0 = var1;
      this.field3 = var2;
      this.field0 = var3;
   }

    @ObfuscatedName("call")
    public Object call() {
      return this.field0.vmethod12(this.field3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Llm;II)V",
      garbageValue = "-2059005384"
   )
   static void method2(Archive var0, int var1) {
      class10.field38.offset = var1 * 8 + 5;
      if (class10.field38.offset >= class10.field38.array.length) {
         if (var0.field3442) {
            var0.method1796();
         } else {
            throw new RuntimeException("");
         }
      } else {
         int var2 = class10.field38.readInt();
         int var3 = class10.field38.readInt();
         var0.loadIndex(var2, var3);
      }
   }
}
