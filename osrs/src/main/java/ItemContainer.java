import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("ItemContainer")
public class ItemContainer extends Node {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    static NodeHashTable itemContainers = new NodeHashTable(32);
    @ObfuscatedName("w")
    int[] ids = new int[]{-1};
    @ObfuscatedName("v")
    int[] quantities = new int[]{0};

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IB)Lde;",
      garbageValue = "95"
   )
   static class123 method455(int var0) {
      class123 var1 = (class123)class4.findEnumerated(UrlRequester.method628(), var0);
      if (var1 == null) {
         var1 = class123.field1193;
      }

      return var1;
   }
}
