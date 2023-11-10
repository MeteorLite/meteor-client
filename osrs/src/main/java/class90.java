import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public enum class90 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field898(0, -1),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field895(1, 2),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field897(2, 3),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field896(3, 4),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field894(4, 5),
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ldr;"
	)
	field899(5, 6);

	@ObfuscatedName("av")
	public static short[][] field892;
	@ObfuscatedName("ae")
	static String field893;
	@ObfuscatedName("aa")
	final int field900;
	@ObfuscatedName("ac")
	final int field901;

	class90(int var3, int var4) {
		this.field900 = var3;
		this.field901 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field901;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-9"
	)
	static boolean method473(int var0, int var1) {
		return var0 != 4 || var1 < 8;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CLof;B)I",
		garbageValue = "53"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "892396745"
	)
	static final void method476() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.endCycle == -1) {
				var0.startCycle = 0;
				ScriptFrame.method344(var0);
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		descriptor = "(ZLuo;I)V",
		garbageValue = "2029902605"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field489 = 0;
		Client.field449 = 0;
		class472.method2351(var1);

		int var3;
		int var8;
		int var9;
		int var10;
		int var12;
		int var19;
		while (true) {
			byte var2 = 16;
			var3 = 1 << var2;
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) < var2 + 12) {
				break;
			}

			int var4 = var1.readBits(var2);
			if (var4 == var3 - 1) {
				break;
			}

			boolean var5 = false;
			if (Client.npcs[var4] == null) {
				Client.npcs[var4] = new NPC();
				var5 = true;
			}

			NPC var20 = Client.npcs[var4];
			Client.npcIndices[++Client.npcCount - 1] = var4;
			var20.npcCycle = Client.cycle;
			var19 = var1.readBits(1);
			var10 = Client.field563[var1.readBits(3)];
			if (var5) {
				var20.orientation = var20.rotation = var10;
			}

			if (var0) {
				var8 = var1.readBits(8);
				if (var8 > 127) {
					var8 -= 256;
				}
			} else {
				var8 = var1.readBits(5);
				if (var8 > 15) {
					var8 -= 32;
				}
			}

			boolean var11 = var1.readBits(1) == 1;
			if (var11) {
				var1.readBits(32);
			}

			var12 = var1.readBits(1);
			if (var12 == 1) {
				Client.field550[++Client.field449 - 1] = var4;
			}

			if (var0) {
				var9 = var1.readBits(8);
				if (var9 > 127) {
					var9 -= 256;
				}
			} else {
				var9 = var1.readBits(5);
				if (var9 > 15) {
					var9 -= 32;
				}
			}

			var20.definition = VerticalAlignment.getNpcDefinition(var1.readBits(14));
			class33.method144(var20);
			if (var20.field1018 == 0) {
				var20.rotation = 0;
			}

			var20.method581(class229.localPlayer.pathX[0] + var8, class229.localPlayer.pathY[0] + var9, var19 == 1);
		}

		var1.exportIndex();

		int var21;
		for (var21 = 0; var21 < Client.field449; ++var21) {
			var3 = Client.field550[var21];
			NPC var14 = Client.npcs[var3];
			int var22 = var1.readUnsignedByte();
			int var6;
			if ((var22 & 16) != 0) {
				var6 = var1.readUnsignedByte();
				var22 += var6 << 8;
			}

			if ((var22 & 256) != 0) {
				var6 = var1.readUnsignedByte();
				var22 += var6 << 16;
			}

			int[] var7;
			short[] var15;
			short[] var16;
			long var17;
			int var23;
			boolean var24;
			if ((var22 & 4096) != 0) {
				var6 = var1.readUnsignedShortAdd();
				if ((var6 & 1) == 1) {
					var14.method593();
				} else {
					var7 = null;
					if ((var6 & 2) == 2) {
						var8 = var1.readUnsignedByteSub();
						var7 = new int[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var10 = var1.readUnsignedShortLE();
							var10 = var10 == 65535 ? -1 : var10;
							var7[var9] = var10;
						}
					}

					var15 = null;
					if ((var6 & 4) == 4) {
						var9 = 0;
						if (var14.definition.recolorTo != null) {
							var9 = var14.definition.recolorTo.length;
						}

						var15 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var15[var10] = (short)var1.readUnsignedShortLE();
						}
					}

					var16 = null;
					if ((var6 & 8) == 8) {
						var10 = 0;
						if (var14.definition.retextureTo != null) {
							var10 = var14.definition.retextureTo.length;
						}

						var16 = new short[var10];

						for (var23 = 0; var23 < var10; ++var23) {
							var16[var23] = (short)var1.readUnsignedIntIME();
						}
					}

					var24 = false;
					if ((var6 & 16) != 0) {
						var24 = var1.readUnsignedShortAdd() == 1;
					}

					var17 = (long)(++NPC.field1080 - 1);
					var14.method591(new NewShit(var17, var7, var15, var16, var24));
				}
			}

			if ((var22 & 65536) != 0) {
				var6 = var1.readUnsignedByte();
				var7 = new int[8];
				var15 = new short[8];

				for (var9 = 0; var9 < 8; ++var9) {
					if ((var6 & 1 << var9) != 0) {
						var7[var9] = var1.readNullableLargeSmart();
						var15[var9] = (short)var1.readShortSmartSub();
					} else {
						var7[var9] = -1;
						var15[var9] = -1;
					}
				}

				var14.method587(var7, var15);
			}

			if ((var22 & 262144) != 0) {
				var6 = var1.readUnsignedIntME();
				var14.turnLeftSequence = (var6 & 1) != 0 ? var1.readUnsignedShort() : var14.definition.turnLeftSequence * 2124045029 * 1875038957;
				var14.turnRightSequence = (var6 & 2) != 0 ? var1.readUnsignedIntIME() : var14.definition.turnRightSequence * 1814511787 * -810894845;
				var14.walkSequence = (var6 & 4) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.walkSequence * -980344253 * 380025451;
				var14.walkBackSequence = (var6 & 8) != 0 ? var1.readUnsignedIntIME() : var14.definition.walkBackSequence * -347828473 * -666784073;
				var14.walkLeftSequence = (var6 & 16) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.walkLeftSequence * -914310317 * -1721155365;
				var14.walkRightSequence = (var6 & 32) != 0 ? var1.readUnsignedIntIME() : var14.definition.walkRightSequence * 1760273377 * 832299041;
				var14.runSequence = (var6 & 64) != 0 ? var1.readUnsignedShortLE() : var14.definition.runSequence * -1490443197 * 795658347;
				var14.runBackSequence = (var6 & 128) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.runBackSequence * -217719435 * 1622952669;
				var14.runLeftSequence = (var6 & 256) != 0 ? var1.readUnsignedIntIME() : var14.definition.runLeftSequence * -556683877 * 168358035;
				var14.runRightSequence = (var6 & 512) != 0 ? var1.readUnsignedShort() : var14.definition.runRightSequence * -732977015 * 1800293817;
				var14.crawlSequence = (var6 & 1024) != 0 ? var1.readUnsignedIntIME() : var14.definition.crawlSequence * -400554641 * 2053962127;
				var14.crawlBackSequence = (var6 & 2048) != 0 ? var1.readUnsignedShort() : var14.definition.crawlBackSequence * -418592841 * -280377849;
				var14.crawlLeftSequence = (var6 & 4096) != 0 ? var1.readUnsignedIntIME() : var14.definition.crawlLeftSequence * 1849100485 * -2053163507;
				var14.crawlRightSequence = (var6 & 8192) != 0 ? var1.readUnsignedIntIME() : var14.definition.crawlRightSequence * 1731690515 * 694176283;
				var14.idleSequence = (var6 & 16384) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.idleSequence * 929101693 * 70810069;
			}

			if ((var22 & 1) != 0) {
				var6 = var1.readUnsignedShortLE();
				if (var6 == 65535) {
					var6 = -1;
				}

				var19 = var1.readUnsignedByte();
				if (var6 == var14.sequence && var6 != -1) {
					var8 = DynamicObject.SequenceDefinition_get(var6).replyMode;
					if (var8 == 1) {
						var14.sequenceFrame = 0;
						var14.sequenceFrameCycle = 0;
						var14.sequenceDelay = var19;
						var14.currentSequenceFrameIndex = 0;
					}

					if (var8 == 2) {
						var14.currentSequenceFrameIndex = 0;
					}
				} else if (var6 == -1 || var14.sequence == -1 || DynamicObject.SequenceDefinition_get(var6).forcedPriority >= DynamicObject.SequenceDefinition_get(var14.sequence).forcedPriority) {
					var14.sequence = var6;
					var14.sequenceFrame = 0;
					var14.sequenceFrameCycle = 0;
					var14.sequenceDelay = var19;
					var14.currentSequenceFrameIndex = 0;
					var14.field1029 = var14.pathLength;
				}
			}

			if ((var22 & 1024) != 0) {
				var14.field1013 = var1.readByteAdd();
				var14.field1012 = var1.readByteNeg();
				var14.field1024 = var1.readByteAdd();
				var14.field1010 = var1.readByteNeg();
				var14.spotAnimation = var1.readUnsignedShortAddLE() + Client.cycle;
				var14.exactMoveArrive1Cycle = var1.readUnsignedShortAddLE() + Client.cycle;
				var14.exactMoveDirection = var1.readUnsignedShortAddLE();
				var14.pathLength = 1;
				var14.field1029 = 0;
				var14.field1013 += var14.pathX[0];
				var14.field1012 += var14.pathY[0];
				var14.field1024 += var14.pathX[0];
				var14.field1010 += var14.pathY[0];
			}

			if ((var22 & 8192) != 0) {
				var14.combatLevelChange = var1.readIntIME();
			}

			if ((var22 & 32) != 0) {
				var6 = var1.readUnsignedShort();
				var19 = var1.readUnsignedShortLE();
				var14.field969 = var1.readUnsignedByteSub() == 1;
				if (Client.param25 >= 212) {
					var14.field995 = var6;
					var14.field997 = var19;
				} else {
					var8 = var14.x - (var6 - NewShit.baseX - NewShit.baseX) * 64;
					var9 = var14.y - (var19 - class101.baseY - class101.baseY) * 64;
					if (var8 != 0 || var9 != 0) {
						var14.movingOrientation = SequenceDefinition.method1040(var8, var9);
					}
				}
			}

			if ((var22 & 128) != 0) {
				var14.targetIndex = var1.readUnsignedShort();
				var14.targetIndex += var1.readUnsignedByteSub() << 16;
				var6 = 16777215;
				if (var6 == var14.targetIndex) {
					var14.targetIndex = -1;
				}
			}

			if ((var22 & 2) != 0) {
				var6 = var1.readUnsignedShortAdd();
				if (var6 > 0) {
					for (var19 = 0; var19 < var6; ++var19) {
						var9 = -1;
						var10 = -1;
						var23 = -1;
						var8 = var1.readUShortSmart();
						if (var8 == 32767) {
							var8 = var1.readUShortSmart();
							var10 = var1.readUShortSmart();
							var9 = var1.readUShortSmart();
							var23 = var1.readUShortSmart();
						} else if (var8 != 32766) {
							var10 = var1.readUShortSmart();
						} else {
							var8 = -1;
						}

						var12 = var1.readUShortSmart();
						var14.addHitSplat(var8, var10, var9, var23, Client.cycle, var12);
					}
				}

				var19 = var1.readUnsignedByteNeg();
				if (var19 > 0) {
					for (var8 = 0; var8 < var19; ++var8) {
						var9 = var1.readUShortSmart();
						var10 = var1.readUShortSmart();
						if (var10 != 32767) {
							var23 = var1.readUShortSmart();
							var12 = var1.readUnsignedByte();
							int var13 = var10 > 0 ? var1.readUnsignedByte() : var12;
							var14.addHealthBar(var9, Client.cycle, var10, var23, var12, var13);
						} else {
							var14.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var22 & 16384) != 0) {
				var14.method575(var1.readStringCp1252NullTerminated());
			}

			if ((var22 & 32768) != 0) {
				var14.method576(var1.readUnsignedByteSub());
			}

			if ((var22 & 131072) != 0) {
				var6 = var1.readUnsignedByte();

				for (var19 = 0; var19 < var6; ++var19) {
					var8 = var1.readUnsignedByte();
					var9 = var1.readUnsignedShort();
					var10 = var1.readIntIME();
					var14.updateSpotAnimation(var8, var9, var10 >> 16, var10 & 65535);
				}
			}

			if ((var22 & 2048) != 0) {
				var14.recolourStartCycle = Client.cycle + var1.readUnsignedShortLE();
				var14.recolourEndCycle = Client.cycle + var1.readUnsignedShortAddLE();
				var14.recolourHue = var1.readByteAdd();
				var14.recolourSaturation = var1.readByteNeg();
				var14.recolourLuminance = var1.readByteAdd();
				var14.recolourAmount = (byte)var1.readUnsignedByteNeg();
			}

			if ((var22 & 512) != 0) {
				var6 = var1.readUnsignedByteSub();
				if ((var6 & 1) == 1) {
					var14.method592();
				} else {
					var7 = null;
					if ((var6 & 2) == 2) {
						var8 = var1.readUnsignedByteSub();
						var7 = new int[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var10 = var1.readUnsignedShort();
							var10 = var10 == 65535 ? -1 : var10;
							var7[var9] = var10;
						}
					}

					var15 = null;
					if ((var6 & 4) == 4) {
						var9 = 0;
						if (var14.definition.recolorTo != null) {
							var9 = var14.definition.recolorTo.length;
						}

						var15 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var15[var10] = (short)var1.readUnsignedShort();
						}
					}

					var16 = null;
					if ((var6 & 8) == 8) {
						var10 = 0;
						if (var14.definition.retextureTo != null) {
							var10 = var14.definition.retextureTo.length;
						}

						var16 = new short[var10];

						for (var23 = 0; var23 < var10; ++var23) {
							var16[var23] = (short)var1.readUnsignedIntIME();
						}
					}

					var24 = false;
					if ((var6 & 16) != 0) {
						var24 = var1.readUnsignedShortAdd() == 1;
					}

					var17 = (long)(++NPC.field1081 - 1);
					var14.method589(new NewShit(var17, var7, var15, var16, var24));
				}
			}

			if ((var22 & 8) != 0) {
				var14.definition = VerticalAlignment.getNpcDefinition(var1.readUnsignedShortLE());
				class33.method144(var14);
				var14.method588();
			}

			if ((var22 & 4) != 0) {
				var14.overheadText = var1.readStringCp1252NullTerminated();
				var14.overheadTextCyclesRemaining = 100;
			}

			if ((var22 & 64) != 0) {
				var1.readUnsignedIntIME();
				var1.readUnsignedIntME();
			}
		}

		for (var21 = 0; var21 < Client.field489; ++var21) {
			var3 = Client.field559[var21];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var21 = 0; var21 < Client.npcCount; ++var21) {
				if (Client.npcs[Client.npcIndices[var21]] == null) {
					throw new RuntimeException(var21 + "," + Client.npcCount);
				}
			}

		}
	}
}