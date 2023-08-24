import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("og")
public class class370 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Log;"
	)
	static final class370 field3598;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Log;"
	)
	static final class370 field3595;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Log;"
	)
	static final class370 field3596;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Log;"
	)
	static final class370 field3597;
	@ObfuscatedName("br")
	@Export("hasFocus")
	protected static boolean hasFocus;

	static {
		field3598 = new class370();
		field3595 = new class370();
		field3596 = new class370();
		field3597 = new class370();
	}

	class370() {
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2133764143"
	)
	static final void method1968() {
		class108.method621(false);
		Client.field452 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < UserComparator5.regionLandArchives.length; ++var1) {
			if (class59.regionMapArchiveIds[var1] != -1 && UserComparator5.regionLandArchives[var1] == null) {
				UserComparator5.regionLandArchives[var1] = class499.archive9.takeFile(class59.regionMapArchiveIds[var1], 0);
				if (UserComparator5.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field452;
				}
			}

			if (ObjTypeCustomisation.regionLandArchiveIds[var1] != -1 && class197.regionMapArchives[var1] == null) {
				class197.regionMapArchives[var1] = class499.archive9.takeFileEncrypted(ObjTypeCustomisation.regionLandArchiveIds[var1], 0, RunException.xteaKeys[var1]);
				if (class197.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field452;
				}
			}
		}

		if (!var0) {
			Client.field456 = 1;
		} else {
			Client.field455 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < UserComparator5.regionLandArchives.length; ++var1) {
				byte[] var2 = class197.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (class191.regions[var1] >> 8) * 64 - UrlRequester.baseX;
					var4 = (class191.regions[var1] & 255) * 64 - class47.baseY;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= class142.method768(var2, var3, var4);
				}
			}

			if (!var0) {
				Client.field456 = 2;
			} else {
				if (Client.field456 != 0) {
					FadeInTask.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				class301.method1622();
				class130.scene.clear();

				for (var1 = 0; var1 < 4; ++var1) {
					Client.collisionMaps[var1].clear();
				}

				int var15;
				for (var1 = 0; var1 < 4; ++var1) {
					for (var15 = 0; var15 < 104; ++var15) {
						for (var3 = 0; var3 < 104; ++var3) {
							Tiles.Tiles_renderFlags[var1][var15][var3] = 0;
						}
					}
				}

				class301.method1622();
				Language.method1973();
				var1 = UserComparator5.regionLandArchives.length;
				class388.method2029();
				class108.method621(true);
				int var17;
				if (!Client.isInInstance) {
					byte[] var5;
					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (class191.regions[var15] >> 8) * 64 - UrlRequester.baseX;
						var4 = (class191.regions[var15] & 255) * 64 - class47.baseY;
						var5 = UserComparator5.regionLandArchives[var15];
						if (var5 != null) {
							class301.method1622();
							class261.method1500(var5, var3, var4, Tiles.timeOfPreviousKeyPress * 8 - 48, MouseRecorder.field873 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (class191.regions[var15] >> 8) * 64 - UrlRequester.baseX;
						var4 = (class191.regions[var15] & 255) * 64 - class47.baseY;
						var5 = UserComparator5.regionLandArchives[var15];
						if (var5 == null && MouseRecorder.field873 < 800) {
							class301.method1622();
							class17.method49(var3, var4, 64, 64);
						}
					}

					class108.method621(true);

					for (var15 = 0; var15 < var1; ++var15) {
						byte[] var16 = class197.regionMapArchives[var15];
						if (var16 != null) {
							var4 = (class191.regions[var15] >> 8) * 64 - UrlRequester.baseX;
							var17 = (class191.regions[var15] & 255) * 64 - class47.baseY;
							class301.method1622();
							FriendsChat.method2206(var16, var4, var17, class130.scene, Client.collisionMaps);
						}
					}
				}

				int var6;
				int var7;
				int var8;
				if (Client.isInInstance) {
					int var9;
					int var10;
					int var11;
					for (var15 = 0; var15 < 4; ++var15) {
						class301.method1622();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								boolean var19 = false;
								var6 = Client.instanceChunkTemplates[var15][var3][var4];
								if (var6 != -1) {
									var7 = var6 >> 24 & 3;
									var8 = var6 >> 1 & 3;
									var9 = var6 >> 14 & 1023;
									var10 = var6 >> 3 & 2047;
									var11 = (var9 / 8 << 8) + var10 / 8;

									for (int var12 = 0; var12 < class191.regions.length; ++var12) {
										if (class191.regions[var12] == var11 && UserComparator5.regionLandArchives[var12] != null) {
											int var13 = (var9 - var3) * 8;
											int var14 = (var10 - var4) * 8;
											class132.method734(UserComparator5.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
											var19 = true;
											break;
										}
									}
								}

								if (!var19) {
									class372.method1970(var15, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var15 = 0; var15 < 13; ++var15) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var15][var3];
							if (var4 == -1) {
								class17.method49(var15 * 8, var3 * 8, 8, 8);
							}
						}
					}

					class108.method621(true);

					for (var15 = 0; var15 < 4; ++var15) {
						class301.method1622();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var17 = Client.instanceChunkTemplates[var15][var3][var4];
								if (var17 != -1) {
									var6 = var17 >> 24 & 3;
									var7 = var17 >> 1 & 3;
									var8 = var17 >> 14 & 1023;
									var9 = var17 >> 3 & 2047;
									var10 = (var8 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < class191.regions.length; ++var11) {
										if (class191.regions[var11] == var10 && class197.regionMapArchives[var11] != null) {
											Tiles.method459(class197.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class130.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				class108.method621(true);
				class301.method1622();
				class129.method717(class130.scene, Client.collisionMaps);
				class108.method621(true);
				var15 = Tiles.Tiles_minPlane;
				if (var15 > HealthBar.Client_plane) {
					var15 = HealthBar.Client_plane;
				}

				if (var15 < HealthBar.Client_plane - 1) {
					var15 = HealthBar.Client_plane - 1;
				}

				if (Client.isLowDetail) {
					class130.scene.init(Tiles.Tiles_minPlane);
				} else {
					class130.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						class135.updateItemPile(var3, var4);
					}
				}

				class301.method1622();
				class165.method869();
				ObjectComposition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var18;
				if (class219.client.hasFrame()) {
					var18 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.DETECT_MODIFIED_CLIENT, Client.packetWriter.isaacCipher);
					var18.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var18);
				}

				if (!Client.isInInstance) {
					var3 = (Tiles.timeOfPreviousKeyPress - 6) / 8;
					var4 = (Tiles.timeOfPreviousKeyPress + 6) / 8;
					var17 = (MouseRecorder.field873 - 6) / 8;
					var6 = (MouseRecorder.field873 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
							if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
								class499.archive9.loadRegionFromName("m" + var7 + "_" + var8);
								class499.archive9.loadRegionFromName("l" + var7 + "_" + var8);
							}
						}
					}
				}

				MusicSong.updateGameState(30);
				class301.method1622();
				ObjectSound.method414();
				var18 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.MAP_BUILD_COMPLETE, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var18);
				PacketWriter.method645();
			}
		}
	}
}