import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("tx")
   static int cameraMoveToAcceleration;
   @ObfuscatedName("h")
   int plane;
   @ObfuscatedName("e")
   int x;
   @ObfuscatedName("v")
   int y;
   @ObfuscatedName("x")
   int originalPlane;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lhj;"
   )
   SceneTilePaint paint;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhy;"
   )
   SceneTileModel model;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lhq;"
   )
   BoundaryObject boundaryObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lhb;"
   )
   WallDecoration wallDecoration;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lhs;"
   )
   FloorDecoration floorDecoration;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lgy;"
   )
   ItemLayer itemLayer;
   @ObfuscatedName("j")
   int gameObjectsCount;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "[Lhp;"
   )
   GameObject[] gameObjects = new GameObject[5];
   @ObfuscatedName("i")
   int[] gameObjectEdgeMasks = new int[5];
   @ObfuscatedName("o")
   int gameObjectsEdgeMask = 0;
   @ObfuscatedName("n")
   int minPlane;
   @ObfuscatedName("k")
   boolean drawPrimary;
   @ObfuscatedName("a")
   boolean drawSecondary;
   @ObfuscatedName("s")
   boolean drawGameObjects;
   @ObfuscatedName("l")
   int drawGameObjectEdges;
   @ObfuscatedName("t")
   int field1957;
   @ObfuscatedName("c")
   int field1950;
   @ObfuscatedName("p")
   int field1959;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Lhe;"
   )
   Tile linkedBelowTile;

   Tile(int var1, int var2, int var3) {
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/CharSequence;IIB)Ljava/lang/String;",
      garbageValue = "-54"
   )
   public static String method1140(CharSequence[] var0, int var1, int var2) {
      if (var2 == 0) {
         return "";
      } else if (var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null ? "null" : var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if (var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if (var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1595440207"
   )
   static void savePreferences() {
      AccessFile var0 = null;

      try {
         var0 = class87.getPreferencesFile("", LoginPacket.field2681.name, true);
         Buffer var1 = StructComposition.clientPreferences.toBuffer();
         var0.write(var1.array, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if (var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
