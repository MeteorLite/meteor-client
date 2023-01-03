import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oz")
public class class412 {
   @ObfuscatedName("h")
   float[] field3778;
   @ObfuscatedName("e")
   int field3779;

   class412(float[] var1, int var2) {
      this.field3778 = var1;
      this.field3779 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-541800699"
   )
   public static int method2151(CharSequence var0) {
      return class318.method1770(var0, 10, true);
   }

   @ObfuscatedName("nl")
   @ObfuscatedSignature(
      descriptor = "(II)Lqf;",
      garbageValue = "-565161685"
   )
   static class460 method2150(int var0) {
      class460 var1 = (class460)Client.Widget_cachedFonts.get((long)var0);
      if (var1 == null) {
         var1 = new class460(Ignored.field3698, var0);
      }

      return var1;
   }
}
