import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class134 extends class136 {
   @ObfuscatedName("h")
   long field1289;
   @ObfuscatedName("e")
   String field1288;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class134(class139 var1) {
      this.this$0 = var1;
      this.field1289 = -1L;
      this.field1288 = null;
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
         this.field1289 = var1.readLong();
      }

      this.field1288 = var1.readStringCp1252NullTerminatedOrNull();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method797(this.field1289, this.field1288, 0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;I)I",
      garbageValue = "-197424852"
   )
   static int method731(AbstractArchive var0, AbstractArchive var1) {
      int var2 = 0;
      String[] var3 = Login.field742;

      int var4;
      String var5;
      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var0.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      var3 = Login.field740;

      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var1.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      var3 = Login.field760;

      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var1.getGroupId(var5) != -1 && var1.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      return var2;
   }
}
