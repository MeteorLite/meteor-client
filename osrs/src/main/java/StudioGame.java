import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mr")
@Implements("StudioGame")
public enum StudioGame implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    runescape("runescape", "RuneScape", 0),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    stellardawn("stellardawn", "Stellar Dawn", 1),
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    game3("game3", "Game 3", 2),
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    game4("game4", "Game 4", 3),
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    game5("game5", "Game 5", 4),
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lmr;"
    )
    oldscape("oldscape", "RuneScape 2007", 5);

    @ObfuscatedName("aq")
    public final String name;
    @ObfuscatedName("al")
    final int id;

   StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(B)[Lnz;",
            garbageValue = "78"
    )
    public static PlayerType[] PlayerType_values() {
      return new PlayerType[]{PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal, PlayerType.field3434, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_ultimateIronman, PlayerType.field3440, PlayerType.field3430, PlayerType.field3433, PlayerType.field3439, PlayerType.field3444, PlayerType.field3432, PlayerType.field3437, PlayerType.PlayerType_playerModerator, PlayerType.field3436, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3431, PlayerType.field3428};
   }
}
