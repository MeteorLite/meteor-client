import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oj")
public class class376 {
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive18")
   static Archive archive18;
   @ObfuscatedName("aj")
   int field3574;

   @ObfuscatedSignature(
      descriptor = "(IZ)V",
      garbageValue = "1"
   )
   class376(int var1, boolean var2) {
      this.field3574 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1782146409"
   )
   public int method1989() {
      return this.field3574;
   }
}
