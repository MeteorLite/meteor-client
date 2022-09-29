import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	@Export("js5Socket")
	static AbstractSocket js5Socket;
	@ObfuscatedName("fn")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1478993123
	)
	final int field2703;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1217958337
	)
	final int field2704;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1407363735
	)
	final int field2705;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(0, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field2703 = var1;
		this.field2704 = var2;
		this.field2705 = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(FI)Z",
		garbageValue = "2147480714"
	)
	boolean method4687(float var1) {
		return var1 >= (float)this.field2705;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(Lmv;Lmv;Lmv;I)V",
		garbageValue = "288051440"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (class123.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		ModeWhere.loginBoxCenter = Login.loginBoxX + 180;
		byte var3;
		int var4;
		int var10;
		int var12;
		int var25;
		int var26;
		int var28;
		int var30;
		int var34;
		int var41;
		if (Login.worldSelectOpen) {
			int var47;
			if (class82.worldSelectBackSprites == null) {
				Archive var42 = ChatChannel.archive8;
				var41 = var42.getGroupId("sl_back");
				var47 = var42.getFileId(var41, "");
				SpritePixels[] var49 = AbstractRasterProvider.method8301(var42, var41, var47);
				class82.worldSelectBackSprites = var49;
			}

			if (ReflectionCheck.worldSelectFlagSprites == null) {
				ReflectionCheck.worldSelectFlagSprites = SpriteMask.method5693(ChatChannel.archive8, "sl_flags", "");
			}

			if (UserComparator6.worldSelectArrows == null) {
				UserComparator6.worldSelectArrows = SpriteMask.method5693(ChatChannel.archive8, "sl_arrows", "");
			}

			if (class182.worldSelectStars == null) {
				class182.worldSelectStars = SpriteMask.method5693(ChatChannel.archive8, "sl_stars", "");
			}

			if (class239.worldSelectLeftSprite == null) {
				class239.worldSelectLeftSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(ChatChannel.archive8, "leftarrow", "");
			}

			if (class13.worldSelectRightSprite == null) {
				class13.worldSelectRightSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(ChatChannel.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (class182.worldSelectStars != null) {
				class182.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				class182.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (UserComparator6.worldSelectArrows != null) {
				var34 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					UserComparator6.worldSelectArrows[2].drawAt(var34, 4);
				} else {
					UserComparator6.worldSelectArrows[0].drawAt(var34, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					UserComparator6.worldSelectArrows[3].drawAt(var34 + 15, 4);
				} else {
					UserComparator6.worldSelectArrows[1].drawAt(var34 + 15, 4);
				}

				var0.draw("World", var34 + 32, 17, 16777215, -1);
				var4 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					UserComparator6.worldSelectArrows[2].drawAt(var4, 4);
				} else {
					UserComparator6.worldSelectArrows[0].drawAt(var4, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					UserComparator6.worldSelectArrows[3].drawAt(var4 + 15, 4);
				} else {
					UserComparator6.worldSelectArrows[1].drawAt(var4 + 15, 4);
				}

				var0.draw("Players", var4 + 32, 17, 16777215, -1);
				var41 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					UserComparator6.worldSelectArrows[2].drawAt(var41, 4);
				} else {
					UserComparator6.worldSelectArrows[0].drawAt(var41, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					UserComparator6.worldSelectArrows[3].drawAt(var41 + 15, 4);
				} else {
					UserComparator6.worldSelectArrows[1].drawAt(var41 + 15, 4);
				}

				var0.draw("Location", var41 + 32, 17, 16777215, -1);
				var47 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					UserComparator6.worldSelectArrows[2].drawAt(var47, 4);
				} else {
					UserComparator6.worldSelectArrows[0].drawAt(var47, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					UserComparator6.worldSelectArrows[3].drawAt(var47 + 15, 4);
				} else {
					UserComparator6.worldSelectArrows[1].drawAt(var47 + 15, 4);
				}

				var0.draw("Type", var47 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (class82.worldSelectBackSprites != null) {
				var3 = 88;
				byte var38 = 19;
				var41 = 765 / (var3 + 1) - 1;
				var47 = 480 / (var38 + 1);

				do {
					var25 = var47;
					var26 = var41;
					if (var47 * (var41 - 1) >= World.World_count) {
						--var41;
					}

					if (var41 * (var47 - 1) >= World.World_count) {
						--var47;
					}

					if (var41 * (var47 - 1) >= World.World_count) {
						--var47;
					}
				} while(var47 != var25 || var41 != var26);

				var25 = (765 - var41 * var3) / (var41 + 1);
				if (var25 > 5) {
					var25 = 5;
				}

				var26 = (480 - var38 * var47) / (var47 + 1);
				if (var26 > 5) {
					var26 = 5;
				}

				var28 = (765 - var3 * var41 - var25 * (var41 - 1)) / 2;
				var10 = (480 - var38 * var47 - var26 * (var47 - 1)) / 2;
				var30 = (var47 + World.World_count - 1) / var47;
				Login.worldSelectPagesCount = var30 - var41;
				if (class239.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					class239.worldSelectLeftSprite.drawAt(8, class166.canvasHeight / 2 - class239.worldSelectLeftSprite.subHeight / 2);
				}

				if (class13.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					class13.worldSelectRightSprite.drawAt(class123.canvasWidth - class13.worldSelectRightSprite.subWidth - 8, class166.canvasHeight / 2 - class13.worldSelectRightSprite.subHeight / 2);
				}

				var12 = var10 + 23;
				int var37 = var28 + Login.xPadding;
				int var14 = 0;
				boolean var15 = false;
				int var16 = Login.worldSelectPage;

				int var17;
				for (var17 = var47 * var16; var17 < World.World_count && var16 - Login.worldSelectPage < var41; ++var17) {
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

					int var22 = 0;
					int var21;
					if (var18.isBeta()) {
						if (var18.isMembersOnly()) {
							var21 = class97.field1305.field1319;
						} else {
							var21 = class97.field1312.field1319;
						}
					} else if (var18.isDeadman()) {
						var22 = 16711680;
						if (var18.isMembersOnly()) {
							var21 = class97.field1311.field1319;
						} else {
							var21 = class97.field1309.field1319;
						}
					} else if (var18.method1739()) {
						if (var18.isMembersOnly()) {
							var21 = class97.field1314.field1319;
						} else {
							var21 = class97.field1310.field1319;
						}
					} else if (var18.isPvp()) {
						if (var18.isMembersOnly()) {
							var21 = class97.field1313.field1319;
						} else {
							var21 = class97.field1308.field1319;
						}
					} else if (var18.method1735()) {
						if (var18.isMembersOnly()) {
							var21 = class97.field1316.field1319;
						} else {
							var21 = class97.field1315.field1319;
						}
					} else if (var18.method1777()) {
						if (var18.isMembersOnly()) {
							var21 = class97.field1318.field1319;
						} else {
							var21 = class97.field1317.field1319;
						}
					} else if (var18.isMembersOnly()) {
						var21 = class97.field1306.field1319;
					} else {
						var21 = class97.field1307.field1319;
					}

					if (MouseHandler.MouseHandler_x >= var37 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var37 + var3 && MouseHandler.MouseHandler_y < var12 + var38 && var19) {
						Login.hoveredWorldIndex = var17;
						class82.worldSelectBackSprites[var21].drawTransOverlayAt(var37, var12, 128, 16777215);
						var15 = true;
					} else {
						class82.worldSelectBackSprites[var21].drawAt(var37, var12);
					}

					if (ReflectionCheck.worldSelectFlagSprites != null) {
						ReflectionCheck.worldSelectFlagSprites[(var18.isMembersOnly() ? 8 : 0) + var18.location].drawAt(var37 + 29, var12);
					}

					var0.drawCentered(Integer.toString(var18.id), var37 + 15, var38 / 2 + var12 + 5, var22, -1);
					var1.drawCentered(var20, var37 + 60, var38 / 2 + var12 + 5, 268435455, -1);
					var12 = var12 + var26 + var38;
					++var14;
					if (var14 >= var47) {
						var12 = var10 + 23;
						var37 = var37 + var3 + var25;
						var14 = 0;
						++var16;
					}
				}

				if (var15) {
					var17 = var1.stringWidth(World.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var32 = var1.ascent + 8;
					int var40 = MouseHandler.MouseHandler_y + 25;
					if (var32 + var40 > 480) {
						var40 = MouseHandler.MouseHandler_y - 25 - var32;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var40, var17, var32, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var40, var17, var32, 0);
					var1.drawCentered(World.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var40 + var1.ascent + 4, 0, -1);
				}
			}

			class20.rasterProvider.drawFull(0, 0);
		} else {
			TextureProvider.leftTitleSprite.drawAt(Login.xPadding, 0);
			PcmPlayer.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			MilliClock.logoSprite.drawAt(Login.xPadding + 382 - MilliClock.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var3 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
				var4 = 253 - var3;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
			}

			String var6;
			String var8;
			String var9;
			char[] var11;
			short var33;
			short var35;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var33 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16776960, 0);
				var34 = var33 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16776960, 0);
				var34 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16776960, 0);
				var34 += 15;
				var34 += 7;
				if (Login.loginIndex != 4 && Login.loginIndex != 10) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var34, 16777215, 0);
					var35 = 200;
					if (!Player.clientPreferences.method2397()) {
						var6 = Login.Login_username;
					} else {
						var8 = Login.Login_username;
						var10 = var8.length();
						var11 = new char[var10];

						for (var12 = 0; var12 < var10; ++var12) {
							var11[var12] = '*';
						}

						var9 = new String(var11);
						var6 = var9;
					}

					for (var6 = var6; var0.stringWidth(var6) > var35; var6 = var6.substring(0, var6.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6), Login.loginBoxX + 180 - 70, var34, 16777215, 0);
					var34 += 15;
					var8 = Login.Login_password;
					var10 = var8.length();
					var11 = new char[var10];

					for (var12 = 0; var12 < var10; ++var12) {
						var11[var12] = '*';
					}

					var9 = new String(var11);

					for (var9 = var9; var0.stringWidth(var9) > var35; var9 = var9.substring(1)) {
					}

					var0.draw("Password: " + var9, Login.loginBoxX + 180 - 108, var34, 16777215, 0);
					var34 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var23;
				if (Login.loginIndex == 0) {
					var33 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var33, 16776960, 0);
					var34 = var33 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var23 = 291;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var0.drawLines("New User", var4 - 73, var23 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var0.drawLines("Existing User", var4 - 73, var23 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var33 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16777215, 0);
					var34 = var33 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16777215, 0);
					var34 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16777215, 0);
					var34 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var23 = 321;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var0.drawCentered("Continue", var4, var23 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var0.drawCentered("Cancel", var4, var23 + 5, 16777215, 0);
				} else if (Login.loginIndex == 2) {
					var33 = 201;
					var0.drawCentered(Login.Login_response1, ModeWhere.loginBoxCenter, var33, 16776960, 0);
					var34 = var33 + 15;
					var0.drawCentered(Login.Login_response2, ModeWhere.loginBoxCenter, var34, 16776960, 0);
					var34 += 15;
					var0.drawCentered(Login.Login_response3, ModeWhere.loginBoxCenter, var34, 16776960, 0);
					var34 += 15;
					var34 += 7;
					var0.draw("Login: ", ModeWhere.loginBoxCenter - 110, var34, 16777215, 0);
					var35 = 200;
					if (!Player.clientPreferences.method2397()) {
						var6 = Login.Login_username;
					} else {
						var8 = Login.Login_username;
						var10 = var8.length();
						var11 = new char[var10];

						for (var12 = 0; var12 < var10; ++var12) {
							var11[var12] = '*';
						}

						var9 = new String(var11);
						var6 = var9;
					}

					for (var6 = var6; var0.stringWidth(var6) > var35; var6 = var6.substring(1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? SoundCache.colorStartTag(16776960) + "|" : ""), ModeWhere.loginBoxCenter - 70, var34, 16777215, 0);
					var34 += 15;
					var8 = Login.Login_password;
					var10 = var8.length();
					var11 = new char[var10];

					for (var12 = 0; var12 < var10; ++var12) {
						var11[var12] = '*';
					}

					var9 = new String(var11);

					for (var9 = var9; var0.stringWidth(var9) > var35; var9 = var9.substring(1)) {
					}

					var0.draw("Password: " + var9 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? SoundCache.colorStartTag(16776960) + "|" : ""), ModeWhere.loginBoxCenter - 108, var34, 16777215, 0);
					var34 += 15;
					var33 = 277;
					var10 = ModeWhere.loginBoxCenter + -117;
					IndexedSprite var36 = Client.method1725(Client.Login_isUsernameRemembered, Login.field925);
					var36.drawAt(var10, var33);
					var10 = var10 + var36.subWidth + 5;
					var1.draw("Remember username", var10, var33 + 13, 16776960, 0);
					var10 = ModeWhere.loginBoxCenter + 24;
					var36 = Client.method1725(Player.clientPreferences.method2397(), Login.field920);
					var36.drawAt(var10, var33);
					var10 = var10 + var36.subWidth + 5;
					var1.draw("Hide username", var10, var33 + 13, 16776960, 0);
					var34 = var33 + 15;
					var12 = ModeWhere.loginBoxCenter - 80;
					short var13 = 321;
					Login.titlebuttonSprite.drawAt(var12 - 73, var13 - 20);
					var0.drawCentered("Login", var12, var13 + 5, 16777215, 0);
					var12 = ModeWhere.loginBoxCenter + 80;
					Login.titlebuttonSprite.drawAt(var12 - 73, var13 - 20);
					var0.drawCentered("Cancel", var12, var13 + 5, 16777215, 0);
					var33 = 357;
					switch(Login.field903) {
					case 2:
						SceneTilePaint.field2648 = "Having trouble logging in?";
						break;
					default:
						SceneTilePaint.field2648 = "Can't login? Click here.";
					}

					class269.field3195 = new Bounds(ModeWhere.loginBoxCenter, var33, var1.stringWidth(SceneTilePaint.field2648), 11);
					Projectile.field957 = new Bounds(ModeWhere.loginBoxCenter, var33, var1.stringWidth("Still having trouble logging in?"), 11);
					var1.drawCentered(SceneTilePaint.field2648, ModeWhere.loginBoxCenter, var33, 16777215, 0);
				} else if (Login.loginIndex == 3) {
					var33 = 201;
					var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var33, 16776960, 0);
					var34 = var33 + 20;
					var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var34, 16776960, 0);
					var34 += 15;
					var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var34, 16776960, 0);
					var34 += 15;
					var4 = Login.loginBoxX + 180;
					var23 = 276;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var2.drawCentered("Try again", var4, var23 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180;
					var23 = 326;
					Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
					var2.drawCentered("Forgotten password?", var4, var23 + 5, 16777215, 0);
				} else {
					String var5;
					if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var33 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16777215, 0);
						var34 = var33 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16777215, 0);
						var34 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16777215, 0);
						var34 += 15;
						var5 = "PIN: ";
						String var7 = class28.otp;
						var28 = var7.length();
						char[] var29 = new char[var28];

						for (var30 = 0; var30 < var28; ++var30) {
							var29[var30] = '*';
						}

						var8 = new String(var29);
						var0.draw(var5 + var8 + (Client.cycle % 40 < 20 ? SoundCache.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var34, 16777215, 0);
						var34 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var34, 16776960, 0);
						var34 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var34, 16776960, 0);
						var26 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						var28 = var34 - var0.ascent;
						IndexedSprite var48;
						if (Login.field916) {
							var48 = UserComparator7.options_buttons_2Sprite;
						} else {
							var48 = WorldMapDecoration.options_buttons_0Sprite;
						}

						var48.drawAt(var26, var28);
						var34 += 15;
						var30 = Login.loginBoxX + 180 - 80;
						short var39 = 321;
						Login.titlebuttonSprite.drawAt(var30 - 73, var39 - 20);
						var0.drawCentered("Continue", var30, var39 + 5, 16777215, 0);
						var30 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var30 - 73, var39 - 20);
						var0.drawCentered("Cancel", var30, var39 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var39 + 36, 255, 0);
					} else {
						short var43;
						if (Login.loginIndex == 5) {
							var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
							var33 = 221;
							var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 15;
							var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var34 += 14;
							var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var34, 16777215, 0);
							var35 = 174;
							if (!Player.clientPreferences.method2397()) {
								var6 = Login.Login_username;
							} else {
								var8 = Login.Login_username;
								var10 = var8.length();
								var11 = new char[var10];

								for (var12 = 0; var12 < var10; ++var12) {
									var11[var12] = '*';
								}

								var9 = new String(var11);
								var6 = var9;
							}

							for (var6 = var6; var0.stringWidth(var6) > var35; var6 = var6.substring(1)) {
							}

							var0.draw(AbstractFont.escapeBrackets(var6) + (Client.cycle % 40 < 20 ? SoundCache.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var34, 16777215, 0);
							var34 += 15;
							var25 = Login.loginBoxX + 180 - 80;
							var43 = 321;
							Login.titlebuttonSprite.drawAt(var25 - 73, var43 - 20);
							var0.drawCentered("Recover", var25, var43 + 5, 16777215, 0);
							var25 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var25 - 73, var43 - 20);
							var0.drawCentered("Back", var25, var43 + 5, 16777215, 0);
							var43 = 356;
							var1.drawCentered("Still having trouble logging in?", ModeWhere.loginBoxCenter, var43, 268435455, 0);
						} else if (Login.loginIndex == 6) {
							var33 = 201;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var4 = Login.loginBoxX + 180;
							var23 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Back", var4, var23 + 5, 16777215, 0);
						} else if (Login.loginIndex == 7) {
							if (UserComparator9.field1387 && !Client.onMobile) {
								var33 = 201;
								var0.drawCentered(Login.Login_response1, ModeWhere.loginBoxCenter, var33, 16776960, 0);
								var34 = var33 + 15;
								var0.drawCentered(Login.Login_response2, ModeWhere.loginBoxCenter, var34, 16776960, 0);
								var34 += 15;
								var0.drawCentered(Login.Login_response3, ModeWhere.loginBoxCenter, var34, 16776960, 0);
								var4 = ModeWhere.loginBoxCenter - 150;
								var34 += 10;

								for (var41 = 0; var41 < 8; ++var41) {
									Login.titlebuttonSprite.method8316(var4, var34, 30, 40);
									boolean var27 = var41 == Login.field891 & Client.cycle % 40 < 20;
									var0.draw((Login.field907[var41] == null ? "" : Login.field907[var41]) + (var27 ? SoundCache.colorStartTag(16776960) + "|" : ""), var4 + 10, var34 + 27, 16777215, 0);
									if (var41 != 1 && var41 != 3) {
										var4 += 35;
									} else {
										var4 += 50;
										var0.draw(AbstractFont.escapeBrackets("/"), var4 - 13, var34 + 27, 16777215, 0);
									}
								}

								var41 = ModeWhere.loginBoxCenter - 80;
								short var44 = 321;
								Login.titlebuttonSprite.drawAt(var41 - 73, var44 - 20);
								var0.drawCentered("Submit", var41, var44 + 5, 16777215, 0);
								var41 = ModeWhere.loginBoxCenter + 80;
								Login.titlebuttonSprite.drawAt(var41 - 73, var44 - 20);
								var0.drawCentered("Cancel", var41, var44 + 5, 16777215, 0);
							} else {
								var33 = 216;
								var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var33, 16776960, 0);
								var34 = var33 + 15;
								var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var34, 16776960, 0);
								var34 += 15;
								var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var34, 16776960, 0);
								var34 += 15;
								var4 = Login.loginBoxX + 180 - 80;
								var23 = 321;
								Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
								var0.drawCentered("Set Date of Birth", var4, var23 + 5, 16777215, 0);
								var4 = Login.loginBoxX + 180 + 80;
								Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
								var0.drawCentered("Back", var4, var23 + 5, 16777215, 0);
							}
						} else if (Login.loginIndex == 8) {
							var33 = 216;
							var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 15;
							var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var23 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Privacy Policy", var4, var23 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Back", var4, var23 + 5, 16777215, 0);
						} else if (Login.loginIndex == 9) {
							var33 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 25;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 25;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16776960, 0);
							var4 = Login.loginBoxX + 180;
							var23 = 311;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Try again", var4, var23 + 5, 16777215, 0);
						} else if (Login.loginIndex == 10) {
							var34 = Login.loginBoxX + 180;
							var35 = 209;
							var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var35, 16776960, 0);
							var4 = var35 + 20;
							Calendar.field3331.drawAt(var34 - 109, var4);
							class147.field1693.drawAt(var34 - 48, var4 + 18);
						} else if (Login.loginIndex == 12) {
							var34 = ModeWhere.loginBoxCenter;
							var35 = 216;
							var2.drawCentered("Before using this app, please read and accept our", var34, var35, 16777215, 0);
							var4 = var35 + 17;
							var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var34, var4, 16777215, 0);
							var4 += 17;
							var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var34, var4, 16777215, 0);
							var4 += 17;
							var2.drawCentered("By accepting, you agree to these documents.", var34, var4, 16777215, 0);
							var34 = ModeWhere.loginBoxCenter - 80;
							var35 = 311;
							Login.titlebuttonSprite.drawAt(var34 - 73, var35 - 20);
							var0.drawCentered("Accept", var34, var35 + 5, 16777215, 0);
							var34 = ModeWhere.loginBoxCenter + 80;
							Login.titlebuttonSprite.drawAt(var34 - 73, var35 - 20);
							var0.drawCentered("Decline", var34, var35 + 5, 16777215, 0);
						} else if (Login.loginIndex == 13) {
							var33 = 231;
							var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var33, 16777215, 0);
							var34 = var33 + 20;
							var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var34, 16777215, 0);
							var4 = Login.loginBoxX + 180;
							var33 = 311;
							Login.titlebuttonSprite.drawAt(var4 - 73, var33 - 20);
							var0.drawCentered("Back", var4, var33 + 5, 16777215, 0);
						} else if (Login.loginIndex == 14) {
							var33 = 201;
							String var24 = "";
							var5 = "";
							var6 = "";
							switch(Login.field902) {
							case 0:
								var24 = "Your account has been involved";
								var5 = "in serious rule breaking.";
								var6 = "";
								break;
							case 1:
								var24 = "Account locked as we suspect it has been stolen.";
								var5 = Strings.field3748;
								var6 = "";
								break;
							case 2:
								var24 = "The unpaid balance on your account needs";
								var5 = "to be resolved before you can play.";
								var6 = Strings.field3965;
								break;
							default:
								Calendar.Login_promptCredentials(false);
							}

							var0.drawCentered(var24, Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 20;
							var0.drawCentered(var5, Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 20;
							var0.drawCentered(var6, Login.loginBoxX + 180, var34, 16776960, 0);
							var25 = Login.loginBoxX + 180;
							var43 = 276;
							Login.titlebuttonSprite.drawAt(var25 - 73, var43 - 20);
							var0.drawCentered("Support Page", var25, var43 + 5, 16777215, 0);
							var25 = Login.loginBoxX + 180;
							var43 = 326;
							Login.titlebuttonSprite.drawAt(var25 - 73, var43 - 20);
							var0.drawCentered("Back", var25, var43 + 5, 16777215, 0);
						} else if (Login.loginIndex == 24) {
							var33 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var33, 16777215, 0);
							var34 = var33 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var34, 16777215, 0);
							var34 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var34, 16777215, 0);
							var34 += 15;
							var4 = Login.loginBoxX + 180;
							var23 = 301;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Ok", var4, var23 + 5, 16777215, 0);
						} else if (Login.loginIndex == 26) {
							var33 = 216;
							var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var33, 16776960, 0);
							var34 = var33 + 15;
							var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var34, 16776960, 0);
							var34 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var23 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Set Date of Birth", var4, var23 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var4 - 73, var23 - 20);
							var0.drawCentered("Back", var4, var23 + 5, 16777215, 0);
						}
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var31 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var31);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, class166.canvasHeight);
				VertexNormal.field2637.draw(Login.xPadding - 22, Client.cycle);
				VertexNormal.field2637.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var31);
			}

			LoginType.title_muteSprite[Player.clientPreferences.method2393() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && class271.clientLanguage == Language.Language_EN) {
				if (class10.field45 != null) {
					var34 = Login.xPadding + 5;
					var35 = 463;
					byte var45 = 100;
					byte var46 = 35;
					class10.field45.drawAt(var34, var35);
					var0.drawCentered("World" + " " + Client.worldId, var45 / 2 + var34, var46 / 2 + var35 - 2, 16777215, 0);
					if (Frames.World_request != null) {
						var1.drawCentered("Loading...", var45 / 2 + var34, var46 / 2 + var35 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var45 / 2 + var34, var46 / 2 + var35 + 12, 16777215, 0);
					}
				} else {
					class10.field45 = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(ChatChannel.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		descriptor = "(Lgd;IIII)V",
		garbageValue = "1541393387"
	)
	static void method4684(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Player.clientPreferences.method2474() != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var7 = var4 >> 8;
					int var8 = var4 >> 4 & 7;
					int var9 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var7;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var8;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var10 = (var2 - 64) / 128;
					int var11 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var9 + (var11 << 8) + (var10 << 16);
					++Client.soundEffectCount;
				}

			}
		}
	}
}
