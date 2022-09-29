import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mo")
public class class343 {
	@ObfuscatedName("c")
	static char[] field4188;
	@ObfuscatedName("p")
	static char[] field4187;
	@ObfuscatedName("f")
	static char[] field4186;
	@ObfuscatedName("n")
	static int[] field4189;

	static {
		field4188 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field4188[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4188[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4188[var0] = (char)(var0 + 48 - 52);
		}

		field4188[62] = '+';
		field4188[63] = '/';
		field4187 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field4187[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4187[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4187[var0] = (char)(var0 + 48 - 52);
		}

		field4187[62] = '*';
		field4187[63] = '-';
		field4186 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field4186[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4186[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4186[var0] = (char)(var0 + 48 - 52);
		}

		field4186[62] = '-';
		field4186[63] = '_';
		field4189 = new int[128];

		for (var0 = 0; var0 < field4189.length; ++var0) {
			field4189[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field4189[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field4189[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field4189[var0] = var0 - 48 + 52;
		}

		int[] var2 = field4189;
		field4189[43] = 62;
		var2[42] = 62;
		int[] var1 = field4189;
		field4189[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "-1540107780"
	)
	static int method6445(int var0, Script var1, boolean var2) {
		String var7;
		if (var0 == 3100) {
			var7 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
			class65.addGameMessage(0, "", var7);
			return 1;
		} else if (var0 == 3101) {
			Interpreter.Interpreter_intStackSize -= 2;
			class120.performPlayerAnimation(class67.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == 3103) {
			if (!Interpreter.field833) {
				Interpreter.field843 = true;
			}

			return 1;
		} else {
			int var16;
			if (var0 == 3104) {
				var7 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
				var16 = 0;
				if (class151.isNumber(var7)) {
					var16 = MidiPcmStream.method5532(var7);
				}

				PacketBufferNode var14 = class120.getPacketBufferNode(ClientPacket.field2942, Client.packetWriter.isaacCipher);
				var14.packetBuffer.writeInt(var16);
				Client.packetWriter.addNode(var14);
				return 1;
			} else {
				PacketBufferNode var12;
				if (var0 == 3105) {
					var7 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
					var12 = class120.getPacketBufferNode(ClientPacket.field3009, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeByte(var7.length() + 1);
					var12.packetBuffer.writeStringCp1252NullTerminated(var7);
					Client.packetWriter.addNode(var12);
					return 1;
				} else if (var0 == 3106) {
					var7 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
					var12 = class120.getPacketBufferNode(ClientPacket.field2972, Client.packetWriter.isaacCipher);
					var12.packetBuffer.writeByte(var7.length() + 1);
					var12.packetBuffer.writeStringCp1252NullTerminated(var7);
					Client.packetWriter.addNode(var12);
					return 1;
				} else {
					int var3;
					String var11;
					if (var0 == 3107) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var11 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
						PacketWriter.method2674(var3, var11);
						return 1;
					} else if (var0 == 3108) {
						Interpreter.Interpreter_intStackSize -= 3;
						var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var16 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						Widget var15 = SpotAnimationDefinition.getWidget(var9);
						AbstractByteArrayCopier.clickWidget(var15, var3, var16);
						return 1;
					} else if (var0 == 3109) {
						Interpreter.Interpreter_intStackSize -= 2;
						var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var16 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						Widget var13 = var2 ? TextureProvider.scriptDotWidget : MenuAction.scriptActiveWidget;
						AbstractByteArrayCopier.clickWidget(var13, var3, var16);
						return 1;
					} else if (var0 == 3110) {
						Renderable.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3111) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Player.clientPreferences.method2452() ? 1 : 0;
						return 1;
					} else if (var0 == 3112) {
						Player.clientPreferences.method2412(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3113) {
						var7 = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
						boolean var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						CollisionMap.openURL(var7, var8, false);
						return 1;
					} else if (var0 == 3115) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var12 = class120.getPacketBufferNode(ClientPacket.field2966, Client.packetWriter.isaacCipher);
						var12.packetBuffer.writeShort(var3);
						Client.packetWriter.addNode(var12);
						return 1;
					} else if (var0 == 3116) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						VarbitComposition.Interpreter_stringStackSize -= 2;
						var11 = Interpreter.Interpreter_stringStack[VarbitComposition.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[VarbitComposition.Interpreter_stringStackSize + 1];
						if (var11.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = class120.getPacketBufferNode(ClientPacket.field3003, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + class357.stringCp1252NullTerminatedByteSize(var11) + class357.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.writeByte(var3);
							var6.packetBuffer.writeStringCp1252NullTerminated(var11);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == 3117) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3118) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3119) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
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
						Canvas.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3128) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class271.getTapToDrop() ? 1 : 0;
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
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class123.canvasWidth;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class166.canvasHeight;
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
						Client.field593 = 3;
						Client.field668 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field593 = 2;
						Client.field668 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field593 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field593 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field593 = 3;
						Client.field668 = var2 ? TextureProvider.scriptDotWidget.id : MenuAction.scriptActiveWidget.id;
						return 1;
					} else {
						boolean var10;
						if (var0 == 3141) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Player.clientPreferences.method2390(var10);
							return 1;
						} else if (var0 == 3142) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Player.clientPreferences.method2397() ? 1 : 0;
							return 1;
						} else if (var0 == 3143) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var10;
							if (!var10) {
								Player.clientPreferences.method2406("");
							}

							return 1;
						} else if (var0 == 3144) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == 3146) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Player.clientPreferences.method2392(!var10);
							return 1;
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Player.clientPreferences.method2393() ? 0 : 1;
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
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class128.method3003();
							return 1;
						} else if (var0 == 3155) {
							--VarbitComposition.Interpreter_stringStackSize;
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
							--VarbitComposition.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
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
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
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
							--VarbitComposition.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--VarbitComposition.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3181) {
							GrandExchangeOfferOwnWorldComparator.method1174(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
							return 1;
						} else if (var0 == 3182) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator5.method2751();
							return 1;
						} else if (var0 == 3189) {
							var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							SequenceDefinition var4 = class4.SequenceDefinition_get(var3);
							if (var4.isCachedModelIdSet()) {
								ItemComposition.method3910(var4.SequenceDefinition_cachedModelId);
							}

							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1039741684"
	)
	static void method6444() {
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1348 = null;
		Client.packetWriter.field1350 = null;
		Client.packetWriter.field1345 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1349 = 0;
		Client.rebootTimer = 0;
		AbstractWorldMapIcon.method5183();
		Client.minimapState = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		class67.localPlayer = null;

		for (var0 = 0; var0 < Client.npcs.length; ++var0) {
			NPC var1 = Client.npcs[var0];
			if (var1 != null) {
				var1.targetIndex = -1;
				var1.false0 = false;
			}
		}

		class33.method640();
		Coord.updateGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field714[var0] = true;
		}

		PacketBufferNode var2 = class120.getPacketBufferNode(ClientPacket.field2956, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(SceneTilePaint.getWindowedMode());
		var2.packetBuffer.writeShort(class123.canvasWidth);
		var2.packetBuffer.writeShort(class166.canvasHeight);
		Client.packetWriter.addNode(var2);
	}
}
