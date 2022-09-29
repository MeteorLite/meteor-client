import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class283 {
	@ObfuscatedName("up")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ljn;"
	)
	@Export("huffman")
	public static Huffman huffman;
	@ObfuscatedName("en")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	static Archive field3325;

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Llb;II)V",
		garbageValue = "1702364125"
	)
	static void method5651(Archive var0, int var1) {
		if (var0.field4028) {
			if (var1 <= NetCache.field4072) {
				throw new RuntimeException("");
			}

			if (var1 < NetCache.field4073) {
				NetCache.field4073 = var1;
			}
		} else {
			if (var1 >= NetCache.field4073) {
				throw new RuntimeException("");
			}

			if (var1 > NetCache.field4072) {
				NetCache.field4072 = var1;
			}
		}

		if (MilliClock.field1810 != null) {
			WorldMapID.method5123(var0, var1);
		} else {
			PacketBufferNode.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
			NetCache.NetCache_archives[var1] = var0;
		}
	}
}
