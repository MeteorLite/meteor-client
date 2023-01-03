import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
@Implements("PlayerType")
public enum PlayerType implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_normal(0, -1, true, false, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_playerModerator(1, 0, true, true, true),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_jagexModerator(2, 1, true, true, false),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_ironman(3, 2, false, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_ultimateIronman(4, 3, false, false, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   PlayerType_hardcoreIronman(5, 10, false, false, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3410(6, 22, false, false, true),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3417(7, 41, false, false, true),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3414(8, 42, false, false, true),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3415(9, 43, false, false, true),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3416(10, 44, false, false, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3406(11, 45, false, false, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3418(12, 46, false, false, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3419(13, 47, false, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3420(14, 48, false, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3421(15, 49, false, false, true),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "Llq;"
   )
   field3422(16, 52, false, false, true);

   @ObfuscatedName("s")
   final int id;
   @ObfuscatedName("l")
   public final int modIcon;
   @ObfuscatedName("t")
   public final boolean isPrivileged;
   @ObfuscatedName("c")
   public final boolean isUser;

   PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.id = var3;
      this.modIcon = var4;
      this.isPrivileged = var6;
      this.isUser = var7;
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
