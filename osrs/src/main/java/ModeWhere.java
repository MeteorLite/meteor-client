import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashSet;
import java.util.Set;

@ObfuscatedName("ok")
@Implements("ModeWhere")
public enum ModeWhere implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3661("", 0, new class382[]{class382.field3634, class382.field3636}),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3656("", 1, new class382[]{class382.field3635, class382.field3634, class382.field3636}),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3660("", 2, new class382[]{class382.field3635, class382.field3633, class382.field3634}),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3658("", 3, new class382[]{class382.field3635}),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3654("", 4),
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3662("", 5, new class382[]{class382.field3635, class382.field3634}),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3653("", 6, new class382[]{class382.field3634}),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3655("", 8, new class382[]{class382.field3635, class382.field3634}),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3657("", 9, new class382[]{class382.field3635, class382.field3633}),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3665("", 10, new class382[]{class382.field3635}),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3659("", 11, new class382[]{class382.field3635}),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3663("", 12, new class382[]{class382.field3635, class382.field3634}),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	field3664("", 13, new class382[]{class382.field3635});

	@ObfuscatedName("bk")
	static String field3652;
	@ObfuscatedName("as")
	@Export("id")
	final int id;
	@ObfuscatedName("ay")
	final Set field3667;

	static {
		$values();
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I[Lot;)V"
	)
	ModeWhere(String var3, int var4, class382[] var5) {
		this.field3667 = new HashSet();
		this.id = var4;
		class382[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class382 var8 = var6[var7];
			this.field3667.add(var8);
		}

	}

	ModeWhere(String var3, int var4) {
		this.field3667 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Lok;",
		garbageValue = "435699803"
	)
	@Export("$values")
	static ModeWhere[] $values() {
		return new ModeWhere[]{field3657, field3664, field3663, field3655, field3654, field3660, field3661, field3659, field3662, field3656, field3653, field3665, field3658};
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIII)Ldt;",
		garbageValue = "-1608087816"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = class10.method32(var1, var0);
		Script var4 = WorldMapData_1.method1280(var3, var0);
		if (var4 != null) {
			return var4;
		} else {
			int var5 = (-3 - var2 << 8) + var0;
			var4 = WorldMapData_1.method1280(var5, var0);
			if (var4 != null) {
				return var4;
			} else {
				int var6 = var0 + -512;
				var4 = WorldMapData_1.method1280(var6, var0);
				return var4 != null ? var4 : null;
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "277734474"
	)
	public static void method2001() {
		ParamComposition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-46"
	)
	static final void method2002() {
		LoginScreenAnimation.method534(false);
		Client.field452 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < WorldMapData_1.regionLandArchives.length; ++var1) {
			if (UserComparator7.regionMapArchiveIds[var1] != -1 && WorldMapData_1.regionLandArchives[var1] == null) {
				WorldMapData_1.regionLandArchives[var1] = WorldMapSection0.archive9.takeFile(UserComparator7.regionMapArchiveIds[var1], 0);
				if (WorldMapData_1.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field452;
				}
			}

			if (UserComparator3.regionLandArchiveIds[var1] != -1 && GrandExchangeEvent.regionMapArchives[var1] == null) {
				GrandExchangeEvent.regionMapArchives[var1] = WorldMapSection0.archive9.takeFileEncrypted(UserComparator3.regionLandArchiveIds[var1], 0, Varcs.xteaKeys[var1]);
				if (GrandExchangeEvent.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field452;
				}
			}
		}

		if (!var0) {
			Client.field451 = 1;
		} else {
			Client.field453 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < WorldMapData_1.regionLandArchives.length; ++var1) {
				byte[] var2 = GrandExchangeEvent.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (KitDefinition.regions[var1] >> 8) * 64 - NewShit.baseX;
					var4 = (KitDefinition.regions[var1] & 255) * 64 - class101.baseY;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= class150.method784(var2, var3, var4);
				}
			}

			if (!var0) {
				Client.field451 = 2;
			} else {
				if (Client.field451 != 0) {
					LoginPacket.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				class102.method604();
				class36.scene.clear();

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

				class102.method604();
				MidiPcmStream.method1651();
				var1 = WorldMapData_1.regionLandArchives.length;
				WorldMapSectionType.method1311();
				LoginScreenAnimation.method534(true);
				int var17;
				if (!Client.isInInstance) {
					byte[] var5;
					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (KitDefinition.regions[var15] >> 8) * 64 - NewShit.baseX;
						var4 = (KitDefinition.regions[var15] & 255) * 64 - class101.baseY;
						var5 = WorldMapData_1.regionLandArchives[var15];
						if (var5 != null) {
							class102.method604();
							class427.method2178(var5, var3, var4, DefaultsGroup.timeOfPreviousKeyPress * 8 - 48, class223.field1886 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var15 = 0; var15 < var1; ++var15) {
						var3 = (KitDefinition.regions[var15] >> 8) * 64 - NewShit.baseX;
						var4 = (KitDefinition.regions[var15] & 255) * 64 - class101.baseY;
						var5 = WorldMapData_1.regionLandArchives[var15];
						if (var5 == null && class223.field1886 < 800) {
							class102.method604();
							MouseHandler.method182(var3, var4, 64, 64);
						}
					}

					LoginScreenAnimation.method534(true);

					for (var15 = 0; var15 < var1; ++var15) {
						byte[] var16 = GrandExchangeEvent.regionMapArchives[var15];
						if (var16 != null) {
							var4 = (KitDefinition.regions[var15] >> 8) * 64 - NewShit.baseX;
							var17 = (KitDefinition.regions[var15] & 255) * 64 - class101.baseY;
							class102.method604();
							class250.method1333(var16, var4, var17, class36.scene, Client.collisionMaps);
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
						class102.method604();

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

									for (int var12 = 0; var12 < KitDefinition.regions.length; ++var12) {
										if (KitDefinition.regions[var12] == var11 && WorldMapData_1.regionLandArchives[var12] != null) {
											int var13 = (var9 - var3) * 8;
											int var14 = (var10 - var4) * 8;
											GameEngine.method146(WorldMapData_1.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
											var19 = true;
											break;
										}
									}
								}

								if (!var19) {
									class230.method1176(var15, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var15 = 0; var15 < 13; ++var15) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var15][var3];
							if (var4 == -1) {
								MouseHandler.method182(var15 * 8, var3 * 8, 8, 8);
							}
						}
					}

					LoginScreenAnimation.method534(true);

					for (var15 = 0; var15 < 4; ++var15) {
						class102.method604();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var17 = Client.instanceChunkTemplates[var15][var3][var4];
								if (var17 != -1) {
									var6 = var17 >> 24 & 3;
									var7 = var17 >> 1 & 3;
									var8 = var17 >> 14 & 1023;
									var9 = var17 >> 3 & 2047;
									var10 = (var8 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < KitDefinition.regions.length; ++var11) {
										if (KitDefinition.regions[var11] == var10 && GrandExchangeEvent.regionMapArchives[var11] != null) {
											Tiles.method455(GrandExchangeEvent.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class36.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				LoginScreenAnimation.method534(true);
				class102.method604();
				class156.method823(class36.scene, Client.collisionMaps);
				LoginScreenAnimation.method534(true);
				var15 = Tiles.Tiles_minPlane;
				if (var15 > ItemLayer.Client_plane) {
					var15 = ItemLayer.Client_plane;
				}

				if (var15 < ItemLayer.Client_plane - 1) {
					var15 = ItemLayer.Client_plane - 1;
				}

				if (Client.isLowDetail) {
					class36.scene.init(Tiles.Tiles_minPlane);
				} else {
					class36.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						ClanSettings.updateItemPile(var3, var4);
					}
				}

				class102.method604();
				class90.method476();
				ObjectComposition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var18;
				if (SpriteMask.client.hasFrame()) {
					var18 = class113.getPacketBufferNode(ClientPacket.DETECT_MODIFIED_CLIENT, Client.packetWriter.isaacCipher);
					var18.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var18);
				}

				if (!Client.isInInstance) {
					var3 = (DefaultsGroup.timeOfPreviousKeyPress - 6) / 8;
					var4 = (DefaultsGroup.timeOfPreviousKeyPress + 6) / 8;
					var17 = (class223.field1886 - 6) / 8;
					var6 = (class223.field1886 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
							if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
								WorldMapSection0.archive9.loadRegionFromName("m" + var7 + "_" + var8);
								WorldMapSection0.archive9.loadRegionFromName("l" + var7 + "_" + var8);
							}
						}
					}
				}

				WorldMapSection2.updateGameState(30);
				class102.method604();
				class320.method1707();
				var18 = class113.getPacketBufferNode(ClientPacket.f49, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var18);
				WorldMapManager.method1277();
			}
		}
	}
}