import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.BitSet;

@ObfuscatedName("my")
public class class332 extends Node {
	@ObfuscatedName("ac")
	int field2895;
	@ObfuscatedName("al")
	BitSet field2896;

	class332(int var1) {
		this.field2895 = var1;
		this.field2896 = new BitSet(128);
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		descriptor = "(ZLuy;I)V",
		garbageValue = "2118721779"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field492 = 0;
		Client.field450 = 0;
		var1.importIndex();
		int var2 = var1.readBits(8);
		int var3;
		if (var2 < Client.npcCount) {
			for (var3 = var2; var3 < Client.npcCount; ++var3) {
				Client.field561[++Client.field492 - 1] = Client.npcIndices[var3];
			}
		}

		if (var2 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			int var6;
			int var7;
			int var8;
			int var9;
			for (var3 = 0; var3 < var2; ++var3) {
				int var4 = Client.npcIndices[var3];
				NPC var5 = Client.npcs[var4];
				var6 = var1.readBits(1);
				if (var6 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var4;
					var5.npcCycle = Client.cycle;
				} else {
					var7 = var1.readBits(2);
					if (var7 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var4;
						var5.npcCycle = Client.cycle;
						Client.field552[++Client.field450 - 1] = var4;
					} else if (var7 == 1) {
						Client.npcIndices[++Client.npcCount - 1] = var4;
						var5.npcCycle = Client.cycle;
						var8 = var1.readBits(3);
						var5.move(var8, MoveSpeed.WALK);
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.field552[++Client.field450 - 1] = var4;
						}
					} else if (var7 == 2) {
						Client.npcIndices[++Client.npcCount - 1] = var4;
						var5.npcCycle = Client.cycle;
						if (var1.readBits(1) == 1) {
							var8 = var1.readBits(3);
							var5.move(var8, MoveSpeed.RUN);
							var9 = var1.readBits(3);
							var5.move(var9, MoveSpeed.RUN);
						} else {
							var8 = var1.readBits(3);
							var5.move(var8, MoveSpeed.CRAWL);
						}

						var8 = var1.readBits(1);
						if (var8 == 1) {
							Client.field552[++Client.field450 - 1] = var4;
						}
					} else if (var7 == 3) {
						Client.field561[++Client.field492 - 1] = var4;
					}
				}
			}

			class13.method44(var0, var1);

			for (var2 = 0; var2 < Client.field450; ++var2) {
				var3 = Client.field552[var2];
				NPC var14 = Client.npcs[var3];
				int var15 = var1.readUnsignedByte();
				if ((var15 & 64) != 0) {
					var6 = var1.readUnsignedByte();
					var15 += var6 << 8;
				}

				if ((var15 & 2048) != 0) {
					var6 = var1.readUnsignedByte();
					var15 += var6 << 16;
				}

				if ((var15 & 128) != 0) {
					var6 = var1.readUnsignedShortAdd();
					if (var6 == 65535) {
						var6 = -1;
					}

					var7 = var1.readUnsignedByte();
					if (var6 == var14.sequence && var6 != -1) {
						var8 = class36.SequenceDefinition_get(var6).replyMode;
						if (var8 == 1) {
							var14.sequenceFrame = 0;
							var14.sequenceFrameCycle = 0;
							var14.sequenceDelay = var7;
							var14.currentSequenceFrameIndex = 0;
						}

						if (var8 == 2) {
							var14.currentSequenceFrameIndex = 0;
						}
					} else if (var6 == -1 || var14.sequence == -1 || class36.SequenceDefinition_get(var6).forcedPriority >= class36.SequenceDefinition_get(var14.sequence).forcedPriority) {
						var14.sequence = var6;
						var14.sequenceFrame = 0;
						var14.sequenceFrameCycle = 0;
						var14.sequenceDelay = var7;
						var14.currentSequenceFrameIndex = 0;
						var14.field1023 = var14.pathLength;
					}
				}

				if ((var15 & 2) != 0) {
					var14.definition = class190.getNpcDefinition(var1.readIntME());
					WorldMapLabel.method1571(var14);
					var14.method591();
				}

				if ((var15 & 32768) != 0) {
					var14.field1016 = var1.readByteAdd();
					var14.field1013 = var1.readByte();
					var14.field1021 = var1.readByte();
					var14.field1010 = var1.readByteSub();
					var14.spotAnimation = var1.readIntME() + Client.cycle;
					var14.exactMoveArrive1Cycle = var1.readUnsignedShort() + Client.cycle;
					var14.exactMoveDirection = var1.readUnsignedShortAdd();
					var14.pathLength = 1;
					var14.field1023 = 0;
					var14.field1016 += var14.pathX[0];
					var14.field1013 += var14.pathY[0];
					var14.field1021 += var14.pathX[0];
					var14.field1010 += var14.pathY[0];
				}

				if ((var15 & 8) != 0) {
					var1.readUnsignedShort();
					var1.readInt();
				}

				int var10;
				int var11;
				int[] var16;
				short[] var17;
				short[] var18;
				long var19;
				boolean var22;
				if ((var15 & 16384) != 0) {
					var6 = var1.readUnsignedByte();
					if ((var6 & 1) == 1) {
						var14.method595();
					} else {
						var16 = null;
						if ((var6 & 2) == 2) {
							var8 = var1.readUnsignedByteAdd();
							var16 = new int[var8];

							for (var9 = 0; var9 < var8; ++var9) {
								var10 = var1.readUnsignedShortAdd();
								var10 = var10 == 65535 ? -1 : var10;
								var16[var9] = var10;
							}
						}

						var17 = null;
						if ((var6 & 4) == 4) {
							var9 = 0;
							if (var14.definition.recolorTo != null) {
								var9 = var14.definition.recolorTo.length;
							}

							var17 = new short[var9];

							for (var10 = 0; var10 < var9; ++var10) {
								var17[var10] = (short)var1.readUnsignedShortAdd();
							}
						}

						var18 = null;
						if ((var6 & 8) == 8) {
							var10 = 0;
							if (var14.definition.retextureTo != null) {
								var10 = var14.definition.retextureTo.length;
							}

							var18 = new short[var10];

							for (var11 = 0; var11 < var10; ++var11) {
								var18[var11] = (short)var1.readUnsignedShort();
							}
						}

						var22 = false;
						if ((var6 & 16) != 0) {
							var22 = var1.readUnsignedByteNeg() == 1;
						}

						var19 = (long)(++NPC.field1076 - 1);
						var14.method592(new NewShit(var19, var16, var17, var18, var22));
					}
				}

				if ((var15 & 512) != 0) {
					var14.method578(var1.readStringCp1252NullTerminated());
				}

				if ((var15 & 4096) != 0) {
					var6 = var1.readUnsignedByteAdd();
					if ((var6 & 1) == 1) {
						var14.method596();
					} else {
						var16 = null;
						if ((var6 & 2) == 2) {
							var8 = var1.readUnsignedByte();
							var16 = new int[var8];

							for (var9 = 0; var9 < var8; ++var9) {
								var10 = var1.readIntME();
								var10 = var10 == 65535 ? -1 : var10;
								var16[var9] = var10;
							}
						}

						var17 = null;
						if ((var6 & 4) == 4) {
							var9 = 0;
							if (var14.definition.recolorTo != null) {
								var9 = var14.definition.recolorTo.length;
							}

							var17 = new short[var9];

							for (var10 = 0; var10 < var9; ++var10) {
								var17[var10] = (short)var1.readIntME();
							}
						}

						var18 = null;
						if ((var6 & 8) == 8) {
							var10 = 0;
							if (var14.definition.retextureTo != null) {
								var10 = var14.definition.retextureTo.length;
							}

							var18 = new short[var10];

							for (var11 = 0; var11 < var10; ++var11) {
								var18[var11] = (short)var1.readUnsignedShortAdd();
							}
						}

						var22 = false;
						if ((var6 & 16) != 0) {
							var22 = var1.readUnsignedByte() == 1;
						}

						var19 = (long)(++NPC.field1077 - 1);
						var14.method594(new NewShit(var19, var16, var17, var18, var22));
					}
				}

				if ((var15 & 262144) != 0) {
					var6 = var1.readInt();
					var14.turnLeftSequence = (var6 & 1) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.turnLeftSequence * -683029639 * -518279479;
					var14.turnRightSequence = (var6 & 2) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.turnRightSequence * -650094419 * 53136165;
					var14.walkSequence = (var6 & 4) != 0 ? var1.readUnsignedShortAdd() : var14.definition.walkSequence * 12153249 * 1652208225;
					var14.walkBackSequence = (var6 & 8) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.walkBackSequence * -601680513 * 514763391;
					var14.walkLeftSequence = (var6 & 16) != 0 ? var1.readUnsignedShort() : var14.definition.walkLeftSequence * 407029447 * 193862391;
					var14.walkRightSequence = (var6 & 32) != 0 ? var1.readIntME() : var14.definition.walkRightSequence * -1457167705 * 1557013783;
					var14.runSequence = (var6 & 64) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.runSequence * -1220844931 * -1279088939;
					var14.runBackSequence = (var6 & 128) != 0 ? var1.readUnsignedShortAdd() : var14.definition.runBackSequence * -1135999935 * -1929114687;
					var14.runLeftSequence = (var6 & 256) != 0 ? var1.readIntME() : var14.definition.runLeftSequence * 1482173473 * -1555933215;
					var14.runRightSequence = (var6 & 512) != 0 ? var1.readUnsignedShort() : var14.definition.runRightSequence * -2140161505 * -936033825;
					var14.crawlSequence = (var6 & 1024) != 0 ? var1.readUnsignedShort() : var14.definition.crawlSequence * 700539735 * 578435175;
					var14.crawlBackSequence = (var6 & 2048) != 0 ? var1.readUnsignedShort() : var14.definition.crawlBackSequence * 279963805 * -2084184651;
					var14.crawlLeftSequence = (var6 & 4096) != 0 ? var1.readIntME() : var14.definition.crawlLeftSequence * -2021467469 * 1677812859;
					var14.crawlRightSequence = (var6 & 8192) != 0 ? var1.readUnsignedShortAdd() : var14.definition.crawlRightSequence * 1071402625 * 999682433;
					var14.idleSequence = (var6 & 16384) != 0 ? var1.readUnsignedShortAddLE() : var14.definition.idleSequence * -771436155 * 1122795341;
				}

				if ((var15 & 131072) != 0) {
					var6 = var1.readUnsignedByteAdd();

					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var1.readUnsignedByteSub();
						var9 = var1.readUnsignedShortAddLE();
						var10 = var1.readUnsignedIntME();
						var14.updateSpotAnimation(var8, var9, var10 >> 16, var10 & 65535);
					}
				}

				if ((var15 & 8192) != 0) {
					var14.method579(var1.readUnsignedByteSub());
				}

				if ((var15 & 32) != 0) {
					var14.overheadText = var1.readStringCp1252NullTerminated();
					var14.overheadTextCyclesRemaining = 100;
				}

				if ((var15 & 16) != 0) {
					var6 = var1.readUnsignedShort();
					var7 = var1.readIntME();
					var14.field964 = var1.readUnsignedByteAdd() == 1;
					if (Client.param25 >= 212) {
						var14.field995 = var6;
						var14.field996 = var7;
					} else {
						var8 = var14.x - (var6 - class20.baseX - class20.baseX) * 64;
						var9 = var14.y - (var7 - class19.baseY - class19.baseY) * 64;
						if (var8 != 0 || var9 != 0) {
							var11 = (int)(Math.atan2((double)var8, (double)var9) * 325.94932345220167D) & 2047;
							var14.movingOrientation = var11;
						}
					}
				}

				if ((var15 & 256) != 0) {
					var14.combatLevelChange = var1.readUnsignedIntLE();
				}

				if ((var15 & 4) != 0) {
					var14.targetIndex = var1.readIntME();
					var14.targetIndex += var1.readUnsignedByte() << 16;
					var6 = 16777215;
					if (var6 == var14.targetIndex) {
						var14.targetIndex = -1;
					}
				}

				if ((var15 & 1) != 0) {
					var6 = var1.readUnsignedByte();
					int var12;
					if (var6 > 0) {
						for (var7 = 0; var7 < var6; ++var7) {
							var9 = -1;
							var10 = -1;
							var11 = -1;
							var8 = var1.readUShortSmart();
							if (var8 == 32767) {
								var8 = var1.readUShortSmart();
								var10 = var1.readUShortSmart();
								var9 = var1.readUShortSmart();
								var11 = var1.readUShortSmart();
							} else if (var8 != 32766) {
								var10 = var1.readUShortSmart();
							} else {
								var8 = -1;
							}

							var12 = var1.readUShortSmart();
							var14.addHitSplat(var8, var10, var9, var11, Client.cycle, var12);
						}
					}

					var7 = var1.readUnsignedByteAdd();
					if (var7 > 0) {
						for (var8 = 0; var8 < var7; ++var8) {
							var9 = var1.readUShortSmart();
							var10 = var1.readUShortSmart();
							if (var10 != 32767) {
								var11 = var1.readUShortSmart();
								var12 = var1.readUnsignedByte();
								int var13 = var10 > 0 ? var1.readUnsignedByteNeg() : var12;
								var14.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
							} else {
								var14.removeHealthBar(var9);
							}
						}
					}
				}

				if ((var15 & 1024) != 0) {
					var14.recolourStartCycle = Client.cycle + var1.readUnsignedShort();
					var14.recolourEndCycle = Client.cycle + var1.readUnsignedShortAddLE();
					var14.recolourHue = var1.readByteSub();
					var14.recolourSaturation = var1.readByte();
					var14.recolourLuminance = var1.readByteNeg();
					var14.recolourAmount = (byte)var1.readUnsignedByte();
				}

				if ((var15 & 65536) != 0) {
					var6 = var1.readUnsignedByteNeg();
					var16 = new int[8];
					var17 = new short[8];

					for (var9 = 0; var9 < 8; ++var9) {
						if ((var6 & 1 << var9) != 0) {
							var16[var9] = var1.readNullableLargeSmart();
							var17[var9] = (short)var1.readShortSmartSub();
						} else {
							var16[var9] = -1;
							var17[var9] = -1;
						}
					}

					var14.method590(var16, var17);
				}
			}

			for (var2 = 0; var2 < Client.field492; ++var2) {
				var3 = Client.field561[var2];
				if (Client.npcs[var3].npcCycle != Client.cycle) {
					Client.npcs[var3].definition = null;
					Client.npcs[var3] = null;
				}
			}

			if (var1.offset != Client.packetWriter.serverPacketLength) {
				throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
			} else {
				for (var2 = 0; var2 < Client.npcCount; ++var2) {
					if (Client.npcs[Client.npcIndices[var2]] == null) {
						throw new RuntimeException(var2 + "," + Client.npcCount);
					}
				}

			}
		}
	}
}