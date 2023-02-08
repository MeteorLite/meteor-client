import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class160 {
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1845674352"
   )
   static int method849(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if (var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if (var0 == 4101) {
            class20.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if (var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3 + ParamComposition.intToString(var4, true);
            return 1;
         } else if (var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if (var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               long var11 = 86400000L * (11745L + (long)var10);
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var17 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
               return 1;
            } else if (var0 != 4105) {
               if (var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if (var0 == 4107) {
                  class20.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = AbstractArchive.method1838(Projectile.compareStrings(Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1], class36.clientLanguage));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if (var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     class302.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var13 = PendingSpawn.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
                     return 1;
                  } else if (var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     class302.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var13 = PendingSpawn.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
                     return 1;
                  } else if (var0 == 4110) {
                     class20.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
                     if (Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if (var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if (var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if (var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class126.isCharPrintable((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class97.isAlphaNumeric((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class155.isCharAlphabetic((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = CollisionMap.isDigit((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     if (var3 != null) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if (var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     class302.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if (var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     StringBuilder var18 = new StringBuilder(var3.length());
                     boolean var16 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if (var7 == '<') {
                           var16 = true;
                        } else if (var7 == '>') {
                           var16 = false;
                        } else if (!var16) {
                           var18.append(var7);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var18.toString();
                     return 1;
                  } else if (var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if (var0 == 4121) {
                     class20.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if (var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else if (var0 == 4123) {
                     class20.Interpreter_stringStackSize -= 3;
                     var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
                     String var15 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 2];
                     if (class387.localPlayer.appearance == null) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var15;
                        return 1;
                     } else {
                        switch(class387.localPlayer.appearance.field2812) {
                        case 0:
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3;
                           break;
                        case 1:
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9;
                           break;
                        case 2:
                        default:
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var15;
                        }

                        return 1;
                     }
                  } else {
                     return 2;
                  }
               }
            } else {
               class20.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
               if (class387.localPlayer.appearance != null && class387.localPlayer.appearance.field2817 != 0) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

    @ObfuscatedName("ge")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-1080663115"
    )
    static void setWindowedMode(int var0) {
      Client.field599 = 0L;
      if (var0 >= 2) {
         Client.isResizable = true;
      } else {
         Client.isResizable = false;
      }

      if (Message.getWindowedMode() == 1) {
         Decimator.client.setMaxCanvasSize(765, 503);
      } else {
         Decimator.client.setMaxCanvasSize(7680, 2160);
      }

      if (Client.gameState >= 25) {
         PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2494, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(Message.getWindowedMode());
         var1.packetBuffer.writeShort(GameEngine.canvasWidth);
         var1.packetBuffer.writeShort(class127.canvasHeight);
         Client.packetWriter.addNode(var1);
      }

   }

    @ObfuscatedName("lr")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "0"
    )
    static final void clanKickUser(String var0) {
      if (class463.friendsChat != null) {
         PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2434, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.addNode(var1);
      }
   }

    @ObfuscatedName("lm")
    @ObfuscatedSignature(
            descriptor = "(Lkz;I)Z",
            garbageValue = "-452016901"
    )
    static boolean isComponentHidden(Widget var0) {
      return var0.isHidden;
   }
}
