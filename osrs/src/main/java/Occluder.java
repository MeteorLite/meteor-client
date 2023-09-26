import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("ac")
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("al")
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("ak")
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("ax")
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("ao")
	@Export("type")
	int type;
	@ObfuscatedName("ah")
	@Export("minX")
	int minX;
	@ObfuscatedName("ar")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("ab")
	@Export("minZ")
	int minZ;
	@ObfuscatedName("am")
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("av")
	@Export("minY")
	int minY;
	@ObfuscatedName("ag")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("aa")
	int field2135;
	@ObfuscatedName("ap")
	int field2146;
	@ObfuscatedName("ay")
	int field2152;
	@ObfuscatedName("as")
	int field2148;
	@ObfuscatedName("aj")
	int field2140;
	@ObfuscatedName("an")
	int field2144;
	@ObfuscatedName("au")
	int field2149;

	Occluder() {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "-104"
	)
	static int method1340(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1093816432"
	)
	static final void method1341() {
		class193.method964(false);
		Client.field454 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < class345.regionLandArchives.length; ++var1) {
			if (HorizontalAlignment.regionMapArchiveIds[var1] != -1 && class345.regionLandArchives[var1] == null) {
				class345.regionLandArchives[var1] = class198.archive9.takeFile(HorizontalAlignment.regionMapArchiveIds[var1], 0);
				if (class345.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field454;
				}
			}

			if (WorldMapIcon_0.regionLandArchiveIds[var1] != -1 && class201.regionMapArchives[var1] == null) {
				class201.regionMapArchives[var1] = class198.archive9.takeFileEncrypted(WorldMapIcon_0.regionLandArchiveIds[var1], 0, class178.xteaKeys[var1]);
				if (class201.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field454;
				}
			}
		}

		if (!var0) {
			Client.field453 = 1;
		} else {
			Client.field455 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < class345.regionLandArchives.length; ++var1) {
				byte[] var2 = class201.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (class152.regions[var1] >> 8) * 64 - class20.baseX;
					var4 = (class152.regions[var1] & 255) * 64 - class19.baseY;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= class208.method1028(var2, var3, var4);
				}
			}

			if (!var0) {
				Client.field453 = 2;
			} else {
				if (Client.field453 != 0) {
					class427.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				class313.method1648();
				class10.scene.clear();

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

				class313.method1648();
				ObjTypeCustomisation.method948();
				var1 = class345.regionLandArchives.length;
				SoundCache.method228();
				class193.method964(true);
				int var17;
				if (!Client.isInInstance) {
					byte[] var5;
					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (class152.regions[var15] >> 8) * 64 - class20.baseX;
						var4 = (class152.regions[var15] & 255) * 64 - class19.baseY;
						var5 = class345.regionLandArchives[var15];
						if (var5 != null) {
							class313.method1648();
							BufferedSource.method2298(var5, var3, var4, class94.timeOfPreviousKeyPress * 8 - 48, class365.field3199 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (class152.regions[var15] >> 8) * 64 - class20.baseX;
						var4 = (class152.regions[var15] & 255) * 64 - class19.baseY;
						var5 = class345.regionLandArchives[var15];
						if (var5 == null && class365.field3199 < 800) {
							class313.method1648();
							Decimator.method317(var3, var4, 64, 64);
						}
					}

					class193.method964(true);

					for (var15 = 0; var15 < var1; ++var15) {
						byte[] var16 = class201.regionMapArchives[var15];
						if (var16 != null) {
							var4 = (class152.regions[var15] >> 8) * 64 - class20.baseX;
							var17 = (class152.regions[var15] & 255) * 64 - class19.baseY;
							class313.method1648();
							PacketBuffer.method2559(var16, var4, var17, class10.scene, Client.collisionMaps);
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
						class313.method1648();

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

									for (int var12 = 0; var12 < class152.regions.length; ++var12) {
										if (class152.regions[var12] == var11 && class345.regionLandArchives[var12] != null) {
											int var13 = (var9 - var3) * 8;
											int var14 = (var10 - var4) * 8;
											UserComparator5.method672(class345.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
											var19 = true;
											break;
										}
									}
								}

								if (!var19) {
									class4.method5(var15, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var15 = 0; var15 < 13; ++var15) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var15][var3];
							if (var4 == -1) {
								Decimator.method317(var15 * 8, var3 * 8, 8, 8);
							}
						}
					}

					class193.method964(true);

					for (var15 = 0; var15 < 4; ++var15) {
						class313.method1648();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var17 = Client.instanceChunkTemplates[var15][var3][var4];
								if (var17 != -1) {
									var6 = var17 >> 24 & 3;
									var7 = var17 >> 1 & 3;
									var8 = var17 >> 14 & 1023;
									var9 = var17 >> 3 & 2047;
									var10 = (var8 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < class152.regions.length; ++var11) {
										if (class152.regions[var11] == var10 && class201.regionMapArchives[var11] != null) {
											Tiles.method457(class201.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class10.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				class193.method964(true);
				class313.method1648();
				class481.method2389(class10.scene, Client.collisionMaps);
				class193.method964(true);
				var15 = Tiles.Tiles_minPlane;
				if (var15 > class87.Client_plane) {
					var15 = class87.Client_plane;
				}

				if (var15 < class87.Client_plane - 1) {
					var15 = class87.Client_plane - 1;
				}

				if (Client.isLowDetail) {
					class10.scene.init(Tiles.Tiles_minPlane);
				} else {
					class10.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						class30.updateItemPile(var3, var4);
					}
				}

				class313.method1648();
				WorldMapDecoration.method1567();
				ObjectComposition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var18;
				if (class159.client.hasFrame()) {
					var18 = ClanChannelMember.getPacketBufferNode(ClientPacket.DETECT_MODIFIED_CLIENT, Client.packetWriter.isaacCipher);
					var18.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var18);
				}

				if (!Client.isInInstance) {
					var3 = (class94.timeOfPreviousKeyPress - 6) / 8;
					var4 = (class94.timeOfPreviousKeyPress + 6) / 8;
					var17 = (class365.field3199 - 6) / 8;
					var6 = (class365.field3199 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
							if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
								class198.archive9.loadRegionFromName("m" + var7 + "_" + var8);
								class198.archive9.loadRegionFromName("l" + var7 + "_" + var8);
							}
						}
					}
				}

				DefaultsGroup.updateGameState(30);
				class313.method1648();
				BuddyRankComparator.method687();
				var18 = ClanChannelMember.getPacketBufferNode(ClientPacket.f49, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var18);
				class19.method66();
			}
		}
	}
}