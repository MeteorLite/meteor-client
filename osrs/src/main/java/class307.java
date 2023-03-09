import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
public class class307 {
   @ObfuscatedName("uy")
   static int field2776;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Leo;"
   )
   UrlRequest field2775;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lsn;"
   )
   SpritePixels field2774;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Leb;)V"
   )
   class307(String var1, UrlRequester var2) {
      try {
         this.field2775 = var2.request(new URL(var1));
      } catch (MalformedURLException var4) {
         this.field2775 = null;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Leo;)V"
   )
   class307(UrlRequest var1) {
      this.field2775 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Lsn;",
      garbageValue = "-923586250"
   )
   SpritePixels method1639() {
      if (this.field2774 == null && this.field2775 != null && this.field2775.isDone()) {
         if (this.field2775.getResponse() != null) {
            this.field2774 = class139.method748(this.field2775.getResponse());
         }

         this.field2775 = null;
      }

      return this.field2774;
   }
}
