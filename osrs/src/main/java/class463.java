import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ro")
public class class463 {
	@ObfuscatedName("oh")
	@Export("menuY")
	static int menuY;
	@ObfuscatedName("ac")
	float field3893;
	@ObfuscatedName("al")
	float field3895;
	@ObfuscatedName("ak")
	float field3894;

	static {
		new class463(0.0F, 0.0F, 0.0F);
		new class463(1.0F, 1.0F, 1.0F);
		new class463(1.0F, 0.0F, 0.0F);
		new class463(0.0F, 1.0F, 0.0F);
		new class463(0.0F, 0.0F, 1.0F);
		NPC.method581(100);
	}

	class463(float var1, float var2, float var3) {
		this.field3893 = var1;
		this.field3895 = var2;
		this.field3894 = var3;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)F",
		garbageValue = "-718087487"
	)
	final float method2328() {
		return (float)Math.sqrt((double)(this.field3893 * this.field3893 + this.field3895 * this.field3895 + this.field3894 * this.field3894));
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3893 + ", " + this.field3895 + ", " + this.field3894;
	}

	@ObfuscatedName("lt")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lnm;S)Ljava/lang/String;",
		garbageValue = "-20030"
	)
	static String method2329(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					var0 = var0.substring(0, var3) + class517.method2534(VarcInt.method977(var1, var2 - 1)) + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}