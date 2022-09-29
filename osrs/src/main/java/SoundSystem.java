import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("tk")
	@ObfuscatedGetter(
		intValue = 1615048077
	)
	static int field327;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	static IndexedSprite field324;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "[Lad;"
	)
	@Export("players")
	volatile PcmPlayer[] players;

	SoundSystem() {
		this.players = new PcmPlayer[2];
	}

	public void run() {
		try {
			for (int var1 = 0; var1 < 2; ++var1) {
				PcmPlayer var2 = this.players[var1];
				if (var2 != null) {
					var2.run();
				}
			}
		} catch (Exception var4) {
			Clock.RunException_sendStackTrace((String)null, var4);
		}

	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		descriptor = "(Ljw;S)V",
		garbageValue = "1126"
	)
	static final void method813(class264 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		byte var4;
		int var5;
		int var6;
		int var7;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var37;
		int var38;
		int var39;
		if (class264.field3046 == var0) {
			var2 = var1.readUnsignedShort();
			var3 = var1.method7954() * 4;
			var4 = var1.method7960();
			var5 = var1.method7954();
			var6 = var1.method7954();
			var7 = (var6 >> 4 & 7) + class392.field4456;
			var38 = (var6 & 7) + ItemComposition.field2163;
			var39 = var1.method8023();
			byte var40 = var1.readByte();
			var11 = var1.method7965();
			var12 = var1.readUnsignedShort();
			var13 = var1.readShort();
			var14 = var1.method7955() * 4;
			var37 = var4 + var7;
			var10 = var40 + var38;
			if (var7 >= 0 && var38 >= 0 && var7 < 104 && var38 < 104 && var37 >= 0 && var10 >= 0 && var37 < 104 && var10 < 104 && var2 != 65535) {
				var7 = var7 * 128 + 64;
				var38 = var38 * 128 + 64;
				var37 = var37 * 128 + 64;
				var10 = var10 * 128 + 64;
				Projectile var36 = new Projectile(var2, Tiles.Client_plane, var7, var38, class120.getTileHeight(var7, var38, Tiles.Client_plane) - var14, var11 + Client.cycle, var12 + Client.cycle, var39, var5, var13, var3);
				var36.setDestination(var37, var10, class120.getTileHeight(var37, var10, Tiles.Client_plane) - var3, var11 + Client.cycle);
				Client.projectiles.addFirst(var36);
			}

		} else {
			if (class264.field3054 == var0) {
				var2 = var1.readUnsignedShort();
				var3 = var1.method7965();
				var4 = var1.method7960();
				var5 = var1.method8023();
				var6 = (var5 >> 4 & 7) + class392.field4456;
				var7 = (var5 & 7) + ItemComposition.field2163;
				byte var8 = var1.method7960();
				byte var9 = var1.method7975();
				var10 = var1.method7955();
				var11 = var10 >> 2;
				var12 = var10 & 3;
				var13 = Client.field564[var11];
				var14 = var1.method7964();
				byte var15 = var1.method7970();
				int var16 = var1.method7964();
				Player var17;
				if (var16 == Client.localPlayerIndex) {
					var17 = class67.localPlayer;
				} else {
					var17 = Client.players[var16];
				}

				if (var17 != null) {
					ObjectComposition var18 = PlayerComposition.getObjectDefinition(var2);
					int var19;
					int var20;
					if (var12 != 1 && var12 != 3) {
						var19 = var18.sizeX;
						var20 = var18.sizeY;
					} else {
						var19 = var18.sizeY;
						var20 = var18.sizeX;
					}

					int var21 = var6 + (var19 >> 1);
					int var22 = var6 + (var19 + 1 >> 1);
					int var23 = var7 + (var20 >> 1);
					int var24 = var7 + (var20 + 1 >> 1);
					int[][] var25 = Tiles.Tiles_heights[Tiles.Client_plane];
					int var26 = var25[var22][var24] + var25[var21][var24] + var25[var22][var23] + var25[var21][var23] >> 2;
					int var27 = (var6 << 7) + (var19 << 6);
					int var28 = (var7 << 7) + (var20 << 6);
					Model var29 = var18.getModel(var11, var12, var25, var27, var26, var28);
					if (var29 != null) {
						MilliClock.updatePendingSpawn(Tiles.Client_plane, var6, var7, var13, -1, 0, 0, var14 + 1, var3 + 1);
						var17.animationCycleStart = var14 + Client.cycle;
						var17.animationCycleEnd = var3 + Client.cycle;
						var17.model0 = var29;
						var17.field1106 = var6 * 128 + var19 * 64;
						var17.field1096 = var7 * 128 + var20 * 64;
						var17.tileHeight2 = var26;
						byte var30;
						if (var9 > var8) {
							var30 = var9;
							var9 = var8;
							var8 = var30;
						}

						if (var4 > var15) {
							var30 = var4;
							var4 = var15;
							var15 = var30;
						}

						var17.minX = var6 + var9;
						var17.maxX = var6 + var8;
						var17.minY = var7 + var4;
						var17.maxY = var15 + var7;
					}
				}
			}

			TileItem var41;
			if (class264.field3049 == var0) {
				var2 = var1.method7965();
				var3 = var1.method8023();
				var37 = (var3 >> 4 & 7) + class392.field4456;
				var5 = (var3 & 7) + ItemComposition.field2163;
				if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
					NodeDeque var35 = Client.groundItems[Tiles.Client_plane][var37][var5];
					if (var35 != null) {
						for (var41 = (TileItem)var35.last(); var41 != null; var41 = (TileItem)var35.previous()) {
							if ((var2 & 32767) == var41.id) {
								var41.remove();
								break;
							}
						}

						if (var35.last() == null) {
							Client.groundItems[Tiles.Client_plane][var37][var5] = null;
						}

						Friend.updateItemPile(var37, var5);
					}
				}

			} else if (class264.field3052 == var0) {
				var2 = var1.method8143();
				var3 = var1.readUnsignedByte();
				var37 = (var3 >> 4 & 7) + class392.field4456;
				var5 = (var3 & 7) + ItemComposition.field2163;
				var6 = var1.readUnsignedShort();
				var7 = var1.readUnsignedShort();
				if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
					NodeDeque var43 = Client.groundItems[Tiles.Client_plane][var37][var5];
					if (var43 != null) {
						for (TileItem var34 = (TileItem)var43.last(); var34 != null; var34 = (TileItem)var43.previous()) {
							if ((var2 & 32767) == var34.id && var7 == var34.quantity) {
								var34.quantity = var6;
								break;
							}
						}

						Friend.updateItemPile(var37, var5);
					}
				}

			} else if (class264.field3055 == var0) {
				var2 = var1.readUnsignedByte();
				var3 = var2 >> 2;
				var37 = var2 & 3;
				var5 = Client.field564[var3];
				var6 = var1.method7965();
				var7 = var1.method7955();
				var38 = (var7 >> 4 & 7) + class392.field4456;
				var39 = (var7 & 7) + ItemComposition.field2163;
				if (var38 >= 0 && var39 >= 0 && var38 < 104 && var39 < 104) {
					MilliClock.updatePendingSpawn(Tiles.Client_plane, var38, var39, var5, var6, var3, var37, 0, -1);
				}

			} else {
				if (class264.field3056 == var0) {
					var2 = var1.readUnsignedByte();
					var3 = var1.method8023();
					var37 = (var3 >> 4 & 7) + class392.field4456;
					var5 = (var3 & 7) + ItemComposition.field2163;
					var6 = var1.method7955();
					var7 = var6 >> 4 & 15;
					var38 = var6 & 7;
					var39 = var1.method8143();
					if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
						var10 = var7 + 1;
						if (class67.localPlayer.pathX[0] >= var37 - var10 && class67.localPlayer.pathX[0] <= var10 + var37 && class67.localPlayer.pathY[0] >= var5 - var10 && class67.localPlayer.pathY[0] <= var5 + var10 && Player.clientPreferences.method2474() != 0 && var38 > 0 && Client.soundEffectCount < 50) {
							Client.soundEffectIds[Client.soundEffectCount] = var39;
							Client.queuedSoundEffectLoops[Client.soundEffectCount] = var38;
							Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
							Client.soundEffects[Client.soundEffectCount] = null;
							Client.soundLocations[Client.soundEffectCount] = var7 + (var5 << 8) + (var37 << 16);
							++Client.soundEffectCount;
						}
					}
				}

				if (class264.field3051 == var0) {
					var2 = var1.method7954();
					var3 = var2 >> 2;
					var37 = var2 & 3;
					var5 = Client.field564[var3];
					var6 = var1.method7955();
					var7 = (var6 >> 4 & 7) + class392.field4456;
					var38 = (var6 & 7) + ItemComposition.field2163;
					var39 = var1.method7964();
					if (var7 >= 0 && var38 >= 0 && var7 < 103 && var38 < 103) {
						if (var5 == 0) {
							BoundaryObject var33 = MusicPatchNode.scene.method4281(Tiles.Client_plane, var7, var38);
							if (var33 != null) {
								var11 = class156.Entity_unpackID(var33.tag);
								if (var3 == 2) {
									var33.renderable1 = new DynamicObject(var11, 2, var37 + 4, Tiles.Client_plane, var7, var38, var39, false, var33.renderable1);
									var33.renderable2 = new DynamicObject(var11, 2, var37 + 1 & 3, Tiles.Client_plane, var7, var38, var39, false, var33.renderable2);
								} else {
									var33.renderable1 = new DynamicObject(var11, var3, var37, Tiles.Client_plane, var7, var38, var39, false, var33.renderable1);
								}
							}
						}

						if (var5 == 1) {
							WallDecoration var44 = MusicPatchNode.scene.method4282(Tiles.Client_plane, var7, var38);
							if (var44 != null) {
								var11 = class156.Entity_unpackID(var44.tag);
								if (var3 != 4 && var3 != 5) {
									if (var3 == 6) {
										var44.renderable1 = new DynamicObject(var11, 4, var37 + 4, Tiles.Client_plane, var7, var38, var39, false, var44.renderable1);
									} else if (var3 == 7) {
										var44.renderable1 = new DynamicObject(var11, 4, (var37 + 2 & 3) + 4, Tiles.Client_plane, var7, var38, var39, false, var44.renderable1);
									} else if (var3 == 8) {
										var44.renderable1 = new DynamicObject(var11, 4, var37 + 4, Tiles.Client_plane, var7, var38, var39, false, var44.renderable1);
										var44.renderable2 = new DynamicObject(var11, 4, (var37 + 2 & 3) + 4, Tiles.Client_plane, var7, var38, var39, false, var44.renderable2);
									}
								} else {
									var44.renderable1 = new DynamicObject(var11, 4, var37, Tiles.Client_plane, var7, var38, var39, false, var44.renderable1);
								}
							}
						}

						if (var5 == 2) {
							GameObject var45 = MusicPatchNode.scene.getGameObject(Tiles.Client_plane, var7, var38);
							if (var3 == 11) {
								var3 = 10;
							}

							if (var45 != null) {
								var45.renderable = new DynamicObject(class156.Entity_unpackID(var45.tag), var3, var37, Tiles.Client_plane, var7, var38, var39, false, var45.renderable);
							}
						}

						if (var5 == 3) {
							FloorDecoration var46 = MusicPatchNode.scene.getFloorDecoration(Tiles.Client_plane, var7, var38);
							if (var46 != null) {
								var46.renderable = new DynamicObject(class156.Entity_unpackID(var46.tag), 22, var37, Tiles.Client_plane, var7, var38, var39, false, var46.renderable);
							}
						}
					}

				} else if (class264.field3057 == var0) {
					var2 = var1.method7954();
					var3 = (var2 >> 4 & 7) + class392.field4456;
					var37 = (var2 & 7) + ItemComposition.field2163;
					var5 = var1.method8143();
					var6 = var1.method7965();
					var7 = var1.method7955();
					if (var3 >= 0 && var37 >= 0 && var3 < 104 && var37 < 104) {
						var3 = var3 * 128 + 64;
						var37 = var37 * 128 + 64;
						GraphicsObject var42 = new GraphicsObject(var5, Tiles.Client_plane, var3, var37, class120.getTileHeight(var3, var37, Tiles.Client_plane) - var7, var6, Client.cycle);
						Client.graphicsObjects.addFirst(var42);
					}

				} else if (class264.field3050 != var0) {
					if (class264.field3047 == var0) {
						var2 = var1.method7964();
						var3 = var1.readUnsignedShort();
						var37 = var1.method7955();
						var5 = (var37 >> 4 & 7) + class392.field4456;
						var6 = (var37 & 7) + ItemComposition.field2163;
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							var41 = new TileItem();
							var41.id = var2;
							var41.quantity = var3;
							if (Client.groundItems[Tiles.Client_plane][var5][var6] == null) {
								Client.groundItems[Tiles.Client_plane][var5][var6] = new NodeDeque();
							}

							Client.groundItems[Tiles.Client_plane][var5][var6].addFirst(var41);
							Friend.updateItemPile(var5, var6);
						}

					} else if (class264.field3053 == var0) {
						var2 = var1.method8023();
						var3 = var2 >> 2;
						var37 = var2 & 3;
						var5 = Client.field564[var3];
						var6 = var1.method8023();
						var7 = (var6 >> 4 & 7) + class392.field4456;
						var38 = (var6 & 7) + ItemComposition.field2163;
						if (var7 >= 0 && var38 >= 0 && var7 < 104 && var38 < 104) {
							MilliClock.updatePendingSpawn(Tiles.Client_plane, var7, var38, var5, -1, var3, var37, 0, -1);
						}

					}
				} else {
					var2 = var1.method7964();
					var3 = var1.method7954();
					var37 = (var3 >> 4 & 7) + class392.field4456;
					var5 = (var3 & 7) + ItemComposition.field2163;
					var6 = var1.method8143();
					if (var37 >= 0 && var5 >= 0 && var37 < 104 && var5 < 104) {
						NodeDeque var31 = Client.groundItems[Tiles.Client_plane][var37][var5];
						if (var31 != null) {
							for (TileItem var32 = (TileItem)var31.last(); var32 != null; var32 = (TileItem)var31.previous()) {
								if ((var2 & 32767) == var32.id && var6 == var32.quantity) {
									var32.remove();
									break;
								}
							}

							if (var31.last() == null) {
								Client.groundItems[Tiles.Client_plane][var37][var5] = null;
							}

							Friend.updateItemPile(var37, var5);
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		descriptor = "(Lkw;B)Z",
		garbageValue = "-25"
	)
	static final boolean method817(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.logoutTimer = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.changeAppearance(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method5730(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.changeSex(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.changeSex(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = class120.getPacketBufferNode(ClientPacket.field3024, Client.packetWriter.isaacCipher);
				Client.playerAppearance.write(var4.packetBuffer);
				Client.packetWriter.addNode(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
