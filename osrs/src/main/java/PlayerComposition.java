import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
@Implements("PlayerComposition")
public class PlayerComposition {
	@ObfuscatedName("b")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "Ljx;"
	)
	@Export("PlayerAppearance_cachedModels")
	static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("a")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("f")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1490136635
	)
	public int field3425;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1040392237
	)
	public int field3423;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -79707607
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		longValue = 59114764337406355L
	)
	@Export("hash")
	long hash;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		longValue = -4365974817637349645L
	)
	long field3420;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "[Lfw;"
	)
	class174[] field3427;
	@ObfuscatedName("n")
	boolean field3428;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	public PlayerComposition() {
		this.field3425 = -1;
		this.field3423 = 0;
		this.field3428 = false;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "([I[Lfw;Z[IIIII)V",
		garbageValue = "1081958245"
	)
	public void method5730(int[] var1, class174[] var2, boolean var3, int[] var4, int var5, int var6, int var7) {
		this.field3427 = var2;
		this.field3428 = var3;
		this.field3425 = var7;
		this.method5731(var1, var4, var5, var6);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "([I[IIII)V",
		garbageValue = "-1357740388"
	)
	public void method5731(int[] var1, int[] var2, int var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = Script.KitDefinition_get(var6);
					if (var7 != null && !var7.nonSelectable && var5 + (var3 == 1 ? 7 : 0) == var7.bodypartID) {
						var1[equipmentIndices[var5]] = var6 + 256;
						break;
					}
				}
			}
		}

		this.equipment = var1;
		this.bodyColors = var2;
		this.field3423 = var3;
		this.npcTransformId = var4;
		this.setHash();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IZB)V",
		garbageValue = "28"
	)
	@Export("changeAppearance")
	public void changeAppearance(int var1, boolean var2) {
		if (var1 != 1 || this.field3423 != 1) {
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

					var4 = Script.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var1 + (this.field3423 == 1 ? 7 : 0) != var4.bodypartID);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(IZI)V",
		garbageValue = "-2095549182"
	)
	public void method5745(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = class34.field193[var1].length - 1;
				}
			} while(!class131.method2952(var1, var3));
		} else {
			do {
				++var3;
				if (var3 >= class34.field193[var1].length) {
					var3 = 0;
				}
			} while(!class131.method2952(var1, var3));
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "72"
	)
	public void method5732(int var1) {
		if (this.field3423 != var1) {
			this.method5731((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(Lqr;B)V",
		garbageValue = "101"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.field3423);

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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1912909156"
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
		this.hash += (long)(this.field3423 * 568602533) * 1040392237L;
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (0L != var1 && var1 != this.hash || this.field3428) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(Lgg;ILgg;II)Lha;",
		garbageValue = "-990876935"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return HealthBarDefinition.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
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
					if (var11 >= 256 && var11 < 512 && !Script.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !MidiPcmStream.ItemDefinition_get(var11 - 512).method3826(this.field3423)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field3420) {
						var18 = (Model)PlayerAppearance_cachedModels.get(this.field3420);
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
							ModelData var14 = Script.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var19[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							ItemComposition var22 = MidiPcmStream.ItemDefinition_get(var13 - 512);
							ModelData var15 = var22.method3779(this.field3423);
							if (var15 != null) {
								if (this.field3427 != null) {
									class174 var16 = this.field3427[var12];
									if (var16 != null) {
										int var17;
										if (var16.field1858 != null && var22.recolorFrom != null && var16.field1858.length == var22.recolorTo.length) {
											for (var17 = 0; var17 < var22.recolorFrom.length; ++var17) {
												var15.recolor(var22.recolorTo[var17], var16.field1858[var17]);
											}
										}

										if (var16.field1855 != null && var22.retextureFrom != null && var22.retextureTo.length == var16.field1855.length) {
											for (var17 = 0; var17 < var22.retextureFrom.length; ++var17) {
												var15.retexture(var22.retextureTo[var17], var16.field1855[var17]);
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
						if (this.bodyColors[var13] < class34.field193[var13].length) {
							var20.recolor(TaskHandler.field1780[var13], class34.field193[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < ArchiveLoader.field1016[var13].length) {
							var20.recolor(class21.field114[var13], ArchiveLoader.field1016[var13][this.bodyColors[var13]]);
						}
					}

					var18 = var20.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var18, var5);
					this.field3420 = var5;
				}
			}

			if (var1 == null && var3 == null) {
				return var18;
			} else {
				Model var21;
				if (var1 != null && var3 != null) {
					var21 = var1.applyTransformations(var18, var2, var3, var4);
				} else if (var1 != null) {
					var21 = var1.transformActorModel(var18, var2);
				} else {
					var21 = var3.transformActorModel(var18, var4);
				}

				return var21;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)Lgs;",
		garbageValue = "-4"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return HealthBarDefinition.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !Script.KitDefinition_get(var3 - 256).method3470()) {
					var1 = true;
				}

				if (var3 >= 512 && !MidiPcmStream.ItemDefinition_get(var3 - 512).method3824(this.field3423)) {
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
						var6 = Script.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = MidiPcmStream.ItemDefinition_get(var5 - 512).method3787(this.field3423);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < class34.field193[var5].length) {
						var8.recolor(TaskHandler.field1780[var5], class34.field193[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < ArchiveLoader.field1016[var5].length) {
						var8.recolor(class21.field114[var5], ArchiveLoader.field1016[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "73"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + HealthBarDefinition.getNpcDefinition(this.npcTransformId).id;
	}
}
