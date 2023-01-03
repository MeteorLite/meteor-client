import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("Login")
public class Login {
   @ObfuscatedName("e")
   @Export("clearLoginScreen")
   static boolean clearLoginScreen;
   @ObfuscatedName("v")
   @Export("xPadding")
   static int xPadding = 0;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "[Lra;"
   )
   @Export("runesSprite")
   static IndexedSprite[] runesSprite;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static IndexedSprite field757;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static IndexedSprite field735;
   @ObfuscatedName("p")
   @Export("loginBoxX")
   static int loginBoxX;
   @ObfuscatedName("y")
   @Export("Login_loadingPercent")
   static int Login_loadingPercent;
   @ObfuscatedName("z")
   @Export("Login_loadingText")
   static String Login_loadingText;
   @ObfuscatedName("ah")
   static int field732;
   @ObfuscatedName("aq")
   static int field736;
   @ObfuscatedName("ap")
   static String field737;
   @ObfuscatedName("ac")
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("bh")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("be")
   @Export("Login_response1")
   static String Login_response1;
   @ObfuscatedName("bf")
   @Export("Login_response2")
   static String Login_response2;
   @ObfuscatedName("bo")
   @Export("Login_response3")
   static String Login_response3;
   @ObfuscatedName("by")
   @Export("Login_username")
   static String Login_username;
   @ObfuscatedName("bw")
   @Export("Login_password")
   static String Login_password;
   @ObfuscatedName("bc")
   static int field746;
   @ObfuscatedName("bl")
   static String[] field727;
   @ObfuscatedName("bt")
   static boolean field747;
   @ObfuscatedName("bu")
   static boolean field762;
   @ObfuscatedName("bm")
   static boolean field738;
   @ObfuscatedName("bk")
   @Export("currentLoginField")
   static int currentLoginField;
   @ObfuscatedName("cq")
   @Export("worldSelectOpen")
   static boolean worldSelectOpen;
   @ObfuscatedName("cj")
   @Export("hoveredWorldIndex")
   static int hoveredWorldIndex;
   @ObfuscatedName("cn")
   @Export("worldSelectPage")
   static int worldSelectPage;
   @ObfuscatedName("cm")
   @Export("worldSelectPagesCount")
   static int worldSelectPagesCount;
   @ObfuscatedName("cu")
   static long field745;
   @ObfuscatedName("co")
   static long field758;
   @ObfuscatedName("ch")
   static String[] field742;
   @ObfuscatedName("ce")
   static String[] field740;
   @ObfuscatedName("cg")
   static String[] field760;

   static {
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field732 = -1;
      field736 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field746 = 0;
      field727 = new String[8];
      field747 = false;
      field762 = false;
      field738 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class128();
      field745 = -1L;
      field758 = -1L;
      field742 = new String[]{"title.jpg"};
      field740 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
      field760 = new String[]{"logo_speedrunning"};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1089740356"
   )
   public static void method432(int var0, int var1) {
      VarbitComposition var3 = (VarbitComposition)VarbitComposition.VarbitDefinition_cached.get((long)var0);
      VarbitComposition var2;
      if (var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = VarbitComposition.VarbitDefinition_archive.takeFile(14, var0);
         var3 = new VarbitComposition();
         if (var4 != null) {
            var3.decode(new Buffer(var4));
         }

         VarbitComposition.VarbitDefinition_cached.put(var3, (long)var0);
         var2 = var3;
      }

      int var8 = var2.baseVar;
      int var5 = var2.startBit;
      int var6 = var2.endBit;
      int var7 = Varps.Varps_masks[var6 - var5];
      if (var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      Varps.Varps_main[var8] = Varps.Varps_main[var8] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(II)Lew;",
      garbageValue = "-1889979389"
   )
   public static class130 method434(int var0) {
      class130 var1 = (class130)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         AbstractArchive var3 = SequenceDefinition.SequenceDefinition_animationsArchive;
         AbstractArchive var4 = BuddyRankComparator.SequenceDefinition_skeletonsArchive;
         boolean var5 = true;
         byte[] var6 = var3.getFile(var0 >> 16 & '\uffff', var0 & '\uffff');
         class130 var2;
         if (var6 == null) {
            var5 = false;
            var2 = null;
         } else {
            int var7 = (var6[1] & 255) << 8 | var6[2] & 255;
            byte[] var8 = var4.getFile(var7, 0);
            if (var8 == null) {
               var5 = false;
            }

            if (!var5) {
               var2 = null;
            } else {
               try {
                  var2 = new class130(var3, var4, var0, false);
               } catch (Exception var10) {
                  var2 = null;
               }
            }
         }

         if (var2 != null) {
            SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;Ljava/lang/String;I)[F",
      garbageValue = "615126819"
   )
   static float[] method433(JSONObject var0, String var1) throws JSONException {
      float[] var2 = new float[4];

      try {
         JSONArray var3 = var0.getJSONArray(var1);
         var2[0] = (float)var3.optDouble(0, 0.0D);
         var2[1] = (float)var3.optDouble(1, 0.0D);
         var2[2] = (float)var3.optDouble(2, 1.0D);
         var2[3] = (float)var3.optDouble(3, 1.0D);
      } catch (JSONException var4) {
         var2[0] = 0.0F;
         var2[1] = 0.0F;
         var2[2] = 1.0F;
         var2[3] = 1.0F;
      }

      return var2;
   }
}
