import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class138 extends class140 {
   @ObfuscatedName("aj")
   long field1293;
   @ObfuscatedName("al")
   String field1292;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class138(class143 var1) {
      this.this$0 = var1;
      this.field1293 = -1L;
      this.field1292 = null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1293 = var1.readLong();
      }

      this.field1292 = var1.readStringCp1252NullTerminatedOrNull();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method793(this.field1293, this.field1292, 0);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "1640153201"
   )
   static int method744(int var0, Script var1, boolean var2) {
      if (var0 == 5630) {
         Client.logoutTimer = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      descriptor = "(I)J",
      garbageValue = "-959228999"
   )
   static long method743() {
      return Client.playerUUID;
   }
}
