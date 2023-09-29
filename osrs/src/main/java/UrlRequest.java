import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.URL;

@ObfuscatedName("eq")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("al")
	static int field1170;
	@ObfuscatedName("ak")
	static int field1169;
	@ObfuscatedName("ac")
	final URL field1171;
	@ObfuscatedName("ax")
	volatile int field1173;
	@ObfuscatedName("ao")
	@Export("response0")
	volatile byte[] response0;

	static {
		field1170 = -1;
		field1169 = -2;
	}

	UrlRequest(URL var1) {
		this.field1173 = field1170;
		this.field1171 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "53"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.field1173 != field1170;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "365015590"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-570806933"
	)
	public String method663() {
		return this.field1171.toString();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1964306071"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(Lnm;III)V",
		garbageValue = "-1837392633"
	)
	public static void method664(Widget var0, int var1, int var2) {
		var0.field3127.bodyColors[var1] = var2;
		var0.field3127.method1760();
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(ILmo;ZI)V",
		garbageValue = "-2002889011"
	)
	static void method665(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = class153.getWorldMap().getMapArea(var0);
		int var4 = TextureProvider.localPlayer.plane;
		int var5 = (TextureProvider.localPlayer.x >> 7) + class20.baseX;
		int var6 = (TextureProvider.localPlayer.y >> 7) + class19.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		class153.getWorldMap().method2438(var3, var7, var1, var2);
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		descriptor = "(Llq;I)V",
		garbageValue = "-1816644009"
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
		int var8;
		if (ZoneOperation.AREA_SOUND == var0) {
			var2 = var1.readUnsignedByte();
			var3 = (var2 >> 4 & 7) + Clock.field1484;
			var4 = (var2 & 7) + class354.field3144;
			var5 = var1.readUnsignedByteSub();
			var6 = var5 >> 2;
			var7 = var5 & 3;
			var8 = Client.field652[var6];
			if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
				class19.updatePendingSpawn(class87.Client_plane, var3, var4, var8, -1, var6, var7, 31, 0, -1);
			}

		} else {
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			Projectile var16;
			byte var37;
			int var41;
			int var42;
			if (ZoneOperation.OBJ_ADD == var0) {
				var2 = var1.readUnsignedByteAdd() * 4;
				var3 = var1.readUnsignedByteAdd();
				byte var38 = var1.readByteAdd();
				var5 = var1.readIntME();
				var37 = var1.readByteNeg();
				var7 = var1.readUnsignedByteNeg();
				var8 = (var7 >> 4 & 7) + Clock.field1484;
				var9 = (var7 & 7) + class354.field3144;
				var10 = var1.method2629();
				var11 = var1.readUnsignedShort();
				var12 = var1.method2630();
				var13 = var1.readUnsignedByteNeg();
				var41 = var1.readIntME();
				var42 = var1.readUnsignedByteSub() * 4;
				var6 = var37 + var8;
				var4 = var38 + var9;
				if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104 && var6 >= 0 && var4 >= 0 && var6 < 104 && var4 < 104 && var11 != 65535) {
					var8 = var8 * 128 + 64;
					var9 = var9 * 128 + 64;
					var6 = var6 * 128 + 64;
					var4 = var4 * 128 + 64;
					var16 = new Projectile(var11, class87.Client_plane, var8, var9, class115.getTileHeight(var8, var9, class87.Client_plane) - var42, var5 + Client.cycle, var41 + Client.cycle, var3, var13, var12, var10, var2);
					var16.setDestination(var6, var4, class115.getTileHeight(var6, var4, class87.Client_plane) - var2, var5 + Client.cycle);
					Client.projectiles.addFirst(var16);
				}

			} else if (ZoneOperation.field2619 == var0) {
				var2 = var1.readUnsignedShortAddLE();
				var3 = var1.readUnsignedByteSub();
				var4 = (var3 >> 4 & 7) + Clock.field1484;
				var5 = (var3 & 7) + class354.field3144;
				var6 = var1.readUnsignedIntLE();
				var7 = var1.readUnsignedIntIME();
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					NodeDeque var44 = Client.groundItems[class87.Client_plane][var4][var5];
					if (var44 != null) {
						for (TileItem var32 = (TileItem)var44.last(); var32 != null; var32 = (TileItem)var44.previous()) {
							if ((var2 & 32767) == var32.id && var7 == var32.quantity) {
								var32.quantity = var6;
								break;
							}
						}

						class30.updateItemPile(var4, var5);
					}
				}

			} else {
				byte var14;
				if (ZoneOperation.MAPPROJ_ANIM == var0) {
					var2 = var1.readUnsignedByte() * 4;
					var3 = var1.readIntME();
					var4 = var1.method2629();
					var5 = var1.readUnsignedByte() * 4;
					var6 = var1.readUnsignedShortAddLE();
					var7 = var1.method2629();
					var8 = var1.readIntME();
					var9 = var1.readUnsignedShortAdd();
					var10 = var1.readUnsignedByteSub();
					var11 = (var10 >> 4 & 7) + Clock.field1484;
					var12 = (var10 & 7) + class354.field3144;
					byte var40 = var1.readByteAdd();
					var14 = var1.readByte();
					var42 = var1.readUnsignedByteSub();
					var13 = var40 + var11;
					var41 = var14 + var12;
					if (var11 >= 0 && var12 >= 0 && var11 < 104 && var12 < 104 && var13 >= 0 && var41 >= 0 && var13 < 104 && var41 < 104 && var8 != 65535) {
						var11 = var11 * 128 + 64;
						var12 = var12 * 128 + 64;
						var13 = var13 * 128 + 64;
						var41 = var41 * 128 + 64;
						var16 = new Projectile(var8, class87.Client_plane, var11, var12, class115.getTileHeight(var11, var12, class87.Client_plane) - var5, var6 + Client.cycle, var3 + Client.cycle, var42, var9, var4, var7, var2);
						var16.setDestination(var13, var41, class115.getTileHeight(var13, var41, class87.Client_plane) - var2, var6 + Client.cycle);
						Client.projectiles.addFirst(var16);
					}

				} else if (ZoneOperation.OBJ_COUNT == var0) {
					var2 = var1.readUnsignedByteNeg();
					var3 = var1.readIntME();
					var4 = var1.readUnsignedByteSub();
					var5 = (var4 >> 4 & 7) + Clock.field1484;
					var6 = (var4 & 7) + class354.field3144;
					var7 = var1.readUnsignedByte() * 4;
					var8 = var1.readIntME();
					var9 = var1.method2583();
					var10 = var1.readUnsignedByteNeg() * 4;
					var11 = var1.readUnsignedShortAdd();
					byte var39 = var1.readByte();
					var13 = var1.readUnsignedByteNeg();
					var14 = var1.readByteSub();
					var12 = var39 + var5;
					var41 = var14 + var6;
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104 && var12 >= 0 && var41 >= 0 && var12 < 104 && var41 < 104 && var3 != 65535) {
						var5 = var5 * 128 + 64;
						var6 = var6 * 128 + 64;
						var12 = var12 * 128 + 64;
						var41 = var41 * 128 + 64;
						Projectile var33 = new Projectile(var3, class87.Client_plane, var5, var6, class115.getTileHeight(var5, var6, class87.Client_plane) - var7, var11 + Client.cycle, var8 + Client.cycle, var2, var13, var9, var10);
						var33.setDestination(var12, var41, class115.getTileHeight(var12, var41, class87.Client_plane) - var10, var11 + Client.cycle);
						Client.projectiles.addFirst(var33);
					}

				} else if (ZoneOperation.LOC_ANIM == var0) {
					var2 = var1.readUnsignedShortAddLE();
					var3 = var1.readUnsignedByteSub();
					var4 = (var3 >> 4 & 7) + Clock.field1484;
					var5 = (var3 & 7) + class354.field3144;
					var6 = var1.readUnsignedByteAdd();
					var7 = var6 >> 2;
					var8 = var6 & 3;
					var9 = Client.field652[var7];
					if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
						if (var9 == 0) {
							BoundaryObject var34 = class10.scene.method1299(class87.Client_plane, var4, var5);
							if (var34 != null) {
								var11 = SecureRandomFuture.Entity_unpackID(var34.tag);
								if (var7 == 2) {
									var34.renderable1 = new DynamicObject(var11, 2, var8 + 4, class87.Client_plane, var4, var5, var2, false, var34.renderable1);
									var34.renderable2 = new DynamicObject(var11, 2, var8 + 1 & 3, class87.Client_plane, var4, var5, var2, false, var34.renderable2);
								} else {
									var34.renderable1 = new DynamicObject(var11, var7, var8, class87.Client_plane, var4, var5, var2, false, var34.renderable1);
								}

								return;
							}
						}

						if (var9 == 1) {
							WallDecoration var45 = class10.scene.method1300(class87.Client_plane, var4, var5);
							if (var45 != null) {
								var11 = SecureRandomFuture.Entity_unpackID(var45.tag);
								if (var7 != 4 && var7 != 5) {
									if (var7 == 6) {
										var45.renderable1 = new DynamicObject(var11, 4, var8 + 4, class87.Client_plane, var4, var5, var2, false, var45.renderable1);
									} else if (var7 == 7) {
										var45.renderable1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class87.Client_plane, var4, var5, var2, false, var45.renderable1);
									} else if (var7 == 8) {
										var45.renderable1 = new DynamicObject(var11, 4, var8 + 4, class87.Client_plane, var4, var5, var2, false, var45.renderable1);
										var45.renderable2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class87.Client_plane, var4, var5, var2, false, var45.renderable2);
									}
								} else {
									var45.renderable1 = new DynamicObject(var11, 4, var8, class87.Client_plane, var4, var5, var2, false, var45.renderable1);
								}

								return;
							}
						}

						if (var9 == 2) {
							GameObject var46 = class10.scene.getGameObject(class87.Client_plane, var4, var5);
							if (var7 == 11) {
								var7 = 10;
							}

							if (var46 != null) {
								var46.renderable = new DynamicObject(SecureRandomFuture.Entity_unpackID(var46.tag), var7, var8, class87.Client_plane, var4, var5, var2, false, var46.renderable);
								return;
							}
						}

						if (var9 == 3) {
							FloorDecoration var47 = class10.scene.getFloorDecoration(class87.Client_plane, var4, var5);
							if (var47 != null) {
								var47.renderable = new DynamicObject(SecureRandomFuture.Entity_unpackID(var47.tag), 22, var8, class87.Client_plane, var4, var5, var2, false, var47.renderable);
								return;
							}
						}

						class266.method1431(class87.Client_plane, var4, var5, var9, var2);
					}

				} else {
					if (ZoneOperation.LOC_ADD_CHANGE == var0) {
						var2 = var1.readUnsignedByteAdd();
						var3 = var1.readIntME();
						var4 = var1.readUnsignedByteSub();
						var5 = var4 >> 4 & 15;
						var6 = var4 & 7;
						var7 = var1.readUnsignedByteAdd();
						var8 = (var7 >> 4 & 7) + Clock.field1484;
						var9 = (var7 & 7) + class354.field3144;
						if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
							var10 = var5 + 1;
							if (TextureProvider.localPlayer.pathX[0] >= var8 - var10 && TextureProvider.localPlayer.pathX[0] <= var10 + var8 && TextureProvider.localPlayer.pathY[0] >= var9 - var10 && TextureProvider.localPlayer.pathY[0] <= var10 + var9 && class91.clientPreferences.getAreaSoundEffectsVolume() != 0 && var6 > 0 && Client.soundEffectCount < 50) {
								Client.soundEffectIds[Client.soundEffectCount] = var3;
								Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
								Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
								Client.soundEffects[Client.soundEffectCount] = null;
								Client.soundLocations[Client.soundEffectCount] = var5 + (var9 << 8) + (var8 << 16);
								++Client.soundEffectCount;
							}
						}
					}

					if (ZoneOperation.PREFETCH_GAMEOBJECTS == var0) {
						var2 = var1.readUnsignedShortAddLE();
						var3 = var1.readUnsignedByte();
						var4 = (var3 >> 4 & 7) + Clock.field1484;
						var5 = (var3 & 7) + class354.field3144;
						var37 = var1.readByteSub();
						var7 = var1.readIntME();
						var8 = var1.readUnsignedShort();
						var9 = var1.readUnsignedShortAdd();
						var10 = var1.readUnsignedByteNeg();
						var11 = var10 >> 2;
						var12 = var10 & 3;
						var13 = Client.field652[var11];
						var14 = var1.readByteNeg();
						byte var15 = var1.readByteSub();
						byte var35 = var1.readByteAdd();
						Player var17;
						if (var7 == Client.localPlayerIndex) {
							var17 = TextureProvider.localPlayer;
						} else {
							var17 = Client.players[var7];
						}

						if (var17 != null) {
							ObjectComposition var18 = class91.getObjectDefinition(var8);
							int var19;
							int var20;
							if (var12 != 1 && var12 != 3) {
								var19 = var18.sizeX;
								var20 = var18.sizeY;
							} else {
								var19 = var18.sizeY;
								var20 = var18.sizeX;
							}

							int var21 = var4 + (var19 >> 1);
							int var22 = var4 + (var19 + 1 >> 1);
							int var23 = var5 + (var20 >> 1);
							int var24 = var5 + (var20 + 1 >> 1);
							int[][] var25 = Tiles.Tiles_heights[class87.Client_plane];
							int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
							int var27 = (var4 << 7) + (var19 << 6);
							int var28 = (var5 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var11, var12, var25, var27, var26, var28);
							if (var29 != null) {
								class19.updatePendingSpawn(class87.Client_plane, var4, var5, var13, -1, 0, 0, 31, var2 + 1, var9 + 1);
								var17.animationCycleStart = var2 + Client.cycle;
								var17.animationCycleEnd = var9 + Client.cycle;
								var17.attachedModel = var29;
								var17.field900 = var19 * 64 + var4 * 128;
								var17.field916 = var20 * 64 + var5 * 128;
								var17.baseTileHeight = var26;
								byte var30;
								if (var35 > var37) {
									var30 = var35;
									var35 = var37;
									var37 = var30;
								}

								if (var14 > var15) {
									var30 = var14;
									var14 = var15;
									var15 = var30;
								}

								var17.minX = var35 + var4;
								var17.maxX = var37 + var4;
								var17.minY = var14 + var5;
								var17.maxY = var15 + var5;
							}
						}
					}

					TileItem var31;
					if (ZoneOperation.field2624 == var0) {
						var2 = var1.readUnsignedByteAdd();
						var3 = var1.readUnsignedIntME();
						var4 = var1.readUnsignedByteAdd();
						var5 = (var4 >> 4 & 7) + Clock.field1484;
						var6 = (var4 & 7) + class354.field3144;
						var1.readUnsignedByteAdd();
						var1.readUnsignedShortAddLE();
						var1.readUnsignedByteSub();
						var7 = var1.readUnsignedShort();
						var1.readUnsignedShort();
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							var31 = new TileItem();
							var31.id = var7;
							var31.quantity = var3;
							var31.method611(var2);
							if (Client.groundItems[class87.Client_plane][var5][var6] == null) {
								Client.groundItems[class87.Client_plane][var5][var6] = new NodeDeque();
							}

							Client.groundItems[class87.Client_plane][var5][var6].addFirst(var31);
							class30.updateItemPile(var5, var6);
						}

					} else {
						NodeDeque var36;
						if (ZoneOperation.OBJ_DEL == var0) {
							var2 = var1.readUnsignedByteAdd();
							var3 = (var2 >> 4 & 7) + Clock.field1484;
							var4 = (var2 & 7) + class354.field3144;
							var5 = var1.readUnsignedShort();
							var6 = var1.readUnsignedByteSub();
							if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
								var36 = Client.groundItems[class87.Client_plane][var3][var4];
								if (var36 != null) {
									for (var31 = (TileItem)var36.last(); var31 != null; var31 = (TileItem)var36.previous()) {
										if ((var5 & 32767) == var31.id) {
											var31.method611(var6);
											break;
										}
									}
								}
							}

						} else if (ZoneOperation.LOC_DEL != var0) {
							if (ZoneOperation.field2617 == var0) {
								var2 = var1.readUnsignedShort();
								var3 = var1.readUnsignedShort();
								var4 = var1.readUnsignedByte();
								var5 = (var4 >> 4 & 7) + Clock.field1484;
								var6 = (var4 & 7) + class354.field3144;
								var7 = var1.readUnsignedByteNeg();
								if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
									var5 = var5 * 128 + 64;
									var6 = var6 * 128 + 64;
									GraphicsObject var43 = new GraphicsObject(var3, class87.Client_plane, var5, var6, class115.getTileHeight(var5, var6, class87.Client_plane) - var7, var2, Client.cycle);
									Client.graphicsObjects.addFirst(var43);
								}

							} else if (ZoneOperation.field2623 == var0) {
								var2 = var1.readUnsignedByte();
								var3 = var1.readUnsignedByteAdd();
								var4 = var3 >> 2;
								var5 = var3 & 3;
								var6 = Client.field652[var4];
								var7 = var1.readUnsignedByteAdd();
								var8 = (var7 >> 4 & 7) + Clock.field1484;
								var9 = (var7 & 7) + class354.field3144;
								var10 = var1.readUnsignedShortAdd();
								if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
									class19.updatePendingSpawn(class87.Client_plane, var8, var9, var6, var10, var4, var5, var2, 0, -1);
								}

							}
						} else {
							var2 = var1.readUnsignedIntLE();
							var3 = var1.readUnsignedByteAdd();
							var4 = (var3 >> 4 & 7) + Clock.field1484;
							var5 = (var3 & 7) + class354.field3144;
							var6 = var1.readUnsignedShortAddLE();
							if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
								var36 = Client.groundItems[class87.Client_plane][var4][var5];
								if (var36 != null) {
									for (var31 = (TileItem)var36.last(); var31 != null; var31 = (TileItem)var36.previous()) {
										if ((var6 & 32767) == var31.id && var2 == var31.quantity) {
											var31.remove();
											break;
										}
									}

									if (var36.last() == null) {
										Client.groundItems[class87.Client_plane][var4][var5] = null;
									}

									class30.updateItemPile(var4, var5);
								}
							}

						}
					}
				}
			}
		}
	}
}