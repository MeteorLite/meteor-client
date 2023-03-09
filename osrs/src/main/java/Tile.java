import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("aj")
   @Export("plane")
   int plane;
   @ObfuscatedName("al")
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @Export("originalPlane")
   int originalPlane;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lit;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lil;"
   )
   @Export("model")
   SceneTileModel model;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Ljc;"
   )
   @Export("boundaryObject")
   BoundaryObject boundaryObject;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Ljg;"
   )
   @Export("wallDecoration")
   WallDecoration wallDecoration;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lib;"
   )
   @Export("floorDecoration")
   FloorDecoration floorDecoration;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lij;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("ak")
   @Export("gameObjectsCount")
   int gameObjectsCount;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "[Ljm;"
   )
   @Export("gameObjects")
   GameObject[] gameObjects = new GameObject[5];
   @ObfuscatedName("as")
   @Export("gameObjectEdgeMasks")
   int[] gameObjectEdgeMasks = new int[5];
   @ObfuscatedName("ay")
   @Export("gameObjectsEdgeMask")
   int gameObjectsEdgeMask = 0;
   @ObfuscatedName("am")
   @Export("minPlane")
   int minPlane;
   @ObfuscatedName("az")
   @Export("drawPrimary")
   boolean drawPrimary;
   @ObfuscatedName("ae")
   @Export("drawSecondary")
   boolean drawSecondary;
   @ObfuscatedName("au")
   @Export("drawGameObjects")
   boolean drawGameObjects;
   @ObfuscatedName("ag")
   @Export("drawGameObjectEdges")
   int drawGameObjectEdges;
   @ObfuscatedName("at")
   int field1940;
   @ObfuscatedName("af")
   int field1944;
   @ObfuscatedName("ai")
   int field1950;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lid;"
   )
   @Export("linkedBelowTile")
   Tile linkedBelowTile;

   Tile(int var1, int var2, int var3) {
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-32899109"
   )
   @Export("setLoginResponseString")
   static void setLoginResponseString(String var0, String var1, String var2) {
      Login.Login_response1 = var0;
      Login.Login_response2 = var1;
      Login.Login_response3 = var2;
   }
}
