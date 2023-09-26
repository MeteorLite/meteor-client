import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("pp")
public class class409 {
	@ObfuscatedName("aj")
	int field3705;
	@ObfuscatedName("an")
	int field3706;
	@ObfuscatedName("au")
	int field3708;
	@ObfuscatedName("ai")
	int field3704;
	@ObfuscatedName("ae")
	int field3702;
	@ObfuscatedName("aw")
	boolean field3701;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lpk;"
	)
	AbstractFont field3710;
	@ObfuscatedName("az")
	ArrayList field3709;
	@ObfuscatedName("at")
	int field3707;
	@ObfuscatedName("af")
	int field3703;

	public class409() {
		this.field3705 = Integer.MAX_VALUE;
		this.field3706 = Integer.MAX_VALUE;
		this.field3708 = 0;
		this.field3704 = 0;
		this.field3702 = 0;
		this.field3701 = true;
		this.field3709 = new ArrayList();
		this.field3707 = 0;
		this.field3703 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lpe;",
		garbageValue = "391282708"
	)
	public class411 method2065(int var1) {
		return (class411)this.field3709.get(var1);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Lpe;",
		garbageValue = "-2102583593"
	)
	class411 method2066() {
		return this.field3709.size() == 0 ? null : (class411)this.field3709.get(this.field3709.size() - 1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-15"
	)
	public boolean method2067() {
		return this.field3709.size() == 0;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-122"
	)
	boolean method2068() {
		return this.field3706 > 1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1628091187"
	)
	public int method2069() {
		return this.field3709.size();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	public String method2070() {
		if (this.method2067()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2069());

			for (int var2 = 0; var2 < this.method2069(); ++var2) {
				class411 var3 = this.method2065(var2);
				var1.append(var3.field3713);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1556362413"
	)
	public void method2071(int var1) {
		if (this.field3710 != null && var1 < this.field3710.ascent * 2) {
			var1 = Integer.MAX_VALUE;
		}

		if (this.field3705 != var1) {
			this.field3705 = var1;
			this.method2099();
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "36"
	)
	public void method2072(int var1) {
		if (this.field3706 != var1) {
			this.field3706 = var1;
			this.method2099();
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1148190983"
	)
	public void method2073(int var1) {
		if (this.field3703 != var1) {
			this.field3703 = var1;
			this.method2099();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lpk;I)V",
		garbageValue = "1676896473"
	)
	public void method2074(AbstractFont var1) {
		if (var1 != this.field3710) {
			this.field3710 = var1;
			if (this.field3710 != null) {
				if (this.field3702 == 0) {
					this.field3702 = this.field3710.ascent;
				}

				if (!this.method2067()) {
					this.method2099();
				}
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "903704871"
	)
	public void method2075(int var1) {
		if (this.field3707 != var1) {
			this.field3707 = var1;
			this.method2099();
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "2058162248"
	)
	public boolean method2076(int var1, int var2) {
		if (this.field3708 != var1 || var2 != this.field3704) {
			this.field3708 = var1;
			this.field3704 = var2;
			this.method2099();
		}

		return true;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1814750102"
	)
	public void method2077(int var1) {
		if (this.field3702 != var1) {
			this.field3702 = var1;
			this.method2099();
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(III)Lpr;",
		garbageValue = "1762179013"
	)
	public class413 method2078(int var1, int var2) {
		if (var2 == var1) {
			return new class413(this, 0, 0);
		} else if (var1 <= this.field3709.size() && var2 <= this.field3709.size()) {
			return var2 < var1 ? new class413(this, var2, var1) : new class413(this, var1, var2);
		} else {
			return new class413(this, 0, 0);
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(CIIS)Lpb;",
		garbageValue = "7902"
	)
	public class410 method2079(char var1, int var2, int var3) {
		return this.method2080(Character.toString(var1), var2, var3);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IIB)Lpb;",
		garbageValue = "-45"
	)
	public class410 method2080(String var1, int var2, int var3) {
		if (var3 == 0) {
			var3 = Integer.MAX_VALUE;
		}

		int var4 = var2;
		if (this.field3709.size() >= var3) {
			this.method2100(var2, var2);
			return new class410(var2, true);
		} else {
			this.field3709.ensureCapacity(this.field3709.size() + var1.length());

			for (int var5 = 0; var5 < var1.length() && this.field3709.size() < var3; ++var5) {
				class411 var6 = new class411();
				var6.field3713 = var1.charAt(var5);
				this.field3709.add(var4, var6);
				++var4;
			}

			this.method2100(var2, var4);
			if (this.field3706 != 0 && this.method2091() > this.field3706) {
				while (var4 != var2) {
					--var4;
					this.method2084(var4);
					if (this.method2091() <= this.field3706) {
						break;
					}
				}

				return new class410(var4, true);
			} else {
				return new class410(var4, false);
			}
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)Lpb;",
		garbageValue = "-2106167498"
	)
	class410 method2081(String var1, int var2) {
		return this.method2080(var1, this.field3709.size(), var2);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Lpb;",
		garbageValue = "-2022964950"
	)
	public class410 method2082(String var1) {
		this.method2083();
		return this.method2081(var1, 0);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-14773"
	)
	void method2083() {
		this.field3709.clear();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "398036956"
	)
	public int method2084(int var1) {
		return this.method2085(var1, var1 + 1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "895943109"
	)
	public int method2085(int var1, int var2) {
		int var3;
		if (var2 < var1) {
			var3 = var2;
			var2 = var1;
			var1 = var3;
		}

		this.field3709.subList(var1, var2).clear();
		var3 = var1;
		if (this.method2068() && this.field3707 == 1) {
			while (var3 > 0) {
				--var3;
				char var4 = ((class411)this.field3709.get(var3)).field3713;
				if (var4 == ' ' || var4 == '\t') {
					break;
				}
			}
		}

		this.method2100(var3, var2);
		return var1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1582951780"
	)
	public int method2086(int var1, int var2) {
		if (this.field3710 == null) {
			return 0;
		} else if (this.method2068() && var1 > this.field3705) {
			return this.field3709.size();
		} else {
			if (!this.field3709.isEmpty()) {
				for (int var3 = 0; var3 < this.field3709.size(); ++var3) {
					class411 var4 = (class411)this.field3709.get(var3);
					if (var2 <= var4.field3714 + this.method2090()) {
						if (var2 < var4.field3714) {
							break;
						}

						if (var1 < var4.field3715) {
							return var3 > 0 ? var3 - 1 : 0;
						}

						if (1 + var3 != this.field3709.size() && ((class411)this.field3709.get(var3 + 1)).field3714 != var4.field3714) {
							int var5 = this.method2102((class411)this.field3709.get(var3), false);
							if (var1 < var5 + var4.field3715) {
								return var3;
							}

							if (var2 <= var4.field3714 + this.method2090()) {
								return var3 + 1;
							}
						}
					}
				}

				class411 var6 = (class411)this.field3709.get(this.field3709.size() - 1);
				if (var1 >= var6.field3715 && var1 <= var6.field3715 + this.method2092() && var2 >= var6.field3714 && var2 <= var6.field3714 + this.method2090()) {
					return this.field3709.size() - 1;
				}
			}

			return this.field3709.size();
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1702844331"
	)
	public int method2087(int var1, int var2) {
		if (this.field3710 != null && !this.method2067() && var1 <= this.field3709.size()) {
			byte var3;
			if (var2 > 0) {
				var3 = 1;
			} else {
				var3 = -1;
				var2 = -var2;
			}

			int var4 = 0;
			int var5 = 0;
			if (var1 > 0) {
				class411 var6 = (class411)this.field3709.get(var1 - 1);
				var4 = var6.field3715 + this.method2101(var1 - 1);
				var5 = var6.field3714;
			} else if (var3 == -1 && var1 == 0) {
				return 0;
			}

			int var14 = 16777215;
			int var7 = 0;
			int var8 = var1;
			int var9 = 16777215;
			int var10 = var3 == 1 ? this.field3709.size() + 1 : 0;

			for (int var11 = var3 + var1; var10 != var11; var11 += var3) {
				class411 var12 = (class411)this.field3709.get(var11 - 1);
				if (var5 != var12.field3714) {
					++var7;
					var5 = var12.field3714;
					if (var7 > var2) {
						return var8;
					}
				}

				if (var7 == var2) {
					int var13 = Math.abs(var12.field3715 + this.method2101(var11 - 1) - var4);
					if (var13 >= var9) {
						return var8;
					}

					var8 = var11;
					var9 = var13;
				}
			}

			if (var3 == 1) {
				return this.field3709.size();
			} else {
				if (var5 != 0) {
					++var7;
				}

				return var9 == 16777215 || var7 == var2 && var4 < var9 ? 0 : var8;
			}
		} else {
			return 0;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-512196245"
	)
	public int method2088() {
		if (!this.field3709.isEmpty() && this.method2091() == 1) {
			return this.field3709.isEmpty() ? 0 : ((class411)this.field3709.get(this.field3709.size() - 1)).field3715 + this.method2092();
		} else {
			int var1 = -1;
			int var2 = 0;

			for (int var3 = this.field3709.size() - 1; var3 >= 0; --var3) {
				class411 var4 = (class411)this.field3709.get(var3);
				if (var1 != var4.field3714) {
					int var5 = this.method2102(var4, false) + var4.field3715;
					var2 = Math.max(var5, var2);
					var1 = var4.field3714;
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "67"
	)
	public int method2089() {
		return this.method2067() ? 0 : this.field3710.ascent + ((class411)this.field3709.get(this.field3709.size() - 1)).field3714;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-51"
	)
	public int method2090() {
		return this.field3702;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "458527670"
	)
	public int method2091() {
		return this.method2089() / this.field3710.ascent;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-317463978"
	)
	int method2092() {
		return this.method2067() ? 0 : this.method2102((class411)this.field3709.get(this.field3709.size() - 1), false);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "4"
	)
	public int method2093() {
		return this.field3705;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-59557509"
	)
	public int method2094() {
		return this.field3706;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1977390124"
	)
	public int method2095() {
		return this.field3707;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "13"
	)
	public int method2096() {
		return this.field3703;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1372497203"
	)
	public int method2097(int var1) {
		switch(this.field3708) {
		case 0:
			return 0;
		case 1:
			return var1 / 2;
		case 2:
			return var1;
		default:
			return 0;
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1982314148"
	)
	public int method2098(int var1) {
		switch(this.field3704) {
		case 0:
			return 0;
		case 1:
			return var1 / 2;
		case 2:
			return var1;
		default:
			return 0;
		}
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2112190855"
	)
	void method2099() {
		this.method2100(0, this.field3709.size());
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-2040581189"
	)
	void method2100(int var1, int var2) {
		if (!this.method2067() && this.field3710 != null) {
			class500 var3 = this.method2103(var1, var2);
			boolean var4 = (Integer)var3.field4079 == 0 && (Integer)var3.field4080 == this.field3709.size();
			int var5 = (Integer)var3.field4079;
			int var6 = 0;
			int var7 = var4 ? 0 : ((class411)this.field3709.get((Integer)var3.field4079)).field3714 * 1441776133 * 402832077;
			int var8 = 0;

			int var9;
			for (var9 = (Integer)var3.field4079; var9 <= (Integer)var3.field4080; ++var9) {
				boolean var10 = var9 >= this.field3709.size();
				class411 var11 = (class411)this.field3709.get(!var10 ? var9 : this.field3709.size() - 1);
				int var12 = !var10 ? this.method2102(var11, false) : 0;
				boolean var13 = !var10 && var11.field3713 == '\n';
				boolean var14 = !var10 && this.method2068() && var12 + var6 > this.field3705;
				if (var13 || var14 || var10) {
					int var15 = var9;
					int var16 = 0;
					int var17;
					int var18;
					class411 var19;
					if (var14) {
						var17 = 0;
						if (this.field3707 == 1) {
							for (var18 = var9; var18 > var5; --var18) {
								var19 = (class411)this.field3709.get(var18);
								var17 += var18 < var15 ? this.method2102(var19, false) : 0;
								if (var19.field3713 == ' ' || var19.field3713 == '\n') {
									var15 = var18;
									var6 -= var17;
									var16 = var17;
									break;
								}
							}
						}
					}

					var17 = -this.method2097(var6);

					for (var18 = var5; var18 < var15; ++var18) {
						var19 = (class411)this.field3709.get(var18);
						int var20 = this.method2102(var19, false);
						var19.field3715 = var17;
						var19.field3714 = var7;
						var17 += var20;
					}

					var5 = var15;
					var6 = var16;
					var7 += this.method2090();
					++var8;
				}

				var6 += !var10 ? var12 : 0;
			}

			if (this.field3704 != 0 && var4) {
				var9 = var8 * this.method2090();
				int var23 = this.method2098(var9);

				for (int var21 = 0; var21 < this.field3709.size(); ++var21) {
					class411 var22 = (class411)this.field3709.get(var21);
					var22.field3714 -= var23;
				}
			}

		}
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1039874623"
	)
	int method2101(int var1) {
		return var1 < this.field3709.size() ? this.method2102((class411)this.field3709.get(var1), false) : 0;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Lpe;ZI)I",
		garbageValue = "1478006177"
	)
	int method2102(class411 var1, boolean var2) {
		if (var1.field3713 == '\n') {
			return 0;
		} else if (this.field3703 == 0) {
			int var3 = this.field3710.advances[var1.field3713];
			if (var3 == 0) {
				return var1.field3713 == '\t' ? this.field3710.advances[32] * 3 : this.field3710.advances[32];
			} else {
				return var3;
			}
		} else {
			return this.field3710.advances[42];
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(IIB)Ltw;",
		garbageValue = "26"
	)
	class500 method2103(int var1, int var2) {
		int var3 = Math.min(var1, var2);
		int var4 = Math.max(var1, var2);
		int var5 = this.field3709.size();
		if (var3 == 0 && var4 == var5) {
			return new class500(0, var5);
		} else {
			int var6 = this.method2104(var3, false);
			int var7 = this.method2105(var4, false);
			int var8;
			switch(this.field3704) {
			case 0:
				if (this.field3708 == 0) {
					return new class500(var6, var5);
				}

				var8 = this.method2104(var3, true);
				return new class500(var8, var5);
			case 1:
				return new class500(0, var5);
			case 2:
				if (this.field3708 == 2) {
					return new class500(0, var7);
				}

				var8 = this.method2105(var4, true);
				return new class500(0, var8);
			default:
				return new class500(0, var5);
			}
		}
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(IZS)I",
		garbageValue = "-9654"
	)
	int method2104(int var1, boolean var2) {
		if (var1 < this.field3709.size()) {
			int var3 = ((class411)this.field3709.get(var1)).field3714;

			for (int var4 = var1; var4 > 0; --var4) {
				if (((class411)this.field3709.get(var4 - 1)).field3714 < var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class411)this.field3709.get(var4 - 1)).field3714;
				}
			}
		}

		return 0;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1749016193"
	)
	int method2105(int var1, boolean var2) {
		if (var1 < this.field3709.size()) {
			int var3 = ((class411)this.field3709.get(var1)).field3714;

			for (int var4 = var1; var4 < this.field3709.size() - 1; ++var4) {
				if (((class411)this.field3709.get(var4 + 1)).field3714 > var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class411)this.field3709.get(var4 + 1)).field3714;
				}
			}
		}

		return this.field3709.size();
	}

	@ObfuscatedName("ov")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-11"
	)
	static void method2106(int var0) {
		if (var0 != Client.loginState) {
			Client.loginState = var0;
		}
	}
}