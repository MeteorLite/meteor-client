import java.awt.Component;
import java.util.Date;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("NewShit")
public class NewShit {
   @ObfuscatedName("f")
   public long field1547;
   @ObfuscatedName("w")
   int[] field1544;
   @ObfuscatedName("v")
   short[] field1545;
   @ObfuscatedName("s")
   short[] field1546;

   public NewShit(long var1, int[] var3, short[] var4, short[] var5) {
      this.field1547 = var1;
      this.field1544 = var3;
      this.field1545 = var4;
      this.field1546 = var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/Component;B)V",
      garbageValue = "-2"
   )
   static void method953(Component var0) {
      var0.removeMouseListener(MouseHandler.MouseHandler_instance);
      var0.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
      var0.removeFocusListener(MouseHandler.MouseHandler_instance);
      MouseHandler.MouseHandler_currentButtonVolatile = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)Lra;",
      garbageValue = "25"
   )
   public static PrivateChatMode method955(int var0) {
      PrivateChatMode[] var1 = class33.method134();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         PrivateChatMode var3 = var1[var2];
         if (var0 == var3.id) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-2040479563"
   )
   public static boolean method952(int var0) {
      return (var0 >> 22 & 1) != 0;
   }

   @ObfuscatedName("lv")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-2132622819"
   )
   static void method954(String var0) {
      GraphicsDefaults.param9 = var0;

      try {
         String var1 = Decimator.client.getParameter(Integer.toString(18));
         String var2 = Decimator.client.getParameter(Integer.toString(13));
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if (var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class153.clockNow() + 94608000000L;
            Calendar.Calendar_calendar.setTime(new Date(var6));
            int var8 = Calendar.Calendar_calendar.get(7);
            int var9 = Calendar.Calendar_calendar.get(5);
            int var10 = Calendar.Calendar_calendar.get(2);
            int var11 = Calendar.Calendar_calendar.get(1);
            int var12 = Calendar.Calendar_calendar.get(11);
            int var13 = Calendar.Calendar_calendar.get(12);
            int var14 = Calendar.Calendar_calendar.get(13);
            String var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         class26.method96(Decimator.client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var15) {
         ;
      }

   }
}
