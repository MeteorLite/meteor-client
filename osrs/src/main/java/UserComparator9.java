import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
	@ObfuscatedName("s")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;
	@ObfuscatedName("cc")
	static boolean field1387;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lnr;Lnr;I)I",
		garbageValue = "2019558836"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "53690591"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (Frames.World_request == null) {
				Frames.World_request = Messages.urlRequester.request(new URL(WorldMapSection1.field2879));
			} else if (Frames.World_request.isDone()) {
				byte[] var0 = Frames.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				World.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = World.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				PendingSpawn.sortWorlds(World.World_worlds, 0, World.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				Frames.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			Frames.World_request = null;
		}

		return false;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "106"
	)
	static final boolean method2776(int var0, int var1) {
		ObjectComposition var2 = PlayerComposition.getObjectDefinition(var0);
		if (var1 == 11) {
			var1 = 10;
		}

		if (var1 >= 5 && var1 <= 8) {
			var1 = 4;
		}

		return var2.method3787(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZB)I",
		garbageValue = "-1"
	)
	static int method2772(int var0, Script var1, boolean var2) {
		if (var0 == 3200) {
			Interpreter.Interpreter_intStackSize -= 3;
			class67.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == 3201) {
			class9.playSong(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == 3202) {
			Interpreter.Interpreter_intStackSize -= 2;
			class161.method3458(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			class83 var3;
			class82 var4;
			int var5;
			int var6;
			String var7;
			if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
				if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
					return var0 == 3211 ? 1 : 2;
				} else {
					var3 = class83.field1078;
					var4 = class82.field1062;
					boolean var8 = false;
					if (var0 == 3214) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var3 = (class83)Varps.findEnumerated(ObjectSound.method1849(), var6);
						if (var3 == null) {
							throw new RuntimeException(String.format("Unrecognized device option %d", var6));
						}
					}

					if (var0 == 3215) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var4 = (class82)Varps.findEnumerated(Renderable.method4463(), var6);
						if (var4 == null) {
							throw new RuntimeException(String.format("Unrecognized game option %d", var6));
						}
					}

					if (var0 == 3210) {
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var3 = (class83)Varps.findEnumerated(ObjectSound.method1849(), var6);
						if (var3 == null) {
							var4 = (class82)Varps.findEnumerated(Renderable.method4463(), var6);
							if (var4 == null) {
								throw new RuntimeException(String.format("Unrecognized client option %d", var6));
							}
						}
					} else if (var0 == 3182) {
						var3 = class83.field1077;
					} else if (var0 == 3204) {
						var4 = class82.field1069;
					} else if (var0 == 3206) {
						var4 = class82.field1064;
					} else if (var0 == 3208) {
						var4 = class82.field1065;
					}

					if (var4 == class82.field1062) {
						switch(var3.field1079) {
						case 1:
							var5 = Player.clientPreferences.method2397() ? 1 : 0;
							break;
						case 2:
							var5 = Player.clientPreferences.method2393() ? 1 : 0;
							break;
						case 3:
							var5 = Player.clientPreferences.method2396() ? 1 : 0;
							break;
						case 4:
							var5 = Player.clientPreferences.method2398();
							break;
						case 5:
							var5 = UserComparator5.method2751();
							break;
						default:
							var7 = String.format("Unkown device option: %s.", var3.toString());
							throw new RuntimeException(var7);
						}
					} else {
						switch(var4.field1066) {
						case 1:
							var5 = Player.clientPreferences.method2452() ? 1 : 0;
							break;
						case 2:
							var6 = Player.clientPreferences.method2402();
							var5 = Math.round((float)(var6 * 100) / 255.0F);
							break;
						case 3:
							var6 = Player.clientPreferences.method2385();
							var5 = Math.round((float)(var6 * 100) / 127.0F);
							break;
						case 4:
							var6 = Player.clientPreferences.method2474();
							var5 = Math.round((float)(var6 * 100) / 127.0F);
							break;
						default:
							var7 = String.format("Unkown game option: %s.", var4.toString());
							throw new RuntimeException(var7);
						}
					}

					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
					return 1;
				}
			} else {
				var3 = class83.field1078;
				var4 = class82.field1062;
				var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var0 == 3212) {
					var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var3 = (class83)Varps.findEnumerated(ObjectSound.method1849(), var6);
					if (var3 == null) {
						throw new RuntimeException(String.format("Unrecognized device option %d", var6));
					}
				}

				if (var0 == 3213) {
					var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var4 = (class82)Varps.findEnumerated(Renderable.method4463(), var6);
					if (var4 == null) {
						throw new RuntimeException(String.format("Unrecognized game option %d", var6));
					}
				}

				if (var0 == 3209) {
					var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					var3 = (class83)Varps.findEnumerated(ObjectSound.method1849(), var6);
					if (var3 == null) {
						var4 = (class82)Varps.findEnumerated(Renderable.method4463(), var6);
						if (var4 == null) {
							throw new RuntimeException(String.format("Unrecognized client option %d", var6));
						}
					}
				} else if (var0 == 3181) {
					var3 = class83.field1077;
				} else if (var0 == 3203) {
					var4 = class82.field1069;
				} else if (var0 == 3205) {
					var4 = class82.field1064;
				} else if (var0 == 3207) {
					var4 = class82.field1065;
				}

				if (var4 == class82.field1062) {
					switch(var3.field1079) {
					case 1:
						Player.clientPreferences.method2390(var5 == 1);
						break;
					case 2:
						Player.clientPreferences.method2392(var5 == 1);
						break;
					case 3:
						Player.clientPreferences.method2394(var5 == 1);
						break;
					case 4:
						if (var5 < 0) {
							var5 = 0;
						}

						Player.clientPreferences.method2451(var5);
						break;
					case 5:
						GrandExchangeOfferOwnWorldComparator.method1174(var5);
						break;
					default:
						var7 = String.format("Unkown device option: %s.", var3.toString());
						throw new RuntimeException(var7);
					}
				} else {
					switch(var4.field1066) {
					case 1:
						Player.clientPreferences.method2412(var5 == 1);
						break;
					case 2:
						var5 = Math.min(Math.max(var5, 0), 100);
						var6 = Math.round((float)(var5 * 255) / 100.0F);
						NPC.method2511(var6);
						break;
					case 3:
						var5 = Math.min(Math.max(var5, 0), 100);
						var6 = Math.round((float)(var5 * 127) / 100.0F);
						class150.method3286(var6);
						break;
					case 4:
						var5 = Math.min(Math.max(var5, 0), 100);
						var6 = Math.round((float)(var5 * 127) / 100.0F);
						class264.method5345(var6);
						break;
					default:
						var7 = String.format("Unkown game option: %s.", var4.toString());
						throw new RuntimeException(var7);
					}
				}

				return 1;
			}
		}
	}
}
