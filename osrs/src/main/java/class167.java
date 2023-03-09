import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class167 {
   @ObfuscatedName("uw")
   @Export("cameraLookAtX")
   static int cameraLookAtX;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive12")
   static Archive archive12;
   @ObfuscatedName("ap")
   int field1401 = -1;
   @ObfuscatedName("ar")
   String field1402;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Leo;"
   )
   UrlRequest field1403;
   @ObfuscatedName("ax")
   String field1404 = null;
   @ObfuscatedName("as")
   float[] field1405 = new float[4];
   @ObfuscatedName("ay")
   ArrayList field1399 = new ArrayList();
   @ObfuscatedName("am")
   ArrayList field1406 = new ArrayList();
   @ObfuscatedName("az")
   ArrayList field1407 = new ArrayList();
   @ObfuscatedName("ae")
   Map field1400 = new HashMap();
   @ObfuscatedName("au")
   Map field1408 = new HashMap();

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Leb;I)Z",
      garbageValue = "-817069381"
   )
   public boolean method867(String var1, UrlRequester var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var2 == null) {
            return false;
         } else {
            this.method873();

            try {
               this.field1402 = var1;
               this.field1403 = var2.request(new URL(this.field1402));
               this.field1401 = 0;
               return true;
            } catch (MalformedURLException var4) {
               this.method873();
               this.field1401 = 100;
               return false;
            }
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Leb;S)V",
      garbageValue = "-30326"
   )
   public void method868(UrlRequester var1) {
      switch(this.field1401) {
      case 0:
         this.method885(var1);
         break;
      case 1:
         this.method883();
         break;
      default:
         return;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "56"
   )
   public int method875() {
      return this.field1401;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "1932678065"
   )
   public int method881(String var1) {
      return this.field1400.containsKey(var1) ? (Integer)this.field1400.get(var1) : -1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1530090364"
   )
   public String method874(String var1) {
      return (String)((String)(this.field1408.containsKey(var1) ? this.field1408.get(var1) : null));
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/util/ArrayList;",
      garbageValue = "-3349953"
   )
   public ArrayList method876() {
      return this.field1406;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/ArrayList;",
      garbageValue = "-19"
   )
   public ArrayList method870() {
      return this.field1407;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1167109503"
   )
   public String method871() {
      return this.field1404;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)[F",
      garbageValue = "-2042824"
   )
   public float[] method878() {
      return this.field1405;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/ArrayList;",
      garbageValue = "7"
   )
   public ArrayList method869() {
      return this.field1399;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "55"
   )
   void method873() {
      this.field1403 = null;
      this.field1404 = null;
      this.field1405[0] = 0.0F;
      this.field1405[1] = 0.0F;
      this.field1405[2] = 1.0F;
      this.field1405[3] = 1.0F;
      this.field1399.clear();
      this.field1406.clear();
      this.field1407.clear();
      this.field1400.clear();
      this.field1408.clear();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Leb;I)V",
      garbageValue = "295942057"
   )
   void method885(UrlRequester var1) {
      if (this.field1403 != null && this.field1403.isDone()) {
         byte[] var2 = this.field1403.getResponse();
         if (var2 == null) {
            this.method873();
            this.field1401 = 100;
         } else {
            try {
               this.method872(new class433(var2), var1);
            } catch (UnsupportedEncodingException var4) {
               this.method873();
               this.field1401 = 102;
               return;
            }

            this.field1401 = this.field1406.size() > 0 ? 1 : 2;
            this.field1403 = null;
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "29"
   )
   void method883() {
      Iterator var1 = this.field1406.iterator();

      class173 var2;
      do {
         if (!var1.hasNext()) {
            var1 = this.field1406.iterator();

            while(var1.hasNext()) {
               var2 = (class173)var1.next();
               if (var2.field1427 != null) {
                  byte[] var3 = var2.field1427.getResponse();
                  if (var3 != null && var3.length > 0) {
                     this.field1401 = 2;
                     return;
                  }
               }
            }

            this.method873();
            this.field1401 = 101;
            return;
         }

         var2 = (class173)var1.next();
      } while(var2.field1427 == null || var2.field1427.isDone());

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONArray;Leb;I)V",
      garbageValue = "1778841749"
   )
   void method882(JSONArray var1, UrlRequester var2) throws JSONException {
      if (var1 != null) {
         for(int var3 = 0; var3 < var1.length(); ++var3) {
            try {
               JSONObject var4 = var1.getJSONObject(var3);
               class173 var5 = new class173(this);
               var5.field1427 = var2.request(new URL(var4.getString("src")));
               var5.field1426 = class260.method1465(var4, "placement");
               this.field1406.add(var5);
            } catch (MalformedURLException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONArray;I)V",
      garbageValue = "-1527876041"
   )
   void method877(JSONArray var1) throws JSONException {
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.length(); ++var2) {
            JSONObject var3 = var1.getJSONObject(var2);
            class174 var4 = new class174(this);
            var4.field1430 = var3.getString("text");
            String var7 = var3.getString("align_x");
            byte var6;
            if (var7.equals("centre")) {
               var6 = 1;
            } else if (!var7.equals("bottom") && !var7.equals("right")) {
               var6 = 0;
            } else {
               var6 = 2;
            }

            var4.field1431 = var6;
            String var10 = var3.getString("align_y");
            byte var9;
            if (var10.equals("centre")) {
               var9 = 1;
            } else if (!var10.equals("bottom") && !var10.equals("right")) {
               var9 = 0;
            } else {
               var9 = 2;
            }

            var4.field1429 = var9;
            var4.field1432 = var3.getInt("font");
            var4.field1433 = class260.method1465(var3, "placement");
            this.field1407.add(var4);
         }

      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;I)V",
      garbageValue = "-1169579643"
   )
   void method879(JSONObject var1) throws JSONException {
      if (var1 != null) {
         this.field1405 = class260.method1465(var1, "clickbounds");
         this.field1404 = var1.getString("endpoint");
         String[] var2 = JSONObject.getNames(var1);

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
               try {
                  int var4 = var1.getInt(var2[var3]);
                  this.field1399.add(new class175(this, var2[var3], var4));
               } catch (Exception var8) {
                  try {
                     String var5 = var1.getString(var2[var3]);
                     if (var5.equals("true")) {
                        this.field1399.add(new class175(this, var2[var3], 1));
                     } else if (var5.equals("false")) {
                        this.field1399.add(new class175(this, var2[var3], 0));
                     } else {
                        this.field1399.add(new class166(this, var2[var3], var5));
                     }
                  } catch (Exception var7) {
                     ;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONObject;B)V",
      garbageValue = "7"
   )
   void method880(JSONObject var1) throws JSONException {
      String[] var2 = JSONObject.getNames(var1);

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         try {
            int var4 = var1.getInt(var2[var3]);
            this.field1400.put(var2[var3], var4);
         } catch (Exception var8) {
            try {
               String var5 = var1.getString(var2[var3]);
               if (var5.equals("true")) {
                  this.field1400.put(var2[var3], 1);
               } else if (var5.equals("false")) {
                  this.field1400.put(var2[var3], 0);
               } else {
                  this.field1408.put(var2[var3], var5);
               }
            } catch (Exception var7) {
               ;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lqg;Leb;B)V",
      garbageValue = "120"
   )
   void method872(class433 var1, UrlRequester var2) {
      JSONObject var3;
      try {
         var3 = var1.method2226();
         var3 = var3.getJSONObject("message");
      } catch (Exception var9) {
         this.method873();
         this.field1401 = 102;
         return;
      }

      try {
         this.method882(var3.getJSONArray("images"), var2);
      } catch (Exception var8) {
         this.field1406.clear();
      }

      try {
         this.method877(var3.getJSONArray("labels"));
      } catch (Exception var7) {
         this.field1407.clear();
      }

      try {
         this.method879(var3.getJSONObject("behaviour"));
      } catch (Exception var6) {
         this.field1404 = null;
         this.field1405[0] = 0.0F;
         this.field1405[1] = 0.0F;
         this.field1405[2] = 1.0F;
         this.field1405[3] = 1.0F;
         this.field1399.clear();
      }

      try {
         this.method880(var3.getJSONObject("meta"));
      } catch (Exception var5) {
         this.field1400.clear();
         this.field1408.clear();
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Leb;B)Z",
      garbageValue = "3"
   )
   public boolean method884(String var1, UrlRequester var2) {
      try {
         this.method872(new class433(var1.getBytes()), var2);
         this.field1401 = this.field1406.size() > 0 ? 1 : 2;
      } catch (UnsupportedEncodingException var4) {
         this.field1401 = 102;
      }

      return this.field1401 < 100;
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "560158880"
   )
   static final void method886(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
         if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
            Client.field594[var4] = true;
         }
      }

   }
}
