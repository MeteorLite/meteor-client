import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("au")
	@Export("plane")
	int plane;
	@ObfuscatedName("ae")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	@ObfuscatedName("at")
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ljg;"
	)
	@Export("paint")
	SceneTilePaint paint;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Ljv;"
	)
	@Export("model")
	SceneTileModel model;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Ljo;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Liy;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lir;"
	)
	@Export("itemLayer")
	ItemLayer itemLayer;
	@ObfuscatedName("ad")
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "[Ljy;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("al")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("an")
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("ar")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("ab")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("ag")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("am")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("ax")
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("ah")
	int field2014;
	@ObfuscatedName("as")
	int field2018;
	@ObfuscatedName("ay")
	int field2022;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lii;"
	)
	@Export("linkedBelowTile")
	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5];
		this.gameObjectEdgeMasks = new int[5];
		this.gameObjectsEdgeMask = 0;
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "-1321170330"
	)
	@Export("addImageTag")
	static String addImageTag(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)Lfv;",
		garbageValue = "-1875628936"
	)
	static class137 method1184(int var0) {
		return ClientPreferences.method571(var0) != 0 ? null : class338.method1862(var0);
	}
}