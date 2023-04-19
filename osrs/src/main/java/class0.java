import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class0 implements class3 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;)Lsg;"
    )
    public Buffer vmethod12(Buffer var1) {
      Buffer var2 = new Buffer(100);
      this.method1(var1, var2);
      return var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsg;Lsg;)V"
   )
   void method1(Buffer var1, Buffer var2) {
      class8 var3 = new class8(var1);
      class5 var4 = new class5(var3);

      long var5;
      for(var5 = 0L; !var4.method16(var3.method28(), var3.method29(), var5); ++var5) {
         ;
      }

      var2.writeLong(var5);
   }
}
