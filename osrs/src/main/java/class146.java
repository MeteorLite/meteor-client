import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class146 extends class139 {
   @ObfuscatedName("f")
   boolean field1327;
   @ObfuscatedName("w")
   byte field1323;
   @ObfuscatedName("v")
   byte field1324;
   @ObfuscatedName("s")
   byte field1325;
   @ObfuscatedName("z")
   byte field1326;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class146(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1327 = var1.readUnsignedByte() == 1;
      this.field1323 = var1.readByte();
      this.field1324 = var1.readByte();
      this.field1325 = var1.readByte();
      this.field1326 = var1.readByte();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.allowGuests = this.field1327;
      var1.field1347 = this.field1323;
      var1.field1363 = this.field1324;
      var1.field1359 = this.field1325;
      var1.field1349 = this.field1326;
   }

   @ObfuscatedName("f")
   static boolean method776(long var0) {
      return class121.method672(var0) == 2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-704646988"
   )
   public static void method775() {
      class36.reflectionChecks = new IterableNodeDeque();
   }
}
