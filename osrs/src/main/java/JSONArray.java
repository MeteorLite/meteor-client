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

@Implements("JSONArray")
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
            this.method2647(Array.get(var1, var3));
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
            this.method2647(new JSONObject(Array.get(var1, var4), var2));
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
   public Object method2649(int var1) {
      return var1 >= 0 && var1 < this.length() ? this.myArrayList.get(var1) : null;
   }

   @ObfuscatedName("get")
   public Object method2646(int var1) throws JSONException {
      Object var2 = this.method2649(var1);
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
   public JSONArray method2647(Object var1) {
      this.myArrayList.add(var1);
      return this;
   }

    @ObfuscatedName("getBoolean")
    public boolean getBoolean(int var1) throws JSONException {
      Object var2 = this.method2646(var1);
      if (var2.equals(Boolean.FALSE) || var2 instanceof String && ((String)var2).equalsIgnoreCase("false")) {
         return false;
      } else if (var2.equals(Boolean.TRUE) || var2 instanceof String && ((String)var2).equalsIgnoreCase("true")) {
         return true;
      } else {
         throw new JSONException("JSONArray[" + var1 + "] is not a Boolean.");
      }
   }

    @ObfuscatedName("getInt")
    public int getInt(int var1) throws JSONException {
      Object var2 = this.method2646(var1);
      return var2 instanceof Number ? ((Number)var2).intValue() : (int)this.getDouble(var1);
   }

    @ObfuscatedName("getLong")
    public long getLong(int var1) throws JSONException {
      Object var2 = this.method2646(var1);
      return var2 instanceof Number ? ((Number)var2).longValue() : (long)this.getDouble(var1);
   }

    @ObfuscatedName("getDouble")
    public double getDouble(int var1) throws JSONException {
      Object var2 = this.method2646(var1);

      try {
         return var2 instanceof Number ? ((Number)var2).doubleValue() : Double.valueOf((String)var2);
      } catch (Exception var4) {
         throw new JSONException("JSONArray[" + var1 + "] is not a number.");
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

    @ObfuscatedName("optDouble")
    public double optDouble(int var1, double var2) {
      try {
         return this.getDouble(var1);
      } catch (Exception var5) {
         return var2;
      }
   }

    @ObfuscatedName("getJSONObject")
    @ObfuscatedSignature(
            descriptor = "(I)Lorg/json/JSONObject;"
    )
    public JSONObject getJSONObject(int var1) throws JSONException {
      Object var2 = this.method2646(var1);
      if (var2 instanceof JSONObject) {
         return (JSONObject)var2;
      } else {
         throw new JSONException("JSONArray[" + var1 + "] is not a JSONObject.");
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

    @ObfuscatedName("getString")
    public String getString(int var1) throws JSONException {
      return this.method2646(var1).toString();
   }

    @ObfuscatedName("optInt")
    public int optInt(int var1, int var2) {
      try {
         return this.getInt(var1);
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

    @ObfuscatedName("optString")
    public String optString(int var1, String var2) {
      Object var3 = this.method2649(var1);
      return var3 != null ? var3.toString() : var2;
   }

    @ObfuscatedName("optBoolean")
    public boolean optBoolean(int var1, boolean var2) {
      try {
         return this.getBoolean(var1);
      } catch (Exception var4) {
         return var2;
      }
   }
}
