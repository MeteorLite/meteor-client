import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class37 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lml;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("e")
	@Export("userHomeDirectory")
	public static String userHomeDirectory;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-21"
	)
	public static int method712(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILbz;ZI)I",
		garbageValue = "-1657073365"
	)
	static int method711(int var0, Script var1, boolean var2) {
		if (var0 == 3800) {
			if (class121.guestClanSettings != null) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 1;
				class10.field56 = class121.guestClanSettings;
			} else {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3801) {
				var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				if (Client.currentClanSettings[var3] != null) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 1;
					class10.field56 = Client.currentClanSettings[var3];
				} else {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3802) {
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = class10.field56.name;
				return 1;
			} else if (var0 == 3803) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.allowGuests ? 1 : 0;
				return 1;
			} else if (var0 == 3804) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1670;
				return 1;
			} else if (var0 == 3805) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1660;
				return 1;
			} else if (var0 == 3806) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1680;
				return 1;
			} else if (var0 == 3807) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1671;
				return 1;
			} else if (var0 == 3809) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.memberCount;
				return 1;
			} else if (var0 == 3810) {
				var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = class10.field56.memberNames[var3];
				return 1;
			} else if (var0 == 3811) {
				var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.memberRanks[var3];
				return 1;
			} else if (var0 == 3812) {
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.bannedMemberCount;
				return 1;
			} else if (var0 == 3813) {
				var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = class10.field56.bannedMemberNames[var3];
				return 1;
			} else {
				int var5;
				int var6;
				if (var0 == 3814) {
					class379.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.method3113(var3, var6, var5);
					return 1;
				} else if (var0 == 3815) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.currentOwner;
					return 1;
				} else if (var0 == 3816) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1673;
					return 1;
				} else if (var0 == 3817) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.method3076(Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize]);
					return 1;
				} else if (var0 == 3818) {
					Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1] = class10.field56.getSortedMembers()[Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1]];
					return 1;
				} else if (var0 == 3819) {
					class379.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
					class197.method3914(var6, var3);
					return 1;
				} else if (var0 == 3820) {
					var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1677[var3];
					return 1;
				} else {
					if (var0 == 3821) {
						class379.Interpreter_intStackSize -= 3;
						var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1] == 1;
						var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
						class355.method6770(var5, var3, var4);
					}

					if (var0 == 3822) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class10.field56.field1678[var3] ? 1 : 0;
						return 1;
					} else if (var0 == 3850) {
						if (class198.guestClanChannel != null) {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 1;
							FontName.field4758 = class198.guestClanChannel;
						} else {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3851) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						if (Client.currentClanChannels[var3] != null) {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 1;
							FontName.field4758 = Client.currentClanChannels[var3];
							UrlRequester.field1389 = var3;
						} else {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3852) {
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = FontName.field4758.name;
						return 1;
					} else if (var0 == 3853) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = FontName.field4758.field1731;
						return 1;
					} else if (var0 == 3854) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = FontName.field4758.field1725;
						return 1;
					} else if (var0 == 3855) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = FontName.field4758.method3215();
						return 1;
					} else if (var0 == 3856) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = ((ClanChannelMember)FontName.field4758.members.get(var3)).username.getName();
						return 1;
					} else if (var0 == 3857) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = ((ClanChannelMember)FontName.field4758.members.get(var3)).rank;
						return 1;
					} else if (var0 == 3858) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = ((ClanChannelMember)FontName.field4758.members.get(var3)).world;
						return 1;
					} else if (var0 == 3859) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						class408.method7728(UrlRequester.field1389, var3);
						return 1;
					} else if (var0 == 3860) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = FontName.field4758.method3208(Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize]);
						return 1;
					} else if (var0 == 3861) {
						Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1] = FontName.field4758.getSortedMembers()[Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1]];
						return 1;
					} else if (var0 == 3890) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class157.field1745 != null ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "948350883"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.playingJingle) {
			class283.midiPcmStream.clear();
			class283.musicPlayerStatus = 1;
			DevicePcmPlayerProvider.musicTrackArchive = null;
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && BufferedSink.clientPreferences.method2391() != 0 && !Client.playingJingle) {
			Archive var1 = ReflectionCheck.archive6;
			int var2 = BufferedSink.clientPreferences.method2391();
			class283.musicPlayerStatus = 1;
			DevicePcmPlayerProvider.musicTrackArchive = var1;
			class283.musicTrackGroupId = var0;
			class283.musicTrackFileId = 0;
			Messages.musicTrackVolume = var2;
			GrandExchangeEvents.musicTrackBoolean = false;
			class19.pcmSampleLength = 2;
		}

		Client.currentTrackGroupId = var0;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "86"
	)
	static final boolean method710(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
