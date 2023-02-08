import java.util.Comparator;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
   @ObfuscatedName("f")
   boolean filterWorlds;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
           descriptor = "(Lmv;Lmv;I)I",
           garbageValue = "883548151"
   )
   int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if (var2.world == var1.world) {
         return 0;
      } else {
         if (this.filterWorlds) {
            if (Client.worldId == var1.world) {
               return -1;
            }

            if (var2.world == Client.worldId) {
               return 1;
            }
         }

         return var1.world < var2.world ? -1 : 1;
      }
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(FFFFLda;S)V",
      garbageValue = "18728"
   )
   static void method337(float var0, float var1, float var2, float var3, class125 var4) {
      float var5 = var1 - var0;
      float var6 = var2 - var1;
      float var7 = var3 - var2;
      float var8 = var6 - var5;
      var4.field1215 = var7 - var6 - var8;
      var4.field1225 = var8 + var8 + var8;
      var4.field1213 = var5 + var5 + var5;
      var4.field1212 = var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "924609426"
   )
   static int method340(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         var3 = class133.getWidget(var4);
      } else {
         var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
      }

      int var10;
      if (var0 == 1100) {
         class302.Interpreter_intStackSize -= 2;
         var10 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         int var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         if (var3.type == 12) {
            class307 var7 = var3.method1750();
            if (var7 != null && var7.method1648(var10, var6)) {
               LoginScreenAnimation.invalidateWidget(var3);
            }
         } else {
            var3.scrollX = var10;
            if (var3.scrollX > var3.scrollWidth - var3.width) {
               var3.scrollX = var3.scrollWidth - var3.width;
            }

            if (var3.scrollX < 0) {
               var3.scrollX = 0;
            }

            var3.scrollY = var6;
            if (var3.scrollY > var3.scrollHeight - var3.height) {
               var3.scrollY = var3.scrollHeight - var3.height;
            }

            if (var3.scrollY < 0) {
               var3.scrollY = 0;
            }

            LoginScreenAnimation.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1101) {
         var3.color = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1102) {
         var3.fill = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1103) {
         var3.transparencyTop = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1104) {
         var3.lineWid = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1105) {
         var3.spriteId2 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1106) {
         var3.spriteAngle = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1107) {
         var3.spriteTiling = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1109) {
         class302.Interpreter_intStackSize -= 6;
         var3.modelOffsetX = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var3.modelOffsetY = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         var3.modelAngleX = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         var3.modelAngleY = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3];
         var3.modelAngleZ = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 4];
         var3.modelZoom = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 5];
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1110) {
         var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         if (var10 != var3.sequenceId) {
            var3.sequenceId = var10;
            var3.modelFrame = 0;
            var3.modelFrameCycle = 0;
            LoginScreenAnimation.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1111) {
         var3.modelOrthog = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         LoginScreenAnimation.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1112) {
         String var14 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
         if (!var14.equals(var3.text)) {
            var3.text = var14;
            LoginScreenAnimation.invalidateWidget(var3);
         }

         return 1;
      } else {
         class307 var11;
         if (var0 == 1113) {
            var3.fontId = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (var3.type == 12) {
               var11 = var3.method1750();
               if (var11 != null) {
                  var11.method1701();
               }
            }

            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1114) {
            class302.Interpreter_intStackSize -= 3;
            if (var3.type == 12) {
               var11 = var3.method1750();
               if (var11 != null) {
                  var11.method1711(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
                  var11.method1649(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2]);
               }
            } else {
               var3.textXAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var3.textYAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var3.textLineHeight = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
            }

            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1115) {
            var3.textShadowed = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1116) {
            var3.outline = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1117) {
            var3.spriteShadow = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1118) {
            var3.spriteFlipV = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1119) {
            var3.spriteFlipH = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1120) {
            class302.Interpreter_intStackSize -= 2;
            var3.scrollWidth = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var3.scrollHeight = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            LoginScreenAnimation.invalidateWidget(var3);
            if (var4 != -1 && var3.type == 0) {
               AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var4 >> 16], var3, false);
            }

            return 1;
         } else if (var0 == 1121) {
            class205.resumePauseWidget(var3.id, var3.childIndex);
            Client.meslayerContinueWidget = var3;
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1122) {
            var3.spriteId = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1123) {
            var3.color2 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1124) {
            var3.transparencyBot = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            LoginScreenAnimation.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1125) {
            var10 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            FillMode var12 = (FillMode)class4.findEnumerated(WorldMapData_0.FillMode_values(), var10);
            if (var12 != null) {
               var3.fillMode = var12;
               LoginScreenAnimation.invalidateWidget(var3);
            }

            return 1;
         } else {
            boolean var5;
            if (var0 == 1126) {
               var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
               var3.field2912 = var5;
               return 1;
            } else if (var0 == 1127) {
               var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
               var3.modelTransparency = var5;
               return 1;
            } else if (var0 == 1129) {
               var3.field2894 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               LoginScreenAnimation.invalidateWidget(var3);
               return 1;
            } else if (var0 == 1130) {
               var3.method1736(Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize], class245.urlRequester, class17.method64());
               return 1;
            } else if (var0 == 1131) {
               class302.Interpreter_intStackSize -= 2;
               var3.method1737(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
               return 1;
            } else if (var0 == 1132) {
               var3.method1738(Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
               return 1;
            } else {
               class302 var13;
               if (var0 == 1133) {
                  --class302.Interpreter_intStackSize;
                  var13 = var3.method1745();
                  if (var13 != null) {
                     var13.field2794 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1134) {
                  --class302.Interpreter_intStackSize;
                  var13 = var3.method1745();
                  if (var13 != null) {
                     var13.field2797 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1135) {
                  --class20.Interpreter_stringStackSize;
                  var11 = var3.method1750();
                  if (var11 != null) {
                     var3.text2 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                  }

                  return 1;
               } else if (var0 == 1136) {
                  --class302.Interpreter_intStackSize;
                  var13 = var3.method1745();
                  if (var13 != null) {
                     var13.field2795 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1137) {
                  --class302.Interpreter_intStackSize;
                  var11 = var3.method1750();
                  if (var11 != null && var11.method1646(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize])) {
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1138) {
                  --class302.Interpreter_intStackSize;
                  var11 = var3.method1750();
                  if (var11 != null && var11.method1647(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize])) {
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1139) {
                  --class302.Interpreter_intStackSize;
                  var11 = var3.method1750();
                  if (var11 != null && var11.method1717(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize])) {
                     LoginScreenAnimation.invalidateWidget(var3);
                  }

                  return 1;
               } else {
                  class307 var9;
                  if (var0 == 1140) {
                     var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     Client.field617.method1066();
                     var9 = var3.method1750();
                     if (var9 != null && var9.method1708(var5)) {
                        if (var5) {
                           Client.field617.method1065(var3);
                        }

                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1141) {
                     var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     if (!var5 && Client.field617.method1072() == var3) {
                        Client.field617.method1066();
                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     var9 = var3.method1750();
                     if (var9 != null) {
                        var9.method1643(var5);
                     }

                     return 1;
                  } else if (var0 == 1142) {
                     class302.Interpreter_intStackSize -= 2;
                     var11 = var3.method1750();
                     if (var11 != null && var11.method1700(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1])) {
                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1143) {
                     --class302.Interpreter_intStackSize;
                     var11 = var3.method1750();
                     if (var11 != null && var11.method1700(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize])) {
                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1144) {
                     --class302.Interpreter_intStackSize;
                     var11 = var3.method1750();
                     if (var11 != null) {
                        var11.method1651(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1145) {
                     --class302.Interpreter_intStackSize;
                     var11 = var3.method1750();
                     if (var11 != null) {
                        var11.method1650(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1146) {
                     --class302.Interpreter_intStackSize;
                     var11 = var3.method1750();
                     if (var11 != null) {
                        var11.method1653(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1147) {
                     --class302.Interpreter_intStackSize;
                     var11 = var3.method1750();
                     if (var11 != null) {
                        var11.method1652(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
                        LoginScreenAnimation.invalidateWidget(var3);
                     }

                     return 1;
                  } else {
                     class27 var8;
                     if (var0 == 1148) {
                        class302.Interpreter_intStackSize -= 2;
                        var8 = var3.method1746();
                        if (var8 != null) {
                           var8.method97(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1149) {
                        class302.Interpreter_intStackSize -= 2;
                        var8 = var3.method1746();
                        if (var8 != null) {
                           var8.method106((char)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-290172946"
   )
   static int method339(int var0, Script var1, boolean var2) {
      boolean var3 = true;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         var3 = false;
      } else {
         var4 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
      }

      int var11;
      if (var0 == 1300) {
         var11 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] - 1;
         if (var11 >= 0 && var11 <= 9) {
            var4.setAction(var11, Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize]);
            return 1;
         } else {
            --class20.Interpreter_stringStackSize;
            return 1;
         }
      } else {
         int var6;
         if (var0 == 1301) {
            class302.Interpreter_intStackSize -= 2;
            var11 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            var4.parent = class135.getWidgetChild(var11, var6);
            return 1;
         } else if (var0 == 1302) {
            var4.isScrollBar = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
            return 1;
         } else if (var0 == 1303) {
            var4.dragZoneSize = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            return 1;
         } else if (var0 == 1304) {
            var4.dragThreshold = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            return 1;
         } else if (var0 == 1305) {
            var4.dataText = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            return 1;
         } else if (var0 == 1306) {
            var4.spellActionName = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            return 1;
         } else if (var0 == 1307) {
            var4.actions = null;
            return 1;
         } else if (var0 == 1308) {
            var4.prioritizeMenuEntry = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
            return 1;
         } else if (var0 == 1309) {
            --class302.Interpreter_intStackSize;
            return 1;
         } else {
            int var7;
            byte[] var9;
            if (var0 != 1350) {
               byte var5;
               if (var0 == 1351) {
                  class302.Interpreter_intStackSize -= 2;
                  var5 = 10;
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]};
                  byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]};
                  ObjectSound.Widget_setKey(var4, var5, var9, var10);
                  return 1;
               } else if (var0 == 1352) {
                  class302.Interpreter_intStackSize -= 3;
                  var11 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] - 1;
                  var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                  var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
                  if (var11 >= 0 && var11 <= 9) {
                     ViewportMouse.Widget_setKeyRate(var4, var11, var6, var7);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (var0 == 1353) {
                  var5 = 10;
                  var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  ViewportMouse.Widget_setKeyRate(var4, var5, var6, var7);
                  return 1;
               } else if (var0 == 1354) {
                  --class302.Interpreter_intStackSize;
                  var11 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] - 1;
                  if (var11 >= 0 && var11 <= 9) {
                     class145.Widget_setKeyIgnoreHeld(var4, var11);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (var0 == 1355) {
                  var5 = 10;
                  class145.Widget_setKeyIgnoreHeld(var4, var5);
                  return 1;
               } else {
                  return 2;
               }
            } else {
               byte[] var8 = null;
               var9 = null;
               if (var3) {
                  class302.Interpreter_intStackSize -= 10;

                  for(var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + class302.Interpreter_intStackSize] >= 0; var7 += 2) {
                     ;
                  }

                  if (var7 > 0) {
                     var8 = new byte[var7 / 2];
                     var9 = new byte[var7 / 2];

                     for(var7 -= 2; var7 >= 0; var7 -= 2) {
                        var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class302.Interpreter_intStackSize];
                        var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class302.Interpreter_intStackSize + 1];
                     }
                  }
               } else {
                  class302.Interpreter_intStackSize -= 2;
                  var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]};
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]};
               }

               var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] - 1;
               if (var7 >= 0 && var7 <= 9) {
                  ObjectSound.Widget_setKey(var4, var7, var8, var9);
                  return 1;
               } else {
                  throw new RuntimeException();
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-2053256956"
   )
   static int method338(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 == 2700) {
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if (var0 == 2701) {
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         if (var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2702) {
         int var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
         if (var4 != null) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
         } else {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2706) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.rootInterface;
         return 1;
      } else if (var0 == 2707) {
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.method1759() ? 1 : 0;
         return 1;
      } else if (var0 == 2708) {
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         return FileSystem.method895(var3);
      } else if (var0 == 2709) {
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         return class308.method1721(var3);
      } else {
         return 2;
      }
   }

   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "5"
   )
   static void method341() {
      if (Client.oculusOrbOnLocalPlayer && class387.localPlayer != null) {
         int var0 = class387.localPlayer.pathX[0];
         int var1 = class387.localPlayer.pathY[0];
         if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
            return;
         }

         class245.oculusOrbFocalPointX = class387.localPlayer.x;
         int var2 = GrandExchangeOfferNameComparator.getTileHeight(class387.localPlayer.x, class387.localPlayer.y, class103.Client_plane) - Client.camFollowHeight;
         if (var2 < Ignored.field3716) {
            Ignored.field3716 = var2;
         }

         UserComparator10.oculusOrbFocalPointY = class387.localPlayer.y;
         Client.oculusOrbOnLocalPlayer = false;
      }

   }
}
