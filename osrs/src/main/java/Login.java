import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Login")
public class Login {
   @ObfuscatedName("aw")
   @Export("xPadding")
   static int xPadding = 0;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Ltc;"
   )
   @Export("titleboxSprite")
   static IndexedSprite titleboxSprite;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Ltc;"
   )
   @Export("options_buttons_0Sprite")
   static IndexedSprite options_buttons_0Sprite;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Ltc;"
   )
   static IndexedSprite field733;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Ltc;"
   )
   static IndexedSprite field745;
   @ObfuscatedName("ar")
   static int field763;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lsg;"
   )
   static Buffer field764;
   @ObfuscatedName("ak")
   @Export("loginBoxX")
   static int loginBoxX;
   @ObfuscatedName("ad")
   @Export("Login_loadingPercent")
   static int Login_loadingPercent;
   @ObfuscatedName("ae")
   @Export("Login_loadingText")
   static String Login_loadingText;
   @ObfuscatedName("ba")
   static int field738;
   @ObfuscatedName("bp")
   static int field752;
   @ObfuscatedName("ce")
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ci")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("cs")
   @Export("Login_response1")
   static String Login_response1;
   @ObfuscatedName("cc")
   @Export("Login_response2")
   static String Login_response2;
   @ObfuscatedName("cn")
   @Export("Login_response3")
   static String Login_response3;
   @ObfuscatedName("ca")
   @Export("Login_username")
   static String Login_username;
   @ObfuscatedName("cu")
   @Export("Login_password")
   static String Login_password;
   @ObfuscatedName("cq")
   static int field747;
   @ObfuscatedName("cm")
   static String[] field748;
   @ObfuscatedName("cy")
   static String field749;
   @ObfuscatedName("cj")
   static boolean field730;
   @ObfuscatedName("ch")
   static boolean field740;
   @ObfuscatedName("cd")
   static boolean field751;
   @ObfuscatedName("dm")
   @Export("currentLoginField")
   static int currentLoginField;
   @ObfuscatedName("di")
   @Export("worldSelectOpen")
   static boolean worldSelectOpen;
   @ObfuscatedName("de")
   @Export("hoveredWorldIndex")
   static int hoveredWorldIndex;
   @ObfuscatedName("dh")
   @Export("worldSelectPage")
   static int worldSelectPage;
   @ObfuscatedName("dp")
   @Export("worldSelectPagesCount")
   static int worldSelectPagesCount;
   @ObfuscatedName("db")
   static long field734;
   @ObfuscatedName("df")
   static long field759;
   @ObfuscatedName("dq")
   static String[] field760;
   @ObfuscatedName("dd")
   static String[] field761;
   @ObfuscatedName("dj")
   static String[] field762;

   static {
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field738 = -1;
      field752 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field747 = 0;
      field748 = new String[8];
      field749 = "";
      field730 = false;
      field740 = false;
      field751 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class129();
      field734 = -1L;
      field759 = -1L;
      field760 = new String[]{"title.jpg"};
      field761 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
      field762 = new String[]{"logo_speedrunning"};
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-722826482"
   )
   static void method444(boolean var0) {
      byte var1 = 0;
      if (!class134.method779()) {
         var1 = 12;
      } else if (ScriptFrame.client.method394() || ScriptFrame.client.method370() || ScriptFrame.client.method369()) {
         var1 = 10;
      }

      class129.method763(var1);
      if (var0) {
         Login_username = "";
         Login_password = "";
         class204.field1846 = 0;
         Messages.otp = "";
      }

      WallDecoration.method1385();
      if (Client.Login_isUsernameRemembered && Login_username != null && Login_username.length() > 0) {
         currentLoginField = 1;
      } else {
         currentLoginField = 0;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2141606464"
   )
   static void method446() {
      if (Players.loadWorlds()) {
         worldSelectOpen = true;
         worldSelectPage = 0;
         worldSelectPagesCount = 0;
      }

   }

   @ObfuscatedName("nd")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-681433942"
   )
   @Export("FriendSystem_invalidateIgnoreds")
   static final void FriendSystem_invalidateIgnoreds() {
      class124.method742();
      if (UserComparator5.friendsChat != null) {
         UserComparator5.friendsChat.invalidateIgnoreds();
      }

   }
}
