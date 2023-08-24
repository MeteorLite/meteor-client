import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rs")
public class class454 implements class459 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lsu;"
	)
	public final class489 field3899;

	@ObfuscatedSignature(
		descriptor = "(Lsx;)V"
	)
	class454(class490 var1) {
		this.field3899 = var1;
	}

	@ObfuscatedSignature(
		descriptor = "(Lrp;)V"
	)
	public class454(class455 var1) {
		this(new class490(var1));
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "530420265"
	)
	public int method2320(int var1) {
		return this.field3899.vmethod8144(var1);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfh;FS)F",
		garbageValue = "26313"
	)
	static float method2321(class130 var0, float var1) {
		if (var0 == null) {
			return 0.0F;
		} else {
			float var2;
			if (var0.field1258 == var1) {
				var2 = 0.0F;
			} else if (var1 == var0.field1254) {
				var2 = 1.0F;
			} else {
				var2 = (var1 - var0.field1258) / (var0.field1254 - var0.field1258);
			}

			float var3;
			if (var0.field1242) {
				var3 = var2;
			} else {
				class126.field1206[3] = var0.field1255;
				class126.field1206[2] = var0.field1249;
				class126.field1206[1] = var0.field1250;
				class126.field1206[0] = var0.field1247 - var2;
				class126.field1207[0] = 0.0F;
				class126.field1207[1] = 0.0F;
				class126.field1207[2] = 0.0F;
				class126.field1207[3] = 0.0F;
				class126.field1207[4] = 0.0F;
				int var4 = ModelData0.method1381(class126.field1206, 3, 0.0F, true, 1.0F, true, class126.field1207);
				if (var4 == 1) {
					var3 = class126.field1207[0];
				} else {
					var3 = 0.0F;
				}
			}

			return var3 * (var0.field1253 + var3 * (var3 * var0.field1248 + var0.field1256)) + var0.field1252;
		}
	}
}