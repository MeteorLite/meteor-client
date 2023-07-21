import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class27 {
	@ObfuscatedName("ag")
	int[] field78;
	@ObfuscatedName("az")
	int[] field79;

	public class27() {
		this.field78 = new int[112];
		this.field79 = new int[192];
		Arrays.fill(this.field78, 3);
		Arrays.fill(this.field79, 3);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "19"
	)
	public void method102(int var1, int var2) {
		if (this.method110(var1) && this.method112(var2)) {
			this.field78[var1] = var2;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(CII)V",
		garbageValue = "1505085994"
	)
	public void method103(char var1, int var2) {
		if (this.method111(var1) && this.method112(var2)) {
			this.field79[var1] = var2;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "62"
	)
	public int method104(int var1) {
		return this.method110(var1) ? this.field78[var1] : 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(CS)I",
		garbageValue = "-2560"
	)
	public int method105(char var1) {
		return this.method111(var1) ? this.field79[var1] : 0;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-2027151744"
	)
	public boolean method106(int var1) {
		return this.method110(var1) && (this.field78[var1] == 1 || this.field78[var1] == 3);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-2113017491"
	)
	public boolean method107(char var1) {
		return this.method111(var1) && (this.field79[var1] == 1 || this.field79[var1] == 3);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-651027133"
	)
	public boolean method108(int var1) {
		return this.method110(var1) && (this.field78[var1] == 2 || this.field78[var1] == 3);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "392210402"
	)
	public boolean method109(char var1) {
		return this.method111(var1) && (this.field79[var1] == 2 || this.field79[var1] == 3);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "295186281"
	)
	boolean method110(int var1) {
		if (var1 >= 0 && var1 < 112) {
			return true;
		} else {
			System.out.println("Invalid keycode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "16"
	)
	boolean method111(char var1) {
		if (var1 >= 0 && var1 < 192) {
			return true;
		} else {
			System.out.println("Invalid keychar: " + var1);
			return false;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1832967657"
	)
	boolean method112(int var1) {
		if (var1 >= 0 && var1 < 4) {
			return true;
		} else {
			System.out.println("Invalid mode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "0"
	)
	static int method113(String var0) {
		if (var0.equals("centre")) {
			return 1;
		} else {
			return !var0.equals("bottom") && !var0.equals("right") ? 0 : 2;
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "937542062"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (UserComparator4.garbageCollector == null || !UserComparator4.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						UserComparator4.garbageCollector = var2;
						GameEngine.garbageCollectorLastCheckTimeMs = -1L;
						GameEngine.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (UserComparator4.garbageCollector != null) {
			long var9 = class113.clockNow();
			long var3 = UserComparator4.garbageCollector.getCollectionTime();
			if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
				long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(var5 * 100L / var7);
				}
			}

			GameEngine.garbageCollectorLastCollectionTime = var3;
			GameEngine.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "193"
	)
	static final void method115() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				class47.updateActorSequence(var3, 1);
			}
		}

	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "-71"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (class136.localPlayer.x >> 7 == Client.destinationX && class136.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		class89.method483();
		ArchiveLoader.method465();
		class510.addNpcsToScene(true);
		int var4 = Players.Players_count;
		int[] var5 = Players.Players_indices;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
				GrandExchangeOfferNameComparator.addPlayerToScene(Client.players[var5[var6]], true);
			}
		}

		class510.addNpcsToScene(false);
		class393.method1991();
		class133.method729();
		class31.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.method1176();
		Rasterizer2D.method2624();
		var4 = Client.camAngleX;
		if (Client.field475 / 256 > var4) {
			var4 = Client.field475 / 256;
		}

		if (Client.field406[4] && Client.field586[4] + 128 > var4) {
			var4 = Client.field586[4] + 128;
		}

		int var17 = Client.camAngleY & 2047;
		class30.method127(class467.oculusOrbFocalPointX, class90.field887, class36.oculusOrbFocalPointY, var4, var17, ClanMate.method2183(var4), var3);
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		if (!Client.isCameraLocked) {
			if (class150.clientPreferences.getRoofsHidden()) {
				var7 = class36.Client_plane;
			} else {
				label290: {
					var8 = 3;
					if (class19.cameraPitch < 310) {
						if (Client.oculusOrbState == 1) {
							var9 = class467.oculusOrbFocalPointX >> 7;
							var10 = class36.oculusOrbFocalPointY >> 7;
						} else {
							var9 = class136.localPlayer.x >> 7;
							var10 = class136.localPlayer.y >> 7;
						}

						var11 = class157.cameraX >> 7;
						var12 = SoundSystem.cameraZ >> 7;
						if (var11 < 0 || var12 < 0 || var11 >= 104 || var12 >= 104) {
							var7 = class36.Client_plane;
							break label290;
						}

						if (var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
							var7 = class36.Client_plane;
							break label290;
						}

						if ((Tiles.Tiles_renderFlags[class36.Client_plane][var11][var12] & 4) != 0) {
							var8 = class36.Client_plane;
						}

						if (var9 > var11) {
							var13 = var9 - var11;
						} else {
							var13 = var11 - var9;
						}

						if (var10 > var12) {
							var14 = var10 - var12;
						} else {
							var14 = var12 - var10;
						}

						int var16;
						if (var13 > var14) {
							var15 = var14 * 65536 / var13;
							var16 = 32768;

							while (var9 != var11) {
								if (var11 < var9) {
									++var11;
								} else if (var11 > var9) {
									--var11;
								}

								if ((Tiles.Tiles_renderFlags[class36.Client_plane][var11][var12] & 4) != 0) {
									var8 = class36.Client_plane;
								}

								var16 += var15;
								if (var16 >= 65536) {
									var16 -= 65536;
									if (var12 < var10) {
										++var12;
									} else if (var12 > var10) {
										--var12;
									}

									if ((Tiles.Tiles_renderFlags[class36.Client_plane][var11][var12] & 4) != 0) {
										var8 = class36.Client_plane;
									}
								}
							}
						} else if (var14 > 0) {
							var15 = var13 * 65536 / var14;
							var16 = 32768;

							while (var10 != var12) {
								if (var12 < var10) {
									++var12;
								} else if (var12 > var10) {
									--var12;
								}

								if ((Tiles.Tiles_renderFlags[class36.Client_plane][var11][var12] & 4) != 0) {
									var8 = class36.Client_plane;
								}

								var16 += var15;
								if (var16 >= 65536) {
									var16 -= 65536;
									if (var11 < var9) {
										++var11;
									} else if (var11 > var9) {
										--var11;
									}

									if ((Tiles.Tiles_renderFlags[class36.Client_plane][var11][var12] & 4) != 0) {
										var8 = class36.Client_plane;
									}
								}
							}
						}
					}

					if (class136.localPlayer.x >= 0 && class136.localPlayer.y >= 0 && class136.localPlayer.x < 13312 && class136.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[class36.Client_plane][class136.localPlayer.x >> 7][class136.localPlayer.y >> 7] & 4) != 0) {
							var8 = class36.Client_plane;
						}

						var7 = var8;
					} else {
						var7 = class36.Client_plane;
					}
				}
			}

			var6 = var7;
		} else {
			if (class150.clientPreferences.getRoofsHidden()) {
				var7 = class36.Client_plane;
			} else {
				var8 = class306.getTileHeight(class157.cameraX, SoundSystem.cameraZ, class36.Client_plane);
				if (var8 - class384.cameraY < 800 && (Tiles.Tiles_renderFlags[class36.Client_plane][class157.cameraX >> 7][SoundSystem.cameraZ >> 7] & 4) != 0) {
					var7 = class36.Client_plane;
				} else {
					var7 = 3;
				}
			}

			var6 = var7;
		}

		var7 = class157.cameraX;
		var8 = class384.cameraY;
		var9 = SoundSystem.cameraZ;
		var10 = class19.cameraPitch;
		var11 = class456.cameraYaw;

		for (var12 = 0; var12 < 5; ++var12) {
			if (Client.field406[var12]) {
				var13 = (int)(Math.random() * (double)(Client.field587[var12] * 2 + 1) - (double)Client.field587[var12] + Math.sin((double)Client.field588[var12] / 100.0D * (double)Client.field585[var12]) * (double)Client.field586[var12]);
				if (var12 == 0) {
					class157.cameraX += var13;
				}

				if (var12 == 1) {
					class384.cameraY += var13;
				}

				if (var12 == 2) {
					SoundSystem.cameraZ += var13;
				}

				if (var12 == 3) {
					class456.cameraYaw = var13 + class456.cameraYaw & 2047;
				}

				if (var12 == 4) {
					class19.cameraPitch += var13;
					if (class19.cameraPitch < 128) {
						class19.cameraPitch = 128;
					}

					if (class19.cameraPitch > 383) {
						class19.cameraPitch = 383;
					}
				}
			}
		}

		var12 = MouseHandler.MouseHandler_x;
		var13 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var12 = MouseHandler.MouseHandler_lastPressedX;
			var13 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var12 >= var0 && var12 < var0 + var2 && var13 >= var1 && var13 < var3 + var1) {
			var14 = var12 - var0;
			var15 = var13 - var1;
			ViewportMouse.ViewportMouse_x = var14;
			ViewportMouse.ViewportMouse_y = var15;
			ViewportMouse.ViewportMouse_isInViewport = true;
			ViewportMouse.ViewportMouse_entityCount = 0;
			ViewportMouse.ViewportMouse_false0 = false;
		} else {
			ViewportMouse.ViewportMouse_isInViewport = false;
			ViewportMouse.ViewportMouse_entityCount = 0;
		}

		class105.method618();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		class105.method618();
		var14 = Rasterizer3D.method1173();
		Rasterizer3D.method1162(TileItem.client.field121);
		Rasterizer3D.field2012.field2253 = Client.viewportZoom;
		UserComparator5.scene.draw(class157.cameraX, class384.cameraY, SoundSystem.cameraZ, class19.cameraPitch, class456.cameraYaw, var6);
		Rasterizer3D.method1162(false);
		if (Client.renderSelf) {
			Rasterizer2D.method2625();
		}

		Rasterizer3D.field2012.field2253 = var14;
		class105.method618();
		UserComparator5.scene.clearTempGameObjects();
		UserComparator7.method669(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			ReflectionCheck.worldToScreen((Client.field435 - AbstractArchive.baseX << 7) + Client.field427, (Client.field433 - class148.baseY << 7) + Client.field437, Client.field426 * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				class345.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.field2012.Rasterizer3D_textureLoader).animate(Client.field452);
		FriendLoginUpdate.method2176();
		class157.cameraX = var7;
		class384.cameraY = var8;
		SoundSystem.cameraZ = var9;
		class19.cameraPitch = var10;
		class456.cameraYaw = var11;
		if (Client.isLoading && class153.field1356.method1903(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			Actor.drawLoadingMessage("Loading - please wait.", false);
		}

	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		descriptor = "(Llo;B)V",
		garbageValue = "-63"
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
		int var9;
		int var10;
		if (ZoneOperation.field2585 == var0) {
			var2 = var1.method2557();
			var3 = var2 >> 4 & 15;
			var4 = var2 & 7;
			var5 = var1.method2556();
			var6 = var1.readUnsignedShortLE();
			var7 = (var6 >> 4 & 7) + WorldMapSectionType.field2393;
			var8 = (var6 & 7) + class387.field3646;
			var9 = var1.readUnsignedByteAdd();
			if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
				var10 = var3 + 1;
				if (class136.localPlayer.pathX[0] >= var7 - var10 && class136.localPlayer.pathX[0] <= var7 + var10 && class136.localPlayer.pathY[0] >= var8 - var10 && class136.localPlayer.pathY[0] <= var10 + var8 && class150.clientPreferences.getAreaSoundEffectsVolume() != 0 && var4 > 0 && Client.soundEffectCount < 50) {
					Client.soundEffectIds[Client.soundEffectCount] = var9;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = var5;
					Client.soundEffects[Client.soundEffectCount] = null;
					Client.soundLocations[Client.soundEffectCount] = var3 + (var8 << 8) + (var7 << 16);
					++Client.soundEffectCount;
				}
			}
		}

		TileItem var31;
		if (ZoneOperation.field2589 == var0) {
			var2 = var1.readUnsignedByteNeg();
			var3 = var1.readUnsignedShortLE();
			var1.readUnsignedShort();
			var1.method2557();
			var4 = var1.readUnsignedShort();
			var5 = var1.readUnsignedByte();
			var6 = (var5 >> 4 & 7) + WorldMapSectionType.field2393;
			var7 = (var5 & 7) + class387.field3646;
			var1.readUnsignedByte();
			var1.readUnsignedShortAddLE();
			if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
				var31 = new TileItem();
				var31.id = var4;
				var31.quantity = var2;
				var31.method613(var3);
				if (Client.groundItems[class36.Client_plane][var6][var7] == null) {
					Client.groundItems[class36.Client_plane][var6][var7] = new NodeDeque();
				}

				Client.groundItems[class36.Client_plane][var6][var7].addFirst(var31);
				class344.updateItemPile(var6, var7);
			}

		} else {
			int var11;
			if (ZoneOperation.field2582 == var0) {
				var2 = var1.readUnsignedByteAdd();
				var3 = var1.readUnsignedByte();
				var4 = (var3 >> 4 & 7) + WorldMapSectionType.field2393;
				var5 = (var3 & 7) + class387.field3646;
				var6 = var1.readUnsignedShortLE();
				var7 = var6 >> 2;
				var8 = var6 & 3;
				var9 = Client.field648[var7];
				if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
					if (var9 == 0) {
						BoundaryObject var32 = UserComparator5.scene.method1233(class36.Client_plane, var4, var5);
						if (var32 != null) {
							var11 = class458.Entity_unpackID(var32.tag);
							if (var7 == 2) {
								var32.renderable1 = new DynamicObject(var11, 2, var8 + 4, class36.Client_plane, var4, var5, var2, false, var32.renderable1);
								var32.renderable2 = new DynamicObject(var11, 2, var8 + 1 & 3, class36.Client_plane, var4, var5, var2, false, var32.renderable2);
							} else {
								var32.renderable1 = new DynamicObject(var11, var7, var8, class36.Client_plane, var4, var5, var2, false, var32.renderable1);
							}

							return;
						}
					}

					if (var9 == 1) {
						WallDecoration var40 = UserComparator5.scene.method1234(class36.Client_plane, var4, var5);
						if (var40 != null) {
							var11 = class458.Entity_unpackID(var40.tag);
							if (var7 != 4 && var7 != 5) {
								if (var7 == 6) {
									var40.renderable1 = new DynamicObject(var11, 4, var8 + 4, class36.Client_plane, var4, var5, var2, false, var40.renderable1);
								} else if (var7 == 7) {
									var40.renderable1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class36.Client_plane, var4, var5, var2, false, var40.renderable1);
								} else if (var7 == 8) {
									var40.renderable1 = new DynamicObject(var11, 4, var8 + 4, class36.Client_plane, var4, var5, var2, false, var40.renderable1);
									var40.renderable2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, class36.Client_plane, var4, var5, var2, false, var40.renderable2);
								}
							} else {
								var40.renderable1 = new DynamicObject(var11, 4, var8, class36.Client_plane, var4, var5, var2, false, var40.renderable1);
							}

							return;
						}
					}

					if (var9 == 2) {
						GameObject var43 = UserComparator5.scene.getGameObject(class36.Client_plane, var4, var5);
						if (var7 == 11) {
							var7 = 10;
						}

						if (var43 != null) {
							var43.renderable = new DynamicObject(class458.Entity_unpackID(var43.tag), var7, var8, class36.Client_plane, var4, var5, var2, false, var43.renderable);
							return;
						}
					}

					if (var9 == 3) {
						FloorDecoration var44 = UserComparator5.scene.getFloorDecoration(class36.Client_plane, var4, var5);
						if (var44 != null) {
							var44.renderable = new DynamicObject(class458.Entity_unpackID(var44.tag), 22, var8, class36.Client_plane, var4, var5, var2, false, var44.renderable);
							return;
						}
					}

					AABB.method1268(class36.Client_plane, var4, var5, var9, var2);
				}

			} else if (ZoneOperation.field2583 == var0) {
				var2 = var1.readUnsignedShortLE();
				var3 = var1.readUnsignedByte();
				var4 = (var3 >> 4 & 7) + WorldMapSectionType.field2393;
				var5 = (var3 & 7) + class387.field3646;
				var6 = var1.readUnsignedShort();
				var7 = var1.readUnsignedShortAddLE();
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					var4 = var4 * 128 + 64;
					var5 = var5 * 128 + 64;
					GraphicsObject var42 = new GraphicsObject(var6, class36.Client_plane, var4, var5, class306.getTileHeight(var4, var5, class36.Client_plane) - var2, var7, Client.cycle);
					Client.graphicsObjects.addFirst(var42);
				}

			} else if (ZoneOperation.field2586 == var0) {
				var2 = var1.method2556();
				var3 = (var2 >> 4 & 7) + WorldMapSectionType.field2393;
				var4 = (var2 & 7) + class387.field3646;
				var5 = var1.readUnsignedShort();
				var6 = var1.method2579();
				var7 = var1.method2579();
				if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
					NodeDeque var41 = Client.groundItems[class36.Client_plane][var3][var4];
					if (var41 != null) {
						for (TileItem var33 = (TileItem)var41.last(); var33 != null; var33 = (TileItem)var41.previous()) {
							if ((var5 & 32767) == var33.id && var6 == var33.quantity) {
								var33.quantity = var7;
								break;
							}
						}

						class344.updateItemPile(var3, var4);
					}
				}

			} else {
				NodeDeque var34;
				if (ZoneOperation.field2588 == var0) {
					var2 = var1.readUnsignedByte();
					var3 = var1.readUnsignedByte();
					var4 = (var3 >> 4 & 7) + WorldMapSectionType.field2393;
					var5 = (var3 & 7) + class387.field3646;
					var6 = var1.readUnsignedShort();
					if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
						var34 = Client.groundItems[class36.Client_plane][var4][var5];
						if (var34 != null) {
							for (var31 = (TileItem)var34.last(); var31 != null; var31 = (TileItem)var34.previous()) {
								if ((var6 & 32767) == var31.id) {
									var31.method613(var2);
									break;
								}
							}
						}
					}

				} else if (ZoneOperation.field2590 == var0) {
					var2 = var1.readUnsignedShortLE();
					var3 = (var2 >> 4 & 7) + WorldMapSectionType.field2393;
					var4 = (var2 & 7) + class387.field3646;
					var5 = var1.method2556();
					var6 = var1.readUnsignedByteAdd();
					var7 = var1.readUnsignedByte();
					var8 = var7 >> 2;
					var9 = var7 & 3;
					var10 = Client.field648[var8];
					if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
						AbstractWorldMapIcon.updatePendingSpawn(class36.Client_plane, var3, var4, var10, var6, var8, var9, var5, 0, -1);
					}

				} else {
					int var12;
					int var13;
					int var14;
					if (ZoneOperation.field2581 == var0) {
						byte var36 = var1.method2559();
						var3 = var1.method2556();
						var4 = (var3 >> 4 & 7) + WorldMapSectionType.field2393;
						var5 = (var3 & 7) + class387.field3646;
						var6 = var1.readUnsignedShortAddLE();
						var7 = var1.readUnsignedByteAdd();
						var8 = var1.readUnsignedShort();
						var9 = var1.readUnsignedShortAddLE();
						byte var38 = var1.readByte();
						var11 = var1.readUnsignedByte();
						var12 = var11 >> 2;
						var13 = var11 & 3;
						var14 = Client.field648[var12];
						byte var15 = var1.method2559();
						byte var16 = var1.readByte();
						Player var17;
						if (var6 == Client.localPlayerIndex) {
							var17 = class136.localPlayer;
						} else {
							var17 = Client.players[var6];
						}

						if (var17 != null) {
							ObjectComposition var18 = class90.getObjectDefinition(var7);
							int var19;
							int var20;
							if (var13 != 1 && var13 != 3) {
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
							int[][] var25 = Tiles.Tiles_heights[class36.Client_plane];
							int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
							int var27 = (var4 << 7) + (var19 << 6);
							int var28 = (var5 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var12, var13, var25, var27, var26, var28);
							if (var29 != null) {
								AbstractWorldMapIcon.updatePendingSpawn(class36.Client_plane, var4, var5, var14, -1, 0, 0, 31, var9 + 1, var8 + 1);
								var17.animationCycleStart = var9 + Client.cycle;
								var17.animationCycleEnd = var8 + Client.cycle;
								var17.attachedModel = var29;
								var17.field911 = var19 * 64 + var4 * 128;
								var17.field914 = var20 * 64 + var5 * 128;
								var17.baseTileHeight = var26;
								byte var30;
								if (var36 > var16) {
									var30 = var36;
									var36 = var16;
									var16 = var30;
								}

								if (var38 > var15) {
									var30 = var38;
									var38 = var15;
									var15 = var30;
								}

								var17.minX = var4 + var36;
								var17.maxX = var4 + var16;
								var17.minY = var5 + var38;
								var17.maxY = var5 + var15;
							}
						}
					}

					if (ZoneOperation.field2584 == var0) {
						var2 = var1.readUnsignedShort();
						var3 = var1.method2573();
						var4 = var1.method2557();
						byte var37 = var1.method2561();
						var6 = var1.method2557();
						var7 = (var6 >> 4 & 7) + WorldMapSectionType.field2393;
						var8 = (var6 & 7) + class387.field3646;
						var9 = var1.method2556();
						var10 = var1.readUnsignedShortAddLE();
						var11 = var1.readUnsignedShortAddLE();
						byte var39 = var1.method2559();
						var13 = var1.method2556() * 4;
						var14 = var1.method2557() * 4;
						var5 = var37 + var7;
						var12 = var39 + var8;
						if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var5 >= 0 && var12 >= 0 && var5 < 104 && var12 < 104 && var11 != 65535) {
							var7 = var7 * 128 + 64;
							var8 = var8 * 128 + 64;
							var5 = var5 * 128 + 64;
							var12 = var12 * 128 + 64;
							Projectile var35 = new Projectile(var11, class36.Client_plane, var7, var8, class306.getTileHeight(var7, var8, class36.Client_plane) - var14, var2 + Client.cycle, var10 + Client.cycle, var9, var4, var3, var13);
							var35.setDestination(var5, var12, class306.getTileHeight(var5, var12, class36.Client_plane) - var13, var2 + Client.cycle);
							Client.projectiles.addFirst(var35);
						}

					} else if (ZoneOperation.field2587 != var0) {
						if (ZoneOperation.field2580 == var0) {
							var2 = var1.readUnsignedShortLE();
							var3 = (var2 >> 4 & 7) + WorldMapSectionType.field2393;
							var4 = (var2 & 7) + class387.field3646;
							var5 = var1.readUnsignedByte();
							var6 = var5 >> 2;
							var7 = var5 & 3;
							var8 = Client.field648[var6];
							if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
								AbstractWorldMapIcon.updatePendingSpawn(class36.Client_plane, var3, var4, var8, -1, var6, var7, 31, 0, -1);
							}

						}
					} else {
						var2 = var1.readUnsignedByteNeg();
						var3 = var1.readUnsignedShort();
						var4 = var1.method2557();
						var5 = (var4 >> 4 & 7) + WorldMapSectionType.field2393;
						var6 = (var4 & 7) + class387.field3646;
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							var34 = Client.groundItems[class36.Client_plane][var5][var6];
							if (var34 != null) {
								for (var31 = (TileItem)var34.last(); var31 != null; var31 = (TileItem)var34.previous()) {
									if ((var3 & 32767) == var31.id && var2 == var31.quantity) {
										var31.remove();
										break;
									}
								}

								if (var34.last() == null) {
									Client.groundItems[class36.Client_plane][var5][var6] = null;
								}

								class344.updateItemPile(var5, var6);
							}
						}

					}
				}
			}
		}
	}
}
