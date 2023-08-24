import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("nf")
@Implements("JagNetThread")
public class JagNetThread {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lqi;"
	)
	AbstractSocket field3561;
	@ObfuscatedName("ae")
	int field3549;
	@ObfuscatedName("ao")
	long field3557;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	NodeHashTable field3565;
	@ObfuscatedName("ac")
	int field3548;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	NodeHashTable field3564;
	@ObfuscatedName("az")
	int field3555;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	DualNodeDeque field3560;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	NodeHashTable field3562;
	@ObfuscatedName("af")
	int field3550;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	NodeHashTable field3563;
	@ObfuscatedName("aq")
	int field3553;
	@ObfuscatedName("al")
	boolean field3546;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lnj;"
	)
	class357 field3558;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	Buffer field3568;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	Buffer field3566;
	@ObfuscatedName("ag")
	int field3551;
	@ObfuscatedName("ax")
	CRC32 field3556;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	Buffer field3567;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Lnk;"
	)
	Archive[] field3559;
	@ObfuscatedName("ay")
	int field3554;
	@ObfuscatedName("aj")
	int field3552;
	@ObfuscatedName("av")
	byte field3547;
	@ObfuscatedName("aw")
	public int field3570;
	@ObfuscatedName("ak")
	public int field3569;

	public JagNetThread() {
		this.field3549 = 0;
		this.field3565 = new NodeHashTable(4096);
		this.field3548 = 0;
		this.field3564 = new NodeHashTable(32);
		this.field3555 = 0;
		this.field3560 = new DualNodeDeque();
		this.field3562 = new NodeHashTable(4096);
		this.field3550 = 0;
		this.field3563 = new NodeHashTable(4096);
		this.field3553 = 0;
		this.field3568 = new Buffer(8);
		this.field3551 = 0;
		this.field3556 = new CRC32();
		this.field3559 = new Archive[256];
		this.field3554 = -1;
		this.field3552 = 255;
		this.field3547 = 0;
		this.field3570 = 0;
		this.field3569 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "935597926"
	)
	public boolean method1930() {
		long var1 = GameEngine.clockNow();
		int var3 = (int)(var1 - this.field3557);
		this.field3557 = var1;
		if (var3 > 200) {
			var3 = 200;
		}

		this.field3549 += var3;
		if (this.field3553 == 0 && this.field3555 == 0 && this.field3550 == 0 && this.field3548 == 0) {
			return true;
		} else if (this.field3561 == null) {
			return false;
		} else {
			try {
				if (this.field3549 > 30000) {
					throw new IOException();
				} else {
					class357 var4;
					Buffer var5;
					while (this.field3555 < 200 && this.field3548 > 0) {
						var4 = (class357)this.field3565.first();
						var5 = new Buffer(4);
						var5.writeByte(1);
						var5.writeMedium((int)var4.key);
						this.field3561.write(var5.array, 0, 4);
						this.field3564.put(var4, var4.key);
						--this.field3548;
						++this.field3555;
					}

					while (this.field3553 < 200 && this.field3550 > 0) {
						var4 = (class357)this.field3560.removeLast();
						var5 = new Buffer(4);
						var5.writeByte(0);
						var5.writeMedium((int)var4.key);
						this.field3561.write(var5.array, 0, 4);
						var4.removeDual();
						this.field3563.put(var4, var4.key);
						--this.field3550;
						++this.field3553;
					}

					for (int var16 = 0; var16 < 100; ++var16) {
						int var17 = this.field3561.available();
						if (var17 < 0) {
							throw new IOException();
						}

						if (var17 == 0) {
							break;
						}

						this.field3549 = 0;
						byte var6 = 0;
						if (this.field3558 == null) {
							var6 = 8;
						} else if (this.field3551 == 0) {
							var6 = 1;
						}

						int var7;
						int var8;
						int var9;
						byte[] var10000;
						int var10001;
						Buffer var22;
						if (var6 > 0) {
							var7 = var6 - this.field3568.offset;
							if (var7 > var17) {
								var7 = var17;
							}

							this.field3561.read(this.field3568.array, this.field3568.offset, var7);
							if (this.field3547 != 0) {
								for (var8 = 0; var8 < var7; ++var8) {
									var10000 = this.field3568.array;
									var10001 = var8 + this.field3568.offset;
									var10000[var10001] ^= this.field3547;
								}
							}

							var22 = this.field3568;
							var22.offset += var7;
							if (this.field3568.offset < var6) {
								break;
							}

							if (this.field3558 == null) {
								this.field3568.offset = 0;
								var8 = this.field3568.readUnsignedByte();
								var9 = this.field3568.readUnsignedShort();
								int var10 = this.field3568.readUnsignedByte();
								int var11 = this.field3568.readInt();
								long var12 = (long)(var9 + (var8 << 16));
								class357 var14 = (class357)this.field3564.get(var12);
								this.field3546 = true;
								if (var14 == null) {
									var14 = (class357)this.field3563.get(var12);
									this.field3546 = false;
								}

								if (var14 == null) {
									throw new IOException();
								}

								int var15 = var10 == 0 ? 5 : 9;
								this.field3558 = var14;
								this.field3566 = new Buffer(this.field3558.field3526 + var11 + var15);
								this.field3566.writeByte(var10);
								this.field3566.writeInt(var11);
								this.field3551 = 8;
								this.field3568.offset = 0;
							} else if (this.field3551 == 0) {
								if (this.field3568.array[0] == -1) {
									this.field3551 = 1;
									this.field3568.offset = 0;
								} else {
									this.field3558 = null;
								}
							}
						} else {
							var7 = this.field3566.array.length - this.field3558.field3526;
							var8 = 512 - this.field3551;
							if (var8 > var7 - this.field3566.offset) {
								var8 = var7 - this.field3566.offset;
							}

							if (var8 > var17) {
								var8 = var17;
							}

							this.field3561.read(this.field3566.array, this.field3566.offset, var8);
							if (this.field3547 != 0) {
								for (var9 = 0; var9 < var8; ++var9) {
									var10000 = this.field3566.array;
									var10001 = var9 + this.field3566.offset;
									var10000[var10001] ^= this.field3547;
								}
							}

							var22 = this.field3566;
							var22.offset += var8;
							this.field3551 += var8;
							if (this.field3566.offset == var7) {
								if (16711935L == this.field3558.key) {
									this.field3567 = this.field3566;

									for (var9 = 0; var9 < 256; ++var9) {
										Archive var18 = this.field3559[var9];
										if (var18 != null) {
											this.method1935(var18, var9);
										}
									}
								} else {
									this.field3556.reset();
									this.field3556.update(this.field3566.array, 0, var7);
									var9 = (int)this.field3556.getValue();
									if (this.field3558.field3527 != var9) {
										try {
											this.field3561.close();
										} catch (Exception var20) {
										}

										++this.field3570;
										this.field3561 = null;
										this.field3547 = (byte)((int)(Math.random() * 255.0D + 1.0D));
										return false;
									}

									this.field3570 = 0;
									this.field3569 = 0;
									this.field3558.field3528.write((int)(this.field3558.key & 65535L), this.field3566.array, 16711680L == (this.field3558.key & 16711680L), this.field3546);
								}

								this.field3558.remove();
								if (this.field3546) {
									--this.field3555;
								} else {
									--this.field3553;
								}

								this.field3551 = 0;
								this.field3558 = null;
								this.field3566 = null;
							} else {
								if (this.field3551 != 512) {
									break;
								}

								this.field3551 = 0;
							}
						}
					}

					return true;
				}
			} catch (IOException var21) {
				try {
					this.field3561.close();
				} catch (Exception var19) {
				}

				++this.field3569;
				this.field3561 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-2147075944"
	)
	public void method1932(boolean var1) {
		if (this.field3561 != null) {
			try {
				Buffer var2 = new Buffer(4);
				var2.writeByte(var1 ? 2 : 3);
				var2.writeMedium(0);
				this.field3561.write(var2.array, 0, 4);
			} catch (IOException var5) {
				try {
					this.field3561.close();
				} catch (Exception var4) {
				}

				++this.field3569;
				this.field3561 = null;
			}

		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lqi;ZI)V",
		garbageValue = "-1755212969"
	)
	public void method1933(AbstractSocket var1, boolean var2) {
		if (this.field3561 != null) {
			try {
				this.field3561.close();
			} catch (Exception var7) {
			}

			this.field3561 = null;
		}

		this.field3561 = var1;
		this.method1932(var2);
		this.field3568.offset = 0;
		this.field3558 = null;
		this.field3566 = null;
		this.field3551 = 0;

		while (true) {
			class357 var3 = (class357)this.field3564.first();
			if (var3 == null) {
				while (true) {
					var3 = (class357)this.field3563.first();
					if (var3 == null) {
						if (this.field3547 != 0) {
							try {
								Buffer var8 = new Buffer(4);
								var8.writeByte(4);
								var8.writeByte(this.field3547);
								var8.writeShort(0);
								this.field3561.write(var8.array, 0, 4);
							} catch (IOException var6) {
								try {
									this.field3561.close();
								} catch (Exception var5) {
								}

								++this.field3569;
								this.field3561 = null;
							}
						}

						this.field3549 = 0;
						this.field3557 = GameEngine.clockNow();
						return;
					}

					this.field3560.method1985(var3);
					this.field3562.put(var3, var3.key);
					++this.field3550;
					--this.field3553;
				}
			}

			this.field3565.put(var3, var3.key);
			++this.field3548;
			--this.field3555;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lnk;II)V",
		garbageValue = "1859946409"
	)
	void method1934(Archive var1, int var2) {
		if (var1.field3515) {
			if (var2 <= this.field3554) {
				throw new RuntimeException("");
			}

			if (var2 < this.field3552) {
				this.field3552 = var2;
			}
		} else {
			if (var2 >= this.field3552) {
				throw new RuntimeException("");
			}

			if (var2 > this.field3554) {
				this.field3554 = var2;
			}
		}

		if (this.field3567 != null) {
			this.method1935(var1, var2);
		} else {
			this.method1936((Archive)null, 255, 255, 0, (byte)0, true);
			this.field3559[var2] = var1;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lnk;II)V",
		garbageValue = "-1785545796"
	)
	void method1935(Archive var1, int var2) {
		this.field3567.offset = var2 * 8 + 5;
		if (this.field3567.offset >= this.field3567.array.length) {
			if (var1.field3515) {
				var1.method1891();
			} else {
				throw new RuntimeException("");
			}
		} else {
			int var3 = this.field3567.readInt();
			int var4 = this.field3567.readInt();
			var1.loadIndex(var3, var4);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lnk;IIIBZB)V",
		garbageValue = "-83"
	)
	void method1936(Archive var1, int var2, int var3, int var4, byte var5, boolean var6) {
		long var7 = (long)(var3 + (var2 << 16));
		class357 var9 = (class357)this.field3565.get(var7);
		if (var9 == null) {
			var9 = (class357)this.field3564.get(var7);
			if (var9 == null) {
				var9 = (class357)this.field3562.get(var7);
				if (var9 != null) {
					if (var6) {
						var9.removeDual();
						this.field3565.put(var9, var7);
						--this.field3550;
						++this.field3548;
					}

				} else {
					if (!var6) {
						var9 = (class357)this.field3563.get(var7);
						if (var9 != null) {
							return;
						}
					}

					var9 = new class357();
					var9.field3528 = var1;
					var9.field3527 = var4;
					var9.field3526 = var5;
					if (var6) {
						this.field3565.put(var9, var7);
						++this.field3548;
					} else {
						this.field3560.method1984(var9);
						this.field3562.put(var9, var7);
						++this.field3550;
					}

				}
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1960227475"
	)
	void method1937(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		class357 var5 = (class357)this.field3562.get(var3);
		if (var5 != null) {
			this.field3560.method1985(var5);
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1437295059"
	)
	int method1938(int var1, int var2) {
		long var3 = (long)((var1 << 16) + var2);
		return this.field3558 != null && var3 == this.field3558.key ? this.field3566.offset * 99 / (this.field3566.array.length - this.field3558.field3526) + 1 : 0;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(ZZS)I",
		garbageValue = "-10235"
	)
	public int method1939(boolean var1, boolean var2) {
		byte var3 = 0;
		int var4 = var3 + this.field3555 + this.field3548;
		return var4;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1866561588"
	)
	public void method1940() {
		if (this.field3561 != null) {
			this.field3561.close();
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldc;",
		garbageValue = "569243283"
	)
	static AttackOption[] method1941() {
		return new AttackOption[]{AttackOption.field1099, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.field1097};
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(CI)C",
		garbageValue = "-162809884"
	)
	static char method1931(char var0) {
		if (var0 == 198) {
			return 'E';
		} else if (var0 == 230) {
			return 'e';
		} else if (var0 == 223) {
			return 's';
		} else if (var0 == 338) {
			return 'E';
		} else {
			return (char)(var0 == 339 ? 'e' : '\u0000');
		}
	}
}