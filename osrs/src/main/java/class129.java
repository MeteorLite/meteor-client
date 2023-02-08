import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class129 implements class119 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;ZIS)V",
      garbageValue = "222"
   )
   static void method714(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
      if (Login.clearLoginScreen) {
         if (var3 == 4) {
            ReflectionCheck.method171(4);
         }

      } else {
         if (var3 == 0) {
            GrandExchangeOfferNameComparator.method1845(var2);
         } else {
            ReflectionCheck.method171(var3);
         }

         Rasterizer2D.Rasterizer2D_clear();
         byte[] var4 = var0.takeFileByNames("title.jpg", "");
         Login.leftTitleSprite = class266.method1505(var4);
         class275.rightTitleSprite = Login.leftTitleSprite.mirrorHorizontally();
         ObjectComposition.method1028(var1, Client.worldProperties);
         class147.titleboxSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
         Login.titlebuttonSprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
         class19.field64 = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
         Canvas.field79 = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
         VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
         Login.runesSprite = class125.method705(var1, "runes", "");
         Login.title_muteSprite = class125.method705(var1, "title_mute", "");
         Login.options_buttons_0Sprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
         ChatChannel.field828 = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
         Login.options_buttons_2Sprite = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
         class100.field1079 = VarcInt.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
         WorldMapRectangle.field2360 = Login.options_buttons_0Sprite.subWidth;
         class134.field1277 = Login.options_buttons_0Sprite.subHeight;
         class305.field2809 = new LoginScreenAnimation(Login.runesSprite);
         if (var2) {
            Login.Login_username = "";
            Login.Login_password = "";
            Login.field761 = new String[8];
            Login.field760 = 0;
         }

         UserComparator4.field1149 = 0;
         InvDefinition.otp = "";
         Login.field764 = true;
         Login.worldSelectOpen = false;
         if (!PacketWriter.clientPreferences.getTitleMusicDisabled()) {
            WorldMapScaleHandler.method1501(2, class153.archive6, "scape main", "", 255, false);
         } else {
            class28.method110(2);
         }

         if (NetCache.NetCache_socket != null) {
            try {
               Buffer var5 = new Buffer(4);
               var5.writeByte(3);
               var5.writeMedium(0);
               NetCache.NetCache_socket.write(var5.array, 0, 4);
            } catch (IOException var8) {
               try {
                  NetCache.NetCache_socket.close();
               } catch (Exception var7) {
                  ;
               }

               ++NetCache.NetCache_ioExceptions;
               NetCache.NetCache_socket = null;
            }
         }

         Login.clearLoginScreen = true;
         Login.xPadding = (GameEngine.canvasWidth - 765) / 2;
         Login.loginBoxX = Login.xPadding + 202;
         class143.loginBoxCenter = Login.loginBoxX + 180;
         Login.leftTitleSprite.drawAt(Login.xPadding, 0);
         class275.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
         class33.logoSprite.drawAt(Login.xPadding + 382 - class33.logoSprite.subWidth / 2, 18);
      }
   }
}
