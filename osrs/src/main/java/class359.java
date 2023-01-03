import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mp")
public class class359 {
   @ObfuscatedName("h")
   static char[] field3568 = new char[64];
   @ObfuscatedName("e")
   static char[] field3571;
   @ObfuscatedName("v")
   static char[] field3570;
   @ObfuscatedName("x")
   static int[] field3569;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3568[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3568[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3568[var0] = (char)(var0 + 48 - 52);
      }

      field3568[62] = '+';
      field3568[63] = '/';
      field3571 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3571[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3571[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3571[var0] = (char)(var0 + 48 - 52);
      }

      field3571[62] = '*';
      field3571[63] = '-';
      field3570 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3570[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3570[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3570[var0] = (char)(var0 + 48 - 52);
      }

      field3570[62] = '-';
      field3570[63] = '_';
      field3569 = new int[128];

      for(var0 = 0; var0 < field3569.length; ++var0) {
         field3569[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3569[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3569[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3569[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3569;
      field3569[43] = 62;
      var2[42] = 62;
      int[] var1 = field3569;
      field3569[47] = 63;
      var1[45] = 63;
   }
}
