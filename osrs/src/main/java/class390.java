import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pu")
public class class390 {
   @ObfuscatedName("ab")
   final Map field3634 = new HashMap();
   @ObfuscatedName("an")
   final Map field3635 = new HashMap();
   @ObfuscatedName("ao")
   final DecimalFormat field3636 = new DecimalFormat();

   public class390() {
      this.field3636.setMaximumFractionDigits(2);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljavax/net/ssl/HttpsURLConnection;I)V",
      garbageValue = "-1545289120"
   )
   public void method2049(HttpsURLConnection var1) {
      Iterator var2 = this.field3634.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/Map;",
      garbageValue = "1"
   )
   public Map method2050() {
      return this.field3634;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-625731660"
   )
   public void method2053(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         this.field3634.put(var1, var2 != null ? var2 : "");
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1613794431"
   )
   public void method2052(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         this.field3634.remove(var1);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Loy;Ljava/lang/String;B)V",
      garbageValue = "-64"
   )
   void method2061(class389 var1, String var2) {
      String var3 = String.format("%s %s", var1.method2046(), var2);
      this.method2053("Authorization", var3);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-512273013"
   )
   public void method2054(String var1) {
      this.method2061(class389.field3633, var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "910711663"
   )
   public void method2051(String var1) {
      this.method2061(class389.field3631, var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lqn;B)V",
      garbageValue = "4"
   )
   public void method2056(class431 var1) {
      this.field3634.put("Content-Type", var1.method2220());
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-72"
   )
   public void method2057() {
      this.field3634.remove("Content-Type");
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Lqn;I)V",
      garbageValue = "1731496941"
   )
   public void method2058(class431 var1) {
      this.method2060(var1, 1.0F);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Lqn;FB)V",
      garbageValue = "36"
   )
   void method2060(class431 var1, float var2) {
      this.field3635.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
      this.method2059();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-5"
   )
   void method2059() {
      this.field3634.remove("Accept");
      if (!this.field3635.isEmpty()) {
         this.field3634.put("Accept", this.method2055());
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-88"
   )
   String method2055() {
      ArrayList var1 = new ArrayList(this.field3635.entrySet());
      Collections.sort(var1, new class391(this));
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (var2.length() > 0) {
            var2.append(",");
         }

         var2.append(((class431)var4.getKey()).method2220());
         float var5 = (Float)var4.getValue();
         if (var5 < 1.0F) {
            String var6 = this.field3636.format((double)var5);
            var2.append(";q=").append(var6);
         }
      }

      return var2.toString();
   }
}
