import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("aw")
	int field242;
	@ObfuscatedName("ay")
	int field244;
	@ObfuscatedName("ar")
	int field238;
	@ObfuscatedName("am")
	int field236;
	@ObfuscatedName("as")
	int field239;
	@ObfuscatedName("aj")
	int field235;
	@ObfuscatedName("ag")
	int field233;
	@ObfuscatedName("az")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("av")
	@Export("start")
	int start;
	@ObfuscatedName("ap")
	@Export("end")
	int end;
	@ObfuscatedName("aq")
	boolean field231;
	@ObfuscatedName("at")
	int field240;
	@ObfuscatedName("ah")
	int field234;
	@ObfuscatedName("ax")
	int field243;
	@ObfuscatedName("aa")
	int field232;

	@ObfuscatedSignature(
		descriptor = "(Lbi;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field231 = var1.field168;
		this.field244 = var2;
		this.field238 = var3;
		this.field236 = var4;
		this.field242 = 0;
		this.method241();
	}

	@ObfuscatedSignature(
		descriptor = "(Lbi;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field231 = var1.field168;
		this.field244 = var2;
		this.field238 = var3;
		this.field236 = 8192;
		this.field242 = 0;
		this.method241();
	}

	@ObfuscatedName("as")
	void method241() {
		this.field239 = this.field238;
		this.field235 = method236(this.field238, this.field236);
		this.field233 = method237(this.field238, this.field236);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("az")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return this.field238 == 0 && this.field240 == 0 ? 0 : 1;
	}

	@ObfuscatedName("av")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field238 == 0 && this.field240 == 0) {
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
			if (this.field242 < 0) {
				if (this.field244 <= 0) {
					this.method250();
					this.remove();
					return;
				}

				this.field242 = 0;
			}

			if (this.field242 >= var7) {
				if (this.field244 >= 0) {
					this.method250();
					this.remove();
					return;
				}

				this.field242 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field231) {
					if (this.field244 < 0) {
						var9 = this.method264(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field242 >= var5) {
							return;
						}

						this.field242 = var5 + var5 - 1 - this.field242;
						this.field244 = -this.field244;
					}

					while (true) {
						var9 = this.method263(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field242 < var6) {
							return;
						}

						this.field242 = var6 + var6 - 1 - this.field242;
						this.field244 = -this.field244;
						var9 = this.method264(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field242 >= var5) {
							return;
						}

						this.field242 = var5 + var5 - 1 - this.field242;
						this.field244 = -this.field244;
					}
				} else if (this.field244 < 0) {
					while (true) {
						var9 = this.method264(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field242 >= var5) {
							return;
						}

						this.field242 = var6 - 1 - (var6 - 1 - this.field242) % var8;
					}
				} else {
					while (true) {
						var9 = this.method263(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field242 < var6) {
							return;
						}

						this.field242 = var5 + (this.field242 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field231) {
						label133: {
							if (this.field244 < 0) {
								var9 = this.method264(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field242 >= var5) {
									return;
								}

								this.field242 = var5 + var5 - 1 - this.field242;
								this.field244 = -this.field244;
								if (--this.numLoops == 0) {
									break label133;
								}
							}

							do {
								var9 = this.method263(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field242 < var6) {
									return;
								}

								this.field242 = var6 + var6 - 1 - this.field242;
								this.field244 = -this.field244;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method264(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field242 >= var5) {
									return;
								}

								this.field242 = var5 + var5 - 1 - this.field242;
								this.field244 = -this.field244;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field244 < 0) {
							while (true) {
								var9 = this.method264(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field242 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field242) / var8;
								if (var10 >= this.numLoops) {
									this.field242 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field242 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method263(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field242 < var6) {
									return;
								}

								var10 = (this.field242 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field242 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field242 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field244 < 0) {
					this.method264(var1, var9, 0, var3, 0);
					if (this.field242 < 0) {
						this.field242 = -1;
						this.method250();
						this.remove();
					}
				} else {
					this.method263(var1, var9, var7, var3, 0);
					if (this.field242 >= var7) {
						this.field242 = var7;
						this.method250();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("ap")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("aq")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field240 > 0) {
			if (var1 >= this.field240) {
				if (this.field238 == Integer.MIN_VALUE) {
					this.field238 = 0;
					this.field233 = 0;
					this.field235 = 0;
					this.field239 = 0;
					this.remove();
					var1 = this.field240;
				}

				this.field240 = 0;
				this.method241();
			} else {
				this.field239 += this.field234 * var1;
				this.field235 += this.field243 * var1;
				this.field233 += this.field232 * var1;
				this.field240 -= var1;
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

		if (this.field242 < 0) {
			if (this.field244 <= 0) {
				this.method250();
				this.remove();
				return;
			}

			this.field242 = 0;
		}

		if (this.field242 >= var5) {
			if (this.field244 >= 0) {
				this.method250();
				this.remove();
				return;
			}

			this.field242 = var5 - 1;
		}

		this.field242 += this.field244 * var1;
		if (this.numLoops < 0) {
			if (!this.field231) {
				if (this.field244 < 0) {
					if (this.field242 >= var3) {
						return;
					}

					this.field242 = var4 - 1 - (var4 - 1 - this.field242) % var6;
				} else {
					if (this.field242 < var4) {
						return;
					}

					this.field242 = var3 + (this.field242 - var3) % var6;
				}

			} else {
				if (this.field244 < 0) {
					if (this.field242 >= var3) {
						return;
					}

					this.field242 = var3 + var3 - 1 - this.field242;
					this.field244 = -this.field244;
				}

				while (this.field242 >= var4) {
					this.field242 = var4 + var4 - 1 - this.field242;
					this.field244 = -this.field244;
					if (this.field242 >= var3) {
						return;
					}

					this.field242 = var3 + var3 - 1 - this.field242;
					this.field244 = -this.field244;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field231) {
					label121: {
						if (this.field244 < 0) {
							if (this.field242 >= var3) {
								return;
							}

							this.field242 = var3 + var3 - 1 - this.field242;
							this.field244 = -this.field244;
							if (--this.numLoops == 0) {
								break label121;
							}
						}

						do {
							if (this.field242 < var4) {
								return;
							}

							this.field242 = var4 + var4 - 1 - this.field242;
							this.field244 = -this.field244;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field242 >= var3) {
								return;
							}

							this.field242 = var3 + var3 - 1 - this.field242;
							this.field244 = -this.field244;
						} while(--this.numLoops != 0);
					}
				} else {
					label153: {
						int var7;
						if (this.field244 < 0) {
							if (this.field242 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field242) / var6;
							if (var7 >= this.numLoops) {
								this.field242 += var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field242 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field242 < var4) {
								return;
							}

							var7 = (this.field242 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field242 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label153;
							}

							this.field242 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field244 < 0) {
				if (this.field242 < 0) {
					this.field242 = -1;
					this.method250();
					this.remove();
				}
			} else if (this.field242 >= var5) {
				this.field242 = var5;
				this.method250();
				this.remove();
			}

		}
	}

	@ObfuscatedName("at")
	public synchronized void method243(int var1) {
		this.method245(var1 << 6, this.method247());
	}

	@ObfuscatedName("ah")
	synchronized void method244(int var1) {
		this.method245(var1, this.method247());
	}

	@ObfuscatedName("ax")
	synchronized void method245(int var1, int var2) {
		this.field238 = var1;
		this.field236 = var2;
		this.field240 = 0;
		this.method241();
	}

	@ObfuscatedName("aa")
	public synchronized int method246() {
		return this.field238 == Integer.MIN_VALUE ? 0 : this.field238;
	}

	@ObfuscatedName("au")
	public synchronized int method247() {
		return this.field236 < 0 ? -1 : this.field236;
	}

	@ObfuscatedName("ae")
	public synchronized void method248(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field242 = var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method249() {
		this.field244 = (this.field244 ^ this.field244 >> 31) + (this.field244 >>> 31);
		this.field244 = -this.field244;
	}

	@ObfuscatedName("ad")
	void method250() {
		if (this.field240 != 0) {
			if (this.field238 == Integer.MIN_VALUE) {
				this.field238 = 0;
			}

			this.field240 = 0;
			this.method241();
		}

	}

	@ObfuscatedName("ao")
	public synchronized void method251(int var1, int var2) {
		this.method252(var1, var2, this.method247());
	}

	@ObfuscatedName("ac")
	public synchronized void method252(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method245(var2, var3);
		} else {
			int var4 = method236(var2, var3);
			int var5 = method237(var2, var3);
			if (var4 == this.field235 && var5 == this.field233) {
				this.field240 = 0;
			} else {
				int var6 = var2 - this.field239;
				if (this.field239 - var2 > var6) {
					var6 = this.field239 - var2;
				}

				if (var4 - this.field235 > var6) {
					var6 = var4 - this.field235;
				}

				if (this.field235 - var4 > var6) {
					var6 = this.field235 - var4;
				}

				if (var5 - this.field233 > var6) {
					var6 = var5 - this.field233;
				}

				if (this.field233 - var5 > var6) {
					var6 = this.field233 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field240 = var1;
				this.field238 = var2;
				this.field236 = var3;
				this.field234 = (var2 - this.field239) / var1;
				this.field243 = (var4 - this.field235) / var1;
				this.field232 = (var5 - this.field233) / var1;
			}
		}
	}

	@ObfuscatedName("ak")
	public synchronized void method253(int var1) {
		if (var1 == 0) {
			this.method244(0);
			this.remove();
		} else if (this.field235 == 0 && this.field233 == 0) {
			this.field240 = 0;
			this.field238 = 0;
			this.field239 = 0;
			this.remove();
		} else {
			int var2 = -this.field239;
			if (this.field239 > var2) {
				var2 = this.field239;
			}

			if (-this.field235 > var2) {
				var2 = -this.field235;
			}

			if (this.field235 > var2) {
				var2 = this.field235;
			}

			if (-this.field233 > var2) {
				var2 = -this.field233;
			}

			if (this.field233 > var2) {
				var2 = this.field233;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field240 = var1;
			this.field238 = Integer.MIN_VALUE;
			this.field234 = -this.field239 / var1;
			this.field243 = -this.field235 / var1;
			this.field232 = -this.field233 / var1;
		}
	}

	@ObfuscatedName("an")
	public synchronized void method254(int var1) {
		if (this.field244 < 0) {
			this.field244 = -var1;
		} else {
			this.field244 = var1;
		}

	}

	@ObfuscatedName("af")
	public synchronized int method255() {
		return this.field244 < 0 ? -this.field244 : this.field244;
	}

	@ObfuscatedName("ai")
	public boolean method256() {
		return this.field242 < 0 || this.field242 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("al")
	public boolean method257() {
		return this.field240 != 0;
	}

	@ObfuscatedName("bd")
	int method263(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field240 > 0) {
				int var6 = var2 + this.field240;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field240 += var2;
				if (this.field244 == 256 && (this.field242 & 255) == 0) {
					if (class373.PcmPlayer_stereo) {
						var2 = method275(0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, this.field243, this.field232, 0, var6, var3, this);
					} else {
						var2 = method274(((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, this.field234, 0, var6, var3, this);
					}
				} else if (class373.PcmPlayer_stereo) {
					var2 = method279(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, this.field243, this.field232, 0, var6, var3, this, this.field244, var5);
				} else {
					var2 = method278(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, this.field234, 0, var6, var3, this, this.field244, var5);
				}

				this.field240 -= var2;
				if (this.field240 != 0) {
					return var2;
				}

				if (!this.method265()) {
					continue;
				}

				return var4;
			}

			if (this.field244 == 256 && (this.field242 & 255) == 0) {
				if (class373.PcmPlayer_stereo) {
					return method267(0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, 0, var4, var3, this);
				}

				return method266(((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, 0, var4, var3, this);
			}

			if (class373.PcmPlayer_stereo) {
				return method271(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, 0, var4, var3, this, this.field244, var5);
			}

			return method270(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, 0, var4, var3, this, this.field244, var5);
		}
	}

	@ObfuscatedName("bb")
	int method264(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field240 > 0) {
				int var6 = var2 + this.field240;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field240 += var2;
				if (this.field244 == -256 && (this.field242 & 255) == 0) {
					if (class373.PcmPlayer_stereo) {
						var2 = method277(0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, this.field243, this.field232, 0, var6, var3, this);
					} else {
						var2 = method276(((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, this.field234, 0, var6, var3, this);
					}
				} else if (class373.PcmPlayer_stereo) {
					var2 = method281(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, this.field243, this.field232, 0, var6, var3, this, this.field244, var5);
				} else {
					var2 = method280(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, this.field234, 0, var6, var3, this, this.field244, var5);
				}

				this.field240 -= var2;
				if (this.field240 != 0) {
					return var2;
				}

				if (!this.method265()) {
					continue;
				}

				return var4;
			}

			if (this.field244 == -256 && (this.field242 & 255) == 0) {
				if (class373.PcmPlayer_stereo) {
					return method269(0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, 0, var4, var3, this);
				}

				return method268(((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, 0, var4, var3, this);
			}

			if (class373.PcmPlayer_stereo) {
				return method273(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field235, this.field233, 0, var4, var3, this, this.field244, var5);
			}

			return method272(0, 0, ((RawSound)super.sound).samples, var1, this.field242, var2, this.field239, 0, var4, var3, this, this.field244, var5);
		}
	}

	@ObfuscatedName("bc")
	boolean method265() {
		int var1 = this.field238;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method236(var1, this.field236);
			var3 = method237(var1, this.field236);
		}

		if (var1 == this.field239 && var2 == this.field235 && var3 == this.field233) {
			if (this.field238 == Integer.MIN_VALUE) {
				this.field238 = 0;
				this.field233 = 0;
				this.field235 = 0;
				this.field239 = 0;
				this.remove();
				return true;
			} else {
				this.method241();
				return false;
			}
		} else {
			if (this.field239 < var1) {
				this.field234 = 1;
				this.field240 = var1 - this.field239;
			} else if (this.field239 > var1) {
				this.field234 = -1;
				this.field240 = this.field239 - var1;
			} else {
				this.field234 = 0;
			}

			if (this.field235 < var2) {
				this.field243 = 1;
				if (this.field240 == 0 || this.field240 > var2 - this.field235) {
					this.field240 = var2 - this.field235;
				}
			} else if (this.field235 > var2) {
				this.field243 = -1;
				if (this.field240 == 0 || this.field240 > this.field235 - var2) {
					this.field240 = this.field235 - var2;
				}
			} else {
				this.field243 = 0;
			}

			if (this.field233 < var3) {
				this.field232 = 1;
				if (this.field240 == 0 || this.field240 > var3 - this.field233) {
					this.field240 = var3 - this.field233;
				}
			} else if (this.field233 > var3) {
				this.field232 = -1;
				if (this.field240 == 0 || this.field240 > this.field233 - var3) {
					this.field240 = this.field233 - var3;
				}
			} else {
				this.field232 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("by")
	@Export("vmethod1019")
	int vmethod1019() {
		int var1 = this.field239 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field242 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("aw")
	static int method236(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ay")
	static int method237(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lbi;II)Lbt;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field181 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lbi;III)Lbt;"
	)
	public static RawPcmStream method240(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbt;)I"
	)
	static int method266(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field242 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbt;)I"
	)
	static int method267(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field242 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILbt;)I"
	)
	static int method268(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field242 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILbt;)I"
	)
	static int method269(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field242 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbt;II)I"
	)
	static int method270(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field242 = var4;
		return var5;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbt;II)I"
	)
	static int method271(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field242 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILbt;II)I"
	)
	static int method272(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field242 = var4;
		return var5;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbt;II)I"
	)
	static int method273(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field242 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbt;)I"
	)
	static int method274(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field235 += var9.field243 * (var6 - var3);
		var9.field233 += var9.field232 * (var6 - var3);

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

		var9.field239 = var4 >> 2;
		var9.field242 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbt;)I"
	)
	static int method275(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field239 += var12.field234 * (var9 - var4);
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

		var12.field235 = var5 >> 2;
		var12.field233 = var6 >> 2;
		var12.field242 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILbt;)I"
	)
	static int method276(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field235 += var9.field243 * (var6 - var3);
		var9.field233 += var9.field232 * (var6 - var3);

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

		var9.field239 = var4 >> 2;
		var9.field242 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILbt;)I"
	)
	static int method277(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field239 += var12.field234 * (var9 - var4);
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

		var12.field235 = var5 >> 2;
		var12.field233 = var6 >> 2;
		var12.field242 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbt;II)I"
	)
	static int method278(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field235 -= var11.field243 * var5;
		var11.field233 -= var11.field232 * var5;
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

		var11.field235 += var11.field243 * var5;
		var11.field233 += var11.field232 * var5;
		var11.field239 = var6;
		var11.field242 = var4;
		return var5;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbt;II)I"
	)
	static int method279(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field239 -= var5 * var13.field234;
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
		var13.field239 += var13.field234 * var5;
		var13.field235 = var6;
		var13.field233 = var7;
		var13.field242 = var4;
		return var5;
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILbt;II)I"
	)
	static int method280(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field235 -= var11.field243 * var5;
		var11.field233 -= var11.field232 * var5;
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

		var11.field235 += var11.field243 * var5;
		var11.field233 += var11.field232 * var5;
		var11.field239 = var6;
		var11.field242 = var4;
		return var5;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILbt;II)I"
	)
	static int method281(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field239 -= var5 * var13.field234;
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
		var13.field239 += var13.field234 * var5;
		var13.field235 = var6;
		var13.field233 = var7;
		var13.field242 = var4;
		return var5;
	}
}
