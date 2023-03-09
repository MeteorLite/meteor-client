import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nq")
@Implements("Language")
public class Language implements class352 {
   @ObfuscatedName("wx")
   @ObfuscatedSignature(
      descriptor = "Lnb;"
   )
   public static class350 field3504;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   @Export("Language_EN")
   public static final Language Language_EN;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   static final Language field3497;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   @Export("Language_FR")
   public static final Language Language_FR;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   static final Language field3499;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   static final Language field3500;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   @Export("Language_ES")
   public static final Language Language_ES;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lnq;"
   )
   static final Language field3502;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "[Lnq;"
   )
   public static final Language[] field3498;
   @ObfuscatedName("ax")
   @Export("Tiles_lightness")
   static int[] Tiles_lightness;
   @ObfuscatedName("aq")
   final String field3496;
   @ObfuscatedName("ap")
   @Export("language")
   final String language;
   @ObfuscatedName("ar")
   @Export("id")
   final int id;

   static {
      Language_EN = new Language("EN", "en", "English", ModeWhere.field3514, 0, "GB");
      field3497 = new Language("DE", "de", "German", ModeWhere.field3514, 1, "DE");
      Language_FR = new Language("FR", "fr", "French", ModeWhere.field3514, 2, "FR");
      field3499 = new Language("PT", "pt", "Portuguese", ModeWhere.field3514, 3, "BR");
      field3500 = new Language("NL", "nl", "Dutch", ModeWhere.field3521, 4, "NL");
      Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3521, 5, "ES");
      field3502 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3514, 6, "MX");
      Language[] var0 = method1894();
      field3498 = new Language[var0.length];
      Language[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Language var3 = var1[var2];
         if (field3498[var3.id] != null) {
            throw new IllegalStateException();
         }

         field3498[var3.id] = var3;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnm;ILjava/lang/String;)V"
   )
   Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
      this.field3496 = var1;
      this.language = var2;
      this.id = var5;
      if (var6 != null) {
         new Locale(var2.substring(0, 2), var6);
      } else {
         new Locale(var2.substring(0, 2));
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "835968120"
   )
   @Export("getLanguage")
   String getLanguage() {
      return this.language;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.getLanguage().toLowerCase(Locale.ENGLISH);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)[Lnq;",
      garbageValue = "1775890171"
   )
   static Language[] method1894() {
      return new Language[]{Language_EN, field3502, field3499, field3500, field3497, Language_ES, Language_FR};
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1699075309"
   )
   @Export("playSong")
   static void playSong(int var0) {
      if (var0 == -1 && !Client.playingJingle) {
         class258.method1464();
      } else if (var0 != -1 && var0 != Client.currentTrackGroupId && WorldMapSectionType.clientPreferences.getCurrentMusicVolume() != 0 && !Client.playingJingle) {
         NPC.method574(2, class308.archive6, var0, 0, WorldMapSectionType.clientPreferences.getCurrentMusicVolume(), false);
      }

      Client.currentTrackGroupId = var0;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      descriptor = "(Ldh;IIB)V",
      garbageValue = "101"
   )
   @Export("performPlayerAnimation")
   static void performPlayerAnimation(Player var0, int var1, int var2) {
      if (var0.sequence == var1 && var1 != -1) {
         int var3 = Coord.SequenceDefinition_get(var1).replyMode;
         if (var3 == 1) {
            var0.sequenceFrame = 0;
            var0.sequenceFrameCycle = 0;
            var0.sequenceDelay = var2;
            var0.currentSequenceFrameIndex = 0;
         }

         if (var3 == 2) {
            var0.currentSequenceFrameIndex = 0;
         }
      } else if (var1 == -1 || var0.sequence == -1 || Coord.SequenceDefinition_get(var1).forcedPriority >= Coord.SequenceDefinition_get(var0.sequence).forcedPriority) {
         var0.sequence = var1;
         var0.sequenceFrame = 0;
         var0.sequenceFrameCycle = 0;
         var0.sequenceDelay = var2;
         var0.currentSequenceFrameIndex = 0;
         var0.field1004 = var0.pathLength;
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      descriptor = "(IIIIZI)V",
      garbageValue = "-721081490"
   )
   @Export("setViewportShape")
   static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
      if (var2 < 1) {
         var2 = 1;
      }

      if (var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      int var6;
      if (var5 < 0) {
         var6 = Client.field418;
      } else if (var5 >= 100) {
         var6 = Client.field616;
      } else {
         var6 = (Client.field616 - Client.field418) * var5 / 100 + Client.field418;
      }

      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if (var7 < Client.field621) {
         var10 = Client.field621;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 > Client.field620) {
            var6 = Client.field620;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if (var7 > Client.field622) {
         var10 = Client.field622;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 < Client.field619) {
            var6 = Client.field619;
            var8 = var10 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      Client.viewportZoom = var3 * var6 / 334;
      if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         class28.method123(var2, var3);
      }

      Client.viewportOffsetX = var0;
      Client.viewportOffsetY = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      descriptor = "(Lmy;II)I",
      garbageValue = "-227067391"
   )
   static final int method1895(Widget var0, int var1) {
      if (var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
         try {
            int[] var2 = var0.cs1Instructions[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if (var6 == 0) {
                  return var3;
               }

               if (var6 == 1) {
                  var7 = Client.currentLevels[var2[var4++]];
               }

               if (var6 == 2) {
                  var7 = Client.levels[var2[var4++]];
               }

               if (var6 == 3) {
                  var7 = Client.experience[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if (var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapSection1.getWidget(var9);
                  var11 = var2[var4++];
                  if (var11 != -1 && (!ParamComposition.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if (var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.field2963[var12];
                        }
                     }
                  }
               }

               if (var6 == 5) {
                  var7 = Varps.Varps_main[var2[var4++]];
               }

               if (var6 == 6) {
                  var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
               }

               if (var6 == 7) {
                  var7 = Varps.Varps_main[var2[var4++]] * 100 / '뜛';
               }

               if (var6 == 8) {
                  var7 = BuddyRankComparator.localPlayer.combatLevel;
               }

               if (var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if (Skills.Skills_enabled[var9]) {
                        var7 += Client.levels[var9];
                     }
                  }
               }

               if (var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = WorldMapSection1.getWidget(var9);
                  var11 = var2[var4++];
                  if (var11 != -1 && (!ParamComposition.ItemDefinition_get(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if (var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if (var6 == 11) {
                  var7 = Client.runEnergy;
               }

               if (var6 == 12) {
                  var7 = Client.weight;
               }

               if (var6 == 13) {
                  var9 = Varps.Varps_main[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0 ? 1 : 0;
               }

               if (var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class17.getVarbit(var9);
               }

               if (var6 == 15) {
                  var8 = 1;
               }

               if (var6 == 16) {
                  var8 = 2;
               }

               if (var6 == 17) {
                  var8 = 3;
               }

               if (var6 == 18) {
                  var7 = (BuddyRankComparator.localPlayer.x >> 7) + GameEngine.baseX;
               }

               if (var6 == 19) {
                  var7 = (BuddyRankComparator.localPlayer.y >> 7) + class178.baseY;
               }

               if (var6 == 20) {
                  var7 = var2[var4++];
               }

               if (var8 == 0) {
                  if (var5 == 0) {
                     var3 += var7;
                  }

                  if (var5 == 1) {
                     var3 -= var7;
                  }

                  if (var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if (var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
