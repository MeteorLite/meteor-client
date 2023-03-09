import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qm")
public class class434 implements class432 {
   @ObfuscatedName("aj")
   final Map field3775;

   public class434(Map var1) {
      this.field3775 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)Lqn;",
      garbageValue = "1"
   )
   @Export("vmethod2213")
   public class431 vmethod2213() {
      return null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)[B",
      garbageValue = "66"
   )
   @Export("vmethod7797")
   public byte[] vmethod7797() throws UnsupportedEncodingException {
      return this.method2231().getBytes("UTF-8");
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "421465179"
   )
   public String method2231() throws UnsupportedEncodingException {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.field3775.entrySet().iterator();

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
