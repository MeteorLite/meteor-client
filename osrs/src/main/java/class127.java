import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class127 extends class129 {
	@ObfuscatedName("pw")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("HitSplatDefinition_cachedSprites")
	static class429 HitSplatDefinition_cachedSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = 8032391392508483815L
	)
	long field1553;
	@ObfuscatedName("p")
	String field1552;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	final class132 this$0;

	@ObfuscatedSignature(
		descriptor = "(Leo;)V"
	)
	class127(class132 var1) {
		this.this$0 = var1;
		this.field1553 = -1L;
		this.field1552 = null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)V",
		garbageValue = "-41"
	)
	void vmethod3320(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1553 = var1.readLong();
		}

		this.field1552 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Led;I)V",
		garbageValue = "-538131930"
	)
	void vmethod3313(ClanSettings var1) {
		var1.method3117(this.field1553, this.field1552, 0);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "-1440587934"
	)
	static int method2992(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? TextureProvider.scriptDotWidget : MenuAction.scriptActiveWidget;
		if (var0 == 1800) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SoundCache.Widget_unpackTargetMask(class97.getWidgetFlags(var3));
			return 1;
		} else if (var0 != 1801) {
			if (var0 == 1802) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
