import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("ct")
public class class59 {
	@ObfuscatedName("iz")
	static int field302;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lbu;"
	)
	VorbisFloor field305;
	@ObfuscatedName("ah")
	boolean field303;
	@ObfuscatedName("ar")
	int[] field307;
	@ObfuscatedName("ao")
	int[] field306;
	@ObfuscatedName("ab")
	boolean[] field304;

	@ObfuscatedSignature(
		descriptor = "(Lbu;Z[I[I[Z)V"
	)
	class59(VorbisFloor var1, boolean var2, int[] var3, int[] var4, boolean[] var5) {
		this.field305 = var1;
		this.field303 = var2;
		this.field307 = var3;
		this.field306 = var4;
		this.field304 = var5;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([FII)V",
		garbageValue = "-121312327"
	)
	void method329(float[] var1, int var2) {
		int var3 = this.field305.field175.length;
		VorbisFloor var10000 = this.field305;
		int var4 = VorbisFloor.field170[this.field305.multiplier - 1];
		boolean[] var5 = this.field304;
		this.field304[1] = true;
		var5[0] = true;

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		for (var6 = 2; var6 < var3; ++var6) {
			var7 = this.field305.method205(this.field307, var6);
			var8 = this.field305.method206(this.field307, var6);
			var9 = this.field305.method207(this.field307[var7], this.field306[var7], this.field307[var8], this.field306[var8], this.field307[var6]);
			var10 = this.field306[var6];
			int var11 = var4 - var9;
			int var13 = (var11 < var9 ? var11 : var9) << 1;
			if (var10 != 0) {
				boolean[] var14 = this.field304;
				this.field304[var8] = true;
				var14[var7] = true;
				this.field304[var6] = true;
				if (var10 >= var13) {
					this.field306[var6] = var11 > var9 ? var9 + (var10 - var9) : var11 + (var9 - var10) - 1;
				} else {
					this.field306[var6] = (var10 & 1) != 0 ? var9 - (var10 + 1) / 2 : var10 / 2 + var9;
				}
			} else {
				this.field304[var6] = false;
				this.field306[var6] = var9;
			}
		}

		this.VarbisFloor_sort(0, var3 - 1);
		var6 = 0;
		var7 = this.field305.multiplier * this.field306[0];

		for (var8 = 1; var8 < var3; ++var8) {
			if (this.field304[var8]) {
				var9 = this.field307[var8];
				var10 = this.field305.multiplier * this.field306[var8];
				this.field305.method208(var6, var7, var9, var10, var1, var2);
				if (var9 >= var2) {
					return;
				}

				var6 = var9;
				var7 = var10;
			}
		}

		var10000 = this.field305;
		float var16 = VorbisFloor.VorbisFloor_decibelStatics[var7];

		for (var9 = var6; var9 < var2; ++var9) {
			var1[var9] *= var16;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1465438441"
	)
	boolean method330() {
		return this.field303;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1888348492"
	)
	@Export("VarbisFloor_sort")
	void VarbisFloor_sort(int var1, int var2) {
		if (var1 < var2) {
			int var3 = var1;
			int var4 = this.field307[var1];
			int var5 = this.field306[var1];
			boolean var6 = this.field304[var1];

			for (int var7 = var1 + 1; var7 <= var2; ++var7) {
				int var8 = this.field307[var7];
				if (var8 < var4) {
					this.field307[var3] = var8;
					this.field306[var3] = this.field306[var7];
					this.field304[var3] = this.field304[var7];
					++var3;
					this.field307[var7] = this.field307[var3];
					this.field306[var7] = this.field306[var3];
					this.field304[var7] = this.field304[var3];
				}
			}

			this.field307[var3] = var4;
			this.field306[var3] = var5;
			this.field304[var3] = var6;
			this.VarbisFloor_sort(var1, var3 - 1);
			this.VarbisFloor_sort(var3 + 1, var2);
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1858684336"
	)
	static void method332() {
		ItemContainer.itemContainers = new NodeHashTable(32);
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "5"
	)
	static int method333(int var0, Script var1, boolean var2) {
		int var3;
		int var5;
		int var7;
		Object var21;
		DbTable var22;
		if (var0 != 7500 && var0 != 7508) {
			if (var0 != 7501) {
				int var4;
				int var6;
				if (var0 == 7502) {
					DbTableType.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
					var6 = SequenceDefinition.method1041(var4);
					var7 = ZoneOperation.method1630(var4);
					int var8 = class134.method731(var4);
					DbRowType var23 = class469.getDbRowType(var3);
					DbTableType var24 = FadeOutTask.getDbTableType(var6);
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
							class514 var17 = class472.method2349(var16);
							if (var17 == class514.field4125) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = MusicPatchNode.method1723(var16);
							}
						}

						return 1;
					} else {
						var15 = var14.length / var25.length;
						if (var5 >= 0 && var5 < var15) {
							for (var16 = var12; var16 < var13; ++var16) {
								int var19 = var16 + var25.length * var5;
								class514 var18 = class472.method2349(var25[var16]);
								if (var18 == class514.field4125) {
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = (String)var14[var19];
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (Integer)var14[var19];
								}
							}

							return 1;
						} else {
							throw new RuntimeException();
						}
					}
				} else if (var0 == 7503) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					var5 = 0;
					var6 = SequenceDefinition.method1041(var4);
					var7 = ZoneOperation.method1630(var4);
					DbRowType var26 = class469.getDbRowType(var3);
					DbTableType var9 = FadeOutTask.getDbTableType(var6);
					int[] var10 = var9.types[var7];
					Object[] var11 = var26.getColumnType(var7);
					if (var11 == null && var9.defaultValues != null) {
						var11 = var9.defaultValues[var7];
					}

					if (var11 != null) {
						var5 = var11.length / var10.length;
					}

					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5;
					return 1;
				} else if (var0 != 7504 && var0 != 7510) {
					if (var0 == 7505) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						DbRowType var28 = class469.getDbRowType(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var28.tableId;
						return 1;
					} else if (var0 == 7506) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var4 = -1;
						if (DevicePcmPlayerProvider.field67 != null && var3 >= 0 && var3 < DevicePcmPlayerProvider.field67.size()) {
							var4 = (Integer)DevicePcmPlayerProvider.field67.get(var3);
						}

						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4;
						return 1;
					} else if (var0 != 7507 && var0 != 7509) {
						return 2;
					} else {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var21 = WorldMapLabelSize.method1187(var3);
						var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var22 = class168.getDbTable(var5);
						if (var22 == null) {
							throw new RuntimeException();
						} else if (SequenceDefinition.method1041(var5) != Client.field545) {
							throw new RuntimeException();
						} else if (DevicePcmPlayerProvider.field67 == null && DevicePcmPlayerProvider.field67.isEmpty()) {
							throw new RuntimeException();
						} else {
							var7 = class134.method731(var5);
							List var20 = var22.method2518(var21, var7);
							DevicePcmPlayerProvider.field67 = new LinkedList(DevicePcmPlayerProvider.field67);
							if (var20 != null) {
								DevicePcmPlayerProvider.field67.retainAll(var20);
							} else {
								DevicePcmPlayerProvider.field67.clear();
							}

							class10.field30 = DevicePcmPlayerProvider.field67.iterator();
							if (var0 == 7507) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = DevicePcmPlayerProvider.field67.size();
							}

							return 1;
						}
					}
				} else {
					--DbTableType.Interpreter_intStackSize;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					DbTable var27 = UserComparator4.method668(var3);
					if (var27 == null) {
						throw new RuntimeException();
					} else {
						DevicePcmPlayerProvider.field67 = var27.method2518(0, 0);
						var5 = 0;
						if (DevicePcmPlayerProvider.field67 != null) {
							Client.field545 = var3;
							class10.field30 = DevicePcmPlayerProvider.field67.iterator();
							var5 = DevicePcmPlayerProvider.field67.size();
						}

						if (var0 == 7504) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5;
						}

						return 1;
					}
				}
			} else {
				if (class10.field30 != null && class10.field30.hasNext()) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (Integer)class10.field30.next();
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
				}

				return 1;
			}
		} else {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			var21 = WorldMapLabelSize.method1187(var3);
			var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			var22 = class168.getDbTable(var5);
			if (var22 == null) {
				throw new RuntimeException();
			} else {
				var7 = class134.method731(var5);
				DevicePcmPlayerProvider.field67 = var22.method2518(var21, var7);
				if (DevicePcmPlayerProvider.field67 != null) {
					Client.field545 = SequenceDefinition.method1041(var5);
					class10.field30 = DevicePcmPlayerProvider.field67.iterator();
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = DevicePcmPlayerProvider.field67.size();
					}
				} else {
					Client.field545 = -1;
					class10.field30 = null;
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		descriptor = "(Lcb;III)V",
		garbageValue = "1570010040"
	)
	static final void method334(MenuAction var0, int var1, int var2) {
		if (var0 != null) {
			class407.menuAction(var0.param0, var0.param1, var0.opcode, var0.identifier, var0.itemId, var0.action, var0.target, var1, var2);
		}

	}
}