import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class Script extends DualNode {
   @ObfuscatedName("tp")
   @ObfuscatedGetter(
      intValue = 621523353
   )
   static int cameraMoveToHeight;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   static EvictingDualNodeHashTable Script_cached = new EvictingDualNodeHashTable(128);
   @ObfuscatedName("e")
   String field990;
   @ObfuscatedName("v")
   int[] opcodes;
   @ObfuscatedName("x")
   int[] intOperands;
   @ObfuscatedName("m")
   String[] stringOperands;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1144522069
   )
   int localIntCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 506367355
   )
   int localStringCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1904250989
   )
   int intArgumentCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 705152755
   )
   int stringArgumentCount;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "[Lql;"
   )
   IterableNodeHashTable[] switches;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)[Lql;",
      garbageValue = "-1776194631"
   )
   IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
      return new IterableNodeHashTable[var1];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)Lbv;",
      garbageValue = "-1509182401"
   )
   static Message Messages_getMessage(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-85"
   )
   static void clearItemContainer(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.ids.length; ++var2) {
            var1.ids[var2] = -1;
            var1.quantities[var2] = 0;
         }

      }
   }
}
