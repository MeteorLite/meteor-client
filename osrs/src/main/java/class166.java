import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class166 {
   @ObfuscatedName("l")
   int field1413 = -1;
   @ObfuscatedName("k")
   String field1414;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Ldg;"
   )
   UrlRequest field1416;
   @ObfuscatedName("r")
   String field1417 = null;
   @ObfuscatedName("b")
   float[] field1418 = new float[4];
   @ObfuscatedName("m")
   ArrayList field1419 = new ArrayList();
   @ObfuscatedName("t")
   ArrayList field1420 = new ArrayList();
   @ObfuscatedName("h")
   ArrayList field1421 = new ArrayList();
   @ObfuscatedName("p")
   Map field1415 = new HashMap();
   @ObfuscatedName("o")
   Map field1422 = new HashMap();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ldi;I)Z",
      garbageValue = "-1906969818"
   )
   public boolean method869(String var1, UrlRequester var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var2 == null) {
            return false;
         } else {
            this.method875();

            try {
               this.field1414 = var1;
               this.field1416 = var2.request(new URL(this.field1414));
               this.field1413 = 0;
               return true;
            } catch (MalformedURLException var4) {
               this.method875();
               this.field1413 = 100;
               return false;
            }
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Ldi;I)V",
      garbageValue = "-441833752"
   )
   public void method870(UrlRequester var1) {
      switch(this.field1413) {
      case 0:
         this.method876(var1);
         break;
      case 1:
         this.method877();
         break;
      default:
         return;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1468199543"
   )
   public int method871() {
      return this.field1413;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "342662863"
   )
   public int method880(String var1) {
      return this.field1415.containsKey(var1) ? (Integer)this.field1415.get(var1) : -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-183486423"
   )
   public String method872(String var1) {
      return (String)((String)(this.field1422.containsKey(var1) ? this.field1422.get(var1) : null));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/util/ArrayList;",
      garbageValue = "-745265160"
   )
   public ArrayList method882() {
      return this.field1420;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/util/ArrayList;",
      garbageValue = "-1813839199"
   )
   public ArrayList method873() {
      return this.field1421;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "532962276"
   )
   public String method874() {
      return this.field1417;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/ArrayList;",
      garbageValue = "61"
   )
   public ArrayList method881() {
      return this.field1419;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "435595886"
   )
   void method875() {
      this.field1416 = null;
      this.field1417 = null;
      this.field1418[0] = 0.0F;
      this.field1418[1] = 0.0F;
      this.field1418[2] = 1.0F;
      this.field1418[3] = 1.0F;
      this.field1419.clear();
      this.field1420.clear();
      this.field1421.clear();
      this.field1415.clear();
      this.field1422.clear();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(Ldi;I)V",
      garbageValue = "1102983702"
   )
   void method876(UrlRequester var1) {
      if (this.field1416 != null && this.field1416.isDone()) {
         byte[] var2 = this.field1416.getResponse();
         if (var2 == null) {
            this.method875();
            this.field1413 = 100;
         } else {
            JSONObject var3;
            try {
               class429 var4 = new class429(var2);
               var3 = var4.method2209();
               var3 = var3.getJSONObject("message");
            } catch (Exception var9) {
               this.method875();
               this.field1413 = 102;
               return;
            }

            try {
               this.method878(var3.getJSONArray("images"), var1);
            } catch (Exception var8) {
               this.field1420.clear();
            }

            try {
               this.method879(var3.getJSONArray("labels"));
            } catch (Exception var7) {
               this.field1421.clear();
            }

            try {
               this.method883(var3.getJSONObject("behaviour"));
            } catch (Exception var6) {
               this.field1417 = null;
               this.field1418[0] = 0.0F;
               this.field1418[1] = 0.0F;
               this.field1418[2] = 1.0F;
               this.field1418[3] = 1.0F;
               this.field1419.clear();
            }

            try {
               this.method884(var3.getJSONObject("meta"));
            } catch (Exception var5) {
               this.field1415.clear();
               this.field1422.clear();
            }

            this.field1413 = this.field1420.size() > 0 ? 1 : 2;
            this.field1416 = null;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1531480410"
   )
   void method877() {
      Iterator var1 = this.field1420.iterator();

      class172 var2;
      do {
         if (!var1.hasNext()) {
            var1 = this.field1420.iterator();

            while(var1.hasNext()) {
               var2 = (class172)var1.next();
               if (var2.field1440 != null) {
                  byte[] var3 = var2.field1440.getResponse();
                  if (var3 != null && var3.length > 0) {
                     this.field1413 = 2;
                     return;
                  }
               }
            }

            this.method875();
            this.field1413 = 101;
            return;
         }

         var2 = (class172)var1.next();
      } while(var2.field1440 == null || var2.field1440.isDone());

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONArray;Ldi;I)V",
      garbageValue = "-1028826421"
   )
   void method878(JSONArray var1, UrlRequester var2) throws JSONException {
      if (var1 != null) {
         for(int var3 = 0; var3 < var1.length(); ++var3) {
            try {
               JSONObject var4 = var1.getJSONObject(var3);
               class172 var5 = new class172(this);
               var5.field1440 = var2.request(new URL(var4.getString("src")));
               var5.field1437 = class88.method494(var4, "placement");
               this.field1420.add(var5);
            } catch (MalformedURLException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONArray;I)V",
      garbageValue = "1741895465"
   )
   void method879(JSONArray var1) throws JSONException {
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.length(); ++var2) {
            JSONObject var3 = var1.getJSONObject(var2);
            class173 var4 = new class173(this);
            var4.field1442 = var3.getString("text");
            String var7 = var3.getString("align_x");
            byte var6;
            if (var7.equals("centre")) {
               var6 = 1;
            } else if (!var7.equals("bottom") && !var7.equals("right")) {
               var6 = 0;
            } else {
               var6 = 2;
            }

            var4.field1443 = var6;
            String var10 = var3.getString("align_y");
            byte var9;
            if (var10.equals("centre")) {
               var9 = 1;
            } else if (!var10.equals("bottom") && !var10.equals("right")) {
               var9 = 0;
            } else {
               var9 = 2;
            }

            var4.field1444 = var9;
            var4.field1445 = var3.getInt("font");
            var4.field1446 = class88.method494(var3, "placement");
            this.field1421.add(var4);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;I)V",
      garbageValue = "-2097797182"
   )
   void method883(JSONObject var1) throws JSONException {
      if (var1 != null) {
         this.field1418 = class88.method494(var1, "clickbounds");
         this.field1417 = var1.getString("endpoint");
         String[] var2 = JSONObject.getNames(var1);

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
               try {
                  int var4 = var1.getInt(var2[var3]);
                  this.field1419.add(new class174(this, var2[var3], var4));
               } catch (Exception var8) {
                  try {
                     String var5 = var1.getString(var2[var3]);
                     if (var5.equals("true")) {
                        this.field1419.add(new class174(this, var2[var3], 1));
                     } else if (var5.equals("false")) {
                        this.field1419.add(new class174(this, var2[var3], 0));
                     } else {
                        this.field1419.add(new class165(this, var2[var3], var5));
                     }
                  } catch (Exception var7) {
                     ;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;I)V",
      garbageValue = "1293504682"
   )
   void method884(JSONObject var1) throws JSONException {
      String[] var2 = JSONObject.getNames(var1);

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         try {
            int var4 = var1.getInt(var2[var3]);
            this.field1415.put(var2[var3], var4);
         } catch (Exception var8) {
            try {
               String var5 = var1.getString(var2[var3]);
               if (var5.equals("true")) {
                  this.field1415.put(var2[var3], 1);
               } else if (var5.equals("false")) {
                  this.field1415.put(var2[var3], 0);
               } else {
                  this.field1422.put(var2[var3], var5);
               }
            } catch (Exception var7) {
               ;
            }
         }
      }

   }
}
