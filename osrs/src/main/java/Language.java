import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mb")
@Implements("Language")
public class Language implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   @Export("Language_EN")
   public static final Language Language_EN;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   static final Language field3524;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   @Export("Language_FR")
   public static final Language Language_FR;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   static final Language field3518;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   static final Language field3519;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   @Export("Language_ES")
   public static final Language Language_ES;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lmb;"
   )
   static final Language field3516;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "[Lmb;"
   )
   public static final Language[] field3526;
   @ObfuscatedName("d")
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("ad")
   @Export("Widget_loadedInterfaces")
   static boolean[] Widget_loadedInterfaces;
   @ObfuscatedName("r")
   final String field3522;
   @ObfuscatedName("u")
   @Export("language")
   final String language;
   @ObfuscatedName("b")
   @Export("id")
   final int id;

   static {
      Language_EN = new Language("EN", "en", "English", ModeWhere.field3545, 0, "GB");
      field3524 = new Language("DE", "de", "German", ModeWhere.field3545, 1, "DE");
      Language_FR = new Language("FR", "fr", "French", ModeWhere.field3545, 2, "FR");
      field3518 = new Language("PT", "pt", "Portuguese", ModeWhere.field3545, 3, "BR");
      field3519 = new Language("NL", "nl", "Dutch", ModeWhere.field3529, 4, "NL");
      Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3529, 5, "ES");
      field3516 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3545, 6, "MX");
      Language[] var0 = new Language[]{field3524, Language_ES, Language_FR, field3519, field3516, field3518, Language_EN};
      field3526 = new Language[var0.length];
      Language[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Language var4 = var2[var3];
         field3526[var4.id] = var4;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmr;ILjava/lang/String;)V"
   )
   Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
      this.field3522 = var1;
      this.language = var2;
      this.id = var5;
      if (var6 != null) {
         new Locale(var2.substring(0, 2), var6);
      } else {
         new Locale(var2.substring(0, 2));
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   @Export("getLanguage")
   String getLanguage() {
      return this.language;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.getLanguage().toLowerCase(Locale.ENGLISH);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([BB)Lrx;",
      garbageValue = "0"
   )
   public static final SpritePixels method1865(byte[] var0) {
      BufferedImage var1 = null;

      try {
         Class var2 = ImageIO.class;
         synchronized(ImageIO.class) {
            var1 = ImageIO.read(new ByteArrayInputStream(var0));
         }

         int var6 = var1.getWidth();
         int var7 = var1.getHeight();
         int[] var4 = new int[var6 * var7];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6);
         var5.grabPixels();
         return new SpritePixels(var4, var6, var7);
      } catch (IOException var9) {
         ;
      } catch (InterruptedException var10) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-669760622"
   )
   static void method1866() {
      Players.Players_count = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         Players.field1087[var0] = null;
         Players.field1094[var0] = MoveSpeed.WALK;
      }

   }
}
