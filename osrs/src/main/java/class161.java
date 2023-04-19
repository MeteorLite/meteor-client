import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class161 extends class139 {
   @ObfuscatedName("ag")
   static int[][][] field1407;
   @ObfuscatedName("af")
   long field1408;
   @ObfuscatedName("an")
   String field1406;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class161(class142 var1) {
      this.this$0 = var1;
      this.field1408 = -1L;
      this.field1406 = null;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         this.field1408 = var1.readLong();
      }

      this.field1406 = var1.readStringCp1252NullTerminatedOrNull();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method857(this.field1408, this.field1406);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IBBBBB)I",
      garbageValue = "-39"
   )
   static int method907(int var0, byte var1, byte var2, byte var3, byte var4) {
      int var5 = var0 >> 10 & 63;
      int var6 = var0 >> 7 & 7;
      int var7 = var0 & 127;
      int var8 = var4 & 255;
      if (var1 != -1) {
         var5 += var8 * (var1 - var5) >> 7;
      }

      if (var2 != -1) {
         var6 += var8 * (var2 - var6) >> 7;
      }

      if (var3 != -1) {
         var7 += var8 * (var3 - var7) >> 7;
      }

      return (var5 << 10 | var6 << 7 | var7) & '\uffff';
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "1719542324"
   )
   static void method908(int var0, int var1, int var2) {
      if (var0 != 0) {
         int var3 = var0 >> 8;
         int var4 = var0 >> 4 & 7;
         int var5 = var0 & 15;
         Client.soundEffectIds[Client.soundEffectCount] = var3;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
         Client.soundEffects[Client.soundEffectCount] = null;
         int var6 = (var1 - 64) / 128;
         int var7 = (var2 - 64) / 128;
         Client.soundLocations[Client.soundEffectCount] = var5 + (var7 << 8) + (var6 << 16);
         ++Client.soundEffectCount;
      }
   }
}
