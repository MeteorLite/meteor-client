import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class110 extends UrlRequester {
   @ObfuscatedName("ki")
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("an")
   final boolean field1138;

   public class110(boolean var1, int var2) {
      super(var2);
      this.field1138 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Leo;I)V",
      garbageValue = "1239593024"
   )
   @Export("vmethod2700")
   void vmethod2700(UrlRequest var1) throws IOException {
      URLConnection var2 = null;
      boolean var9 = false;

      HttpURLConnection var12;
      label136: {
         label128: {
            try {
               label131: {
                  var9 = true;
                  String var3 = var1.field1142.getProtocol();
                  if (var3.equals("http")) {
                     var2 = this.method637(var1);
                  } else {
                     if (!var3.equals("https")) {
                        var1.field1139 = UrlRequest.field1141;
                        var9 = false;
                        break label131;
                     }

                     var2 = this.method635(var1);
                  }

                  this.method633(var2, var1);
                  var9 = false;
                  break label136;
               }
            } catch (IOException var10) {
               var1.field1139 = UrlRequest.field1141;
               var9 = false;
               break label128;
            } finally {
               if (var9) {
                  if (var2 != null && var2 instanceof HttpURLConnection) {
                     HttpURLConnection var6 = (HttpURLConnection)var2;
                     var6.disconnect();
                  }

               }
            }

            if (var2 != null && var2 instanceof HttpURLConnection) {
               HttpURLConnection var4 = (HttpURLConnection)var2;
               var4.disconnect();
            }

            return;
         }

         if (var2 != null && var2 instanceof HttpURLConnection) {
            var12 = (HttpURLConnection)var2;
            var12.disconnect();
         }

         return;
      }

      if (var2 != null && var2 instanceof HttpURLConnection) {
         var12 = (HttpURLConnection)var2;
         var12.disconnect();
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(Leo;I)Ljava/net/URLConnection;",
      garbageValue = "-1488509554"
   )
   URLConnection method637(UrlRequest var1) throws IOException {
      URLConnection var2 = var1.field1142.openConnection();
      this.method631(var2);
      return var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Leo;I)Ljava/net/URLConnection;",
      garbageValue = "-26988696"
   )
   URLConnection method635(UrlRequest var1) throws IOException {
      HttpsURLConnection var2 = (HttpsURLConnection)var1.field1142.openConnection();
      if (!this.field1138) {
         if (class15.field44 == null) {
            class15.field44 = new class15();
         }

         class15 var4 = class15.field44;
         var2.setSSLSocketFactory(var4);
      }

      this.method631(var2);
      return var2;
   }

   @ObfuscatedName("aj")
   public static final int method639(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if (0.0D != var2) {
         double var12;
         if (var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var2 + var4 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if (var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if (var20 < 0.0D) {
            ++var20;
         }

         if (var16 * 6.0D < 1.0D) {
            var6 = var16 * 6.0D * (var12 - var14) + var14;
         } else if (var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if (var16 * 3.0D < 2.0D) {
            var6 = 6.0D * (0.6666666666666666D - var16) * (var12 - var14) + var14;
         } else {
            var6 = var14;
         }

         if (var0 * 6.0D < 1.0D) {
            var8 = 6.0D * (var12 - var14) * var0 + var14;
         } else if (var0 * 2.0D < 1.0D) {
            var8 = var12;
         } else if (var0 * 3.0D < 2.0D) {
            var8 = var14 + (0.6666666666666666D - var0) * (var12 - var14) * 6.0D;
         } else {
            var8 = var14;
         }

         if (var20 * 6.0D < 1.0D) {
            var10 = var20 * (var12 - var14) * 6.0D + var14;
         } else if (var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if (var20 * 3.0D < 2.0D) {
            var10 = 6.0D * (var12 - var14) * (0.6666666666666666D - var20) + var14;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "62279651"
   )
   public static String method640(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if (var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if (var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if (var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if (var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && var3 != 0L) {
         var3 /= 37L;
      }

      String var8 = GrandExchangeOffer.base37DecodeLong(var3);
      if (var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      descriptor = "(Lmy;III)V",
      garbageValue = "73329471"
   )
   @Export("checkIfMinimapClicked")
   static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
      if (Client.minimapState == 0 || Client.minimapState == 3) {
         if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
            SpriteMask var3 = var0.getSpriteMask(true);
            if (var3 == null) {
               return;
            }

            int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
            int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
            if (var3.contains(var4, var5)) {
               var4 -= var3.width / 2;
               var5 -= var3.height / 2;
               int var6 = Client.camAngleY & 2047;
               int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
               int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
               int var9 = var7 * var5 + var4 * var8 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + BuddyRankComparator.localPlayer.x >> 7;
               int var12 = BuddyRankComparator.localPlayer.y - var10 >> 7;
               PacketBufferNode var13 = UserComparator9.getPacketBufferNode(ClientPacket.field2457, Client.packetWriter.isaacCipher);
               var13.packetBuffer.writeByte(18);
               var13.packetBuffer.writeShortLE(var12 + class178.baseY);
               var13.packetBuffer.writeShort(var11 + GameEngine.baseX);
               var13.packetBuffer.method2467(Client.keyHandlerInstance.getKeyPressed(82) ? (Client.keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
               var13.packetBuffer.writeByte(var4);
               var13.packetBuffer.writeByte(var5);
               var13.packetBuffer.writeShort(Client.camAngleY);
               var13.packetBuffer.writeByte(57);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(89);
               var13.packetBuffer.writeShort(BuddyRankComparator.localPlayer.x);
               var13.packetBuffer.writeShort(BuddyRankComparator.localPlayer.y);
               var13.packetBuffer.writeByte(63);
               Client.packetWriter.addNode(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-726762980"
   )
   @Export("insertMenuItemNoShift")
   public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
      class351.insertMenuItem(var0, var1, var2, var3, var4, var5, -1, false);
   }
}
