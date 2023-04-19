import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
public class class284 {
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-871294200"
   )
   static void method1595(int var0) {
      if (var0 != Client.loginState) {
         Client.loginState = var0;
      }
   }
}
