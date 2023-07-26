import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pt")
public class class395 {
	@ObfuscatedName("au")
	int field3667;
	@ObfuscatedName("ae")
	int field3663;
	@ObfuscatedName("ab")
	int field3661;
	@ObfuscatedName("ad")
	int field3662;
	@ObfuscatedName("ao")
	int field3666;
	@ObfuscatedName("ac")
	boolean field3660;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lpq;"
	)
	AbstractFont field3669;
	@ObfuscatedName("an")
	ArrayList field3668;
	@ObfuscatedName("af")
	int field3664;
	@ObfuscatedName("ai")
	int field3665;

	public class395() {
		this.field3667 = Integer.MAX_VALUE;
		this.field3663 = Integer.MAX_VALUE;
		this.field3661 = 0;
		this.field3662 = 0;
		this.field3666 = 0;
		this.field3660 = true;
		this.field3668 = new ArrayList();
		this.field3664 = 0;
		this.field3665 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lpz;",
		garbageValue = "-1921326690"
	)
	public class397 method1995(int var1) {
		return (class397)this.field3668.get(var1);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)Lpz;",
		garbageValue = "5"
	)
	class397 method1996() {
		return this.field3668.size() == 0 ? null : (class397)this.field3668.get(this.field3668.size() - 1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1788834683"
	)
	public boolean method1997() {
		return this.field3668.size() == 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-45616913"
	)
	boolean method1998() {
		return this.field3663 > 1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-520333390"
	)
	public int method1999() {
		return this.field3668.size();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "370673788"
	)
	public String method2000() {
		if (this.method1997()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method1999());

			for (int var2 = 0; var2 < this.method1999(); ++var2) {
				class397 var3 = this.method1995(var2);
				var1.append(var3.field3671);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "46"
	)
	public void method2001(int var1) {
		if (this.field3669 != null && var1 < this.field3669.ascent * 2) {
			var1 = Integer.MAX_VALUE;
		}

		if (this.field3667 != var1) {
			this.field3667 = var1;
			this.method2030();
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "48068084"
	)
	public void method2002(int var1) {
		if (this.field3663 != var1) {
			this.field3663 = var1;
			this.method2030();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1944936240"
	)
	public void method2003(int var1) {
		if (this.field3665 != var1) {
			this.field3665 = var1;
			this.method2030();
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lpq;I)V",
		garbageValue = "-1981250546"
	)
	public void method2004(AbstractFont var1) {
		if (var1 != this.field3669) {
			this.field3669 = var1;
			if (this.field3669 != null) {
				if (this.field3666 == 0) {
					this.field3666 = this.field3669.ascent;
				}

				if (!this.method1997()) {
					this.method2030();
				}
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1972843844"
	)
	public void method2005(int var1) {
		if (this.field3664 != var1) {
			this.field3664 = var1;
			this.method2030();
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "1001647291"
	)
	public boolean method2006(int var1, int var2) {
		if (this.field3661 != var1 || var2 != this.field3662) {
			this.field3661 = var1;
			this.field3662 = var2;
			this.method2030();
		}

		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "1"
	)
	public void method2007(int var1) {
		if (this.field3666 != var1) {
			this.field3666 = var1;
			this.method2030();
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(III)Lpo;",
		garbageValue = "494218521"
	)
	public class399 method2008(int var1, int var2) {
		if (var2 == var1) {
			return new class399(this, 0, 0);
		} else if (var1 <= this.field3668.size() && var2 <= this.field3668.size()) {
			return var2 < var1 ? new class399(this, var2, var1) : new class399(this, var1, var2);
		} else {
			return new class399(this, 0, 0);
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(CIII)Lph;",
		garbageValue = "2008322061"
	)
	public class396 method2009(char var1, int var2, int var3) {
		return this.method2010(Character.toString(var1), var2, var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;III)Lph;",
		garbageValue = "-1597542040"
	)
	public class396 method2010(String var1, int var2, int var3) {
		if (var3 == 0) {
			var3 = Integer.MAX_VALUE;
		}

		int var4 = var2;
		if (this.field3668.size() >= var3) {
			this.method2031(var2, var2);
			return new class396(var2, true);
		} else {
			this.field3668.ensureCapacity(this.field3668.size() + var1.length());

			for (int var5 = 0; var5 < var1.length() && this.field3668.size() < var3; ++var5) {
				class397 var6 = new class397();
				var6.field3671 = var1.charAt(var5);
				this.field3668.add(var4, var6);
				++var4;
			}

			this.method2031(var2, var4);
			if (this.field3663 != 0 && this.method2022() > this.field3663) {
				while (var4 != var2) {
					--var4;
					this.method2014(var4);
					if (this.method2022() <= this.field3663) {
						break;
					}
				}

				return new class396(var4, true);
			} else {
				return new class396(var4, false);
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)Lph;",
		garbageValue = "-44"
	)
	class396 method2011(String var1, int var2) {
		return this.method2010(var1, this.field3668.size(), var2);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Lph;",
		garbageValue = "-46"
	)
	public class396 method2012(String var1) {
		this.method2013();
		return this.method2011(var1, 0);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-18"
	)
	void method2013() {
		this.field3668.clear();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-93"
	)
	public int method2014(int var1) {
		return this.method2015(var1, var1 + 1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "1"
	)
	public int method2015(int var1, int var2) {
		int var3;
		if (var2 < var1) {
			var3 = var2;
			var2 = var1;
			var1 = var3;
		}

		this.field3668.subList(var1, var2).clear();
		var3 = var1;
		if (this.method1998() && this.field3664 == 1) {
			while (var3 > 0) {
				--var3;
				char var4 = ((class397)this.field3668.get(var3)).field3671;
				if (var4 == ' ' || var4 == '\t') {
					break;
				}
			}
		}

		this.method2031(var3, var2);
		return var1;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "62"
	)
	public int method2016(int var1, int var2) {
		if (this.field3669 == null) {
			return 0;
		} else if (this.method1998() && var1 > this.field3667) {
			return this.field3668.size();
		} else {
			if (!this.field3668.isEmpty()) {
				for (int var3 = 0; var3 < this.field3668.size(); ++var3) {
					class397 var4 = (class397)this.field3668.get(var3);
					if (var2 <= var4.field3672 + this.method2021()) {
						if (var2 < var4.field3672) {
							break;
						}

						if (var1 < var4.field3673) {
							return var3 > 0 ? var3 - 1 : 0;
						}

						if (var3 + 1 != this.field3668.size() && ((class397)this.field3668.get(var3 + 1)).field3672 != var4.field3672) {
							int var5 = this.method2033((class397)this.field3668.get(var3), false);
							if (var1 < var5 + var4.field3673) {
								return var3;
							}

							if (var2 <= var4.field3672 + this.method2021()) {
								return var3 + 1;
							}
						}
					}
				}

				class397 var6 = (class397)this.field3668.get(this.field3668.size() - 1);
				if (var1 >= var6.field3673 && var1 <= var6.field3673 + this.method2023() && var2 >= var6.field3672 && var2 <= var6.field3672 + this.method2021()) {
					return this.field3668.size() - 1;
				}
			}

			return this.field3668.size();
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1416421146"
	)
	public int method2017(int var1, int var2) {
		if (this.field3669 != null && !this.method1997() && var1 <= this.field3668.size()) {
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
				class397 var6 = (class397)this.field3668.get(var1 - 1);
				var4 = var6.field3673 + this.method2032(var1 - 1);
				var5 = var6.field3672;
			} else if (var3 == -1 && var1 == 0) {
				return 0;
			}

			int var14 = 16777215;
			int var7 = 0;
			int var8 = var1;
			int var9 = 16777215;
			int var10 = var3 == 1 ? this.field3668.size() + 1 : 0;

			for (int var11 = var3 + var1; var10 != var11; var11 += var3) {
				class397 var12 = (class397)this.field3668.get(var11 - 1);
				if (var5 != var12.field3672) {
					++var7;
					var5 = var12.field3672;
					if (var7 > var2) {
						return var8;
					}
				}

				if (var7 == var2) {
					int var13 = Math.abs(var12.field3673 + this.method2032(var11 - 1) - var4);
					if (var13 >= var9) {
						return var8;
					}

					var8 = var11;
					var9 = var13;
				}
			}

			if (var3 == 1) {
				return this.field3668.size();
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

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "1557"
	)
	public int method2018() {
		if (!this.field3668.isEmpty() && this.method2022() == 1) {
			return this.field3668.isEmpty() ? 0 : ((class397)this.field3668.get(this.field3668.size() - 1)).field3673 + this.method2023();
		} else {
			int var1 = -1;
			int var2 = 0;

			for (int var3 = this.field3668.size() - 1; var3 >= 0; --var3) {
				class397 var4 = (class397)this.field3668.get(var3);
				if (var1 != var4.field3672) {
					int var5 = this.method2033(var4, false) + var4.field3673;
					var2 = Math.max(var5, var2);
					var1 = var4.field3672;
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1208537065"
	)
	public int method2019() {
		return this.method1997() ? 0 : this.field3669.ascent + ((class397)this.field3668.get(this.field3668.size() - 1)).field3672;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int method2021() {
		return this.field3666;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-3335"
	)
	public int method2022() {
		return this.method2019() / this.field3669.ascent;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-435208989"
	)
	int method2023() {
		return this.method1997() ? 0 : this.method2033((class397)this.field3668.get(this.field3668.size() - 1), false);
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-156407630"
	)
	public int method2024() {
		return this.field3667;
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-78"
	)
	public int method2025() {
		return this.field3663;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1411436568"
	)
	public int method2026() {
		return this.field3664;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1254279551"
	)
	public int method2027() {
		return this.field3665;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "0"
	)
	public int method2028(int var1) {
		switch(this.field3661) {
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

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "47"
	)
	public int method2029(int var1) {
		switch(this.field3662) {
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

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1723560040"
	)
	void method2030() {
		this.method2031(0, this.field3668.size());
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-2083638926"
	)
	void method2031(int var1, int var2) {
		if (!this.method1997() && this.field3669 != null) {
			class486 var3 = this.method2034(var1, var2);
			boolean var4 = (Integer)var3.field4036 == 0 && (Integer)var3.field4037 == this.field3668.size();
			int var5 = (Integer)var3.field4036;
			int var6 = 0;
			int var7 = var4 ? 0 : ((class397)this.field3668.get((Integer)var3.field4036)).field3672 * 254759267 * 2114762827;
			int var8 = 0;

			int var9;
			for (var9 = (Integer)var3.field4036; var9 <= (Integer)var3.field4037; ++var9) {
				boolean var10 = var9 >= this.field3668.size();
				class397 var11 = (class397)this.field3668.get(!var10 ? var9 : this.field3668.size() - 1);
				int var12 = !var10 ? this.method2033(var11, false) : 0;
				boolean var13 = !var10 && var11.field3671 == '\n';
				boolean var14 = !var10 && this.method1998() && var6 + var12 > this.field3667;
				if (var13 || var14 || var10) {
					int var15 = var9;
					int var16 = 0;
					int var17;
					int var18;
					class397 var19;
					if (var14) {
						var17 = 0;
						if (this.field3664 == 1) {
							for (var18 = var9; var18 > var5; --var18) {
								var19 = (class397)this.field3668.get(var18);
								var17 += var18 < var15 ? this.method2033(var19, false) : 0;
								if (var19.field3671 == ' ' || var19.field3671 == '\n') {
									var15 = var18;
									var6 -= var17;
									var16 = var17;
									break;
								}
							}
						}
					}

					var17 = -this.method2028(var6);

					for (var18 = var5; var18 < var15; ++var18) {
						var19 = (class397)this.field3668.get(var18);
						int var20 = this.method2033(var19, false);
						var19.field3673 = var17;
						var19.field3672 = var7;
						var17 += var20;
					}

					var5 = var15;
					var6 = var16;
					var7 += this.method2021();
					++var8;
				}

				var6 += !var10 ? var12 : 0;
			}

			if (this.field3662 != 0 && var4) {
				var9 = var8 * this.method2021();
				int var23 = this.method2029(var9);

				for (int var21 = 0; var21 < this.field3668.size(); ++var21) {
					class397 var22 = (class397)this.field3668.get(var21);
					var22.field3672 -= var23;
				}
			}

		}
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-46"
	)
	int method2032(int var1) {
		return var1 < this.field3668.size() ? this.method2033((class397)this.field3668.get(var1), false) : 0;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(Lpz;ZB)I",
		garbageValue = "4"
	)
	int method2033(class397 var1, boolean var2) {
		if (var1.field3671 == '\n') {
			return 0;
		} else if (this.field3665 == 0) {
			int var3 = this.field3669.advances[var1.field3671];
			if (var3 == 0) {
				return var1.field3671 == '\t' ? this.field3669.advances[32] * 3 : this.field3669.advances[32];
			} else {
				return var3;
			}
		} else {
			return this.field3669.advances[42];
		}
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lsf;",
		garbageValue = "-41"
	)
	class486 method2034(int var1, int var2) {
		int var3 = Math.min(var1, var2);
		int var4 = Math.max(var1, var2);
		int var5 = this.field3668.size();
		if (var3 == 0 && var4 == var5) {
			return new class486(0, var5);
		} else {
			int var6 = this.method2035(var3, false);
			int var7 = this.method2036(var4, false);
			int var8;
			switch(this.field3662) {
			case 0:
				if (this.field3661 == 0) {
					return new class486(var6, var5);
				}

				var8 = this.method2035(var3, true);
				return new class486(var8, var5);
			case 1:
				return new class486(0, var5);
			case 2:
				if (this.field3661 == 2) {
					return new class486(0, var7);
				}

				var8 = this.method2036(var4, true);
				return new class486(0, var8);
			default:
				return new class486(0, var5);
			}
		}
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "1702216179"
	)
	int method2035(int var1, boolean var2) {
		if (var1 < this.field3668.size()) {
			int var3 = ((class397)this.field3668.get(var1)).field3672;

			for (int var4 = var1; var4 > 0; --var4) {
				if (((class397)this.field3668.get(var4 - 1)).field3672 < var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class397)this.field3668.get(var4 - 1)).field3672;
				}
			}
		}

		return 0;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1813129427"
	)
	int method2036(int var1, boolean var2) {
		if (var1 < this.field3668.size()) {
			int var3 = ((class397)this.field3668.get(var1)).field3672;

			for (int var4 = var1; var4 < this.field3668.size() - 1; ++var4) {
				if (((class397)this.field3668.get(var4 + 1)).field3672 > var3) {
					if (!var2) {
						return var4;
					}

					var2 = false;
					var3 = ((class397)this.field3668.get(var4 + 1)).field3672;
				}
			}
		}

		return this.field3668.size();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Ltm;",
		garbageValue = "1693423022"
	)
	public static class503 method1994(int var0) {
		int var1 = class501.field4087[var0];
		if (var1 == 1) {
			return class503.field4090;
		} else if (var1 == 2) {
			return class503.field4089;
		} else {
			return var1 == 3 ? class503.field4091 : null;
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1112737604"
	)
	static void method2020() {
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lpc;Lpc;Lpc;I)V",
		garbageValue = "680551313"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (GrandExchangeOfferTotalQuantityComparator.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		Script.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			WorldMapData_0.method1364(var0, var1);
		} else {
			SongTask.leftTitleSprite.drawAt(Login.xPadding, 0);
			ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
			int var4;
			if (Client.gameState == 0 || Client.gameState == 5) {
				byte var3 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
				var4 = 253 - var3;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
			}

			String var5;
			String var7;
			String var8;
			int var9;
			char[] var10;
			int var11;
			short var19;
			int var20;
			short var21;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var19 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16776960, 0);
				var20 = var19 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16776960, 0);
				var20 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16776960, 0);
				var20 += 15;
				var20 += 7;
				if (Login.loginIndex != 4 && Login.loginIndex != 10) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var20, 16777215, 0);
					var21 = 200;

					for (var5 = class14.method51(); var0.stringWidth(var5) > var21; var5 = var5.substring(0, var5.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var5), Login.loginBoxX + 180 - 70, var20, 16777215, 0);
					var20 += 15;
					var7 = Login.Login_password;
					var9 = var7.length();
					var10 = new char[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var10[var11] = '*';
					}

					var8 = new String(var10);

					for (var8 = var8; var0.stringWidth(var8) > var21; var8 = var8.substring(1)) {
					}

					var0.draw("Password: " + var8, Login.loginBoxX + 180 - 108, var20, 16777215, 0);
					var20 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11 || Client.gameState == 50) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var13;
				if (Login.loginIndex == 0) {
					var19 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var19, 16776960, 0);
					var20 = var19 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var13 = 291;
					Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
					var0.drawLines("New User", var4 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
					var0.drawLines("Existing User", var4 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var19 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16777215, 0);
					var20 = var19 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16777215, 0);
					var20 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16777215, 0);
					var20 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var13 = 321;
					Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
					var0.drawCentered("Continue", var4, var13 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
					var0.drawCentered("Cancel", var4, var13 + 5, 16777215, 0);
				} else {
					short var12;
					IndexedSprite var22;
					if (Login.loginIndex == 2) {
						var19 = 201;
						var0.drawCentered(Login.Login_response1, Script.loginBoxCenter, var19, 16776960, 0);
						var20 = var19 + 15;
						var0.drawCentered(Login.Login_response2, Script.loginBoxCenter, var20, 16776960, 0);
						var20 += 15;
						var0.drawCentered(Login.Login_response3, Script.loginBoxCenter, var20, 16776960, 0);
						var20 += 15;
						var20 += 7;
						var0.draw("Login: ", Script.loginBoxCenter - 110, var20, 16777215, 0);
						var21 = 200;

						for (var5 = class14.method51(); var0.stringWidth(var5) > var21; var5 = var5.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var5) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? MusicPatchPcmStream.colorStartTag(16776960) + "|" : ""), Script.loginBoxCenter - 70, var20, 16777215, 0);
						var20 += 15;
						var7 = Login.Login_password;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var8 = new String(var10);

						for (var8 = var8; var0.stringWidth(var8) > var21; var8 = var8.substring(1)) {
						}

						var0.draw("Password: " + var8 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? MusicPatchPcmStream.colorStartTag(16776960) + "|" : ""), Script.loginBoxCenter - 108, var20, 16777215, 0);
						var20 += 15;
						var19 = 277;
						var9 = Script.loginBoxCenter + -117;
						var22 = PcmPlayer.method209(Client.Login_isUsernameRemembered, Login.field741);
						var22.drawAt(var9, var19);
						var9 = var9 + var22.subWidth + 5;
						var1.draw("Remember username", var9, var19 + 13, 16776960, 0);
						var9 = Script.loginBoxCenter + 24;
						var22 = PcmPlayer.method209(class150.clientPreferences.getIsUsernameHidden(), Login.field740);
						var22.drawAt(var9, var19);
						var9 = var9 + var22.subWidth + 5;
						var1.draw("Hide username", var9, var19 + 13, 16776960, 0);
						var20 = var19 + 15;
						var11 = Script.loginBoxCenter - 80;
						var12 = 321;
						Login.titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
						var0.drawCentered("Login", var11, var12 + 5, 16777215, 0);
						var11 = Script.loginBoxCenter + 80;
						Login.titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
						var0.drawCentered("Cancel", var11, var12 + 5, 16777215, 0);
						var19 = 357;
						switch(Login.field747) {
						case 2:
							MouseHandler.field145 = "Having trouble logging in?";
							break;
						default:
							MouseHandler.field145 = "Can't login? Click here.";
						}

						class343.field3130 = new Bounds(Script.loginBoxCenter, var19, var1.stringWidth(MouseHandler.field145), 11);
						class313.field2821 = new Bounds(Script.loginBoxCenter, var19, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(MouseHandler.field145, Script.loginBoxCenter, var19, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var19 = 201;
						var0.drawCentered("Incorrect username or password.", Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 20;
						var1.drawCentered("If you have upgraded to a Jagex Account, you", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 20;
						var1.drawCentered("need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180;
						var13 = 276;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var2.drawCentered("Try again", var4, var13 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var13 = 326;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var2.drawCentered("Forgotten password?", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var19 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16777215, 0);
						var20 = var19 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16777215, 0);
						var20 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16777215, 0);
						var20 += 15;
						var5 = "PIN: ";
						var7 = Login.otp;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var8 = new String(var10);
						var0.draw(var5 + var8 + (Client.cycle % 40 < 20 ? MusicPatchPcmStream.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var20, 16777215, 0);
						var20 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var20, 16776960, 0);
						var20 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var20, 16776960, 0);
						int var16 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						var9 = var20 - var0.ascent;
						if (Login.field739) {
							var22 = class11.options_buttons_2Sprite;
						} else {
							var22 = WorldMapLabelSize.options_buttons_0Sprite;
						}

						var22.drawAt(var16, var9);
						var20 += 15;
						var11 = Login.loginBoxX + 180 - 80;
						var12 = 321;
						Login.titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
						var0.drawCentered("Continue", var11, var12 + 5, 16777215, 0);
						var11 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var11 - 73, var12 - 20);
						var0.drawCentered("Cancel", var11, var12 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var12 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var19 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var20 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var20, 16777215, 0);
						var21 = 174;

						for (var5 = class14.method51(); var0.stringWidth(var5) > var21; var5 = var5.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var5) + (Client.cycle % 40 < 20 ? MusicPatchPcmStream.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var20, 16777215, 0);
						var20 += 15;
						int var17 = Login.loginBoxX + 180 - 80;
						short var15 = 321;
						Login.titlebuttonSprite.drawAt(var17 - 73, var15 - 20);
						var0.drawCentered("Recover", var17, var15 + 5, 16777215, 0);
						var17 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var17 - 73, var15 - 20);
						var0.drawCentered("Back", var17, var15 + 5, 16777215, 0);
						var15 = 356;
						var1.drawCentered("Still having trouble logging in?", Script.loginBoxCenter, var15, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var19 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180;
						var13 = 321;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Back", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						if (Message.field347 && !Client.onMobile) {
							var19 = 201;
							var0.drawCentered(Login.Login_response1, Script.loginBoxCenter, var19, 16776960, 0);
							var20 = var19 + 15;
							var0.drawCentered(Login.Login_response2, Script.loginBoxCenter, var20, 16776960, 0);
							var20 += 15;
							var0.drawCentered(Login.Login_response3, Script.loginBoxCenter, var20, 16776960, 0);
							var4 = Script.loginBoxCenter - 150;
							var20 += 10;

							int var23;
							for (var23 = 0; var23 < 8; ++var23) {
								Login.titlebuttonSprite.method2635(var4, var20, 30, 40);
								boolean var26 = var23 == Login.field748 & Client.cycle % 40 < 20;
								var0.draw((Login.field767[var23] == null ? "" : Login.field767[var23]) + (var26 ? MusicPatchPcmStream.colorStartTag(16776960) + "|" : ""), var4 + 10, var20 + 27, 16777215, 0);
								if (var23 != 1 && var23 != 3) {
									var4 += 35;
								} else {
									var4 += 50;
									var0.draw(AbstractFont.escapeBrackets("/"), var4 - 13, var20 + 27, 16777215, 0);
								}
							}

							var23 = Script.loginBoxCenter - 80;
							short var27 = 321;
							Login.titlebuttonSprite.drawAt(var23 - 73, var27 - 20);
							var0.drawCentered("Submit", var23, var27 + 5, 16777215, 0);
							var23 = Script.loginBoxCenter + 80;
							Login.titlebuttonSprite.drawAt(var23 - 73, var27 - 20);
							var0.drawCentered("Cancel", var23, var27 + 5, 16777215, 0);
						} else {
							var19 = 216;
							var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var19, 16776960, 0);
							var20 = var19 + 15;
							var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var20, 16776960, 0);
							var20 += 15;
							var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var20, 16776960, 0);
							var20 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var13 = 321;
							Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
							var0.drawCentered("Set Date of Birth", var4, var13 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
							var0.drawCentered("Back", var4, var13 + 5, 16777215, 0);
						}
					} else if (Login.loginIndex == 8) {
						var19 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180 - 80;
						var13 = 321;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Privacy Policy", var4, var13 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Back", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 9) {
						var19 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 25;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 25;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16776960, 0);
						var4 = Login.loginBoxX + 180;
						var13 = 311;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Try again", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 10) {
						var20 = Login.loginBoxX + 180;
						var21 = 209;
						var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var21, 16776960, 0);
						var4 = var21 + 20;
						Login.field773.drawAt(var20 - 109, var4);
						if (Login.field761.isEmpty()) {
							DirectByteArrayCopier.field3096.drawAt(var20 - 48, var4 + 18);
						} else {
							DirectByteArrayCopier.field3096.drawAt(var20 - 48, var4 + 5);
							var0.drawCentered(Login.field761, var20, var4 + 68 - 15, 16776960, 0);
						}
					} else if (Login.loginIndex == 12) {
						var20 = Script.loginBoxCenter;
						var21 = 216;
						var2.drawCentered("Before using this app, please read and accept our", var20, var21, 16777215, 0);
						var4 = var21 + 17;
						var2.drawCentered("<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var20, var4, 16777215, 0);
						var4 += 17;
						var2.drawCentered("<col=ffd200>agreement (EULA)</col>.", var20, var4, 16777215, 0);
						var4 += 17;
						var2.drawCentered("By accepting, you agree to these documents.", var20, var4, 16777215, 0);
						var20 = Script.loginBoxCenter - 80;
						var21 = 311;
						Login.titlebuttonSprite.drawAt(var20 - 73, var21 - 20);
						var0.drawCentered("Accept", var20, var21 + 5, 16777215, 0);
						var20 = Script.loginBoxCenter + 80;
						Login.titlebuttonSprite.drawAt(var20 - 73, var21 - 20);
						var0.drawCentered("Decline", var20, var21 + 5, 16777215, 0);
					} else if (Login.loginIndex == 13) {
						var19 = 231;
						var2.drawCentered("You must accept our terms of use, privacy policy,", Login.loginBoxX + 180, var19, 16777215, 0);
						var20 = var19 + 20;
						var2.drawCentered("and end user licence agreement to continue.", Login.loginBoxX + 180, var20, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var19 = 311;
						Login.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Back", var4, var19 + 5, 16777215, 0);
					} else if (Login.loginIndex == 14) {
						var19 = 201;
						String var14 = "";
						var5 = "";
						String var6 = "";
						switch(Login.field746) {
						case 0:
							var14 = "Your account has been involved";
							var5 = "in serious rule breaking.";
							var6 = "";
							break;
						case 1:
							var14 = "Your account has been locked due to";
							var5 = "suspicious activity.";
							var6 = "Please recover your account.";
							break;
						case 2:
							var14 = "The unpaid balance on your account needs";
							var5 = "to be resolved before you can play.";
							var6 = Strings.field3291;
							break;
						default:
							PlayerComposition.Login_promptCredentials(false);
						}

						var0.drawCentered(var14, Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 20;
						var0.drawCentered(var5, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 20;
						var0.drawCentered(var6, Login.loginBoxX + 180, var20, 16776960, 0);
						int var24 = Login.loginBoxX + 180;
						short var25 = 276;
						Login.titlebuttonSprite.drawAt(var24 - 73, var25 - 20);
						if (Login.field746 == 1) {
							var0.drawCentered("Recover Account", var24, var25 + 5, 16777215, 0);
						} else {
							var0.drawCentered("View Appeal Options", var24, var25 + 5, 16777215, 0);
						}

						var24 = Login.loginBoxX + 180;
						var25 = 326;
						Login.titlebuttonSprite.drawAt(var24 - 73, var25 - 20);
						var0.drawCentered("Back", var24, var25 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var19 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16777215, 0);
						var20 = var19 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16777215, 0);
						var20 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16777215, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180;
						var13 = 301;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Ok", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 32) {
						var19 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180 - 80;
						var13 = 321;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Set Date of Birth", var4, var13 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var0.drawCentered("Back", var4, var13 + 5, 16777215, 0);
					} else if (Login.loginIndex == 33) {
						var19 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var19, 16776960, 0);
						var20 = var19 + 20;
						var1.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 20;
						var1.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var20, 16776960, 0);
						var20 += 15;
						var4 = Login.loginBoxX + 180;
						var13 = 276;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var2.drawCentered("Download Launcher", var4, var13 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var13 = 326;
						Login.titlebuttonSprite.drawAt(var4 - 73, var13 - 20);
						var2.drawCentered("Back", var4, var13 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var18 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var18);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, WorldMapArchiveLoader.canvasHeight);
				class165.field1419.draw(Login.xPadding - 22, Client.cycle);
				class165.field1419.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var18);
			}

			class304.title_muteSprite[class150.clientPreferences.getTitleMusicDisabled() ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == Interpreter.clientLanguage) {
				if (class465.field3894 != null) {
					var20 = Login.xPadding + 5;
					var21 = 463;
					byte var28 = 100;
					byte var29 = 35;
					class465.field3894.drawAt(var20, var21);
					var0.drawCentered("World" + " " + Client.worldId, var28 / 2 + var20, var29 / 2 + var21 - 2, 16777215, 0);
					if (World.World_request != null) {
						var1.drawCentered("Loading...", var28 / 2 + var20, var29 / 2 + var21 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var28 / 2 + var20, var29 / 2 + var21 + 12, 16777215, 0);
					}
				} else {
					class465.field3894 = class451.SpriteBuffer_getIndexedSpriteByName(class386.archive8, "sl_button", "");
				}
			}

		}
	}
}
