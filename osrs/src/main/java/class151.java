import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class151 extends class159 {
	@ObfuscatedName("bw")
	static String field1365;
	@ObfuscatedName("au")
	int field1366;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgg;"
	)
	final class160 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgg;)V"
	)
	class151(class160 var1) {
		this.this$0 = var1;
		this.field1366 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3238")
	void vmethod3238(Buffer var1) {
		this.field1366 = var1.readUnsignedShort();
		var1.readUnsignedByte();
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;I)V",
		garbageValue = "831405774"
	)
	@Export("vmethod3239")
	void vmethod3239(ClanChannel var1) {
		var1.removeMember(this.field1366);
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		descriptor = "(Lto;I)V",
		garbageValue = "-619616137"
	)
	static final void method795(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field451; ++var1) {
			int var2 = Client.field552[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			if ((var4 & 8) != 0) {
				var5 = var0.readUnsignedByte();
				var4 += var5 << 8;
			}

			if ((var4 & 2048) != 0) {
				var5 = var0.readUnsignedByte();
				var4 += var5 << 16;
			}

			int var6;
			int var7;
			int var8;
			int var9;
			int var10;
			if ((var4 & 128) != 0) {
				var5 = var0.readUnsignedByteNeg();
				int var11;
				if (var5 > 0) {
					for (var6 = 0; var6 < var5; ++var6) {
						var8 = -1;
						var9 = -1;
						var10 = -1;
						var7 = var0.readUShortSmart();
						if (var7 == 32767) {
							var7 = var0.readUShortSmart();
							var9 = var0.readUShortSmart();
							var8 = var0.readUShortSmart();
							var10 = var0.readUShortSmart();
						} else if (var7 != 32766) {
							var9 = var0.readUShortSmart();
						} else {
							var7 = -1;
						}

						var11 = var0.readUShortSmart();
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
					}
				}

				var6 = var0.readUnsignedByteSub();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.readUnsignedByteNeg();
							int var12 = var9 > 0 ? var0.readUnsignedByteNeg() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			int[] var13;
			short[] var14;
			short[] var15;
			long var16;
			boolean var19;
			if ((var4 & 512) != 0) {
				var5 = var0.readUnsignedByte();
				if ((var5 & 1) == 1) {
					var3.method595();
				} else {
					var13 = null;
					if ((var5 & 2) == 2) {
						var7 = var0.readUnsignedByteAdd();
						var13 = new int[var7];

						for (var8 = 0; var8 < var7; ++var8) {
							var9 = var0.method2587();
							var9 = var9 == 65535 ? -1 : var9;
							var13[var8] = var9;
						}
					}

					var14 = null;
					if ((var5 & 4) == 4) {
						var8 = 0;
						if (var3.definition.recolorTo != null) {
							var8 = var3.definition.recolorTo.length;
						}

						var14 = new short[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var14[var9] = (short)var0.readUnsignedShortLE();
						}
					}

					var15 = null;
					if ((var5 & 8) == 8) {
						var9 = 0;
						if (var3.definition.retextureTo != null) {
							var9 = var3.definition.retextureTo.length;
						}

						var15 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var15[var10] = (short)var0.readUnsignedShortLE();
						}
					}

					var19 = false;
					if ((var5 & 16) != 0) {
						var19 = var0.readUnsignedByteSub() == 1;
					}

					var16 = (long)(++NPC.field1074 - 1);
					var3.method592(new NewShit(var16, var13, var14, var15, var19));
				}
			}

			if ((var4 & 32) != 0) {
				var5 = var0.readUnsignedShortLE();
				var6 = var0.readUnsignedShort();
				var3.field959 = var0.readUnsignedByteNeg() == 1;
				if (Client.param25 >= 212) {
					var3.field988 = var5;
					var3.field989 = var6;
				} else {
					var7 = var3.x - (var5 - UrlRequester.baseX - UrlRequester.baseX) * 64;
					var8 = var3.y - (var6 - class47.baseY - class47.baseY) * 64;
					if (var7 != 0 || var8 != 0) {
						var10 = (int)(Math.atan2((double)var7, (double)var8) * 325.94932345220167D) & 2047;
						var3.movingOrientation = var10;
					}
				}
			}

			if ((var4 & 64) != 0) {
				var5 = var0.readUnsignedShort();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.readUnsignedByteSub();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = EnumComposition.SequenceDefinition_get(var5).replyMode;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.currentSequenceFrameIndex = 0;
					}

					if (var7 == 2) {
						var3.currentSequenceFrameIndex = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || EnumComposition.SequenceDefinition_get(var5).forcedPriority >= EnumComposition.SequenceDefinition_get(var3.sequence).forcedPriority) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.currentSequenceFrameIndex = 0;
					var3.field1022 = var3.pathLength;
				}
			}

			if ((var4 & 131072) != 0) {
				var5 = var0.readUnsignedByteNeg();

				for (var6 = 0; var6 < var5; ++var6) {
					var7 = var0.readUnsignedByteSub();
					var8 = var0.method2587();
					var9 = var0.method2598();
					var3.updateSpotAnimation(var7, var8, var9 >> 16, var9 & 65535);
				}
			}

			if ((var4 & 4) != 0) {
				var3.definition = class90.getNpcDefinition(var0.readUnsignedShort());
				ItemLayer.method1152(var3);
				var3.method591();
			}

			if ((var4 & 16) != 0) {
				var3.targetIndex = var0.readIntME();
				var3.targetIndex += var0.readUnsignedByteSub() << 16;
				var5 = 16777215;
				if (var5 == var3.targetIndex) {
					var3.targetIndex = -1;
				}
			}

			if ((var4 & 4096) != 0) {
				var3.field1004 = var0.readSignedByteSub();
				var3.field1001 = var0.readSignedByteSub();
				var3.field1002 = var0.readByteNeg();
				var3.field1014 = var0.readByteAdd();
				var3.spotAnimation = var0.readIntME() + Client.cycle;
				var3.exactMoveArrive1Cycle = var0.readUnsignedShort() + Client.cycle;
				var3.exactMoveDirection = var0.method2587();
				var3.pathLength = 1;
				var3.field1022 = 0;
				var3.field1004 += var3.pathX[0];
				var3.field1001 += var3.pathY[0];
				var3.field1002 += var3.pathX[0];
				var3.field1014 += var3.pathY[0];
			}

			if ((var4 & 65536) != 0) {
				var5 = var0.readIntIME();
				var3.turnLeftSequence = (var5 & 1) != 0 ? var0.method2587() : var3.definition.turnLeftSequence * -1670226789 * 1686120851;
				var3.turnRightSequence = (var5 & 2) != 0 ? var0.readUnsignedShortLE() : var3.definition.turnRightSequence * -1405323159 * 821598169;
				var3.walkSequence = (var5 & 4) != 0 ? var0.readIntME() : var3.definition.walkSequence * 636917019 * 934984979;
				var3.walkBackSequence = (var5 & 8) != 0 ? var0.method2587() : var3.definition.walkBackSequence * 129510829 * 1271381541;
				var3.walkLeftSequence = (var5 & 16) != 0 ? var0.readUnsignedShortLE() : var3.definition.walkLeftSequence * 799501513 * -1909691015;
				var3.walkRightSequence = (var5 & 32) != 0 ? var0.readUnsignedShortLE() : var3.definition.walkRightSequence * 1831978023 * 749693847;
				var3.runSequence = (var5 & 64) != 0 ? var0.method2587() : var3.definition.runSequence * -1380991387 * -725499027;
				var3.runBackSequence = (var5 & 128) != 0 ? var0.method2587() : var3.definition.runBackSequence * -797891459 * 1726248149;
				var3.runLeftSequence = (var5 & 256) != 0 ? var0.readIntME() : var3.definition.runLeftSequence * -1089844195 * 1675023925;
				var3.runRightSequence = (var5 & 512) != 0 ? var0.method2587() : var3.definition.runRightSequence * -581873653 * -1635337309;
				var3.crawlSequence = (var5 & 1024) != 0 ? var0.readIntME() : var3.definition.crawlSequence * 1002809145 * -448850167;
				var3.crawlBackSequence = (var5 & 2048) != 0 ? var0.method2587() : var3.definition.crawlBackSequence * -1708442501 * -2089336141;
				var3.crawlLeftSequence = (var5 & 4096) != 0 ? var0.readIntME() : var3.definition.crawlLeftSequence * 2098030227 * -1815894117;
				var3.crawlRightSequence = (var5 & 8192) != 0 ? var0.readUnsignedShortLE() : var3.definition.crawlRightSequence * 1404008677 * -1427405587;
				var3.idleSequence = (var5 & 16384) != 0 ? var0.readIntME() : var3.definition.idleSequence * 403001363 * 260766235;
			}

			if ((var4 & 262144) != 0) {
				var5 = var0.readUnsignedByte();
				var13 = new int[8];
				var14 = new short[8];

				for (var8 = 0; var8 < 8; ++var8) {
					if ((var5 & 1 << var8) != 0) {
						var13[var8] = var0.method2563();
						var14[var8] = (short)var0.method2560();
					} else {
						var13[var8] = -1;
						var14[var8] = -1;
					}
				}

				var3.method590(var13, var14);
			}

			if ((var4 & 32768) != 0) {
				var3.method577(var0.readStringCp1252NullTerminated());
			}

			if ((var4 & 2) != 0) {
				var0.readUnsignedShort();
				var0.readInt();
			}

			if ((var4 & 1) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 8192) != 0) {
				var3.recolourStartCycle = Client.cycle + var0.readUnsignedShort();
				var3.recolourEndCycle = Client.cycle + var0.readUnsignedShort();
				var3.recolourHue = var0.readByteNeg();
				var3.recolourSaturation = var0.readByteNeg();
				var3.recolourLuminance = var0.readByteNeg();
				var3.recolourAmount = (byte)var0.readUnsignedByte();
			}

			if ((var4 & 256) != 0) {
				var5 = var0.readUnsignedByteAdd();
				if ((var5 & 1) == 1) {
					var3.method596();
				} else {
					var13 = null;
					if ((var5 & 2) == 2) {
						var7 = var0.readUnsignedByteAdd();
						var13 = new int[var7];

						for (var8 = 0; var8 < var7; ++var8) {
							var9 = var0.readUnsignedShortLE();
							var9 = var9 == 65535 ? -1 : var9;
							var13[var8] = var9;
						}
					}

					var14 = null;
					if ((var5 & 4) == 4) {
						var8 = 0;
						if (var3.definition.recolorTo != null) {
							var8 = var3.definition.recolorTo.length;
						}

						var14 = new short[var8];

						for (var9 = 0; var9 < var8; ++var9) {
							var14[var9] = (short)var0.readUnsignedShortLE();
						}
					}

					var15 = null;
					if ((var5 & 8) == 8) {
						var9 = 0;
						if (var3.definition.retextureTo != null) {
							var9 = var3.definition.retextureTo.length;
						}

						var15 = new short[var9];

						for (var10 = 0; var10 < var9; ++var10) {
							var15[var10] = (short)var0.readIntME();
						}
					}

					var19 = false;
					if ((var5 & 16) != 0) {
						var19 = var0.readUnsignedByteSub() == 1;
					}

					var16 = (long)(++NPC.field1075 - 1);
					var3.method594(new NewShit(var16, var13, var14, var15, var19));
				}
			}

			if ((var4 & 16384) != 0) {
				var3.method579(var0.readUnsignedByteAdd());
			}

			if ((var4 & 1024) != 0) {
				var3.combatLevelChange = var0.readInt();
			}
		}

	}
}