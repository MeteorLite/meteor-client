import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class133 extends class136 {
   @ObfuscatedName("f")
   static int field1285;
   @ObfuscatedName("bg")
   static String param9;
   @ObfuscatedName("id")
   static byte[][] regionLandArchives;
   @ObfuscatedName("h")
   int field1286;
   @ObfuscatedName("e")
   int field1282;
   @ObfuscatedName("v")
   int field1283;
   @ObfuscatedName("x")
   int field1281;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class133(class139 var1) {
      this.this$0 = var1;
      this.field1286 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1286 = var1.readUnsignedShort();
      this.field1282 = var1.readInt();
      this.field1283 = var1.readUnsignedByte();
      this.field1281 = var1.readUnsignedByte();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method788(this.field1286, this.field1282, this.field1283, this.field1281);
   }
}
