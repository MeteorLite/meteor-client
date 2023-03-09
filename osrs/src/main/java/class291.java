import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
public class class291 {
   @ObfuscatedName("aj")
   static int[] field2661;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lbp;"
   )
   @Export("soundSystem")
   static SoundSystem soundSystem;

   static {
      new Object();
      field2661 = new int[33];
      field2661[0] = 0;
      int var0 = 2;

      for(int var1 = 1; var1 < 33; ++var1) {
         field2661[var1] = var0 - 1;
         var0 += var0;
      }

   }
}
