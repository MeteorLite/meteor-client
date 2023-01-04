import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
final class class102 implements class297 {
   @ObfuscatedName("tk")
   static int field1084;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @ObfuscatedName("val$cc")
   final Widget val$cc;

   @ObfuscatedSignature(
      descriptor = "(Lkd;)V"
   )
   class102(Widget var1) {
      this.val$cc = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1798262930"
   )
   public void vmethod5708() {
      if (this.val$cc != null && this.val$cc.method1735().field2813 != null) {
         ScriptEvent var1 = new ScriptEvent();
         var1.method475(this.val$cc);
         var1.setArgs(this.val$cc.method1735().field2813);
         AABB.getScriptEvents().addFirst(var1);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ldu;FB)F",
      garbageValue = "89"
   )
   static float method610(class125 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2 = var1 - var0.field1207;
         return (var0.field1201 + var2 * (var0.field1209 * var2 + var0.field1223)) * var2 + var0.field1212;
      }
   }
}
