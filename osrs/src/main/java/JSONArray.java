import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("org/json/JSONArray")
public class JSONArray {
   @ObfuscatedName("myArrayList")
   ArrayList myArrayList;

   public JSONArray() {
      this.myArrayList = new ArrayList();
   }

   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONTokener;)V"
   )
   public JSONArray(JSONTokener var1) throws JSONException {
      this();
      char var2 = var1.nextClean();
      char var3;
      if (var2 == '[') {
         var3 = ']';
      } else {
         if (var2 != '(') {
            throw var1.syntaxError("A JSONArray text must start with '['");
         }

         var3 = ')';
      }

      if (var1.nextClean() != ']') {
         var1.back();

         while(true) {
            if (var1.nextClean() == ',') {
               var1.back();
               this.myArrayList.add((Object)null);
            } else {
               var1.back();
               this.myArrayList.add(var1.nextValue());
            }

            var2 = var1.nextClean();
            switch(var2) {
            case ')':
            case ']':
               if (var3 != var2) {
                  throw var1.syntaxError("Expected a '" + new Character(var3) + "'");
               }

               return;
            case ',':
            case ';':
               if (var1.nextClean() == ']') {
                  return;
               }

               var1.back();
               break;
            default:
               throw var1.syntaxError("Expected a ',' or ']'");
            }
         }
      }
   }

   public JSONArray(String var1) throws JSONException {
      this(new JSONTokener(var1));
   }

   public JSONArray(Collection var1) {
      this.myArrayList = var1 == null ? new ArrayList() : new ArrayList(var1);
   }

   public JSONArray(Object var1) throws JSONException {
      this();
      if (!var1.getClass().isArray()) {
         throw new JSONException("JSONArray initial value should be a string or collection or array.");
      } else {
         int var2 = Array.getLength(var1);

         for(int var3 = 0; var3 < var2; ++var3) {
            this.method9210(Array.get(var1, var3));
         }

      }
   }

   public JSONArray(Object var1, boolean var2) throws JSONException {
      this();
      if (!var1.getClass().isArray()) {
         throw new JSONException("JSONArray initial value should be a string or collection or array.");
      } else {
         int var3 = Array.getLength(var1);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.method9210(new JSONObject(Array.get(var1, var4), var2));
         }

      }
   }

   public JSONArray(Collection var1, boolean var2) {
      this.myArrayList = new ArrayList();
      if (var1 != null) {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            this.myArrayList.add(new JSONObject(var3.next(), var2));
         }
      }

   }

   @ObfuscatedName("opt")
   public Object method9211(int var1) {
      return var1 >= 0 && var1 < this.length() ? this.myArrayList.get(var1) : null;
   }

   @ObfuscatedName("get")
   public Object method9221(int var1) throws JSONException {
      Object var2 = this.method9211(var1);
      if (var2 == null) {
         throw new JSONException("JSONArray[" + var1 + "] not found.");
      } else {
         return var2;
      }
   }

   @ObfuscatedName("put")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;)Lorg/json/JSONArray;"
   )
   public JSONArray method9210(Object var1) {
      this.myArrayList.add(var1);
      return this;
   }

   @ObfuscatedName("optBoolean")
   public boolean optBoolean(int var1, boolean var2) {
      try {
         return this.getBoolean(var1);
      } catch (Exception var4) {
         return var2;
      }
   }

   @ObfuscatedName("optLong")
   public long optLong(int var1, long var2) {
      try {
         return this.getLong(var1);
      } catch (Exception var5) {
         return var2;
      }
   }

   @ObfuscatedName("optInt")
   public int optInt(int var1, int var2) {
      try {
         return this.getInt(var1);
      } catch (Exception var4) {
         return var2;
      }
   }

   @ObfuscatedName("optString")
   public String optString(int var1, String var2) {
      Object var3 = this.method9211(var1);
      return var3 != null ? var3.toString() : var2;
   }

   @ObfuscatedName("getBoolean")
   public boolean getBoolean(int var1) throws JSONException {
      Object var2 = this.method9221(var1);
      if (var2.equals(Boolean.FALSE) || var2 instanceof String && ((String)var2).equalsIgnoreCase("false")) {
         return false;
      } else if (var2.equals(Boolean.TRUE) || var2 instanceof String && ((String)var2).equalsIgnoreCase("true")) {
         return true;
      } else {
         throw new JSONException("JSONArray[" + var1 + "] is not a Boolean.");
      }
   }

   @ObfuscatedName("getLong")
   public long getLong(int var1) throws JSONException {
      Object var2 = this.method9221(var1);
      return var2 instanceof Number ? ((Number)var2).longValue() : (long)this.getDouble(var1);
   }

   @ObfuscatedName("getInt")
   public int getInt(int var1) throws JSONException {
      Object var2 = this.method9221(var1);
      return var2 instanceof Number ? ((Number)var2).intValue() : (int)this.getDouble(var1);
   }

   @ObfuscatedName("getDouble")
   public double getDouble(int var1) throws JSONException {
      Object var2 = this.method9221(var1);

      try {
         return var2 instanceof Number ? ((Number)var2).doubleValue() : Double.valueOf((String)var2);
      } catch (Exception var4) {
         throw new JSONException("JSONArray[" + var1 + "] is not a number.");
      }
   }

   @ObfuscatedName("optDouble")
   public double optDouble(int var1, double var2) {
      try {
         return this.getDouble(var1);
      } catch (Exception var5) {
         return var2;
      }
   }

   @ObfuscatedName("toString")
   String toString(int var1, int var2) throws JSONException {
      int var3 = this.length();
      if (var3 == 0) {
         return "[]";
      } else {
         StringBuffer var5 = new StringBuffer("[");
         if (var3 == 1) {
            var5.append(JSONObject.valueToString(this.myArrayList.get(0), var1, var2));
         } else {
            int var6 = var2 + var1;
            var5.append('\n');

            int var4;
            for(var4 = 0; var4 < var3; ++var4) {
               if (var4 > 0) {
                  var5.append(",\n");
               }

               for(int var7 = 0; var7 < var6; ++var7) {
                  var5.append(' ');
               }

               var5.append(JSONObject.valueToString(this.myArrayList.get(var4), var1, var6));
            }

            var5.append('\n');

            for(var4 = 0; var4 < var2; ++var4) {
               var5.append(' ');
            }
         }

         var5.append(']');
         return var5.toString();
      }
   }

   @ObfuscatedName("length")
   public int length() {
      return this.myArrayList.size();
   }

   @ObfuscatedName("join")
   public String join(String var1) throws JSONException {
      int var2 = this.length();
      StringBuffer var3 = new StringBuffer();

      for(int var4 = 0; var4 < var2; ++var4) {
         if (var4 > 0) {
            var3.append(var1);
         }

         var3.append(JSONObject.valueToString(this.myArrayList.get(var4)));
      }

      return var3.toString();
   }

   @ObfuscatedName("getJSONObject")
   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONObject;"
   )
   public JSONObject getJSONObject(int var1) throws JSONException {
      Object var2 = this.method9221(var1);
      if (var2 instanceof JSONObject) {
         return (JSONObject)var2;
      } else {
         throw new JSONException("JSONArray[" + var1 + "] is not a JSONObject.");
      }
   }

   @ObfuscatedName("getString")
   public String getString(int var1) throws JSONException {
      return this.method9221(var1).toString();
   }

   @ObfuscatedName("write")
   public Writer write(Writer var1) throws JSONException {
      try {
         boolean var2 = false;
         int var3 = this.length();
         var1.write(91);

         for(int var4 = 0; var4 < var3; ++var4) {
            if (var2) {
               var1.write(44);
            }

            Object var5 = this.myArrayList.get(var4);
            if (var5 instanceof JSONObject) {
               ((JSONObject)var5).write(var1);
            } else if (var5 instanceof JSONArray) {
               ((JSONArray)var5).write(var1);
            } else {
               var1.write(JSONObject.valueToString(var5));
            }

            var2 = true;
         }

         var1.write(93);
         return var1;
      } catch (IOException var7) {
         throw new JSONException(var7);
      }
   }

   @ObfuscatedName("toString")
   public String toString() {
      try {
         return '[' + this.join(",") + ']';
      } catch (Exception var2) {
         return null;
      }
   }

   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONObject;"
   )
   public JSONObject optJSONObject(int var1) {
      Object var2 = this.method9211(var1);
      return var2 instanceof JSONObject ? (JSONObject)var2 : null;
   }

   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONArray;"
   )
   public JSONArray getJSONArray(int var1) throws JSONException {
      Object var2 = this.method9221(var1);
      if (var2 instanceof JSONArray) {
         return (JSONArray)var2;
      } else {
         throw new JSONException("JSONArray[" + var1 + "] is not a JSONArray.");
      }
   }

   @ObfuscatedName("isNull")
   public boolean isNull(int var1) {
      return JSONObject.NULL.equals(this.method9211(var1));
   }

   @ObfuscatedName("optBoolean")
   public boolean optBoolean(int var1) {
      return this.optBoolean(var1, false);
   }

   @ObfuscatedName("optDouble")
   public double optDouble(int var1) {
      return this.optDouble(var1, Double.NaN);
   }

   @ObfuscatedName("optInt")
   public int optInt(int var1) {
      return this.optInt(var1, 0);
   }

   @ObfuscatedSignature(
      descriptor = "(I)Lorg/json/JSONArray;"
   )
   public JSONArray optJSONArray(int var1) {
      Object var2 = this.method9211(var1);
      return var2 instanceof JSONArray ? (JSONArray)var2 : null;
   }

   @ObfuscatedName("optLong")
   public long optLong(int var1) {
      return this.optLong(var1, 0L);
   }

   @ObfuscatedName("toJSONObject")
   @ObfuscatedSignature(
      descriptor = "(Lorg/json/JSONArray;)Lorg/json/JSONObject;"
   )
   public JSONObject toJSONObject(JSONArray var1) throws JSONException {
      if (var1 != null && var1.length() != 0 && this.length() != 0) {
         JSONObject var2 = new JSONObject();

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            var2.method9196(var1.getString(var3), this.method9211(var3));
         }

         return var2;
      } else {
         return null;
      }
   }

   @ObfuscatedName("optString")
   public String optString(int var1) {
      return this.optString(var1, "");
   }

   @ObfuscatedName("toString")
   public String toString(int var1) throws JSONException {
      return this.toString(var1, 0);
   }
}
