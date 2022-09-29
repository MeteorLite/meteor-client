import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("rw")
	static boolean field964;
	@ObfuscatedName("jw")
	@ObfuscatedGetter(
		intValue = 753704077
	)
	@Export("cameraY")
	static int cameraY;
	@ObfuscatedName("c")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("p")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-924338289"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/security/SecureRandom;",
		garbageValue = "610108675"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var2) {
			return class271.method5377();
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IIIS)J",
		garbageValue = "128"
	)
	static long method2111(int var0, int var1, int var2) {
		return (long)(var2 << 16 | var0 << 8 | var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/String;",
		garbageValue = "-92"
	)
	static String method2108(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqf;II)V",
		garbageValue = "-907276343"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		int var3 = 0;
		var0.importIndex();

		int var4;
		int var6;
		byte[] var10000;
		int var20;
		for (var4 = 0; var4 < Players.Players_count; ++var4) {
			var20 = Players.Players_indices[var4];
			if ((Players.field1290[var20] & 1) == 0) {
				if (var3 > 0) {
					--var3;
					var10000 = Players.field1290;
					var10000[var20] = (byte)(var10000[var20] | 2);
				} else {
					var6 = var0.readBits(1);
					if (var6 == 0) {
						var3 = Renderable.method4461(var0);
						var10000 = Players.field1290;
						var10000[var20] = (byte)(var10000[var20] | 2);
					} else {
						class259.readPlayerUpdate(var0, var20);
					}
				}
			}
		}

		var0.exportIndex();
		if (var3 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var4 = 0; var4 < Players.Players_count; ++var4) {
				var20 = Players.Players_indices[var4];
				if ((Players.field1290[var20] & 1) != 0) {
					if (var3 > 0) {
						--var3;
						var10000 = Players.field1290;
						var10000[var20] = (byte)(var10000[var20] | 2);
					} else {
						var6 = var0.readBits(1);
						if (var6 == 0) {
							var3 = Renderable.method4461(var0);
							var10000 = Players.field1290;
							var10000[var20] = (byte)(var10000[var20] | 2);
						} else {
							class259.readPlayerUpdate(var0, var20);
						}
					}
				}
			}

			var0.exportIndex();
			if (var3 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
					var20 = Players.Players_emptyIndices[var4];
					if ((Players.field1290[var20] & 1) != 0) {
						if (var3 > 0) {
							--var3;
							var10000 = Players.field1290;
							var10000[var20] = (byte)(var10000[var20] | 2);
						} else {
							var6 = var0.readBits(1);
							if (var6 == 0) {
								var3 = Renderable.method4461(var0);
								var10000 = Players.field1290;
								var10000[var20] = (byte)(var10000[var20] | 2);
							} else if (class139.updateExternalPlayer(var0, var20)) {
								var10000 = Players.field1290;
								var10000[var20] = (byte)(var10000[var20] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var3 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
						var20 = Players.Players_emptyIndices[var4];
						if ((Players.field1290[var20] & 1) == 0) {
							if (var3 > 0) {
								--var3;
								var10000 = Players.field1290;
								var10000[var20] = (byte)(var10000[var20] | 2);
							} else {
								var6 = var0.readBits(1);
								if (var6 == 0) {
									var3 = Renderable.method4461(var0);
									var10000 = Players.field1290;
									var10000[var20] = (byte)(var10000[var20] | 2);
								} else if (class139.updateExternalPlayer(var0, var20)) {
									var10000 = Players.field1290;
									var10000[var20] = (byte)(var10000[var20] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var3 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						Player var5;
						for (var4 = 1; var4 < 2048; ++var4) {
							var10000 = Players.field1290;
							var10000[var4] = (byte)(var10000[var4] >> 1);
							var5 = Client.players[var4];
							if (var5 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var4;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var4;
							}
						}

						for (var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
							var4 = Players.Players_pendingUpdateIndices[var3];
							var5 = Client.players[var4];
							var6 = var0.readUnsignedByte();
							if ((var6 & 128) != 0) {
								var6 += var0.readUnsignedByte() << 8;
							}

							byte var7 = class193.field2248.field2245;
							if ((var6 & 8) != 0) {
								var5.overheadText = var0.readStringCp1252NullTerminated();
								if (var5.overheadText.charAt(0) == '~') {
									var5.overheadText = var5.overheadText.substring(1);
									class65.addGameMessage(2, var5.username.getName(), var5.overheadText);
								} else if (var5 == class67.localPlayer) {
									class65.addGameMessage(2, var5.username.getName(), var5.overheadText);
								}

								var5.isAutoChatting = false;
								var5.overheadTextColor = 0;
								var5.overheadTextEffect = 0;
								var5.overheadTextCyclesRemaining = 150;
							}

							if ((var6 & 1024) != 0) {
								var7 = var0.readByte();
							}

							int var8;
							int var11;
							int var12;
							int var15;
							if ((var6 & 1) != 0) {
								var8 = var0.method7964();
								PlayerType var9 = (PlayerType)Varps.findEnumerated(class437.PlayerType_values(), var0.method7955());
								boolean var10 = var0.method7955() == 1;
								var11 = var0.readUnsignedByte();
								var12 = var0.offset;
								if (var5.username != null && var5.appearance != null) {
									boolean var13 = false;
									if (var9.isUser && Varps.friendSystem.isIgnored(var5.username)) {
										var13 = true;
									}

									if (!var13 && Client.field617 == 0 && !var5.isHidden) {
										Players.field1302.offset = 0;
										var0.readBytes(Players.field1302.array, 0, var11);
										Players.field1302.offset = 0;
										String var14 = AbstractFont.escapeBrackets(class123.method2954(Occluder.method4474(Players.field1302)));
										var5.overheadText = var14.trim();
										var5.overheadTextColor = var8 >> 8;
										var5.overheadTextEffect = var8 & 255;
										var5.overheadTextCyclesRemaining = 150;
										var5.isAutoChatting = var10;
										var5.field1150 = var5 != class67.localPlayer && var9.isUser && "" != Client.field752 && var14.toLowerCase().indexOf(Client.field752) == -1;
										if (var9.isPrivileged) {
											var15 = var10 ? 91 : 1;
										} else {
											var15 = var10 ? 90 : 2;
										}

										if (var9.modIcon != -1) {
											class65.addGameMessage(var15, method2108(var9.modIcon) + var5.username.getName(), var14);
										} else {
											class65.addGameMessage(var15, var5.username.getName(), var14);
										}
									}
								}

								var0.offset = var11 + var12;
							}

							int var16;
							if ((var6 & 32) != 0) {
								var8 = var0.readUnsignedByte();
								int var19;
								int var23;
								int var24;
								if (var8 > 0) {
									for (var16 = 0; var16 < var8; ++var16) {
										var11 = -1;
										var12 = -1;
										var24 = -1;
										var23 = var0.readUShortSmart();
										if (var23 == 32767) {
											var23 = var0.readUShortSmart();
											var12 = var0.readUShortSmart();
											var11 = var0.readUShortSmart();
											var24 = var0.readUShortSmart();
										} else if (var23 != 32766) {
											var12 = var0.readUShortSmart();
										} else {
											var23 = -1;
										}

										var19 = var0.readUShortSmart();
										var5.addHitSplat(var23, var12, var11, var24, Client.cycle, var19);
									}
								}

								var16 = var0.readUnsignedByte();
								if (var16 > 0) {
									for (var23 = 0; var23 < var16; ++var23) {
										var11 = var0.readUShortSmart();
										var12 = var0.readUShortSmart();
										if (var12 != 32767) {
											var24 = var0.readUShortSmart();
											var19 = var0.method8023();
											var15 = var12 > 0 ? var0.method7954() : var19;
											var5.addHealthBar(var11, Client.cycle, var12, var24, var19, var15);
										} else {
											var5.removeHealthBar(var11);
										}
									}
								}
							}

							if ((var6 & 512) != 0) {
								class193[] var17 = Players.field1291;
								class193[] var18 = new class193[]{class193.field2247, class193.field2248, class193.field2246, class193.field2244};
								var17[var4] = (class193)Varps.findEnumerated(var18, var0.readByte());
							}

							if ((var6 & 16) != 0) {
								var5.field1163 = var0.method8143();
								if (var5.pathLength == 0) {
									var5.orientation = var5.field1163;
									var5.field1163 = -1;
								}
							}

							if ((var6 & 16384) != 0) {
								var5.field1192 = var0.method7975();
								var5.field1181 = var0.readByte();
								var5.field1180 = var0.readByte();
								var5.field1140 = var0.readByte();
								var5.field1183 = var0.method7965() + Client.cycle;
								var5.field1136 = var0.readUnsignedShort() + Client.cycle;
								var5.field1185 = var0.method7965();
								if (var5.field1103) {
									var5.field1192 += var5.tileX;
									var5.field1181 += var5.tileY;
									var5.field1180 += var5.tileX;
									var5.field1140 += var5.tileY;
									var5.pathLength = 0;
								} else {
									var5.field1192 += var5.pathX[0];
									var5.field1181 += var5.pathY[0];
									var5.field1180 += var5.pathX[0];
									var5.field1140 += var5.pathY[0];
									var5.pathLength = 1;
								}

								var5.field1202 = 0;
							}

							if ((var6 & 2) != 0) {
								var5.targetIndex = var0.method7965();
								if (var5.targetIndex == 65535) {
									var5.targetIndex = -1;
								}
							}

							if ((var6 & 2048) != 0) {
								var5.field1188 = Client.cycle + var0.method7965();
								var5.field1158 = Client.cycle + var0.method8143();
								var5.field1190 = var0.method7960();
								var5.field1191 = var0.readByte();
								var5.field1169 = var0.method7960();
								var5.field1194 = (byte)var0.method8023();
							}

							if ((var6 & 4) != 0) {
								var8 = var0.method8023();
								byte[] var21 = new byte[var8];
								Buffer var26 = new Buffer(var21);
								var0.method7976(var21, 0, var8);
								Players.field1292[var4] = var26;
								var5.read(var26);
							}

							if ((var6 & 256) != 0) {
								var5.spotAnimation = var0.readUnsignedShort();
								var8 = var0.method8135();
								var5.field1145 = var8 >> 16;
								var5.field1147 = (var8 & 65535) + Client.cycle;
								var5.spotAnimationFrame = 0;
								var5.field1176 = 0;
								if (var5.field1147 > Client.cycle) {
									var5.spotAnimationFrame = -1;
								}

								if (var5.spotAnimation == 65535) {
									var5.spotAnimation = -1;
								}
							}

							if ((var6 & 8192) != 0) {
								for (var8 = 0; var8 < 3; ++var8) {
									var5.actions[var8] = var0.readStringCp1252NullTerminated();
								}
							}

							if ((var6 & 64) != 0) {
								var8 = var0.method7964();
								if (var8 == 65535) {
									var8 = -1;
								}

								var16 = var0.method7955();
								class120.performPlayerAnimation(var5, var8, var16);
							}

							if (var5.field1103) {
								if (var7 == 127) {
									var5.resetPath(var5.tileX, var5.tileY);
								} else {
									class193 var25;
									if (var7 != class193.field2248.field2245) {
										class193[] var22 = new class193[]{class193.field2247, class193.field2248, class193.field2246, class193.field2244};
										var25 = (class193)Varps.findEnumerated(var22, var7);
									} else {
										var25 = Players.field1291[var4];
									}

									var5.method2282(var5.tileX, var5.tileY, var25);
								}
							}
						}

						if (var0.offset - var2 != var1) {
							throw new RuntimeException(var0.offset - var2 + " " + var1);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "-229358462"
	)
	static int method2103(int var0, Script var1, boolean var2) {
		return 2;
	}
}
