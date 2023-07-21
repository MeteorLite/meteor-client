import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rk")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("an")
	@Export("userHomeDirectory")
	static String userHomeDirectory;
	@ObfuscatedName("aw")
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("ay")
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("ar")
	@Export("highX")
	public int highX;
	@ObfuscatedName("am")
	@Export("highY")
	public int highY;

	public Bounds(int var1, int var2, int var3, int var4) {
		this.setLow(var1, var2);
		this.setHigh(var3, var4);
	}

	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1375793969"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1178115137"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-4"
	)
	public boolean method2257(int var1, int var2) {
		return var1 >= this.lowX && var1 < this.lowX + this.highX && var2 >= this.lowY && var2 < this.highY + this.lowY;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lrk;Lrk;I)V",
		garbageValue = "839108851"
	)
	public void method2258(Bounds var1, Bounds var2) {
		this.method2259(var1, var2);
		this.method2260(var1, var2);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lrk;Lrk;B)V",
		garbageValue = "-5"
	)
	void method2259(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX = (var2.highX * 1322732417 - (var1.lowX * 1322732417 - this.lowX * 1322732417)) * 1200419969;
			var2.lowX = var1.lowX;
		}

		if (var2.method2261() > var1.method2261()) {
			var2.highX -= var2.method2261() - var1.method2261();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lrk;Lrk;I)V",
		garbageValue = "-1620507171"
	)
	void method2260(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY = (var2.highY * 1916255941 - (var1.lowY * 1916255941 - this.lowY * 1916255941)) * 1043533837;
			var2.lowY = var1.lowY;
		}

		if (var2.method2262() > var1.method2262()) {
			var2.highY -= var2.method2262() - var1.method2262();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-16"
	)
	int method2261() {
		return this.highX + this.lowX;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-83"
	)
	int method2262() {
		return this.highY + this.lowY;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return null;
	}

	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2055136301"
	)
	static void method2263() {
		if (Client.oculusOrbOnLocalPlayer && class136.localPlayer != null) {
			int var0 = class136.localPlayer.pathX[0];
			int var1 = class136.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			class467.oculusOrbFocalPointX = class136.localPlayer.x;
			int var2 = class306.getTileHeight(class136.localPlayer.x, class136.localPlayer.y, class36.Client_plane) - Client.camFollowHeight;
			if (var2 < class90.field887) {
				class90.field887 = var2;
			}

			class36.oculusOrbFocalPointY = class136.localPlayer.y;
			Client.oculusOrbOnLocalPlayer = false;
		}

	}
}
