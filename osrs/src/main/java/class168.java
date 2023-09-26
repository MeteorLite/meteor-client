import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class168 extends class161 {
	@ObfuscatedName("ac")
	String field1423;
	@ObfuscatedName("al")
	byte field1422;
	@ObfuscatedName("ak")
	byte field1421;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	final class162 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgf;)V"
	)
	class168(class162 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;B)V",
		garbageValue = "0"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1423 = var1.readStringCp1252NullTerminatedOrNull();
		if (this.field1423 != null) {
			var1.readUnsignedByte();
			this.field1422 = var1.readByte();
			this.field1421 = var1.readByte();
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgb;B)V",
		garbageValue = "0"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.name = this.field1423;
		if (this.field1423 != null) {
			var1.field1414 = this.field1422;
			var1.field1413 = this.field1421;
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "-85"
	)
	static int method878(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 100) {
			Interpreter.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = class33.widgetDefinition.method1740(var3);
				if (var6.children == null) {
					var6.children = new Widget[var5 + 1];
				}

				if (var6.children.length <= var5) {
					Widget[] var7 = new Widget[var5 + 1];

					for (int var8 = 0; var8 < var6.children.length; ++var8) {
						var7[var8] = var6.children[var8];
					}

					var6.children = var7;
				}

				if (var5 > 0 && var6.children[var5 - 1] == null) {
					throw new RuntimeException("" + (var5 - 1));
				} else {
					Widget var12 = new Widget();
					var12.type = var4;
					var12.parentId = var12.id = var6.id;
					var12.childIndex = var5;
					var12.isIf3 = true;
					if (var4 == 12) {
						var12.method1876();
						var12.method1877().method1810(new class107(var12));
						var12.method1877().method1809(new class108(var12));
					}

					var6.children[var5] = var12;
					if (var2) {
						class416.scriptDotWidget = var12;
					} else {
						class306.scriptActiveWidget = var12;
					}

					ClanChannelMember.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == 101) {
				var9 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
				Widget var10 = class33.widgetDefinition.method1740(var9.id);
				var10.children[var9.childIndex] = null;
				ClanChannelMember.invalidateWidget(var10);
				return 1;
			} else if (var0 == 102) {
				var9 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
				var9.children = null;
				ClanChannelMember.invalidateWidget(var9);
				return 1;
			} else if (var0 != 200) {
				if (var0 == 201) {
					var9 = class33.widgetDefinition.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							class416.scriptDotWidget = var9;
						} else {
							class306.scriptActiveWidget = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Widget var11 = class33.widgetDefinition.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						class416.scriptDotWidget = var11;
					} else {
						class306.scriptActiveWidget = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}