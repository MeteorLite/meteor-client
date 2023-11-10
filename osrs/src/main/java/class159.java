import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("ge")
public class class159 extends class144 {
	@ObfuscatedName("at")
	long field1405;
	@ObfuscatedName("ah")
	String field1404;
	@ObfuscatedName("ar")
	int field1403;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class159(class147 var1) {
		this.this$0 = var1;
		this.field1405 = -1L;
		this.field1404 = null;
		this.field1403 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1405 = var1.readLong();
		}

		this.field1404 = var1.readStringCp1252NullTerminatedOrNull();
		this.field1403 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method804(this.field1405, this.field1404, this.field1403);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "118"
	)
	static void method834() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "404161563"
	)
	static int method837(int var0, Script var1, boolean var2) {
		if (var0 == 3200) {
			DbTableType.Interpreter_intStackSize -= 3;
			class460.queueSoundEffect(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2]);
			return 1;
		} else {
			int var3;
			int var4;
			int var5;
			int var6;
			int var7;
			if (var0 == 3201) {
				DbTableType.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 4];
				ArrayList var8 = new ArrayList();
				var8.add(var3);
				class135.method734(var8, var4, var5, var6, var7);
				return 1;
			} else if (var0 == 3202) {
				DbTableType.Interpreter_intStackSize -= 2;
				FileSystem.playJingle(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
				return 1;
			} else {
				class90 var12;
				class89 var13;
				String var15;
				if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
					boolean var16;
					if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
						if (var0 == 3211) {
							return 1;
						} else if (var0 == 3216) {
							var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var4 = 0;
							class90 var18 = (class90)class12.findEnumerated(UserComparator3.method679(), var3);
							if (var18 != null) {
								var4 = var18 != class90.field898 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 == 3218) {
							var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var4 = 0;
							class89 var10 = (class89)class12.findEnumerated(HealthBar.method569(), var3);
							if (var10 != null) {
								var4 = var10 != class89.field889 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 != 3217 && var0 != 3219) {
							if (var0 == 3220) {
								DbTableType.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
								WorldMapManager.method1265(var3, var4);
								return 1;
							} else if (var0 == 3221) {
								DbTableType.Interpreter_intStackSize -= 6;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
								var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 4];
								int var11 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 5];
								ArrayList var9 = new ArrayList();
								var9.add(var3);
								var9.add(var4);
								class135.method734(var9, var5, var6, var7, var11);
								return 1;
							} else if (var0 == 3222) {
								DbTableType.Interpreter_intStackSize -= 4;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
								class191.someMusicMethod(var3, var4, var5, var6);
								return 1;
							} else {
								return 2;
							}
						} else {
							var12 = class90.field898;
							var13 = class89.field889;
							var16 = true;
							boolean var17 = true;
							if (var0 == 3217) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								var12 = (class90)class12.findEnumerated(UserComparator3.method679(), var7);
								if (var12 == null) {
									throw new RuntimeException(String.format("Unrecognized device option %d", var7));
								}
							}

							if (var0 == 3219) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								var13 = (class89)class12.findEnumerated(HealthBar.method569(), var7);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized game option %d", var7));
								}
							}

							String var14;
							byte var19;
							if (var13 == class89.field889) {
								switch(var12.field900) {
								case 1:
								case 2:
								case 3:
									var19 = 0;
									var6 = 1;
									break;
								case 4:
									var19 = 0;
									var6 = Integer.MAX_VALUE;
									break;
								case 5:
									var19 = 0;
									var6 = 100;
									break;
								default:
									var14 = String.format("Unkown device option: %s.", var12.toString());
									throw new RuntimeException(var14);
								}
							} else {
								switch(var13.field891) {
								case 1:
									var19 = 0;
									var6 = 1;
									break;
								case 2:
								case 3:
								case 4:
									var19 = 0;
									var6 = 100;
									break;
								default:
									var14 = String.format("Unkown game option: %s.", var13.toString());
									throw new RuntimeException(var14);
								}
							}

							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var19;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6;
							return 1;
						}
					} else {
						var12 = class90.field898;
						var13 = class89.field889;
						var16 = false;
						if (var0 == 3214) {
							var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var12 = (class90)class12.findEnumerated(UserComparator3.method679(), var6);
							if (var12 == null) {
								throw new RuntimeException(String.format("Unrecognized device option %d", var6));
							}
						}

						if (var0 == 3215) {
							var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var13 = (class89)class12.findEnumerated(HealthBar.method569(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized game option %d", var6));
							}
						}

						if (var0 == 3210) {
							var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var12 = (class90)class12.findEnumerated(UserComparator3.method679(), var6);
							if (var12 == null) {
								var13 = (class89)class12.findEnumerated(HealthBar.method569(), var6);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized client option %d", var6));
								}
							}
						} else if (var0 == 3182) {
							var12 = class90.field899;
						} else if (var0 == 3204) {
							var13 = class89.field888;
						} else if (var0 == 3206) {
							var13 = class89.field887;
						} else if (var0 == 3208) {
							var13 = class89.field885;
						}

						if (var13 == class89.field889) {
							switch(var12.field900) {
							case 1:
								var5 = WorldMapIcon_1.clientPreferences.getIsUsernameHidden() ? 1 : 0;
								break;
							case 2:
								var5 = WorldMapIcon_1.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
								break;
							case 3:
								var5 = WorldMapIcon_1.clientPreferences.method547() ? 1 : 0;
								break;
							case 4:
								var5 = WorldMapIcon_1.clientPreferences.method549();
								break;
							case 5:
								var5 = class216.method1099();
								break;
							default:
								var15 = String.format("Unkown device option: %s.", var12.toString());
								throw new RuntimeException(var15);
							}
						} else {
							switch(var13.field891) {
							case 1:
								var5 = WorldMapIcon_1.clientPreferences.getRoofsHidden() ? 1 : 0;
								break;
							case 2:
								var6 = WorldMapIcon_1.clientPreferences.getCurrentMusicVolume();
								var5 = Math.round((float)(var6 * 100) / 255.0F);
								break;
							case 3:
								var6 = WorldMapIcon_1.clientPreferences.getCurrentSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							case 4:
								var6 = WorldMapIcon_1.clientPreferences.getAreaSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							default:
								var15 = String.format("Unkown game option: %s.", var13.toString());
								throw new RuntimeException(var15);
							}
						}

						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5;
						return 1;
					}
				} else {
					var12 = class90.field898;
					var13 = class89.field889;
					var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					if (var0 == 3212) {
						var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var12 = (class90)class12.findEnumerated(UserComparator3.method679(), var6);
						if (var12 == null) {
							throw new RuntimeException(String.format("Unrecognized device option %d", var6));
						}
					}

					if (var0 == 3213) {
						var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var13 = (class89)class12.findEnumerated(HealthBar.method569(), var6);
						if (var13 == null) {
							throw new RuntimeException(String.format("Unrecognized game option %d", var6));
						}
					}

					if (var0 == 3209) {
						var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var12 = (class90)class12.findEnumerated(UserComparator3.method679(), var6);
						if (var12 == null) {
							var13 = (class89)class12.findEnumerated(HealthBar.method569(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized client option %d", var6));
							}
						}
					} else if (var0 == 3181) {
						var12 = class90.field899;
					} else if (var0 == 3203) {
						var13 = class89.field888;
					} else if (var0 == 3205) {
						var13 = class89.field887;
					} else if (var0 == 3207) {
						var13 = class89.field885;
					}

					if (var13 == class89.field889) {
						switch(var12.field900) {
						case 1:
							WorldMapIcon_1.clientPreferences.setIsUsernameHidden(var5 == 1);
							break;
						case 2:
							WorldMapIcon_1.clientPreferences.getTitleMusicDisabled(var5 == 1);
							break;
						case 3:
							WorldMapIcon_1.clientPreferences.method545(var5 == 1);
							break;
						case 4:
							if (var5 < 0) {
								var5 = 0;
							}

							WorldMapIcon_1.clientPreferences.method548(var5);
							break;
						case 5:
							class311.method1647(var5);
							break;
						default:
							var15 = String.format("Unkown device option: %s.", var12.toString());
							throw new RuntimeException(var15);
						}
					} else {
						switch(var13.field891) {
						case 1:
							WorldMapIcon_1.clientPreferences.setRoofsHidden(var5 == 1);
							break;
						case 2:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 255) / 100.0F);
							Decimator.method323(var6);
							break;
						case 3:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							SoundSystem.method235(var6);
							break;
						case 4:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							Login.method438(var6);
							break;
						default:
							var15 = String.format("Unkown game option: %s.", var13.toString());
							throw new RuntimeException(var15);
						}
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)V",
		garbageValue = "227996304"
	)
	@Export("invalidateWidget")
	public static void invalidateWidget(Widget var0) {
		if (var0 != null && var0.cycle == Client.field523) {
			Client.field407[var0.rootIndex] = true;
		}

	}
}