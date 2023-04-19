import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
public class class295 {
   @ObfuscatedName("af")
   static int[] field2716;

   static {
      new Object();
      field2716 = new int[33];
      field2716[0] = 0;
      int var0 = 2;

      for(int var1 = 1; var1 < 33; ++var1) {
         field2716[var1] = var0 - 1;
         var0 += var0;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   public static void method1608() {
      if (NetCache.NetCache_socket != null) {
         NetCache.NetCache_socket.close();
      }

   }
}
