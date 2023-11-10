import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
	@ObfuscatedName("au")
	static int field1202;
	@ObfuscatedName("at")
	@Export("reversed")
	final boolean reversed;

	public UserComparator6(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lrh;Lrh;I)I",
		garbageValue = "-464829605"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "-32"
	)
	static int method689(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 != 1927 && var0 != 2927) {
			int var4;
			if (var0 == 1928) {
				var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
				var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (var4 >= 1 && var4 <= 10) {
					class102 var5 = new class102(var4, var3.id, var3.childIndex, var3.itemId);
					Interpreter.field712.add(var5);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else if (var0 == 2928) {
				DbTableType.Interpreter_intStackSize -= 3;
				int var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				int var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				if (var8 >= 1 && var8 <= 10) {
					class102 var6 = new class102(var8, var7, var4, HealthBarDefinition.widgetDefinition.method1733(var7).itemId);
					Interpreter.field712.add(var6);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else {
				return 2;
			}
		} else if (Interpreter.field705 >= 10) {
			throw new RuntimeException();
		} else {
			if (var0 >= 2000) {
				var3 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
			} else {
				var3 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
			}

			if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var9 = new ScriptEvent();
				var9.widget = var3;
				var9.args = var3.onResize;
				var9.field871 = Interpreter.field705 + 1;
				Client.scriptEvents.addFirst(var9);
				return 1;
			}
		}
	}
}