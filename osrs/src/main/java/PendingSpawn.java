import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("rg")
	@ObfuscatedSignature(
		descriptor = "Lew;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("aw")
	@Export("plane")
	int plane;
	@ObfuscatedName("ay")
	@Export("type")
	int type;
	@ObfuscatedName("ar")
	@Export("x")
	int x;
	@ObfuscatedName("am")
	@Export("y")
	int y;
	@ObfuscatedName("as")
	@Export("objectId")
	int objectId;
	@ObfuscatedName("aj")
	int field945;
	@ObfuscatedName("ag")
	int field943;
	@ObfuscatedName("az")
	@Export("id")
	int id;
	@ObfuscatedName("av")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ap")
	@Export("objectType")
	int objectType;
	@ObfuscatedName("aq")
	int field948;
	@ObfuscatedName("ah")
	int field944;
	@ObfuscatedName("ax")
	@Export("startCycle")
	int startCycle;
	@ObfuscatedName("aa")
	@Export("endCycle")
	int endCycle;

	PendingSpawn() {
		this.field944 = 31;
		this.startCycle = 0;
		this.endCycle = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2117178902"
	)
	void method509(int var1) {
		this.field944 = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1391421037"
	)
	boolean method510(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field944 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Lnw;",
		garbageValue = "-1780334162"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_normal, PlayerType.field3484, PlayerType.field3472, PlayerType.field3473, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_ironman, PlayerType.field3483, PlayerType.field3474, PlayerType.PlayerType_ultimateIronman, PlayerType.field3475, PlayerType.field3479, PlayerType.PlayerType_playerModerator, PlayerType.field3482, PlayerType.field3486, PlayerType.field3488, PlayerType.field3478};
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIIIIILiz;Lij;I)V",
		garbageValue = "235941196"
	)
	@Export("addObjects")
	static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectComposition var8 = class90.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = BufferedNetSocket.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			if (var8.hasSound()) {
				GrandExchangeOfferOwnWorldComparator.method353(var0, var1, var2, var8, var4);
			}

			Object var22;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Renderable)var22, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else {
				int var31;
				if (var5 != 10 && var5 != 11) {
					int[] var10000;
					if (var5 >= 12) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.method1221(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
						if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
							var10000 = BufferedNetSocket.field3806[var0][var1];
							var10000[var2] |= 2340;
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

					} else if (var5 == 0) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field840[var4], 0, var19, var21);
						if (var4 == 0) {
							if (var8.clipped) {
								InvDefinition.field1488[var0][var1][var2] = 50;
								InvDefinition.field1488[var0][var1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = BufferedNetSocket.field3806[var0][var1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 1) {
							if (var8.clipped) {
								InvDefinition.field1488[var0][var1][var2 + 1] = 50;
								InvDefinition.field1488[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = BufferedNetSocket.field3806[var0][var1];
								var10000[var2 + 1] |= 1170;
							}
						} else if (var4 == 2) {
							if (var8.clipped) {
								InvDefinition.field1488[var0][var1 + 1][var2] = 50;
								InvDefinition.field1488[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = BufferedNetSocket.field3806[var0][var1 + 1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 3) {
							if (var8.clipped) {
								InvDefinition.field1488[var0][var1][var2] = 50;
								InvDefinition.field1488[var0][var1 + 1][var2] = 50;
							}

							if (var8.modelClipped) {
								var10000 = BufferedNetSocket.field3806[var0][var1];
								var10000[var2] |= 1170;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1093(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method1227(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 1) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field844[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								InvDefinition.field1488[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								InvDefinition.field1488[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								InvDefinition.field1488[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								InvDefinition.field1488[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1093(var1, var2, var5, var4, var8.boolean1);
						}

					} else {
						int var28;
						if (var5 == 2) {
							var28 = var4 + 1 & 3;
							Object var23;
							Object var24;
							if (var8.animationId == -1 && var8.transforms == null) {
								var23 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
								var24 = var8.getEntity(2, var28, var15, var17, var16, var18);
							} else {
								var23 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								var24 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, Tiles.field840[var4], Tiles.field840[var28], var19, var21);
							if (var8.modelClipped) {
								if (var4 == 0) {
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2] |= 585;
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2 + 1] |= 1170;
								} else if (var4 == 1) {
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2 + 1] |= 1170;
									var10000 = BufferedNetSocket.field3806[var0][var1 + 1];
									var10000[var2] |= 585;
								} else if (var4 == 2) {
									var10000 = BufferedNetSocket.field3806[var0][var1 + 1];
									var10000[var2] |= 585;
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2] |= 1170;
								} else if (var4 == 3) {
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2] |= 1170;
									var10000 = BufferedNetSocket.field3806[var0][var1];
									var10000[var2] |= 585;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method1093(var1, var2, var5, var4, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method1227(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 3) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field844[var4], 0, var19, var21);
							if (var8.clipped) {
								if (var4 == 0) {
									InvDefinition.field1488[var0][var1][var2 + 1] = 50;
								} else if (var4 == 1) {
									InvDefinition.field1488[var0][var1 + 1][var2 + 1] = 50;
								} else if (var4 == 2) {
									InvDefinition.field1488[var0][var1 + 1][var2] = 50;
								} else if (var4 == 3) {
									InvDefinition.field1488[var0][var1][var2] = 50;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method1093(var1, var2, var5, var4, var8.boolean1);
							}

						} else if (var5 == 9) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.method1221(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
							if (var8.interactType != 0 && var7 != null) {
								var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method1227(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 4) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field840[var4], 0, 0, 0, var19, var21);
						} else {
							Object var25;
							long var29;
							if (var5 == 5) {
								var28 = 16;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (0L != var29) {
									var28 = class90.getObjectDefinition(class458.Entity_unpackID(var29)).int2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, Tiles.field840[var4], 0, var28 * Tiles.field839[var4], var28 * Tiles.field842[var4], var19, var21);
							} else if (var5 == 6) {
								var28 = 8;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var29 != 0L) {
									var28 = class90.getObjectDefinition(class458.Entity_unpackID(var29)).int2 / 2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, 256, var4, var28 * Tiles.field843[var4], var28 * Tiles.field841[var4], var19, var21);
							} else if (var5 == 7) {
								var31 = var4 + 2 & 3;
								if (var8.animationId == -1 && var8.transforms == null) {
									var22 = var8.getEntity(4, var31 + 4, var15, var17, var16, var18);
								} else {
									var22 = new DynamicObject(var3, 4, var31 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, 256, var31, 0, 0, var19, var21);
							} else if (var5 == 8) {
								var28 = 8;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (0L != var29) {
									var28 = class90.getObjectDefinition(class458.Entity_unpackID(var29)).int2 / 2;
								}

								int var27 = var4 + 2 & 3;
								Object var26;
								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
									var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
									var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)var26, 256, var4, var28 * Tiles.field843[var4], var28 * Tiles.field841[var4], var19, var21);
							}
						}
					}
				} else {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
					}

					if (var22 != null && var6.method1221(var0, var1, var2, var16, var9, var10, (Renderable)var22, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
						var31 = 15;
						if (var22 instanceof Model) {
							var31 = ((Model)var22).method1293() / 4;
							if (var31 > 30) {
								var31 = 30;
							}
						}

						for (int var32 = 0; var32 <= var9; ++var32) {
							for (int var33 = 0; var33 <= var10; ++var33) {
								if (var31 > InvDefinition.field1488[var0][var32 + var1][var33 + var2]) {
									InvDefinition.field1488[var0][var32 + var1][var33 + var2] = (byte)var31;
								}
							}
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				}
			}
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-230258157"
	)
	public static void method513(boolean var0) {
		if (var0 != class502.ItemDefinition_inMembersWorld) {
			GrandExchangeOfferOwnWorldComparator.method355();
			class502.ItemDefinition_inMembersWorld = var0;
		}

	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		descriptor = "(IZZZZS)Lny;",
		garbageValue = "-12533"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
		ArchiveDisk var5 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var5 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class302.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var5, class158.masterDisk, class153.field1356, var0, var1, var2, var3, var4);
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "1729163536"
	)
	static long method515() {
		return Client.playerUUID;
	}
}
