import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
	@ObfuscatedName("tv")
	@ObfuscatedGetter(
		intValue = -1314803357
	)
	static int field1398;
	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "[Lqu;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator6(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lnr;Lnr;I)I",
		garbageValue = "-215269810"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "-463932256"
	)
	public static float method2792(int var0) {
		var0 &= 16383;
		return (float)((double)((float)var0 / 16384.0F) * 6.283185307179586D);
	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "73"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			class135.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;
		int var8 = 0;

		while (true) {
			int var10 = ViewportMouse.ViewportMouse_entityCount;
			if (var8 >= var10) {
				if (-1L != var4) {
					var8 = (int)(var4 >>> 0 & 127L);
					var10 = MilliClock.method3477(var4);
					Player var11 = Client.players[Client.combatTargetPlayerIndex];
					class155.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var10);
				}

				return;
			}

			long var27 = ViewportMouse.ViewportMouse_entityTags[var8];
			if (var6 != var27) {
				label328: {
					var6 = var27;
					int var15 = class145.method3226(var8);
					int var16 = MilliClock.method3477(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var17 = var16;
					int var18 = class17.method271(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var20 = EnumComposition.method3627(var8);
					if (var18 == 2 && MusicPatchNode.scene.getObjectFlags(Tiles.Client_plane, var15, var16, var27) >= 0) {
						ObjectComposition var21 = PlayerComposition.getObjectDefinition(var20);
						if (var21.transforms != null) {
							var21 = var21.transform();
						}

						if (var21 == null) {
							break label328;
						}

						if (Client.isItemSelected == 1) {
							class135.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + SoundCache.colorStartTag(65535) + var21.name, 1, var20, var15, var16);
						} else if (Client.isSpellSelected) {
							if ((UrlRequest.selectedSpellFlags & 4) == 4) {
								class135.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + SoundCache.colorStartTag(65535) + var21.name, 2, var20, var15, var16);
							}
						} else {
							String[] var22 = var21.actions;
							if (var22 != null) {
								for (int var23 = 4; var23 >= 0; --var23) {
									if (var22[var23] != null) {
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

										class135.insertMenuItemNoShift(var22[var23], SoundCache.colorStartTag(65535) + var21.name, var24, var20, var15, var17);
									}
								}
							}

							class135.insertMenuItemNoShift("Examine", SoundCache.colorStartTag(65535) + var21.name, 1002, var21.id, var15, var17);
						}
					}

					Player var25;
					int var29;
					NPC var30;
					int var37;
					int[] var38;
					if (var18 == 1) {
						NPC var33 = Client.npcs[var20];
						if (var33 == null) {
							break label328;
						}

						if (var33.definition.size == 1 && (var33.x & 127) == 64 && (var33.y & 127) == 64) {
							for (var29 = 0; var29 < Client.npcCount; ++var29) {
								var30 = Client.npcs[Client.npcIndices[var29]];
								if (var30 != null && var33 != var30 && var30.definition.size == 1 && var33.x == var30.x && var30.y == var33.y) {
									class119.addNpcToMenu(var30, Client.npcIndices[var29], var15, var17);
								}
							}

							var29 = Players.Players_count;
							var38 = Players.Players_indices;

							for (var37 = 0; var37 < var29; ++var37) {
								var25 = Client.players[var38[var37]];
								if (var25 != null && var33.x == var25.x && var33.y == var25.y) {
									class155.addPlayerToMenu(var25, var38[var37], var15, var17);
								}
							}
						}

						class119.addNpcToMenu(var33, var20, var15, var17);
					}

					if (var18 == 0) {
						Player var34 = Client.players[var20];
						if (var34 == null) {
							break label328;
						}

						if ((var34.x & 127) == 64 && (var34.y & 127) == 64) {
							for (var29 = 0; var29 < Client.npcCount; ++var29) {
								var30 = Client.npcs[Client.npcIndices[var29]];
								if (var30 != null && var30.definition.size == 1 && var34.x == var30.x && var30.y == var34.y) {
									class119.addNpcToMenu(var30, Client.npcIndices[var29], var15, var17);
								}
							}

							var29 = Players.Players_count;
							var38 = Players.Players_indices;

							for (var37 = 0; var37 < var29; ++var37) {
								var25 = Client.players[var38[var37]];
								if (var25 != null && var25 != var34 && var34.x == var25.x && var25.y == var34.y) {
									class155.addPlayerToMenu(var25, var38[var37], var15, var17);
								}
							}
						}

						if (var20 != Client.combatTargetPlayerIndex) {
							class155.addPlayerToMenu(var34, var20, var15, var17);
						} else {
							var4 = var27;
						}
					}

					if (var18 == 3) {
						NodeDeque var36 = Client.groundItems[Tiles.Client_plane][var15][var17];
						if (var36 != null) {
							for (TileItem var35 = (TileItem)var36.first(); var35 != null; var35 = (TileItem)var36.next()) {
								ItemComposition var39 = UserComparator3.ItemDefinition_get(var35.id);
								if (Client.isItemSelected == 1) {
									class135.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + SoundCache.colorStartTag(16748608) + var39.name, 16, var35.id, var15, var17);
								} else if (Client.isSpellSelected) {
									if ((UrlRequest.selectedSpellFlags & 1) == 1) {
										class135.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + SoundCache.colorStartTag(16748608) + var39.name, 17, var35.id, var15, var17);
									}
								} else {
									String[] var31 = var39.groundActions;

									for (int var32 = 4; var32 >= 0; --var32) {
										if (var31 != null && var31[var32] != null) {
											byte var26 = 0;
											if (var32 == 0) {
												var26 = 18;
											}

											if (var32 == 1) {
												var26 = 19;
											}

											if (var32 == 2) {
												var26 = 20;
											}

											if (var32 == 3) {
												var26 = 21;
											}

											if (var32 == 4) {
												var26 = 22;
											}

											class135.insertMenuItemNoShift(var31[var32], SoundCache.colorStartTag(16748608) + var39.name, var26, var35.id, var15, var17);
										} else if (var32 == 2) {
											class135.insertMenuItemNoShift("Take", SoundCache.colorStartTag(16748608) + var39.name, 20, var35.id, var15, var17);
										}
									}

									class135.insertMenuItemNoShift("Examine", SoundCache.colorStartTag(16748608) + var39.name, 1004, var35.id, var15, var17);
								}
							}
						}
					}
				}
			}

			++var8;
		}
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1874215636"
	)
	static boolean method2800(int var0) {
		for (int var1 = 0; var1 < Client.field529; ++var1) {
			if (Client.field749[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
