import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("af")
	static int field2121;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "[Lia;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		descriptor = "(Lnu;Lnu;IZ)V"
	)
	Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13;
				if (var4) {
					var13 = var2.getFile(0, var11);
				} else {
					var13 = var2.getFile(var11, 0);
				}

				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-8394863"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-292158439"
	)
	public static void method1293(int var0, int var1) {
		VarbitComposition var2 = class384.method2022(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1760053534"
	)
	public static int method1292(int var0) {
		return class464.field3907[var0 & 16383];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "-8"
	)
	static int method1295(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 100) {
			SoundCache.Interpreter_intStackSize -= 3;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
			if (var4 == 0) {
				throw new RuntimeException();
			} else {
				Widget var6 = class92.getWidget(var3);
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
						var12.method1843();
						var12.method1844().method1778(new class105(var12));
						var12.method1844().method1777(new class106(var12));
					}

					var6.children[var5] = var12;
					if (var2) {
						GameObject.scriptDotWidget = var12;
					} else {
						SceneTilePaint.scriptActiveWidget = var12;
					}

					class218.invalidateWidget(var6);
					return 1;
				}
			}
		} else {
			Widget var9;
			if (var0 == 101) {
				var9 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
				Widget var10 = class92.getWidget(var9.id);
				var10.children[var9.childIndex] = null;
				class218.invalidateWidget(var10);
				return 1;
			} else if (var0 == 102) {
				var9 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
				var9.children = null;
				class218.invalidateWidget(var9);
				return 1;
			} else if (var0 != 200) {
				if (var0 == 201) {
					var9 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					if (var9 != null) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
						if (var2) {
							GameObject.scriptDotWidget = var9;
						} else {
							SceneTilePaint.scriptActiveWidget = var9;
						}
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Widget var11 = SoundCache.getWidgetChild(var3, var4);
				if (var11 != null && var4 != -1) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					if (var2) {
						GameObject.scriptDotWidget = var11;
					} else {
						SceneTilePaint.scriptActiveWidget = var11;
					}
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		descriptor = "(ZLto;I)V",
		garbageValue = "101109035"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field492 = 0;
		Client.field451 = 0;
		var1.importIndex();
		int var2 = var1.readBits(8);
		int var3;
		if (var2 < Client.npcCount) {
			for (var3 = var2; var3 < Client.npcCount; ++var3) {
				Client.field564[++Client.field492 - 1] = Client.npcIndices[var3];
			}
		}

		if (var2 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var3 = 0; var3 < var2; ++var3) {
				int var4 = Client.npcIndices[var3];
				NPC var5 = Client.npcs[var4];
				int var6 = var1.readBits(1);
				if (var6 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var4;
					var5.npcCycle = Client.cycle;
				} else {
					int var7 = var1.readBits(2);
					if (var7 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var4;
						var5.npcCycle = Client.cycle;
						Client.field552[++Client.field451 - 1] = var4;
					} else {
						int var8;
						int var9;
						if (var7 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var4;
							var5.npcCycle = Client.cycle;
							var8 = var1.readBits(3);
							var5.move(var8, MoveSpeed.WALK);
							var9 = var1.readBits(1);
							if (var9 == 1) {
								Client.field552[++Client.field451 - 1] = var4;
							}
						} else if (var7 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var4;
							var5.npcCycle = Client.cycle;
							if (var1.readBits(1) == 1) {
								var8 = var1.readBits(3);
								var5.move(var8, MoveSpeed.RUN);
								var9 = var1.readBits(3);
								var5.move(var9, MoveSpeed.RUN);
							} else {
								var8 = var1.readBits(3);
								var5.move(var8, MoveSpeed.CRAWL);
							}

							var8 = var1.readBits(1);
							if (var8 == 1) {
								Client.field552[++Client.field451 - 1] = var4;
							}
						} else if (var7 == 3) {
							Client.field564[++Client.field492 - 1] = var4;
						}
					}
				}
			}

			class349.method1874(var0, var1);
			class151.method795(var1);

			for (var2 = 0; var2 < Client.field492; ++var2) {
				var3 = Client.field564[var2];
				if (Client.npcs[var3].npcCycle != Client.cycle) {
					Client.npcs[var3].definition = null;
					Client.npcs[var3] = null;
				}
			}

			if (var1.offset != Client.packetWriter.serverPacketLength) {
				throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
			} else {
				for (var2 = 0; var2 < Client.npcCount; ++var2) {
					if (Client.npcs[Client.npcIndices[var2]] == null) {
						throw new RuntimeException(var2 + "," + Client.npcCount);
					}
				}

			}
		}
	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1066961664"
	)
	static void method1297() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}
}