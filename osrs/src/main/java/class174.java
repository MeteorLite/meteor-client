import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class174 {
	@ObfuscatedName("y")
	static byte[][][] field1852;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;
	@ObfuscatedName("md")
	@ObfuscatedGetter(
		intValue = 1243084179
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("c")
	public short[] field1858;
	@ObfuscatedName("x")
	public short[] field1855;

	public class174(int var1) {
		ItemComposition var2 = MidiPcmStream.ItemDefinition_get(var1);
		if (var2.method3785()) {
			this.field1858 = new short[var2.recolorTo.length];
			System.arraycopy(var2.recolorTo, 0, this.field1858, 0, this.field1858.length);
		}

		if (var2.method3821()) {
			this.field1855 = new short[var2.retextureTo.length];
			System.arraycopy(var2.retextureTo, 0, this.field1855, 0, this.field1855.length);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILbz;ZB)I",
		garbageValue = "10"
	)
	static int method3400(int var0, Script var1, boolean var2) {
		if (var0 == 5000) {
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == 5001) {
			class379.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
			class300.privateChatMode = class359.method6838(Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]);
			if (class300.privateChatMode == null) {
				class300.privateChatMode = PrivateChatMode.field5000;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
			PacketBufferNode var13 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3099, Client.packetWriter.isaacCipher);
			var13.packetBuffer.writeByte(Client.publicChatMode);
			var13.packetBuffer.writeByte(class300.privateChatMode.field4999);
			var13.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var13);
			return 1;
		} else {
			PacketBufferNode var6;
			int var7;
			String var8;
			int var9;
			if (var0 == 5002) {
				var8 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
				class379.Interpreter_intStackSize -= 2;
				var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var9 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var6 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3069, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(Actor.stringCp1252NullTerminatedByteSize(var8) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var8);
				var6.packetBuffer.writeByte(var7 - 1);
				var6.packetBuffer.writeByte(var9);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var3;
				Message var5;
				if (var0 == 5003) {
					class379.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
					var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
					var5 = GrandExchangeEvents.Messages_getByChannelAndID(var3, var7);
					if (var5 != null) {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.count;
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.cycle;
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.sender != null ? var5.sender : "";
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.prefix != null ? var5.prefix : "";
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.text != null ? var5.text : "";
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.isFromFriend() ? 1 : (var5.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					Message var4;
					if (var0 == 5004) {
						var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						var4 = class20.Messages_getMessage(var3);
						if (var4 != null) {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.type;
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.cycle;
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.sender != null ? var4.sender : "";
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.prefix != null ? var4.prefix : "";
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.text != null ? var4.text : "";
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.isFromFriend() ? 1 : (var4.isFromIgnored() ? 2 : 0);
						} else {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 5005) {
						if (class300.privateChatMode == null) {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class300.privateChatMode.field4999;
						}

						return 1;
					} else {
						PacketBufferNode var12;
						if (var0 == 5008) {
							var8 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							var7 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							var12 = class305.method6204(var7, var8, class103.clientLanguage, -1);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5009) {
							class125.Interpreter_stringStackSize -= 2;
							var8 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
							String var11 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
							var12 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3077, Client.packetWriter.isaacCipher);
							var12.packetBuffer.writeShort(0);
							int var10 = var12.packetBuffer.offset;
							var12.packetBuffer.writeStringCp1252NullTerminated(var8);
							class281.method5418(var12.packetBuffer, var11);
							var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5010) {
							var8 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							class379.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
							var9 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
							var6 = class305.method6204(var7, var8, class103.clientLanguage, var9);
							Client.packetWriter.addNode(var6);
							return 1;
						} else if (var0 != 5015) {
							if (var0 == 5016) {
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Client.tradeChatMode;
								return 1;
							} else if (var0 == 5017) {
								var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = WorldMapSectionType.Messages_getHistorySize(var3);
								return 1;
							} else if (var0 == 5018) {
								var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class133.Messages_getLastChatID(var3);
								return 1;
							} else if (var0 == 5019) {
								var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class281.method5428(var3);
								return 1;
							} else if (var0 == 5020) {
								var8 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
								GameEngine.doCheat(var8);
								return 1;
							} else if (var0 == 5021) {
								Client.field730 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize].toLowerCase().trim();
								return 1;
							} else if (var0 == 5022) {
								Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = Client.field730;
								return 1;
							} else if (var0 == 5023) {
								var8 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
								System.out.println(var8);
								return 1;
							} else if (var0 == 5030) {
								class379.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
								var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
								var5 = GrandExchangeEvents.Messages_getByChannelAndID(var3, var7);
								if (var5 != null) {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.count;
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.cycle;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.sender != null ? var5.sender : "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.prefix != null ? var5.prefix : "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5.text != null ? var5.text : "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5.isFromFriend() ? 1 : (var5.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else if (var0 == 5031) {
								var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
								var4 = class20.Messages_getMessage(var3);
								if (var4 != null) {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.type;
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.cycle;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.sender != null ? var4.sender : "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.prefix != null ? var4.prefix : "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.text != null ? var4.text : "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4.isFromFriend() ? 1 : (var4.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else {
								return 2;
							}
						} else {
							if (class296.localPlayer != null && class296.localPlayer.username != null) {
								var8 = class296.localPlayer.username.getName();
							} else {
								var8 = "";
							}

							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var8;
							return 1;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1855673975"
	)
	static boolean method3399() {
		return Client.tapToDrop || Client.keyHandlerInstance.getKeyPressed(81);
	}
}
