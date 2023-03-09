import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rr")
class class461 implements Iterator {
   @ObfuscatedName("aj")
   int field3938;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lrw;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class462 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lrw;)V"
   )
   class461(class462 var1) {
      this.this$0 = var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.field3938 < this.this$0.method2212();
   }

   @Export("remove")
   @ObfuscatedName("remove")
   public void remove() {
      throw new UnsupportedOperationException();
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      int var1 = ++this.field3938 - 1;
      class427 var2 = (class427)this.this$0.field3940.get((long)var1);
      return var2 != null ? var2 : this.this$0.method2350(var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1830456034"
   )
   public static int method2347(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if (var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if (var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
