import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("po")
public class class399 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lpt;"
	)
	class395 field3698;
	@ObfuscatedName("ay")
	int field3697;
	@ObfuscatedName("ar")
	int field3696;

	@ObfuscatedSignature(
		descriptor = "(Lpt;II)V"
	)
	class399(class395 var1, int var2, int var3) {
		this.field3697 = 0;
		this.field3696 = 0;
		this.field3698 = var1;
		this.field3697 = var2;
		this.field3696 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1809601354"
	)
	public String method2074() {
		if (this.method2076()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2077());

			for (int var2 = this.field3697; var2 < this.field3696; ++var2) {
				class397 var3 = this.field3698.method1995(var2);
				var1.append(var3.field3671);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1827126332"
	)
	boolean method2075(int var1) {
		return this.field3698.method2027() == 2 || this.field3698.method2027() == 1 && (!this.field3698.field3660 || this.field3696 - 1 != var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-587840558"
	)
	public boolean method2076() {
		return this.field3697 == this.field3696;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "107"
	)
	public int method2077() {
		return this.field3696 - this.field3697;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lpz;I)Z",
		garbageValue = "-1646717603"
	)
	boolean method2078(class397 var1) {
		if (this.field3698.field3665 == 2) {
			return true;
		} else if (this.field3698.field3665 == 0) {
			return false;
		} else {
			return this.field3698.method1996() != var1;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1502136655"
	)
	int method2079() {
		if (this.method2076()) {
			return 0;
		} else {
			class397 var1 = this.field3698.method1995(this.field3696 - 1);
			if (var1.field3671 == '\n') {
				return 0;
			} else if (this.method2078(var1)) {
				return this.field3698.field3669.advances[42];
			} else {
				int var2 = this.field3698.field3669.advances[var1.field3671];
				if (var2 == 0) {
					return var1.field3671 == '\t' ? this.field3698.field3669.advances[32] * 3 : this.field3698.field3669.advances[32];
				} else {
					return var2;
				}
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Lsf;",
		garbageValue = "-631307887"
	)
	public class486 method2080() {
		if (this.method2076()) {
			return new class486(0, 0);
		} else {
			class397 var1 = this.field3698.method1995(this.field3696 - 1);
			return new class486(var1.field3673 + this.method2079(), var1.field3672);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)Lpz;",
		garbageValue = "-2132806837"
	)
	public class397 method2081(int var1) {
		return var1 >= 0 && var1 < this.method2077() ? this.field3698.method1995(this.field3697 + var1) : null;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "687406142"
	)
	static int method2082(int var0, int var1, int var2) {
		if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
			return 0;
		} else {
			return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
		}
	}
}
