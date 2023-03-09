import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pm")
public class class392 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lpm;"
   )
   public static final class392 field3638 = new class392(1);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lpm;"
   )
   static final class392 field3640 = new class392(0);
   @ObfuscatedName("bj")
   @Export("client")
   @ObfuscatedSignature(
      descriptor = "Lclient;"
   )
   public static Client client;
   @ObfuscatedName("ac")
   final int field3639;

   class392(int var1) {
      this.field3639 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/security/SecureRandom;",
      garbageValue = "1245058623"
   )
   static SecureRandom method2063() {
      SecureRandom var0 = new SecureRandom();
      var0.nextInt();
      return var0;
   }
}
