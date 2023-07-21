import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("UserComparator10")
public class UserComparator10 extends AbstractUserComparator {
	@ObfuscatedName("ag")
	static byte[][][] field1180;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("Widget_spritesArchive")
	public static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("aw")
	@Export("reversed")
	final boolean reversed;

	public UserComparator10(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lqa;Lqa;I)I",
		garbageValue = "1605409711"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;ZII)V",
		garbageValue = "1893975915"
	)
	static void method682(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.clearLoginScreen) {
			if (var3 == 4) {
				class328.method1678(4);
			}

		} else {
			if (var3 == 0) {
				class333.method1811(var2);
			} else {
				class328.method1678(var3);
			}

			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			class407.leftTitleSprite = ClanChannelMember.method769(var4);
			ScriptFrame.rightTitleSprite = class407.leftTitleSprite.mirrorHorizontally();
			class425.method2154(var1, Client.worldProperties);
			Login.titleboxSprite = class451.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = class451.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.field773 = class451.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
			DirectByteArrayCopier.field3096 = class451.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
			class451.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
			Login.runesSprite = DesktopPlatformInfoProvider.method2334(var1, "runes", "");
			class304.title_muteSprite = DesktopPlatformInfoProvider.method2334(var1, "title_mute", "");
			WorldMapLabelSize.options_buttons_0Sprite = class451.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			class4.field4 = class451.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			class11.options_buttons_2Sprite = class451.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			Message.field348 = class451.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class139.field1311 = WorldMapLabelSize.options_buttons_0Sprite.subWidth;
			class453.field3874 = WorldMapLabelSize.options_buttons_0Sprite.subHeight;
			class165.field1419 = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
				Login.field767 = new String[8];
				Login.field748 = 0;
			}

			class424.field3758 = 0;
			Login.otp = "";
			Login.field739 = true;
			Login.worldSelectOpen = false;
			if (!class150.clientPreferences.getTitleMusicDisabled()) {
				ArrayList var5 = new ArrayList();
				var5.add(new class318(class13.archive6, "scape main", "", 255, false));
				UserComparator4.method663(var5, 0, 0, 0, 100, false);
			} else {
				RouteStrategy.method1107(0, 0);
			}

			class306.field2755.clear();
			class360 var6 = class153.field1356;
			var6.method1896(false);
			Login.clearLoginScreen = true;
			Login.xPadding = (GrandExchangeOfferTotalQuantityComparator.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			Script.loginBoxCenter = Login.loginBoxX + 180;
			class407.leftTitleSprite.drawAt(Login.xPadding, 0);
			ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;IZB)Z",
		garbageValue = "41"
	)
	static boolean method681(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						return false;
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					return false;
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var10 + var5 * var1;
				if (var9 / var1 != var5) {
					return false;
				}

				var5 = var9;
				var4 = true;
			}

			return var4;
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZB)I",
		garbageValue = "0"
	)
	static int method683(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var4 = VarbitComposition.getWidget(var3);
		} else {
			var4 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
		}

		if (var0 == 1000) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			class200.invalidateWidget(var4);
			TileItem.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == 1001) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			class200.invalidateWidget(var4);
			TileItem.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == 1003) {
			boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				class200.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == 1005) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == 1006) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1405780494"
	)
	static final int method684(int var0, int var1) {
		int var2 = class419.method2124(var0 + 45365, var1 + 91923, 4) - 128 + (class419.method2124(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (class419.method2124(var0, var1, 1) - 128 >> 2);
		var2 = (int)(0.3D * (double)var2) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}
}
