import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class60 {
	@ObfuscatedName("aw")
	byte[] field312;
	@ObfuscatedName("ay")
	int field314;
	@ObfuscatedName("ar")
	int field313;

	class60() {
		this.field312 = null;
		this.field314 = 0;
		this.field313 = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2044027415"
	)
	int method325(int var1) {
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var1 >= 8 - this.field313; var1 -= var4) {
			var4 = 8 - this.field313;
			int var5 = (1 << var4) - 1;
			var2 += (this.field312[this.field314] >> this.field313 & var5) << var3;
			this.field313 = 0;
			++this.field314;
			var3 += var4;
		}

		if (var1 > 0) {
			var4 = (1 << var1) - 1;
			var2 += (this.field312[this.field314] >> this.field313 & var4) << var3;
			this.field313 += var1;
		}

		return var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "92"
	)
	int method326() {
		int var1 = this.field312[this.field314] >> this.field313 & 1;
		++this.field313;
		this.field314 += this.field313 >> 3;
		this.field313 &= 7;
		return var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "([BII)V",
		garbageValue = "706879560"
	)
	void method327(byte[] var1, int var2) {
		this.field312 = var1;
		this.field314 = var2;
		this.field313 = 0;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-881348723"
	)
	static int method328(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = VarbitComposition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
		}

		class200.invalidateWidget(var3);
		int var4;
		int var5;
		if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
			if (var0 == 1201) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1202) {
				var3.modelType = 3;
				var3.modelId = class136.localPlayer.appearance.getChatHeadId();
				return 1;
			} else if (var0 == 1207) {
				boolean var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				WorldMapManager.method1453(var3, class136.localPlayer.appearance, var7);
				return 1;
			} else if (var0 == 1208) {
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3.field3081 == null) {
					throw new RuntimeException("");
				} else {
					UserComparator9.method679(var3, var4);
					return 1;
				}
			} else if (var0 == 1209) {
				Interpreter.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				if (var3.field3081 == null) {
					throw new RuntimeException("");
				} else {
					class310.method1641(var3, var4, var5);
					return 1;
				}
			} else if (var0 == 1210) {
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3.field3081 == null) {
					throw new RuntimeException("");
				} else {
					TaskHandler.method898(var3, class136.localPlayer.appearance.field2900, var4);
					return 1;
				}
			} else {
				return 2;
			}
		} else {
			Interpreter.Interpreter_intStackSize -= 2;
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemComposition var6 = class125.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == 1205) {
				var3.itemQuantityMode = 0;
			} else if (var0 == 1212 | var6.isStackable == 1) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.modelRotation > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.modelRotation;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "1862862390"
	)
	static boolean method329(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"ï¿½$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var1)) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("jw")
	@ObfuscatedSignature(
		descriptor = "(Ldf;I)Z",
		garbageValue = "1187792462"
	)
	static boolean method330(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else {
			boolean var1;
			if (class136.localPlayer != var0) {
				var1 = (Client.drawPlayerNames & 4) != 0;
				return var1 || WorldMapIcon_1.method1373() && var0.isFriend() || ModeWhere.method1946() && var0.method491();
			} else {
				var1 = (Client.drawPlayerNames & 8) != 0;
				return var1;
			}
		}
	}

	@ObfuscatedName("kc")
	@ObfuscatedSignature(
		descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "14"
	)
	@Export("menuAction")
	static final void menuAction(int param0, int param1, int var2, int var3_item_npc_index, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		NPC var9;
		PacketBufferNode var11;
		if (var2 == 1003) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				NPCComposition var10 = var9.definition;
				if (var10.transforms != null) {
					var10 = var10.transform();
				}

				if (var10 != null) {
					var11 = class503.getPacketBufferNode(ClientPacket.OPNPC6, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShortAdd(var10.id);
					Client.packetWriter.addNode(var11);
				}
			}
		}

		PacketBufferNode var15;
		if (var2 == 7) {
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPNPCU, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAdd(class301.field2732);
				var15.packetBuffer.writeShortAddLE(SecureRandomCallable.field846);
				var15.packetBuffer.writeIntIME(DirectByteArrayCopier.field3095);
				var15.packetBuffer.writeShortAdd(var3_item_npc_index);
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		Player var14;
		if (var2 == 49) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var15.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 9) {
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPNPC1, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var15.packetBuffer.writeShortAddLE(var3_item_npc_index);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 45) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER2, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var15.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 51) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER8, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var15.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0); // Movement
				Client.packetWriter.addNode(var15);
			}
		}

		PacketBufferNode var16;
		if (var2 == 1002) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var16 = class503.getPacketBufferNode(ClientPacket.OPLOC6, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShort(var3_item_npc_index);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 48) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER5, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAdd(var3_item_npc_index);
				var15.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 1001) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var16 = class503.getPacketBufferNode(ClientPacket.OPLOC5, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAddLE(var3_item_npc_index);
			var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
			var16.packetBuffer.writeShortAddLE(param0 + AbstractArchive.baseX);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 12) {
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPNPC4, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortLE(var3_item_npc_index);
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		Widget var17;
		if (var2 == 58) {
			var17 = MouseRecorder.getWidgetChild(param1, param0);
			if (var17 != null) {
				if (var17.field3042 != null) {
					ScriptEvent var18 = new ScriptEvent();
					var18.widget = var17;
					var18.opIndex = var3_item_npc_index;
					var18.targetName = var6;
					var18.args = var17.field3042;
					GrandExchangeOfferOwnWorldComparator.runScriptEvent(var18);
				}

				var15 = class503.getPacketBufferNode(ClientPacket.IF_BUTTONT, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAdd(Client.selectedSpellItemId); // fromItem
				var15.packetBuffer.writeShortLE(param0); // toSlot
				var15.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex); // fromSlot
				var15.packetBuffer.writeShortAddLE(var4); // toItem
				var15.packetBuffer.writeIntME(class33.selectedSpellWidget); // from_component_hash
				var15.packetBuffer.writeIntME(param1); // to_component_hash
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 8) {
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPNPCT, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeIntIME(class33.selectedSpellWidget); // component hash
				var15.packetBuffer.writeShortLE(Client.selectedSpellChildIndex); // component Slot
				var15.packetBuffer.writeShortLE(Client.selectedSpellItemId); // verify
				var15.packetBuffer.writeShortLE(var3_item_npc_index); // npc index
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0); // movement
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 1) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var16 = class503.getPacketBufferNode(ClientPacket.OPLOCU, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortLE(var3_item_npc_index);
			var16.packetBuffer.writeShortLE(SecureRandomCallable.field846);
			var16.packetBuffer.writeShortLE(class301.field2732);
			var16.packetBuffer.writeShortLE(param0 + AbstractArchive.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeInt(DirectByteArrayCopier.field3095);
			var16.packetBuffer.writeShortLE(class148.baseY + param1);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 47) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAdd(var3_item_npc_index);
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 44) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var15.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 11) {
			var9 = Client.npcs[var3_item_npc_index];
			if (var9 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPNPC3, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShort(var3_item_npc_index);
				var15.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		int var12;
		Widget var19;
		if (var2 == 29) {
			var16 = class503.getPacketBufferNode(ClientPacket.BUTTON_CLICK, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeInt(param1);
			Client.packetWriter.addNode(var16);
			var19 = VarbitComposition.getWidget(param1);
			if (var19 != null && var19.cs1Instructions != null && var19.cs1Instructions[0][0] == 5) {
				var12 = var19.cs1Instructions[0][1];
				if (Varps.Varps_main[var12] != var19.cs1ComparisonValues[0]) {
					Varps.Varps_main[var12] = var19.cs1ComparisonValues[0];
					MenuAction.changeGameOptions(var12);
				}
			}
		}

		if (var2 == 22) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ5, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortAdd(param0 + AbstractArchive.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeShortAdd(var3_item_npc_index);
			var16.packetBuffer.writeShortAdd(class148.baseY + param1);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 50) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShort(var3_item_npc_index);
				var15.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 14) {
			var14 = Client.players[var3_item_npc_index];
			if (var14 != null) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var15 = class503.getPacketBufferNode(ClientPacket.OPPLAYERU, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeShortAddLE(SecureRandomCallable.field846);
				var15.packetBuffer.writeShortAddLE(class301.field2732);
				var15.packetBuffer.writeIntLE(DirectByteArrayCopier.field3095);
				var15.packetBuffer.writeShort(var3_item_npc_index);
				var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var15);
			}
		}

		if (var2 == 26) {
			class390.method1987();
		}

		if (var2 == 23) {
			if (Client.isMenuOpen) {
				UserComparator5.scene.setViewportWalking();
			} else {
				UserComparator5.scene.menuOpen(class36.Client_plane, param0, param1, true);
			}
		}

		if (var2 == 16) {
			Client.mouseCrossX = var7;
			Client.mouseCrossY = var8;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			var16 = class503.getPacketBufferNode(ClientPacket.OPOBJU, Client.packetWriter.isaacCipher);
			var16.packetBuffer.writeShortLE(class301.field2732);
			var16.packetBuffer.writeShortLE(SecureRandomCallable.field846);
			var16.packetBuffer.writeShortLE(var3_item_npc_index);
			var16.packetBuffer.writeShortLE(class148.baseY + param1);
			var16.packetBuffer.writeShortAddLE(param0 + AbstractArchive.baseX);
			var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
			var16.packetBuffer.writeIntME(DirectByteArrayCopier.field3095);
			Client.packetWriter.addNode(var16);
		}

		if (var2 == 57 || var2 == 1007) {
			var17 = MouseRecorder.getWidgetChild(param1, param0);
			if (var17 != null) {
				BufferedSource.widgetDefaultMenuAction(var3_item_npc_index, param1, param0, var4, var6);
			}
		}

		if (var2 == 25) {
			var17 = MouseRecorder.getWidgetChild(param1, param0);
			if (var17 != null) {
				SoundCache.Widget_runOnTargetLeave();
				ArchiveDiskAction.selectSpell(param1, param0, class273.Widget_unpackTargetMask(UserComparator8.getWidgetFlags(var17)), var4);
				Client.isItemSelected = 0;
				Client.field597 = class13.Widget_getSpellActionName(var17);
				if (Client.field597 == null) {
					Client.field597 = "null";
				}

				if (var17.isIf3) {
					Client.field596 = var17.dataText + MusicPatchPcmStream.colorStartTag(16777215);
				} else {
					Client.field596 = MusicPatchPcmStream.colorStartTag(65280) + var17.field3078 + MusicPatchPcmStream.colorStartTag(16777215);
				}
			}

		} else {
			if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
				class127.worldMap.worldMapMenuAction(var2, var3_item_npc_index, new Coord(param0), new Coord(param1));
			}

			if (var2 == 46) {
				var14 = Client.players[var3_item_npc_index];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var15 = class503.getPacketBufferNode(ClientPacket._OPOBJ3, Client.packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var15.packetBuffer.writeShort(var3_item_npc_index);
					Client.packetWriter.addNode(var15);
				}
			}

			if (var2 == 15) {
				var14 = Client.players[var3_item_npc_index];
				if (var14 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var15 = class503.getPacketBufferNode(ClientPacket._OPPLAYER5, Client.packetWriter.isaacCipher);
					var15.packetBuffer.writeShortAdd(var3_item_npc_index);
					var15.packetBuffer.writeIntME(class33.selectedSpellWidget);
					var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var15.packetBuffer.writeShort(Client.selectedSpellItemId);
					var15.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
					Client.packetWriter.addNode(var15);
				}
			}

			if (var2 == 6) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPLOC4, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
				var16.packetBuffer.writeShortLE(param0 + AbstractArchive.baseX);
				var16.packetBuffer.writeShort(var3_item_npc_index);
				var16.packetBuffer.writeByteAdd(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 20) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ3, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortAdd(param0 + AbstractArchive.baseX);
				var16.packetBuffer.writeShortAdd(var3_item_npc_index);
				var16.packetBuffer.writeShortLE(class148.baseY + param1);
				var16.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 17) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJT, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortLE(class148.baseY + param1);
				var16.packetBuffer.writeShortAdd(Client.selectedSpellChildIndex);
				var16.packetBuffer.writeShortAdd(var3_item_npc_index);
				var16.packetBuffer.writeIntLE(class33.selectedSpellWidget);
				var16.packetBuffer.writeShortAdd(Client.selectedSpellItemId);
				var16.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShort(param0 + AbstractArchive.baseX);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 19) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ2, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortLE(param0 + AbstractArchive.baseX);
				var16.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortLE(var3_item_npc_index);
				var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 10) {
				var9 = Client.npcs[var3_item_npc_index];
				if (var9 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var15 = class503.getPacketBufferNode(ClientPacket.OPNPC2, Client.packetWriter.isaacCipher);
					var15.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var15.packetBuffer.writeShortLE(var3_item_npc_index);
					Client.packetWriter.addNode(var15);
				}
			}

			if (var2 == 2) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPLOCT, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeByteNeg(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0); // Movement
				var16.packetBuffer.writeShort(Client.selectedSpellItemId); // Item
				var16.packetBuffer.writeShort(var3_item_npc_index); // object
				var16.packetBuffer.writeShort(class148.baseY + param1); // Z
				var16.packetBuffer.writeShortAdd(param0 + AbstractArchive.baseX); // x
				var16.packetBuffer.writeShortLE(Client.selectedSpellChildIndex); // Slot
				var16.packetBuffer.writeIntIME(class33.selectedSpellWidget); // hash
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 3) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPLOC1, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortLE(class148.baseY + param1); // z
				var16.packetBuffer.writeShortLE(param0 + AbstractArchive.baseX); // x
				var16.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0); // movement
				var16.packetBuffer.writeShort(var3_item_npc_index); // ObjectId
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 24) {
				var17 = VarbitComposition.getWidget(param1);
				if (var17 != null) {
					boolean var13 = true;
					if (var17.contentType > 0) {
						var13 = class467.method2326(var17);
					}

					if (var13) {
						var11 = class503.getPacketBufferNode(ClientPacket.BUTTON_CLICK, Client.packetWriter.isaacCipher);
						var11.packetBuffer.writeInt(param1);
						Client.packetWriter.addNode(var11);
					}
				}
			}

			if (var2 == 5) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPLOC3, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortAdd(param0 + AbstractArchive.baseX); // x
				var16.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0); // movement
				var16.packetBuffer.writeShortAdd(class148.baseY + param1); // z
				var16.packetBuffer.writeShortAddLE(var3_item_npc_index); // id
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 21) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ4, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortLE(var3_item_npc_index);
				var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
				var16.packetBuffer.writeShortAddLE(param0 + AbstractArchive.baseX);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 18) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ1, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
				var16.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var16.packetBuffer.writeShortAddLE(param0 + AbstractArchive.baseX);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 30 && Client.meslayerContinueWidget == null) {
				WorldMapArea.resumePauseWidget(param1, param0);
				Client.meslayerContinueWidget = MouseRecorder.getWidgetChild(param1, param0);
				class200.invalidateWidget(Client.meslayerContinueWidget);
			}

			if (var2 == 1004) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				var16 = class503.getPacketBufferNode(ClientPacket.OPOBJ6, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortLE(param0 + AbstractArchive.baseX);
				var16.packetBuffer.writeShortAdd(var3_item_npc_index);
				var16.packetBuffer.writeShortAddLE(class148.baseY + param1);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 4) {
				Client.mouseCrossX = var7;
				Client.mouseCrossY = var8;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				var16 = class503.getPacketBufferNode(ClientPacket.OPLOC2, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeShortLE(class148.baseY + param1);
				var16.packetBuffer.writeShortAddLE(var3_item_npc_index);
				var16.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
				var16.packetBuffer.writeShortAdd(param0 + AbstractArchive.baseX);
				Client.packetWriter.addNode(var16);
			}

			if (var2 == 28) {
				var16 = class503.getPacketBufferNode(ClientPacket.BUTTON_CLICK, Client.packetWriter.isaacCipher);
				var16.packetBuffer.writeInt(param1);
				Client.packetWriter.addNode(var16);
				var19 = VarbitComposition.getWidget(param1);
				if (var19 != null && var19.cs1Instructions != null && var19.cs1Instructions[0][0] == 5) {
					var12 = var19.cs1Instructions[0][1];
					Varps.Varps_main[var12] = 1 - Varps.Varps_main[var12];
					MenuAction.changeGameOptions(var12);
				}
			}

			if (var2 == 13) {
				var9 = Client.npcs[var3_item_npc_index];
				if (var9 != null) {
					Client.mouseCrossX = var7;
					Client.mouseCrossY = var8;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = param0;
					Client.destinationY = param1;
					var15 = class503.getPacketBufferNode(ClientPacket.OPNPC5, Client.packetWriter.isaacCipher);
					var15.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
					var15.packetBuffer.writeShort(var3_item_npc_index);
					Client.packetWriter.addNode(var15);
				}
			}

			if (Client.isItemSelected != 0) {
				Client.isItemSelected = 0;
				class200.invalidateWidget(VarbitComposition.getWidget(DirectByteArrayCopier.field3095));
			}

			if (Client.isSpellSelected) {
				SoundCache.Widget_runOnTargetLeave();
			}

		}
	}
}
