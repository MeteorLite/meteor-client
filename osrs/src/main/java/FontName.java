import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pc")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("j")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("s")
	@Export("name")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lcq;",
		garbageValue = "-1814894957"
	)
	static AttackOption[] method7594() {
		return new AttackOption[]{AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.field1282, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1275};
	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1573839974"
	)
	static final void method7596() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = class67.localPlayer.x;
			var1 = class67.localPlayer.y;
			if (class147.oculusOrbFocalPointX - var0 < -500 || class147.oculusOrbFocalPointX - var0 > 500 || Language.oculusOrbFocalPointY - var1 < -500 || Language.oculusOrbFocalPointY - var1 > 500) {
				class147.oculusOrbFocalPointX = var0;
				Language.oculusOrbFocalPointY = var1;
			}

			if (var0 != class147.oculusOrbFocalPointX) {
				class147.oculusOrbFocalPointX += (var0 - class147.oculusOrbFocalPointX) / 16;
			}

			if (var1 != Language.oculusOrbFocalPointY) {
				Language.oculusOrbFocalPointY += (var1 - Language.oculusOrbFocalPointY) / 16;
			}

			var2 = class147.oculusOrbFocalPointX >> 7;
			var3 = Language.oculusOrbFocalPointY >> 7;
			var4 = class120.getTileHeight(class147.oculusOrbFocalPointX, Language.oculusOrbFocalPointY, Tiles.Client_plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = Tiles.Client_plane;
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

			if (var6 > Client.field589) {
				Client.field589 += (var6 - Client.field589) / 24;
			} else if (var6 < Client.field589) {
				Client.field589 += (var6 - Client.field589) / 80;
			}

			class120.field1505 = class120.getTileHeight(class67.localPlayer.x, class67.localPlayer.y, Tiles.Client_plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			if (Client.field586 && class67.localPlayer != null) {
				var0 = class67.localPlayer.pathX[0];
				var1 = class67.localPlayer.pathY[0];
				if (var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
					class147.oculusOrbFocalPointX = class67.localPlayer.x;
					var2 = class120.getTileHeight(class67.localPlayer.x, class67.localPlayer.y, Tiles.Client_plane) - Client.camFollowHeight;
					if (var2 < class120.field1505) {
						class120.field1505 = var2;
					}

					Language.oculusOrbFocalPointY = class67.localPlayer.y;
					Client.field586 = false;
				}
			}

			short var10 = -1;
			if (KeyHandler.KeyHandler_pressedKeys[33]) {
				var10 = 0;
			} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
				var10 = 1024;
			}

			if (KeyHandler.KeyHandler_pressedKeys[48]) {
				if (var10 == 0) {
					var10 = 1792;
				} else if (var10 == 1024) {
					var10 = 1280;
				} else {
					var10 = 1536;
				}
			} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
				if (var10 == 0) {
					var10 = 256;
				} else if (var10 == 1024) {
					var10 = 768;
				} else {
					var10 = 512;
				}
			}

			byte var11 = 0;
			if (KeyHandler.KeyHandler_pressedKeys[35]) {
				var11 = -1;
			} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
				var11 = 1;
			}

			var2 = 0;
			if (var10 >= 0 || var11 != 0) {
				var2 = KeyHandler.KeyHandler_pressedKeys[81] ? Client.oculusOrbSlowedSpeed : Client.oculusOrbNormalSpeed;
				var2 *= 16;
				Client.field581 = var10;
				Client.field582 = var11;
			}

			if (Client.field580 < var2) {
				Client.field580 += var2 / 8;
				if (Client.field580 > var2) {
					Client.field580 = var2;
				}
			} else if (Client.field580 > var2) {
				Client.field580 = Client.field580 * 9 / 10;
			}

			if (Client.field580 > 0) {
				var3 = Client.field580 / 16;
				if (Client.field581 >= 0) {
					var0 = Client.field581 - class10.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					class147.oculusOrbFocalPointX += var4 * var3 / 65536;
					Language.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field582 != 0) {
					class120.field1505 += var3 * Client.field582;
					if (class120.field1505 > 0) {
						class120.field1505 = 0;
					}
				}
			} else {
				Client.field581 = -1;
				Client.field582 = -1;
			}

			if (KeyHandler.KeyHandler_pressedKeys[13]) {
				method7595();
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && Renderable.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.mouseCamClickedY;
			Client.camAngleDX = var0 * 2;
			Client.mouseCamClickedY = var0 != -1 && var0 != 1 ? (MouseHandler.MouseHandler_y + Client.mouseCamClickedY) / 2 : MouseHandler.MouseHandler_y;
			var1 = Client.mouseCamClickedX - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.mouseCamClickedX = var1 != -1 && var1 != 1 ? (Client.mouseCamClickedX + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x;
		} else {
			if (KeyHandler.KeyHandler_pressedKeys[96]) {
				Client.camAngleDY += (-24 - Client.camAngleDY) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[97]) {
				Client.camAngleDY += (24 - Client.camAngleDY) / 2;
			} else {
				Client.camAngleDY /= 2;
			}

			if (KeyHandler.KeyHandler_pressedKeys[98]) {
				Client.camAngleDX += (12 - Client.camAngleDX) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[99]) {
				Client.camAngleDX += (-12 - Client.camAngleDX) / 2;
			} else {
				Client.camAngleDX /= 2;
			}

			Client.mouseCamClickedY = MouseHandler.MouseHandler_y;
			Client.mouseCamClickedX = MouseHandler.MouseHandler_x;
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

	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	static void method7595() {
		Client.packetWriter.addNode(class120.getPacketBufferNode(ClientPacket.field2943, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}
