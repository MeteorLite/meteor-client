import java.util.Comparator;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nl")
class class388 implements Comparator {
   @ObfuscatedName("s")
   public static int field3666;
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      descriptor = "Lpq;"
   )
   static class421 field3667;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lnx;"
   )
   @ObfuscatedName("this$0")
   final class387 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lnx;)V"
   )
   class388(class387 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;I)I",
      garbageValue = "-731916106"
   )
   int method2045(Entry var1, Entry var2) {
      return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      return super.equals(var1);
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.method2045((Entry)var1, (Entry)var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IS)I",
      garbageValue = "-22723"
   )
   public static int method2046(int var0) {
      return class431.field3812[var0 & 16383];
   }
}
