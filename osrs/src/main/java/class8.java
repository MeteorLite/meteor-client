import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class8 {
   @ObfuscatedName("aj")
   final int field17;
   @ObfuscatedName("al")
   final int field16;
   @ObfuscatedName("ac")
   final String field18;

   @ObfuscatedSignature(
      descriptor = "(Lsy;)V"
   )
   class8(Buffer var1) {
      this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
   }

   class8(int var1, int var2, String var3) {
      this.field17 = var1;
      this.field16 = var2;
      this.field18 = var3;
   }

   @ObfuscatedName("aj")
   String method23() {
      return Integer.toHexString(this.field17) + Integer.toHexString(this.field16) + this.field18;
   }

   @ObfuscatedName("al")
   int method24() {
      return this.field16;
   }
}
