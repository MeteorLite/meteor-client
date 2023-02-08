import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("PlayerType")
public enum PlayerType implements class349 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_normal(0, -1, true, false, true),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_playerModerator(1, 0, true, true, true),
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_jagexModerator(2, 1, true, true, false),
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_ironman(3, 2, false, false, true),
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_ultimateIronman(4, 3, false, false, true),
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Llu;"
    )
    PlayerType_hardcoreIronman(5, 10, false, false, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3409(6, 22, false, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3415(7, 41, false, false, true),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3416(8, 42, false, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3417(9, 43, false, false, true),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3418(10, 44, false, false, true),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3430(11, 45, false, false, true),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3420(12, 46, false, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3414(13, 47, false, false, true),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3422(14, 48, false, false, true),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3419(15, 49, false, false, true),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Llu;"
   )
   field3424(16, 52, false, false, true);

    @ObfuscatedName("jj")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] modIconSprites;
    @ObfuscatedName("ng")
    static int menuHeight;
    @ObfuscatedName("o")
    final int id;
    @ObfuscatedName("u")
    public final int modIcon;
    @ObfuscatedName("x")
    public final boolean isPrivileged;
    @ObfuscatedName("a")
    public final boolean isUser;

   PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.id = var3;
      this.modIcon = var4;
      this.isPrivileged = var6;
      this.isUser = var7;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }
}
