import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rn")
public class class466 {
	@ObfuscatedName("ai")
	static int[] field3914;
	@ObfuscatedName("az")
	public static int[] field3911;
	@ObfuscatedName("ad")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfi;"
	)
	static ClanSettings field3912;

	static {
		field3914 = new int[32768];

		for (int var0 = 0; var0 < 32768; ++var0) {
			field3914[var0] = method2344(var0);
		}

		method2346();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[Lnv;",
		garbageValue = "3"
	)
	static class345[] method2345() {
		return new class345[]{class345.field3151, class345.field3150};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2141889570"
	)
	static final int method2344(int var0) {
		double var1 = (double)(var0 >> 10 & 31) / 31.0D;
		double var3 = (double)(var0 >> 5 & 31) / 31.0D;
		double var5 = (double)(var0 & 31) / 31.0D;
		double var7 = var1;
		if (var3 < var1) {
			var7 = var3;
		}

		if (var5 < var7) {
			var7 = var5;
		}

		double var9 = var1;
		if (var3 > var1) {
			var9 = var3;
		}

		if (var5 > var9) {
			var9 = var5;
		}

		double var11 = 0.0D;
		double var13 = 0.0D;
		double var15 = (var9 + var7) / 2.0D;
		if (var7 != var9) {
			if (var15 < 0.5D) {
				var13 = (var9 - var7) / (var7 + var9);
			}

			if (var15 >= 0.5D) {
				var13 = (var9 - var7) / (2.0D - var9 - var7);
			}

			if (var9 == var1) {
				var11 = (var3 - var5) / (var9 - var7);
			} else if (var3 == var9) {
				var11 = 2.0D + (var5 - var1) / (var9 - var7);
			} else if (var5 == var9) {
				var11 = 4.0D + (var1 - var3) / (var9 - var7);
			}
		}

		int var17 = (int)(var11 * 256.0D / 6.0D);
		var17 &= 255;
		double var18 = 256.0D * var13;
		if (var18 < 0.0D) {
			var18 = 0.0D;
		} else if (var18 > 255.0D) {
			var18 = 255.0D;
		}

		if (var15 > 0.7D) {
			var18 /= 2.0D;
			var18 = Math.floor(var18);
		}

		if (var15 > 0.75D) {
			var18 /= 2.0D;
			var18 = Math.floor(var18);
		}

		if (var15 > 0.85D) {
			var18 /= 2.0D;
			var18 = Math.floor(var18);
		}

		if (var15 > 0.95D) {
			var18 /= 2.0D;
			var18 = Math.floor(var18);
		}

		if (var15 > 0.995D) {
			var15 = 0.995D;
		}

		int var20 = (int)((double)(var17 / 4 * 8) + var18 / 32.0D);
		return (var20 << 7) + (int)(var15 * 128.0D);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "861588431"
	)
	static void method2346() {
		if (field3911 == null) {
			field3911 = new int[65536];
			double var0 = 0.949999988079071D;

			for (int var2 = 0; var2 < 65536; ++var2) {
				double var3 = 0.0078125D + (double)(var2 >> 10 & 63) / 64.0D;
				double var5 = 0.0625D + (double)(var2 >> 7 & 7) / 8.0D;
				double var7 = (double)(var2 & 127) / 128.0D;
				double var9 = var7;
				double var11 = var7;
				double var13 = var7;
				if (0.0D != var5) {
					double var15;
					if (var7 < 0.5D) {
						var15 = var7 * (var5 + 1.0D);
					} else {
						var15 = var5 + var7 - var5 * var7;
					}

					double var17 = 2.0D * var7 - var15;
					double var19 = var3 + 0.3333333333333333D;
					if (var19 > 1.0D) {
						--var19;
					}

					double var23 = var3 - 0.3333333333333333D;
					if (var23 < 0.0D) {
						++var23;
					}

					if (var19 * 6.0D < 1.0D) {
						var9 = var19 * 6.0D * (var15 - var17) + var17;
					} else if (2.0D * var19 < 1.0D) {
						var9 = var15;
					} else if (3.0D * var19 < 2.0D) {
						var9 = var17 + (var15 - var17) * (0.6666666666666666D - var19) * 6.0D;
					} else {
						var9 = var17;
					}

					if (6.0D * var3 < 1.0D) {
						var11 = var17 + (var15 - var17) * 6.0D * var3;
					} else if (2.0D * var3 < 1.0D) {
						var11 = var15;
					} else if (var3 * 3.0D < 2.0D) {
						var11 = 6.0D * (var15 - var17) * (0.6666666666666666D - var3) + var17;
					} else {
						var11 = var17;
					}

					if (6.0D * var23 < 1.0D) {
						var13 = 6.0D * (var15 - var17) * var23 + var17;
					} else if (var23 * 2.0D < 1.0D) {
						var13 = var15;
					} else if (var23 * 3.0D < 2.0D) {
						var13 = var17 + (0.6666666666666666D - var23) * (var15 - var17) * 6.0D;
					} else {
						var13 = var17;
					}
				}

				var9 = Math.pow(var9, var0);
				var11 = Math.pow(var11, var0);
				var13 = Math.pow(var13, var0);
				int var25 = (int)(256.0D * var9);
				int var16 = (int)(256.0D * var11);
				int var26 = (int)(256.0D * var13);
				int var18 = var26 + (var16 << 8) + (var25 << 16);
				field3911[var2] = var18 & 16777215;
			}

		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "294804302"
	)
	public static int method2347(int var0) {
		return 255 - (var0 & 255);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "66"
	)
	static int method2350() {
		return Login.loginIndex;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-734620102"
	)
	static int method2349(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == 3100) {
			var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
			MouseHandler.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == 3101) {
			SoundCache.Interpreter_intStackSize -= 2;
			LoginType.performPlayerAnimation(VarbitComposition.localPlayer, Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize], Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == 3103) {
			if (!Interpreter.field704) {
				Interpreter.field705 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == 3104) {
				var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
				var10 = 0;
				if (class218.isNumber(var3)) {
					var10 = HealthBarUpdate.method524(var3);
				}

				PacketBufferNode var12 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.RESUME_P_COUNTDIALOG, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == 3105) {
					var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.RESUME_P_NAMEDIALOG, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == 3106) {
					var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
					var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.RESUME_P_STRINGDIALOG, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var8;
					if (var0 == 3107) {
						var8 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
						class14.method41(var8, var7);
						return 1;
					} else if (var0 == 3108) {
						SoundCache.Interpreter_intStackSize -= 3;
						var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
						Widget var13 = class92.getWidget(var9);
						class227.clickWidget(var13, var8, var10);
						return 1;
					} else if (var0 == 3109) {
						SoundCache.Interpreter_intStackSize -= 2;
						var8 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? GameObject.scriptDotWidget : SceneTilePaint.scriptActiveWidget;
						class227.clickWidget(var11, var8, var10);
						return 1;
					} else if (var0 == 3110) {
						ObjTypeCustomisation.mouseCam = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3111) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class449.clientPreferences.getRoofsHidden() ? 1 : 0;
						return 1;
					} else if (var0 == 3112) {
						class449.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3113) {
						var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						class30.openURL(var3, var4, false);
						return 1;
					} else if (var0 == 3115) {
						var8 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var14 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.RESUME_P_OBJDIALOG, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var8);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == 3116) {
						var8 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						class137.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.BUG_REPORT, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + AbstractSocket.stringCp1252NullTerminatedByteSize(var7) + AbstractSocket.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.writeByte(var8);
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == 3117) {
						--SoundCache.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3118) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3119) {
						Client.field386 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == 3125) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3126) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3127) {
						class14.setTapToDrop(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == 3128) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class30.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == 3129) {
						SoundCache.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						SoundCache.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--SoundCache.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3132) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class113.canvasWidth;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class177.canvasHeight;
						return 1;
					} else if (var0 == 3133) {
						--SoundCache.Interpreter_intStackSize;
						return 1;
					} else if (var0 == 3134) {
						return 1;
					} else if (var0 == 3135) {
						SoundCache.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field505 = 3;
						Client.field508 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field505 = 2;
						Client.field508 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field505 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field505 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field505 = 3;
						Client.field508 = var2 ? GameObject.scriptDotWidget.id * -198009563 * -802277715 : SceneTilePaint.scriptActiveWidget.id * -198009563 * -802277715;
						return 1;
					} else {
						boolean var15;
						if (var0 == 3141) {
							var15 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class449.clientPreferences.setIsUsernameHidden(var15);
							return 1;
						} else if (var0 == 3142) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class449.clientPreferences.getIsUsernameHidden() ? 1 : 0;
							return 1;
						} else if (var0 == 3143) {
							var15 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var15;
							if (!var15) {
								class449.clientPreferences.setUsernameToRemember("");
							}

							return 1;
						} else if (var0 == 3144) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == 3146) {
							var15 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
							class449.clientPreferences.getTitleMusicDisabled(!var15);
							return 1;
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class449.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = FriendSystem.method412();
							return 1;
						} else if (var0 == 3155) {
							--class137.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							SoundCache.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--SoundCache.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--SoundCache.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class137.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--SoundCache.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--SoundCache.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							SoundCache.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							SoundCache.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							SoundCache.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--SoundCache.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--SoundCache.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--SoundCache.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class137.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--class137.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3181) {
							class20.method69(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
							return 1;
						} else if (var0 == 3182) {
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = PlayerType.method1883();
							return 1;
						} else if (var0 == 3189) {
							var8 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							FontName.method2447(var8);
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "1811966721"
	)
	static int method2351(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 5504) {
			SoundCache.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == 5505) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == 5506) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == 5530) {
			var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3;
			return 1;
		} else if (var0 == 5531) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.camFollowHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		descriptor = "(Lnk;Ljava/lang/String;I)V",
		garbageValue = "88867976"
	)
	static void method2348(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field550 += var2.groupCount;
	}

	@ObfuscatedName("ls")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-2084"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.CONTINUE, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE(var0);
		var2.packetBuffer.writeIntME(var1);
		Client.packetWriter.addNode(var2);
	}
}