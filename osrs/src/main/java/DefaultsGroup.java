import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pp")
@Implements("DefaultsGroup")
public class DefaultsGroup {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lpp;"
   )
   static final DefaultsGroup field3713 = new DefaultsGroup(3);
   @ObfuscatedName("al")
   @Export("group")
   final int group;

   DefaultsGroup(int var1) {
      this.group = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "141700645"
   )
   static void method2166() {
      Players.Players_count = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         Players.cachedAppearanceBuffer[var0] = null;
         Players.playerMovementSpeeds[var0] = MoveSpeed.WALK;
      }

   }
}
