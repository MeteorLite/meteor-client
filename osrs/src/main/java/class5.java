import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class5 implements class2 {
   @ObfuscatedName("h")
   final MessageDigest field14 = this.method28();

   @ObfuscatedSignature(
      descriptor = "(Lu;)V"
   )
   class5(class8 var1) {
   }

   @ObfuscatedName("h")
   boolean method24(int var1, String var2, long var3) {
      byte[] var5 = this.method25(var2, var3);
      return method33(var5) >= var1;
   }

   @ObfuscatedName("x")
   byte[] method25(String var1, long var2) {
      StringBuilder var4 = new StringBuilder();
      var4.append(var1).append(Long.toHexString(var2));
      this.field14.reset();

      try {
         this.field14.update(var4.toString().getBytes("UTF-8"));
      } catch (UnsupportedEncodingException var6) {
         var6.printStackTrace();
      }

      return this.field14.digest();
   }

   @ObfuscatedName("m")
   MessageDigest method28() {
      try {
         return MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException var2) {
         var2.printStackTrace();
         return null;
      }
   }

   @ObfuscatedName("e")
   static int method33(byte[] var0) {
      int var1 = 0;
      byte[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         byte var4 = var2[var3];
         int var5 = method26(var4);
         var1 += var5;
         if (var5 != 8) {
            break;
         }
      }

      return var1;
   }

   @ObfuscatedName("v")
   static int method26(byte var0) {
      int var1 = 0;
      if (var0 == 0) {
         var1 = 8;
      } else {
         for(int var2 = var0 & 255; (var2 & 128) == 0; var2 <<= 1) {
            ++var1;
         }
      }

      return var1;
   }
}
