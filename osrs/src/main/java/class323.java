import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
public class class323 {
   @ObfuscatedName("wd")
   static long field3037;

    @ObfuscatedName("hz")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-411015869"
    )
    static final void playPcmPlayers() {
      if (HorizontalAlignment.pcmPlayer1 != null) {
         HorizontalAlignment.pcmPlayer1.run();
      }

      if (class28.pcmPlayer0 != null) {
         class28.pcmPlayer0.run();
      }

   }
}
