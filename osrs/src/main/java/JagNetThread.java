import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("oz")
@Implements("JagNetThread")
public class JagNetThread {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lro;"
	)
	AbstractSocket field3597;
	@ObfuscatedName("ah")
	int field3587;
	@ObfuscatedName("ar")
	long field3593;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	NodeHashTable field3599;
	@ObfuscatedName("ab")
	int field3585;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	NodeHashTable field3601;
	@ObfuscatedName("aa")
	int field3584;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	DualNodeDeque field3594;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	NodeHashTable field3598;
	@ObfuscatedName("az")
	int field3591;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	NodeHashTable field3600;
	@ObfuscatedName("av")
	int field3590;
	@ObfuscatedName("ax")
	boolean field3582;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Loy;"
	)
	class369 field3596;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	Buffer field3604;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	Buffer field3603;
	@ObfuscatedName("aj")
	int field3588;
	@ObfuscatedName("aq")
	CRC32 field3592;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	Buffer field3602;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "[Loh;"
	)
	Archive[] field3595;
	@ObfuscatedName("ae")
	int field3586;
	@ObfuscatedName("an")
	int field3589;
	@ObfuscatedName("ag")
	byte field3583;
	@ObfuscatedName("ad")
	public int field3605;
	@ObfuscatedName("af")
	public int field3606;

	public JagNetThread() {
		this.field3587 = 0;
		this.field3599 = new NodeHashTable(4096);
		this.field3585 = 0;
		this.field3601 = new NodeHashTable(32);
		this.field3584 = 0;
		this.field3594 = new DualNodeDeque();
		this.field3598 = new NodeHashTable(4096);
		this.field3591 = 0;
		this.field3600 = new NodeHashTable(4096);
		this.field3590 = 0;
		this.field3604 = new Buffer(8);
		this.field3588 = 0;
		this.field3592 = new CRC32();
		this.field3595 = new Archive[256];
		this.field3586 = -1;
		this.field3589 = 255;
		this.field3583 = 0;
		this.field3605 = 0;
		this.field3606 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-63"
	)
	public boolean method1953() {
		long var1 = SpotAnimationDefinition.method962();
		int var3 = (int)(var1 - this.field3593);
		this.field3593 = var1;
		if (var3 > 200) {
			var3 = 200;
		}

		this.field3587 += var3;
		if (this.field3590 == 0 && this.field3584 == 0 && this.field3591 == 0 && this.field3585 == 0) {
			return true;
		} else if (this.field3597 == null) {
			return false;
		} else {
			try {
				if (this.field3587 > 30000) {
					throw new IOException();
				} else {
					class369 var4;
					Buffer var5;
					while (this.field3584 < 200 && this.field3585 > 0) {
						var4 = (class369)this.field3599.first();
						var5 = new Buffer(4);
						var5.writeByte(1);
						var5.writeMedium((int)var4.key);
						this.field3597.write(var5.array, 0, 4);
						this.field3601.put(var4, var4.key);
						--this.field3585;
						++this.field3584;
					}

					while (this.field3590 < 200 && this.field3591 > 0) {
						var4 = (class369)this.field3594.removeLast();
						var5 = new Buffer(4);
						var5.writeByte(0);
						var5.writeMedium((int)var4.key);
						this.field3597.write(var5.array, 0, 4);
						var4.removeDual();
						this.field3600.put(var4, var4.key);
						--this.field3591;
						++this.field3590;
					}

					for (int var16 = 0; var16 < 100; ++var16) {
						int var17 = this.field3597.available();
						if (var17 < 0) {
							throw new IOException();
						}

						if (var17 == 0) {
							break;
						}

						this.field3587 = 0;
						byte var6 = 0;
						if (this.field3596 == null) {
							var6 = 8;
						} else if (this.field3588 == 0) {
							var6 = 1;
						}

						int var7;
						int var8;
						int var9;
						byte[] var10000;
						int var10001;
						Buffer var22;
						if (var6 > 0) {
							var7 = var6 - this.field3604.offset;
							if (var7 > var17) {
								var7 = var17;
							}

							this.field3597.read(this.field3604.array, this.field3604.offset, var7);
							if (this.field3583 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = this.field3604.array;
									var10001 = var8 + this.field3604.offset;
									var10000[var10001] ^= this.field3583;
								}
							}

							var22 = this.field3604;
							var22.offset += var7;
							if (this.field3604.offset < var6) {
								break;
							}

							if (this.field3596 == null) {
								this.field3604.offset = 0;
								var8 = this.field3604.readUnsignedByte();
								var9 = this.field3604.readUnsignedShort();
								int var10 = this.field3604.readUnsignedByte();
								int var11 = this.field3604.readInt();
								long var12 = (long)(var9 + (var8 << 16));
								class369 var14 = (class369)this.field3601.get(var12);
								this.field3582 = true;
								if (var14 == null) {
									var14 = (class369)this.field3600.get(var12);
									this.field3582 = false;
								}

								if (var14 == null) {
									throw new IOException();
								}

								int var15 = var10 == 0 ? 5 : 9;
								this.field3596 = var14;
								this.field3603 = new Buffer(this.field3596.field3562 + var11 + var15);
								this.field3603.writeByte(var10);
								this.field3603.writeInt(var11);
								this.field3588 = 8;
								this.field3604.offset = 0;
							} else if (this.field3588 == 0) {
								if (this.field3604.array[0] == -1) {
									this.field3588 = 1;
									this.field3604.offset = 0;
								} else {
									this.field3596 = null;
								}
							}
						} else {
							var7 = this.field3603.array.length - this.field3596.field3562;
							var8 = 512 - this.field3588;
							if (var8 > var7 - this.field3603.offset) {
								var8 = var7 - this.field3603.offset;
							}

							if (var8 > var17) {
								var8 = var17;
							}

							this.field3597.read(this.field3603.array, this.field3603.offset, var8);
							if (this.field3583 != 0) {
								for (var9 = 0; var9 < var8; ++var9) {
									var10000 = this.field3603.array;
									var10001 = this.field3603.offset + var9;
									var10000[var10001] ^= this.field3583;
								}
							}

							var22 = this.field3603;
							var22.offset += var8;
							this.field3588 += var8;
							if (this.field3603.offset == var7) {
								if (this.field3596.key == 16711935L) {
									this.field3602 = this.field3603;

									for (var9 = 0; var9 < 256; ++var9) {
										Archive var18 = this.field3595[var9];
										if (var18 != null) {
											this.method1957(var18, var9);
										}
									}
								} else {
									this.field3592.reset();
									this.field3592.update(this.field3603.array, 0, var7);
									var9 = (int)this.field3592.getValue();
									if (this.field3596.field3563 != var9) {
										try {
											this.field3597.close();
										} catch (Exception var20) {
										}

										++this.field3605;
										this.field3597 = null;
										this.field3583 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									this.field3605 = 0;
									this.field3606 = 0;
									this.field3596.field3564.write((int)(this.field3596.key & 65535L), this.field3603.array, (this.field3596.key & 16711680L) == 16711680L, this.field3582);
								}

								this.field3596.remove();
								if (this.field3582) {
									--this.field3584;
								} else {
									--this.field3590;
								}

								this.field3588 = 0;
								this.field3596 = null;
								this.field3603 = null;
							} else {
								if (this.field3588 != 512) {
									break;
								}

								this.field3588 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var21) {
				try {
					this.field3597.close();
				} catch (Exception var19) {
				}

				++this.field3606;
				this.field3597 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-438812293"
	)
	public void method1954(boolean var1) {
		if (this.field3597 != null) {
			try {
				Buffer var2 = new Buffer(4);
				var2.writeByte(var1 ? 2 : 3);
				var2.writeMedium(0);
				this.field3597.write(var2.array, 0, 4);
			} catch (IOException var5) {
				try {
					this.field3597.close();
				} catch (Exception var4) {
				}

				++this.field3606;
				this.field3597 = null;
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lro;ZI)V",
		garbageValue = "1047063145"
	)
	public void method1955(AbstractSocket var1, boolean var2) {
		if (this.field3597 != null) {
			try {
				this.field3597.close();
			} catch (Exception var7) {
			}

			this.field3597 = null;
		}

		this.field3597 = var1;
		this.method1954(var2);
		this.field3604.offset = 0;
		this.field3596 = null;
		this.field3603 = null;
		this.field3588 = 0;

		while (true) {
			class369 var3 = (class369)this.field3601.first();
			if (var3 == null) {
				while (true) {
					var3 = (class369)this.field3600.first();
					if (var3 == null) {
						if (this.field3583 != 0) {
							try {
								Buffer var8 = new Buffer(4);
								var8.writeByte(4);
								var8.writeByte(this.field3583);
								var8.writeShort(0);
								this.field3597.write(var8.array, 0, 4);
							} catch (IOException var6) {
								try {
									this.field3597.close();
								} catch (Exception var5) {
								}

								++this.field3606;
								this.field3597 = null;
							}
						}

						this.field3587 = 0;
						this.field3593 = SpotAnimationDefinition.method962();
						return;
					}

					this.field3594.method2004(var3);
					this.field3598.put(var3, var3.key);
					++this.field3591;
					--this.field3590;
				}
			}

			this.field3599.put(var3, var3.key);
			++this.field3585;
			--this.field3584;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Loh;II)V",
		garbageValue = "-1796726180"
	)
	void method1956(Archive var1, int var2) {
		if (var1.field3547 && !var1.field3546) {
			if (var2 <= this.field3586) {
				throw new RuntimeException("");
			}

			if (var2 < this.field3589) {
				this.field3589 = var2;
			}
		} else {
			if (var2 >= this.field3589) {
				throw new RuntimeException("");
			}

			if (var2 > this.field3586) {
				this.field3586 = var2;
			}
		}

		if (this.field3602 != null) {
			this.method1957(var1, var2);
		} else {
			this.method1958((Archive)null, 255, 255, 0, (byte)0, true);
			this.field3595[var2] = var1;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Loh;IB)V",
		garbageValue = "-34"
	)
	void method1957(Archive var1, int var2) {
		this.field3602.offset = var2 * 8 + 5;
		if (this.field3602.offset >= this.field3602.array.length) {
			if (var1.field3547) {
				var1.method1916();
			} else {
				throw new RuntimeException("");
			}
		} else {
			int var3 = this.field3602.readInt();
			int var4 = this.field3602.readInt();
			var1.loadIndex(var3, var4);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Loh;IIIBZB)V",
		garbageValue = "71"
	)
	void method1958(Archive var1, int var2, int var3, int var4, byte var5, boolean var6) {
		long var7 = (long)(var3 + (var2 << 16));
		class369 var9 = (class369)this.field3599.get(var7);
		if (var9 == null) {
			var9 = (class369)this.field3601.get(var7);
			if (var9 == null) {
				var9 = (class369)this.field3598.get(var7);
				if (var9 != null) {
					if (var6) {
						var9.removeDual();
						this.field3599.put(var9, var7);
						--this.field3591;
						++this.field3585;
					}

				} else {
					if (!var6) {
						var9 = (class369)this.field3600.get(var7);
						if (var9 != null) {
							return;
						}
					}

					var9 = new class369();
					var9.field3564 = var1;
					var9.field3563 = var4;
					var9.field3562 = var5;
					if (var6) {
						this.field3599.put(var9, var7);
						++this.field3585;
					} else {
						this.field3594.method2003(var9);
						this.field3598.put(var9, var7);
						++this.field3591;
					}

				}
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "880980368"
	)
	void method1959(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		class369 var5 = (class369)this.field3598.get(var3);
		if (var5 != null) {
			this.field3594.method2004(var5);
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "480276269"
	)
	int method1960(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		return this.field3596 != null && this.field3596.key == var3 ? this.field3603.offset * 99 / (this.field3603.array.length - this.field3596.field3562) + 1 : 0;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ZZB)I",
		garbageValue = "-122"
	)
	public int method1961(boolean var1, boolean var2) {
		byte var3 = 0;
		int var4 = var3 + this.field3585 + this.field3584;
		return var4;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1516647272"
	)
	public void method1962() {
		if (this.field3597 != null) {
			this.field3597.close();
		}

	}
}