import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class136 extends class139 {
   @ObfuscatedName("vr")
   @ObfuscatedSignature(
      descriptor = "Lmu;"
   )
   public static class347 field1293;
   @ObfuscatedName("f")
   int field1295;
   @ObfuscatedName("w")
   int field1292;
   @ObfuscatedName("v")
   int field1291;
   @ObfuscatedName("s")
   int field1294;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class136(class142 var1) {
      this.this$0 = var1;
      this.field1295 = -1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1295 = var1.readUnsignedShort();
      this.field1292 = var1.readInt();
      this.field1291 = var1.readUnsignedByte();
      this.field1294 = var1.readUnsignedByte();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method802(this.field1295, this.field1292, this.field1291, this.field1294);
   }
}
