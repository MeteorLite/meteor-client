import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class70 {
   @ObfuscatedName("an")
   static final BigInteger field711 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("ao")
   static final BigInteger field712 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lne;IIB)[Lsn;",
      garbageValue = "58"
   )
   public static SpritePixels[] method416(AbstractArchive var0, int var1, int var2) {
      byte[] var4 = var0.takeFile(var1, var2);
      boolean var3;
      if (var4 == null) {
         var3 = false;
      } else {
         class212.SpriteBuffer_decode(var4);
         var3 = true;
      }

      return !var3 ? null : ViewportMouse.method1296();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsy;II)V",
      garbageValue = "1835049871"
   )
   public static void method418(Buffer var0, int var1) {
      if (JagexCache.JagexCache_randomDat != null) {
         try {
            JagexCache.JagexCache_randomDat.seek(0L);
            JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("lc")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1262575388"
   )
   static final void method417(int var0) {
      var0 = Math.min(Math.max(var0, 0), 255);
      if (var0 != WorldMapSectionType.clientPreferences.getCurrentMusicVolume()) {
         if (WorldMapSectionType.clientPreferences.getCurrentMusicVolume() == 0 && Client.currentTrackGroupId != -1) {
            class163.method853(class308.archive6, Client.currentTrackGroupId, 0, var0, false);
            Client.playingJingle = false;
         } else if (var0 == 0) {
            class258.method1464();
            Client.playingJingle = false;
         } else if (class293.musicPlayerStatus != 0) {
            class368.musicTrackVolume = var0;
         } else {
            class293.midiPcmStream.setPcmStreamVolume(var0);
         }

         WorldMapSectionType.clientPreferences.setCurrentMusicVolume(var0);
      }

   }

   @ObfuscatedName("nm")
   @ObfuscatedSignature(
      descriptor = "(II)Lst;",
      garbageValue = "745575289"
   )
   static class471 method419(int var0) {
      class471 var1 = (class471)Client.Widget_cachedFonts.get((long)var0);
      if (var1 == null) {
         var1 = new class471(class320.field3001, var0);
      }

      return var1;
   }
}
