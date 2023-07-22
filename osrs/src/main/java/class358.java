import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nx")
public class class358 extends DualNode {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	Archive field3518;
	@ObfuscatedName("ay")
	int field3517;
	@ObfuscatedName("ar")
	byte field3516;

	class358() {
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "70"
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

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "([BIIB)I",
		garbageValue = "0"
	)
	static int method1864(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		descriptor = "(ZLtc;I)V",
		garbageValue = "-720645536"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field488 = 0;
		Client.field446 = 0;
		class53.method298(var1);

		int var3;
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
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

			NPC var6 = Client.npcs[var4];
			Client.npcIndices[++Client.npcCount - 1] = var4;
			var6.npcCycle = Client.cycle;
			var10 = var1.readBits(1);
			if (var10 == 1) {
				Client.field549[++Client.field446 - 1] = var4;
			}

			var7 = var1.readBits(1);
			boolean var11 = var1.readBits(1) == 1;
			if (var11) {
				var1.readBits(32);
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

			var6.definition = Tile.getNpcDefinition(var1.readBits(14));
			var12 = Client.field559[var1.readBits(3)];
			if (var5) {
				var6.orientation = var6.rotation = var12;
			}

			Client.method383(var6);
			if (var6.field1005 == 0) {
				var6.rotation = 0;
			}

			var6.method588(class136.localPlayer.pathX[0] + var8, class136.localPlayer.pathY[0] + var9, var7 == 1);
		}

		var1.exportIndex();

		int var22;
		for (var22 = 0; var22 < Client.field446; ++var22) {
			var3 = Client.field549[var22];
			NPC var14 = Client.npcs[var3];
			int var23 = var1.readUnsignedByte();
			int var15;
			if ((var23 & 32) != 0) {
				var15 = var1.readUnsignedByte();
				var23 += var15 << 8;
			}

			if ((var23 & 1024) != 0) {
				var15 = var1.readUnsignedByte();
				var23 += var15 << 16;
			}

			if ((var23 & 8) != 0) {
				var14.targetIndex = var1.readUnsignedShort();
				var14.targetIndex += var1.readUnsignedByte() << 16;
				var15 = 16777215;
				if (var15 == var14.targetIndex) {
					var14.targetIndex = -1;
				}
			}

			if ((var23 & 1) != 0) {
				var14.definition = Tile.getNpcDefinition(var1.readUnsignedShortAddLE());
				Client.method383(var14);
				var14.method595();
			}

			if ((var23 & 4) != 0) {
				var15 = var1.readUnsignedByteAdd();
				if (var15 == 65535) {
					var15 = -1;
				}

				var7 = var1._readUnsignedByteSub();
				if (var15 == var14.sequence && var15 != -1) {
					var8 = class135.SequenceDefinition_get(var15).replyMode;
					if (var8 == 1) {
						var14.sequenceFrame = 0;
						var14.sequenceFrameCycle = 0;
						var14.sequenceDelay = var7;
						var14.currentSequenceFrameIndex = 0;
					}

					if (var8 == 2) {
						var14.currentSequenceFrameIndex = 0;
					}
				} else if (var15 == -1 || var14.sequence == -1 || class135.SequenceDefinition_get(var15).forcedPriority >= class135.SequenceDefinition_get(var14.sequence).forcedPriority) {
					var14.sequence = var15;
					var14.sequenceFrame = 0;
					var14.sequenceFrameCycle = 0;
					var14.sequenceDelay = var7;
					var14.currentSequenceFrameIndex = 0;
					var14.field1018 = var14.pathLength;
				}
			}

			if ((var23 & 64) != 0) {
				var1.readUnsignedByteAdd();
				var1.readInt();
			}

			int[] var16;
			short[] var17;
			short[] var18;
			long var19;
			int var24;
			boolean var25;
			if ((var23 & 512) != 0) {
				var15 = var1._readUnsignedByteSub();
				if ((var15 & 1) == 1) {
					var14.method599();
				} else {
					var16 = null;
					if ((var15 & 2) == 2) {
						var8 = var1.method2557();
						var16 = new int[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var10 = var1.readUnsignedShort();
							var10 = var10 == 65535 ? -1 : var10;
							var16[var9] = var10;
						}
					}

					var17 = null;
					if ((var15 & 4) == 4) {
						var9 = 0;
						if (var14.definition.recolorTo != null) {
							var9 = var14.definition.recolorTo.length;
						}

						var17 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var17[var10] = (short)var1.readUnsignedShort();
						}
					}

					var18 = null;
					if ((var15 & 8) == 8) {
						var10 = 0;
						if (var14.definition.retextureTo != null) {
							var10 = var14.definition.retextureTo.length;
						}

						var18 = new short[var10];

						for (var24 = 0; var24 < var10; ++var24) {
							var18[var24] = (short)var1.readUnsignedShortAddLE();
						}
					}

					var25 = false;
					if ((var15 & 16) != 0) {
						var25 = var1.readUnsignedByte() == 1;
					}

					var19 = (long)(++NPC.field1069 - 1);
					var14.method596(new NewShit(var19, var16, var17, var18, var25));
				}
			}

			if ((var23 & 256) != 0) {
				var15 = var1._readUnsignedByteSub();
				if ((var15 & 1) == 1) {
					var14.method600();
				} else {
					var16 = null;
					if ((var15 & 2) == 2) {
						var8 = var1.method2556();
						var16 = new int[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var10 = var1.readUnsignedShort();
							var10 = var10 == 65535 ? -1 : var10;
							var16[var9] = var10;
						}
					}

					var17 = null;
					if ((var15 & 4) == 4) {
						var9 = 0;
						if (var14.definition.recolorTo != null) {
							var9 = var14.definition.recolorTo.length;
						}

						var17 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var17[var10] = (short)var1.readUnsignedByteAdd();
						}
					}

					var18 = null;
					if ((var15 & 8) == 8) {
						var10 = 0;
						if (var14.definition.retextureTo != null) {
							var10 = var14.definition.retextureTo.length;
						}

						var18 = new short[var10];

						for (var24 = 0; var24 < var10; ++var24) {
							var18[var24] = (short)var1.readUnsignedByteAdd();
						}
					}

					var25 = false;
					if ((var15 & 16) != 0) {
						var25 = var1.method2557() == 1;
					}

					var19 = (long)(++NPC.field1068 - 1);
					var14.method598(new NewShit(var19, var16, var17, var18, var25));
				}
			}

