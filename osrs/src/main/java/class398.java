import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pl")
public class class398 {
	@ObfuscatedName("gy")
	@Export("playerUUIDLength")
	static int playerUUIDLength;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lpj;"
	)
	class394 field3708;
	@ObfuscatedName("ae")
	int field3706;
	@ObfuscatedName("ao")
	int field3707;

	@ObfuscatedSignature(
		descriptor = "(Lpj;II)V"
	)
	class398(class394 var1, int var2, int var3) {
		this.field3706 = 0;
		this.field3707 = 0;
		this.field3708 = var1;
		this.field3706 = var2;
		this.field3707 = var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "1"
	)
	public String method2113() {
		if (this.method2115()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2116());

			for (int var2 = this.field3706; var2 < this.field3707; ++var2) {
				class396 var3 = this.field3708.method2036(var2);
				var1.append(var3.field3680);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "0"
	)
	boolean method2114(int var1) {
		return this.field3708.method2068() == 2 || this.field3708.method2068() == 1 && (!this.field3708.field3668 || this.field3707 - 1 != var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "181871891"
	)
	public boolean method2115() {
		return this.field3706 == this.field3707;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1557600445"
	)
	public int method2116() {
		return this.field3707 - this.field3706;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lpz;I)Z",
		garbageValue = "-663348628"
	)
	boolean method2117(class396 var1) {
		if (this.field3708.field3674 == 2) {
			return true;
		} else if (this.field3708.field3674 == 0) {
			return false;
		} else {
			return this.field3708.method2037() != var1;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-808768391"
	)
	int method2118() {
		if (this.method2115()) {
			return 0;
		} else {
			class396 var1 = this.field3708.method2036(this.field3707 - 1);
			if (var1.field3680 == '\n') {
				return 0;
			} else if (this.method2117(var1)) {
				return this.field3708.field3677.advances[42];
			} else {
				int var2 = this.field3708.field3677.advances[var1.field3680];
				if (var2 == 0) {
					return var1.field3680 == '\t' ? this.field3708.field3677.advances[32] * 3 : this.field3708.field3677.advances[32];
				} else {
					return var2;
				}
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Lss;",
		garbageValue = "-873357566"
	)
	public class485 method2119() {
		if (this.method2115()) {
			return new class485(0, 0);
		} else {
			class396 var1 = this.field3708.method2036(this.field3707 - 1);
			return new class485(var1.field3681 + this.method2118(), var1.field3682);
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)Lpz;",
		garbageValue = "602399469"
	)
	public class396 method2120(int var1) {
		return var1 >= 0 && var1 < this.method2116() ? this.field3708.method2036(this.field3706 + var1) : null;
	}

	@ObfuscatedName("mj")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-46"
	)
	static boolean method2121(int var0) {
		for (int var1 = 0; var1 < Client.field532; ++var1) {
			if (Client.field581[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}