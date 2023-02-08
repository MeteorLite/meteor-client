import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class246 {
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
           descriptor = "(II)V",
           garbageValue = "1717042974"
   )
   static void updateGameState(int var0) {
      if (var0 != Client.gameState) {
         if (Client.gameState == 30) {
            Client.field617.method1066();
         }

         if (Client.gameState == 0) {
            Decimator.client.method165();
         }

         if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
            ModeWhere.method1885(0);
            Client.field400 = 0;
            Client.field401 = 0;
            Client.timer.method2026(var0);
            if (var0 != 20) {
               class373.method1971(false);
            }
         }

         if (var0 != 20 && var0 != 40 && WorldMapLabelSize.field2235 != null) {
            WorldMapLabelSize.field2235.close();
            WorldMapLabelSize.field2235 = null;
         }

         if (Client.gameState == 25) {
            Client.field609 = 0;
            Client.field433 = 0;
            Client.field434 = 1;
            Client.field435 = 0;
            Client.field436 = 1;
         }

         int var1;
         if (var0 != 5 && var0 != 10) {
            if (var0 == 20) {
               var1 = Client.gameState == 11 ? 4 : 0;
               class129.method714(ApproximateRouteStrategy.archive10, WorldMapEvent.archive8, false, var1);
            } else if (var0 == 11) {
               class129.method714(ApproximateRouteStrategy.archive10, WorldMapEvent.archive8, false, 4);
            } else if (var0 == 50) {
               class70.setLoginResponseString("", "Updating date of birth...", "");
               class129.method714(ApproximateRouteStrategy.archive10, WorldMapEvent.archive8, false, 7);
            } else if (Login.clearLoginScreen) {
               class147.titleboxSprite = null;
               Login.titlebuttonSprite = null;
               Login.runesSprite = null;
               Login.leftTitleSprite = null;
               class275.rightTitleSprite = null;
               class33.logoSprite = null;
               Login.title_muteSprite = null;
               Login.options_buttons_0Sprite = null;
               Login.options_buttons_2Sprite = null;
               class491.worldSelectBackSprites = null;
               class307.worldSelectFlagSprites = null;
               class391.worldSelectArrows = null;
               KeyHandler.worldSelectStars = null;
               Login.field769 = null;
               class305.field2809.method517();
               class28.method110(2);
               if (NetCache.NetCache_socket != null) {
                  try {
                     Buffer var3 = new Buffer(4);
                     var3.writeByte(2);
                     var3.writeMedium(0);
                     NetCache.NetCache_socket.write(var3.array, 0, 4);
                  } catch (IOException var5) {
                     try {
                        NetCache.NetCache_socket.close();
                     } catch (Exception var4) {
                        ;
                     }

                     ++NetCache.NetCache_ioExceptions;
                     NetCache.NetCache_socket = null;
                  }
               }

               Login.clearLoginScreen = false;
            }
         } else {
            var1 = ClanSettings.method809() ? 0 : 12;
            class129.method714(ApproximateRouteStrategy.archive10, WorldMapEvent.archive8, true, var1);
         }

         Client.gameState = var0;
      }
   }
}
