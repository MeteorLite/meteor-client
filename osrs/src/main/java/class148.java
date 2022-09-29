import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class148 extends class129 {
	@ObfuscatedName("ng")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1789853223
	)
	int field1700;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	final class132 this$0;

	@ObfuscatedSignature(
		descriptor = "(Leo;)V"
	)
	class148(class132 var1) {
		this.this$0 = var1;
		this.field1700 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "-41"
	)
	void vmethod3320(Buffer var1) {
		this.field1700 = var1.readUnsignedShort();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;I)V",
		garbageValue = "-538131930"
	)
	void vmethod3313(ClanSettings var1) {
		var1.method3123(this.field1700);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-1"
	)
	static void method3260() {
		Tiles.Tiles_minPlane = 99;
		class152.Tiles_underlays = new byte[4][104][104];
		class294.Tiles_overlays = new byte[4][104][104];
		Tiles.Tiles_shapes = new byte[4][104][104];
		Tiles.field1001 = new byte[4][104][104];
		ChatChannel.field996 = new int[4][105][105];
		SoundCache.field328 = new byte[4][105][105];
		Tiles.field1002 = new int[105][105];
		TextureProvider.Tiles_hue = new int[104];
		FontName.Tiles_saturation = new int[104];
		class436.Tiles_lightness = new int[104];
		class434.Tiles_hueMultiplier = new int[104];
		Tiles.field1008 = new int[104];
	}

	@ObfuscatedName("hs")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)V",
		garbageValue = "-1094464901"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = MusicPatchNode.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var14;
		int var26;
		if (0L != var5) {
			var7 = MusicPatchNode.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			boolean var12 = var5 != 0L;
			if (var12) {
				boolean var13 = (int)(var5 >>> 16 & 1L) == 1;
				var12 = !var13;
			}

			if (var12) {
				var10 = var4;
			}

			int[] var19 = class11.sceneMinimapSprite.pixels;
			var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var14 = class156.Entity_unpackID(var5);
			ObjectComposition var15 = PlayerComposition.getObjectDefinition(var14);
			if (var15.mapSceneId != -1) {
				IndexedSprite var16 = WorldMapArea.mapSceneSprites[var15.mapSceneId];
				if (var16 != null) {
					int var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
					int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
					var16.drawAt(var17 + var1 * 4 + 48, var18 + (104 - var2 - var15.sizeY) * 4 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 1) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var19[var26] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = MusicPatchNode.scene.getGameObjectTag(var0, var1, var2);
		if (0L != var5) {
			var7 = MusicPatchNode.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = class156.Entity_unpackID(var5);
			ObjectComposition var20 = PlayerComposition.getObjectDefinition(var10);
			if (var20.mapSceneId != -1) {
				IndexedSprite var28 = WorldMapArea.mapSceneSprites[var20.mapSceneId];
				if (var28 != null) {
					var26 = (var20.sizeX * 4 - var28.subWidth) / 2;
					var14 = (var20.sizeY * 4 - var28.subHeight) / 2;
					var28.drawAt(var26 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var14 + 48);
				}
			} else if (var9 == 9) {
				int var25 = 15658734;
				boolean var27 = var5 != 0L;
				if (var27) {
					boolean var21 = (int)(var5 >>> 16 & 1L) == 1;
					var27 = !var21;
				}

				if (var27) {
					var25 = 15597568;
				}

				int[] var22 = class11.sceneMinimapSprite.pixels;
				int var29 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var22[var29] = var25;
					var22[var29 + 1 + 512] = var25;
					var22[var29 + 1024 + 2] = var25;
					var22[var29 + 1536 + 3] = var25;
				} else {
					var22[var29 + 1536] = var25;
					var22[var29 + 1 + 1024] = var25;
					var22[var29 + 512 + 2] = var25;
					var22[var29 + 3] = var25;
				}
			}
		}

		var5 = MusicPatchNode.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = class156.Entity_unpackID(var5);
			ObjectComposition var23 = PlayerComposition.getObjectDefinition(var7);
			if (var23.mapSceneId != -1) {
				IndexedSprite var24 = WorldMapArea.mapSceneSprites[var23.mapSceneId];
				if (var24 != null) {
					var10 = (var23.sizeX * 4 - var24.subWidth) / 2;
					int var11 = (var23.sizeY * 4 - var24.subHeight) / 2;
					var24.drawAt(var10 + var1 * 4 + 48, (104 - var2 - var23.sizeY) * 4 + var11 + 48);
				}
			}
		}

	}

	@ObfuscatedName("le")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1982981660"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = class120.getPacketBufferNode(ClientPacket.field2948, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}
}
