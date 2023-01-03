import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("f")
   static int field1051 = 1;
   @ObfuscatedName("u")
   static int field1053 = 1;
   @ObfuscatedName("i")
   static int[] Tiles_hueMultiplier;
   @ObfuscatedName("mw")
   static int menuY;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lgz;"
   )
   NPCComposition definition;
   @ObfuscatedName("e")
   String nameChange = "";
   @ObfuscatedName("x")
   int field1048 = 31;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lqz;"
   )
   class467 field1049;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lgp;"
   )
   NewShit field1050;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lgp;"
   )
   NewShit field1052;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1631971802"
   )
   void method590(String var1) {
      this.nameChange = var1 == null ? "" : var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lhh;",
      garbageValue = "-1279733976"
   )
   protected final Model getModel() {
      if (this.definition == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? AABB.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || super.idleSequence == super.movementSequence && var1 != null ? null : AABB.SequenceDefinition_get(super.movementSequence);
         Model var3 = this.definition.method966(var1, super.sequenceFrame, var2, super.movementFrame, this.field1050);
         if (var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            int var4 = var3.indicesCount;
            if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               Model var5 = ClanSettings.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
               if (var5 != null) {
                  var5.offsetBy(0, -super.spotAnimHeight, 0);
                  Model[] var6 = new Model[]{var3, var5};
                  var3 = new Model(var6, 2);
               }
            }

            if (this.definition.size == 1) {
               var3.isSingleTile = true;
            }

            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2180 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "939145985"
   )
   void method574(int var1) {
      this.field1048 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1988661958"
   )
   boolean method591(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1048 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1271311386"
   )
   final String method577() {
      if (!this.nameChange.isEmpty()) {
         return this.nameChange;
      } else {
         NPCComposition var1 = this.definition;
         if (var1.transforms != null) {
            var1 = var1.transform();
            if (var1 == null) {
               var1 = this.definition;
            }
         }

         return var1.name;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(ILgs;B)V",
      garbageValue = "-17"
   )
   final void move(int var1, MoveSpeed var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if (var1 == 0) {
         --var3;
         ++var4;
      }

      if (var1 == 1) {
         ++var4;
      }

      if (var1 == 2) {
         ++var3;
         ++var4;
      }

      if (var1 == 3) {
         --var3;
      }

      if (var1 == 4) {
         ++var3;
      }

      if (var1 == 5) {
         --var3;
         --var4;
      }

      if (var1 == 6) {
         --var4;
      }

      if (var1 == 7) {
         ++var3;
         --var4;
      }

      if (super.sequence != -1 && AABB.SequenceDefinition_get(super.sequence).field1794 == 1) {
         super.sequence = -1;
      }

      if (super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var5 = super.pathLength; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "-468996840"
   )
   final void method576(int var1, int var2, boolean var3) {
      if (super.sequence != -1 && AABB.SequenceDefinition_get(super.sequence).field1794 == 1) {
         super.sequence = -1;
      }

      if (!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if (super.pathLength < 9) {
               ++super.pathLength;
            }

            for(int var6 = super.pathLength; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = MoveSpeed.WALK;
            return;
         }
      }

      super.pathLength = 0;
      super.field1004 = 0;
      super.field991 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field933 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + super.field933 * 64;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "114"
   )
   int[] method585() {
      return this.field1049 != null ? this.field1049.method2408() : this.definition.method961();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(B)[S",
      garbageValue = "79"
   )
   short[] method578() {
      return this.field1049 != null ? this.field1049.method2409() : this.definition.method964();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(IISI)V",
      garbageValue = "1336672694"
   )
   void method579(int var1, int var2, short var3) {
      if (this.field1049 == null) {
         this.field1049 = new class467(this.definition);
      }

      this.field1049.method2410(var1, var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "([I[SI)V",
      garbageValue = "-1499310121"
   )
   void method580(int[] var1, short[] var2) {
      if (this.field1049 == null) {
         this.field1049 = new class467(this.definition);
      }

      this.field1049.method2411(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-4"
   )
   void method581() {
      this.field1049 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lgp;I)V",
      garbageValue = "-812185885"
   )
   void method582(NewShit var1) {
      this.field1052 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)Lgp;",
      garbageValue = "894608808"
   )
   NewShit method583() {
      return this.field1052;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lgp;I)V",
      garbageValue = "-1612778242"
   )
   void method584(NewShit var1) {
      this.field1050 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2124571860"
   )
   final boolean isVisible() {
      return this.definition != null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-222403464"
   )
   void method586() {
      this.field1052 = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "611713256"
   )
   void method587() {
      this.field1050 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "98652591"
   )
   static int method573(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         var3 = ObjTypeCustomisation.getWidget(var4);
      } else {
         var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
      }

      int var10;
      if (var0 == 1100) {
         class87.Interpreter_intStackSize -= 2;
         var10 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         int var6 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         if (var3.type == 12) {
            class303 var7 = var3.method1724();
            if (var7 != null && var7.method1643(var10, var6)) {
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
         var3.color = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1102) {
         var3.fill = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1103) {
         var3.transparencyTop = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1104) {
         var3.lineWid = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1105) {
         var3.spriteId2 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1106) {
         var3.spriteAngle = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1107) {
         var3.spriteTiling = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1109) {
         class87.Interpreter_intStackSize -= 6;
         var3.modelOffsetX = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         var3.modelOffsetY = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         var3.modelAngleX = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         var3.modelAngleY = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 3];
         var3.modelAngleZ = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 4];
         var3.modelZoom = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 5];
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1110) {
         var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         if (var10 != var3.sequenceId) {
            var3.sequenceId = var10;
            var3.modelFrame = 0;
            var3.modelFrameCycle = 0;
            class69.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1111) {
         var3.modelOrthog = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
         class69.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1112) {
         String var14 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         if (!var14.equals(var3.text)) {
            var3.text = var14;
            class69.invalidateWidget(var3);
         }

         return 1;
      } else {
         class303 var11;
         if (var0 == 1113) {
            var3.fontId = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (var3.type == 12) {
               var11 = var3.method1724();
               if (var11 != null) {
                  var11.method1648();
               }
            }

            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1114) {
            class87.Interpreter_intStackSize -= 3;
            if (var3.type == 12) {
               var11 = var3.method1724();
               if (var11 != null) {
                  var11.method1644(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                  var11.method1645(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2]);
               }
            } else {
               var3.textXAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var3.textYAlignment = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               var3.textLineHeight = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
            }

            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1115) {
            var3.textShadowed = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1116) {
            var3.outline = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1117) {
            var3.spriteShadow = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1118) {
            var3.spriteFlipV = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1119) {
            var3.spriteFlipH = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1120) {
            class87.Interpreter_intStackSize -= 2;
            var3.scrollWidth = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
            var3.scrollHeight = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
            class69.invalidateWidget(var3);
            if (var4 != -1 && var3.type == 0) {
               class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var4 >> 16], var3, false);
            }

            return 1;
         } else if (var0 == 1121) {
            class262.resumePauseWidget(var3.id, var3.childIndex);
            Client.meslayerContinueWidget = var3;
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1122) {
            var3.spriteId = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1123) {
            var3.color2 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1124) {
            var3.transparencyBot = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            class69.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1125) {
            var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            FillMode var12 = (FillMode)World.findEnumerated(UrlRequest.FillMode_values(), var10);
            if (var12 != null) {
               var3.fillMode = var12;
               class69.invalidateWidget(var3);
            }

            return 1;
         } else {
            boolean var5;
            if (var0 == 1126) {
               var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               var3.field2899 = var5;
               return 1;
            } else if (var0 == 1127) {
               var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               var3.modelTransparency = var5;
               return 1;
            } else if (var0 == 1129) {
               var3.field2902 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               class69.invalidateWidget(var3);
               return 1;
            } else if (var0 == 1130) {
               var3.method1746(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize], TaskHandler.urlRequester, class154.method823());
               return 1;
            } else if (var0 == 1131) {
               class87.Interpreter_intStackSize -= 2;
               var3.method1725(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
               return 1;
            } else if (var0 == 1132) {
               var3.method1720(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               return 1;
            } else {
               class298 var13;
               if (var0 == 1133) {
                  --class87.Interpreter_intStackSize;
                  var13 = var3.method1748();
                  if (var13 != null) {
                     var13.field2800 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1134) {
                  --class87.Interpreter_intStackSize;
                  var13 = var3.method1748();
                  if (var13 != null) {
                     var13.field2802 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1135) {
                  --Interpreter.Interpreter_stringStackSize;
                  var11 = var3.method1724();
                  if (var11 != null) {
                     var3.text2 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                  }

                  return 1;
               } else if (var0 == 1136) {
                  --class87.Interpreter_intStackSize;
                  var13 = var3.method1748();
                  if (var13 != null) {
                     var13.field2801 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1137) {
                  --class87.Interpreter_intStackSize;
                  var11 = var3.method1724();
                  if (var11 != null && var11.method1640(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1138) {
                  --class87.Interpreter_intStackSize;
                  var11 = var3.method1724();
                  if (var11 != null && var11.method1641(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1139) {
                  --class87.Interpreter_intStackSize;
                  var11 = var3.method1724();
                  if (var11 != null && var11.method1642(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize])) {
                     class69.invalidateWidget(var3);
                  }

                  return 1;
               } else {
                  class303 var9;
                  if (var0 == 1140) {
                     var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     Client.field417.method1065();
                     var9 = var3.method1724();
                     if (var9 != null && var9.method1635(var5)) {
                        if (var5) {
                           Client.field417.method1063(var3);
                        }

                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1141) {
                     var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     if (!var5 && Client.field417.method1064() == var3) {
                        Client.field417.method1065();
                        class69.invalidateWidget(var3);
                     }

                     var9 = var3.method1724();
                     if (var9 != null) {
                        var9.method1636(var5);
                     }

                     return 1;
                  } else if (var0 == 1142) {
                     class87.Interpreter_intStackSize -= 2;
                     var11 = var3.method1724();
                     if (var11 != null && var11.method1656(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1])) {
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1143) {
                     --class87.Interpreter_intStackSize;
                     var11 = var3.method1724();
                     if (var11 != null && var11.method1656(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize])) {
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1144) {
                     --class87.Interpreter_intStackSize;
                     var11 = var3.method1724();
                     if (var11 != null) {
                        var11.method1697(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize]);
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1145) {
                     --class87.Interpreter_intStackSize;
                     var11 = var3.method1724();
                     if (var11 != null) {
                        var11.method1646(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1146) {
                     --class87.Interpreter_intStackSize;
                     var11 = var3.method1724();
                     if (var11 != null) {
                        var11.method1703(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1147) {
                     --class87.Interpreter_intStackSize;
                     var11 = var3.method1724();
                     if (var11 != null) {
                        var11.method1684(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize]);
                        class69.invalidateWidget(var3);
                     }

                     return 1;
                  } else {
                     class28 var8;
                     if (var0 == 1148) {
                        class87.Interpreter_intStackSize -= 2;
                        var8 = var3.method1737();
                        if (var8 != null) {
                           var8.method107(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1149) {
                        class87.Interpreter_intStackSize -= 2;
                        var8 = var3.method1737();
                        if (var8 != null) {
                           var8.method104((char)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
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

   @ObfuscatedName("mn")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)Z",
      garbageValue = "1009858394"
   )
   static final boolean method592(Widget var0) {
      int var1 = var0.contentType;
      if (var1 == 205) {
         Client.logoutTimer = 250;
         return true;
      } else {
         int var2;
         int var3;
         if (var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.playerAppearance.changeAppearance(var2, var3 == 1);
         }

         if (var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.playerAppearance.method1623(var2, var3 == 1);
         }

         if (var1 == 324) {
            Client.playerAppearance.method1624(0);
         }

         if (var1 == 325) {
            Client.playerAppearance.method1624(1);
         }

         if (var1 == 326) {
            PacketBufferNode var4 = class136.getPacketBufferNode(ClientPacket.field2434, Client.packetWriter.isaacCipher);
            Client.playerAppearance.write(var4.packetBuffer);
            Client.packetWriter.addNode(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
