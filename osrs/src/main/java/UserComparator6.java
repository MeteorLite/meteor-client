import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class UserComparator6 extends AbstractUserComparator {
   @ObfuscatedName("vz")
   @ObfuscatedGetter(
      intValue = -421019103
   )
   static int foundItemIndex;
   @ObfuscatedName("h")
   final boolean reversed;

   public UserComparator6(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Loa;Loa;I)I",
      garbageValue = "1341322906"
   )
   int compareBuddy(Buddy var1, Buddy var2) {
      if (var1.world != 0 && var2.world != 0) {
         return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
      } else {
         return this.compareUser(var1, var2);
      }
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Lbz;I)V",
      garbageValue = "-1996213238"
   )
   static void changeWorld(World var0) {
      if (var0.isMembersOnly() != Client.isMembersWorld) {
         Client.isMembersWorld = var0.isMembersOnly();
         class344.method6675(var0.isMembersOnly());
      }

      if (var0.properties != Client.worldProperties) {
         Archive var1 = ClientPreferences.archive8;
         int var2 = var0.properties;
         if ((var2 & 536870912) != 0) {
            Login.logoSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
         } else if ((var2 & 1073741824) != 0) {
            Login.logoSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(var1, "logo_seasonal_mode", "");
         } else if ((var2 & 256) != 0) {
            Login.logoSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(var1, "logo_speedrunning", "");
         } else {
            Login.logoSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
         }
      }

      class139.worldHost = var0.host;
      Client.worldId = var0.id;
      Client.worldProperties = var0.properties;
      ClanChannel.worldPort = Client.gameBuild == 0 ? 'ꩊ' : var0.id + '鱀';
      class137.js5Port = Client.gameBuild == 0 ? 443 : var0.id + '썐';
      class31.currentPort = ClanChannel.worldPort;
   }
}
