import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

@ObfuscatedName("ay")
class class13 extends DefaultTlsClient {
	@ObfuscatedName("ga")
	static int field35;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lap;"
	)
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lap;)V"
	)
	class13(class12 var1) {
		this.this$1 = var1;
	}

	@Export("getClientExtensions")
	@ObfuscatedName("getClientExtensions")
	public Hashtable getClientExtensions() throws IOException {
		Hashtable var1 = super.getClientExtensions();
		if (var1 == null) {
			var1 = new Hashtable();
		}

		byte[] var2 = this.this$1.val$host.getBytes();
		ByteArrayOutputStream var3 = new ByteArrayOutputStream();
		DataOutputStream var4 = new DataOutputStream(var3);
		var4.writeShort(var2.length + 3);
		var4.writeByte(0);
		var4.writeShort(var2.length);
		var4.write(var2);
		var4.close();
		var1.put(0, var3.toByteArray());
		return var1;
	}

	@Export("getAuthentication")
	@ObfuscatedName("getAuthentication")
	public TlsAuthentication getAuthentication() throws IOException {
		return new class11(this);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "-21"
	)
	static int method42(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
		if (var0 == 1800) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = KitDefinition.Widget_unpackTargetMask(MouseRecorder.getWidgetFlags(var3));
			return 1;
		} else if (var0 != 1801) {
			if (var0 == 1802) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "751094160"
	)
	static int method43(int var0, Script var1, boolean var2) {
		if (var0 == 3800) {
			if (VerticalAlignment.guestClanSettings != null) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
				class295.field2496 = VerticalAlignment.guestClanSettings;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3801) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (Client.currentClanSettings[var3] != null) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					class295.field2496 = Client.currentClanSettings[var3];
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3802) {
				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = class295.field2496.name;
				return 1;
			} else if (var0 == 3803) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.allowGuests ? 1 : 0;
				return 1;
			} else if (var0 == 3804) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1371;
				return 1;
			} else if (var0 == 3805) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1372;
				return 1;
			} else if (var0 == 3806) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1370;
				return 1;
			} else if (var0 == 3807) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1369;
				return 1;
			} else if (var0 == 3809) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.memberCount;
				return 1;
			} else if (var0 == 3810) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = class295.field2496.memberNames[var3];
				return 1;
			} else if (var0 == 3811) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.memberRanks[var3];
				return 1;
			} else if (var0 == 3812) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.bannedMemberCount;
				return 1;
			} else if (var0 == 3813) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = class295.field2496.bannedMemberNames[var3];
				return 1;
			} else {
				int var5;
				int var6;
				if (var0 == 3814) {
					Interpreter.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.method814(var3, var6, var5);
					return 1;
				} else if (var0 == 3815) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.currentOwner;
					return 1;
				} else if (var0 == 3816) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1378;
					return 1;
				} else if (var0 == 3817) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.method813(Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize]);
					return 1;
				} else if (var0 == 3818) {
					Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = class295.field2496.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
					return 1;
				} else if (var0 == 3819) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					class36.method183(var6, var3);
					return 1;
				} else if (var0 == 3820) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1379[var3];
					return 1;
				} else {
					if (var0 == 3821) {
						Interpreter.Interpreter_intStackSize -= 3;
						var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
						var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						HealthBarUpdate.method525(var5, var3, var4);
					}

					if (var0 == 3822) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class295.field2496.field1368[var3] ? 1 : 0;
						return 1;
					} else if (var0 == 3850) {
						if (ClanChannelMember.guestClanChannel != null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							Interpreter.field704 = ClanChannelMember.guestClanChannel;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3851) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						if (Client.currentClanChannels[var3] != null) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
							Interpreter.field704 = Client.currentClanChannels[var3];
							VarcInt.field1529 = var3;
						} else {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3852) {
						Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = Interpreter.field704.name;
						return 1;
					} else if (var0 == 3853) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.field704.field1413;
						return 1;
					} else if (var0 == 3854) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.field704.field1414;
						return 1;
					} else if (var0 == 3855) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.field704.method868();
						return 1;
					} else if (var0 == 3856) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = ((ClanChannelMember)Interpreter.field704.members.get(var3)).username.getName();
						return 1;
					} else if (var0 == 3857) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)Interpreter.field704.members.get(var3)).rank;
						return 1;
					} else if (var0 == 3858) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)Interpreter.field704.members.get(var3)).world;
						return 1;
					} else if (var0 == 3859) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						ArchiveDisk.method2314(VarcInt.field1529, var3);
						return 1;
					} else if (var0 == 3860) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.field704.method869(Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize]);
						return 1;
					} else if (var0 == 3861) {
						Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = Interpreter.field704.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
						return 1;
					} else if (var0 == 3890) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SequenceDefinition.varclan != null ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		descriptor = "(ZLuy;B)V",
		garbageValue = "15"
	)
	static final void method44(boolean var0, PacketBuffer var1) {
		while (true) {
			byte var2 = 16;
			int var3 = 1 << var2;
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= var2 + 12) {
				int var4 = var1.readBits(var2);
				if (var4 != var3 - 1) {
					boolean var5 = false;
					if (Client.npcs[var4] == null) {
						Client.npcs[var4] = new NPC();
						var5 = true;
					}

					NPC var6 = Client.npcs[var4];
					Client.npcIndices[++Client.npcCount - 1] = var4;
					var6.npcCycle = Client.cycle;
					int var10 = var1.readBits(1);
					if (var10 == 1) {
						Client.field552[++Client.field450 - 1] = var4;
					}

					int var7 = var1.readBits(1);
					var6.definition = class190.getNpcDefinition(var1.readBits(14));
					int var11 = Client.field563[var1.readBits(3)];
					if (var5) {
						var6.orientation = var6.rotation = var11;
					}

					int var8;
					if (var0) {
						var8 = var1.readBits(8);
						if (var8 > 127) {
							var8 -= 256;
						}
					} else {
						var8 = var1.readBits(5);
						if (var8 > 15) {
							var8 -= 32;
						}
					}

					int var9;
					if (var0) {
						var9 = var1.readBits(8);
						if (var9 > 127) {
							var9 -= 256;
						}
					} else {
						var9 = var1.readBits(5);
						if (var9 > 15) {
							var9 -= 32;
						}
					}

					boolean var12 = var1.readBits(1) == 1;
					if (var12) {
						var1.readBits(32);
					}

					WorldMapLabel.method1571(var6);
					if (var6.field1020 == 0) {
						var6.rotation = 0;
					}

					var6.method584(TextureProvider.localPlayer.pathX[0] + var8, TextureProvider.localPlayer.pathY[0] + var9, var7 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}

	@ObfuscatedName("oi")
	@ObfuscatedSignature(
		descriptor = "(B)Loo;",
		garbageValue = "-81"
	)
	static JagNetThread method45() {
		return class59.field309;
	}
}