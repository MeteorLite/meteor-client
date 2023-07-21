import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("KeyHandler")
public class KeyHandler implements KeyListener, FocusListener {
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	static StudioGame field72;
	@ObfuscatedName("ay")
	Collection field76;
	@ObfuscatedName("ar")
	Collection field75;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Lba;"
	)
	class29[] field73;
	@ObfuscatedName("as")
	@Export("KeyHandler_pressedKeys")
	boolean[] KeyHandler_pressedKeys;
	@ObfuscatedName("aj")
	@Export("KeyHandler_idleCycles")
	volatile int KeyHandler_idleCycles;

	KeyHandler() {
		this.field73 = new class29[3];
		this.KeyHandler_pressedKeys = new boolean[112];
		this.KeyHandler_idleCycles = 0;
		this.field76 = new ArrayList(100);
		this.field75 = new ArrayList(100);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lba;II)V",
		garbageValue = "801097328"
	)
	void method92(class29 var1, int var2) {
		this.field73[var2] = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "661246345"
	)
	@Export("getIdleCycles")
	int getIdleCycles() {
		return this.KeyHandler_idleCycles;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;I)V",
		garbageValue = "-1935152839"
	)
	void method94(Component var1) {
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(this);
		var1.addFocusListener(this);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "26"
	)
	synchronized void method95(Component var1) {
		var1.removeKeyListener(this);
		var1.removeFocusListener(this);
		synchronized(this) {
			this.field76.add(new class33(4, 0));
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1132854168"
	)
	void method96() {
		++this.KeyHandler_idleCycles;
		this.method97();
		Iterator var1 = this.field75.iterator();

		while (var1.hasNext()) {
			class33 var2 = (class33)var1.next();

			for (int var3 = 0; var3 < this.field73.length && !var2.method134(this.field73[var3]); ++var3) {
			}
		}

		this.field75.clear();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "325496091"
	)
	synchronized void method97() {
		Collection var1 = this.field75;
		this.field75 = this.field76;
		this.field76 = var1;
	}

	@Export("keyPressed")
	@ObfuscatedName("keyPressed")
	public final synchronized void keyPressed(KeyEvent var1) {
		int var2;
		label23: {
			var2 = var1.getKeyCode();
			if (var2 >= 0) {
				int var4 = class28.KeyHandler_keyCodes.length;
				if (var2 < var4) {
					var2 = class343.method1829(var2);
					boolean var5 = (var2 & 128) != 0;
					if (var5) {
						var2 = -1;
					}
					break label23;
				}
			}

			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = true;
			this.field76.add(new class33(1, var2));
			this.KeyHandler_idleCycles = 0;
		}

		var1.consume();
	}

	@Export("keyReleased")
	@ObfuscatedName("keyReleased")
	public final synchronized void keyReleased(KeyEvent var1) {
		int var2;
		label16: {
			var2 = var1.getKeyCode();
			if (var2 >= 0) {
				int var4 = class28.KeyHandler_keyCodes.length;
				if (var2 < var4) {
					var2 = class343.method1829(var2) & -129;
					break label16;
				}
			}

			var2 = -1;
		}

		if (var2 >= 0) {
			this.KeyHandler_pressedKeys[var2] = false;
			this.field76.add(new class33(2, var2));
		}

		var1.consume();
	}

	@Export("keyTyped")
	@ObfuscatedName("keyTyped")
	public final synchronized void keyTyped(KeyEvent var1) {
		char var2 = var1.getKeyChar();
		if (var2 != 0 && var2 != '\uffff') {
			boolean var3;
			if (var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
				var3 = true;
			} else {
				label53: {
					if (var2 != 0) {
						char[] var4 = class385.cp1252AsciiExtension;

						for (int var5 = 0; var5 < var4.length; ++var5) {
							char var6 = var4[var5];
							if (var6 == var2) {
								var3 = true;
								break label53;
							}
						}
					}

					var3 = false;
				}
			}

			if (var3) {
				this.field76.add(new class33(3, var2));
			}
		}

		var1.consume();
	}

	public final synchronized void focusGained(FocusEvent var1) {
		this.field76.add(new class33(4, 1));
	}

	@Export("focusLost")
	@ObfuscatedName("focusLost")
	public final synchronized void focusLost(FocusEvent var1) {
		for (int var2 = 0; var2 < 112; ++var2) {
			if (this.KeyHandler_pressedKeys[var2]) {
				this.KeyHandler_pressedKeys[var2] = false;
				this.field76.add(new class33(2, var2));
			}
		}

		this.field76.add(new class33(4, 0));
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ltc;I)V",
		garbageValue = "483892465"
	)
	static final void method98(PacketBuffer var0) {
		for (int var1 = 0; var1 < Players.Players_pendingUpdateCount; ++var1) {
			int var2 = Players.Players_pendingUpdateIndices[var1];
			Player var3 = Client.players[var2];
			int var4 = var0.readUnsignedByte();
			if ((var4 & 4) != 0) {
				var4 += var0.readUnsignedByte() << 8;
			}

			if ((var4 & 16384) != 0) {
				var4 += var0.readUnsignedByte() << 16;
			}

			byte var5 = MoveSpeed.STATIONARY.speed;
			if ((var4 & 512) != 0) {
				MoveSpeed[] var6 = Players.playerMovementSpeeds;
				MoveSpeed[] var8 = new MoveSpeed[]{MoveSpeed.STATIONARY, MoveSpeed.WALK, MoveSpeed.CRAWL, MoveSpeed.RUN};
				var6[var2] = (MoveSpeed)ClientPreferences.findEnumerated(var8, var0.method2559());
			}

			int var17;
			if ((var4 & 32) != 0) {
				var3.targetIndex = var0.readUnsignedShortAdd();
				var3.targetIndex += var0.readUnsignedByte() << 16;
				var17 = 16777215;
				if (var17 == var3.targetIndex) {
					var3.targetIndex = -1;
				}
			}

			int var7;
			if ((var4 & 2) != 0) {
				var17 = var0.readUnsignedByteAdd();
				if (var17 == 65535) {
					var17 = -1;
				}

				var7 = var0.method2556();
				WorldMapSectionType.performPlayerAnimation(var3, var17, var7);
			}

			int var9;
			int var10;
			int var13;
			if ((var4 & 16) != 0) {
				var17 = var0.readUnsignedShort();
				PlayerType var18 = (PlayerType)ClientPreferences.findEnumerated(PendingSpawn.PlayerType_values(), var0.method2557());
				boolean var19 = var0.readUnsignedByte() == 1;
				var9 = var0.readUnsignedShortLE();
				var10 = var0.offset;
				if (var3.username != null && var3.appearance != null) {
					boolean var11 = false;
					if (var18.isUser && class177.friendSystem.isIgnored(var3.username)) {
						var11 = true;
					}

					if (!var11 && Client.field485 == 0 && !var3.isHidden) {
						Players.field1111.offset = 0;
						var0.method2581(Players.field1111.array, 0, var9);
						Players.field1111.offset = 0;
						String var12 = AbstractFont.escapeBrackets(class153.method797(class292.readString(Players.field1111)));
						var3.overheadText = var12.trim();
						var3.field986 = var17 >> 8;
						var3.field994 = var17 & 255;
						var3.overheadTextCyclesRemaining = 150;
						var3.field1023 = null;
						var3.isAutoChatting = var19;
						var3.showPublicPlayerChat = var3 != class136.localPlayer && var18.isUser && !Client.field598.isEmpty() && var12.toLowerCase().indexOf(Client.field598) == -1;
						if (var18.isPrivileged) {
							var13 = var19 ? 91 : 1;
						} else {
							var13 = var19 ? 90 : 2;
						}

						if (var18.modIcon != -1) {
							class415.addGameMessage(var13, SecureRandomCallable.addImageTag(var18.modIcon) + var3.username.getName(), var12);
						} else {
							class415.addGameMessage(var13, var3.username.getName(), var12);
						}
					}
				}

				var0.offset = var10 + var9;
			}

			if ((var4 & 8192) != 0) {
				for (var17 = 0; var17 < 3; ++var17) {
					var3.actions[var17] = var0.readStringCp1252NullTerminated();
				}
			}

			if ((var4 & 4096) != 0) {
				var3.field1013 = var0.method2561();
				var3.field1007 = var0.method2559();
				var3.field1011 = var0.method2559();
				var3.field1010 = var0.method2561();
				var3.spotAnimation = var0.readUnsignedShortAddLE() + Client.cycle;
				var3.exactMoveArrive1Cycle = var0.readUnsignedShortAdd() + Client.cycle;
				var3.exactMoveDirection = var0.readUnsignedShortAdd();
				if (var3.hasMovementPending) {
					var3.field1013 += var3.tileX;
					var3.field1007 += var3.tileY;
					var3.field1011 += var3.tileX;
					var3.field1010 += var3.tileY;
					var3.pathLength = 0;
				} else {
					var3.field1013 += var3.pathX[0];
					var3.field1007 += var3.pathY[0];
					var3.field1011 += var3.pathX[0];
					var3.field1010 += var3.pathY[0];
					var3.pathLength = 1;
				}

				var3.field1018 = 0;
			}

			if ((var4 & 64) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				if (var3.overheadText.charAt(0) == '~') {
					var3.overheadText = var3.overheadText.substring(1);
					class415.addGameMessage(2, var3.username.getName(), var3.overheadText);
				} else if (var3 == class136.localPlayer) {
					class415.addGameMessage(2, var3.username.getName(), var3.overheadText);
				}

				var3.isAutoChatting = false;
				var3.field986 = 0;
				var3.field994 = 0;
				var3.overheadTextCyclesRemaining = 150;
			}

			if ((var4 & 32768) != 0) {
				var5 = var0.method2561();
			}

			int var21;
			int var25;
			int var29;
			if ((var4 & 2048) != 0) {
				var17 = var0.readUnsignedShortAdd();
				var7 = var17 >> 8;
				var29 = var7 >= 13 && var7 <= 20 ? var7 - 12 : 0;
				PlayerType var20 = (PlayerType)ClientPreferences.findEnumerated(PendingSpawn.PlayerType_values(), var0.method2556());
				boolean var24 = var0.method2556() == 1;
				var25 = var0.method2556();
				var21 = var0.offset;
				if (var3.username != null && var3.appearance != null) {
					boolean var26 = false;
					if (var20.isUser && class177.friendSystem.isIgnored(var3.username)) {
						var26 = true;
					}

					if (!var26 && Client.field485 == 0 && !var3.isHidden) {
						Players.field1111.offset = 0;
						var0.method2580(Players.field1111.array, 0, var25);
						Players.field1111.offset = 0;
						String var14 = AbstractFont.escapeBrackets(class153.method797(class292.readString(Players.field1111)));
						var3.overheadText = var14.trim();
						var3.field986 = var17 >> 8;
						var3.field994 = var17 & 255;
						var3.overheadTextCyclesRemaining = 150;
						byte[] var15 = null;
						int var16;
						if (var29 > 0 && var29 <= 8) {
							var15 = new byte[var29];

							for (var16 = 0; var16 < var29; ++var16) {
								var15[var16] = var0.method2560();
							}
						}

						var3.field1023 = Ignored.method2221(var15);
						var3.isAutoChatting = var24;
						var3.showPublicPlayerChat = var3 != class136.localPlayer && var20.isUser && !Client.field598.isEmpty() && var14.toLowerCase().indexOf(Client.field598) == -1;
						if (var20.isPrivileged) {
							var16 = var24 ? 91 : 1;
						} else {
							var16 = var24 ? 90 : 2;
						}

						if (var20.modIcon != -1) {
							class415.addGameMessage(var16, SecureRandomCallable.addImageTag(var20.modIcon) + var3.username.getName(), var14);
						} else {
							class415.addGameMessage(var16, var3.username.getName(), var14);
						}
					}
				}

				var0.offset = var29 + var21 + var25;
			}

			if ((var4 & 65536) != 0) {
				var17 = var0.method2556();

				for (var7 = 0; var7 < var17; ++var7) {
					var29 = var0.readUnsignedShortLE();
					var9 = var0.readUnsignedShort();
					var10 = var0.method2579();
					var3.method522(var29, var9, var10 >> 16, var10 & 65535);
				}
			}

			if ((var4 & 8) != 0) {
				var17 = var0.method2556();
				if (var17 > 0) {
					for (var7 = 0; var7 < var17; ++var7) {
						var9 = -1;
						var10 = -1;
						var25 = -1;
						var29 = var0.readUShortSmart();
						if (var29 == 32767) {
							var29 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var25 = var0.readUShortSmart();
						} else if (var29 != 32766) {
							var10 = var0.readUShortSmart();
						} else {
							var29 = -1;
						}

						var21 = var0.readUShortSmart();
						var3.addHitSplat(var29, var10, var9, var25, Client.cycle, var21);
					}
				}

				var7 = var0.method2557();
				if (var7 > 0) {
					for (var29 = 0; var29 < var7; ++var29) {
						var9 = var0.readUShortSmart();
						var10 = var0.readUShortSmart();
						if (var10 != 32767) {
							var25 = var0.readUShortSmart();
							var21 = var0.readUnsignedByte();
							var13 = var10 > 0 ? var0.method2557() : var21;
							var3.addHealthBar(var9, Client.cycle, var10, var25, var21, var13);
						} else {
							var3.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var4 & 128) != 0) {
				var3.movingOrientation = var0.readUnsignedShortAddLE();
				if (var3.pathLength == 0) {
					var3.orientation = var3.movingOrientation;
					var3.method526();
				}
			}

			if ((var4 & 256) != 0) {
				var3.recolourStartCycle = Client.cycle + var0.readUnsignedShort();
				var3.recolourEndCycle = Client.cycle + var0.readUnsignedShortAdd();
				var3.recolourHue = var0.method2561();
				var3.recolourSaturation = var0.method2560();
				var3.recolourLuminance = var0.readByte();
				var3.recolourAmount = (byte)var0.readUnsignedByte();
			}

			if ((var4 & 1) != 0) {
				var17 = var0.readUnsignedByte();
				byte[] var27 = new byte[var17];
				Buffer var23 = new Buffer(var27);
				var0.method2580(var27, 0, var17);
				Players.cachedAppearanceBuffer[var2] = var23;
				var3.read(var23);
			}

			if (var3.hasMovementPending) {
				if (var5 == 127) {
					var3.resetPath(var3.tileX, var3.tileY);
				} else {
					MoveSpeed var22;
					if (var5 != MoveSpeed.STATIONARY.speed) {
						MoveSpeed[] var28 = new MoveSpeed[]{MoveSpeed.STATIONARY, MoveSpeed.WALK, MoveSpeed.CRAWL, MoveSpeed.RUN};
						var22 = (MoveSpeed)ClientPreferences.findEnumerated(var28, var5);
					} else {
						var22 = Players.playerMovementSpeeds[var2];
					}

					var3.move(var3.tileX, var3.tileY, var22);
				}
			}
		}

	}

	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "1524159145"
	)
	static final void method99(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var13 + var6;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method1180(var17, var18, var19);
			Rasterizer3D.method1182(var21, var22, var23, var17, var18, var19, 0.0F, 0.0F, 0.0F, var4);
			Rasterizer3D.method1180(var17, var19, var20);
			Rasterizer3D.method1182(var21, var23, var24, var17, var19, var20, 0.0F, 0.0F, 0.0F, var4);
		}
	}
}
