import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
public enum StudioGame implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   runescape("runescape", "RuneScape", 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   stellardawn("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   game3("game3", "Game 3", 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   game4("game4", "Game 4", 3),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   game5("game5", "Game 5", 4),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   oldscape("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("f")
   public final String name;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1618416039
   )
   final int id;

   StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.id;
   }
}
