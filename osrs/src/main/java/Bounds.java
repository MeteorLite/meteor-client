import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rv")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("at")
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("ah")
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("ar")
	@Export("highX")
	public int highX;
	@ObfuscatedName("ao")
	@Export("highY")
	public int highY;

	public Bounds(int var1, int var2, int var3, int var4) {
		this.setLow(var1, var2);
		this.setHigh(var3, var4);
	}

	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "20"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1923662926"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "375775673"
	)
	public boolean method2300(int var1, int var2) {
		return var1 >= this.lowX && var1 < this.highX + this.lowX && var2 >= this.lowY && var2 < this.highY + this.lowY;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lrv;Lrv;I)V",
		garbageValue = "-1398838147"
	)
	public void method2301(Bounds var1, Bounds var2) {
		this.method2302(var1, var2);
		this.method2303(var1, var2);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lrv;Lrv;I)V",
		garbageValue = "497587597"
	)
	void method2302(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX = (var2.highX - (var1.lowX - this.lowX));
			var2.lowX = var1.lowX;
		}

		if (var2.method2304() > var1.method2304()) {
			var2.highX -= var2.method2304() - var1.method2304();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lrv;Lrv;I)V",
		garbageValue = "1262928810"
	)
	void method2303(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY = (var2.highY - (var1.lowY - this.lowY));
			var2.lowY = var1.lowY;
		}

		if (var2.method2305() > var1.method2305()) {
			var2.highY -= var2.method2305() - var1.method2305();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-222138556"
	)
	int method2304() {
		return this.lowX + this.highX;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "578775229"
	)
	int method2305() {
		return this.lowY + this.highY;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return null;
	}
}