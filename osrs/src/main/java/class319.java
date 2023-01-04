import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
public class class319 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   static final class319 field3063 = new class319(51, 27, 800, 0, 16, 16);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lls;"
   )
   static final class319 field3060 = new class319(25, 28, 800, 656, 40, 40);
   @ObfuscatedName("v")
   final int field3061;
   @ObfuscatedName("x")
   final int field3062;

   class319(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.field3061 = var5;
      this.field3062 = var6;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(S)Lch;",
      garbageValue = "-20617"
   )
   static ClientPreferences method1771() {
      AccessFile var0 = null;
      ClientPreferences var1 = new ClientPreferences();

      try {
         var0 = class87.getPreferencesFile("", LoginPacket.gameStudio.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if (var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new ClientPreferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if (var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1520113956"
   )
   static void method1772() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.clear();
      Messages.Messages_queue.clear();
      Messages.Messages_count = 0;
   }
}
