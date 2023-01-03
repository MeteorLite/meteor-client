import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class146 extends class136 {
   @ObfuscatedName("ti")
   @Export("cameraLookAtY")
   static int cameraLookAtY;
   @ObfuscatedName("fm")
   static String field1331;
   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      descriptor = "Lnv;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("h")
   int field1329;
   @ObfuscatedName("e")
   String field1333;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class146(class139 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1329 = var1.readInt();
      this.field1333 = var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method792(this.field1329, this.field1333);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lqs;",
      garbageValue = "1183914569"
   )
   @Export("getDbTableType")
   public static DbTableType getDbTableType(int var0) {
      DbTableType var1 = (DbTableType)DbTableType.DBTableType_cache.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = DbTableType.field3975.takeFile(39, var0);
         var1 = new DbTableType();
         if (var2 != null) {
            var1.method2311(new Buffer(var2));
         }

         var1.method2312();
         DbTableType.DBTableType_cache.put(var1, (long)var0);
         return var1;
      }
   }
}
