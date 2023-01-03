import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("px")
public class class424 {
   @ObfuscatedName("m")
   static final int[] field3800 = new int[16384];
   @ObfuscatedName("q")
   static final int[] field3801 = new int[16384];

   static {
      double var0 = 3.834951969714103E-4D;

      for(int var2 = 0; var2 < 16384; ++var2) {
         field3800[var2] = (int)(16384.0D * Math.sin(var0 * (double)var2));
         field3801[var2] = (int)(16384.0D * Math.cos((double)var2 * var0));
      }

   }
}
