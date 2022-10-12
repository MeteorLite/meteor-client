import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lpr;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("ds")
	static boolean field1020;
	@ObfuscatedName("f")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("c")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "208881986"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "108133089"
	)
	public static boolean method2221(int var0) {
		return var0 == WorldMapDecorationType.field3694.id;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(IB)Ldq;",
		garbageValue = "-65"
	)
	static class126 method2225(int var0) {
		class126 var1 = (class126)WallDecoration.findEnumerated(class14.method178(), var0);
		if (var1 == null) {
			var1 = class126.field1519;
		}

		return var1;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(ILbz;ZB)I",
		garbageValue = "-114"
	)
	static int method2219(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = class281.getWidget(Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? class140.scriptDotWidget : class136.scriptActiveWidget;
		}

		int var11;
		if (var0 == 1300) {
			var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize]);
				return 1;
			} else {
				--class125.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == 1301) {
				class379.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var4.parent = WorldMapDecoration.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == 1302) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1303) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1304) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1305) {
				var4.dataText = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1306) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1307) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.prioritizeMenuEntry = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1309) {
				--class379.Interpreter_intStackSize;
				return 1;
			} else {
				int var7;
				byte[] var8;
				if (var0 != 1350) {
					byte var5;
					if (var0 == 1351) {
						class379.Interpreter_intStackSize -= 2;
						var5 = 10;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize]};
						byte[] var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]};
						GameObject.Widget_setKey(var4, var5, var8, var9);
						return 1;
					} else if (var0 == 1352) {
						class379.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							UserComparator9.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1353) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						UserComparator9.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == 1354) {
						--class379.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							class355.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1355) {
						var5 = 10;
						class355.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var10 = null;
					var8 = null;
					if (var3) {
						class379.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + class379.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var10 = new byte[var7 / 2];
							var8 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var10[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class379.Interpreter_intStackSize];
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class379.Interpreter_intStackSize + 1];
							}
						}
					} else {
						class379.Interpreter_intStackSize -= 2;
						var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize]};
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						GameObject.Widget_setKey(var4, var7, var10, var8);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}
}
