import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pn")
public class class408 {
	@ObfuscatedName("at")
	public char field3716;
	@ObfuscatedName("ah")
	public int field3717;
	@ObfuscatedName("ar")
	public int field3718;

	class408() {
		this.field3717 = 0;
		this.field3718 = 0;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(Ltu;I)Ljava/lang/Object;",
		garbageValue = "-458356510"
	)
	static Object method2096(class514 var0) {
		if (var0 == null) {
			throw new IllegalStateException("popValueOfType() failure - null baseVarType");
		} else {
			switch(var0.field4129) {
			case 0:
				return Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			case 2:
				return Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
			default:
				throw new IllegalStateException("popValueOfType() failure - unsupported type");
			}
		}
	}
}