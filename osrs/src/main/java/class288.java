import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
public final class class288 {
   @ObfuscatedName("ac")
   static final HashMap field2655 = new HashMap();

   static {
      java.util.Calendar.getInstance(method1550("Europe/London"));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/util/TimeZone;",
      garbageValue = "-1918615757"
   )
   static TimeZone method1550(String var0) {
      HashMap var1 = field2655;
      synchronized(field2655) {
         TimeZone var2 = (TimeZone)field2655.get(var0);
         if (var2 == null) {
            var2 = TimeZone.getTimeZone(var0);
            field2655.put(var0, var2);
         }

         return var2;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;Lne;Llz;I)Z",
      garbageValue = "1516727558"
   )
   public static boolean method1553(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
      class293.musicPatchesArchive = var0;
      class293.musicSamplesArchive = var1;
      class293.soundEffectsArchive = var2;
      class293.midiPcmStream = var3;
      return true;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lbr;Loe;Loe;B)V",
      garbageValue = "11"
   )
   static void method1552(GameEngine var0, Font var1, Font var2) {
      int var4;
      int var5;
      int var6;
      int var45;
      if (Login.worldSelectOpen) {
         class208 var43 = Calendar.method1780();

         while(true) {
            if (!var43.method1090()) {
               if (MouseHandler.MouseHandler_lastButton != 1 && (class319.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
                  break;
               }

               var4 = Login.xPadding + 280;
               if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(0, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(0, 1);
                  break;
               }

               var5 = Login.xPadding + 390;
               if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(1, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var5 + 15 && MouseHandler.MouseHandler_lastPressedX <= var5 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(1, 1);
                  break;
               }

               var6 = Login.xPadding + 500;
               if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var6 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(2, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var6 + 15 && MouseHandler.MouseHandler_lastPressedX <= var6 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(2, 1);
                  break;
               }

               var45 = Login.xPadding + 610;
               if (MouseHandler.MouseHandler_lastPressedX >= var45 && MouseHandler.MouseHandler_lastPressedX <= var45 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(3, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var45 + 15 && MouseHandler.MouseHandler_lastPressedX <= var45 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  MusicPatchNode2.changeWorldSelectSorting(3, 1);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                  class88.method477();
                  break;
               }

               if (Login.hoveredWorldIndex != -1) {
                  World var8 = class260.World_worlds[Login.hoveredWorldIndex];
                  VarbitComposition.changeWorld(var8);
                  Login.worldSelectOpen = false;
                  Login.leftTitleSprite.drawAt(Login.xPadding, 0);
                  class419.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
                  Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
               } else {
                  if (Login.worldSelectPage > 0 && class12.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class12.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class143.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class143.canvasHeight / 2 + 50) {
                     --Login.worldSelectPage;
                  }

                  if (Login.worldSelectPage < Login.worldSelectPagesCount && class208.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GameEngine.canvasWidth - class208.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GameEngine.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class143.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class143.canvasHeight / 2 + 50) {
                     ++Login.worldSelectPage;
                  }
               }
               break;
            }

            if (var43.field1823 == 13) {
               Login.worldSelectOpen = false;
               Login.leftTitleSprite.drawAt(Login.xPadding, 0);
               class419.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
               Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
               break;
            }

            if (var43.field1823 == 96) {
               if (Login.worldSelectPage > 0 && class12.worldSelectLeftSprite != null) {
                  --Login.worldSelectPage;
               }
            } else if (var43.field1823 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class208.worldSelectRightSprite != null) {
               ++Login.worldSelectPage;
            }
         }

      } else {
         if ((MouseHandler.MouseHandler_lastButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            WorldMapSectionType.clientPreferences.getTitleMusicDisabled(!WorldMapSectionType.clientPreferences.getTitleMusicDisabled());
            if (!WorldMapSectionType.clientPreferences.getTitleMusicDisabled()) {
               Archive var3 = class308.archive6;
               var4 = var3.getGroupId("scape main");
               var5 = var3.getFileId(var4, "");
               class163.method853(var3, var4, var5, 255, false);
            } else {
               class258.method1464();
            }
         }

         if (Client.gameState != 5) {
            if (Login.field757 == -1L) {
               Login.field757 = WorldMapSection2.clockNow() + 1000L;
            }

            long var24 = WorldMapSection2.clockNow();
            boolean var44;
            if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
               while(true) {
                  if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
                     var44 = true;
                     break;
                  }

                  ArchiveLoader var26 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
                  if (!var26.isLoaded()) {
                     var44 = false;
                     break;
                  }

                  ++Client.archiveLoadersDone;
               }
            } else {
               var44 = true;
            }

            if (var44 && Login.field758 == -1L) {
               Login.field758 = var24;
               if (Login.field758 > Login.field757) {
                  Login.field757 = Login.field758;
               }
            }

            if (Client.gameState == 10 || Client.gameState == 11) {
               if (Language.Language_EN == class69.clientLanguage) {
                  if (MouseHandler.MouseHandler_lastButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var6 = Login.xPadding + 5;
                     short var7 = 463;
                     byte var27 = 100;
                     byte var9 = 35;
                     if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var27 + var6 && MouseHandler.MouseHandler_lastPressedY >= var7 && MouseHandler.MouseHandler_lastPressedY <= var7 + var9) {
                        Client.method381();
                        return;
                     }
                  }

                  if (class16.World_request != null) {
                     Client.method381();
                  }
               }

               var6 = MouseHandler.MouseHandler_lastButton;
               var45 = MouseHandler.MouseHandler_lastPressedX;
               int var55 = MouseHandler.MouseHandler_lastPressedY;
               if (var6 == 0) {
                  var45 = MouseHandler.MouseHandler_x;
                  var55 = MouseHandler.MouseHandler_y;
               }

               if (!class319.mouseCam && var6 == 4) {
                  var6 = 1;
               }

               class208 var28 = Calendar.method1780();
               short var47;
               int var48;
               if (Login.loginIndex == 0) {
                  boolean var53 = false;

                  while(var28.method1090()) {
                     if (var28.field1823 == 84) {
                        var53 = true;
                     }
                  }

                  var48 = Login.loginBoxCenter - 80;
                  var47 = 291;
                  if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20) {
                     KeyHandler.openURL(class154.method822("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var48 = Login.loginBoxCenter + 80;
                  if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20 || var53) {
                     if ((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        class14.method52(1);
                        ReflectionCheck.method178();
                     } else if ((Client.worldProperties & 4) != 0) {
                        if ((Client.worldProperties & 1024) != 0) {
                           Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other almost everywhere";
                           Login.Login_response3 = "and the Protect Item prayer won't work.";
                        } else {
                           Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other";
                           Login.Login_response3 = "almost everywhere.";
                        }

                        Login.Login_response0 = "Warning!";
                        class14.method52(1);
                        ReflectionCheck.method178();
                     } else if ((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        class14.method52(1);
                        ReflectionCheck.method178();
                     } else {
                        FontName.Login_promptCredentials(false);
                     }
                  }
               } else {
                  int var10;
                  short var11;
                  if (Login.loginIndex == 1) {
                     while(true) {
                        if (!var28.method1090()) {
                           var10 = Login.loginBoxCenter - 80;
                           var11 = 321;
                           if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                              FontName.Login_promptCredentials(false);
                           }

                           var10 = Login.loginBoxCenter + 80;
                           if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                              class14.method52(0);
                           }
                           break;
                        }

                        if (var28.field1823 == 84) {
                           FontName.Login_promptCredentials(false);
                        } else if (var28.field1823 == 13) {
                           class14.method52(0);
                        }
                     }
                  } else {
                     int var15;
                     short var46;
                     boolean var49;
                     if (Login.loginIndex == 2) {
                        var46 = 201;
                        var10 = var46 + 52;
                        if (var6 == 1 && var55 >= var10 - 12 && var55 < var10 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var10 += 15;
                        if (var6 == 1 && var55 >= var10 - 12 && var55 < var10 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var10 += 15;
                        var46 = 361;
                        if (WorldMapSectionType.field2332 != null) {
                           var48 = WorldMapSectionType.field2332.highX / 2;
                           if (var6 == 1 && var45 >= WorldMapSectionType.field2332.lowX - var48 && var45 <= var48 + WorldMapSectionType.field2332.lowX && var55 >= var46 - 15 && var55 < var46) {
                              switch(Login.field725) {
                              case 1:
                                 Tile.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 class14.method52(5);
                                 return;
                              case 2:
                                 KeyHandler.openURL("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var48 = Login.loginBoxCenter - 80;
                        var47 = 321;
                        if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if (Login.Login_username.length() == 0) {
                              Tile.setLoginResponseString("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Login.Login_password.length() == 0) {
                              Tile.setLoginResponseString("", "Please enter your password.", "");
                              return;
                           }

                           Tile.setLoginResponseString("", "Connecting to server...", "");
                           class130.method716(false);
                           class19.updateGameState(20);
                           return;
                        }

                        var48 = Login.loginBoxX + 180 + 80;
                        if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20) {
                           class14.method52(0);
                           Login.Login_username = "";
                           Login.Login_password = "";
                           FriendSystem.field663 = 0;
                           NetFileRequest.otp = "";
                           Login.field750 = true;
                        }

                        var48 = Login.loginBoxCenter + -117;
                        var47 = 277;
                        Login.field737 = var45 >= var48 && var45 < var48 + Message.field348 && var55 >= var47 && var55 < var47 + class465.field3943;
                        if (var6 == 1 && Login.field737) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if (!Client.Login_isUsernameRemembered && WorldMapSectionType.clientPreferences.getUsernameToRemember() != null) {
                              WorldMapSectionType.clientPreferences.setUsernameToRemember((String)null);
                           }
                        }

                        var48 = Login.loginBoxCenter + 24;
                        var47 = 277;
                        Login.field749 = var45 >= var48 && var45 < var48 + Message.field348 && var55 >= var47 && var55 < var47 + class465.field3943;
                        if (var6 == 1 && Login.field749) {
                           WorldMapSectionType.clientPreferences.setIsUsernameHidden(!WorldMapSectionType.clientPreferences.getIsUsernameHidden());
                           if (!WorldMapSectionType.clientPreferences.getIsUsernameHidden()) {
                              Login.Login_username = "";
                              WorldMapSectionType.clientPreferences.setUsernameToRemember((String)null);
                              ReflectionCheck.method178();
                           }
                        }

                        label1528:
                        while(true) {
                           Transferable var57;
                           do {
                              while(true) {
                                 char var51;
                                 label1492:
                                 do {
                                    while(true) {
                                       while(var28.method1090()) {
                                          if (var28.field1823 != 13) {
                                             if (Login.currentLoginField != 0) {
                                                continue label1492;
                                             }

                                             Interpreter.method411(var28.field1824);
                                             if (var28.field1823 == 85 && Login.Login_username.length() > 0) {
                                                Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                             }

                                             if (var28.field1823 == 84 || var28.field1823 == 80) {
                                                Login.currentLoginField = 1;
                                             }

                                             var51 = var28.field1824;
                                             var49 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var51) != -1;
                                             if (var49 && Login.Login_username.length() < 320) {
                                                Login.Login_username = Login.Login_username + var28.field1824;
                                             }
                                          } else {
                                             class14.method52(0);
                                             Login.Login_username = "";
                                             Login.Login_password = "";
                                             FriendSystem.field663 = 0;
                                             NetFileRequest.otp = "";
                                             Login.field750 = true;
                                          }
                                       }

                                       return;
                                    }
                                 } while(Login.currentLoginField != 1);

                                 if (var28.field1823 == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 } else if (var28.field1823 == 84 || var28.field1823 == 80) {
                                    Login.currentLoginField = 0;
                                    if (var28.field1823 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          Tile.setLoginResponseString("", "Please enter your username/email address.", "");
                                          return;
                                       }

                                       if (Login.Login_password.length() == 0) {
                                          Tile.setLoginResponseString("", "Please enter your password.", "");
                                          return;
                                       }

                                       Tile.setLoginResponseString("", "Connecting to server...", "");
                                       class130.method716(false);
                                       class19.updateGameState(20);
                                       return;
                                    }
                                 }

                                 if ((var28.getKeyPressed(82) || var28.getKeyPressed(87)) && var28.field1823 == 67) {
                                    Clipboard var56 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var57 = var56.getContents(class392.client);
                                    var15 = 20 - Login.Login_password.length();
                                    break;
                                 }

                                 if (ReflectionCheck.method180(var28.field1824)) {
                                    var51 = var28.field1824;
                                    var49 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var51) != -1;
                                    if (var49 && Login.Login_password.length() < 20) {
                                       Login.Login_password = Login.Login_password + var28.field1824;
                                    }
                                 }
                              }
                           } while(var15 <= 0);

                           try {
                              String var16 = (String)var57.getTransferData(DataFlavor.stringFlavor);
                              int var17 = Math.min(var15, var16.length());
                              int var52 = 0;

                              while(true) {
                                 if (var52 >= var17) {
                                    Login.Login_password = Login.Login_password + var16.substring(0, var17);
                                    continue label1528;
                                 }

                                 if (!ReflectionCheck.method180(var16.charAt(var52))) {
                                    break;
                                 }

                                 char var54 = var16.charAt(var52);
                                 boolean var19 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var54) != -1;
                                 if (!var19) {
                                    break;
                                 }

                                 ++var52;
                              }

                              class14.method52(3);
                              return;
                           } catch (UnsupportedFlavorException var41) {
                              ;
                           } catch (IOException var42) {
                              ;
                           }
                        }
                     } else {
                        Bounds var31;
                        if (Login.loginIndex == 3) {
                           var10 = Login.loginBoxX + 180;
                           var11 = 241;
                           var31 = var1.method1996(0, "<col=ffd200>Download it here.</col>".length(), "<col=ffd200>Download it here.</col>", var10, var11);
                           if (var6 == 1 && var31.method2170(var45, var55)) {
                              KeyHandler.openURL("https://oldschool.runescape.com/launcher", true, false);
                           }

                           var10 = Login.loginBoxX + 180;
                           var11 = 276;
                           if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                              class28.method121(false);
                           }

                           var10 = Login.loginBoxX + 180;
                           var11 = 326;
                           if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                              Tile.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                              class14.method52(5);
                              return;
                           }
                        } else {
                           int var13;
                           if (Login.loginIndex == 4) {
                              var10 = Login.loginBoxX + 180 - 80;
                              var11 = 321;
                              if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                 NetFileRequest.otp.trim();
                                 if (NetFileRequest.otp.length() != 6) {
                                    Tile.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 FriendSystem.field663 = Integer.parseInt(NetFileRequest.otp);
                                 NetFileRequest.otp = "";
                                 class130.method716(true);
                                 Tile.setLoginResponseString("", "Connecting to server...", "");
                                 class19.updateGameState(20);
                                 return;
                              }

                              if (var6 == 1 && var45 >= Login.loginBoxX + 180 - 9 && var45 <= Login.loginBoxX + 180 + 130 && var55 >= 263 && var55 <= 296) {
                                 Login.field750 = !Login.field750;
                              }

                              if (var6 == 1 && var45 >= Login.loginBoxX + 180 - 34 && var45 <= Login.loginBoxX + 34 + 180 && var55 >= 351 && var55 <= 363) {
                                 KeyHandler.openURL(class154.method822("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                              }

                              var10 = Login.loginBoxX + 180 + 80;
                              if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                 class14.method52(0);
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 FriendSystem.field663 = 0;
                                 NetFileRequest.otp = "";
                              }

                              while(var28.method1090()) {
                                 boolean var12 = false;

                                 for(var13 = 0; var13 < "1234567890".length(); ++var13) {
                                    if (var28.field1824 == "1234567890".charAt(var13)) {
                                       var12 = true;
                                       break;
                                    }
                                 }

                                 if (var28.field1823 == 13) {
                                    class14.method52(0);
                                    Login.Login_username = "";
                                    Login.Login_password = "";
                                    FriendSystem.field663 = 0;
                                    NetFileRequest.otp = "";
                                 } else {
                                    if (var28.field1823 == 85 && NetFileRequest.otp.length() > 0) {
                                       NetFileRequest.otp = NetFileRequest.otp.substring(0, NetFileRequest.otp.length() - 1);
                                    }

                                    if (var28.field1823 == 84) {
                                       NetFileRequest.otp.trim();
                                       if (NetFileRequest.otp.length() != 6) {
                                          Tile.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                          return;
                                       }

                                       FriendSystem.field663 = Integer.parseInt(NetFileRequest.otp);
                                       NetFileRequest.otp = "";
                                       class130.method716(true);
                                       Tile.setLoginResponseString("", "Connecting to server...", "");
                                       class19.updateGameState(20);
                                       return;
                                    }

                                    if (var12 && NetFileRequest.otp.length() < 6) {
                                       NetFileRequest.otp = NetFileRequest.otp + var28.field1824;
                                    }
                                 }
                              }
                           } else {
                              int var14;
                              if (Login.loginIndex == 5) {
                                 var10 = Login.loginBoxX + 180 - 80;
                                 var11 = 321;
                                 if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                    WallDecoration.method1305();
                                    return;
                                 }

                                 var10 = Login.loginBoxX + 180 + 80;
                                 if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                    FontName.Login_promptCredentials(true);
                                 }

                                 var47 = 361;
                                 if (DevicePcmPlayerProvider.field67 != null) {
                                    var13 = DevicePcmPlayerProvider.field67.highX / 2;
                                    if (var6 == 1 && var45 >= DevicePcmPlayerProvider.field67.lowX - var13 && var45 <= var13 + DevicePcmPlayerProvider.field67.lowX && var55 >= var47 - 15 && var55 < var47) {
                                       KeyHandler.openURL(class154.method822("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                                    }
                                 }

                                 while(var28.method1090()) {
                                    var49 = false;

                                    for(var14 = 0; var14 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var14) {
                                       if (var28.field1824 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var14)) {
                                          var49 = true;
                                          break;
                                       }
                                    }

                                    if (var28.field1823 == 13) {
                                       FontName.Login_promptCredentials(true);
                                    } else {
                                       if (var28.field1823 == 85 && Login.Login_username.length() > 0) {
                                          Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                       }

                                       if (var28.field1823 == 84) {
                                          WallDecoration.method1305();
                                          return;
                                       }

                                       if (var49 && Login.Login_username.length() < 320) {
                                          Login.Login_username = Login.Login_username + var28.field1824;
                                       }
                                    }
                                 }
                              } else if (Login.loginIndex != 6) {
                                 if (Login.loginIndex == 7) {
                                    if (class157.field1372 && !Client.onMobile) {
                                       var10 = Login.loginBoxCenter - 150;
                                       var48 = var10 + 40 + 240 + 25;
                                       var47 = 231;
                                       var13 = var47 + 40;
                                       if (var6 == 1 && var45 >= var10 && var45 <= var48 && var55 >= var47 && var55 <= var13) {
                                          var15 = var10;
                                          int var32 = 0;

                                          while(true) {
                                             if (var32 >= 8) {
                                                var14 = 0;
                                                break;
                                             }

                                             if (var45 <= var15 + 30) {
                                                var14 = var32;
                                                break;
                                             }

                                             var15 += 30;
                                             var15 += var32 != 1 && var32 != 3 ? 5 : 20;
                                             ++var32;
                                          }

                                          Login.field746 = var14;
                                       }

                                       var14 = Login.loginBoxX + 180 - 80;
                                       short var50 = 321;
                                       boolean var18;
                                       boolean var20;
                                       String[] var21;
                                       int var22;
                                       String var23;
                                       SimpleDateFormat var33;
                                       StringBuilder var34;
                                       Date var35;
                                       Date var36;
                                       boolean var58;
                                       java.util.Calendar var59;
                                       Date var60;
                                       if (var6 == 1 && var45 >= var14 - 75 && var45 <= var14 + 75 && var55 >= var50 - 20 && var55 <= var50 + 20) {
                                          label1371: {
                                             try {
                                                var33 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                                var33.setLenient(false);
                                                var34 = new StringBuilder();
                                                var21 = Login.field745;
                                                var22 = 0;

                                                while(true) {
                                                   if (var22 < var21.length) {
                                                      var23 = var21[var22];
                                                      if (var23 != null) {
                                                         var34.append(var23);
                                                         ++var22;
                                                         continue;
                                                      }

                                                      method1551("Date not valid.", "Please ensure all characters are populated.", "");
                                                      var35 = null;
                                                   } else {
                                                      var34.append("12");
                                                      var35 = var33.parse(var34.toString());
                                                   }

                                                   var36 = var35;
                                                   break;
                                                }
                                             } catch (ParseException var40) {
                                                method1551("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                var58 = false;
                                                break label1371;
                                             }

                                             if (var36 == null) {
                                                var58 = false;
                                             } else {
                                                var59 = java.util.Calendar.getInstance();
                                                var59.set(1, var59.get(1) - 13);
                                                var59.set(5, var59.get(5) + 1);
                                                var59.set(11, 0);
                                                var59.set(12, 0);
                                                var59.set(13, 0);
                                                var59.set(14, 0);
                                                var60 = var59.getTime();
                                                var18 = var36.before(var60);
                                                var20 = class83.method461(var36);
                                                if (!var20) {
                                                   method1551("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                   var58 = false;
                                                } else {
                                                   if (!var18) {
                                                      class31.field89 = 8388607;
                                                   } else {
                                                      class31.field89 = (int)(var36.getTime() / 86400000L - 11745L);
                                                   }

                                                   var58 = true;
                                                }
                                             }
                                          }

                                          if (var58) {
                                             class19.updateGameState(50);
                                             return;
                                          }
                                       }

                                       var14 = Login.loginBoxX + 180 + 80;
                                       if (var6 == 1 && var45 >= var14 - 75 && var45 <= var14 + 75 && var55 >= var50 - 20 && var55 <= var50 + 20) {
                                          Login.field745 = new String[8];
                                          FontName.Login_promptCredentials(true);
                                       }

                                       while(var28.method1090()) {
                                          if (var28.field1823 == 101) {
                                             Login.field745[Login.field746] = null;
                                          }

                                          if (var28.field1823 == 85) {
                                             if (Login.field745[Login.field746] == null && Login.field746 > 0) {
                                                --Login.field746;
                                             }

                                             Login.field745[Login.field746] = null;
                                          }

                                          if (var28.field1824 >= '0' && var28.field1824 <= '9') {
                                             Login.field745[Login.field746] = "" + var28.field1824;
                                             if (Login.field746 < 7) {
                                                ++Login.field746;
                                             }
                                          }

                                          if (var28.field1823 == 84) {
                                             label1300: {
                                                try {
                                                   var33 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                                   var33.setLenient(false);
                                                   var34 = new StringBuilder();
                                                   var21 = Login.field745;
                                                   var22 = 0;

                                                   while(true) {
                                                      if (var22 >= var21.length) {
                                                         var34.append("12");
                                                         var35 = var33.parse(var34.toString());
                                                         break;
                                                      }

                                                      var23 = var21[var22];
                                                      if (var23 == null) {
                                                         method1551("Date not valid.", "Please ensure all characters are populated.", "");
                                                         var35 = null;
                                                         break;
                                                      }

                                                      var34.append(var23);
                                                      ++var22;
                                                   }

                                                   var36 = var35;
                                                } catch (ParseException var39) {
                                                   method1551("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                   var58 = false;
                                                   break label1300;
                                                }

                                                if (var36 == null) {
                                                   var58 = false;
                                                } else {
                                                   var59 = java.util.Calendar.getInstance();
                                                   var59.set(1, var59.get(1) - 13);
                                                   var59.set(5, var59.get(5) + 1);
                                                   var59.set(11, 0);
                                                   var59.set(12, 0);
                                                   var59.set(13, 0);
                                                   var59.set(14, 0);
                                                   var60 = var59.getTime();
                                                   var18 = var36.before(var60);
                                                   var20 = class83.method461(var36);
                                                   if (!var20) {
                                                      method1551("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                      var58 = false;
                                                   } else {
                                                      if (!var18) {
                                                         class31.field89 = 8388607;
                                                      } else {
                                                         class31.field89 = (int)(var36.getTime() / 86400000L - 11745L);
                                                      }

                                                      var58 = true;
                                                   }
                                                }
                                             }

                                             if (var58) {
                                                class19.updateGameState(50);
                                             }

                                             return;
                                          }
                                       }
                                    } else {
                                       var10 = Login.loginBoxX + 180 - 80;
                                       var11 = 321;
                                       if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                          KeyHandler.openURL(class154.method822("secure", true) + "m=dob/set_dob.ws", true, false);
                                          Tile.setLoginResponseString("", "Page has opened in the browser.", "");
                                          class14.method52(6);
                                          return;
                                       }

                                       var10 = Login.loginBoxX + 180 + 80;
                                       if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                          FontName.Login_promptCredentials(true);
                                       }
                                    }
                                 } else if (Login.loginIndex == 8) {
                                    var10 = Login.loginBoxX + 180 - 80;
                                    var11 = 321;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       KeyHandler.openURL("https://www.jagex.com/terms/privacy", true, false);
                                       Tile.setLoginResponseString("", "Page has opened in the browser.", "");
                                       class14.method52(6);
                                       return;
                                    }

                                    var10 = Login.loginBoxX + 180 + 80;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       FontName.Login_promptCredentials(true);
                                    }
                                 } else if (Login.loginIndex == 9) {
                                    var10 = Login.loginBoxX + 180;
                                    var11 = 311;
                                    if (var28.field1823 == 84 || var28.field1823 == 13 || var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       class28.method121(false);
                                    }
                                 } else if (Login.loginIndex == 10) {
                                    var10 = Login.loginBoxX + 180;
                                    var11 = 209;
                                    if (var28.field1823 == 84 || var6 == 1 && var45 >= var10 - 109 && var45 <= var10 + 109 && var55 >= var11 && var55 <= var11 + 68) {
                                       Tile.setLoginResponseString("", "Connecting to server...", "");
                                       Client.field393 = class482.field4017;
                                       class130.method716(false);
                                       class19.updateGameState(20);
                                    }
                                 } else if (Login.loginIndex == 12) {
                                    var10 = Login.loginBoxCenter;
                                    var11 = 233;
                                    var31 = var2.method1996(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                                    Bounds var29 = var2.method1996(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                                    Bounds var30 = var2.method1996(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                                    var48 = var11 + 17;
                                    Bounds var37 = var2.method1996(0, 34, "<col=ffd200>agreement (EULA)</col>.", var10, var48);
                                    if (var6 == 1) {
                                       if (var31.method2170(var45, var55)) {
                                          KeyHandler.openURL("https://www.jagex.com/terms", true, false);
                                       } else if (var29.method2170(var45, var55)) {
                                          KeyHandler.openURL("https://www.jagex.com/terms/privacy", true, false);
                                       } else if (var30.method2170(var45, var55) || var37.method2170(var45, var55)) {
                                          KeyHandler.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
                                       }
                                    }

                                    var10 = Login.loginBoxCenter - 80;
                                    var11 = 311;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       WorldMapSectionType.clientPreferences.method536(Client.param21);
                                       class28.method121(true);
                                    }

                                    var10 = Login.loginBoxCenter + 80;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       Login.loginIndex = 13;
                                    }
                                 } else if (Login.loginIndex == 13) {
                                    var10 = Login.loginBoxCenter;
                                    var11 = 321;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       class28.method121(true);
                                    }
                                 } else if (Login.loginIndex == 14) {
                                    String var38 = "";
                                    switch(Login.field738) {
                                    case 0:
                                       var38 = "https://secure.runescape.com/m=offence-appeal/account-history";
                                       break;
                                    case 1:
                                       var38 = "https://secure.runescape.com/m=accountappeal/passwordrecovery";
                                       break;
                                    case 2:
                                       var38 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
                                       break;
                                    default:
                                       FontName.Login_promptCredentials(false);
                                    }

                                    var48 = Login.loginBoxX + 180;
                                    var47 = 276;
                                    if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20) {
                                       KeyHandler.openURL(var38, true, false);
                                       Tile.setLoginResponseString("", "Page has opened in the browser.", "");
                                       class14.method52(6);
                                       return;
                                    }

                                    var48 = Login.loginBoxX + 180;
                                    var47 = 326;
                                    if (var6 == 1 && var45 >= var48 - 75 && var45 <= var48 + 75 && var55 >= var47 - 20 && var55 <= var47 + 20) {
                                       FontName.Login_promptCredentials(false);
                                    }
                                 } else if (Login.loginIndex == 24) {
                                    var10 = Login.loginBoxX + 180;
                                    var11 = 301;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       class28.method121(false);
                                    }
                                 } else if (Login.loginIndex == 26) {
                                    var10 = Login.loginBoxX + 180 - 80;
                                    var11 = 321;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       KeyHandler.openURL(class154.method822("secure", true) + "m=dob/set_dob.ws", true, false);
                                       Tile.setLoginResponseString("", "Page has opened in the browser.", "");
                                       class14.method52(6);
                                       return;
                                    }

                                    var10 = Login.loginBoxX + 180 + 80;
                                    if (var6 == 1 && var45 >= var10 - 75 && var45 <= var10 + 75 && var55 >= var11 - 20 && var55 <= var11 + 20) {
                                       FontName.Login_promptCredentials(true);
                                    }
                                 }
                              } else {
                                 while(true) {
                                    do {
                                       if (!var28.method1090()) {
                                          var46 = 321;
                                          if (var6 == 1 && var55 >= var46 - 20 && var55 <= var46 + 20) {
                                             FontName.Login_promptCredentials(true);
                                          }

                                          return;
                                       }
                                    } while(var28.field1823 != 84 && var28.field1823 != 13);

                                    FontName.Login_promptCredentials(true);
                                 }
                              }
                           }
                        }
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1902346230"
   )
   static void method1551(String var0, String var1, String var2) {
      class14.method52(7);
      Tile.setLoginResponseString(var0, var1, var2);
   }
}
