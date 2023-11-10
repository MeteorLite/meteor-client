import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class158 extends class144 {
	@ObfuscatedName("at")
	int field1402;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class158(class147 var1) {
		this.this$0 = var1;
		this.field1402 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1402 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method809(this.field1402);
	}

	@ObfuscatedName("ab")
	static int method828(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "11323368"
	)
	static final void method829() {
		WorldMapArea.method1213("You can't add yourself to your own ignore list");
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-1589352545"
	)
	static int method833(int var0, Script var1, boolean var2) {
		if (var0 == 7108) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class60.method339() ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2036594717"
	)
	static int method832(int var0) {
		return var0 * 3 + 600;
	}
}