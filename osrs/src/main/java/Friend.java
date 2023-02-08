import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ol")
@Implements("Friend")
public class Friend extends Buddy {
   @ObfuscatedName("f")
   boolean field3698;
   @ObfuscatedName("w")
   boolean field3697;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lol;I)I",
            garbageValue = "-1263388841"
    )
    int compareToFriend(Friend var1) {
      if (super.world == Client.worldId && Client.worldId != var1.world) {
         return -1;
      } else if (Client.worldId == var1.world && super.world != Client.worldId) {
         return 1;
      } else if (super.world != 0 && var1.world == 0) {
         return -1;
      } else if (var1.world != 0 && super.world == 0) {
         return 1;
      } else if (this.field3698 && !var1.field3698) {
         return -1;
      } else if (!this.field3698 && var1.field3698) {
         return 1;
      } else if (this.field3697 && !var1.field3697) {
         return -1;
      } else if (!this.field3697 && var1.field3697) {
         return 1;
      } else {
         return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Low;I)I",
            garbageValue = "1651786682"
    )
    public int compareTo_user(User var1) {
      return this.compareToFriend((Friend)var1);
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareToFriend((Friend)var1);
   }
}
