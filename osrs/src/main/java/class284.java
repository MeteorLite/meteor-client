import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("js")
public class class284 {
   @ObfuscatedName("h")
   static int[] field2697;

   static {
      new Object();
      field2697 = new int[33];
      field2697[0] = 0;
      int var0 = 2;

      for(int var1 = 1; var1 < 33; ++var1) {
         field2697[var1] = var0 - 1;
         var0 += var0;
      }

   }
}
