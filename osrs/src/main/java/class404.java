import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.*;

@ObfuscatedName("ps")
public class class404 extends AbstractQueue {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lpw;"
	)
	class402[] field3703;
	@ObfuscatedName("ah")
	Map field3702;
	@ObfuscatedName("ar")
	int field3701;
	@ObfuscatedName("ao")
	final Comparator field3704;
	@ObfuscatedName("ab")
	int field3700;

	public class404(int var1, Comparator var2) {
		this.field3700 = 0;
		this.field3703 = new class402[var1];
		this.field3702 = new HashMap();
		this.field3704 = var2;
	}

	public class404(int var1) {
		this(var1, (Comparator)null);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1191377810"
	)
	void method2046() {
		int var1 = (this.field3703.length << 1) + 1;
		this.field3703 = (class402[])((class402[])Arrays.copyOf(this.field3703, var1));
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1996732562"
	)
	void method2047(int var1) {
		class402 var2;
		int var3;
		for (var2 = this.field3703[var1]; var1 > 0; var1 = var3) {
			var3 = var1 - 1 >>> 1;
			class402 var4 = this.field3703[var3];
			if (this.field3704 != null) {
				if (this.field3704.compare(var2.field3696, var4.field3696) >= 0) {
					break;
				}
			} else if (((Comparable)var2.field3696).compareTo(var4.field3696) >= 0) {
				break;
			}

			this.field3703[var1] = var4;
			this.field3703[var1].field3695 = var1;
		}

		this.field3703[var1] = var2;
		this.field3703[var1].field3695 = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-500854691"
	)
	void method2048(int var1) {
		class402 var2 = this.field3703[var1];

		int var8;
		for (int var3 = this.field3701 >>> 1; var1 < var3; var1 = var8) {
			int var4 = (var1 << 1) + 1;
			class402 var5 = this.field3703[var4];
			int var6 = (var1 << 1) + 2;
			class402 var7 = this.field3703[var6];
			if (this.field3704 != null) {
				if (var6 < this.field3701 && this.field3704.compare(var5.field3696, var7.field3696) > 0) {
					var8 = var6;
				} else {
					var8 = var4;
				}
			} else if (var6 < this.field3701 && ((Comparable)var5.field3696).compareTo(var7.field3696) > 0) {
				var8 = var6;
			} else {
				var8 = var4;
			}

			if (this.field3704 != null) {
				if (this.field3704.compare(var2.field3696, this.field3703[var8].field3696) <= 0) {
					break;
				}
			} else if (((Comparable)var2.field3696).compareTo(this.field3703[var8].field3696) <= 0) {
				break;
			}

			this.field3703[var1] = this.field3703[var8];
			this.field3703[var1].field3695 = var1;
		}

		this.field3703[var1] = var2;
		this.field3703[var1].field3695 = var1;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public boolean remove(Object var1) {
		class402 var2 = (class402)this.field3702.remove(var1);
		if (var2 == null) {
			return false;
		} else {
			++this.field3700;
			--this.field3701;
			if (this.field3701 == var2.field3695) {
				this.field3703[this.field3701] = null;
				return true;
			} else {
				class402 var3 = this.field3703[this.field3701];
				this.field3703[this.field3701] = null;
				this.field3703[var2.field3695] = var3;
				this.field3703[var2.field3695].field3695 = var2.field3695;
				this.method2048(var2.field3695);
				if (var3 == this.field3703[var2.field3695]) {
					this.method2047(var2.field3695);
				}

				return true;
			}
		}
	}

	@Export("peek")
	@ObfuscatedName("peek")
	public Object peek() {
		return this.field3701 == 0 ? null : this.field3703[0].field3696;
	}

	@Export("size")
	@ObfuscatedName("size")
	public int size() {
		return this.field3701;
	}

	@Export("offer")
	@ObfuscatedName("offer")
	public boolean offer(Object var1) {
		if (this.field3702.containsKey(var1)) {
			//throw new IllegalArgumentException("");
		} else {
			++this.field3700;
			int var2 = this.field3701;
			if (var2 >= this.field3703.length) {
				this.method2046();
			}

			++this.field3701;
			if (var2 == 0) {
				this.field3703[0] = new class402(var1, 0);
				this.field3702.put(var1, this.field3703[0]);
			} else {
				this.field3703[var2] = new class402(var1, var2);
				this.field3702.put(var1, this.field3703[var2]);
				this.method2047(var2);
			}

			return true;
		}
		return true;

	}

	@Export("poll")
	@ObfuscatedName("poll")
	public Object poll() {
		if (this.field3701 == 0) {
			return null;
		} else {
			++this.field3700;
			Object var1 = this.field3703[0].field3696;
			this.field3702.remove(var1);
			--this.field3701;
			if (this.field3701 == 0) {
				this.field3703[this.field3701] = null;
			} else {
				this.field3703[0] = this.field3703[this.field3701];
				this.field3703[0].field3695 = 0;
				this.field3703[this.field3701] = null;
				this.method2048(0);
			}

			return var1;
		}
	}

	@Export("contains")
	@ObfuscatedName("contains")
	public boolean contains(Object var1) {
		return this.field3702.containsKey(var1);
	}

	@Export("toArray")
	@ObfuscatedName("toArray")
	public Object[] toArray() {
		Object[] var1 = super.toArray();
		if (this.field3704 != null) {
			Arrays.sort(var1, this.field3704);
		} else {
			Arrays.sort(var1);
		}

		return var1;
	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return new class403(this);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FB)F",
		garbageValue = "0"
	)
	static float method2045(class131 var0, float var1) {
		if (var0 != null && var0.method722() != 0) {
			if (var1 < (float)var0.field1258[0].field1217) {
				return var0.field1257 == class129.field1244 ? var0.field1258[0].field1213 : Decimator.method321(var0, var1, true);
			} else if (var1 > (float)var0.field1258[var0.method722() - 1].field1217) {
				return var0.field1256 == class129.field1244 ? var0.field1258[var0.method722() - 1].field1213 : Decimator.method321(var0, var1, false);
			} else if (var0.field1252) {
				return var0.field1258[0].field1213;
			} else {
				class126 var2 = var0.method721(var1);
				boolean var3 = false;
				boolean var4 = false;
				if (var2 == null) {
					return 0.0F;
				} else {
					float var5;
					float var6;
					float var7;
					if ((double)var2.field1212 == 0.0D && (double)var2.field1216 == 0.0D) {
						var3 = true;
					} else if (var2.field1212 == Float.MAX_VALUE && Float.MAX_VALUE == var2.field1216) {
						var4 = true;
					} else if (var2.field1211 != null) {
						if (var0.field1253) {
							var5 = (float)var2.field1217;
							float var9 = var2.field1213;
							var6 = var5 + var2.field1212 * 0.33333334F;
							float var10 = 0.33333334F * var2.field1216 + var9;
							float var8 = (float)var2.field1211.field1217;
							float var12 = var2.field1211.field1213;
							var7 = var8 - var2.field1211.field1215 * 0.33333334F;
							float var11 = var12 - 0.33333334F * var2.field1211.field1214;
							if (var0.field1254) {
								Language.method1997(var0, var5, var6, var7, var8, var9, var10, var11, var12);
							} else if (var0 != null) {
								var0.field1259 = var5;
								float var13 = var8 - var5;
								float var14 = var12 - var9;
								float var15 = var6 - var5;
								float var16 = 0.0F;
								float var17 = 0.0F;
								if ((double)var15 != 0.0D) {
									var16 = (var10 - var9) / var15;
								}

								var15 = var8 - var7;
								if (0.0D != (double)var15) {
									var17 = (var12 - var11) / var15;
								}

								float var18 = 1.0F / (var13 * var13);
								float var19 = var16 * var13;
								float var20 = var13 * var17;
								var0.field1263 = (var20 + var19 - var14 - var14) * var18 / var13;
								var0.field1270 = var18 * (var14 + var14 + var14 - var19 - var19 - var20);
								var0.field1265 = var16;
								var0.field1267 = var9;
							}

							var0.field1253 = false;
						}
					} else {
						var3 = true;
					}

					if (var3) {
						return var2.field1213;
					} else if (var4) {
						return (float)var2.field1217 != var1 && var2.field1211 != null ? var2.field1211.field1213 : var2.field1213;
					} else if (var0.field1254) {
						if (var0 == null) {
							var5 = 0.0F;
						} else {
							if (var0.field1259 == var1) {
								var6 = 0.0F;
							} else if (var0.field1260 == var1) {
								var6 = 1.0F;
							} else {
								var6 = (var1 - var0.field1259) / (var0.field1260 - var0.field1259);
							}

							if (var0.field1255) {
								var7 = var6;
							} else {
								class127.field1221[3] = var0.field1267;
								class127.field1221[2] = var0.field1265;
								class127.field1221[1] = var0.field1270;
								class127.field1221[0] = var0.field1263 - var6;
								class127.field1220[0] = 0.0F;
								class127.field1220[1] = 0.0F;
								class127.field1220[2] = 0.0F;
								class127.field1220[3] = 0.0F;
								class127.field1220[4] = 0.0F;
								int var21 = FloorUnderlayDefinition.method967(class127.field1221, 3, 0.0F, true, 1.0F, true, class127.field1220);
								if (var21 == 1) {
									var7 = class127.field1220[0];
								} else {
									var7 = 0.0F;
								}
							}

							var5 = var7 * (var0.field1266 + (var0.field1269 + var0.field1262 * var7) * var7) + var0.field1268;
						}

						return var5;
					} else {
						if (var0 == null) {
							var5 = 0.0F;
						} else {
							var6 = var1 - var0.field1259;
							var5 = var0.field1267 + var6 * (var6 * (var0.field1270 + var6 * var0.field1263) + var0.field1265);
						}

						return var5;
					}
				}
			}
		} else {
			return 0.0F;
		}
	}
}