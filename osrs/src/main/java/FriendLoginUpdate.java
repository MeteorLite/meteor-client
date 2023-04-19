import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pf")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
   @ObfuscatedName("af")
   public int field3722 = (int)(class96.clockNow() / 1000L);
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Ltm;"
    )
    public Username friendUsername;
    @ObfuscatedName("aw")
    public short worldId;

   @ObfuscatedSignature(
      descriptor = "(Ltm;I)V"
   )
   FriendLoginUpdate(Username var1, int var2) {
      this.friendUsername = var1;
      this.worldId = (short)var2;
   }
}
