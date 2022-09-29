import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 198001113
	)
	public static int field307;
	@ObfuscatedName("w")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1129159487
	)
	static int field289;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lqi;"
	)
	@Export("rightTitleSprite")
	static SpritePixels rightTitleSprite;
	@ObfuscatedName("ev")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	static Archive field308;
	@ObfuscatedName("t")
	@Export("samples")
	protected int[] samples;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 345659719
	)
	int field305;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = -4829683574331307973L
	)
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 281559795
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1788039721
	)
	int field296;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -51038683
	)
	int field309;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -6052758255276747429L
	)
	long field287;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1751912477
	)
	int field292;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1590684117
	)
	int field300;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1088142097
	)
	int field301;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = -5715826514371147267L
	)
	long field302;
	@ObfuscatedName("o")
	boolean field303;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 703781733
	)
	int field304;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "[Lay;"
	)
	PcmStream[] field288;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "[Lay;"
	)
	PcmStream[] field306;

	protected PcmPlayer() {
		this.field305 = 32;
		this.timeMs = Language.method6232();
		this.field287 = 0L;
		this.field292 = 0;
		this.field300 = 0;
		this.field301 = 0;
		this.field302 = 0L;
		this.field303 = true;
		this.field304 = 0;
		this.field288 = new PcmStream[8];
		this.field306 = new PcmStream[8];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1258996867"
	)
	protected void init() throws Exception {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-18767"
	)
	@Export("open")
	protected void open(int var1) throws Exception {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1605756455"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("n")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1217659327"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1686238954"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(Lay;I)V",
		garbageValue = "-1505570976"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2009296387"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = Language.method6232();

			try {
				if (this.field287 != 0L) {
					if (var1 < this.field287) {
						return;
					}

					this.open(this.capacity);
					this.field287 = 0L;
					this.field303 = true;
				}

				int var3 = this.position();
				if (this.field301 - var3 > this.field292) {
					this.field292 = this.field301 - var3;
				}

				int var4 = this.field296 + this.field309;
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
					this.field303 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field309 = var4 - this.field296;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field302) {
					if (!this.field303) {
						if (this.field292 == 0 && this.field300 == 0) {
							this.close();
							this.field287 = var1 + 2000L;
							return;
						}

						this.field309 = Math.min(this.field300, this.field292);
						this.field300 = this.field292;
					} else {
						this.field303 = false;
					}

					this.field292 = 0;
					this.field302 = 2000L + var1;
				}

				this.field301 = var3;
			} catch (Exception var7) {
				this.close();
				this.field287 = var1 + 2000L;
			}

			try {
				if (var1 > 500000L + this.timeMs) {
					var1 = this.timeMs;
				}

				while (var1 > 5000L + this.timeMs) {
					this.skip(256);
					this.timeMs += (long)(256000 / field307);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-706031060"
	)
	public final void method774() {
		this.field303 = true;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2013759457"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field303 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field287 = Language.method6232() + 2000L;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2126791300"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (Decimator.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == Decimator.soundSystem.players[var2]) {
					Decimator.soundSystem.players[var2] = null;
				}

				if (Decimator.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				class342.soundSystemExecutor.shutdownNow();
				class342.soundSystemExecutor = null;
				Decimator.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1528008370"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field304 -= var1;
		if (this.field304 < 0) {
			this.field304 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("aq")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class352.clearIntArray(var1, 0, var3);
		this.field304 -= var2;
		if (this.stream != null && this.field304 <= 0) {
			this.field304 += field307 >> 4;
			InvDefinition.PcmStream_disable(this.stream);
			this.method762(this.stream, this.stream.vmethod1015());
			int var4 = 0;
			int var5 = 255;

			int var6;
			PcmStream var10;
			label107:
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
						PcmStream var11 = this.field288[var7];

						label101:
						while (true) {
							while (true) {
								if (var11 == null) {
									break label101;
								}

								AbstractSound var12 = var11.sound;
								if (var12 != null && var12.position > var8) {
									var5 |= 1 << var7;
									var10 = var11;
									var11 = var11.after;
								} else {
									var11.active = true;
									int var13 = var11.vmethod5612();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}

									if (var4 >= this.field305) {
										break label107;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field360; var14 != null; var14 = var11.nextSubStream()) {
											this.method762(var14, var15 * var14.vmethod1015() >> 8);
										}
									}

									PcmStream var18 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field288[var7] = var18;
									} else {
										var10.after = var18;
									}

									if (var18 == null) {
										this.field306[var7] = var10;
									}

									var11 = var18;
								}
							}
						}
					}

					var7 += 4;
					++var8;
				}
			}

			for (var6 = 0; var6 < 8; ++var6) {
				PcmStream var16 = this.field288[var6];
				PcmStream[] var17 = this.field288;
				this.field306[var6] = null;

				for (var17[var6] = null; var16 != null; var16 = var10) {
					var10 = var16.after;
					var16.after = null;
				}
			}
		}

		if (this.field304 < 0) {
			this.field304 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = Language.method6232();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lay;IS)V",
		garbageValue = "-12246"
	)
	final void method762(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field306[var3];
		if (var4 == null) {
			this.field288[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field306[var3] = var1;
		var1.field360 = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Ljm;",
		garbageValue = "-728628837"
	)
	public static PacketBufferNode method795() {
		return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
	}
}
