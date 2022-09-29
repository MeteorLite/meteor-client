import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
	@ObfuscatedName("c")
	int field345;
	@ObfuscatedName("p")
	int field349;
	@ObfuscatedName("f")
	int field346;
	@ObfuscatedName("n")
	int field347;
	@ObfuscatedName("k")
	int field348;
	@ObfuscatedName("s")
	int field356;
	@ObfuscatedName("q")
	int field350;
	@ObfuscatedName("m")
	@Export("numLoops")
	int numLoops;
	@ObfuscatedName("x")
	@Export("start")
	int start;
	@ObfuscatedName("j")
	@Export("end")
	int end;
	@ObfuscatedName("v")
	boolean field354;
	@ObfuscatedName("h")
	int field357;
	@ObfuscatedName("t")
	int field352;
	@ObfuscatedName("u")
	int field355;
	@ObfuscatedName("d")
	int field358;

	@ObfuscatedSignature(
		descriptor = "(Lab;III)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3, int var4) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field354 = var1.field273;
		this.field349 = var2;
		this.field346 = var3;
		this.field347 = var4;
		this.field345 = 0;
		this.method926();
	}

	@ObfuscatedSignature(
		descriptor = "(Lab;II)V"
	)
	RawPcmStream(RawSound var1, int var2, int var3) {
		super.sound = var1;
		this.start = var1.start;
		this.end = var1.end;
		this.field354 = var1.field273;
		this.field349 = var2;
		this.field346 = var3;
		this.field347 = 8192;
		this.field345 = 0;
		this.method926();
	}

	@ObfuscatedName("k")
	void method926() {
		this.field348 = this.field346;
		this.field356 = method865(this.field346, this.field347);
		this.field350 = method848(this.field346, this.field347);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected PcmStream firstSubStream() {
		return null;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("q")
	protected int vmethod5612() {
		return this.field346 == 0 && this.field357 == 0 ? 0 : 1;
	}

	@ObfuscatedName("m")
	@Export("fill")
	public synchronized void fill(int[] var1, int var2, int var3) {
		if (this.field346 == 0 && this.field357 == 0) {
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
			if (this.field345 < 0) {
				if (this.field349 <= 0) {
					this.method920();
					this.remove();
					return;
				}

				this.field345 = 0;
			}

			if (this.field345 >= var7) {
				if (this.field349 >= 0) {
					this.method920();
					this.remove();
					return;
				}

				this.field345 = var7 - 1;
			}

			if (this.numLoops < 0) {
				if (this.field354) {
					if (this.field349 < 0) {
						var9 = this.method875(var1, var2, var5, var3, var4.samples[this.start]);
						if (this.field345 >= var5) {
							return;
						}

						this.field345 = var5 + var5 - 1 - this.field345;
						this.field349 = -this.field349;
					}

					while (true) {
						var9 = this.method971(var1, var9, var6, var3, var4.samples[this.end - 1]);
						if (this.field345 < var6) {
							return;
						}

						this.field345 = var6 + var6 - 1 - this.field345;
						this.field349 = -this.field349;
						var9 = this.method875(var1, var9, var5, var3, var4.samples[this.start]);
						if (this.field345 >= var5) {
							return;
						}

						this.field345 = var5 + var5 - 1 - this.field345;
						this.field349 = -this.field349;
					}
				} else if (this.field349 < 0) {
					while (true) {
						var9 = this.method875(var1, var9, var5, var3, var4.samples[this.end - 1]);
						if (this.field345 >= var5) {
							return;
						}

						this.field345 = var6 - 1 - (var6 - 1 - this.field345) % var8;
					}
				} else {
					while (true) {
						var9 = this.method971(var1, var9, var6, var3, var4.samples[this.start]);
						if (this.field345 < var6) {
							return;
						}

						this.field345 = var5 + (this.field345 - var5) % var8;
					}
				}
			} else {
				if (this.numLoops > 0) {
					if (this.field354) {
						label127: {
							if (this.field349 < 0) {
								var9 = this.method875(var1, var2, var5, var3, var4.samples[this.start]);
								if (this.field345 >= var5) {
									return;
								}

								this.field345 = var5 + var5 - 1 - this.field345;
								this.field349 = -this.field349;
								if (--this.numLoops == 0) {
									break label127;
								}
							}

							do {
								var9 = this.method971(var1, var9, var6, var3, var4.samples[this.end - 1]);
								if (this.field345 < var6) {
									return;
								}

								this.field345 = var6 + var6 - 1 - this.field345;
								this.field349 = -this.field349;
								if (--this.numLoops == 0) {
									break;
								}

								var9 = this.method875(var1, var9, var5, var3, var4.samples[this.start]);
								if (this.field345 >= var5) {
									return;
								}

								this.field345 = var5 + var5 - 1 - this.field345;
								this.field349 = -this.field349;
							} while(--this.numLoops != 0);
						}
					} else {
						int var10;
						if (this.field349 < 0) {
							while (true) {
								var9 = this.method875(var1, var9, var5, var3, var4.samples[this.end - 1]);
								if (this.field345 >= var5) {
									return;
								}

								var10 = (var6 - 1 - this.field345) / var8;
								if (var10 >= this.numLoops) {
									this.field345 += var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field345 += var8 * var10;
								this.numLoops -= var10;
							}
						} else {
							while (true) {
								var9 = this.method971(var1, var9, var6, var3, var4.samples[this.start]);
								if (this.field345 < var6) {
									return;
								}

								var10 = (this.field345 - var5) / var8;
								if (var10 >= this.numLoops) {
									this.field345 -= var8 * this.numLoops;
									this.numLoops = 0;
									break;
								}

								this.field345 -= var8 * var10;
								this.numLoops -= var10;
							}
						}
					}
				}

				if (this.field349 < 0) {
					this.method875(var1, var9, 0, var3, 0);
					if (this.field345 < 0) {
						this.field345 = -1;
						this.method920();
						this.remove();
					}
				} else {
					this.method971(var1, var9, var7, var3, 0);
					if (this.field345 >= var7) {
						this.field345 = var7;
						this.method920();
						this.remove();
					}
				}

			}
		}
	}

	@ObfuscatedName("x")
	@Export("setNumLoops")
	public synchronized void setNumLoops(int var1) {
		this.numLoops = var1;
	}

	@ObfuscatedName("j")
	@Export("skip")
	public synchronized void skip(int var1) {
		if (this.field357 > 0) {
			if (var1 >= this.field357) {
				if (this.field346 == Integer.MIN_VALUE) {
					this.field346 = 0;
					this.field350 = 0;
					this.field356 = 0;
					this.field348 = 0;
					this.remove();
					var1 = this.field357;
				}

				this.field357 = 0;
				this.method926();
			} else {
				this.field348 += this.field352 * var1;
				this.field356 += this.field355 * var1;
				this.field350 += this.field358 * var1;
				this.field357 -= var1;
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

		if (this.field345 < 0) {
			if (this.field349 <= 0) {
				this.method920();
				this.remove();
				return;
			}

			this.field345 = 0;
		}

		if (this.field345 >= var5) {
			if (this.field349 >= 0) {
				this.method920();
				this.remove();
				return;
			}

			this.field345 = var5 - 1;
		}

		this.field345 += this.field349 * var1;
		if (this.numLoops < 0) {
			if (!this.field354) {
				if (this.field349 < 0) {
					if (this.field345 >= var3) {
						return;
					}

					this.field345 = var4 - 1 - (var4 - 1 - this.field345) % var6;
				} else {
					if (this.field345 < var4) {
						return;
					}

					this.field345 = var3 + (this.field345 - var3) % var6;
				}

			} else {
				if (this.field349 < 0) {
					if (this.field345 >= var3) {
						return;
					}

					this.field345 = var3 + var3 - 1 - this.field345;
					this.field349 = -this.field349;
				}

				while (this.field345 >= var4) {
					this.field345 = var4 + var4 - 1 - this.field345;
					this.field349 = -this.field349;
					if (this.field345 >= var3) {
						return;
					}

					this.field345 = var3 + var3 - 1 - this.field345;
					this.field349 = -this.field349;
				}

			}
		} else {
			if (this.numLoops > 0) {
				if (this.field354) {
					label129: {
						if (this.field349 < 0) {
							if (this.field345 >= var3) {
								return;
							}

							this.field345 = var3 + var3 - 1 - this.field345;
							this.field349 = -this.field349;
							if (--this.numLoops == 0) {
								break label129;
							}
						}

						do {
							if (this.field345 < var4) {
								return;
							}

							this.field345 = var4 + var4 - 1 - this.field345;
							this.field349 = -this.field349;
							if (--this.numLoops == 0) {
								break;
							}

							if (this.field345 >= var3) {
								return;
							}

							this.field345 = var3 + var3 - 1 - this.field345;
							this.field349 = -this.field349;
						} while(--this.numLoops != 0);
					}
				} else {
					label161: {
						int var7;
						if (this.field349 < 0) {
							if (this.field345 >= var3) {
								return;
							}

							var7 = (var4 - 1 - this.field345) / var6;
							if (var7 >= this.numLoops) {
								this.field345 += var6 * this.numLoops;
								this.numLoops = 0;
								break label161;
							}

							this.field345 += var6 * var7;
							this.numLoops -= var7;
						} else {
							if (this.field345 < var4) {
								return;
							}

							var7 = (this.field345 - var3) / var6;
							if (var7 >= this.numLoops) {
								this.field345 -= var6 * this.numLoops;
								this.numLoops = 0;
								break label161;
							}

							this.field345 -= var6 * var7;
							this.numLoops -= var7;
						}

						return;
					}
				}
			}

			if (this.field349 < 0) {
				if (this.field345 < 0) {
					this.field345 = -1;
					this.method920();
					this.remove();
				}
			} else if (this.field345 >= var5) {
				this.field345 = var5;
				this.method920();
				this.remove();
			}

		}
	}

	@ObfuscatedName("v")
	public synchronized void method854(int var1) {
		this.method856(var1 << 6, this.method907());
	}

	@ObfuscatedName("h")
	synchronized void method855(int var1) {
		this.method856(var1, this.method907());
	}

	@ObfuscatedName("t")
	synchronized void method856(int var1, int var2) {
		this.field346 = var1;
		this.field347 = var2;
		this.field357 = 0;
		this.method926();
	}

	@ObfuscatedName("u")
	public synchronized int method887() {
		return this.field346 == Integer.MIN_VALUE ? 0 : this.field346;
	}

	@ObfuscatedName("d")
	public synchronized int method907() {
		return this.field347 < 0 ? -1 : this.field347;
	}

	@ObfuscatedName("b")
	public synchronized void method859(int var1) {
		int var2 = ((RawSound)super.sound).samples.length << 8;
		if (var1 < -1) {
			var1 = -1;
		}

		if (var1 > var2) {
			var1 = var2;
		}

		this.field345 = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Z)V",
		garbageValue = "1"
	)
	public synchronized void method857() {
		this.field349 = (this.field349 ^ this.field349 >> 31) + (this.field349 >>> 31);
		this.field349 = -this.field349;
	}

	@ObfuscatedName("l")
	void method920() {
		if (this.field357 != 0) {
			if (this.field346 == Integer.MIN_VALUE) {
				this.field346 = 0;
			}

			this.field357 = 0;
			this.method926();
		}

	}

	@ObfuscatedName("e")
	public synchronized void method922(int var1, int var2) {
		this.method863(var1, var2, this.method907());
	}

	@ObfuscatedName("g")
	public synchronized void method863(int var1, int var2, int var3) {
		if (var1 == 0) {
			this.method856(var2, var3);
		} else {
			int var4 = method865(var2, var3);
			int var5 = method848(var2, var3);
			if (var4 == this.field356 && var5 == this.field350) {
				this.field357 = 0;
			} else {
				int var6 = var2 - this.field348;
				if (this.field348 - var2 > var6) {
					var6 = this.field348 - var2;
				}

				if (var4 - this.field356 > var6) {
					var6 = var4 - this.field356;
				}

				if (this.field356 - var4 > var6) {
					var6 = this.field356 - var4;
				}

				if (var5 - this.field350 > var6) {
					var6 = var5 - this.field350;
				}

				if (this.field350 - var5 > var6) {
					var6 = this.field350 - var5;
				}

				if (var1 > var6) {
					var1 = var6;
				}

				this.field357 = var1;
				this.field346 = var2;
				this.field347 = var3;
				this.field352 = (var2 - this.field348) / var1;
				this.field355 = (var4 - this.field356) / var1;
				this.field358 = (var5 - this.field350) / var1;
			}
		}
	}

	@ObfuscatedName("y")
	public synchronized void method864(int var1) {
		if (var1 == 0) {
			this.method855(0);
			this.remove();
		} else if (this.field356 == 0 && this.field350 == 0) {
			this.field357 = 0;
			this.field346 = 0;
			this.field348 = 0;
			this.remove();
		} else {
			int var2 = -this.field348;
			if (this.field348 > var2) {
				var2 = this.field348;
			}

			if (-this.field356 > var2) {
				var2 = -this.field356;
			}

			if (this.field356 > var2) {
				var2 = this.field356;
			}

			if (-this.field350 > var2) {
				var2 = -this.field350;
			}

			if (this.field350 > var2) {
				var2 = this.field350;
			}

			if (var1 > var2) {
				var1 = var2;
			}

			this.field357 = var1;
			this.field346 = Integer.MIN_VALUE;
			this.field352 = -this.field348 / var1;
			this.field355 = -this.field356 / var1;
			this.field358 = -this.field350 / var1;
		}
	}

	@ObfuscatedName("i")
	public synchronized void method903(int var1) {
		if (this.field349 < 0) {
			this.field349 = -var1;
		} else {
			this.field349 = var1;
		}

	}

	@ObfuscatedName("r")
	public synchronized int method866() {
		return this.field349 < 0 ? -this.field349 : this.field349;
	}

	@ObfuscatedName("aa")
	public boolean method867() {
		return this.field345 < 0 || this.field345 >= ((RawSound)super.sound).samples.length << 8;
	}

	@ObfuscatedName("ak")
	public boolean method892() {
		return this.field357 != 0;
	}

	@ObfuscatedName("am")
	int method971(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field357 > 0) {
				int var6 = var2 + this.field357;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field357 += var2;
				if (this.field349 == 256 && (this.field345 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method886(0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, this.field355, this.field358, 0, var6, var3, this);
					} else {
						var2 = method885(((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, this.field352, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method890(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, this.field355, this.field358, 0, var6, var3, this, this.field349, var5);
				} else {
					var2 = method874(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, this.field352, 0, var6, var3, this, this.field349, var5);
				}

				this.field357 -= var2;
				if (this.field357 != 0) {
					return var2;
				}

				if (!this.method876()) {
					continue;
				}

				return var4;
			}

			if (this.field349 == 256 && (this.field345 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method877(0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, 0, var4, var3, this);
				}

				return method870(((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method957(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, 0, var4, var3, this, this.field349, var5);
			}

			return method862(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, 0, var4, var3, this, this.field349, var5);
		}
	}

	@ObfuscatedName("ap")
	int method875(int[] var1, int var2, int var3, int var4, int var5) {
		while (true) {
			if (this.field357 > 0) {
				int var6 = var2 + this.field357;
				if (var6 > var4) {
					var6 = var4;
				}

				this.field357 += var2;
				if (this.field349 == -256 && (this.field345 & 255) == 0) {
					if (PcmPlayer.PcmPlayer_stereo) {
						var2 = method888(0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, this.field355, this.field358, 0, var6, var3, this);
					} else {
						var2 = method860(((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, this.field352, 0, var6, var3, this);
					}
				} else if (PcmPlayer.PcmPlayer_stereo) {
					var2 = method869(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, this.field355, this.field358, 0, var6, var3, this, this.field349, var5);
				} else {
					var2 = method891(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, this.field352, 0, var6, var3, this, this.field349, var5);
				}

				this.field357 -= var2;
				if (this.field357 != 0) {
					return var2;
				}

				if (!this.method876()) {
					continue;
				}

				return var4;
			}

			if (this.field349 == -256 && (this.field345 & 255) == 0) {
				if (PcmPlayer.PcmPlayer_stereo) {
					return method880(0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, 0, var4, var3, this);
				}

				return method879(((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, 0, var4, var3, this);
			}

			if (PcmPlayer.PcmPlayer_stereo) {
				return method884(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field356, this.field350, 0, var4, var3, this, this.field349, var5);
			}

			return method883(0, 0, ((RawSound)super.sound).samples, var1, this.field345, var2, this.field348, 0, var4, var3, this, this.field349, var5);
		}
	}

	@ObfuscatedName("az")
	boolean method876() {
		int var1 = this.field346;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var3 = 0;
			var2 = 0;
			var1 = 0;
		} else {
			var2 = method865(var1, this.field347);
			var3 = method848(var1, this.field347);
		}

		if (var1 == this.field348 && var2 == this.field356 && var3 == this.field350) {
			if (this.field346 == Integer.MIN_VALUE) {
				this.field346 = 0;
				this.field350 = 0;
				this.field356 = 0;
				this.field348 = 0;
				this.remove();
				return true;
			} else {
				this.method926();
				return false;
			}
		} else {
			if (this.field348 < var1) {
				this.field352 = 1;
				this.field357 = var1 - this.field348;
			} else if (this.field348 > var1) {
				this.field352 = -1;
				this.field357 = this.field348 - var1;
			} else {
				this.field352 = 0;
			}

			if (this.field356 < var2) {
				this.field355 = 1;
				if (this.field357 == 0 || this.field357 > var2 - this.field356) {
					this.field357 = var2 - this.field356;
				}
			} else if (this.field356 > var2) {
				this.field355 = -1;
				if (this.field357 == 0 || this.field357 > this.field356 - var2) {
					this.field357 = this.field356 - var2;
				}
			} else {
				this.field355 = 0;
			}

			if (this.field350 < var3) {
				this.field358 = 1;
				if (this.field357 == 0 || this.field357 > var3 - this.field350) {
					this.field357 = var3 - this.field350;
				}
			} else if (this.field350 > var3) {
				this.field358 = -1;
				if (this.field357 == 0 || this.field357 > this.field350 - var3) {
					this.field357 = this.field350 - var3;
				}
			} else {
				this.field358 = 0;
			}

			return false;
		}
	}

	@ObfuscatedName("af")
	int vmethod1015() {
		int var1 = this.field348 * 3 >> 6;
		var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
		if (this.numLoops == 0) {
			var1 -= var1 * this.field345 / (((RawSound)super.sound).samples.length << 8);
		} else if (this.numLoops >= 0) {
			var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
		}

		return var1 > 255 ? 255 : var1;
	}

	@ObfuscatedName("c")
	static int method865(int var0, int var1) {
		return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("p")
	static int method848(int var0, int var1) {
		return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lab;II)Lae;"
	)
	@Export("createRawPcmStream")
	public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field307 * 100)), var2 << 6) : null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lab;III)Lae;"
	)
	public static RawPcmStream method851(RawSound var0, int var1, int var2, int var3) {
		return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILae;)I"
	)
	static int method870(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field345 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILae;)I"
	)
	static int method877(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field345 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIILae;)I"
	)
	static int method879(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

		var8.field345 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIILae;)I"
	)
	static int method880(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

		var10.field345 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILae;II)I"
	)
	static int method862(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field345 = var4;
		return var5;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILae;II)I"
	)
	static int method957(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field345 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIILae;II)I"
	)
	static int method883(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

		var10.field345 = var4;
		return var5;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILae;II)I"
	)
	static int method884(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

		var11.field345 = var4;
		return var5 >> 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILae;)I"
	)
	static int method885(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var8 - var2) > var7) {
			var6 = var7;
		}

		var9.field356 += var9.field355 * (var6 - var3);
		var9.field350 += var9.field358 * (var6 - var3);

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

		var9.field348 = var4 >> 2;
		var9.field345 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILae;)I"
	)
	static int method886(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var11 + var4 - var3) > var10) {
			var9 = var10;
		}

		var12.field348 += var12.field352 * (var9 - var4);
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

		var12.field356 = var5 >> 2;
		var12.field350 = var6 >> 2;
		var12.field345 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "([B[IIIIIIIILae;)I"
	)
	static int method860(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
		var2 >>= 8;
		var8 >>= 8;
		var4 <<= 2;
		var5 <<= 2;
		if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
			var6 = var7;
		}

		var9.field356 += var9.field355 * (var6 - var3);
		var9.field350 += var9.field358 * (var6 - var3);

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

		var9.field348 = var4 >> 2;
		var9.field345 = var2 << 8;
		return var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I[B[IIIIIIIIIILae;)I"
	)
	static int method888(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
		var3 >>= 8;
		var11 >>= 8;
		var5 <<= 2;
		var6 <<= 2;
		var7 <<= 2;
		var8 <<= 2;
		if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
			var9 = var10;
		}

		var12.field348 += var12.field352 * (var9 - var4);
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

		var12.field356 = var5 >> 2;
		var12.field350 = var6 >> 2;
		var12.field345 = var3 << 8;
		return var4 >> 1;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILae;II)I"
	)
	static int method874(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field356 -= var11.field355 * var5;
		var11.field350 -= var11.field358 * var5;
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

		var11.field356 += var11.field355 * var5;
		var11.field350 += var11.field358 * var5;
		var11.field348 = var6;
		var11.field345 = var4;
		return var5;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILae;II)I"
	)
	static int method890(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field348 -= var5 * var13.field352;
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
		var13.field348 += var13.field352 * var5;
		var13.field356 = var6;
		var13.field350 = var7;
		var13.field345 = var4;
		return var5;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIILae;II)I"
	)
	static int method891(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
		var11.field356 -= var11.field355 * var5;
		var11.field350 -= var11.field358 * var5;
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

		var11.field356 += var11.field355 * var5;
		var11.field350 += var11.field358 * var5;
		var11.field348 = var6;
		var11.field345 = var4;
		return var5;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(II[B[IIIIIIIIIILae;II)I"
	)
	static int method869(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
		var13.field348 -= var5 * var13.field352;
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
		var13.field348 += var13.field352 * var5;
		var13.field356 = var6;
		var13.field350 = var7;
		var13.field345 = var4;
		return var5;
	}
}
