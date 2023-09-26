import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("ni")
@Implements("PlayerComposition")
public class PlayerComposition {
	@ObfuscatedName("ag")
	public static short[] field2940;
	@ObfuscatedName("as")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("PlayerAppearance_cachedModels")
	public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lqe;"
	)
	public static class438 field2939;
	@ObfuscatedName("ae")
	public static int field2937;
	@ObfuscatedName("ac")
	int[] field2944;
	@ObfuscatedName("al")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("ak")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("ax")
	public int field2951;
	@ObfuscatedName("ao")
	public int field2950;
	@ObfuscatedName("ah")
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("ar")
	@Export("hash")
	long hash;
	@ObfuscatedName("ab")
	long field2947;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Lhy;"
	)
	@Export("customisations")
	ObjTypeCustomisation[] customisations;
	@ObfuscatedName("av")
	@Export("isFemale")
	boolean isFemale;

	static {
		equipmentIndices = new int[]{class223.field1868.field1879, class223.field1865.field1879, class223.field1869.field1879, class223.field1870.field1879, class223.field1871.field1879, class223.field1866.field1879, class223.field1867.field1879};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
		field2939 = new class438(16, class436.field3797);
		field2937 = 0;
	}

	public PlayerComposition() {
		this.field2951 = -1;
		this.field2950 = 0;
		this.isFemale = false;
	}

	@ObfuscatedSignature(
		descriptor = "(Lni;)V"
	)
	PlayerComposition(PlayerComposition var1) {
		this.field2951 = -1;
		this.field2950 = 0;
		this.isFemale = false;
		int[] var2 = Arrays.copyOf(var1.equipment, var1.equipment.length);
		int[] var3 = Arrays.copyOf(var1.field2944, var1.field2944.length);
		ObjTypeCustomisation[] var4 = (ObjTypeCustomisation[])(var1.customisations != null ? (ObjTypeCustomisation[])Arrays.copyOf(var1.customisations, var1.customisations.length) : null);
		int[] var5 = Arrays.copyOf(var1.bodyColors, var1.bodyColors.length);
		this.method1749(var3, var2, var4, false, var5, var1.field2950, var1.npcTransformId, var1.field2951);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([I[I[Lhy;Z[IIIII)V",
		garbageValue = "-106574907"
	)
	public void method1749(int[] var1, int[] var2, ObjTypeCustomisation[] var3, boolean var4, int[] var5, int var6, int var7, int var8) {
		this.customisations = var3;
		this.isFemale = var4;
		this.field2951 = var8;
		this.method1750(var1, var2, var5, var6, var7);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "([I[I[IIIB)V",
		garbageValue = "108"
	)
	public void method1750(int[] var1, int[] var2, int[] var3, int var4, int var5) {
		if (var1 == null) {
			var1 = this.method1751(var4);
		}

		if (var2 == null) {
			var2 = this.method1751(var4);
		}

		this.field2944 = var1;
		this.equipment = var2;
		this.bodyColors = var3;
		this.field2950 = var4;
		this.npcTransformId = var5;
		this.setHash();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)[I",
		garbageValue = "1"
	)
	int[] method1751(int var1) {
		int[] var2 = new int[12];

		for (int var3 = 0; var3 < 7; ++var3) {
			for (int var4 = 0; var4 < class403.KitDefinition_fileCount; ++var4) {
				KitDefinition var5 = class73.KitDefinition_get(var4);
				if (var5 != null && !var5.nonSelectable && var3 + (var1 == 1 ? 7 : 0) == var5.bodypartID) {
					var2[equipmentIndices[var3]] = var4 + 256;
					break;
				}
			}
		}

		return var2;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "-151201208"
	)
	@Export("changeAppearance")
	public void changeAppearance(int var1, boolean var2) {
		int var3 = this.equipment[equipmentIndices[var1]];
		if (var3 != 0) {
			var3 -= 256;

			KitDefinition var4;
			do {
				if (!var2) {
					--var3;
					if (var3 < 0) {
						var3 = class403.KitDefinition_fileCount - 1;
					}
				} else {
					++var3;
					if (var3 >= class403.KitDefinition_fileCount) {
						var3 = 0;
					}
				}

				var4 = class73.KitDefinition_get(var3);
			} while(var4 == null || var4.nonSelectable || (this.field2950 == 1 ? 7 : 0) + var1 != var4.bodypartID);

			this.equipment[equipmentIndices[var1]] = var3 + 256;
			this.setHash();
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "1880856093"
	)
	public void method1753(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = class104.field1093[var1].length - 1;
				}

				if (var1 == 4 && var3 >= 8) {
					var4 = false;
				} else {
					var4 = true;
				}
			} while(!var4);
		} else {
			do {
				++var3;
				if (var3 >= class104.field1093[var1].length) {
					var3 = 0;
				}

				if (var1 == 4 && var3 >= 8) {
					var4 = false;
				} else {
					var4 = true;
				}
			} while(!var4);
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-554597133"
	)
	public void method1754(int var1) {
		if (this.field2950 != var1) {
			this.method1750((int[])null, (int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lul;B)V",
		garbageValue = "28"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.field2950);

		int var2;
		for (var2 = 0; var2 < 7; ++var2) {
			int var3 = this.equipment[equipmentIndices[var2]];
			if (var3 == 0) {
				var1.writeByte(-1);
			} else {
				var1.writeByte(var3 - 256);
			}
		}

		for (var2 = 0; var2 < 5; ++var2) {
			var1.writeByte(this.bodyColors[var2]);
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "89"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.hash;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.hash = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.hash <<= 4;
			if (this.equipment[var5] >= 256) {
				this.hash += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.hash += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.hash += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.hash <<= 3;
			this.hash += (long)this.bodyColors[var5];
		}

		this.hash <<= 1;
		this.hash += (long)this.field2950;
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && var1 != this.hash || this.isFemale) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lif;ILif;II)Ljn;",
		garbageValue = "745471626"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return class190.getNpcDefinition(this.npcTransformId).method1011(var1, var2, var3, var4, (NewShit)null);
		} else {
			long var5 = this.hash;
			int[] var7 = this.equipment;
			if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
				var7 = new int[12];

				for (int var8 = 0; var8 < 12; ++var8) {
					var7[var8] = this.equipment[var8];
				}

				if (var1.shield >= 0) {
					var5 += (long)(var1.shield - this.equipment[5] << 40);
					var7[5] = var1.shield;
				}

				if (var1.weapon >= 0) {
					var5 += (long)(var1.weapon - this.equipment[3] << 48);
					var7[3] = var1.weapon;
				}
			}

			Model var18 = (Model)PlayerAppearance_cachedModels.get(var5);
			if (var18 == null) {
				boolean var9 = false;

				int var11;
				for (int var10 = 0; var10 < 12; ++var10) {
					var11 = var7[var10];
					if (var11 >= 256 && var11 < 512 && !class73.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !class214.ItemDefinition_get(var11 - 512).method1099(this.field2950)) {
						var9 = true;
					}
				}

				if (var9) {
					if (this.field2947 != -1L) {
						var18 = (Model)PlayerAppearance_cachedModels.get(this.field2947);
					}

					if (var18 == null) {
						return null;
					}
				}

				if (var18 == null) {
					ModelData[] var19 = new ModelData[12];
					var11 = 0;

					int var13;
					for (int var12 = 0; var12 < 12; ++var12) {
						var13 = var7[var12];
						if (var13 >= 256 && var13 < 512) {
							ModelData var14 = class73.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var19[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							ItemComposition var22 = class214.ItemDefinition_get(var13 - 512);
							ModelData var15 = var22.method1100(this.field2950);
							if (var15 != null) {
								if (this.customisations != null) {
									ObjTypeCustomisation var16 = this.customisations[var12];
									if (var16 != null) {
										int var17;
										if (var16.recol != null && var22.recolorFrom != null && var22.recolorTo.length == var16.recol.length) {
											for (var17 = 0; var17 < var22.recolorFrom.length; ++var17) {
												var15.recolor(var22.recolorTo[var17], var16.recol[var17]);
											}
										}

										if (var16.retex != null && var22.retextureFrom != null && var22.retextureTo.length == var16.retex.length) {
											for (var17 = 0; var17 < var22.retextureFrom.length; ++var17) {
												var15.retexture(var22.retextureTo[var17], var16.retex[var17]);
											}
										}
									}
								}

								var19[var11++] = var15;
							}
						}
					}

					ModelData var20 = new ModelData(var19, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < class104.field1093[var13].length) {
							var20.recolor(field2940[var13], class104.field1093[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < class33.field87[var13].length) {
							var20.recolor(Coord.field2906[var13], class33.field87[var13][this.bodyColors[var13]]);
						}
					}

					var18 = var20.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var18, var5);
					this.field2947 = var5;
				}
			}

			Model var21;
			if (var1 == null && var3 == null) {
				var21 = var18.toSharedSequenceModel(true);
			} else if (var1 != null && var3 != null) {
				var21 = var1.applyTransformations(var18, var2, var3, var4);
			} else if (var1 != null) {
				var21 = var1.transformActorModel(var18, var2);
			} else {
				var21 = var3.transformActorModel(var18, var4);
			}

			return var21;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljw;",
		garbageValue = "-578216920"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return class190.getNpcDefinition(this.npcTransformId).method1012((NewShit)null);
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !class73.KitDefinition_get(var3 - 256).method984()) {
					var1 = true;
				}

				if (var3 >= 512 && !class214.ItemDefinition_get(var3 - 512).method1101(this.field2950)) {
					var1 = true;
				}
			}

			if (var1) {
				return null;
			} else {
				ModelData[] var7 = new ModelData[12];
				var3 = 0;

				int var5;
				for (int var4 = 0; var4 < 12; ++var4) {
					var5 = this.equipment[var4];
					ModelData var6;
					if (var5 >= 256 && var5 < 512) {
						var6 = class73.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = class214.ItemDefinition_get(var5 - 512).method1102(this.field2950);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < class104.field1093[var5].length) {
						var8.recolor(field2940[var5], class104.field1093[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < class33.field87[var5].length) {
						var8.recolor(Coord.field2906[var5], class33.field87[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1292206549"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		long var1 = this.hash;
		if (this.npcTransformId != -1) {
			var1 = -65536L | (long)this.npcTransformId;
		}

		Integer var3 = (Integer)field2939.method2216(var1);
		if (var3 == null) {
			var3 = ++field2937 - 1;
			field2939.method2217(var1, var3);
			field2937 %= 65535;
		}

		return var3;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	void method1760() {
		this.method1750(this.field2944, this.equipment, this.bodyColors, this.field2950, this.npcTransformId);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)I",
		garbageValue = "20"
	)
	static final int method1748(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "63"
	)
	static int method1761(int var0, Script var1, boolean var2) {
		if (var0 == 5306) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class178.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == 5307) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					NPCComposition.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == 5308) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class91.clientPreferences.method562();
				return 1;
			} else if (var0 != 5309) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					class91.clientPreferences.method561(var3);
				}

				return 1;
			}
		}
	}
}