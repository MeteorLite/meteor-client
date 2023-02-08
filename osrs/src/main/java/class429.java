import java.io.UnsupportedEncodingException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ps")
public class class429 implements class428 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lorg/json/JSONObject;"
   )
   JSONObject field3809;

   public class429(byte[] var1) throws UnsupportedEncodingException {
      this.method2212(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;)V"
   )
   public class429(JSONObject var1) {
      this.field3809 = var1;
   }

   public class429(String var1) throws UnsupportedEncodingException {
      this.method2208(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)Lpf;",
      garbageValue = "1"
   )
   public class427 vmethod2213() {
      return class427.field3808;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(B)[B",
            garbageValue = "1"
    )
    public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.field3809 == null ? new byte[0] : this.field3809.toString().getBytes("UTF-8");
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "([BB)V",
      garbageValue = "-106"
   )
   void method2212(byte[] var1) throws UnsupportedEncodingException {
      String var2 = new String(var1, "UTF-8");
      this.method2208(var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-893487137"
   )
   void method2208(String var1) throws UnsupportedEncodingException {
      try {
         if (var1.charAt(0) == '{') {
            this.field3809 = new JSONObject(var1);
         } else {
            if (var1.charAt(0) != '[') {
               throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
            }

            JSONArray var2 = new JSONArray(var1);
            this.field3809 = new JSONObject();
            this.field3809.method2546("arrayValues", var2);
         }

      } catch (JSONException var3) {
         throw new UnsupportedEncodingException(var3.getMessage());
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(B)Lorg/json/JSONObject;",
      garbageValue = "-128"
   )
   public JSONObject method2209() {
      return this.field3809;
   }
}
