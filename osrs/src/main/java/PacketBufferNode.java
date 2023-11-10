import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Lld;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("au")
	@Export("PacketBufferNode_packetBufferNodeCount")
	static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("clientPacket")
	ClientPacket clientPacket;
	@ObfuscatedName("ah")
	@Export("clientPacketLength")
	int clientPacketLength;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Luo;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("ao")
	@Export("index")
	public int index;

	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
		PacketBufferNode_packetBufferNodeCount = 0;
	}

	PacketBufferNode() {
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1380070255"
	)
	@Export("release")
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1877979689"
	)
	public static int method1635(int var0, int var1) {
		return (int)Math.round(Math.atan2((double)var0, (double)var1) * 2607.5945876176133D) & 16383;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1854762565"
	)
	static void method1637(boolean var0) {
		if (var0) {
			SecureRandomCallable.method457();
		} else {
			for (int var1 = 0; var1 < class316.musicSongs.size(); ++var1) {
				MusicSong var2 = (MusicSong)class316.musicSongs.get(var1);
				if (var2 == null) {
					class316.musicSongs.remove(var1);
					--var1;
				} else if (var2.field2880) {
					if (var2.midiPcmStream.field2830 > 0) {
						--var2.midiPcmStream.field2830;
					}

					var2.midiPcmStream.clear();
					var2.midiPcmStream.method1657();
					var2.midiPcmStream.setPcmStreamVolume(0);
					class316.musicSongs.remove(var1);
					--var1;
				} else {
					var2.field2880 = true;
				}
			}
		}

	}

	@ObfuscatedName("lc")
	@ObfuscatedSignature(
		descriptor = "(IIIIS)V",
		garbageValue = "-9846"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			WorldMapSectionType.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < class93.method501(); ++var8) {
			long var9 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var9 != var6) {
				var6 = var9;
				long var15 = ViewportMouse.ViewportMouse_entityTags[var8];
				int var14 = (int)(var15 >>> 0 & 127L);
				var14 = var14;
				int var25 = GrandExchangeOfferAgeComparator.method1969(var8);
				int var16 = class128.method699(var8);
				int var17 = class232.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var18 = var17;
				int var22;
				if (var16 == 2 && class36.scene.getObjectFlags(ItemLayer.Client_plane, var14, var25, var9) >= 0) {
					ObjectComposition var19 = WorldMapSection2.getObjectDefinition(var17);
					if (var19.transforms != null) {
						var19 = var19.transform();
					}

					if (var19 == null) {
						continue;
					}

					PendingSpawn var20 = null;

					for (PendingSpawn var21 = (PendingSpawn)Client.pendingSpawns.last(); var21 != null; var21 = (PendingSpawn)Client.pendingSpawns.previous()) {
						if (var21.plane == ItemLayer.Client_plane && var14 == var21.x && var25 == var21.y && var18 == var21.id) {
							var20 = var21;
							break;
						}
					}

					if (Client.isItemSelected == 1) {
						WorldMapSectionType.insertMenuItemNoShift("Use", Client.field597 + " " + "->" + " " + class167.colorStartTag(65535) + var19.name, 1, var18, var14, var25);
					} else if (Client.isSpellSelected) {
						if ((UrlRequest.field1182 & 4) == 4) {
							WorldMapSectionType.insertMenuItemNoShift(Client.field599, Client.field598 + " " + "->" + " " + class167.colorStartTag(65535) + var19.name, 2, var18, var14, var25);
						}
					} else {
						String[] var35 = var19.actions;
						if (var35 != null) {
							for (var22 = 4; var22 >= 0; --var22) {
								if ((var20 == null || var20.method504(var22)) && var35[var22] != null) {
									short var23 = 0;
									if (var22 == 0) {
										var23 = 3;
									}

									if (var22 == 1) {
										var23 = 4;
									}

									if (var22 == 2) {
										var23 = 5;
									}

									if (var22 == 3) {
										var23 = 6;
									}

									if (var22 == 4) {
										var23 = 1001;
									}

									WorldMapSectionType.insertMenuItemNoShift(var35[var22], class167.colorStartTag(65535) + var19.name, var23, var18, var14, var25);
								}
							}
						}

						WorldMapSectionType.insertMenuItemNoShift("Examine", class167.colorStartTag(65535) + var19.name, 1002, var19.id, var14, var25);
					}
				}

				int var26;
				Player var27;
				NPC var36;
				int[] var37;
				if (var16 == 1) {
					NPC var31 = Client.npcs[var18];
					if (var31 == null) {
						continue;
					}

					if (var31.definition.size == 1 && (var31.x & 127) == 64 && (var31.y & 127) == 64) {
						for (var26 = 0; var26 < Client.npcCount; ++var26) {
							var36 = Client.npcs[Client.npcIndices[var26]];
							if (var36 != null && var36 != var31 && var36.definition.size == 1 && var36.x == var31.x && var36.y == var31.y) {
								WorldMapLabelSize.addNpcToMenu(var36, Client.npcIndices[var26], var14, var25);
							}
						}

						var26 = Players.Players_count;
						var37 = Players.Players_indices;

						for (var22 = 0; var22 < var26; ++var22) {
							var27 = Client.players[var37[var22]];
							if (var27 != null && var27.x == var31.x && var27.y == var31.y) {
								ArchiveDiskAction.addPlayerToMenu(var27, var37[var22], var14, var25);
							}
						}
					}

					WorldMapLabelSize.addNpcToMenu(var31, var18, var14, var25);
				}

				if (var16 == 0) {
					Player var32 = Client.players[var18];
					if (var32 == null) {
						continue;
					}

					if ((var32.x & 127) == 64 && (var32.y & 127) == 64) {
						for (var26 = 0; var26 < Client.npcCount; ++var26) {
							var36 = Client.npcs[Client.npcIndices[var26]];
							if (var36 != null && var36.definition.size == 1 && var32.x == var36.x && var32.y == var36.y) {
								WorldMapLabelSize.addNpcToMenu(var36, Client.npcIndices[var26], var14, var25);
							}
						}

						var26 = Players.Players_count;
						var37 = Players.Players_indices;

						for (var22 = 0; var22 < var26; ++var22) {
							var27 = Client.players[var37[var22]];
							if (var27 != null && var32 != var27 && var32.x == var27.x && var27.y == var32.y) {
								ArchiveDiskAction.addPlayerToMenu(var27, var37[var22], var14, var25);
							}
						}
					}

					if (var18 != Client.combatTargetPlayerIndex) {
						ArchiveDiskAction.addPlayerToMenu(var32, var18, var14, var25);
					} else {
						var4 = var9;
					}
				}

				if (var16 == 3) {
					NodeDeque var33 = Client.groundItems[ItemLayer.Client_plane][var14][var25];
					if (var33 != null) {
						for (TileItem var34 = (TileItem)var33.first(); var34 != null; var34 = (TileItem)var33.next()) {
							ItemComposition var38 = class214.ItemDefinition_get(var34.id);
							if (Client.isItemSelected == 1) {
								WorldMapSectionType.insertMenuItemNoShift("Use", Client.field597 + " " + "->" + " " + class167.colorStartTag(16748608) + var38.name, 16, var34.id, var14, var25);
							} else if (Client.isSpellSelected) {
								if ((UrlRequest.field1182 & 1) == 1) {
									WorldMapSectionType.insertMenuItemNoShift(Client.field599, Client.field598 + " " + "->" + " " + class167.colorStartTag(16748608) + var38.name, 17, var34.id, var14, var25);
								}
							} else {
								String[] var28 = var38.groundActions;

								for (int var39 = 4; var39 >= 0; --var39) {
									if (var34.method610(var39)) {
										if (var28 != null && var28[var39] != null) {
											byte var24 = 0;
											if (var39 == 0) {
												var24 = 18;
											}

											if (var39 == 1) {
												var24 = 19;
											}

											if (var39 == 2) {
												var24 = 20;
											}

											if (var39 == 3) {
												var24 = 21;
											}

											if (var39 == 4) {
												var24 = 22;
											}

											WorldMapSectionType.insertMenuItemNoShift(var28[var39], class167.colorStartTag(16748608) + var38.name, var24, var34.id, var14, var25);
										} else if (var39 == 2) {
											WorldMapSectionType.insertMenuItemNoShift("Take", class167.colorStartTag(16748608) + var38.name, 20, var34.id, var14, var25);
										}
									}
								}

								WorldMapSectionType.insertMenuItemNoShift("Examine", class167.colorStartTag(16748608) + var38.name, 1004, var34.id, var14, var25);
							}
						}
					}
				}
			}
		}

		if (-1L != var4) {
			var8 = (int)(var4 >>> 0 & 127L);
			int var10 = (int)(var4 >>> 7 & 127L);
			Player var12 = Client.players[Client.combatTargetPlayerIndex];
			ArchiveDiskAction.addPlayerToMenu(var12, Client.combatTargetPlayerIndex, var8, var10);
		}

	}

	@ObfuscatedName("oo")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1716534762"
	)
	public static boolean method1639() {
		return Client.clickedWidget != null;
	}
}