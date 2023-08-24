import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("World")
public class World {
	@ObfuscatedName("ai")
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("az")
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("ap")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("aa")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("ad")
	@Export("id")
	int id;
	@ObfuscatedName("aq")
	@Export("properties")
	int properties;
	@ObfuscatedName("al")
	@Export("population")
	int population;
	@ObfuscatedName("an")
	@Export("host")
	String host;
	@ObfuscatedName("ar")
	@Export("activity")
	String activity;
	@ObfuscatedName("ab")
	@Export("location")
	int location;
	@ObfuscatedName("ag")
	@Export("index")
	int index;
	@ObfuscatedName("am")
	String field679;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "2"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (class510.field4129.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1342373424"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (class510.field4125.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1471748283"
	)
	boolean method388() {
		return (class510.field4124.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-87"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (class510.field4127.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1678180347"
	)
	boolean method390() {
		return (class510.field4128.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1233565973"
	)
	boolean method391() {
		return (class510.field4132.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "879753429"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (class510.field4126.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-6"
	)
	boolean method393() {
		return (class510.field4131.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "2"
	)
	boolean method394() {
		return (class510.field4122.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "8"
	)
	boolean method395() {
		return (class510.field4130.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-2141322867"
	)
	public static String method385(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = SceneTilePaint.method1352(var5);
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		descriptor = "(Lls;I)V",
		garbageValue = "681545140"
	)
	@Export("processZoneOperation")
	static final void processZoneOperation(ZoneOperation var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		if (ZoneOperation.AREA_SOUND == var0) {
			var2 = var1.readUnsignedIntIME();
			var3 = var1.readIntIME();
			var4 = var1.readUnsignedByte();
			var5 = (var4 >> 4 & 7) + ObjectSound.field686;
			var6 = (var4 & 7) + class125.field1193;
			var7 = var1.readUnsignedShortLE();
			if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
				NodeDeque var41 = Client.groundItems[HealthBar.Client_plane][var5][var6];
				if (var41 != null) {
					for (TileItem var9 = (TileItem)var41.last(); var9 != null; var9 = (TileItem)var41.previous()) {
						if ((var7 & 32767) == var9.id && var3 == var9.quantity) {
							var9.quantity = var2;
							break;
						}
					}

					class135.updateItemPile(var5, var6);
				}
			}

		} else {
			byte var10;
			int var12;
			int var13;
			int var31;
			int var32;
			if (ZoneOperation.OBJ_ADD == var0) {
				var2 = var1.readUnsignedByteAdd();
				var3 = var2 >> 2;
				var4 = var2 & 3;
				var5 = Client.field653[var3];
				var6 = var1.readUnsignedByteNeg();
				var7 = (var6 >> 4 & 7) + ObjectSound.field686;
				var31 = (var6 & 7) + class125.field1193;
				var32 = var1.method2587();
				var10 = var1.readByteAdd();
				byte var11 = var1.readByteNeg();
				var12 = var1.readIntME();
				var13 = var1.readIntME();
				byte var14 = var1.readSignedByteSub();
				byte var15 = var1.readByte();
				int var16 = var1.method2587();
				Player var17;
				if (var32 == Client.localPlayerIndex) {
					var17 = VarbitComposition.localPlayer;
				} else {
					var17 = Client.players[var32];
				}

				if (var17 != null) {
					ObjectComposition var18 = WorldMapElement.getObjectDefinition(var13);
					int var19;
					int var20;
					if (var4 != 1 && var4 != 3) {
						var19 = var18.sizeX;
						var20 = var18.sizeY;
					} else {
						var19 = var18.sizeY;
						var20 = var18.sizeX;
					}

					int var21 = var7 + (var19 >> 1);
					int var22 = var7 + (var19 + 1 >> 1);
					int var23 = var31 + (var20 >> 1);
					int var24 = var31 + (var20 + 1 >> 1);
					int[][] var25 = Tiles.Tiles_heights[HealthBar.Client_plane];
					int var26 = var25[var22][var24] + var25[var21][var24] + var25[var22][var23] + var25[var21][var23] >> 2;
					int var27 = (var7 << 7) + (var19 << 6);
					int var28 = (var31 << 7) + (var20 << 6);
					Model var29 = var18.getModel(var3, var4, var25, var27, var26, var28);
					if (var29 != null) {
						ClientPreferences.updatePendingSpawn(HealthBar.Client_plane, var7, var31, var5, -1, 0, 0, 31, var12 + 1, var16 + 1);
						var17.animationCycleStart = var12 + Client.cycle;
						var17.animationCycleEnd = var16 + Client.cycle;
						var17.attachedModel = var29;
						var17.field909 = var19 * 64 + var7 * 128;
						var17.field910 = var20 * 64 + var31 * 128;
						var17.baseTileHeight = var26;
						byte var30;
						if (var14 > var10) {
							var30 = var14;
							var14 = var10;
							var10 = var30;
						}

						if (var11 > var15) {
							var30 = var11;
							var11 = var15;
							var15 = var30;
						}

						var17.minX = var7 + var14;
						var17.maxX = var10 + var7;
						var17.minY = var11 + var31;
						var17.maxY = var15 + var31;
					}
				}
			}

			if (ZoneOperation.LOC_ANIM == var0) {
				var2 = var1.readUnsignedByteNeg();
				var3 = (var2 >> 4 & 7) + ObjectSound.field686;
				var4 = (var2 & 7) + class125.field1193;
				var5 = var1.readUnsignedShort();
				var6 = var1.readUnsignedByteNeg();
				var7 = var1.readUnsignedShortLE();
				if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
					var3 = var3 * 128 + 64;
					var4 = var4 * 128 + 64;
					GraphicsObject var40 = new GraphicsObject(var7, HealthBar.Client_plane, var3, var4, class18.getTileHeight(var3, var4, HealthBar.Client_plane) - var6, var5, Client.cycle);
					Client.graphicsObjects.addFirst(var40);
				}

			} else {
				int var42;
				if (ZoneOperation.MAP_ANIM == var0) {
					var2 = var1.readUnsignedByteAdd();
					var3 = var1.readUnsignedByteNeg();
					var4 = var3 >> 2;
					var5 = var3 & 3;
					var6 = Client.field653[var4];
					var7 = var1.method2587();
					var31 = var1.readUnsignedByteSub();
					var32 = (var31 >> 4 & 7) + ObjectSound.field686;
					var42 = (var31 & 7) + class125.field1193;
					if (var32 >= 0 && var42 >= 0 && var32 < 104 && var42 < 104) {
						ClientPreferences.updatePendingSpawn(HealthBar.Client_plane, var32, var42, var6, var7, var4, var5, var2, 0, -1);
					}

				} else {
					int var43;
					if (ZoneOperation.OBJ_COUNT == var0) {
						var2 = var1.readUnsignedByteNeg();
						var3 = var2 >> 2;
						var4 = var2 & 3;
						var5 = Client.field653[var3];
						var6 = var1.readIntME();
						var7 = var1.readUnsignedByteNeg();
						var31 = (var7 >> 4 & 7) + ObjectSound.field686;
						var32 = (var7 & 7) + class125.field1193;
						if (var31 >= 0 && var32 >= 0 && var31 < 103 && var32 < 103) {
							if (var5 == 0) {
								BoundaryObject var33 = class130.scene.method1255(HealthBar.Client_plane, var31, var32);
								if (var33 != null) {
									var43 = InvDefinition.Entity_unpackID(var33.tag);
									if (var3 == 2) {
										var33.renderable1 = new DynamicObject(var43, 2, var4 + 4, HealthBar.Client_plane, var31, var32, var6, false, var33.renderable1);
										var33.renderable2 = new DynamicObject(var43, 2, var4 + 1 & 3, HealthBar.Client_plane, var31, var32, var6, false, var33.renderable2);
									} else {
										var33.renderable1 = new DynamicObject(var43, var3, var4, HealthBar.Client_plane, var31, var32, var6, false, var33.renderable1);
									}

									return;
								}
							}

							if (var5 == 1) {
								WallDecoration var46 = class130.scene.method1256(HealthBar.Client_plane, var31, var32);
								if (var46 != null) {
									var43 = InvDefinition.Entity_unpackID(var46.tag);
									if (var3 != 4 && var3 != 5) {
										if (var3 == 6) {
											var46.renderable1 = new DynamicObject(var43, 4, var4 + 4, HealthBar.Client_plane, var31, var32, var6, false, var46.renderable1);
										} else if (var3 == 7) {
											var46.renderable1 = new DynamicObject(var43, 4, (var4 + 2 & 3) + 4, HealthBar.Client_plane, var31, var32, var6, false, var46.renderable1);
										} else if (var3 == 8) {
											var46.renderable1 = new DynamicObject(var43, 4, var4 + 4, HealthBar.Client_plane, var31, var32, var6, false, var46.renderable1);
											var46.renderable2 = new DynamicObject(var43, 4, (var4 + 2 & 3) + 4, HealthBar.Client_plane, var31, var32, var6, false, var46.renderable2);
										}
									} else {
										var46.renderable1 = new DynamicObject(var43, 4, var4, HealthBar.Client_plane, var31, var32, var6, false, var46.renderable1);
									}

									return;
								}
							}

							if (var5 == 2) {
								GameObject var47 = class130.scene.getGameObject(HealthBar.Client_plane, var31, var32);
								if (var3 == 11) {
									var3 = 10;
								}

								if (var47 != null) {
									var47.renderable = new DynamicObject(InvDefinition.Entity_unpackID(var47.tag), var3, var4, HealthBar.Client_plane, var31, var32, var6, false, var47.renderable);
									return;
								}
							}

							if (var5 == 3) {
								FloorDecoration var48 = class130.scene.getFloorDecoration(HealthBar.Client_plane, var31, var32);
								if (var48 != null) {
									var48.renderable = new DynamicObject(InvDefinition.Entity_unpackID(var48.tag), 22, var4, HealthBar.Client_plane, var31, var32, var6, false, var48.renderable);
									return;
								}
							}

							class460.method2332(HealthBar.Client_plane, var31, var32, var5, var6);
						}

					} else {
						TileItem var8;
						if (ZoneOperation.OBJ_DEL_LEGACY == var0) {
							var1.readUnsignedByteAdd();
							var2 = var1.readUnsignedByteAdd();
							var3 = (var2 >> 4 & 7) + ObjectSound.field686;
							var4 = (var2 & 7) + class125.field1193;
							var5 = var1.readUnsignedByte();
							var6 = var1.readInt();
							var1.method2587();
							var1.readIntME();
							var1.readUnsignedByteAdd();
							var7 = var1.readUnsignedShort();
							if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
								var8 = new TileItem();
								var8.id = var7;
								var8.quantity = var6;
								var8.method609(var5);
								if (Client.groundItems[HealthBar.Client_plane][var3][var4] == null) {
									Client.groundItems[HealthBar.Client_plane][var3][var4] = new NodeDeque();
								}

								Client.groundItems[HealthBar.Client_plane][var3][var4].addFirst(var8);
								class135.updateItemPile(var3, var4);
							}

						} else if (ZoneOperation.LOC_ADD_CHANGE == var0) {
							var2 = var1.readUnsignedByte();
							var3 = (var2 >> 4 & 7) + ObjectSound.field686;
							var4 = (var2 & 7) + class125.field1193;
							var5 = var1.readUnsignedByteNeg();
							var6 = var5 >> 2;
							var7 = var5 & 3;
							var31 = Client.field653[var6];
							if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
								ClientPreferences.updatePendingSpawn(HealthBar.Client_plane, var3, var4, var31, -1, var6, var7, 31, 0, -1);
							}

						} else {
							NodeDeque var34;
							if (ZoneOperation.PREFETCH_GAMEOBJECTS == var0) {
								var2 = var1.method2587();
								var3 = var1.readUnsignedIntIME();
								var4 = var1.readUnsignedByte();
								var5 = (var4 >> 4 & 7) + ObjectSound.field686;
								var6 = (var4 & 7) + class125.field1193;
								if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
									var34 = Client.groundItems[HealthBar.Client_plane][var5][var6];
									if (var34 != null) {
										for (var8 = (TileItem)var34.last(); var8 != null; var8 = (TileItem)var34.previous()) {
											if ((var2 & 32767) == var8.id && var3 == var8.quantity) {
												var8.remove();
												break;
											}
										}

										if (var34.last() == null) {
											Client.groundItems[HealthBar.Client_plane][var5][var6] = null;
										}

										class135.updateItemPile(var5, var6);
									}
								}

							} else {
								if (ZoneOperation.MAPPROJ_ANIM == var0) {
									var2 = var1.readUnsignedByteAdd();
									var3 = (var2 >> 4 & 7) + ObjectSound.field686;
									var4 = (var2 & 7) + class125.field1193;
									var5 = var1.readUnsignedByteSub();
									var6 = var5 >> 4 & 15;
									var7 = var5 & 7;
									var31 = var1.readUnsignedByte();
									var32 = var1.method2587();
									if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
										var42 = var6 + 1;
										if (VarbitComposition.localPlayer.pathX[0] >= var3 - var42 && VarbitComposition.localPlayer.pathX[0] <= var42 + var3 && VarbitComposition.localPlayer.pathY[0] >= var4 - var42 && VarbitComposition.localPlayer.pathY[0] <= var42 + var4 && class449.clientPreferences.getAreaSoundEffectsVolume() != 0 && var7 > 0 && Client.soundEffectCount < 50) {
											Client.soundEffectIds[Client.soundEffectCount] = var32;
											Client.queuedSoundEffectLoops[Client.soundEffectCount] = var7;
											Client.queuedSoundEffectDelays[Client.soundEffectCount] = var31;
											Client.soundEffects[Client.soundEffectCount] = null;
											Client.soundLocations[Client.soundEffectCount] = var6 + (var4 << 8) + (var3 << 16);
											++Client.soundEffectCount;
										}
									}
								}

								int var44;
								if (ZoneOperation.OBJ_DEL == var0) {
									var2 = var1.readUnsignedShortLE();
									var3 = var1.readUnsignedShort();
									byte var37 = var1.readSignedByteSub();
									var5 = var1.readUnsignedByteNeg();
									var6 = var1.method2593();
									byte var39 = var1.readByte();
									var31 = var1.readUnsignedByteAdd() * 4;
									var32 = var1.readUnsignedByteNeg();
									var42 = var1.readUnsignedByteSub() * 4;
									var43 = var1.method2594();
									var12 = var1.readUnsignedByte();
									var13 = (var12 >> 4 & 7) + ObjectSound.field686;
									var44 = (var12 & 7) + class125.field1193;
									int var45 = var1.method2587();
									var4 = var37 + var13;
									var7 = var39 + var44;
									if (var13 >= 0 && var44 >= 0 && var13 < 104 && var44 < 104 && var4 >= 0 && var7 >= 0 && var4 < 104 && var7 < 104 && var45 != 65535) {
										var13 = var13 * 128 + 64;
										var44 = var44 * 128 + 64;
										var4 = var4 * 128 + 64;
										var7 = var7 * 128 + 64;
										Projectile var35 = new Projectile(var45, HealthBar.Client_plane, var13, var44, class18.getTileHeight(var13, var44, HealthBar.Client_plane) - var31, var2 + Client.cycle, var3 + Client.cycle, var5, var32, var43, var6, var42);
										var35.setDestination(var4, var7, class18.getTileHeight(var4, var7, HealthBar.Client_plane) - var42, var2 + Client.cycle);
										Client.projectiles.addFirst(var35);
									}

								} else if (ZoneOperation.LOC_DEL == var0) {
									var2 = var1.readIntME();
									var3 = var1.readUnsignedByteAdd();
									var4 = (var3 >> 4 & 7) + ObjectSound.field686;
									var5 = (var3 & 7) + class125.field1193;
									byte var38 = var1.readSignedByteSub();
									var7 = var1.method2594();
									var31 = var1.readUnsignedByteAdd();
									var32 = var1.method2587();
									var10 = var1.readByteAdd();
									var43 = var1.readUnsignedByteNeg() * 4;
									var12 = var1.readUnsignedByteAdd();
									var13 = var1.readUnsignedByteAdd() * 4;
									var44 = var1.readUnsignedShort();
									var42 = var10 + var4;
									var6 = var38 + var5;
									if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104 && var42 >= 0 && var6 >= 0 && var42 < 104 && var6 < 104 && var2 != 65535) {
										var4 = var4 * 128 + 64;
										var5 = var5 * 128 + 64;
										var42 = var42 * 128 + 64;
										var6 = var6 * 128 + 64;
										Projectile var36 = new Projectile(var2, HealthBar.Client_plane, var4, var5, class18.getTileHeight(var4, var5, HealthBar.Client_plane) - var13, var44 + Client.cycle, var32 + Client.cycle, var31, var12, var7, var43);
										var36.setDestination(var42, var6, class18.getTileHeight(var42, var6, HealthBar.Client_plane) - var43, var44 + Client.cycle);
										Client.projectiles.addFirst(var36);
									}

								} else if (ZoneOperation.field2607 == var0) {
									var2 = var1.readUnsignedByte();
									var3 = (var2 >> 4 & 7) + ObjectSound.field686;
									var4 = (var2 & 7) + class125.field1193;
									var5 = var1.readUnsignedByteSub();
									var6 = var1.readIntME();
									if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
										var34 = Client.groundItems[HealthBar.Client_plane][var3][var4];
										if (var34 != null) {
											for (var8 = (TileItem)var34.last(); var8 != null; var8 = (TileItem)var34.previous()) {
												if ((var6 & 32767) == var8.id) {
													var8.method609(var5);
													break;
												}
											}
										}
									}

								}
							}
						}
					}
				}
			}
		}
	}
}