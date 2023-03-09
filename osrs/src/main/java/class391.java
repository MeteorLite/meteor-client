import java.util.Comparator;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pi")
class class391 implements Comparator {
   @ObfuscatedName("aq")
   static int field3637;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lpu;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class390 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lpu;)V"
   )
   class391(class390 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;B)I",
      garbageValue = "71"
   )
   int method2062(Entry var1, Entry var2) {
      return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method2062((Entry)var1, (Entry)var2);
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
