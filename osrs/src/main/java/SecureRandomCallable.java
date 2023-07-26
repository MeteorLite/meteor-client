import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("oh")
	static int field846;
	@ObfuscatedName("tc")
	@ObfuscatedSignature(
		descriptor = "Lbe;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;

	SecureRandomCallable() {
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		return WorldMapSection2.method1377();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "2007772558"
	)
	@Export("addImageTag")
	static String addImageTag(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "([FI)V",
		garbageValue = "-1364633543"
	)
	static void method462(float[] var0) {
		if (var0[0] + class126.field1194 < 1.3333334F) {
			float var1 = var0[0] - 2.0F;
			float var2 = var0[0] - 1.0F;
			float var3 = (float)Math.sqrt((double)(var1 * var1 - var2 * 4.0F * var2));
			float var4 = (-var1 + var3) * 0.5F;
			if (class126.field1194 + var0[1] > var4) {
				var0[1] = var4 - class126.field1194;
			} else {
				var4 = (-var1 - var3) * 0.5F;
				if (var0[1] < class126.field1194 + var4) {
					var0[1] = var4 + class126.field1194;
				}
			}
		} else {
			var0[0] = 1.3333334F - class126.field1194;
			var0[1] = 0.33333334F - class126.field1194;
		}

	}
}
