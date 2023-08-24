import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	public static final NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("ao")
	static int field3512;
	@ObfuscatedName("at")
	static boolean field3511;
	@ObfuscatedName("ac")
	static Object field3513;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3512 = 0;
		field3511 = false;
		field3513 = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					synchronized(field3513) {
						if ((field3511 || field3512 <= 1) && ArchiveDiskActionHandler_requestQueue.method1997()) {
							field3512 = 0;
							field3513.notifyAll();
							return;
						}

						field3512 = 600;
					}
				} else {
					PendingSpawn.method505(100L);
					synchronized(field3513) {
						if ((field3511 || field3512 <= 1) && ArchiveDiskActionHandler_requestQueue.method1997()) {
							field3512 = 0;
							field3513.notifyAll();
							return;
						}

						--field3512;
					}
				}
			}
		} catch (Exception var13) {
			Messages.RunException_sendStackTrace((String)null, var13);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-224365630"
	)
	static void method1884() {
		ItemComposition.field1768 = new int[2000];
		int var0 = 0;
		int var1 = 240;

		int var3;
		for (byte var2 = 12; var0 < 16; var1 -= var2) {
			var3 = ArchiveLoader.method463((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)((float)var0 * 0.425F / 16.0F + 0.075F));
			ItemComposition.field1768[var0] = var3;
			++var0;
		}

		var1 = 48;

		for (int var5 = var1 / 6; var0 < ItemComposition.field1768.length; var1 -= var5) {
			var3 = var0 * 2;

			for (int var4 = ArchiveLoader.method463((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < ItemComposition.field1768.length; ++var0) {
				ItemComposition.field1768[var0] = var4;
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "63"
	)
	public static final boolean method1885(char var0) {
		return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "5"
	)
	static int method1886(int var0, Script var1, boolean var2) {
		if (var0 == 5000) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == 5001) {
			SoundCache.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			class128.privateChatMode = DevicePcmPlayerProvider.method74(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
			if (class128.privateChatMode == null) {
				class128.privateChatMode = PrivateChatMode.field4271;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
			PacketBufferNode var11 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.SET_CHATFILTERSETTINGS, Client.packetWriter.isaacCipher);
			var11.packetBuffer.writeByte(Client.publicChatMode);
			var11.packetBuffer.writeByte(class128.privateChatMode.id);
			var11.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var11);
			return 1;
		} else {
			String var3;
			int var4;
			int var5;
			PacketBufferNode var6;
			if (var0 == 5002) {
				var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
				SoundCache.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var6 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.SEND_SNAPSHOT, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(AbstractSocket.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var7;
				Message var8;
				if (var0 == 5003) {
					SoundCache.Interpreter_intStackSize -= 2;
					var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					var8 = AbstractByteArrayCopier.Messages_getByChannelAndID(var7, var4);
					if (var8 != null) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.count;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.cycle;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					Message var9;
					if (var0 == 5004) {
						var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var9 = class33.Messages_getMessage(var7);
						if (var9 != null) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.type;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.cycle;
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
						} else {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 5005) {
						if (class128.privateChatMode == null) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class128.privateChatMode.id;
						}

						return 1;
					} else {
						PacketBufferNode var12;
						if (var0 == 5008) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							var12 = Actor.method510(var4, var3, ClanChannelMember.clientLanguage, -1);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5009) {
							class137.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
							String var13 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
							var12 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.MESSAGE_PRIVATE, Client.packetWriter.isaacCipher);
							var12.packetBuffer.writeShort(0);
							int var10 = var12.packetBuffer.offset;
							var12.packetBuffer.writeStringCp1252NullTerminated(var3);
							class216.method1127(var12.packetBuffer, var13);
							var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5010) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							SoundCache.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var6 = Actor.method510(var4, var3, ClanChannelMember.clientLanguage, var5);
							Client.packetWriter.addNode(var6);
							return 1;
						} else if (var0 != 5015) {
							if (var0 == 5016) {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.tradeChatMode;
								return 1;
							} else if (var0 == 5017) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = HorizontalAlignment.Messages_getHistorySize(var7);
								return 1;
							} else if (var0 == 5018) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ClientPacket.Messages_getLastChatID(var7);
								return 1;
							} else if (var0 == 5019) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ClanChannelMember.method776(var7);
								return 1;
							} else if (var0 == 5020) {
								var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
								class85.doCheat(var3);
								return 1;
							} else if (var0 == 5021) {
								Client.field602 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize].toLowerCase().trim();
								return 1;
							} else if (var0 == 5022) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = Client.field602;
								return 1;
							} else if (var0 == 5023) {
								var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
								System.out.println(var3);
								return 1;
							} else if (var0 == 5030) {
								SoundCache.Interpreter_intStackSize -= 2;
								var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
								var8 = AbstractByteArrayCopier.Messages_getByChannelAndID(var7, var4);
								if (var8 != null) {
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.count;
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.cycle;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else if (var0 == 5031) {
								var7 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
								var9 = class33.Messages_getMessage(var7);
								if (var9 != null) {
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.type;
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.cycle;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else {
								return 2;
							}
						} else {
							if (VarbitComposition.localPlayer != null && VarbitComposition.localPlayer.username != null) {
								var3 = VarbitComposition.localPlayer.username.getName();
							} else {
								var3 = "";
							}

							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3;
							return 1;
						}
					}
				}
			}
		}
	}
}