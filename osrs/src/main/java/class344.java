import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.datatransfer.*;

@ObfuscatedName("nz")
public class class344 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lpp;"
	)
	class409 field2972;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lpp;"
	)
	class409 field2971;
	@ObfuscatedName("ae")
	boolean field2952;
	@ObfuscatedName("aw")
	boolean field2953;
	@ObfuscatedName("aq")
	int field2957;
	@ObfuscatedName("az")
	boolean field2954;
	@ObfuscatedName("at")
	int field2958;
	@ObfuscatedName("af")
	int field2956;
	@ObfuscatedName("ad")
	int field2955;
	@ObfuscatedName("bn")
	int field2964;
	@ObfuscatedName("bk")
	int field2963;
	@ObfuscatedName("by")
	int field2967;
	@ObfuscatedName("bd")
	int field2961;
	@ObfuscatedName("be")
	int field2962;
	@ObfuscatedName("bv")
	int field2966;
	@ObfuscatedName("ba")
	int field2959;
	@ObfuscatedName("bz")
	int field2968;
	@ObfuscatedName("bb")
	int field2960;
	@ObfuscatedName("bo")
	int field2965;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "Lmg;"
	)
	class337 field2969;
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "Lmg;"
	)
	class337 field2970;

	class344() {
		this.field2972 = new class409();
		this.field2971 = new class409();
		this.field2952 = false;
		this.field2953 = true;
		this.field2957 = 0;
		this.field2954 = false;
		this.field2958 = 0;
		this.field2956 = 0;
		this.field2955 = 0;
		this.field2964 = 0;
		this.field2963 = 0;
		this.field2967 = 0;
		this.field2961 = 0;
		this.field2962 = Integer.MAX_VALUE;
		this.field2966 = Integer.MAX_VALUE;
		this.field2959 = 0;
		this.field2968 = 0;
		this.field2960 = 0;
		this.field2965 = 0;
		this.field2972.method2075(1);
		this.field2971.method2075(1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "120"
	)
	void method1762() {
		this.field2957 = (this.field2957 + 1) % 60;
		if (this.field2961 > 0) {
			--this.field2961;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ZI)Z",
		garbageValue = "523317409"
	)
	public boolean method1763(boolean var1) {
		var1 = var1 && this.field2953;
		boolean var2 = this.field2952 != var1;
		this.field2952 = var1;
		if (!this.field2952) {
			this.method1787(this.field2964, this.field2964);
		}

		return var2;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1481904343"
	)
	public void method1764(boolean var1) {
		this.field2953 = var1;
		this.field2952 = var1 && this.field2952;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "-2133127223"
	)
	public boolean method1765(String var1) {
		String var2 = this.field2972.method2070();
		if (!var2.equals(var1)) {
			var1 = this.method1831(var1);
			this.field2972.method2082(var1);
			this.method1787(this.field2963, this.field2964);
			this.method1772(this.field2960, this.field2965);
			this.method1835();
			this.method1840();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "1293964055"
	)
	boolean method1766(String var1) {
		this.field2971.method2082(var1);
		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lpk;I)Z",
		garbageValue = "2045619310"
	)
	boolean method1767(AbstractFont var1) {
		boolean var2 = !this.field2954;
		this.field2972.method2074(var1);
		this.field2971.method2074(var1);
		this.field2954 = true;
		var2 |= this.method1772(this.field2960, this.field2965);
		var2 |= this.method1787(this.field2963, this.field2964);
		if (this.method1835()) {
			this.method1840();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "70"
	)
	public boolean method1768(int var1, int var2) {
		boolean var3 = this.field2959 != var1 || var2 != this.field2968;
		this.field2959 = var1;
		this.field2968 = var2;
		var3 |= this.method1772(this.field2960, this.field2965);
		return var3;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-74"
	)
	public boolean method1769(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var2 = var1 == this.field2972.method2093();
		this.field2972.method2071(var1);
		this.field2971.method2071(var1);
		if (this.method1835()) {
			this.method1840();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "6"
	)
	public boolean method1770(int var1) {
		this.field2972.method2072(var1);
		if (this.method1835()) {
			this.method1840();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1717570728"
	)
	public boolean method1771(int var1) {
		this.field2966 = var1;
		if (this.method1835()) {
			this.method1840();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-1634456183"
	)
	public boolean method1772(int var1, int var2) {
		if (!this.method1819()) {
			this.field2960 = var1;
			this.field2965 = var2;
			return false;
		} else {
			int var3 = this.field2960;
			int var4 = this.field2965;
			int var5 = Math.max(0, this.field2972.method2088() - this.field2959 + 2);
			int var6 = Math.max(0, this.field2972.method2089() - this.field2968 + 1);
			this.field2960 = Math.max(0, Math.min(var5, var1));
			this.field2965 = Math.max(0, Math.min(var6, var2));
			return var3 != this.field2960 || var4 != this.field2965;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "2093677654"
	)
	public boolean method1773(int var1, int var2) {
		boolean var3 = true;
		if (var1 < 0 || var1 > 2) {
			var3 = false;
		}

		if (var2 < 0 || var2 > 2) {
			var3 = false;
		}

		return var3 ? this.field2972.method2076(var1, var2) : false;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-939191131"
	)
	public void method1774(int var1) {
		this.field2972.method2077(var1);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-592386576"
	)
	public void method1775(int var1) {
		this.field2958 = var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "3"
	)
	public void method1776(int var1) {
		this.field2972.method2075(var1);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1498031514"
	)
	public void method1777(int var1) {
		this.field2972.method2073(var1);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "180"
	)
	public boolean method1778(int var1) {
		this.field2955 = var1;
		String var2 = this.field2972.method2070();
		int var3 = var2.length();
		var2 = this.method1831(var2);
		if (var2.length() != var3) {
			this.field2972.method2082(var2);
			this.method1772(this.field2960, this.field2965);
			this.method1835();
			this.method1840();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-969199499"
	)
	public void method1779() {
		this.field2954 = false;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "4138"
	)
	public boolean method1780(int var1) {
		if (this.method1841(var1)) {
			this.method1785();
			class410 var2 = this.field2972.method2079((char)var1, this.field2964, this.field2962);
			this.method1787(var2.method2107(), var2.method2107());
			this.method1835();
			this.method1840();
		}

		return true;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "755624940"
	)
	public void method1781() {
		if (!this.method1785() && this.field2964 > 0) {
			int var1 = this.field2972.method2084(this.field2964 - 1);
			this.method1840();
			this.method1787(var1, var1);
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "22"
	)
	public void method1782() {
		if (!this.method1785() && this.field2964 < this.field2972.method2069()) {
			int var1 = this.field2972.method2084(this.field2964);
			this.method1840();
			this.method1787(var1, var1);
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2101637945"
	)
	public void method1783() {
		if (!this.method1785() && this.field2964 > 0) {
			class500 var1 = this.method1833(this.field2964 - 1);
			int var2 = this.field2972.method2085((Integer)var1.field4079, this.field2964);
			this.method1840();
			this.method1787(var2, var2);
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-882101391"
	)
	public void method1784() {
		if (!this.method1785() && this.field2964 < this.field2972.method2069()) {
			class500 var1 = this.method1833(this.field2964);
			int var2 = this.field2972.method2085(this.field2964, (Integer)var1.field4080);
			this.method1840();
			this.method1787(var2, var2);
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-639259447"
	)
	boolean method1785() {
		if (!this.method1830()) {
			return false;
		} else {
			int var1 = this.field2972.method2085(this.field2963, this.field2964);
			this.method1840();
			this.method1787(var1, var1);
			return true;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-3"
	)
	public void method1786() {
		this.method1787(0, this.field2972.method2069());
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-504671047"
	)
	public boolean method1787(int var1, int var2) {
		if (!this.method1819()) {
			this.field2963 = var1;
			this.field2964 = var2;
			return false;
		} else {
			if (var1 > this.field2972.method2069()) {
				var1 = this.field2972.method2069();
			}

			if (var2 > this.field2972.method2069()) {
				var2 = this.field2972.method2069();
			}

			boolean var3 = this.field2963 != var1 || var2 != this.field2964;
			this.field2963 = var1;
			if (var2 != this.field2964) {
				this.field2964 = var2;
				this.field2957 = 0;
				this.method1838();
			}

			if (var3 && this.field2970 != null) {
				this.field2970.vmethod5708();
			}

			return var3;
		}
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "55"
	)
	public void method1788(boolean var1) {
		class500 var2 = this.method1834(this.field2964);
		this.method1836((Integer)var2.field4079, var1);
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "2010552592"
	)
	public void method1789(boolean var1) {
		class500 var2 = this.method1834(this.field2964);
		this.method1836((Integer)var2.field4080, var1);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-81"
	)
	public void method1790(boolean var1) {
		this.method1836(0, var1);
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1475070773"
	)
	public void method1791(boolean var1) {
		this.method1836(this.field2972.method2069(), var1);
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1914804723"
	)
	public void method1792(boolean var1) {
		if (this.method1830() && !var1) {
			this.method1836(Math.min(this.field2963, this.field2964), var1);
		} else if (this.field2964 > 0) {
			this.method1836(this.field2964 - 1, var1);
		}

	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1254852438"
	)
	public void method1793(boolean var1) {
		if (this.method1830() && !var1) {
			this.method1836(Math.max(this.field2963, this.field2964), var1);
		} else if (this.field2964 < this.field2972.method2069()) {
			this.method1836(this.field2964 + 1, var1);
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1246989574"
	)
	public void method1794(boolean var1) {
		if (this.field2964 > 0) {
			class500 var2 = this.method1833(this.field2964 - 1);
			this.method1836((Integer)var2.field4079, var1);
		}

	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-589145055"
	)
	public void method1795(boolean var1) {
		if (this.field2964 < this.field2972.method2069()) {
			class500 var2 = this.method1833(this.field2964 + 1);
			this.method1836((Integer)var2.field4080, var1);
		}

	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1596308602"
	)
	public void method1796(boolean var1) {
		if (this.field2964 > 0) {
			this.method1836(this.field2972.method2087(this.field2964, -1), var1);
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1852812163"
	)
	public void method1797(boolean var1) {
		if (this.field2964 < this.field2972.method2069()) {
			this.method1836(this.field2972.method2087(this.field2964, 1), var1);
		}

	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-28"
	)
	public void method1798(boolean var1) {
		if (this.field2964 > 0) {
			int var2 = this.method1837();
			this.method1836(this.field2972.method2087(this.field2964, -var2), var1);
		}

	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-196223675"
	)
	public void method1799(boolean var1) {
		if (this.field2964 < this.field2972.method2069()) {
			int var2 = this.method1837();
			this.method1836(this.field2972.method2087(this.field2964, var2), var1);
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "18712"
	)
	public void method1800(boolean var1) {
		class413 var2 = this.field2972.method2078(0, this.field2964);
		class500 var3 = var2.method2151();
		this.method1836(this.field2972.method2086((Integer)var3.field4079, this.field2965), var1);
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-124"
	)
	public void method1801(boolean var1) {
		class413 var2 = this.field2972.method2078(0, this.field2964);
		class500 var3 = var2.method2151();
		this.method1836(this.field2972.method2086((Integer)var3.field4079, this.field2968 + this.field2965), var1);
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(IIZZI)V",
		garbageValue = "-1267266894"
	)
	public void method1802(int var1, int var2, boolean var3, boolean var4) {
		boolean var5 = false;
		class500 var6;
		int var8;
		if (!this.field2954) {
			var8 = 0;
		} else {
			var1 += this.field2960;
			var2 += this.field2965;
			var6 = this.method1842();
			var8 = this.field2972.method2086(var1 - (Integer)var6.field4079, var2 - (Integer)var6.field4080);
		}

		if (var3 && var4) {
			this.field2956 = 1;
			var6 = this.method1833(var8);
			class500 var7 = this.method1833(this.field2967);
			this.method1832(var7, var6);
		} else if (var3) {
			this.field2956 = 1;
			var6 = this.method1833(var8);
			this.method1787((Integer)var6.field4079, (Integer)var6.field4080);
			this.field2967 = (Integer)var6.field4079;
		} else if (var4) {
			this.method1787(this.field2967, var8);
		} else {
			if (this.field2961 > 0 && var8 == this.field2967) {
				if (this.field2964 == this.field2963) {
					this.field2956 = 1;
					var6 = this.method1833(var8);
					this.method1787((Integer)var6.field4079, (Integer)var6.field4080);
				} else {
					this.field2956 = 2;
					var6 = this.method1834(var8);
					this.method1787((Integer)var6.field4079, (Integer)var6.field4080);
				}
			} else {
				this.field2956 = 0;
				this.method1787(var8, var8);
				this.field2967 = var8;
			}

			this.field2961 = 25;
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1597491058"
	)
	public void method1803(int var1, int var2) {
		if (this.field2954 && this.method1814()) {
			var1 += this.field2960;
			var2 += this.field2965;
			class500 var3 = this.method1842();
			int var4 = this.field2972.method2086(var1 - (Integer)var3.field4079, var2 - (Integer)var3.field4080);
			class500 var5;
			class500 var6;
			switch(this.field2956) {
			case 0:
				this.method1787(this.field2963, var4);
				break;
			case 1:
				var5 = this.method1833(this.field2967);
				var6 = this.method1833(var4);
				this.method1832(var5, var6);
				break;
			case 2:
				var5 = this.method1834(this.field2967);
				var6 = this.method1834(var4);
				this.method1832(var5, var6);
			}
		}

	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "-839335368"
	)
	public void method1804(Clipboard var1) {
		class413 var2 = this.field2972.method2078(this.field2963, this.field2964);
		if (!var2.method2147()) {
			String var3 = var2.method2145();
			if (!var3.isEmpty()) {
				var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
			}
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "2087668691"
	)
	public void method1805(Clipboard var1) {
		if (this.method1830()) {
			this.method1804(var1);
			this.method1785();
		}

	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
		garbageValue = "84"
	)
	public void method1806(Clipboard var1) {
		Transferable var2 = var1.getContents((Object)null);
		if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var3 = this.method1831((String)var2.getTransferData(DataFlavor.stringFlavor));
				this.method1785();
				class410 var4 = this.field2972.method2080(var3, this.field2964, this.field2962);
				this.method1787(var4.method2107(), var4.method2107());
				this.method1835();
				this.method1840();
			} catch (Exception var5) {
			}
		}

	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	public void method1807() {
		this.field2965 = Math.max(0, this.field2965 - this.field2972.method2090());
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-794433961"
	)
	public void method1808() {
		int var1 = Math.max(0, this.field2972.method2089() - this.field2968);
		this.field2965 = Math.min(var1, this.field2965 + this.field2972.method2090());
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lmg;I)V",
		garbageValue = "-1738038140"
	)
	public void method1809(class337 var1) {
		this.field2969 = var1;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(Lmg;I)V",
		garbageValue = "1967767680"
	)
	public void method1810(class337 var1) {
		this.field2970 = var1;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(B)Lpp;",
		garbageValue = "-4"
	)
	public class409 method1811() {
		return this.field2972;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(I)Lpp;",
		garbageValue = "1583287029"
	)
	public class409 method1812() {
		return this.field2971;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(I)Lpr;",
		garbageValue = "1493883876"
	)
	public class413 method1813() {
		return this.field2972.method2078(this.field2963, this.field2964);
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "435699001"
	)
	public boolean method1814() {
		return this.field2952;
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "515348942"
	)
	public boolean method1815() {
		return this.field2953;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "30"
	)
	public boolean method1816() {
		return this.method1814() && this.field2957 % 60 < 30;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-272595100"
	)
	public int method1817() {
		return this.field2964;
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "6"
	)
	public int method1818() {
		return this.field2963;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1559709726"
	)
	public boolean method1819() {
		return this.field2954;
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1987240412"
	)
	public int method1820() {
		return this.field2960;
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-123"
	)
	public int method1821() {
		return this.field2965;
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1717649091"
	)
	public int method1822() {
		return this.field2972.method2093();
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "61"
	)
	public int method1823() {
		return this.field2972.method2094();
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "418287158"
	)
	public int method1824() {
		return this.field2966;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "250709855"
	)
	public int method1825() {
		return this.field2958;
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-150919313"
	)
	public int method1826() {
		return this.field2972.method2095();
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "128"
	)
	public int method1827() {
		return this.field2955;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "29102"
	)
	public int method1828() {
		return this.field2972.method2096();
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "114534110"
	)
	public boolean method1829() {
		return this.method1823() > 1;
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-455222882"
	)
	boolean method1830() {
		return this.field2964 != this.field2963;
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-21"
	)
	String method1831(String var1) {
		StringBuilder var2 = new StringBuilder(var1.length());

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			char var4 = var1.charAt(var3);
			if (this.method1841(var4)) {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(Ltw;Ltw;I)V",
		garbageValue = "1806400604"
	)
	void method1832(class500 var1, class500 var2) {
		if ((Integer)var2.field4079 < (Integer)var1.field4079) {
			this.method1787((Integer)var1.field4080, (Integer)var2.field4079);
		} else {
			this.method1787((Integer)var1.field4079, (Integer)var2.field4080);
		}

	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(II)Ltw;",
		garbageValue = "772728945"
	)
	class500 method1833(int var1) {
		int var2 = this.field2972.method2069();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.method1839(this.field2972.method2065(var5 - 1).field3713)) {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.method1839(this.field2972.method2065(var5).field3713)) {
				var4 = var5;
				break;
			}
		}

		return new class500(var3, var4);
	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		descriptor = "(II)Ltw;",
		garbageValue = "-1936541681"
	)
	class500 method1834(int var1) {
		int var2 = this.field2972.method2069();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.field2972.method2065(var5 - 1).field3713 == '\n') {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.field2972.method2065(var5).field3713 == '\n') {
				var4 = var5;
				break;
			}
		}

		return new class500(var3, var4);
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1778479023"
	)
	boolean method1835() {
		if (!this.method1819()) {
			return false;
		} else {
			boolean var1 = false;
			if (this.field2972.method2069() > this.field2966) {
				this.field2972.method2085(this.field2966, this.field2972.method2069());
				var1 = true;
			}

			int var2 = this.method1823();
			int var3;
			if (this.field2972.method2091() > var2) {
				var3 = this.field2972.method2087(0, var2) - 1;
				this.field2972.method2085(var3, this.field2972.method2069());
				var1 = true;
			}

			if (var1) {
				var3 = this.field2964;
				int var4 = this.field2963;
				int var5 = this.field2972.method2069();
				if (this.field2964 > var5) {
					var3 = var5;
				}

				if (this.field2963 > var5) {
					var4 = var5;
				}

				this.method1787(var4, var3);
			}

			return var1;
		}
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "-1307117212"
	)
	void method1836(int var1, boolean var2) {
		if (var2) {
			this.method1787(this.field2963, var1);
		} else {
			this.method1787(var1, var1);
		}

	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "996246059"
	)
	int method1837() {
		return this.field2968 / this.field2972.method2090();
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1596440102"
	)
	void method1838() {
		class413 var1 = this.field2972.method2078(0, this.field2964);
		class500 var2 = var1.method2151();
		int var3 = this.field2972.method2090();
		int var4 = (Integer)var2.field4079 - 10;
		int var5 = var4 + 20;
		int var6 = (Integer)var2.field4080 - 3;
		int var7 = var6 + var3 + 6;
		int var8 = this.field2960;
		int var9 = var8 + this.field2959;
		int var10 = this.field2965;
		int var11 = var10 + this.field2968;
		int var12 = this.field2960;
		int var13 = this.field2965;
		if (var4 < var8) {
			var12 = var4;
		} else if (var5 > var9) {
			var12 = var5 - this.field2959;
		}

		if (var6 < var10) {
			var13 = var6;
		} else if (var7 > var11) {
			var13 = var7 - this.field2968;
		}

		this.method1772(var12, var13);
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "5"
	)
	boolean method1839(int var1) {
		return var1 == 32 || var1 == 10 || var1 == 9;
	}

	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "844665494"
	)
	void method1840() {
		if (this.field2969 != null) {
			this.field2969.vmethod5708();
		}

	}

	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "0"
	)
	boolean method1841(int var1) {
		switch(this.field2955) {
		case 1:
			return Decimator.isAlphaNumeric((char)var1);
		case 2:
			return class135.isCharAlphabetic((char)var1);
		case 3:
			return IsaacCipher.isDigit((char)var1);
		case 4:
			char var2 = (char)var1;
			if (IsaacCipher.isDigit(var2)) {
				return true;
			} else {
				if (var2 != 'k' && var2 != 'K' && var2 != 'm' && var2 != 'M' && var2 != 'b' && var2 != 'B') {
					return false;
				}

				return true;
			}
		default:
			return true;
		}
	}

	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		descriptor = "(I)Ltw;",
		garbageValue = "-1694076835"
	)
	class500 method1842() {
		int var1 = this.field2972.method2097(this.field2959);
		int var2 = this.field2972.method2098(this.field2968);
		return new class500(var1, var2);
	}
}