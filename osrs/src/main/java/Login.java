import java.text.DecimalFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("Login")
public class Login {
    @ObfuscatedName("w")
    static boolean clearLoginScreen;
    @ObfuscatedName("v")
    static int xPadding = 0;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] runesSprite;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite titlebuttonSprite;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "Lrs;"
    )
    static SpritePixels leftTitleSprite;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] title_muteSprite;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite options_buttons_0Sprite;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite options_buttons_2Sprite;
    @ObfuscatedName("q")
    static int loginBoxX;
    @ObfuscatedName("e")
    static int Login_loadingPercent;
    @ObfuscatedName("g")
    static String Login_loadingText;
   @ObfuscatedName("ae")
   static int field751;
   @ObfuscatedName("ab")
   static int field752;
    @ObfuscatedName("ao")
    static int loginIndex;
    @ObfuscatedName("bj")
    static String Login_response0;
    @ObfuscatedName("bf")
    static String Login_response1;
    @ObfuscatedName("bz")
    static String Login_response2;
    @ObfuscatedName("br")
    static String Login_response3;
    @ObfuscatedName("bm")
    static String Login_username;
    @ObfuscatedName("be")
    static String Login_password;
   @ObfuscatedName("bl")
   static int field760;
   @ObfuscatedName("bq")
   static String[] field761;
   @ObfuscatedName("bd")
   static String field762;
   @ObfuscatedName("bp")
   static boolean field772;
   @ObfuscatedName("bc")
   static boolean field768;
   @ObfuscatedName("bx")
   static boolean field764;
    @ObfuscatedName("bv")
    static int currentLoginField;
    @ObfuscatedName("cp")
    static boolean worldSelectOpen;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      descriptor = "Lrg;"
   )
   static IndexedSprite field769;
    @ObfuscatedName("ct")
    static int hoveredWorldIndex;
    @ObfuscatedName("cb")
    static int worldSelectPage;
    @ObfuscatedName("cz")
    static int worldSelectPagesCount;
   @ObfuscatedName("cy")
   static long field756;
   @ObfuscatedName("cv")
   static long field740;
   @ObfuscatedName("cf")
   static String[] field774;
   @ObfuscatedName("cm")
   static String[] field775;
   @ObfuscatedName("ce")
   static String[] field738;

   static {
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field751 = -1;
      field752 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field760 = 0;
      field761 = new String[8];
      field762 = "";
      field772 = false;
      field768 = false;
      field764 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class129();
      field756 = -1L;
      field740 = -1L;
      field774 = new String[]{"title.jpg"};
      field775 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
      field738 = new String[]{"logo_speedrunning"};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;IZB)Lei;",
      garbageValue = "-125"
   )
   public static class133 method425(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
      boolean var4 = true;
      byte[] var5 = var0.getFile(var2 >> 16 & '\uffff', var2 & '\uffff');
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
            if (class277.field2428 == null) {
               class461.field3977 = Runtime.getRuntime().availableProcessors();
               class277.field2428 = new ThreadPoolExecutor(0, class461.field3977, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(class461.field3977 * 100 + 100), new class130());
            }

            try {
               return new class133(var0, var1, var2, var3);
            } catch (Exception var9) {
               return null;
            }
         }
      }
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lru;B)V",
            garbageValue = "-76"
    )
    static final void updatePlayer(PacketBuffer var0) {
      var0.importIndex();
      int var1 = Client.localPlayerIndex;
      Player var2 = class387.localPlayer = Client.players[var1] = new Player();
      var2.index = var1;
      int var3 = var0.readBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - ParamComposition.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
      var2.pathY[0] = var6 - Client.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
      class103.Client_plane = var2.plane = var4;
      if (Players.cachedAppearanceBuffer[var1] != null) {
         var2.read(Players.cachedAppearanceBuffer[var1]);
      }

      Players.Players_count = 0;
      Players.Players_indices[++Players.Players_count - 1] = var1;
      Players.activityFlags[var1] = 0;
      Players.Players_emptyIdxCount = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if (var7 != var1) {
            int var8 = var0.readBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            Players.Players_orientations[var7] = 0;
            Players.Players_targetIndices[var7] = -1;
            Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
            Players.activityFlags[var7] = 0;
         }
      }

      var0.exportIndex();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;B)V",
      garbageValue = "102"
   )
   public static void method426(AbstractArchive var0, AbstractArchive var1) {
      class303.HealthBarDefinition_archive = var0;
      HealthBarDefinition.field1520 = var1;
   }
}
