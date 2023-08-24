import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public enum class6 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	field6(0, 0);

	@ObfuscatedName("wi")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	@Export("masterDisk")
	static ArchiveDisk masterDisk;
	@ObfuscatedName("ae")
	public final int field8;
	@ObfuscatedName("ao")
	final int field7;

	class6(int var3, int var4) {
		this.field8 = var3;
		this.field7 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field7;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "1893076970"
	)
	static int method12(int var0, Script var1, boolean var2) {
		return 2;
	}

	@ObfuscatedName("ne")
	@ObfuscatedSignature(
		descriptor = "(Lmi;IIIB)V",
		garbageValue = "32"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		class301.method1622();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = VarbitComposition.localPlayer.x / 32 + 48;
				int var7 = 464 - VarbitComposition.localPlayer.y / 32;
				AbstractUserComparator.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - VarbitComposition.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - VarbitComposition.localPlayer.y / 32;
					class210.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var14 = Client.groundItems[HealthBar.Client_plane][var8][var9];
						if (var14 != null) {
							var11 = var8 * 4 + 2 - VarbitComposition.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - VarbitComposition.localPlayer.y / 32;
							class210.drawSpriteOnMinimap(var1, var2, var11, var12, FloorOverlayDefinition.mapDotSprites[0], var4);
						}
					}
				}

				for (var8 = 0; var8 < Client.npcCount; ++var8) {
					NPC var15 = Client.npcs[Client.npcIndices[var8]];
					if (var15 != null && var15.isVisible()) {
						NPCComposition var17 = var15.definition;
						if (var17 != null && var17.transforms != null) {
							var17 = var17.transform();
						}

						if (var17 != null && var17.drawMapDot && var17.isInteractable) {
							var11 = var15.x / 32 - VarbitComposition.localPlayer.x / 32;
							var12 = var15.y / 32 - VarbitComposition.localPlayer.y / 32;
							class210.drawSpriteOnMinimap(var1, var2, var11, var12, FloorOverlayDefinition.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var18 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var16 = Client.players[var18[var10]];
					if (var16 != null && var16.isVisible() && !var16.isHidden && var16 != VarbitComposition.localPlayer) {
						var12 = var16.x / 32 - VarbitComposition.localPlayer.x / 32;
						int var13 = var16.y / 32 - VarbitComposition.localPlayer.y / 32;
						if (var16.isFriend()) {
							class210.drawSpriteOnMinimap(var1, var2, var12, var13, FloorOverlayDefinition.mapDotSprites[3], var4);
						} else if (VarbitComposition.localPlayer.team != 0 && var16.team != 0 && var16.team == VarbitComposition.localPlayer.team) {
							class210.drawSpriteOnMinimap(var1, var2, var12, var13, FloorOverlayDefinition.mapDotSprites[4], var4);
						} else if (var16.isFriendsChatMember()) {
							class210.drawSpriteOnMinimap(var1, var2, var12, var13, FloorOverlayDefinition.mapDotSprites[5], var4);
						} else if (var16.isClanMember()) {
							class210.drawSpriteOnMinimap(var1, var2, var12, var13, FloorOverlayDefinition.mapDotSprites[6], var4);
						} else {
							class210.drawSpriteOnMinimap(var1, var2, var12, var13, FloorOverlayDefinition.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var19 = Client.npcs[Client.hintArrowNpcIndex];
						if (var19 != null) {
							var11 = var19.x / 32 - VarbitComposition.localPlayer.x / 32;
							var12 = var19.y / 32 - VarbitComposition.localPlayer.y / 32;
							class408.worldToMinimap(var1, var2, var11, var12, Message.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - UrlRequester.baseX * 4 + 2 - VarbitComposition.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - class47.baseY * 4 + 2 - VarbitComposition.localPlayer.y / 32;
						class408.worldToMinimap(var1, var2, var10, var11, Message.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var20 = Client.players[Client.hintArrowPlayerIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - VarbitComposition.localPlayer.x / 32;
							var12 = var20.y / 32 - VarbitComposition.localPlayer.y / 32;
							class408.worldToMinimap(var1, var2, var11, var12, Message.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - VarbitComposition.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - VarbitComposition.localPlayer.y / 32;
					class210.drawSpriteOnMinimap(var1, var2, var10, var11, Message.mapMarkerSprites[0], var4);
				}

				if (!VarbitComposition.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field408[var3] = true;
		}
	}
}