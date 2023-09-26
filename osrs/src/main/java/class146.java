import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class146 extends class145 {
	@ObfuscatedName("ac")
	int field1327;
	@ObfuscatedName("al")
	boolean field1326;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lff;"
	)
	final class148 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lff;)V"
	)
	class146(class148 var1) {
		this.this$0 = var1;
		this.field1327 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-11659242"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1327 = var1.readUnsignedShort();
		this.field1326 = var1.readUnsignedByte() == 1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgi;I)V",
		garbageValue = "21847466"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method824(this.field1327, this.field1326);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1923763150"
	)
	static void method768(int var0) {
		class464.field3897 = var0;
		class464.field3898 = new class464[var0];
		class464.field3896 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1925208332"
	)
	public static boolean method767(int var0) {
		return (var0 & 1) != 0;
	}
}