import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("MenuAction")
public class MenuAction {
    @ObfuscatedName("hu")
    @ObfuscatedSignature(
            descriptor = "Lnv;"
    )
    static Font fontPlain12;
    @ObfuscatedName("f")
    int param0;
    @ObfuscatedName("w")
    int param1;
    @ObfuscatedName("v")
    int opcode;
    @ObfuscatedName("s")
    int identifier;
    @ObfuscatedName("z")
    int itemId;
    @ObfuscatedName("j")
    String action;
    @ObfuscatedName("i")
    String target;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-1320413975"
   )
   public static final boolean method417(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(IB)I",
            garbageValue = "42"
    )
    public static int Widget_unpackTargetMask(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-358398577"
   )
   static final void method415() {
      int var0 = Players.Players_count;
      int[] var1 = Players.Players_indices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.players[var1[var2]];
         if (var3 != null) {
            PcmPlayer.updateActorSequence(var3, 1);
         }
      }

   }
}