			if ((var23 & 262144) != 0) {
				var15 = var1.method2578();
				var14.turnLeftSequence = (var15 & 1) != 0 ? var1.readUnsignedByteAdd() : var14.definition.turnLeftSequence * -1164304999 * -740038999;
				var14.turnRightSequence = (var15 & 2) != 0 ? var1.readUnsignedShort() : var14.definition.turnRightSequence * 618248039 * -858229673;
				var14.walkSequence = (var15 & 4) != 0 ? var1.readUnsignedShort() : var14.definition.walkSequence * 1701863897 * -717353367;
				var14.walkBackSequence = (var15 & 8) != 0 ? var1.readUnsignedByteAdd() : var14.definition.walkBackSequence * 2045371335 * 551218679;
				var14.walkLeftSequence = (var15 & 16) != 0 ? var1.readUnsignedShortAdd() : var14.definition.walkLeftSequence * -836382071 * 2076787641;
				var14.walkRightSequence = (var15 & 32) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.walkRightSequence * 1238970345 * 724342873;
				var14.runSequence = (var15 & 64) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.runSequence * 1872771113 * -1352211431;
				var14.runBackSequence = (var15 & 128) != 0 ? var1.readUnsignedShort() : var14.definition.runBackSequence * -493138789 * -1789544045;
				var14.runLeftSequence = (var15 & 256) != 0 ? var1.readUnsignedShortAdd() : var14.definition.runLeftSequence * 1890594435 * -1702883285;
				var14.runRightSequence = (var15 & 512) != 0 ? var1.readUnsignedShortAdd() : var14.definition.runRightSequence * -879943903 * 12002529;
				var14.crawlSequence = (var15 & 1024) != 0 ? var1.readUnsignedByteAdd() : var14.definition.crawlSequence * 1478538629 * -1703871667;
				var14.crawlBackSequence = (var15 & 2048) != 0 ? var1.readUnsignedByteAdd() : var14.definition.crawlBackSequence * -1355856507 * 474737485;
				var14.crawlLeftSequence = (var15 & 4096) != 0 ? var1.readUnsignedShortAdd() : var14.definition.crawlLeftSequence * 1944282437 * 904488333;
				var14.crawlRightSequence = (var15 & 8192) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.crawlRightSequence * 881727523 * 1352095627;
				var14.idleSequence = (var15 & 16384) != 0 ? var1.readUnsignedByteAdd() : var14.definition.idleSequence * -1626376685 * 1344848923;
			}

			if ((var23 & 131072) != 0) {
				var15 = var1.method2557();

				for (var7 = 0; var7 < var15; ++var7) {
					var8 = var1.method2557();
					var9 = var1.readUnsignedShort();
					var10 = var1.method2578();
					var14.updateSpotAnimation(var8, var9, var10 >> 16, var10 & 65535);
				}
			}

