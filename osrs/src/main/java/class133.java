import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("fs")
public class class133 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1257;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1260;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1259;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1262;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1261;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	static final class133 field1258;
	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		descriptor = "Lcf;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("ar")
	final int field1265;
	@ObfuscatedName("ab")
	final int field1263;
	@ObfuscatedName("am")
	final int field1264;

	static {
		field1257 = new class133(0, 0, (String)null, 0);
		field1260 = new class133(1, 1, (String)null, 9);
		field1259 = new class133(2, 2, (String)null, 3);
		field1262 = new class133(3, 3, (String)null, 6);
		field1261 = new class133(4, 4, (String)null, 1);
		field1258 = new class133(5, 5, (String)null, 3);
	}

	class133(int var1, int var2, String var3, int var4) {
		this.field1265 = var1;
		this.field1263 = var2;
		this.field1264 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1263;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2025897930"
	)
	int method718() {
		return this.field1264;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)Z",
		garbageValue = "-1116623065"
	)
	static final boolean method721(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = ViewportMouse.ViewportMouse_y + var6;
		if (var7 < var0 && var7 < var1 && var7 < var2) {
			return false;
		} else {
			var7 = ViewportMouse.ViewportMouse_y - var6;
			if (var7 > var0 && var7 > var1 && var7 > var2) {
				return false;
			} else {
				var7 = ViewportMouse.ViewportMouse_x + var6;
				if (var7 < var3 && var7 < var4 && var7 < var5) {
					return false;
				} else {
					var7 = ViewportMouse.ViewportMouse_x - var6;
					return var7 <= var3 || var7 <= var4 || var7 <= var5;
				}
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IZII)V",
		garbageValue = "-605983244"
	)
	public static final void method720(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			PcmPlayer.field179 = var0;
			class306.PcmPlayer_stereo = var1;
			class225.field1884 = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "941581685"
	)
	static int method722(int var0, Script var1, boolean var2) {
		if (var0 == 3200) {
			Interpreter.Interpreter_intStackSize -= 3;
			GraphicsDefaults.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
			return 1;
		} else {
			int var3;
			int var4;
			int var5;
			int var6;
			int var7;
			if (var0 == 3201) {
				Interpreter.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
				ArrayList var8 = new ArrayList();
				var8.add(var3);
				class202.method1006(var8, var4, var5, var6, var7);
				return 1;
			} else if (var0 == 3202) {
				Interpreter.Interpreter_intStackSize -= 2;
				class437.playJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
				return 1;
			} else {
				class92 var12;
				class91 var13;
				String var15;
				if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
					boolean var16;
					if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
						if (var0 == 3211) {
							return 1;
						} else if (var0 == 3216) {
							var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var4 = 0;
							class92 var18 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var3);
							if (var18 != null) {
								var4 = var18 != class92.field889 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 == 3218) {
							var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var4 = 0;
							class91 var10 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var3);
							if (var10 != null) {
								var4 = var10 != class91.field881 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 != 3217 && var0 != 3219) {
							if (var0 == 3220) {
								Interpreter.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								ItemComposition.method1088(var3, var4);
								return 1;
							} else if (var0 == 3221) {
								Interpreter.Interpreter_intStackSize -= 6;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
								var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
								int var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
								ArrayList var9 = new ArrayList();
								var9.add(var3);
								var9.add(var4);
								class202.method1006(var9, var5, var6, var7, var11);
								return 1;
							} else if (var0 == 3222) {
								Interpreter.Interpreter_intStackSize -= 4;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
								class206.someMusicMethod(var3, var4, var5, var6);
								return 1;
							} else {
								return 2;
							}
						} else {
							var12 = class92.field889;
							var13 = class91.field881;
							var16 = true;
							boolean var17 = true;
							if (var0 == 3217) {
								var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								var12 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var7);
								if (var12 == null) {
									throw new RuntimeException(String.format("Unrecognized device option %d", var7));
								}
							}

							if (var0 == 3219) {
								var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								var13 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var7);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized game option %d", var7));
								}
							}

							String var14;
							byte var19;
							if (var13 == class91.field881) {
								switch(var12.field896) {
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
								switch(var13.field886) {
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

							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var19;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6;
							return 1;
						}
					} else {
						var12 = class92.field889;
						var13 = class91.field881;
						var16 = false;
						if (var0 == 3214) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var12 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var6);
							if (var12 == null) {
								throw new RuntimeException(String.format("Unrecognized device option %d", var6));
							}
						}

						if (var0 == 3215) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var13 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized game option %d", var6));
							}
						}

						if (var0 == 3210) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var12 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var6);
							if (var12 == null) {
								var13 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var6);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized client option %d", var6));
								}
							}
						} else if (var0 == 3182) {
							var12 = class92.field890;
						} else if (var0 == 3204) {
							var13 = class91.field882;
						} else if (var0 == 3206) {
							var13 = class91.field885;
						} else if (var0 == 3208) {
							var13 = class91.field884;
						}

						if (var13 == class91.field881) {
							switch(var12.field896) {
							case 1:
								var5 = class91.clientPreferences.getIsUsernameHidden() ? 1 : 0;
								break;
							case 2:
								var5 = class91.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
								break;
							case 3:
								var5 = class91.clientPreferences.method546() ? 1 : 0;
								break;
							case 4:
								var5 = class91.clientPreferences.method548();
								break;
							case 5:
								var5 = FaceNormal.method1334();
								break;
							default:
								var15 = String.format("Unkown device option: %s.", var12.toString());
								throw new RuntimeException(var15);
							}
						} else {
							switch(var13.field886) {
							case 1:
								var5 = class91.clientPreferences.getRoofsHidden() ? 1 : 0;
								break;
							case 2:
								var6 = class91.clientPreferences.getCurrentMusicVolume();
								var5 = Math.round((float)(var6 * 100) / 255.0F);
								break;
							case 3:
								var6 = class91.clientPreferences.getCurrentSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							case 4:
								var6 = class91.clientPreferences.getAreaSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							default:
								var15 = String.format("Unkown game option: %s.", var13.toString());
								throw new RuntimeException(var15);
							}
						}

						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
						return 1;
					}
				} else {
					var12 = class92.field889;
					var13 = class91.field881;
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (var0 == 3212) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var6);
						if (var12 == null) {
							throw new RuntimeException(String.format("Unrecognized device option %d", var6));
						}
					}

					if (var0 == 3213) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var6);
						if (var13 == null) {
							throw new RuntimeException(String.format("Unrecognized game option %d", var6));
						}
					}

					if (var0 == 3209) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = (class92)SequenceDefinition.findEnumerated(class141.method750(), var6);
						if (var12 == null) {
							var13 = (class91)SequenceDefinition.findEnumerated(class95.method505(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized client option %d", var6));
							}
						}
					} else if (var0 == 3181) {
						var12 = class92.field890;
					} else if (var0 == 3203) {
						var13 = class91.field882;
					} else if (var0 == 3205) {
						var13 = class91.field885;
					} else if (var0 == 3207) {
						var13 = class91.field884;
					}

					if (var13 == class91.field881) {
						switch(var12.field896) {
						case 1:
							class91.clientPreferences.setIsUsernameHidden(var5 == 1);
							break;
						case 2:
							class91.clientPreferences.getTitleMusicDisabled(var5 == 1);
							break;
						case 3:
							class91.clientPreferences.method544(var5 == 1);
							break;
						case 4:
							if (var5 < 0) {
								var5 = 0;
							}

							class91.clientPreferences.method547(var5);
							break;
						case 5:
							FontName.method2482(var5);
							break;
						default:
							var15 = String.format("Unkown device option: %s.", var12.toString());
							throw new RuntimeException(var15);
						}
					} else {
						switch(var13.field886) {
						case 1:
							class91.clientPreferences.setRoofsHidden(var5 == 1);
							break;
						case 2:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 255) / 100.0F);
							JagexCache.method921(var6);
							break;
						case 3:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							FloorOverlayDefinition.method1114(var6);
							break;
						case 4:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							class198.method994(var6);
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
}