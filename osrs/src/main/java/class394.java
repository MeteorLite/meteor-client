import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pc")
public class class394 {
    @ObfuscatedName("al")
    public static int[] SpriteBuffer_spritePalette;
   @ObfuscatedName("ac")
   final Map field3683 = new HashMap();
   @ObfuscatedName("au")
   final Map field3685 = new HashMap();
   @ObfuscatedName("ab")
   final DecimalFormat field3686 = new DecimalFormat();

   public class394() {
      this.field3686.setMaximumFractionDigits(2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljavax/net/ssl/HttpsURLConnection;I)V",
      garbageValue = "1759614769"
   )
   public void method2104(HttpsURLConnection var1) {
      Iterator var2 = this.field3683.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/util/Map;",
      garbageValue = "1411572394"
   )
   public Map method2105() {
      return this.field3683;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-687653151"
   )
   public void method2106(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         this.field3683.put(var1, var2 != null ? var2 : "");
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;S)V",
      garbageValue = "-14811"
   )
   public void method2115(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         this.field3683.remove(var1);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lpm;Ljava/lang/String;B)V",
      garbageValue = "84"
   )
   void method2107(class393 var1, String var2) {
      String var3 = String.format("%s %s", var1.method2102(), var2);
      this.method2106("Authorization", var3);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "95"
   )
   public void method2114(String var1) {
      this.method2107(class393.field3681, var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-596088088"
   )
   public void method2108(String var1) {
      this.method2107(class393.field3680, var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lqz;I)V",
      garbageValue = "1037521942"
   )
   public void method2109(class435 var1) {
      this.field3683.put("Content-Type", var1.method2287());
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1055361805"
   )
   public void method2110() {
      this.field3683.remove("Content-Type");
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(Lqz;B)V",
      garbageValue = "49"
   )
   public void method2111(class435 var1) {
      this.method2112(var1, 1.0F);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lqz;FI)V",
      garbageValue = "-868305920"
   )
   void method2112(class435 var1, float var2) {
      this.field3685.put(var1, Math.max(0.0F, Math.min(1.0F, var2)));
      this.method2113();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "720033407"
   )
   void method2113() {
      this.field3683.remove("Accept");
      if (!this.field3685.isEmpty()) {
         this.field3683.put("Accept", this.method2116());
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "269746303"
   )
   String method2116() {
      ArrayList var1 = new ArrayList(this.field3685.entrySet());
      Collections.sort(var1, new class395(this));
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (var2.length() > 0) {
            var2.append(",");
         }

         var2.append(((class435)var4.getKey()).method2287());
         float var5 = (Float)var4.getValue();
         if (var5 < 1.0F) {
            String var6 = this.field3686.format((double)var5);
            var2.append(";q=").append(var6);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/awt/Component;I)V",
      garbageValue = "1714263236"
   )
   static void method2117(Component var0) {
      var0.addMouseListener(MouseHandler.MouseHandler_instance);
      var0.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var0.addFocusListener(MouseHandler.MouseHandler_instance);
   }
}
