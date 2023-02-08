import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class8 {
   @ObfuscatedName("f")
   final int field17;
   @ObfuscatedName("w")
   final int field16;
   @ObfuscatedName("v")
   final String field18;

   @ObfuscatedSignature(
      descriptor = "(Lrd;)V"
   )
   class8(Buffer var1) {
      this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
   }

   class8(int var1, int var2, String var3) {
      this.field17 = var1;
      this.field16 = var2;
      this.field18 = var3;
   }

   @ObfuscatedName("f")
   String method29() {
      return Integer.toHexString(this.field17) + Integer.toHexString(this.field16) + this.field18;
   }

   @ObfuscatedName("w")
   int method30() {
      return this.field16;
   }
}
