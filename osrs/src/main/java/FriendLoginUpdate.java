import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pz")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
   @ObfuscatedName("aj")
   public int field3667 = (int)(WorldMapSection2.clockNow() / 1000L);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ltj;"
   )
   @Export("friendUsername")
   public Username friendUsername;
   @ObfuscatedName("ac")
   @Export("worldId")
   public short worldId;

   @ObfuscatedSignature(
      descriptor = "(Ltj;I)V"
   )
   FriendLoginUpdate(Username var1, int var2) {
      this.friendUsername = var1;
      this.worldId = (short)var2;
   }
}
