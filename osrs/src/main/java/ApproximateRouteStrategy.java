import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ApproximateRouteStrategy")
public class ApproximateRouteStrategy extends RouteStrategy {
	@ObfuscatedName("w")
	@Export("SpriteBuffer_spriteWidths")
	public static int[] SpriteBuffer_spriteWidths;
	@ObfuscatedName("jm")
	@ObfuscatedGetter(
		intValue = -541999579
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("nm")
	@ObfuscatedGetter(
		intValue = -1628203189
	)
	@Export("selectedItemSlot")
	static int selectedItemSlot;

	ApproximateRouteStrategy() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IIILgj;I)Z",
		garbageValue = "-385329000"
	)
	@Export("hasArrived")
	protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "-2062628259"
	)
	public static int method1169(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 <= 127) {
				++var2;
			} else if (var4 <= 2047) {
				var2 += 2;
			} else {
				var2 += 3;
			}
		}

		return var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "-2056812499"
	)
	public static void method1170(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1849517626"
	)
	@Export("logOut")
	static final void logOut() {
		Client.packetWriter.close();
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		KitDefinition.KitDefinition_cached.clear();
		MusicPatch.method5606();
		NPCComposition.NpcDefinition_cached.clear();
		NPCComposition.NpcDefinition_cachedModels.clear();
		ItemComposition.ItemDefinition_cached.clear();
		ItemComposition.ItemDefinition_cachedModels.clear();
		ItemComposition.ItemDefinition_cachedSprites.clear();
		UserComparator8.method2742();
		class97.method2584();
		VarbitComposition.VarbitDefinition_cached.clear();
		VarpDefinition.VarpDefinition_cached.clear();
		class127.HitSplatDefinition_cachedSprites.method7724();
		class150.HitSplatDefinition_cached.method7724();
		class97.method2587();
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
		AttackOption.method2557();
		ParamComposition.ParamDefinition_cached.clear();
		class287.method5687();
		Ignored.method6968();
		class439.DBRowType_cache.clear();
		Client.Widget_cachedModels.clear();
		Client.Widget_cachedFonts.clear();
		PlayerComposition.PlayerAppearance_cachedModels.clear();
		class292.method5724();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		DevicePcmPlayerProvider.archive5.clearFiles();
		HorizontalAlignment.field1926.clearFiles();
		class301.archive7.clearFiles();
		UserComparator10.archive4.clearFiles();
		class434.archive9.clearFiles();
		class14.archive6.clearFiles();
		FaceNormal.archive11.clearFiles();
		ChatChannel.archive8.clearFiles();
		class83.field1081.clearFiles();
		class163.archive10.clearFiles();
		class283.field3325.clearFiles();
		class102.archive12.clearFiles();
		PcmPlayer.field308.clearFiles();
		MusicPatchNode.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		TaskHandler.method3435(2);
		Client.currentTrackGroupId = -1;
		Client.playingJingle = false;
		class303.method5918();
		Coord.updateGameState(10);
	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		descriptor = "(IIIILjava/lang/String;I)V",
		garbageValue = "1905973140"
	)
	@Export("widgetDefaultMenuAction")
	static void widgetDefaultMenuAction(int id, int param1, int param0, int itemId, String var4) {
		Widget var5 = JagexCache.getWidgetChild(param1, param0);
		if (var5 != null) {
			if (var5.onOp != null) {
				ScriptEvent var6 = new ScriptEvent();
				var6.widget = var5;
				var6.opIndex = id;
				var6.targetName = var4;
				var6.args = var5.onOp;
				class348.runScriptEvent(var6);
			}

			boolean var11 = true;
			if (var5.contentType > 0) {
				var11 = SoundSystem.method817(var5);
			}

			if (var11) {
				int var8 = class97.getWidgetFlags(var5);
				int var9 = id - 1;
				boolean var7 = (var8 >> var9 + 1 & 1) != 0;
				if (var7) {
					PacketBufferNode var10;
					if (id == 1) {
						var10 = class120.getPacketBufferNode(ClientPacket.field2964, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 2) {
						var10 = class120.getPacketBufferNode(ClientPacket.field2983, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 3) {
						var10 = class120.getPacketBufferNode(ClientPacket.field3012, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 4) {
						var10 = class120.getPacketBufferNode(ClientPacket.field2936, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 5) {
						var10 = class120.getPacketBufferNode(ClientPacket.field3027, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 6) {
						var10 = class120.getPacketBufferNode(ClientPacket.field3014, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 7) {
						var10 = class120.getPacketBufferNode(ClientPacket.field3017, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 8) {
						var10 = class120.getPacketBufferNode(ClientPacket.field2959, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 9) {
						var10 = class120.getPacketBufferNode(ClientPacket.field2974, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

					if (id == 10) {
						var10 = class120.getPacketBufferNode(ClientPacket.field3010, Client.packetWriter.isaacCipher);
						var10.packetBuffer.writeInt(param1);
						var10.packetBuffer.writeShort(param0);
						var10.packetBuffer.writeShort(itemId);
						Client.packetWriter.addNode(var10);
					}

				}
			}
		}
	}
}
