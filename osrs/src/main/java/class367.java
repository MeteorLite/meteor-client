import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("os")
public enum class367 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	field3512(-1),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	field3514(0),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	field3513(1),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	field3515(2);

	@ObfuscatedName("ao")
	final int field3516;

	class367(int var3) {
		this.field3516 = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3516;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lpu;Lpu;Lpu;I)V",
		garbageValue = "-266598843"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (class340.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		class379.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			ArchiveDiskActionHandler.method1914(var0, var1);
		} else {
			PcmPlayer.leftTitleSprite.drawAt(Login.xPadding, 0);
			Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
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

			String var6;
			String var7;
			String var8;
			String var9;
			short var23;
			int var24;
			short var25;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var23 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16776960, 0);
				var24 = var23 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16776960, 0);
				var24 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16776960, 0);
				var24 += 15;
				var24 += 7;
				if (Login.loginIndex != 4 && Login.loginIndex != 10) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var24, 16777215, 0);
					var25 = 200;
					if (class91.clientPreferences.getIsUsernameHidden()) {
						var8 = Login.Login_username;
						var7 = class92.method486('*', var8.length());
						var6 = var7;
					} else {
						var6 = Login.Login_username;
					}

					for (var6 = var6; var0.stringWidth(var6) > var25; var6 = var6.substring(0, var6.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6), Login.loginBoxX + 180 - 70, var24, 16777215, 0);
					var24 += 15;
					var8 = Login.Login_password;
					var7 = class92.method486('*', var8.length());

					for (var9 = var7; var0.stringWidth(var9) > var25; var9 = var9.substring(1)) {
					}

					var0.draw("Password: " + var9, Login.loginBoxX + 180 - 108, var24, 16777215, 0);
					var24 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var14;
				if (Login.loginIndex == 0) {
					var23 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var23, 16776960, 0);
					var24 = var23 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var14 = 291;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var0.drawLines("New User", var4 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var0.drawLines("Existing User", var4 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var23 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16777215, 0);
					var24 = var23 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16777215, 0);
					var24 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16777215, 0);
					var24 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var14 = 321;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var0.drawCentered("Continue", var4, var14 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var0.drawCentered("Cancel", var4, var14 + 5, 16777215, 0);
				} else if (Login.loginIndex == 2) {
					var23 = 201;
					var0.drawCentered(Login.Login_response1, class379.loginBoxCenter, var23, 16776960, 0);
					var24 = var23 + 15;
					var0.drawCentered(Login.Login_response2, class379.loginBoxCenter, var24, 16776960, 0);
					var24 += 15;
					var0.drawCentered(Login.Login_response3, class379.loginBoxCenter, var24, 16776960, 0);
					var24 += 15;
					var24 += 7;
					var0.draw("Login: ", class379.loginBoxCenter - 110, var24, 16777215, 0);
					var25 = 200;
					if (class91.clientPreferences.getIsUsernameHidden()) {
						var8 = Login.Login_username;
						var7 = class92.method486('*', var8.length());
						var6 = var7;
					} else {
						var6 = Login.Login_username;
					}

					for (var6 = var6; var0.stringWidth(var6) > var25; var6 = var6.substring(1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? Client.colorStartTag(16776960) + "|" : ""), class379.loginBoxCenter - 70, var24, 16777215, 0);
					var24 += 15;
					var8 = Login.Login_password;
					var7 = class92.method486('*', var8.length());

					for (var9 = var7; var0.stringWidth(var9) > var25; var9 = var9.substring(1)) {
					}

					var0.draw("Password: " + var9 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? Client.colorStartTag(16776960) + "|" : ""), class379.loginBoxCenter - 108, var24, 16777215, 0);
					var24 += 15;
					var23 = 277;
					int var10 = class379.loginBoxCenter + -117;
					IndexedSprite var11 = ClanSettings.method828(Client.Login_isUsernameRemembered, Login.field742);
					var11.drawAt(var10, var23);
					var10 = var10 + var11.subWidth + 5;
					var1.draw("Remember username", var10, var23 + 13, 16776960, 0);
					var10 = class379.loginBoxCenter + 24;
					var11 = ClanSettings.method828(class91.clientPreferences.getIsUsernameHidden(), Login.field743);
					var11.drawAt(var10, var23);
					var10 = var10 + var11.subWidth + 5;
					var1.draw("Hide username", var10, var23 + 13, 16776960, 0);
					var24 = var23 + 15;
					int var12 = class379.loginBoxCenter - 80;
					short var13 = 321;
					VarcInt.titlebuttonSprite.drawAt(var12 - 73, var13 - 20);
					var0.drawCentered("Login", var12, var13 + 5, 16777215, 0);
					var12 = class379.loginBoxCenter + 80;
					VarcInt.titlebuttonSprite.drawAt(var12 - 73, var13 - 20);
					var0.drawCentered("Cancel", var12, var13 + 5, 16777215, 0);
					var23 = 357;
					switch(Login.field749) {
					case 2:
						class16.field47 = "Having trouble logging in?";
						break;
					default:
						class16.field47 = "Can't login? Click here.";
					}

					class481.field3945 = new Bounds(class379.loginBoxCenter, var23, var1.stringWidth(class16.field47), 11);
					Message.field349 = new Bounds(class379.loginBoxCenter, var23, var1.stringWidth("Still having trouble logging in?"), 11);
					var1.drawCentered(class16.field47, class379.loginBoxCenter, var23, 16777215, 0);
				} else if (Login.loginIndex == 3) {
					var23 = 201;
					var0.drawCentered("Incorrect username or password.", Login.loginBoxX + 180, var23, 16776960, 0);
					var24 = var23 + 20;
					var1.drawCentered("If you have upgraded to a Jagex Account, you", Login.loginBoxX + 180, var24, 16776960, 0);
					var24 += 20;
					var1.drawCentered("need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", Login.loginBoxX + 180, var24, 16776960, 0);
					var24 += 15;
					var4 = Login.loginBoxX + 180;
					var14 = 276;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var2.drawCentered("Try again", var4, var14 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180;
					var14 = 326;
					VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
					var2.drawCentered("Forgotten password?", var4, var14 + 5, 16777215, 0);
				} else {
					String var5;
					if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var23 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16777215, 0);
						var24 = var23 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16777215, 0);
						var24 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16777215, 0);
						var24 += 15;
						var5 = "PIN: ";
						var7 = class186.otp;
						var6 = class92.method486('*', var7.length());
						var0.draw(var5 + var6 + (Client.cycle % 40 < 20 ? Client.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var24, 16777215, 0);
						var24 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var24, 16776960, 0);
						var24 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var24, 16776960, 0);
						int var16 = 180 + Login.loginBoxX - 9 + var0.stringWidth("for 30 days: ") + 15;
						int var17 = var24 - var0.ascent;
						IndexedSprite var18;
						if (Login.field741) {
							var18 = class534.options_buttons_2Sprite;
						} else {
							var18 = class519.options_buttons_0Sprite;
						}

						var18.drawAt(var16, var17);
						var24 += 15;
						int var19 = Login.loginBoxX + 180 - 80;
						short var26 = 321;
						VarcInt.titlebuttonSprite.drawAt(var19 - 73, var26 - 20);
						var0.drawCentered("Continue", var19, var26 + 5, 16777215, 0);
						var19 = Login.loginBoxX + 180 + 80;
						VarcInt.titlebuttonSprite.drawAt(var19 - 73, var26 - 20);
						var0.drawCentered("Cancel", var19, var26 + 5, 16777215, 0);
						var1.drawCentered("Can't login? Click here.", Login.loginBoxX + 180, var26 + 36, 16777215, 0);
					} else {
						int var20;
						short var28;
						if (Login.loginIndex == 5) {
							var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
							var23 = 221;
							var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 15;
							var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var24 += 14;
							var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var24, 16777215, 0);
							var25 = 174;
							if (class91.clientPreferences.getIsUsernameHidden()) {
								var8 = Login.Login_username;
								var7 = class92.method486('*', var8.length());
								var6 = var7;
							} else {
								var6 = Login.Login_username;
							}

							for (var6 = var6; var0.stringWidth(var6) > var25; var6 = var6.substring(1)) {
							}

							var0.draw(AbstractFont.escapeBrackets(var6) + (Client.cycle % 40 < 20 ? Client.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var24, 16777215, 0);
							var24 += 15;
							var20 = Login.loginBoxX + 180 - 80;
							var28 = 321;
							VarcInt.titlebuttonSprite.drawAt(var20 - 73, var28 - 20);
							var0.drawCentered("Recover", var20, var28 + 5, 16777215, 0);
							var20 = Login.loginBoxX + 180 + 80;
							VarcInt.titlebuttonSprite.drawAt(var20 - 73, var28 - 20);
							var0.drawCentered("Back", var20, var28 + 5, 16777215, 0);
							var28 = 356;
							var1.drawCentered("Still having trouble logging in?", class379.loginBoxCenter, var28, 268435455, 0);
						} else if (Login.loginIndex == 6) {
							var23 = 201;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var4 = Login.loginBoxX + 180;
							var14 = 321;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Back", var4, var14 + 5, 16777215, 0);
						} else if (Login.loginIndex == 7) {
							if (MusicPatchNode2.field2778 && !Client.onMobile) {
								var23 = 201;
								var0.drawCentered(Login.Login_response1, class379.loginBoxCenter, var23, 16776960, 0);
								var24 = var23 + 15;
								var0.drawCentered(Login.Login_response2, class379.loginBoxCenter, var24, 16776960, 0);
								var24 += 15;
								var0.drawCentered(Login.Login_response3, class379.loginBoxCenter, var24, 16776960, 0);
								var4 = class379.loginBoxCenter - 150;
								var24 += 10;

								int var27;
								for (var27 = 0; var27 < 8; ++var27) {
									VarcInt.titlebuttonSprite.method2693(var4, var24, 30, 40);
									boolean var21 = var27 == Login.field751 & Client.cycle % 40 < 20;
									var0.draw((Login.field766[var27] == null ? "" : Login.field766[var27]) + (var21 ? Client.colorStartTag(16776960) + "|" : ""), var4 + 10, var24 + 27, 16777215, 0);
									if (var27 != 1 && var27 != 3) {
										var4 += 35;
									} else {
										var4 += 50;
										var0.draw(AbstractFont.escapeBrackets("/"), var4 - 13, var24 + 27, 16777215, 0);
									}
								}

								var27 = class379.loginBoxCenter - 80;
								short var30 = 321;
								VarcInt.titlebuttonSprite.drawAt(var27 - 73, var30 - 20);
								var0.drawCentered("Submit", var27, var30 + 5, 16777215, 0);
								var27 = class379.loginBoxCenter + 80;
								VarcInt.titlebuttonSprite.drawAt(var27 - 73, var30 - 20);
								var0.drawCentered("Cancel", var27, var30 + 5, 16777215, 0);
							} else {
								var23 = 216;
								var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var23, 16776960, 0);
								var24 = var23 + 15;
								var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var24, 16776960, 0);
								var24 += 15;
								var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var24, 16776960, 0);
								var24 += 15;
								var4 = Login.loginBoxX + 180 - 80;
								var14 = 321;
								VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
								var0.drawCentered("Set Date of Birth", var4, var14 + 5, 16777215, 0);
								var4 = Login.loginBoxX + 180 + 80;
								VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
								var0.drawCentered("Back", var4, var14 + 5, 16777215, 0);
							}
						} else if (Login.loginIndex == 8) {
							var23 = 216;
							var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 15;
							var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var14 = 321;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Privacy Policy", var4, var14 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Back", var4, var14 + 5, 16777215, 0);
						} else if (Login.loginIndex == 9) {
							var23 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 25;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 25;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16776960, 0);
							var4 = Login.loginBoxX + 180;
							var14 = 311;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Try again", var4, var14 + 5, 16777215, 0);
						} else if (Login.loginIndex == 10) {
							var24 = Login.loginBoxX + 180;
							var25 = 209;
							var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var25, 16776960, 0);
							var4 = var25 + 20;
							Login.field775.drawAt(var24 - 109, var4);
							if (Login.field761.isEmpty()) {
								class364.field3198.drawAt(var24 - 48, var4 + 18);
							} else {
								class364.field3198.drawAt(var24 - 48, var4 + 5);
								var0.drawCentered(Login.field761, var24, var4 + 68 - 15, 16776960, 0);
							}
						} else if (Login.loginIndex == 12) {
							var24 = class379.loginBoxCenter;
							var25 = 216;
							var2.drawCentered("Before using this app, please read and accept our", var24, var25, 16777215, 0);
							var4 = var25 + 17;
							var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var24, var4, 16777215, 0);
							var4 += 17;
							var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var24, var4, 16777215, 0);
							var4 += 17;
							var2.drawCentered("By accepting, you agree to these documents.", var24, var4, 16777215, 0);
							var24 = class379.loginBoxCenter - 80;
							var25 = 311;
							VarcInt.titlebuttonSprite.drawAt(var24 - 73, var25 - 20);
							var0.drawCentered("Accept", var24, var25 + 5, 16777215, 0);
							var24 = class379.loginBoxCenter + 80;
							VarcInt.titlebuttonSprite.drawAt(var24 - 73, var25 - 20);
							var0.drawCentered("Decline", var24, var25 + 5, 16777215, 0);
						} else if (Login.loginIndex == 13) {
							var23 = 231;
							var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var23, 16777215, 0);
							var24 = var23 + 20;
							var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var24, 16777215, 0);
							var4 = Login.loginBoxX + 180;
							var23 = 311;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Back", var4, var23 + 5, 16777215, 0);
						} else if (Login.loginIndex == 14) {
							var23 = 201;
							String var15 = "";
							var5 = "";
							var6 = "";
							switch(Login.field748) {
							case 0:
								var15 = "Your account has been involved";
								var5 = "in serious rule breaking.";
								var6 = "";
								break;
							case 1:
								var15 = "Your account has been locked due to";
								var5 = "suspicious activity.";
								var6 = "Please recover your account.";
								break;
							case 2:
								var15 = "The unpaid balance on your account needs";
								var5 = "to be resolved before you can play.";
								var6 = Strings.field3355;
								break;
							default:
								class429.Login_promptCredentials(false);
							}

							var0.drawCentered(var15, Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 20;
							var0.drawCentered(var5, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 20;
							var0.drawCentered(var6, Login.loginBoxX + 180, var24, 16776960, 0);
							var20 = Login.loginBoxX + 180;
							var28 = 276;
							VarcInt.titlebuttonSprite.drawAt(var20 - 73, var28 - 20);
							if (Login.field748 == 1) {
								var0.drawCentered("Recover Account", var20, var28 + 5, 16777215, 0);
							} else {
								var0.drawCentered("View Appeal Options", var20, var28 + 5, 16777215, 0);
							}

							var20 = Login.loginBoxX + 180;
							var28 = 326;
							VarcInt.titlebuttonSprite.drawAt(var20 - 73, var28 - 20);
							var0.drawCentered("Back", var20, var28 + 5, 16777215, 0);
						} else if (Login.loginIndex == 24) {
							var23 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16777215, 0);
							var24 = var23 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16777215, 0);
							var24 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16777215, 0);
							var24 += 15;
							var4 = Login.loginBoxX + 180;
							var14 = 301;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Ok", var4, var14 + 5, 16777215, 0);
						} else if (Login.loginIndex == 32) {
							var23 = 216;
							var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 15;
							var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var14 = 321;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Set Date of Birth", var4, var14 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var0.drawCentered("Back", var4, var14 + 5, 16777215, 0);
						} else if (Login.loginIndex == 33) {
							var23 = 201;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var23, 16776960, 0);
							var24 = var23 + 20;
							var1.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 20;
							var1.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var24, 16776960, 0);
							var24 += 15;
							var4 = Login.loginBoxX + 180;
							var14 = 276;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var2.drawCentered("Download Launcher", var4, var14 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180;
							var14 = 326;
							VarcInt.titlebuttonSprite.drawAt(var4 - 73, var14 - 20);
							var2.drawCentered("Back", var4, var14 + 5, 16777215, 0);
						}
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var22 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var22);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, class491.canvasHeight);
				class544.field4278.draw(Login.xPadding - 22, Client.cycle);
				class544.field4278.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var22);
			}

			Login.title_muteSprite[class91.clientPreferences.getTitleMusicDisabled() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == WorldMapLabelSize.clientLanguage) {
				if (Varcs.field1138 != null) {
					var24 = Login.xPadding + 5;
					var25 = 463;
					byte var29 = 100;
					byte var31 = 35;
					Varcs.field1138.drawAt(var24, var25);
					var0.drawCentered("World" + " " + Client.worldId, var29 / 2 + var24, var31 / 2 + var25 - 2, 16777215, 0);
					if (class91.World_request != null) {
						var1.drawCentered("Loading...", var29 / 2 + var24, var31 / 2 + var25 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var29 / 2 + var24, var31 / 2 + var25 + 12, 16777215, 0);
					}
				} else {
					Varcs.field1138 = class167.SpriteBuffer_getIndexedSpriteByName(class199.archive8, "sl_button", "");
				}
			}

		}
	}
}