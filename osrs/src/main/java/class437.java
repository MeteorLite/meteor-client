import java.io.UnsupportedEncodingException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qv")
public class class437 implements class436 {
   @ObfuscatedName("ai")
   public static short[][] field3825;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lorg/json/JSONObject;"
   )
   JSONObject field3826;

   public class437(byte[] var1) throws UnsupportedEncodingException {
      this.method2291(var1);
   }

   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;)V"
   )
   public class437(JSONObject var1) {
      this.field3826 = var1;
   }

   public class437(String var1) throws UnsupportedEncodingException {
      this.method2294(var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Lqz;",
      garbageValue = "-1368831969"
   )
   public class435 vmethod2213() {
      return class435.field3823;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)[B",
            garbageValue = "888549065"
    )
    public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.field3826 == null ? new byte[0] : this.field3826.toString().getBytes("UTF-8");
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "([BI)V",
      garbageValue = "773111973"
   )
   void method2291(byte[] var1) throws UnsupportedEncodingException {
      String var2 = new String(var1, "UTF-8");
      this.method2294(var2);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "101"
   )
   void method2294(String var1) throws UnsupportedEncodingException {
      try {
         if (var1.charAt(0) == '{') {
            this.field3826 = new JSONObject(var1);
         } else {
            if (var1.charAt(0) != '[') {
               throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder.");
            }

            JSONArray var2 = new JSONArray(var1);
            this.field3826 = new JSONObject();
            this.field3826.method2652("arrayValues", var2);
         }

      } catch (JSONException var3) {
         throw new UnsupportedEncodingException(var3.getMessage());
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONObject;",
      garbageValue = "-288365426"
   )
   public JSONObject method2292() {
      return this.field3826;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)I",
      garbageValue = "34"
   )
   static final int method2295(int var0, int var1, int var2, int var3) {
      return var2 * var1 + var3 * var0 >> 16;
   }
}
