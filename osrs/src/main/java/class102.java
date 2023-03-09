import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
final class class102 implements class304 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   @Export("HitSplatDefinition_archive")
   public static AbstractArchive HitSplatDefinition_archive;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("val$cc")
   @ObfuscatedName("val$cc")
   final Widget val$cc;

   @ObfuscatedSignature(
      descriptor = "(Lmy;)V"
   )
   class102(Widget var1) {
      this.val$cc = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "177803302"
   )
   @Export("vmethod5708")
   public void vmethod5708() {
      if (this.val$cc != null && this.val$cc.method1768().field2777 != null) {
         ScriptEvent var1 = new ScriptEvent();
         var1.method467(this.val$cc);
         var1.setArgs(this.val$cc.method1768().field2777);
         class144.getScriptEvents().addFirst(var1);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "([FIFB)F",
      garbageValue = "0"
   )
   static float method598(float[] var0, int var1, float var2) {
      float var3 = var0[var1];

      for(int var4 = var1 - 1; var4 >= 0; --var4) {
         var3 = var0[var4] + var3 * var2;
      }

      return var3;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "62"
   )
   static int method597(int var0) {
      return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
   }
}
