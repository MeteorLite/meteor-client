import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 extends class136 {
   @ObfuscatedName("tg")
   static int cameraMoveToX;
   @ObfuscatedName("dh")
   static boolean field1785;
   @ObfuscatedName("fq")
   static int field1788;
   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      descriptor = "Lcj;"
   )
   static Player localPlayer;
   @ObfuscatedName("h")
   int field1786;
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
      this.field1786 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1786 = var1.readUnsignedShort();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method3176(this.field1786);
   }
}
