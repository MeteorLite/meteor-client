import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class151 extends class136 {
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Lok;"
   )
   static Bounds field1370;
   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      descriptor = "Lnv;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("h")
   long field1372;
   @ObfuscatedName("e")
   String field1368;
   @ObfuscatedName("v")
   int field1369;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class151(class139 var1) {
      this.this$0 = var1;
      this.field1372 = -1L;
      this.field1368 = null;
      this.field1369 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1372 = var1.readLong();
      }

      this.field1368 = var1.readStringCp1252NullTerminatedOrNull();
      this.field1369 = var1.readUnsignedShort();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method797(this.field1372, this.field1368, this.field1369);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;B)V",
      garbageValue = "116"
   )
   public static void method812(AbstractArchive var0) {
   }
}
