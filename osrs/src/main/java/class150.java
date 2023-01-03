import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class150 extends class136 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static IndexedSprite field1367;
   @ObfuscatedName("h")
   int field1366;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class150(class139 var1) {
      this.this$0 = var1;
      this.field1366 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1366 = var1.readUnsignedShort();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method795(this.field1366);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "48"
   )
   public static boolean method809(int var0) {
      return var0 == WorldMapDecorationType.field3055.id;
   }
}
