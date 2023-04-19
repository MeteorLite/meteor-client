import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public enum class6 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Laq;"
   )
   field9(0, 0);

   @ObfuscatedName("an")
   final int field10;
   @ObfuscatedName("aw")
   final int field8;

   class6(int var3, int var4) {
      this.field10 = var3;
      this.field8 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field8;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1788010106"
   )
   static int method20() {
      return Rasterizer3D.clips.field2233;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(ZI)V",
            garbageValue = "1620071571"
    )
    static void Login_promptCredentials(boolean var0) {
      if (!ScriptFrame.client.method394() && !ScriptFrame.client.method370() && !ScriptFrame.client.method369()) {
         Login.Login_response1 = "";
         Login.Login_response2 = "Enter your username/email & password.";
         Login.Login_response3 = "";
         class129.method763(2);
         if (var0) {
            Login.Login_password = "";
         }

         WallDecoration.method1385();
         if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
            Login.currentLoginField = 1;
         } else {
            Login.currentLoginField = 0;
         }

      } else {
         class129.method763(10);
      }
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(Lon;Lon;Lon;I)V",
            garbageValue = "-1602531743"
    )
    static void drawTitle(Font var0, Font var1, Font var2) {
      Login.xPadding = (GameEngine.canvasWidth - 765) / 2;
      Login.loginBoxX = Login.xPadding + 202;
      class143.loginBoxCenter = Login.loginBoxX + 180;
      if (Login.worldSelectOpen) {
         Decimator.method328(var0, var1);
      } else {
         class123.leftTitleSprite.drawAt(Login.xPadding, 0);
         ParamComposition.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
         Canvas.logoSprite.drawAt(Login.xPadding + 382 - Canvas.logoSprite.subWidth / 2, 18);
         int var4;
         if (Client.gameState == 0 || Client.gameState == 5) {
            byte var3 = 20;
            var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
            var4 = 253 - var3;
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
            var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
         }

         String var5;
         String var6;
         short var22;
         int var23;
         short var24;
         if (Client.gameState == 20) {
            Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
            var22 = 201;
            var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
            var23 = var22 + 15;
            var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
            var23 += 15;
            var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
            var23 += 15;
            var23 += 7;
            if (Login.loginIndex != 4 && Login.loginIndex != 10) {
               var0.draw("Login: ", Login.loginBoxX + 180 - 110, var23, 16777215, 0);
               var24 = 200;

               for(var5 = class18.method74(); var0.stringWidth(var5) > var24; var5 = var5.substring(0, var5.length() - 1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var5), Login.loginBoxX + 180 - 70, var23, 16777215, 0);
               var23 += 15;

               for(var6 = WorldMapDecorationType.method1841(Login.Login_password); var0.stringWidth(var6) > var24; var6 = var6.substring(1)) {
                  ;
               }

               var0.draw("Password: " + var6, Login.loginBoxX + 180 - 108, var23, 16777215, 0);
               var23 += 15;
            }
         }

         if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
            Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
            short var17;
            if (Login.loginIndex == 0) {
               var22 = 251;
               var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var22, 16776960, 0);
               var23 = var22 + 30;
               var4 = Login.loginBoxX + 180 - 80;
               var17 = 291;
               class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
               var0.drawLines("New User", var4 - 73, var17 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var4 = Login.loginBoxX + 180 + 80;
               class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
               var0.drawLines("Existing User", var4 - 73, var17 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if (Login.loginIndex == 1) {
               var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
               var22 = 236;
               var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
               var23 = var22 + 15;
               var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
               var23 += 15;
               var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
               var23 += 15;
               var4 = Login.loginBoxX + 180 - 80;
               var17 = 321;
               class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
               var0.drawCentered("Continue", var4, var17 + 5, 16777215, 0);
               var4 = Login.loginBoxX + 180 + 80;
               class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
               var0.drawCentered("Cancel", var4, var17 + 5, 16777215, 0);
            } else {
               int var7;
               if (Login.loginIndex == 2) {
                  var22 = 201;
                  var0.drawCentered(Login.Login_response1, class143.loginBoxCenter, var22, 16776960, 0);
                  var23 = var22 + 15;
                  var0.drawCentered(Login.Login_response2, class143.loginBoxCenter, var23, 16776960, 0);
                  var23 += 15;
                  var0.drawCentered(Login.Login_response3, class143.loginBoxCenter, var23, 16776960, 0);
                  var23 += 15;
                  var23 += 7;
                  var0.draw("Login: ", class143.loginBoxCenter - 110, var23, 16777215, 0);
                  var24 = 200;

                  for(var5 = class18.method74(); var0.stringWidth(var5) > var24; var5 = var5.substring(1)) {
                     ;
                  }

                  var0.draw(AbstractFont.escapeBrackets(var5) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? class383.colorStartTag(16776960) + "|" : ""), class143.loginBoxCenter - 70, var23, 16777215, 0);
                  var23 += 15;

                  for(var6 = WorldMapDecorationType.method1841(Login.Login_password); var0.stringWidth(var6) > var24; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.draw("Password: " + var6 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? class383.colorStartTag(16776960) + "|" : ""), class143.loginBoxCenter - 108, var23, 16777215, 0);
                  var23 += 15;
                  var22 = 277;
                  var7 = class143.loginBoxCenter + -117;
                  boolean var9 = Client.Login_isUsernameRemembered;
                  boolean var10 = Login.field730;
                  IndexedSprite var8 = var9 ? (var10 ? Login.field745 : class158.options_buttons_2Sprite) : (var10 ? Login.field733 : Login.options_buttons_0Sprite);
                  var8.drawAt(var7, var22);
                  var7 = var7 + var8.subWidth + 5;
                  var1.draw("Remember username", var7, var22 + 13, 16776960, 0);
                  var7 = class143.loginBoxCenter + 24;
                  boolean var13 = class20.clientPreferences.getIsUsernameHidden();
                  boolean var14 = Login.field740;
                  IndexedSprite var12 = var13 ? (var14 ? Login.field745 : class158.options_buttons_2Sprite) : (var14 ? Login.field733 : Login.options_buttons_0Sprite);
                  var12.drawAt(var7, var22);
                  var7 = var7 + var12.subWidth + 5;
                  var1.draw("Hide username", var7, var22 + 13, 16776960, 0);
                  var23 = var22 + 15;
                  int var15 = class143.loginBoxCenter - 80;
                  short var16 = 321;
                  class292.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
                  var0.drawCentered("Login", var15, var16 + 5, 16777215, 0);
                  var15 = class143.loginBoxCenter + 80;
                  class292.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
                  var0.drawCentered("Cancel", var15, var16 + 5, 16777215, 0);
                  var22 = 357;
                  switch(Login.field752) {
                  case 2:
                     class18.field58 = "Having trouble logging in?";
                     break;
                  default:
                     class18.field58 = "Can't login? Click here.";
                  }

                  class96.field1063 = new Bounds(class143.loginBoxCenter, var22, var1.stringWidth(class18.field58), 11);
                  class19.field60 = new Bounds(class143.loginBoxCenter, var22, var1.stringWidth("Still having trouble logging in?"), 11);
                  var1.drawCentered(class18.field58, class143.loginBoxCenter, var22, 16777215, 0);
               } else if (Login.loginIndex == 3) {
                  var22 = 201;
                  var0.drawCentered("Incorrect username or password.", Login.loginBoxX + 180, var22, 16776960, 0);
                  var23 = var22 + 20;
                  var1.drawCentered("If you have upgraded to a Jagex Account, you", Login.loginBoxX + 180, var23, 16776960, 0);
                  var23 += 20;
                  var1.drawCentered("need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", Login.loginBoxX + 180, var23, 16776960, 0);
                  var23 += 15;
                  var4 = Login.loginBoxX + 180;
                  var17 = 276;
                  class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                  var2.drawCentered("Try again", var4, var17 + 5, 16777215, 0);
                  var4 = Login.loginBoxX + 180;
                  var17 = 326;
                  class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                  var2.drawCentered("Forgotten password?", var4, var17 + 5, 16777215, 0);
               } else {
                  short var18;
                  int var27;
                  if (Login.loginIndex == 4) {
                     var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
                     var22 = 236;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
                     var23 = var22 + 15;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
                     var23 += 15;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
                     var23 += 15;
                     var0.draw("PIN: " + WorldMapDecorationType.method1841(Messages.otp) + (Client.cycle % 40 < 20 ? class383.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var23, 16777215, 0);
                     var23 -= 8;
                     var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var23, 16776960, 0);
                     var23 += 15;
                     var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var23, 16776960, 0);
                     var4 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
                     var27 = var23 - var0.ascent;
                     IndexedSprite var25;
                     if (Login.field751) {
                        var25 = class158.options_buttons_2Sprite;
                     } else {
                        var25 = Login.options_buttons_0Sprite;
                     }

                     var25.drawAt(var4, var27);
                     var23 += 15;
                     var7 = Login.loginBoxX + 180 - 80;
                     var18 = 321;
                     class292.titlebuttonSprite.drawAt(var7 - 73, var18 - 20);
                     var0.drawCentered("Continue", var7, var18 + 5, 16777215, 0);
                     var7 = Login.loginBoxX + 180 + 80;
                     class292.titlebuttonSprite.drawAt(var7 - 73, var18 - 20);
                     var0.drawCentered("Cancel", var7, var18 + 5, 16777215, 0);
                     var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var18 + 36, 255, 0);
                  } else if (Login.loginIndex == 5) {
                     var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
                     var22 = 221;
                     var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 15;
                     var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var23 += 14;
                     var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var23, 16777215, 0);
                     var24 = 174;

                     for(var5 = class18.method74(); var0.stringWidth(var5) > var24; var5 = var5.substring(1)) {
                        ;
                     }

                     var0.draw(AbstractFont.escapeBrackets(var5) + (Client.cycle % 40 < 20 ? class383.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var23, 16777215, 0);
                     var23 += 15;
                     int var19 = Login.loginBoxX + 180 - 80;
                     short var26 = 321;
                     class292.titlebuttonSprite.drawAt(var19 - 73, var26 - 20);
                     var0.drawCentered("Recover", var19, var26 + 5, 16777215, 0);
                     var19 = Login.loginBoxX + 180 + 80;
                     class292.titlebuttonSprite.drawAt(var19 - 73, var26 - 20);
                     var0.drawCentered("Back", var19, var26 + 5, 16777215, 0);
                     var26 = 356;
                     var1.drawCentered("Still having trouble logging in?", class143.loginBoxCenter, var26, 268435455, 0);
                  } else if (Login.loginIndex == 6) {
                     var22 = 201;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 15;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var4 = Login.loginBoxX + 180;
                     var17 = 321;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 7) {
                     if (WorldMapSectionType.field2384 && !Client.onMobile) {
                        var22 = 201;
                        var0.drawCentered(Login.Login_response1, class143.loginBoxCenter, var22, 16776960, 0);
                        var23 = var22 + 15;
                        var0.drawCentered(Login.Login_response2, class143.loginBoxCenter, var23, 16776960, 0);
                        var23 += 15;
                        var0.drawCentered(Login.Login_response3, class143.loginBoxCenter, var23, 16776960, 0);
                        var4 = class143.loginBoxCenter - 150;
                        var23 += 10;

                        for(var27 = 0; var27 < 8; ++var27) {
                           class292.titlebuttonSprite.method2596(var4, var23, 30, 40);
                           boolean var28 = var27 == Login.field747 & Client.cycle % 40 < 20;
                           var0.draw((Login.field748[var27] == null ? "" : Login.field748[var27]) + (var28 ? class383.colorStartTag(16776960) + "|" : ""), var4 + 10, var23 + 27, 16777215, 0);
                           if (var27 != 1 && var27 != 3) {
                              var4 += 35;
                           } else {
                              var4 += 50;
                              var0.draw(AbstractFont.escapeBrackets("/"), var4 - 13, var23 + 27, 16777215, 0);
                           }
                        }

                        var27 = class143.loginBoxCenter - 80;
                        short var29 = 321;
                        class292.titlebuttonSprite.drawAt(var27 - 73, var29 - 20);
                        var0.drawCentered("Submit", var27, var29 + 5, 16777215, 0);
                        var27 = class143.loginBoxCenter + 80;
                        class292.titlebuttonSprite.drawAt(var27 - 73, var29 - 20);
                        var0.drawCentered("Cancel", var27, var29 + 5, 16777215, 0);
                     } else {
                        var22 = 216;
                        var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var22, 16776960, 0);
                        var23 = var22 + 15;
                        var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var23, 16776960, 0);
                        var23 += 15;
                        var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var23, 16776960, 0);
                        var23 += 15;
                        var4 = Login.loginBoxX + 180 - 80;
                        var17 = 321;
                        class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                        var0.drawCentered("Set Date of Birth", var4, var17 + 5, 16777215, 0);
                        var4 = Login.loginBoxX + 180 + 80;
                        class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                        var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
                     }
                  } else if (Login.loginIndex == 8) {
                     var22 = 216;
                     var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 15;
                     var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var4 = Login.loginBoxX + 180 - 80;
                     var17 = 321;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Privacy Policy", var4, var17 + 5, 16777215, 0);
                     var4 = Login.loginBoxX + 180 + 80;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 9) {
                     var22 = 221;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 25;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 25;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
                     var4 = Login.loginBoxX + 180;
                     var17 = 311;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Try again", var4, var17 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 10) {
                     var23 = Login.loginBoxX + 180;
                     var24 = 209;
                     var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var24, 16776960, 0);
                     var4 = var24 + 20;
                     class439.field3828.drawAt(var23 - 109, var4);
                     if (Login.field749.isEmpty()) {
                        class376.field3605.drawAt(var23 - 48, var4 + 18);
                     } else {
                        class376.field3605.drawAt(var23 - 48, var4 + 5);
                        var0.drawCentered(Login.field749, var23, var4 + 68 - 15, 16776960, 0);
                     }
                  } else if (Login.loginIndex == 12) {
                     var23 = class143.loginBoxCenter;
                     var24 = 216;
                     var2.drawCentered("Before using this app, please read and accept our", var23, var24, 16777215, 0);
                     var4 = var24 + 17;
                     var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var23, var4, 16777215, 0);
                     var4 += 17;
                     var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var23, var4, 16777215, 0);
                     var4 += 17;
                     var2.drawCentered("By accepting, you agree to these documents.", var23, var4, 16777215, 0);
                     var23 = class143.loginBoxCenter - 80;
                     var24 = 311;
                     class292.titlebuttonSprite.drawAt(var23 - 73, var24 - 20);
                     var0.drawCentered("Accept", var23, var24 + 5, 16777215, 0);
                     var23 = class143.loginBoxCenter + 80;
                     class292.titlebuttonSprite.drawAt(var23 - 73, var24 - 20);
                     var0.drawCentered("Decline", var23, var24 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 13) {
                     var22 = 231;
                     var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var22, 16777215, 0);
                     var23 = var22 + 20;
                     var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var23, 16777215, 0);
                     var4 = Login.loginBoxX + 180;
                     var22 = 311;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var22 - 20);
                     var0.drawCentered("Back", var4, var22 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 14) {
                     var22 = 201;
                     String var20 = "";
                     var5 = "";
                     var6 = "";
                     switch(Login.field738) {
                     case 0:
                        var20 = "Your account has been involved";
                        var5 = "in serious rule breaking.";
                        var6 = "";
                        break;
                     case 1:
                        var20 = "Your account has been locked due to";
                        var5 = "suspicious activity.";
                        var6 = "Please recover your account.";
                        break;
                     case 2:
                        var20 = "The unpaid balance on your account needs";
                        var5 = "to be resolved before you can play.";
                        var6 = Strings.field3226;
                        break;
                     default:
                        Login_promptCredentials(false);
                     }

                     var0.drawCentered(var20, Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 20;
                     var0.drawCentered(var5, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 20;
                     var0.drawCentered(var6, Login.loginBoxX + 180, var23, 16776960, 0);
                     var7 = Login.loginBoxX + 180;
                     var18 = 276;
                     class292.titlebuttonSprite.drawAt(var7 - 73, var18 - 20);
                     if (Login.field738 == 1) {
                        var0.drawCentered("Recover Account", var7, var18 + 5, 16777215, 0);
                     } else {
                        var0.drawCentered("View Appeal Options", var7, var18 + 5, 16777215, 0);
                     }

                     var7 = Login.loginBoxX + 180;
                     var18 = 326;
                     class292.titlebuttonSprite.drawAt(var7 - 73, var18 - 20);
                     var0.drawCentered("Back", var7, var18 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 24) {
                     var22 = 221;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
                     var23 = var22 + 15;
                     var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
                     var23 += 15;
                     var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
                     var23 += 15;
                     var4 = Login.loginBoxX + 180;
                     var17 = 301;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Ok", var4, var17 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 32) {
                     var22 = 216;
                     var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 15;
                     var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var4 = Login.loginBoxX + 180 - 80;
                     var17 = 321;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Set Date of Birth", var4, var17 + 5, 16777215, 0);
                     var4 = Login.loginBoxX + 180 + 80;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
                  } else if (Login.loginIndex == 33) {
                     var22 = 201;
                     var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
                     var23 = var22 + 20;
                     var1.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 20;
                     var1.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
                     var23 += 15;
                     var4 = Login.loginBoxX + 180;
                     var17 = 276;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var2.drawCentered("Download Launcher", var4, var17 + 5, 16777215, 0);
                     var4 = Login.loginBoxX + 180;
                     var17 = 326;
                     class292.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
                     var2.drawCentered("Back", var4, var17 + 5, 16777215, 0);
                  }
               }
            }
         }

         if (Client.gameState >= 10) {
            int[] var21 = new int[4];
            Rasterizer2D.Rasterizer2D_getClipArray(var21);
            Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, class262.canvasHeight);
            class121.field1184.draw(Login.xPadding - 22, Client.cycle);
            class121.field1184.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
            Rasterizer2D.Rasterizer2D_setClipArray(var21);
         }

         class148.title_muteSprite[class20.clientPreferences.getTitleMusicDisabled() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
         if (Client.gameState > 5 && Language.Language_EN == ClanSettings.clientLanguage) {
            if (class319.field3030 != null) {
               var23 = Login.xPadding + 5;
               var24 = 463;
               byte var31 = 100;
               byte var30 = 35;
               class319.field3030.drawAt(var23, var24);
               var0.drawCentered("World" + " " + Client.worldId, var31 / 2 + var23, var30 / 2 + var24 - 2, 16777215, 0);
               if (class11.World_request != null) {
                  var1.drawCentered("Loading...", var31 / 2 + var23, var30 / 2 + var24 + 12, 16777215, 0);
               } else {
                  var1.drawCentered("Click to switch", var31 / 2 + var23, var30 / 2 + var24 + 12, 16777215, 0);
               }
            } else {
               class319.field3030 = MusicPatchNode2.SpriteBuffer_getIndexedSpriteByName(class452.archive8, "sl_button", "");
            }
         }

      }
   }
}
