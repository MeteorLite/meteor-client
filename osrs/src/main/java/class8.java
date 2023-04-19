import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class8 {
   @ObfuscatedName("af")
   final int field18;
   @ObfuscatedName("an")
   final int field17;
   @ObfuscatedName("aw")
   final String field19;

   @ObfuscatedSignature(
      descriptor = "(Lsg;)V"
   )
   class8(Buffer var1) {
      this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated());
   }

   class8(int var1, int var2, String var3) {
      this.field18 = var1;
      this.field17 = var2;
      this.field19 = var3;
   }

   @ObfuscatedName("af")
   String method29() {
      return Integer.toHexString(this.field18) + Integer.toHexString(this.field17) + this.field19;
   }

   @ObfuscatedName("an")
   int method28() {
      return this.field17;
   }
}
