import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Login")
public class Login {
   @ObfuscatedName("al")
   @Export("clearLoginScreen")
   static boolean clearLoginScreen;
   @ObfuscatedName("ac")
   @Export("xPadding")
   static int xPadding = 0;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "[Lsp;"
   )
   @Export("runesSprite")
   static IndexedSprite[] runesSprite;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   @Export("titlebuttonSprite")
   static IndexedSprite titlebuttonSprite;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lsn;"
   )
   @Export("leftTitleSprite")
   static SpritePixels leftTitleSprite;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   @Export("options_buttons_0Sprite")
   static IndexedSprite options_buttons_0Sprite;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   @Export("options_buttons_2Sprite")
   static IndexedSprite options_buttons_2Sprite;
   @ObfuscatedName("ai")
   @Export("loginBoxX")
   static int loginBoxX;
   @ObfuscatedName("aw")
   @Export("loginBoxCenter")
   static int loginBoxCenter;
   @ObfuscatedName("aa")
   @Export("Login_loadingPercent")
   static int Login_loadingPercent;
   @ObfuscatedName("ah")
   @Export("Login_loadingText")
   static String Login_loadingText;
   @ObfuscatedName("bp")
   static int field738;
   @ObfuscatedName("bn")
   static int field725;
   @ObfuscatedName("bi")
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("cl")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ca")
   @Export("Login_response1")
   static String Login_response1;
   @ObfuscatedName("cb")
   @Export("Login_response2")
   static String Login_response2;
   @ObfuscatedName("co")
   @Export("Login_response3")
   static String Login_response3;
   @ObfuscatedName("cj")
   @Export("Login_username")
   static String Login_username;
   @ObfuscatedName("cn")
   @Export("Login_password")
   static String Login_password;
   @ObfuscatedName("cd")
   static int field746;
   @ObfuscatedName("cc")
   static String[] field745;
   @ObfuscatedName("cg")
   static String field747;
   @ObfuscatedName("cw")
   static boolean field737;
   @ObfuscatedName("cp")
   static boolean field749;
   @ObfuscatedName("cv")
   static boolean field750;
   @ObfuscatedName("cr")
   @Export("currentLoginField")
   static int currentLoginField;
   @ObfuscatedName("dp")
   @Export("worldSelectOpen")
   static boolean worldSelectOpen;
   @ObfuscatedName("dh")
   @Export("hoveredWorldIndex")
   static int hoveredWorldIndex;
   @ObfuscatedName("dj")
   @Export("worldSelectPage")
   static int worldSelectPage;
   @ObfuscatedName("da")
   @Export("worldSelectPagesCount")
   static int worldSelectPagesCount;
   @ObfuscatedName("dw")
   static long field757;
   @ObfuscatedName("dt")
   static long field758;
   @ObfuscatedName("db")
   static String[] field759;
   @ObfuscatedName("dm")
   static String[] field760;
   @ObfuscatedName("dz")
   static String[] field761;
   @ObfuscatedName("np")
   @Export("menuY")
   static int menuY;

   static {
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field738 = -1;
      field725 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field746 = 0;
      field745 = new String[8];
      field747 = "";
      field737 = false;
      field749 = false;
      field750 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class130();
      field757 = -1L;
      field758 = -1L;
      field759 = new String[]{"title.jpg"};
      field760 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"};
      field761 = new String[]{"logo_speedrunning"};
   }

   @ObfuscatedName("aj")
   public static final void method429(long var0) {
      if (var0 > 0L) {
         if (0L == var0 % 10L) {
            class169.method900(var0 - 1L);
            class169.method900(1L);
         } else {
            class169.method900(var0);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "977"
   )
   @Export("hashString")
   public static int hashString(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class18.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "27"
   )
   static int method430(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 3903) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if (var0 == 3904) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
         return 1;
      } else if (var0 == 3905) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
         return 1;
      } else if (var0 == 3906) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if (var0 == 3907) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
         return 1;
      } else if (var0 == 3908) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
         return 1;
      } else {
         int var12;
         if (var0 == 3910) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
            return 1;
         } else if (var0 == 3911) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
            return 1;
         } else if (var0 == 3912) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
            return 1;
         } else if (var0 == 3913) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
            return 1;
         } else {
            boolean var13;
            if (var0 == 3914) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if (Projectile.grandExchangeEvents != null) {
                  Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
               }

               return 1;
            } else if (var0 == 3915) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if (Projectile.grandExchangeEvents != null) {
                  Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
               }

               return 1;
            } else if (var0 == 3916) {
               Interpreter.Interpreter_intStackSize -= 2;
               var13 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == 1;
               boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
               if (Projectile.grandExchangeEvents != null) {
                  Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
                  Projectile.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
               }

               return 1;
            } else if (var0 == 3917) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if (Projectile.grandExchangeEvents != null) {
                  Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
               }

               return 1;
            } else if (var0 == 3918) {
               var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
               if (Projectile.grandExchangeEvents != null) {
                  Projectile.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
               }

               return 1;
            } else if (var0 == 3919) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.grandExchangeEvents == null ? 0 : Projectile.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if (var0 == 3920) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.world;
                  return 1;
               } else if (var0 == 3921) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var11.getOfferName();
                  return 1;
               } else if (var0 == 3922) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
                  return 1;
               } else if (var0 == 3923) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  long var5 = WorldMapSection2.clockNow() - GrandExchangeOfferWorldComparator.field3473 - var11.age;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var10;
                  return 1;
               } else if (var0 == 3924) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if (var0 == 3925) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
                  return 1;
               } else if (var0 == 3926) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)Projectile.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
