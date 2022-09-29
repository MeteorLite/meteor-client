import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Iterator;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
class class17 implements SSLSession {
	@ObfuscatedName("uc")
	static Iterator field100;
	@ObfuscatedName("q")
	@Export("ItemDefinition_inMembersWorld")
	static boolean ItemDefinition_inMembersWorld;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lh;"
	)
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lh;)V"
	)
	class17(class12 var1) {
		this.this$1 = var1;
	}

	public Certificate[] getLocalCertificates() {
		throw new UnsupportedOperationException();
	}

	public String getCipherSuite() {
		throw new UnsupportedOperationException();
	}

	public long getCreationTime() {
		throw new UnsupportedOperationException();
	}

	public byte[] getId() {
		throw new UnsupportedOperationException();
	}

	public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
		return this.this$1.field62;
	}

	public void putValue(String var1, Object var2) {
		throw new UnsupportedOperationException();
	}

	public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
		return null;
	}

	public String getProtocol() {
		throw new UnsupportedOperationException();
	}

	public SSLSessionContext getSessionContext() {
		throw new UnsupportedOperationException();
	}

	public String[] getValueNames() {
		throw new UnsupportedOperationException();
	}

	public void invalidate() {
		throw new UnsupportedOperationException();
	}

	public boolean isValid() {
		throw new UnsupportedOperationException();
	}

	public Principal getLocalPrincipal() {
		throw new UnsupportedOperationException();
	}

	public void removeValue(String var1) {
		throw new UnsupportedOperationException();
	}

	public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
		return null;
	}

	public Object getValue(String var1) {
		throw new UnsupportedOperationException();
	}

	public int getPeerPort() {
		return 0;
	}

	public int getPacketBufferSize() {
		throw new UnsupportedOperationException();
	}

	public int getApplicationBufferSize() {
		return 0;
	}

	public String getPeerHost() {
		throw new UnsupportedOperationException();
	}

	public long getLastAccessedTime() {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-7"
	)
	public static void method267() {
		class139.midiPcmStream.clear();
		class274.musicPlayerStatus = 1;
		class274.musicTrackArchive = null;
	}

	@ObfuscatedName("n")
	public static int method271(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "-2056199428"
	)
	static final void menuAction(int param0, int param1, int opcode, int id, int itemId, String var5, String var6, int canvasX, int canvasY) {
		if (opcode >= 2000) {
			opcode -= 2000;
		}

		PacketBufferNode var9;
		if (opcode == 1) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field2951, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShort(Canvas.selectedItemId);
			var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
			var9.packetBuffer.writeInt(GameObject.selectedItemWidget);
			var9.packetBuffer.writeIntME(id);
			var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var9.packetBuffer.writeShort(class128.baseX * 64 + param0);
			var9.packetBuffer.writeShort(ApproximateRouteStrategy.selectedItemSlot);
			Client.packetWriter.addNode(var9);
		} else if (opcode == 2) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field2968, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeIntME(Client.selectedSpellItemId);
			var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
			var9.packetBuffer.writeIntME(class128.baseX * 64 + param0);
			var9.packetBuffer.method7961(Client.selectedSpellChildIndex);
			var9.packetBuffer.method7972(ClanSettings.selectedSpellWidget);
			var9.packetBuffer.writeIntME(id);
			Client.packetWriter.addNode(var9);
		} else if (opcode == 3) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field3042, Client.packetWriter.isaacCipher);
			var9.packetBuffer.method7961(WorldMapData_1.baseY * 64 + param1);
			var9.packetBuffer.method7961(class128.baseX * 64 + param0);
			var9.packetBuffer.writeShort(id);
			var9.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var9);
		} else if (opcode == 4) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field2965, Client.packetWriter.isaacCipher);
			var9.packetBuffer.method7961(id);
			var9.packetBuffer.writeShort(WorldMapData_1.baseY * 64 + param1);
			var9.packetBuffer.method8004(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var9.packetBuffer.writeShort(class128.baseX * 64 + param0);
			Client.packetWriter.addNode(var9);
		} else if (opcode == 5) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field3041, Client.packetWriter.isaacCipher);
			var9.packetBuffer.method8136(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var9.packetBuffer.method7962(class128.baseX * 64 + param0);
			var9.packetBuffer.method7962(WorldMapData_1.baseY * 64 + param1);
			var9.packetBuffer.writeShort(id);
			Client.packetWriter.addNode(var9);
		} else if (opcode == 6) {
			Client.mouseCrossX = canvasX;
			Client.mouseCrossY = canvasY;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var9 = class120.getPacketBufferNode(ClientPacket.field2946, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeIntME(class128.baseX * 64 + param0);
			var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var9.packetBuffer.method7962(id);
			var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
			Client.packetWriter.addNode(var9);
		} else {
			PacketBufferNode var10;
			NPC var14;
			if (opcode == 7) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field2958, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeInt(GameObject.selectedItemWidget);
					var10.packetBuffer.writeShort(ApproximateRouteStrategy.selectedItemSlot);
					var10.packetBuffer.writeShort(id);
					var10.packetBuffer.writeShort(Canvas.selectedItemId);
					var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 8) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field2949, Client.packetWriter.isaacCipher);
					var10.packetBuffer.method7961(Client.selectedSpellChildIndex);
					var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var10.packetBuffer.method7972(ClanSettings.selectedSpellWidget);
					var10.packetBuffer.method7961(id);
					var10.packetBuffer.method7962(Client.selectedSpellItemId);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 9) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field2969, Client.packetWriter.isaacCipher);
					var10.packetBuffer.method7962(id);
					var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 10) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field2961, Client.packetWriter.isaacCipher);
					var10.packetBuffer.method7961(id);
					var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 11) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field3034, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(id);
					var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 12) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field3044, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var10.packetBuffer.writeIntME(id);
					Client.packetWriter.addNode(var10);
				}
			} else if (opcode == 13) {
				var14 = Client.npcs[id];
				if (var14 != null) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var10 = class120.getPacketBufferNode(ClientPacket.field2941, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeShort(id);
					var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			} else {
				Player var16;
				if (opcode == 14) {
					var16 = Client.players[id];
					if (var16 != null) {
						Client.mouseCrossX = canvasX;
						Client.mouseCrossY = canvasY;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = param0;
						Client.destinationY = param1;
						var10 = class120.getPacketBufferNode(ClientPacket.field3018, Client.packetWriter.isaacCipher);
						var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var10.packetBuffer.writeShort(ApproximateRouteStrategy.selectedItemSlot);
						var10.packetBuffer.method7962(id);
						var10.packetBuffer.method7916(GameObject.selectedItemWidget);
						var10.packetBuffer.writeIntME(Canvas.selectedItemId);
						Client.packetWriter.addNode(var10);
					}
				} else if (opcode == 15) {
					var16 = Client.players[id];
					if (var16 != null) {
						Client.mouseCrossX = canvasX;
						Client.mouseCrossY = canvasY;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = param0;
						Client.destinationY = param1;
						var10 = class120.getPacketBufferNode(ClientPacket.field2985, Client.packetWriter.isaacCipher);
						var10.packetBuffer.method7962(id);
						var10.packetBuffer.writeShort(Client.selectedSpellChildIndex);
						var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var10.packetBuffer.method7971(ClanSettings.selectedSpellWidget);
						var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
						Client.packetWriter.addNode(var10);
					}
				} else if (opcode == 16) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field3007, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntME(Canvas.selectedItemId);
					var9.packetBuffer.method8004(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method7961(ApproximateRouteStrategy.selectedItemSlot);
					var9.packetBuffer.writeShort(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.method7961(class128.baseX * 64 + param0);
					var9.packetBuffer.writeIntME(id);
					var9.packetBuffer.writeInt(GameObject.selectedItemWidget);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 17) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field3006, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntME(Client.selectedSpellItemId);
					var9.packetBuffer.writeShort(id);
					var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeInt(ClanSettings.selectedSpellWidget);
					var9.packetBuffer.writeIntME(class128.baseX * 64 + param0);
					var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 18) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field3029, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method7961(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.writeShort(class128.baseX * 64 + param0);
					var9.packetBuffer.writeShort(id);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 19) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field2945, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(id);
					var9.packetBuffer.method8136(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method7961(class128.baseX * 64 + param0);
					var9.packetBuffer.writeShort(WorldMapData_1.baseY * 64 + param1);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 20) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field3026, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method7961(class128.baseX * 64 + param0);
					var9.packetBuffer.method7962(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.writeIntME(id);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 21) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field2954, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method7961(id);
					var9.packetBuffer.method7961(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.writeIntME(class128.baseX * 64 + param0);
					var9.packetBuffer.method8004(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 22) {
					Client.mouseCrossX = canvasX;
					Client.mouseCrossY = canvasY;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var9 = class120.getPacketBufferNode(ClientPacket.field3045, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
					var9.packetBuffer.method7962(id);
					var9.packetBuffer.method8136(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeIntME(class128.baseX * 64 + param0);
					Client.packetWriter.addNode(var9);
				} else if (opcode == 23) {
					if (Client.isMenuOpen) {
						MusicPatchNode.scene.setViewportWalking();
					} else {
						MusicPatchNode.scene.menuOpen(Tiles.Client_plane, param0, param1, true);
					}
				} else {
					PacketBufferNode var11;
					Widget var17;
					if (opcode == 24) {
						var17 = SpotAnimationDefinition.getWidget(param1);
						if (var17 != null) {
							boolean var12 = true;
							if (var17.contentType > 0) {
								var12 = SoundSystem.method817(var17);
							}

							if (var12) {
								var11 = class120.getPacketBufferNode(ClientPacket.field2939, Client.packetWriter.isaacCipher);
								var11.packetBuffer.writeInt(param1);
								Client.packetWriter.addNode(var11);
							}
						}
					} else {
						if (opcode == 25) {
							var17 = JagexCache.getWidgetChild(param1, param0);
							if (var17 != null) {
								class193.Widget_runOnTargetLeave();
								class128.selectSpell(param1, param0, SoundCache.Widget_unpackTargetMask(class97.getWidgetFlags(var17)), itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = class67.Widget_getSpellActionName(var17);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var17.isIf3) {
									Client.selectedSpellName = var17.dataText + SoundCache.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = SoundCache.colorStartTag(65280) + var17.spellName + SoundCache.colorStartTag(16777215);
								}
							}

							return;
						}

						if (opcode == 26) {
							class21.method318();
						} else {
							int var13;
							Widget var15;
							if (opcode == 28) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2939, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeInt(param1);
								Client.packetWriter.addNode(var9);
								var15 = SpotAnimationDefinition.getWidget(param1);
								if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
									var13 = var15.cs1Instructions[0][1];
									Varps.Varps_main[var13] = 1 - Varps.Varps_main[var13];
									class269.changeGameOptions(var13);
								}
							} else if (opcode == 29) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2939, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeInt(param1);
								Client.packetWriter.addNode(var9);
								var15 = SpotAnimationDefinition.getWidget(param1);
								if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
									var13 = var15.cs1Instructions[0][1];
									if (Varps.Varps_main[var13] != var15.cs1ComparisonValues[0]) {
										Varps.Varps_main[var13] = var15.cs1ComparisonValues[0];
										class269.changeGameOptions(var13);
									}
								}
							} else if (opcode == 30) {
								if (Client.meslayerContinueWidget == null) {
									class425.resumePauseWidget(param1, param0);
									Client.meslayerContinueWidget = JagexCache.getWidgetChild(param1, param0);
									class403.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (opcode == 31) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2980, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeInt(param1);
								var9.packetBuffer.writeShort(ApproximateRouteStrategy.selectedItemSlot);
								var9.packetBuffer.method7961(Canvas.selectedItemId);
								var9.packetBuffer.method7971(GameObject.selectedItemWidget);
								var9.packetBuffer.writeIntME(param0);
								var9.packetBuffer.writeShort(itemId);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 32) {
								var9 = class120.getPacketBufferNode(ClientPacket.field3038, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeInt(ClanSettings.selectedSpellWidget);
								var9.packetBuffer.writeIntME(param0);
								var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
								var9.packetBuffer.method7971(param1);
								var9.packetBuffer.writeIntME(itemId);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 33) {
								var9 = class120.getPacketBufferNode(ClientPacket.field3001, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeIntME(itemId);
								var9.packetBuffer.method7972(param1);
								var9.packetBuffer.writeShort(param0);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 34) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2970, Client.packetWriter.isaacCipher);
								var9.packetBuffer.method7971(param1);
								var9.packetBuffer.method7961(param0);
								var9.packetBuffer.method7962(itemId);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 35) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2993, Client.packetWriter.isaacCipher);
								var9.packetBuffer.method7961(itemId);
								var9.packetBuffer.method7972(param1);
								var9.packetBuffer.method7962(param0);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 36) {
								var9 = class120.getPacketBufferNode(ClientPacket.field2992, Client.packetWriter.isaacCipher);
								var9.packetBuffer.writeShort(param0);
								var9.packetBuffer.method7962(itemId);
								var9.packetBuffer.method7916(param1);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else if (opcode == 37) {
								var9 = class120.getPacketBufferNode(ClientPacket.field3043, Client.packetWriter.isaacCipher);
								var9.packetBuffer.method7961(param0);
								var9.packetBuffer.method7972(param1);
								var9.packetBuffer.method7961(itemId);
								Client.packetWriter.addNode(var9);
								Client.field609 = 0;
								DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
								Client.field635 = param0;
							} else {
								if (opcode == 38) {
									class193.Widget_runOnTargetLeave();
									var17 = SpotAnimationDefinition.getWidget(param1);
									Client.isItemSelected = 1;
									ApproximateRouteStrategy.selectedItemSlot = param0;
									GameObject.selectedItemWidget = param1;
									Canvas.selectedItemId = itemId;
									class403.invalidateWidget(var17);
									Client.selectedItemName = SoundCache.colorStartTag(16748608) + UserComparator3.ItemDefinition_get(itemId).name + SoundCache.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (opcode == 39) {
									var9 = class120.getPacketBufferNode(ClientPacket.field3028, Client.packetWriter.isaacCipher);
									var9.packetBuffer.method7961(itemId);
									var9.packetBuffer.method7962(param0);
									var9.packetBuffer.writeInt(param1);
									Client.packetWriter.addNode(var9);
									Client.field609 = 0;
									DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
									Client.field635 = param0;
								} else if (opcode == 40) {
									var9 = class120.getPacketBufferNode(ClientPacket.field3019, Client.packetWriter.isaacCipher);
									var9.packetBuffer.writeInt(param1);
									var9.packetBuffer.method7962(param0);
									var9.packetBuffer.method7962(itemId);
									Client.packetWriter.addNode(var9);
									Client.field609 = 0;
									DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
									Client.field635 = param0;
								} else if (opcode == 41) {
									var9 = class120.getPacketBufferNode(ClientPacket.field3040, Client.packetWriter.isaacCipher);
									var9.packetBuffer.writeInt(param1);
									var9.packetBuffer.writeIntME(param0);
									var9.packetBuffer.writeIntME(itemId);
									Client.packetWriter.addNode(var9);
									Client.field609 = 0;
									DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
									Client.field635 = param0;
								} else if (opcode == 42) {
									var9 = class120.getPacketBufferNode(ClientPacket.field2999, Client.packetWriter.isaacCipher);
									var9.packetBuffer.writeInt(param1);
									var9.packetBuffer.writeShort(param0);
									var9.packetBuffer.writeIntME(itemId);
									Client.packetWriter.addNode(var9);
									Client.field609 = 0;
									DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
									Client.field635 = param0;
								} else if (opcode == 43) {
									var9 = class120.getPacketBufferNode(ClientPacket.field3032, Client.packetWriter.isaacCipher);
									var9.packetBuffer.method7962(param0);
									var9.packetBuffer.method7961(itemId);
									var9.packetBuffer.method7971(param1);
									Client.packetWriter.addNode(var9);
									Client.field609 = 0;
									DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
									Client.field635 = param0;
								} else if (opcode == 44) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field3011, Client.packetWriter.isaacCipher);
										var10.packetBuffer.writeShort(id);
										var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 45) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2981, Client.packetWriter.isaacCipher);
										var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var10.packetBuffer.writeIntME(id);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 46) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2963, Client.packetWriter.isaacCipher);
										var10.packetBuffer.method8136(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var10.packetBuffer.method7962(id);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 47) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2975, Client.packetWriter.isaacCipher);
										var10.packetBuffer.method7961(id);
										var10.packetBuffer.method8004(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 48) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2984, Client.packetWriter.isaacCipher);
										var10.packetBuffer.writeIntME(id);
										var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 49) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2973, Client.packetWriter.isaacCipher);
										var10.packetBuffer.method8004(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var10.packetBuffer.method7962(id);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 50) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2997, Client.packetWriter.isaacCipher);
										var10.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var10.packetBuffer.writeIntME(id);
										Client.packetWriter.addNode(var10);
									}
								} else if (opcode == 51) {
									var16 = Client.players[id];
									if (var16 != null) {
										Client.mouseCrossX = canvasX;
										Client.mouseCrossY = canvasY;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = param0;
										Client.destinationY = param1;
										var10 = class120.getPacketBufferNode(ClientPacket.field2988, Client.packetWriter.isaacCipher);
										var10.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var10.packetBuffer.writeIntME(id);
										Client.packetWriter.addNode(var10);
									}
								} else {
									label666: {
										if (opcode != 57) {
											if (opcode == 58) {
												var17 = JagexCache.getWidgetChild(param1, param0);
												if (var17 != null) {
													if (var17.field3506 != null) {
														ScriptEvent var19 = new ScriptEvent();
														var19.widget = var17;
														var19.opIndex = id;
														var19.targetName = var6;
														var19.args = var17.field3506;
														class348.runScriptEvent(var19);
													}

													var10 = class120.getPacketBufferNode(ClientPacket.field2987, Client.packetWriter.isaacCipher);
													var10.packetBuffer.writeShort(param0);
													var10.packetBuffer.method7916(ClanSettings.selectedSpellWidget);
													var10.packetBuffer.method7961(Client.selectedSpellChildIndex);
													var10.packetBuffer.method7971(param1);
													var10.packetBuffer.writeShort(Client.selectedSpellItemId);
													var10.packetBuffer.method7961(itemId);
													Client.packetWriter.addNode(var10);
												}
												break label666;
											}

											if (opcode == 1001) {
												Client.mouseCrossX = canvasX;
												Client.mouseCrossY = canvasY;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = param0;
												Client.destinationY = param1;
												var9 = class120.getPacketBufferNode(ClientPacket.field2971, Client.packetWriter.isaacCipher);
												var9.packetBuffer.method7962(id);
												var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
												var9.packetBuffer.method7961(class128.baseX * 64 + param0);
												var9.packetBuffer.method7952(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												Client.packetWriter.addNode(var9);
												break label666;
											}

											if (opcode == 1002) {
												Client.mouseCrossX = canvasX;
												Client.mouseCrossY = canvasY;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var9 = class120.getPacketBufferNode(ClientPacket.field2996, Client.packetWriter.isaacCipher);
												var9.packetBuffer.writeShort(id);
												Client.packetWriter.addNode(var9);
												break label666;
											}

											if (opcode == 1003) {
												Client.mouseCrossX = canvasX;
												Client.mouseCrossY = canvasY;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var14 = Client.npcs[id];
												if (var14 != null) {
													NPCComposition var18 = var14.definition;
													if (var18.transforms != null) {
														var18 = var18.transform();
													}

													if (var18 != null) {
														var11 = class120.getPacketBufferNode(ClientPacket.field3035, Client.packetWriter.isaacCipher);
														var11.packetBuffer.method7962(var18.id);
														Client.packetWriter.addNode(var11);
													}
												}
												break label666;
											}

											if (opcode == 1004) {
												Client.mouseCrossX = canvasX;
												Client.mouseCrossY = canvasY;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var9 = class120.getPacketBufferNode(ClientPacket.field2937, Client.packetWriter.isaacCipher);
												var9.packetBuffer.writeShort(id);
												var9.packetBuffer.writeShort(class128.baseX * 64 + param0);
												var9.packetBuffer.writeIntME(WorldMapData_1.baseY * 64 + param1);
												Client.packetWriter.addNode(var9);
												break label666;
											}

											if (opcode == 1005) {
												var17 = SpotAnimationDefinition.getWidget(param1);
												if (var17 != null && var17.itemQuantities[param0] >= 100000) {
													class65.addGameMessage(27, "", var17.itemQuantities[param0] + " x " + UserComparator3.ItemDefinition_get(itemId).name);
												} else {
													var10 = class120.getPacketBufferNode(ClientPacket.field2979, Client.packetWriter.isaacCipher);
													var10.packetBuffer.method7962(itemId);
													Client.packetWriter.addNode(var10);
												}

												Client.field609 = 0;
												DevicePcmPlayerProvider.field153 = SpotAnimationDefinition.getWidget(param1);
												Client.field635 = param0;
												break label666;
											}

											if (opcode != 1007) {
												if (opcode == 1011 || opcode == 1010 || opcode == 1008 || opcode == 1009 || opcode == 1012) {
													Decimator.worldMap.worldMapMenuAction(opcode, id, new Coord(param0), new Coord(param1));
												}
												break label666;
											}
										}

										var17 = JagexCache.getWidgetChild(param1, param0);
										if (var17 != null) {
											ApproximateRouteStrategy.widgetDefaultMenuAction(id, param1, param0, itemId, var6);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (Client.isItemSelected != 0) {
			Client.isItemSelected = 0;
			class403.invalidateWidget(SpotAnimationDefinition.getWidget(GameObject.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			class193.Widget_runOnTargetLeave();
		}

		if (DevicePcmPlayerProvider.field153 != null && Client.field609 == 0) {
			class403.invalidateWidget(DevicePcmPlayerProvider.field153);
		}

	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		descriptor = "([Lkw;IIIIIIIB)V",
		garbageValue = "-5"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (var9.method5784() || class97.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
				if (var9.isIf3) {
					if (class11.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != class148.mousedOverWidgetIf1 && class11.isComponentHidden(var9)) {
					continue;
				}

				if (var9.type == 11 && var9.method5827(Messages.urlRequester)) {
					if (var9.method5790()) {
						class403.invalidateWidget(var9);
						StructComposition.revalidateWidgetScroll(var9.children, var9, true);
					}

					if (var9.field3522 != null) {
						ScriptEvent var10 = new ScriptEvent();
						var10.widget = var9;
						var10.args = var9.field3522;
						Client.scriptEvents.addFirst(var10);
					}
				}

				int var26 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var17;
				int var18;
				if (var9.type == 2) {
					var12 = var2;
					var13 = var3;
					var14 = var4;
					var15 = var5;
				} else {
					int var16;
					if (var9.type == 9) {
						var16 = var26;
						var17 = var11;
						var18 = var26 + var9.width;
						int var19 = var11 + var9.height;
						if (var18 < var26) {
							var16 = var18;
							var18 = var26;
						}

						if (var19 < var11) {
							var17 = var19;
							var19 = var11;
						}

						++var18;
						++var19;
						var12 = var16 > var2 ? var16 : var2;
						var13 = var17 > var3 ? var17 : var3;
						var14 = var18 < var4 ? var18 : var4;
						var15 = var19 < var5 ? var19 : var5;
					} else {
						var16 = var26 + var9.width;
						var17 = var11 + var9.height;
						var12 = var26 > var2 ? var26 : var2;
						var13 = var11 > var3 ? var11 : var3;
						var14 = var16 < var4 ? var16 : var4;
						var15 = var17 < var5 ? var17 : var5;
					}
				}

				if (var9 == Client.clickedWidget) {
					Client.field686 = true;
					Client.field687 = var26;
					Client.field688 = var11;
				}

				boolean var34 = false;
				if (var9.field3395) {
					switch(Client.field593) {
					case 0:
						var34 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field668 == var9.id >>> 16) {
							var34 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field668) {
							var34 = true;
						}
					}
				}

				if (var34 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var27;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
									if (var27.isMouseInputEvent) {
										var27.remove();
										var27.widget.containsMouse = false;
									}
								}

								if (class259.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									FloorOverlayDefinition.addCancelMenuEntry();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var27.isMouseInputEvent && var27.widget.onScroll == var27.args) {
									var27.remove();
								}
							}
						}
					}

					var17 = MouseHandler.MouseHandler_x;
					var18 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var17 = MouseHandler.MouseHandler_lastPressedX;
						var18 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var35 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var35) {
							UserComparator6.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						BufferedSource.checkIfMinimapClicked(var9, var26, var11);
					} else {
						if (var9.contentType == 1400) {
							Decimator.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var35) {
							if (var9.contentType == 1400) {
								Decimator.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
							} else {
								TaskHandler.Widget_addToMenu(var9, var17 - var26, var18 - var11);
							}
						}

						boolean var21;
						int var29;
						if (var34) {
							for (int var20 = 0; var20 < var9.field3464.length; ++var20) {
								var21 = false;
								boolean var28 = false;
								if (!var21 && var9.field3464[var20] != null) {
									for (var29 = 0; var29 < var9.field3464[var20].length; ++var29) {
										boolean var24 = false;
										if (var9.field3544 != null) {
											var24 = KeyHandler.KeyHandler_pressedKeys[var9.field3464[var20][var29]];
										}

										if (UserComparator6.method2800(var9.field3464[var20][var29]) || var24) {
											var21 = true;
											if (var9.field3544 != null && var9.field3544[var20] > Client.cycle) {
												break;
											}

											byte var33 = var9.field3475[var20][var29];
											if (var33 == 0 || ((var33 & 8) == 0 || !KeyHandler.KeyHandler_pressedKeys[86] && !KeyHandler.KeyHandler_pressedKeys[82] && !KeyHandler.KeyHandler_pressedKeys[81]) && ((var33 & 2) == 0 || KeyHandler.KeyHandler_pressedKeys[86]) && ((var33 & 1) == 0 || KeyHandler.KeyHandler_pressedKeys[82]) && ((var33 & 4) == 0 || KeyHandler.KeyHandler_pressedKeys[81])) {
												var28 = true;
												break;
											}
										}
									}
								}

								if (var28) {
									if (var20 < 10) {
										ApproximateRouteStrategy.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										class193.Widget_runOnTargetLeave();
										class128.selectSpell(var9.id, var9.childIndex, SoundCache.Widget_unpackTargetMask(class97.getWidgetFlags(var9)), var9.itemId);
										Client.selectedSpellActionName = class67.Widget_getSpellActionName(var9);
										if (Client.selectedSpellActionName == null) {
											Client.selectedSpellActionName = "null";
										}

										Client.selectedSpellName = var9.dataText + SoundCache.colorStartTag(16777215);
									}

									var29 = var9.field3417[var20];
									if (var9.field3544 == null) {
										var9.field3544 = new int[var9.field3464.length];
									}

									if (var9.field3477 == null) {
										var9.field3477 = new int[var9.field3464.length];
									}

									if (var29 != 0) {
										if (var9.field3544[var20] == 0) {
											var9.field3544[var20] = var29 + Client.cycle + var9.field3477[var20];
										} else {
											var9.field3544[var20] = var29 + Client.cycle;
										}
									} else {
										var9.field3544[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field3544 != null) {
									var9.field3544[var20] = 0;
								}
							}
						}

						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var35 = true;
							} else {
								var35 = false;
							}

							boolean var36 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
								var36 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							int[] var22;
							if (var21) {
								AbstractByteArrayCopier.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
								if (var9.type == 11 && var9.method5789(MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY, var6, var7)) {
									switch(var9.method5817()) {
									case 0:
										CollisionMap.openURL(var9.method5815(), true, false);
										break;
									case 1:
										if (ItemComposition.method3909(class97.getWidgetFlags(var9))) {
											var22 = var9.method5835();
											if (var22 != null) {
												PacketBufferNode var23 = class120.getPacketBufferNode(ClientPacket.field2994, Client.packetWriter.isaacCipher);
												var23.packetBuffer.method7916(var22[0]);
												var23.packetBuffer.method7971(var9.id);
												var23.packetBuffer.method7916(var22[1]);
												var23.packetBuffer.writeShort(var9.childIndex);
												var23.packetBuffer.method7916(var22[2]);
												var23.packetBuffer.method7916(var9.method5839());
												Client.packetWriter.addNode(var23);
											}
										}
									}
								}
							}

							if (var9.contentType == 1400) {
								Decimator.worldMap.method7391(var17, var18, var35 & var36, var35 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && HealthBarDefinition.method3606(class97.getWidgetFlags(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field683 = true;
								Client.field783 = var26;
								Client.field744 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var37;
								if (var35 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var37 = new ScriptEvent();
									var37.isMouseInputEvent = true;
									var37.widget = var9;
									var37.mouseY = Client.mouseWheelRotation;
									var37.args = var9.onScroll;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.clickedWidget != null || User.dragInventoryWidget != null || Client.isMenuOpen) {
									var21 = false;
									var36 = false;
									var35 = false;
								}

								if (!var9.isClicked && var21) {
									var9.isClicked = true;
									if (var9.onClick != null) {
										var37 = new ScriptEvent();
										var37.isMouseInputEvent = true;
										var37.widget = var9;
										var37.mouseX = MouseHandler.MouseHandler_lastPressedX - var26;
										var37.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var37.args = var9.onClick;
										Client.scriptEvents.addFirst(var37);
									}
								}

								if (var9.isClicked && var36 && var9.onClickRepeat != null) {
									var37 = new ScriptEvent();
									var37.isMouseInputEvent = true;
									var37.widget = var9;
									var37.mouseX = MouseHandler.MouseHandler_x - var26;
									var37.mouseY = MouseHandler.MouseHandler_y - var11;
									var37.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var37);
								}

								if (var9.isClicked && !var36) {
									var9.isClicked = false;
									if (var9.onRelease != null) {
										var37 = new ScriptEvent();
										var37.isMouseInputEvent = true;
										var37.widget = var9;
										var37.mouseX = MouseHandler.MouseHandler_x - var26;
										var37.mouseY = MouseHandler.MouseHandler_y - var11;
										var37.args = var9.onRelease;
										Client.field626.addFirst(var37);
									}
								}

								if (var36 && var9.onHold != null) {
									var37 = new ScriptEvent();
									var37.isMouseInputEvent = true;
									var37.widget = var9;
									var37.mouseX = MouseHandler.MouseHandler_x - var26;
									var37.mouseY = MouseHandler.MouseHandler_y - var11;
									var37.args = var9.onHold;
									Client.scriptEvents.addFirst(var37);
								}

								if (!var9.containsMouse && var35) {
									var9.containsMouse = true;
									if (var9.onMouseOver != null) {
										var37 = new ScriptEvent();
										var37.isMouseInputEvent = true;
										var37.widget = var9;
										var37.mouseX = MouseHandler.MouseHandler_x - var26;
										var37.mouseY = MouseHandler.MouseHandler_y - var11;
										var37.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var37);
									}
								}

								if (var9.containsMouse && var35 && var9.onMouseRepeat != null) {
									var37 = new ScriptEvent();
									var37.isMouseInputEvent = true;
									var37.widget = var9;
									var37.mouseX = MouseHandler.MouseHandler_x - var26;
									var37.mouseY = MouseHandler.MouseHandler_y - var11;
									var37.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var37);
								}

								if (var9.containsMouse && !var35) {
									var9.containsMouse = false;
									if (var9.onMouseLeave != null) {
										var37 = new ScriptEvent();
										var37.isMouseInputEvent = true;
										var37.widget = var9;
										var37.mouseX = MouseHandler.MouseHandler_x - var26;
										var37.mouseY = MouseHandler.MouseHandler_y - var11;
										var37.args = var9.onMouseLeave;
										Client.field626.addFirst(var37);
									}
								}

								if (var9.onTimer != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onTimer;
									Client.field709.addFirst(var37);
								}

								ScriptEvent var25;
								int var39;
								int var40;
								if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field3539) {
									if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field3539 <= 32) {
										label834:
										for (var40 = var9.field3539; var40 < Client.changedVarpCount; ++var40) {
											var29 = Client.changedVarps[var40 & 31];

											for (var39 = 0; var39 < var9.varTransmitTriggers.length; ++var39) {
												if (var29 == var9.varTransmitTriggers[var39]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var25);
													break label834;
												}
											}
										}
									} else {
										var37 = new ScriptEvent();
										var37.widget = var9;
										var37.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var37);
									}

									var9.field3539 = Client.changedVarpCount;
								}

								if (var9.onInvTransmit != null && Client.field694 > var9.field3540) {
									if (var9.invTransmitTriggers != null && Client.field694 - var9.field3540 <= 32) {
										label810:
										for (var40 = var9.field3540; var40 < Client.field694; ++var40) {
											var29 = Client.changedItemContainers[var40 & 31];

											for (var39 = 0; var39 < var9.invTransmitTriggers.length; ++var39) {
												if (var29 == var9.invTransmitTriggers[var39]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var25);
													break label810;
												}
											}
										}
									} else {
										var37 = new ScriptEvent();
										var37.widget = var9;
										var37.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var37);
									}

									var9.field3540 = Client.field694;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field3541) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field3541 <= 32) {
										label786:
										for (var40 = var9.field3541; var40 < Client.changedSkillsCount; ++var40) {
											var29 = Client.changedSkills[var40 & 31];

											for (var39 = 0; var39 < var9.statTransmitTriggers.length; ++var39) {
												if (var29 == var9.statTransmitTriggers[var39]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var25);
													break label786;
												}
											}
										}
									} else {
										var37 = new ScriptEvent();
										var37.widget = var9;
										var37.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var37);
									}

									var9.field3541 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field3538 && var9.onChatTransmit != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field700 > var9.field3538 && var9.onFriendTransmit != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field701 > var9.field3538 && var9.onClanTransmit != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field702 > var9.field3538 && var9.field3526 != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.field3526;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field745 > var9.field3538 && var9.field3431 != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.field3431;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field704 > var9.field3538 && var9.onStockTransmit != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field705 > var9.field3538 && var9.field3452 != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.field3452;
									Client.scriptEvents.addFirst(var37);
								}

								if (Client.field706 > var9.field3538 && var9.onMiscTransmit != null) {
									var37 = new ScriptEvent();
									var37.widget = var9;
									var37.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var37);
								}

								var9.field3538 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var40 = 0; var40 < Client.field529; ++var40) {
										ScriptEvent var38 = new ScriptEvent();
										var38.widget = var9;
										var38.keyTyped = Client.field749[var40];
										var38.keyPressed = Client.field731[var40];
										var38.args = var9.onKey;
										Client.scriptEvents.addFirst(var38);
									}
								}

								ScriptEvent var32;
								if (var9.field3528 != null) {
									var22 = VerticalAlignment.method3664();

									for (var29 = 0; var29 < var22.length; ++var29) {
										var32 = new ScriptEvent();
										var32.widget = var9;
										var32.keyTyped = var22[var29];
										var32.args = var9.field3528;
										Client.scriptEvents.addFirst(var32);
									}
								}

								if (var9.field3511 != null) {
									var22 = ClientPacket.method5341();

									for (var29 = 0; var29 < var22.length; ++var29) {
										var32 = new ScriptEvent();
										var32.widget = var9;
										var32.keyTyped = var22[var29];
										var32.args = var9.field3511;
										Client.scriptEvents.addFirst(var32);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || User.dragInventoryWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									class148.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									class148.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								GrandExchangeEvent.field4105 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								class10.method110(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var30 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var30 != null) {
								if (var30.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var31 = (ScriptEvent)Client.scriptEvents.last(); var31 != null; var31 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var31.isMouseInputEvent) {
											var31.remove();
											var31.widget.containsMouse = false;
										}
									}

									if (class259.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										FloorOverlayDefinition.addCancelMenuEntry();
									}
								}

								class259.updateRootInterface(var30.group, var12, var13, var14, var15, var26, var11);
							}
						}
					}
				}
			}
		}

	}
}
