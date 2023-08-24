import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class132 implements class371 {
	@ObfuscatedName("wu")
	static long field1272;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1288;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1277;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1283;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1287;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1275;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1280;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1289;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1284;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1273;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1278;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1276;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1285;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1281;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1282;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1286;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1274;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class132 field1279;
	@ObfuscatedName("am")
	final int field1291;
	@ObfuscatedName("ax")
	final int field1292;
	@ObfuscatedName("ah")
	final int field1290;

	static {
		field1288 = new class132(0, 0, (String)null, -1, -1);
		field1277 = new class132(1, 1, (String)null, 0, 2);
		field1283 = new class132(2, 2, (String)null, 1, 2);
		field1287 = new class132(3, 3, (String)null, 2, 2);
		field1275 = new class132(4, 4, (String)null, 3, 1);
		field1280 = new class132(5, 5, (String)null, 4, 1);
		field1289 = new class132(6, 6, (String)null, 5, 1);
		field1284 = new class132(7, 7, (String)null, 6, 3);
		field1273 = new class132(8, 8, (String)null, 7, 3);
		field1278 = new class132(9, 9, (String)null, 8, 3);
		field1276 = new class132(10, 10, (String)null, 0, 7);
		field1285 = new class132(11, 11, (String)null, 1, 7);
		field1281 = new class132(12, 12, (String)null, 2, 7);
		field1282 = new class132(13, 13, (String)null, 3, 7);
		field1286 = new class132(14, 14, (String)null, 4, 7);
		field1274 = new class132(15, 15, (String)null, 5, 7);
		field1279 = new class132(16, 16, (String)null, 0, 5);
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;II)V",
		garbageValue = "-1"
	)
	class132(int var1, int var2, String var3, int var4, int var5) {
		this.field1291 = var1;
		this.field1292 = var2;
		this.field1290 = var4;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1552695494"
	)
	int method733() {
		return this.field1290;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1292;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([BIIIIIIIII[Lis;I)V",
		garbageValue = "388906105"
	)
	static final void method734(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, CollisionMap[] var10) {
		int var12;
		for (int var11 = 0; var11 < 8; ++var11) {
			for (var12 = 0; var12 < 8; ++var12) {
				if (var11 + var2 > 0 && var11 + var2 < 103 && var3 + var12 > 0 && var3 + var12 < 103) {
					int[] var10000 = var10[var1].flags[var11 + var2];
					var10000[var12 + var3] &= -16777217;
				}
			}
		}

		Buffer var19 = new Buffer(var0);

		for (var12 = 0; var12 < 4; ++var12) {
			for (int var13 = 0; var13 < 64; ++var13) {
				for (int var14 = 0; var14 < 64; ++var14) {
					if (var12 == var4 && var13 >= var5 && var13 < var5 + 8 && var14 >= var6 && var14 < var6 + 8) {
						int var15 = var2 + class85.method470(var13 & 7, var14 & 7, var7);
						int var16 = var3 + class144.method772(var13 & 7, var14 & 7, var7);
						int var17 = (var13 & 7) + var8 + var2;
						int var18 = var3 + (var14 & 7) + var9;
						SecureRandomFuture.loadTerrain(var19, var1, var15, var16, var17, var18, var7);
					} else {
						SecureRandomFuture.loadTerrain(var19, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-1398962204"
	)
	static int method735(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
		if (var0 == 1500) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == 1501) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == 1502) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 1503) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 1504) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 1505) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-124816622"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (VarbitComposition.localPlayer.x >> 7 == Client.destinationX && VarbitComposition.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		RouteStrategy.method1125();
		InterfaceParent.method475();
		WorldMapData_0.addNpcsToScene(true);
		class147.method785();
		WorldMapData_0.addNpcsToScene(false);

		int var6;
		for (Projectile var4 = (Projectile)Client.projectiles.last(); var4 != null; var4 = (Projectile)Client.projectiles.previous()) {
			if (var4.plane == HealthBar.Client_plane && Client.cycle <= var4.cycleEnd) {
				if (Client.cycle >= var4.cycleStart) {
					NPC var5;
					Player var40;
					if (!var4.isMoving && var4.field797 != 0) {
						if (var4.field797 > 0) {
							var5 = Client.npcs[var4.field797 - 1];
							if (var5 != null && var5.x >= 0 && var5.x < 13312 && var5.y >= 0 && var5.y < 13312) {
								var4.sourceX = var5.x;
								var4.sourceY = var5.y;
								var4.setDestination(var4.field805, var4.field799, var4.field789, Client.cycle);
							}
						} else {
							var6 = -var4.field797 - 1;
							if (var6 == Client.localPlayerIndex) {
								var40 = VarbitComposition.localPlayer;
							} else {
								var40 = Client.players[var6];
							}

							if (var40 != null && var40.x >= 0 && var40.x < 13312 && var40.y >= 0 && var40.y < 13312) {
								var4.sourceX = var40.x;
								var4.sourceY = var40.y;
								var4.setDestination(var4.field805, var4.field799, var4.field789, Client.cycle);
							}
						}
					}

					if (var4.targetIndex > 0) {
						var5 = Client.npcs[var4.targetIndex - 1];
						if (var5 != null && var5.x >= 0 && var5.x < 13312 && var5.y >= 0 && var5.y < 13312) {
							var4.setDestination(var5.x, var5.y, class18.getTileHeight(var5.x, var5.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					if (var4.targetIndex < 0) {
						var6 = -var4.targetIndex - 1;
						if (var6 == Client.localPlayerIndex) {
							var40 = VarbitComposition.localPlayer;
						} else {
							var40 = Client.players[var6];
						}

						if (var40 != null && var40.x >= 0 && var40.x < 13312 && var40.y >= 0 && var40.y < 13312) {
							var4.setDestination(var40.x, var40.y, class18.getTileHeight(var40.x, var40.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					var4.advance(Client.field457);
					class130.scene.drawEntity(HealthBar.Client_plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1L, false);
				}
			} else {
				var4.remove();
			}
		}

		class167.method874();
		GrandExchangeOfferOwnWorldComparator.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.method1199();
		Rasterizer2D.method2643();
		int var36 = Client.camAngleX;
		if (Client.field467 / 256 > var36) {
			var36 = Client.field467 / 256;
		}

		if (Client.cameraShaking[4] && Client.cameraMoveIntensity[4] + 128 > var36) {
			var36 = Client.cameraMoveIntensity[4] + 128;
		}

		int var37 = Client.camAngleY & 2047;
		var6 = FriendLoginUpdate.oculusOrbFocalPointX;
		int var7 = class125.field1194;
		int var8 = HealthBar.oculusOrbFocalPointY;
		int var9 = class172.method907(var36);
		int var11 = var3 - 334;
		if (var11 < 0) {
			var11 = 0;
		} else if (var11 > 100) {
			var11 = 100;
		}

		int var12 = (Client.zoomWidth - Client.zoomHeight) * var11 / 100 + Client.zoomHeight;
		int var10 = var12 * var9 / 256;
		var11 = 2048 - var36 & 2047;
		var12 = 2048 - var37 & 2047;
		int var13 = 0;
		int var14 = 0;
		int var15 = var10;
		int var16;
		int var17;
		int var18;
		if (var11 != 0) {
			var16 = Rasterizer3D.Rasterizer3D_sine[var11];
			var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
			var18 = var17 * var14 - var16 * var10 >> 16;
			var15 = var17 * var10 + var16 * var14 >> 16;
			var14 = var18;
		}

		if (var12 != 0) {
			var16 = Rasterizer3D.Rasterizer3D_sine[var12];
			var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
			var18 = var16 * var15 + var13 * var17 >> 16;
			var15 = var17 * var15 - var13 * var16 >> 16;
			var13 = var18;
		}

		if (Client.isCameraLocked) {
			FontName.field4045 = var6 - var13;
			KeyHandler.field70 = var7 - var14;
			class31.field84 = var8 - var15;
			UserComparator4.field1180 = var36;
			VertexNormal.field2255 = var37;
		} else {
			NPCComposition.cameraX = var6 - var13;
			class133.cameraY = var7 - var14;
			class139.cameraZ = var8 - var15;
			class129.cameraPitch = var36;
			UserComparator10.cameraYaw = var37;
		}

		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (FriendLoginUpdate.oculusOrbFocalPointX >> 7 != VarbitComposition.localPlayer.x >> 7 || HealthBar.oculusOrbFocalPointY >> 7 != VarbitComposition.localPlayer.y >> 7)) {
			var16 = VarbitComposition.localPlayer.plane;
			var17 = (FriendLoginUpdate.oculusOrbFocalPointX >> 7) + UrlRequester.baseX;
			var18 = (HealthBar.oculusOrbFocalPointY >> 7) + class47.baseY;
			NPC.method597(var17, var18, var16, true);
		}

		int var20;
		if (!Client.isCameraLocked) {
			if (class449.clientPreferences.getRoofsHidden()) {
				var11 = HealthBar.Client_plane;
			} else {
				label577: {
					var12 = 3;
					if (class129.cameraPitch < 310) {
						if (Client.oculusOrbState == 1) {
							var13 = FriendLoginUpdate.oculusOrbFocalPointX >> 7;
							var14 = HealthBar.oculusOrbFocalPointY >> 7;
						} else {
							var13 = VarbitComposition.localPlayer.x >> 7;
							var14 = VarbitComposition.localPlayer.y >> 7;
						}

						var15 = NPCComposition.cameraX >> 7;
						var16 = class139.cameraZ >> 7;
						if (var15 < 0 || var16 < 0 || var15 >= 104 || var16 >= 104) {
							var11 = HealthBar.Client_plane;
							break label577;
						}

						if (var13 < 0 || var14 < 0 || var13 >= 104 || var14 >= 104) {
							var11 = HealthBar.Client_plane;
							break label577;
						}

						if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][var15][var16] & 4) != 0) {
							var12 = HealthBar.Client_plane;
						}

						if (var13 > var15) {
							var17 = var13 - var15;
						} else {
							var17 = var15 - var13;
						}

						if (var14 > var16) {
							var18 = var14 - var16;
						} else {
							var18 = var16 - var14;
						}

						int var19;
						if (var17 > var18) {
							var19 = var18 * 65536 / var17;
							var20 = 32768;

							while (var15 != var13) {
								if (var15 < var13) {
									++var15;
								} else if (var15 > var13) {
									--var15;
								}

								if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][var15][var16] & 4) != 0) {
									var12 = HealthBar.Client_plane;
								}

								var20 += var19;
								if (var20 >= 65536) {
									var20 -= 65536;
									if (var16 < var14) {
										++var16;
									} else if (var16 > var14) {
										--var16;
									}

									if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][var15][var16] & 4) != 0) {
										var12 = HealthBar.Client_plane;
									}
								}
							}
						} else if (var18 > 0) {
							var19 = var17 * 65536 / var18;
							var20 = 32768;

							while (var14 != var16) {
								if (var16 < var14) {
									++var16;
								} else if (var16 > var14) {
									--var16;
								}

								if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][var15][var16] & 4) != 0) {
									var12 = HealthBar.Client_plane;
								}

								var20 += var19;
								if (var20 >= 65536) {
									var20 -= 65536;
									if (var15 < var13) {
										++var15;
									} else if (var15 > var13) {
										--var15;
									}

									if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][var15][var16] & 4) != 0) {
										var12 = HealthBar.Client_plane;
									}
								}
							}
						}
					}

					if (VarbitComposition.localPlayer.x >= 0 && VarbitComposition.localPlayer.y >= 0 && VarbitComposition.localPlayer.x < 13312 && VarbitComposition.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[HealthBar.Client_plane][VarbitComposition.localPlayer.x >> 7][VarbitComposition.localPlayer.y >> 7] & 4) != 0) {
							var12 = HealthBar.Client_plane;
						}

						var11 = var12;
					} else {
						var11 = HealthBar.Client_plane;
					}
				}
			}

			var10 = var11;
		} else {
			var10 = StructComposition.method1024();
		}

		var11 = NPCComposition.cameraX;
		var12 = class133.cameraY;
		var13 = class139.cameraZ;
		var14 = class129.cameraPitch;
		var15 = UserComparator10.cameraYaw;

		for (var16 = 0; var16 < 5; ++var16) {
			if (Client.cameraShaking[var16]) {
				var17 = (int)(Math.random() * (double)(Client.cameraShakeIntensity[var16] * 2 + 1) - (double)Client.cameraShakeIntensity[var16] + Math.sin((double)Client.cameraShakeSpeed[var16] / 100.0D * (double)Client.cameraShakeCycle[var16]) * (double)Client.cameraMoveIntensity[var16]);
				if (var16 == 0) {
					NPCComposition.cameraX += var17;
				}

				if (var16 == 1) {
					class133.cameraY += var17;
				}

				if (var16 == 2) {
					class139.cameraZ += var17;
				}

				if (var16 == 3) {
					UserComparator10.cameraYaw = var17 + UserComparator10.cameraYaw & 2047;
				}

				if (var16 == 4) {
					class129.cameraPitch += var17;
					if (class129.cameraPitch < 128) {
						class129.cameraPitch = 128;
					}

					if (class129.cameraPitch > 383) {
						class129.cameraPitch = 383;
					}
				}
			}
		}

		var16 = MouseHandler.MouseHandler_x;
		var17 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var16 = MouseHandler.MouseHandler_lastPressedX;
			var17 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var16 >= var0 && var16 < var0 + var2 && var17 >= var1 && var17 < var3 + var1) {
			MenuAction.method425(var16 - var0, var17 - var1);
		} else {
			Players.method619();
		}

		class301.method1622();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		class301.method1622();
		var18 = Rasterizer3D.get3dZoom();
		Rasterizer3D.method1185(class219.client.field123);
		Rasterizer3D.clips.field2280 = Client.viewportZoom;
		class130.scene.draw(NPCComposition.cameraX, class133.cameraY, class139.cameraZ, class129.cameraPitch, UserComparator10.cameraYaw, var10);
		Rasterizer3D.method1185(false);
		if (Client.renderSelf) {
			Rasterizer2D.method2644();
		}

		Rasterizer3D.clips.field2280 = var18;
		class301.method1622();
		class130.scene.clearTempGameObjects();
		Client.overheadTextLimit = 0;
		boolean var41 = false;
		var20 = -1;
		int var21 = -1;
		int var22 = Players.Players_count;
		int[] var23 = Players.Players_indices;

		int var24;
		for (var24 = 0; var24 < var22 + Client.npcCount; ++var24) {
			Object var25;
			if (var24 < var22) {
				var25 = Client.players[var23[var24]];
				if (var23[var24] == Client.combatTargetPlayerIndex) {
					var41 = true;
					var20 = var24;
					continue;
				}

				if (var25 == VarbitComposition.localPlayer) {
					var21 = var24;
					continue;
				}
			} else {
				var25 = Client.npcs[Client.npcIndices[var24 - var22]];
			}

			PcmPlayer.drawActor2d((Actor)var25, var24, var0, var1, var2, var3);
		}

		if (Client.field386 && var21 != -1) {
			PcmPlayer.drawActor2d(VarbitComposition.localPlayer, var21, var0, var1, var2, var3);
		}

		if (var41) {
			PcmPlayer.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var20, var0, var1, var2, var3);
		}

		for (var24 = 0; var24 < Client.overheadTextLimit; ++var24) {
			int var38 = Client.overheadTextXs[var24];
			int var26 = Client.overheadTextYs[var24];
			int var27 = Client.overheadTextXOffsets[var24];
			int var28 = Client.overheadTextAscents[var24];
			boolean var29 = true;

			while (var29) {
				var29 = false;

				for (int var30 = 0; var30 < var24; ++var30) {
					if (var26 + 2 > Client.overheadTextYs[var30] - Client.overheadTextAscents[var30] && var26 - var28 < Client.overheadTextYs[var30] + 2 && var38 - var27 < Client.overheadTextXOffsets[var30] + Client.overheadTextXs[var30] && var38 + var27 > Client.overheadTextXs[var30] - Client.overheadTextXOffsets[var30] && Client.overheadTextYs[var30] - Client.overheadTextAscents[var30] < var26) {
						var26 = Client.overheadTextYs[var30] - Client.overheadTextAscents[var30];
						var29 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var24];
			Client.viewportTempY = Client.overheadTextYs[var24] = var26;
			String var39 = Client.field603[var24];
			if (Client.chatEffects == 0) {
				int var31 = 16776960;
				if (Client.overheadTextColors[var24] < 6) {
					var31 = Client.field579[Client.overheadTextColors[var24]];
				}

				if (Client.overheadTextColors[var24] == 6) {
					var31 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var24] == 7) {
					var31 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var24] == 8) {
					var31 = Client.viewportDrawCount % 20 < 10 ? '\ub000' : 8454016;
				}

				int var32;
				if (Client.overheadTextColors[var24] == 9) {
					var32 = 150 - Client.overheadTextCyclesRemaining[var24];
					if (var32 < 50) {
						var31 = var32 * 1280 + 16711680;
					} else if (var32 < 100) {
						var31 = 16776960 - (var32 - 50) * 327680;
					} else if (var32 < 150) {
						var31 = (var32 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var24] == 10) {
					var32 = 150 - Client.overheadTextCyclesRemaining[var24];
					if (var32 < 50) {
						var31 = var32 * 5 + 16711680;
					} else if (var32 < 100) {
						var31 = 16711935 - (var32 - 50) * 327680;
					} else if (var32 < 150) {
						var31 = (var32 - 100) * 327680 + 255 - (var32 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var24] == 11) {
					var32 = 150 - Client.overheadTextCyclesRemaining[var24];
					if (var32 < 50) {
						var31 = 16777215 - var32 * 327685;
					} else if (var32 < 100) {
						var31 = (var32 - 50) * 327685 + 65280;
					} else if (var32 < 150) {
						var31 = 16777215 - (var32 - 100) * 327680;
					}
				}

				int var33;
				if (Client.overheadTextColors[var24] == 12 && Client.field594[var24] == null) {
					var32 = var39.length();
					Client.field594[var24] = new int[var32];

					for (var33 = 0; var33 < var32; ++var33) {
						int var34 = (int)(64.0F * ((float)var33 / (float)var32));
						int var35 = var34 << 10 | 896 | 64;
						Client.field594[var24][var33] = class466.field3911[var35];
					}
				}

				if (Client.overheadTextEffects[var24] == 0) {
					class59.fontBold12.method2098(var39, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.field594[var24]);
				}

				if (Client.overheadTextEffects[var24] == 1) {
					class59.fontBold12.method2095(var39, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.viewportDrawCount, Client.field594[var24]);
				}

				if (Client.overheadTextEffects[var24] == 2) {
					class59.fontBold12.method2096(var39, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.viewportDrawCount, Client.field594[var24]);
				}

				if (Client.overheadTextEffects[var24] == 3) {
					class59.fontBold12.method2097(var39, var0 + Client.viewportTempX, Client.viewportTempY + var1, var31, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var24], Client.field594[var24]);
				}

				if (Client.overheadTextEffects[var24] == 4) {
					var32 = (150 - Client.overheadTextCyclesRemaining[var24]) * (class59.fontBold12.stringWidth(var39) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					class59.fontBold12.method2099(var39, var0 + Client.viewportTempX + 50 - var32, Client.viewportTempY + var1, var31, 0, Client.field594[var24]);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var24] == 5) {
					var32 = 150 - Client.overheadTextCyclesRemaining[var24];
					var33 = 0;
					if (var32 < 25) {
						var33 = var32 - 25;
					} else if (var32 > 125) {
						var33 = var32 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class59.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					class59.fontBold12.method2098(var39, var0 + Client.viewportTempX, var33 + Client.viewportTempY + var1, var31, 0, Client.field594[var24]);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				class59.fontBold12.drawCentered(var39, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		ItemContainer.method469(var0, var1);
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).animate(Client.field457);
		class153.method805(var0, var1, var2, var3);
		NPCComposition.cameraX = var11;
		class133.cameraY = var12;
		class139.cameraZ = var13;
		class129.cameraPitch = var14;
		UserComparator10.cameraYaw = var15;
		if (Client.isLoading && class308.field2819.method1939(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			FadeInTask.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}