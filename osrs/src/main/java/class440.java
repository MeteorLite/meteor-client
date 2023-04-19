import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("qm")
public class class440 {
   @ObfuscatedName("ax")
   static final int[] field3831 = new int[2048];
   @ObfuscatedName("ai")
   static final int[] field3832 = new int[2048];

   static {
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field3831[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field3832[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
      }

   }
}
