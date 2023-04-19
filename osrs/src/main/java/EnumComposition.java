import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
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

@ObfuscatedName("hx")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive EnumDefinition_archive;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("ay")
   static int field1536;
    @ObfuscatedName("aw")
    public char inputType;
    @ObfuscatedName("ac")
    public char outputType;
    @ObfuscatedName("au")
    public String defaultStr = "null";
    @ObfuscatedName("ab")
    public int defaultInt;
    @ObfuscatedName("aq")
    public int outputCount = 0;
    @ObfuscatedName("al")
    public int[] keys;
    @ObfuscatedName("at")
    public int[] intVals;
    @ObfuscatedName("aa")
    public String[] strVals;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)V",
            garbageValue = "1"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Lsg;II)V",
            garbageValue = "-1230554018"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1771733315"
    )
    public int size() {
      return this.outputCount;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;B)V",
      garbageValue = "42"
   )
   public static void method1010(AbstractArchive var0) {
      FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lro;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2050135786"
   )
   static String method1014(IterableNodeHashTable var0, int var1, String var2) {
      if (var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null ? var2 : (String)var3.obj;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lbm;Lon;Lon;I)V",
      garbageValue = "1210826213"
   )
   static void method1016(GameEngine var0, Font var1, Font var2) {
      if (Login.worldSelectOpen) {
         class33.method151(var0);
      } else {
         if ((MouseHandler.MouseHandler_lastButton == 1 || !class473.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            class20.clientPreferences.getTitleMusicDisabled(!class20.clientPreferences.getTitleMusicDisabled());
            if (!class20.clientPreferences.getTitleMusicDisabled()) {
               class478.method2438(class399.archive6, "scape main", "", 255, false);
            } else {
               FloorUnderlayDefinition.method1050();
            }
         }

         if (Client.gameState != 5) {
            if (-1L == Login.field734) {
               Login.field734 = class96.clockNow() + 1000L;
            }

            long var3 = class96.clockNow();
            boolean var5;
            if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
               while(true) {
                  if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
                     var5 = true;
                     break;
                  }

                  ArchiveLoader var6 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
                  if (!var6.isLoaded()) {
                     var5 = false;
                     break;
                  }

                  ++Client.archiveLoadersDone;
               }
            } else {
               var5 = true;
            }

            if (var5 && -1L == Login.field759) {
               Login.field759 = var3;
               if (Login.field759 > Login.field734) {
                  Login.field734 = Login.field759;
               }
            }

            if (Client.gameState == 10 || Client.gameState == 11) {
               int var33;
               if (ClanSettings.clientLanguage == Language.Language_EN) {
                  if (MouseHandler.MouseHandler_lastButton == 1 || !class473.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var33 = Login.xPadding + 5;
                     short var7 = 463;
                     byte var8 = 100;
                     byte var9 = 35;
                     if (MouseHandler.MouseHandler_lastPressedX >= var33 && MouseHandler.MouseHandler_lastPressedX <= var33 + var8 && MouseHandler.MouseHandler_lastPressedY >= var7 && MouseHandler.MouseHandler_lastPressedY <= var7 + var9) {
                        Login.method446();
                        return;
                     }
                  }

                  if (class11.World_request != null) {
                     Login.method446();
                  }
               }

               var33 = MouseHandler.MouseHandler_lastButton;
               int var60 = MouseHandler.MouseHandler_lastPressedX;
               int var61 = MouseHandler.MouseHandler_lastPressedY;
               if (var33 == 0) {
                  var60 = MouseHandler.MouseHandler_x;
                  var61 = MouseHandler.MouseHandler_y;
               }

               if (!class473.mouseCam && var33 == 4) {
                  var33 = 1;
               }

               class207 var34 = Client.keyHandlerInstance;
               class207 var10 = var34;
               short var63;
               int var64;
               if (Login.loginIndex == 0) {
                  boolean var76 = false;

                  while(var10.method1154()) {
                     if (var10.field1867 == 84) {
                        var76 = true;
                     }
                  }

                  var64 = class143.loginBoxCenter - 80;
                  var63 = 291;
                  if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20) {
                     Ignored.openURL(InvDefinition.method977("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var64 = class143.loginBoxCenter + 80;
                  if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20 || var76) {
                     if ((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        class129.method763(1);
                        if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
                           Login.currentLoginField = 1;
                        } else {
                           Login.currentLoginField = 0;
                        }
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
                        class129.method763(1);
                        if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
                           Login.currentLoginField = 1;
                        } else {
                           Login.currentLoginField = 0;
                        }
                     } else if ((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        class129.method763(1);
                        if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
                           Login.currentLoginField = 1;
                        } else {
                           Login.currentLoginField = 0;
                        }
                     } else {
                        class6.Login_promptCredentials(false);
                     }
                  }
               } else {
                  int var11;
                  short var12;
                  if (Login.loginIndex == 1) {
                     while(true) {
                        if (!var10.method1154()) {
                           var11 = class143.loginBoxCenter - 80;
                           var12 = 321;
                           if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                              class6.Login_promptCredentials(false);
                           }

                           var11 = class143.loginBoxCenter + 80;
                           if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                              class129.method763(0);
                           }
                           break;
                        }

                        if (var10.field1867 == 84) {
                           class6.Login_promptCredentials(false);
                        } else if (var10.field1867 == 13) {
                           class129.method763(0);
                        }
                     }
                  } else {
                     int var15;
                     String var17;
                     boolean var20;
                     short var62;
                     boolean var66;
                     int var69;
                     if (Login.loginIndex == 2) {
                        var62 = 201;
                        var11 = var62 + 52;
                        if (var33 == 1 && var61 >= var11 - 12 && var61 < var11 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var11 += 15;
                        if (var33 == 1 && var61 >= var11 - 12 && var61 < var11 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var11 += 15;
                        var62 = 361;
                        if (class96.field1063 != null) {
                           var64 = class96.field1063.highX / 2;
                           if (var33 == 1 && var60 >= class96.field1063.lowX - var64 && var60 <= var64 + class96.field1063.lowX && var61 >= var62 - 15 && var61 < var62) {
                              switch(Login.field752) {
                              case 1:
                                 class205.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 class129.method763(5);
                                 return;
                              case 2:
                                 Ignored.openURL("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var64 = class143.loginBoxCenter - 80;
                        var63 = 321;
                        if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if (Login.Login_username.length() == 0) {
                              class205.setLoginResponseString("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Login.Login_password.length() == 0) {
                              class205.setLoginResponseString("", "Please enter your password.", "");
                              return;
                           }

                           class205.setLoginResponseString("", "Connecting to server...", "");
                           class14.method53(false);
                           class138.updateGameState(20);
                           return;
                        }

                        var64 = Login.loginBoxX + 180 + 80;
                        if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20) {
                           class129.method763(0);
                           Login.Login_username = "";
                           Login.Login_password = "";
                           class204.field1846 = 0;
                           Messages.otp = "";
                           Login.field751 = true;
                        }

                        var64 = class143.loginBoxCenter + -117;
                        var63 = 277;
                        Login.field730 = var60 >= var64 && var60 < var64 + ChatChannel.field817 && var61 >= var63 && var61 < var63 + FloorUnderlayDefinition.field1642;
                        if (var33 == 1 && Login.field730) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if (!Client.Login_isUsernameRemembered && class20.clientPreferences.getUsernameToRemember() != null) {
                              class20.clientPreferences.setUsernameToRemember((String)null);
                           }
                        }

                        var64 = class143.loginBoxCenter + 24;
                        var63 = 277;
                        Login.field740 = var60 >= var64 && var60 < var64 + ChatChannel.field817 && var61 >= var63 && var61 < var63 + FloorUnderlayDefinition.field1642;
                        if (var33 == 1 && Login.field740) {
                           class20.clientPreferences.setIsUsernameHidden(!class20.clientPreferences.getIsUsernameHidden());
                           if (!class20.clientPreferences.getIsUsernameHidden()) {
                              Login.Login_username = "";
                              class20.clientPreferences.setUsernameToRemember((String)null);
                              if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
                                 Login.currentLoginField = 1;
                              } else {
                                 Login.currentLoginField = 0;
                              }
                           }
                        }

                        label1653:
                        while(true) {
                           Transferable var85;
                           do {
                              while(true) {
                                 label1617:
                                 do {
                                    while(true) {
                                       while(var10.method1154()) {
                                          if (var10.field1867 != 13) {
                                             if (Login.currentLoginField != 0) {
                                                continue label1617;
                                             }

                                             char var68 = var10.field1866;

                                             for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var68 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15); ++var15) {
                                                ;
                                             }

                                             if (var10.field1867 == 85 && Login.Login_username.length() > 0) {
                                                Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                             }

                                             if (var10.field1867 == 84 || var10.field1867 == 80) {
                                                Login.currentLoginField = 1;
                                             }

                                             char var74 = var10.field1866;
                                             boolean var70 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var74) != -1;
                                             if (var70 && Login.Login_username.length() < 320) {
                                                Login.Login_username = Login.Login_username + var10.field1866;
                                             }
                                          } else {
                                             class129.method763(0);
                                             Login.Login_username = "";
                                             Login.Login_password = "";
                                             class204.field1846 = 0;
                                             Messages.otp = "";
                                             Login.field751 = true;
                                          }
                                       }

                                       return;
                                    }
                                 } while(Login.currentLoginField != 1);

                                 if (var10.field1867 == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 } else if (var10.field1867 == 84 || var10.field1867 == 80) {
                                    Login.currentLoginField = 0;
                                    if (var10.field1867 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          class205.setLoginResponseString("", "Please enter your username/email address.", "");
                                          return;
                                       }

                                       if (Login.Login_password.length() == 0) {
                                          class205.setLoginResponseString("", "Please enter your password.", "");
                                          return;
                                       }

                                       class205.setLoginResponseString("", "Connecting to server...", "");
                                       class14.method53(false);
                                       class138.updateGameState(20);
                                       return;
                                    }
                                 }

                                 if ((var10.getKeyPressed(82) || var10.getKeyPressed(87)) && var10.field1867 == 67) {
                                    Clipboard var84 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var85 = var84.getContents(ScriptFrame.client);
                                    var69 = 20 - Login.Login_password.length();
                                    break;
                                 }

                                 if (MouseHandler.method195(var10.field1866)) {
                                    char var71 = var10.field1866;
                                    var66 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var71) != -1;
                                    if (var66 && Login.Login_password.length() < 20) {
                                       Login.Login_password = Login.Login_password + var10.field1866;
                                    }
                                 }
                              }
                           } while(var69 <= 0);

                           try {
                              var17 = (String)var85.getTransferData(DataFlavor.stringFlavor);
                              int var75 = Math.min(var69, var17.length());
                              int var72 = 0;

                              while(true) {
                                 if (var72 >= var75) {
                                    Login.Login_password = Login.Login_password + var17.substring(0, var75);
                                    continue label1653;
                                 }

                                 if (!MouseHandler.method195(var17.charAt(var72))) {
                                    break;
                                 }

                                 char var21 = var17.charAt(var72);
                                 var20 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var21) != -1;
                                 if (!var20) {
                                    break;
                                 }

                                 ++var72;
                              }

                              class129.method763(3);
                              return;
                           } catch (UnsupportedFlavorException var58) {
                              ;
                           } catch (IOException var59) {
                              ;
                           }
                        }
                     } else {
                        Bounds var37;
                        if (Login.loginIndex == 3) {
                           var11 = Login.loginBoxX + 180;
                           var12 = 241;
                           var37 = var1.method2051(25, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.".length() - 34, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", var11, var12);
                           if (var33 == 1 && var37.method2232(var60, var61)) {
                              Ignored.openURL("https://oldschool.runescape.com/launcher", true, false);
                           }

                           var11 = Login.loginBoxX + 180;
                           var12 = 276;
                           if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                              Login.method444(false);
                           }

                           var11 = Login.loginBoxX + 180;
                           var12 = 326;
                           if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                              class205.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                              class129.method763(5);
                              return;
                           }
                        } else {
                           int var14;
                           if (Login.loginIndex == 4) {
                              var11 = Login.loginBoxX + 180 - 80;
                              var12 = 321;
                              if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                 Messages.otp.trim();
                                 if (Messages.otp.length() != 6) {
                                    class205.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 class204.field1846 = Integer.parseInt(Messages.otp);
                                 Messages.otp = "";
                                 class14.method53(true);
                                 class205.setLoginResponseString("", "Connecting to server...", "");
                                 class138.updateGameState(20);
                                 return;
                              }

                              if (var33 == 1 && var60 >= Login.loginBoxX + 180 - 9 && var60 <= Login.loginBoxX + 180 + 130 && var61 >= 263 && var61 <= 296) {
                                 Login.field751 = !Login.field751;
                              }

                              if (var33 == 1 && var60 >= Login.loginBoxX + 180 - 34 && var60 <= Login.loginBoxX + 34 + 180 && var61 >= 351 && var61 <= 363) {
                                 Ignored.openURL(InvDefinition.method977("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                              }

                              var11 = Login.loginBoxX + 180 + 80;
                              if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                 class129.method763(0);
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class204.field1846 = 0;
                                 Messages.otp = "";
                              }

                              while(var10.method1154()) {
                                 boolean var13 = false;

                                 for(var14 = 0; var14 < "1234567890".length(); ++var14) {
                                    if (var10.field1866 == "1234567890".charAt(var14)) {
                                       var13 = true;
                                       break;
                                    }
                                 }

                                 if (var10.field1867 == 13) {
                                    class129.method763(0);
                                    Login.Login_username = "";
                                    Login.Login_password = "";
                                    class204.field1846 = 0;
                                    Messages.otp = "";
                                 } else {
                                    if (var10.field1867 == 85 && Messages.otp.length() > 0) {
                                       Messages.otp = Messages.otp.substring(0, Messages.otp.length() - 1);
                                    }

                                    if (var10.field1867 == 84) {
                                       Messages.otp.trim();
                                       if (Messages.otp.length() != 6) {
                                          class205.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                          return;
                                       }

                                       class204.field1846 = Integer.parseInt(Messages.otp);
                                       Messages.otp = "";
                                       class14.method53(true);
                                       class205.setLoginResponseString("", "Connecting to server...", "");
                                       class138.updateGameState(20);
                                       return;
                                    }

                                    if (var13 && Messages.otp.length() < 6) {
                                       Messages.otp = Messages.otp + var10.field1866;
                                    }
                                 }
                              }
                           } else if (Login.loginIndex == 5) {
                              var11 = Login.loginBoxX + 180 - 80;
                              var12 = 321;
                              if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                 Login.Login_username = Login.Login_username.trim();
                                 if (Login.Login_username.length() == 0) {
                                    class205.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 } else {
                                    long var38 = class264.method1531();
                                    byte var65;
                                    if (var38 == 0L) {
                                       var65 = 5;
                                    } else {
                                       var17 = Login.Login_username;
                                       Random var40 = new Random();
                                       Buffer var87 = new Buffer(128);
                                       Buffer var89 = new Buffer(128);
                                       int[] var91 = new int[]{var40.nextInt(), var40.nextInt(), (int)(var38 >> 32), (int)var38};
                                       var87.writeByte(10);

                                       int var22;
                                       for(var22 = 0; var22 < 4; ++var22) {
                                          var87.writeInt(var40.nextInt());
                                       }

                                       var87.writeInt(var91[0]);
                                       var87.writeInt(var91[1]);
                                       var87.writeLong(var38);
                                       var87.writeLong(0L);

                                       for(var22 = 0; var22 < 4; ++var22) {
                                          var87.writeInt(var40.nextInt());
                                       }

                                       var87.encryptRsa(class68.field717, class68.field716);
                                       var89.writeByte(10);

                                       for(var22 = 0; var22 < 3; ++var22) {
                                          var89.writeInt(var40.nextInt());
                                       }

                                       var89.writeLong(var40.nextLong());
                                       var89.writeLongMedium(var40.nextLong());
                                       class383.method2086(var89);
                                       var89.writeLong(var40.nextLong());
                                       var89.encryptRsa(class68.field717, class68.field716);
                                       var22 = DynamicObject.stringCp1252NullTerminatedByteSize(var17);
                                       if (var22 % 8 != 0) {
                                          var22 += 8 - var22 % 8;
                                       }

                                       Buffer var77 = new Buffer(var22);
                                       var77.writeStringCp1252NullTerminated(var17);
                                       var77.offset = var22;
                                       var77.xteaEncryptAll(var91);
                                       Buffer var24 = new Buffer(var77.offset + var89.offset + var87.offset + 5);
                                       var24.writeByte(2);
                                       var24.writeByte(var87.offset);
                                       var24.writeBytes(var87.array, 0, var87.offset);
                                       var24.writeByte(var89.offset);
                                       var24.writeBytes(var89.array, 0, var89.offset);
                                       var24.writeShort(var77.offset);
                                       var24.writeBytes(var77.array, 0, var77.offset);
                                       String var79 = WorldMapSectionType.method1510(var24.array);

                                       byte var16;
                                       try {
                                          URL var80 = new URL(InvDefinition.method977("services", false) + "m=accountappeal/login.ws");
                                          URLConnection var81 = var80.openConnection();
                                          var81.setDoInput(true);
                                          var81.setDoOutput(true);
                                          var81.setConnectTimeout(5000);
                                          OutputStreamWriter var82 = new OutputStreamWriter(var81.getOutputStream());
                                          var82.write("data2=" + class397.method2120(var79) + "&dest=" + class397.method2120("passwordchoice.ws"));
                                          var82.flush();
                                          InputStream var83 = var81.getInputStream();
                                          var24 = new Buffer(new byte[1000]);

                                          while(true) {
                                             int var30 = var83.read(var24.array, var24.offset, 1000 - var24.offset);
                                             if (var30 == -1) {
                                                var82.close();
                                                var83.close();
                                                String var94 = new String(var24.array);
                                                if (var94.startsWith("OFFLINE")) {
                                                   var16 = 4;
                                                } else if (var94.startsWith("WRONG")) {
                                                   var16 = 7;
                                                } else if (var94.startsWith("RELOAD")) {
                                                   var16 = 3;
                                                } else if (var94.startsWith("Not permitted for social network accounts.")) {
                                                   var16 = 6;
                                                } else {
                                                   var24.xteaDecryptAll(var91);

                                                   while(var24.offset > 0 && var24.array[var24.offset - 1] == 0) {
                                                      --var24.offset;
                                                   }

                                                   var94 = new String(var24.array, 0, var24.offset);
                                                   if (AttackOption.method619(var94)) {
                                                      Ignored.openURL(var94, true, false);
                                                      var16 = 2;
                                                   } else {
                                                      var16 = 5;
                                                   }
                                                }
                                                break;
                                             }

                                             var24.offset += var30;
                                             if (var24.offset >= 1000) {
                                                var16 = 5;
                                                break;
                                             }
                                          }
                                       } catch (Throwable var54) {
                                          var54.printStackTrace();
                                          var16 = 5;
                                       }

                                       var65 = var16;
                                    }

                                    switch(var65) {
                                    case 2:
                                       class205.setLoginResponseString(Strings.field3267, Strings.field3291, Strings.field3376);
                                       class129.method763(6);
                                       break;
                                    case 3:
                                       class205.setLoginResponseString("", "Error connecting to server.", "");
                                       break;
                                    case 4:
                                       class205.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
                                       break;
                                    case 5:
                                       class205.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
                                       break;
                                    case 6:
                                       class205.setLoginResponseString("", "Error connecting to server.", "");
                                       break;
                                    case 7:
                                       class205.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
                                    }
                                 }

                                 return;
                              }

                              var11 = Login.loginBoxX + 180 + 80;
                              if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                 class6.Login_promptCredentials(true);
                              }

                              var63 = 361;
                              if (class19.field60 != null) {
                                 var14 = class19.field60.highX / 2;
                                 if (var33 == 1 && var60 >= class19.field60.lowX - var14 && var60 <= var14 + class19.field60.lowX && var61 >= var63 - 15 && var61 < var63) {
                                    Ignored.openURL(InvDefinition.method977("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                                 }
                              }

                              while(var10.method1154()) {
                                 var66 = false;

                                 for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var15) {
                                    if (var10.field1866 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15)) {
                                       var66 = true;
                                       break;
                                    }
                                 }

                                 if (var10.field1867 == 13) {
                                    class6.Login_promptCredentials(true);
                                 } else {
                                    if (var10.field1867 == 85 && Login.Login_username.length() > 0) {
                                       Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                    }

                                    if (var10.field1867 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          class205.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                       } else {
                                          long var45 = class264.method1531();
                                          byte var67;
                                          if (var45 == 0L) {
                                             var67 = 5;
                                          } else {
                                             String var41 = Login.Login_username;
                                             Random var42 = new Random();
                                             Buffer var43 = new Buffer(128);
                                             Buffer var47 = new Buffer(128);
                                             int[] var23 = new int[]{var42.nextInt(), var42.nextInt(), (int)(var45 >> 32), (int)var45};
                                             var43.writeByte(10);

                                             int var48;
                                             for(var48 = 0; var48 < 4; ++var48) {
                                                var43.writeInt(var42.nextInt());
                                             }

                                             var43.writeInt(var23[0]);
                                             var43.writeInt(var23[1]);
                                             var43.writeLong(var45);
                                             var43.writeLong(0L);

                                             for(var48 = 0; var48 < 4; ++var48) {
                                                var43.writeInt(var42.nextInt());
                                             }

                                             var43.encryptRsa(class68.field717, class68.field716);
                                             var47.writeByte(10);

                                             for(var48 = 0; var48 < 3; ++var48) {
                                                var47.writeInt(var42.nextInt());
                                             }

                                             var47.writeLong(var42.nextLong());
                                             var47.writeLongMedium(var42.nextLong());
                                             class383.method2086(var47);
                                             var47.writeLong(var42.nextLong());
                                             var47.encryptRsa(class68.field717, class68.field716);
                                             var48 = DynamicObject.stringCp1252NullTerminatedByteSize(var41);
                                             if (var48 % 8 != 0) {
                                                var48 += 8 - var48 % 8;
                                             }

                                             Buffer var25 = new Buffer(var48);
                                             var25.writeStringCp1252NullTerminated(var41);
                                             var25.offset = var48;
                                             var25.xteaEncryptAll(var23);
                                             Buffer var26 = new Buffer(var43.offset + var47.offset + var25.offset + 5);
                                             var26.writeByte(2);
                                             var26.writeByte(var43.offset);
                                             var26.writeBytes(var43.array, 0, var43.offset);
                                             var26.writeByte(var47.offset);
                                             var26.writeBytes(var47.array, 0, var47.offset);
                                             var26.writeShort(var25.offset);
                                             var26.writeBytes(var25.array, 0, var25.offset);
                                             String var27 = WorldMapSectionType.method1510(var26.array);

                                             byte var18;
                                             try {
                                                URL var28 = new URL(InvDefinition.method977("services", false) + "m=accountappeal/login.ws");
                                                URLConnection var29 = var28.openConnection();
                                                var29.setDoInput(true);
                                                var29.setDoOutput(true);
                                                var29.setConnectTimeout(5000);
                                                OutputStreamWriter var44 = new OutputStreamWriter(var29.getOutputStream());
                                                var44.write("data2=" + class397.method2120(var27) + "&dest=" + class397.method2120("passwordchoice.ws"));
                                                var44.flush();
                                                InputStream var31 = var29.getInputStream();
                                                var26 = new Buffer(new byte[1000]);

                                                while(true) {
                                                   int var32 = var31.read(var26.array, var26.offset, 1000 - var26.offset);
                                                   if (var32 == -1) {
                                                      var44.close();
                                                      var31.close();
                                                      String var49 = new String(var26.array);
                                                      if (var49.startsWith("OFFLINE")) {
                                                         var18 = 4;
                                                      } else if (var49.startsWith("WRONG")) {
                                                         var18 = 7;
                                                      } else if (var49.startsWith("RELOAD")) {
                                                         var18 = 3;
                                                      } else if (var49.startsWith("Not permitted for social network accounts.")) {
                                                         var18 = 6;
                                                      } else {
                                                         var26.xteaDecryptAll(var23);

                                                         while(var26.offset > 0 && var26.array[var26.offset - 1] == 0) {
                                                            --var26.offset;
                                                         }

                                                         var49 = new String(var26.array, 0, var26.offset);
                                                         if (AttackOption.method619(var49)) {
                                                            Ignored.openURL(var49, true, false);
                                                            var18 = 2;
                                                         } else {
                                                            var18 = 5;
                                                         }
                                                      }
                                                      break;
                                                   }

                                                   var26.offset += var32;
                                                   if (var26.offset >= 1000) {
                                                      var18 = 5;
                                                      break;
                                                   }
                                                }
                                             } catch (Throwable var55) {
                                                var55.printStackTrace();
                                                var18 = 5;
                                             }

                                             var67 = var18;
                                          }

                                          switch(var67) {
                                          case 2:
                                             class205.setLoginResponseString(Strings.field3267, Strings.field3291, Strings.field3376);
                                             class129.method763(6);
                                             break;
                                          case 3:
                                             class205.setLoginResponseString("", "Error connecting to server.", "");
                                             break;
                                          case 4:
                                             class205.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
                                             break;
                                          case 5:
                                             class205.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
                                             break;
                                          case 6:
                                             class205.setLoginResponseString("", "Error connecting to server.", "");
                                             break;
                                          case 7:
                                             class205.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
                                          }
                                       }

                                       return;
                                    }

                                    if (var66 && Login.Login_username.length() < 320) {
                                       Login.Login_username = Login.Login_username + var10.field1866;
                                    }
                                 }
                              }
                           } else if (Login.loginIndex != 6) {
                              if (Login.loginIndex == 7) {
                                 if (WorldMapSectionType.field2384 && !Client.onMobile) {
                                    var11 = class143.loginBoxCenter - 150;
                                    var64 = var11 + 40 + 240 + 25;
                                    var63 = 231;
                                    var14 = var63 + 40;
                                    if (var33 == 1 && var60 >= var11 && var60 <= var64 && var61 >= var63 && var61 <= var14) {
                                       var69 = var11;
                                       int var50 = 0;

                                       while(true) {
                                          if (var50 >= 8) {
                                             var15 = 0;
                                             break;
                                          }

                                          if (var60 <= var69 + 30) {
                                             var15 = var50;
                                             break;
                                          }

                                          var69 += 30;
                                          var69 += var50 != 1 && var50 != 3 ? 5 : 20;
                                          ++var50;
                                       }

                                       Login.field747 = var15;
                                    }

                                    var15 = Login.loginBoxX + 180 - 80;
                                    short var73 = 321;
                                    boolean var19;
                                    int var51;
                                    String var78;
                                    Date var86;
                                    Date var88;
                                    SimpleDateFormat var90;
                                    StringBuilder var92;
                                    Date var93;
                                    String[] var95;
                                    boolean var96;
                                    if (var33 == 1 && var60 >= var15 - 75 && var60 <= var15 + 75 && var61 >= var73 - 20 && var61 <= var73 + 20) {
                                       label1469: {
                                          try {
                                             var90 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                             var90.setLenient(false);
                                             var92 = new StringBuilder();
                                             var95 = Login.field748;
                                             var51 = 0;

                                             while(true) {
                                                if (var51 >= var95.length) {
                                                   var92.append("12");
                                                   var88 = var90.parse(var92.toString());
                                                   break;
                                                }

                                                var78 = var95[var51];
                                                if (var78 == null) {
                                                   WorldMapRectangle.method1522("Date not valid.", "Please ensure all characters are populated.", "");
                                                   var88 = null;
                                                   break;
                                                }

                                                var92.append(var78);
                                                ++var51;
                                             }

                                             var86 = var88;
                                          } catch (ParseException var57) {
                                             WorldMapRectangle.method1522("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                             var96 = false;
                                             break label1469;
                                          }

                                          if (var86 == null) {
                                             var96 = false;
                                          } else {
                                             var19 = class81.method483(var86);
                                             var93 = Varcs.method651();
                                             var20 = var86.after(var93);
                                             if (!var20) {
                                                WorldMapRectangle.method1522("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                var96 = false;
                                             } else {
                                                if (!var19) {
                                                   ByteArrayPool.field3668 = 8388607;
                                                } else {
                                                   ByteArrayPool.field3668 = (int)(var86.getTime() / 86400000L - 11745L);
                                                }

                                                var96 = true;
                                             }
                                          }
                                       }

                                       if (var96) {
                                          class138.updateGameState(50);
                                          return;
                                       }
                                    }

                                    var15 = Login.loginBoxX + 180 + 80;
                                    if (var33 == 1 && var60 >= var15 - 75 && var60 <= var15 + 75 && var61 >= var73 - 20 && var61 <= var73 + 20) {
                                       Login.field748 = new String[8];
                                       class6.Login_promptCredentials(true);
                                    }

                                    while(var10.method1154()) {
                                       if (var10.field1867 == 101) {
                                          Login.field748[Login.field747] = null;
                                       }

                                       if (var10.field1867 == 85) {
                                          if (Login.field748[Login.field747] == null && Login.field747 > 0) {
                                             --Login.field747;
                                          }

                                          Login.field748[Login.field747] = null;
                                       }

                                       if (var10.field1866 >= '0' && var10.field1866 <= '9') {
                                          Login.field748[Login.field747] = "" + var10.field1866;
                                          if (Login.field747 < 7) {
                                             ++Login.field747;
                                          }
                                       }

                                       if (var10.field1867 == 84) {
                                          label1397: {
                                             try {
                                                var90 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
                                                var90.setLenient(false);
                                                var92 = new StringBuilder();
                                                var95 = Login.field748;
                                                var51 = 0;

                                                while(true) {
                                                   if (var51 < var95.length) {
                                                      var78 = var95[var51];
                                                      if (var78 != null) {
                                                         var92.append(var78);
                                                         ++var51;
                                                         continue;
                                                      }

                                                      WorldMapRectangle.method1522("Date not valid.", "Please ensure all characters are populated.", "");
                                                      var88 = null;
                                                   } else {
                                                      var92.append("12");
                                                      var88 = var90.parse(var92.toString());
                                                   }

                                                   var86 = var88;
                                                   break;
                                                }
                                             } catch (ParseException var56) {
                                                WorldMapRectangle.method1522("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                var96 = false;
                                                break label1397;
                                             }

                                             if (var86 == null) {
                                                var96 = false;
                                             } else {
                                                var19 = class81.method483(var86);
                                                var93 = Varcs.method651();
                                                var20 = var86.after(var93);
                                                if (!var20) {
                                                   WorldMapRectangle.method1522("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
                                                   var96 = false;
                                                } else {
                                                   if (!var19) {
                                                      ByteArrayPool.field3668 = 8388607;
                                                   } else {
                                                      ByteArrayPool.field3668 = (int)(var86.getTime() / 86400000L - 11745L);
                                                   }

                                                   var96 = true;
                                                }
                                             }
                                          }

                                          if (var96) {
                                             class138.updateGameState(50);
                                          }

                                          return;
                                       }
                                    }
                                 } else {
                                    var11 = Login.loginBoxX + 180 - 80;
                                    var12 = 321;
                                    if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                       Ignored.openURL(InvDefinition.method977("secure", true) + "m=dob/set_dob.ws", true, false);
                                       class205.setLoginResponseString("", "Page has opened in the browser.", "");
                                       class129.method763(6);
                                       return;
                                    }

                                    var11 = Login.loginBoxX + 180 + 80;
                                    if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                       class6.Login_promptCredentials(true);
                                    }
                                 }
                              } else if (Login.loginIndex == 8) {
                                 var11 = Login.loginBoxX + 180 - 80;
                                 var12 = 321;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Ignored.openURL("https://www.jagex.com/terms/privacy", true, false);
                                    class205.setLoginResponseString("", "Page has opened in the browser.", "");
                                    class129.method763(6);
                                    return;
                                 }

                                 var11 = Login.loginBoxX + 180 + 80;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    class6.Login_promptCredentials(true);
                                 }
                              } else if (Login.loginIndex == 9) {
                                 var11 = Login.loginBoxX + 180;
                                 var12 = 311;
                                 if (var34.field1867 == 84 || var34.field1867 == 13 || var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Login.method444(false);
                                 }
                              } else if (Login.loginIndex == 10) {
                                 var11 = Login.loginBoxX + 180;
                                 var12 = 209;
                                 if (var34.field1867 == 84 || var33 == 1 && var60 >= var11 - 109 && var60 <= var11 + 109 && var61 >= var12 && var61 <= var12 + 68) {
                                    class205.setLoginResponseString("", "Connecting to server...", "");
                                    Client.field395 = class493.field4094;
                                    class14.method53(false);
                                    class138.updateGameState(20);
                                 }
                              } else if (Login.loginIndex == 12) {
                                 var11 = class143.loginBoxCenter;
                                 var12 = 233;
                                 var37 = var2.method2051(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
                                 Bounds var35 = var2.method2051(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
                                 Bounds var36 = var2.method2051(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
                                 var64 = var12 + 17;
                                 Bounds var52 = var2.method2051(0, 34, "<col=ffd200>agreement (EULA)</col>.", var11, var64);
                                 if (var33 == 1) {
                                    if (var37.method2232(var60, var61)) {
                                       Ignored.openURL("https://www.jagex.com/terms", true, false);
                                    } else if (var35.method2232(var60, var61)) {
                                       Ignored.openURL("https://www.jagex.com/terms/privacy", true, false);
                                    } else if (var36.method2232(var60, var61) || var52.method2232(var60, var61)) {
                                       Ignored.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
                                    }
                                 }

                                 var11 = class143.loginBoxCenter - 80;
                                 var12 = 311;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    class20.clientPreferences.method574(Client.param21);
                                    Login.method444(true);
                                 }

                                 var11 = class143.loginBoxCenter + 80;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Login.loginIndex = 13;
                                 }
                              } else if (Login.loginIndex == 13) {
                                 var11 = class143.loginBoxCenter;
                                 var12 = 321;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Login.method444(true);
                                 }
                              } else if (Login.loginIndex == 14) {
                                 String var53 = "";
                                 switch(Login.field738) {
                                 case 0:
                                    var53 = "https://secure.runescape.com/m=offence-appeal/account-history";
                                    break;
                                 case 1:
                                    var53 = "https://secure.runescape.com/m=accountappeal/passwordrecovery";
                                    break;
                                 case 2:
                                    var53 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
                                    break;
                                 default:
                                    class6.Login_promptCredentials(false);
                                 }

                                 var64 = Login.loginBoxX + 180;
                                 var63 = 276;
                                 if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20) {
                                    Ignored.openURL(var53, true, false);
                                    class205.setLoginResponseString("", "Page has opened in the browser.", "");
                                    class129.method763(6);
                                    return;
                                 }

                                 var64 = Login.loginBoxX + 180;
                                 var63 = 326;
                                 if (var33 == 1 && var60 >= var64 - 75 && var60 <= var64 + 75 && var61 >= var63 - 20 && var61 <= var63 + 20) {
                                    class6.Login_promptCredentials(false);
                                 }
                              } else if (Login.loginIndex == 24) {
                                 var11 = Login.loginBoxX + 180;
                                 var12 = 301;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Login.method444(false);
                                 }
                              } else if (Login.loginIndex == 32) {
                                 var11 = Login.loginBoxX + 180 - 80;
                                 var12 = 321;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Ignored.openURL(InvDefinition.method977("secure", true) + "m=dob/set_dob.ws", true, false);
                                    class205.setLoginResponseString("", "Page has opened in the browser.", "");
                                    class129.method763(6);
                                    return;
                                 }

                                 var11 = Login.loginBoxX + 180 + 80;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    class6.Login_promptCredentials(true);
                                 }
                              } else if (Login.loginIndex == 33) {
                                 var11 = Login.loginBoxX + 180;
                                 var12 = 276;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    Ignored.openURL("https://oldschool.runescape.com/launcher", true, false);
                                 }

                                 var11 = Login.loginBoxX + 180;
                                 var12 = 326;
                                 if (var33 == 1 && var60 >= var11 - 75 && var60 <= var11 + 75 && var61 >= var12 - 20 && var61 <= var12 + 20) {
                                    class6.Login_promptCredentials(true);
                                 }
                              }
                           } else {
                              while(true) {
                                 do {
                                    if (!var10.method1154()) {
                                       var62 = 321;
                                       if (var33 == 1 && var61 >= var62 - 20 && var61 <= var62 + 20) {
                                          class6.Login_promptCredentials(true);
                                       }

                                       return;
                                    }
                                 } while(var10.field1867 != 84 && var10.field1867 != 13);

                                 class6.Login_promptCredentials(true);
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

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1074260583"
   )
   static final void method1013() {
      for(int var0 = 0; var0 < Client.npcCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.npcs[var1];
         if (var2 != null) {
            ReflectionCheck.updateActorSequence(var2, var2.definition.size);
         }
      }

   }

    @ObfuscatedName("jb")
    @ObfuscatedSignature(
            descriptor = "(Llm;I)V",
            garbageValue = "-302991134"
    )
    static final void processZoneOperation(ZoneOperation var0) {
      PacketBuffer var1 = Client.packetWriter.packetBuffer;
      int var2;
      int var5;
      int var6;
      int var7;
      int var9;
      byte var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var36;
      int var37;
      int var38;
      int var39;
      if (ZoneOperation.field2565 == var0) {
         var2 = var1.readUnsignedByte();
         var36 = var1.readUnsignedByte();
         var37 = (var36 >> 4 & 7) + class9.field28;
         var5 = (var36 & 7) + FontName.field3968;
         var6 = var1._readUnsignedByteSub() * 4;
         var7 = var1.readUnsignedShortAdd();
         var38 = var1._readUnsignedByteSub();
         var9 = var1.readUnsignedShort();
         var10 = var1.readByteNeg();
         var11 = var1.readUnsignedByteNeg() * 4;
         var12 = var1.readUnsignedShort();
         var13 = var1.method2523();
         byte var40 = var1.readUnsignedByteSub();
         var14 = var40 + var37;
         var39 = var10 + var5;
         if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104 && var14 >= 0 && var39 >= 0 && var14 < 104 && var39 < 104 && var7 != 65535) {
            var37 = var37 * 128 + 64;
            var5 = var5 * 128 + 64;
            var14 = var14 * 128 + 64;
            var39 = var39 * 128 + 64;
            Projectile var15 = new Projectile(var7, GameEngine.Client_plane, var37, var5, class147.getTileHeight(var37, var5, GameEngine.Client_plane) - var11, var9 + Client.cycle, var12 + Client.cycle, var2, var38, var13, var6);
            var15.setDestination(var14, var39, class147.getTileHeight(var14, var39, GameEngine.Client_plane) - var6, var9 + Client.cycle);
            Client.projectiles.addFirst(var15);
         }

      } else {
         if (ZoneOperation.field2563 == var0) {
            var2 = var1.readUnsignedShort();
            byte var3 = var1.readUnsignedByteSub();
            byte var4 = var1.readByteAdd();
            var5 = var1.readUnsignedByteAdd();
            var6 = (var5 >> 4 & 7) + class9.field28;
            var7 = (var5 & 7) + FontName.field3968;
            byte var8 = var1.readByte();
            var9 = var1.readUnsignedShort();
            var10 = var1.readByteAdd();
            var11 = var1.readUnsignedByte();
            var12 = var11 >> 2;
            var13 = var11 & 3;
            var14 = Client.field431[var12];
            int var31 = var1.readUnsignedShortAdd();
            int var16 = var1.readUnsignedShortAddLE();
            Player var17;
            if (var2 == Client.localPlayerIndex) {
               var17 = MusicPatchNode.localPlayer;
            } else {
               var17 = Client.players[var2];
            }

            if (var17 != null) {
               ObjectComposition var18 = class144.getObjectDefinition(var16);
               int var19;
               int var20;
               if (var13 != 1 && var13 != 3) {
                  var19 = var18.sizeX;
                  var20 = var18.sizeY;
               } else {
                  var19 = var18.sizeY;
                  var20 = var18.sizeX;
               }

               int var21 = var6 + (var19 >> 1);
               int var22 = var6 + (var19 + 1 >> 1);
               int var23 = var7 + (var20 >> 1);
               int var24 = var7 + (var20 + 1 >> 1);
               int[][] var25 = Tiles.Tiles_heights[GameEngine.Client_plane];
               int var26 = var25[var21][var24] + var25[var22][var23] + var25[var21][var23] + var25[var22][var24] >> 2;
               int var27 = (var6 << 7) + (var19 << 6);
               int var28 = (var7 << 7) + (var20 << 6);
               Model var29 = var18.getModel(var12, var13, var25, var27, var26, var28);
               if (var29 != null) {
                  class33.updatePendingSpawn(GameEngine.Client_plane, var6, var7, var14, -1, 0, 0, 31, var9 + 1, var31 + 1);
                  var17.animationCycleStart = var9 + Client.cycle;
                  var17.animationCycleEnd = var31 + Client.cycle;
                  var17.attachedModel = var29;
                  var17.field899 = var19 * 64 + var6 * 128;
                  var17.field903 = var20 * 64 + var7 * 128;
                  var17.baseTileHeight = var26;
                  byte var30;
                  if (var8 > var10) {
                     var30 = var8;
                     var8 = var10;
                     var10 = var30;
                  }

                  if (var3 > var4) {
                     var30 = var3;
                     var3 = var4;
                     var4 = var30;
                  }

                  var17.minX = var6 + var8;
                  var17.maxX = var6 + var10;
                  var17.minY = var7 + var3;
                  var17.maxY = var4 + var7;
               }
            }
         }

         if (ZoneOperation.field2562 == var0) {
            var2 = var1._readUnsignedByteSub();
            var36 = (var2 >> 4 & 7) + class9.field28;
            var37 = (var2 & 7) + FontName.field3968;
            var5 = var1.readInt();
            var6 = var1.readUnsignedShortAddLE();
            var7 = var1.readInt();
            if (var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104) {
               NodeDeque var42 = Client.groundItems[GameEngine.Client_plane][var36][var37];
               if (var42 != null) {
                  for(TileItem var33 = (TileItem)var42.last(); var33 != null; var33 = (TileItem)var42.previous()) {
                     if ((var6 & 32767) == var33.id && var7 == var33.quantity) {
                        var33.quantity = var5;
                        break;
                     }
                  }

                  class121.updateItemPile(var36, var37);
               }
            }

         } else {
            TileItem var41;
            if (ZoneOperation.field2570 == var0) {
               var1.readUnsignedByteAdd();
               var2 = var1.readIntLE();
               var36 = var1.readUnsignedByteAdd();
               var37 = var1.readUnsignedByte();
               var5 = (var37 >> 4 & 7) + class9.field28;
               var6 = (var37 & 7) + FontName.field3968;
               var7 = var1.readUnsignedShortAdd();
               var1.readUnsignedShortLE();
               var1.readUnsignedShortAdd();
               var1.readUnsignedByteNeg();
               if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  var41 = new TileItem();
                  var41.id = var7;
                  var41.quantity = var2;
                  var41.method622(var36);
                  if (Client.groundItems[GameEngine.Client_plane][var5][var6] == null) {
                     Client.groundItems[GameEngine.Client_plane][var5][var6] = new NodeDeque();
                  }

                  Client.groundItems[GameEngine.Client_plane][var5][var6].addFirst(var41);
                  class121.updateItemPile(var5, var6);
               }

            } else if (ZoneOperation.field2567 == var0) {
               var2 = var1.readUnsignedByte();
               var36 = var1._readUnsignedByteSub();
               var37 = (var36 >> 4 & 7) + class9.field28;
               var5 = (var36 & 7) + FontName.field3968;
               var6 = var1.readUnsignedByteNeg();
               var7 = var6 >> 2;
               var38 = var6 & 3;
               var9 = Client.field431[var7];
               var39 = var1.readUnsignedShortLE();
               if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
                  class33.updatePendingSpawn(GameEngine.Client_plane, var37, var5, var9, var39, var7, var38, var2, 0, -1);
               }

            } else {
               NodeDeque var34;
               if (ZoneOperation.field2569 == var0) {
                  var2 = var1.readUnsignedByteNeg();
                  var36 = (var2 >> 4 & 7) + class9.field28;
                  var37 = (var2 & 7) + FontName.field3968;
                  var5 = var1.readUnsignedShortLE();
                  var6 = var1.readIntME();
                  if (var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104) {
                     var34 = Client.groundItems[GameEngine.Client_plane][var36][var37];
                     if (var34 != null) {
                        for(var41 = (TileItem)var34.last(); var41 != null; var41 = (TileItem)var34.previous()) {
                           if ((var5 & 32767) == var41.id && var6 == var41.quantity) {
                              var41.remove();
                              break;
                           }
                        }

                        if (var34.last() == null) {
                           Client.groundItems[GameEngine.Client_plane][var36][var37] = null;
                        }

                        class121.updateItemPile(var36, var37);
                     }
                  }

               } else {
                  if (ZoneOperation.field2572 == var0) {
                     var2 = var1.readUnsignedShortAddLE();
                     var36 = var1.readUnsignedByteNeg();
                     var37 = var36 >> 4 & 15;
                     var5 = var36 & 7;
                     var6 = var1.readUnsignedByteAdd();
                     var7 = (var6 >> 4 & 7) + class9.field28;
                     var38 = (var6 & 7) + FontName.field3968;
                     var9 = var1._readUnsignedByteSub();
                     if (var7 >= 0 && var38 >= 0 && var7 < 104 && var38 < 104) {
                        var39 = var37 + 1;
                        if (MusicPatchNode.localPlayer.pathX[0] >= var7 - var39 && MusicPatchNode.localPlayer.pathX[0] <= var39 + var7 && MusicPatchNode.localPlayer.pathY[0] >= var38 - var39 && MusicPatchNode.localPlayer.pathY[0] <= var38 + var39 && class20.clientPreferences.getAreaSoundEffectsVolume() != 0 && var5 > 0 && Client.soundEffectCount < 50) {
                           Client.soundEffectIds[Client.soundEffectCount] = var2;
                           Client.queuedSoundEffectLoops[Client.soundEffectCount] = var5;
                           Client.queuedSoundEffectDelays[Client.soundEffectCount] = var9;
                           Client.soundEffects[Client.soundEffectCount] = null;
                           Client.soundLocations[Client.soundEffectCount] = var37 + (var38 << 8) + (var7 << 16);
                           ++Client.soundEffectCount;
                        }
                     }
                  }

                  if (ZoneOperation.field2568 == var0) {
                     var2 = var1.readUnsignedShortAddLE();
                     var36 = var1.readUnsignedByteNeg();
                     var37 = (var36 >> 4 & 7) + class9.field28;
                     var5 = (var36 & 7) + FontName.field3968;
                     var6 = var1.readUnsignedByteAdd();
                     if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
                        var34 = Client.groundItems[GameEngine.Client_plane][var37][var5];
                        if (var34 != null) {
                           for(var41 = (TileItem)var34.last(); var41 != null; var41 = (TileItem)var34.previous()) {
                              if ((var2 & 32767) == var41.id) {
                                 var41.method622(var6);
                                 break;
                              }
                           }
                        }
                     }

                  } else if (ZoneOperation.field2564 != var0) {
                     if (ZoneOperation.field2571 == var0) {
                        var2 = var1.readUnsignedByteAdd();
                        var36 = (var2 >> 4 & 7) + class9.field28;
                        var37 = (var2 & 7) + FontName.field3968;
                        var5 = var1.readUnsignedByte();
                        var6 = var5 >> 2;
                        var7 = var5 & 3;
                        var38 = Client.field431[var6];
                        if (var36 >= 0 && var37 >= 0 && var36 < 104 && var37 < 104) {
                           class33.updatePendingSpawn(GameEngine.Client_plane, var36, var37, var38, -1, var6, var7, 31, 0, -1);
                        }

                     } else if (ZoneOperation.field2566 == var0) {
                        var2 = var1.readUnsignedByteNeg();
                        var36 = var1.readUnsignedShort();
                        var37 = var1._readUnsignedByteSub();
                        var5 = (var37 >> 4 & 7) + class9.field28;
                        var6 = (var37 & 7) + FontName.field3968;
                        var7 = var1.readUnsignedShortLE();
                        if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                           var5 = var5 * 128 + 64;
                           var6 = var6 * 128 + 64;
                           GraphicsObject var32 = new GraphicsObject(var7, GameEngine.Client_plane, var5, var6, class147.getTileHeight(var5, var6, GameEngine.Client_plane) - var2, var36, Client.cycle);
                           Client.graphicsObjects.addFirst(var32);
                        }

                     }
                  } else {
                     var2 = var1.readUnsignedByte();
                     var36 = (var2 >> 4 & 7) + class9.field28;
                     var37 = (var2 & 7) + FontName.field3968;
                     var5 = var1.readUnsignedShortLE();
                     var6 = var1.readUnsignedByteNeg();
                     var7 = var6 >> 2;
                     var38 = var6 & 3;
                     var9 = Client.field431[var7];
                     if (var36 >= 0 && var37 >= 0 && var36 < 103 && var37 < 103) {
                        if (var9 == 0) {
                           BoundaryObject var35 = class31.scene.method1252(GameEngine.Client_plane, var36, var37);
                           if (var35 != null) {
                              var11 = InterfaceParent.Entity_unpackID(var35.tag);
                              if (var7 == 2) {
                                 var35.renderable1 = new DynamicObject(var11, 2, var38 + 4, GameEngine.Client_plane, var36, var37, var5, false, var35.renderable1);
                                 var35.renderable2 = new DynamicObject(var11, 2, var38 + 1 & 3, GameEngine.Client_plane, var36, var37, var5, false, var35.renderable2);
                              } else {
                                 var35.renderable1 = new DynamicObject(var11, var7, var38, GameEngine.Client_plane, var36, var37, var5, false, var35.renderable1);
                              }

                              return;
                           }
                        }

                        if (var9 == 1) {
                           WallDecoration var43 = class31.scene.method1253(GameEngine.Client_plane, var36, var37);
                           if (var43 != null) {
                              var11 = InterfaceParent.Entity_unpackID(var43.tag);
                              if (var7 != 4 && var7 != 5) {
                                 if (var7 == 6) {
                                    var43.renderable1 = new DynamicObject(var11, 4, var38 + 4, GameEngine.Client_plane, var36, var37, var5, false, var43.renderable1);
                                 } else if (var7 == 7) {
                                    var43.renderable1 = new DynamicObject(var11, 4, (var38 + 2 & 3) + 4, GameEngine.Client_plane, var36, var37, var5, false, var43.renderable1);
                                 } else if (var7 == 8) {
                                    var43.renderable1 = new DynamicObject(var11, 4, var38 + 4, GameEngine.Client_plane, var36, var37, var5, false, var43.renderable1);
                                    var43.renderable2 = new DynamicObject(var11, 4, (var38 + 2 & 3) + 4, GameEngine.Client_plane, var36, var37, var5, false, var43.renderable2);
                                 }
                              } else {
                                 var43.renderable1 = new DynamicObject(var11, 4, var38, GameEngine.Client_plane, var36, var37, var5, false, var43.renderable1);
                              }

                              return;
                           }
                        }

                        if (var9 == 2) {
                           GameObject var44 = class31.scene.getGameObject(GameEngine.Client_plane, var36, var37);
                           if (var7 == 11) {
                              var7 = 10;
                           }

                           if (var44 != null) {
                              var44.renderable = new DynamicObject(InterfaceParent.Entity_unpackID(var44.tag), var7, var38, GameEngine.Client_plane, var36, var37, var5, false, var44.renderable);
                              return;
                           }
                        }

                        if (var9 == 3) {
                           FloorDecoration var45 = class31.scene.getFloorDecoration(GameEngine.Client_plane, var36, var37);
                           if (var45 != null) {
                              var45.renderable = new DynamicObject(InterfaceParent.Entity_unpackID(var45.tag), 22, var38, GameEngine.Client_plane, var36, var37, var5, false, var45.renderable);
                              return;
                           }
                        }

                        class186.method1009(GameEngine.Client_plane, var36, var37, var9, var5);
                     }

                  }
               }
            }
         }
      }
   }
}
