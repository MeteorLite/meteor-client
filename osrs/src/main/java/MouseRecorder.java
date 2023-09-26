import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("ac")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("al")
	@Export("lock")
	Object lock;
	@ObfuscatedName("ak")
	@Export("index")
	int index;
	@ObfuscatedName("ax")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("ao")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("ah")
	@Export("millis")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		for (; this.isRunning; Players.method623(50L)) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-2055845886"
	)
	static int method476(int var0) {
		return class28.KeyHandler_keyCodes[var0];
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "258753092"
	)
	static int method475(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIILjt;Lih;I)V",
		garbageValue = "-737190520"
	)
	static final void method477(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap var9) {
		ObjectComposition var10 = class91.getObjectDefinition(var4);
		int var11 = var7 >= 0 ? var7 : var10.animationId * -1053143457 * 1992396191;
		int var12;
		int var13;
		if (var5 != 1 && var5 != 3) {
			var12 = var10.sizeX;
			var13 = var10.sizeY;
		} else {
			var12 = var10.sizeY;
			var13 = var10.sizeX;
		}

		int var14;
		int var15;
		if (var12 + var2 <= 104) {
			var14 = (var12 >> 1) + var2;
			var15 = var2 + (var12 + 1 >> 1);
		} else {
			var14 = var2;
			var15 = var2 + 1;
		}

		int var16;
		int var17;
		if (var3 + var13 <= 104) {
			var16 = var3 + (var13 >> 1);
			var17 = var3 + (var13 + 1 >> 1);
		} else {
			var16 = var3;
			var17 = var3 + 1;
		}

		int[][] var18 = Tiles.Tiles_heights[var1];
		int var19 = var18[var15][var17] + var18[var14][var16] + var18[var15][var16] + var18[var14][var17] >> 2;
		int var20 = (var2 << 7) + (var12 << 6);
		int var21 = (var3 << 7) + (var13 << 6);
		long var22 = GrandExchangeOfferAgeComparator.calculateTag(var2, var3, 2, var10.int1 == 0, var4);
		int var24 = (var5 << 6) + var6;
		if (var10.int3 == 1) {
			var24 += 256;
		}

		Object var25;
		if (var6 == 22) {
			if (var11 == -1 && var10.transforms == null) {
				var25 = var10.getModel(22, var5, var18, var20, var19, var21);
			} else {
				var25 = new DynamicObject(var4, 22, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
			}

			var8.newFloorDecoration(var0, var2, var3, var19, (Renderable)var25, var22, var24);
			if (var10.interactType == 1) {
				var9.setBlockedByFloorDec(var2, var3);
			}

		} else if (var6 != 10 && var6 != 11) {
			if (var6 >= 12) {
				if (var11 == -1 && var10.transforms == null) {
					var25 = var10.getModel(var6, var5, var18, var20, var19, var21);
				} else {
					var25 = new DynamicObject(var4, var6, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
				}

				var8.method1287(var0, var2, var3, var19, 1, 1, (Renderable)var25, 0, var22, var24);
				if (var10.interactType != 0) {
					var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
				}

			} else if (var6 == 0) {
				if (var11 == -1 && var10.transforms == null) {
					var25 = var10.getModel(0, var5, var18, var20, var19, var21);
				} else {
					var25 = new DynamicObject(var4, 0, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
				}

				var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field844[var5], 0, var22, var24);
				if (var10.interactType != 0) {
					var9.method1156(var2, var3, var6, var5, var10.boolean1);
				}

			} else if (var6 == 1) {
				if (var11 == -1 && var10.transforms == null) {
					var25 = var10.getModel(1, var5, var18, var20, var19, var21);
				} else {
					var25 = new DynamicObject(var4, 1, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
				}

				var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field843[var5], 0, var22, var24);
				if (var10.interactType != 0) {
					var9.method1156(var2, var3, var6, var5, var10.boolean1);
				}

			} else {
				int var31;
				if (var6 == 2) {
					var31 = var5 + 1 & 3;
					Object var26;
					Object var27;
					if (var11 == -1 && var10.transforms == null) {
						var26 = var10.getModel(2, var5 + 4, var18, var20, var19, var21);
						var27 = var10.getModel(2, var31, var18, var20, var19, var21);
					} else {
						var26 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
						var27 = new DynamicObject(var4, 2, var31, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
					}

					var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var26, (Renderable)var27, Tiles.field844[var5], Tiles.field844[var31], var22, var24);
					if (var10.interactType != 0) {
						var9.method1156(var2, var3, var6, var5, var10.boolean1);
					}

				} else if (var6 == 3) {
					if (var11 == -1 && var10.transforms == null) {
						var25 = var10.getModel(3, var5, var18, var20, var19, var21);
					} else {
						var25 = new DynamicObject(var4, 3, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
					}

					var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field843[var5], 0, var22, var24);
					if (var10.interactType != 0) {
						var9.method1156(var2, var3, var6, var5, var10.boolean1);
					}

				} else if (var6 == 9) {
					if (var11 == -1 && var10.transforms == null) {
						var25 = var10.getModel(var6, var5, var18, var20, var19, var21);
					} else {
						var25 = new DynamicObject(var4, var6, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
					}

					var8.method1287(var0, var2, var3, var19, 1, 1, (Renderable)var25, 0, var22, var24);
					if (var10.interactType != 0) {
						var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
					}

				} else if (var6 == 4) {
					if (var11 == -1 && var10.transforms == null) {
						var25 = var10.getModel(4, var5, var18, var20, var19, var21);
					} else {
						var25 = new DynamicObject(var4, 4, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
					}

					var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field844[var5], 0, 0, 0, var22, var24);
				} else {
					Object var28;
					long var32;
					if (var6 == 5) {
						var31 = 16;
						var32 = var8.getBoundaryObjectTag(var0, var2, var3);
						if (0L != var32) {
							var31 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var32)).int2;
						}

						if (var11 == -1 && var10.transforms == null) {
							var28 = var10.getModel(4, var5, var18, var20, var19, var21);
						} else {
							var28 = new DynamicObject(var4, 4, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
						}

						var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)null, Tiles.field844[var5], 0, var31 * Tiles.field847[var5], var31 * Tiles.field845[var5], var22, var24);
					} else if (var6 == 6) {
						var31 = 8;
						var32 = var8.getBoundaryObjectTag(var0, var2, var3);
						if (0L != var32) {
							var31 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var32)).int2 / 2;
						}

						if (var11 == -1 && var10.transforms == null) {
							var28 = var10.getModel(4, var5 + 4, var18, var20, var19, var21);
						} else {
							var28 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
						}

						var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)null, 256, var5, var31 * Tiles.field848[var5], var31 * Tiles.field846[var5], var22, var24);
					} else if (var6 == 7) {
						int var34 = var5 + 2 & 3;
						if (var11 == -1 && var10.transforms == null) {
							var25 = var10.getModel(4, var34 + 4, var18, var20, var19, var21);
						} else {
							var25 = new DynamicObject(var4, 4, var34 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
						}

						var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, 256, var34, 0, 0, var22, var24);
					} else if (var6 == 8) {
						var31 = 8;
						var32 = var8.getBoundaryObjectTag(var0, var2, var3);
						if (0L != var32) {
							var31 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var32)).int2 / 2;
						}

						int var30 = var5 + 2 & 3;
						Object var29;
						if (var11 == -1 && var10.transforms == null) {
							var28 = var10.getModel(4, var5 + 4, var18, var20, var19, var21);
							var29 = var10.getModel(4, var30 + 4, var18, var20, var19, var21);
						} else {
							var28 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
							var29 = new DynamicObject(var4, 4, var30 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
						}

						var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)var29, 256, var5, var31 * Tiles.field848[var5], var31 * Tiles.field846[var5], var22, var24);
					}
				}
			}
		} else {
			if (var11 == -1 && var10.transforms == null) {
				var25 = var10.getModel(10, var5, var18, var20, var19, var21);
			} else {
				var25 = new DynamicObject(var4, 10, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
			}

			if (var25 != null) {
				var8.method1287(var0, var2, var3, var19, var12, var13, (Renderable)var25, var6 == 11 ? 256 : 0, var22, var24);
			}

			if (var10.interactType != 0) {
				var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
			}

		}
	}

	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		descriptor = "(IIZI)V",
		garbageValue = "-1742769560"
	)
	static final void method478(int var0, int var1, boolean var2) {
		if (!var2 || var0 != class94.timeOfPreviousKeyPress || class365.field3199 != var1) {
			class94.timeOfPreviousKeyPress = var0;
			class365.field3199 = var1;
			DefaultsGroup.updateGameState(25);
			class427.drawLoadingMessage("Loading - please wait.", true);
			int var3 = class20.baseX;
			int var4 = class19.baseY;
			class20.baseX = (var0 - 6) * 8;
			class19.baseY = (var1 - 6) * 8;
			int var5 = class20.baseX - var3;
			int var6 = class19.baseY - var4;
			var3 = class20.baseX;
			var4 = class19.baseY;

			int var7;
			int var9;
			int[] var10000;
			for (var7 = 0; var7 < 65536; ++var7) {
				NPC var8 = Client.npcs[var7];
				if (var8 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var8.pathX;
						var10000[var9] -= var5;
						var10000 = var8.pathY;
						var10000[var9] -= var6;
					}

					var8.x -= var5 * 128;
					var8.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var21.pathX;
						var10000[var9] -= var5;
						var10000 = var21.pathY;
						var10000[var9] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var20 = 0;
			byte var18 = 104;
			byte var22 = 1;
			if (var5 < 0) {
				var20 = 103;
				var18 = -1;
				var22 = -1;
			}

			byte var10 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var6 < 0) {
				var10 = 103;
				var11 = -1;
				var12 = -1;
			}

			int var14;
			for (int var13 = var20; var18 != var13; var13 += var22) {
				for (var14 = var10; var14 != var11; var14 += var12) {
					int var15 = var5 + var13;
					int var16 = var6 + var14;

					for (int var17 = 0; var17 < 4; ++var17) {
						if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
							Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
						} else {
							Client.groundItems[var17][var13][var14] = null;
						}
					}
				}
			}

			for (PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
				var19.x -= var5;
				var19.y -= var6;
				if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
					var19.remove();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.isCameraLocked = false;
			Client.cameraX -= var5 << 7;
			WorldMapArea.cameraZ -= var6 << 7;
			ChatChannel.oculusOrbFocalPointX -= var5 << 7;
			AbstractWorldMapData.oculusOrbFocalPointY -= var6 << 7;
			Client.field539 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}

	@ObfuscatedName("np")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)I",
		garbageValue = "-1186602538"
	)
	@Export("getWidgetFlags")
	static int getWidgetFlags(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.childIndex + ((long)var0.id << 32));
		return var1 != null ? var1.integer : var0.flags;
	}
}