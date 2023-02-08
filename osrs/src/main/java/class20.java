import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class20 {
    @ObfuscatedName("i")
    public static int musicTrackGroupId;
    @ObfuscatedName("c")
    static int Interpreter_stringStackSize;
   @ObfuscatedName("t")
   static int field69;
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "Ljd;"
    )
    static WorldMapEvent worldMapEvent;
   @ObfuscatedName("f")
   final int field71;
   @ObfuscatedName("w")
   final Map field72;
   @ObfuscatedName("v")
   final String field68;

   class20(String var1) {
      this.field71 = 400;
      this.field72 = null;
      this.field68 = "";
   }

   class20(HttpURLConnection var1) throws IOException {
      this.field71 = var1.getResponseCode();
      var1.getResponseMessage();
      this.field72 = var1.getHeaderFields();
      StringBuilder var2 = new StringBuilder();
      InputStream var3 = this.field71 >= 300 ? var1.getErrorStream() : var1.getInputStream();
      if (var3 != null) {
         InputStreamReader var4 = new InputStreamReader(var3);
         BufferedReader var5 = new BufferedReader(var4);

         String var6;
         while((var6 = var5.readLine()) != null) {
            var2.append(var6);
         }

         var3.close();
      }

      this.field68 = var2.toString();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "1"
   )
   public int method76() {
      return this.field71;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/Map;",
      garbageValue = "63"
   )
   public Map method74() {
      return this.field72;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-5"
   )
   public String method75() {
      return this.field68;
   }
}
