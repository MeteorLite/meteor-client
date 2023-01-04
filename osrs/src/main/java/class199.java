import java.awt.datatransfer.Clipboard;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class199 implements class30 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   Widget field1813 = null;
   @ObfuscatedName("e")
   boolean field1812 = false;
   @ObfuscatedName("v")
   boolean field1814 = false;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1119176744"
   )
   public boolean vmethod3949(int var1) {
      if (this.field1813 == null) {
         return false;
      } else {
         class28 var2 = this.field1813.method1737();
         if (var2 == null) {
            return false;
         } else {
            if (var2.method108(var1)) {
               switch(var1) {
               case 81:
                  this.field1814 = true;
                  break;
               case 82:
                  this.field1812 = true;
                  break;
               default:
                  if (this.method1068(var1)) {
                     class69.invalidateWidget(this.field1813);
                  }
               }
            }

            return var2.method113(var1);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-916991313"
   )
   public boolean vmethod3989(int var1) {
      switch(var1) {
      case 81:
         this.field1814 = false;
         return false;
      case 82:
         this.field1812 = false;
         return false;
      default:
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-258182"
   )
   public boolean vmethod3951(char var1) {
      if (this.field1813 == null) {
         return false;
      } else if (!ObjectSound.method415(var1)) {
         return false;
      } else {
         class303 var2 = this.field1813.method1724();
         if (var2 != null && var2.method1706()) {
            class28 var3 = this.field1813.method1737();
            if (var3 == null) {
               return false;
            } else {
               if (var3.method112(var1) && var2.method1649(var1)) {
                  class69.invalidateWidget(this.field1813);
               }

               return var3.method106(var1);
            }
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(ZI)Z",
      garbageValue = "333814410"
   )
   public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)V",
      garbageValue = "-158178523"
   )
   public void method1063(Widget var1) {
      this.method1065();
      if (var1 != null) {
         this.field1813 = var1;
         class301 var2 = var1.method1735();
         if (var2 != null) {
            var2.field2810.method1635(true);
            if (var2.field2811 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method475(var1);
               var3.setArgs(var2.field2811);
               AABB.getScriptEvents().addFirst(var3);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(B)Lkd;",
      garbageValue = "11"
   )
   public Widget method1064() {
      return this.field1813;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-73"
   )
   public void method1065() {
      if (this.field1813 != null) {
         class301 var1 = this.field1813.method1735();
         Widget var2 = this.field1813;
         this.field1813 = null;
         if (var1 != null) {
            var1.field2810.method1635(false);
            if (var1.field2811 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method475(var2);
               var3.setArgs(var1.field2811);
               AABB.getScriptEvents().addFirst(var3);
            }

         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "175543627"
   )
   boolean method1068(int var1) {
      if (this.field1813 == null) {
         return false;
      } else {
         class303 var2 = this.field1813.method1724();
         if (var2 != null && var2.method1706()) {
            Clipboard var5;
            switch(var1) {
            case 13:
               this.method1065();
               return true;
            case 48:
               if (this.field1812) {
                  var2.method1710();
               }

               return true;
            case 65:
               if (this.field1812) {
                  var5 = BuddyRankComparator.client.getClipboard();
                  var2.method1670(var5);
               }

               return true;
            case 66:
               if (this.field1812) {
                  var5 = BuddyRankComparator.client.getClipboard();
                  var2.method1701(var5);
               }

               return true;
            case 67:
               if (this.field1812) {
                  var5 = BuddyRankComparator.client.getClipboard();
                  var2.method1671(var5);
               }

               return true;
            case 84:
               if (var2.method1685() == 0) {
                  var2.method1649(10);
               } else if (this.field1814 && var2.method1687()) {
                  var2.method1649(10);
               } else {
                  class301 var3 = this.field1813.method1735();
                  ScriptEvent var4 = new ScriptEvent();
                  var4.method475(this.field1813);
                  var4.setArgs(var3.field2809);
                  AABB.getScriptEvents().addFirst(var4);
                  this.method1065();
               }

               return true;
            case 85:
               if (this.field1812) {
                  var2.method1652();
               } else {
                  var2.method1650();
               }

               return true;
            case 96:
               if (this.field1812) {
                  var2.method1662(this.field1814);
               } else {
                  var2.method1660(this.field1814);
               }

               return true;
            case 97:
               if (this.field1812) {
                  var2.method1655(this.field1814);
               } else {
                  var2.method1661(this.field1814);
               }

               return true;
            case 98:
               if (this.field1812) {
                  var2.method1672();
               } else {
                  var2.method1699(this.field1814);
               }

               return true;
            case 99:
               if (this.field1812) {
                  var2.method1695();
               } else {
                  var2.method1679(this.field1814);
               }

               return true;
            case 101:
               if (this.field1812) {
                  var2.method1653();
               } else {
                  var2.method1651();
               }

               return true;
            case 102:
               if (this.field1812) {
                  var2.method1658(this.field1814);
               } else {
                  var2.method1712(this.field1814);
               }

               return true;
            case 103:
               if (this.field1812) {
                  var2.method1659(this.field1814);
               } else {
                  var2.method1657(this.field1814);
               }

               return true;
            case 104:
               if (this.field1812) {
                  var2.method1666(this.field1814);
               } else {
                  var2.method1664(this.field1814);
               }

               return true;
            case 105:
               if (this.field1812) {
                  var2.method1667(this.field1814);
               } else {
                  var2.method1665(this.field1814);
               }

               return true;
            default:
               return false;
            }
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Lnv;Lnv;Lnv;I)V",
      garbageValue = "-672132656"
   )
   static void drawTitle(Font var0, Font var1, Font var2) {
      Login.xPadding = (CollisionMap.canvasWidth - 765) / 2;
      Login.loginBoxX = Login.xPadding + 202;
      UrlRequest.loginBoxCenter = Login.loginBoxX + 180;
      int var7;
      int var8;
      int var10;
      byte var23;
      int var24;
      int var33;
      int var42;
      if (Login.worldSelectOpen) {
         Archive var32;
         int var36;
         if (GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites == null) {
            var32 = ClientPreferences.archive8;
            var33 = var32.getGroupId("sl_back");
            var36 = var32.getFileId(var33, "");
            SpritePixels[] var30 = SequenceDefinition.method1062(var32, var33, var36);
            GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites = var30;
         }

         IndexedSprite[] var31;
         if (class87.worldSelectFlagSprites == null) {
            var32 = ClientPreferences.archive8;
            var33 = var32.getGroupId("sl_flags");
            var36 = var32.getFileId(var33, "");
            var31 = AbstractWorldMapData.method1431(var32, var33, var36);
            class87.worldSelectFlagSprites = var31;
         }

         if (FloorDecoration.worldSelectArrows == null) {
            var32 = ClientPreferences.archive8;
            var33 = var32.getGroupId("sl_arrows");
            var36 = var32.getFileId(var33, "");
            var31 = AbstractWorldMapData.method1431(var32, var33, var36);
            FloorDecoration.worldSelectArrows = var31;
         }

         if (class280.worldSelectStars == null) {
            var32 = ClientPreferences.archive8;
            var33 = var32.getGroupId("sl_stars");
            var36 = var32.getFileId(var33, "");
            var31 = AbstractWorldMapData.method1431(var32, var33, var36);
            class280.worldSelectStars = var31;
         }

         if (BufferedNetSocket.worldSelectLeftSprite == null) {
            BufferedNetSocket.worldSelectLeftSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(ClientPreferences.archive8, "leftarrow", "");
         }

         if (class140.worldSelectRightSprite == null) {
            class140.worldSelectRightSprite = Projectile.SpriteBuffer_getIndexedSpriteByName(ClientPreferences.archive8, "rightarrow", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
         Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
         if (class280.worldSelectStars != null) {
            class280.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
            var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
            class280.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
            var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
         }

         if (FloorDecoration.worldSelectArrows != null) {
            var42 = Login.xPadding + 280;
            if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
               FloorDecoration.worldSelectArrows[2].drawAt(var42, 4);
            } else {
               FloorDecoration.worldSelectArrows[0].drawAt(var42, 4);
            }

            if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
               FloorDecoration.worldSelectArrows[3].drawAt(var42 + 15, 4);
            } else {
               FloorDecoration.worldSelectArrows[1].drawAt(var42 + 15, 4);
            }

            var0.draw("World", var42 + 32, 17, 16777215, -1);
            var24 = Login.xPadding + 390;
            if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
               FloorDecoration.worldSelectArrows[2].drawAt(var24, 4);
            } else {
               FloorDecoration.worldSelectArrows[0].drawAt(var24, 4);
            }

            if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
               FloorDecoration.worldSelectArrows[3].drawAt(var24 + 15, 4);
            } else {
               FloorDecoration.worldSelectArrows[1].drawAt(var24 + 15, 4);
            }

            var0.draw("Players", var24 + 32, 17, 16777215, -1);
            var33 = Login.xPadding + 500;
            if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
               FloorDecoration.worldSelectArrows[2].drawAt(var33, 4);
            } else {
               FloorDecoration.worldSelectArrows[0].drawAt(var33, 4);
            }

            if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
               FloorDecoration.worldSelectArrows[3].drawAt(var33 + 15, 4);
            } else {
               FloorDecoration.worldSelectArrows[1].drawAt(var33 + 15, 4);
            }

            var0.draw("Location", var33 + 32, 17, 16777215, -1);
            var36 = Login.xPadding + 610;
            if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
               FloorDecoration.worldSelectArrows[2].drawAt(var36, 4);
            } else {
               FloorDecoration.worldSelectArrows[0].drawAt(var36, 4);
            }

            if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
               FloorDecoration.worldSelectArrows[3].drawAt(var36 + 15, 4);
            } else {
               FloorDecoration.worldSelectArrows[1].drawAt(var36 + 15, 4);
            }

            var0.draw("Type", var36 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
         var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
         Login.hoveredWorldIndex = -1;
         if (GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites != null) {
            var23 = 88;
            byte var45 = 19;
            var33 = 765 / (var23 + 1) - 1;
            var36 = 480 / (var45 + 1);

            do {
               var7 = var36;
               var8 = var33;
               if (var36 * (var33 - 1) >= World.World_count) {
                  --var33;
               }

               if (var33 * (var36 - 1) >= World.World_count) {
                  --var36;
               }

               if (var33 * (var36 - 1) >= World.World_count) {
                  --var36;
               }
            } while(var36 != var7 || var33 != var8);

            var7 = (765 - var33 * var23) / (var33 + 1);
            if (var7 > 5) {
               var7 = 5;
            }

            var8 = (480 - var45 * var36) / (var36 + 1);
            if (var8 > 5) {
               var8 = 5;
            }

            int var9 = (765 - var33 * var23 - var7 * (var33 - 1)) / 2;
            var10 = (480 - var45 * var36 - var8 * (var36 - 1)) / 2;
            int var39 = (var36 + World.World_count - 1) / var36;
            Login.worldSelectPagesCount = var39 - var33;
            if (BufferedNetSocket.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
               BufferedNetSocket.worldSelectLeftSprite.drawAt(8, Language.canvasHeight / 2 - BufferedNetSocket.worldSelectLeftSprite.subHeight / 2);
            }

            if (class140.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
               class140.worldSelectRightSprite.drawAt(CollisionMap.canvasWidth - class140.worldSelectRightSprite.subWidth - 8, Language.canvasHeight / 2 - class140.worldSelectRightSprite.subHeight / 2);
            }

            int var12 = var10 + 23;
            int var13 = var9 + Login.xPadding;
            int var14 = 0;
            boolean var15 = false;
            int var16 = Login.worldSelectPage;

            int var17;
            for(var17 = var16 * var36; var17 < World.World_count && var16 - Login.worldSelectPage < var33; ++var17) {
               World var18 = World.World_worlds[var17];
               boolean var19 = true;
               String var20 = Integer.toString(var18.population);
               if (var18.population == -1) {
                  var20 = "OFF";
                  var19 = false;
               } else if (var18.population > 1980) {
                  var20 = "FULL";
                  var19 = false;
               }

               int var21 = -1;
               int var22 = 0;
               if (var18.isBeta()) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1104.field1111;
                  } else {
                     var21 = class104.field1103.field1111;
                  }
               } else if (var18.isDeadman()) {
                  var22 = 16711680;
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1102.field1111;
                  } else {
                     var21 = class104.field1105.field1111;
                  }
               } else if (var18.method394()) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1106.field1111;
                  } else {
                     var21 = class104.field1109.field1111;
                  }
               } else if (var18.isPvp()) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1100.field1111;
                  } else {
                     var21 = class104.field1099.field1111;
                  }
               } else if (var18.method393()) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1101.field1111;
                  } else {
                     var21 = class104.field1108.field1111;
                  }
               } else if (var18.method388()) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1110.field1111;
                  } else {
                     var21 = class104.field1107.field1111;
                  }
               }

               if (var21 == -1 || var21 >= GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites.length) {
                  if (var18.isMembersOnly()) {
                     var21 = class104.field1098.field1111;
                  } else {
                     var21 = class104.field1114.field1111;
                  }
               }

               if (MouseHandler.MouseHandler_x >= var13 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var13 + var23 && MouseHandler.MouseHandler_y < var45 + var12 && var19) {
                  Login.hoveredWorldIndex = var17;
                  GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites[var21].drawTransOverlayAt(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  GrandExchangeOfferOwnWorldComparator.worldSelectBackSprites[var21].drawAt(var13, var12);
               }

               if (class87.worldSelectFlagSprites != null) {
                  class87.worldSelectFlagSprites[(var18.isMembersOnly() ? 8 : 0) + var18.location].drawAt(var13 + 29, var12);
               }

               var0.drawCentered(Integer.toString(var18.id), var13 + 15, var45 / 2 + var12 + 5, var22, -1);
               var1.drawCentered(var20, var13 + 60, var45 / 2 + var12 + 5, 268435455, -1);
               var12 = var12 + var8 + var45;
               ++var14;
               if (var14 >= var36) {
                  var12 = var10 + 23;
                  var13 = var13 + var7 + var23;
                  var14 = 0;
                  ++var16;
               }
            }

            if (var15) {
               var17 = var1.stringWidth(World.World_worlds[Login.hoveredWorldIndex].activity) + 6;
               int var25 = var1.ascent + 8;
               int var40 = MouseHandler.MouseHandler_y + 25;
               if (var25 + var40 > 480) {
                  var40 = MouseHandler.MouseHandler_y - 25 - var25;
               }

               Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var40, var17, var25, 16777120);
               Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var40, var17, var25, 0);
               var1.drawCentered(World.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var40 + var1.ascent + 4, 0, -1);
            }
         }

         RouteStrategy.rasterProvider.drawFull(0, 0);
      } else {
         SecureRandomCallable.leftTitleSprite.drawAt(Login.xPadding, 0);
         class9.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
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
         String var28;
         short var41;
         short var43;
         if (Client.gameState == 20) {
            ModelData0.titleboxSprite.drawAt(Login.loginBoxX + 180 - ModelData0.titleboxSprite.subWidth / 2, 271 - ModelData0.titleboxSprite.subHeight / 2);
            var41 = 201;
            var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16776960, 0);
            var42 = var41 + 15;
            var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16776960, 0);
            var42 += 15;
            var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16776960, 0);
            var42 += 15;
            var42 += 7;
            if (Login.loginIndex != 4 && Login.loginIndex != 10) {
               var0.draw("Login: ", Login.loginBoxX + 180 - 110, var42, 16777215, 0);
               var43 = 200;
               var26 = StructComposition.clientPreferences.getIsUsernameHidden() ? TaskHandler.method873(Login.Login_username) : Login.Login_username;

               for(var27 = var26; var0.stringWidth(var27) > var43; var27 = var27.substring(0, var27.length() - 1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var27), Login.loginBoxX + 180 - 70, var42, 16777215, 0);
               var42 += 15;

               for(var28 = TaskHandler.method873(Login.Login_password); var0.stringWidth(var28) > var43; var28 = var28.substring(1)) {
                  ;
               }

               var0.draw("Password: " + var28, Login.loginBoxX + 180 - 108, var42, 16777215, 0);
               var42 += 15;
            }
         }

         if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
            ModelData0.titleboxSprite.drawAt(Login.loginBoxX, 171);
            short var5;
            if (Login.loginIndex == 0) {
               var41 = 251;
               var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var41, 16776960, 0);
               var42 = var41 + 30;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 291;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var24 = Login.loginBoxX + 180 + 80;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if (Login.loginIndex == 1) {
               var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
               var41 = 236;
               var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16777215, 0);
               var42 = var41 + 15;
               var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16777215, 0);
               var42 += 15;
               var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16777215, 0);
               var42 += 15;
               var24 = Login.loginBoxX + 180 - 80;
               var5 = 321;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
               var24 = Login.loginBoxX + 180 + 80;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
            } else if (Login.loginIndex == 2) {
               var41 = 201;
               var0.drawCentered(Login.Login_response1, UrlRequest.loginBoxCenter, var41, 16776960, 0);
               var42 = var41 + 15;
               var0.drawCentered(Login.Login_response2, UrlRequest.loginBoxCenter, var42, 16776960, 0);
               var42 += 15;
               var0.drawCentered(Login.Login_response3, UrlRequest.loginBoxCenter, var42, 16776960, 0);
               var42 += 15;
               var42 += 7;
               var0.draw("Login: ", UrlRequest.loginBoxCenter - 110, var42, 16777215, 0);
               var43 = 200;
               var26 = StructComposition.clientPreferences.getIsUsernameHidden() ? TaskHandler.method873(Login.Login_username) : Login.Login_username;

               for(var27 = var26; var0.stringWidth(var27) > var43; var27 = var27.substring(1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var27) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? MouseRecorder.colorStartTag(16776960) + "|" : ""), UrlRequest.loginBoxCenter - 70, var42, 16777215, 0);
               var42 += 15;

               for(var28 = TaskHandler.method873(Login.Login_password); var0.stringWidth(var28) > var43; var28 = var28.substring(1)) {
                  ;
               }

               var0.draw("Password: " + var28 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? MouseRecorder.colorStartTag(16776960) + "|" : ""), UrlRequest.loginBoxCenter - 108, var42, 16777215, 0);
               var42 += 15;
               var41 = 277;
               var8 = UrlRequest.loginBoxCenter + -117;
               IndexedSprite var29 = class143.method764(Client.Login_isUsernameRemembered, Login.field747);
               var29.drawAt(var8, var41);
               var8 = var8 + var29.subWidth + 5;
               var1.draw("Remember username", var8, var41 + 13, 16776960, 0);
               var8 = UrlRequest.loginBoxCenter + 24;
               var29 = class143.method764(StructComposition.clientPreferences.getIsUsernameHidden(), Login.field762);
               var29.drawAt(var8, var41);
               var8 = var8 + var29.subWidth + 5;
               var1.draw("Hide username", var8, var41 + 13, 16776960, 0);
               var42 = var41 + 15;
               var10 = UrlRequest.loginBoxCenter - 80;
               short var11 = 321;
               Frames.titlebuttonSprite.drawAt(var10 - 73, var11 - 20);
               var0.drawCentered("Login", var10, var11 + 5, 16777215, 0);
               var10 = UrlRequest.loginBoxCenter + 80;
               Frames.titlebuttonSprite.drawAt(var10 - 73, var11 - 20);
               var0.drawCentered("Cancel", var10, var11 + 5, 16777215, 0);
               var41 = 357;
               switch(Login.field736) {
               case 2:
                  Login.field737 = "Having trouble logging in?";
                  break;
               default:
                  Login.field737 = "Can't login? Click here.";
               }

               class379.field3654 = new Bounds(UrlRequest.loginBoxCenter, var41, var1.stringWidth(Login.field737), 11);
               class151.field1370 = new Bounds(UrlRequest.loginBoxCenter, var41, var1.stringWidth("Still having trouble logging in?"), 11);
               var1.drawCentered(Login.field737, UrlRequest.loginBoxCenter, var41, 16777215, 0);
            } else if (Login.loginIndex == 3) {
               var41 = 201;
               var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var41, 16776960, 0);
               var42 = var41 + 20;
               var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var42, 16776960, 0);
               var42 += 15;
               var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var42, 16776960, 0);
               var42 += 15;
               var24 = Login.loginBoxX + 180;
               var5 = 276;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
               var24 = Login.loginBoxX + 180;
               var5 = 326;
               Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
               var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
            } else {
               short var37;
               if (Login.loginIndex == 4) {
                  var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
                  var41 = 236;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16777215, 0);
                  var42 = var41 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16777215, 0);
                  var42 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16777215, 0);
                  var42 += 15;
                  var0.draw("PIN: " + TaskHandler.method873(class141.otp) + (Client.cycle % 40 < 20 ? MouseRecorder.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var42, 16777215, 0);
                  var42 -= 8;
                  var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var42, 16776960, 0);
                  var42 += 15;
                  var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var42, 16776960, 0);
                  var24 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
                  var33 = var42 - var0.ascent;
                  IndexedSprite var44;
                  if (Login.field738) {
                     var44 = class89.options_buttons_2Sprite;
                  } else {
                     var44 = WorldMapLabel.options_buttons_0Sprite;
                  }

                  var44.drawAt(var24, var33);
                  var42 += 15;
                  var7 = Login.loginBoxX + 180 - 80;
                  var37 = 321;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Continue", var7, var37 + 5, 16777215, 0);
                  var7 = Login.loginBoxX + 180 + 80;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Cancel", var7, var37 + 5, 16777215, 0);
                  var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var37 + 36, 255, 0);
               } else if (Login.loginIndex == 5) {
                  var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
                  var41 = 221;
                  var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 15;
                  var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var42 += 14;
                  var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var42, 16777215, 0);
                  var43 = 174;
                  var26 = StructComposition.clientPreferences.getIsUsernameHidden() ? TaskHandler.method873(Login.Login_username) : Login.Login_username;

                  for(var27 = var26; var0.stringWidth(var27) > var43; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.draw(AbstractFont.escapeBrackets(var27) + (Client.cycle % 40 < 20 ? MouseRecorder.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var42, 16777215, 0);
                  var42 += 15;
                  var7 = Login.loginBoxX + 180 - 80;
                  var37 = 321;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Recover", var7, var37 + 5, 16777215, 0);
                  var7 = Login.loginBoxX + 180 + 80;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Back", var7, var37 + 5, 16777215, 0);
                  var37 = 356;
                  var1.drawCentered("Still having trouble logging in?", UrlRequest.loginBoxCenter, var37, 268435455, 0);
               } else if (Login.loginIndex == 6) {
                  var41 = 201;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var24 = Login.loginBoxX + 180;
                  var5 = 321;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 7) {
                  if (class155.field1380 && !Client.onMobile) {
                     var41 = 201;
                     var0.drawCentered(Login.Login_response1, UrlRequest.loginBoxCenter, var41, 16776960, 0);
                     var42 = var41 + 15;
                     var0.drawCentered(Login.Login_response2, UrlRequest.loginBoxCenter, var42, 16776960, 0);
                     var42 += 15;
                     var0.drawCentered(Login.Login_response3, UrlRequest.loginBoxCenter, var42, 16776960, 0);
                     var24 = UrlRequest.loginBoxCenter - 150;
                     var42 += 10;

                     for(var33 = 0; var33 < 8; ++var33) {
                        Frames.titlebuttonSprite.method2459(var24, var42, 30, 40);
                        boolean var6 = var33 == Login.field746 & Client.cycle % 40 < 20;
                        var0.draw((Login.field727[var33] == null ? "" : Login.field727[var33]) + (var6 ? MouseRecorder.colorStartTag(16776960) + "|" : ""), var24 + 10, var42 + 27, 16777215, 0);
                        if (var33 != 1 && var33 != 3) {
                           var24 += 35;
                        } else {
                           var24 += 50;
                           var0.draw(AbstractFont.escapeBrackets("/"), var24 - 13, var42 + 27, 16777215, 0);
                        }
                     }

                     var33 = UrlRequest.loginBoxCenter - 80;
                     short var34 = 321;
                     Frames.titlebuttonSprite.drawAt(var33 - 73, var34 - 20);
                     var0.drawCentered("Submit", var33, var34 + 5, 16777215, 0);
                     var33 = UrlRequest.loginBoxCenter + 80;
                     Frames.titlebuttonSprite.drawAt(var33 - 73, var34 - 20);
                     var0.drawCentered("Cancel", var33, var34 + 5, 16777215, 0);
                  } else {
                     var41 = 216;
                     var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var41, 16776960, 0);
                     var42 = var41 + 15;
                     var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var42, 16776960, 0);
                     var42 += 15;
                     var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var42, 16776960, 0);
                     var42 += 15;
                     var24 = Login.loginBoxX + 180 - 80;
                     var5 = 321;
                     Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
                     var24 = Login.loginBoxX + 180 + 80;
                     Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                     var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
                  }
               } else if (Login.loginIndex == 8) {
                  var41 = 216;
                  var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 15;
                  var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var24 = Login.loginBoxX + 180 - 80;
                  var5 = 321;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
                  var24 = Login.loginBoxX + 180 + 80;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 9) {
                  var41 = 221;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 25;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 25;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16776960, 0);
                  var24 = Login.loginBoxX + 180;
                  var5 = 311;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 10) {
                  var42 = Login.loginBoxX + 180;
                  var43 = 209;
                  var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var43, 16776960, 0);
                  var24 = var43 + 20;
                  class299.field2803.drawAt(var42 - 109, var24);
                  class150.field1367.drawAt(var42 - 48, var24 + 18);
               } else if (Login.loginIndex == 12) {
                  var42 = UrlRequest.loginBoxCenter;
                  var43 = 216;
                  var2.drawCentered("Before using this app, please read and accept our", var42, var43, 16777215, 0);
                  var24 = var43 + 17;
                  var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var42, var24, 16777215, 0);
                  var24 += 17;
                  var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var42, var24, 16777215, 0);
                  var24 += 17;
                  var2.drawCentered("By accepting, you agree to these documents.", var42, var24, 16777215, 0);
                  var42 = UrlRequest.loginBoxCenter - 80;
                  var43 = 311;
                  Frames.titlebuttonSprite.drawAt(var42 - 73, var43 - 20);
                  var0.drawCentered("Accept", var42, var43 + 5, 16777215, 0);
                  var42 = UrlRequest.loginBoxCenter + 80;
                  Frames.titlebuttonSprite.drawAt(var42 - 73, var43 - 20);
                  var0.drawCentered("Decline", var42, var43 + 5, 16777215, 0);
               } else if (Login.loginIndex == 13) {
                  var41 = 231;
                  var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var41, 16777215, 0);
                  var42 = var41 + 20;
                  var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var42, 16777215, 0);
                  var24 = Login.loginBoxX + 180;
                  var41 = 311;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var41 - 20);
                  var0.drawCentered("Back", var24, var41 + 5, 16777215, 0);
               } else if (Login.loginIndex == 14) {
                  var41 = 201;
                  String var4 = "";
                  var26 = "";
                  var27 = "";
                  switch(Login.field732) {
                  case 0:
                     var4 = "Your account has been involved";
                     var26 = "in serious rule breaking.";
                     var27 = "";
                     break;
                  case 1:
                     var4 = "Account locked as we suspect it has been stolen.";
                     var26 = Strings.field3172;
                     var27 = "";
                     break;
                  case 2:
                     var4 = "The unpaid balance on your account needs";
                     var26 = "to be resolved before you can play.";
                     var27 = Strings.field3209;
                     break;
                  default:
                     class343.Login_promptCredentials(false);
                  }

                  var0.drawCentered(var4, Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 20;
                  var0.drawCentered(var26, Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 20;
                  var0.drawCentered(var27, Login.loginBoxX + 180, var42, 16776960, 0);
                  var7 = Login.loginBoxX + 180;
                  var37 = 276;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Support Page", var7, var37 + 5, 16777215, 0);
                  var7 = Login.loginBoxX + 180;
                  var37 = 326;
                  Frames.titlebuttonSprite.drawAt(var7 - 73, var37 - 20);
                  var0.drawCentered("Back", var7, var37 + 5, 16777215, 0);
               } else if (Login.loginIndex == 24) {
                  var41 = 221;
                  var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var41, 16777215, 0);
                  var42 = var41 + 15;
                  var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var42, 16777215, 0);
                  var42 += 15;
                  var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var42, 16777215, 0);
                  var42 += 15;
                  var24 = Login.loginBoxX + 180;
                  var5 = 301;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
               } else if (Login.loginIndex == 26) {
                  var41 = 216;
                  var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var41, 16776960, 0);
                  var42 = var41 + 15;
                  var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var42, 16776960, 0);
                  var42 += 15;
                  var24 = Login.loginBoxX + 180 - 80;
                  var5 = 321;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
                  var24 = Login.loginBoxX + 180 + 80;
                  Frames.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
                  var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
               }
            }
         }

         if (Client.gameState >= 10) {
            int[] var3 = new int[4];
            Rasterizer2D.Rasterizer2D_getClipArray(var3);
            Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, Language.canvasHeight);
            class154.field1379.draw(Login.xPadding - 22, Client.cycle);
            class154.field1379.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
            Rasterizer2D.Rasterizer2D_setClipArray(var3);
         }

         class109.title_muteSprite[StructComposition.clientPreferences.getTitleMusicDisabled() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
         if (Client.gameState > 5 && class173.clientLanguage == Language.Language_EN) {
            if (class98.field1070 != null) {
               var42 = Login.xPadding + 5;
               var43 = 463;
               byte var38 = 100;
               byte var35 = 35;
               class98.field1070.drawAt(var42, var43);
               var0.drawCentered("World" + " " + Client.worldId, var38 / 2 + var42, var35 / 2 + var43 - 2, 16777215, 0);
               if (class1.World_request != null) {
                  var1.drawCentered("Loading...", var38 / 2 + var42, var35 / 2 + var43 + 12, 16777215, 0);
               } else {
                  var1.drawCentered("Click to switch", var38 / 2 + var42, var35 / 2 + var43 + 12, 16777215, 0);
               }
            } else {
               class98.field1070 = Projectile.SpriteBuffer_getIndexedSpriteByName(ClientPreferences.archive8, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "1920337009"
   )
   static int method1071(int var0, Script var1, boolean var2) {
      return 2;
   }
}
