import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public class class304 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ldg;"
   )
   UrlRequest field2801;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lrs;"
   )
   SpritePixels field2800;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ldi;)V"
   )
   class304(String var1, UrlRequester var2) {
      try {
         this.field2801 = var2.request(new URL(var1));
      } catch (MalformedURLException var4) {
         this.field2801 = null;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Ldg;)V"
   )
   class304(UrlRequest var1) {
      this.field2801 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "1593287997"
   )
   SpritePixels method1630() {
      if (this.field2800 == null && this.field2801 != null && this.field2801.isDone()) {
         if (this.field2801.getResponse() != null) {
            this.field2800 = class266.method1505(this.field2801.getResponse());
         }

         this.field2801 = null;
      }

      return this.field2800;
   }
}
