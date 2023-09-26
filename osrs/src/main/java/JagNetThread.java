import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("oo")
@Implements("JagNetThread")
public class JagNetThread {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lre;"
	)
	AbstractSocket field3598;
	@ObfuscatedName("al")
	int field3586;
	@ObfuscatedName("ak")
	long field3594;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	NodeHashTable field3602;
	@ObfuscatedName("ao")
	int field3588;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	NodeHashTable field3600;
	@ObfuscatedName("ar")
	int field3590;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lpl;"
	)
	DualNodeDeque field3597;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	NodeHashTable field3601;
	@ObfuscatedName("av")
	int field3591;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	NodeHashTable field3599;
	@ObfuscatedName("aa")
	int field3585;
	@ObfuscatedName("ap")
	boolean field3583;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lou;"
	)
	class372 field3596;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	Buffer field3605;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	Buffer field3604;
	@ObfuscatedName("an")
	int field3587;
	@ObfuscatedName("ai")
	CRC32 field3593;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	Buffer field3603;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "[Lok;"
	)
	Archive[] field3595;
	@ObfuscatedName("aq")
	int field3589;
	@ObfuscatedName("az")
	int field3592;
	@ObfuscatedName("at")
	byte field3584;
	@ObfuscatedName("af")
	public int field3607;
	@ObfuscatedName("ad")
	public int field3606;

	public JagNetThread() {
		this.field3586 = 0;
		this.field3602 = new NodeHashTable(4096);
		this.field3588 = 0;
		this.field3600 = new NodeHashTable(32);
		this.field3590 = 0;
		this.field3597 = new DualNodeDeque();
		this.field3601 = new NodeHashTable(4096);
		this.field3591 = 0;
		this.field3599 = new NodeHashTable(4096);
		this.field3585 = 0;
		this.field3605 = new Buffer(8);
		this.field3587 = 0;
		this.field3593 = new CRC32();
		this.field3595 = new Archive[256];
		this.field3589 = -1;
		this.field3592 = 255;
		this.field3584 = 0;
		this.field3607 = 0;
		this.field3606 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "877525740"
	)
	public boolean method1960() {
		long var1 = GrandExchangeOfferTotalQuantityComparator.method1971();
		int var3 = (int)(var1 - this.field3594);
		this.field3594 = var1;
		if (var3 > 200) {
			var3 = 200;
		}

		this.field3586 += var3;
		if (this.field3585 == 0 && this.field3590 == 0 && this.field3591 == 0 && this.field3588 == 0) {
			return true;
		} else if (this.field3598 == null) {
			return false;
		} else {
			try {
				if (this.field3586 > 30000) {
					throw new IOException();
				} else {
					class372 var4;
					Buffer var5;
					while (this.field3590 < 200 && this.field3588 > 0) {
						var4 = (class372)this.field3602.first();
						var5 = new Buffer(4);
						var5.writeByte(1);
						var5.writeMedium((int)var4.key);
						this.field3598.write(var5.array, 0, 4);
						this.field3600.put(var4, var4.key);
						--this.field3588;
						++this.field3590;
					}

					while (this.field3585 < 200 && this.field3591 > 0) {
						var4 = (class372)this.field3597.removeLast();
						var5 = new Buffer(4);
						var5.writeByte(0);
						var5.writeMedium((int)var4.key);
						this.field3598.write(var5.array, 0, 4);
						var4.removeDual();
						this.field3599.put(var4, var4.key);
						--this.field3591;
						++this.field3585;
					}

					for (int var16 = 0; var16 < 100; ++var16) {
						int var17 = this.field3598.available();
						if (var17 < 0) {
							throw new IOException();
						}

						if (var17 == 0) {
							break;
						}

						this.field3586 = 0;
						byte var6 = 0;
						if (this.field3596 == null) {
							var6 = 8;
						} else if (this.field3587 == 0) {
							var6 = 1;
						}

						int var7;
						int var8;
						int var9;
						byte[] var10000;
						int var10001;
						Buffer var22;
						if (var6 > 0) {
							var7 = var6 - this.field3605.offset;
							if (var7 > var17) {
								var7 = var17;
							}

							this.field3598.read(this.field3605.array, this.field3605.offset, var7);
							if (this.field3584 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = this.field3605.array;
									var10001 = var8 + this.field3605.offset;
									var10000[var10001] ^= this.field3584;
								}
							}

							var22 = this.field3605;
							var22.offset += var7;
							if (this.field3605.offset < var6) {
								break;
							}

							if (this.field3596 == null) {
								this.field3605.offset = 0;
								var8 = this.field3605.readUnsignedByte();
								var9 = this.field3605.readUnsignedShort();
								int var10 = this.field3605.readUnsignedByte();
								int var11 = this.field3605.readInt();
								long var12 = (long)(var9 + (var8 << 16));
								class372 var14 = (class372)this.field3600.get(var12);
								this.field3583 = true;
								if (var14 == null) {
									var14 = (class372)this.field3599.get(var12);
									this.field3583 = false;
								}

								if (var14 == null) {
									throw new IOException();
								}

								int var15 = var10 == 0 ? 5 : 9;
								this.field3596 = var14;
								this.field3604 = new Buffer(this.field3596.field3563 + var15 + var11);
								this.field3604.writeByte(var10);
								this.field3604.writeInt(var11);
								this.field3587 = 8;
								this.field3605.offset = 0;
							} else if (this.field3587 == 0) {
								if (this.field3605.array[0] == -1) {
									this.field3587 = 1;
									this.field3605.offset = 0;
								} else {
									this.field3596 = null;
								}
							}
						} else {
							var7 = this.field3604.array.length - this.field3596.field3563;
							var8 = 512 - this.field3587;
							if (var8 > var7 - this.field3604.offset) {
								var8 = var7 - this.field3604.offset;
							}

							if (var8 > var17) {
								var8 = var17;
							}

							this.field3598.read(this.field3604.array, this.field3604.offset, var8);
							if (this.field3584 != 0) {
								for (var9 = 0; var9 < var8; ++var9) {
									var10000 = this.field3604.array;
									var10001 = var9 + this.field3604.offset;
									var10000[var10001] ^= this.field3584;
								}
							}

							var22 = this.field3604;
							var22.offset += var8;
							this.field3587 += var8;
							if (this.field3604.offset == var7) {
								if (16711935L == this.field3596.key) {
									this.field3603 = this.field3604;

									for (var9 = 0; var9 < 256; ++var9) {
										Archive var18 = this.field3595[var9];
										if (var18 != null) {
											this.method1964(var18, var9);
										}
									}
								} else {
									this.field3593.reset();
									this.field3593.update(this.field3604.array, 0, var7);
									var9 = (int)this.field3593.getValue();
									if (this.field3596.field3564 != var9) {
										try {
											this.field3598.close();
										} catch (Exception var20) {
										}

										++this.field3607;
										this.field3598 = null;
										this.field3584 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									this.field3607 = 0;
									this.field3606 = 0;
									this.field3596.field3565.write((int)(this.field3596.key & 65535L), this.field3604.array, (this.field3596.key & 16711680L) == 16711680L, this.field3583);
								}

								this.field3596.remove();
								if (this.field3583) {
									--this.field3590;
								} else {
									--this.field3585;
								}

								this.field3587 = 0;
								this.field3596 = null;
								this.field3604 = null;
							} else {
								if (this.field3587 != 512) {
									break;
								}

								this.field3587 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var21) {
				try {
					this.field3598.close();
				} catch (Exception var19) {
				}

				++this.field3606;
				this.field3598 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "1"
	)
	public void method1961(boolean var1) {
		if (this.field3598 != null) {
			try {
				Buffer var2 = new Buffer(4);
				var2.writeByte(var1 ? 2 : 3);
				var2.writeMedium(0);
				this.field3598.write(var2.array, 0, 4);
			} catch (IOException var5) {
				try {
					this.field3598.close();
				} catch (Exception var4) {
				}

				++this.field3606;
				this.field3598 = null;
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lre;ZB)V",
		garbageValue = "-76"
	)
	public void method1962(AbstractSocket var1, boolean var2) {
		if (this.field3598 != null) {
			try {
				this.field3598.close();
			} catch (Exception var7) {
			}

			this.field3598 = null;
		}

		this.field3598 = var1;
		this.method1961(var2);
		this.field3605.offset = 0;
		this.field3596 = null;
		this.field3604 = null;
		this.field3587 = 0;

		while (true) {
			class372 var3 = (class372)this.field3600.first();
			if (var3 == null) {
				while (true) {
					var3 = (class372)this.field3599.first();
					if (var3 == null) {
						if (this.field3584 != 0) {
							try {
								Buffer var8 = new Buffer(4);
								var8.writeByte(4);
								var8.writeByte(this.field3584);
								var8.writeShort(0);
								this.field3598.write(var8.array, 0, 4);
							} catch (IOException var6) {
								try {
									this.field3598.close();
								} catch (Exception var5) {
								}

								++this.field3606;
								this.field3598 = null;
							}
						}

						this.field3586 = 0;
						this.field3594 = GrandExchangeOfferTotalQuantityComparator.method1971();
						return;
					}

					this.field3597.method2016(var3);
					this.field3601.put(var3, var3.key);
					++this.field3591;
					--this.field3585;
				}
			}

			this.field3602.put(var3, var3.key);
			++this.field3588;
			--this.field3590;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lok;II)V",
		garbageValue = "-699589985"
	)
	void method1963(Archive var1, int var2) {
		if (var1.field3549 && !var1.field3550) {
			if (var2 <= this.field3589) {
				throw new RuntimeException("");
			}

			if (var2 < this.field3592) {
				this.field3592 = var2;
			}
		} else {
			if (var2 >= this.field3592) {
				throw new RuntimeException("");
			}

			if (var2 > this.field3589) {
				this.field3589 = var2;
			}
		}

		if (this.field3603 != null) {
			this.method1964(var1, var2);
		} else {
			this.method1965((Archive)null, 255, 255, 0, (byte)0, true);
			this.field3595[var2] = var1;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lok;II)V",
		garbageValue = "-1352429107"
	)
	void method1964(Archive var1, int var2) {
		this.field3603.offset = var2 * 8 + 5;
		if (this.field3603.offset >= this.field3603.array.length) {
			if (var1.field3549) {
				var1.method1919();
			} else {
				throw new RuntimeException("");
			}
		} else {
			int var3 = this.field3603.readInt();
			int var4 = this.field3603.readInt();
			var1.loadIndex(var3, var4);
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lok;IIIBZI)V",
		garbageValue = "-1546984161"
	)
	void method1965(Archive var1, int var2, int var3, int var4, byte var5, boolean var6) {
		long var7 = (long)(var3 + (var2 << 16));
		class372 var9 = (class372)this.field3602.get(var7);
		if (var9 == null) {
			var9 = (class372)this.field3600.get(var7);
			if (var9 == null) {
				var9 = (class372)this.field3601.get(var7);
				if (var9 != null) {
					if (var6) {
						var9.removeDual();
						this.field3602.put(var9, var7);
						--this.field3591;
						++this.field3588;
					}

				} else {
					if (!var6) {
						var9 = (class372)this.field3599.get(var7);
						if (var9 != null) {
							return;
						}
					}

					var9 = new class372();
					var9.field3565 = var1;
					var9.field3564 = var4;
					var9.field3563 = var5;
					if (var6) {
						this.field3602.put(var9, var7);
						++this.field3588;
					} else {
						this.field3597.method2015(var9);
						this.field3601.put(var9, var7);
						++this.field3591;
					}

				}
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "223399065"
	)
	void method1966(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		class372 var5 = (class372)this.field3601.get(var3);
		if (var5 != null) {
			this.field3597.method2016(var5);
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "823173998"
	)
	int method1967(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		return this.field3596 != null && var3 == this.field3596.key ? this.field3604.offset * 99 / (this.field3604.array.length - this.field3596.field3563) + 1 : 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(ZZB)I",
		garbageValue = "-84"
	)
	public int method1968(boolean var1, boolean var2) {
		byte var3 = 0;
		int var4 = var3 + this.field3590 + this.field3588;
		return var4;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "45"
	)
	public void method1969() {
		if (this.field3598 != null) {
			this.field3598.close();
		}

	}
}