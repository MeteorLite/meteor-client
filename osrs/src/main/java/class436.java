import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("qz")
public class class436 {
   @ObfuscatedName("as")
   static final int[] field3778 = new int[2048];
   @ObfuscatedName("ay")
   static final int[] field3779 = new int[2048];

   static {
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field3778[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         field3779[var2] = (int)(65536.0D * Math.cos((double)var2 * var0));
      }

   }
}
