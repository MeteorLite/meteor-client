import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("me")
@Implements("Strings")
public class Strings {
   @ObfuscatedName("fs")
   public static String field3133 = "Please visit the support page for assistance.";
   @ObfuscatedName("lm")
   public static String field3103 = "";
   @ObfuscatedName("lb")
   public static String field3332 = "Page has opened in the browser.";
   @ObfuscatedName("ld")
   public static String field3333 = "";

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1715180489"
   )
   protected static final void method1804() {
      GameEngine.clock.mark();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.graphicsTickTimes[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.clientTickTimes[var0] = 0L;
      }

      GameEngine.gameCyclesToDo = 0;
   }
}
