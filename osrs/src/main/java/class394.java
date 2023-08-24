import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("pj")
public class class394 {
	@ObfuscatedName("ab")
	int field3669;
	@ObfuscatedName("ag")
	int field3670;
	@ObfuscatedName("am")
	int field3672;
	@ObfuscatedName("ax")
	int field3675;
	@ObfuscatedName("ah")
	int field3671;
	@ObfuscatedName("as")
	boolean field3668;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lpk;"
	)
	AbstractFont field3677;
	@ObfuscatedName("aj")
	ArrayList field3676;
	@ObfuscatedName("av")
	int field3673;
	@ObfuscatedName("aw")
	int field3674;

	public class394() {
		this.field3669 = Integer.MAX_VALUE;
		this.field3670 = Integer.MAX_VALUE;
		this.field3672 = 0;
		this.field3675 = 0;
		this.field3671 = 0;
		this.field3668 = true;
		this.field3676 = new ArrayList();
		this.field3673 = 0;
		this.field3674 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Lpz;",
		garbageValue = "425318611"
	)
	public class396 method2036(int var1) {
		return (class396)this.field3676.get(var1);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Lpz;",
		garbageValue = "1830163512"
	)
	class396 method2037() {
		return this.field3676.size() == 0 ? null : (class396)this.field3676.get(this.field3676.size() - 1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1992869018"
	)
	public boolean method2038() {
		return this.field3676.size() == 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-675218118"
	)
	boolean method2039() {
		return this.field3670 > 1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1688510031"
	)
	public int method2040() {
		return this.field3676.size();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "163147996"
	)
	public String method2041() {
		if (this.method2038()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2040());

			for (int var2 = 0; var2 < this.method2040(); ++var2) {
				class396 var3 = this.method2036(var2);
				var1.append(var3.field3680);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-32"
	)
	public void method2042(int var1) {
		if (this.field3677 != null && var1 < this.field3677.ascent * 2) {
			var1 = Integer.MAX_VALUE;
		}

		if (this.field3669 != var1) {
			this.field3669 = var1;
			this.method2071();
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1949241738"
	)
	public void method2043(int var1) {
		if (this.field3670 != var1) {
			this.field3670 = var1;
			this.method2071();
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-38"
	)
	public void method2044(int var1) {
		if (this.field3674 != var1) {
			this.field3674 = var1;
			this.method2071();
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(Lpk;I)V",
		garbageValue = "1103184746"
	)
	public void method2045(AbstractFont var1) {
		if (var1 != this.field3677) {
			this.field3677 = var1;
			if (this.field3677 != null) {
				if (this.field3671 == 0) {
					this.field3671 = this.field3677.ascent;
				}

				if (!this.method2038()) {
					this.method2071();
				}
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1772052418"
	)
	public void method2046(int var1) {
		if (this.field3673 != var1) {
			this.field3673 = var1;
			this.method2071();
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-1456021058"
	)
	public boolean method2047(int var1, int var2) {
		if (this.field3672 != var1 || var2 != this.field3675) {
			this.field3672 = var1;
			this.field3675 = var2;
			this.method2071();
		}

		return true;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1080029038"
	)
	public void method2048(int var1) {
		if (this.field3671 != var1) {
			this.field3671 = var1;
			this.method2071();
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(III)Lpl;",
		garbageValue = "-1114977482"
	)
	public class398 method2049(int var1, int var2) {
		if (var2 == var1) {
			return new class398(this, 0, 0);
		} else if (var1 <= this.field3676.size() && var2 <= this.field3676.size()) {
			return var2 < var1 ? new class398(this, var2, var1) : new class398(this, var1, var2);
		} else {
			return new class398(this, 0, 0);
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CIII)Lpu;",
		garbageValue = "-803390242"
	)
	public class395 method2050(char var1, int var2, int var3) {
		return this.method2051(Character.toString(var1), var2, var3);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;III)Lpu;",
		garbageValue = "-522015714"
	)
	public class395 method2051(String var1, int var2, int var3) {
		if (var3 == 0) {
			var3 = Integer.MAX_VALUE;
		}

		int var4 = var2;
		if (this.field3676.size() >= var3) {
			this.method2072(var2, var2);
			return new class395(var2, true);
		} else {
			this.field3676.ensureCapacity(this.field3676.size() + var1.length());

			for (int var5 = 0; var5 < var1.length() && this.field3676.size() < var3; ++var5) {
				class396 var6 = new class396();
				var6.field3680 = var1.charAt(var5);
				this.field3676.add(var4, var6);
				++var4;
			}

			this.method2072(var2, var4);
			if (this.field3670 != 0 && this.method2063() > this.field3670) {
				while (var4 != var2) {
					--var4;
					this.method2056(var4);
					if (this.method2063() <= this.field3670) {
						break;
					}
				}

				return new class395(var4, true);
			} else {
				return new class395(var4, false);
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)Lpu;",
		garbageValue = "-584459098"
	)
	class395 method2052(String var1, int var2) {
		return this.method2051(var1, this.field3676.size(), var2);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Lpu;",
		garbageValue = "67"
	)
	public class395 method2054(String var1) {
		this.method2055();
		return this.method2052(var1, 0);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1865432397"
	)
	void method2055() {
		this.field3676.clear();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "2"
	)
	public int method2056(int var1) {
		return this.method2057(var1, var1 + 1);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1605170962"
	)
	public int method2057(int var1, int var2) {
		int var3;
		if (var2 < var1) {
			var3 = var2;
			var2 = var1;
			var1 = var3;
		}

		this.field3676.subList(var1, var2).clear();
		var3 = var1;
		if (this.method2039() && this.field3673 == 1) {
			while (var3 > 0) {
				--var3;
				char var4 = ((class396)this.field3676.get(var3)).field3680;
				if (var4 == ' ' || var4 == '\t') {
					break;
				}
			}
		}

		this.method2072(var3, var2);
		return var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIS)I",
		garbageValue = "194"
	)
	public int method2058(int var1, int var2) {
		if (this.field3677 == null) {
			return 0;
		} else if (this.method2039() && var1 > this.field3669) {
			return this.field3676.size();
		} else {
			if (!this.field3676.isEmpty()) {
				for (int var3 = 0; var3 < this.field3676.size(); ++var3) {
					class396 var4 = (class396)this.field3676.get(var3);
					if (var2 <= var4.field3682 + this.method2062()) {
						if (var2 < var4.field3682) {
							break;
						}

						if (var1 < var4.field3681) {
							return var3 > 0 ? var3 - 1 : 0;
						}

						if (1 + var3 != this.field3676.size() && ((class396)this.field3676.get(1 + var3)).field3682 != var4.field3682) {
							int var5 = this.method2074((class396)this.field3676.get(var3), false);
							if (var1 < var5 + var4.field3681) {
								return var3;
							}

							if (var2 <= var4.field3682 + this.method2062()) {
								return var3 + 1;
							}
						}
					}
				}

				class396 var6 = (class396)this.field3676.get(this.field3676.size() - 1);
				if (var1 >= var6.field3681 && var1 <= var6.field3681 + this.method2064() && var2 >= var6.field3682 && var2 <= var6.field3682 + this.method2062()) {
					return this.field3676.size() - 1;
				}
			}

			return this.field3676.size();
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIS)I",
		garbageValue = "139"
	)
	public int method2059(int var1, int var2) {
		if (this.field3677 != null && !this.method2038() && var1 <= this.field3676.size()) {
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
				class396 var6 = (class396)this.field3676.get(var1 - 1);
				var4 = var6.field3681 + this.method2073(var1 - 1);
				var5 = var6.field3682;
			} else if (var3 == -1 && var1 == 0) {
				return 0;
			}

			int var14 = 16777215;
			int var7 = 0;
			int var8 = var1;
			int var9 = 16777215;
			int var10 = var3 == 1 ? this.field3676.size() + 1 : 0;

			for (int var11 = var3 + var1; var10 != var11; var11 += var3) {
				class396 var12 = (class396)this.field3676.get(var11 - 1);
				if (var5 != var12.field3682) {
					++var7;
					var5 = var12.field3682;
					if (var7 > var2) {
						return var8;
					}
				}

				if (var7 == var2) {
					int var13 = Math.abs(var12.field3681 + this.method2073(var11 - 1) - var4);
					if (var13 >= var9) {
						return var8;
					}

					var8 = var11;
					var9 = var13;
				}
			}

			if (var3 == 1) {
				return this.field3676.size();
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-540646519"
	)
	public int method2060() {
		if (!this.field3676.isEmpty() && this.method2063() == 1) {
			return this.field3676.isEmpty() ? 0 : ((class396)this.field3676.get(this.field3676.size() - 1)).field3681 + this.method2064();
		} else {
			int var1 = -1;
			int var2 = 0;

			for (int var3 = this.field3676.size() - 1; var3 >= 0; --var3) {
				class396 var4 = (class396)this.field3676.get(var3);
				if (var1 != var4.field3682) {
					int var5 = this.method2074(var4, false) + var4.field3681;
					var2 = Math.max(var5, var2);
					var1 = var4.field3682;
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "872153542"
	)
	public int method2061() {
		return this.method2038() ? 0 : this.field3677.ascent + ((class396)this.field3676.get(this.field3676.size() - 1)).field3682;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1220139043"
	)
	public int method2062() {
		return this.field3671;
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "106"
	)
	public int method2063() {
		return this.method2061() / this.field3677.ascent;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1975027491"
	)
	int method2064() {
		return this.method2038() ? 0 : this.method2074((class396)this.field3676.get(this.field3676.size() - 1), false);
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "103"
	)
	public int method2065() {
		return this.field3669;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2030708038"
	)
	public int method2066() {
		return this.field3670;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "106"
	)
	public int method2067() {
		return this.field3673;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "326799918"
	)
	public int method2068() {
		return this.field3674;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "0"
	)
	public int method2069(int var1) {
		switch(this.field3672) {
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

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "59"
	)
	public int method2070(int var1) {
		switch(this.field3675) {
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

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2042432438"
	)
	void method2071() {
		this.method2072(0, this.field3676.size());
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2146351228"
	)
	void method2072(int var1, int var2) {
		if (!this.method2038() && this.field3677 != null) {
			class485 var3 = this.method2075(var1, var2);
			boolean var4 = (Integer)var3.field4049 == 0 && (Integer)var3.field4048 == this.field3676.size();
			int var5 = (Integer)var3.field4049;
			int var6 = 0;
			int var7 = var4 ? 0 : ((class396)this.field3676.get((Integer)var3.field4049)).field3682 * 778585567 * -122833377;
			int var8 = 0;

			int var9;
			for (var9 = (Integer)var3.field4049; var9 <= (Integer)var3.field4048; ++var9) {
				boolean var10 = var9 >= this.field3676.size();
				class396 var11 = (class396)this.field3676.get(!var10 ? var9 : this.field3676.size() - 1);
				int var12 = !var10 ? this.method2074(var11, false) : 0;
				boolean var13 = !var10 && var11.field3680 == '\n';
				boolean var14 = !var10 && this.method2039() && var12 + var6 > this.field3669;
				if (var13 || var14 || var10) {
					int var15 = var9;
					int var16 = 0;
					int var17;
					int var18;
					class396 var19;
					if (var14) {
						var17 = 0;
						if (this.field3673 == 1) {
							for (var18 = var9; var18 > var5; --var18) {
								var19 = (class396)this.field3676.get(var18);
								var17 += var18 < var15 ? this.method2074(var19, false) : 0;
								if (var19.field3680 == ' ' || var19.field3680 == '\n') {
									var15 = var18;
									var6 -= var17;
									var16 = var17;
									break;
								}
							}
						}
					}

					var17 = -this.method2069(var6);

					for (var18 = var5; var18 < var15; ++var18) {
						var19 = (class396)this.field3676.get(var18);
						int var20 = this.method2074(var19, false);
						var19.field3681 = var17;
						var19.field3682 = var7;
						var17 += var20;
					}

					var5 = var15;
					var6 = var16;
					var7 += this.method2062();
					++var8;
				}

				var6 += !var10 ? var12 : 0;
			}

			if (this.field3675 != 0 && var4) {
				var9 = var8 * this.method2062();
				int var23 = this.method2070(var9);

				for (int var21 = 0; var21 < this.field3676.size(); ++var21) {
					class396 var22 = (class396)this.field3676.get(var21);
					var22.field3682 -= var23;
				}
			}

		}
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "369306860"
	)
	int method2073(int var1) {
		return var1 < this.field3676.size() ? this.method2074((class396)this.field3676.get(var1), false) : 0;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(Lpz;ZI)I",
		garbageValue = "1524622539"
	)
	int method2074(class396 var1, boolean var2) {
		if (var1.field3680 == '\n') {
			return 0;
		} else if (this.field3674 == 0) {
			int var3 = this.field3677.advances[var1.field3680];
			if (var3 == 0) {
				return var1.field3680 == '\t' ? this.field3677.advances[32] * 3 : this.field3677.advances[32];
			} else {
				return var3;
			}
		} else {
			return this.field3677.advances[42];
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lss;",
		garbageValue = "0"
	)
	class485 method2075(int var1, int var2) {
		int var3 = Math.min(var1, var2);
		int var4 = Math.max(var1, var2);
		int var5 = this.field3676.size();
		if (var3 == 0 && var4 == var5) {
			return new class485(0, var5);
		} else {
			int var6 = this.method2076(var3, false);
			int var7 = this.method2077(var4, false);
			int var8;
			switch(this.field3675) {
			case 0:
				if (this.field3672 == 0) {
					return new class485(var6, var5);
				}

				var8 = this.method2076(var3, true);
				return new class485(var8, var5);
			case 1:
				return new class485(0, var5);
			case 2:
				if (this.field3672 == 2) {
					return new class485(0, var7);
				}

				var8 = this.method2077(var4, true);
				return new class485(0, var8);
			default:
				return new class485(0, var5);
			}
		}
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1605508090"
	)
	int method2076(int var1, boolean var2) {
		if (var1 < this.field3676.size()) {
			int var3 = ((class396)this.field3676.get(var1)).field3682;

			for (int var4 = var1; var4 > 0; --var4) {
				if (((class396)this.field3676.get(var4 - 1)).field3682 < var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class396)this.field3676.get(var4 - 1)).field3682;
				}
			}
		}

		return 0;
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "1892979097"
	)
	int method2077(int var1, boolean var2) {
		if (var1 < this.field3676.size()) {
			int var3 = ((class396)this.field3676.get(var1)).field3682;

			for (int var4 = var1; var4 < this.field3676.size() - 1; ++var4) {
				if (((class396)this.field3676.get(var4 + 1)).field3682 > var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class396)this.field3676.get(var4 + 1)).field3682;
				}
			}
		}

		return this.field3676.size();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1123926703"
	)
	public static void method2053() {
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
	}
}