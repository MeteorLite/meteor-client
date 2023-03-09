import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rf")
public class class467 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lrf;"
   )
   public static final class467 field3950 = new class467(0, 0, Integer.class, new class464());
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lrf;"
   )
   public static final class467 field3945 = new class467(1, 1, Long.class, new class466());
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lrf;"
   )
   public static final class467 field3949 = new class467(2, 2, String.class, new class468());
   @ObfuscatedName("ab")
   public final int field3946;
   @ObfuscatedName("an")
   public final int field3947;
   @ObfuscatedName("ao")
   public final Class field3944;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lrj;"
   )
   final class463 field3948;

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/Class;Lrj;)V"
   )
   class467(int var1, int var2, Class var3, class463 var4) {
      this.field3946 = var1;
      this.field3947 = var2;
      this.field3944 = var3;
      this.field3948 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field3947;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)Ljava/lang/Object;",
      garbageValue = "-680543053"
   )
   public Object method2362(Buffer var1) {
      return this.field3948.vmethod8273(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "83"
   )
   public static int method2368(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lew;FB)F",
      garbageValue = "33"
   )
   static float method2360(class127 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2 = var1 - var0.field1207;
         return var0.field1202 + var2 * (var2 * (var2 * var0.field1223 + var0.field1208) + var0.field1209);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)[Lrf;",
      garbageValue = "79"
   )
   public static class467[] method2367() {
      return new class467[]{field3950, field3949, field3945};
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;B)Lrf;",
      garbageValue = "-2"
   )
   public static class467 method2365(Class var0) {
      class467[] var1 = method2367();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class467 var3 = var1[var2];
         if (var3.field3944 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Lsy;B)V",
      garbageValue = "32"
   )
   public static void method2366(Object var0, Buffer var1) {
      class463 var2 = method2364(var0.getClass());
      var2.vmethod8274(var0, var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;B)Lrj;",
      garbageValue = "-18"
   )
   static class463 method2364(Class var0) {
      class467[] var2 = method2367();
      int var3 = 0;

      class467 var1;
      while(true) {
         if (var3 >= var2.length) {
            var1 = null;
            break;
         }

         class467 var4 = var2[var3];
         if (var4.field3944 == var0) {
            var1 = var4;
            break;
         }

         ++var3;
      }

      if (var1 == null) {
         throw new IllegalArgumentException();
      } else {
         return var1.field3948;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)Lcz;",
      garbageValue = "306318319"
   )
   @Export("getNextWorldListWorld")
   static World getNextWorldListWorld() {
      return World.World_listCount < World.World_count ? class260.World_worlds[++World.World_listCount - 1] : null;
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      descriptor = "(B)Lrc;",
      garbageValue = "-64"
   )
   @Export("getWorldMap")
   static WorldMap getWorldMap() {
      return WorldMapData_1.worldMap;
   }
}
