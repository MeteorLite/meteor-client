import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class168 extends class144 {
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field1428;
	@ObfuscatedName("at")
	int field1429;
	@ObfuscatedName("ah")
	long field1430;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class168(class147 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1429 = var1.readInt();
		this.field1430 = var1.readLong();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method816(this.field1429, this.field1430);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "-89"
	)
	static int method874(int var0, Script var1, boolean var2) {
		Widget var3 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
		if (var0 == 2500) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == 2501) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == 2502) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 2503) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 2504) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 2505) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ou")
	@ObfuscatedSignature(
		descriptor = "(II)Lte;",
		garbageValue = "-847126653"
	)
	@Export("getDbTable")
	static DbTable getDbTable(int var0) {
		DbTable var1 = (DbTable)Client.Widget_cachedModels.get((long)var0);
		if (var1 == null) {
			var1 = new DbTable(class267.field2224, SequenceDefinition.method1041(var0), ZoneOperation.method1630(var0));
			Client.Widget_cachedModels.put(var1, (long)var0);
		}

		return var1;
	}
}