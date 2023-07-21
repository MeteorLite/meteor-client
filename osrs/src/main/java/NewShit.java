import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("NewShit")
public class NewShit {
	@ObfuscatedName("aw")
	public long field1566;
	@ObfuscatedName("ay")
	int[] field1562;
	@ObfuscatedName("ar")
	short[] field1564;
	@ObfuscatedName("am")
	short[] field1563;
	@ObfuscatedName("as")
	public boolean field1565;

	public NewShit(long var1, int[] var3, short[] var4, short[] var5, boolean var6) {
		this.field1565 = false;
		this.field1566 = var1;
		this.field1562 = var3;
		this.field1564 = var4;
		this.field1563 = var5;
		this.field1565 = var6;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FI)F",
		garbageValue = "-1510328589"
	)
	static float method961(class130 var0, float var1) {
		if (var0 == null) {
			return 0.0F;
		} else {
			float var2;
			if (var0.field1234 == var1) {
				var2 = 0.0F;
			} else if (var1 == var0.field1244) {
				var2 = 1.0F;
			} else {
				var2 = (var1 - var0.field1234) / (var0.field1244 - var0.field1234);
			}

			float var3;
			if (var0.field1227) {
				var3 = var2;
			} else {
				class126.field1197[3] = var0.field1240;
				class126.field1197[2] = var0.field1239;
				class126.field1197[1] = var0.field1238;
				class126.field1197[0] = var0.field1242 - var2;
				class126.field1196[0] = 0.0F;
				class126.field1196[1] = 0.0F;
				class126.field1196[2] = 0.0F;
				class126.field1196[3] = 0.0F;
				class126.field1196[4] = 0.0F;
				int var4 = DbRowType.method2486(class126.field1197, 3, 0.0F, true, 1.0F, true, class126.field1196);
				if (var4 == 1) {
					var3 = class126.field1196[0];
				} else {
					var3 = 0.0F;
				}
			}

			return (var0.field1243 + (var0.field1233 + var3 * var0.field1241) * var3) * var3 + var0.field1235;
		}
	}
}
