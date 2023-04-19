import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lk")
public final class class293 {
   @ObfuscatedName("af")
   static long field2711;
   @ObfuscatedName("an")
   static long field2712;

    @ObfuscatedName("hg")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "16777216"
    )
    static final void forceDisconnect(int var0) {
      class31.logOut();
      switch(var0) {
      case 1:
         class220.method1233();
         break;
      case 2:
         UrlRequest.method680();
      }

   }
}
