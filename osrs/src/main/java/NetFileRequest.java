import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	@Export("archive")
	public Archive archive;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 2101208687
	)
	@Export("crc")
	public int crc;
	@ObfuscatedName("f")
	@Export("padding")
	public byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1754412957"
	)
	public static int method6004(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) {
			var2 = var2 << 1 | var0 & 1;
			var0 >>>= 1;
		}

		return var2;
	}
}
