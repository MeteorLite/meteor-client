import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("Login")
public class Login {
	@ObfuscatedName("p")
	@Export("clearLoginScreen")
	static boolean clearLoginScreen;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2144632883
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1406320157
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -636835861
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("z")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1963717405
	)
	static int field902;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 382138665
	)
	static int field903;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 426058389
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("bg")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("bw")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("bc")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("bv")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("bi")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("bj")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -1882733041
	)
	static int field891;
	@ObfuscatedName("bo")
	static String[] field907;
	@ObfuscatedName("bt")
	static boolean field925;
	@ObfuscatedName("bb")
	static boolean field920;
	@ObfuscatedName("bq")
	static boolean field916;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = 793941749
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("cf")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = 1809316571
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -2076400999
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = 1399484843
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		longValue = -3144092253317418407L
	)
	static long field924;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		longValue = 9220212022270271691L
	)
	static long field918;
	@ObfuscatedName("cq")
	static String[] field896;
	@ObfuscatedName("cp")
	static String[] field927;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field902 = -1;
		field903 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field891 = 0;
		field907 = new String[8];
		field925 = false;
		field920 = false;
		field916 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class121();
		field924 = -1L;
		field918 = -1L;
		field896 = new String[]{"title.jpg"};
		field927 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "logo_speedrunning", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I[BLnj;B)V",
		garbageValue = "126"
	)
	static void method2041(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field4018 == 0) {
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field4018 = 600;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1755574868"
	)
	public static boolean method2084(int var0) {
		return (var0 >> 30 & 1) != 0;
	}
}
