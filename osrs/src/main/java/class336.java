import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mp")
public class class336 {
	@ObfuscatedName("at")
	public int field2923;
	@ObfuscatedName("ah")
	public int field2921;
	@ObfuscatedName("ar")
	public int field2922;

	class336() {
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1748948438"
	)
	static final void method1740() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = class229.localPlayer.x;
			var1 = class229.localPlayer.y;
			if (LoginScreenAnimation.oculusOrbFocalPointX - var0 < -500 || LoginScreenAnimation.oculusOrbFocalPointX - var0 > 500 || ScriptFrame.oculusOrbFocalPointY - var1 < -500 || ScriptFrame.oculusOrbFocalPointY - var1 > 500) {
				LoginScreenAnimation.oculusOrbFocalPointX = var0;
				ScriptFrame.oculusOrbFocalPointY = var1;
			}

			if (var0 != LoginScreenAnimation.oculusOrbFocalPointX) {
				LoginScreenAnimation.oculusOrbFocalPointX += (var0 - LoginScreenAnimation.oculusOrbFocalPointX) / 16;
			}

			if (var1 != ScriptFrame.oculusOrbFocalPointY) {
				ScriptFrame.oculusOrbFocalPointY += (var1 - ScriptFrame.oculusOrbFocalPointY) / 16;
			}

			var2 = LoginScreenAnimation.oculusOrbFocalPointX >> 7;
			var3 = ScriptFrame.oculusOrbFocalPointY >> 7;
			var4 = WorldMapDecorationType.getTileHeight(LoginScreenAnimation.oculusOrbFocalPointX, ScriptFrame.oculusOrbFocalPointY, ItemLayer.Client_plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = ItemLayer.Client_plane;
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

			if (var6 > Client.field473) {
				Client.field473 += (var6 - Client.field473) / 24;
			} else if (var6 < Client.field473) {
				Client.field473 += (var6 - Client.field473) / 80;
			}

			class12.field41 = WorldMapDecorationType.getTileHeight(class229.localPlayer.x, class229.localPlayer.y, ItemLayer.Client_plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			WorldMapCacheName.method1356();
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
				var2 = Client.keyHandlerInstance.getKeyPressed(81) ? Client.oculusOrbSlowedSpeed  : Client.oculusOrbNormalSpeed ;
				var2 *= 16;
				Client.field462 = var10;
				Client.field477 = var11;
			}

			if (Client.field471 < var2) {
				Client.field471 += var2 / 8;
				if (Client.field471 > var2) {
					Client.field471 = var2;
				}
			} else if (Client.field471 > var2) {
				Client.field471 = Client.field471 * 9 / 10;
			}

			if (Client.field471 > 0) {
				var3 = Client.field471 / 16;
				if (Client.field462 >= 0) {
					var0 = Client.field462 - class192.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					LoginScreenAnimation.oculusOrbFocalPointX += var3 * var4 / 65536;
					ScriptFrame.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field477 != 0) {
					class12.field41 += var3 * Client.field477;
					if (class12.field41 > 0) {
						class12.field41 = 0;
					}
				}
			} else {
				Client.field462 = -1;
				Client.field477 = -1;
			}

			if (Client.keyHandlerInstance.getKeyPressed(13)) {
				Client.packetWriter.addNode(class113.getPacketBufferNode(ClientPacket.field2593, Client.packetWriter.isaacCipher));
				Client.oculusOrbState = 0;
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && class19.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.field464;
			Client.camAngleDX = var0 * 2;
			Client.field464 = var0 != -1 && var0 != 1 ? (MouseHandler.MouseHandler_y + Client.field464) / 2 : MouseHandler.MouseHandler_y ;
			var1 = Client.field478 - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.field478 = var1 != -1 && var1 != 1 ? (MouseHandler.MouseHandler_x + Client.field478) / 2 : MouseHandler.MouseHandler_x ;
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

			Client.field464 = MouseHandler.MouseHandler_y;
			Client.field478 = MouseHandler.MouseHandler_x;
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

	@ObfuscatedName("oi")
	@ObfuscatedSignature(
		descriptor = "(Luj;IS)V",
		garbageValue = "241"
	)
	static void method1741(Buffer var0, int var1) {
		NewShit.method936(var0.array, var1);
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}
}