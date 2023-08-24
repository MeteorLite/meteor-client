import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ScheduledExecutorService;

@ObfuscatedName("bb")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("ac")
	public static int field181;
	@ObfuscatedName("ai")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("ap")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("aa")
	static int field182;
	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("an")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbw;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("ab")
	int field189;
	@ObfuscatedName("ag")
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("am")
	@Export("capacity")
	int capacity;
	@ObfuscatedName("ax")
	int field194;
	@ObfuscatedName("ah")
	int field190;
	@ObfuscatedName("as")
	long field198;
	@ObfuscatedName("ay")
	int field195;
	@ObfuscatedName("aj")
	int field191;
	@ObfuscatedName("av")
	int field193;
	@ObfuscatedName("aw")
	long field199;
	@ObfuscatedName("ak")
	boolean field185;
	@ObfuscatedName("bd")
	int field196;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "[Lbw;"
	)
	PcmStream[] field188;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "[Lbw;"
	)
	PcmStream[] field187;

	protected PcmPlayer() {
		this.field189 = 32;
		this.timeMs = GameEngine.clockNow();
		this.field198 = 0L;
		this.field195 = 0;
		this.field191 = 0;
		this.field193 = 0;
		this.field199 = 0L;
		this.field185 = true;
		this.field196 = 0;
		this.field188 = new PcmStream[8];
		this.field187 = new PcmStream[8];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1766369380"
	)
	@Export("init")
	protected void init() throws Exception {
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-83"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1982834691"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("at")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1874015336"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "54"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lbw;I)V",
		garbageValue = "-828545471"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = GameEngine.clockNow();

			try {
				if (0L != this.field198) {
					if (var1 < this.field198) {
						return;
					}

					this.open(this.capacity);
					this.field198 = 0L;
					this.field185 = true;
				}

				int var3 = this.position();
				if (this.field193 - var3 > this.field195) {
					this.field195 = this.field193 - var3;
				}

				int var4 = this.field190 + this.field194;
				if (var4 + 256 > 16384) {
					var4 = 16128;
				}

				if (var4 + 256 > this.capacity) {
					this.capacity += 1024;
					if (this.capacity > 16384) {
						this.capacity = 16384;
					}

					this.close();
					this.open(this.capacity);
					var3 = 0;
					this.field185 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field190 = var4 - this.field194;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field199) {
					if (!this.field185) {
						if (this.field195 == 0 && this.field191 == 0) {
							this.close();
							this.field198 = var1 + 2000L;
							return;
						}

						this.field190 = Math.min(this.field191, this.field195);
						this.field191 = this.field195;
					} else {
						this.field185 = false;
					}

					this.field195 = 0;
					this.field199 = var1 + 2000L;
				}

				this.field193 = var3;
			} catch (Exception var7) {
				this.close();
				this.field198 = 2000L + var1;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > this.timeMs + 5000L) {
					this.skip(256);
					this.timeMs += (long)(256000 / field181);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1331437422"
	)
	public final void method200() {
		this.field185 = true;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "30"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field185 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field198 = GameEngine.clockNow() + 2000L;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-35"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (Canvas.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == Canvas.soundSystem.players[var2]) {
					Canvas.soundSystem.players[var2] = null;
				}

				if (Canvas.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				soundSystemExecutor.shutdownNow();
				soundSystemExecutor = null;
				Canvas.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "9"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field196 -= var1;
		if (this.field196 < 0) {
			this.field196 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("bh")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class409.clearIntArray(var1, 0, var3);
		this.field196 -= var2;
		if (this.stream != null && this.field196 <= 0) {
			this.field196 += field181 >> 4;
			class31.PcmStream_disable(this.stream);
			this.method205(this.stream, this.stream.vmethod1019());
			int var4 = 0;
			int var5 = 255;

			int var6;
			PcmStream var10;
			label105:
			for (var6 = 7; var5 != 0; --var6) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}

				for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
					if ((var9 & 1) != 0) {
						var5 &= ~(1 << var7);
						var10 = null;
						PcmStream var11 = this.field188[var7];

						label99:
						while (true) {
							while (true) {
								if (var11 == null) {
									break label99;
								}

								AbstractSound var12 = var11.sound;
								if (var12 != null && var12.position > var8) {
									var5 |= 1 << var7;
									var10 = var11;
									var11 = var11.after;
								} else {
									var11.active = true;
									int var13 = var11.vmethod5648();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field189) {
										break label105;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field249; var14 != null; var14 = var11.nextSubStream()) {
											this.method205(var14, var15 * var14.vmethod1019() >> 8);
										}
									}

									PcmStream var16 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field188[var7] = var16;
									} else {
										var10.after = var16;
									}

									if (var16 == null) {
										this.field187[var7] = var10;
									}

									var11 = var16;
								}
							}
						}
					}

					var7 += 4;
					++var8;
				}
			}

			for (var6 = 0; var6 < 8; ++var6) {
				PcmStream var17 = this.field188[var6];
				PcmStream[] var18 = this.field188;
				this.field187[var6] = null;

				for (var18[var6] = null; var17 != null; var17 = var10) {
					var10 = var17.after;
					var17.after = null;
				}
			}
		}

		if (this.field196 < 0) {
			this.field196 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = GameEngine.clockNow();
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(Lbw;II)V",
		garbageValue = "1754087851"
	)
	final void method205(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field187[var3];
		if (var4 == null) {
			this.field188[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field187[var3] = var1;
		var1.field249 = var2;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "125"
	)
	public static int method197(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 7 & 127L);
		return var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2108015149"
	)
	static void method212(int var0) {
		if (var0 != Login.loginIndex) {
			Login.loginIndex = var0;
		}
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		descriptor = "(Ldr;IIIIIB)V",
		garbageValue = "1"
	)
	@Export("drawActor2d")
	static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
		if (var0 != null && var0.isVisible()) {
			if (var0 instanceof NPC) {
				NPCComposition var6 = ((NPC)var0).definition;
				if (var6.transforms != null) {
					var6 = var6.transform();
				}

				if (var6 == null) {
					return;
				}
			}

			int var75 = Players.Players_count;
			int[] var7 = Players.Players_indices;
			boolean var8 = var1 < var75;
			int var9 = -2;
			if (var0.overheadText != null && (!var8 || !var0.showPublicPlayerChat && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
				SecureRandomFuture.method443(var0, var0.defaultHeight);
				if (Client.viewportTempX > -1 && Client.overheadTextLimit < Client.overheadTextCount) {
					Client.overheadTextXOffsets[Client.overheadTextLimit] = class59.fontBold12.stringWidth(var0.overheadText) / 2;
					Client.overheadTextAscents[Client.overheadTextLimit] = class59.fontBold12.ascent;
					Client.overheadTextXs[Client.overheadTextLimit] = Client.viewportTempX;
					Client.overheadTextYs[Client.overheadTextLimit] = Client.viewportTempY - var9;
					Client.overheadTextColors[Client.overheadTextLimit] = var0.field995;
					Client.overheadTextEffects[Client.overheadTextLimit] = var0.field996;
					Client.overheadTextCyclesRemaining[Client.overheadTextLimit] = var0.overheadTextCyclesRemaining;
					Client.field594[Client.overheadTextLimit] = var0.field1028;
					Client.field603[Client.overheadTextLimit] = var0.overheadText;
					++Client.overheadTextLimit;
					var9 += 12;
				}
			}

			int var15;
			int var22;
			int var23;
			if (!var0.healthBars.method2008()) {
				SecureRandomFuture.method443(var0, var0.defaultHeight + 15);

				for (HealthBar var10 = (HealthBar)var0.healthBars.last(); var10 != null; var10 = (HealthBar)var0.healthBars.previous()) {
					HealthBarUpdate var11 = var10.get(Client.cycle);
					if (var11 == null) {
						if (var10.isEmpty()) {
							var10.remove();
						}
					} else {
						HealthBarDefinition var12 = var10.definition;
						SpritePixels var13 = var12.getBackSprite();
						SpritePixels var14 = var12.getFrontSprite();
						int var16 = 0;
						if (var13 != null && var14 != null) {
							if (var12.widthPadding * 2 < var14.subWidth) {
								var16 = var12.widthPadding;
							}

							var15 = var14.subWidth - var16 * 2;
						} else {
							var15 = var12.width;
						}

						int var17 = 255;
						boolean var18 = true;
						int var19 = Client.cycle - var11.cycle;
						int var20 = var15 * var11.health2 / var12.width;
						int var21;
						int var97;
						if (var11.cycleOffset > var19) {
							var21 = var12.field1556 == 0 ? 0 : var12.field1556 * (var19 / var12.field1556);
							var22 = var15 * var11.health / var12.width;
							var97 = var21 * (var20 - var22) / var11.cycleOffset + var22;
						} else {
							var97 = var20;
							var21 = var11.cycleOffset + var12.int5 - var19;
							if (var12.int3 >= 0) {
								var17 = (var21 << 8) / (var12.int5 - var12.int3);
							}
						}

						if (var11.health2 > 0 && var97 < 1) {
							var97 = 1;
						}

						if (var13 != null && var14 != null) {
							if (var15 == var97) {
								var97 += var16 * 2;
							} else {
								var97 += var16;
							}

							var21 = var13.subHeight;
							var9 += var21;
							var22 = var2 + Client.viewportTempX - (var15 >> 1);
							var23 = var3 + Client.viewportTempY - var9;
							var22 -= var16;
							if (var17 >= 0 && var17 < 255) {
								var13.drawTransAt(var22, var23, var17);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var97, var23 + var21);
								var14.drawTransAt(var22, var23, var17);
							} else {
								var13.drawTransBgAt(var22, var23);
								Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var97, var21 + var23);
								var14.drawTransBgAt(var22, var23);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
							var9 += 2;
						} else {
							var9 += 5;
							if (Client.viewportTempX > -1) {
								var21 = var2 + Client.viewportTempX - (var15 >> 1);
								var22 = var3 + Client.viewportTempY - var9;
								Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var97, 5, 65280);
								Rasterizer2D.Rasterizer2D_fillRectangle(var97 + var21, var22, var15 - var97, 5, 16711680);
							}

							var9 += 2;
						}
					}
				}
			}

			if (var9 == -2) {
				var9 += 7;
			}

			Player var90;
			if (var8 && var0.playerCycle == Client.cycle && Occluder.method1299((Player)var0)) {
				var90 = (Player)var0;
				if (var8) {
					SecureRandomFuture.method443(var0, var0.defaultHeight + 15);
					AbstractFont var91 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
					var9 += 4;
					var91.drawCentered(var90.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var9, 16777215, 0);
					var9 += 18;
				}
			}

			if (var8) {
				var90 = (Player)var0;
				if (var90.isHidden) {
					return;
				}

				if (var90.headIconPk != -1 || var90.headIconPrayer != -1) {
					SecureRandomFuture.method443(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						if (var90.headIconPk != -1) {
							var9 += 25;
							class178.headIconPkSprites[var90.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
						}

						if (var90.headIconPrayer != -1) {
							var9 += 25;
							class502.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
						}
					}
				}

				if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
					SecureRandomFuture.method443(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						var9 += ArchiveLoader.headIconHintSprites[1].subHeight;
						ArchiveLoader.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
					}
				}
			} else {
				NPC var92 = (NPC)var0;
				int[] var93 = var92.method587();
				short[] var94 = var92.method588();
				if (var94 != null && var93 != null) {
					for (int var76 = 0; var76 < var94.length; ++var76) {
						if (var94[var76] >= 0 && var93[var76] >= 0) {
							long var77 = (long)var93[var76] << 8 | (long)var94[var76];
							SpritePixels var79 = (SpritePixels)Client.archive5.method2180(var77);
							if (var79 == null) {
								SpritePixels[] var80 = WorldMapArchiveLoader.method2379(archive8, var93[var76], 0);
								if (var80 != null && var94[var76] < var80.length) {
									var79 = var80[var94[var76]];
									Client.archive5.method2181(var77, var79);
								}
							}

							if (var79 != null) {
								SecureRandomFuture.method443(var0, var0.defaultHeight + 15);
								if (Client.viewportTempX > -1) {
									var79.drawTransBgAt(var2 + Client.viewportTempX - (var79.subWidth >> 1), Client.viewportTempY + (var3 - var79.subHeight) - 4);
								}
							}
						}
					}
				}

				if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
					SecureRandomFuture.method443(var0, var0.defaultHeight + 15);
					if (Client.viewportTempX > -1) {
						ArchiveLoader.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
					}
				}
			}

			for (int var81 = 0; var81 < 4; ++var81) {
				int var82 = var0.hitSplatCycles[var81];
				int var83 = var0.hitSplatTypes[var81];
				HitSplatDefinition var95 = null;
				int var84 = 0;
				if (var83 >= 0) {
					if (var82 <= Client.cycle) {
						continue;
					}

					var95 = WorldMapCacheName.method1564(var0.hitSplatTypes[var81]);
					var84 = var95.field1706;
					if (var95 != null && var95.transforms != null) {
						var95 = var95.transform();
						if (var95 == null) {
							var0.hitSplatCycles[var81] = -1;
							continue;
						}
					}
				} else if (var82 < 0) {
					continue;
				}

				var15 = var0.hitSplatTypes2[var81];
				HitSplatDefinition var99 = null;
				if (var15 >= 0) {
					var99 = WorldMapCacheName.method1564(var15);
					if (var99 != null && var99.transforms != null) {
						var99 = var99.transform();
					}
				}

				if (var82 - var84 <= Client.cycle) {
					if (var95 == null) {
						var0.hitSplatCycles[var81] = -1;
					} else {
						SecureRandomFuture.method443(var0, var0.defaultHeight / 2);
						if (Client.viewportTempX > -1) {
							boolean var96 = true;
							if (var81 == 1) {
								Client.viewportTempY -= 20;
							}

							if (var81 == 2) {
								Client.viewportTempX -= 15;
								Client.viewportTempY -= 10;
							}

							if (var81 == 3) {
								Client.viewportTempX += 15;
								Client.viewportTempY -= 10;
							}

							SpritePixels var85 = null;
							SpritePixels var86 = null;
							SpritePixels var87 = null;
							SpritePixels var88 = null;
							var22 = 0;
							var23 = 0;
							int var24 = 0;
							int var25 = 0;
							int var26 = 0;
							int var27 = 0;
							int var28 = 0;
							int var29 = 0;
							SpritePixels var30 = null;
							SpritePixels var31 = null;
							SpritePixels var32 = null;
							SpritePixels var33 = null;
							int var34 = 0;
							int var35 = 0;
							int var36 = 0;
							int var37 = 0;
							int var38 = 0;
							int var39 = 0;
							int var40 = 0;
							int var41 = 0;
							int var42 = 0;
							var85 = var95.method1032();
							int var43;
							if (var85 != null) {
								var22 = var85.subWidth;
								var43 = var85.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var26 = var85.xOffset;
							}

							var86 = var95.method1033();
							if (var86 != null) {
								var23 = var86.subWidth;
								var43 = var86.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var27 = var86.xOffset;
							}

							var87 = var95.method1034();
							if (var87 != null) {
								var24 = var87.subWidth;
								var43 = var87.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var28 = var87.xOffset;
							}

							var88 = var95.method1035();
							if (var88 != null) {
								var25 = var88.subWidth;
								var43 = var88.subHeight;
								if (var43 > var42) {
									var42 = var43;
								}

								var29 = var88.xOffset;
							}

							if (var99 != null) {
								var30 = var99.method1032();
								if (var30 != null) {
									var34 = var30.subWidth;
									var43 = var30.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var38 = var30.xOffset;
								}

								var31 = var99.method1033();
								if (var31 != null) {
									var35 = var31.subWidth;
									var43 = var31.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var39 = var31.xOffset;
								}

								var32 = var99.method1034();
								if (var32 != null) {
									var36 = var32.subWidth;
									var43 = var32.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var40 = var32.xOffset;
								}

								var33 = var99.method1035();
								if (var33 != null) {
									var37 = var33.subWidth;
									var43 = var33.subHeight;
									if (var43 > var42) {
										var42 = var43;
									}

									var41 = var33.xOffset;
								}
							}

							Font var89 = var95.getFont();
							if (var89 == null) {
								var89 = HealthBarUpdate.fontPlain11;
							}

							Font var44;
							if (var99 != null) {
								var44 = var99.getFont();
								if (var44 == null) {
									var44 = HealthBarUpdate.fontPlain11;
								}
							} else {
								var44 = HealthBarUpdate.fontPlain11;
							}

							String var45 = null;
							String var46 = null;
							boolean var47 = false;
							int var48 = 0;
							var45 = var95.getString(var0.hitSplatValues[var81]);
							int var98 = var89.stringWidth(var45);
							if (var99 != null) {
								var46 = var99.getString(var0.hitSplatValues2[var81]);
								var48 = var44.stringWidth(var46);
							}

							int var49 = 0;
							int var50 = 0;
							if (var23 > 0) {
								if (var87 == null && var88 == null) {
									var49 = 1;
								} else {
									var49 = var98 / var23 + 1;
								}
							}

							if (var99 != null && var35 > 0) {
								if (var32 == null && var33 == null) {
									var50 = 1;
								} else {
									var50 = var48 / var35 + 1;
								}
							}

							int var51 = 0;
							int var52 = var51;
							if (var22 > 0) {
								var51 += var22;
							}

							var51 += 2;
							int var53 = var51;
							if (var24 > 0) {
								var51 += var24;
							}

							int var54 = var51;
							int var55 = var51;
							int var56;
							if (var23 > 0) {
								var56 = var23 * var49;
								var51 += var56;
								var55 += (var56 - var98) / 2;
							} else {
								var51 += var98;
							}

							var56 = var51;
							if (var25 > 0) {
								var51 += var25;
							}

							int var57 = 0;
							int var58 = 0;
							int var59 = 0;
							int var60 = 0;
							int var61 = 0;
							int var62;
							if (var99 != null) {
								var51 += 2;
								var57 = var51;
								if (var34 > 0) {
									var51 += var34;
								}

								var51 += 2;
								var58 = var51;
								if (var36 > 0) {
									var51 += var36;
								}

								var59 = var51;
								var61 = var51;
								if (var35 > 0) {
									var62 = var50 * var35;
									var51 += var62;
									var61 += (var62 - var48) / 2;
								} else {
									var51 += var48;
								}

								var60 = var51;
								if (var37 > 0) {
									var51 += var37;
								}
							}

							var62 = var0.hitSplatCycles[var81] - Client.cycle;
							int var63 = var95.field1709 - var62 * var95.field1709 / var95.field1706;
							int var64 = var62 * var95.field1703 / var95.field1706 + -var95.field1703;
							int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
							int var66 = var3 + Client.viewportTempY - 12 + var64;
							int var67 = var66;
							int var68 = var42 + var66;
							int var69 = var66 + var95.field1708 + 15;
							int var70 = var69 - var89.maxAscent;
							int var71 = var69 + var89.maxDescent;
							if (var70 < var66) {
								var67 = var70;
							}

							if (var71 > var68) {
								var68 = var71;
							}

							int var72 = 0;
							int var73;
							int var74;
							if (var99 != null) {
								var72 = var66 + var99.field1708 + 15;
								var73 = var72 - var44.maxAscent;
								var74 = var72 + var44.maxDescent;
								if (var73 < var67) {
									;
								}

								if (var74 > var68) {
									;
								}
							}

							var73 = 255;
							if (var95.field1707 >= 0) {
								var73 = (var62 << 8) / (var95.field1706 - var95.field1707);
							}

							if (var73 >= 0 && var73 < 255) {
								if (var85 != null) {
									var85.drawTransAt(var65 + var52 - var26, var66, var73);
								}

								if (var87 != null) {
									var87.drawTransAt(var65 + var53 - var28, var66, var73);
								}

								if (var86 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var86.drawTransAt(var74 * var23 + (var54 + var65 - var27), var66, var73);
									}
								}

								if (var88 != null) {
									var88.drawTransAt(var65 + var56 - var29, var66, var73);
								}

								var89.drawAlpha(var45, var65 + var55, var69, var95.textColor, 0, var73);
								if (var99 != null) {
									if (var30 != null) {
										var30.drawTransAt(var57 + var65 - var38, var66, var73);
									}

									if (var32 != null) {
										var32.drawTransAt(var58 + var65 - var40, var66, var73);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransAt(var74 * var35 + (var59 + var65 - var39), var66, var73);
										}
									}

									if (var33 != null) {
										var33.drawTransAt(var65 + var60 - var41, var66, var73);
									}

									var44.drawAlpha(var46, var61 + var65, var72, var99.textColor, 0, var73);
								}
							} else {
								if (var85 != null) {
									var85.drawTransBgAt(var65 + var52 - var26, var66);
								}

								if (var87 != null) {
									var87.drawTransBgAt(var65 + var53 - var28, var66);
								}

								if (var86 != null) {
									for (var74 = 0; var74 < var49; ++var74) {
										var86.drawTransBgAt(var23 * var74 + (var65 + var54 - var27), var66);
									}
								}

								if (var88 != null) {
									var88.drawTransBgAt(var56 + var65 - var29, var66);
								}

								var89.draw(var45, var65 + var55, var69, var95.textColor | -16777216, 0);
								if (var99 != null) {
									if (var30 != null) {
										var30.drawTransBgAt(var57 + var65 - var38, var66);
									}

									if (var32 != null) {
										var32.drawTransBgAt(var58 + var65 - var40, var66);
									}

									if (var31 != null) {
										for (var74 = 0; var74 < var50; ++var74) {
											var31.drawTransBgAt(var74 * var35 + (var65 + var59 - var39), var66);
										}
									}

									if (var33 != null) {
										var33.drawTransBgAt(var65 + var60 - var41, var66);
									}

									var44.draw(var46, var65 + var61, var72, var99.textColor | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("md")
	@ObfuscatedSignature(
		descriptor = "([Lmi;IIIZI)V",
		garbageValue = "-166664235"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				class369.alignWidgetSize(var6, var2, var3, var4);
				WorldMapArea.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					Login.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}
}