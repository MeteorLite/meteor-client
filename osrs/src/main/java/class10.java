import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class10 {
   @ObfuscatedName("gi")
   static int field35;
   @ObfuscatedName("aj")
   final HttpsURLConnection field31;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lpu;"
   )
   final class390 field29;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lar;"
   )
   final class9 field30;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lqb;"
   )
   class432 field28;
   @ObfuscatedName("an")
   boolean field34;
   @ObfuscatedName("ao")
   boolean field32;
   @ObfuscatedName("av")
   int field33;

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;Lar;Lpu;Z)V"
   )
   public class10(URL var1, class9 var2, class390 var3, boolean var4) throws IOException {
      this.field34 = false;
      this.field32 = false;
      this.field33 = 300000;
      if (!var2.method25()) {
         throw new UnsupportedEncodingException("Unsupported request method used " + var2.method26());
      } else {
         this.field31 = (HttpsURLConnection)var1.openConnection();
         if (!var4) {
            HttpsURLConnection var5 = this.field31;
            if (class15.field44 == null) {
               class15.field44 = new class15();
            }

            class15 var6 = class15.field44;
            var5.setSSLSocketFactory(var6);
         }

         this.field30 = var2;
         this.field29 = var3 != null ? var3 : new class390();
      }
   }

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;Lar;Z)V"
   )
   public class10(URL var1, class9 var2, boolean var3) throws IOException {
      this(var1, var2, new class390(), var3);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(S)Lpu;",
      garbageValue = "8183"
   )
   public class390 method30() {
      return this.field29;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lqb;B)V",
      garbageValue = "121"
   )
   public void method31(class432 var1) {
      if (!this.field34) {
         if (var1 == null) {
            this.field29.method2052("Content-Type");
            this.field28 = null;
         } else {
            this.field28 = var1;
            if (this.field28.vmethod2213() != null) {
               this.field29.method2056(this.field28.vmethod2213());
            } else {
               this.field29.method2057();
            }

         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1245579304"
   )
   void method32() throws ProtocolException {
      if (!this.field34) {
         this.field31.setRequestMethod(this.field30.method26());
         this.field29.method2049(this.field31);
         if (this.field30.method27() && this.field28 != null) {
            this.field31.setDoOutput(true);
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();

            try {
               var1.write(this.field28.vmethod7797());
               var1.writeTo(this.field31.getOutputStream());
            } catch (IOException var11) {
               var11.printStackTrace();
            } finally {
               try {
                  var1.close();
               } catch (IOException var10) {
                  var10.printStackTrace();
               }

            }
         }

         this.field31.setConnectTimeout(this.field33);
         this.field31.setInstanceFollowRedirects(this.field32);
         this.field34 = true;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-105"
   )
   boolean method33() throws IOException {
      if (!this.field34) {
         this.method32();
      }

      this.field31.connect();
      return this.field31.getResponseCode() == -1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Laf;",
      garbageValue = "2110513112"
   )
   class20 method34() {
      try {
         if (!this.field34 || this.field31.getResponseCode() == -1) {
            return new class20("No REST response has been received yet.");
         }
      } catch (IOException var10) {
         this.field31.disconnect();
         return new class20("Error decoding REST response code: " + var10.getMessage());
      }

      class20 var3;
      try {
         class20 var1 = new class20(this.field31);
         return var1;
      } catch (IOException var8) {
         var3 = new class20("Error decoding REST response: " + var8.getMessage());
      } finally {
         this.field31.disconnect();
      }

      return var3;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      descriptor = "(Lhx;IIII)V",
      garbageValue = "-793671958"
   )
   static void method35(SequenceDefinition var0, int var1, int var2, int var3) {
      if (Client.soundEffectCount < 50 && WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() != 0) {
         if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
            int var4 = var0.soundEffects[var1];
            if (var4 != 0) {
               int var7 = var4 >> 8;
               int var8 = var4 >> 4 & 7;
               int var9 = var4 & 15;
               Client.soundEffectIds[Client.soundEffectCount] = var7;
               Client.queuedSoundEffectLoops[Client.soundEffectCount] = var8;
               Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
               Client.soundEffects[Client.soundEffectCount] = null;
               int var10 = (var2 - 64) / 128;
               int var11 = (var3 - 64) / 128;
               Client.soundLocations[Client.soundEffectCount] = var9 + (var11 << 8) + (var10 << 16);
               ++Client.soundEffectCount;
            }

         }
      }
   }
}
