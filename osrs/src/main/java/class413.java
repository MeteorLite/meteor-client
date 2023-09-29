import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pr")
public class class413 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lpp;"
	)
	class409 field3740;
	@ObfuscatedName("al")
	int field3739;
	@ObfuscatedName("ak")
	int field3738;

	@ObfuscatedSignature(
		descriptor = "(Lpp;II)V"
	)
	class413(class409 var1, int var2, int var3) {
		this.field3739 = 0;
		this.field3738 = 0;
		this.field3740 = var1;
		this.field3739 = var2;
		this.field3738 = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1895014245"
	)
	public String method2145() {
		if (this.method2147()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2148());

			for (int var2 = this.field3739; var2 < this.field3738; ++var2) {
				class411 var3 = this.field3740.method2065(var2);
				var1.append(var3.field3713);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-819207986"
	)
	boolean method2146(int var1) {
		return this.field3740.method2096() == 2 || this.field3740.method2096() == 1 && (!this.field3740.field3701 || this.field3738 - 1 != var1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-70"
	)
	public boolean method2147() {
		return this.field3738 == this.field3739;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-40"
	)
	public int method2148() {
		return this.field3738 - this.field3739;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lpe;B)Z",
		garbageValue = "4"
	)
	boolean method2149(class411 var1) {
		if (this.field3740.field3703 == 2) {
			return true;
		} else if (this.field3740.field3703 == 0) {
			return false;
		} else {
			return this.field3740.method2066() != var1;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1508488797"
	)
	int method2150() {
		if (this.method2147()) {
			return 0;
		} else {
			class411 var1 = this.field3740.method2065(this.field3738 - 1);
			if (var1.field3713 == '\n') {
				return 0;
			} else if (this.method2149(var1)) {
				return this.field3740.field3710.advances[42];
			} else {
				int var2 = this.field3740.field3710.advances[var1.field3713];
				if (var2 == 0) {
					return var1.field3713 == '\t' ? this.field3740.field3710.advances[32] * 3 : this.field3740.field3710.advances[32];
				} else {
					return var2;
				}
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ltw;",
		garbageValue = "-1209602899"
	)
	public class500 method2151() {
		if (this.method2147()) {
			return new class500(0, 0);
		} else {
			class411 var1 = this.field3740.method2065(this.field3738 - 1);
			return new class500(var1.field3715 + this.method2150(), var1.field3714);
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)Lpe;",
		garbageValue = "-52"
	)
	public class411 method2152(int var1) {
		return var1 >= 0 && var1 < this.method2148() ? this.field3740.method2065(this.field3739 + var1) : null;
	}
}