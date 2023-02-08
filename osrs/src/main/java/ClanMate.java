import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("og")
@Implements("ClanMate")
public class ClanMate extends Buddy {
    @ObfuscatedName("dc")
    static boolean mouseCam;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool friend;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool ignored;

   ClanMate() {
      this.friend = TriBool.TriBool_unknown;
      this.ignored = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-393311077"
    )
    void clearIsFriend() {
      this.friend = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "-25"
    )
    public final boolean isFriend() {
      if (this.friend == TriBool.TriBool_unknown) {
         this.fillIsFriend();
      }

      return this.friend == TriBool.TriBool_true;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "16"
    )
    void fillIsFriend() {
      this.friend = WorldMapElement.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "102"
    )
    void clearIsIgnored() {
      this.ignored = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1204193663"
    )
    public final boolean isIgnored() {
      if (this.ignored == TriBool.TriBool_unknown) {
         this.fillIsIgnored();
      }

      return this.ignored == TriBool.TriBool_true;
   }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-67"
    )
    void fillIsIgnored() {
      this.ignored = WorldMapElement.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }
}
