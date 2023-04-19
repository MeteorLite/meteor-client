import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("UrlRequester")
public abstract class UrlRequester implements Runnable {
    @ObfuscatedName("tk")
    @ObfuscatedSignature(
            descriptor = "Ltq;"
    )
    static SpritePixels sceneMinimapSprite;
   @ObfuscatedName("af")
   final Thread field1146 = new Thread(this);
    @ObfuscatedName("an")
    volatile boolean isClosed;
    @ObfuscatedName("aw")
    Queue requests = new LinkedList();
   @ObfuscatedName("ac")
   int field1145;

   UrlRequester(int var1) {
      this.field1146.setPriority(1);
      this.field1146.start();
      this.field1145 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lez;B)V",
            garbageValue = "16"
    )
    abstract void vmethod2700(UrlRequest var1) throws IOException;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URLConnection;I)I",
      garbageValue = "-730727375"
   )
   int method665(URLConnection var1) {
      int var2 = UrlRequest.field1150;
      if (var1 != null) {
         try {
            if (var1 instanceof HttpURLConnection) {
               var2 = ((HttpURLConnection)var1).getResponseCode();
            }
         } catch (IOException var4) {
            ;
         }
      }

      return var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URLConnection;I)V",
      garbageValue = "-218004174"
   )
   void method668(URLConnection var1) {
      var1.setConnectTimeout(5000);
      var1.setReadTimeout(5000);
      var1.setUseCaches(false);
      var1.setRequestProperty("Connection", "close");
      var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1145);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URLConnection;Lez;B)V",
      garbageValue = "1"
   )
   void method669(URLConnection var1, UrlRequest var2) {
      DataInputStream var3 = null;

      try {
         int var5 = var1.getContentLength();
         var3 = new DataInputStream(var1.getInputStream());
         byte[] var4;
         if (var5 >= 0) {
            var4 = new byte[var5];
            var3.readFully(var4);
         } else {
            var4 = new byte[0];
            byte[] var6 = AbstractWorldMapData.ByteArrayPool_getArray(5000);

            byte[] var8;
            for(int var7 = var3.read(var6, 0, var6.length); var7 > -1; var4 = var8) {
               var8 = new byte[var4.length + var7];
               System.arraycopy(var4, 0, var8, 0, var4.length);
               System.arraycopy(var6, 0, var8, var4.length, var7);
            }

            InterfaceParent.ByteArrayPool_release(var6);
         }

         var2.response0 = var4;
      } catch (IOException var14) {
         var2.response0 = null;
      } finally {
         var2.field1149 = this.method665(var1);
      }

      if (var3 != null) {
         try {
            var3.close();
         } catch (IOException var13) {
            ;
         }
      }

   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(Ljava/net/URL;I)Lez;",
            garbageValue = "-73486264"
    )
    public UrlRequest request(URL var1) {
      UrlRequest var2 = new UrlRequest(var1);
      synchronized(this) {
         this.requests.add(var2);
         this.notify();
         return var2;
      }
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1770460847"
    )
    public void close() {
      this.isClosed = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field1146.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

    @ObfuscatedName("run")
    public void run() {
      while(!this.isClosed) {
         try {
            UrlRequest var1;
            synchronized(this) {
               var1 = (UrlRequest)this.requests.poll();
               if (var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var5) {
                     ;
                  }
                  continue;
               }
            }

            this.vmethod2700(var1);
         } catch (Exception var7) {
            class387.RunException_sendStackTrace((String)null, var7);
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "46"
   )
   static boolean method671(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+') {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               return false;
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "([FI)V",
      garbageValue = "-166868527"
   )
   static void method670(float[] var0) {
      if (class121.field1180 + var0[0] < 1.3333334F) {
         float var1 = var0[0] - 2.0F;
         float var2 = var0[0] - 1.0F;
         float var3 = (float)Math.sqrt((double)(var1 * var1 - var2 * var2 * 4.0F));
         float var4 = 0.5F * (-var1 + var3);
         if (class121.field1180 + var0[1] > var4) {
            var0[1] = var4 - class121.field1180;
         } else {
            var4 = 0.5F * (-var1 - var3);
            if (var0[1] < class121.field1180 + var4) {
               var0[1] = var4 + class121.field1180;
            }
         }
      } else {
         var0[0] = 1.3333334F - class121.field1180;
         var0[1] = 0.33333334F - class121.field1180;
      }

   }
}
