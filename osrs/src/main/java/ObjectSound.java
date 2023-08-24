import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("bj")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("jd")
	static int field686;
	@ObfuscatedName("ae")
	@Export("plane")
	int plane;
	@ObfuscatedName("ao")
	@Export("x")
	int x;
	@ObfuscatedName("at")
	@Export("y")
	int y;
	@ObfuscatedName("ac")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("ai")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("az")
	int field702;
	@ObfuscatedName("ap")
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lbn;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("af")
	int field696;
	@ObfuscatedName("ad")
	int field694;
	@ObfuscatedName("aq")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("al")
	int field698;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lbn;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lhv;"
	)
	@Export("obj")
	ObjectComposition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1805200159"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectComposition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field702 = var2.int7 * 128;
			this.field696 = var2.int5;
			this.field694 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field702 = 0;
			this.field696 = 0;
			this.field694 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			class162.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-42"
	)
	static void method414() {
		Tiles.Tiles_underlays = null;
		class227.Tiles_overlays = null;
		class172.Tiles_shapes = null;
		ModelData0.field2282 = null;
		BufferedNetSocket.field3820 = null;
		MoveSpeed.field1924 = null;
		class162.field1419 = null;
		Fonts.Tiles_hue = null;
		class466.Tiles_saturation = null;
		Tiles.Tiles_lightness = null;
		class128.Tiles_hueMultiplier = null;
		Interpreter.field710 = null;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "449179665"
	)
	static int method415(int var0, Script var1, boolean var2) {
		if (var0 == 3800) {
			if (Players.guestClanSettings != null) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
				class466.field3912 = Players.guestClanSettings;
			} else {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3801) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				if (Client.currentClanSettings[var3] != null) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					class466.field3912 = Client.currentClanSettings[var3];
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3802) {
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = class466.field3912.name;
				return 1;
			} else if (var0 == 3803) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.allowGuests ? 1 : 0;
				return 1;
			} else if (var0 == 3804) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1383;
				return 1;
			} else if (var0 == 3805) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1385;
				return 1;
			} else if (var0 == 3806) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1384;
				return 1;
			} else if (var0 == 3807) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1386;
				return 1;
			} else if (var0 == 3809) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.memberCount;
				return 1;
			} else if (var0 == 3810) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = class466.field3912.memberNames[var3];
				return 1;
			} else if (var0 == 3811) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.memberRanks[var3];
				return 1;
			} else if (var0 == 3812) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.bannedMemberCount;
				return 1;
			} else if (var0 == 3813) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = class466.field3912.bannedMemberNames[var3];
				return 1;
			} else {
				int var5;
				int var6;
				if (var0 == 3814) {
					SoundCache.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.method809(var3, var6, var5);
					return 1;
				} else if (var0 == 3815) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.currentOwner;
					return 1;
				} else if (var0 == 3816) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1391;
					return 1;
				} else if (var0 == 3817) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.method808(Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize]);
					return 1;
				} else if (var0 == 3818) {
					Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = class466.field3912.getSortedMembers()[Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]];
					return 1;
				} else if (var0 == 3819) {
					SoundCache.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					class386.method2027(var6, var3);
					return 1;
				} else if (var0 == 3820) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1393[var3];
					return 1;
				} else {
					if (var0 == 3821) {
						SoundCache.Interpreter_intStackSize -= 3;
						var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1] == 1;
						var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
						SoundSystem.method219(var5, var3, var4);
					}

					if (var0 == 3822) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class466.field3912.field1382[var3] ? 1 : 0;
						return 1;
					} else if (var0 == 3850) {
						if (VerticalAlignment.guestClanChannel != null) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
							class396.field3679 = VerticalAlignment.guestClanChannel;
						} else {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3851) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						if (Client.currentClanChannels[var3] != null) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
							class396.field3679 = Client.currentClanChannels[var3];
							class113.field1172 = var3;
						} else {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3852) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = class396.field3679.name;
						return 1;
					} else if (var0 == 3853) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class396.field3679.field1425;
						return 1;
					} else if (var0 == 3854) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class396.field3679.field1426;
						return 1;
					} else if (var0 == 3855) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class396.field3679.method859();
						return 1;
					} else if (var0 == 3856) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = ((ClanChannelMember)class396.field3679.members.get(var3)).username.getName();
						return 1;
					} else if (var0 == 3857) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((ClanChannelMember)class396.field3679.members.get(var3)).rank;
						return 1;
					} else if (var0 == 3858) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ((ClanChannelMember)class396.field3679.members.get(var3)).world;
						return 1;
					} else if (var0 == 3859) {
						var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						UserComparator10.method689(class113.field1172, var3);
						return 1;
					} else if (var0 == 3860) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class396.field3679.method860(Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize]);
						return 1;
					} else if (var0 == 3861) {
						Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = class396.field3679.getSortedMembers()[Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]];
						return 1;
					} else if (var0 == 3890) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class139.varclan != null ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-24646"
	)
	static void method416() {
		Client.packetWriter.addNode(ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2569, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}