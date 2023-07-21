import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Login")
public class Login {
	@ObfuscatedName("ay")
	@Export("clearLoginScreen")
	static boolean clearLoginScreen;
	@ObfuscatedName("ar")
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Luu;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	static IndexedSprite field773;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("ak")
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("af")
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("ai")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("bh")
	static int field746;
	@ObfuscatedName("bt")
	static int field747;
	@ObfuscatedName("ct")
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("cf")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("cz")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("cb")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("cs")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("cj")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("cn")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ce")
	static int field748;
	@ObfuscatedName("cq")
	static String[] field767;
	@ObfuscatedName("cu")
	static String field761;
	@ObfuscatedName("ch")
	static boolean field741;
	@ObfuscatedName("cg")
	static boolean field740;
	@ObfuscatedName("cv")
	@Export("otp")
	static String otp;
	@ObfuscatedName("cc")
	static boolean field739;
	@ObfuscatedName("dc")
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("dy")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("dt")
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("df")
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("dm")
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("dz")
	static long field772;
	@ObfuscatedName("dx")
	static long field771;
	@ObfuscatedName("dp")
	static String[] field769;
	@ObfuscatedName("ds")
	static String[] field770;
	@ObfuscatedName("da")
	static String[] field768;
	@ObfuscatedName("gt")
	@Export("worldPort")
	static int worldPort;
	@ObfuscatedName("gn")
	static String field766;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field746 = -1;
		field747 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field748 = 0;
		field767 = new String[8];
		field761 = "";
		field741 = false;
		field740 = false;
		field739 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class133();
		field772 = -1L;
		field771 = -1L;
		field769 = new String[]{"title.jpg"};
		field770 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
		field768 = new String[]{"logo_speedrunning"};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "288446910"
	)
	@Export("loadInterface")
	public static boolean loadInterface(int var0) {
		if (Widget.Widget_loadedInterfaces[var0]) {
			return true;
		} else if (!ArchiveLoader.Widget_archive.tryLoadGroup(var0)) {
			return false;
		} else {
			int var1 = ArchiveLoader.Widget_archive.getGroupFileCount(var0);
			if (var1 == 0) {
				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			} else {
				if (ArchiveLoader.Widget_interfaceComponents[var0] == null) {
					ArchiveLoader.Widget_interfaceComponents[var0] = new Widget[var1];
				}

				for (int var2 = 0; var2 < var1; ++var2) {
					if (ArchiveLoader.Widget_interfaceComponents[var0][var2] == null) {
						byte[] var3 = ArchiveLoader.Widget_archive.takeFile(var0, var2);
						if (var3 != null) {
							ArchiveLoader.Widget_interfaceComponents[var0][var2] = new Widget();
							ArchiveLoader.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
							if (var3[0] == -1) {
								ArchiveLoader.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								ArchiveLoader.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3));
							}
						}
					}
				}

				Widget.Widget_loadedInterfaces[var0] = true;
				return true;
			}
		}
	}
}
