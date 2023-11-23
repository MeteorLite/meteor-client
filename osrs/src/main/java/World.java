import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("World")
public class World {
	@ObfuscatedName("au")
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("aa")
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("ac")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("al")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("ap")
	@Export("id")
	int id;
	@ObfuscatedName("av")
	@Export("properties")
	int properties;
	@ObfuscatedName("ax")
	@Export("population")
	int population;
	@ObfuscatedName("as")
	@Export("host")
	String host;
	@ObfuscatedName("ay")
	@Export("activity")
	String activity;
	@ObfuscatedName("ak")
	@Export("location")
	int location;
	@ObfuscatedName("aj")
	@Export("index")
	int index;
	@ObfuscatedName("am")
	String field679;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-98"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (class522.field4158.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "0"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (class522.field4153.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "25"
	)
	boolean method399() {
		return (class522.field4152.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2092493983"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (class522.field4157.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1744253846"
	)
	boolean method401() {
		return (class522.field4155.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "1917"
	)
	boolean method402() {
		return (class522.field4160.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1429834032"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (class522.field4151.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "893660966"
	)
	boolean method404() {
		return (class522.field4161.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-42"
	)
	boolean method405() {
		return (class522.field4154.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-15"
	)
	boolean method406() {
		return (class522.field4159.rsOrdinal() & this.properties) != 0;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "([BIII)Ljava/lang/String;",
		garbageValue = "-1248471414"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class396.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1960092148"
	)
	static int method407(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == 3100) {
			var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
			GrandExchangeOfferUnitPriceComparator.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == 3101) {
			DbTableType.Interpreter_intStackSize -= 2;
			WorldMapLabelSize.performPlayerAnimation(class229.localPlayer, Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize], Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == 3103) {
			if (!Interpreter.field703) {
				Interpreter.field702 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == 3104) {
				var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				var10 = 0;
				if (ClientPacket.isNumber(var3)) {
					var10 = Huffman.method1888(var3);
				}

				PacketBufferNode var12 = class113.getPacketBufferNode(ClientPacket.RESUME_COUNTDIALOG, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == 3105) {
					var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					var14 = class113.getPacketBufferNode(ClientPacket.RESUME_NAMEDIALOG, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == 3106) {
					var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					var14 = class113.getPacketBufferNode(ClientPacket.RESUME_STRINGDIALOG, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var8;
					if (var0 == 3107) {
						var8 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
						class402.method2043(var8, var7);
						return 1;
					} else if (var0 == 3108) {
						DbTableType.Interpreter_intStackSize -= 3;
						var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
						Widget var13 = HealthBarDefinition.widgetDefinition.method1733(var9);
						HorizontalAlignment.clickWidget(var13, var8, var10);
						return 1;
					} else if (var0 == 3109) {
						DbTableType.Interpreter_intStackSize -= 2;
						var8 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
						HorizontalAlignment.clickWidget(var11, var8, var10);
						return 1;
					} else if (var0 == 3110) {
						class19.mouseCam = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3111) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapIcon_1.clientPreferences.getRoofsHidden() ? 1 : 0;
						return 1;
					} else if (var0 == 3112) {
						WorldMapIcon_1.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3113) {
						var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						HealthBar.openURL(var3, var4, false);
						return 1;
					} else if (var0 == 3115) {
						var8 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var14 = class113.getPacketBufferNode(ClientPacket.RESUME_OBJDIALOG, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var8);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == 3116) {
						var8 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						class127.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = class113.getPacketBufferNode(ClientPacket.f66, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + ClanChannel.stringCp1252NullTerminatedByteSize(var7) + ClanChannel.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeByteAdd(var8);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == 3117) {
						--DbTableType.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3118) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3119) {
						Client.field387 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == 3125) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3126) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3127) {
						IgnoreList.setTapToDrop(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3128) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Strings.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == 3129) {
						DbTableType.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						DbTableType.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--DbTableType.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3132) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Language.canvasWidth;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class47.canvasHeight;
						return 1;
					} else if (var0 == 3133) {
						--DbTableType.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3134) {
						return 1;
					} else if (var0 == 3135) {
						DbTableType.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field505 = 3;
						Client.field499 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field505 = 2;
						Client.field499 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field505 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field505 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field505 = 3;
						Client.field499 = var2 ? Interpreter.scriptDotWidget.id  : HealthBar.scriptActiveWidget.id ;
						return 1;
					} else {
						boolean var15;
						if (var0 == 3141) {
							var15 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							WorldMapIcon_1.clientPreferences.setIsUsernameHidden(var15);
							return 1;
						} else if (var0 == 3142) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapIcon_1.clientPreferences.getIsUsernameHidden() ? 1 : 0;
							return 1;
						} else if (var0 == 3143) {
							var15 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var15;
							if (!var15) {
								WorldMapIcon_1.clientPreferences.setUsernameToRemember("");
							}

							return 1;
						} else if (var0 == 3144) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == 3146) {
							var15 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
							WorldMapIcon_1.clientPreferences.getTitleMusicDisabled(!var15);
							return 1;
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapIcon_1.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapData_1.method1285();
							return 1;
						} else if (var0 == 3155) {
							--class127.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							DbTableType.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--DbTableType.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--DbTableType.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class127.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--DbTableType.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--DbTableType.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							DbTableType.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							DbTableType.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							DbTableType.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--DbTableType.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--DbTableType.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--DbTableType.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class127.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--class127.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3181) {
							class311.method1647(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
							return 1;
						} else if (var0 == 3182) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class216.method1099();
							return 1;
						} else if (var0 == 3189) {
							var8 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							class240.method1294(var8);
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}
}