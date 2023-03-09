import java.io.UnsupportedEncodingException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qg")
public class class433 implements class432 {
   @ObfuscatedName("gq")
   static String field3773;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lorg/json/JSONObject;"
   )
   JSONObject field3774;

   public class433(byte[] var1) throws UnsupportedEncodingException {
      this.method2224(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;)V"
   )
   public class433(JSONObject var1) {
      this.field3774 = var1;
   }

   public class433(String var1) throws UnsupportedEncodingException {
      this.method2225(var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)Lqn;",
      garbageValue = "1"
   )
   public class431 vmethod2213() {
      return class431.field3770;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)[B",
      garbageValue = "66"
   )
   @Export("vmethod7797")
   public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.field3774 == null ? new byte[0] : this.field3774.toString().getBytes("UTF-8");
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "([BB)V",
      garbageValue = "18"
   )
   void method2224(byte[] var1) throws UnsupportedEncodingException {
      String var2 = new String(var1, "UTF-8");
      this.method2225(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;S)V",
      garbageValue = "11699"
   )
   void method2225(String var1) throws UnsupportedEncodingException {
      try {
         if (var1.charAt(0) == '{') {
            this.field3774 = new JSONObject(var1);
         } else {
            if (var1.charAt(0) != '[') {
               throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
            }

            JSONArray var2 = new JSONArray(var1);
            this.field3774 = new JSONObject();
            this.field3774.method2575("arrayValues", var2);
         }

      } catch (JSONException var3) {
         throw new UnsupportedEncodingException(var3.getMessage());
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONObject;",
      garbageValue = "214188933"
   )
   public JSONObject method2226() {
      return this.field3774;
   }
}
