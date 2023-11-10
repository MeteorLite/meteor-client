import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("at")
	@Export("plane")
	int plane;
	@ObfuscatedName("ah")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lke;"
	)
	@Export("paint")
	SceneTilePaint paint;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lkl;"
	)
	@Export("model")
	SceneTileModel model;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lkm;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lkj;"
	)
	@Export("itemLayer")
	ItemLayer itemLayer;
	@ObfuscatedName("ap")
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "[Lle;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("ax")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("as")
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("ay")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("ak")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("aj")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("am")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("aq")
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("ai")
	int field2196;
	@ObfuscatedName("aw")
	int field2203;
	@ObfuscatedName("ae")
	int field2194;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lkv;"
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

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1636778707"
	)
	static void method1412() {
		for (class222 var0 = (class222)Client.field625.last(); var0 != null; var0 = (class222)Client.field625.previous()) {
			var0.remove();
		}

	}
}