import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lt")
public class class328 {
   static {
      int var0 = 0;
      int var1 = 0;
      class323[] var2 = FontName.method2295();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class323 var4 = var2[var3];
         if (var4.field3060 > var0) {
            var0 = var4.field3060;
         }

         if (var4.field3058 > var1) {
            var1 = var4.field3058;
         }
      }

   }
}
