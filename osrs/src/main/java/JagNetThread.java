import java.io.IOException;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nq")
public class JagNetThread {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lqh;"
	)
	AbstractSocket field3552;
	@ObfuscatedName("ay")
	int field3546;
	@ObfuscatedName("ar")
	long field3548;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	NodeHashTable field3554;
	@ObfuscatedName("as")
	int field3544;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	NodeHashTable field3553;
	@ObfuscatedName("ag")
	int field3540;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lob;"
	)
	DualNodeDeque field3551;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	NodeHashTable field3556;
	@ObfuscatedName("ap")
	int field3543;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	NodeHashTable field3555;
	@ObfuscatedName("at")
	int field3545;
	@ObfuscatedName("ah")
	boolean field3537;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lnx;"
	)
	class358 field3549;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	Buffer field3557;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	Buffer field3559;
	@ObfuscatedName("ae")
	int field3539;
	@ObfuscatedName("ad")
	CRC32 field3547;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	Buffer field3558;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lny;"
	)
	Archive[] field3550;
	@ObfuscatedName("ak")
	int field3541;
	@ObfuscatedName("an")
	int field3542;
	@ObfuscatedName("af")
	byte field3538;
	@ObfuscatedName("ai")
	public int field3560;
	@ObfuscatedName("al")
	public int field3561;

	public JagNetThread() {
		this.field3546 = 0;
		this.field3554 = new NodeHashTable(4096);
		this.field3544 = 0;
		this.field3553 = new NodeHashTable(32);
		this.field3540 = 0;
		this.field3551 = new DualNodeDeque();
		this.field3556 = new NodeHashTable(4096);
		this.field3543 = 0;
		this.field3555 = new NodeHashTable(4096);
		this.field3545 = 0;
		this.field3557 = new Buffer(8);
		this.field3539 = 0;
		this.field3547 = new CRC32();
		this.field3550 = new Archive[256];
		this.field3541 = -1;
		this.field3542 = 255;
		this.field3538 = 0;
		this.field3560 = 0;
		this.field3561 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "-1782"
	)
	public boolean method1895() {
		long var1 = class113.clockNow();
		int var3 = (int)(var1 - this.field3548);
		this.field3548 = var1;
		if (var3 > 200) {
			var3 = 200;
		}

		this.field3546 += var3;
		if (this.field3545 == 0 && this.field3540 == 0 && this.field3543 == 0 && this.field3544 == 0) {
			return true;
		} else if (this.field3552 == null) {
			return false;
		} else {
			try {
				if (this.field3546 > 30000) {
					throw new IOException();
				} else {
					class358 var4;
					Buffer var5;
					while (this.field3540 < 200 && this.field3544 > 0) {
						var4 = (class358)this.field3554.first();
						var5 = new Buffer(4);
						var5.writeByte(1);
						var5.writeMedium((int)var4.key);
						this.field3552.write(var5.array, 0, 4);
						this.field3553.put(var4, var4.key);
						--this.field3544;
						++this.field3540;
					}

					while (this.field3545 < 200 && this.field3543 > 0) {
						var4 = (class358)this.field3551.removeLast();
						var5 = new Buffer(4);
						var5.writeByte(0);
						var5.writeMedium((int)var4.key);
						this.field3552.write(var5.array, 0, 4);
						var4.removeDual();
						this.field3555.put(var4, var4.key);
						--this.field3543;
						++this.field3545;
					}

					for (int var16 = 0; var16 < 100; ++var16) {
						int var17 = this.field3552.available();
						if (var17 < 0) {
							throw new IOException();
						}

						if (var17 == 0) {
							break;
						}

						this.field3546 = 0;
						byte var6 = 0;
						if (this.field3549 == null) {
							var6 = 8;
						} else if (this.field3539 == 0) {
							var6 = 1;
						}

						int var7;
						int var8;
						int var9;
						byte[] var10000;
						int var10001;
						Buffer var22;
						if (var6 > 0) {
							var7 = var6 - this.field3557.offset;
							if (var7 > var17) {
								var7 = var17;
							}

							this.field3552.read(this.field3557.array, this.field3557.offset, var7);
							if (this.field3538 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = this.field3557.array;
									var10001 = this.field3557.offset + var8;
									var10000[var10001] ^= this.field3538;
								}
							}

							var22 = this.field3557;
							var22.offset += var7;
							if (this.field3557.offset < var6) {
								break;
							}

							if (this.field3549 == null) {
								this.field3557.offset = 0;
								var8 = this.field3557.readUnsignedByte();
								var9 = this.field3557.readUnsignedShort();
								int var10 = this.field3557.readUnsignedByte();
								int var11 = this.field3557.readInt();
								long var12 = (long)(var9 + (var8 << 16));
								class358 var14 = (class358)this.field3553.get(var12);
								this.field3537 = true;
								if (var14 == null) {
									var14 = (class358)this.field3555.get(var12);
									this.field3537 = false;
								}

								if (var14 == null) {
									throw new IOException();
								}

								int var15 = var10 == 0 ? 5 : 9;
								this.field3549 = var14;
								this.field3559 = new Buffer(this.field3549.field3516 + var15 + var11);
								this.field3559.writeByte(var10);
								this.field3559.writeInt(var11);
								this.field3539 = 8;
								this.field3557.offset = 0;
							} else if (this.field3539 == 0) {
								if (this.field3557.array[0] == -1) {
									this.field3539 = 1;
									this.field3557.offset = 0;
								} else {
									this.field3549 = null;
								}
							}
						} else {
							var7 = this.field3559.array.length - this.field3549.field3516;
							var8 = 512 - this.field3539;
							if (var8 > var7 - this.field3559.offset) {
								var8 = var7 - this.field3559.offset;
							}

							if (var8 > var17) {
								var8 = var17;
							}

							this.field3552.read(this.field3559.array, this.field3559.offset, var8);
							if (this.field3538 != 0) {
								for (var9 = 0; var9 < var8; ++var9) {
									var10000 = this.field3559.array;
									var10001 = var9 + this.field3559.offset;
									var10000[var10001] ^= this.field3538;
								}
							}

							var22 = this.field3559;
							var22.offset += var8;
							this.field3539 += var8;
							if (this.field3559.offset == var7) {
								if (this.field3549.key == 16711935L) {
									this.field3558 = this.field3559;

									for (var9 = 0; var9 < 256; ++var9) {
										Archive var18 = this.field3550[var9];
										if (var18 != null) {
											this.method1899(var18, var9);
										}
									}
								} else {
									this.field3547.reset();
									this.field3547.update(this.field3559.array, 0, var7);
									var9 = (int)this.field3547.getValue();
									if (this.field3549.field3517 != var9) {
										try {
											this.field3552.close();
										} catch (Exception var20) {
										}

										++this.field3560;
										this.field3552 = null;
										this.field3538 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									this.field3560 = 0;
									this.field3561 = 0;
									this.field3549.field3518.write((int)(this.field3549.key & 65535L), this.field3559.array, (this.field3549.key & 16711680L) == 16711680L, this.field3537);
								}

								this.field3549.remove();
								if (this.field3537) {
									--this.field3540;
								} else {
									--this.field3545;
								}

								this.field3539 = 0;
								this.field3549 = null;
								this.field3559 = null;
							} else {
								if (this.field3539 != 512) {
									break;
								}

								this.field3539 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var21) {
				try {
					this.field3552.close();
				} catch (Exception var19) {
				}

				++this.field3561;
				this.field3552 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-89"
	)
	public void method1896(boolean var1) {
		if (this.field3552 != null) {
			try {
				Buffer var2 = new Buffer(4);
				var2.writeByte(var1 ? 2 : 3);
				var2.writeMedium(0);
				this.field3552.write(var2.array, 0, 4);
			} catch (IOException var5) {
				try {
					this.field3552.close();
				} catch (Exception var4) {
				}

				++this.field3561;
				this.field3552 = null;
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lqh;ZB)V",
		garbageValue = "64"
	)
	public void method1897(AbstractSocket var1, boolean var2) {
		if (this.field3552 != null) {
			try {
				this.field3552.close();
			} catch (Exception var7) {
			}

			this.field3552 = null;
		}

		this.field3552 = var1;
		this.method1896(var2);
		this.field3557.offset = 0;
		this.field3549 = null;
		this.field3559 = null;
		this.field3539 = 0;

		while (true) {
			class358 var3 = (class358)this.field3553.first();
			if (var3 == null) {
				while (true) {
					var3 = (class358)this.field3555.first();
					if (var3 == null) {
						if (this.field3538 != 0) {
							try {
								Buffer var8 = new Buffer(4);
								var8.writeByte(4);
								var8.writeByte(this.field3538);
								var8.writeShort(0);
								this.field3552.write(var8.array, 0, 4);
							} catch (IOException var6) {
								try {
									this.field3552.close();
								} catch (Exception var5) {
								}

								++this.field3561;
								this.field3552 = null;
							}
						}

						this.field3546 = 0;
						this.field3548 = class113.clockNow();
						return;
					}

					this.field3551.method1948(var3);
					this.field3556.put(var3, var3.key);
					++this.field3543;
					--this.field3545;
				}
			}

			this.field3554.put(var3, var3.key);
			++this.field3544;
			--this.field3540;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lny;II)V",
		garbageValue = "-830735706"
	)
	void method1898(Archive var1, int var2) {
		if (var1.field3506) {
			if (var2 <= this.field3541) {
				throw new RuntimeException("");
			}

			if (var2 < this.field3542) {
				this.field3542 = var2;
			}
		} else {
			if (var2 >= this.field3542) {
				throw new RuntimeException("");
			}

			if (var2 > this.field3541) {
				this.field3541 = var2;
			}
		}

		if (this.field3558 != null) {
			this.method1899(var1, var2);
		} else {
			this.method1900((Archive)null, 255, 255, 0, (byte)0, true);
			this.field3550[var2] = var1;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lny;IB)V",
		garbageValue = "5"
	)
	void method1899(Archive var1, int var2) {
		this.field3558.offset = var2 * 8 + 5;
		if (this.field3558.offset >= this.field3558.array.length) {
			if (var1.field3506) {
				var1.method1855();
			} else {
				throw new RuntimeException("");
			}
		} else {
			int var3 = this.field3558.readInt();
			int var4 = this.field3558.readInt();
			var1.loadIndex(var3, var4);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lny;IIIBZI)V",
		garbageValue = "-1002085673"
	)
	void method1900(Archive var1, int var2, int var3, int var4, byte var5, boolean var6) {
		long var7 = (long)(var3 + (var2 << 16));
		class358 var9 = (class358)this.field3554.get(var7);
		if (var9 == null) {
			var9 = (class358)this.field3553.get(var7);
			if (var9 == null) {
				var9 = (class358)this.field3556.get(var7);
				if (var9 != null) {
					if (var6) {
						var9.removeDual();
						this.field3554.put(var9, var7);
						--this.field3543;
						++this.field3544;
					}

				} else {
					if (!var6) {
						var9 = (class358)this.field3555.get(var7);
						if (var9 != null) {
							return;
						}
					}

					var9 = new class358();
					var9.field3518 = var1;
					var9.field3517 = var4;
					var9.field3516 = var5;
					if (var6) {
						this.field3554.put(var9, var7);
						++this.field3544;
					} else {
						this.field3551.method1947(var9);
						this.field3556.put(var9, var7);
						++this.field3543;
					}

				}
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2091914027"
	)
	void method1901(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		class358 var5 = (class358)this.field3556.get(var3);
		if (var5 != null) {
			this.field3551.method1948(var5);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "106"
	)
	int method1902(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		return this.field3549 != null && this.field3549.key == var3 ? this.field3559.offset * 99 / (this.field3559.array.length - this.field3549.field3516) + 1 : 0;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(ZZI)I",
		garbageValue = "-988136504"
	)
	public int method1903(boolean var1, boolean var2) {
		byte var3 = 0;
		int var4 = var3 + this.field3544 + this.field3540;
		return var4;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-102"
	)
	public void method1904() {
		if (this.field3552 != null) {
			this.field3552.close();
		}

	}
}
