import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qq")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	final LoginType field3781;

	@ObfuscatedSignature(
		descriptor = "(Lsl;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400);
		this.field3781 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Lqs;",
		garbageValue = "-1997275235"
	)
	@Export("newInstance")
	User newInstance() {
		return new Ignored();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)[Lqs;",
		garbageValue = "99"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new Ignored[var1];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ltm;II)V",
		garbageValue = "974375681"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		while (var1.offset < var2) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 4) {
				Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.field3781);
				if (!var4.hasCleanName()) {
					throw new IllegalStateException();
				}

				boolean var5 = false;
				class299.friendSystem.removeIgnore(var4.getName(), var5);
			} else {
				boolean var9 = (var3 & 1) != 0;
				Username var10 = new Username(var1.readStringCp1252NullTerminated(), this.field3781);
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.field3781);
				var1.readStringCp1252NullTerminated();
				if (!var10.hasCleanName()) {
					throw new IllegalStateException();
				}

				Ignored var7 = (Ignored)this.getByCurrentUsername(var10);
				if (var9) {
					Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
					if (var8 != null && var7 != var8) {
						if (var7 != null) {
							this.remove(var8);
						} else {
							var7 = var8;
						}
					}
				}

				if (var7 != null) {
					this.changeName(var7, var10, var6);
				} else if (this.getSize() < 400) {
					int var11 = this.getSize();
					var7 = (Ignored)this.addLast(var10, var6);
					var7.id = var11;
				}
			}
		}

	}

	@ObfuscatedName("lm")
	@ObfuscatedSignature(
		descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "5"
	)
	@Export("menuAction")
	static final void menuAction(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		NPC var9;
		PacketBufferNode var10;
		if (var2 == 9) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC1, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var10.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 12) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC4, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}
		}

		Player var14;
		if (var2 == 45) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER2, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAddLE(var3);
				var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 47) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAdd(var3);
				var10.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		Widget var15;
		if (var2 == 57 || var2 == 1007) {
			var15 = SoundCache.getWidgetChild(var1, var0);
			if (var15 != null) {
				class47.widgetDefaultMenuAction(var3, var1, var0, var4, var6);
			}
		}

		PacketBufferNode var16;
		if (var2 == 19) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJ2, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			var16.packetBuffer.writeShortAddLE(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeIntME(var3);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 1) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOCT, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAdd(class157.field1406);
			var16.packetBuffer.writeInt(class138.field1306);
			var16.packetBuffer.writeShort(WorldMapArea.field2343);
			var16.packetBuffer.writeShortAddLE(var3);
			var16.packetBuffer.writeShortAdd(class47.baseY + var1);
			var16.packetBuffer.writeShortAdd(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 13) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC5, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var10.packetBuffer.writeIntME(var3);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 14) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPCU, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeIntLE(class138.field1306);
				var10.packetBuffer.writeShortAdd(class157.field1406);
				var10.packetBuffer.writeShortAdd(WorldMapArea.field2343);
				var10.packetBuffer.writeShortAdd(var3);
				var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 1002) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOCE, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAddLE(var3);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 10) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC2, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var10.packetBuffer.writeIntME(var3);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 1001) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC5, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAddLE(class47.baseY + var1);
			var16.packetBuffer.writeIntME(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAdd(var3);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 26) {
			WorldMapIcon_1.method1402();
		}

		if (var2 == 8) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPCT, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var10.packetBuffer.writeShortAdd(var3);
				var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
				var10.packetBuffer.writeIntIME(ModeWhere.selectedSpellWidget);
				var10.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 18) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJ1, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAdd(var3);
			var16.packetBuffer.writeShortAddLE(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 23) {
			if (Client.isMenuOpen) {
				class130.scene.setViewportWalking();
			} else {
				class130.scene.menuOpen(HealthBar.Client_plane, var0, var1, true);
			}
		}

		PacketBufferNode var11;
		if (var2 == 24) {
			var15 = class92.getWidget(var1);
			if (var15 != null) {
				boolean var12 = true;
				if (var15.contentType > 0) {
					var12 = Bounds.method2290(var15);
				}

				if (var12) {
					var11 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2567, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeInt(var1);
					Client.packetWriter.addNode(var11);
				}
			}
		}

		if (var2 == 11) {
			var9 = Client.npcs[var3];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC3, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAddLE(var3);
				var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 49) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAdd(var3);
				var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 16) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.EXIT_FREECAM, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAddLE(class157.field1406);
			var16.packetBuffer.writeIntME(var3);
			var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAdd(WorldMapArea.field2343);
			var16.packetBuffer.writeIntME(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShortAdd(class47.baseY + var1);
			var16.packetBuffer.writeIntIME_(class138.field1306);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 2) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC6, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAddLE(var3);
			var16.packetBuffer.writeShortAdd(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			var16.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
			var16.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAddLE(Client.selectedSpellItemId);
			var16.packetBuffer.writeIntLE(ModeWhere.selectedSpellWidget);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
			Canvas.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
		}

		if (var2 == 6) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC4, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAdd(var3);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAdd(class47.baseY + var1);
			var16.packetBuffer.writeIntLE(var0 + UrlRequester.baseX);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 21) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJ4, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeIntME(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShortAdd(class47.baseY + var1);
			var16.packetBuffer.writeIntME(var3);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 30 && Client.meslayerContinueWidget == null) {
			class466.resumePauseWidget(var1, var0);
			Client.meslayerContinueWidget = SoundCache.getWidgetChild(var1, var0);
			class218.invalidateWidget(Client.meslayerContinueWidget);
		}

		if (var2 == 15) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYERT, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex);
				var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
				var10.packetBuffer.writeIntIME(ModeWhere.selectedSpellWidget);
				var10.packetBuffer.writeIntME(var3);
				var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		int var13;
		Widget var17;
		if (var2 == 28) {
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2567, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var16);
			var17 = class92.getWidget(var1);
			if (var17 != null && var17.cs1Instructions != null && var17.cs1Instructions[0][0] == 5) {
				var13 = var17.cs1Instructions[0][1];
				Varps.Varps_main[var13] = 1 - Varps.Varps_main[var13];
				WorldMapDecoration.changeGameOptions(var13);
			}
		}

		if (var2 == 48) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER5, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAdd(var3);
				var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 4) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC2, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShort(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			var16.packetBuffer.writeIntME(var3);
			var16.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 29) {
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2567, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var16);
			var17 = class92.getWidget(var1);
			if (var17 != null && var17.cs1Instructions != null && var17.cs1Instructions[0][0] == 5) {
				var13 = var17.cs1Instructions[0][1];
				if (Varps.Varps_main[var13] != var17.cs1ComparisonValues[0]) {
					Varps.Varps_main[var13] = var17.cs1ComparisonValues[0];
					WorldMapDecoration.changeGameOptions(var13);
				}
			}
		}

		if (var2 == 1003) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var9 = Client.npcs[var3];
			if (var9 != null) {
				NPCComposition var18 = var9.definition;
				if (var18.transforms != null) {
					var18 = var18.transform();
				}

				if (var18 != null) {
					var11 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPCE, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShortAdd(var18.id);
					Client.packetWriter.addNode(var11);
				}
			}
		}

		if (var2 == 44) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAddLE(var3);
				var10.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 1004) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJE, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShort(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShortAddLE(var3);
			var16.packetBuffer.writeIntME(class47.baseY + var1);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 46) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER3, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeByte(var3);
				var10.packetBuffer.writeShort(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 22) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJ5, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAddLE(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShort(var3);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 58) {
			var15 = SoundCache.getWidgetChild(var1, var0);
			if (var15 != null) {
				if (var15.field3076 != null) {
					ScriptEvent var19 = new ScriptEvent();
					var19.widget = var15;
					var19.opIndex = var3;
					var19.targetName = var6;
					var19.args = var15.field3076;
					WorldMapSection1.runScriptEvent(var19);
				}

				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.IF_BUTTONT, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeShortAdd(Client.selectedSpellItemId);
				var10.packetBuffer.writeShort(var0);
				var10.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
				var10.packetBuffer.writeShort(var4);
				var10.packetBuffer.writeIntIME(ModeWhere.selectedSpellWidget);
				var10.packetBuffer.writeIntIME_(var1);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 5) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC3, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShort(var3);
			var16.packetBuffer.writeShortAddLE(var0 + UrlRequester.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShort(class47.baseY + var1);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 50) {
			var14 = Client.players[var3];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeIntME(var3);
				var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var10);
			}
		}

		if (var2 == 25) {
			var15 = SoundCache.getWidgetChild(var1, var0);
			if (var15 != null) {
				InvDefinition.Widget_runOnTargetLeave();
				DirectByteArrayCopier.selectSpell(var1, var0, HealthBarDefinition.Widget_unpackTargetMask(NewShit.getWidgetFlags(var15)), var4);
				Client.isItemSelected = 0;
				Client.field600 = class300.Widget_getSpellActionName(var15);
				if (Client.field600 == null) {
					Client.field600 = "null";
				}

				if (var15.isIf3) {
					Client.field601 = var15.dataText + MoveSpeed.colorStartTag(16777215);
				} else {
					Client.field601 = MoveSpeed.colorStartTag(65280) + var15.field3097 + MoveSpeed.colorStartTag(16777215);
				}
			}

		} else {
			if (var2 == 17) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPOBJT, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeIntME(var0 + UrlRequester.baseX);
				var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortAdd(Client.selectedSpellItemId);
				var16.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
				var16.packetBuffer.writeIntIME(ModeWhere.selectedSpellWidget);
				var16.packetBuffer.writeShortAdd(class47.baseY + var1);
				var16.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 20) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPNPC6, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeIntME(class47.baseY + var1);
				var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortAddLE(var3);
				var16.packetBuffer.writeIntME(var0 + UrlRequester.baseX);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 3) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var16 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPLOC1, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShort(var0 + UrlRequester.baseX);
				var16.packetBuffer.writeIntME(class47.baseY + var1);
				var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortAddLE(var3);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 51) {
				var14 = Client.players[var3];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYER8, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var10.packetBuffer.writeShortAdd(var3);
					Client.packetWriter.addNode(var10);
				}
			}

			if (var2 == 7) {
				var9 = Client.npcs[var3];
				if (var9 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var10 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.OPPLAYERU, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(WorldMapArea.field2343);
					var10.packetBuffer.writeIntME(class157.field1406);
					var10.packetBuffer.writeIntLE(class138.field1306);
					var10.packetBuffer.writeIntME(var3);
					var10.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					Client.packetWriter.addNode(var10);
				}
			}

			if (Client.isItemSelected != 0) {
				Client.isItemSelected = 0;
				class218.invalidateWidget(class92.getWidget(class138.field1306));
			}

			if (Client.isSpellSelected) {
				InvDefinition.Widget_runOnTargetLeave();
			}

		}
	}

	@ObfuscatedName("oq")
	@ObfuscatedSignature(
		descriptor = "(IS)Ltx;",
		garbageValue = "-11165"
	)
	static class506 method2190(int var0) {
		class506 var1 = (class506)Client.Widget_cachedFonts.get((long)var0);
		if (var1 == null) {
			var1 = new class506(class343.field3148, var0);
		}

		return var1;
	}
}