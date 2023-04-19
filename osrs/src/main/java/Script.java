import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Script")
public class Script extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable Script_cached = new EvictingDualNodeHashTable(128);
    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "Lno;"
    )
    public static NetFileRequest NetCache_currentResponse;
   @ObfuscatedName("an")
   String field794;
    @ObfuscatedName("aw")
    int[] opcodes;
    @ObfuscatedName("ac")
    int[] intOperands;
    @ObfuscatedName("au")
    String[] stringOperands;
    @ObfuscatedName("ab")
    int localIntCount;
    @ObfuscatedName("aq")
    int localStringCount;
    @ObfuscatedName("al")
    int intArgumentCount;
    @ObfuscatedName("at")
    int stringArgumentCount;
    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "[Lro;"
    )
    IterableNodeHashTable[] switches;

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(II)[Lro;",
            garbageValue = "-1544314186"
    )
    IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
      return new IterableNodeHashTable[var1];
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-2065195027"
   )
   public static int method460(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if ((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if (var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }
}
