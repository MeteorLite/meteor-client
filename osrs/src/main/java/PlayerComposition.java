import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("mt")
@Implements("PlayerComposition")
public class PlayerComposition {
	@ObfuscatedName("al")
	public static short[] field2904;
	@ObfuscatedName("an")
	public static short[][] field2905;
	@ObfuscatedName("ar")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("PlayerAppearance_cachedModels")
	public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	static class423 field2907;
	@ObfuscatedName("ah")
	static int field2906;
	@ObfuscatedName("au")
	int[] field2913;
	@ObfuscatedName("ae")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("ao")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("at")
	public int field2918;
	@ObfuscatedName("ac")
	public int field2916;
	@ObfuscatedName("ai")
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("az")
	@Export("hash")
	long hash;
	@ObfuscatedName("ap")
	long field2914;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "[Lho;"
	)
	@Export("customisations")
	ObjTypeCustomisation[] customisations;
	@ObfuscatedName("af")
	@Export("isFemale")
	boolean isFemale;

	static {
		equipmentIndices = new int[]{class209.field1857.field1871, class209.field1862.field1871, class209.field1858.field1871, class209.field1863.field1871, class209.field1860.field1871, class209.field1861.field1871, class209.field1859.field1871};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
		field2907 = new class423(16, class421.field3766);
		field2906 = 0;
	}

	public PlayerComposition() {
		this.field2918 = -1;
		this.field2916 = 0;
		this.isFemale = false;
	}

	@ObfuscatedSignature(
		descriptor = "(Lmt;)V"
	)
	PlayerComposition(PlayerComposition var1) {
		this.field2918 = -1;
		this.field2916 = 0;
		this.isFemale = false;
		int[] var2 = Arrays.copyOf(var1.equipment, var1.equipment.length);
		int[] var3 = Arrays.copyOf(var1.field2913, var1.field2913.length);
		ObjTypeCustomisation[] var4 = (ObjTypeCustomisation[])(var1.customisations != null ? (ObjTypeCustomisation[])Arrays.copyOf(var1.customisations, var1.customisations.length) : null);
		int[] var5 = Arrays.copyOf(var1.bodyColors, var1.bodyColors.length);
		this.method1717(var3, var2, var4, false, var5, var1.field2916, var1.npcTransformId, var1.field2918);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([I[I[Lho;Z[IIIII)V",
		garbageValue = "-1866336930"
	)
	public void method1717(int[] var1, int[] var2, ObjTypeCustomisation[] var3, boolean var4, int[] var5, int var6, int var7, int var8) {
		this.customisations = var3;
		this.isFemale = var4;
		this.field2918 = var8;
		this.method1718(var1, var2, var5, var6, var7);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "([I[I[IIII)V",
		garbageValue = "1458257561"
	)
	public void method1718(int[] var1, int[] var2, int[] var3, int var4, int var5) {
		if (var1 == null) {
			var1 = this.method1720(var4);
		}

		if (var2 == null) {
			var2 = this.method1720(var4);
		}

		this.field2913 = var1;
		this.equipment = var2;
		this.bodyColors = var3;
		this.field2916 = var4;
		this.npcTransformId = var5;
		this.setHash();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)[I",
		garbageValue = "67"
	)
	int[] method1720(int var1) {
		int[] var2 = new int[12];

		for (int var3 = 0; var3 < 7; ++var3) {
			for (int var4 = 0; var4 < KitDefinition.KitDefinition_fileCount; ++var4) {
				KitDefinition var5 = ClanChannel.KitDefinition_get(var4);
				if (var5 != null && !var5.nonSelectable && var3 + (var1 == 1 ? 7 : 0) == var5.bodypartID) {
					var2[equipmentIndices[var3]] = var4 + 256;
					break;
				}
			}
		}

		return var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "-1083968287"
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
						var3 = KitDefinition.KitDefinition_fileCount - 1;
					}
				} else {
					++var3;
					if (var3 >= KitDefinition.KitDefinition_fileCount) {
						var3 = 0;
					}
				}

				var4 = ClanChannel.KitDefinition_get(var3);
			} while(var4 == null || var4.nonSelectable || (this.field2916 == 1 ? 7 : 0) + var1 != var4.bodypartID);

			this.equipment[equipmentIndices[var1]] = var3 + 256;
			this.setHash();
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IZB)V",
		garbageValue = "8"
	)
	public void method1722(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = class140.field1328[var1].length - 1;
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
				if (var3 >= class140.field1328[var1].length) {
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-782377094"
	)
	public void method1723(int var1) {
		if (this.field2916 != var1) {
			this.method1718((int[])null, (int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-544852329"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.field2916);

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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "12"
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
		this.hash += (long)this.field2916;
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && var1 != this.hash || this.isFemale) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lib;ILib;II)Ljr;",
		garbageValue = "-616726225"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return class90.getNpcDefinition(this.npcTransformId).method985(var1, var2, var3, var4, (NewShit)null);
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
					if (var11 >= 256 && var11 < 512 && !ClanChannel.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !InvDefinition.ItemDefinition_get(var11 - 512).method1061(this.field2916)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field2914) {
						var18 = (Model)PlayerAppearance_cachedModels.get(this.field2914);
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
							ModelData var14 = ClanChannel.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var19[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							ItemComposition var22 = InvDefinition.ItemDefinition_get(var13 - 512);
							ModelData var15 = var22.method1062(this.field2916);
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

										if (var16.retex != null && var22.retextureFrom != null && var16.retex.length == var22.retextureTo.length) {
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
						if (this.bodyColors[var13] < class140.field1328[var13].length) {
							var20.recolor(UrlRequest.field1174[var13], class140.field1328[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < field2905[var13].length) {
							var20.recolor(field2904[var13], field2905[var13][this.bodyColors[var13]]);
						}
					}

					var18 = var20.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var18, var5);
					this.field2914 = var5;
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

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)Lic;",
		garbageValue = "-812517450"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return class90.getNpcDefinition(this.npcTransformId).method986((NewShit)null);
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !ClanChannel.KitDefinition_get(var3 - 256).method961()) {
					var1 = true;
				}

				if (var3 >= 512 && !InvDefinition.ItemDefinition_get(var3 - 512).method1063(this.field2916)) {
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
						var6 = ClanChannel.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = InvDefinition.ItemDefinition_get(var5 - 512).method1064(this.field2916);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < class140.field1328[var5].length) {
						var8.recolor(UrlRequest.field1174[var5], class140.field1328[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < field2905[var5].length) {
						var8.recolor(field2904[var5], field2905[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "14"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		long var1 = this.hash;
		if (this.npcTransformId != -1) {
			var1 = -65536L | (long)this.npcTransformId;
		}

		Integer var3 = (Integer)field2907.method2180(var1);
		if (var3 == null) {
			var3 = ++field2906 - 1;
			field2907.method2181(var1, var3);
			field2906 %= 65535;
		}

		return var3;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1158771729"
	)
	void method1729() {
		this.method1718(this.field2913, this.equipment, this.bodyColors, this.field2916, this.npcTransformId);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(CLon;B)C",
		garbageValue = "1"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else {
			return var0 == 376 ? 'Y' : var0;
		}
	}
}