import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pm")
public class class393 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lpm;"
   )
   static final class393 field3681 = new class393("Basic");
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lpm;"
   )
   static final class393 field3680 = new class393("Bearer");
   @ObfuscatedName("aw")
   final String field3682;

   class393(String var1) {
      this.field3682 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "43"
   )
   String method2102() {
      return this.field3682;
   }

    @ObfuscatedName("ny")
    @ObfuscatedSignature(
            descriptor = "(Lmq;B)Z",
            garbageValue = "1"
    )
    static boolean isComponentHidden(Widget var0) {
      return var0.isHidden;
   }
}
