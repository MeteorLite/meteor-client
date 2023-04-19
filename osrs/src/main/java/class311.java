import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
public class class311 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lez;"
   )
   UrlRequest field2819;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ltq;"
   )
   SpritePixels field2820;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Let;)V"
   )
   class311(String var1, UrlRequester var2) {
      try {
         this.field2819 = var2.request(new URL(var1));
      } catch (MalformedURLException var4) {
         this.field2819 = null;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Lez;)V"
   )
   class311(UrlRequest var1) {
      this.field2819 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)Ltq;",
      garbageValue = "26"
   )
   SpritePixels method1690() {
      if (this.field2820 == null && this.field2819 != null && this.field2819.isDone()) {
         if (this.field2819.getResponse() != null) {
            this.field2820 = Strings.method1853(this.field2819.getResponse());
         }

         this.field2819 = null;
      }

      return this.field2820;
   }
}
