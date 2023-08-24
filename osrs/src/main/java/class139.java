import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public enum class139 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	field1322(0, 0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	field1319(2, 1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	field1320(3, 2),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	field1321(4, 3),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	field1318(1, 4);

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Ldb;"
	)
	static LoginScreenAnimation field1323;
	@ObfuscatedName("km")
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("rj")
	@ObfuscatedSignature(
		descriptor = "Lrs;"
	)
	@Export("varclan")
	static class454 varclan;
	@ObfuscatedName("ai")
	public final int field1327;
	@ObfuscatedName("az")
	@Export("id")
	final int id;

	class139(int var3, int var4) {
		this.field1327 = var3;
		this.id = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V",
		garbageValue = "-1677394683"
	)
	public static void method756(AbstractArchive var0) {
		ParamComposition.ParamDefinition_archive = var0;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lch;Lch;IZI)I",
		garbageValue = "548586770"
	)
	@Export("compareWorlds")
	static int compareWorlds(World var0, World var1, int var2, boolean var3) {
		if (var2 == 1) {
			int var4 = var0.population;
			int var5 = var1.population;
			if (!var3) {
				if (var4 == -1) {
					var4 = 2001;
				}

				if (var5 == -1) {
					var5 = 2001;
				}
			}

			return var4 - var5;
		} else if (var2 == 2) {
			return var0.location - var1.location;
		} else if (var2 == 3) {
			if (var0.activity.equals("-")) {
				if (var1.activity.equals("-")) {
					return 0;
				} else {
					return var3 ? -1 : 1;
				}
			} else if (var1.activity.equals("-")) {
				return var3 ? 1 : -1;
			} else {
				return var0.activity.compareTo(var1.activity);
			}
		} else if (var2 == 4) {
			return var0.method390() ? (var1.method390() ? 0 : 1) : (var1.method390() ? -1 : 0);
		} else if (var2 == 5) {
			return var0.method388() ? (var1.method388() ? 0 : 1) : (var1.method388() ? -1 : 0);
		} else if (var2 == 6) {
			return var0.isPvp() ? (var1.isPvp() ? 0 : 1) : (var1.isPvp() ? -1 : 0);
		} else if (var2 == 7) {
			return var0.isMembersOnly() ? (var1.isMembersOnly() ? 0 : 1) : (var1.isMembersOnly() ? -1 : 0);
		} else {
			return var0.id - var1.id;
		}
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-808541663"
	)
	static int method759(int var0, Script var1, boolean var2) {
		if (var0 == 6500) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class125.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == 6501) {
				var3 = class18.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 6502) {
				var3 = VarcInt.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == 6506) {
					var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == class176.World_worlds[var5].id) {
							var4 = class176.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == 6507) {
					SoundCache.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3] == 1;
					class131.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != 6511) {
					if (var0 == 6512) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamComposition var9;
						if (var0 == 6513) {
							SoundCache.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var9 = ObjTypeCustomisation.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = class90.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class90.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6514) {
							SoundCache.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var9 = ObjTypeCustomisation.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = WorldMapElement.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = WorldMapElement.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6515) {
							SoundCache.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var9 = ObjTypeCustomisation.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = InvDefinition.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = InvDefinition.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6516) {
							SoundCache.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var9 = ObjTypeCustomisation.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = Players.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Players.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == 6518) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == 6519) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.clientType;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == 6521) {
							return 1;
						} else if (var0 == 6522) {
							--class137.Interpreter_stringStackSize;
							--SoundCache.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--class137.Interpreter_stringStackSize;
							--SoundCache.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6524) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == 6525) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == 6526) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == 6527) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.field424;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = class176.World_worlds[var7];
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}
}