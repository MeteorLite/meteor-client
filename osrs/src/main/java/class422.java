import java.applet.Applet;
import java.io.UnsupportedEncodingException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pf")
public class class422 implements class421 {
   @ObfuscatedName("h")
   @Export("RunException_applet")
   public static Applet RunException_applet;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   @Export("Widget_archive")
   static AbstractArchive Widget_archive;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lorg/json/JSONObject;"
   )
   JSONObject field3797;

   public class422(byte[] var1) throws UnsupportedEncodingException {
      this.method2175(var1);
   }

   public class422(String var1) throws UnsupportedEncodingException {
      this.method2172(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)[B",
      garbageValue = "0"
   )
   @Export("vmethod7797")
   public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.field3797 == null ? new byte[0] : this.field3797.toString().getBytes("UTF-8");
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "([BI)V",
      garbageValue = "1750252743"
   )
   void method2175(byte[] var1) throws UnsupportedEncodingException {
      String var2 = new String(var1, "UTF-8");
      this.method2172(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1308508243"
   )
   void method2172(String var1) throws UnsupportedEncodingException {
      try {
         if (var1.charAt(0) == '{') {
            this.field3797 = new JSONObject(var1);
         } else {
            if (var1.charAt(0) != '[') {
               throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
            }

            JSONArray var2 = new JSONArray(var1);
            this.field3797 = new JSONObject();
            this.field3797.method2507("arrayValues", var2);
         }

      } catch (JSONException var3) {
         throw new UnsupportedEncodingException(var3.getMessage());
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONObject;",
      garbageValue = "1299055961"
   )
   public JSONObject method2173() {
      return this.field3797;
   }
}
