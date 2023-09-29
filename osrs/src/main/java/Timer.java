import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qq")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("ac")
	long field3783;
	@ObfuscatedName("al")
	long field3785;
	@ObfuscatedName("ak")
	public boolean field3788;
	@ObfuscatedName("ax")
	long field3787;
	@ObfuscatedName("ao")
	long field3786;
	@ObfuscatedName("ah")
	long field3784;
	@ObfuscatedName("ar")
	int field3781;
	@ObfuscatedName("ab")
	int field3779;
	@ObfuscatedName("am")
	int field3780;
	@ObfuscatedName("av")
	int field3782;

	public Timer() {
		this.field3783 = -1L;
		this.field3785 = -1L;
		this.field3788 = false;
		this.field3787 = 0L;
		this.field3786 = 0L;
		this.field3784 = 0L;
		this.field3781 = 0;
		this.field3779 = 0;
		this.field3780 = 0;
		this.field3782 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "281982191"
	)
	public void method2182() {
		this.field3783 = GrandExchangeOfferTotalQuantityComparator.method1971();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "8"
	)
	public void method2183() {
		if (-1L != this.field3783) {
			this.field3786 = GrandExchangeOfferTotalQuantityComparator.method1971() - this.field3783;
			this.field3783 = -1L;
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "49"
	)
	public void method2184(int var1) {
		this.field3785 = GrandExchangeOfferTotalQuantityComparator.method1971();
		this.field3781 = var1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1876587712"
	)
	public void method2185() {
		if (-1L != this.field3785) {
			this.field3787 = GrandExchangeOfferTotalQuantityComparator.method1971() - this.field3785;
			this.field3785 = -1L;
		}

		++this.field3780;
		this.field3788 = true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-699557437"
	)
	public void method2186() {
		this.field3788 = false;
		this.field3779 = 0;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1309820962"
	)
	public void method2187() {
		this.method2185();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "1951350671"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3786;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		long var4 = this.field3787;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		long var6 = this.field3784;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int)var6);
		var1.writeShort(this.field3781);
		var1.writeShort(this.field3779);
		var1.writeShort(this.field3780);
		var1.writeShort(this.field3782);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "-2042986049"
	)
	public static String method2181(CharSequence var0) {
		int var1 = var0.length();
		StringBuilder var2 = new StringBuilder(var1);

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
				if (var4 == ' ') {
					var2.append('+');
				} else {
					byte var5 = Actor.charToByteCp1252(var4);
					var2.append('%');
					int var6 = var5 >> 4 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}

					var6 = var5 & 15;
					if (var6 >= 10) {
						var2.append((char)(var6 + 55));
					} else {
						var2.append((char)(var6 + 48));
					}
				}
			} else {
				var2.append(var4);
			}
		}

		return var2.toString();
	}
}