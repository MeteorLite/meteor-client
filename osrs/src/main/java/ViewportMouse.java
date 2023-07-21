import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("aw")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("ay")
	@Export("ViewportMouse_x")
	public static int ViewportMouse_x;
	@ObfuscatedName("ar")
	@Export("ViewportMouse_y")
	public static int ViewportMouse_y;
	@ObfuscatedName("am")
	@Export("ViewportMouse_false0")
	public static boolean ViewportMouse_false0;
	@ObfuscatedName("as")
	static int field2228;
	@ObfuscatedName("aj")
	static int field2227;
	@ObfuscatedName("av")
	static int field2229;
	@ObfuscatedName("ah")
	public static short[] field2226;
	@ObfuscatedName("ax")
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("aa")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Llo;",
		garbageValue = "719974539"
	)
	public static ZoneOperation[] method1320() {
		return new ZoneOperation[]{ZoneOperation.field2588, ZoneOperation.field2589, ZoneOperation.field2585, ZoneOperation.field2582, ZoneOperation.field2586, ZoneOperation.field2581, ZoneOperation.field2580, ZoneOperation.field2590, ZoneOperation.field2587, ZoneOperation.field2583, ZoneOperation.field2584};
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-900202219"
	)
	public static int method1319(int var0) {
		return var0 >>> 12;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Lrj;",
		garbageValue = "1976955779"
	)
	public static class450 method1321() {
		synchronized(class450.field3852) {
			if (class344.field3132 == 0) {
				return new class450();
			} else {
				class450.field3852[--class344.field3132].method2268();
				return class450.field3852[class344.field3132];
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-604436276"
	)
	static int method1322(int var0, Script var1, boolean var2) {
		if (var0 == 3200) {
			Interpreter.Interpreter_intStackSize -= 3;
			class17.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
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
				ObjectComposition.method1031(var8, var4, var5, var6, var7);
				return 1;
			} else if (var0 == 3202) {
				Interpreter.Interpreter_intStackSize -= 2;
				Interpreter.playJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
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
							var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var4 = 0;
							class90 var18 = (class90)ClientPreferences.findEnumerated(class1.method2(), var3);
							if (var18 != null) {
								var4 = var18 != class90.field892 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 == 3218) {
							var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var4 = 0;
							class89 var10 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var3);
							if (var10 != null) {
								var4 = var10 != class89.field882 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 != 3217 && var0 != 3219) {
							if (var0 == 3220) {
								Interpreter.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								RouteStrategy.method1107(var3, var4);
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
								ObjectComposition.method1031(var9, var5, var6, var7, var11);
								return 1;
							} else if (var0 == 3222) {
								Interpreter.Interpreter_intStackSize -= 4;
								var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
								class452.method2293(var3, var4, var5, var6);
								return 1;
							} else {
								return 2;
							}
						} else {
							var12 = class90.field892;
							var13 = class89.field882;
							var16 = true;
							boolean var17 = true;
							if (var0 == 3217) {
								var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								var12 = (class90)ClientPreferences.findEnumerated(class1.method2(), var7);
								if (var12 == null) {
									throw new RuntimeException(String.format("Unrecognized device option %d", var7));
								}
							}

							if (var0 == 3219) {
								var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								var13 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var7);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized game option %d", var7));
								}
							}

							String var14;
							byte var19;
							if (var13 == class89.field882) {
								switch(var12.field894) {
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
								switch(var13.field885) {
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
						var12 = class90.field892;
						var13 = class89.field882;
						var16 = false;
						if (var0 == 3214) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var12 = (class90)ClientPreferences.findEnumerated(class1.method2(), var6);
							if (var12 == null) {
								throw new RuntimeException(String.format("Unrecognized device option %d", var6));
							}
						}

						if (var0 == 3215) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var13 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized game option %d", var6));
							}
						}

						if (var0 == 3210) {
							var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							var12 = (class90)ClientPreferences.findEnumerated(class1.method2(), var6);
							if (var12 == null) {
								var13 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var6);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized client option %d", var6));
								}
							}
						} else if (var0 == 3182) {
							var12 = class90.field888;
						} else if (var0 == 3204) {
							var13 = class89.field880;
						} else if (var0 == 3206) {
							var13 = class89.field879;
						} else if (var0 == 3208) {
							var13 = class89.field881;
						}

						if (var13 == class89.field882) {
							switch(var12.field894) {
							case 1:
								var5 = class150.clientPreferences.getIsUsernameHidden() ? 1 : 0;
								break;
							case 2:
								var5 = class150.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
								break;
							case 3:
								var5 = class150.clientPreferences.method557() ? 1 : 0;
								break;
							case 4:
								var5 = class150.clientPreferences.method559();
								break;
							case 5:
								var5 = JagexCache.method901();
								break;
							default:
								var15 = String.format("Unkown device option: %s.", var12.toString());
								throw new RuntimeException(var15);
							}
						} else {
							switch(var13.field885) {
							case 1:
								var5 = class150.clientPreferences.getRoofsHidden() ? 1 : 0;
								break;
							case 2:
								var6 = class150.clientPreferences.getCurrentMusicVolume();
								var5 = Math.round((float)(var6 * 100) / 255.0F);
								break;
							case 3:
								var6 = class150.clientPreferences.getCurrentSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							case 4:
								var6 = class150.clientPreferences.getAreaSoundEffectsVolume();
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
					var12 = class90.field892;
					var13 = class89.field882;
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					if (var0 == 3212) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = (class90)ClientPreferences.findEnumerated(class1.method2(), var6);
						if (var12 == null) {
							throw new RuntimeException(String.format("Unrecognized device option %d", var6));
						}
					}

					if (var0 == 3213) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var13 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var6);
						if (var13 == null) {
							throw new RuntimeException(String.format("Unrecognized game option %d", var6));
						}
					}

					if (var0 == 3209) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = (class90)ClientPreferences.findEnumerated(class1.method2(), var6);
						if (var12 == null) {
							var13 = (class89)ClientPreferences.findEnumerated(FontName.method2420(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized client option %d", var6));
							}
						}
					} else if (var0 == 3181) {
						var12 = class90.field888;
					} else if (var0 == 3203) {
						var13 = class89.field880;
					} else if (var0 == 3205) {
						var13 = class89.field879;
					} else if (var0 == 3207) {
						var13 = class89.field881;
					}

					if (var13 == class89.field882) {
						switch(var12.field894) {
						case 1:
							class150.clientPreferences.setIsUsernameHidden(var5 == 1);
							break;
						case 2:
							class150.clientPreferences.getTitleMusicDisabled(var5 == 1);
							break;
						case 3:
							class150.clientPreferences.method555(var5 == 1);
							break;
						case 4:
							if (var5 < 0) {
								var5 = 0;
							}

							class150.clientPreferences.method558(var5);
							break;
						case 5:
							UrlRequester.method650(var5);
							break;
						default:
							var15 = String.format("Unkown device option: %s.", var12.toString());
							throw new RuntimeException(var15);
						}
					} else {
						switch(var13.field885) {
						case 1:
							class150.clientPreferences.setRoofsHidden(var5 == 1);
							break;
						case 2:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 255) / 100.0F);
							StudioGame.method1839(var6);
							break;
						case 3:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							ClanMate.method2184(var6);
							break;
						case 4:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							Interpreter.method429(var6);
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
