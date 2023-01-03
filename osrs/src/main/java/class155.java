import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 extends class136 {
   @ObfuscatedName("tg")
   static int cameraMoveToX;
   @ObfuscatedName("dh")
   static boolean field1380;
   @ObfuscatedName("fq")
   static int field1383;
   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      descriptor = "Lcj;"
   )
   static Player localPlayer;
   @ObfuscatedName("h")
   int field1381;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class155(class139 var1) {
      this.this$0 = var1;
      this.field1381 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1381 = var1.readUnsignedShort();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method787(this.field1381);
   }
}
