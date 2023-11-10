import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("ab")
	public static int field179;
	@ObfuscatedName("al")
	public static int field180;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lbq;"
	)
	@Export("pcmPlayerProvider")
	public static class51 pcmPlayerProvider;
	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field181;
	@ObfuscatedName("as")
	@Export("samples")
	public int[] samples;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lbk;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("ak")
	int field189;
	@ObfuscatedName("aj")
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("am")
	@Export("capacity")
	public int capacity;
	@ObfuscatedName("aq")
	public int field196;
	@ObfuscatedName("ai")
	int field188;
	@ObfuscatedName("aw")
	long field194;
	@ObfuscatedName("ae")
	int field186;
	@ObfuscatedName("an")
	int field190;
	@ObfuscatedName("ag")
	int field187;
	@ObfuscatedName("ad")
	long field192;
	@ObfuscatedName("af")
	boolean field185;
	@ObfuscatedName("bf")
	int field191;
	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "[Lbk;"
	)
	PcmStream[] field184;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "[Lbk;"
	)
	PcmStream[] field183;

	public PcmPlayer() {
		this.field189 = 32;
		this.timeMs = SpotAnimationDefinition.method962();
		this.field194 = 0L;
		this.field186 = 0;
		this.field190 = 0;
		this.field187 = 0;
		this.field192 = 0L;
		this.field185 = true;
		this.field191 = 0;
		this.field184 = new PcmStream[8];
		this.field183 = new PcmStream[8];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "95"
	)
	@Export("init")
	public void init() throws Exception {
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1706445518"
	)
	@Export("open")
	public void open(int var1) throws Exception {
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-79725090"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("ao")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1254913818"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-264971545"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lbk;B)V",
		garbageValue = "32"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1871006724"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = SpotAnimationDefinition.method962();

			try {
				if (0L != this.field194) {
					if (var1 < this.field194) {
						return;
					}

					this.open(this.capacity);
					this.field194 = 0L;
					this.field185 = true;
				}

				int var3 = this.position();
				if (this.field187 - var3 > this.field186) {
					this.field186 = this.field187 - var3;
				}

				int var4 = this.field196 + this.field188;
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
						this.field188 = var4 - this.field196;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field192) {
					if (!this.field185) {
						if (this.field186 == 0 && this.field190 == 0) {
							this.close();
							this.field194 = 2000L + var1;
							return;
						}

						this.field188 = Math.min(this.field190, this.field186);
						this.field190 = this.field186;
					} else {
						this.field185 = false;
					}

					this.field186 = 0;
					this.field192 = var1 + 2000L;
				}

				this.field187 = var3;
			} catch (Exception var7) {
				this.close();
				this.field194 = 2000L + var1;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / field179);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-440619545"
	)
	public final void method213() {
		this.field185 = true;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2108187094"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field185 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field194 = SpotAnimationDefinition.method962() + 2000L;
		}

	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "592900977"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (DelayFadeTask.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == DelayFadeTask.soundSystem.players[var2]) {
					DelayFadeTask.soundSystem.players[var2] = null;
				}

				if (DelayFadeTask.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				class342.soundSystemExecutor.shutdownNow();
				class342.soundSystemExecutor = null;
				DelayFadeTask.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-120"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field191 -= var1;
		if (this.field191 < 0) {
			this.field191 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("bi")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (WorldMapRectangle.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class421.clearIntArray(var1, 0, var3);
		this.field191 -= var2;
		if (this.stream != null && this.field191 <= 0) {
			this.field191 += field179 >> 4;
			NPC.PcmStream_disable(this.stream);
			this.method218(this.stream, this.stream.vmethod1019());
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
						PcmStream var11 = this.field184[var7];

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
										for (int var15 = var11.field244; var14 != null; var14 = var11.nextSubStream()) {
											this.method218(var14, var15 * var14.vmethod1019() >> 8);
										}
									}

									PcmStream var16 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field184[var7] = var16;
									} else {
										var10.after = var16;
									}

									if (var16 == null) {
										this.field183[var7] = var10;
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
				PcmStream var17 = this.field184[var6];
				PcmStream[] var18 = this.field184;
				this.field183[var6] = null;

				for (var18[var6] = null; var17 != null; var17 = var10) {
					var10 = var17.after;
					var17.after = null;
				}
			}
		}

		if (this.field191 < 0) {
			this.field191 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = SpotAnimationDefinition.method962();
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Lbk;IB)V",
		garbageValue = "39"
	)
	final void method218(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field183[var3];
		if (var4 == null) {
			this.field184[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field183[var3] = var1;
		var1.field244 = var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;Ljava/lang/String;B)I",
		garbageValue = "108"
	)
	public static int method210(Buffer var0, String var1) {
		int var2 = var0.offset;
		byte[] var3 = MusicPatchPcmStream.method1720(var1);
		var0.writeSmartByteShort(var3.length);
		var0.offset += class350.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
		return var0.offset - var2;
	}

	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-54"
	)
	static void method225(int var0) {
		class174.tempMenuAction = new MenuAction();
		class174.tempMenuAction.param0 = Client.menuArguments1[var0];
		class174.tempMenuAction.param1 = Client.menuArguments2[var0];
		class174.tempMenuAction.opcode = Client.menuOpcodes[var0];
		class174.tempMenuAction.identifier = Client.menuIdentifiers[var0];
		class174.tempMenuAction.itemId = Client.menuItemIds[var0];
		class174.tempMenuAction.action = Client.menuActions[var0];
		class174.tempMenuAction.target = Client.menuTargets[var0];
	}
}