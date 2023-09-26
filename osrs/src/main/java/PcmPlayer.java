import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("ao")
	public static int field179;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("leftTitleSprite")
	static SpritePixels leftTitleSprite;
	@ObfuscatedName("tw")
	static boolean field180;
	@ObfuscatedName("ay")
	@Export("samples")
	public int[] samples;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lbi;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("aj")
	int field187;
	@ObfuscatedName("an")
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("au")
	@Export("capacity")
	public int capacity;
	@ObfuscatedName("ai")
	public int field195;
	@ObfuscatedName("ae")
	int field186;
	@ObfuscatedName("aw")
	long field194;
	@ObfuscatedName("aq")
	int field188;
	@ObfuscatedName("az")
	int field190;
	@ObfuscatedName("at")
	int field189;
	@ObfuscatedName("af")
	long field192;
	@ObfuscatedName("ad")
	boolean field185;
	@ObfuscatedName("bv")
	int field191;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "[Lbi;"
	)
	PcmStream[] field183;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "[Lbi;"
	)
	PcmStream[] field184;

	public PcmPlayer() {
		this.field187 = 32;
		this.timeMs = GrandExchangeOfferTotalQuantityComparator.method1971();
		this.field194 = 0L;
		this.field188 = 0;
		this.field190 = 0;
		this.field189 = 0;
		this.field192 = 0L;
		this.field185 = true;
		this.field191 = 0;
		this.field183 = new PcmStream[8];
		this.field184 = new PcmStream[8];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1058566109"
	)
	@Export("init")
	public void init() throws Exception {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "1"
	)
	@Export("open")
	public void open(int var1) throws Exception {
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-325041005"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("ax")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "3331"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lbi;I)V",
		garbageValue = "-1717479669"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1281644299"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = GrandExchangeOfferTotalQuantityComparator.method1971();

			try {
				if (this.field194 != 0L) {
					if (var1 < this.field194) {
						return;
					}

					this.open(this.capacity);
					this.field194 = 0L;
					this.field185 = true;
				}

				int var3 = this.position();
				if (this.field189 - var3 > this.field188) {
					this.field188 = this.field189 - var3;
				}

				int var4 = this.field186 + this.field195;
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
						this.field186 = var4 - this.field195;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field192) {
					if (!this.field185) {
						if (this.field188 == 0 && this.field190 == 0) {
							this.close();
							this.field194 = var1 + 2000L;
							return;
						}

						this.field186 = Math.min(this.field190, this.field188);
						this.field190 = this.field188;
					} else {
						this.field185 = false;
					}

					this.field188 = 0;
					this.field192 = 2000L + var1;
				}

				this.field189 = var3;
			} catch (Exception var7) {
				this.close();
				this.field194 = var1 + 2000L;
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

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "233937978"
	)
	public final void method209() {
		this.field185 = true;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1063946921"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field185 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field194 = GrandExchangeOfferTotalQuantityComparator.method1971() + 2000L;
		}

	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1490878758"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (UserComparator4.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == UserComparator4.soundSystem.players[var2]) {
					UserComparator4.soundSystem.players[var2] = null;
				}

				if (UserComparator4.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				class353.soundSystemExecutor.shutdownNow();
				class353.soundSystemExecutor = null;
				UserComparator4.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1697605758"
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

	@ObfuscatedName("bd")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (class306.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class424.clearIntArray(var1, 0, var3);
		this.field191 -= var2;
		if (this.stream != null && this.field191 <= 0) {
			this.field191 += field179 >> 4;
			class193.PcmStream_disable(this.stream);
			this.method214(this.stream, this.stream.vmethod1019());
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
						PcmStream var11 = this.field183[var7];

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

									if (var4 >= this.field187) {
										break label105;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field247; var14 != null; var14 = var11.nextSubStream()) {
											this.method214(var14, var15 * var14.vmethod1019() >> 8);
										}
									}

									PcmStream var16 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field183[var7] = var16;
									} else {
										var10.after = var16;
									}

									if (var16 == null) {
										this.field184[var7] = var10;
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
				PcmStream var17 = this.field183[var6];
				PcmStream[] var18 = this.field183;
				this.field184[var6] = null;

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

		this.timeMs = GrandExchangeOfferTotalQuantityComparator.method1971();
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Lbi;IB)V",
		garbageValue = "-119"
	)
	final void method214(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field184[var3];
		if (var4 == null) {
			this.field183[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field184[var3] = var1;
		var1.field247 = var2;
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "13"
	)
	static final void method221() {
		int var0;
		int var1;
		int var2;
		if (!Client.field402) {
			var0 = class191.cameraMoveToX * 128 + 64;
			var1 = MouseHandler.cameraMoveToY * 128 + 64;
			var2 = class115.getTileHeight(var0, var1, class87.Client_plane) - SoundSystem.cameraMoveToHeight;
			WorldMapSectionType.method1555(var0, var2, var1);
		} else if (Client.field646 != null) {
			Client.cameraX = Client.field646.vmethod2349();
			WorldMapArea.cameraZ = Client.field646.vmethod2347();
			if (Client.field403) {
				class17.cameraY = Client.field646.vmethod2320();
			} else {
				class17.cameraY = class115.getTileHeight(Client.cameraX, WorldMapArea.cameraZ, class87.Client_plane) - Client.field646.vmethod2320();
			}

			Client.field646.method2413();
		}

		if (!Client.field401) {
			var0 = class148.cameraLookAtX * 128 + 64;
			var1 = BufferedNetSocket.cameraLookAtY * 128 + 64;
			var2 = class115.getTileHeight(var0, var1, class87.Client_plane) - class161.cameraLookAtHeight;
			int var3 = var0 - Client.cameraX;
			int var4 = var2 - class17.cameraY;
			int var5 = var1 - WorldMapArea.cameraZ;
			int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
			int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.9490051269531D) & 2047;
			int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.9490051269531D) & 2047;
			Projectile.method438(var7, var8);
		} else {
			if (Client.field642 != null) {
				class365.cameraPitch = Client.field642.method2409();
				class365.cameraPitch = Math.min(Math.max(class365.cameraPitch, 128), 383);
				Client.field642.method2413();
			}

			if (Client.field643 != null) {
				WallDecoration.cameraYaw = Client.field643.method2409() & 2047;
				Client.field643.method2413();
			}
		}

	}
}