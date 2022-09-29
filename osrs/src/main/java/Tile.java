import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("pq")
	@ObfuscatedGetter(
		intValue = -1447414295
	)
	static int field2344;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1115103641
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1271850871
	)
	@Export("x")
	int x;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 622993199
	)
	@Export("y")
	int y;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 377528605
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lhj;"
	)
	@Export("paint")
	SceneTilePaint paint;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lhm;"
	)
	@Export("model")
	SceneTileModel model;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lhc;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Lhu;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Lgi;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lgc;"
	)
	@Export("itemLayer")
	ItemLayer itemLayer;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1915552999
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "[Lhd;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("h")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 713976971
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1676001773
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("d")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("b")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("a")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -952901597
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 879436659
	)
	int field2363;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 324890351
	)
	int field2364;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 2010185507
	)
	int field2365;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "Lgf;"
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

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "-9"
	)
	static final void method4128(int var0, int var1, int var2) {
		if (TaskHandler.cameraX < var0) {
			TaskHandler.cameraX = (var0 - TaskHandler.cameraX) * UserComparator6.field1398 / 1000 + TaskHandler.cameraX + ObjectSound.field832;
			if (TaskHandler.cameraX > var0) {
				TaskHandler.cameraX = var0;
			}
		}

		if (TaskHandler.cameraX > var0) {
			TaskHandler.cameraX -= (TaskHandler.cameraX - var0) * UserComparator6.field1398 / 1000 + ObjectSound.field832;
			if (TaskHandler.cameraX < var0) {
				TaskHandler.cameraX = var0;
			}
		}

		if (SecureRandomFuture.cameraY < var1) {
			SecureRandomFuture.cameraY = (var1 - SecureRandomFuture.cameraY) * UserComparator6.field1398 / 1000 + SecureRandomFuture.cameraY + ObjectSound.field832;
			if (SecureRandomFuture.cameraY > var1) {
				SecureRandomFuture.cameraY = var1;
			}
		}

		if (SecureRandomFuture.cameraY > var1) {
			SecureRandomFuture.cameraY -= (SecureRandomFuture.cameraY - var1) * UserComparator6.field1398 / 1000 + ObjectSound.field832;
			if (SecureRandomFuture.cameraY < var1) {
				SecureRandomFuture.cameraY = var1;
			}
		}

		if (ApproximateRouteStrategy.cameraZ < var2) {
			ApproximateRouteStrategy.cameraZ = (var2 - ApproximateRouteStrategy.cameraZ) * UserComparator6.field1398 / 1000 + ApproximateRouteStrategy.cameraZ + ObjectSound.field832;
			if (ApproximateRouteStrategy.cameraZ > var2) {
				ApproximateRouteStrategy.cameraZ = var2;
			}
		}

		if (ApproximateRouteStrategy.cameraZ > var2) {
			ApproximateRouteStrategy.cameraZ -= (ApproximateRouteStrategy.cameraZ - var2) * UserComparator6.field1398 / 1000 + ObjectSound.field832;
			if (ApproximateRouteStrategy.cameraZ < var2) {
				ApproximateRouteStrategy.cameraZ = var2;
			}
		}

	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		descriptor = "([Lkw;II)V",
		garbageValue = "-468512104"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !class11.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && class11.isComponentHidden(var3) && var3 != class148.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						class260.method5339(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var8 = class264.runCs1(var3);
						if (var8) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = class4.SequenceDefinition_get(var5);
							if (!var6.isCachedModelIdSet()) {
								for (var3.modelFrameCycle += Client.field743; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class403.invalidateWidget(var3)) {
									var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
									++var3.modelFrame;
									if (var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame -= var6.frameCount;
										if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
											var3.modelFrame = 0;
										}
									}
								}
							} else {
								var3.modelFrame += Client.field743;
								int var7 = var6.method3950();
								if (var3.modelFrame >= var7) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var7) {
										var3.modelFrame = 0;
									}
								}

								class403.invalidateWidget(var3);
							}
						}
					}

					if (var3.field3451 != 0 && !var3.isIf3) {
						int var9 = var3.field3451 >> 16;
						var5 = var3.field3451 << 16 >> 16;
						var9 *= Client.field743;
						var5 *= Client.field743;
						var3.modelAngleX = var9 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						class403.invalidateWidget(var3);
					}
				}
			}
		}

	}
}
