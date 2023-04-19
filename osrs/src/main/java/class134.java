import java.util.Collections;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public enum class134 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1291(0, 0),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1298(1, 1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1290(2, 2),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1293(3, 3),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1288(4, 4),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1292(5, 5),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1289(6, 6),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1294(7, 7),
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   field1295(8, 8);

   @ObfuscatedName("aa")
   final int field1296;
   @ObfuscatedName("ay")
   final int field1297;

   class134(int var3, int var4) {
      this.field1296 = var3;
      this.field1297 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field1297;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([I[II)V",
      garbageValue = "-1476012206"
   )
   public static void method782(int[] var0, int[] var1) {
      if (var0 != null && var1 != null) {
         ClanChannel.ByteArrayPool_alternativeSizes = var0;
         class136.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
         UserComparator3.ByteArrayPool_arrays = new byte[var0.length][][];

         for(int var2 = 0; var2 < ClanChannel.ByteArrayPool_alternativeSizes.length; ++var2) {
            UserComparator3.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
            ByteArrayPool.field3662.add(var0[var2]);
         }

         Collections.sort(ByteArrayPool.field3662);
      } else {
         ClanChannel.ByteArrayPool_alternativeSizes = null;
         class136.ByteArrayPool_altSizeArrayCounts = null;
         UserComparator3.ByteArrayPool_arrays = null;
         class273.method1570();
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "0"
   )
   public static int method780(int var0, int var1, int var2) {
      int var3 = class140.method806(var2 - var1 + 1);
      var3 <<= var1;
      var0 |= var3;
      return var0;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(CB)Z",
            garbageValue = "3"
    )
    public static boolean isCharAlphabetic(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("oi")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "68"
   )
   static boolean method779() {
      return class20.clientPreferences.method575() >= Client.param21;
   }
}
