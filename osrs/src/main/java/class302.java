import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class302 {
    @ObfuscatedName("l")
    static int Interpreter_intStackSize;
   @ObfuscatedName("f")
   public int field2794;
   @ObfuscatedName("w")
   public int field2797;
   @ObfuscatedName("v")
   public int field2795;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(CB)C",
      garbageValue = "51"
   )
   static char method1628(char var0) {
      return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
   }
}
