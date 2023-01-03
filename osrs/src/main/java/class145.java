import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class145 extends class136 {
   @ObfuscatedName("q")
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("j")
   @Export("musicTrackBoolean")
   public static boolean musicTrackBoolean;
   @ObfuscatedName("jz")
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("h")
   String field1327;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class145(class139 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1327 = var1.readStringCp1252NullTerminated();
      var1.readInt();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.name = this.field1327;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1769477023"
   )
   public static int method773(int var0) {
      if (var0 > 0) {
         return 1;
      } else {
         return var0 < 0 ? -1 : 0;
      }
   }
}
