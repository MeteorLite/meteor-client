import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("PcmPlayer")
public class PcmPlayer {
	@ObfuscatedName("as")
	public static int field181;
	@ObfuscatedName("cm")
	static int field182;
	@ObfuscatedName("oa")
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("ax")
	@Export("samples")
	public int[] samples;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lby;"
	)
	@Export("stream")
	PcmStream stream;
	@ObfuscatedName("au")
	int field192;
	@ObfuscatedName("ae")
	@Export("timeMs")
	long timeMs;
	@ObfuscatedName("ab")
	@Export("capacity")
	public int capacity;
	@ObfuscatedName("ad")
	public int field198;
	@ObfuscatedName("ao")
	int field191;
	@ObfuscatedName("ac")
	long field194;
	@ObfuscatedName("ak")
	int field189;
	@ObfuscatedName("an")
	int field190;
	@ObfuscatedName("af")
	int field188;
	@ObfuscatedName("ai")
	long field196;
	@ObfuscatedName("al")
	boolean field184;
	@ObfuscatedName("bs")
	int field193;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "[Lby;"
	)
	PcmStream[] field186;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "[Lby;"
	)
	PcmStream[] field187;

	public PcmPlayer() {
		this.field192 = 32;
		this.timeMs = class113.clockNow();
		this.field194 = 0L;
		this.field189 = 0;
		this.field190 = 0;
		this.field188 = 0;
		this.field196 = 0L;
		this.field184 = true;
		this.field193 = 0;
		this.field186 = new PcmStream[8];
		this.field187 = new PcmStream[8];
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-27916"
	)
	@Export("init")
	public void init() throws Exception {
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1387208790"
	)
	@Export("open")
	public void open(int var1) throws Exception {
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-110"
	)
	@Export("position")
	protected int position() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("am")
	@Export("write")
	protected void write() throws Exception {
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1310720179"
	)
	@Export("close")
	protected void close() {
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1294273793"
	)
	@Export("discard")
	protected void discard() throws Exception {
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Lby;B)V",
		garbageValue = "46"
	)
	@Export("setStream")
	public final synchronized void setStream(PcmStream var1) {
		this.stream = var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1561448166"
	)
	@Export("run")
	public final synchronized void run() {
		if (this.samples != null) {
			long var1 = class113.clockNow();

			try {
				if (this.field194 != 0L) {
					if (var1 < this.field194) {
						return;
					}

					this.open(this.capacity);
					this.field194 = 0L;
					this.field184 = true;
				}

				int var3 = this.position();
				if (this.field188 - var3 > this.field189) {
					this.field189 = this.field188 - var3;
				}

				int var4 = this.field191 + this.field198;
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
					this.field184 = true;
					if (var4 + 256 > this.capacity) {
						var4 = this.capacity - 256;
						this.field191 = var4 - this.field198;
					}
				}

				while (var3 < var4) {
					this.fill(this.samples, 256);
					this.write();
					var3 += 256;
				}

				if (var1 > this.field196) {
					if (!this.field184) {
						if (this.field189 == 0 && this.field190 == 0) {
							this.close();
							this.field194 = var1 + 2000L;
							return;
						}

						this.field191 = Math.min(this.field190, this.field189);
						this.field190 = this.field189;
					} else {
						this.field184 = false;
					}

					this.field189 = 0;
					this.field196 = 2000L + var1;
				}

				this.field188 = var3;
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
					this.timeMs += (long)(256000 / field181);
				}
			} catch (Exception var6) {
				this.timeMs = var1;
			}

		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1629205695"
	)
	public final void method201() {
		this.field184 = true;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2090417340"
	)
	@Export("tryDiscard")
	public final synchronized void tryDiscard() {
		this.field184 = true;

		try {
			this.discard();
		} catch (Exception var2) {
			this.close();
			this.field194 = class113.clockNow() + 2000L;
		}

	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1796457673"
	)
	@Export("shutdown")
	public final synchronized void shutdown() {
		if (WorldMapSectionType.soundSystem != null) {
			boolean var1 = true;

			for (int var2 = 0; var2 < 2; ++var2) {
				if (this == WorldMapSectionType.soundSystem.players[var2]) {
					WorldMapSectionType.soundSystem.players[var2] = null;
				}

				if (WorldMapSectionType.soundSystem.players[var2] != null) {
					var1 = false;
				}
			}

			if (var1) {
				class273.soundSystemExecutor.shutdownNow();
				class273.soundSystemExecutor = null;
				WorldMapSectionType.soundSystem = null;
			}
		}

		this.close();
		this.samples = null;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "75"
	)
	@Export("skip")
	final void skip(int var1) {
		this.field193 -= var1;
		if (this.field193 < 0) {
			this.field193 = 0;
		}

		if (this.stream != null) {
			this.stream.skip(var1);
		}

	}

	@ObfuscatedName("ba")
	@Export("fill")
	final void fill(int[] var1, int var2) {
		int var3 = var2;
		if (class373.PcmPlayer_stereo) {
			var3 = var2 << 1;
		}

		class410.clearIntArray(var1, 0, var3);
		this.field193 -= var2;
		if (this.stream != null && this.field193 <= 0) {
			this.field193 += field181 >> 4;
			class345.PcmStream_disable(this.stream);
			this.method207(this.stream, this.stream.vmethod1019());
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
						PcmStream var11 = this.field186[var7];

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

									if (var4 >= this.field192) {
										break label105;
									}

									PcmStream var14 = var11.firstSubStream();
									if (var14 != null) {
										for (int var15 = var11.field248; var14 != null; var14 = var11.nextSubStream()) {
											this.method207(var14, var15 * var14.vmethod1019() >> 8);
										}
									}

									PcmStream var16 = var11.after;
									var11.after = null;
									if (var10 == null) {
										this.field186[var7] = var16;
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
				PcmStream var17 = this.field186[var6];
				PcmStream[] var18 = this.field186;
				this.field187[var6] = null;

				for (var18[var6] = null; var17 != null; var17 = var10) {
					var10 = var17.after;
					var17.after = null;
				}
			}
		}

		if (this.field193 < 0) {
			this.field193 = 0;
		}

		if (this.stream != null) {
			this.stream.fill(var1, 0, var2);
		}

		this.timeMs = class113.clockNow();
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(Lby;II)V",
		garbageValue = "702268738"
	)
	final void method207(PcmStream var1, int var2) {
		int var3 = var2 >> 5;
		PcmStream var4 = this.field187[var3];
		if (var4 == null) {
			this.field186[var3] = var1;
		} else {
			var4.after = var1;
		}

		this.field187[var3] = var1;
		var1.field248 = var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ZZI)Luu;",
		garbageValue = "1707988592"
	)
	static IndexedSprite method209(boolean var0, boolean var1) {
		return var0 ? (var1 ? Message.field348 : class11.options_buttons_2Sprite) : (var1 ? class4.field4 : WorldMapLabelSize.options_buttons_0Sprite);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Lcr;",
		garbageValue = "1"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return class419.getNextWorldListWorld();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "1"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + class313.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}
}
