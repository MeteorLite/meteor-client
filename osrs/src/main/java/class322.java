import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
public class class322 {
   static {
      Math.sqrt(8192.0D);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      descriptor = "(III)Lgt;",
      garbageValue = "-874062293"
   )
   static RouteStrategy method1782(int var0, int var1) {
      Client.field412.approxDestinationX = var0;
      Client.field412.approxDestinationY = var1;
      Client.field412.approxDestinationSizeX = 1;
      Client.field412.approxDestinationSizeY = 1;
      return Client.field412;
   }
}
