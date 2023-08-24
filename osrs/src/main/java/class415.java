import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("pw")
public class class415 {
	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "66"
	)
	@Export("reloadJS5")
	static void reloadJS5() {
		if (KeyHandler.varcs.hasUnwrittenChanges()) {
			KeyHandler.varcs.write();
		}

		if (class126.mouseRecorder != null) {
			class126.mouseRecorder.isRunning = false;
		}

		class126.mouseRecorder = null;
		Client.packetWriter.close();
		if (GameEngine.taskHandler != null) {
			try {
				GameEngine.taskHandler.close();
			} catch (Exception var3) {
			}
		}

		GameEngine.taskHandler = null;
		Tiles.method461();
		class1.archive2.clearFiles();
		Player.archive13.clearFiles();
		class106.field1107.clearFiles();
		Tiles.field838.clearFiles();
		class10.field28.clearFiles();
		WorldMapElement.field1509.clearFiles();
		ClanChannelMember.field1339.clearFiles();
		class227.field2040.clearFiles();
		class72.method424();
		class130.scene.clear();

		for (int var1 = 0; var1 < 4; ++var1) {
			Client.collisionMaps[var1].clear();
		}

		Canvas.worldMap = null;
		Script.method445(0, 0);
		UrlRequester.method652();
		Client.playingJingle = false;
		class388.method2029();
		if (AddRequestTask.pcmPlayer1 != null) {
			AddRequestTask.pcmPlayer1.shutdown();
		}

		class308.field2819.method1940();
		class214.method1124();
		if (FriendsChat.urlRequester != null) {
			FriendsChat.urlRequester.close();
		}

		class510.method2513();
		JagexCache.JagexCache_dat2File = null;
		JagexCache.JagexCache_idx255File = null;
		WallDecoration.JagexCache_idxFiles = null;
		ItemContainer.method468();
		class6.masterDisk = null;
		Client.archiveLoaders.clear();
		Client.field550 = 0;
		class308.field2819 = new JagNetThread();
		FriendsChat.urlRequester = new class113(class219.client.field661, 216);

		try {
			SecureRandomCallable.method462("oldschool", class30.field83, WorldMapLabelSize.field2323.name, 0, 22);
		} catch (IOException var2) {
			throw new RuntimeException(var2);
		}

		class6.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		GameEngine.taskHandler = new TaskHandler();
		class219.client.method152();
		Client.field419 = class92.field940;
		MusicSong.updateGameState(0);
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1762836764"
	)
	static final void method2159() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = VarbitComposition.localPlayer.x;
			var1 = VarbitComposition.localPlayer.y;
			if (FriendLoginUpdate.oculusOrbFocalPointX - var0 < -500 || FriendLoginUpdate.oculusOrbFocalPointX - var0 > 500 || HealthBar.oculusOrbFocalPointY - var1 < -500 || HealthBar.oculusOrbFocalPointY - var1 > 500) {
				FriendLoginUpdate.oculusOrbFocalPointX = var0;
				HealthBar.oculusOrbFocalPointY = var1;
			}

			if (var0 != FriendLoginUpdate.oculusOrbFocalPointX) {
				FriendLoginUpdate.oculusOrbFocalPointX += (var0 - FriendLoginUpdate.oculusOrbFocalPointX) / 16;
			}

			if (var1 != HealthBar.oculusOrbFocalPointY) {
				HealthBar.oculusOrbFocalPointY += (var1 - HealthBar.oculusOrbFocalPointY) / 16;
			}

			var2 = FriendLoginUpdate.oculusOrbFocalPointX >> 7;
			var3 = HealthBar.oculusOrbFocalPointY >> 7;
			var4 = class18.getTileHeight(FriendLoginUpdate.oculusOrbFocalPointX, HealthBar.oculusOrbFocalPointY, HealthBar.Client_plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = HealthBar.Client_plane;
						if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
							++var8;
						}

						int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
						if (var9 > var5) {
							var5 = var9;
						}
					}
				}
			}

			var6 = var5 * 192;
			if (var6 > 98048) {
				var6 = 98048;
			}

			if (var6 < 32768) {
				var6 = 32768;
			}

			if (var6 > Client.field467) {
				Client.field467 += (var6 - Client.field467) / 24;
			} else if (var6 < Client.field467) {
				Client.field467 += (var6 - Client.field467) / 80;
			}

			class125.field1194 = class18.getTileHeight(VarbitComposition.localPlayer.x, VarbitComposition.localPlayer.y, HealthBar.Client_plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			class28.method111();
			short var10 = -1;
			if (Client.keyHandlerInstance.getKeyPressed(33)) {
				var10 = 0;
			} else if (Client.keyHandlerInstance.getKeyPressed(49)) {
				var10 = 1024;
			}

			if (Client.keyHandlerInstance.getKeyPressed(48)) {
				if (var10 == 0) {
					var10 = 1792;
				} else if (var10 == 1024) {
					var10 = 1280;
				} else {
					var10 = 1536;
				}
			} else if (Client.keyHandlerInstance.getKeyPressed(50)) {
				if (var10 == 0) {
					var10 = 256;
				} else if (var10 == 1024) {
					var10 = 768;
				} else {
					var10 = 512;
				}
			}

			byte var11 = 0;
			if (Client.keyHandlerInstance.getKeyPressed(35)) {
				var11 = -1;
			} else if (Client.keyHandlerInstance.getKeyPressed(51)) {
				var11 = 1;
			}

			var2 = 0;
			if (var10 >= 0 || var11 != 0) {
				var2 = Client.keyHandlerInstance.getKeyPressed(81) ? Client.oculusOrbSlowedSpeed * 1039153205 * -557098467 : Client.oculusOrbNormalSpeed * -554086649 * 623963831;
				var2 *= 16;
				Client.field468 = var10;
				Client.field471 = var11;
			}

			if (Client.field480 < var2) {
				Client.field480 += var2 / 8;
				if (Client.field480 > var2) {
					Client.field480 = var2;
				}
			} else if (Client.field480 > var2) {
				Client.field480 = Client.field480 * 9 / 10;
			}

			if (Client.field480 > 0) {
				var3 = Client.field480 / 16;
				if (Client.field468 >= 0) {
					var0 = Client.field468 - UserComparator10.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					FriendLoginUpdate.oculusOrbFocalPointX += var4 * var3 / 65536;
					HealthBar.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field471 != 0) {
					class125.field1194 += var3 * Client.field471;
					if (class125.field1194 > 0) {
						class125.field1194 = 0;
					}
				}
			} else {
				Client.field468 = -1;
				Client.field471 = -1;
			}

			if (Client.keyHandlerInstance.getKeyPressed(13)) {
				ObjectSound.method416();
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && ObjTypeCustomisation.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.field465;
			Client.camAngleDX = var0 * 2;
			Client.field465 = var0 != -1 && var0 != 1 ? (Client.field465 + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * 1545391541 * 1675983005;
			var1 = Client.field473 - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.field473 = var1 != -1 && var1 != 1 ? (MouseHandler.MouseHandler_x + Client.field473) / 2 : MouseHandler.MouseHandler_x * 72258787 * 2105757899;
		} else {
			if (Client.keyHandlerInstance.getKeyPressed(96)) {
				Client.camAngleDY += (-24 - Client.camAngleDY) / 2;
			} else if (Client.keyHandlerInstance.getKeyPressed(97)) {
				Client.camAngleDY += (24 - Client.camAngleDY) / 2;
			} else {
				Client.camAngleDY /= 2;
			}

			if (Client.keyHandlerInstance.getKeyPressed(98)) {
				Client.camAngleDX += (12 - Client.camAngleDX) / 2;
			} else if (Client.keyHandlerInstance.getKeyPressed(99)) {
				Client.camAngleDX += (-12 - Client.camAngleDX) / 2;
			} else {
				Client.camAngleDX /= 2;
			}

			Client.field465 = MouseHandler.MouseHandler_y;
			Client.field473 = MouseHandler.MouseHandler_x;
		}

		Client.camAngleY = Client.camAngleDY / 2 + Client.camAngleY & 2047;
		Client.camAngleX += Client.camAngleDX / 2;
		if (Client.camAngleX < 128) {
			Client.camAngleX = 128;
		}

		if (Client.camAngleX > 383) {
			Client.camAngleX = 383;
		}

	}
}