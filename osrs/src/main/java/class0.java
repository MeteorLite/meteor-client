import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class0 implements class3 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;)Lqy;"
   )
   @Export("vmethod12")
   public Buffer vmethod12(Buffer var1) {
      Buffer var2 = new Buffer(100);
      this.method1(var1, var2);
      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;Lqy;)V"
   )
   void method1(Buffer var1, Buffer var2) {
      class8 var3 = new class8(var1);
      class5 var4 = new class5(var3);

      long var5;
      for(var5 = 0L; !var4.method8(var3.method24(), var3.method23(), var5); ++var5) {
         ;
      }

      var2.writeLong(var5);
   }
}
