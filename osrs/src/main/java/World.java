import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("World")
public class World {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "[Lbz;"
   )
   static World[] World_worlds;
   @ObfuscatedName("q")
   static int World_count = 0;
   @ObfuscatedName("f")
   static int World_listCount = 0;
   @ObfuscatedName("r")
   static int[] World_sortOption2 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("u")
   static int[] World_sortOption1 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] headIconPkSprites;
   @ObfuscatedName("j")
   int id;
   @ObfuscatedName("g")
   int properties;
   @ObfuscatedName("i")
   int population;
   @ObfuscatedName("o")
   String host;
   @ObfuscatedName("n")
   String activity;
   @ObfuscatedName("k")
   int location;
   @ObfuscatedName("a")
   int index;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "475623933"
   )
   boolean isMembersOnly() {
      return (1 & this.properties) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2088011917"
   )
   boolean method389() {
      return (2 & this.properties) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "80"
   )
   boolean isPvp() {
      return (4 & this.properties) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1129666838"
   )
   boolean method386() {
      return (8 & this.properties) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1842559739"
   )
   boolean isDeadman() {
      return (536870912 & this.properties) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1891731193"
   )
   boolean isBeta() {
      return (33554432 & this.properties) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "7"
   )
   boolean method394() {
      return (1073741824 & this.properties) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "19"
   )
   boolean method393() {
      return (256 & this.properties) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1936366564"
   )
   boolean method388() {
      return (134217728 & this.properties) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([Lme;II)Lme;",
      garbageValue = "64778385"
   )
   public static class345 findEnumerated(class345[] var0, int var1) {
      class345[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class345 var4 = var2[var3];
         if (var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "100"
   )
   static final int method392(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class143.method763(var3, var5);
      int var8 = class143.method763(var3 + 1, var5);
      int var9 = class143.method763(var3, var5 + 1);
      int var10 = class143.method763(var3 + 1, var5 + 1);
      int var11 = MouseHandler.method183(var7, var8, var4, var2);
      int var12 = MouseHandler.method183(var9, var10, var4, var2);
      return MouseHandler.method183(var11, var12, var6, var2);
   }
}
