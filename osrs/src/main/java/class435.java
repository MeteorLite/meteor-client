import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public class class435 {
   @ObfuscatedName("an")
   static final int[] field3776 = new int[16384];
   @ObfuscatedName("ao")
   static final int[] field3777 = new int[16384];

   static {
      double var0 = 3.834951969714103E-4D;

      for(int var2 = 0; var2 < 16384; ++var2) {
         field3776[var2] = (int)(16384.0D * Math.sin(var0 * (double)var2));
         field3777[var2] = (int)(16384.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2131868008"
   )
   static void method2232() {
      WorldMapRegion.WorldMapRegion_cachedSprites.clear();
   }
}
