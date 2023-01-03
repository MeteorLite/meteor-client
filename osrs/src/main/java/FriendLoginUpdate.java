import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class FriendLoginUpdate extends Link {
   @ObfuscatedName("h")
   public int field3684 = (int)(Message.clockNow() / 1000L);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   public Username friendUsername;
   @ObfuscatedName("v")
   public short worldId;

   @ObfuscatedSignature(
      descriptor = "(Lrp;I)V"
   )
   FriendLoginUpdate(Username var1, int var2) {
      this.friendUsername = var1;
      this.worldId = (short)var2;
   }
}
