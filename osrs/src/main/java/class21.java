import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class21 {
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive field63;
   @ObfuscatedName("ov")
   @Export("selectedSpellFlags")
   static int selectedSpellFlags;
   @ObfuscatedName("h")
   final int field61;
   @ObfuscatedName("e")
   final String field62;

   class21(String var1) {
      this.field61 = 400;
      this.field62 = "";
   }

   class21(HttpURLConnection var1) throws IOException {
      this.field61 = var1.getResponseCode();
      var1.getResponseMessage();
      var1.getHeaderFields();
      StringBuilder var2 = new StringBuilder();
      InputStream var3 = this.field61 >= 300 ? var1.getErrorStream() : var1.getInputStream();
      if (var3 != null) {
         InputStreamReader var4 = new InputStreamReader(var3);
         BufferedReader var5 = new BufferedReader(var4);

         String var6;
         while((var6 = var5.readLine()) != null) {
            var2.append(var6);
         }

         var3.close();
      }

      this.field62 = var2.toString();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1934403737"
   )
   public int method74() {
      return this.field61;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-309548900"
   )
   public String method75() {
      return this.field62;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)Lgh;",
      garbageValue = "96"
   )
   public static FloorUnderlayDefinition method76(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = class283.FloorUnderlayDefinition_archive.takeFile(1, var0);
         var1 = new FloorUnderlayDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.postDecode();
         FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
