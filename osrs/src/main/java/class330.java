import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mo")
public class class330 {
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lpt;"
	)
	class395 field2920;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lpt;"
	)
	class395 field2921;
	@ObfuscatedName("ao")
	boolean field2903;
	@ObfuscatedName("ac")
	boolean field2901;
	@ObfuscatedName("ak")
	int field2906;
	@ObfuscatedName("an")
	boolean field2902;
	@ObfuscatedName("af")
	int field2904;
	@ObfuscatedName("ai")
	int field2905;
	@ObfuscatedName("al")
	int field2907;
	@ObfuscatedName("bd")
	int field2910;
	@ObfuscatedName("bb")
	int field2909;
	@ObfuscatedName("bn")
	int field2912;
	@ObfuscatedName("ba")
	int field2908;
	@ObfuscatedName("bf")
	int field2911;
	@ObfuscatedName("bs")
	int field2916;
	@ObfuscatedName("bp")
	int field2914;
	@ObfuscatedName("bv")
	int field2917;
	@ObfuscatedName("bq")
	int field2915;
	@ObfuscatedName("bo")
	int field2913;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	class324 field2918;
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	class324 field2919;

	class330() {
		this.field2920 = new class395();
		this.field2921 = new class395();
		this.field2903 = false;
		this.field2901 = true;
		this.field2906 = 0;
		this.field2902 = false;
		this.field2904 = 0;
		this.field2905 = 0;
		this.field2907 = 0;
		this.field2910 = 0;
		this.field2909 = 0;
		this.field2912 = 0;
		this.field2908 = 0;
		this.field2911 = Integer.MAX_VALUE;
		this.field2916 = Integer.MAX_VALUE;
		this.field2914 = 0;
		this.field2917 = 0;
		this.field2915 = 0;
		this.field2913 = 0;
		this.field2920.method2005(1);
		this.field2921.method2005(1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-459181496"
	)
	void method1693() {
		this.field2906 = (this.field2906 + 1) % 60;
		if (this.field2908 > 0) {
			--this.field2908;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ZB)Z",
		garbageValue = "7"
	)
	public boolean method1694(boolean var1) {
		var1 = var1 && this.field2901;
		boolean var2 = this.field2903 != var1;
		this.field2903 = var1;
		if (!this.field2903) {
			this.method1718(this.field2910, this.field2910);
		}

		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1718362437"
	)
	public void method1695(boolean var1) {
		this.field2901 = var1;
		this.field2903 = var1 && this.field2903;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Z",
		garbageValue = "-14"
	)
	boolean method1696(String var1) {
		String var2 = this.field2920.method2000();
		if (!var2.equals(var1)) {
			var1 = this.method1762(var1);
			this.field2920.method2012(var1);
			this.method1703(this.field2915, this.field2913);
			this.method1766();
			this.method1771();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "8373002"
	)
	boolean method1697(String var1) {
		this.field2921.method2012(var1);
		return true;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lpq;I)Z",
		garbageValue = "-1919649797"
	)
	boolean method1698(AbstractFont var1) {
		boolean var2 = !this.field2902;
		this.field2920.method2004(var1);
		this.field2921.method2004(var1);
		this.field2902 = true;
		var2 |= this.method1703(this.field2915, this.field2913);
		var2 |= this.method1718(this.field2909, this.field2910);
		if (this.method1766()) {
			this.method1771();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "1432554130"
	)
	public boolean method1699(int var1, int var2) {
		boolean var3 = this.field2914 != var1 || var2 != this.field2917;
		this.field2914 = var1;
		this.field2917 = var2;
		var3 |= this.method1703(this.field2915, this.field2913);
		return var3;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-40"
	)
	public boolean method1700(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var2 = var1 == this.field2920.method2024();
		this.field2920.method2001(var1);
		this.field2921.method2001(var1);
		if (this.method1766()) {
			this.method1771();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "14"
	)
	public boolean method1701(int var1) {
		this.field2920.method2002(var1);
		if (this.method1766()) {
			this.method1771();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "569863727"
	)
	public boolean method1702(int var1) {
		this.field2916 = var1;
		if (this.method1766()) {
			this.method1771();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "217776537"
	)
	public boolean method1703(int var1, int var2) {
		if (!this.method1750()) {
			this.field2915 = var1;
			this.field2913 = var2;
			return false;
		} else {
			int var3 = this.field2915;
			int var4 = this.field2913;
			int var5 = Math.max(0, this.field2920.method2018() - this.field2914 + 2);
			int var6 = Math.max(0, this.field2920.method2019() - this.field2917 + 1);
			this.field2915 = Math.max(0, Math.min(var5, var1));
			this.field2913 = Math.max(0, Math.min(var6, var2));
			return var3 != this.field2915 || var4 != this.field2913;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIS)Z",
		garbageValue = "-1284"
	)
	public boolean method1704(int var1, int var2) {
		boolean var3 = true;
		if (var1 < 0 || var1 > 2) {
			var3 = false;
		}

		if (var2 < 0 || var2 > 2) {
			var3 = false;
		}

		return var3 ? this.field2920.method2006(var1, var2) : false;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1785897338"
	)
	public void method1705(int var1) {
		this.field2920.method2007(var1);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-39"
	)
	public void method1706(int var1) {
		this.field2904 = var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "591098801"
	)
	public void method1707(int var1) {
		this.field2920.method2005(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1778164479"
	)
	public void method1708(int var1) {
		this.field2920.method2003(var1);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "2124230223"
	)
	public boolean method1709(int var1) {
		this.field2907 = var1;
		String var2 = this.field2920.method2000();
		int var3 = var2.length();
		var2 = this.method1762(var2);
		if (var2.length() != var3) {
			this.field2920.method2012(var2);
			this.method1703(this.field2915, this.field2913);
			this.method1766();
			this.method1771();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1676900457"
	)
	public void method1710() {
		this.field2902 = false;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "2097619146"
	)
	public boolean method1711(int var1) {
		if (this.method1772(var1)) {
			this.method1716();
			class396 var2 = this.field2920.method2009((char)var1, this.field2910, this.field2911);
			this.method1718(var2.method2038(), var2.method2038());
			this.method1766();
			this.method1771();
		}

		return true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "639045291"
	)
	public void method1712() {
		if (!this.method1716() && this.field2910 > 0) {
			int var1 = this.field2920.method2014(this.field2910 - 1);
			this.method1771();
			this.method1718(var1, var1);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1560455499"
	)
	public void method1713() {
		if (!this.method1716() && this.field2910 < this.field2920.method1999()) {
			int var1 = this.field2920.method2014(this.field2910);
			this.method1771();
			this.method1718(var1, var1);
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1632298723"
	)
	public void method1714() {
		if (!this.method1716() && this.field2910 > 0) {
			class486 var1 = this.method1764(this.field2910 - 1);
			int var2 = this.field2920.method2015((Integer)var1.field4036, this.field2910);
			this.method1771();
			this.method1718(var2, var2);
		}

	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "45"
	)
	public void method1715() {
		if (!this.method1716() && this.field2910 < this.field2920.method1999()) {
			class486 var1 = this.method1764(this.field2910);
			int var2 = this.field2920.method2015(this.field2910, (Integer)var1.field4037);
			this.method1771();
			this.method1718(var2, var2);
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "809245355"
	)
	boolean method1716() {
		if (!this.method1761()) {
			return false;
		} else {
			int var1 = this.field2920.method2015(this.field2909, this.field2910);
			this.method1771();
			this.method1718(var1, var1);
			return true;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-636827836"
	)
	public void method1717() {
		this.method1718(0, this.field2920.method1999());
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-47"
	)
	public boolean method1718(int var1, int var2) {
		if (!this.method1750()) {
			this.field2909 = var1;
			this.field2910 = var2;
			return false;
		} else {
			if (var1 > this.field2920.method1999()) {
				var1 = this.field2920.method1999();
			}

			if (var2 > this.field2920.method1999()) {
				var2 = this.field2920.method1999();
			}

			boolean var3 = this.field2909 != var1 || var2 != this.field2910;
			this.field2909 = var1;
			if (var2 != this.field2910) {
				this.field2910 = var2;
				this.field2906 = 0;
				this.method1769();
			}

			if (var3 && this.field2919 != null) {
				this.field2919.vmethod5708();
			}

			return var3;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "112"
	)
	public void method1719(boolean var1) {
		class486 var2 = this.method1765(this.field2910);
		this.method1767((Integer)var2.field4036, var1);
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "647132311"
	)
	public void method1720(boolean var1) {
		class486 var2 = this.method1765(this.field2910);
		this.method1767((Integer)var2.field4037, var1);
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "26"
	)
	public void method1721(boolean var1) {
		this.method1767(0, var1);
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "109"
	)
	public void method1722(boolean var1) {
		this.method1767(this.field2920.method1999(), var1);
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "483744415"
	)
	public void method1723(boolean var1) {
		if (this.method1761() && !var1) {
			this.method1767(Math.min(this.field2909, this.field2910), var1);
		} else if (this.field2910 > 0) {
			this.method1767(this.field2910 - 1, var1);
		}

	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "424331931"
	)
	public void method1724(boolean var1) {
		if (this.method1761() && !var1) {
			this.method1767(Math.max(this.field2909, this.field2910), var1);
		} else if (this.field2910 < this.field2920.method1999()) {
			this.method1767(this.field2910 + 1, var1);
		}

	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1838680706"
	)
	public void method1725(boolean var1) {
		if (this.field2910 > 0) {
			class486 var2 = this.method1764(this.field2910 - 1);
			this.method1767((Integer)var2.field4036, var1);
		}

	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-127"
	)
	public void method1726(boolean var1) {
		if (this.field2910 < this.field2920.method1999()) {
			class486 var2 = this.method1764(this.field2910 + 1);
			this.method1767((Integer)var2.field4037, var1);
		}

	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-31746529"
	)
	public void method1727(boolean var1) {
		if (this.field2910 > 0) {
			this.method1767(this.field2920.method2017(this.field2910, -1), var1);
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "593239666"
	)
	public void method1728(boolean var1) {
		if (this.field2910 < this.field2920.method1999()) {
			this.method1767(this.field2920.method2017(this.field2910, 1), var1);
		}

	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-35"
	)
	public void method1729(boolean var1) {
		if (this.field2910 > 0) {
			int var2 = this.method1768();
			this.method1767(this.field2920.method2017(this.field2910, -var2), var1);
		}

	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "46"
	)
	public void method1730(boolean var1) {
		if (this.field2910 < this.field2920.method1999()) {
			int var2 = this.method1768();
			this.method1767(this.field2920.method2017(this.field2910, var2), var1);
		}

	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "1"
	)
	public void method1731(boolean var1) {
		class399 var2 = this.field2920.method2008(0, this.field2910);
		class486 var3 = var2.method2080();
		this.method1767(this.field2920.method2016((Integer)var3.field4036, this.field2913), var1);
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1784409030"
	)
	public void method1732(boolean var1) {
		class399 var2 = this.field2920.method2008(0, this.field2910);
		class486 var3 = var2.method2080();
		this.method1767(this.field2920.method2016((Integer)var3.field4036, this.field2913 + this.field2917), var1);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(IIZZI)V",
		garbageValue = "-1784719026"
	)
	public void method1733(int var1, int var2, boolean var3, boolean var4) {
		boolean var5 = false;
		class486 var6;
		int var8;
		if (!this.field2902) {
			var8 = 0;
		} else {
			var1 += this.field2915;
			var2 += this.field2913;
			var6 = this.method1773();
			var8 = this.field2920.method2016(var1 - (Integer)var6.field4036, var2 - (Integer)var6.field4037);
		}

		if (var3 && var4) {
			this.field2905 = 1;
			var6 = this.method1764(var8);
			class486 var7 = this.method1764(this.field2912);
			this.method1763(var7, var6);
		} else if (var3) {
			this.field2905 = 1;
			var6 = this.method1764(var8);
			this.method1718((Integer)var6.field4036, (Integer)var6.field4037);
			this.field2912 = (Integer)var6.field4036;
		} else if (var4) {
			this.method1718(this.field2912, var8);
		} else {
			if (this.field2908 > 0 && var8 == this.field2912) {
				if (this.field2910 == this.field2909) {
					this.field2905 = 1;
					var6 = this.method1764(var8);
					this.method1718((Integer)var6.field4036, (Integer)var6.field4037);
				} else {
					this.field2905 = 2;
					var6 = this.method1765(var8);
					this.method1718((Integer)var6.field4036, (Integer)var6.field4037);
				}
			} else {
				this.field2905 = 0;
				this.method1718(var8, var8);
				this.field2912 = var8;
			}

			this.field2908 = 25;
		}

	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1833413853"
	)
	public void method1734(int var1, int var2) {
		if (this.field2902 && this.method1745()) {
			var1 += this.field2915;
			var2 += this.field2913;
			class486 var3 = this.method1773();
			int var4 = this.field2920.method2016(var1 - (Integer)var3.field4036, var2 - (Integer)var3.field4037);
			class486 var5;
			class486 var6;
			switch(this.field2905) {
			case 0:
				this.method1718(this.field2909, var4);
				break;
			case 1:
				var5 = this.method1764(this.field2912);
				var6 = this.method1764(var4);
				this.method1763(var5, var6);
				break;
			case 2:
				var5 = this.method1765(this.field2912);
				var6 = this.method1765(var4);
				this.method1763(var5, var6);
			}
		}

	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;B)V",
		garbageValue = "47"
	)
	public void method1735(Clipboard var1) {
		class399 var2 = this.field2920.method2008(this.field2909, this.field2910);
		if (!var2.method2076()) {
			String var3 = var2.method2074();
			if (!var3.isEmpty()) {
				var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
			}
		}

	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "189356475"
	)
	public void method1736(Clipboard var1) {
		if (this.method1761()) {
			this.method1735(var1);
			this.method1716();
		}

	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "284807230"
	)
	public void method1737(Clipboard var1) {
		Transferable var2 = var1.getContents((Object)null);
		if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var3 = this.method1762((String)var2.getTransferData(DataFlavor.stringFlavor));
				this.method1716();
				class396 var4 = this.field2920.method2010(var3, this.field2910, this.field2911);
				this.method1718(var4.method2038(), var4.method2038());
				this.method1766();
				this.method1771();
			} catch (Exception var5) {
			}
		}

	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-121"
	)
	public void method1738() {
		this.field2913 = Math.max(0, this.field2913 - this.field2920.method2021());
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-119"
	)
	public void method1739() {
		int var1 = Math.max(0, this.field2920.method2019() - this.field2917);
		this.field2913 = Math.min(var1, this.field2913 + this.field2920.method2021());
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(Lmv;B)V",
		garbageValue = "26"
	)
	public void method1740(class324 var1) {
		this.field2918 = var1;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Lmv;I)V",
		garbageValue = "-2108435148"
	)
	public void method1741(class324 var1) {
		this.field2919 = var1;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(I)Lpt;",
		garbageValue = "-1669614004"
	)
	public class395 method1742() {
		return this.field2920;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(B)Lpt;",
		garbageValue = "25"
	)
	public class395 method1743() {
		return this.field2921;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(B)Lpo;",
		garbageValue = "2"
	)
	public class399 method1744() {
		return this.field2920.method2008(this.field2909, this.field2910);
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1934970333"
	)
	public boolean method1745() {
		return this.field2903;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1635187775"
	)
	public boolean method1746() {
		return this.field2901;
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-3"
	)
	public boolean method1747() {
		return this.method1745() && this.field2906 % 60 < 30;
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1735474606"
	)
	public int method1748() {
		return this.field2910;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-912146623"
	)
	public int method1749() {
		return this.field2909;
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-72"
	)
	public boolean method1750() {
		return this.field2902;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1863338129"
	)
	public int method1751() {
		return this.field2915;
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "56"
	)
	public int method1752() {
		return this.field2913;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1605906220"
	)
	public int method1753() {
		return this.field2920.method2024();
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1275690994"
	)
	public int method1754() {
		return this.field2920.method2025();
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "27"
	)
	public int method1755() {
		return this.field2916;
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2058718198"
	)
	public int method1756() {
		return this.field2904;
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "61"
	)
	public int method1757() {
		return this.field2920.method2026();
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "85673603"
	)
	public int method1758() {
		return this.field2907;
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	public int method1759() {
		return this.field2920.method2027();
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "-26300"
	)
	public boolean method1760() {
		return this.method1754() > 1;
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1024988634"
	)
	boolean method1761() {
		return this.field2910 != this.field2909;
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "755561266"
	)
	String method1762(String var1) {
		StringBuilder var2 = new StringBuilder(var1.length());

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			char var4 = var1.charAt(var3);
			if (this.method1772(var4)) {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "(Lsf;Lsf;I)V",
		garbageValue = "1987987448"
	)
	void method1763(class486 var1, class486 var2) {
		if ((Integer)var2.field4036 < (Integer)var1.field4036) {
			this.method1718((Integer)var1.field4037, (Integer)var2.field4036);
		} else {
			this.method1718((Integer)var1.field4036, (Integer)var2.field4037);
		}

	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "(IB)Lsf;",
		garbageValue = "42"
	)
	class486 method1764(int var1) {
		int var2 = this.field2920.method1999();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.method1770(this.field2920.method1995(var5 - 1).field3671)) {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.method1770(this.field2920.method1995(var5).field3671)) {
				var4 = var5;
				break;
			}
		}

		return new class486(var3, var4);
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(II)Lsf;",
		garbageValue = "1047123828"
	)
	class486 method1765(int var1) {
		int var2 = this.field2920.method1999();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.field2920.method1995(var5 - 1).field3671 == '\n') {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.field2920.method1995(var5).field3671 == '\n') {
				var4 = var5;
				break;
			}
		}

		return new class486(var3, var4);
	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1532809681"
	)
	boolean method1766() {
		if (!this.method1750()) {
			return false;
		} else {
			boolean var1 = false;
			if (this.field2920.method1999() > this.field2916) {
				this.field2920.method2015(this.field2916, this.field2920.method1999());
				var1 = true;
			}

			int var2 = this.method1754();
			int var3;
			if (this.field2920.method2022() > var2) {
				var3 = this.field2920.method2017(0, var2) - 1;
				this.field2920.method2015(var3, this.field2920.method1999());
				var1 = true;
			}

			if (var1) {
				var3 = this.field2910;
				int var4 = this.field2909;
				int var5 = this.field2920.method1999();
				if (this.field2910 > var5) {
					var3 = var5;
				}

				if (this.field2909 > var5) {
					var4 = var5;
				}

				this.method1718(var4, var3);
			}

			return var1;
		}
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "-1065241721"
	)
	void method1767(int var1, boolean var2) {
		if (var2) {
			this.method1718(this.field2909, var1);
		} else {
			this.method1718(var1, var1);
		}

	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1134475135"
	)
	int method1768() {
		return this.field2917 / this.field2920.method2021();
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-886757584"
	)
	void method1769() {
		class399 var1 = this.field2920.method2008(0, this.field2910);
		class486 var2 = var1.method2080();
		int var3 = this.field2920.method2021();
		int var4 = (Integer)var2.field4036 - 10;
		int var5 = var4 + 20;
		int var6 = (Integer)var2.field4037 - 3;
		int var7 = var3 + var6 + 6;
		int var8 = this.field2915;
		int var9 = var8 + this.field2914;
		int var10 = this.field2913;
		int var11 = var10 + this.field2917;
		int var12 = this.field2915;
		int var13 = this.field2913;
		if (var4 < var8) {
			var12 = var4;
		} else if (var5 > var9) {
			var12 = var5 - this.field2914;
		}

		if (var6 < var10) {
			var13 = var6;
		} else if (var7 > var11) {
			var13 = var7 - this.field2917;
		}

		this.method1703(var12, var13);
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-2093013908"
	)
	boolean method1770(int var1) {
		return var1 == 32 || var1 == 10 || var1 == 9;
	}

	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "203184236"
	)
	void method1771() {
		if (this.field2918 != null) {
			this.field2918.vmethod5708();
		}

	}

	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "98"
	)
	boolean method1772(int var1) {
		switch(this.field2907) {
		case 1:
			return class126.isAlphaNumeric((char)var1);
		case 2:
			return Canvas.isCharAlphabetic((char)var1);
		case 3:
			return class164.isDigit((char)var1);
		case 4:
			char var2 = (char)var1;
			if (class164.isDigit(var2)) {
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

	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		descriptor = "(B)Lsf;",
		garbageValue = "0"
	)
	class486 method1773() {
		int var1 = this.field2920.method2028(this.field2914);
		int var2 = this.field2920.method2029(this.field2917);
		return new class486(var1, var2);
	}

	@ObfuscatedName("ar")
	static int method1692(long var0) {
		return (int)(var0 >>> 0 & 127L);
	}
}
