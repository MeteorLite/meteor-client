import java.util.Comparator;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pp")
class class395 implements Comparator {
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lpc;"
   )
   @ObfuscatedName("this$0")
   final class394 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lpc;)V"
   )
   class395(class394 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;I)I",
      garbageValue = "226740004"
   )
   int method2118(Entry var1, Entry var2) {
      return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.method2118((Entry)var1, (Entry)var2);
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
