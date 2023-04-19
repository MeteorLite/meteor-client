import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ng")
public class class349 {
   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "709882847"
   )
   static final void method1918() {
      if (Client.logoutTimer > 0) {
         class31.logOut();
      } else {
         Client.timer.method2101();
         class138.updateGameState(40);
         class333.field3090 = Client.packetWriter.getSocket();
         Client.packetWriter.removeSocket();
      }
   }
}
