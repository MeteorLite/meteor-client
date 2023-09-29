import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qs")
public class class436 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	public static final class436 field3797;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lqs;"
	)
	static final class436 field3798;
	@ObfuscatedName("ak")
	final int field3799;

	static {
		field3797 = new class436(1);
		field3798 = new class436(0);
	}

	class436(int var1) {
		this.field3799 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/String;",
		garbageValue = "30"
	)
	@Export("addImageTag")
	static String addImageTag(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "112"
	)
	static final void method2211(String var0) {
		class411.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("nc")
	@ObfuscatedSignature(
		descriptor = "(Lnm;IIII)V",
		garbageValue = "-1362386286"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		class313.method1648();
		SpriteMask var4 = var0.method1857(class33.widgetDefinition, false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = TextureProvider.localPlayer.x / 32 + 48;
				int var7 = 464 - TextureProvider.localPlayer.y / 32;
				SpriteMask.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - TextureProvider.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - TextureProvider.localPlayer.y / 32;
					SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[class87.Client_plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - TextureProvider.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - TextureProvider.localPlayer.y / 32;
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var11, var12, class103.mapDotSprites[0], var4);
						}
					}
				}

				for (var8 = 0; var8 < Client.npcCount; ++var8) {
					NPC var14 = Client.npcs[Client.npcIndices[var8]];
					if (var14 != null && var14.isVisible()) {
						NPCComposition var18 = var14.definition;
						if (var18 != null && var18.transforms != null) {
							var18 = var18.transform();
						}

						if (var18 != null && var18.drawMapDot && var18.isInteractable) {
							var11 = var14.x / 32 - TextureProvider.localPlayer.x / 32;
							var12 = var14.y / 32 - TextureProvider.localPlayer.y / 32;
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var11, var12, class103.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var17 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var16 = Client.players[var17[var10]];
					if (var16 != null && var16.isVisible() && !var16.isHidden && var16 != TextureProvider.localPlayer) {
						var12 = var16.x / 32 - TextureProvider.localPlayer.x / 32;
						int var13 = var16.y / 32 - TextureProvider.localPlayer.y / 32;
						if (var16.isFriend()) {
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var12, var13, class103.mapDotSprites[3], var4);
						} else if (TextureProvider.localPlayer.team != 0 && var16.team != 0 && var16.team == TextureProvider.localPlayer.team) {
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var12, var13, class103.mapDotSprites[4], var4);
						} else if (var16.method493()) {
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var12, var13, class103.mapDotSprites[5], var4);
						} else if (var16.isClanMember()) {
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var12, var13, class103.mapDotSprites[6], var4);
						} else {
							SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var12, var13, class103.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var19 = Client.npcs[Client.hintArrowNpcIndex];
						if (var19 != null) {
							var11 = var19.x / 32 - TextureProvider.localPlayer.x / 32;
							var12 = var19.y / 32 - TextureProvider.localPlayer.y / 32;
							Language.worldToMinimap(var1, var2, var11, var12, class47.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - class20.baseX * 4 + 2 - TextureProvider.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - class19.baseY * 4 + 2 - TextureProvider.localPlayer.y / 32;
						Language.worldToMinimap(var1, var2, var10, var11, class47.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var20 = Client.players[Client.hintArrowPlayerIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - TextureProvider.localPlayer.x / 32;
							var12 = var20.y / 32 - TextureProvider.localPlayer.y / 32;
							Language.worldToMinimap(var1, var2, var11, var12, class47.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - TextureProvider.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - TextureProvider.localPlayer.y / 32;
					SecureRandomFuture.drawSpriteOnMinimap(var1, var2, var10, var11, class47.mapMarkerSprites[0], var4);
				}

				if (!TextureProvider.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field407[var3] = true;
		}
	}
}