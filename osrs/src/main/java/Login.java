import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.text.DecimalFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("cy")
@Implements("Login")
public class Login {
	@ObfuscatedName("ar")
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	static IndexedSprite field776;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Luz;"
	)
	@Export("rightTitleSprite")
	static SpritePixels rightTitleSprite;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	static IndexedSprite field779;
	@ObfuscatedName("ae")
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("an")
	@Export("userHomeDirectory")
	static String userHomeDirectory;
	@ObfuscatedName("ag")
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("ad")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("bc")
	static int field751;
	@ObfuscatedName("bb")
	static int field750;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "Lrv;"
	)
	static Bounds field775;
	@ObfuscatedName("cf")
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("cg")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("cv")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("cx")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("cp")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("ce")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ci")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("cw")
	static int field753;
	@ObfuscatedName("cq")
	static String[] field769;
	@ObfuscatedName("cn")
	static String field763;
	@ObfuscatedName("cb")
	static boolean field743;
	@ObfuscatedName("cz")
	static boolean field745;
	@ObfuscatedName("cd")
	static boolean field744;
	@ObfuscatedName("dt")
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("dx")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("dr")
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("ds")
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("da")
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("dp")
	static long field774;
	@ObfuscatedName("df")
	static long field773;
	@ObfuscatedName("dv")
	static String[] field771;
	@ObfuscatedName("dz")
	static String[] field772;
	@ObfuscatedName("dl")
	static String[] field770;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field751 = -1;
		field750 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field753 = 0;
		field769 = new String[8];
		field763 = "";
		field743 = false;
		field745 = false;
		field744 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class135();
		field774 = -1L;
		field773 = -1L;
		field771 = new String[]{"title.jpg"};
		field772 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
		field770 = new String[]{"logo_speedrunning"};
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;IZI)Lfo;",
		garbageValue = "-1429797359"
	)
	public static class139 method437(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true;
		byte[] var5 = var0.getFile(var2 >> 16 & 65535, var2 & 65535);
		if (var5 == null) {
			var4 = false;
			return null;
		} else {
			int var6 = (var5[1] & 255) << 8 | var5[2] & 255;
			byte[] var7;
			if (var3) {
				var7 = var1.getFile(0, var6);
			} else {
				var7 = var1.getFile(var6, 0);
			}

			if (var7 == null) {
				var4 = false;
			}

			if (!var4) {
				return null;
			} else {
				if (class139.field1309 == null) {
					FloorDecoration.field2162 = Runtime.getRuntime().availableProcessors();
					class139.field1309 = new ThreadPoolExecutor(0, FloorDecoration.field2162, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(FloorDecoration.field2162 * 100 + 100), new class136());
				}

				try {
					return new class139(var0, var1, var2, var3);
				} catch (Exception var9) {
					return null;
				}
			}
		}
	}

	@ObfuscatedName("mr")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "10"
	)
	static final void method438(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		WorldMapIcon_1.clientPreferences.setAreaSoundEffectsVolume(var0);
	}
}