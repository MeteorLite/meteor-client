import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class33 {
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite logoSprite;
   @ObfuscatedName("i")
   int field105;
   @ObfuscatedName("n")
   int field104;

   class33(int var1, int var2) {
      this.field105 = var1;
      this.field104 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lag;I)Z",
      garbageValue = "-384198501"
   )
   boolean method133(class29 var1) {
      if (var1 == null) {
         return false;
      } else {
         switch(this.field105) {
         case 1:
            return var1.vmethod3949(this.field104);
         case 2:
            return var1.vmethod3989(this.field104);
         case 3:
            return var1.vmethod3951((char)this.field104);
         case 4:
            return var1.vmethod3953(this.field104 == 1);
         default:
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)[Lra;",
      garbageValue = "-483685235"
   )
   static PrivateChatMode[] method134() {
      return new PrivateChatMode[]{PrivateChatMode.field4119, PrivateChatMode.field4117, PrivateChatMode.field4118};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;IIS)Lnv;",
      garbageValue = "17887"
   )
   public static Font method129(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
      if (!Buffer.method2444(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.takeFile(var2, var3);
         Font var4;
         if (var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class488.SpriteBuffer_xOffsets, ApproximateRouteStrategy.SpriteBuffer_yOffsets, FriendsList.SpriteBuffer_spriteWidths, class132.SpriteBuffer_spriteHeights, class100.SpriteBuffer_spritePalette, class140.SpriteBuffer_pixels);
            class100.method595();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "1548132184"
   )
   static int method132(int var0, Script var1, boolean var2) {
      if (var0 < 1000) {
         return class130.method715(var0, var1, var2);
      } else if (var0 < 1100) {
         return UserComparator9.method660(var0, var1, var2);
      } else if (var0 < 1200) {
         return GrandExchangeOfferOwnWorldComparator.method340(var0, var1, var2);
      } else if (var0 < 1300) {
         return ScriptFrame.method320(var0, var1, var2);
      } else if (var0 < 1400) {
         return GrandExchangeOfferOwnWorldComparator.method339(var0, var1, var2);
      } else if (var0 < 1500) {
         return class139.method750(var0, var1, var2);
      } else if (var0 < 1600) {
         return WorldMapManager.method1405(var0, var1, var2);
      } else if (var0 < 1700) {
         return class162.method860(var0, var1, var2);
      } else if (var0 < 1800) {
         return class96.method580(var0, var1, var2);
      } else if (var0 < 1900) {
         return class457.method2324(var0, var1, var2);
      } else if (var0 < 2000) {
         return Tiles.method449(var0, var1, var2);
      } else if (var0 < 2100) {
         return UserComparator9.method660(var0, var1, var2);
      } else if (var0 < 2200) {
         return GrandExchangeOfferOwnWorldComparator.method340(var0, var1, var2);
      } else if (var0 < 2300) {
         return ScriptFrame.method320(var0, var1, var2);
      } else if (var0 < 2400) {
         return GrandExchangeOfferOwnWorldComparator.method339(var0, var1, var2);
      } else if (var0 < 2500) {
         return class139.method750(var0, var1, var2);
      } else if (var0 < 2600) {
         return class132.method717(var0, var1, var2);
      } else if (var0 < 2700) {
         return EnumComposition.method948(var0, var1, var2);
      } else if (var0 < 2800) {
         return GrandExchangeOfferOwnWorldComparator.method338(var0, var1, var2);
      } else if (var0 < 2900) {
         return WorldMapSectionType.method1438(var0, var1, var2);
      } else if (var0 < 3000) {
         return Tiles.method449(var0, var1, var2);
      } else if (var0 < 3200) {
         return class217.method1182(var0, var1, var2);
      } else if (var0 < 3300) {
         return class122.method686(var0, var1, var2);
      } else if (var0 < 3400) {
         return PacketWriter.method626(var0, var1, var2);
      } else if (var0 < 3500) {
         return class151.method813(var0, var1, var2);
      } else if (var0 < 3600) {
         return UserComparator4.method648(var0, var1, var2);
      } else if (var0 < 3700) {
         return class390.method2047(var0, var1, var2);
      } else if (var0 < 3800) {
         return StructComposition.method1002(var0, var1, var2);
      } else if (var0 < 3900) {
         return DynamicObject.method440(var0, var1, var2);
      } else if (var0 < 4000) {
         return TriBool.method2127(var0, var1, var2);
      } else if (var0 < 4100) {
         return class10.method44(var0, var1, var2);
      } else if (var0 < 4200) {
         return class160.method849(var0, var1, var2);
      } else if (var0 < 4300) {
         return class6.method14(var0, var1, var2);
      } else if (var0 < 5100) {
         return StudioGame.method1785(var0, var1, var2);
      } else if (var0 < 5400) {
         return FriendSystem.method398(var0, var1, var2);
      } else if (var0 < 5600) {
         return class101.method599(var0, var1, var2);
      } else if (var0 < 5700) {
         return class217.method1177(var0, var1, var2);
      } else if (var0 < 6300) {
         return ServerPacket.method1541(var0, var1, var2);
      } else if (var0 < 6600) {
         return class378.method2017(var0, var1, var2);
      } else if (var0 < 6700) {
         return WorldMapRectangle.method1452(var0, var1, var2);
      } else if (var0 < 6800) {
         return class134.method732(var0, var1, var2);
      } else if (var0 < 6900) {
         return class17.method62(var0, var1, var2);
      } else if (var0 < 7000) {
         return PcmPlayer.method215(var0, var1, var2);
      } else if (var0 < 7100) {
         return Client.method368(var0, var1, var2);
      } else if (var0 < 7200) {
         return World.method385(var0, var1, var2);
      } else if (var0 < 7300) {
         return CollisionMap.method1106(var0, var1, var2);
      } else if (var0 < 7500) {
         return class4.method6(var0, var1, var2);
      } else if (var0 < 7600) {
         return ArchiveDisk.method2152(var0, var1, var2);
      } else {
         return var0 < 7700 ? class126.method709(var0, var1, var2) : 2;
      }
   }

    @ObfuscatedName("fo")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1841454557"
    )
    static void getLoginError(int var0) {
      int var1 = Login.loginIndex;
      if (var0 == -3) {
         class70.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
      } else if (var0 == -2) {
         class70.setLoginResponseString("Error connecting to server.", "Please try using a different world.", "");
      } else if (var0 == -1) {
         class70.setLoginResponseString("No response from server.", "Please try using a different world.", "");
      } else if (var0 == 3) {
         ReflectionCheck.method171(3);
         Login.field752 = 1;
      } else if (var0 == 4) {
         ReflectionCheck.method171(14);
         Login.field751 = 0;
      } else if (var0 == 5) {
         Login.field752 = 2;
         class70.setLoginResponseString("Either your account is still logged in, or the last", "world you were using has become unavailable.", "Please try again later.");
      } else if (var0 != 68 && (Client.onMobile || var0 != 6)) {
         if (var0 == 7) {
            class70.setLoginResponseString("This world is full.", "Please use a different world.", "");
         } else if (var0 == 8) {
            class70.setLoginResponseString("Unable to connect.", "Login server offline.", "");
         } else if (var0 == 9) {
            class70.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
         } else if (var0 == 10) {
            class70.setLoginResponseString("Unable to connect.", "Bad session id.", "");
         } else if (var0 == 11) {
            class70.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
         } else if (var0 == 12) {
            class70.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
         } else if (var0 == 13) {
            class70.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
         } else if (var0 == 14) {
            class70.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
         } else if (var0 == 16) {
            class70.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
         } else if (var0 == 17) {
            class70.setLoginResponseString("To access this free world, log into a", "members world and move your character", "to a non-members area.");
         } else if (var0 == 18) {
            ReflectionCheck.method171(14);
            Login.field751 = 1;
         } else if (var0 == 19) {
            class70.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
         } else if (var0 == 20) {
            class70.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
         } else if (var0 == 22) {
            class70.setLoginResponseString("Malformed login packet.", "Please try again.", "");
         } else if (var0 == 23) {
            class70.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
         } else if (var0 == 24) {
            class70.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
         } else if (var0 == 25) {
            class70.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
         } else if (var0 == 26) {
            class70.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
         } else if (var0 == 27) {
            class70.setLoginResponseString("", "Service unavailable.", "");
         } else if (var0 == 31) {
            class70.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
         } else if (var0 == 32) {
            ReflectionCheck.method171(14);
            Login.field751 = 2;
         } else if (var0 == 37) {
            class70.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
         } else if (var0 == 38) {
            class70.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
         } else if (var0 == 55) {
            ReflectionCheck.method171(8);
         } else {
            if (var0 == 56) {
               class70.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
               class246.updateGameState(11);
               return;
            }

            if (var0 == 57) {
               class70.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
               class246.updateGameState(11);
               return;
            }

            if (var0 == 61) {
               class70.setLoginResponseString("", "Please enter your date of birth (DD/MM/YYYY)", "");
               ReflectionCheck.method171(7);
            } else {
               if (var0 == 62) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(9);
                  class70.setLoginResponseString("Login attempt timed out.", "Please try again.", "");
                  return;
               }

               if (var0 == 63) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(9);
                  class70.setLoginResponseString("You were signed out.", "Please sign in again.", "");
                  return;
               }

               if (var0 == 65 || var0 == 67) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(9);
                  class70.setLoginResponseString("Failed to login.", "Please try again.", "");
                  return;
               }

               if (var0 == 71) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(7);
                  class70.setLoginResponseString("There was a problem updating your DOB.", "Please try again later. If the problem ", "persists, please contact Jagex Support.");
               } else if (var0 == 73) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(6);
                  class70.setLoginResponseString("Your date of birth information is waiting", "to be reviewed by our staff.", "It will be processed shortly.");
               } else if (var0 == 72) {
                  class246.updateGameState(10);
                  ReflectionCheck.method171(26);
               } else {
                  class70.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
               }
            }
         }
      } else {
         class70.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
      }

      class246.updateGameState(10);
      boolean var3 = var1 != class16.method59();
      if (!var3 && Client.field404.method2459()) {
         ReflectionCheck.method171(9);
      }

   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "32"
   )
   static void method131(int var0) {
      class148.tempMenuAction = new MenuAction();
      class148.tempMenuAction.param0 = Client.menuArguments1[var0];
      class148.tempMenuAction.param1 = Client.menuArguments2[var0];
      class148.tempMenuAction.opcode = Client.menuOpcodes[var0];
      class148.tempMenuAction.identifier = Client.menuIdentifiers[var0];
      class148.tempMenuAction.itemId = Client.menuItemIds[var0];
      class148.tempMenuAction.action = Client.menuActions[var0];
      class148.tempMenuAction.target = Client.menuTargets[var0];
   }
}
