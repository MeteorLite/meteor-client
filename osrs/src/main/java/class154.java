import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class154 extends class139 {
   @ObfuscatedName("af")
   long field1387;
   @ObfuscatedName("an")
   String field1386;
   @ObfuscatedName("aw")
   int field1385;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class154(class142 var1) {
      this.this$0 = var1;
      this.field1387 = -1L;
      this.field1386 = null;
      this.field1385 = 0;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1387 = var1.readLong();
      }

      this.field1386 = var1.readStringCp1252NullTerminatedOrNull();
      this.field1385 = var1.readUnsignedShort();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method849(this.field1387, this.field1386, this.field1385);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lme;I)V",
      garbageValue = "-1214282669"
   )
   public static void method883(Huffman var0) {
      class319.huffman = var0;
   }
}
