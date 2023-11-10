import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.datatransfer.*;

@ObfuscatedName("ni")
public class class341 {
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lpv;"
	)
	class406 field2969;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lpv;"
	)
	class406 field2970;
	@ObfuscatedName("ai")
	boolean field2950;
	@ObfuscatedName("aw")
	boolean field2952;
	@ObfuscatedName("ae")
	int field2954;
	@ObfuscatedName("an")
	boolean field2951;
	@ObfuscatedName("ag")
	int field2956;
	@ObfuscatedName("ad")
	int field2953;
	@ObfuscatedName("af")
	int field2955;
	@ObfuscatedName("be")
	int field2959;
	@ObfuscatedName("bd")
	int field2958;
	@ObfuscatedName("bl")
	int field2963;
	@ObfuscatedName("bi")
	int field2962;
	@ObfuscatedName("bv")
	int field2966;
	@ObfuscatedName("bf")
	int field2960;
	@ObfuscatedName("bg")
	int field2961;
	@ObfuscatedName("ba")
	int field2957;
	@ObfuscatedName("bm")
	int field2964;
	@ObfuscatedName("bp")
	int field2965;
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "Lmc;"
	)
	class334 field2968;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Lmc;"
	)
	class334 field2967;

	class341() {
		this.field2969 = new class406();
		this.field2970 = new class406();
		this.field2950 = false;
		this.field2952 = true;
		this.field2954 = 0;
		this.field2951 = false;
		this.field2956 = 0;
		this.field2953 = 0;
		this.field2955 = 0;
		this.field2959 = 0;
		this.field2958 = 0;
		this.field2963 = 0;
		this.field2962 = 0;
		this.field2966 = Integer.MAX_VALUE;
		this.field2960 = Integer.MAX_VALUE;
		this.field2961 = 0;
		this.field2957 = 0;
		this.field2964 = 0;
		this.field2965 = 0;
		this.field2969.method2062(1);
		this.field2970.method2062(1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	void method1758() {
		this.field2954 = (this.field2954 + 1) % 60;
		if (this.field2962 > 0) {
			--this.field2962;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ZI)Z",
		garbageValue = "-1199149744"
	)
	public boolean method1759(boolean var1) {
		var1 = var1 && this.field2952;
		boolean var2 = this.field2950 != var1;
		this.field2950 = var1;
		if (!this.field2950) {
			this.method1783(this.field2959, this.field2959);
		}

		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "18331512"
	)
	public void method1760(boolean var1) {
		this.field2952 = var1;
		this.field2950 = var1 && this.field2950;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Z",
		garbageValue = "1"
	)
	public boolean method1761(String var1) {
		String var2 = this.field2969.method2056();
		if (!var2.equals(var1)) {
			var1 = this.method1827(var1);
			this.field2969.method2069(var1);
			this.method1783(this.field2958, this.field2959);
			this.method1768(this.field2964, this.field2965);
			this.method1831();
			this.method1836();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Z",
		garbageValue = "-65"
	)
	boolean method1762(String var1) {
		this.field2970.method2069(var1);
		return true;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lpa;B)Z",
		garbageValue = "116"
	)
	boolean method1763(AbstractFont var1) {
		boolean var2 = !this.field2951;
		this.field2969.method2061(var1);
		this.field2970.method2061(var1);
		this.field2951 = true;
		var2 |= this.method1768(this.field2964, this.field2965);
		var2 |= this.method1783(this.field2958, this.field2959);
		if (this.method1831()) {
			this.method1836();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "101"
	)
	public boolean method1764(int var1, int var2) {
		boolean var3 = this.field2961 != var1 || var2 != this.field2957;
		this.field2961 = var1;
		this.field2957 = var2;
		var3 |= this.method1768(this.field2964, this.field2965);
		return var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-229674282"
	)
	public boolean method1765(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var2 = var1 == this.field2969.method2080();
		this.field2969.method2057(var1);
		this.field2970.method2057(var1);
		if (this.method1831()) {
			this.method1836();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "8"
	)
	public boolean method1766(int var1) {
		this.field2969.method2059(var1);
		if (this.method1831()) {
			this.method1836();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "117249639"
	)
	public boolean method1767(int var1) {
		this.field2960 = var1;
		if (this.method1831()) {
			this.method1836();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-285626466"
	)
	public boolean method1768(int var1, int var2) {
		if (!this.method1815()) {
			this.field2964 = var1;
			this.field2965 = var2;
			return false;
		} else {
			int var3 = this.field2964;
			int var4 = this.field2965;
			int var5 = Math.max(0, this.field2969.method2075() - this.field2961 + 2);
			int var6 = Math.max(0, this.field2969.method2076() - this.field2957 + 1);
			this.field2964 = Math.max(0, Math.min(var5, var1));
			this.field2965 = Math.max(0, Math.min(var6, var2));
			return var3 != this.field2964 || var4 != this.field2965;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "18"
	)
	public boolean method1769(int var1, int var2) {
		boolean var3 = true;
		if (var1 < 0 || var1 > 2) {
			var3 = false;
		}

		if (var2 < 0 || var2 > 2) {
			var3 = false;
		}

		return var3 ? this.field2969.method2063(var1, var2) : false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-56"
	)
	public void method1770(int var1) {
		this.field2969.method2064(var1);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-15"
	)
	public void method1771(int var1) {
		this.field2956 = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "312320630"
	)
	public void method1772(int var1) {
		this.field2969.method2062(var1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1049067680"
	)
	public void method1773(int var1) {
		this.field2969.method2060(var1);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1504264243"
	)
	public boolean method1774(int var1) {
		this.field2955 = var1;
		String var2 = this.field2969.method2056();
		int var3 = var2.length();
		var2 = this.method1827(var2);
		if (var2.length() != var3) {
			this.field2969.method2069(var2);
			this.method1768(this.field2964, this.field2965);
			this.method1831();
			this.method1836();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "611320825"
	)
	public void method1775() {
		this.field2951 = false;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1918004716"
	)
	public boolean method1776(int var1) {
		if (this.method1837(var1)) {
			this.method1781();
			class407 var2 = this.field2969.method2066((char)var1, this.field2959, this.field2966);
			this.method1783(var2.method2094(), var2.method2094());
			this.method1831();
			this.method1836();
		}

		return true;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "125"
	)
	public void method1777() {
		if (!this.method1781() && this.field2959 > 0) {
			int var1 = this.field2969.method2071(this.field2959 - 1);
			this.method1836();
			this.method1783(var1, var1);
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1496895197"
	)
	public void method1778() {
		if (!this.method1781() && this.field2959 < this.field2969.method2055()) {
			int var1 = this.field2969.method2071(this.field2959);
			this.method1836();
			this.method1783(var1, var1);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "2"
	)
	public void method1779() {
		if (!this.method1781() && this.field2959 > 0) {
			class497 var1 = this.method1829(this.field2959 - 1);
			int var2 = this.field2969.method2072((Integer)var1.field4074, this.field2959);
			this.method1836();
			this.method1783(var2, var2);
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "576864564"
	)
	public void method1780() {
		if (!this.method1781() && this.field2959 < this.field2969.method2055()) {
			class497 var1 = this.method1829(this.field2959);
			int var2 = this.field2969.method2072(this.field2959, (Integer)var1.field4073);
			this.method1836();
			this.method1783(var2, var2);
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1514418987"
	)
	boolean method1781() {
		if (!this.method1826()) {
			return false;
		} else {
			int var1 = this.field2969.method2072(this.field2958, this.field2959);
			this.method1836();
			this.method1783(var1, var1);
			return true;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "154519165"
	)
	public void method1782() {
		this.method1783(0, this.field2969.method2055());
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "1917418195"
	)
	public boolean method1783(int var1, int var2) {
		if (!this.method1815()) {
			this.field2958 = var1;
			this.field2959 = var2;
			return false;
		} else {
			if (var1 > this.field2969.method2055()) {
				var1 = this.field2969.method2055();
			}

			if (var2 > this.field2969.method2055()) {
				var2 = this.field2969.method2055();
			}

			boolean var3 = this.field2958 != var1 || var2 != this.field2959;
			this.field2958 = var1;
			if (var2 != this.field2959) {
				this.field2959 = var2;
				this.field2954 = 0;
				this.method1834();
			}

			if (var3 && this.field2967 != null) {
				this.field2967.vmethod5708();
			}

			return var3;
		}
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "64"
	)
	public void method1784(boolean var1) {
		class497 var2 = this.method1830(this.field2959);
		this.method1832((Integer)var2.field4074, var1);
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-114"
	)
	public void method1785(boolean var1) {
		class497 var2 = this.method1830(this.field2959);
		this.method1832((Integer)var2.field4073, var1);
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "941946265"
	)
	public void method1786(boolean var1) {
		this.method1832(0, var1);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "2021236230"
	)
	public void method1787(boolean var1) {
		this.method1832(this.field2969.method2055(), var1);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1171552759"
	)
	public void method1788(boolean var1) {
		if (this.method1826() && !var1) {
			this.method1832(Math.min(this.field2958, this.field2959), var1);
		} else if (this.field2959 > 0) {
			this.method1832(this.field2959 - 1, var1);
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-81"
	)
	public void method1789(boolean var1) {
		if (this.method1826() && !var1) {
			this.method1832(Math.max(this.field2958, this.field2959), var1);
		} else if (this.field2959 < this.field2969.method2055()) {
			this.method1832(this.field2959 + 1, var1);
		}

	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1880064758"
	)
	public void method1790(boolean var1) {
		if (this.field2959 > 0) {
			class497 var2 = this.method1829(this.field2959 - 1);
			this.method1832((Integer)var2.field4074, var1);
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-214351650"
	)
	public void method1791(boolean var1) {
		if (this.field2959 < this.field2969.method2055()) {
			class497 var2 = this.method1829(this.field2959 + 1);
			this.method1832((Integer)var2.field4073, var1);
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-2098854575"
	)
	public void method1792(boolean var1) {
		if (this.field2959 > 0) {
			this.method1832(this.field2969.method2074(this.field2959, -1), var1);
		}

	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "115"
	)
	public void method1793(boolean var1) {
		if (this.field2959 < this.field2969.method2055()) {
			this.method1832(this.field2969.method2074(this.field2959, 1), var1);
		}

	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1022985895"
	)
	public void method1794(boolean var1) {
		if (this.field2959 > 0) {
			int var2 = this.method1833();
			this.method1832(this.field2969.method2074(this.field2959, -var2), var1);
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-828148265"
	)
	public void method1795(boolean var1) {
		if (this.field2959 < this.field2969.method2055()) {
			int var2 = this.method1833();
			this.method1832(this.field2969.method2074(this.field2959, var2), var1);
		}

	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-618248059"
	)
	public void method1796(boolean var1) {
		class410 var2 = this.field2969.method2065(0, this.field2959);
		class497 var3 = var2.method2137();
		this.method1832(this.field2969.method2073((Integer)var3.field4074, this.field2965), var1);
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-993585503"
	)
	public void method1797(boolean var1) {
		class410 var2 = this.field2969.method2065(0, this.field2959);
		class497 var3 = var2.method2137();
		this.method1832(this.field2969.method2073((Integer)var3.field4074, this.field2957 + this.field2965), var1);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(IIZZI)V",
		garbageValue = "470461038"
	)
	public void method1798(int var1, int var2, boolean var3, boolean var4) {
		boolean var5 = false;
		class497 var6;
		int var8;
		if (!this.field2951) {
			var8 = 0;
		} else {
			var1 += this.field2964;
			var2 += this.field2965;
			var6 = this.method1838();
			var8 = this.field2969.method2073(var1 - (Integer)var6.field4074, var2 - (Integer)var6.field4073);
		}

		if (var3 && var4) {
			this.field2953 = 1;
			var6 = this.method1829(var8);
			class497 var7 = this.method1829(this.field2963);
			this.method1828(var7, var6);
		} else if (var3) {
			this.field2953 = 1;
			var6 = this.method1829(var8);
			this.method1783((Integer)var6.field4074, (Integer)var6.field4073);
			this.field2963 = (Integer)var6.field4074;
		} else if (var4) {
			this.method1783(this.field2963, var8);
		} else {
			if (this.field2962 > 0 && var8 == this.field2963) {
				if (this.field2958 == this.field2959) {
					this.field2953 = 1;
					var6 = this.method1829(var8);
					this.method1783((Integer)var6.field4074, (Integer)var6.field4073);
				} else {
					this.field2953 = 2;
					var6 = this.method1830(var8);
					this.method1783((Integer)var6.field4074, (Integer)var6.field4073);
				}
			} else {
				this.field2953 = 0;
				this.method1783(var8, var8);
				this.field2963 = var8;
			}

			this.field2962 = 25;
		}

	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-292946076"
	)
	public void method1799(int var1, int var2) {
		if (this.field2951 && this.method1810()) {
			var1 += this.field2964;
			var2 += this.field2965;
			class497 var3 = this.method1838();
			int var4 = this.field2969.method2073(var1 - (Integer)var3.field4074, var2 - (Integer)var3.field4073);
			class497 var5;
			class497 var6;
			switch(this.field2953) {
			case 0:
				this.method1783(this.field2958, var4);
				break;
			case 1:
				var5 = this.method1829(this.field2963);
				var6 = this.method1829(var4);
				this.method1828(var5, var6);
				break;
			case 2:
				var5 = this.method1830(this.field2963);
				var6 = this.method1830(var4);
				this.method1828(var5, var6);
			}
		}

	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "-307910360"
	)
	public void method1800(Clipboard var1) {
		class410 var2 = this.field2969.method2065(this.field2958, this.field2959);
		if (!var2.method2133()) {
			String var3 = var2.method2131();
			if (!var3.isEmpty()) {
				var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
			}
		}

	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "2135903606"
	)
	public void method1801(Clipboard var1) {
		if (this.method1826()) {
			this.method1800(var1);
			this.method1781();
		}

	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "1435827067"
	)
	public void method1802(Clipboard var1) {
		Transferable var2 = var1.getContents((Object)null);
		if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var3 = this.method1827((String)var2.getTransferData(DataFlavor.stringFlavor));
				this.method1781();
				class407 var4 = this.field2969.method2067(var3, this.field2959, this.field2966);
				this.method1783(var4.method2094(), var4.method2094());
				this.method1831();
				this.method1836();
			} catch (Exception var5) {
			}
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-288828294"
	)
	public void method1803() {
		this.field2965 = Math.max(0, this.field2965 - this.field2969.method2077());
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "34"
	)
	public void method1804() {
		int var1 = Math.max(0, this.field2969.method2076() - this.field2957);
		this.field2965 = Math.min(var1, this.field2965 + this.field2969.method2077());
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(Lmc;I)V",
		garbageValue = "-1869847655"
	)
	public void method1805(class334 var1) {
		this.field2968 = var1;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(Lmc;I)V",
		garbageValue = "-1051047872"
	)
	public void method1806(class334 var1) {
		this.field2967 = var1;
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(I)Lpv;",
		garbageValue = "2075539041"
	)
	public class406 method1807() {
		return this.field2969;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)Lpv;",
		garbageValue = "1030146297"
	)
	public class406 method1808() {
		return this.field2970;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(B)Lpd;",
		garbageValue = "126"
	)
	public class410 method1809() {
		return this.field2969.method2065(this.field2958, this.field2959);
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2065405253"
	)
	public boolean method1810() {
		return this.field2950;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "32"
	)
	public boolean method1811() {
		return this.field2952;
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "1"
	)
	public boolean method1812() {
		return this.method1810() && this.field2954 % 60 < 30;
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	public int method1813() {
		return this.field2959;
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-93"
	)
	public int method1814() {
		return this.field2958;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1339355429"
	)
	public boolean method1815() {
		return this.field2951;
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-914270657"
	)
	public int method1816() {
		return this.field2964;
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-59337247"
	)
	public int method1817() {
		return this.field2965;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "183448923"
	)
	public int method1818() {
		return this.field2969.method2080();
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1901590514"
	)
	public int method1819() {
		return this.field2969.method2081();
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "433958524"
	)
	public int method1820() {
		return this.field2960;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "27"
	)
	public int method1821() {
		return this.field2956;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1220088206"
	)
	public int method1822() {
		return this.field2969.method2082();
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "8"
	)
	public int method1823() {
		return this.field2955;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1771864931"
	)
	public int method1824() {
		return this.field2969.method2083();
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "48"
	)
	public boolean method1825() {
		return this.method1819() > 1;
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-760216869"
	)
	boolean method1826() {
		return this.field2959 != this.field2958;
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-79"
	)
	String method1827(String var1) {
		StringBuilder var2 = new StringBuilder(var1.length());

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			char var4 = var1.charAt(var3);
			if (this.method1837(var4)) {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(Lti;Lti;I)V",
		garbageValue = "-1148711859"
	)
	void method1828(class497 var1, class497 var2) {
		if ((Integer)var2.field4074 < (Integer)var1.field4074) {
			this.method1783((Integer)var1.field4073, (Integer)var2.field4074);
		} else {
			this.method1783((Integer)var1.field4074, (Integer)var2.field4073);
		}

	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "(II)Lti;",
		garbageValue = "377951962"
	)
	class497 method1829(int var1) {
		int var2 = this.field2969.method2055();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.method1835(this.field2969.method2051(var5 - 1).field3716)) {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.method1835(this.field2969.method2051(var5).field3716)) {
				var4 = var5;
				break;
			}
		}

		return new class497(var3, var4);
	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		descriptor = "(II)Lti;",
		garbageValue = "-1182045499"
	)
	class497 method1830(int var1) {
		int var2 = this.field2969.method2055();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.field2969.method2051(var5 - 1).field3716 == '\n') {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.field2969.method2051(var5).field3716 == '\n') {
				var4 = var5;
				break;
			}
		}

		return new class497(var3, var4);
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1603465990"
	)
	boolean method1831() {
		if (!this.method1815()) {
			return false;
		} else {
			boolean var1 = false;
			if (this.field2969.method2055() > this.field2960) {
				this.field2969.method2072(this.field2960, this.field2969.method2055());
				var1 = true;
			}

			int var2 = this.method1819();
			int var3;
			if (this.field2969.method2078() > var2) {
				var3 = this.field2969.method2074(0, var2) - 1;
				this.field2969.method2072(var3, this.field2969.method2055());
				var1 = true;
			}

			if (var1) {
				var3 = this.field2959;
				int var4 = this.field2958;
				int var5 = this.field2969.method2055();
				if (this.field2959 > var5) {
					var3 = var5;
				}

				if (this.field2958 > var5) {
					var4 = var5;
				}

				this.method1783(var4, var3);
			}

			return var1;
		}
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "2086601547"
	)
	void method1832(int var1, boolean var2) {
		if (var2) {
			this.method1783(this.field2958, var1);
		} else {
			this.method1783(var1, var1);
		}

	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-1"
	)
	int method1833() {
		return this.field2957 / this.field2969.method2077();
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1786950999"
	)
	void method1834() {
		class410 var1 = this.field2969.method2065(0, this.field2959);
		class497 var2 = var1.method2137();
		int var3 = this.field2969.method2077();
		int var4 = (Integer)var2.field4074 - 10;
		int var5 = var4 + 20;
		int var6 = (Integer)var2.field4073 - 3;
		int var7 = var3 + var6 + 6;
		int var8 = this.field2964;
		int var9 = var8 + this.field2961;
		int var10 = this.field2965;
		int var11 = var10 + this.field2957;
		int var12 = this.field2964;
		int var13 = this.field2965;
		if (var4 < var8) {
			var12 = var4;
		} else if (var5 > var9) {
			var12 = var5 - this.field2961;
		}

		if (var6 < var10) {
			var13 = var6;
		} else if (var7 > var11) {
			var13 = var7 - this.field2957;
		}

		this.method1768(var12, var13);
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "1"
	)
	boolean method1835(int var1) {
		return var1 == 32 || var1 == 10 || var1 == 9;
	}

	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "336"
	)
	void method1836() {
		if (this.field2968 != null) {
			this.field2968.vmethod5708();
		}

	}

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1431244165"
	)
	boolean method1837(int var1) {
		switch(this.field2955) {
		case 1:
			return KeyHandler.isAlphaNumeric((char)var1);
		case 2:
			return class10.isCharAlphabetic((char)var1);
		case 3:
			return Player.isDigit((char)var1);
		case 4:
			char var2 = (char)var1;
			if (Player.isDigit(var2)) {
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

	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		descriptor = "(I)Lti;",
		garbageValue = "-306061048"
	)
	class497 method1838() {
		int var1 = this.field2969.method2084(this.field2961);
		int var2 = this.field2969.method2085(this.field2957);
		return new class497(var1, var2);
	}
}