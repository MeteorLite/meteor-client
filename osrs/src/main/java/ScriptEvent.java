import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("dl")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("ac")
	@Export("args")
	Object[] args;
	@ObfuscatedName("al")
	boolean field861;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("ax")
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("ao")
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("ah")
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("ab")
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("am")
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("av")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("ag")
	int field864;
	@ObfuscatedName("aa")
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/Object;B)V",
		garbageValue = "-8"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1815349260"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lnm;B)V",
		garbageValue = "-116"
	)
	public void method470(Widget var1) {
		this.widget = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "-119"
	)
	static int method466(int var0, int var1) {
		FloorOverlayDefinition var2 = class4.method4(var0);
		if (var2 == null) {
			return var1;
		} else {
			int var3;
			int var4;
			byte var5;
			int var7;
			if (var2.secondaryRgb >= 0) {
				var3 = Occluder.method1340(var2.secondaryHue, var2.secondarySaturation, var2.secondaryLightness);
				var5 = 96;
				if (var3 == -2) {
					var4 = 12345678;
				} else if (var3 == -1) {
					if (var5 < 0) {
						var5 = 0;
					} else if (var5 > 127) {
						var5 = 127;
					}

					var7 = 127 - var5;
					var4 = var7;
				} else {
					var7 = var5 * (var3 & 127) / 128;
					if (var7 < 2) {
						var7 = 2;
					} else if (var7 > 126) {
						var7 = 126;
					}

					var4 = var7 + (var3 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var4] | -16777216;
			} else if (var2.texture >= 0) {
				var4 = Rasterizer3D.clips.Rasterizer3D_textureLoader.getAverageTextureRGB(var2.texture);
				var5 = 96;
				if (var4 == -2) {
					var3 = 12345678;
				} else if (var4 == -1) {
					if (var5 < 0) {
						var5 = 0;
					} else if (var5 > 127) {
						var5 = 127;
					}

					var7 = 127 - var5;
					var3 = var7;
				} else {
					var7 = var5 * (var4 & 127) / 128;
					if (var7 < 2) {
						var7 = 2;
					} else if (var7 > 126) {
						var7 = 126;
					}

					var3 = var7 + (var4 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var3] | -16777216;
			} else if (var2.primaryRgb == 16711935) {
				return var1;
			} else {
				var3 = Occluder.method1340(var2.hue, var2.saturation, var2.lightness);
				var5 = 96;
				if (var3 == -2) {
					var4 = 12345678;
				} else if (var3 == -1) {
					if (var5 < 0) {
						var5 = 0;
					} else if (var5 > 127) {
						var5 = 127;
					}

					var7 = 127 - var5;
					var4 = var7;
				} else {
					var7 = var5 * (var3 & 127) / 128;
					if (var7 < 2) {
						var7 = 2;
					} else if (var7 > 126) {
						var7 = 126;
					}

					var4 = var7 + (var3 & 65408);
				}

				return Rasterizer3D.Rasterizer3D_colorPalette[var4] | -16777216;
			}
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;III)[Lud;",
		garbageValue = "-1840423911"
	)
	public static SpritePixels[] method468(AbstractArchive var0, int var1, int var2) {
		if (!class164.method862(var0, var1, var2)) {
			return null;
		} else {
			SpritePixels[] var4 = new SpritePixels[class544.SpriteBuffer_spriteCount];

			for (int var5 = 0; var5 < class544.SpriteBuffer_spriteCount; ++var5) {
				SpritePixels var6 = var4[var5] = new SpritePixels();
				var6.width = class159.SpriteBuffer_spriteWidth;
				var6.height = class500.SpriteBuffer_spriteHeight;
				var6.xOffset = class326.SpriteBuffer_xOffsets[var5];
				var6.yOffset = ModelData0.SpriteBuffer_yOffsets[var5];
				var6.subWidth = class59.SpriteBuffer_spriteWidths[var5];
				var6.subHeight = class544.SpriteBuffer_spriteHeights[var5];
				int var7 = var6.subWidth * var6.subHeight;
				byte[] var8 = AddRequestTask.SpriteBuffer_pixels[var5];
				var6.pixels = new int[var7];

				for (int var9 = 0; var9 < var7; ++var9) {
					var6.pixels[var9] = class372.SpriteBuffer_spritePalette[var8[var9] & 255];
				}
			}

			class407.method2062();
			return var4;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;ZIB)V",
		garbageValue = "-22"
	)
	static void method471(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.clearLoginScreen) {
			if (var3 == 4) {
				GameEngine.method166(4);
			}

		} else {
			if (var3 == 0) {
				MusicPatchNode2.method1657(var2);
			} else {
				GameEngine.method166(var3);
			}

			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			PcmPlayer.leftTitleSprite = Frames.method1335(var4);
			Login.rightTitleSprite = PcmPlayer.leftTitleSprite.mirrorHorizontally();
			TextureProvider.method1351(var1, Client.worldProperties);
			Login.titleboxSprite = class167.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			VarcInt.titlebuttonSprite = class167.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.field775 = class167.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_large", "");
			class364.field3198 = class167.SpriteBuffer_getIndexedSpriteByName(var1, "play_now_text", "");
			class167.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton_wide42,1", "");
			Login.runesSprite = InvDefinition.method953(var1, "runes", "");
			Login.title_muteSprite = InvDefinition.method953(var1, "title_mute", "");
			class519.options_buttons_0Sprite = class167.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			class305.field2513 = class167.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			class534.options_buttons_2Sprite = class167.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			ClanChannel.field1409 = class167.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class274.field2399 = class519.options_buttons_0Sprite.subWidth;
			class202.field1581 = class519.options_buttons_0Sprite.subHeight;
			class544.field4278 = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
				Login.field766 = new String[8];
				Login.field751 = 0;
			}

			ClientPreferences.field1059 = 0;
			class186.otp = "";
			Login.field741 = true;
			Login.worldSelectOpen = false;
			if (!class91.clientPreferences.getTitleMusicDisabled()) {
				ArrayList var5 = new ArrayList();
				var5.add(new MusicSong(CollisionMap.archive6, "scape main", "", 255, false));
				class148.method776(var5, 0, 0, 0, 100, false);
			} else {
				ItemComposition.method1088(0, 0);
			}

			class470.method2362();
			class13.method45().method1961(false);
			Login.clearLoginScreen = true;
			Login.xPadding = (class340.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			class379.loginBoxCenter = Login.loginBoxX + 180;
			PcmPlayer.leftTitleSprite.drawAt(Login.xPadding, 0);
			Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "77"
	)
	static final int method472(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("nd")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1310629797"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		class304.method1636();
		ZoneOperation.method1644();
		int var1 = class150.VarpDefinition_get(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					JagexCache.method920(0.9D);
				}

				if (var2 == 2) {
					JagexCache.method920(0.8D);
				}

				if (var2 == 3) {
					JagexCache.method920(0.7D);
				}

				if (var2 == 4) {
					JagexCache.method920(0.6D);
				}
			}

			if (var1 == 3) {
				if (var2 == 0) {
					JagexCache.method921(255);
				}

				if (var2 == 1) {
					JagexCache.method921(192);
				}

				if (var2 == 2) {
					JagexCache.method921(128);
				}

				if (var2 == 3) {
					JagexCache.method921(64);
				}

				if (var2 == 4) {
					JagexCache.method921(0);
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					FloorOverlayDefinition.method1114(127);
				}

				if (var2 == 1) {
					FloorOverlayDefinition.method1114(96);
				}

				if (var2 == 2) {
					FloorOverlayDefinition.method1114(64);
				}

				if (var2 == 3) {
					FloorOverlayDefinition.method1114(32);
				}

				if (var2 == 4) {
					FloorOverlayDefinition.method1114(0);
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2 == 1;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
			}

			if (var1 == 10) {
				if (var2 == 0) {
					class198.method994(127);
				}

				if (var2 == 1) {
					class198.method994(96);
				}

				if (var2 == 2) {
					class198.method994(64);
				}

				if (var2 == 3) {
					class198.method994(32);
				}

				if (var2 == 4) {
					class198.method994(0);
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)SequenceDefinition.findEnumerated(ClientPreferences.method569(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				Client.npcAttackOption = (AttackOption)SequenceDefinition.findEnumerated(ClientPreferences.method569(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}

	@ObfuscatedName("os")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "-1009991511"
	)
	static String method474(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (HealthBarDefinition.param9 != null) {
			var3 = "/p=" + HealthBarDefinition.param9;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + WorldMapLabelSize.clientLanguage + "/a=" + WorldMapIcon_1.field2337 + var3 + "/";
	}
}