import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
    @ObfuscatedName("tq")
    @ObfuscatedSignature(
            descriptor = "Lak;"
    )
    static PcmPlayer pcmPlayer0;
    @ObfuscatedName("im")
    @ObfuscatedSignature(
            descriptor = "Lrs;"
    )
    static SpritePixels compass;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "[Lak;"
    )
    volatile PcmPlayer[] players = new PcmPlayer[2];

    @ObfuscatedName("run")
    public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            PcmPlayer var2 = this.players[var1];
            if (var2 != null) {
               var2.run();
            }
         }
      } catch (Exception var4) {
         class121.RunException_sendStackTrace((String)null, var4);
      }

   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-2099365505"
    )
    static void savePreferences() {
      AccessFile var0 = null;

      try {
         var0 = UrlRequester.getPreferencesFile("", class134.field1270.name, true);
         Buffer var1 = PacketWriter.clientPreferences.toBuffer();
         var0.write(var1.array, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if (var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("mv")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1599179239"
   )
   static void method221() {
      if (Client.oculusOrbState == 1) {
         Client.oculusOrbOnLocalPlayer = true;
      }

   }
}
