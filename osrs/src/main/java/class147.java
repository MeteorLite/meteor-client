import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class147 extends class140 {
   @ObfuscatedName("aj")
   boolean field1326;
   @ObfuscatedName("al")
   byte field1322;
   @ObfuscatedName("ac")
   byte field1325;
   @ObfuscatedName("ab")
   byte field1323;
   @ObfuscatedName("an")
   byte field1324;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class147(class143 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1326 = var1.readUnsignedByte() == 1;
      this.field1322 = var1.readByte();
      this.field1325 = var1.readByte();
      this.field1323 = var1.readByte();
      this.field1324 = var1.readByte();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.allowGuests = this.field1326;
      var1.field1342 = this.field1322;
      var1.field1346 = this.field1325;
      var1.field1343 = this.field1323;
      var1.field1344 = this.field1324;
   }
}
