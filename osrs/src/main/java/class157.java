import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class157 extends class139 {
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "Las;"
    )
    public static class50 pcmPlayerProvider;
    @ObfuscatedName("ll")
    @ObfuscatedSignature(
            descriptor = "Lkz;"
    )
    static Widget hoveredItemContainer;
   @ObfuscatedName("f")
   int field1387;
   @ObfuscatedName("w")
   int field1385;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class157(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1387 = var1.readInt();
      this.field1385 = var1.readInt();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method795(this.field1387, this.field1385);
   }
}
