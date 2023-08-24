import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("au")
	int field245;
	@ObfuscatedName("ae")
	int field235;
	@ObfuscatedName("ao")
	int field240;
	@ObfuscatedName("at")
	int field244;
	@ObfuscatedName("ac")
	int field234;
	@ObfuscatedName("ai")
	int field237;
	@ObfuscatedName("az")
	int field246;
	@ObfuscatedName("ap")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("aa")
	@Export("start")
	int start;
	@ObfuscatedName("af")
	@Export("end")
	int end;
	@ObfuscatedName("ad")
	boolean field232;
	@ObfuscatedName("aq")
	int field242;
	@ObfuscatedName("al")
	int field238;
	@ObfuscatedName("an")
	int field239;
	@ObfuscatedName("ar")
	int field243;

	@ObfuscatedSignature(
		descriptor = "(Lbu;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field232 = var1.field167;
		this.field235 = var2;
		this.field240 = var3;
		this.field244 = var4;
		this.field245 = 0;
		this.method236();
	}

	@ObfuscatedSignature(
		descriptor = "(Lbu;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field232 = var1.field167;
		this.field235 = var2;
		this.field240 = var3;
		this.field244 = 8192;
		this.field245 = 0;
		this.method236();
	}

	@ObfuscatedName("ac")
	void method236() {
		this.field234 = this.field240;
		this.field237 = method231(this.field240, this.field244);
		this.field246 = method232(this.field240, this.field244);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ap")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return this.field240 == 0 && this.field242 == 0 ? 0 : 1;
	}

	@ObfuscatedName("aa")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field240 == 0 && this.field242 == 0) {
			this.skip(var3);
		} else {
			RawSound var4 = (RawSound)super.sound;
			int var5 = this.start << 8;
			int var6 = this.end << 8;
			int var7 = var4.samples.length << 8;
			int var8 = var6 - var5;
			if (var8 <= 0) {
				this.numLoops = 0;
			}

			int var9 = var2;
			var3 += var2;
			if (this.field245 < 0) {
				if (this.field235 <= 0) {
					this.method245();
					this.remove();
					return;
				}

				this.field245 = 0;
			}

			if (this.field245 >= var7) {
				if (this.field235 >= 0) {
					this.method245();
					this.remove();
					return;
				}

				this.field245 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field232) {
					if (this.field235 < 0) {
						var9 = this.method259(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field245 >= var5) {
							return;
						}

						this.field245 = var5 + var5 - 1 - this.field245;
						this.field235 = -this.field235;
					}

					while (true) {
						var9 = this.method258(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field245 < var6) {
							return;
						}

						this.field245 = var6 + var6 - 1 - this.field245;
						this.field235 = -this.field235;
						var9 = this.method259(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field245 >= var5) {
							return;
						}

						this.field245 = var5 + var5 - 1 - this.field245;
						this.field235 = -this.field235;
					}
				} else if (this.field235 < 0) {
					while (true) {
						var9 = this.method259(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field245 >= var5) {
							return;
						}

						this.field245 = var6 - 1 - (var6 - 1 - this.field245) % var8;
					}
				} else {
					while (true) {
						var9 = this.method258(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field245 < var6) {
							return;
						}

						this.field245 = var5 + (this.field245 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field232) {
						label133: {
							if (this.field235 < 0) {
								var9 = this.method259(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field245 >= var5) {
									return;
								}

								this.field245 = var5 + var5 - 1 - this.field245;
								this.field235 = -this.field235;
								if (--this.numLoops == 0) {
									break label133;
								}
							}

							do {
								var9 = this.method258(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field245 < var6) {
									return;
								}

								this.field245 = var6 + var6 - 1 - this.field245;
								this.field235 = -this.field235;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method259(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field245 >= var5) {
									return;
								}

								this.field245 = var5 + var5 - 1 - this.field245;
								this.field235 = -this.field235;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field235 < 0) {
							while (true) {
								var9 = this.method259(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field245 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field245) / var8;
								if (var10 >= this.numLoops) {
									this.field245 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field245 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method258(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field245 < var6) {
									return;
								}

								var10 = (this.field245 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field245 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field245 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field235 < 0) {
					this.method259(var1, var9, 0, var3, 0);
					if (this.field245 < 0) {
						this.field245 = -1;
						this.method245();
						this.remove();
					}
				} else {
					this.method258(var1, var9, var7, var3, 0);
					if (this.field245 >= var7) {
						this.field245 = var7;
						this.method245();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("af")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("ad")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field242 > 0) {
			if (var1 >= this.field242) {
				if (this.field240 == Integer.MIN_VALUE) {
					this.field240 = 0;
					this.field246 = 0;
					this.field237 = 0;
					this.field234 = 0;
					this.remove();
					var1 = this.field242;
				}

				this.field242 = 0;
				this.method236();
			} else {
				this.field234 += this.field238 * var1;
				this.field237 += this.field239 * var1;
				this.field246 += this.field243 * var1;
				this.field242 -= var1;
			}
		}

		RawSound var2 = (RawSound)super.sound;
		int var3 = this.start << 8;
		int var4 = this.end << 8;
		int var5 = var2.samples.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.numLoops = 0;
		}

		if (this.field245 < 0) {
			if (this.field235 <= 0) {
				this.method245();
				this.remove();
				return;
			}

			this.field245 = 0;
		}

		if (this.field245 >= var5) {
			if (this.field235 >= 0) {
				this.method245();
				this.remove();
				return;
			}

			this.field245 = var5 - 1;
		}

		this.field245 += this.field235 * var1;
		if (this.numLoops < 0) {
			if (!this.field232) {
				if (this.field235 < 0) {
					if (this.field245 >= var3) {
						return;
					}

					this.field245 = var4 - 1 - (var4 - 1 - this.field245) % var6;
				} else {
					if (this.field245 < var4) {
						return;
					}

					this.field245 = var3 + (this.field245 - var3) % var6;
				}

			} else {
				if (this.field235 < 0) {
					if (this.field245 >= var3) {
						return;
					}

					this.field245 = var3 + var3 - 1 - this.field245;
					this.field235 = -this.field235;
				}

				while (this.field245 >= var4) {
					this.field245 = var4 + var4 - 1 - this.field245;
					this.field235 = -this.field235;
					if (this.field245 >= var3) {
						return;
					}

					this.field245 = var3 + var3 - 1 - this.field245;
					this.field235 = -this.field235;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field232) {
					label121: {
						if (this.field235 < 0) {
							if (this.field245 >= var3) {
								return;
							}

							this.field245 = var3 + var3 - 1 - this.field245;
							this.field235 = -this.field235;
							if (--this.numLoops == 0) {
								break label121;
							}
						}

						do {
							if (this.field245 < var4) {
								return;
							}

							this.field245 = var4 + var4 - 1 - this.field245;
							this.field235 = -this.field235;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field245 >= var3) {
								return;
							}

							this.field245 = var3 + var3 - 1 - this.field245;
							this.field235 = -this.field235;
						} while(--this.numLoops != 0);
					}
				} else {
					label153: {
						int var7;
						if (this.field235 < 0) {
							if (this.field245 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field245) / var6;
							if (var7 >= this.numLoops) {
								this.field245 += var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field245 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field245 < var4) {
								return;
							}

							var7 = (this.field245 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field245 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field245 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field235 < 0) {
				if (this.field245 < 0) {
					this.field245 = -1;
					this.method245();
					this.remove();
				}
			} else if (this.field245 >= var5) {
				this.field245 = var5;
				this.method245();
				this.remove();
			}

		}
	}

	@ObfuscatedName("aq")
	public synchronized void method238(int var1) {
		this.method240(var1 << 6, this.method242());
	}

	@ObfuscatedName("al")
	synchronized void method239(int var1) {
		this.method240(var1, this.method242());
	}

	@ObfuscatedName("an")
	synchronized void method240(int var1, int var2) {
		this.field240 = var1;
		this.field244 = var2;
		this.field242 = 0;
		this.method236();
	}

	@ObfuscatedName("ar")
	public synchronized int method241() {
		return this.field240 == Integer.MIN_VALUE ? 0 : this.field240;
	}

	@ObfuscatedName("ab")
	public synchronized int method242() {
		return this.field244 < 0 ? -1 : this.field244;
	}

	@ObfuscatedName("ag")
	public synchronized void method243(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field245 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method244() {
		this.field235 = (this.field235 ^ this.field235 >> 31) + (this.field235 >>> 31);
		this.field235 = -this.field235;
	}

	@ObfuscatedName("ax")
	void method245() {
		if (this.field242 != 0) {
			if (this.field240 == Integer.MIN_VALUE) {
				this.field240 = 0;
			}

			this.field242 = 0;
			this.method236();
		}

	}

	@ObfuscatedName("ah")
	public synchronized void method246(int var1, int var2) {
		this.method247(var1, var2, this.method242());
	}

	@ObfuscatedName("as")
	public synchronized void method247(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method240(var2, var3);
		} else {
			int var4 = method231(var2, var3);
			int var5 = method232(var2, var3);
			if (var4 == this.field237 && var5 == this.field246) {
				this.field242 = 0;
			} else {
				int var6 = var2 - this.field234;
				if (this.field234 - var2 > var6) {
					var6 = this.field234 - var2;
				}

				if (var4 - this.field237 > var6) {
					var6 = var4 - this.field237;
				}

				if (this.field237 - var4 > var6) {
					var6 = this.field237 - var4;
				}

				if (var5 - this.field246 > var6) {
					var6 = var5 - this.field246;
				}

				if (this.field246 - var5 > var6) {
					var6 = this.field246 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field242 = var1;
				this.field240 = var2;
				this.field244 = var3;
				this.field238 = (var2 - this.field234) / var1;
				this.field239 = (var4 - this.field237) / var1;
				this.field243 = (var5 - this.field246) / var1;
			}
		}
	}

	@ObfuscatedName("ay")
	public synchronized void method248(int var1) {
		if (var1 == 0) {
			this.method239(0);
			this.remove();
		} else if (this.field237 == 0 && this.field246 == 0) {
			this.field242 = 0;
			this.field240 = 0;
			this.field234 = 0;
			this.remove();
		} else {
			int var2 = -this.field234;
			if (this.field234 > var2) {
				var2 = this.field234;
			}

			if (-this.field237 > var2) {
				var2 = -this.field237;
			}

			if (this.field237 > var2) {
				var2 = this.field237;
			}

			if (-this.field246 > var2) {
				var2 = -this.field246;
			}

			if (this.field246 > var2) {
				var2 = this.field246;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field242 = var1;
			this.field240 = Integer.MIN_VALUE;
			this.field238 = -this.field234 / var1;
			this.field239 = -this.field237 / var1;
			this.field243 = -this.field246 / var1;
		}
	}

	@ObfuscatedName("aj")
	public synchronized void method249(int var1) {
		if (this.field235 < 0) {
			this.field235 = -var1;
		} else {
			this.field235 = var1;
		}

	}

	@ObfuscatedName("av")
	public synchronized int method250() {
		return this.field235 < 0 ? -this.field235 : this.field235;
	}

	@ObfuscatedName("aw")
	public boolean method251() {
		return this.field245 < 0 || this.field245 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ak")
	public boolean method252() {
		return this.field242 != 0;
	}

	@ObfuscatedName("bh")
	int method258(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field242 > 0) {
				int var6 = var2 + this.field242;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field242 += var2;
				if (this.field235 == 256 && (this.field245 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method270(0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, this.field239, this.field243, 0, var6, var3, this);
					} else {
						var2 = method269(((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, this.field238, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method274(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, this.field239, this.field243, 0, var6, var3, this, this.field235, var5);
				} else {
					var2 = method273(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, this.field238, 0, var6, var3, this, this.field235, var5);
				}

				this.field242 -= var2;
				if (this.field242 != 0) {
					return var2;
				}

				if (!this.method260()) {
					continue;
				}

				return var4;
			}

			if (this.field235 == 256 && (this.field245 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method262(0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, 0, var4, var3, this);
				}

				return method261(((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method266(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, 0, var4, var3, this, this.field235, var5);
			}

			return method265(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, 0, var4, var3, this, this.field235, var5);
		}
	}

	@ObfuscatedName("bm")
	int method259(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field242 > 0) {
				int var6 = var2 + this.field242;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field242 += var2;
				if (this.field235 == -256 && (this.field245 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method272(0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, this.field239, this.field243, 0, var6, var3, this);
					} else {
						var2 = method271(((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, this.field238, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method276(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, this.field239, this.field243, 0, var6, var3, this, this.field235, var5);
				} else {
					var2 = method275(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, this.field238, 0, var6, var3, this, this.field235, var5);
				}

				this.field242 -= var2;
				if (this.field242 != 0) {
					return var2;
				}

				if (!this.method260()) {
					continue;
				}

				return var4;
			}

			if (this.field235 == -256 && (this.field245 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method264(0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, 0, var4, var3, this);
				}

				return method263(((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method268(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field237, this.field246, 0, var4, var3, this, this.field235, var5);
			}

			return method267(0, 0, ((RawSound)super.sound).samples, var1, this.field245, var2, this.field234, 0, var4, var3, this, this.field235, var5);
		}
	}

	@ObfuscatedName("bf")
	boolean method260() {
		int var1 = this.field240;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method231(var1, this.field244);
			var3 = method232(var1, this.field244);
		}

		if (var1 == this.field234 && var2 == this.field237 && var3 == this.field246) {
			if (this.field240 == Integer.MIN_VALUE) {
				this.field240 = 0;
				this.field246 = 0;
				this.field237 = 0;
				this.field234 = 0;
				this.remove();
				return true;
			} else {
				this.method236();
				return false;
			}
		} else {
			if (this.field234 < var1) {
				this.field238 = 1;
				this.field242 = var1 - this.field234;
			} else if (this.field234 > var1) {
				this.field238 = -1;
				this.field242 = this.field234 - var1;
			} else {
				this.field238 = 0;
			}

			if (this.field237 < var2) {
				this.field239 = 1;
				if (this.field242 == 0 || this.field242 > var2 - this.field237) {
					this.field242 = var2 - this.field237;
				}
			} else if (this.field237 > var2) {
				this.field239 = -1;
				if (this.field242 == 0 || this.field242 > this.field237 - var2) {
					this.field242 = this.field237 - var2;
				}
			} else {
				this.field239 = 0;
			}

			if (this.field246 < var3) {
				this.field243 = 1;
				if (this.field242 == 0 || this.field242 > var3 - this.field246) {
					this.field242 = var3 - this.field246;
				}
			} else if (this.field246 > var3) {
				this.field243 = -1;
				if (this.field242 == 0 || this.field242 > this.field246 - var3) {
					this.field242 = this.field246 - var3;
				}
			} else {
				this.field243 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("br")
	@Export("vmethod1019")
	int vmethod1019() {
		int var1 = this.field234 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field245 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("au")
	static int method231(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ae")
	static int method232(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lbu;II)Lbn;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field181 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lbu;III)Lbn;"
	)
	public static RawPcmStream method235(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbn;)I"
	)
	static int method261(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var7 - var2) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
			var10001 = var3++;
		}

		var8.field245 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbn;)I"
	)
	static int method262(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var4 + var9 - var3) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field245 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbn;)I"
	)
	static int method263(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
		var2 >>= 8;
		var7 >>= 8;
		var4 <<= 2;
		if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
			var5 = var6;
		}

		int var10001;
		for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var10001 = var3++;
		}

		for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
			var10001 = var3++;
		}

		var8.field245 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbn;)I"
	)
	static int method264(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
		var3 >>= 8;
		var9 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
			var7 = var8;
		}

		var4 <<= 1;
		var7 <<= 1;

		int var10001;
		byte var11;
		for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
			var2[var10001] += var11 * var6;
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
			var11 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var11 * var5;
			var10001 = var4++;
		}

		var10.field245 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbn;II)I"
	)
	static int method265(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
			var7 = var8;
		}

		byte var13;
		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			var13 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
			var7 = var8;
		}

		for (var1 = var12; var5 < var7; var4 += var11) {
			var13 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
		}

		var10.field245 = var4;
		return var5;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbn;II)I"
	)
	static int method266(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		byte var14;
		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field245 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbn;II)I"
	)
	static int method267(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
		if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
			var7 = var8;
		}

		int var10001;
		while (var5 < var7) {
			var1 = var4 >> 8;
			byte var13 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
			var4 += var11;
		}

		if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
			var7 = var8;
		}

		var0 = var12;

		for (var1 = var11; var5 < var7; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
		}

		var10.field245 = var4;
		return var5;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbn;II)I"
	)
	static int method268(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var5 <<= 1;

		int var10001;
		for (var8 <<= 1; var5 < var8; var4 += var12) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var8 <<= 1;

		for (var1 = var13; var5 < var8; var4 += var12) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
		}

		var11.field245 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbn;)I"
	)
	static int method269(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field237 += var9.field239 * (var6 - var3);
		var9.field246 += var9.field243 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2++] * var4;
		}

		var9.field234 = var4 >> 2;
		var9.field245 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbn;)I"
	)
	static int method270(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field234 += var12.field238 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3++];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field237 = var5 >> 2;
		var12.field246 = var6 >> 2;
		var12.field245 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbn;)I"
	)
	static int method271(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field237 += var9.field239 * (var6 - var3);
		var9.field246 += var9.field243 * (var6 - var3);

		int var10001;
		for (var6 -= 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
			var4 += var5;
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		for (var6 += 3; var3 < var6; var4 += var5) {
			var10001 = var3++;
			var1[var10001] += var0[var2--] * var4;
		}

		var9.field234 = var4 >> 2;
		var9.field245 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbn;)I"
	)
	static int method272(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field234 += var12.field238 * (var9 - var4);
		var4 <<= 1;
		var9 <<= 1;

		byte var13;
		int var10001;
		for (var9 -= 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
			var6 += var8;
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		for (var9 += 6; var4 < var9; var6 += var8) {
			var13 = var1[var3--];
			var10001 = var4++;
			var2[var10001] += var13 * var5;
			var5 += var7;
			var10001 = var4++;
			var2[var10001] += var13 * var6;
		}

		var12.field237 = var5 >> 2;
		var12.field246 = var6 >> 2;
		var12.field245 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbn;II)I"
	)
	static int method273(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field237 -= var11.field239 * var5;
		var11.field246 -= var11.field243 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
			var8 = var9;
		}

		byte var14;
		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			var14 = var2[var1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
			var8 = var9;
		}

		for (var1 = var13; var5 < var8; var4 += var12) {
			var14 = var2[var4 >> 8];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field237 += var11.field239 * var5;
		var11.field246 += var11.field243 * var5;
		var11.field234 = var6;
		var11.field245 = var4;
		return var5;
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbn;II)I"
	)
	static int method274(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field234 -= var5 * var13.field238;
		if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		byte var16;
		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			var16 = var2[var1];
			var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var16 = var2[var4 >> 8];
			var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field234 += var13.field238 * var5;
		var13.field237 = var6;
		var13.field246 = var7;
		var13.field245 = var4;
		return var5;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbn;II)I"
	)
	static int method275(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field237 -= var11.field239 * var5;
		var11.field246 -= var11.field243 * var5;
		if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		int var10001;
		while (var5 < var8) {
			var1 = var4 >> 8;
			byte var14 = var2[var1 - 1];
			var10001 = var5++;
			var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
			var4 += var12;
		}

		if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
			var8 = var9;
		}

		var0 = var13;

		for (var1 = var12; var5 < var8; var4 += var1) {
			var10001 = var5++;
			var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
			var6 += var7;
		}

		var11.field237 += var11.field239 * var5;
		var11.field246 += var11.field243 * var5;
		var11.field234 = var6;
		var11.field245 = var4;
		return var5;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbn;II)I"
	)
	static int method276(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field234 -= var5 * var13.field238;
		if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var5 <<= 1;

		int var10001;
		for (var10 <<= 1; var5 < var10; var4 += var14) {
			var1 = var4 >> 8;
			byte var16 = var2[var1 - 1];
			var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
			var10 = var11;
		}

		var10 <<= 1;

		for (var1 = var15; var5 < var10; var4 += var14) {
			var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
			var10001 = var5++;
			var3[var10001] += var0 * var6 >> 6;
			var6 += var8;
			var10001 = var5++;
			var3[var10001] += var0 * var7 >> 6;
			var7 += var9;
		}

		var5 >>= 1;
		var13.field234 += var13.field238 * var5;
		var13.field237 = var6;
		var13.field246 = var7;
		var13.field245 = var4;
		return var5;
	}
}