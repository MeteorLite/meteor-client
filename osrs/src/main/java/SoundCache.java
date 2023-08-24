import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("bi")
@Implements("SoundCache")
public class SoundCache {
	@ObfuscatedName("aa")
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		descriptor = "[Luk;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("soundEffectIndex")
	AbstractArchive soundEffectIndex;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	AbstractArchive field216;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	NodeHashTable field218;

	@ObfuscatedSignature(
		descriptor = "(Lnu;Lnu;)V"
	)
	public SoundCache(AbstractArchive var1, AbstractArchive var2) {
		new NodeHashTable(256);
		this.field218 = new NodeHashTable(256);
		this.soundEffectIndex = var1;
		this.field216 = var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II[II)Lbu;",
		garbageValue = "-1861641707"
	)
	@Export("getSoundEffect0")
	RawSound getSoundEffect0(int var1, int var2, int[] var3) {
		long var4 = this.method226(var1, var2, false);
		class53 var6 = (class53)this.field218.get(var4);
		if (var6 != null) {
			return var6.method292();
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			SoundEffect var7 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
			if (var7 == null) {
				return null;
			} else {
				RawSound var8 = var7.toRawSound();
				this.field218.put(new class53(var8), var4);
				if (var3 != null) {
					var3[0] -= var8.samples.length;
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lcf;",
		garbageValue = "-98"
	)
	class53 method221(int var1, int var2) {
		long var3 = this.method226(var1, var2, true);
		class53 var5 = (class53)this.field218.get(var3);
		if (var5 != null) {
			return var5;
		} else {
			VorbisSample var6 = VorbisSample.readMusicSample(this.field216, var1, var2);
			if (var6 == null) {
				return new class53();
			} else {
				class53 var7 = new class53(var6);
				this.field218.put(var7, var3);
				return var7;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I[II)Lbu;",
		garbageValue = "88728645"
	)
	@Export("getSoundEffect")
	RawSound getSoundEffect(int var1, int[] var2) {
		if (this.soundEffectIndex.getGroupCount() == 1) {
			return this.getSoundEffect0(0, var1, var2);
		} else if (this.soundEffectIndex.getGroupFileCount(var1) == 1) {
			return this.getSoundEffect0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lcf;",
		garbageValue = "134889372"
	)
	public class53 method223(int var1) {
		if (this.field216.getGroupCount() == 1) {
			return this.method221(0, var1);
		} else if (this.field216.getGroupFileCount(var1) == 1) {
			return this.method221(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lbu;",
		garbageValue = "1913686453"
	)
	public RawSound method225(int var1) {
		return this.getSoundEffect(var1, (int[])null);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIZI)J",
		garbageValue = "1190461425"
	)
	long method226(int var1, int var2, boolean var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >> 12);
		var4 |= var1 << 16;
		return var3 ? (long)var4 ^ 4294967296L : (long)var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)Lmi;",
		garbageValue = "139540914"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = class92.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1117171488"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-1164645966"
	)
	static int method228(int var0, Script var1, boolean var2) {
		int var3;
		int var5;
		int var7;
		Object var21;
		class506 var22;
		if (var0 != 7500 && var0 != 7508) {
			if (var0 != 7501) {
				int var4;
				int var6;
				if (var0 == 7502) {
					Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[Interpreter_intStackSize + 2];
					var6 = UserComparator3.method682(var4);
					var7 = NewShit.method979(var4);
					int var8 = MoveSpeed.method1141(var4);
					DbRowType var23 = class159.getDbRowType(var3);
					DbTableType var24 = class159.getDbTableType(var6);
					int[] var25 = var24.types[var7];
					int var12 = 0;
					int var13 = var25.length;
					if (var8 >= 0) {
						if (var8 >= var13) {
							throw new RuntimeException("Tuple index out-of-bounds. Requested: " + var8 + ", Max: " + var13);
						}

						var12 = var8;
						var13 = var8 + 1;
					}

					Object[] var14 = var23.getColumnType(var7);
					if (var14 == null && var24.defaultValues != null) {
						var14 = var24.defaultValues[var7];
					}

					int var15;
					int var16;
					if (var14 == null) {
						for (var15 = var12; var15 < var13; ++var15) {
							var16 = var25[var15];
							class502 var17 = SequenceDefinition.method1074(var16);
							if (var17 == class502.field4100) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							} else {
								Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = class127.method703(var16);
							}
						}

						return 1;
					} else {
						var15 = var14.length / var25.length;
						if (var5 >= 0 && var5 < var15) {
							for (var16 = var12; var16 < var13; ++var16) {
								int var19 = var16 + var25.length * var5;
								class502 var18 = SequenceDefinition.method1074(var25[var16]);
								if (var18 == class502.field4100) {
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = (String)var14[var19];
								} else {
									Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = (Integer)var14[var19];
								}
							}

							return 1;
						} else {
							throw new RuntimeException();
						}
					}
				} else if (var0 == 7503) {
					Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter_intStackSize + 1];
					var5 = 0;
					var6 = UserComparator3.method682(var4);
					var7 = NewShit.method979(var4);
					DbRowType var26 = class159.getDbRowType(var3);
					DbTableType var9 = class159.getDbTableType(var6);
					int[] var10 = var9.types[var7];
					Object[] var11 = var26.getColumnType(var7);
					if (var11 == null && var9.defaultValues != null) {
						var11 = var9.defaultValues[var7];
					}

					if (var11 != null) {
						var5 = var11.length / var10.length;
					}

					Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = var5;
					return 1;
				} else if (var0 != 7504 && var0 != 7510) {
					if (var0 == 7505) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
						DbRowType var28 = class159.getDbRowType(var3);
						Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = var28.tableId;
						return 1;
					} else if (var0 == 7506) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
						var4 = -1;
						if (VarcInt.field1532 != null && var3 >= 0 && var3 < VarcInt.field1532.size()) {
							var4 = (Integer)VarcInt.field1532.get(var3);
						}

						Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = var4;
						return 1;
					} else if (var0 != 7507 && var0 != 7509) {
						return 2;
					} else {
						var3 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
						var21 = MoveSpeed.method1143(var3);
						var5 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
						var22 = class344.method1868(var5);
						if (var22 == null) {
							throw new RuntimeException();
						} else if (UserComparator3.method682(var5) != Client.field549) {
							throw new RuntimeException();
						} else if (VarcInt.field1532 == null && VarcInt.field1532.isEmpty()) {
							throw new RuntimeException();
						} else {
							var7 = MoveSpeed.method1141(var5);
							List var20 = var22.method2507(var21, var7);
							VarcInt.field1532 = new LinkedList(VarcInt.field1532);
							if (var20 != null) {
								VarcInt.field1532.retainAll(var20);
							} else {
								VarcInt.field1532.clear();
							}

							Decimator.field296 = VarcInt.field1532.iterator();
							if (var0 == 7507) {
								Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = VarcInt.field1532.size();
							}

							return 1;
						}
					}
				} else {
					--Interpreter_intStackSize;
					var3 = Interpreter.Interpreter_intStack[Interpreter_intStackSize];
					class506 var27 = IgnoreList.method2190(var3);
					if (var27 == null) {
						throw new RuntimeException();
					} else {
						VarcInt.field1532 = var27.method2507(0, 0);
						var5 = 0;
						if (VarcInt.field1532 != null) {
							Client.field549 = var3;
							Decimator.field296 = VarcInt.field1532.iterator();
							var5 = VarcInt.field1532.size();
						}

						if (var0 == 7504) {
							Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = var5;
						}

						return 1;
					}
				}
			} else {
				if (Decimator.field296 != null && Decimator.field296.hasNext()) {
					Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = (Integer)Decimator.field296.next();
				} else {
					Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = -1;
				}

				return 1;
			}
		} else {
			var3 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
			var21 = MoveSpeed.method1143(var3);
			var5 = Interpreter.Interpreter_intStack[--Interpreter_intStackSize];
			var22 = class344.method1868(var5);
			if (var22 == null) {
				throw new RuntimeException();
			} else {
				var7 = MoveSpeed.method1141(var5);
				VarcInt.field1532 = var22.method2507(var21, var7);
				if (VarcInt.field1532 != null) {
					Client.field549 = UserComparator3.method682(var5);
					Decimator.field296 = VarcInt.field1532.iterator();
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = VarcInt.field1532.size();
					}
				} else {
					Client.field549 = -1;
					Decimator.field296 = null;
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++Interpreter_intStackSize - 1] = 0;
					}
				}

				return 1;
			}
		}
	}
}