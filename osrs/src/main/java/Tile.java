import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("f")
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @Export("originalPlane")
   int originalPlane;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lhc;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lhj;"
   )
   @Export("model")
   SceneTileModel model;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lhg;"
   )
   @Export("boundaryObject")
   BoundaryObject boundaryObject;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lij;"
   )
   @Export("wallDecoration")
   WallDecoration wallDecoration;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lhq;"
   )
   @Export("floorDecoration")
   FloorDecoration floorDecoration;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lhi;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("c")
   @Export("gameObjectsCount")
   int gameObjectsCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "[Liu;"
   )
   @Export("gameObjects")
   GameObject[] gameObjects = new GameObject[5];
   @ObfuscatedName("b")
   @Export("gameObjectEdgeMasks")
   int[] gameObjectEdgeMasks = new int[5];
   @ObfuscatedName("m")
   @Export("gameObjectsEdgeMask")
   int gameObjectsEdgeMask = 0;
   @ObfuscatedName("t")
   @Export("minPlane")
   int minPlane;
   @ObfuscatedName("h")
   @Export("drawPrimary")
   boolean drawPrimary;
   @ObfuscatedName("p")
   @Export("drawSecondary")
   boolean drawSecondary;
   @ObfuscatedName("o")
   @Export("drawGameObjects")
   boolean drawGameObjects;
   @ObfuscatedName("u")
   @Export("drawGameObjectEdges")
   int drawGameObjectEdges;
   @ObfuscatedName("x")
   int field1954;
   @ObfuscatedName("a")
   int field1944;
   @ObfuscatedName("q")
   int field1959;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "Lhy;"
   )
   @Export("linkedBelowTile")
   Tile linkedBelowTile;

   Tile(int var1, int var2, int var3) {
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
