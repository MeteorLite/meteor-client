import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Script")
public class Script extends DualNode {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable Script_cached = new EvictingDualNodeHashTable(128);
    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static AbstractArchive Widget_fontsArchive;
   @ObfuscatedName("w")
   String field807;
    @ObfuscatedName("v")
    int[] opcodes;
    @ObfuscatedName("s")
    int[] intOperands;
    @ObfuscatedName("z")
    String[] stringOperands;
    @ObfuscatedName("j")
    int localIntCount;
    @ObfuscatedName("i")
    int localStringCount;
    @ObfuscatedName("n")
    int intArgumentCount;
    @ObfuscatedName("l")
    int stringArgumentCount;
    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "[Lqu;"
    )
    IterableNodeHashTable[] switches;

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(II)[Lqu;",
            garbageValue = "1227371114"
    )
    IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
      return new IterableNodeHashTable[var1];
   }
}
