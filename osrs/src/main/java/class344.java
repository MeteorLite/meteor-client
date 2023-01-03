import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mk")
public class class344 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmk;"
   )
   static final class344 field3513 = new class344();
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lmk;"
   )
   static final class344 field3512 = new class344();
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmk;"
   )
   static final class344 field3514 = new class344();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1623169078"
   )
   public static void method1858(boolean var0) {
      if (var0 != Clock.ItemDefinition_inMembersWorld) {
         ItemComposition.ItemDefinition_cached.clear();
         ItemComposition.ItemDefinition_cachedModels.clear();
         ItemComposition.ItemDefinition_cachedSprites.clear();
         Clock.ItemDefinition_inMembersWorld = var0;
      }

   }

   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "25067"
   )
   static final void method1857() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsFriend();
      }

      KeyHandler.method99();
      if (class281.friendsChat != null) {
         class281.friendsChat.clearFriends();
      }

   }
}