			if ((var23 & 32768) != 0) {
				var14.field1013 = var1.readUnsignedByteSub();
				var14.field1007 = var1.readByteAdd();
				var14.field1011 = var1.readByte();
				var14.field1010 = var1.readByte();
				var14.spotAnimation = var1.readUnsignedShort() + Client.cycle;
				var14.exactMoveArrive1Cycle = var1.readUnsignedByteAdd() + Client.cycle;
				var14.exactMoveDirection = var1.readUnsignedShortAddLE();
				var14.pathLength = 1;
				var14.field1018 = 0;
				var14.field1013 += var14.pathX[0];
				var14.field1007 += var14.pathY[0];
				var14.field1011 += var14.pathX[0];
				var14.field1010 += var14.pathY[0];
			}

			if ((var23 & 2) != 0) {
				var15 = var1.readUnsignedShortAdd();
				var7 = var1.readUnsignedShortAdd();
				var14.field958 = var1.readUnsignedByte() == 1;
				if (Client.param25 >= 212) {
					var14.field997 = var15;
					var14.field992 = var7;
				} else {
					var8 = var14.x - (var15 - AbstractArchive.baseX - AbstractArchive.baseX) * 64;
					var9 = var14.y - (var7 - class148.baseY - class148.baseY) * 64;
					if (var8 != 0 || var9 != 0) {
						var24 = (int)(Math.atan2((double)var8, (double)var9) * 325.94932345220167D) & 2047;
						var14.movingOrientation = var24;
					}
				}
			}

			if ((var23 & 4096) != 0) {
				var14.recolourStartCycle = Client.cycle + var1.readUnsignedByteAdd();
				var14.recolourEndCycle = Client.cycle + var1.readUnsignedShort();
				var14.recolourHue = var1.readByteAdd();
				var14.recolourSaturation = var1.readByte();
				var14.recolourLuminance = var1.readByteNeg();
				var14.recolourAmount = (byte)var1.readUnsignedByte();
			}

			if ((var23 & 16) != 0) {
				var15 = var1.readUnsignedByte();
				if (var15 > 0) {
					for (var7 = 0; var7 < var15; ++var7) {
						var9 = -1;
						var10 = -1;
						var24 = -1;
						var8 = var1.readUShortSmart();
						if (var8 == 32767) {
							var8 = var1.readUShortSmart();
							var10 = var1.readUShortSmart();
							var9 = var1.readUShortSmart();
							var24 = var1.readUShortSmart();
						} else if (var8 != 32766) {
							var10 = var1.readUShortSmart();
						} else {
							var8 = -1;
						}

						var12 = var1.readUShortSmart();
						var14.addHitSplat(var8, var10, var9, var24, Client.cycle, var12);
					}
				}

				var7 = var1.readUnsignedByte();
				if (var7 > 0) {
					for (var8 = 0; var8 < var7; ++var8) {
						var9 = var1.readUShortSmart();
						var10 = var1.readUShortSmart();
						if (var10 != 32767) {
							var24 = var1.readUShortSmart();
							var12 = var1._readUnsignedByteSub();
							int var13 = var10 > 0 ? var1._readUnsignedByteSub() : var12;
							var14.addHealthBar(var9, Client.cycle, var10, var24, var12, var13);
						} else {
							var14.removeHealthBar(var9);
						}
					}
				}
			}

			if ((var23 & 8192) != 0) {
				var14.method584(var1.method2557());
			}

			if ((var23 & 16384) != 0) {
				var14.combatLevelChange = var1.readUnsignedByteNeg();
			}

			if ((var23 & 65536) != 0) {
				var15 = var1.method2556();
				var16 = new int[8];
				var17 = new short[8];

				for (var9 = 0; var9 < 8; ++var9) {
					if ((var15 & 1 << var9) != 0) {
						var16[var9] = var1.method2543();
						var17[var9] = (short)var1.method2540();
					} else {
						var16[var9] = -1;
						var17[var9] = -1;
					}
				}

				var14.method594(var16, var17);
			}

			if ((var23 & 2048) != 0) {
				var14.method582(var1.readStringCp1252NullTerminated());
			}

			if ((var23 & 128) != 0) {
				var14.overheadText = var1.readStringCp1252NullTerminated();
				var14.overheadTextCyclesRemaining = 100;
			}
		}

		for (var22 = 0; var22 < Client.field488; ++var22) {
			var3 = Client.field558[var22];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var22 = 0; var22 < Client.npcCount; ++var22) {
				if (Client.npcs[Client.npcIndices[var22]] == null) {
					throw new RuntimeException(var22 + "," + Client.npcCount);
				}
			}

		}
	}
}
