import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("pv")
public class class406 {
	@ObfuscatedName("ak")
	int field3710;
	@ObfuscatedName("aj")
	int field3709;
	@ObfuscatedName("am")
	int field3711;
	@ObfuscatedName("aq")
	int field3712;
	@ObfuscatedName("ai")
	int field3708;
	@ObfuscatedName("aw")
	boolean field3705;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lpa;"
	)
	AbstractFont field3714;
	@ObfuscatedName("an")
	ArrayList field3713;
	@ObfuscatedName("ag")
	int field3707;
	@ObfuscatedName("ad")
	int field3706;

	public class406() {
		this.field3710 = Integer.MAX_VALUE;
		this.field3709 = Integer.MAX_VALUE;
		this.field3711 = 0;
		this.field3712 = 0;
		this.field3708 = 0;
		this.field3705 = true;
		this.field3713 = new ArrayList();
		this.field3707 = 0;
		this.field3706 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lpn;",
		garbageValue = "-1648887293"
	)
	public class408 method2051(int var1) {
		return (class408)this.field3713.get(var1);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Lpn;",
		garbageValue = "-1618780366"
	)
	class408 method2052() {
		return this.field3713.size() == 0 ? null : (class408)this.field3713.get(this.field3713.size() - 1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2001561937"
	)
	public boolean method2053() {
		return this.field3713.size() == 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-607330455"
	)
	boolean method2054() {
		return this.field3709 > 1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-917985217"
	)
	public int method2055() {
		return this.field3713.size();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1548157009"
	)
	public String method2056() {
		if (this.method2053()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2055());

			for (int var2 = 0; var2 < this.method2055(); ++var2) {
				class408 var3 = this.method2051(var2);
				var1.append(var3.field3716);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1319008258"
	)
	public void method2057(int var1) {
		if (this.field3714 != null && var1 < this.field3714.ascent * 2) {
			var1 = Integer.MAX_VALUE;
		}

		if (this.field3710 != var1) {
			this.field3710 = var1;
			this.method2086();
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1206229207"
	)
	public void method2059(int var1) {
		if (this.field3709 != var1) {
			this.field3709 = var1;
			this.method2086();
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2046388223"
	)
	public void method2060(int var1) {
		if (this.field3706 != var1) {
			this.field3706 = var1;
			this.method2086();
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lpa;B)V",
		garbageValue = "83"
	)
	public void method2061(AbstractFont var1) {
		if (var1 != this.field3714) {
			this.field3714 = var1;
			if (this.field3714 != null) {
				if (this.field3708 == 0) {
					this.field3708 = this.field3714.ascent;
				}

				if (!this.method2053()) {
					this.method2086();
				}
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1301835621"
	)
	public void method2062(int var1) {
		if (this.field3707 != var1) {
			this.field3707 = var1;
			this.method2086();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "203029050"
	)
	public boolean method2063(int var1, int var2) {
		if (this.field3711 != var1 || var2 != this.field3712) {
			this.field3711 = var1;
			this.field3712 = var2;
			this.method2086();
		}

		return true;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-36"
	)
	public void method2064(int var1) {
		if (this.field3708 != var1) {
			this.field3708 = var1;
			this.method2086();
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lpd;",
		garbageValue = "-125"
	)
	public class410 method2065(int var1, int var2) {
		if (var2 == var1) {
			return new class410(this, 0, 0);
		} else if (var1 <= this.field3713.size() && var2 <= this.field3713.size()) {
			return var2 < var1 ? new class410(this, var2, var1) : new class410(this, var1, var2);
		} else {
			return new class410(this, 0, 0);
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(CIIB)Lpx;",
		garbageValue = "51"
	)
	public class407 method2066(char var1, int var2, int var3) {
		return this.method2067(Character.toString(var1), var2, var3);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;III)Lpx;",
		garbageValue = "1271891096"
	)
	public class407 method2067(String var1, int var2, int var3) {
		if (var3 == 0) {
			var3 = Integer.MAX_VALUE;
		}

		int var4 = var2;
		if (this.field3713.size() >= var3) {
			this.method2087(var2, var2);
			return new class407(var2, true);
		} else {
			this.field3713.ensureCapacity(this.field3713.size() + var1.length());

			for (int var5 = 0; var5 < var1.length() && this.field3713.size() < var3; ++var5) {
				class408 var6 = new class408();
				var6.field3716 = var1.charAt(var5);
				this.field3713.add(var4, var6);
				++var4;
			}

			this.method2087(var2, var4);
			if (this.field3709 != 0 && this.method2078() > this.field3709) {
				while (var4 != var2) {
					--var4;
					this.method2071(var4);
					if (this.method2078() <= this.field3709) {
						break;
					}
				}

				return new class407(var4, true);
			} else {
				return new class407(var4, false);
			}
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)Lpx;",
		garbageValue = "-98"
	)
	class407 method2068(String var1, int var2) {
		return this.method2067(var1, this.field3713.size(), var2);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Lpx;",
		garbageValue = "-83"
	)
	public class407 method2069(String var1) {
		this.method2070();
		return this.method2068(var1, 0);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "95"
	)
	void method2070() {
		this.field3713.clear();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-620955221"
	)
	public int method2071(int var1) {
		return this.method2072(var1, var1 + 1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "58"
	)
	public int method2072(int var1, int var2) {
		int var3;
		if (var2 < var1) {
			var3 = var2;
			var2 = var1;
			var1 = var3;
		}

		this.field3713.subList(var1, var2).clear();
		var3 = var1;
		if (this.method2054() && this.field3707 == 1) {
			while (var3 > 0) {
				--var3;
				char var4 = ((class408)this.field3713.get(var3)).field3716;
				if (var4 == ' ' || var4 == '\t') {
					break;
				}
			}
		}

		this.method2087(var3, var2);
		return var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-769092328"
	)
	public int method2073(int var1, int var2) {
		if (this.field3714 == null) {
			return 0;
		} else if (this.method2054() && var1 > this.field3710) {
			return this.field3713.size();
		} else {
			if (!this.field3713.isEmpty()) {
				for (int var3 = 0; var3 < this.field3713.size(); ++var3) {
					class408 var4 = (class408)this.field3713.get(var3);
					if (var2 <= var4.field3718 + this.method2077()) {
						if (var2 < var4.field3718) {
							break;
						}

						if (var1 < var4.field3717) {
							return var3 > 0 ? var3 - 1 : 0;
						}

						if (1 + var3 != this.field3713.size() && ((class408)this.field3713.get(1 + var3)).field3718 != var4.field3718) {
							int var5 = this.method2089((class408)this.field3713.get(var3), false);
							if (var1 < var5 + var4.field3717) {
								return var3;
							}

							if (var2 <= var4.field3718 + this.method2077()) {
								return var3 + 1;
							}
						}
					}
				}

				class408 var6 = (class408)this.field3713.get(this.field3713.size() - 1);
				if (var1 >= var6.field3717 && var1 <= var6.field3717 + this.method2079() && var2 >= var6.field3718 && var2 <= var6.field3718 + this.method2077()) {
					return this.field3713.size() - 1;
				}
			}

			return this.field3713.size();
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "795729934"
	)
	public int method2074(int var1, int var2) {
		if (this.field3714 != null && !this.method2053() && var1 <= this.field3713.size()) {
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
				class408 var6 = (class408)this.field3713.get(var1 - 1);
				var4 = var6.field3717 + this.method2088(var1 - 1);
				var5 = var6.field3718;
			} else if (var3 == -1 && var1 == 0) {
				return 0;
			}

			int var14 = 16777215;
			int var7 = 0;
			int var8 = var1;
			int var9 = 16777215;
			int var10 = var3 == 1 ? this.field3713.size() + 1 : 0;

			for (int var11 = var3 + var1; var11 != var10; var11 += var3) {
				class408 var12 = (class408)this.field3713.get(var11 - 1);
				if (var5 != var12.field3718) {
					++var7;
					var5 = var12.field3718;
					if (var7 > var2) {
						return var8;
					}
				}

				if (var7 == var2) {
					int var13 = Math.abs(var12.field3717 + this.method2088(var11 - 1) - var4);
					if (var13 >= var9) {
						return var8;
					}

					var8 = var11;
					var9 = var13;
				}
			}

			if (var3 == 1) {
				return this.field3713.size();
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-612896858"
	)
	public int method2075() {
		if (!this.field3713.isEmpty() && this.method2078() == 1) {
			return this.field3713.isEmpty() ? 0 : ((class408)this.field3713.get(this.field3713.size() - 1)).field3717 + this.method2079();
		} else {
			int var1 = -1;
			int var2 = 0;

			for (int var3 = this.field3713.size() - 1; var3 >= 0; --var3) {
				class408 var4 = (class408)this.field3713.get(var3);
				if (var1 != var4.field3718) {
					int var5 = this.method2089(var4, false) + var4.field3717;
					var2 = Math.max(var5, var2);
					var1 = var4.field3718;
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "6"
	)
	public int method2076() {
		return this.method2053() ? 0 : this.field3714.ascent + ((class408)this.field3713.get(this.field3713.size() - 1)).field3718;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-593841574"
	)
	public int method2077() {
		return this.field3708;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "93"
	)
	public int method2078() {
		return this.method2076() / this.field3714.ascent;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-918826426"
	)
	int method2079() {
		return this.method2053() ? 0 : this.method2089((class408)this.field3713.get(this.field3713.size() - 1), false);
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-379034894"
	)
	public int method2080() {
		return this.field3710;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2096364291"
	)
	public int method2081() {
		return this.field3709;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1926453895"
	)
	public int method2082() {
		return this.field3707;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-163729135"
	)
	public int method2083() {
		return this.field3706;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1438354732"
	)
	public int method2084(int var1) {
		switch(this.field3711) {
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

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1172186374"
	)
	public int method2085(int var1) {
		switch(this.field3712) {
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
		descriptor = "(B)V",
		garbageValue = "0"
	)
	void method2086() {
		this.method2087(0, this.field3713.size());
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "605694861"
	)
	void method2087(int var1, int var2) {
		if (!this.method2053() && this.field3714 != null) {
			class497 var3 = this.method2090(var1, var2);
			boolean var4 = (Integer)var3.field4074 == 0 && (Integer)var3.field4073 == this.field3713.size();
			int var5 = (Integer)var3.field4074;
			int var6 = 0;
			int var7 = var4 ? 0 : ((class408)this.field3713.get((Integer)var3.field4074)).field3718;
			int var8 = 0;

			int var9;
			for (var9 = (Integer)var3.field4074; var9 <= (Integer)var3.field4073; ++var9) {
				boolean var10 = var9 >= this.field3713.size();
				class408 var11 = (class408)this.field3713.get(!var10 ? var9 : this.field3713.size() - 1);
				int var12 = !var10 ? this.method2089(var11, false) : 0;
				boolean var13 = !var10 && var11.field3716 == '\n';
				boolean var14 = !var10 && this.method2054() && var12 + var6 > this.field3710;
				if (var13 || var14 || var10) {
					int var15 = var9;
					int var16 = 0;
					int var17;
					int var18;
					class408 var19;
					if (var14) {
						var17 = 0;
						if (this.field3707 == 1) {
							for (var18 = var9; var18 > var5; --var18) {
								var19 = (class408)this.field3713.get(var18);
								var17 += var18 < var15 ? this.method2089(var19, false) : 0;
								if (var19.field3716 == ' ' || var19.field3716 == '\n') {
									var15 = var18;
									var6 -= var17;
									var16 = var17;
									break;
								}
							}
						}
					}

					var17 = -this.method2084(var6);

					for (var18 = var5; var18 < var15; ++var18) {
						var19 = (class408)this.field3713.get(var18);
						int var20 = this.method2089(var19, false);
						var19.field3717 = var17;
						var19.field3718 = var7;
						var17 += var20;
					}

					var5 = var15;
					var6 = var16;
					var7 += this.method2077();
					++var8;
				}

				var6 += !var10 ? var12 : 0;
			}

			if (this.field3712 != 0 && var4) {
				var9 = var8 * this.method2077();
				int var23 = this.method2085(var9);

				for (int var21 = 0; var21 < this.field3713.size(); ++var21) {
					class408 var22 = (class408)this.field3713.get(var21);
					var22.field3718 -= var23;
				}
			}

		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1124192376"
	)
	int method2088(int var1) {
		return var1 < this.field3713.size() ? this.method2089((class408)this.field3713.get(var1), false) : 0;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lpn;ZI)I",
		garbageValue = "2090126332"
	)
	int method2089(class408 var1, boolean var2) {
		if (var1.field3716 == '\n') {
			return 0;
		} else if (this.field3706 == 0) {
			int var3 = this.field3714.advances[var1.field3716];
			if (var3 == 0) {
				return var1.field3716 == '\t' ? this.field3714.advances[32] * 3 : this.field3714.advances[32];
			} else {
				return var3;
			}
		} else {
			return this.field3714.advances[42];
		}
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(III)Lti;",
		garbageValue = "-139251767"
	)
	class497 method2090(int var1, int var2) {
		int var3 = Math.min(var1, var2);
		int var4 = Math.max(var1, var2);
		int var5 = this.field3713.size();
		if (var3 == 0 && var4 == var5) {
			return new class497(0, var5);
		} else {
			int var6 = this.method2091(var3, false);
			int var7 = this.method2092(var4, false);
			int var8;
			switch(this.field3712) {
			case 0:
				if (this.field3711 == 0) {
					return new class497(var6, var5);
				}

				var8 = this.method2091(var3, true);
				return new class497(var8, var5);
			case 1:
				return new class497(0, var5);
			case 2:
				if (this.field3711 == 2) {
					return new class497(0, var7);
				}

				var8 = this.method2092(var4, true);
				return new class497(0, var8);
			default:
				return new class497(0, var5);
			}
		}
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(IZB)I",
		garbageValue = "-36"
	)
	int method2091(int var1, boolean var2) {
		if (var1 < this.field3713.size()) {
			int var3 = ((class408)this.field3713.get(var1)).field3718;

			for (int var4 = var1; var4 > 0; --var4) {
				if (((class408)this.field3713.get(var4 - 1)).field3718 < var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class408)this.field3713.get(var4 - 1)).field3718;
				}
			}
		}

		return 0;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1768880978"
	)
	int method2092(int var1, boolean var2) {
		if (var1 < this.field3713.size()) {
			int var3 = ((class408)this.field3713.get(var1)).field3718;

			for (int var4 = var1; var4 < this.field3713.size() - 1; ++var4) {
				if (((class408)this.field3713.get(var4 + 1)).field3718 > var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class408)this.field3713.get(var4 + 1)).field3718;
				}
			}
		}

		return this.field3713.size();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;ZI)V",
		garbageValue = "-180086044"
	)
	public static void method2058(AbstractArchive var0, AbstractArchive var1, boolean var2) {
		ObjectComposition.ObjectDefinition_archive = var0;
		ObjectComposition.ObjectDefinition_modelsArchive = var1;
		ObjectComposition.ObjectDefinition_isLowDetail = var2;
	}

	@ObfuscatedName("mi")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIB)V",
		garbageValue = "51"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (HealthBarDefinition.widgetDefinition.loadInterface(var0)) {
			AbstractWorldMapData.updateInterface(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}