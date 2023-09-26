import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
public class class266 {
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "36"
	)
	static int method1430(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == 3100) {
			var3 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
			class411.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == 3101) {
			Interpreter.Interpreter_intStackSize -= 2;
			WorldMapEvent.performPlayerAnimation(TextureProvider.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == 3103) {
			if (!Interpreter.field702) {
				Interpreter.field701 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == 3104) {
				var3 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
				var10 = 0;
				if (AttackOption.isNumber(var3)) {
					var10 = class36.method182(var3);
				}

				PacketBufferNode var15 = ClanChannelMember.getPacketBufferNode(ClientPacket.RESUME_COUNTDIALOG, Client.packetWriter.isaacCipher);
				var15.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var15);
				return 1;
			} else {
				PacketBufferNode var12;
				if (var0 == 3105) {
					var3 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
					var12 = ClanChannelMember.getPacketBufferNode(ClientPacket.RESUME_NAMEDIALOG, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeByte(var3.length() + 1);
					var12.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var12);
					return 1;
				} else if (var0 == 3106) {
					var3 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
					var12 = ClanChannelMember.getPacketBufferNode(ClientPacket.RESUME_STRINGDIALOG, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeByte(var3.length() + 1);
					var12.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var12);
					return 1;
				} else {
					String var7;
					int var8;
					if (var0 == 3107) {
						var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
						GrandExchangeOfferTotalQuantityComparator.method1976(var8, var7);
						return 1;
					} else if (var0 == 3108) {
						Interpreter.Interpreter_intStackSize -= 3;
						var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						Widget var11 = class33.widgetDefinition.method1740(var5);
						TaskHandler.clickWidget(var11, var8, var10);
						return 1;
					} else if (var0 == 3109) {
						Interpreter.Interpreter_intStackSize -= 2;
						var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						Widget var14 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
						TaskHandler.clickWidget(var14, var8, var10);
						return 1;
					} else if (var0 == 3110) {
						UserComparator8.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3111) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class91.clientPreferences.getRoofsHidden() ? 1 : 0;
						return 1;
					} else if (var0 == 3112) {
						class91.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3113) {
						var3 = Interpreter.Interpreter_stringStack[--class180.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						VertexNormal.openURL(var3, var4, false);
						return 1;
					} else if (var0 == 3115) {
						var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = ClanChannelMember.getPacketBufferNode(ClientPacket.RESUME_OBJDIALOG, Client.packetWriter.isaacCipher);
						var12.packetBuffer.writeShort(var8);
						Client.packetWriter.addNode(var12);
						return 1;
					} else if (var0 == 3116) {
						var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						class180.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[class180.Interpreter_stringStackSize];
						String var9 = Interpreter.Interpreter_stringStack[class180.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var9.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = ClanChannelMember.getPacketBufferNode(ClientPacket.f66, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + class478.stringCp1252NullTerminatedByteSize(var7) + class478.stringCp1252NullTerminatedByteSize(var9));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeStringCp1252NullTerminated(var9);
							var6.packetBuffer.writeByteNeg(var8);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == 3117) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3118) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3119) {
						Client.field388 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == 3125) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3126) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3127) {
						class154.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3128) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class47.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == 3129) {
						Interpreter.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3132) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class340.canvasWidth;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class491.canvasHeight;
						return 1;
					} else if (var0 == 3133) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3134) {
						return 1;
					} else if (var0 == 3135) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field508 = 3;
						Client.field505 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field508 = 2;
						Client.field505 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field508 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field508 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field508 = 3;
						Client.field505 = var2 ? class416.scriptDotWidget.id * 41171959 * -749799993 : class306.scriptActiveWidget.id * 41171959 * -749799993;
						return 1;
					} else {
						boolean var13;
						if (var0 == 3141) {
							var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class91.clientPreferences.setIsUsernameHidden(var13);
							return 1;
						} else if (var0 == 3142) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class91.clientPreferences.getIsUsernameHidden() ? 1 : 0;
							return 1;
						} else if (var0 == 3143) {
							var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var13;
							if (!var13) {
								class91.clientPreferences.setUsernameToRemember("");
							}

							return 1;
						} else if (var0 == 3144) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == 3146) {
							var13 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							class91.clientPreferences.getTitleMusicDisabled(!var13);
							return 1;
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class91.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class138.method734();
							return 1;
						} else if (var0 == 3155) {
							--class180.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							Interpreter.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class180.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class180.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class180.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--class180.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3181) {
							FontName.method2482(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
							return 1;
						} else if (var0 == 3182) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FaceNormal.method1334();
							return 1;
						} else if (var0 == 3189) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							class462.method2327(var8);
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)Z",
		garbageValue = "-277761006"
	)
	static final boolean method1431(int var0, int var1, int var2, int var3, int var4) {
		PendingSpawn var5 = null;

		for (PendingSpawn var6 = (PendingSpawn)Client.pendingSpawns.last(); var6 != null; var6 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var6.plane && var6.x == var1 && var2 == var6.y && var3 == var6.type) {
				var5 = var6;
				break;
			}
		}

		if (var5 != null) {
			var5.field946 = var4;
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		descriptor = "([BII)V",
		garbageValue = "-1820839232"
	)
	static void method1432(byte[] var0, int var1) {
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class424.writeRandomDat(var0, var1, Client.randomDatData, 0, 24);
	}
}