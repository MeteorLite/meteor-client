import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Law;"
	)
	@Export("pcmPlayerProvider")
	static class47 pcmPlayerProvider;
	@ObfuscatedName("c")
	@Export("text")
	String text;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1893758611
	)
	@Export("width")
	int width;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -186990655
	)
	@Export("height")
	int height;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IILhz;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		descriptor = "(Lqf;B)V",
		garbageValue = "-14"
	)
	static final void method5120(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field549; ++var1) {
			int var2 = Client.field550[var1];
			NPC var3 = Client.npcs[var2];
			int var4 = var0.readUnsignedByte();
			int var5;
			if (WorldMapSectionType.field2826 && (var4 & 1) != 0) {
				var5 = var0.readUnsignedByte();
				var4 += var5 << 8;
			}

			if ((var4 & 64) != 0) {
				var3.overheadText = var0.readStringCp1252NullTerminated();
				var3.overheadTextCyclesRemaining = 100;
			}

			if ((var4 & 512) != 0) {
				var3.field1203 = var0.method7974();
			}

			if ((var4 & 4) != 0) {
				var3.spotAnimation = var0.method8143();
				var5 = var0.method7974();
				var3.field1145 = var5 >> 16;
				var3.field1147 = (var5 & 65535) + Client.cycle;
				var3.spotAnimationFrame = 0;
				var3.field1176 = 0;
				if (var3.field1147 > Client.cycle) {
					var3.spotAnimationFrame = -1;
				}

				if (var3.spotAnimation == 65535) {
					var3.spotAnimation = -1;
				}
			}

			int var6;
			int var7;
			int var8;
			if ((var4 & 2) != 0) {
				var5 = var0.method7955();
				int var9;
				int var10;
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

				var6 = var0.method8023();
				if (var6 > 0) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						if (var9 != 32767) {
							var10 = var0.readUShortSmart();
							var11 = var0.method8023();
							int var12 = var9 > 0 ? var0.readUnsignedByte() : var11;
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
						} else {
							var3.removeHealthBar(var8);
						}
					}
				}
			}

			if ((var4 & 16) != 0) {
				var3.definition = class193.getNpcDefinition(var0.method7964());
				var3.field1131 = var3.definition.size;
				var3.field1196 = var3.definition.rotation;
				var3.walkSequence = var3.definition.walkSequence;
				var3.walkBackSequence = var3.definition.walkBackSequence;
				var3.walkLeftSequence = var3.definition.walkLeftSequence;
				var3.walkRightSequence = var3.definition.walkRightSequence;
				var3.idleSequence = var3.definition.idleSequence;
				var3.turnLeftSequence = var3.definition.turnLeftSequence;
				var3.turnRightSequence = var3.definition.turnRightSequence;
			}

			if ((var4 & 256) != 0) {
				var3.field1188 = Client.cycle + var0.method8143();
				var3.field1158 = Client.cycle + var0.method8143();
				var3.field1190 = var0.readByte();
				var3.field1191 = var0.method7975();
				var3.field1169 = var0.method7970();
				var3.field1194 = (byte)var0.readUnsignedByte();
			}

			if (WorldMapSectionType.field2826 && (var4 & 2048) != 0 || !WorldMapSectionType.field2826 && (var4 & 1) != 0) {
				var3.field1192 = var0.readByte();
				var3.field1181 = var0.method7975();
				var3.field1180 = var0.method7960();
				var3.field1140 = var0.method7960();
				var3.field1183 = var0.readUnsignedShort() + Client.cycle;
				var3.field1136 = var0.readUnsignedShort() + Client.cycle;
				var3.field1185 = var0.method8143();
				var3.pathLength = 1;
				var3.field1202 = 0;
				var3.field1192 += var3.pathX[0];
				var3.field1181 += var3.pathY[0];
				var3.field1180 += var3.pathX[0];
				var3.field1140 += var3.pathY[0];
			}

			if ((var4 & 32) != 0) {
				var5 = var0.readUnsignedShort();
				if (var5 == 65535) {
					var5 = -1;
				}

				var6 = var0.method7954();
				if (var5 == var3.sequence && var5 != -1) {
					var7 = class4.SequenceDefinition_get(var5).field2219;
					if (var7 == 1) {
						var3.sequenceFrame = 0;
						var3.sequenceFrameCycle = 0;
						var3.sequenceDelay = var6;
						var3.field1173 = 0;
					}

					if (var7 == 2) {
						var3.field1173 = 0;
					}
				} else if (var5 == -1 || var3.sequence == -1 || class4.SequenceDefinition_get(var5).field2212 >= class4.SequenceDefinition_get(var3.sequence).field2212) {
					var3.sequence = var5;
					var3.sequenceFrame = 0;
					var3.sequenceFrameCycle = 0;
					var3.sequenceDelay = var6;
					var3.field1173 = 0;
					var3.field1202 = var3.pathLength;
				}
			}

			if ((var4 & 1024) != 0) {
				var3.method2513(var0.readStringCp1252NullTerminated());
			}

			if ((var4 & 8) != 0) {
				var5 = var0.method7964();
				var6 = var0.method8143();
				if (WorldMapSectionType.field2826) {
					var3.field1141 = var0.method8023() == 1;
				}

				var7 = var3.x - (var5 - class128.baseX * 64 - class128.baseX * 64) * 64;
				var8 = var3.y - (var6 - WorldMapData_1.baseY * 64 - WorldMapData_1.baseY * 64) * 64;
				if (var7 != 0 || var8 != 0) {
					var3.field1163 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
				}
			}

			if ((var4 & 128) != 0) {
				var3.targetIndex = var0.method7964();
				if (var3.targetIndex == 65535) {
					var3.targetIndex = -1;
				}
			}
		}

	}

	@ObfuscatedName("lw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-392455478"
	)
	static final void method5119() {
		Client.field700 = Client.cycleCntr;
	}
}
