import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ty")
public enum class510 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4129(1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4124(2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4127(4),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4128(8),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4135(16),
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4138(32),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4151(64, true),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4143(128),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4122(256, true),
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4136(512),
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4123(1024),
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4144(2048),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4140(4096),
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4142(8192),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4145(16384),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4134(32768),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4125(65536),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4141(131072),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4149(262144),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4137(524288),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4146(1048576),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4150(2097152),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4139(4194304),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4147(8388608),
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4148(16777216),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4126(33554432),
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4153(67108864, true),
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4130(134217728),
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4154(268435456),
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4132(536870912, true),
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4131(1073741824, true),
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	field4152(Integer.MIN_VALUE);

	@ObfuscatedName("hu")
	static String field4133;
	@ObfuscatedName("by")
	final int field4155;

	class510(int var3) {
		this.field4155 = var3;
	}

	@ObfuscatedSignature(
		descriptor = "(IZ)V",
		garbageValue = "1"
	)
	class510(int var3, boolean var4) {
		this.field4155 = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4155;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "3331"
	)
	public static void method2513() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < JagexCache.field1461; ++var0) {
				WallDecoration.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}
}