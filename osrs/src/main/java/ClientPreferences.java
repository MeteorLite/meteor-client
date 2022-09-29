import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1460817999
	)
	@Export("ClientPreferences_optionCount")
	static int ClientPreferences_optionCount;
	@ObfuscatedName("f")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("n")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("k")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("w")
	@Export("displayFps")
	boolean displayFps;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -450320321
	)
	int field1234;
	@ObfuscatedName("q")
	@Export("brightness")
	double brightness;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1663068863
	)
	@Export("musicVolume")
	int musicVolume;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1084788481
	)
	@Export("soundEffectsVolume")
	int soundEffectsVolume;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -14495649
	)
	@Export("areaSoundEffectsVolume")
	int areaSoundEffectsVolume;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1273309993
	)
	int field1243;
	@ObfuscatedName("h")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1030816249
	)
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("u")
	@Export("parameters")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 10;
	}

	ClientPreferences() {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1243 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		this.method2386(true);
	}

	@ObfuscatedSignature(
		descriptor = "(Lqq;)V"
	)
	ClientPreferences(Buffer var1) {
		this.hideUsername = false;
		this.displayFps = false;
		this.brightness = 0.8D;
		this.musicVolume = 127;
		this.soundEffectsVolume = 127;
		this.areaSoundEffectsVolume = 127;
		this.field1243 = -1;
		this.rememberedUsername = null;
		this.windowMode = 1;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}

				if (var2 > 6) {
					this.brightness = (double)var1.readUnsignedByte() / 100.0D;
					this.musicVolume = var1.readUnsignedByte();
					this.soundEffectsVolume = var1.readUnsignedByte();
					this.areaSoundEffectsVolume = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field1243 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.displayFps = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field1234 = var1.readInt();
				}
			} else {
				this.method2386(true);
			}
		} else {
			this.method2386(true);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1182413250"
	)
	void method2386(boolean var1) {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)Lqq;",
		garbageValue = "1274404202"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(100);
		var1.writeByte(ClientPreferences_optionCount);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		var1.writeByte((int)(100.0D * this.brightness));
		var1.writeByte(this.musicVolume);
		var1.writeByte(this.soundEffectsVolume);
		var1.writeByte(this.areaSoundEffectsVolume);
		var1.writeByte(this.field1243);
		var1.writeByte(this.displayFps ? 1 : 0);
		var1.writeInt(this.field1234);
		return var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "66"
	)
	void method2412(boolean var1) {
		this.roofsHidden = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1676530066"
	)
	boolean method2452() {
		return this.roofsHidden;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-48"
	)
	void method2390(boolean var1) {
		this.hideUsername = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1474436266"
	)
	boolean method2397() {
		return this.hideUsername;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "1"
	)
	void method2392(boolean var1) {
		this.titleMusicDisabled = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-64"
	)
	boolean method2393() {
		return this.titleMusicDisabled;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "50"
	)
	void method2394(boolean var1) {
		this.displayFps = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "63"
	)
	void method2395() {
		this.method2394(!this.displayFps);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-869794111"
	)
	boolean method2396() {
		return this.displayFps;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2141560552"
	)
	void method2451(int var1) {
		this.field1234 = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-487908407"
	)
	int method2398() {
		return this.field1234;
	}

	@ObfuscatedName("d")
	void method2399(double var1) {
		this.brightness = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(I)D",
		garbageValue = "-1993581063"
	)
	double method2387() {
		return this.brightness;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "587626375"
	)
	void method2449(int var1) {
		this.musicVolume = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-50"
	)
	int method2402() {
		return this.musicVolume;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1966171619"
	)
	@Export("updateSoundEffectVolume")
	void updateSoundEffectVolume(int var1) {
		this.soundEffectsVolume = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1960607889"
	)
	int method2385() {
		return this.soundEffectsVolume;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1396212893"
	)
	void method2405(int var1) {
		this.areaSoundEffectsVolume = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1834648228"
	)
	int method2474() {
		return this.areaSoundEffectsVolume;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1779588329"
	)
	void method2406(String var1) {
		this.rememberedUsername = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(S)Ljava/lang/String;",
		garbageValue = "175"
	)
	String method2407() {
		return this.rememberedUsername;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "41"
	)
	void method2408(int var1) {
		this.field1243 = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2041475317"
	)
	int method2409() {
		return this.field1243;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-37"
	)
	void method2410(int var1) {
		this.windowMode = var1;
		GrandExchangeOfferAgeComparator.savePreferences();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1832389332"
	)
	int method2411() {
		return this.windowMode;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "72159241"
	)
	static void method2487() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "32335824"
	)
	static final void method2400(String var0) {
		StringBuilder var10000 = new StringBuilder();
		Object var10001 = null;
		var10000 = var10000.append("Please remove ").append(var0);
		var10001 = null;
		String var1 = var10000.append(" from your ignore list first").toString();
		class65.addGameMessage(30, "", var1);
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		descriptor = "(Lce;II)V",
		garbageValue = "1107775722"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		SequenceDefinition var2;
		int var3;
		int var4;
		int var11;
		if (var0.field1183 >= Client.cycle) {
			class125.method2968(var0);
		} else if (var0.field1136 >= Client.cycle) {
			class10.method108(var0);
		} else {
			var0.movementSequence = var0.idleSequence;
			if (var0.pathLength == 0) {
				var0.field1201 = 0;
			} else {
				label700: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var2 = class4.SequenceDefinition_get(var0.sequence);
						if (var0.field1202 > 0 && var2.field2217 == 0) {
							++var0.field1201;
							break label700;
						}

						if (var0.field1202 <= 0 && var2.field2218 == 0) {
							++var0.field1201;
							break label700;
						}
					}

					var11 = var0.x;
					var3 = var0.y;
					var4 = var0.field1131 * -360448000 + var0.pathX[var0.pathLength - 1] * 128;
					int var5 = var0.pathY[var0.pathLength - 1] * 128 + var0.field1131 * -360448000;
					if (var11 < var4) {
						if (var3 < var5) {
							var0.orientation = 1280;
						} else if (var3 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var11 > var4) {
						if (var3 < var5) {
							var0.orientation = 768;
						} else if (var3 > var5) {
							var0.orientation = 256;
						} else {
							var0.orientation = 512;
						}
					} else if (var3 < var5) {
						var0.orientation = 1024;
					} else if (var3 > var5) {
						var0.orientation = 0;
					}

					class193 var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
						int var7 = var0.orientation - var0.rotation & 2047;
						if (var7 > 1024) {
							var7 -= 2048;
						}

						int var8 = var0.walkBackSequence;
						if (var7 >= -256 && var7 <= 256) {
							var8 = var0.walkSequence;
						} else if (var7 >= 256 && var7 < 768) {
							var8 = var0.walkRightSequence;
						} else if (var7 >= -768 && var7 <= -256) {
							var8 = var0.walkLeftSequence;
						}

						if (var8 == -1) {
							var8 = var0.walkSequence;
						}

						var0.movementSequence = var8;
						int var9 = 4;
						boolean var10 = true;
						if (var0 instanceof NPC) {
							var10 = ((NPC)var0).definition.isClickable;
						}

						if (var10) {
							if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field1196 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field1201 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1201;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field1201 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1201;
							}
						}

						if (var6 == class193.field2247) {
							var9 <<= 1;
						} else if (var6 == class193.field2244) {
							var9 >>= 1;
						}

						if (var9 >= 8) {
							if (var0.walkSequence == var0.movementSequence && var0.runSequence != -1) {
								var0.movementSequence = var0.runSequence;
							} else if (var0.movementSequence == var0.walkBackSequence && var0.field1189 != -1) {
								var0.movementSequence = var0.field1189;
							} else if (var0.movementSequence == var0.walkLeftSequence && var0.field1193 != -1) {
								var0.movementSequence = var0.field1193;
							} else if (var0.walkRightSequence == var0.movementSequence && var0.field1143 != -1) {
								var0.movementSequence = var0.field1143;
							}
						} else if (var9 <= 1) {
							if (var0.movementSequence == var0.walkSequence && var0.field1144 != -1) {
								var0.movementSequence = var0.field1144;
							} else if (var0.movementSequence == var0.walkBackSequence && var0.field1179 != -1) {
								var0.movementSequence = var0.field1179;
							} else if (var0.walkLeftSequence == var0.movementSequence && var0.field1182 != -1) {
								var0.movementSequence = var0.field1182;
							} else if (var0.movementSequence == var0.walkRightSequence && var0.field1171 != -1) {
								var0.movementSequence = var0.field1171;
							}
						}

						if (var4 != var11 || var5 != var3) {
							if (var11 < var4) {
								var0.x += var9;
								if (var0.x > var4) {
									var0.x = var4;
								}
							} else if (var11 > var4) {
								var0.x -= var9;
								if (var0.x < var4) {
									var0.x = var4;
								}
							}

							if (var3 < var5) {
								var0.y += var9;
								if (var0.y > var5) {
									var0.y = var5;
								}
							} else if (var3 > var5) {
								var0.y -= var9;
								if (var0.y < var5) {
									var0.y = var5;
								}
							}
						}

						if (var4 == var0.x && var5 == var0.y) {
							--var0.pathLength;
							if (var0.field1202 > 0) {
								--var0.field1202;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field1202 > 0) {
							--var0.field1202;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field1183 = 0;
			var0.field1136 = 0;
			var0.x = var0.field1131 * -360448000 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.field1131 * -360448000;
			var0.method2331();
		}

		if (class67.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = -1;
			var0.field1183 = 0;
			var0.field1136 = 0;
			var0.x = var0.pathX[0] * 128 + var0.field1131 * -360448000;
			var0.y = var0.field1131 * -360448000 + var0.pathY[0] * 128;
			var0.method2331();
		}

		if (var0.field1196 != 0) {
			if (var0.targetIndex != -1) {
				Object var13 = null;
				if (var0.targetIndex < 32768) {
					var13 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var13 = Client.players[var0.targetIndex - 32768];
				}

				if (var13 != null) {
					var3 = var0.x - ((Actor)var13).x;
					var4 = var0.y - ((Actor)var13).y;
					if (var3 != 0 || var4 != 0) {
						var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field1163 != -1 && (var0.pathLength == 0 || var0.field1201 > 0)) {
				var0.orientation = var0.field1163;
				var0.field1163 = -1;
			}

			var11 = var0.orientation - var0.rotation & 2047;
			if (var11 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var11 != 0) {
				++var0.field1195;
				boolean var14;
				if (var11 > 1024) {
					var0.rotation -= var0.field1141 ? var11 : var0.field1196;
					var14 = true;
					if (var11 < var0.field1196 || var11 > 2048 - var0.field1196) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (!var0.field1141 && var0.movementSequence == var0.idleSequence && (var0.field1195 > 25 || var14)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field1141 ? var11 : var0.field1196;
					var14 = true;
					if (var11 < var0.field1196 || var11 > 2048 - var0.field1196) {
						var0.rotation = var0.orientation;
						var14 = false;
					}

					if (!var0.field1141 && var0.idleSequence == var0.movementSequence && (var0.field1195 > 25 || var14)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
				var0.field1141 = false;
			} else {
				var0.field1195 = 0;
			}
		}

		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var2 = class4.SequenceDefinition_get(var0.movementSequence);
			if (var2 != null) {
				if (!var2.isCachedModelIdSet() && var2.frameIds != null) {
					++var0.movementFrameCycle;
					if (var0.movementFrame < var2.frameIds.length && var0.movementFrameCycle > var2.frameLengths[var0.movementFrame]) {
						var0.movementFrameCycle = 1;
						++var0.movementFrame;
						WorldMapLabelSize.method4684(var2, var0.movementFrame, var0.x, var0.y);
					}

					if (var0.movementFrame >= var2.frameIds.length) {
						if (var2.frameCount > 0) {
							var0.movementFrame -= var2.frameCount;
							if (var2.field2194) {
								++var0.field1168;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var2.frameIds.length || var2.field2194 && var0.field1168 >= var2.field2215) {
								var0.movementFrameCycle = 0;
								var0.movementFrame = 0;
								var0.field1168 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						WorldMapLabelSize.method4684(var2, var0.movementFrame, var0.x, var0.y);
					}
				} else if (var2.isCachedModelIdSet()) {
					++var0.movementFrame;
					var3 = var2.method3950();
					if (var0.movementFrame < var3) {
						Actor.method2348(var2, var0.movementFrame, var0.x, var0.y);
					} else {
						if (var2.frameCount > 0) {
							var0.movementFrame -= var2.frameCount;
							if (var2.field2194) {
								++var0.field1168;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var3 || var2.field2194 && var0.field1168 >= var2.field2215) {
								var0.movementFrame = 0;
								var0.movementFrameCycle = 0;
								var0.field1168 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						Actor.method2348(var2, var0.movementFrame, var0.x, var0.y);
					}
				} else {
					var0.movementSequence = -1;
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		if (var0.spotAnimation != -1 && Client.cycle >= var0.field1147) {
			if (var0.spotAnimationFrame < 0) {
				var0.spotAnimationFrame = 0;
			}

			var11 = class308.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
			if (var11 != -1) {
				SequenceDefinition var12 = class4.SequenceDefinition_get(var11);
				if (var12 != null && var12.frameIds != null && !var12.isCachedModelIdSet()) {
					++var0.field1176;
					if (var0.spotAnimationFrame < var12.frameIds.length && var0.field1176 > var12.frameLengths[var0.spotAnimationFrame]) {
						var0.field1176 = 1;
						++var0.spotAnimationFrame;
						WorldMapLabelSize.method4684(var12, var0.spotAnimationFrame, var0.x, var0.y);
					}

					if (var0.spotAnimationFrame >= var12.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var12.frameIds.length)) {
						var0.spotAnimation = -1;
					}
				} else if (var12.isCachedModelIdSet()) {
					++var0.spotAnimationFrame;
					var4 = var12.method3950();
					if (var0.spotAnimationFrame < var4) {
						Actor.method2348(var12, var0.spotAnimationFrame, var0.x, var0.y);
					} else if (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var4) {
						var0.spotAnimation = -1;
					}
				} else {
					var0.spotAnimation = -1;
				}
			} else {
				var0.spotAnimation = -1;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var2 = class4.SequenceDefinition_get(var0.sequence);
			if (var2.field2217 == 1 && var0.field1202 > 0 && var0.field1183 <= Client.cycle && var0.field1136 < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var2 = class4.SequenceDefinition_get(var0.sequence);
			if (var2 == null) {
				var0.sequence = -1;
			} else if (!var2.isCachedModelIdSet() && var2.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var2.frameIds.length && var0.sequenceFrameCycle > var2.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					WorldMapLabelSize.method4684(var2, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var2.frameIds.length) {
					var0.sequenceFrame -= var2.frameCount;
					++var0.field1173;
					if (var0.field1173 >= var2.field2215) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var2.frameIds.length) {
						WorldMapLabelSize.method4684(var2, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var2.field2211;
			} else if (var2.isCachedModelIdSet()) {
				++var0.sequenceFrame;
				var3 = var2.method3950();
				if (var0.sequenceFrame < var3) {
					Actor.method2348(var2, var0.sequenceFrame, var0.x, var0.y);
				} else {
					var0.sequenceFrame -= var2.frameCount;
					++var0.field1173;
					if (var0.field1173 >= var2.field2215) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var3) {
						Actor.method2348(var2, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "110"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		ArchiveLoader.method2212();
		if (Client.renderSelf) {
			class67.addPlayerToScene(class67.localPlayer, false);
		}

		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class67.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		AttackOption.addNpcsToScene(true);
		Client.method1726();
		AttackOption.addNpcsToScene(false);

		int var6;
		for (Projectile var4 = (Projectile)Client.projectiles.last(); var4 != null; var4 = (Projectile)Client.projectiles.previous()) {
			if (var4.plane == Tiles.Client_plane && Client.cycle <= var4.cycleEnd) {
				if (Client.cycle >= var4.cycleStart) {
					if (var4.targetIndex > 0) {
						NPC var33 = Client.npcs[var4.targetIndex - 1];
						if (var33 != null && var33.x >= 0 && var33.x < 13312 && var33.y >= 0 && var33.y < 13312) {
							var4.setDestination(var33.x, var33.y, class120.getTileHeight(var33.x, var33.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					if (var4.targetIndex < 0) {
						var6 = -var4.targetIndex - 1;
						Player var35;
						if (var6 == Client.localPlayerIndex) {
							var35 = class67.localPlayer;
						} else {
							var35 = Client.players[var6];
						}

						if (var35 != null && var35.x >= 0 && var35.x < 13312 && var35.y >= 0 && var35.y < 13312) {
							var4.setDestination(var35.x, var35.y, class120.getTileHeight(var35.x, var35.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					var4.advance(Client.field743);
					MusicPatchNode.scene.drawEntity(Tiles.Client_plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1L, false);
				}
			} else {
				var4.remove();
			}
		}

		class146.method3239();
		class346.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var30 = Client.camAngleX;
		if (Client.field589 / 256 > var30) {
			var30 = Client.field589 / 256;
		}

		if (Client.field755[4] && Client.field757[4] + 128 > var30) {
			var30 = Client.field757[4] + 128;
		}

		int var5 = Client.camAngleY & 2047;
		class307.method5929(class147.oculusOrbFocalPointX, class120.field1505, Language.oculusOrbFocalPointY, var30, var5, MusicPatchNode2.method5401(var30), var3);
		if (!Client.isCameraLocked) {
			var6 = ItemContainer.method2233();
		} else {
			var6 = class156.method3395();
		}

		int var7 = TaskHandler.cameraX;
		int var8 = SecureRandomFuture.cameraY;
		int var9 = ApproximateRouteStrategy.cameraZ;
		int var10 = class163.cameraPitch;
		int var11 = class10.cameraYaw;

		int var12;
		int var13;
		for (var12 = 0; var12 < 5; ++var12) {
			if (Client.field755[var12]) {
				var13 = (int)(Math.random() * (double)(Client.field575[var12] * 2 + 1) - (double)Client.field575[var12] + Math.sin((double)Client.field759[var12] * ((double)Client.field758[var12] / 100.0D)) * (double)Client.field757[var12]);
				if (var12 == 0) {
					TaskHandler.cameraX += var13;
				}

				if (var12 == 1) {
					SecureRandomFuture.cameraY += var13;
				}

				if (var12 == 2) {
					ApproximateRouteStrategy.cameraZ += var13;
				}

				if (var12 == 3) {
					class10.cameraYaw = var13 + class10.cameraYaw & 2047;
				}

				if (var12 == 4) {
					class163.cameraPitch += var13;
					if (class163.cameraPitch < 128) {
						class163.cameraPitch = 128;
					}

					if (class163.cameraPitch > 383) {
						class163.cameraPitch = 383;
					}
				}
			}
		}

		var12 = MouseHandler.MouseHandler_x;
		var13 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var12 = MouseHandler.MouseHandler_lastPressedX;
			var13 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var12 >= var0 && var12 < var0 + var2 && var13 >= var1 && var13 < var3 + var1) {
			Canvas.method379(var12 - var0, var13 - var1);
		} else {
			class166.method3479();
		}

		class14.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		class14.playPcmPlayers();
		int var14 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		MusicPatchNode.scene.draw(TaskHandler.cameraX, SecureRandomFuture.cameraY, ApproximateRouteStrategy.cameraZ, class163.cameraPitch, class10.cameraYaw, var6);
		Rasterizer3D.Rasterizer3D_zoom = var14;
		class14.playPcmPlayers();
		MusicPatchNode.scene.clearTempGameObjects();
		Client.overheadTextCount = 0;
		boolean var15 = false;
		int var16 = -1;
		int var17 = -1;
		int var18 = Players.Players_count;
		int[] var19 = Players.Players_indices;

		int var20;
		for (var20 = 0; var20 < var18 + Client.npcCount; ++var20) {
			Object var32;
			if (var20 < var18) {
				var32 = Client.players[var19[var20]];
				if (var19[var20] == Client.combatTargetPlayerIndex) {
					var15 = true;
					var16 = var20;
					continue;
				}

				if (var32 == class67.localPlayer) {
					var17 = var20;
					continue;
				}
			} else {
				var32 = Client.npcs[Client.npcIndices[var20 - var18]];
			}

			class19.drawActor2d((Actor)var32, var20, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var17 != -1) {
			class19.drawActor2d(class67.localPlayer, var17, var0, var1, var2, var3);
		}

		if (var15) {
			class19.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var16, var0, var1, var2, var3);
		}

		for (var20 = 0; var20 < Client.overheadTextCount; ++var20) {
			int var21 = Client.overheadTextXs[var20];
			int var22 = Client.overheadTextYs[var20];
			int var23 = Client.overheadTextXOffsets[var20];
			int var24 = Client.overheadTextAscents[var20];
			boolean var25 = true;

			while (var25) {
				var25 = false;

				for (int var31 = 0; var31 < var20; ++var31) {
					if (var22 + 2 > Client.overheadTextYs[var31] - Client.overheadTextAscents[var31] && var22 - var24 < Client.overheadTextYs[var31] + 2 && var21 - var23 < Client.overheadTextXOffsets[var31] + Client.overheadTextXs[var31] && var23 + var21 > Client.overheadTextXs[var31] - Client.overheadTextXOffsets[var31] && Client.overheadTextYs[var31] - Client.overheadTextAscents[var31] < var22) {
						var22 = Client.overheadTextYs[var31] - Client.overheadTextAscents[var31];
						var25 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var20];
			Client.viewportTempY = Client.overheadTextYs[var20] = var22;
			String var26 = Client.overheadText[var20];
			if (Client.chatEffects == 0) {
				int var27 = 16776960;
				if (Client.overheadTextColors[var20] < 6) {
					var27 = Client.field724[Client.overheadTextColors[var20]];
				}

				if (Client.overheadTextColors[var20] == 6) {
					var27 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var20] == 7) {
					var27 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var20] == 8) {
					var27 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var28;
				if (Client.overheadTextColors[var20] == 9) {
					var28 = 150 - Client.overheadTextCyclesRemaining[var20];
					if (var28 < 50) {
						var27 = var28 * 1280 + 16711680;
					} else if (var28 < 100) {
						var27 = 16776960 - (var28 - 50) * 327680;
					} else if (var28 < 150) {
						var27 = (var28 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var20] == 10) {
					var28 = 150 - Client.overheadTextCyclesRemaining[var20];
					if (var28 < 50) {
						var27 = var28 * 5 + 16711680;
					} else if (var28 < 100) {
						var27 = 16711935 - (var28 - 50) * 327680;
					} else if (var28 < 150) {
						var27 = (var28 - 100) * 327680 + 255 - (var28 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var20] == 11) {
					var28 = 150 - Client.overheadTextCyclesRemaining[var20];
					if (var28 < 50) {
						var27 = 16777215 - var28 * 327685;
					} else if (var28 < 100) {
						var27 = (var28 - 50) * 327685 + 65280;
					} else if (var28 < 150) {
						var27 = 16777215 - (var28 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var20] == 0) {
					class29.fontBold12.drawCentered(var26, var0 + Client.viewportTempX, Client.viewportTempY + var1, var27, 0);
				}

				if (Client.overheadTextEffects[var20] == 1) {
					class29.fontBold12.drawCenteredWave(var26, var0 + Client.viewportTempX, Client.viewportTempY + var1, var27, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var20] == 2) {
					class29.fontBold12.drawCenteredWave2(var26, var0 + Client.viewportTempX, Client.viewportTempY + var1, var27, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var20] == 3) {
					class29.fontBold12.drawCenteredShake(var26, var0 + Client.viewportTempX, Client.viewportTempY + var1, var27, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var20]);
				}

				if (Client.overheadTextEffects[var20] == 4) {
					var28 = (150 - Client.overheadTextCyclesRemaining[var20]) * (class29.fontBold12.stringWidth(var26) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					class29.fontBold12.draw(var26, var0 + Client.viewportTempX + 50 - var28, Client.viewportTempY + var1, var27, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var20] == 5) {
					var28 = 150 - Client.overheadTextCyclesRemaining[var20];
					int var29 = 0;
					if (var28 < 25) {
						var29 = var28 - 25;
					} else if (var28 > 125) {
						var29 = var28 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class29.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					class29.fontBold12.drawCentered(var26, var0 + Client.viewportTempX, var29 + Client.viewportTempY + var1, var27, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				class29.fontBold12.drawCentered(var26, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		if (Client.hintArrowType == 2) {
			class82.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - class128.baseX * 64 << 7), (Client.hintArrowY - WorldMapData_1.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				class135.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field743);
		Client.field617 = 0;
		int var34 = class128.baseX * 64 + (class67.localPlayer.x >> 7);
		var16 = WorldMapData_1.baseY * 64 + (class67.localPlayer.y >> 7);
		if (var34 >= 3053 && var34 <= 3156 && var16 >= 3056 && var16 <= 3136) {
			Client.field617 = 1;
		}

		if (var34 >= 3072 && var34 <= 3118 && var16 >= 9492 && var16 <= 9535) {
			Client.field617 = 1;
		}

		if (Client.field617 == 1 && var34 >= 3139 && var34 <= 3199 && var16 >= 3008 && var16 <= 3062) {
			Client.field617 = 0;
		}

		TaskHandler.cameraX = var7;
		SecureRandomFuture.cameraY = var8;
		ApproximateRouteStrategy.cameraZ = var9;
		class163.cameraPitch = var10;
		class10.cameraYaw = var11;
		if (Client.isLoading && TaskHandler.method3433(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class146.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
