import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tv")
public class class519 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	public static final class519 field4205;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	public static final class519 field4204;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	static final class519 field4208;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	static final class519 field4209;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	static final class519 field4206;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Ltv;"
	)
	static final class519 field4207;
	@ObfuscatedName("az")
	final int field4211;
	@ObfuscatedName("ap")
	final int field4210;

	static {
		field4205 = new class519(1, 0);
		field4204 = new class519(5, 2);
		field4208 = new class519(2, 5);
		field4209 = new class519(0, 6);
		field4206 = new class519(4, 7);
		field4207 = new class519(3, 8);
	}

	class519(int var1, int var2) {
		this.field4211 = var1;
		this.field4210 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-664760154"
	)
	public boolean method2616() {
		return this == field4204;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4210;
	}
}