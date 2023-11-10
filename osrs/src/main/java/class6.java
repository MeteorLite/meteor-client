import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.util.ArrayList;

@ObfuscatedName("aa")
public enum class6 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Laa;"
	)
	field9(0, 0);

	@ObfuscatedName("wa")
	@ObfuscatedSignature(
		descriptor = "Lov;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("bl")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("km")
	static int field6;
	@ObfuscatedName("ah")
	final int field10;
	@ObfuscatedName("ar")
	final int field11;

	class6(int var3, int var4) {
		this.field10 = var3;
		this.field11 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field11;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;ZII)V",
		garbageValue = "-1391050872"
	)
	static void method14(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (class384.clearLoginScreen) {
			if (var3 == 4) {
				UserComparator7.method674(4);
			}

		} else {
			if (var3 == 0) {
				ClientPreferences.method568(var2);
			} else {
				UserComparator7.method674(var3);
			}

			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			class250.leftTitleSprite = WorldMapArchiveLoader.method2391(var4);
			Login.rightTitleSprite = class250.leftTitleSprite.mirrorHorizontally();
			MenuAction.method435(var1, Client.worldProperties);
			Login.titleboxSprite = class313.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = class313.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.field776 = class313.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
			class11.field38 = class313.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
			class313.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
			class134.runesSprite = Skills.method1895(var1, "runes", "");
			Login.title_muteSprite = Skills.method1895(var1, "title_mute", "");
			class310.options_buttons_0Sprite = class313.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			Login.field779 = class313.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			FriendsList.options_buttons_2Sprite = class313.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			GrandExchangeEvents.field3611 = class313.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			NPCComposition.field1532 = class310.options_buttons_0Sprite.subWidth;
			class113.field1178 = class310.options_buttons_0Sprite.subHeight;
			EnumComposition.field1505 = new LoginScreenAnimation(class134.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
				Login.field769 = new String[8];
				Login.field753 = 0;
			}

			class53.field256 = 0;
			NewShit.otp = "";
			Login.field744 = true;
			Login.worldSelectOpen = false;
			if (!WorldMapIcon_1.clientPreferences.getTitleMusicDisabled()) {
				ArrayList var5 = new ArrayList();
				var5.add(new MusicSong(class514.archive6, "scape main", "", 255, false));
				PendingSpawn.method505(var5, 0, 0, 0, 100, false);
			} else {
				WorldMapManager.method1265(0, 0);
			}

			class472.method2350();
			class157.method827().method1954(false);
			class384.clearLoginScreen = true;
			Login.xPadding = (Language.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			class157.loginBoxCenter = Login.loginBoxX + 180;
			class250.leftTitleSprite.drawAt(Login.xPadding, 0);
			Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IIIIIZI)Luz;",
		garbageValue = "-328465387"
	)
	@Export("getItemSprite")
	public static final SpritePixels getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (var1 == -1) {
			var4 = 0;
		} else if (var4 == 2 && var1 != 1) {
			var4 = 1;
		}

		long var6 = ((long)var4 << 40) + (long)var0 + ((long)var1 << 16) + ((long)var2 << 38) + ((long)var3 << 42);
		SpritePixels var8;
		if (!var5) {
			var8 = (SpritePixels)ItemComposition.ItemDefinition_cachedSprites.get(var6);
			if (var8 != null) {
				return var8;
			}
		}

		ItemComposition var9 = class214.ItemDefinition_get(var0);
		if (var1 > 1 && var9.countobj != null) {
			int var10 = -1;

			for (int var11 = 0; var11 < 10; ++var11) {
				if (var1 >= var9.countco[var11] && var9.countco[var11] != 0) {
					var10 = var9.countobj[var11];
				}
			}

			if (var10 != -1) {
				var9 = class214.ItemDefinition_get(var10);
			}
		}

		Model var22 = var9.getModel(1);
		if (var22 == null) {
			return null;
		} else {
			SpritePixels var23 = null;
			if (var9.noteTemplate != -1) {
				var23 = getItemSprite(var9.note, 10, 1, 0, 0, true);
				if (var23 == null) {
					return null;
				}
			} else if (var9.notedId != -1) {
				var23 = getItemSprite(var9.unnotedId, var1, var2, var3, 0, false);
				if (var23 == null) {
					return null;
				}
			} else if (var9.placeholderTemplate != -1) {
				var23 = getItemSprite(var9.placeholder, var1, 0, 0, 0, false);
				if (var23 == null) {
					return null;
				}
			}

			int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
			int var13 = Rasterizer2D.Rasterizer2D_width;
			int var14 = Rasterizer2D.Rasterizer2D_height;
			float[] var15 = Rasterizer2D.field4245;
			int[] var16 = new int[4];
			Rasterizer2D.Rasterizer2D_getClipArray(var16);
			var8 = new SpritePixels(36, 32);
			Rasterizer3D.method1426(var8.pixels, 36, 32, (float[])null);
			Rasterizer2D.Rasterizer2D_clear();
			Rasterizer3D.method1427();
			Rasterizer3D.method1430(16, 16);
			Rasterizer3D.clips.field2457 = false;
			if (var9.placeholderTemplate != -1) {
				var23.drawTransBgAt(0, 0);
			}

			int var17 = var9.zoom2d;
			if (var5) {
				var17 = (int)(1.5D * (double)var17);
			} else if (var2 == 2) {
				var17 = (int)((double)var17 * 1.04D);
			}

			int var18 = var17 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
			int var19 = var17 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
			var22.calculateBoundsCylinder();
			var22.method1556(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var22.height / 2 + var18 + var9.offsetY2d, var19 + var9.offsetY2d);
			if (var9.notedId != -1) {
				var23.drawTransBgAt(0, 0);
			}

			if (var2 >= 1) {
				var8.outline(1);
			}

			if (var2 >= 2) {
				var8.outline(16777215);
			}

			if (var3 != 0) {
				var8.shadow(var3);
			}

			Rasterizer3D.method1426(var8.pixels, 36, 32, (float[])null);
			if (var9.noteTemplate != -1) {
				var23.drawTransBgAt(0, 0);
			}

			if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
				Font var20 = TaskHandler.ItemDefinition_fontPlain11;
				String var21;
				if (var1 < 100000) {
					var21 = "<col=ffff00>" + var1 + "</col>";
				} else if (var1 < 10000000) {
					var21 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
				} else {
					var21 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
				}

				var20.draw(var21, 0, 9, 16776960, 1);
			}

			if (!var5) {
				ItemComposition.ItemDefinition_cachedSprites.put(var8, var6);
			}

			Rasterizer3D.method1426(var12, var13, var14, var15);
			Rasterizer2D.Rasterizer2D_setClipArray(var16);
			Rasterizer3D.method1427();
			Rasterizer3D.clips.field2457 = true;
			return var8;
		}
	}
}