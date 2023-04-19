import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qa")
public class class438 implements class436 {
   @ObfuscatedName("af")
   final Map field3827;

   public class438(Map var1) {
      this.field3827 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)Lqz;",
            garbageValue = "-1368831969"
    )
    public class435 vmethod2213() {
      return null;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)[B",
            garbageValue = "888549065"
    )
    public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.method2298().getBytes("UTF-8");
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-759167743"
   )
   public String method2298() throws UnsupportedEncodingException {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.field3827.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         String var4 = URLEncoder.encode((String)var3.getKey(), "UTF-8");
         String var5 = URLEncoder.encode((String)var3.getValue(), "UTF-8");
         var1.append(var4).append("=").append(var5).append("&");
      }

      if (var1.length() == 0) {
         return "";
      } else {
         var1.deleteCharAt(var1.length() - 1);
         var1.insert(0, "?");
         return var1.toString();
      }
   }
}
