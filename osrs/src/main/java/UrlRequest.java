import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("an")
   static int field1151 = -1;
   @ObfuscatedName("aw")
   static int field1150 = -2;
   @ObfuscatedName("at")
   public static int field1154;
   @ObfuscatedName("af")
   final URL field1152;
   @ObfuscatedName("ac")
   volatile int field1149;
    @ObfuscatedName("au")
    volatile byte[] response0;

   UrlRequest(URL var1) {
      this.field1149 = field1151;
      this.field1152 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "-54"
    )
    public boolean isDone() {
      return this.field1149 != field1151;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)[B",
            garbageValue = "76"
    )
    public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "82"
   )
   public String method679() {
      return this.field1152.toString();
   }

    @ObfuscatedName("ac")
    static int Rasterizer3D_brighten(int var0, double var1) {
      double var3 = (double)(var0 >> 16) / 256.0D;
      double var5 = (double)(var0 >> 8 & 255) / 256.0D;
      double var7 = (double)(var0 & 255) / 256.0D;
      var3 = Math.pow(var3, var1);
      var5 = Math.pow(var5, var1);
      var7 = Math.pow(var7, var1);
      int var9 = (int)(var3 * 256.0D);
      int var10 = (int)(var5 * 256.0D);
      int var11 = (int)(var7 * 256.0D);
      return var11 + (var10 << 8) + (var9 << 16);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-560341895"
   )
   static void method680() {
      class129.method763(24);
      class205.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
   }
}
