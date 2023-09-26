import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.text.DecimalFormat;

@ObfuscatedName("ca")
@Implements("Login")
public class Login {
	@ObfuscatedName("al")
	@Export("clearLoginScreen")
	static boolean clearLoginScreen;
	@ObfuscatedName("ak")
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "[Lun;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	static IndexedSprite field775;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("rightTitleSprite")
	static SpritePixels rightTitleSprite;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "[Lun;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("aq")
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("at")
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("af")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("bl")
	static int field748;
	@ObfuscatedName("bx")
	static int field749;
	@ObfuscatedName("ce")
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("cu")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("cw")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("co")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("cc")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("cg")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("cq")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("cz")
	static int field751;
	@ObfuscatedName("cp")
	static String[] field766;
	@ObfuscatedName("cs")
	static String field761;
	@ObfuscatedName("cd")
	static boolean field742;
	@ObfuscatedName("ct")
	static boolean field743;
	@ObfuscatedName("ca")
	static boolean field741;
	@ObfuscatedName("dv")
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("dg")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("dp")
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("do")
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("dh")
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("du")
	static long field771;
	@ObfuscatedName("dr")
	static long field770;
	@ObfuscatedName("dw")
	static String[] field769;
	@ObfuscatedName("di")
	static String[] field767;
	@ObfuscatedName("dt")
	static String[] field768;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field748 = -1;
		field749 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field751 = 0;
		field766 = new String[8];
		field761 = "";
		field742 = false;
		field743 = false;
		field741 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class135();
		field771 = -1L;
		field770 = -1L;
		field769 = new String[]{"title.jpg"};
		field767 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
		field768 = new String[]{"logo_speedrunning"};
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "85678974"
	)
	static final int method433(int var0, int var1) {
		int var2 = ClientPreferences.method568(var0 - 1, var1 - 1) + ClientPreferences.method568(var0 + 1, var1 - 1) + ClientPreferences.method568(var0 - 1, var1 + 1) + ClientPreferences.method568(var0 + 1, var1 + 1);
		int var3 = ClientPreferences.method568(var0 - 1, var1) + ClientPreferences.method568(var0 + 1, var1) + ClientPreferences.method568(var0, var1 - 1) + ClientPreferences.method568(var0, 1 + var1);
		int var4 = ClientPreferences.method568(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}
}