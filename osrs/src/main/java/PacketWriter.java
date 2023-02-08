import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("PacketWriter")
public class PacketWriter {
   @ObfuscatedName("vq")
   @ObfuscatedSignature(
           descriptor = "Lcy;"
   )
   static ClientPreferences clientPreferences;
   @ObfuscatedName("ur")
   static int field1136;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
           descriptor = "Lov;"
   )
   AbstractSocket socket;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "Lmt;"
   )
   IterableNodeDeque packetBufferNodes = new IterableNodeDeque();
   @ObfuscatedName("v")
   int bufferSize = 0;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
           descriptor = "Lrd;"
   )
   Buffer buffer = new Buffer(5000);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
           descriptor = "Lrt;"
   )
   public IsaacCipher isaacCipher;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
           descriptor = "Lru;"
   )
   PacketBuffer packetBuffer = new PacketBuffer(40000);
   @ObfuscatedName("i")
   @ObfuscatedSignature(
           descriptor = "Ljg;"
   )
   ServerPacket serverPacket = null;
   @ObfuscatedName("n")
   int serverPacketLength = 0;
   @ObfuscatedName("l")
   boolean field1129 = true;
   @ObfuscatedName("k")
   int field1130 = 0;
   @ObfuscatedName("c")
   int pendingWrites = 0;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Ljg;"
   )
   ServerPacket field1137;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ljg;"
   )
   ServerPacket field1133;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ljg;"
   )
   ServerPacket field1134;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
           descriptor = "(S)V",
           garbageValue = "30455"
   )
   final void clearBuffer() {
      this.packetBufferNodes.rsClear();
      this.bufferSize = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "(B)V",
           garbageValue = "-60"
   )
   final void flush() throws IOException {
      if (this.socket != null && this.bufferSize > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
            if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
               this.socket.write(this.buffer.array, 0, this.buffer.offset);
               this.pendingWrites = 0;
               break;
            }

            this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
            this.bufferSize -= var1.index;
            var1.remove();
            var1.packetBuffer.releaseArray();
            var1.release();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
           descriptor = "(Lji;B)V",
           garbageValue = "35"
   )
   public final void addNode(PacketBufferNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.index = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.bufferSize += var1.index;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
           descriptor = "(Lov;S)V",
           garbageValue = "-25572"
   )
   void setSocket(AbstractSocket var1) {
      this.socket = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-365633246"
   )
   void close() {
      if (this.socket != null) {
         this.socket.close();
         this.socket = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
           descriptor = "(B)V",
           garbageValue = "8"
   )
   void removeSocket() {
      this.socket = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
           descriptor = "(B)Lov;",
           garbageValue = "-5"
   )
   AbstractSocket getSocket() {
      return this.socket;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
           descriptor = "(Laj;Lnv;I)V",
           garbageValue = "1044238917"
   )
   static void loginScreen(GameEngine var0, Font var1) {
      if (Login.worldSelectOpen) {
         HealthBar.method555(var0);
      } else {
         if ((MouseHandler.MouseHandler_lastButton == 1 || !ClanMate.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            clientPreferences.getTitleMusicDisabled(!clientPreferences.getTitleMusicDisabled());
            if (!clientPreferences.getTitleMusicDisabled()) {
               Skeleton.method1185(class153.archive6, "scape main", "", 255, false);
            } else {
               class177.method905();
            }
         }

         if (Client.gameState != 5) {
            if (-1L == Login.field756) {
               Login.field756 = class153.clockNow() + 1000L;
            }

            long var2 = class153.clockNow();
            boolean var4;
            if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
               while(true) {
                  if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
                     var4 = true;
                     break;
                  }

                  ArchiveLoader var5 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
                  if (!var5.isLoaded()) {
                     var4 = false;
                     break;
                  }

                  ++Client.archiveLoadersDone;
               }
            } else {
               var4 = true;
            }

            if (var4 && -1L == Login.field740) {
               Login.field740 = var2;
               if (Login.field740 > Login.field756) {
                  Login.field756 = Login.field740;
               }
            }

            if (Client.gameState == 10 || Client.gameState == 11) {
               int var21;
               if (class36.clientLanguage == Language.Language_EN) {
                  if (MouseHandler.MouseHandler_lastButton == 1 || !ClanMate.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var21 = Login.xPadding + 5;
                     short var6 = 463;
                     byte var7 = 100;
                     byte var8 = 35;
                     if (MouseHandler.MouseHandler_lastPressedX >= var21 && MouseHandler.MouseHandler_lastPressedX <= var7 + var21 && MouseHandler.MouseHandler_lastPressedY >= var6 && MouseHandler.MouseHandler_lastPressedY <= var8 + var6) {
                        FloorDecoration.method1144();
                        return;
                     }
                  }

                  if (ClanChannel.World_request != null) {
                     FloorDecoration.method1144();
                  }
               }

               var21 = MouseHandler.MouseHandler_lastButton;
               int var31 = MouseHandler.MouseHandler_lastPressedX;
               int var32 = MouseHandler.MouseHandler_lastPressedY;
               if (var21 == 0) {
                  var31 = MouseHandler.MouseHandler_x;
                  var32 = MouseHandler.MouseHandler_y;
               }

               if (!ClanMate.mouseCam && var21 == 4) {
                  var21 = 1;
               }

               class205 var22 = Client.keyHandlerInstance;
               class205 var9 = var22;
               int var34;
               short var35;
               if (Login.loginIndex == 0) {
                  boolean var42 = false;

                  while(var9.method1085()) {
                     if (var9.field1832 == 84) {
                        var42 = true;
                     }
                  }

                  var34 = class143.loginBoxCenter - 80;
                  var35 = 291;
                  if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20) {
                     AttackOption.openURL(class310.method1760("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var34 = class143.loginBoxCenter + 80;
                  if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20 || var42) {
                     if ((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        ReflectionCheck.method171(1);
                        class361.method1925();
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
                        ReflectionCheck.method171(1);
                        class361.method1925();
                     } else if ((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        ReflectionCheck.method171(1);
                        class361.method1925();
                     } else {
                        UserComparator6.Login_promptCredentials(false);
                     }
                  }
               } else {
                  int var10;
                  short var11;
                  if (Login.loginIndex == 1) {
                     while(true) {
                        if (!var9.method1085()) {
                           var10 = class143.loginBoxCenter - 80;
                           var11 = 321;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              UserComparator6.Login_promptCredentials(false);
                           }

                           var10 = class143.loginBoxCenter + 80;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              ReflectionCheck.method171(0);
                           }
                           break;
                        }

                        if (var9.field1832 == 84) {
                           UserComparator6.Login_promptCredentials(false);
                        } else if (var9.field1832 == 13) {
                           ReflectionCheck.method171(0);
                        }
                     }
                  } else {
                     int var14;
                     int var15;
                     short var33;
                     boolean var36;
                     if (Login.loginIndex == 2) {
                        var33 = 201;
                        var10 = var33 + 52;
                        if (var21 == 1 && var32 >= var10 - 12 && var32 < var10 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var10 += 15;
                        if (var21 == 1 && var32 >= var10 - 12 && var32 < var10 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var10 += 15;
                        var33 = 361;
                        if (Calendar.field3019 != null) {
                           var34 = Calendar.field3019.highX / 2;
                           if (var21 == 1 && var31 >= Calendar.field3019.lowX - var34 && var31 <= var34 + Calendar.field3019.lowX && var32 >= var33 - 15 && var32 < var33) {
                              switch(Login.field752) {
                              case 1:
                                 class70.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 ReflectionCheck.method171(5);
                                 return;
                              case 2:
                                 AttackOption.openURL("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var34 = class143.loginBoxCenter - 80;
                        var35 = 321;
                        if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if (Login.Login_username.length() == 0) {
                              class70.setLoginResponseString("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Login.Login_password.length() == 0) {
                              class70.setLoginResponseString("", "Please enter your password.", "");
                              return;
                           }

                           class70.setLoginResponseString("", "Connecting to server...", "");
                           class373.method1971(false);
                           class246.updateGameState(20);
                           return;
                        }

                        var34 = Login.loginBoxX + 180 + 80;
                        if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20) {
                           ReflectionCheck.method171(0);
                           Login.Login_username = "";
                           Login.Login_password = "";
                           UserComparator4.field1149 = 0;
                           InvDefinition.otp = "";
                           Login.field764 = true;
                        }

                        var34 = class143.loginBoxCenter + -117;
                        var35 = 277;
                        Login.field772 = var31 >= var34 && var31 < var34 + WorldMapRectangle.field2360 && var32 >= var35 && var32 < var35 + class134.field1277;
                        if (var21 == 1 && Login.field772) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if (!Client.Login_isUsernameRemembered && clientPreferences.getUsernameToRemember() != null) {
                              clientPreferences.setUsernameToRemember((String)null);
                           }
                        }

                        var34 = class143.loginBoxCenter + 24;
                        var35 = 277;
                        Login.field768 = var31 >= var34 && var31 < var34 + WorldMapRectangle.field2360 && var32 >= var35 && var32 < var35 + class134.field1277;
                        if (var21 == 1 && Login.field768) {
                           clientPreferences.setIsUsernameHidden(!clientPreferences.getIsUsernameHidden());
                           if (!clientPreferences.getIsUsernameHidden()) {
                              Login.Login_username = "";
                              clientPreferences.setUsernameToRemember((String)null);
                              class361.method1925();
                           }
                        }

                        label1246:
                        while(true) {
                           Transferable var44;
                           do {
                              while(true) {
                                 label1210:
                                 do {
                                    while(true) {
                                       while(var9.method1085()) {
                                          if (var9.field1832 != 13) {
                                             if (Login.currentLoginField != 0) {
                                                continue label1210;
                                             }

                                             char var37 = var9.field1826;

                                             for(var14 = 0; var14 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var37 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var14); ++var14) {
                                                ;
                                             }

                                             if (var9.field1832 == 85 && Login.Login_username.length() > 0) {
                                                Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                             }

                                             if (var9.field1832 == 84 || var9.field1832 == 80) {
                                                Login.currentLoginField = 1;
                                             }

                                             char var39 = var9.field1826;
                                             boolean var40 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var39) != -1;
                                             if (var40 && Login.Login_username.length() < 320) {
                                                Login.Login_username = Login.Login_username + var9.field1826;
                                             }
                                          } else {
                                             ReflectionCheck.method171(0);
                                             Login.Login_username = "";
                                             Login.Login_password = "";
                                             UserComparator4.field1149 = 0;
                                             InvDefinition.otp = "";
                                             Login.field764 = true;
                                          }
                                       }

                                       return;
                                    }
                                 } while(Login.currentLoginField != 1);

                                 if (var9.field1832 == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 } else if (var9.field1832 == 84 || var9.field1832 == 80) {
                                    Login.currentLoginField = 0;
                                    if (var9.field1832 == 84) {
                                       Login.Login_username = Login.Login_username.trim();
                                       if (Login.Login_username.length() == 0) {
                                          class70.setLoginResponseString("", "Please enter your username/email address.", "");
                                          return;
                                       }

                                       if (Login.Login_password.length() == 0) {
                                          class70.setLoginResponseString("", "Please enter your password.", "");
                                          return;
                                       }

                                       class70.setLoginResponseString("", "Connecting to server...", "");
                                       class373.method1971(false);
                                       class246.updateGameState(20);
                                       return;
                                    }
                                 }

                                 if ((var9.getKeyPressed(82) || var9.getKeyPressed(87)) && var9.field1832 == 67) {
                                    Clipboard var43 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var44 = var43.getContents(Decimator.client);
                                    var15 = 20 - Login.Login_password.length();
                                    break;
                                 }

                                 if (MusicPatch.method1608(var9.field1826)) {
                                    char var41 = var9.field1826;
                                    var36 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var41) != -1;
                                    if (var36 && Login.Login_password.length() < 20) {
                                       Login.Login_password = Login.Login_password + var9.field1826;
                                    }
                                 }
                              }
                           } while(var15 <= 0);

                           try {
                              String var16 = (String)var44.getTransferData(DataFlavor.stringFlavor);
                              int var17 = Math.min(var15, var16.length());
                              int var18 = 0;

                              while(true) {
                                 if (var18 >= var17) {
                                    Login.Login_password = Login.Login_password + var16.substring(0, var17);
                                    continue label1246;
                                 }

                                 if (!MusicPatch.method1608(var16.charAt(var18))) {
                                    break;
                                 }

                                 char var20 = var16.charAt(var18);
                                 boolean var19 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var20) != -1;
                                 if (!var19) {
                                    break;
                                 }

                                 ++var18;
                              }

                              ReflectionCheck.method171(3);
                              return;
                           } catch (UnsupportedFlavorException var29) {
                              ;
                           } catch (IOException var30) {
                              ;
                           }
                        }
                     } else if (Login.loginIndex == 3) {
                        var10 = Login.loginBoxX + 180;
                        var11 = 276;
                        if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                           GrandExchangeOfferNameComparator.method1845(false);
                        }

                        var10 = Login.loginBoxX + 180;
                        var11 = 326;
                        if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                           class70.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           ReflectionCheck.method171(5);
                           return;
                        }
                     } else {
                        int var13;
                        if (Login.loginIndex == 4) {
                           var10 = Login.loginBoxX + 180 - 80;
                           var11 = 321;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              InvDefinition.otp.trim();
                              if (InvDefinition.otp.length() != 6) {
                                 class70.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              UserComparator4.field1149 = Integer.parseInt(InvDefinition.otp);
                              InvDefinition.otp = "";
                              class373.method1971(true);
                              class70.setLoginResponseString("", "Connecting to server...", "");
                              class246.updateGameState(20);
                              return;
                           }

                           if (var21 == 1 && var31 >= Login.loginBoxX + 180 - 9 && var31 <= Login.loginBoxX + 180 + 130 && var32 >= 263 && var32 <= 296) {
                              Login.field764 = !Login.field764;
                           }

                           if (var21 == 1 && var31 >= Login.loginBoxX + 180 - 34 && var31 <= Login.loginBoxX + 34 + 180 && var32 >= 351 && var32 <= 363) {
                              AttackOption.openURL(class310.method1760("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var10 = Login.loginBoxX + 180 + 80;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              ReflectionCheck.method171(0);
                              Login.Login_username = "";
                              Login.Login_password = "";
                              UserComparator4.field1149 = 0;
                              InvDefinition.otp = "";
                           }

                           while(var9.method1085()) {
                              boolean var12 = false;

                              for(var13 = 0; var13 < "1234567890".length(); ++var13) {
                                 if (var9.field1826 == "1234567890".charAt(var13)) {
                                    var12 = true;
                                    break;
                                 }
                              }

                              if (var9.field1832 == 13) {
                                 ReflectionCheck.method171(0);
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 UserComparator4.field1149 = 0;
                                 InvDefinition.otp = "";
                              } else {
                                 if (var9.field1832 == 85 && InvDefinition.otp.length() > 0) {
                                    InvDefinition.otp = InvDefinition.otp.substring(0, InvDefinition.otp.length() - 1);
                                 }

                                 if (var9.field1832 == 84) {
                                    InvDefinition.otp.trim();
                                    if (InvDefinition.otp.length() != 6) {
                                       class70.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    UserComparator4.field1149 = Integer.parseInt(InvDefinition.otp);
                                    InvDefinition.otp = "";
                                    class373.method1971(true);
                                    class70.setLoginResponseString("", "Connecting to server...", "");
                                    class246.updateGameState(20);
                                    return;
                                 }

                                 if (var12 && InvDefinition.otp.length() < 6) {
                                    InvDefinition.otp = InvDefinition.otp + var9.field1826;
                                 }
                              }
                           }
                        } else if (Login.loginIndex == 5) {
                           var10 = Login.loginBoxX + 180 - 80;
                           var11 = 321;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              WorldMapAreaData.method1487();
                              return;
                           }

                           var10 = Login.loginBoxX + 180 + 80;
                           if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                              UserComparator6.Login_promptCredentials(true);
                           }

                           var35 = 361;
                           if (class290.field2708 != null) {
                              var13 = class290.field2708.highX / 2;
                              if (var21 == 1 && var31 >= class290.field2708.lowX - var13 && var31 <= var13 + class290.field2708.lowX && var32 >= var35 - 15 && var32 < var35) {
                                 AttackOption.openURL(class310.method1760("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                              }
                           }

                           while(var9.method1085()) {
                              var36 = false;

                              for(var14 = 0; var14 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var14) {
                                 if (var9.field1826 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var14)) {
                                    var36 = true;
                                    break;
                                 }
                              }

                              if (var9.field1832 == 13) {
                                 UserComparator6.Login_promptCredentials(true);
                              } else {
                                 if (var9.field1832 == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 }

                                 if (var9.field1832 == 84) {
                                    WorldMapAreaData.method1487();
                                    return;
                                 }

                                 if (var36 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + var9.field1826;
                                 }
                              }
                           }
                        } else if (Login.loginIndex != 6) {
                           if (Login.loginIndex == 7) {
                              if (class209.field1857 && !Client.onMobile) {
                                 var10 = class143.loginBoxCenter - 150;
                                 var34 = var10 + 40 + 240 + 25;
                                 var35 = 231;
                                 var13 = var35 + 40;
                                 if (var21 == 1 && var31 >= var10 && var31 <= var34 && var32 >= var35 && var32 <= var13) {
                                    var15 = var10;
                                    int var25 = 0;

                                    while(true) {
                                       if (var25 >= 8) {
                                          var14 = 0;
                                          break;
                                       }

                                       if (var31 <= var15 + 30) {
                                          var14 = var25;
                                          break;
                                       }

                                       var15 += 30;
                                       var15 += var25 != 1 && var25 != 3 ? 5 : 20;
                                       ++var25;
                                    }

                                    Login.field760 = var14;
                                 }

                                 var14 = Login.loginBoxX + 180 - 80;
                                 short var38 = 321;
                                 boolean var45;
                                 if (var21 == 1 && var31 >= var14 - 75 && var31 <= var14 + 75 && var32 >= var38 - 20 && var32 <= var38 + 20) {
                                    var45 = Language.method1880();
                                    if (var45) {
                                       class246.updateGameState(50);
                                       return;
                                    }
                                 }

                                 var14 = Login.loginBoxX + 180 + 80;
                                 if (var21 == 1 && var31 >= var14 - 75 && var31 <= var14 + 75 && var32 >= var38 - 20 && var32 <= var38 + 20) {
                                    Login.field761 = new String[8];
                                    UserComparator6.Login_promptCredentials(true);
                                 }

                                 while(var9.method1085()) {
                                    if (var9.field1832 == 101) {
                                       Login.field761[Login.field760] = null;
                                    }

                                    if (var9.field1832 == 85) {
                                       if (Login.field761[Login.field760] == null && Login.field760 > 0) {
                                          --Login.field760;
                                       }

                                       Login.field761[Login.field760] = null;
                                    }

                                    if (var9.field1826 >= '0' && var9.field1826 <= '9') {
                                       Login.field761[Login.field760] = "" + var9.field1826;
                                       if (Login.field760 < 7) {
                                          ++Login.field760;
                                       }
                                    }

                                    if (var9.field1832 == 84) {
                                       var45 = Language.method1880();
                                       if (var45) {
                                          class246.updateGameState(50);
                                       }

                                       return;
                                    }
                                 }
                              } else {
                                 var10 = Login.loginBoxX + 180 - 80;
                                 var11 = 321;
                                 if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                    AttackOption.openURL(class310.method1760("secure", true) + "m=dob/set_dob.ws", true, false);
                                    class70.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                    ReflectionCheck.method171(6);
                                    return;
                                 }

                                 var10 = Login.loginBoxX + 180 + 80;
                                 if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                    UserComparator6.Login_promptCredentials(true);
                                 }
                              }
                           } else if (Login.loginIndex == 8) {
                              var10 = Login.loginBoxX + 180 - 80;
                              var11 = 321;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 AttackOption.openURL("https://www.jagex.com/terms/privacy", true, false);
                                 class70.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 ReflectionCheck.method171(6);
                                 return;
                              }

                              var10 = Login.loginBoxX + 180 + 80;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 UserComparator6.Login_promptCredentials(true);
                              }
                           } else if (Login.loginIndex == 9) {
                              var10 = Login.loginBoxX + 180;
                              var11 = 311;
                              if (var22.field1832 == 84 || var22.field1832 == 13 || var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 GrandExchangeOfferNameComparator.method1845(false);
                              }
                           } else if (Login.loginIndex == 10) {
                              var10 = Login.loginBoxX + 180;
                              var11 = 209;
                              if (var22.field1832 == 84 || var21 == 1 && var31 >= var10 - 109 && var31 <= var10 + 109 && var32 >= var11 && var32 <= var11 + 68) {
                                 class70.setLoginResponseString("", "Connecting to server...", "");
                                 Client.field404 = class478.field4049;
                                 class373.method1971(false);
                                 class246.updateGameState(20);
                              }
                           } else if (Login.loginIndex == 12) {
                              var10 = class143.loginBoxCenter;
                              var11 = 233;
                              Bounds var26 = var1.method1999(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                              Bounds var23 = var1.method1999(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                              Bounds var24 = var1.method1999(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var10, var11);
                              var34 = var11 + 17;
                              Bounds var27 = var1.method1999(0, 34, "<col=ffd200>agreement (EULA)</col>.", var10, var34);
                              if (var21 == 1) {
                                 if (var26.method2160(var31, var32)) {
                                    AttackOption.openURL("https://www.jagex.com/terms", true, false);
                                 } else if (var23.method2160(var31, var32)) {
                                    AttackOption.openURL("https://www.jagex.com/terms/privacy", true, false);
                                 } else if (var24.method2160(var31, var32) || var27.method2160(var31, var32)) {
                                    AttackOption.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
                                 }
                              }

                              var10 = class143.loginBoxCenter - 80;
                              var11 = 311;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 FriendsChat.method2076();
                                 GrandExchangeOfferNameComparator.method1845(true);
                              }

                              var10 = class143.loginBoxCenter + 80;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 Login.loginIndex = 13;
                              }
                           } else if (Login.loginIndex == 13) {
                              var10 = class143.loginBoxCenter;
                              var11 = 321;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 GrandExchangeOfferNameComparator.method1845(true);
                              }
                           } else if (Login.loginIndex == 14) {
                              String var28 = "";
                              switch(Login.field751) {
                              case 0:
                                 var28 = "https://secure.runescape.com/m=offence-appeal/account-history";
                                 break;
                              case 1:
                                 var28 = "https://secure.runescape.com/m=accountappeal/passwordrecovery";
                                 break;
                              case 2:
                                 var28 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
                                 break;
                              default:
                                 UserComparator6.Login_promptCredentials(false);
                              }

                              var34 = Login.loginBoxX + 180;
                              var35 = 276;
                              if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20) {
                                 AttackOption.openURL(var28, true, false);
                                 class70.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 ReflectionCheck.method171(6);
                                 return;
                              }

                              var34 = Login.loginBoxX + 180;
                              var35 = 326;
                              if (var21 == 1 && var31 >= var34 - 75 && var31 <= var34 + 75 && var32 >= var35 - 20 && var32 <= var35 + 20) {
                                 UserComparator6.Login_promptCredentials(false);
                              }
                           } else if (Login.loginIndex == 24) {
                              var10 = Login.loginBoxX + 180;
                              var11 = 301;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 GrandExchangeOfferNameComparator.method1845(false);
                              }
                           } else if (Login.loginIndex == 26) {
                              var10 = Login.loginBoxX + 180 - 80;
                              var11 = 321;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 AttackOption.openURL(class310.method1760("secure", true) + "m=dob/set_dob.ws", true, false);
                                 class70.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 ReflectionCheck.method171(6);
                                 return;
                              }

                              var10 = Login.loginBoxX + 180 + 80;
                              if (var21 == 1 && var31 >= var10 - 75 && var31 <= var10 + 75 && var32 >= var11 - 20 && var32 <= var11 + 20) {
                                 UserComparator6.Login_promptCredentials(true);
                              }
                           }
                        } else {
                           while(true) {
                              do {
                                 if (!var9.method1085()) {
                                    var33 = 321;
                                    if (var21 == 1 && var32 >= var33 - 20 && var32 <= var33 + 20) {
                                       UserComparator6.Login_promptCredentials(true);
                                    }

                                    return;
                                 }
                              } while(var9.field1832 != 84 && var9.field1832 != 13);

                              UserComparator6.Login_promptCredentials(true);
                           }
                        }
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZB)I",
      garbageValue = "3"
   )
   static int method626(int var0, Script var1, boolean var2) {
      if (var0 == 3300) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.cycle;
         return 1;
      } else {
         int var3;
         int var4;
         if (var0 == 3301) {
            class302.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class6.method17(var3, var4);
            return 1;
         } else if (var0 == 3302) {
            class302.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = DefaultsGroup.ItemContainer_getCount(var3, var4);
            return 1;
         } else if (var0 == 3303) {
            class302.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ZoneOperation.method1535(var3, var4);
            return 1;
         } else if (var0 == 3304) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapArea.getInvDefinition(var3).size;
            return 1;
         } else if (var0 == 3305) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
            return 1;
         } else if (var0 == 3306) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.levels[var3];
            return 1;
         } else if (var0 == 3307) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.experience[var3];
            return 1;
         } else {
            int var5;
            if (var0 == 3308) {
               var3 = class103.Client_plane;
               var4 = (class387.localPlayer.x >> 7) + ParamComposition.baseX;
               var5 = (class387.localPlayer.y >> 7) + Client.baseY;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if (var0 == 3309) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if (var0 == 3310) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3 >> 28;
               return 1;
            } else if (var0 == 3311) {
               var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3 & 16383;
               return 1;
            } else if (var0 == 3312) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
               return 1;
            } else if (var0 == 3313) {
               class302.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class6.method17(var3, var4);
               return 1;
            } else if (var0 == 3314) {
               class302.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = DefaultsGroup.ItemContainer_getCount(var3, var4);
               return 1;
            } else if (var0 == 3315) {
               class302.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = ZoneOperation.method1535(var3, var4);
               return 1;
            } else if (var0 == 3316) {
               if (Client.staffModLevel >= 2) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.staffModLevel;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3317) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.rebootTimer;
               return 1;
            } else if (var0 == 3318) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.worldId;
               return 1;
            } else if (var0 == 3321) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.runEnergy / 100;
               return 1;
            } else if (var0 == 3322) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.weight;
               return 1;
            } else if (var0 == 3323) {
               if (Client.playerMod) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3324) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.worldProperties;
               return 1;
            } else if (var0 == 3325) {
               class302.Interpreter_intStackSize -= 4;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
               int var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3;
               return 1;
            } else if (var0 == 3326) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.lastMouseRecordX;
               return 1;
            } else if (var0 == 3327) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.lastMouseRecordY;
               return 1;
            } else if (var0 == 3331) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.runEnergy;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
