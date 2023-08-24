import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.text.DecimalFormat;
import java.util.ArrayList;

@ObfuscatedName("cy")
@Implements("Login")
public class Login {
	@ObfuscatedName("ao")
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Luk;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	static IndexedSprite field777;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	@Export("leftTitleSprite")
	static SpritePixels leftTitleSprite;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("ay")
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("av")
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("aw")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("bi")
	static int field750;
	@ObfuscatedName("bn")
	static int field751;
	@ObfuscatedName("cw")
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("cf")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("cm")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("cn")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("cs")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("cx")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("cr")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ce")
	static int field752;
	@ObfuscatedName("cq")
	static String[] field768;
	@ObfuscatedName("cu")
	static String field764;
	@ObfuscatedName("cz")
	static boolean field745;
	@ObfuscatedName("ct")
	static boolean field744;
	@ObfuscatedName("cc")
	static boolean field743;
	@ObfuscatedName("dh")
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("dn")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("dk")
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("df")
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("dz")
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("dv")
	static long field773;
	@ObfuscatedName("dr")
	static long field772;
	@ObfuscatedName("do")
	static String[] field770;
	@ObfuscatedName("db")
	static String[] field769;
	@ObfuscatedName("dp")
	static String[] field771;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field750 = -1;
		field751 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field752 = 0;
		field768 = new String[8];
		field764 = "";
		field745 = false;
		field744 = false;
		field743 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class133();
		field773 = -1L;
		field772 = -1L;
		field770 = new String[]{"title.jpg"};
		field769 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
		field771 = new String[]{"logo_speedrunning"};
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Lro;",
		garbageValue = "1233302527"
	)
	public static class449 method427() {
		synchronized(class449.field3868) {
			if (class338.field3112 == 0) {
				return new class449();
			} else {
				class449.field3868[--class338.field3112].method2296();
				return class449.field3868[class338.field3112];
			}
		}
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1609122082"
	)
	@Export("playJingle")
	static void playJingle(int var0, int var1) {
		if (class449.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
			ArrayList var2 = new ArrayList();
			var2.add(new MusicSong(class388.field3655, var0, 0, class449.clientPreferences.getCurrentMusicVolume(), false));
			class53.method291(var2, 0, 0, 0, 0, true);
			Client.playingJingle = true;
		}

	}

	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		descriptor = "([Lmi;Lmi;ZI)V",
		garbageValue = "1287151342"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * -1561222175 * -568991711 : var1.width * 501302871 * 2076902759;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * 917378589 * 1251957813 : var1.height * -556278153 * 1553685319;
		PcmPlayer.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			PcmPlayer.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			int var6 = var5.group;
			if (ModeWhere.loadInterface(var6)) {
				PcmPlayer.resizeInterface(PacketBufferNode.Widget_interfaceComponents[var6], -1, var3, var4, var2);
			}
		}

		if (var1.contentType == 1337) {
		}

	}
}