import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("GameObject")
public final class GameObject {
    @ObfuscatedName("f")
    int plane;
    @ObfuscatedName("w")
    int z;
    @ObfuscatedName("v")
    int centerX;
    @ObfuscatedName("s")
    int centerY;
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    public Renderable renderable;
    @ObfuscatedName("j")
    int orientation;
    @ObfuscatedName("i")
    int startX;
    @ObfuscatedName("n")
    int endX;
    @ObfuscatedName("l")
    int startY;
    @ObfuscatedName("k")
    int endY;
   @ObfuscatedName("c")
   int field2227;
    @ObfuscatedName("r")
    int lastDrawn;
    @ObfuscatedName("b")
    public long tag = 0L;
    @ObfuscatedName("m")
    int flags = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "71"
   )
   public static String method1310(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if (var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class31.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if (var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if (var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/String;[IIII)V",
      garbageValue = "988147954"
   )
   public static void method1309(String[] var0, int[] var1, int var2, int var3) {
      if (var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         int var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               int var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1309(var0, var1, var2, var5 - 1);
         method1309(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("mu")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "24"
   )
   static void method1308() {
      if (class136.field1293 != null) {
         Client.field660 = Client.cycle;
         class136.field1293.method1869();

         for(int var0 = 0; var0 < Client.players.length; ++var0) {
            if (Client.players[var0] != null) {
               class136.field1293.method1867((Client.players[var0].x >> 7) + ParamComposition.baseX, (Client.players[var0].y >> 7) + Client.baseY);
            }
         }
      }

   }
}
