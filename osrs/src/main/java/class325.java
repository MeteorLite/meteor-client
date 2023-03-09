import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
public class class325 {
   static {
      Math.sqrt(8192.0D);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "12"
   )
   static int method1797(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var3 = WorldMapSection1.getWidget(var4);
      } else {
         var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
      }

      int var10;
      if (var0 == 1100) {
         Interpreter.Interpreter_intStackSize -= 2;
         var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (var3.type == 12) {
            class310 var7 = var3.method1758();
            if (var7 != null && var7.method1662(var10, var6)) {
               class69.invalidateWidget(var3);
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

            class69.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1101) {
         var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1102) {
         var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1103) {
         var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1104) {
         var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1105) {
         var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1106) {
         var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1107) {
         var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1109) {
         Interpreter.Interpreter_intStackSize -= 6;
         var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
         var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1110) {
         var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         if (var10 != var3.sequenceId) {
            var3.sequenceId = var10;
            var3.modelFrame = 0;
            var3.modelFrameCycle = 0;
            class69.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1111) {
         var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1112) {
         String var14 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
         if (!var14.equals(var3.text)) {
            var3.text = var14;
            class69.invalidateWidget(var3);
         }

         return 1;
      } else {
         class310 var11;
         if (var0 == 1113) {
            var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var3.type == 12) {
               var11 = var3.method1758();
               if (var11 != null) {
                  var11.method1665();
               }
            }

            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1114) {
            Interpreter.Interpreter_intStackSize -= 3;
            if (var3.type == 12) {
               var11 = var3.method1758();
               if (var11 != null) {
                  var11.method1716(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                  var11.method1663(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
               }
            } else {
               var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            }

            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1115) {
            var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1116) {
            var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1117) {
            var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1118) {
            var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1119) {
            var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1120) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            class69.invalidateWidget(var3);
            if (var4 != -1 && var3.type == 0) {
               class278.revalidateWidgetScroll(class155.Widget_interfaceComponents[var4 >> 16], var3, false);
            }

            return 1;
         } else if (var0 == 1121) {
            class130.resumePauseWidget(var3.id, var3.childIndex);
            Client.meslayerContinueWidget = var3;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1122) {
            var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1123) {
            var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1124) {
            var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1125) {
            var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            FillMode var12 = (FillMode)SpriteMask.findEnumerated(GameObject.FillMode_values(), var10);
            if (var12 != null) {
               var3.fillMode = var12;
               class69.invalidateWidget(var3);
            }

            return 1;
         } else {
            boolean var5;
            if (var0 == 1126) {
               var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               var3.field2856 = var5;
               return 1;
            } else if (var0 == 1127) {
               var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               var3.modelTransparency = var5;
               return 1;
            } else if (var0 == 1129) {
               var3.field2872 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
               class69.invalidateWidget(var3);
               return 1;
            } else if (var0 == 1130) {
               var3.method1764(Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize], class345.urlRequester, class138.method743());
               return 1;
            } else if (var0 == 1131) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3.method1748(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
               return 1;
            } else if (var0 == 1132) {
               var3.method1749(Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               return 1;
            } else {
               class305 var13;
               if (var0 == 1133) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1759();
                  if (var13 != null) {
                     var13.field2768 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1134) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1759();
                  if (var13 != null) {
                     var13.field2769 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1135) {
                  --HealthBar.Interpreter_stringStackSize;
                  var11 = var3.method1758();
                  if (var11 != null) {
                     var3.text2 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                  }

                  return 1;
               } else if (var0 == 1136) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1759();
                  if (var13 != null) {
                     var13.field2771 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1137) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1758();
                  if (var11 != null && var11.method1653(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1138) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1758();
                  if (var11 != null && var11.method1660(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1139) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1758();
                  if (var11 != null && var11.method1661(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else {
                  class310 var9;
                  if (var0 == 1140) {
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     Client.field585.method1082();
                     var9 = var3.method1758();
                     if (var9 != null && var9.method1706(var5)) {
                        if (var5) {
                           Client.field585.method1073(var3);
                        }

                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1141) {
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     if (!var5 && Client.field585.method1074() == var3) {
                        Client.field585.method1082();
                        class69.invalidateWidget(var3);
                     }

                     var9 = var3.method1758();
                     if (var9 != null) {
                        var9.method1670(var5);
                     }

                     return 1;
                  } else if (var0 == 1142) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var11 = var3.method1758();
                     if (var11 != null && var11.method1672(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1])) {
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1143) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1758();
                     if (var11 != null && var11.method1672(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1144) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1758();
                     if (var11 != null) {
                        var11.method1711(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1145) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1758();
                     if (var11 != null) {
                        var11.method1686(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1146) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1758();
                     if (var11 != null) {
                        var11.method1714(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1147) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1758();
                     if (var11 != null) {
                        var11.method1664(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else {
                     class27 var8;
                     if (var0 == 1148) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var8 = var3.method1760();
                        if (var8 != null) {
                           var8.method109(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1149) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var8 = var3.method1760();
                        if (var8 != null) {
                           var8.method110((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1150) {
                        var3.method1769(Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize], class345.urlRequester);
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
}
