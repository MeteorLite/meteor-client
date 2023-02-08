import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mr")
public class class363 {
   @ObfuscatedName("f")
   public static char[] field3571 = new char[64];
   @ObfuscatedName("w")
   static char[] field3572;
   @ObfuscatedName("v")
   static char[] field3573;
   @ObfuscatedName("s")
   static int[] field3570;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3571[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3571[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3571[var0] = (char)(var0 + 48 - 52);
      }

      field3571[62] = '+';
      field3571[63] = '/';
      field3572 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3572[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3572[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3572[var0] = (char)(var0 + 48 - 52);
      }

      field3572[62] = '*';
      field3572[63] = '-';
      field3573 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3573[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3573[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3573[var0] = (char)(var0 + 48 - 52);
      }

      field3573[62] = '-';
      field3573[63] = '_';
      field3570 = new int[128];

      for(var0 = 0; var0 < field3570.length; ++var0) {
         field3570[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3570[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3570[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3570[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3570;
      field3570[43] = 62;
      var2[42] = 62;
      int[] var1 = field3570;
      field3570[47] = 63;
      var1[45] = 63;
   }
}
