import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
   @ObfuscatedName("v")
   @Export("recol")
   public short[] recol;
   @ObfuscatedName("x")
   @Export("retex")
   public short[] retex;

   public ObjTypeCustomisation(int var1) {
      ItemComposition var2 = NPCComposition.ItemDefinition_get(var1);
      if (var2.method1040()) {
         this.recol = new short[var2.recolorTo.length];
         System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
      }

      if (var2.method1038()) {
         this.retex = new short[var2.retextureTo.length];
         System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1790788447"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      VarbitComposition var2 = (VarbitComposition)VarbitComposition.VarbitDefinition_cached.get((long)var0);
      VarbitComposition var1;
      if (var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = VarbitComposition.VarbitDefinition_archive.takeFile(14, var0);
         var2 = new VarbitComposition();
         if (var3 != null) {
            var2.decode(new Buffer(var3));
         }

         VarbitComposition.VarbitDefinition_cached.put(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.baseVar;
      int var4 = var1.startBit;
      int var5 = var1.endBit;
      int var6 = Varps.Varps_masks[var5 - var4];
      return Varps.Varps_main[var7] >> var4 & var6;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lkd;",
      garbageValue = "1101221337"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if (class71.Widget_interfaceComponents[var1] == null || class71.Widget_interfaceComponents[var1][var2] == null) {
         boolean var3 = Players.loadInterface(var1);
         if (!var3) {
            return null;
         }
      }

      return class71.Widget_interfaceComponents[var1][var2];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lan;Lnv;B)V",
      garbageValue = "0"
   )
   @Export("loginScreen")
   static void loginScreen(GameEngine var0, Font var1) {
      int var4;
      int var81;
      int var82;
      if (Login.worldSelectOpen) {
         class201 var80 = Client.keyHandlerInstance;
         class201 var3 = var80;

         while(true) {
            if (!var3.method1087()) {
               if (MouseHandler.MouseHandler_lastButton != 1 && (SceneTilePaint.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
                  break;
               }

               var4 = Login.xPadding + 280;
               if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(0, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(0, 1);
                  break;
               }

               var81 = Login.xPadding + 390;
               if (MouseHandler.MouseHandler_lastPressedX >= var81 && MouseHandler.MouseHandler_lastPressedX <= var81 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(1, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var81 + 15 && MouseHandler.MouseHandler_lastPressedX <= var81 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(1, 1);
                  break;
               }

               var82 = Login.xPadding + 500;
               if (MouseHandler.MouseHandler_lastPressedX >= var82 && MouseHandler.MouseHandler_lastPressedX <= var82 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(2, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var82 + 15 && MouseHandler.MouseHandler_lastPressedX <= var82 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(2, 1);
                  break;
               }

               int var83 = Login.xPadding + 610;
               if (MouseHandler.MouseHandler_lastPressedX >= var83 && MouseHandler.MouseHandler_lastPressedX <= var83 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(3, 0);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= var83 + 15 && MouseHandler.MouseHandler_lastPressedX <= var83 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  class9.changeWorldSelectSorting(3, 1);
                  break;
               }

               if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                  Login.worldSelectOpen = false;
                  SecureRandomCallable.leftTitleSprite.drawAt(Login.xPadding, 0);
                  class9.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
                  Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
                  break;
               }

               if (Login.hoveredWorldIndex != -1) {
                  World var84 = World.World_worlds[Login.hoveredWorldIndex];
                  UserComparator6.changeWorld(var84);
                  Login.worldSelectOpen = false;
                  SecureRandomCallable.leftTitleSprite.drawAt(Login.xPadding, 0);
                  class9.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
                  Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
               } else {
                  if (Login.worldSelectPage > 0 && BufferedNetSocket.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= BufferedNetSocket.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= Language.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Language.canvasHeight / 2 + 50) {
                     --Login.worldSelectPage;
                  }

                  if (Login.worldSelectPage < Login.worldSelectPagesCount && class140.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= CollisionMap.canvasWidth - class140.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= CollisionMap.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= Language.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Language.canvasHeight / 2 + 50) {
                     ++Login.worldSelectPage;
                  }
               }
               break;
            }

            if (var3.field1833 == 13) {
               Login.worldSelectOpen = false;
               SecureRandomCallable.leftTitleSprite.drawAt(Login.xPadding, 0);
               class9.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
               Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
               break;
            }

            if (var3.field1833 == 96) {
               if (Login.worldSelectPage > 0 && BufferedNetSocket.worldSelectLeftSprite != null) {
                  --Login.worldSelectPage;
               }
            } else if (var3.field1833 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class140.worldSelectRightSprite != null) {
               ++Login.worldSelectPage;
            }
         }

      } else {
         if ((MouseHandler.MouseHandler_lastButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            StructComposition.clientPreferences.method556(!StructComposition.clientPreferences.method546());
            if (!StructComposition.clientPreferences.method546()) {
               Archive var2 = class162.archive6;
               int var35 = var2.getGroupId("scape main");
               var4 = var2.getFileId(var35, "");
               class29.method115(var2, var35, var4, 255, false);
            } else {
               class6.method14();
            }
         }

         if (Client.gameState != 5) {
            if (-1L == Login.field745) {
               Login.field745 = Message.method344() + 1000L;
            }

            long var36 = Message.method344();
            if (HitSplatDefinition.method999() && Login.field758 == -1L) {
               Login.field758 = var36;
               if (Login.field758 > Login.field745) {
                  Login.field745 = Login.field758;
               }
            }

            if (Client.gameState == 10 || Client.gameState == 11) {
               if (Language.Language_EN == class173.clientLanguage) {
                  if (MouseHandler.MouseHandler_lastButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var4 = Login.xPadding + 5;
                     short var5 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + var6 && MouseHandler.MouseHandler_lastPressedY >= var5 && MouseHandler.MouseHandler_lastPressedY <= var5 + var7) {
                        WorldMapSection0.method1424();
                        return;
                     }
                  }

                  if (class1.World_request != null) {
                     WorldMapSection0.method1424();
                  }
               }

               var4 = MouseHandler.MouseHandler_lastButton;
               var81 = MouseHandler.MouseHandler_lastPressedX;
               var82 = MouseHandler.MouseHandler_lastPressedY;
               if (var4 == 0) {
                  var81 = MouseHandler.MouseHandler_x;
                  var82 = MouseHandler.MouseHandler_y;
               }

               if (!SceneTilePaint.mouseCam && var4 == 4) {
                  var4 = 1;
               }

               class201 var38 = Client.keyHandlerInstance;
               class201 var8 = var38;
               int var86;
               short var87;
               if (Login.loginIndex == 0) {
                  boolean var95 = false;

                  while(var8.method1087()) {
                     if (var8.field1833 == 84) {
                        var95 = true;
                     }
                  }

                  var86 = UrlRequest.loginBoxCenter - 80;
                  var87 = 291;
                  if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20) {
                     ModeWhere.openURL(ScriptFrame.method330("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var86 = UrlRequest.loginBoxCenter + 80;
                  if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20 || var95) {
                     if ((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        class12.method42(1);
                        SoundSystem.method237();
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
                        class12.method42(1);
                        SoundSystem.method237();
                     } else if ((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        class12.method42(1);
                        SoundSystem.method237();
                     } else {
                        class343.Login_promptCredentials(false);
                     }
                  }
               } else {
                  int var9;
                  short var10;
                  if (Login.loginIndex == 1) {
                     while(true) {
                        if (!var8.method1087()) {
                           var9 = UrlRequest.loginBoxCenter - 80;
                           var10 = 321;
                           if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                              class343.Login_promptCredentials(false);
                           }

                           var9 = UrlRequest.loginBoxCenter + 80;
                           if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                              class12.method42(0);
                           }
                           break;
                        }

                        if (var8.field1833 == 84) {
                           class343.Login_promptCredentials(false);
                        } else if (var8.field1833 == 13) {
                           class12.method42(0);
                        }
                     }
                  } else {
                     int var13;
                     int var14;
                     short var85;
                     if (Login.loginIndex == 2) {
                        var85 = 201;
                        var9 = var85 + 52;
                        if (var4 == 1 && var82 >= var9 - 12 && var82 < var9 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var9 += 15;
                        if (var4 == 1 && var82 >= var9 - 12 && var82 < var9 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var9 += 15;
                        var85 = 361;
                        if (class379.field3654 != null) {
                           var86 = class379.field3654.highX / 2;
                           if (var4 == 1 && var81 >= class379.field3654.lowX - var86 && var81 <= var86 + class379.field3654.lowX && var82 >= var85 - 15 && var82 < var85) {
                              switch(Login.field736) {
                              case 1:
                                 TaskHandler.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 class12.method42(5);
                                 return;
                              case 2:
                                 ModeWhere.openURL("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var86 = UrlRequest.loginBoxCenter - 80;
                        var87 = 321;
                        if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if (Login.Login_username.length() == 0) {
                              TaskHandler.setLoginResponseString("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Login.Login_password.length() == 0) {
                              TaskHandler.setLoginResponseString("", "Please enter your password.", "");
                              return;
                           }

                           TaskHandler.setLoginResponseString("", "Connecting to server...", "");
                           InterfaceParent.method472(false);
                           class140.updateGameState(20);
                           return;
                        }

                        var86 = Login.loginBoxX + 180 + 80;
                        if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20) {
                           class12.method42(0);
                           Login.Login_username = "";
                           Login.Login_password = "";
                           class143.field1321 = 0;
                           class141.otp = "";
                           Login.field738 = true;
                        }

                        var86 = UrlRequest.loginBoxCenter + -117;
                        var87 = 277;
                        Login.field747 = var81 >= var86 && var81 < var86 + class126.field1232 && var82 >= var87 && var82 < var87 + WorldMapSection1.field2393;
                        if (var4 == 1 && Login.field747) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if (!Client.Login_isUsernameRemembered && StructComposition.clientPreferences.method548() != null) {
                              StructComposition.clientPreferences.method547((String)null);
                           }
                        }

                        var86 = UrlRequest.loginBoxCenter + 24;
                        var87 = 277;
                        Login.field762 = var81 >= var86 && var81 < var86 + class126.field1232 && var82 >= var87 && var82 < var87 + WorldMapSection1.field2393;
                        if (var4 == 1 && Login.field762) {
                           StructComposition.clientPreferences.method558(!StructComposition.clientPreferences.method536());
                           if (!StructComposition.clientPreferences.method536()) {
                              Login.Login_username = "";
                              StructComposition.clientPreferences.method547((String)null);
                              SoundSystem.method237();
                           }
                        }

                        while(true) {
                           Transferable var112;
                           do {
                              while(true) {
                                 label1863:
                                 do {
                                    while(true) {
                                       while(var8.method1087()) {
                                          if (var8.field1833 != 13) {
                                             if (Login.currentLoginField != 0) {
                                                continue label1863;
                                             }

                                             char var91 = var8.field1820;

                                             for(var13 = 0; var13 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var91 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var13); ++var13) {
                                                ;
                                             }

                                             if (var8.field1833 == 85 && Login.Login_username.length() > 0) {
                                                Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                             }

                                             if (var8.field1833 == 84 || var8.field1833 == 80) {
                                                Login.currentLoginField = 1;
                                             }

                                             if (class4.method7(var8.field1820) && Login.Login_username.length() < 320) {
                                                Login.Login_username = Login.Login_username + var8.field1820;
                                             }
                                          } else {
                                             class12.method42(0);
                                             Login.Login_username = "";
                                             Login.Login_password = "";
                                             class143.field1321 = 0;
                                             class141.otp = "";
                                             Login.field738 = true;
                                          }
                                       }

                                       return;
                                    }
                                 } while(Login.currentLoginField != 1);

                                 if (var8.field1833 == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 } else if (var8.field1833 == 84 || var8.field1833 == 80) {
                                    Login.currentLoginField = 0;
                                    if (var8.field1833 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          TaskHandler.setLoginResponseString("", "Please enter your username/email address.", "");
                                          return;
                                       }

                                       if (Login.Login_password.length() == 0) {
                                          TaskHandler.setLoginResponseString("", "Please enter your password.", "");
                                          return;
                                       }

                                       TaskHandler.setLoginResponseString("", "Connecting to server...", "");
                                       InterfaceParent.method472(false);
                                       class140.updateGameState(20);
                                       return;
                                    }
                                 }

                                 if ((var8.getKeyPressed(82) || var8.getKeyPressed(87)) && var8.field1833 == 67) {
                                    Clipboard var111 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var112 = var111.getContents(BuddyRankComparator.client);
                                    var14 = 20 - Login.Login_password.length();
                                    break;
                                 }

                                 if (ObjectSound.method415(var8.field1820) && class4.method7(var8.field1820) && Login.Login_password.length() < 20) {
                                    Login.Login_password = Login.Login_password + var8.field1820;
                                 }
                              }
                           } while(var14 <= 0);

                           try {
                              String var93 = (String)var112.getTransferData(DataFlavor.stringFlavor);
                              int var99 = Math.min(var14, var93.length());

                              for(int var94 = 0; var94 < var99; ++var94) {
                                 if (!ObjectSound.method415(var93.charAt(var94)) || !class4.method7(var93.charAt(var94))) {
                                    class12.method42(3);
                                    return;
                                 }
                              }

                              Login.Login_password = Login.Login_password + var93.substring(0, var99);
                           } catch (UnsupportedFlavorException var78) {
                              ;
                           } catch (IOException var79) {
                              ;
                           }
                        }
                     } else if (Login.loginIndex == 3) {
                        var9 = Login.loginBoxX + 180;
                        var10 = 276;
                        if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                           class124.method694(false);
                        }

                        var9 = Login.loginBoxX + 180;
                        var10 = 326;
                        if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                           TaskHandler.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class12.method42(5);
                           return;
                        }
                     } else {
                        int var12;
                        if (Login.loginIndex == 4) {
                           var9 = Login.loginBoxX + 180 - 80;
                           var10 = 321;
                           if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                              class141.otp.trim();
                              if (class141.otp.length() != 6) {
                                 TaskHandler.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class143.field1321 = Integer.parseInt(class141.otp);
                              class141.otp = "";
                              InterfaceParent.method472(true);
                              TaskHandler.setLoginResponseString("", "Connecting to server...", "");
                              class140.updateGameState(20);
                              return;
                           }

                           if (var4 == 1 && var81 >= Login.loginBoxX + 180 - 9 && var81 <= Login.loginBoxX + 180 + 130 && var82 >= 263 && var82 <= 296) {
                              Login.field738 = !Login.field738;
                           }

                           if (var4 == 1 && var81 >= Login.loginBoxX + 180 - 34 && var81 <= Login.loginBoxX + 34 + 180 && var82 >= 351 && var82 <= 363) {
                              ModeWhere.openURL(ScriptFrame.method330("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var9 = Login.loginBoxX + 180 + 80;
                           if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                              class12.method42(0);
                              Login.Login_username = "";
                              Login.Login_password = "";
                              class143.field1321 = 0;
                              class141.otp = "";
                           }

                           while(var8.method1087()) {
                              boolean var11 = false;

                              for(var12 = 0; var12 < "1234567890".length(); ++var12) {
                                 if (var8.field1820 == "1234567890".charAt(var12)) {
                                    var11 = true;
                                    break;
                                 }
                              }

                              if (var8.field1833 == 13) {
                                 class12.method42(0);
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class143.field1321 = 0;
                                 class141.otp = "";
                              } else {
                                 if (var8.field1833 == 85 && class141.otp.length() > 0) {
                                    class141.otp = class141.otp.substring(0, class141.otp.length() - 1);
                                 }

                                 if (var8.field1833 == 84) {
                                    class141.otp.trim();
                                    if (class141.otp.length() != 6) {
                                       TaskHandler.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class143.field1321 = Integer.parseInt(class141.otp);
                                    class141.otp = "";
                                    InterfaceParent.method472(true);
                                    TaskHandler.setLoginResponseString("", "Connecting to server...", "");
                                    class140.updateGameState(20);
                                    return;
                                 }

                                 if (var11 && class141.otp.length() < 6) {
                                    class141.otp = class141.otp + var8.field1820;
                                 }
                              }
                           }
                        } else {
                           int var55;
                           if (Login.loginIndex == 5) {
                              var9 = Login.loginBoxX + 180 - 80;
                              var10 = 321;
                              Buffer var20;
                              int var24;
                              if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                 Login.Login_username = Login.Login_username.trim();
                                 if (Login.Login_username.length() == 0) {
                                    TaskHandler.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 } else {
                                    long var44;
                                    try {
                                       URL var41 = new URL(ScriptFrame.method330("services", false) + "m=accountappeal/login.ws");
                                       URLConnection var15 = var41.openConnection();
                                       var15.setRequestProperty("connection", "close");
                                       var15.setDoInput(true);
                                       var15.setDoOutput(true);
                                       var15.setConnectTimeout(5000);
                                       OutputStreamWriter var114 = new OutputStreamWriter(var15.getOutputStream());
                                       var114.write("data1=req");
                                       var114.flush();
                                       InputStream var116 = var15.getInputStream();
                                       Buffer var96 = new Buffer(new byte[1000]);

                                       while(true) {
                                          int var19 = var116.read(var96.array, var96.offset, 1000 - var96.offset);
                                          if (var19 == -1) {
                                             var96.offset = 0;
                                             long var46 = var96.readLong();
                                             var44 = var46;
                                             break;
                                          }

                                          var96.offset += var19;
                                          if (var96.offset >= 1000) {
                                             var44 = 0L;
                                             break;
                                          }
                                       }
                                    } catch (Exception var71) {
                                       var44 = 0L;
                                    }

                                    byte var88;
                                    if (var44 == 0L) {
                                       var88 = 5;
                                    } else {
                                       String var117 = Login.Login_username;
                                       Random var97 = new Random();
                                       Buffer var120 = new Buffer(128);
                                       var20 = new Buffer(128);
                                       int[] var104 = new int[]{var97.nextInt(), var97.nextInt(), (int)(var44 >> 32), (int)var44};
                                       var120.writeByte(10);

                                       int var22;
                                       for(var22 = 0; var22 < 4; ++var22) {
                                          var120.writeInt(var97.nextInt());
                                       }

                                       var120.writeInt(var104[0]);
                                       var120.writeInt(var104[1]);
                                       var120.writeLong(var44);
                                       var120.writeLong(0L);

                                       for(var22 = 0; var22 < 4; ++var22) {
                                          var120.writeInt(var97.nextInt());
                                       }

                                       var120.encryptRsa(class69.field712, class69.field711);
                                       var20.writeByte(10);

                                       for(var22 = 0; var22 < 3; ++var22) {
                                          var20.writeInt(var97.nextInt());
                                       }

                                       var20.writeLong(var97.nextLong());
                                       var20.writeLongMedium(var97.nextLong());
                                       if (Client.randomDatData != null) {
                                          var20.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
                                       } else {
                                          byte[] var105 = new byte[24];

                                          try {
                                             JagexCache.JagexCache_randomDat.seek(0L);
                                             JagexCache.JagexCache_randomDat.readFully(var105);

                                             for(var24 = 0; var24 < 24 && var105[var24] == 0; ++var24) {
                                                ;
                                             }

                                             if (var24 >= 24) {
                                                throw new IOException();
                                             }
                                          } catch (Exception var70) {
                                             for(int var25 = 0; var25 < 24; ++var25) {
                                                var105[var25] = -1;
                                             }
                                          }

                                          var20.writeBytes(var105, 0, var105.length);
                                       }

                                       var20.writeLong(var97.nextLong());
                                       var20.encryptRsa(class69.field712, class69.field711);
                                       var22 = class13.stringCp1252NullTerminatedByteSize(var117);
                                       if (var22 % 8 != 0) {
                                          var22 += 8 - var22 % 8;
                                       }

                                       Buffer var106 = new Buffer(var22);
                                       var106.writeStringCp1252NullTerminated(var117);
                                       var106.offset = var22;
                                       var106.xteaEncryptAll(var104);
                                       Buffer var51 = new Buffer(var20.offset + var120.offset + var106.offset + 5);
                                       var51.writeByte(2);
                                       var51.writeByte(var120.offset);
                                       var51.writeBytes(var120.array, 0, var120.offset);
                                       var51.writeByte(var20.offset);
                                       var51.writeBytes(var20.array, 0, var20.offset);
                                       var51.writeShort(var106.offset);
                                       var51.writeBytes(var106.array, 0, var106.offset);
                                       String var125 = EnumComposition.method944(var51.array);

                                       byte var16;
                                       try {
                                          URL var107 = new URL(ScriptFrame.method330("services", false) + "m=accountappeal/login.ws");
                                          URLConnection var108 = var107.openConnection();
                                          var108.setDoInput(true);
                                          var108.setDoOutput(true);
                                          var108.setConnectTimeout(5000);
                                          OutputStreamWriter var109 = new OutputStreamWriter(var108.getOutputStream());
                                          var109.write("data2=" + DbTableType.method2313(var125) + "&dest=" + DbTableType.method2313("passwordchoice.ws"));
                                          var109.flush();
                                          InputStream var110 = var108.getInputStream();
                                          var51 = new Buffer(new byte[1000]);

                                          while(true) {
                                             int var30 = var110.read(var51.array, var51.offset, 1000 - var51.offset);
                                             if (var30 == -1) {
                                                var109.close();
                                                var110.close();
                                                String var126 = new String(var51.array);
                                                if (var126.startsWith("OFFLINE")) {
                                                   var16 = 4;
                                                } else if (var126.startsWith("WRONG")) {
                                                   var16 = 7;
                                                } else if (var126.startsWith("RELOAD")) {
                                                   var16 = 3;
                                                } else if (var126.startsWith("Not permitted for social network accounts.")) {
                                                   var16 = 6;
                                                } else {
                                                   var51.xteaDecryptAll(var104);

                                                   while(var51.offset > 0 && var51.array[var51.offset - 1] == 0) {
                                                      --var51.offset;
                                                   }

                                                   var126 = new String(var51.array, 0, var51.offset);
                                                   boolean var31;
                                                   if (var126 == null) {
                                                      var31 = false;
                                                   } else {
                                                      label2026: {
                                                         try {
                                                            new URL(var126);
                                                         } catch (MalformedURLException var68) {
                                                            var31 = false;
                                                            break label2026;
                                                         }

                                                         var31 = true;
                                                      }
                                                   }

                                                   if (var31) {
                                                      ModeWhere.openURL(var126, true, false);
                                                      var16 = 2;
                                                   } else {
                                                      var16 = 5;
                                                   }
                                                }
                                                break;
                                             }

                                             var51.offset += var30;
                                             if (var51.offset >= 1000) {
                                                var16 = 5;
                                                break;
                                             }
                                          }
                                       } catch (Throwable var69) {
                                          var69.printStackTrace();
                                          var16 = 5;
                                       }

                                       var88 = var16;
                                    }

                                    switch(var88) {
                                    case 2:
                                       TaskHandler.setLoginResponseString(Strings.field3357, Strings.field3358, Strings.field3094);
                                       class12.method42(6);
                                       break;
                                    case 3:
                                       TaskHandler.setLoginResponseString("", "Error connecting to server.", "");
                                       break;
                                    case 4:
                                       TaskHandler.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
                                       break;
                                    case 5:
                                       TaskHandler.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
                                       break;
                                    case 6:
                                       TaskHandler.setLoginResponseString("", "Error connecting to server.", "");
                                       break;
                                    case 7:
                                       TaskHandler.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
                                    }
                                 }

                                 return;
                              }

                              var9 = Login.loginBoxX + 180 + 80;
                              if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                 class343.Login_promptCredentials(true);
                              }

                              var87 = 361;
                              if (class151.field1370 != null) {
                                 var12 = class151.field1370.highX / 2;
                                 if (var4 == 1 && var81 >= class151.field1370.lowX - var12 && var81 <= var12 + class151.field1370.lowX && var82 >= var87 - 15 && var82 < var87) {
                                    ModeWhere.openURL(ScriptFrame.method330("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                                 }
                              }

                              while(var8.method1087()) {
                                 boolean var89 = false;

                                 for(var13 = 0; var13 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var13) {
                                    if (var8.field1820 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var13)) {
                                       var89 = true;
                                       break;
                                    }
                                 }

                                 if (var8.field1833 == 13) {
                                    class343.Login_promptCredentials(true);
                                 } else {
                                    if (var8.field1833 == 85 && Login.Login_username.length() > 0) {
                                       Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                    }

                                    if (var8.field1833 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          TaskHandler.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                       } else {
                                          long var48;
                                          try {
                                             URL var42 = new URL(ScriptFrame.method330("services", false) + "m=accountappeal/login.ws");
                                             URLConnection var43 = var42.openConnection();
                                             var43.setRequestProperty("connection", "close");
                                             var43.setDoInput(true);
                                             var43.setDoOutput(true);
                                             var43.setConnectTimeout(5000);
                                             OutputStreamWriter var18 = new OutputStreamWriter(var43.getOutputStream());
                                             var18.write("data1=req");
                                             var18.flush();
                                             InputStream var50 = var43.getInputStream();
                                             var20 = new Buffer(new byte[1000]);

                                             while(true) {
                                                var55 = var50.read(var20.array, var20.offset, 1000 - var20.offset);
                                                if (var55 == -1) {
                                                   var20.offset = 0;
                                                   long var56 = var20.readLong();
                                                   var48 = var56;
                                                   break;
                                                }

                                                var20.offset += var55;
                                                if (var20.offset >= 1000) {
                                                   var48 = 0L;
                                                   break;
                                                }
                                             }
                                          } catch (Exception var75) {
                                             var48 = 0L;
                                          }

                                          byte var90;
                                          if (var48 == 0L) {
                                             var90 = 5;
                                          } else {
                                             String var119 = Login.Login_username;
                                             Random var102 = new Random();
                                             Buffer var21 = new Buffer(128);
                                             Buffer var52 = new Buffer(128);
                                             int[] var23 = new int[]{var102.nextInt(), var102.nextInt(), (int)(var48 >> 32), (int)var48};
                                             var21.writeByte(10);

                                             for(var24 = 0; var24 < 4; ++var24) {
                                                var21.writeInt(var102.nextInt());
                                             }

                                             var21.writeInt(var23[0]);
                                             var21.writeInt(var23[1]);
                                             var21.writeLong(var48);
                                             var21.writeLong(0L);

                                             for(var24 = 0; var24 < 4; ++var24) {
                                                var21.writeInt(var102.nextInt());
                                             }

                                             var21.encryptRsa(class69.field712, class69.field711);
                                             var52.writeByte(10);

                                             for(var24 = 0; var24 < 3; ++var24) {
                                                var52.writeInt(var102.nextInt());
                                             }

                                             var52.writeLong(var102.nextLong());
                                             var52.writeLongMedium(var102.nextLong());
                                             if (Client.randomDatData != null) {
                                                var52.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
                                             } else {
                                                byte[] var53 = new byte[24];

                                                try {
                                                   JagexCache.JagexCache_randomDat.seek(0L);
                                                   JagexCache.JagexCache_randomDat.readFully(var53);

                                                   int var60;
                                                   for(var60 = 0; var60 < 24 && var53[var60] == 0; ++var60) {
                                                      ;
                                                   }

                                                   if (var60 >= 24) {
                                                      throw new IOException();
                                                   }
                                                } catch (Exception var74) {
                                                   for(int var61 = 0; var61 < 24; ++var61) {
                                                      var53[var61] = -1;
                                                   }
                                                }

                                                var52.writeBytes(var53, 0, var53.length);
                                             }

                                             var52.writeLong(var102.nextLong());
                                             var52.encryptRsa(class69.field712, class69.field711);
                                             var24 = class13.stringCp1252NullTerminatedByteSize(var119);
                                             if (var24 % 8 != 0) {
                                                var24 += 8 - var24 % 8;
                                             }

                                             Buffer var124 = new Buffer(var24);
                                             var124.writeStringCp1252NullTerminated(var119);
                                             var124.offset = var24;
                                             var124.xteaEncryptAll(var23);
                                             Buffer var26 = new Buffer(var52.offset + var21.offset + var124.offset + 5);
                                             var26.writeByte(2);
                                             var26.writeByte(var21.offset);
                                             var26.writeBytes(var21.array, 0, var21.offset);
                                             var26.writeByte(var52.offset);
                                             var26.writeBytes(var52.array, 0, var52.offset);
                                             var26.writeShort(var124.offset);
                                             var26.writeBytes(var124.array, 0, var124.offset);
                                             String var27 = EnumComposition.method944(var26.array);

                                             byte var64;
                                             try {
                                                URL var28 = new URL(ScriptFrame.method330("services", false) + "m=accountappeal/login.ws");
                                                URLConnection var29 = var28.openConnection();
                                                var29.setDoInput(true);
                                                var29.setDoOutput(true);
                                                var29.setConnectTimeout(5000);
                                                OutputStreamWriter var54 = new OutputStreamWriter(var29.getOutputStream());
                                                var54.write("data2=" + DbTableType.method2313(var27) + "&dest=" + DbTableType.method2313("passwordchoice.ws"));
                                                var54.flush();
                                                InputStream var62 = var29.getInputStream();
                                                var26 = new Buffer(new byte[1000]);

                                                while(true) {
                                                   int var63 = var62.read(var26.array, var26.offset, 1000 - var26.offset);
                                                   if (var63 == -1) {
                                                      var54.close();
                                                      var62.close();
                                                      String var32 = new String(var26.array);
                                                      if (var32.startsWith("OFFLINE")) {
                                                         var64 = 4;
                                                      } else if (var32.startsWith("WRONG")) {
                                                         var64 = 7;
                                                      } else if (var32.startsWith("RELOAD")) {
                                                         var64 = 3;
                                                      } else if (var32.startsWith("Not permitted for social network accounts.")) {
                                                         var64 = 6;
                                                      } else {
                                                         var26.xteaDecryptAll(var23);

                                                         while(var26.offset > 0 && var26.array[var26.offset - 1] == 0) {
                                                            --var26.offset;
                                                         }

                                                         var32 = new String(var26.array, 0, var26.offset);
                                                         boolean var33;
                                                         if (var32 == null) {
                                                            var33 = false;
                                                         } else {
                                                            label2028: {
                                                               try {
                                                                  new URL(var32);
                                                               } catch (MalformedURLException var72) {
                                                                  var33 = false;
                                                                  break label2028;
                                                               }

                                                               var33 = true;
                                                            }
                                                         }

                                                         if (var33) {
                                                            ModeWhere.openURL(var32, true, false);
                                                            var64 = 2;
                                                         } else {
                                                            var64 = 5;
                                                         }
                                                      }
                                                      break;
                                                   }

                                                   var26.offset += var63;
                                                   if (var26.offset >= 1000) {
                                                      var64 = 5;
                                                      break;
                                                   }
                                                }
                                             } catch (Throwable var73) {
                                                var73.printStackTrace();
                                                var64 = 5;
                                             }

                                             var90 = var64;
                                          }

                                          switch(var90) {
                                          case 2:
                                             TaskHandler.setLoginResponseString(Strings.field3357, Strings.field3358, Strings.field3094);
                                             class12.method42(6);
                                             break;
                                          case 3:
                                             TaskHandler.setLoginResponseString("", "Error connecting to server.", "");
                                             break;
                                          case 4:
                                             TaskHandler.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
                                             break;
                                          case 5:
                                             TaskHandler.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
                                             break;
                                          case 6:
                                             TaskHandler.setLoginResponseString("", "Error connecting to server.", "");
                                             break;
                                          case 7:
                                             TaskHandler.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
                                          }
                                       }

                                       return;
                                    }

                                    if (var89 && Login.Login_username.length() < 320) {
                                       Login.Login_username = Login.Login_username + var8.field1820;
                                    }
                                 }
                              }
                           } else if (Login.loginIndex != 6) {
                              if (Login.loginIndex == 7) {
                                 if (class155.field1380 && !Client.onMobile) {
                                    var9 = UrlRequest.loginBoxCenter - 150;
                                    var86 = var9 + 40 + 240 + 25;
                                    var87 = 231;
                                    var12 = var87 + 40;
                                    if (var4 == 1 && var81 >= var9 && var81 <= var86 && var82 >= var87 && var82 <= var12) {
                                       var14 = var9;
                                       int var65 = 0;

                                       while(true) {
                                          if (var65 >= 8) {
                                             var13 = 0;
                                             break;
                                          }

                                          if (var81 <= var14 + 30) {
                                             var13 = var65;
                                             break;
                                          }

                                          var14 += 30;
                                          var14 += var65 != 1 && var65 != 3 ? 5 : 20;
                                          ++var65;
                                       }

                                       Login.field746 = var13;
                                    }

                                    var13 = Login.loginBoxX + 180 - 80;
                                    short var92 = 321;
                                    boolean var17;
                                    SimpleDateFormat var98;
                                    java.util.Calendar var100;
                                    boolean var101;
                                    String[] var103;
                                    Date var115;
                                    Date var118;
                                    StringBuilder var121;
                                    Date var122;
                                    String var123;
                                    boolean var127;
                                    if (var4 == 1 && var81 >= var13 - 75 && var81 <= var13 + 75 && var82 >= var92 - 20 && var82 <= var92 + 20) {
                                       label1734: {
                                          try {
                                             var98 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                             var98.setLenient(false);
                                             var121 = new StringBuilder();
                                             var103 = Login.field727;
                                             var55 = 0;

                                             while(true) {
                                                if (var55 >= var103.length) {
                                                   var121.append("12");
                                                   var118 = var98.parse(var121.toString());
                                                   break;
                                                }

                                                var123 = var103[var55];
                                                if (var123 == null) {
                                                   Player.method503("Date not valid.", "Please ensure all characters are populated.", "");
                                                   var118 = null;
                                                   break;
                                                }

                                                var121.append(var123);
                                                ++var55;
                                             }

                                             var115 = var118;
                                          } catch (ParseException var77) {
                                             Player.method503("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                             var127 = false;
                                             break label1734;
                                          }

                                          if (var115 == null) {
                                             var127 = false;
                                          } else {
                                             var100 = java.util.Calendar.getInstance();
                                             var100.set(1, var100.get(1) - 13);
                                             var100.set(5, var100.get(5) + 1);
                                             var100.set(11, 0);
                                             var100.set(12, 0);
                                             var100.set(13, 0);
                                             var100.set(14, 0);
                                             var122 = var100.getTime();
                                             var17 = var115.before(var122);
                                             var101 = class410.method2144(var115);
                                             if (!var101) {
                                                Player.method503("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                var127 = false;
                                             } else {
                                                if (!var17) {
                                                   class29.field81 = 8388607;
                                                } else {
                                                   class29.field81 = (int)(var115.getTime() / 86400000L - 11745L);
                                                }

                                                var127 = true;
                                             }
                                          }
                                       }

                                       if (var127) {
                                          class140.updateGameState(50);
                                          return;
                                       }
                                    }

                                    var13 = Login.loginBoxX + 180 + 80;
                                    if (var4 == 1 && var81 >= var13 - 75 && var81 <= var13 + 75 && var82 >= var92 - 20 && var82 <= var92 + 20) {
                                       Login.field727 = new String[8];
                                       class343.Login_promptCredentials(true);
                                    }

                                    while(var8.method1087()) {
                                       if (var8.field1833 == 101) {
                                          Login.field727[Login.field746] = null;
                                       }

                                       if (var8.field1833 == 85) {
                                          if (Login.field727[Login.field746] == null && Login.field746 > 0) {
                                             --Login.field746;
                                          }

                                          Login.field727[Login.field746] = null;
                                       }

                                       if (var8.field1820 >= '0' && var8.field1820 <= '9') {
                                          Login.field727[Login.field746] = "" + var8.field1820;
                                          if (Login.field746 < 7) {
                                             ++Login.field746;
                                          }
                                       }

                                       if (var8.field1833 == 84) {
                                          label1662: {
                                             try {
                                                var98 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                                var98.setLenient(false);
                                                var121 = new StringBuilder();
                                                var103 = Login.field727;
                                                var55 = 0;

                                                while(true) {
                                                   if (var55 < var103.length) {
                                                      var123 = var103[var55];
                                                      if (var123 != null) {
                                                         var121.append(var123);
                                                         ++var55;
                                                         continue;
                                                      }

                                                      Player.method503("Date not valid.", "Please ensure all characters are populated.", "");
                                                      var118 = null;
                                                   } else {
                                                      var121.append("12");
                                                      var118 = var98.parse(var121.toString());
                                                   }

                                                   var115 = var118;
                                                   break;
                                                }
                                             } catch (ParseException var76) {
                                                Player.method503("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                var127 = false;
                                                break label1662;
                                             }

                                             if (var115 == null) {
                                                var127 = false;
                                             } else {
                                                var100 = java.util.Calendar.getInstance();
                                                var100.set(1, var100.get(1) - 13);
                                                var100.set(5, var100.get(5) + 1);
                                                var100.set(11, 0);
                                                var100.set(12, 0);
                                                var100.set(13, 0);
                                                var100.set(14, 0);
                                                var122 = var100.getTime();
                                                var17 = var115.before(var122);
                                                var101 = class410.method2144(var115);
                                                if (!var101) {
                                                   Player.method503("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                   var127 = false;
                                                } else {
                                                   if (!var17) {
                                                      class29.field81 = 8388607;
                                                   } else {
                                                      class29.field81 = (int)(var115.getTime() / 86400000L - 11745L);
                                                   }

                                                   var127 = true;
                                                }
                                             }
                                          }

                                          if (var127) {
                                             class140.updateGameState(50);
                                          }

                                          return;
                                       }
                                    }
                                 } else {
                                    var9 = Login.loginBoxX + 180 - 80;
                                    var10 = 321;
                                    if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                       ModeWhere.openURL(ScriptFrame.method330("secure", true) + "m=dob/set_dob.ws", true, false);
                                       TaskHandler.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                       class12.method42(6);
                                       return;
                                    }

                                    var9 = Login.loginBoxX + 180 + 80;
                                    if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                       class343.Login_promptCredentials(true);
                                    }
                                 }
                              } else if (Login.loginIndex == 8) {
                                 var9 = Login.loginBoxX + 180 - 80;
                                 var10 = 321;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    ModeWhere.openURL("https://www.jagex.com/terms/privacy", true, false);
                                    TaskHandler.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                    class12.method42(6);
                                    return;
                                 }

                                 var9 = Login.loginBoxX + 180 + 80;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    class343.Login_promptCredentials(true);
                                 }
                              } else if (Login.loginIndex == 9) {
                                 var9 = Login.loginBoxX + 180;
                                 var10 = 311;
                                 if (var38.field1833 == 84 || var38.field1833 == 13 || var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    class124.method694(false);
                                 }
                              } else if (Login.loginIndex == 10) {
                                 var9 = Login.loginBoxX + 180;
                                 var10 = 209;
                                 if (var38.field1833 == 84 || var4 == 1 && var81 >= var9 - 109 && var81 <= var9 + 109 && var82 >= var10 && var82 <= var10 + 68) {
                                    TaskHandler.setLoginResponseString("", "Connecting to server...", "");
                                    Client.field485 = class471.field4037;
                                    InterfaceParent.method472(false);
                                    class140.updateGameState(20);
                                 }
                              } else if (Login.loginIndex == 12) {
                                 var9 = UrlRequest.loginBoxCenter;
                                 var10 = 233;
                                 Bounds var66 = var1.method1964(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
                                 Bounds var39 = var1.method1964(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
                                 Bounds var40 = var1.method1964(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
                                 var86 = var10 + 17;
                                 Bounds var113 = var1.method1964(0, 34, "<col=ffd200>agreement (EULA)</col>.", var9, var86);
                                 if (var4 == 1) {
                                    if (var66.method2116(var81, var82)) {
                                       ModeWhere.openURL("https://www.jagex.com/terms", true, false);
                                    } else if (var39.method2116(var81, var82)) {
                                       ModeWhere.openURL("https://www.jagex.com/terms/privacy", true, false);
                                    } else if (var40.method2116(var81, var82) || var113.method2116(var81, var82)) {
                                       ModeWhere.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
                                    }
                                 }

                                 var9 = UrlRequest.loginBoxCenter - 80;
                                 var10 = 311;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    WorldMapData_0.method1303();
                                    class124.method694(true);
                                 }

                                 var9 = UrlRequest.loginBoxCenter + 80;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    Login.loginIndex = 13;
                                 }
                              } else if (Login.loginIndex == 13) {
                                 var9 = UrlRequest.loginBoxCenter;
                                 var10 = 321;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    class124.method694(true);
                                 }
                              } else if (Login.loginIndex == 14) {
                                 String var67 = "";
                                 switch(Login.field732) {
                                 case 0:
                                    var67 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                    break;
                                 case 1:
                                    var67 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                    break;
                                 case 2:
                                    var67 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
                                    break;
                                 default:
                                    class343.Login_promptCredentials(false);
                                 }

                                 var86 = Login.loginBoxX + 180;
                                 var87 = 276;
                                 if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20) {
                                    ModeWhere.openURL(var67, true, false);
                                    TaskHandler.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                    class12.method42(6);
                                    return;
                                 }

                                 var86 = Login.loginBoxX + 180;
                                 var87 = 326;
                                 if (var4 == 1 && var81 >= var86 - 75 && var81 <= var86 + 75 && var82 >= var87 - 20 && var82 <= var87 + 20) {
                                    class343.Login_promptCredentials(false);
                                 }
                              } else if (Login.loginIndex == 24) {
                                 var9 = Login.loginBoxX + 180;
                                 var10 = 301;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    class124.method694(false);
                                 }
                              } else if (Login.loginIndex == 26) {
                                 var9 = Login.loginBoxX + 180 - 80;
                                 var10 = 321;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    ModeWhere.openURL(ScriptFrame.method330("secure", true) + "m=dob/set_dob.ws", true, false);
                                    TaskHandler.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                    class12.method42(6);
                                    return;
                                 }

                                 var9 = Login.loginBoxX + 180 + 80;
                                 if (var4 == 1 && var81 >= var9 - 75 && var81 <= var9 + 75 && var82 >= var10 - 20 && var82 <= var10 + 20) {
                                    class343.Login_promptCredentials(true);
                                 }
                              }
                           } else {
                              while(true) {
                                 do {
                                    if (!var8.method1087()) {
                                       var85 = 321;
                                       if (var4 == 1 && var82 >= var85 - 20 && var82 <= var85 + 20) {
                                          class343.Login_promptCredentials(true);
                                       }

                                       return;
                                    }
                                 } while(var8.field1833 != 84 && var8.field1833 != 13);

                                 class343.Login_promptCredentials(true);
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
