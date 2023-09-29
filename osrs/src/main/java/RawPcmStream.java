import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("ac")
	int field233;
	@ObfuscatedName("al")
	int field236;
	@ObfuscatedName("ak")
	int field235;
	@ObfuscatedName("ax")
	int field243;
	@ObfuscatedName("ao")
	int field238;
	@ObfuscatedName("ah")
	int field234;
	@ObfuscatedName("ar")
	int field240;
	@ObfuscatedName("ab")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("am")
	@Export("start")
	int start;
	@ObfuscatedName("av")
	@Export("end")
	int end;
	@ObfuscatedName("ag")
	boolean field230;
	@ObfuscatedName("aa")
	int field231;
	@ObfuscatedName("ap")
	int field239;
	@ObfuscatedName("ay")
	int field244;
	@ObfuscatedName("as")
	int field241;

	@ObfuscatedSignature(
		descriptor = "(Lbs;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field230 = var1.field166;
		this.field236 = var2;
		this.field235 = var3;
		this.field243 = var4;
		this.field233 = 0;
		this.method245();
	}

	@ObfuscatedSignature(
		descriptor = "(Lbs;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field230 = var1.field166;
		this.field236 = var2;
		this.field235 = var3;
		this.field243 = 8192;
		this.field233 = 0;
		this.method245();
	}

	@ObfuscatedName("ao")
	void method245() {
		this.field238 = this.field235;
		this.field234 = method240(this.field235, this.field243);
		this.field240 = method241(this.field235, this.field243);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ab")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return this.field235 == 0 && this.field231 == 0 ? 0 : 1;
	}

	@ObfuscatedName("am")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field235 == 0 && this.field231 == 0) {
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
			if (this.field233 < 0) {
				if (this.field236 <= 0) {
					this.method254();
					this.remove();
					return;
				}

				this.field233 = 0;
			}

			if (this.field233 >= var7) {
				if (this.field236 >= 0) {
					this.method254();
					this.remove();
					return;
				}

				this.field233 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field230) {
					if (this.field236 < 0) {
						var9 = this.method268(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field233 >= var5) {
							return;
						}

						this.field233 = var5 + var5 - 1 - this.field233;
						this.field236 = -this.field236;
					}

					while (true) {
						var9 = this.method267(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field233 < var6) {
							return;
						}

						this.field233 = var6 + var6 - 1 - this.field233;
						this.field236 = -this.field236;
						var9 = this.method268(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field233 >= var5) {
							return;
						}

						this.field233 = var5 + var5 - 1 - this.field233;
						this.field236 = -this.field236;
					}
				} else if (this.field236 < 0) {
					while (true) {
						var9 = this.method268(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field233 >= var5) {
							return;
						}

						this.field233 = var6 - 1 - (var6 - 1 - this.field233) % var8;
					}
				} else {
					while (true) {
						var9 = this.method267(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field233 < var6) {
							return;
						}

						this.field233 = var5 + (this.field233 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field230) {
						label133: {
							if (this.field236 < 0) {
								var9 = this.method268(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field233 >= var5) {
									return;
								}

								this.field233 = var5 + var5 - 1 - this.field233;
								this.field236 = -this.field236;
								if (--this.numLoops == 0) {
									break label133;
								}
							}

							do {
								var9 = this.method267(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field233 < var6) {
									return;
								}

								this.field233 = var6 + var6 - 1 - this.field233;
								this.field236 = -this.field236;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method268(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field233 >= var5) {
									return;
								}

								this.field233 = var5 + var5 - 1 - this.field233;
								this.field236 = -this.field236;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field236 < 0) {
							while (true) {
								var9 = this.method268(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field233 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field233) / var8;
								if (var10 >= this.numLoops) {
									this.field233 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field233 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method267(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field233 < var6) {
									return;
								}

								var10 = (this.field233 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field233 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field233 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field236 < 0) {
					this.method268(var1, var9, 0, var3, 0);
					if (this.field233 < 0) {
						this.field233 = -1;
						this.method254();
						this.remove();
					}
				} else {
					this.method267(var1, var9, var7, var3, 0);
					if (this.field233 >= var7) {
						this.field233 = var7;
						this.method254();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("av")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("ag")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field231 > 0) {
			if (var1 >= this.field231) {
				if (this.field235 == Integer.MIN_VALUE) {
					this.field235 = 0;
					this.field240 = 0;
					this.field234 = 0;
					this.field238 = 0;
					this.remove();
					var1 = this.field231;
				}

				this.field231 = 0;
				this.method245();
			} else {
				this.field238 += this.field239 * var1;
				this.field234 += this.field244 * var1;
				this.field240 += this.field241 * var1;
				this.field231 -= var1;
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

		if (this.field233 < 0) {
			if (this.field236 <= 0) {
				this.method254();
				this.remove();
				return;
			}

			this.field233 = 0;
		}

		if (this.field233 >= var5) {
			if (this.field236 >= 0) {
				this.method254();
				this.remove();
				return;
			}

			this.field233 = var5 - 1;
		}

		this.field233 += this.field236 * var1;
		if (this.numLoops < 0) {
			if (!this.field230) {
				if (this.field236 < 0) {
					if (this.field233 >= var3) {
						return;
					}

					this.field233 = var4 - 1 - (var4 - 1 - this.field233) % var6;
				} else {
					if (this.field233 < var4) {
						return;
					}

					this.field233 = var3 + (this.field233 - var3) % var6;
				}

			} else {
				if (this.field236 < 0) {
					if (this.field233 >= var3) {
						return;
					}

					this.field233 = var3 + var3 - 1 - this.field233;
					this.field236 = -this.field236;
				}

				while (this.field233 >= var4) {
					this.field233 = var4 + var4 - 1 - this.field233;
					this.field236 = -this.field236;
					if (this.field233 >= var3) {
						return;
					}

					this.field233 = var3 + var3 - 1 - this.field233;
					this.field236 = -this.field236;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field230) {
					label121: {
						if (this.field236 < 0) {
							if (this.field233 >= var3) {
								return;
							}

							this.field233 = var3 + var3 - 1 - this.field233;
							this.field236 = -this.field236;
							if (--this.numLoops == 0) {
								break label121;
							}
						}

						do {
							if (this.field233 < var4) {
								return;
							}

							this.field233 = var4 + var4 - 1 - this.field233;
							this.field236 = -this.field236;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field233 >= var3) {
								return;
							}

							this.field233 = var3 + var3 - 1 - this.field233;
							this.field236 = -this.field236;
						} while(--this.numLoops != 0);
					}
				} else {
					label153: {
						int var7;
						if (this.field236 < 0) {
							if (this.field233 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field233) / var6;
							if (var7 >= this.numLoops) {
								this.field233 += var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field233 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field233 < var4) {
								return;
							}

							var7 = (this.field233 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field233 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field233 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field236 < 0) {
				if (this.field233 < 0) {
					this.field233 = -1;
					this.method254();
					this.remove();
				}
			} else if (this.field233 >= var5) {
				this.field233 = var5;
				this.method254();
				this.remove();
			}

		}
	}

	@ObfuscatedName("aa")
	public synchronized void method247(int var1) {
		this.method249(var1 << 6, this.method251());
	}

	@ObfuscatedName("ap")
	synchronized void method248(int var1) {
		this.method249(var1, this.method251());
	}

	@ObfuscatedName("ay")
	synchronized void method249(int var1, int var2) {
		this.field235 = var1;
		this.field243 = var2;
		this.field231 = 0;
		this.method245();
	}

	@ObfuscatedName("as")
	public synchronized int method250() {
		return this.field235 == Integer.MIN_VALUE ? 0 : this.field235;
	}

	@ObfuscatedName("aj")
	public synchronized int method251() {
		return this.field243 < 0 ? -1 : this.field243;
	}

	@ObfuscatedName("an")
	public synchronized void method252(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field233 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method253() {
		this.field236 = (this.field236 ^ this.field236 >> 31) + (this.field236 >>> 31);
		this.field236 = -this.field236;
	}

	@ObfuscatedName("ai")
	void method254() {
		if (this.field231 != 0) {
			if (this.field235 == Integer.MIN_VALUE) {
				this.field235 = 0;
			}

			this.field231 = 0;
			this.method245();
		}

	}

	@ObfuscatedName("ae")
	public synchronized void method255(int var1, int var2) {
		this.method256(var1, var2, this.method251());
	}

	@ObfuscatedName("aw")
	public synchronized void method256(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method249(var2, var3);
		} else {
			int var4 = method240(var2, var3);
			int var5 = method241(var2, var3);
			if (var4 == this.field234 && var5 == this.field240) {
				this.field231 = 0;
			} else {
				int var6 = var2 - this.field238;
				if (this.field238 - var2 > var6) {
					var6 = this.field238 - var2;
				}

				if (var4 - this.field234 > var6) {
					var6 = var4 - this.field234;
				}

				if (this.field234 - var4 > var6) {
					var6 = this.field234 - var4;
				}

				if (var5 - this.field240 > var6) {
					var6 = var5 - this.field240;
				}

				if (this.field240 - var5 > var6) {
					var6 = this.field240 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field231 = var1;
				this.field235 = var2;
				this.field243 = var3;
				this.field239 = (var2 - this.field238) / var1;
				this.field244 = (var4 - this.field234) / var1;
				this.field241 = (var5 - this.field240) / var1;
			}
		}
	}

	@ObfuscatedName("aq")
	public synchronized void method257(int var1) {
		if (var1 == 0) {
			this.method248(0);
			this.remove();
		} else if (this.field234 == 0 && this.field240 == 0) {
			this.field231 = 0;
			this.field235 = 0;
			this.field238 = 0;
			this.remove();
		} else {
			int var2 = -this.field238;
			if (this.field238 > var2) {
				var2 = this.field238;
			}

			if (-this.field234 > var2) {
				var2 = -this.field234;
			}

			if (this.field234 > var2) {
				var2 = this.field234;
			}

			if (-this.field240 > var2) {
				var2 = -this.field240;
			}

			if (this.field240 > var2) {
				var2 = this.field240;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field231 = var1;
			this.field235 = Integer.MIN_VALUE;
			this.field239 = -this.field238 / var1;
			this.field244 = -this.field234 / var1;
			this.field241 = -this.field240 / var1;
		}
	}

	@ObfuscatedName("bb")
	public synchronized void method258(int var1) {
		if (this.field236 < 0) {
			this.field236 = -var1;
		} else {
			this.field236 = var1;
		}

	}

	@ObfuscatedName("bo")
	public synchronized int method259() {
		return this.field236 < 0 ? -this.field236 : this.field236;
	}

	@ObfuscatedName("bp")
	public boolean method260() {
		return this.field233 < 0 || this.field233 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("bm")
	public boolean method261() {
		return this.field231 != 0;
	}

	@ObfuscatedName("br")
	int method267(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field231 > 0) {
				int var6 = var2 + this.field231;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field231 += var2;
				if (this.field236 == 256 && (this.field233 & 255) == 0) {
					if (class306.PcmPlayer_stereo) {
						var2 = method279(0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, this.field244, this.field241, 0, var6, var3, this);
					} else {
						var2 = method278(((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, this.field239, 0, var6, var3, this);
					}
				} else if (class306.PcmPlayer_stereo) {
					var2 = method283(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, this.field244, this.field241, 0, var6, var3, this, this.field236, var5);
				} else {
					var2 = method282(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, this.field239, 0, var6, var3, this, this.field236, var5);
				}

				this.field231 -= var2;
				if (this.field231 != 0) {
					return var2;
				}

				if (!this.method269()) {
					continue;
				}

				return var4;
			}

			if (this.field236 == 256 && (this.field233 & 255) == 0) {
				if (class306.PcmPlayer_stereo) {
					return method271(0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, 0, var4, var3, this);
				}

				return method270(((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, 0, var4, var3, this);
			}

			if (class306.PcmPlayer_stereo) {
				return method275(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, 0, var4, var3, this, this.field236, var5);
			}

			return method274(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, 0, var4, var3, this, this.field236, var5);
		}
	}

	@ObfuscatedName("bs")
	@Export("vmethod1019")
	int vmethod1019() {
		int var1 = this.field238 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field233 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("bc")
	int method268(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field231 > 0) {
				int var6 = var2 + this.field231;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field231 += var2;
				if (this.field236 == -256 && (this.field233 & 255) == 0) {
					if (class306.PcmPlayer_stereo) {
						var2 = method281(0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, this.field244, this.field241, 0, var6, var3, this);
					} else {
						var2 = method280(((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, this.field239, 0, var6, var3, this);
					}
				} else if (class306.PcmPlayer_stereo) {
					var2 = method285(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, this.field244, this.field241, 0, var6, var3, this, this.field236, var5);
				} else {
					var2 = method284(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, this.field239, 0, var6, var3, this, this.field236, var5);
				}

				this.field231 -= var2;
				if (this.field231 != 0) {
					return var2;
				}

				if (!this.method269()) {
					continue;
				}

				return var4;
			}

			if (this.field236 == -256 && (this.field233 & 255) == 0) {
				if (class306.PcmPlayer_stereo) {
					return method273(0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, 0, var4, var3, this);
				}

				return method272(((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, 0, var4, var3, this);
			}

			if (class306.PcmPlayer_stereo) {
				return method277(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field234, this.field240, 0, var4, var3, this, this.field236, var5);
			}

			return method276(0, 0, ((RawSound)super.sound).samples, var1, this.field233, var2, this.field238, 0, var4, var3, this, this.field236, var5);
		}
	}

	@ObfuscatedName("bu")
	boolean method269() {
		int var1 = this.field235;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method240(var1, this.field243);
			var3 = method241(var1, this.field243);
		}

		if (var1 == this.field238 && var2 == this.field234 && var3 == this.field240) {
			if (this.field235 == Integer.MIN_VALUE) {
				this.field235 = 0;
				this.field240 = 0;
				this.field234 = 0;
				this.field238 = 0;
				this.remove();
				return true;
			} else {
				this.method245();
				return false;
			}
		} else {
			if (this.field238 < var1) {
				this.field239 = 1;
				this.field231 = var1 - this.field238;
			} else if (this.field238 > var1) {
				this.field239 = -1;
				this.field231 = this.field238 - var1;
			} else {
				this.field239 = 0;
			}

			if (this.field234 < var2) {
				this.field244 = 1;
				if (this.field231 == 0 || this.field231 > var2 - this.field234) {
					this.field231 = var2 - this.field234;
				}
			} else if (this.field234 > var2) {
				this.field244 = -1;
				if (this.field231 == 0 || this.field231 > this.field234 - var2) {
					this.field231 = this.field234 - var2;
				}
			} else {
				this.field244 = 0;
			}

			if (this.field240 < var3) {
				this.field241 = 1;
				if (this.field231 == 0 || this.field231 > var3 - this.field240) {
					this.field231 = var3 - this.field240;
				}
			} else if (this.field240 > var3) {
				this.field241 = -1;
				if (this.field231 == 0 || this.field231 > this.field240 - var3) {
					this.field231 = this.field240 - var3;
				}
			} else {
				this.field241 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("ac")
	static int method240(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("al")
	static int method241(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lbs;II)Lbx;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field179 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lbs;III)Lbx;"
	)
	public static RawPcmStream method244(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbx;)I"
	)
	static int method270(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field233 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbx;)I"
	)
	static int method271(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field233 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbx;)I"
	)
	static int method272(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field233 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbx;)I"
	)
	static int method273(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field233 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbx;II)I"
	)
	static int method274(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field233 = var4;
		return var5;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbx;II)I"
	)
	static int method275(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field233 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbx;II)I"
	)
	static int method276(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field233 = var4;
		return var5;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbx;II)I"
	)
	static int method277(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field233 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbx;)I"
	)
	static int method278(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field234 += var9.field244 * (var6 - var3);
		var9.field240 += var9.field241 * (var6 - var3);

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

		var9.field238 = var4 >> 2;
		var9.field233 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbx;)I"
	)
	static int method279(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field238 += var12.field239 * (var9 - var4);
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

		var12.field234 = var5 >> 2;
		var12.field240 = var6 >> 2;
		var12.field233 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbx;)I"
	)
	static int method280(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field234 += var9.field244 * (var6 - var3);
		var9.field240 += var9.field241 * (var6 - var3);

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

		var9.field238 = var4 >> 2;
		var9.field233 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbx;)I"
	)
	static int method281(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field238 += var12.field239 * (var9 - var4);
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

		var12.field234 = var5 >> 2;
		var12.field240 = var6 >> 2;
		var12.field233 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbx;II)I"
	)
	static int method282(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field234 -= var11.field244 * var5;
		var11.field240 -= var11.field241 * var5;
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

		var11.field234 += var11.field244 * var5;
		var11.field240 += var11.field241 * var5;
		var11.field238 = var6;
		var11.field233 = var4;
		return var5;
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbx;II)I"
	)
	static int method283(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field238 -= var5 * var13.field239;
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
		var13.field238 += var13.field239 * var5;
		var13.field234 = var6;
		var13.field240 = var7;
		var13.field233 = var4;
		return var5;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbx;II)I"
	)
	static int method284(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field234 -= var11.field244 * var5;
		var11.field240 -= var11.field241 * var5;
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

		var11.field234 += var11.field244 * var5;
		var11.field240 += var11.field241 * var5;
		var11.field238 = var6;
		var11.field233 = var4;
		return var5;
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbx;II)I"
	)
	static int method285(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field238 -= var5 * var13.field239;
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
		var13.field238 += var13.field239 * var5;
		var13.field234 = var6;
		var13.field240 = var7;
		var13.field233 = var4;
		return var5;
	}
}