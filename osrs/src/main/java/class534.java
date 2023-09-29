import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("uh")
public class class534 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	public static final class534 field4231;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	public static final class534 field4232;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	static final class534 field4235;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	static final class534 field4237;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	static final class534 field4236;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Luh;"
	)
	static final class534 field4234;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("ar")
	final int field4239;
	@ObfuscatedName("ab")
	final int field4238;

	static {
		field4231 = new class534(5, 0);
		field4232 = new class534(2, 2);
		field4235 = new class534(1, 5);
		field4237 = new class534(3, 6);
		field4236 = new class534(4, 7);
		field4234 = new class534(0, 8);
	}

	class534(int var1, int var2) {
		this.field4239 = var1;
		this.field4238 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4238;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "91579028"
	)
	public boolean method2654() {
		return this == field4232;
	}
}