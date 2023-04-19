import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class31 {
   @ObfuscatedName("af")
   public static Applet field90 = null;
   @ObfuscatedName("an")
   public static String field91 = "";
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "[Lcl;"
    )
    static World[] World_worlds;
   @ObfuscatedName("ai")
   static int[] field92;
    @ObfuscatedName("js")
    @ObfuscatedSignature(
            descriptor = "Lie;"
    )
    static Scene scene;
    @ObfuscatedName("kg")
    @ObfuscatedSignature(
            descriptor = "[Ltc;"
    )
    static IndexedSprite[] modIconSprites;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1319661382"
   )
   public static String method133(String var0) {
      return var0 != null && !var0.isEmpty() && var0.charAt(0) != '#' ? var0 : "";
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "14"
   )
   static int method135(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var3 = class165.getWidget(var4);
      } else {
         var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
      }

      int var10;
      if (var0 == 1100) {
         Interpreter.Interpreter_intStackSize -= 2;
         var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (var3.type == 12) {
            class314 var7 = var3.method1815();
            if (var7 != null && var7.method1713(var10, var6)) {
               class144.invalidateWidget(var3);
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

            class144.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1101) {
         var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1102) {
         var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1103) {
         var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1104) {
         var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1105) {
         var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1106) {
         var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1107) {
         var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1109) {
         Interpreter.Interpreter_intStackSize -= 6;
         var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
         var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1110) {
         var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         if (var10 != var3.sequenceId) {
            var3.sequenceId = var10;
            var3.modelFrame = 0;
            var3.modelFrameCycle = 0;
            class144.invalidateWidget(var3);
         }

         return 1;
      } else if (var0 == 1111) {
         var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class144.invalidateWidget(var3);
         return 1;
      } else if (var0 == 1112) {
         String var14 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         if (!var14.equals(var3.text)) {
            var3.text = var14;
            class144.invalidateWidget(var3);
         }

         return 1;
      } else {
         class314 var11;
         if (var0 == 1113) {
            var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var3.type == 12) {
               var11 = var3.method1815();
               if (var11 != null) {
                  var11.method1771();
               }
            }

            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1114) {
            Interpreter.Interpreter_intStackSize -= 3;
            if (var3.type == 12) {
               var11 = var3.method1815();
               if (var11 != null) {
                  var11.method1714(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                  var11.method1715(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
               }
            } else {
               var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            }

            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1115) {
            var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1116) {
            var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1117) {
            var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1118) {
            var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1119) {
            var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1120) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            class144.invalidateWidget(var3);
            if (var4 != -1 && var3.type == 0) {
               WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var4 >> 16], var3, false);
            }

            return 1;
         } else if (var0 == 1121) {
            class81.resumePauseWidget(var3.id, var3.childIndex);
            Client.meslayerContinueWidget = var3;
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1122) {
            var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1123) {
            var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1124) {
            var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class144.invalidateWidget(var3);
            return 1;
         } else if (var0 == 1125) {
            var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            FillMode var12 = (FillMode)StructComposition.findEnumerated(GrandExchangeOffer.FillMode_values(), var10);
            if (var12 != null) {
               var3.fillMode = var12;
               class144.invalidateWidget(var3);
            }

            return 1;
         } else {
            boolean var5;
            if (var0 == 1126) {
               var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               var3.field2913 = var5;
               return 1;
            } else if (var0 == 1127) {
               var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               var3.modelTransparency = var5;
               return 1;
            } else if (var0 == 1129) {
               var3.field2916 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
               class144.invalidateWidget(var3);
               return 1;
            } else if (var0 == 1130) {
               var3.method1803(Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize], class14.urlRequester, Projectile.method450());
               return 1;
            } else if (var0 == 1131) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3.method1824(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
               return 1;
            } else if (var0 == 1132) {
               var3.method1805(Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               return 1;
            } else {
               class309 var13;
               if (var0 == 1133) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1817();
                  if (var13 != null) {
                     var13.field2818 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1134) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1817();
                  if (var13 != null) {
                     var13.field2816 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1135) {
                  --SecureRandomCallable.Interpreter_stringStackSize;
                  var11 = var3.method1815();
                  if (var11 != null) {
                     var3.text2 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                  }

                  return 1;
               } else if (var0 == 1136) {
                  --Interpreter.Interpreter_intStackSize;
                  var13 = var3.method1817();
                  if (var13 != null) {
                     var13.field2817 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1137) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1815();
                  if (var11 != null && var11.method1711(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1138) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1815();
                  if (var11 != null && var11.method1784(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else if (var0 == 1139) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = var3.method1815();
                  if (var11 != null && var11.method1712(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                     class144.invalidateWidget(var3);
                  }

                  return 1;
               } else {
                  class314 var9;
                  if (var0 == 1140) {
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     Client.field590.method1138();
                     var9 = var3.method1815();
                     if (var9 != null && var9.method1706(var5)) {
                        if (var5) {
                           Client.field590.method1137(var3);
                        }

                        class144.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1141) {
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     if (!var5 && Client.field590.method1144() == var3) {
                        Client.field590.method1138();
                        class144.invalidateWidget(var3);
                     }

                     var9 = var3.method1815();
                     if (var9 != null) {
                        var9.method1707(var5);
                     }

                     return 1;
                  } else if (var0 == 1142) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     var11 = var3.method1815();
                     if (var11 != null && var11.method1725(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1])) {
                        class144.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1143) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1815();
                     if (var11 != null && var11.method1725(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize])) {
                        class144.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1144) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1815();
                     if (var11 != null) {
                        var11.method1717(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                        class144.invalidateWidget(var3);
                     }

                     return 1;
                  } else if (var0 == 1145) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1815();
                     if (var11 != null) {
                        var11.method1705(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1146) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1815();
                     if (var11 != null) {
                        var11.method1719(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                     }

                     return 1;
                  } else if (var0 == 1147) {
                     --Interpreter.Interpreter_intStackSize;
                     var11 = var3.method1815();
                     if (var11 != null) {
                        var11.method1718(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
                        class144.invalidateWidget(var3);
                     }

                     return 1;
                  } else {
                     class27 var8;
                     if (var0 == 1148) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var8 = var3.method1795();
                        if (var8 != null) {
                           var8.method114(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1149) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var8 = var3.method1795();
                        if (var8 != null) {
                           var8.method115((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        }

                        return 1;
                     } else if (var0 == 1150) {
                        var3.method1802(Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize], class14.urlRequester);
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

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "57"
   )
   static int method134(int var0, Script var1, boolean var2) {
      Widget var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if (var0 == 2500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if (var0 == 2501) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if (var0 == 2502) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if (var0 == 2503) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if (var0 == 2504) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
         return 1;
      } else if (var0 == 2505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

    @ObfuscatedName("hc")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1902768187"
    )
    static final void logOut() {
      Client.packetWriter.close();
      FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
      class294.method1607();
      class4.method9();
      class14.method56();
      class173.method958();
      class379.method2042();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.SequenceDefinition_cachedFrames.clear();
      SequenceDefinition.SequenceDefinition_cachedModel.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
      VarbitComposition.VarbitDefinition_cached.clear();
      VarpDefinition.VarpDefinition_cached.clear();
      class160.HitSplatDefinition_cachedSprites.method2418();
      MenuAction.HitSplatDefinition_cached.method2418();
      class432.method2285();
      GrandExchangeEvent.method1922();
      InterfaceParent.method488();
      class165.method921();
      Strings.method1854();
      class383.method2087();
      DbRowType.DBRowType_cache.clear();
      Client.Widget_cachedModels.clear();
      Client.Widget_cachedFonts.clear();
      GrandExchangeOfferTotalQuantityComparator.method1913();
      class18.method75();
      ((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      Client.archive5.method2127();
      DevicePcmPlayerProvider.field67.clearFiles();
      GameBuild.archive7.clearFiles();
      class85.archive4.clearFiles();
      class426.field3811.clearFiles();
      GrandExchangeOfferTotalQuantityComparator.archive9.clearFiles();
      class399.archive6.clearFiles();
      FloorUnderlayDefinition.archive11.clearFiles();
      class452.archive8.clearFiles();
      WorldMapLabelSize.field2285.clearFiles();
      NetFileRequest.archive10.clearFiles();
      class195.field1645.clearFiles();
      class126.archive12.clearFiles();
      PcmPlayer.field211.clearFiles();
      scene.clear();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      Client.field590.method1138();
      System.gc();
      class297.musicPlayerStatus = 1;
      class297.musicTrackArchive = null;
      class379.musicTrackGroupId = -1;
      VarpDefinition.musicTrackFileId = -1;
      class100.musicTrackVolume = 0;
      class120.musicTrackBoolean = false;
      class162.pcmSampleLength = 2;
      Client.currentTrackGroupId = -1;
      Client.playingJingle = false;
      StructComposition.method1068();
      class138.updateGameState(10);
   }
}
