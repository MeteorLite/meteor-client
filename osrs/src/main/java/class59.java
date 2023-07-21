import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class59 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lbu;"
	)
	VorbisFloor field309;
	@ObfuscatedName("ay")
	boolean field307;
	@ObfuscatedName("ar")
	int[] field311;
	@ObfuscatedName("am")
	int[] field310;
	@ObfuscatedName("as")
	boolean[] field308;

	@ObfuscatedSignature(
		descriptor = "(Lbu;Z[I[I[Z)V"
	)
	class59(VorbisFloor var1, boolean var2, int[] var3, int[] var4, boolean[] var5) {
		this.field309 = var1;
		this.field307 = var2;
		this.field311 = var3;
		this.field310 = var4;
		this.field308 = var5;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([FIS)V",
		garbageValue = "-3681"
	)
	void method318(float[] var1, int var2) {
		int var3 = this.field309.field177.length;
		VorbisFloor var10000 = this.field309;
		int var4 = VorbisFloor.field173[this.field309.multiplier - 1];
		boolean[] var5 = this.field308;
		this.field308[1] = true;
		var5[0] = true;

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		for (var6 = 2; var6 < var3; ++var6) {
			var7 = this.field309.method194(this.field311, var6);
			var8 = this.field309.method195(this.field311, var6);
			var9 = this.field309.method196(this.field311[var7], this.field310[var7], this.field311[var8], this.field310[var8], this.field311[var6]);
			var10 = this.field310[var6];
			int var11 = var4 - var9;
			int var13 = (var11 < var9 ? var11 : var9) << 1;
			if (var10 != 0) {
				boolean[] var14 = this.field308;
				this.field308[var8] = true;
				var14[var7] = true;
				this.field308[var6] = true;
				if (var10 >= var13) {
					this.field310[var6] = var11 > var9 ? var9 + (var10 - var9) : var11 + (var9 - var10) - 1;
				} else {
					this.field310[var6] = (var10 & 1) != 0 ? var9 - (var10 + 1) / 2 : var10 / 2 + var9;
				}
			} else {
				this.field308[var6] = false;
				this.field310[var6] = var9;
			}
		}

		this.VarbisFloor_sort(0, var3 - 1);
		var6 = 0;
		var7 = this.field309.multiplier * this.field310[0];

		for (var8 = 1; var8 < var3; ++var8) {
			if (this.field308[var8]) {
				var9 = this.field311[var8];
				var10 = this.field309.multiplier * this.field310[var8];
				this.field309.method197(var6, var7, var9, var10, var1, var2);
				if (var9 >= var2) {
					return;
				}

				var6 = var9;
				var7 = var10;
			}
		}

		var10000 = this.field309;
		float var16 = VorbisFloor.VorbisFloor_decibelStatics[var7];

		for (var9 = var6; var9 < var2; ++var9) {
			var1[var9] *= var16;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "4"
	)
	boolean method319() {
		return this.field307;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-48"
	)
	@Export("VarbisFloor_sort")
	void VarbisFloor_sort(int var1, int var2) {
		if (var1 < var2) {
			int var3 = var1;
			int var4 = this.field311[var1];
			int var5 = this.field310[var1];
			boolean var6 = this.field308[var1];

			for (int var7 = var1 + 1; var7 <= var2; ++var7) {
				int var8 = this.field311[var7];
				if (var8 < var4) {
					this.field311[var3] = var8;
					this.field310[var3] = this.field310[var7];
					this.field308[var3] = this.field308[var7];
					++var3;
					this.field311[var7] = this.field311[var3];
					this.field310[var7] = this.field310[var3];
					this.field308[var7] = this.field308[var3];
				}
			}

			this.field311[var3] = var4;
			this.field310[var3] = var5;
			this.field308[var3] = var6;
			this.VarbisFloor_sort(var1, var3 - 1);
			this.VarbisFloor_sort(var3 + 1, var2);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-937523976"
	)
	static void method320(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-740402565"
	)
	public static void method322() {
		Widget.Widget_cachedSprites.clear();
		Widget.Widget_cachedModels.clear();
		Widget.Widget_cachedFonts.clear();
		Widget.Widget_cachedSpriteMasks.clear();
	}

	@ObfuscatedName("le")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "26"
	)
	static final int method323() {
		return Client.menuOptionsCount - 1;
	}

	@ObfuscatedName("lh")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1812783002"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			JagexCache.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < class467.method2321(); ++var8) {
			long var9 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var6 != var9) {
				var6 = var9;
				int var13 = class365.method1917(var8);
				int var14 = class197.method979(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var15 = var14;
				int var16 = class6.method12(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var18 = class458.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var19 = var18;
				int var23;
				if (var16 == 2 && UserComparator5.scene.getObjectFlags(class36.Client_plane, var13, var14, var9) >= 0) {
					ObjectComposition var20 = class90.getObjectDefinition(var18);
					if (var20.transforms != null) {
						var20 = var20.transform();
					}

					if (var20 == null) {
						continue;
					}

					PendingSpawn var21 = null;

					for (PendingSpawn var22 = (PendingSpawn)Client.pendingSpawns.last(); var22 != null; var22 = (PendingSpawn)Client.pendingSpawns.previous()) {
						if (var22.plane == class36.Client_plane && var13 == var22.x && var15 == var22.y && var19 == var22.id) {
							var21 = var22;
							break;
						}
					}

					if (Client.isItemSelected == 1) {
						JagexCache.insertMenuItemNoShift("Use", Client.field595 + " " + "->" + " " + MusicPatchPcmStream.colorStartTag(65535) + var20.name, 1, var19, var13, var15);
					} else if (Client.isSpellSelected) {
						if ((PcmPlayer.selectedSpellFlags & 4) == 4) {
							JagexCache.insertMenuItemNoShift(Client.field597, Client.field596 + " " + "->" + " " + MusicPatchPcmStream.colorStartTag(65535) + var20.name, 2, var19, var13, var15);
						}
					} else {
						String[] var35 = var20.actions;
						if (var35 != null) {
							for (var23 = 4; var23 >= 0; --var23) {
								if ((var21 == null || var21.method510(var23)) && var35[var23] != null) {
									short var24 = 0;
									if (var23 == 0) {
										var24 = 3;
									}

									if (var23 == 1) {
										var24 = 4;
									}

									if (var23 == 2) {
										var24 = 5;
									}

									if (var23 == 3) {
										var24 = 6;
									}

									if (var23 == 4) {
										var24 = 1001;
									}

									JagexCache.insertMenuItemNoShift(var35[var23], MusicPatchPcmStream.colorStartTag(65535) + var20.name, var24, var19, var13, var15);
								}
							}
						}

						JagexCache.insertMenuItemNoShift("Examine", MusicPatchPcmStream.colorStartTag(65535) + var20.name, 1002, var20.id, var13, var15);
					}
				}

				int var26;
				Player var27;
				NPC var36;
				int[] var37;
				if (var16 == 1) {
					NPC var31 = Client.npcs[var19];
					if (var31 == null) {
						continue;
					}

					if (var31.definition.size == 1 && (var31.x & 127) == 64 && (var31.y & 127) == 64) {
						for (var26 = 0; var26 < Client.npcCount; ++var26) {
							var36 = Client.npcs[Client.npcIndices[var26]];
							if (var36 != null && var36 != var31 && var36.definition.size == 1 && var31.x == var36.x && var31.y == var36.y) {
								VarpDefinition.addNpcToMenu(var36, Client.npcIndices[var26], var13, var15);
							}
						}

						var26 = Players.Players_count;
						var37 = Players.Players_indices;

						for (var23 = 0; var23 < var26; ++var23) {
							var27 = Client.players[var37[var23]];
							if (var27 != null && var31.x == var27.x && var31.y == var27.y) {
								WorldMapAreaData.addPlayerToMenu(var27, var37[var23], var13, var15);
							}
						}
					}

					VarpDefinition.addNpcToMenu(var31, var19, var13, var15);
				}

				if (var16 == 0) {
					Player var32 = Client.players[var19];
					if (var32 == null) {
						continue;
					}

					if ((var32.x & 127) == 64 && (var32.y & 127) == 64) {
						for (var26 = 0; var26 < Client.npcCount; ++var26) {
							var36 = Client.npcs[Client.npcIndices[var26]];
							if (var36 != null && var36.definition.size == 1 && var32.x == var36.x && var36.y == var32.y) {
								VarpDefinition.addNpcToMenu(var36, Client.npcIndices[var26], var13, var15);
							}
						}

						var26 = Players.Players_count;
						var37 = Players.Players_indices;

						for (var23 = 0; var23 < var26; ++var23) {
							var27 = Client.players[var37[var23]];
							if (var27 != null && var27 != var32 && var32.x == var27.x && var32.y == var27.y) {
								WorldMapAreaData.addPlayerToMenu(var27, var37[var23], var13, var15);
							}
						}
					}

					if (var19 != Client.combatTargetPlayerIndex) {
						WorldMapAreaData.addPlayerToMenu(var32, var19, var13, var15);
					} else {
						var4 = var9;
					}
				}

				if (var16 == 3) {
					NodeDeque var33 = Client.groundItems[class36.Client_plane][var13][var15];
					if (var33 != null) {
						for (TileItem var34 = (TileItem)var33.first(); var34 != null; var34 = (TileItem)var33.next()) {
							ItemComposition var38 = class125.ItemDefinition_get(var34.id);
							if (Client.isItemSelected == 1) {
								JagexCache.insertMenuItemNoShift("Use", Client.field595 + " " + "->" + " " + MusicPatchPcmStream.colorStartTag(16748608) + var38.name, 16, var34.id, var13, var15);
							} else if (Client.isSpellSelected) {
								if ((PcmPlayer.selectedSpellFlags & 1) == 1) {
									JagexCache.insertMenuItemNoShift(Client.field597, Client.field596 + " " + "->" + " " + MusicPatchPcmStream.colorStartTag(16748608) + var38.name, 17, var34.id, var13, var15);
								}
							} else {
								String[] var28 = var38.groundActions;

								for (int var39 = 4; var39 >= 0; --var39) {
									if (var34.method614(var39)) {
										if (var28 != null && var28[var39] != null) {
											byte var25 = 0;
											if (var39 == 0) {
												var25 = 18;
											}

											if (var39 == 1) {
												var25 = 19;
											}

											if (var39 == 2) {
												var25 = 20;
											}

											if (var39 == 3) {
												var25 = 21;
											}

											if (var39 == 4) {
												var25 = 22;
											}

											JagexCache.insertMenuItemNoShift(var28[var39], MusicPatchPcmStream.colorStartTag(16748608) + var38.name, var25, var34.id, var13, var15);
										} else if (var39 == 2) {
											JagexCache.insertMenuItemNoShift("Take", MusicPatchPcmStream.colorStartTag(16748608) + var38.name, 20, var34.id, var13, var15);
										}
									}
								}

								JagexCache.insertMenuItemNoShift("Examine", MusicPatchPcmStream.colorStartTag(16748608) + var38.name, 1004, var34.id, var13, var15);
							}
						}
					}
				}
			}
		}

		if (-1L != var4) {
			var8 = (int)(var4 >>> 0 & 127L);
			int var10 = class197.method979(var4);
			Player var30 = Client.players[Client.combatTargetPlayerIndex];
			WorldMapAreaData.addPlayerToMenu(var30, Client.combatTargetPlayerIndex, var8, var10);
		}

	}
}
