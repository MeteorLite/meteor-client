import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.TlsClientProtocol;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;

@ObfuscatedName("ax")
class class12 extends SSLSocket {
	@ObfuscatedName("vq")
	@ObfuscatedSignature(
		descriptor = "Lcj;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		descriptor = "[Luz;"
	)
	@Export("mapMarkerSprites")
	static SpritePixels[] mapMarkerSprites;
	@ObfuscatedName("ln")
	static int field41;
	@ObfuscatedName("at")
	Certificate[] field43;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lak;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class15 this$0;
	// $FF: synthetic field
	@Export("val$tlsClientProtocol")
	@ObfuscatedName("val$tlsClientProtocol")
	final TlsClientProtocol val$tlsClientProtocol;
	// $FF: synthetic field
	@Export("val$host")
	@ObfuscatedName("val$host")
	final String val$host;

	@ObfuscatedSignature(
		descriptor = "(Lak;Lorg/bouncycastle/crypto/tls/TlsClientProtocol;Ljava/lang/String;)V"
	)
	class12(class15 var1, TlsClientProtocol var2, String var3) {
		this.this$0 = var1;
		this.val$tlsClientProtocol = var2;
		this.val$host = var3;
	}

	public InputStream getInputStream() throws IOException {
		return this.val$tlsClientProtocol.getInputStream();
	}

	public OutputStream getOutputStream() throws IOException {
		return this.val$tlsClientProtocol.getOutputStream();
	}

	@Export("close")
	@ObfuscatedName("close")
	public synchronized void close() throws IOException {
		this.val$tlsClientProtocol.close();
	}

	public void addHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public boolean getEnableSessionCreation() {
		return false;
	}

	public String[] getEnabledCipherSuites() {
		return null;
	}

	public String[] getEnabledProtocols() {
		return null;
	}

	public boolean getNeedClientAuth() {
		return false;
	}

	@Export("getSession")
	@ObfuscatedName("getSession")
	public SSLSession getSession() {
		return new class17(this);
	}

	public String[] getSupportedProtocols() {
		return null;
	}

	public String[] getSupportedCipherSuites() {
		return null;
	}

	public boolean getUseClientMode() {
		return false;
	}

	public boolean getWantClientAuth() {
		return false;
	}

	public void removeHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public void setEnableSessionCreation(boolean var1) {
	}

	public void setEnabledCipherSuites(String[] var1) {
	}

	public void setEnabledProtocols(String[] var1) {
	}

	public void setNeedClientAuth(boolean var1) {
	}

	public void setUseClientMode(boolean var1) {
	}

	public void setWantClientAuth(boolean var1) {
	}

	@Export("startHandshake")
	@ObfuscatedName("startHandshake")
	public void startHandshake() throws IOException {
		this.val$tlsClientProtocol.connect(new class13(this));
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([Loj;II)Loj;",
		garbageValue = "-948387119"
	)
	@Export("findEnumerated")
	public static class383 findEnumerated(class383[] var0, int var1) {
		class383[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class383 var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Llu;",
		garbageValue = "915557708"
	)
	public static ServerPacket[] method46() {
		return new ServerPacket[]{ServerPacket.field2651, ServerPacket.field2639, ServerPacket.TRADING_POST_UPDATE, ServerPacket.SEND_PING, ServerPacket.field2633, ServerPacket.IF_SETNPCHEAD, ServerPacket.IF_SETTEXT, ServerPacket.SET_PLAYER_OP, ServerPacket.OBJ_COUNT, ServerPacket.UPDATE_UID192, ServerPacket.OBJ_DEL_LEGACY, ServerPacket.RESET_ANIMS, ServerPacket.field2655, ServerPacket.IF_OPENTOP, ServerPacket.field2656, ServerPacket.field2642, ServerPacket.field2641, ServerPacket.PREFETCH_GAMEOBJECTS, ServerPacket.field2648, ServerPacket.MIDI_SONG_WITH_SECONDARY, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.MAPPROJ_ANIM, ServerPacket.NPC_ANIM_SPECIFIC, ServerPacket.VARP_LARGE, ServerPacket.TRADING_POST_RESULTS, ServerPacket.field2637, ServerPacket.NPC_SPOTANIM_SPECIFIC, ServerPacket.REFLECTIONCHECK_FRIENDLIST, ServerPacket.UPDATE_STAT, ServerPacket.UPDATE_IGNORELIST, ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR, ServerPacket.TOGGLE_OCULUS_ORB, ServerPacket.VARCLAN_ENABLE, ServerPacket.MIDI_SONG_STOP, ServerPacket.field2670, ServerPacket.field2673, ServerPacket.IF_SETSCROLLPOS, ServerPacket.LOC_ANIM_SPECIFIC, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.PLAYER_INFO, ServerPacket.EMPTY_PACKET, ServerPacket.UPDATE_RUNWEIGHT, ServerPacket.field2682, ServerPacket.VARP_SMALL, ServerPacket.PLAYER_SPOTANIM_SPECIFIC, ServerPacket.IF_SETPLAYERMODEL_OBJ, ServerPacket.IF_CLOSESUB, ServerPacket.HINT_ARROW, ServerPacket.NEW_PACK_215, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.OPEN_URL, ServerPacket.field2674, ServerPacket.MESSAGE_PRIVATE, ServerPacket.IF_SETOBJECT, ServerPacket.CAM_MOVETO_EASED_CIRCULAR, ServerPacket.MINIMAP_TOGGLE, ServerPacket.NEW_PACKET_CAM_RESET_V2, ServerPacket.MESSAGE_CLANCHANNEL, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.IF_OPENSUB, ServerPacket.IF_SETPOSITION, ServerPacket.CAM_RESET, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2, ServerPacket.CLANSETTINGS_FULL, ServerPacket.field2698, ServerPacket.SET_MAP_FLAG, ServerPacket.field2697, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.field2684, ServerPacket.REBUILD_REGION, ServerPacket.RUN_CLIENTSCRIPT, ServerPacket.NPC_HEADICON_SPECIFIC, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.field2707, ServerPacket.field2694, ServerPacket.CAM_MOVETO, ServerPacket.field2728, ServerPacket.VARCLAN, ServerPacket.field2719, ServerPacket.MESSAGE_GAME, ServerPacket.LOC_ADD_CHANGE, ServerPacket.SYNTH_SOUND, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.SYNC_CLIENT_VARCACHE, ServerPacket.CAM_SHAKE, ServerPacket.UPDATE_RUNENERGY, ServerPacket.IF_SETANIM, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.MIDI_JINGLE, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.field2709, ServerPacket.ENTER_FREECAM, ServerPacket.field2724, ServerPacket.UPDATE_SITESETTINGS, ServerPacket.UPDATE_ZONE_FULL_FOLLOWS, ServerPacket.LOGOUT_FULL, ServerPacket.PLAYER_ANIM_SPECIFIC, ServerPacket.field2713, ServerPacket.field2722, ServerPacket.NPC_INFO_SMALL, ServerPacket.field2718, ServerPacket.VARCLAN_DISABLE, ServerPacket.LOGIN_SCREEN_PACKET, ServerPacket.field2754, ServerPacket.UPDATE_FRIENDLIST, ServerPacket.field2753, ServerPacket.field2743, ServerPacket.field2745, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.IF_SETPLAYERHEAD, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.UPDATE_INV_FULL, ServerPacket.IF_SETPLAYERMODEL_SELF, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE, ServerPacket.NPC_INFO_LARGE, ServerPacket.MIDI_SONG, ServerPacket.OBJ_ADD, ServerPacket.field2757, ServerPacket.MIDI_SWAP, ServerPacket.field2740, ServerPacket.field2756, ServerPacket.field2736, ServerPacket.IF_SETHIDE, ServerPacket.field2748};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "1"
	)
	public static boolean method43(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1907529408"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IB)V",
		garbageValue = "12"
	)
	@Export("setFriendsRank")
	static final void setFriendsRank(String var0, int var1) {
		PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.f2, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(ClanChannel.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.writeByteNeg(var1);
		Client.packetWriter.addNode(var2);
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1724856740"
	)
	static int method48(int var0, Script var1, boolean var2) {
		if (var0 == 5000) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == 5001) {
			DbTableType.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			ObjTypeCustomisation.privateChatMode = WorldMapArea.method1204(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
			if (ObjTypeCustomisation.privateChatMode == null) {
				ObjTypeCustomisation.privateChatMode = PrivateChatMode.field4303;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
			PacketBufferNode var11 = class113.getPacketBufferNode(ClientPacket.CHAT_SETFILTER, Client.packetWriter.isaacCipher);
			var11.packetBuffer.writeByte(Client.publicChatMode);
			var11.packetBuffer.writeByte(ObjTypeCustomisation.privateChatMode.id);
			var11.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var11);
			return 1;
		} else {
			String var3;
			int var4;
			int var5;
			PacketBufferNode var6;
			if (var0 == 5002) {
				var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				DbTableType.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var6 = class113.getPacketBufferNode(ClientPacket.CHAT_SEND_ABUSE_REPORT, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(ClanChannel.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var7;
				Message var8;
				if (var0 == 5003) {
					DbTableType.Interpreter_intStackSize -= 2;
					var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					var8 = class14.Messages_getByChannelAndID(var7, var4);
					if (var8 != null) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.count;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.cycle;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else {
					Message var9;
					if (var0 == 5004) {
						var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var9 = class31.Messages_getMessage(var7);
						if (var9 != null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.type;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.cycle;
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 5005) {
						if (ObjTypeCustomisation.privateChatMode == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ObjTypeCustomisation.privateChatMode.id;
						}

						return 1;
					} else {
						PacketBufferNode var12;
						if (var0 == 5008) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							var12 = class544.method2711(var4, var3, class85.clientLanguage, -1);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5009) {
							class127.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
							String var13 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
							var12 = class113.getPacketBufferNode(ClientPacket.CHAT_SENDPRIVATE, Client.packetWriter.isaacCipher);
							var12.packetBuffer.writeShort(0);
							int var10 = var12.packetBuffer.offset;
							var12.packetBuffer.writeStringCp1252NullTerminated(var3);
							PcmPlayer.method210(var12.packetBuffer, var13);
							var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
							Client.packetWriter.addNode(var12);
							return 1;
						} else if (var0 == 5010) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							DbTableType.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var6 = class544.method2711(var4, var3, class85.clientLanguage, var5);
							Client.packetWriter.addNode(var6);
							return 1;
						} else if (var0 != 5015) {
							if (var0 == 5016) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.tradeChatMode;
								return 1;
							} else if (var0 == 5017) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Message.Messages_getHistorySize(var7);
								return 1;
							} else if (var0 == 5018) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Messages_getLastChatID(var7);
								return 1;
							} else if (var0 == 5019) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class92.method498(var7);
								return 1;
							} else if (var0 == 5020) {
								var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
								class9.doCheat(var3);
								return 1;
							} else if (var0 == 5021) {
								Client.field600 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize].toLowerCase().trim();
								return 1;
							} else if (var0 == 5022) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = Client.field600;
								return 1;
							} else if (var0 == 5023) {
								var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
								System.out.println(var3);
								return 1;
							} else if (var0 == 5030) {
								DbTableType.Interpreter_intStackSize -= 2;
								var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
								var8 = class14.Messages_getByChannelAndID(var7, var4);
								if (var8 != null) {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.count;
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.cycle;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else if (var0 == 5031) {
								var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
								var9 = class31.Messages_getMessage(var7);
								if (var9 != null) {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.type;
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.cycle;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
								}

								return 1;
							} else {
								return 2;
							}
						} else {
							if (class229.localPlayer != null && class229.localPlayer.username != null) {
								var3 = class229.localPlayer.username.getName();
							} else {
								var3 = "";
							}

							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3;
							return 1;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "11"
	)
	static int method49(int var0, Script var1, boolean var2) {
		return 2;
	}
}