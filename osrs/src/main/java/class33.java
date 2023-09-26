import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class33 {
	@ObfuscatedName("ay")
	public static short[][] field87;
	@ObfuscatedName("eu")
	@ObfuscatedSignature(
		descriptor = "Lnt;"
	)
	static WidgetDefinition field89;
	@ObfuscatedName("rv")
	@ObfuscatedSignature(
		descriptor = "Lek;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("ar")
	int field91;
	@ObfuscatedName("ab")
	int field90;

	class33(int var1, int var2) {
		this.field91 = var1;
		this.field90 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lbd;I)Z",
		garbageValue = "-114567882"
	)
	boolean method133(class29 var1) {
		if (var1 == null) {
			return false;
		} else {
			switch(this.field91) {
			case 1:
				return var1.vmethod3949(this.field90);
			case 2:
				return var1.vmethod3989(this.field90);
			case 3:
				return var1.vmethod3951((char)this.field90);
			case 4:
				return var1.vmethod3953(this.field90 == 1);
			default:
				return false;
			}
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIII)Lud;",
		garbageValue = "1018953264"
	)
	static SpritePixels method134(int var0, int var1, int var2) {
		DemotingHashTable var3 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var4 = (long)(var2 << 16 | var0 << 8 | var1);
		return (SpritePixels)var3.get(var4);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "973188034"
	)
	public static void method135() {
		WorldMapElement.HitSplatDefinition_cached.clear();
	}

	@ObfuscatedName("ll")
	@ObfuscatedSignature(
		descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "102"
	)
	@Export("menuAction")
	static final void menuAction(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		PacketBufferNode var9;
		if (var2 == 16) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.f97, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(Actor.field958);
			var9.packetBuffer.writeShortLE(var3);
			var9.packetBuffer.writeIntME(class4.field2);
			var9.packetBuffer.writeShortAdd(var0 + class20.baseX);
			var9.packetBuffer.writeShort(class129.field1205);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortLE(class19.baseY + var1);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
			class434.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
		}

		Widget var10;
		int var11;
		if (var2 == 28) {
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.WIDGET_TYPE, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var9);
			var10 = field89.method1740(var1);
			if (var10 != null && var10.cs1Instructions != null && var10.cs1Instructions[0][0] == 5) {
				var11 = var10.cs1Instructions[0][1];
				Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
				ScriptEvent.changeGameOptions(var11);
			}
		}

		if (var2 == 4) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOC2, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var3);
			var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortAdd(var0 + class20.baseX);
			var9.packetBuffer.writeShortLE(class19.baseY + var1);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 1) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.field2534, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeIntIME(class4.field2);
			var9.packetBuffer.writeShortLE(var0 + class20.baseX);
			var9.packetBuffer.writeShort(Actor.field958);
			var9.packetBuffer.writeShortAdd(class129.field1205);
			var9.packetBuffer.writeShort(var3);
			var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortAddLE(class19.baseY + var1);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 20) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJ3, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortLE(class19.baseY + var1);
			var9.packetBuffer.writeShortAddLE(var3);
			var9.packetBuffer.writeShortAddLE(var0 + class20.baseX);
			var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		PacketBufferNode var14;
		NPC var15;
		if (var2 == 7) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.f69, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShortAdd(Actor.field958);
				var14.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeInt(class4.field2);
				var14.packetBuffer.writeShortLE(var3);
				var14.packetBuffer.writeShortAddLE(class129.field1205);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 6) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOC4, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortLE(class19.baseY + var1);
			var9.packetBuffer.writeShortAddLE(var3);
			var9.packetBuffer.writeShortAddLE(var0 + class20.baseX);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		Player var16;
		if (var2 == 14) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.f4, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeIntME(class4.field2);
				var14.packetBuffer.writeShortAdd(Actor.field958);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortAdd(var3);
				var14.packetBuffer.writeShortAddLE(class129.field1205);
				Client.packetWriter.addNode(var14);
			}
		}

		Widget var17;
		if (var2 == 57 || var2 == 1007) {
			var17 = field89.getWidgetChild(var1, var0);
			if (var17 != null) {
				TextureProvider.widgetDefaultMenuAction(var3, var1, var0, var4, var6);
			}
		}

		if (var2 == 48) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER5, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 50) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 23) {
			if (Client.isMenuOpen) {
				class10.scene.setViewportWalking();
			} else {
				class10.scene.menuOpen(class87.Client_plane, var0, var1, true);
			}
		}

		if (var2 == 13) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPC5, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		PacketBufferNode var12;
		if (var2 == 1003) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var15 = Client.npcs[var3];
			if (var15 != null) {
				NPCComposition var18 = var15.definition;
				if (var18.transforms != null) {
					var18 = var18.transform();
				}

				if (var18 != null) {
					var12 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPCE, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeShortAddLE(var18.id);
					Client.packetWriter.addNode(var12);
				}
			}
		}

		if (var2 == 21) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJ4, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var3);
			var9.packetBuffer.writeShort(var0 + class20.baseX);
			var9.packetBuffer.writeShort(class19.baseY + var1);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 44) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortAddLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 11) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPC3, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortAddLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 5) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOC3, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAddLE(class19.baseY + var1);
			var9.packetBuffer.writeShort(var3);
			var9.packetBuffer.writeShortLE(var0 + class20.baseX);
			var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 15) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYERT, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShort(Client.field503);
				var14.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex);
				var14.packetBuffer.writeIntLE(JagexCache.field1449);
				var14.packetBuffer.writeShortLE(var3);
				var14.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 51) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER8, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 22) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJ5, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShort(class19.baseY + var1);
			var9.packetBuffer.writeShortLE(var0 + class20.baseX);
			var9.packetBuffer.writeShortAddLE(var3);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 24) {
			var17 = field89.method1740(var1);
			if (var17 != null) {
				boolean var13 = true;
				if (var17.contentType > 0) {
					var13 = EnumComposition.method1002(var17);
				}

				if (var13) {
					var12 = ClanChannelMember.getPacketBufferNode(ClientPacket.WIDGET_TYPE, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeInt(var1);
					Client.packetWriter.addNode(var12);
				}
			}
		}

		if (var2 == 2) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOCT, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
			var9.packetBuffer.writeShort(var0 + class20.baseX);
			var9.packetBuffer.writeIntIME(JagexCache.field1449);
			var9.packetBuffer.writeShortLE(var3);
			var9.packetBuffer.writeShortLE(class19.baseY + var1);
			var9.packetBuffer.writeShortAdd(Client.field503);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 30 && Client.meslayerContinueWidget == null) {
			class174.resumePauseWidget(var1, var0);
			Client.meslayerContinueWidget = field89.getWidgetChild(var1, var0);
			ClanChannelMember.invalidateWidget(Client.meslayerContinueWidget);
		}

		if (var2 == 12) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPC4, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 9) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPC1, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShortAdd(var3);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 49) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 19) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJ2, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAddLE(var0 + class20.baseX);
			var9.packetBuffer.writeShort(class19.baseY + var1);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortAdd(var3);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 1002) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOCE, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var3);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 17) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJT, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var3);
			var9.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeInt(JagexCache.field1449);
			var9.packetBuffer.writeShort(Client.field503);
			var9.packetBuffer.writeShortAddLE(class19.baseY + var1);
			var9.packetBuffer.writeShortAddLE(var0 + class20.baseX);
			var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 46) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER3, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShortAdd(var3);
				var14.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 3) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOC1, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(var0 + class20.baseX);
			var9.packetBuffer.writeShortAddLE(class19.baseY + var1);
			var9.packetBuffer.writeShortAddLE(var3);
			var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 45) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER2, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 10) {
			var15 = Client.npcs[var3];
			if (var15 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPC2, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var14.packetBuffer.writeShortAdd(var3);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 1004) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJE, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShort(class19.baseY + var1);
			var9.packetBuffer.writeShort(var0 + class20.baseX);
			var9.packetBuffer.writeShortAdd(var3);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 58) {
			var17 = field89.getWidgetChild(var1, var0);
			if (var17 != null) {
				if (var17.field3105 != null) {
					ScriptEvent var19 = new ScriptEvent();
					var19.widget = var17;
					var19.opIndex = var3;
					var19.targetName = var6;
					var19.args = var17.field3105;
					Interpreter.runScriptEvent(var19);
				}

				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.IF_BUTTONT, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShortAddLE(Client.selectedSpellChildIndex);
				var14.packetBuffer.writeInt(var1);
				var14.packetBuffer.writeShortAdd(var4);
				var14.packetBuffer.writeIntIME(JagexCache.field1449);
				var14.packetBuffer.writeShortAddLE(Client.field503);
				var14.packetBuffer.writeShortAddLE(var0);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 18) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPOBJ1, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShortAdd(class19.baseY + var1);
			var9.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var9.packetBuffer.writeShortAdd(var0 + class20.baseX);
			var9.packetBuffer.writeShort(var3);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 1001) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPLOC5, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeShort(var3);
			var9.packetBuffer.writeShortAdd(class19.baseY + var1);
			var9.packetBuffer.writeShortAdd(var0 + class20.baseX);
			var9.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			Client.packetWriter.addNode(var9);
		}

		if (var2 == 29) {
			var9 = ClanChannelMember.getPacketBufferNode(ClientPacket.WIDGET_TYPE, Client.packetWriter.isaacCipher);
			var9.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var9);
			var10 = field89.method1740(var1);
			if (var10 != null && var10.cs1Instructions != null && var10.cs1Instructions[0][0] == 5) {
				var11 = var10.cs1Instructions[0][1];
				if (Varps.Varps_main[var11] != var10.cs1ComparisonValues[0]) {
					Varps.Varps_main[var11] = var10.cs1ComparisonValues[0];
					ScriptEvent.changeGameOptions(var11);
				}
			}
		}

		if (var2 == 47) {
			var16 = Client.players[var3];
			if (var16 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeShortAddLE(var3);
				var14.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var14);
			}
		}

		if (var2 == 26) {
			GrandExchangeOfferOwnWorldComparator.method351();
		}

		if (var2 == 25) {
			var17 = field89.getWidgetChild(var1, var0);
			if (var17 != null) {
				class286.method1575();
				class478.method2385(var1, var0, KitDefinition.Widget_unpackTargetMask(MouseRecorder.getWidgetFlags(var17)), var4);
				Client.isItemSelected = 0;
				Client.field599 = class155.Widget_getSpellActionName(var17);
				if (Client.field599 == null) {
					Client.field599 = "null";
				}

				if (var17.isIf3) {
					Client.field600 = var17.dataText + Client.colorStartTag(16777215);
				} else {
					Client.field600 = Client.colorStartTag(65280) + var17.field3124 + Client.colorStartTag(16777215);
				}
			}

		} else {
			if (var2 == 8) {
				var15 = Client.npcs[var3];
				if (var15 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var14 = ClanChannelMember.getPacketBufferNode(ClientPacket.OPNPCT, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeIntIME(JagexCache.field1449);
					var14.packetBuffer.writeShortAdd(Client.field503);
					var14.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var14.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
					var14.packetBuffer.writeShortAddLE(var3);
					Client.packetWriter.addNode(var14);
				}
			}

			if (Client.isItemSelected != 0) {
				Client.isItemSelected = 0;
				ClanChannelMember.invalidateWidget(field89.method1740(class4.field2));
			}

			if (Client.isSpellSelected) {
				class286.method1575();
			}

		}
	}
}