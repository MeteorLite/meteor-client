import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nb")
public class class386 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lnb;"
   )
   static final class386 field3661 = new class386("Basic");
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lnb;"
   )
   static final class386 field3660 = new class386("Bearer");
   @ObfuscatedName("v")
   final String field3659;

   class386(String var1) {
      this.field3659 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1783609031"
   )
   String method2031() {
      return this.field3659;
   }
}
