import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class10 {
   @ObfuscatedName("h")
   HttpsURLConnection field32;
   @ObfuscatedName("e")
   final Map field29;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lpu;"
   )
   class421 field30;
   @ObfuscatedName("x")
   Map field35;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   final class9 field28;
   @ObfuscatedName("q")
   boolean field31 = false;
   @ObfuscatedName("f")
   boolean field33 = false;
   @ObfuscatedName("r")
   int field34 = 300000;

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;Lb;Z)V"
   )
   public class10(URL var1, class9 var2, boolean var3) throws IOException {
      if (!var2.method25()) {
         throw new UnsupportedEncodingException("Unsupported request method used " + var2.method26());
      } else {
         this.field32 = (HttpsURLConnection)var1.openConnection();
         if (!var3) {
            HttpsURLConnection var4 = this.field32;
            if (class15.field47 == null) {
               class15.field47 = new class15();
            }

            class15 var5 = class15.field47;
            var4.setSSLSocketFactory(var5);
         }

         this.field28 = var2;
         this.field29 = new HashMap();
         this.field35 = new HashMap();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-825590030"
   )
   public void method35(String var1, String var2) {
      if (!this.field31) {
         this.field29.put(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-953268261"
   )
   String method34() {
      ArrayList var1 = new ArrayList(this.field35.entrySet());
      Collections.sort(var1, new class18(this));
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (var2.length() > 0) {
            var2.append(",");
         }

         var2.append(((class420)var4.getKey()).method2169());
         float var5 = (Float)var4.getValue();
         if (var5 < 1.0F) {
            String var6 = Float.toString(var5).substring(0, 4);
            var2.append(";q=" + var6);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1499670769"
   )
   void method36() throws ProtocolException {
      if (!this.field31) {
         this.field32.setRequestMethod(this.field28.method26());
         if (!this.field35.isEmpty()) {
            this.field29.put("Accept", this.method34());
         }

         Iterator var1 = this.field29.entrySet().iterator();

         while(var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            this.field32.setRequestProperty((String)var2.getKey(), (String)var2.getValue());
         }

         if (this.field28.method27() && this.field30 != null) {
            this.field32.setDoOutput(true);
            ByteArrayOutputStream var13 = new ByteArrayOutputStream();

            try {
               var13.write(this.field30.vmethod7797());
               var13.writeTo(this.field32.getOutputStream());
            } catch (IOException var11) {
               var11.printStackTrace();
            } finally {
               if (var13 != null) {
                  try {
                     var13.close();
                  } catch (IOException var10) {
                     var10.printStackTrace();
                  }
               }

            }
         }

         this.field32.setConnectTimeout(this.field34);
         this.field32.setInstanceFollowRedirects(this.field33);
         this.field31 = true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "71873329"
   )
   boolean method37() throws IOException, SocketTimeoutException {
      if (!this.field31) {
         this.method36();
      }

      this.field32.connect();
      return this.field32.getResponseCode() == -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)Lp;",
      garbageValue = "39"
   )
   class21 method38() {
      try {
         if (!this.field31 || this.field32.getResponseCode() == -1) {
            return new class21("No REST response has been received yet.");
         }
      } catch (IOException var10) {
         this.field32.disconnect();
         return new class21("Error decoding REST response code: " + var10.getMessage());
      }

      class21 var1 = null;

      class21 var3;
      try {
         var1 = new class21(this.field32);
         return var1;
      } catch (IOException var8) {
         var3 = new class21("Error decoding REST response: " + var8.getMessage());
      } finally {
         this.field32.disconnect();
      }

      return var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-609690388"
   )
   static int method39(int var0, Script var1, boolean var2) {
      if (var0 == 6200) {
         class87.Interpreter_intStackSize -= 2;
         Client.field623 = (short)AttackOption.method602(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize]);
         if (Client.field623 <= 0) {
            Client.field623 = 256;
         }

         Client.field395 = (short)AttackOption.method602(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
         if (Client.field395 <= 0) {
            Client.field395 = 256;
         }

         return 1;
      } else if (var0 == 6201) {
         class87.Interpreter_intStackSize -= 2;
         Client.zoomHeight = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         if (Client.zoomHeight <= 0) {
            Client.zoomHeight = 256;
         }

         Client.zoomWidth = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         if (Client.zoomWidth <= 0) {
            Client.zoomWidth = 320;
         }

         return 1;
      } else if (var0 == 6202) {
         class87.Interpreter_intStackSize -= 4;
         Client.field535 = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         if (Client.field535 <= 0) {
            Client.field535 = 1;
         }

         Client.field628 = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         if (Client.field628 <= 0) {
            Client.field628 = 32767;
         } else if (Client.field628 < Client.field535) {
            Client.field628 = Client.field535;
         }

         Client.field629 = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         if (Client.field629 <= 0) {
            Client.field629 = 1;
         }

         Client.field355 = (short)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 3];
         if (Client.field355 <= 0) {
            Client.field355 = 32767;
         } else if (Client.field355 < Client.field629) {
            Client.field355 = Client.field629;
         }

         return 1;
      } else if (var0 == 6203) {
         if (Client.viewportWidget != null) {
            class143.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.viewportWidth;
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.viewportHeight;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
         }

         return 1;
      } else if (var0 == 6204) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.zoomHeight;
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.zoomWidth;
         return 1;
      } else if (var0 == 6205) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GrandExchangeEvents.method1827(Client.field623);
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GrandExchangeEvents.method1827(Client.field395);
         return 1;
      } else if (var0 == 6220) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6221) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6222) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = CollisionMap.canvasWidth;
         return 1;
      } else if (var0 == 6223) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Language.canvasHeight;
         return 1;
      } else {
         return 2;
      }
   }
}
