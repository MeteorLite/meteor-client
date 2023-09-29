import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qy")
public class class432 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)Lng;",
		garbageValue = "-17"
	)
	public static GameBuild method2191(int var0) {
		GameBuild[] var1 = class209.method1031();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			GameBuild var3 = var1[var2];
			if (var0 == var3.buildId) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;Lte;I)Ljava/lang/String;",
		garbageValue = "1990083355"
	)
	public static String method2192(CharSequence var0, LoginType var1) {
		if (var0 == null) {
			return null;
		} else {
			int var2 = 0;

			int var3;
			for (var3 = var0.length(); var2 < var3 && DevicePcmPlayerProvider.method82(var0.charAt(var2)); ++var2) {
			}

			while (var3 > var2 && DevicePcmPlayerProvider.method82(var0.charAt(var3 - 1))) {
				--var3;
			}

			int var4 = var3 - var2;
			if (var4 >= 1) {
				byte var6;
				if (var1 == null) {
					var6 = 12;
				} else {
					switch(var1.field4106) {
					case 8:
						var6 = 20;
						break;
					default:
						var6 = 12;
					}
				}

				if (var4 <= var6) {
					StringBuilder var10 = new StringBuilder(var4);

					for (int var11 = var2; var11 < var3; ++var11) {
						char var7 = var0.charAt(var11);
						if (class410.method2108(var7)) {
							char var8;
							switch(var7) {
							case ' ':
							case '-':
							case '_':
							case '\u00a0':
								var8 = '_';
								break;
							case '#':
							case '[':
							case ']':
								var8 = var7;
								break;
							case '\u00c0':
							case '\u00c1':
							case '\u00c2':
							case '\u00c3':
							case '\u00c4':
							case '\u00e0':
							case '\u00e1':
							case '\u00e2':
							case '\u00e3':
							case '\u00e4':
								var8 = 'a';
								break;
							case '\u00c7':
							case '\u00e7':
								var8 = 'c';
								break;
							case '\u00c8':
							case '\u00c9':
							case '\u00ca':
							case '\u00cb':
							case '\u00e8':
							case '\u00e9':
							case '\u00ea':
							case '\u00eb':
								var8 = 'e';
								break;
							case '\u00cd':
							case '\u00ce':
							case '\u00cf':
							case '\u00ed':
							case '\u00ee':
							case '\u00ef':
								var8 = 'i';
								break;
							case '\u00d1':
							case '\u00f1':
								var8 = 'n';
								break;
							case '\u00d2':
							case '\u00d3':
							case '\u00d4':
							case '\u00d5':
							case '\u00d6':
							case '\u00f2':
							case '\u00f3':
							case '\u00f4':
							case '\u00f5':
							case '\u00f6':
								var8 = 'o';
								break;
							case '\u00d9':
							case '\u00da':
							case '\u00db':
							case '\u00dc':
							case '\u00f9':
							case '\u00fa':
							case '\u00fb':
							case '\u00fc':
								var8 = 'u';
								break;
							case '\u00df':
								var8 = 'b';
								break;
							case '\u00ff':
							case '\u0178':
								var8 = 'y';
								break;
							default:
								var8 = Character.toLowerCase(var7);
							}

							if (var8 != 0) {
								var10.append(var8);
							}
						}
					}

					if (var10.length() == 0) {
						return null;
					}

					return var10.toString();
				}
			}

			return null;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "-1639340549"
	)
	static final int method2193(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = Login.method433(var3, var5);
		int var8 = Login.method433(var3 + 1, var5);
		int var9 = Login.method433(var3, var5 + 1);
		int var10 = Login.method433(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
		int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
		int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
		int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
		return var15;
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-2048863537"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (TextureProvider.localPlayer.x >> 7 == Client.destinationX && TextureProvider.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		if (Client.field388) {
			class199.addPlayerToScene(TextureProvider.localPlayer, false);
		}

		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class199.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		TileItem.addNpcsToScene(true);
		WorldMapArchiveLoader.method2420();
		TileItem.addNpcsToScene(false);
		class471.method2366();

		for (GraphicsObject var4 = (GraphicsObject)Client.graphicsObjects.last(); var4 != null; var4 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var4.plane == class87.Client_plane && !var4.isFinished) {
				if (Client.cycle >= var4.cycleStart) {
					var4.advance(Client.field460);
					if (var4.isFinished) {
						var4.remove();
					} else {
						class10.scene.drawEntity(var4.plane, var4.x, var4.y, var4.z, 60, var4, 0, -1L, false);
					}
				}
			} else {
				var4.remove();
			}
		}

		class53.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.method1248();
		Rasterizer2D.method2682();
		int var37 = Client.camAngleX;
		if (Client.field476 / 256 > var37) {
			var37 = Client.field476 / 256;
		}

		if (Client.cameraShaking[4] && Client.cameraMoveIntensity[4] + 128 > var37) {
			var37 = Client.cameraMoveIntensity[4] + 128;
		}

		int var5 = Client.camAngleY & 2047;
		int var6 = ChatChannel.oculusOrbFocalPointX;
		int var7 = class433.field3789;
		int var8 = AbstractWorldMapData.oculusOrbFocalPointY;
		int var9 = var37 * 3 + 600;
		int var12 = var3 - 334;
		if (var12 < 0) {
			var12 = 0;
		} else if (var12 > 100) {
			var12 = 100;
		}

		int var13 = (Client.zoomWidth - Client.zoomHeight) * var12 / 100 + Client.zoomHeight;
		int var11 = var13 * var9 / 256;
		var12 = 2048 - var37 & 2047;
		var13 = 2048 - var5 & 2047;
		int var14 = 0;
		int var15 = 0;
		int var16 = var11;
		int var17;
		int var18;
		int var19;
		if (var12 != 0) {
			var17 = Rasterizer3D.Rasterizer3D_sine[var12];
			var18 = Rasterizer3D.Rasterizer3D_cosine[var12];
			var19 = var18 * var15 - var17 * var11 >> 16;
			var16 = var18 * var11 + var15 * var17 >> 16;
			var15 = var19;
		}

		if (var13 != 0) {
			var17 = Rasterizer3D.Rasterizer3D_sine[var13];
			var18 = Rasterizer3D.Rasterizer3D_cosine[var13];
			var19 = var17 * var16 + var14 * var18 >> 16;
			var16 = var18 * var16 - var14 * var17 >> 16;
			var14 = var19;
		}

		if (Client.isCameraLocked) {
			AbstractUserComparator.field3834 = var6 - var14;
			TriBool.field3849 = var7 - var15;
			JagexCache.field1450 = var8 - var16;
			class14.field36 = var37;
			GrandExchangeOfferOwnWorldComparator.field360 = var5;
		} else {
			Client.cameraX = var6 - var14;
			class17.cameraY = var7 - var15;
			WorldMapArea.cameraZ = var8 - var16;
			class365.cameraPitch = var37;
			WallDecoration.cameraYaw = var5;
		}

		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (ChatChannel.oculusOrbFocalPointX >> 7 != TextureProvider.localPlayer.x >> 7 || AbstractWorldMapData.oculusOrbFocalPointY >> 7 != TextureProvider.localPlayer.y >> 7)) {
			var17 = TextureProvider.localPlayer.plane;
			var18 = (ChatChannel.oculusOrbFocalPointX >> 7) + class20.baseX;
			var19 = (AbstractWorldMapData.oculusOrbFocalPointY >> 7) + class19.baseY;
			PacketBufferNode var20 = ClanChannelMember.getPacketBufferNode(ClientPacket.f20, Client.packetWriter.isaacCipher);
			var20.packetBuffer.writeShortAddLE(var18);
			var20.packetBuffer.writeShortLE(var19);
			var20.packetBuffer.writeInt(Client.field366);
			var20.packetBuffer.writeByteAdd(var17);
			Client.packetWriter.addNode(var20);
		}

		if (!Client.isCameraLocked) {
			var11 = class136.method731();
		} else {
			var11 = class232.method1196();
		}

		var12 = Client.cameraX;
		var13 = class17.cameraY;
		var14 = WorldMapArea.cameraZ;
		var15 = class365.cameraPitch;
		var16 = WallDecoration.cameraYaw;

		for (var17 = 0; var17 < 5; ++var17) {
			if (Client.cameraShaking[var17]) {
				var18 = (int)(Math.random() * (double)(Client.cameraShakeIntensity[var17] * 2 + 1) - (double)Client.cameraShakeIntensity[var17] + Math.sin((double)Client.cameraShakeCycle[var17] * ((double)Client.cameraShakeSpeed[var17] / 100.0D)) * (double)Client.cameraMoveIntensity[var17]);
				if (var17 == 0) {
					Client.cameraX += var18;
				}

				if (var17 == 1) {
					class17.cameraY += var18;
				}

				if (var17 == 2) {
					WorldMapArea.cameraZ += var18;
				}

				if (var17 == 3) {
					WallDecoration.cameraYaw = var18 + WallDecoration.cameraYaw & 2047;
				}

				if (var17 == 4) {
					class365.cameraPitch += var18;
					if (class365.cameraPitch < 128) {
						class365.cameraPitch = 128;
					}

					if (class365.cameraPitch > 383) {
						class365.cameraPitch = 383;
					}
				}
			}
		}

		var17 = MouseHandler.MouseHandler_x;
		var18 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var17 = MouseHandler.MouseHandler_lastPressedX;
			var18 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var17 >= var0 && var17 < var0 + var2 && var18 >= var1 && var18 < var3 + var1) {
			class16.method53(var17 - var0, var18 - var1);
		} else {
			SpotAnimationDefinition.method1038();
		}

		class313.method1648();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		class313.method1648();
		var19 = Rasterizer3D.get3dZoom();
		Rasterizer3D.method1234(class159.client.field121);
		Rasterizer3D.clips.field2290 = Client.viewportZoom;
		class10.scene.draw(Client.cameraX, class17.cameraY, WorldMapArea.cameraZ, class365.cameraPitch, WallDecoration.cameraYaw, var11);
		Rasterizer3D.method1234(false);
		if (Client.renderSelf) {
			Rasterizer2D.method2683();
		}

		Rasterizer3D.clips.field2290 = var19;
		class313.method1648();
		class10.scene.clearTempGameObjects();
		Client.overheadTextLimit = 0;
		boolean var38 = false;
		int var21 = -1;
		int var22 = -1;
		int var23 = Players.Players_count;
		int[] var24 = Players.Players_indices;

		int var25;
		for (var25 = 0; var25 < var23 + Client.npcCount; ++var25) {
			Object var26;
			if (var25 < var23) {
				var26 = Client.players[var24[var25]];
				if (var24[var25] == Client.combatTargetPlayerIndex) {
					var38 = true;
					var21 = var25;
					continue;
				}

				if (var26 == TextureProvider.localPlayer) {
					var22 = var25;
					continue;
				}
			} else {
				var26 = Client.npcs[Client.npcIndices[var25 - var23]];
			}

			class232.drawActor2d((Actor)var26, var25, var0, var1, var2, var3);
		}

		if (Client.field388 && var22 != -1) {
			class232.drawActor2d(TextureProvider.localPlayer, var22, var0, var1, var2, var3);
		}

		if (var38) {
			class232.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var21, var0, var1, var2, var3);
		}

		for (var25 = 0; var25 < Client.overheadTextLimit; ++var25) {
			int var39 = Client.overheadTextXs[var25];
			int var27 = Client.overheadTextYs[var25];
			int var28 = Client.overheadTextXOffsets[var25];
			int var29 = Client.overheadTextAscents[var25];
			boolean var30 = true;

			while (var30) {
				var30 = false;

				for (int var31 = 0; var31 < var25; ++var31) {
					if (var27 + 2 > Client.overheadTextYs[var31] - Client.overheadTextAscents[var31] && var27 - var29 < Client.overheadTextYs[var31] + 2 && var39 - var28 < Client.overheadTextXOffsets[var31] + Client.overheadTextXs[var31] && var28 + var39 > Client.overheadTextXs[var31] - Client.overheadTextXOffsets[var31] && Client.overheadTextYs[var31] - Client.overheadTextAscents[var31] < var27) {
						var27 = Client.overheadTextYs[var31] - Client.overheadTextAscents[var31];
						var30 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var25];
			Client.viewportTempY = Client.overheadTextYs[var25] = var27;
			String var40 = Client.field602[var25];
			if (Client.chatEffects == 0) {
				int var32 = 16776960;
				if (Client.overheadTextColors[var25] < 6) {
					var32 = Client.field580[Client.overheadTextColors[var25]];
				}

				if (Client.overheadTextColors[var25] == 6) {
					var32 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var25] == 7) {
					var32 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var25] == 8) {
					var32 = Client.viewportDrawCount % 20 < 10 ? '\ub000' : 8454016;
				}

				int var33;
				if (Client.overheadTextColors[var25] == 9) {
					var33 = 150 - Client.overheadTextCyclesRemaining[var25];
					if (var33 < 50) {
						var32 = var33 * 1280 + 16711680;
					} else if (var33 < 100) {
						var32 = 16776960 - (var33 - 50) * 327680;
					} else if (var33 < 150) {
						var32 = (var33 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var25] == 10) {
					var33 = 150 - Client.overheadTextCyclesRemaining[var25];
					if (var33 < 50) {
						var32 = var33 * 5 + 16711680;
					} else if (var33 < 100) {
						var32 = 16711935 - (var33 - 50) * 327680;
					} else if (var33 < 150) {
						var32 = (var33 - 100) * 327680 + 255 - (var33 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var25] == 11) {
					var33 = 150 - Client.overheadTextCyclesRemaining[var25];
					if (var33 < 50) {
						var32 = 16777215 - var33 * 327685;
					} else if (var33 < 100) {
						var32 = (var33 - 50) * 327685 + 65280;
					} else if (var33 < 150) {
						var32 = 16777215 - (var33 - 100) * 327680;
					}
				}

				int var34;
				if (Client.overheadTextColors[var25] == 12 && Client.field595[var25] == null) {
					var33 = var40.length();
					Client.field595[var25] = new int[var33];

					for (var34 = 0; var34 < var33; ++var34) {
						int var35 = (int)(64.0F * ((float)var34 / (float)var33));
						int var36 = var35 << 10 | 896 | 64;
						Client.field595[var25][var34] = class481.field3942[var36];
					}
				}

				if (Client.overheadTextEffects[var25] == 0) {
					SoundCache.fontBold12.method2130(var40, var0 + Client.viewportTempX, Client.viewportTempY + var1, var32, 0, Client.field595[var25]);
				}

				if (Client.overheadTextEffects[var25] == 1) {
					SoundCache.fontBold12.method2127(var40, var0 + Client.viewportTempX, Client.viewportTempY + var1, var32, 0, Client.viewportDrawCount, Client.field595[var25]);
				}

				if (Client.overheadTextEffects[var25] == 2) {
					SoundCache.fontBold12.method2128(var40, var0 + Client.viewportTempX, Client.viewportTempY + var1, var32, 0, Client.viewportDrawCount, Client.field595[var25]);
				}

				if (Client.overheadTextEffects[var25] == 3) {
					SoundCache.fontBold12.method2129(var40, var0 + Client.viewportTempX, Client.viewportTempY + var1, var32, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var25], Client.field595[var25]);
				}

				if (Client.overheadTextEffects[var25] == 4) {
					var33 = (150 - Client.overheadTextCyclesRemaining[var25]) * (SoundCache.fontBold12.stringWidth(var40) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					SoundCache.fontBold12.method2131(var40, var0 + Client.viewportTempX + 50 - var33, Client.viewportTempY + var1, var32, 0, Client.field595[var25]);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var25] == 5) {
					var33 = 150 - Client.overheadTextCyclesRemaining[var25];
					var34 = 0;
					if (var33 < 25) {
						var34 = var33 - 25;
					} else if (var33 > 125) {
						var34 = var33 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - SoundCache.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					SoundCache.fontBold12.method2130(var40, var0 + Client.viewportTempX, var34 + Client.viewportTempY + var1, var32, 0, Client.field595[var25]);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				SoundCache.fontBold12.drawCentered(var40, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		HealthBarDefinition.method991(var0, var1);
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).animate(Client.field460);
		ConcurrentMidiTask.method2173();
		Client.cameraX = var12;
		class17.cameraY = var13;
		WorldMapArea.cameraZ = var14;
		class365.cameraPitch = var15;
		WallDecoration.cameraYaw = var16;
		if (Client.isLoading && class59.field309.method1968(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class427.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}