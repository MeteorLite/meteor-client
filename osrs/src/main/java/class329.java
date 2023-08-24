import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.datatransfer.*;

@ObfuscatedName("mb")
public class class329 {
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lpj;"
	)
	class394 field2938;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lpj;"
	)
	class394 field2939;
	@ObfuscatedName("ah")
	boolean field2919;
	@ObfuscatedName("as")
	boolean field2921;
	@ObfuscatedName("ay")
	int field2925;
	@ObfuscatedName("aj")
	boolean field2920;
	@ObfuscatedName("av")
	int field2923;
	@ObfuscatedName("aw")
	int field2924;
	@ObfuscatedName("ak")
	int field2922;
	@ObfuscatedName("bh")
	int field2928;
	@ObfuscatedName("bj")
	int field2929;
	@ObfuscatedName("bk")
	int field2930;
	@ObfuscatedName("bv")
	int field2934;
	@ObfuscatedName("bt")
	int field2933;
	@ObfuscatedName("bd")
	int field2926;
	@ObfuscatedName("by")
	int field2935;
	@ObfuscatedName("bs")
	int field2932;
	@ObfuscatedName("bm")
	int field2931;
	@ObfuscatedName("bf")
	int field2927;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "Lmf;"
	)
	class323 field2937;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "Lmf;"
	)
	class323 field2936;

	class329() {
		this.field2938 = new class394();
		this.field2939 = new class394();
		this.field2919 = false;
		this.field2921 = true;
		this.field2925 = 0;
		this.field2920 = false;
		this.field2923 = 0;
		this.field2924 = 0;
		this.field2922 = 0;
		this.field2928 = 0;
		this.field2929 = 0;
		this.field2930 = 0;
		this.field2934 = 0;
		this.field2933 = Integer.MAX_VALUE;
		this.field2926 = Integer.MAX_VALUE;
		this.field2935 = 0;
		this.field2932 = 0;
		this.field2931 = 0;
		this.field2927 = 0;
		this.field2938.method2046(1);
		this.field2939.method2046(1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "108"
	)
	void method1730() {
		this.field2925 = (this.field2925 + 1) % 60;
		if (this.field2934 > 0) {
			--this.field2934;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ZI)Z",
		garbageValue = "-1080189228"
	)
	public boolean method1731(boolean var1) {
		var1 = var1 && this.field2921;
		boolean var2 = this.field2919 != var1;
		this.field2919 = var1;
		if (!this.field2919) {
			this.method1755(this.field2928, this.field2928);
		}

		return var2;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "220495780"
	)
	public void method1732(boolean var1) {
		this.field2921 = var1;
		this.field2919 = var1 && this.field2919;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "-764154033"
	)
	boolean method1733(String var1) {
		String var2 = this.field2938.method2041();
		if (!var2.equals(var1)) {
			var1 = this.method1799(var1);
			this.field2938.method2054(var1);
			this.method1740(this.field2931, this.field2927);
			this.method1803();
			this.method1808();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Z",
		garbageValue = "0"
	)
	boolean method1734(String var1) {
		this.field2939.method2054(var1);
		return true;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lpk;B)Z",
		garbageValue = "2"
	)
	boolean method1735(AbstractFont var1) {
		boolean var2 = !this.field2920;
		this.field2938.method2045(var1);
		this.field2939.method2045(var1);
		this.field2920 = true;
		var2 |= this.method1740(this.field2931, this.field2927);
		var2 |= this.method1755(this.field2929, this.field2928);
		if (this.method1803()) {
			this.method1808();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-41"
	)
	public boolean method1736(int var1, int var2) {
		boolean var3 = this.field2935 != var1 || var2 != this.field2932;
		this.field2935 = var1;
		this.field2932 = var2;
		var3 |= this.method1740(this.field2931, this.field2927);
		return var3;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1183077231"
	)
	public boolean method1737(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var2 = var1 == this.field2938.method2065();
		this.field2938.method2042(var1);
		this.field2939.method2042(var1);
		if (this.method1803()) {
			this.method1808();
			var2 = true;
		}

		return var2;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-790356702"
	)
	public boolean method1738(int var1) {
		this.field2938.method2043(var1);
		if (this.method1803()) {
			this.method1808();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-34"
	)
	public boolean method1739(int var1) {
		this.field2926 = var1;
		if (this.method1803()) {
			this.method1808();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "1916065285"
	)
	public boolean method1740(int var1, int var2) {
		if (!this.method1787()) {
			this.field2931 = var1;
			this.field2927 = var2;
			return false;
		} else {
			int var3 = this.field2931;
			int var4 = this.field2927;
			int var5 = Math.max(0, this.field2938.method2060() - this.field2935 + 2);
			int var6 = Math.max(0, this.field2938.method2061() - this.field2932 + 1);
			this.field2931 = Math.max(0, Math.min(var5, var1));
			this.field2927 = Math.max(0, Math.min(var6, var2));
			return var3 != this.field2931 || var4 != this.field2927;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIS)Z",
		garbageValue = "-28947"
	)
	public boolean method1741(int var1, int var2) {
		boolean var3 = true;
		if (var1 < 0 || var1 > 2) {
			var3 = false;
		}

		if (var2 < 0 || var2 > 2) {
			var3 = false;
		}

		return var3 ? this.field2938.method2047(var1, var2) : false;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "105"
	)
	public void method1742(int var1) {
		this.field2938.method2048(var1);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "318624055"
	)
	public void method1743(int var1) {
		this.field2923 = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-745884306"
	)
	public void method1744(int var1) {
		this.field2938.method2046(var1);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "73"
	)
	public void method1745(int var1) {
		this.field2938.method2044(var1);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1266422233"
	)
	public boolean method1746(int var1) {
		this.field2922 = var1;
		String var2 = this.field2938.method2041();
		int var3 = var2.length();
		var2 = this.method1799(var2);
		if (var2.length() != var3) {
			this.field2938.method2054(var2);
			this.method1740(this.field2931, this.field2927);
			this.method1803();
			this.method1808();
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-313169923"
	)
	public void method1747() {
		this.field2920 = false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-88"
	)
	public boolean method1748(int var1) {
		if (this.method1809(var1)) {
			this.method1753();
			class395 var2 = this.field2938.method2050((char)var1, this.field2928, this.field2933);
			this.method1755(var2.method2078(), var2.method2078());
			this.method1803();
			this.method1808();
		}

		return true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1833500314"
	)
	public void method1749() {
		if (!this.method1753() && this.field2928 > 0) {
			int var1 = this.field2938.method2056(this.field2928 - 1);
			this.method1808();
			this.method1755(var1, var1);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "54"
	)
	public void method1750() {
		if (!this.method1753() && this.field2928 < this.field2938.method2040()) {
			int var1 = this.field2938.method2056(this.field2928);
			this.method1808();
			this.method1755(var1, var1);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-66"
	)
	public void method1751() {
		if (!this.method1753() && this.field2928 > 0) {
			class485 var1 = this.method1801(this.field2928 - 1);
			int var2 = this.field2938.method2057((Integer)var1.field4049, this.field2928);
			this.method1808();
			this.method1755(var2, var2);
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-43"
	)
	public void method1752() {
		if (!this.method1753() && this.field2928 < this.field2938.method2040()) {
			class485 var1 = this.method1801(this.field2928);
			int var2 = this.field2938.method2057(this.field2928, (Integer)var1.field4048);
			this.method1808();
			this.method1755(var2, var2);
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1216764682"
	)
	boolean method1753() {
		if (!this.method1798()) {
			return false;
		} else {
			int var1 = this.field2938.method2057(this.field2929, this.field2928);
			this.method1808();
			this.method1755(var1, var1);
			return true;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-70"
	)
	public void method1754() {
		this.method1755(0, this.field2938.method2040());
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "28215574"
	)
	public boolean method1755(int var1, int var2) {
		if (!this.method1787()) {
			this.field2929 = var1;
			this.field2928 = var2;
			return false;
		} else {
			if (var1 > this.field2938.method2040()) {
				var1 = this.field2938.method2040();
			}

			if (var2 > this.field2938.method2040()) {
				var2 = this.field2938.method2040();
			}

			boolean var3 = this.field2929 != var1 || var2 != this.field2928;
			this.field2929 = var1;
			if (var2 != this.field2928) {
				this.field2928 = var2;
				this.field2925 = 0;
				this.method1806();
			}

			if (var3 && this.field2936 != null) {
				this.field2936.vmethod5708();
			}

			return var3;
		}
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "67"
	)
	public void method1756(boolean var1) {
		class485 var2 = this.method1802(this.field2928);
		this.method1804((Integer)var2.field4049, var1);
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-86"
	)
	public void method1757(boolean var1) {
		class485 var2 = this.method1802(this.field2928);
		this.method1804((Integer)var2.field4048, var1);
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "103"
	)
	public void method1758(boolean var1) {
		this.method1804(0, var1);
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1079000340"
	)
	public void method1759(boolean var1) {
		this.method1804(this.field2938.method2040(), var1);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1431814125"
	)
	public void method1760(boolean var1) {
		if (this.method1798() && !var1) {
			this.method1804(Math.min(this.field2929, this.field2928), var1);
		} else if (this.field2928 > 0) {
			this.method1804(this.field2928 - 1, var1);
		}

	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1263469110"
	)
	public void method1761(boolean var1) {
		if (this.method1798() && !var1) {
			this.method1804(Math.max(this.field2929, this.field2928), var1);
		} else if (this.field2928 < this.field2938.method2040()) {
			this.method1804(this.field2928 + 1, var1);
		}

	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "-12006"
	)
	public void method1762(boolean var1) {
		if (this.field2928 > 0) {
			class485 var2 = this.method1801(this.field2928 - 1);
			this.method1804((Integer)var2.field4049, var1);
		}

	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1452508344"
	)
	public void method1763(boolean var1) {
		if (this.field2928 < this.field2938.method2040()) {
			class485 var2 = this.method1801(this.field2928 + 1);
			this.method1804((Integer)var2.field4048, var1);
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1855815967"
	)
	public void method1764(boolean var1) {
		if (this.field2928 > 0) {
			this.method1804(this.field2938.method2059(this.field2928, -1), var1);
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1322004372"
	)
	public void method1765(boolean var1) {
		if (this.field2928 < this.field2938.method2040()) {
			this.method1804(this.field2938.method2059(this.field2928, 1), var1);
		}

	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "6"
	)
	public void method1766(boolean var1) {
		if (this.field2928 > 0) {
			int var2 = this.method1805();
			this.method1804(this.field2938.method2059(this.field2928, -var2), var1);
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-203552347"
	)
	public void method1767(boolean var1) {
		if (this.field2928 < this.field2938.method2040()) {
			int var2 = this.method1805();
			this.method1804(this.field2938.method2059(this.field2928, var2), var1);
		}

	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(ZS)V",
		garbageValue = "2595"
	)
	public void method1768(boolean var1) {
		class398 var2 = this.field2938.method2049(0, this.field2928);
		class485 var3 = var2.method2119();
		this.method1804(this.field2938.method2058((Integer)var3.field4049, this.field2927), var1);
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1036465571"
	)
	public void method1769(boolean var1) {
		class398 var2 = this.field2938.method2049(0, this.field2928);
		class485 var3 = var2.method2119();
		this.method1804(this.field2938.method2058((Integer)var3.field4049, this.field2932 + this.field2927), var1);
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(IIZZI)V",
		garbageValue = "-1002335608"
	)
	public void method1770(int var1, int var2, boolean var3, boolean var4) {
		boolean var5 = false;
		class485 var6;
		int var8;
		if (!this.field2920) {
			var8 = 0;
		} else {
			var1 += this.field2931;
			var2 += this.field2927;
			var6 = this.method1810();
			var8 = this.field2938.method2058(var1 - (Integer)var6.field4049, var2 - (Integer)var6.field4048);
		}

		if (var3 && var4) {
			this.field2924 = 1;
			var6 = this.method1801(var8);
			class485 var7 = this.method1801(this.field2930);
			this.method1800(var7, var6);
		} else if (var3) {
			this.field2924 = 1;
			var6 = this.method1801(var8);
			this.method1755((Integer)var6.field4049, (Integer)var6.field4048);
			this.field2930 = (Integer)var6.field4049;
		} else if (var4) {
			this.method1755(this.field2930, var8);
		} else {
			if (this.field2934 > 0 && var8 == this.field2930) {
				if (this.field2928 == this.field2929) {
					this.field2924 = 1;
					var6 = this.method1801(var8);
					this.method1755((Integer)var6.field4049, (Integer)var6.field4048);
				} else {
					this.field2924 = 2;
					var6 = this.method1802(var8);
					this.method1755((Integer)var6.field4049, (Integer)var6.field4048);
				}
			} else {
				this.field2924 = 0;
				this.method1755(var8, var8);
				this.field2930 = var8;
			}

			this.field2934 = 25;
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-30"
	)
	public void method1771(int var1, int var2) {
		if (this.field2920 && this.method1782()) {
			var1 += this.field2931;
			var2 += this.field2927;
			class485 var3 = this.method1810();
			int var4 = this.field2938.method2058(var1 - (Integer)var3.field4049, var2 - (Integer)var3.field4048);
			class485 var5;
			class485 var6;
			switch(this.field2924) {
			case 0:
				this.method1755(this.field2929, var4);
				break;
			case 1:
				var5 = this.method1801(this.field2930);
				var6 = this.method1801(var4);
				this.method1800(var5, var6);
				break;
			case 2:
				var5 = this.method1802(this.field2930);
				var6 = this.method1802(var4);
				this.method1800(var5, var6);
			}
		}

	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "-1723140286"
	)
	public void method1772(Clipboard var1) {
		class398 var2 = this.field2938.method2049(this.field2929, this.field2928);
		if (!var2.method2115()) {
			String var3 = var2.method2113();
			if (!var3.isEmpty()) {
				var1.setContents(new StringSelection(var3), (ClipboardOwner)null);
			}
		}

	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "2111715206"
	)
	public void method1773(Clipboard var1) {
		if (this.method1798()) {
			this.method1772(var1);
			this.method1753();
		}

	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/datatransfer/Clipboard;I)V",
		garbageValue = "-992379728"
	)
	public void method1774(Clipboard var1) {
		Transferable var2 = var1.getContents((Object)null);
		if (var2 != null && var2.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var3 = this.method1799((String)var2.getTransferData(DataFlavor.stringFlavor));
				this.method1753();
				class395 var4 = this.field2938.method2051(var3, this.field2928, this.field2933);
				this.method1755(var4.method2078(), var4.method2078());
				this.method1803();
				this.method1808();
			} catch (Exception var5) {
			}
		}

	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "127"
	)
	public void method1775() {
		this.field2927 = Math.max(0, this.field2927 - this.field2938.method2062());
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-12"
	)
	public void method1776() {
		int var1 = Math.max(0, this.field2938.method2061() - this.field2932);
		this.field2927 = Math.min(var1, this.field2927 + this.field2938.method2062());
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(Lmf;I)V",
		garbageValue = "1877137858"
	)
	public void method1777(class323 var1) {
		this.field2937 = var1;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(Lmf;I)V",
		garbageValue = "1739536664"
	)
	public void method1778(class323 var1) {
		this.field2936 = var1;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(I)Lpj;",
		garbageValue = "-2121359079"
	)
	public class394 method1779() {
		return this.field2938;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(I)Lpj;",
		garbageValue = "1026932642"
	)
	public class394 method1780() {
		return this.field2939;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(I)Lpl;",
		garbageValue = "-927140025"
	)
	public class398 method1781() {
		return this.field2938.method2049(this.field2929, this.field2928);
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "10263708"
	)
	public boolean method1782() {
		return this.field2919;
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2120535737"
	)
	public boolean method1783() {
		return this.field2921;
	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "111"
	)
	public boolean method1784() {
		return this.method1782() && this.field2925 % 60 < 30;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "2"
	)
	public int method1785() {
		return this.field2928;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "9"
	)
	public int method1786() {
		return this.field2929;
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "73"
	)
	public boolean method1787() {
		return this.field2920;
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1004374049"
	)
	public int method1788() {
		return this.field2931;
	}

	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-737818988"
	)
	public int method1789() {
		return this.field2927;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "770052367"
	)
	public int method1790() {
		return this.field2938.method2065();
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-339785891"
	)
	public int method1791() {
		return this.field2938.method2066();
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-105"
	)
	public int method1792() {
		return this.field2926;
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "10872"
	)
	public int method1793() {
		return this.field2923;
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-333954295"
	)
	public int method1794() {
		return this.field2938.method2067();
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int method1795() {
		return this.field2922;
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-2053175833"
	)
	public int method1796() {
		return this.field2938.method2068();
	}

	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-20"
	)
	public boolean method1797() {
		return this.method1791() > 1;
	}

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-350056548"
	)
	boolean method1798() {
		return this.field2928 != this.field2929;
	}

	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "83"
	)
	String method1799(String var1) {
		StringBuilder var2 = new StringBuilder(var1.length());

		for (int var3 = 0; var3 < var1.length(); ++var3) {
			char var4 = var1.charAt(var3);
			if (this.method1809(var4)) {
				var2.append(var4);
			}
		}

		return var2.toString();
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(Lss;Lss;B)V",
		garbageValue = "5"
	)
	void method1800(class485 var1, class485 var2) {
		if ((Integer)var2.field4049 < (Integer)var1.field4049) {
			this.method1755((Integer)var1.field4048, (Integer)var2.field4049);
		} else {
			this.method1755((Integer)var1.field4049, (Integer)var2.field4048);
		}

	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(IB)Lss;",
		garbageValue = "-107"
	)
	class485 method1801(int var1) {
		int var2 = this.field2938.method2040();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.method1807(this.field2938.method2036(var5 - 1).field3680)) {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.method1807(this.field2938.method2036(var5).field3680)) {
				var4 = var5;
				break;
			}
		}

		return new class485(var3, var4);
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(II)Lss;",
		garbageValue = "-982019338"
	)
	class485 method1802(int var1) {
		int var2 = this.field2938.method2040();
		int var3 = 0;
		int var4 = var2;

		int var5;
		for (var5 = var1; var5 > 0; --var5) {
			if (this.field2938.method2036(var5 - 1).field3680 == '\n') {
				var3 = var5;
				break;
			}
		}

		for (var5 = var1; var5 < var2; ++var5) {
			if (this.field2938.method2036(var5).field3680 == '\n') {
				var4 = var5;
				break;
			}
		}

		return new class485(var3, var4);
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2078239234"
	)
	boolean method1803() {
		if (!this.method1787()) {
			return false;
		} else {
			boolean var1 = false;
			if (this.field2938.method2040() > this.field2926) {
				this.field2938.method2057(this.field2926, this.field2938.method2040());
				var1 = true;
			}

			int var2 = this.method1791();
			int var3;
			if (this.field2938.method2063() > var2) {
				var3 = this.field2938.method2059(0, var2) - 1;
				this.field2938.method2057(var3, this.field2938.method2040());
				var1 = true;
			}

			if (var1) {
				var3 = this.field2928;
				int var4 = this.field2929;
				int var5 = this.field2938.method2040();
				if (this.field2928 > var5) {
					var3 = var5;
				}

				if (this.field2929 > var5) {
					var4 = var5;
				}

				this.method1755(var4, var3);
			}

			return var1;
		}
	}

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "1750876747"
	)
	void method1804(int var1, boolean var2) {
		if (var2) {
			this.method1755(this.field2929, var1);
		} else {
			this.method1755(var1, var1);
		}

	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "6"
	)
	int method1805() {
		return this.field2932 / this.field2938.method2062();
	}

	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-676768049"
	)
	void method1806() {
		class398 var1 = this.field2938.method2049(0, this.field2928);
		class485 var2 = var1.method2119();
		int var3 = this.field2938.method2062();
		int var4 = (Integer)var2.field4049 - 10;
		int var5 = var4 + 20;
		int var6 = (Integer)var2.field4048 - 3;
		int var7 = var6 + var3 + 6;
		int var8 = this.field2931;
		int var9 = var8 + this.field2935;
		int var10 = this.field2927;
		int var11 = var10 + this.field2932;
		int var12 = this.field2931;
		int var13 = this.field2927;
		if (var4 < var8) {
			var12 = var4;
		} else if (var5 > var9) {
			var12 = var5 - this.field2935;
		}

		if (var6 < var10) {
			var13 = var6;
		} else if (var7 > var11) {
			var13 = var7 - this.field2932;
		}

		this.method1740(var12, var13);
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-369704395"
	)
	boolean method1807(int var1) {
		return var1 == 32 || var1 == 10 || var1 == 9;
	}

	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2067288907"
	)
	void method1808() {
		if (this.field2937 != null) {
			this.field2937.vmethod5708();
		}

	}

	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-268502133"
	)
	boolean method1809(int var1) {
		switch(this.field2922) {
		case 1:
			return WorldMapLabel.isAlphaNumeric((char)var1);
		case 2:
			return class200.isCharAlphabetic((char)var1);
		case 3:
			return class330.isDigit((char)var1);
		case 4:
			char var2 = (char)var1;
			if (class330.isDigit(var2)) {
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

	@ObfuscatedName("di")
	@ObfuscatedSignature(
		descriptor = "(I)Lss;",
		garbageValue = "-1390264109"
	)
	class485 method1810() {
		int var1 = this.field2938.method2069(this.field2935);
		int var2 = this.field2938.method2070(this.field2932);
		return new class485(var1, var2);
	}
}