import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("ky")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("au")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("ae")
	@Export("planes")
	int planes;
	@ObfuscatedName("ao")
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("at")
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("ac")
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("ai")
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljf;I)V",
		garbageValue = "-474032336"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "509257779"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-94"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)[I",
		garbageValue = "1978048199"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.regionEndX * 64 - this.regionStartX * 64), var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)Lmc;",
		garbageValue = "-1281040923"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.regionEndY * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "47"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-6"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ldy;B)V",
		garbageValue = "21"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		NPC.runScript(var0, 500000, 475000);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "-20"
	)
	static int method1553(int var0, Script var1, boolean var2) {
		if (var0 == 3200) {
			SoundCache.Interpreter_intStackSize -= 3;
			class27.queueSoundEffect(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2]);
			return 1;
		} else {
			int var3;
			int var4;
			int var5;
			int var6;
			int var7;
			if (var0 == 3201) {
				SoundCache.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 4];
				ArrayList var8 = new ArrayList();
				var8.add(var3);
				class157.method836(var8, var4, var5, var6, var7);
				return 1;
			} else if (var0 == 3202) {
				SoundCache.Interpreter_intStackSize -= 2;
				Login.playJingle(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
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
							var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var4 = 0;
							class90 var18 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var3);
							if (var18 != null) {
								var4 = var18 != class90.field893 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 == 3218) {
							var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var4 = 0;
							class89 var10 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var3);
							if (var10 != null) {
								var4 = var10 != class89.field884 ? 1 : 0;
							}

							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4;
							return 1;
						} else if (var0 != 3217 && var0 != 3219) {
							if (var0 == 3220) {
								SoundCache.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
								Script.method445(var3, var4);
								return 1;
							} else if (var0 == 3221) {
								SoundCache.Interpreter_intStackSize -= 6;
								var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
								var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 4];
								int var11 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 5];
								ArrayList var9 = new ArrayList();
								var9.add(var3);
								var9.add(var4);
								class157.method836(var9, var5, var6, var7, var11);
								return 1;
							} else if (var0 == 3222) {
								SoundCache.Interpreter_intStackSize -= 4;
								var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
								var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
								var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
								PacketWriter.someMusicMethod(var3, var4, var5, var6);
								return 1;
							} else {
								return 2;
							}
						} else {
							var12 = class90.field893;
							var13 = class89.field884;
							var16 = true;
							boolean var17 = true;
							if (var0 == 3217) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								var12 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var7);
								if (var12 == null) {
									throw new RuntimeException(String.format("Unrecognized device option %d", var7));
								}
							}

							if (var0 == 3219) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								var13 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var7);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized game option %d", var7));
								}
							}

							String var14;
							byte var19;
							if (var13 == class89.field884) {
								switch(var12.field895) {
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

							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var19;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var6;
							return 1;
						}
					} else {
						var12 = class90.field893;
						var13 = class89.field884;
						var16 = false;
						if (var0 == 3214) {
							var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var12 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var6);
							if (var12 == null) {
								throw new RuntimeException(String.format("Unrecognized device option %d", var6));
							}
						}

						if (var0 == 3215) {
							var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var13 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized game option %d", var6));
							}
						}

						if (var0 == 3210) {
							var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var12 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var6);
							if (var12 == null) {
								var13 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var6);
								if (var13 == null) {
									throw new RuntimeException(String.format("Unrecognized client option %d", var6));
								}
							}
						} else if (var0 == 3182) {
							var12 = class90.field890;
						} else if (var0 == 3204) {
							var13 = class89.field882;
						} else if (var0 == 3206) {
							var13 = class89.field883;
						} else if (var0 == 3208) {
							var13 = class89.field880;
						}

						if (var13 == class89.field884) {
							switch(var12.field895) {
							case 1:
								var5 = class449.clientPreferences.getIsUsernameHidden() ? 1 : 0;
								break;
							case 2:
								var5 = class449.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
								break;
							case 3:
								var5 = class449.clientPreferences.method550() ? 1 : 0;
								break;
							case 4:
								var5 = class449.clientPreferences.method552();
								break;
							case 5:
								var5 = PlayerType.method1883();
								break;
							default:
								var15 = String.format("Unkown device option: %s.", var12.toString());
								throw new RuntimeException(var15);
							}
						} else {
							switch(var13.field885) {
							case 1:
								var5 = class449.clientPreferences.getRoofsHidden() ? 1 : 0;
								break;
							case 2:
								var6 = class449.clientPreferences.getCurrentMusicVolume();
								var5 = Math.round((float)(var6 * 100) / 255.0F);
								break;
							case 3:
								var6 = class449.clientPreferences.getCurrentSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							case 4:
								var6 = class449.clientPreferences.getAreaSoundEffectsVolume();
								var5 = Math.round((float)(var6 * 100) / 127.0F);
								break;
							default:
								var15 = String.format("Unkown game option: %s.", var13.toString());
								throw new RuntimeException(var15);
							}
						}

						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var5;
						return 1;
					}
				} else {
					var12 = class90.field893;
					var13 = class89.field884;
					var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					if (var0 == 3212) {
						var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var12 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var6);
						if (var12 == null) {
							throw new RuntimeException(String.format("Unrecognized device option %d", var6));
						}
					}

					if (var0 == 3213) {
						var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var13 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var6);
						if (var13 == null) {
							throw new RuntimeException(String.format("Unrecognized game option %d", var6));
						}
					}

					if (var0 == 3209) {
						var6 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var12 = (class90)KeyHandler.findEnumerated(AbstractWorldMapData.method1517(), var6);
						if (var12 == null) {
							var13 = (class89)KeyHandler.findEnumerated(Varps.method1708(), var6);
							if (var13 == null) {
								throw new RuntimeException(String.format("Unrecognized client option %d", var6));
							}
						}
					} else if (var0 == 3181) {
						var12 = class90.field890;
					} else if (var0 == 3203) {
						var13 = class89.field882;
					} else if (var0 == 3205) {
						var13 = class89.field883;
					} else if (var0 == 3207) {
						var13 = class89.field880;
					}

					if (var13 == class89.field884) {
						switch(var12.field895) {
						case 1:
							class449.clientPreferences.setIsUsernameHidden(var5 == 1);
							break;
						case 2:
							class449.clientPreferences.getTitleMusicDisabled(var5 == 1);
							break;
						case 3:
							class449.clientPreferences.method548(var5 == 1);
							break;
						case 4:
							if (var5 < 0) {
								var5 = 0;
							}

							class449.clientPreferences.method551(var5);
							break;
						case 5:
							class20.method69(var5);
							break;
						default:
							var15 = String.format("Unkown device option: %s.", var12.toString());
							throw new RuntimeException(var15);
						}
					} else {
						switch(var13.field885) {
						case 1:
							class449.clientPreferences.setRoofsHidden(var5 == 1);
							break;
						case 2:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 255) / 100.0F);
							WorldMapEvent.method1588(var6);
							break;
						case 3:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							class385.method2026(var6);
							break;
						case 4:
							var5 = Math.min(Math.max(var5, 0), 100);
							var6 = Math.round((float)(var5 * 127) / 100.0F);
							class14.method44(var6);
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

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1870954980"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.playingJingle) {
			Script.method445(0, 0);
		} else if (var0 != -1 && !class172.method906(var0) && class449.clientPreferences.getCurrentMusicVolume() != 0) {
			ArrayList var1 = new ArrayList();
			var1.add(new MusicSong(class385.archive6, var0, 0, class449.clientPreferences.getCurrentMusicVolume(), false));
			if (Client.playingJingle) {
				class305.field2773.clear();
				class305.field2773.addAll(var1);
				class270.method1537(0, 100, 100, 0);
			} else {
				class53.method291(var1, 0, 100, 100, 0, false);
			}
		}

	}
}