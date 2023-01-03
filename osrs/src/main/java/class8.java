import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class8 {
   @ObfuscatedName("h")
   final int field14;
   @ObfuscatedName("e")
   final int field13;
   @ObfuscatedName("v")
   final String field15;

   @ObfuscatedSignature(
      descriptor = "(Lqy;)V"
   )
   class8(Buffer var1) {
      this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
   }

   class8(int var1, int var2, String var3) {
      this.field14 = var1;
      this.field13 = var2;
      this.field15 = var3;
   }

   @ObfuscatedName("h")
   String method23() {
      return Integer.toHexString(this.field14) + Integer.toHexString(this.field13) + this.field15;
   }

   @ObfuscatedName("e")
   int method24() {
      return this.field13;
   }
}
