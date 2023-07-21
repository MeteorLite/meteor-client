import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nc")
public class class346 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnc;"
	)
	static final class346 field3135;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnc;"
	)
	static final class346 field3136;
	@ObfuscatedName("ar")
	final int field3138;
	@ObfuscatedName("am")
	final int field3137;

	static {
		field3135 = new class346(51, 27, 800, 0, 16, 16);
		field3136 = new class346(25, 28, 800, 656, 40, 40);
	}

	class346(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.field3138 = var5;
		this.field3137 = var6;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1801743156"
	)
	public static int method1835(int var0) {
		return var0 != 0 && var0 != 1 ? -1 : 0;
	}
}
