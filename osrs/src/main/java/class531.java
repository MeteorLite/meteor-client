import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("us")
public class class531 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	public static final class531 field4234;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	public static final class531 field4233;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	static final class531 field4237;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	static final class531 field4236;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	static final class531 field4235;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lus;"
	)
	static final class531 field4238;
	@ObfuscatedName("aa")
	final int field4239;
	@ObfuscatedName("ac")
	final int field4240;

	static {
		field4234 = new class531(1, 0);
		field4233 = new class531(3, 2);
		field4237 = new class531(4, 5);
		field4236 = new class531(2, 6);
		field4235 = new class531(0, 7);
		field4238 = new class531(5, 8);
	}

	class531(int var1, int var2) {
		this.field4239 = var1;
		this.field4240 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1094976837"
	)
	public boolean method2633() {
		return this == field4233;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4240;
	}
}