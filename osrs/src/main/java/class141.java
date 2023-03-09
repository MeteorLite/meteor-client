import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class141 extends class140 {
   @ObfuscatedName("aj")
   int field1297;
   @ObfuscatedName("al")
   boolean field1298;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class141(class143 var1) {
      this.this$0 = var1;
      this.field1297 = -1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1297 = var1.readUnsignedShort();
      this.field1298 = var1.readUnsignedByte() == 1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method798(this.field1297, this.field1298);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(Loe;Loe;Loe;B)V",
      garbageValue = "-39"
   )
   @Export("drawTitle")
   static void drawTitle(Font var0, Font var1, Font var2) {
      Login.xPadding = (GameEngine.canvasWidth - 765) / 2;
      Login.loginBoxX = Login.xPadding + 202;
      Login.loginBoxCenter = Login.loginBoxX + 180;
      int var6;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      byte var23;
      int var24;
      int var25;
      int var38;
      int var41;
      int var52;
      if (Login.worldSelectOpen) {
         if (WorldMapSection2.worldSelectBackSprites == null) {
            WorldMapSection2.worldSelectBackSprites = class279.method1541(class143.archive8, "sl_back", "");
         }

         IndexedSprite[] var35;
         Archive var36;
         if (class279.worldSelectFlagSprites == null) {
            var36 = class143.archive8;
            var38 = var36.getGroupId("sl_flags");
            var6 = var36.getFileId(var38, "");
            var35 = class456.method2330(var36, var38, var6);
            class279.worldSelectFlagSprites = var35;
         }

         if (class353.worldSelectArrows == null) {
            var36 = class143.archive8;
            var38 = var36.getGroupId("sl_arrows");
            var6 = var36.getFileId(var38, "");
            var35 = class456.method2330(var36, var38, var6);
            class353.worldSelectArrows = var35;
         }

         if (class293.worldSelectStars == null) {
            var36 = class143.archive8;
            var38 = var36.getGroupId("sl_stars");
            var6 = var36.getFileId(var38, "");
            var35 = class456.method2330(var36, var38, var6);
            class293.worldSelectStars = var35;
         }

         if (class12.worldSelectLeftSprite == null) {
            class12.worldSelectLeftSprite = class368.SpriteBuffer_getIndexedSpriteByName(class143.archive8, "leftarrow", "");
         }

         if (class208.worldSelectRightSprite == null) {
            class208.worldSelectRightSprite = class368.SpriteBuffer_getIndexedSpriteByName(class143.archive8, "rightarrow", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
         Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
         if (class293.worldSelectStars != null) {
            class293.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
            var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
            class293.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
            var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
         }

         if (class353.worldSelectArrows != null) {
            var52 = Login.xPadding + 280;
            if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
               class353.worldSelectArrows[2].drawAt(var52, 4);
            } else {
               class353.worldSelectArrows[0].drawAt(var52, 4);
            }

            if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
               class353.worldSelectArrows[3].drawAt(var52 + 15, 4);
            } else {
               class353.worldSelectArrows[1].drawAt(var52 + 15, 4);
            }

            var0.draw("World", var52 + 32, 17, 16777215, -1);
            var24 = Login.xPadding + 390;
            if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
               class353.worldSelectArrows[2].drawAt(var24, 4);
            } else {
               class353.worldSelectArrows[0].drawAt(var24, 4);
            }

            if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
               class353.worldSelectArrows[3].drawAt(var24 + 15, 4);
            } else {
               class353.worldSelectArrows[1].drawAt(var24 + 15, 4);
            }

            var0.draw("Players", var24 + 32, 17, 16777215, -1);
            var38 = Login.xPadding + 500;
            if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
               class353.worldSelectArrows[2].drawAt(var38, 4);
            } else {
               class353.worldSelectArrows[0].drawAt(var38, 4);
            }

            if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
               class353.worldSelectArrows[3].drawAt(var38 + 15, 4);
            } else {
               class353.worldSelectArrows[1].drawAt(var38 + 15, 4);
            }

            var0.draw("Location", var38 + 32, 17, 16777215, -1);
            var6 = Login.xPadding + 610;
            if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
               class353.worldSelectArrows[2].drawAt(var6, 4);
            } else {
               class353.worldSelectArrows[0].drawAt(var6, 4);
            }

            if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
               class353.worldSelectArrows[3].drawAt(var6 + 15, 4);
            } else {
               class353.worldSelectArrows[1].drawAt(var6 + 15, 4);
            }

            var0.draw("Type", var6 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
         var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
         Login.hoveredWorldIndex = -1;
         if (WorldMapSection2.worldSelectBackSprites != null) {
            var23 = 88;
            byte var56 = 19;
            var38 = 765 / (var23 + 1) - 1;
            var6 = 480 / (var56 + 1);

            do {
               var41 = var6;
               var8 = var38;
               if (var6 * (var38 - 1) >= World.World_count) {
                  --var38;
               }

               if (var38 * (var6 - 1) >= World.World_count) {
                  --var6;
               }

               if (var38 * (var6 - 1) >= World.World_count) {
                  --var6;
               }
            } while(var6 != var41 || var38 != var8);

            var41 = (765 - var38 * var23) / (var38 + 1);
            if (var41 > 5) {
               var41 = 5;
            }

            var8 = (480 - var6 * var56) / (var6 + 1);
            if (var8 > 5) {
               var8 = 5;
            }

            var9 = (765 - var23 * var38 - var41 * (var38 - 1)) / 2;
            var10 = (480 - var6 * var56 - var8 * (var6 - 1)) / 2;
            var11 = (var6 + World.World_count - 1) / var6;
            Login.worldSelectPagesCount = var11 - var38;
            if (class12.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
               class12.worldSelectLeftSprite.drawAt(8, class143.canvasHeight / 2 - class12.worldSelectLeftSprite.subHeight / 2);
            }

            if (class208.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
               class208.worldSelectRightSprite.drawAt(GameEngine.canvasWidth - class208.worldSelectRightSprite.subWidth - 8, class143.canvasHeight / 2 - class208.worldSelectRightSprite.subHeight / 2);
            }

            var12 = var10 + 23;
            int var45 = var9 + Login.xPadding;
            int var14 = 0;
            boolean var15 = false;
            int var47 = Login.worldSelectPage;

            int var48;
            for(var48 = var6 * var47; var48 < World.World_count && var47 - Login.worldSelectPage < var38; ++var48) {
               World var18 = class260.World_worlds[var48];
               boolean var49 = true;
               String var20 = Integer.toString(var18.population);
               if (var18.population == -1) {
                  var20 = "OFF";
                  var49 = false;
               } else if (var18.population > 1980) {
                  var20 = "FULL";
                  var49 = false;
               }

               int var21 = -1;
               int var22 = 0;
               if (var18.isBeta()) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1106.field1098;
                  } else {
                     var21 = class105.field1101.field1098;
                  }
               } else if (var18.isDeadman()) {
                  var22 = 16711680;
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1096.field1098;
                  } else {
                     var21 = class105.field1095.field1098;
                  }
               } else if (var18.method393()) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1092.field1098;
                  } else {
                     var21 = class105.field1099.field1098;
                  }
               } else if (var18.isPvp()) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1100.field1098;
                  } else {
                     var21 = class105.field1093.field1098;
                  }
               } else if (var18.method391()) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1102.field1098;
                  } else {
                     var21 = class105.field1094.field1098;
                  }
               } else if (var18.method392()) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1097.field1098;
                  } else {
                     var21 = class105.field1103.field1098;
                  }
               }

               if (var21 == -1 || var21 >= WorldMapSection2.worldSelectBackSprites.length) {
                  if (var18.isMembersOnly()) {
                     var21 = class105.field1104.field1098;
                  } else {
                     var21 = class105.field1105.field1098;
                  }
               }

               if (MouseHandler.MouseHandler_x >= var45 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var45 + var23 && MouseHandler.MouseHandler_y < var12 + var56 && var49) {
                  Login.hoveredWorldIndex = var48;
                  WorldMapSection2.worldSelectBackSprites[var21].drawTransOverlayAt(var45, var12, 128, 16777215);
                  var15 = true;
               } else {
                  WorldMapSection2.worldSelectBackSprites[var21].drawAt(var45, var12);
               }

               if (class279.worldSelectFlagSprites != null) {
                  class279.worldSelectFlagSprites[(var18.isMembersOnly() ? 8 : 0) + var18.location].drawAt(var45 + 29, var12);
               }

               var0.drawCentered(Integer.toString(var18.id), var45 + 15, var56 / 2 + var12 + 5, var22, -1);
               var1.drawCentered(var20, var45 + 60, var56 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var56 + var8;
               ++var14;
               if (var14 >= var6) {
                  var12 = var10 + 23;
                  var45 = var45 + var23 + var41;
                  var14 = 0;
                  ++var47;
               }
            }

            if (var15) {
               var48 = var1.stringWidth(class260.World_worlds[Login.hoveredWorldIndex].activity) + 6;
               var25 = var1.ascent + 8;
               int var50 = MouseHandler.MouseHandler_y + 25;
               if (var50 + var25 > 480) {
                  var50 = MouseHandler.MouseHandler_y - 25 - var25;
               }

               Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var48 / 2, var50, var48, var25, 16777120);
               Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var48 / 2, var50, var48, var25, 0);
               var1.drawCentered(class260.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var50 + var1.ascent + 4, 0, -1);
            }
         }

         StudioGame.rasterProvider.drawFull(0, 0);
      } else {
         Login.leftTitleSprite.drawAt(Login.xPadding, 0);
         class419.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
         Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
         if (Client.gameState == 0 || Client.gameState == 5) {
            var23 = 20;
            var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
            var24 = 253 - var23;
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
            var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
         }

         String var26;
         String var27;
         char[] var28;
         String var29;
         short var51;
         short var53;
         if (Client.gameState == 20) {
            WorldMapSprite.titleboxSprite.drawAt(Login.loginBoxX + 180 - WorldMapSprite.titleboxSprite.subWidth / 2, 271 - WorldMapSprite.titleboxSprite.subHeight / 2);
            var51 = 201;
            var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16776960, 0);
            var52 = var51 + 15;
            var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16776960, 0);
            var52 += 15;
            var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16776960, 0);
            var52 += 15;
            var52 += 7;
            if (Login.loginIndex != 4 && Login.loginIndex != 10) {
               var0.draw("Login: ", Login.loginBoxX + 180 - 110, var52, 16777215, 0);
               var53 = 200;

               for(var26 = UserComparator3.method661(); var0.stringWidth(var26) > var53; var26 = var26.substring(0, var26.length() - 1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var26), Login.loginBoxX + 180 - 70, var52, 16777215, 0);
               var52 += 15;
               var27 = Login.Login_password;
               var9 = var27.length();
               var28 = new char[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var28[var11] = '*';
               }

               var29 = new String(var28);

               for(var29 = var29; var0.stringWidth(var29) > var53; var29 = var29.substring(1)) {
                  ;
               }

               var0.draw("Password: " + var29, Login.loginBoxX + 180 - 108, var52, 16777215, 0);
               var52 += 15;
            }
         }

         if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
            WorldMapSprite.titleboxSprite.drawAt(Login.loginBoxX, 171);
            short var5;
            if (Login.loginIndex == 0) {
               var51 = 251;
               var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var51, 16776960, 0);
               var52 = var51 + 30;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 291;
               Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var24 = Login.loginBoxX + 180 + 80;
               Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if (Login.loginIndex == 1) {
               var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
               var51 = 236;
               var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16777215, 0);
               var52 = var51 + 15;
               var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16777215, 0);
               var52 += 15;
               var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16777215, 0);
               var52 += 15;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 321;
               Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
               var24 = Login.loginBoxX + 180 + 80;
               Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
            } else {
               String var30;
               if (Login.loginIndex == 2) {
                  var51 = 201;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxCenter, var51, 16776960, 0);
                  var52 = var51 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxCenter, var52, 16776960, 0);
                  var52 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxCenter, var52, 16776960, 0);
                  var52 += 15;
                  var52 += 7;
                  var0.draw("Login: ", Login.loginBoxCenter - 110, var52, 16777215, 0);
                  var53 = 200;
                  char[] var31;
                  String var32;
                  if (!WorldMapSectionType.clientPreferences.getIsUsernameHidden()) {
                     var30 = Login.Login_username;
                  } else {
                     var29 = Login.Login_username;
                     var10 = var29.length();
                     var31 = new char[var10];

                     for(var12 = 0; var12 < var10; ++var12) {
                        var31[var12] = '*';
                     }

                     var32 = new String(var31);
                     var30 = var32;
                  }

                  for(var30 = var30; var0.stringWidth(var30) > var53; var30 = var30.substring(1)) {
                     ;
                  }

                  var0.draw(AbstractFont.escapeBrackets(var30) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? Canvas.colorStartTag(16776960) + "|" : ""), Login.loginBoxCenter - 70, var52, 16777215, 0);
                  var52 += 15;
                  var29 = Login.Login_password;
                  var10 = var29.length();
                  var31 = new char[var10];

                  for(var12 = 0; var12 < var10; ++var12) {
                     var31[var12] = '*';
                  }

                  var32 = new String(var31);

                  for(var32 = var32; var0.stringWidth(var32) > var53; var32 = var32.substring(1)) {
                     ;
                  }

                  var0.draw("Password: " + var32 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? Canvas.colorStartTag(16776960) + "|" : ""), Login.loginBoxCenter - 108, var52, 16777215, 0);
                  var52 += 15;
                  var51 = 277;
                  var10 = Login.loginBoxCenter + -117;
                  boolean var44 = Client.Login_isUsernameRemembered;
                  boolean var13 = Login.field737;
                  IndexedSprite var55 = var44 ? (var13 ? KitDefinition.field1507 : Login.options_buttons_2Sprite) : (var13 ? ArchiveLoader.field836 : Login.options_buttons_0Sprite);
                  var55.drawAt(var10, var51);
                  var10 = var10 + var55.subWidth + 5;
                  var1.draw("Remember username", var10, var51 + 13, 16776960, 0);
                  var10 = Login.loginBoxCenter + 24;
                  boolean var16 = WorldMapSectionType.clientPreferences.getIsUsernameHidden();
                  boolean var17 = Login.field749;
                  IndexedSprite var34 = var16 ? (var17 ? KitDefinition.field1507 : Login.options_buttons_2Sprite) : (var17 ? ArchiveLoader.field836 : Login.options_buttons_0Sprite);
                  var34.drawAt(var10, var51);
                  var10 = var10 + var34.subWidth + 5;
                  var1.draw("Hide username", var10, var51 + 13, 16776960, 0);
                  var52 = var51 + 15;
                  var25 = Login.loginBoxCenter - 80;
                  short var19 = 321;
                  Login.titlebuttonSprite.drawAt(var25 - 73, var19 - 20);
                  var0.drawCentered("Login", var25, var19 + 5, 16777215, 0);
                  var25 = Login.loginBoxCenter + 80;
                  Login.titlebuttonSprite.drawAt(var25 - 73, var19 - 20);
                  var0.drawCentered("Cancel", var25, var19 + 5, 16777215, 0);
                  var51 = 357;
                  switch(Login.field725) {
                  case 2:
                     InvDefinition.field1458 = "Having trouble logging in?";
                     break;
                  default:
                     InvDefinition.field1458 = "Can't login? Click here.";
                  }

                  WorldMapSectionType.field2332 = new Bounds(Login.loginBoxCenter, var51, var1.stringWidth(InvDefinition.field1458), 11);
                  DevicePcmPlayerProvider.field67 = new Bounds(Login.loginBoxCenter, var51, var1.stringWidth("Still having trouble logging in?"), 11);
                  var1.drawCentered(InvDefinition.field1458, Login.loginBoxCenter, var51, 16777215, 0);
               } else if (Login.loginIndex == 3) {
                  var51 = 201;
                  var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 20;
                  var1.drawCentered("You may need to use the Jagex Launcher to continue playing.", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 20;
                  var1.drawCentered("<col=ffd200>Download it here.</col>", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var24 = Login.loginBoxX + 180;
                  var5 = 276;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
                  var24 = Login.loginBoxX + 180;
                  var5 = 326;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 4) {
                  var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
                  var51 = 236;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16777215, 0);
                  var52 = var51 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16777215, 0);
                  var52 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16777215, 0);
                  var52 += 15;
                  var26 = "PIN: ";
                  var27 = NetFileRequest.otp;
                  var9 = var27.length();
                  var28 = new char[var9];

                  for(var11 = 0; var11 < var9; ++var11) {
                     var28[var11] = '*';
                  }

                  var29 = new String(var28);
                  var0.draw(var26 + var29 + (Client.cycle % 40 < 20 ? Canvas.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var52, 16777215, 0);
                  var52 -= 8;
                  var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var52, 16776960, 0);
                  var52 += 15;
                  var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var52, 16776960, 0);
                  var8 = 180 + Login.loginBoxX - 9 + var0.stringWidth("for 30 days: ") + 15;
                  var9 = var52 - var0.ascent;
                  IndexedSprite var54;
                  if (Login.field750) {
                     var54 = Login.options_buttons_2Sprite;
                  } else {
                     var54 = Login.options_buttons_0Sprite;
                  }

                  var54.drawAt(var8, var9);
                  var52 += 15;
                  var11 = Login.loginBoxX + 180 - 80;
                  short var46 = 321;
                  Login.titlebuttonSprite.drawAt(var11 - 73, var46 - 20);
                  var0.drawCentered("Continue", var11, var46 + 5, 16777215, 0);
                  var11 = Login.loginBoxX + 180 + 80;
                  Login.titlebuttonSprite.drawAt(var11 - 73, var46 - 20);
                  var0.drawCentered("Cancel", var11, var46 + 5, 16777215, 0);
                  var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var46 + 36, 255, 0);
               } else if (Login.loginIndex == 5) {
                  var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
                  var51 = 221;
                  var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 15;
                  var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var52 += 14;
                  var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var52, 16777215, 0);
                  var53 = 174;

                  for(var26 = UserComparator3.method661(); var0.stringWidth(var26) > var53; var26 = var26.substring(1)) {
                     ;
                  }

                  var0.draw(AbstractFont.escapeBrackets(var26) + (Client.cycle % 40 < 20 ? Canvas.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var52, 16777215, 0);
                  var52 += 15;
                  var6 = Login.loginBoxX + 180 - 80;
                  short var7 = 321;
                  Login.titlebuttonSprite.drawAt(var6 - 73, var7 - 20);
                  var0.drawCentered("Recover", var6, var7 + 5, 16777215, 0);
                  var6 = Login.loginBoxX + 180 + 80;
                  Login.titlebuttonSprite.drawAt(var6 - 73, var7 - 20);
                  var0.drawCentered("Back", var6, var7 + 5, 16777215, 0);
                  var7 = 356;
                  var1.drawCentered("Still having trouble logging in?", Login.loginBoxCenter, var7, 268435455, 0);
               } else if (Login.loginIndex == 6) {
                  var51 = 201;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var24 = Login.loginBoxX + 180;
                  var5 = 321;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 7) {
                  if (class157.field1372 && !Client.onMobile) {
                     var51 = 201;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxCenter, var51, 16776960, 0);
                     var52 = var51 + 15;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxCenter, var52, 16776960, 0);
                     var52 += 15;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxCenter, var52, 16776960, 0);
                     var24 = Login.loginBoxCenter - 150;
                     var52 += 10;

                     for(var38 = 0; var38 < 8; ++var38) {
                        Login.titlebuttonSprite.method2519(var24, var52, 30, 40);
                        boolean var37 = var38 == Login.field746 & Client.cycle % 40 < 20;
                        var0.draw((Login.field745[var38] == null ? "" : Login.field745[var38]) + (var37 ? Canvas.colorStartTag(16776960) + "|" : ""), var24 + 10, var52 + 27, 16777215, 0);
                        if (var38 != 1 && var38 != 3) {
                           var24 += 35;
                        } else {
                           var24 += 50;
                           var0.draw(AbstractFont.escapeBrackets("/"), var24 - 13, var52 + 27, 16777215, 0);
                        }
                     }

                     var38 = Login.loginBoxCenter - 80;
                     short var39 = 321;
                     Login.titlebuttonSprite.drawAt(var38 - 73, var39 - 20);
                     var0.drawCentered("Submit", var38, var39 + 5, 16777215, 0);
                     var38 = Login.loginBoxCenter + 80;
                     Login.titlebuttonSprite.drawAt(var38 - 73, var39 - 20);
                     var0.drawCentered("Cancel", var38, var39 + 5, 16777215, 0);
                  } else {
                     var51 = 216;
                     var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var51, 16776960, 0);
                     var52 = var51 + 15;
                     var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var52, 16776960, 0);
                     var52 += 15;
                     var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var52, 16776960, 0);
                     var52 += 15;
                     var24 = Login.loginBoxX + 180 - 80;
                     var5 = 321;
                     Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
                     var24 = Login.loginBoxX + 180 + 80;
                     Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
                  }
               } else if (Login.loginIndex == 8) {
                  var51 = 216;
                  var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 15;
                  var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var24 = Login.loginBoxX + 180 - 80;
                  var5 = 321;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
                  var24 = Login.loginBoxX + 180 + 80;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 9) {
                  var51 = 221;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 25;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 25;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16776960, 0);
                  var24 = Login.loginBoxX + 180;
                  var5 = 311;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 10) {
                  var52 = Login.loginBoxX + 180;
                  var53 = 209;
                  var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var53, 16776960, 0);
                  var24 = var53 + 20;
                  GrandExchangeOfferOwnWorldComparator.field353.drawAt(var52 - 109, var24);
                  if (Login.field747.isEmpty()) {
                     class72.field721.drawAt(var52 - 48, var24 + 18);
                  } else {
                     class72.field721.drawAt(var52 - 48, var24 + 5);
                     var0.drawCentered(Login.field747, var52, var24 + 68 - 15, 16776960, 0);
                  }
               } else if (Login.loginIndex == 12) {
                  var52 = Login.loginBoxCenter;
                  var53 = 216;
                  var2.drawCentered("Before using this app, please read and accept our", var52, var53, 16777215, 0);
                  var24 = var53 + 17;
                  var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var52, var24, 16777215, 0);
                  var24 += 17;
                  var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var52, var24, 16777215, 0);
                  var24 += 17;
                  var2.drawCentered("By accepting, you agree to these documents.", var52, var24, 16777215, 0);
                  var52 = Login.loginBoxCenter - 80;
                  var53 = 311;
                  Login.titlebuttonSprite.drawAt(var52 - 73, var53 - 20);
                  var0.drawCentered("Accept", var52, var53 + 5, 16777215, 0);
                  var52 = Login.loginBoxCenter + 80;
                  Login.titlebuttonSprite.drawAt(var52 - 73, var53 - 20);
                  var0.drawCentered("Decline", var52, var53 + 5, 16777215, 0);
               } else if (Login.loginIndex == 13) {
                  var51 = 231;
                  var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var51, 16777215, 0);
                  var52 = var51 + 20;
                  var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var52, 16777215, 0);
                  var24 = Login.loginBoxX + 180;
                  var51 = 311;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var51 - 20);
                  var0.drawCentered("Back", var24, var51 + 5, 16777215, 0);
               } else if (Login.loginIndex == 14) {
                  var51 = 201;
                  String var4 = "";
                  var26 = "";
                  var30 = "";
                  switch(Login.field738) {
                  case 0:
                     var4 = "Your account has been involved";
                     var26 = "in serious rule breaking.";
                     var30 = "";
                     break;
                  case 1:
                     var4 = "Your account has been locked due to";
                     var26 = "suspicious activity.";
                     var30 = "Please recover your account.";
                     break;
                  case 2:
                     var4 = "The unpaid balance on your account needs";
                     var26 = "to be resolved before you can play.";
                     var30 = Strings.field3133;
                     break;
                  default:
                     FontName.Login_promptCredentials(false);
                  }

                  var0.drawCentered(var4, Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 20;
                  var0.drawCentered(var26, Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 20;
                  var0.drawCentered(var30, Login.loginBoxX + 180, var52, 16776960, 0);
                  var41 = Login.loginBoxX + 180;
                  short var42 = 276;
                  Login.titlebuttonSprite.drawAt(var41 - 73, var42 - 20);
                  if (Login.field738 == 1) {
                     var0.drawCentered("Recover Account", var41, var42 + 5, 16777215, 0);
                  } else {
                     var0.drawCentered("View Appeal Options", var41, var42 + 5, 16777215, 0);
                  }

                  var41 = Login.loginBoxX + 180;
                  var42 = 326;
                  Login.titlebuttonSprite.drawAt(var41 - 73, var42 - 20);
                  var0.drawCentered("Back", var41, var42 + 5, 16777215, 0);
               } else if (Login.loginIndex == 24) {
                  var51 = 221;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var51, 16777215, 0);
                  var52 = var51 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var52, 16777215, 0);
                  var52 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var52, 16777215, 0);
                  var52 += 15;
                  var24 = Login.loginBoxX + 180;
                  var5 = 301;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 26) {
                  var51 = 216;
                  var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var51, 16776960, 0);
                  var52 = var51 + 15;
                  var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var52, 16776960, 0);
                  var52 += 15;
                  var24 = Login.loginBoxX + 180 - 80;
                  var5 = 321;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
                  var24 = Login.loginBoxX + 180 + 80;
                  Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               }
            }
         }

         if (Client.gameState >= 10) {
            int[] var3 = new int[4];
            Rasterizer2D.Rasterizer2D_getClipArray(var3);
            Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, class143.canvasHeight);
            ArchiveDiskActionHandler.field3410.draw(Login.xPadding - 22, Client.cycle);
            ArchiveDiskActionHandler.field3410.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
            Rasterizer2D.Rasterizer2D_setClipArray(var3);
         }

         class139.title_muteSprite[WorldMapSectionType.clientPreferences.getTitleMusicDisabled() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
         if (Client.gameState > 5 && Language.Language_EN == class69.clientLanguage) {
            if (FriendSystem.field664 != null) {
               var52 = Login.xPadding + 5;
               var53 = 463;
               byte var43 = 100;
               byte var40 = 35;
               FriendSystem.field664.drawAt(var52, var53);
               var0.drawCentered("World" + " " + Client.worldId, var43 / 2 + var52, var40 / 2 + var53 - 2, 16777215, 0);
               if (class16.World_request != null) {
                  var1.drawCentered("Loading...", var43 / 2 + var52, var40 / 2 + var53 + 12, 16777215, 0);
               } else {
                  var1.drawCentered("Click to switch", var43 / 2 + var52, var40 / 2 + var53 + 12, 16777215, 0);
               }
            } else {
               FriendSystem.field664 = class368.SpriteBuffer_getIndexedSpriteByName(class143.archive8, "sl_button", "");
            }
         }

      }
   }
}
