import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
final class class101 implements class297 {
   @ObfuscatedName("tt")
   static int field1083;
   @ObfuscatedName("ng")
   static int selectedItemSlot;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @ObfuscatedName("val$cc")
   final Widget val$cc;

   @ObfuscatedSignature(
      descriptor = "(Lkd;)V"
   )
   class101(Widget var1) {
      this.val$cc = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1798262930"
   )
   public void vmethod5708() {
      if (this.val$cc != null && this.val$cc.method1735().field2812 != null) {
         ScriptEvent var1 = new ScriptEvent();
         var1.method475(this.val$cc);
         var1.setArgs(this.val$cc.method1735().field2812);
         AABB.getScriptEvents().addFirst(var1);
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1255396169"
   )
   static void setWindowedMode(int var0) {
      Client.field584 = 0L;
      if (var0 >= 2) {
         Client.isResizable = true;
      } else {
         Client.isResizable = false;
      }

      if (Message.getWindowedMode() == 1) {
         BuddyRankComparator.client.setMaxCanvasSize(765, 503);
      } else {
         BuddyRankComparator.client.setMaxCanvasSize(7680, 2160);
      }

      if (Client.gameState >= 25) {
         GameEngine.method179();
      }

   }
}
