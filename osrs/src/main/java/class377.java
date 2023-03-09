import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("od")
public class class377 {
   @ObfuscatedName("aj")
   public char field3577;
   @ObfuscatedName("al")
   public int field3576 = 0;
   @ObfuscatedName("ac")
   public int field3575 = 0;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "87"
   )
   static void method1990(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var1 != null) {
         var1.remove();
      }
   }
}
