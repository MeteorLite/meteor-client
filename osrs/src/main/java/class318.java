import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.BitSet;
import java.util.Random;

@ObfuscatedName("mk")
public class class318 extends Node {
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("au")
	int field2875;
	@ObfuscatedName("ae")
	BitSet field2876;

	class318(int var1) {
		this.field2875 = var1;
		this.field2876 = new BitSet(128);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;B)I",
		garbageValue = "-14"
	)
	static final int method1703(long var0, String var2) {
		Random var3 = new Random();
		Buffer var4 = new Buffer(128);
		Buffer var5 = new Buffer(128);
		int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
		var4.writeByte(10);

		int var7;
		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.writeInt(var6[0]);
		var4.writeInt(var6[1]);
		var4.writeLong(var0);
		var4.writeLong(0L);

		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.encryptRsa(class72.field731, class72.field732);
		var5.writeByte(10);

		for (var7 = 0; var7 < 3; ++var7) {
			var5.writeInt(var3.nextInt());
		}

		var5.writeLong(var3.nextLong());
		var5.writeLongMedium(var3.nextLong());
		class177.method919(var5);
		var5.writeLong(var3.nextLong());
		var5.encryptRsa(class72.field731, class72.field732);
		var7 = AbstractSocket.stringCp1252NullTerminatedByteSize(var2);
		if (var7 % 8 != 0) {
			var7 += 8 - var7 % 8;
		}

		Buffer var8 = new Buffer(var7);
		var8.writeStringCp1252NullTerminated(var2);
		var8.offset = var7;
		var8.xteaEncryptAll(var6);
		Buffer var9 = new Buffer(var8.offset + var5.offset + var4.offset + 5);
		var9.writeByte(2);
		var9.writeByte(var4.offset);
		var9.writeBytes(var4.array, 0, var4.offset);
		var9.writeByte(var5.offset);
		var9.writeBytes(var5.array, 0, var5.offset);
		var9.writeShort(var8.offset);
		var9.writeBytes(var8.array, 0, var8.offset);
		byte[] var11 = var9.array;
		String var10 = class11.method32(var11, 0, var11.length);
		String var12 = var10;

		try {
			URL var13 = new URL(HorizontalAlignment.method978("services", false) + "m=accountappeal/login.ws");
			URLConnection var14 = var13.openConnection();
			var14.setDoInput(true);
			var14.setDoOutput(true);
			var14.setConnectTimeout(5000);
			OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
			String var17 = "data2=" + UserComparator10.method687(var12) + "&dest=";
			int var19 = "passwordchoice.ws".length();
			StringBuilder var20 = new StringBuilder(var19);

			for (int var21 = 0; var21 < var19; ++var21) {
				char var22 = "passwordchoice.ws".charAt(var21);
				if ((var22 < 'a' || var22 > 'z') && (var22 < 'A' || var22 > 'Z') && (var22 < '0' || var22 > '9') && var22 != '.' && var22 != '-' && var22 != '*' && var22 != '_') {
					if (var22 == ' ') {
						var20.append('+');
					} else {
						byte var23 = class348.charToByteCp1252(var22);
						var20.append('%');
						int var24 = var23 >> 4 & 15;
						if (var24 >= 10) {
							var20.append((char)(var24 + 55));
						} else {
							var20.append((char)(var24 + 48));
						}

						var24 = var23 & 15;
						if (var24 >= 10) {
							var20.append((char)(var24 + 55));
						} else {
							var20.append((char)(var24 + 48));
						}
					}
				} else {
					var20.append(var22);
				}
			}

			String var18 = var20.toString();
			var15.write(var17 + var18);
			var15.flush();
			InputStream var25 = var14.getInputStream();
			var9 = new Buffer(new byte[1000]);

			do {
				int var26 = var25.read(var9.array, var9.offset, 1000 - var9.offset);
				if (var26 == -1) {
					var15.close();
					var25.close();
					String var28 = new String(var9.array);
					if (var28.startsWith("OFFLINE")) {
						return 4;
					} else if (var28.startsWith("WRONG")) {
						return 7;
					} else if (var28.startsWith("RELOAD")) {
						return 3;
					} else if (var28.startsWith("Not permitted for social network accounts.")) {
						return 6;
					} else {
						var9.xteaDecryptAll(var6);

						while (var9.offset > 0 && var9.array[var9.offset - 1] == 0) {
							--var9.offset;
						}

						var28 = new String(var9.array, 0, var9.offset);
						if (PendingSpawn.method508(var28)) {
							class30.openURL(var28, true, false);
							return 2;
						} else {
							return 5;
						}
					}
				}

				var9.offset += var26;
			} while(var9.offset < 1000);

			return 5;
		} catch (Throwable var27) {
			var27.printStackTrace();
			return 5;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1758045320"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		descriptor = "(Ldr;II)V",
		garbageValue = "798219365"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		if (var0.spotAnimation >= Client.cycle) {
			Huffman.method1853(var0);
		} else {
			int var4;
			int var5;
			int var7;
			int var8;
			int var11;
			if (var0.exactMoveArrive1Cycle >= Client.cycle) {
				boolean var2 = var0.exactMoveArrive1Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
				if (!var2) {
					SequenceDefinition var3 = EnumComposition.SequenceDefinition_get(var0.sequence);
					if (var3 != null && !var3.isCachedModelIdSet()) {
						var2 = var0.sequenceFrameCycle + 1 > var3.frameLengths[var0.sequenceFrame];
					} else {
						var2 = true;
					}
				}

				if (var2) {
					var11 = var0.exactMoveArrive1Cycle - var0.spotAnimation;
					var4 = Client.cycle - var0.spotAnimation;
					var5 = var0.field976 * 64 + var0.field1004 * 128;
					int var6 = var0.field976 * 64 + var0.field1001 * 128;
					var7 = var0.field976 * 64 + var0.field1002 * 128;
					var8 = var0.field976 * 64 + var0.field1014 * 128;
					var0.x = (var4 * var7 + var5 * (var11 - var4)) / var11;
					var0.y = (var4 * var8 + var6 * (var11 - var4)) / var11;
				}

				var0.field1021 = 0;
				var0.orientation = var0.exactMoveDirection;
				var0.rotation = var0.orientation;
			} else {
				var0.movementSequence = var0.idleSequence;
				if (var0.pathLength == 0) {
					var0.field1021 = 0;
				} else {
					label298: {
						if (var0.sequence != -1 && var0.sequenceDelay == 0) {
							SequenceDefinition var12 = EnumComposition.SequenceDefinition_get(var0.sequence);
							if (var0.field1022 > 0 && var12.precedenceAnimating == 0) {
								++var0.field1021;
								break label298;
							}

							if (var0.field1022 <= 0 && var12.priority == 0) {
								++var0.field1021;
								break label298;
							}
						}

						int var14 = var0.x;
						var11 = var0.y;
						var4 = var0.field976 * 64 + var0.pathX[var0.pathLength - 1] * 128;
						var5 = var0.field976 * 64 + var0.pathY[var0.pathLength - 1] * 128;
						if (var14 < var4) {
							if (var11 < var5) {
								var0.orientation = 1280;
							} else if (var11 > var5) {
								var0.orientation = 1792;
							} else {
								var0.orientation = 1536;
							}
						} else if (var14 > var4) {
							if (var11 < var5) {
								var0.orientation = 768;
							} else if (var11 > var5) {
								var0.orientation = 256;
							} else {
								var0.orientation = 512;
							}
						} else if (var11 < var5) {
							var0.orientation = 1024;
						} else if (var11 > var5) {
							var0.orientation = 0;
						}

						MoveSpeed var13 = var0.pathTraversed[var0.pathLength - 1];
						if (var4 - var14 <= 256 && var4 - var14 >= -256 && var5 - var11 <= 256 && var5 - var11 >= -256) {
							var7 = var0.orientation - var0.rotation & 2047;
							if (var7 > 1024) {
								var7 -= 2048;
							}

							var8 = var0.walkBackSequence;
							if (var7 >= -256 && var7 <= 256) {
								var8 = var0.walkSequence;
							} else if (var7 >= 256 && var7 < 768) {
								var8 = var0.walkRightSequence;
							} else if (var7 >= -768 && var7 <= -256) {
								var8 = var0.walkLeftSequence;
							}

							if (var8 == -1) {
								var8 = var0.walkSequence;
							}

							var0.movementSequence = var8;
							int var9 = 4;
							boolean var10 = true;
							if (var0 instanceof NPC) {
								var10 = ((NPC)var0).definition.isClickable;
							}

							if (var10) {
								if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field1017 != 0) {
									var9 = 2;
								}

								if (var0.pathLength > 2) {
									var9 = 6;
								}

								if (var0.pathLength > 3) {
									var9 = 8;
								}

								if (var0.field1021 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field1021;
								}
							} else {
								if (var0.pathLength > 1) {
									var9 = 6;
								}

								if (var0.pathLength > 2) {
									var9 = 8;
								}

								if (var0.field1021 > 0 && var0.pathLength > 1) {
									var9 = 8;
									--var0.field1021;
								}
							}

							if (var13 == MoveSpeed.RUN) {
								var9 <<= 1;
							} else if (var13 == MoveSpeed.CRAWL) {
								var9 >>= 1;
							}

							if (var9 >= 8) {
								if (var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
									var0.movementSequence = var0.runSequence;
								} else if (var0.walkBackSequence == var0.movementSequence && var0.runBackSequence != -1) {
									var0.movementSequence = var0.runBackSequence;
								} else if (var0.movementSequence == var0.walkLeftSequence && var0.runLeftSequence != -1) {
									var0.movementSequence = var0.runLeftSequence;
								} else if (var0.walkRightSequence == var0.movementSequence && var0.runRightSequence != -1) {
									var0.movementSequence = var0.runRightSequence;
								}
							} else if (var9 <= 2) {
								if (var0.movementSequence == var0.walkSequence && var0.crawlSequence != -1) {
									var0.movementSequence = var0.crawlSequence;
								} else if (var0.movementSequence == var0.walkBackSequence && var0.crawlBackSequence != -1) {
									var0.movementSequence = var0.crawlBackSequence;
								} else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
									var0.movementSequence = var0.crawlLeftSequence;
								} else if (var0.walkRightSequence == var0.movementSequence && var0.crawlRightSequence != -1) {
									var0.movementSequence = var0.crawlRightSequence;
								}
							}

							if (var4 != var14 || var5 != var11) {
								if (var14 < var4) {
									var0.x += var9;
									if (var0.x > var4) {
										var0.x = var4;
									}
								} else if (var14 > var4) {
									var0.x -= var9;
									if (var0.x < var4) {
										var0.x = var4;
									}
								}

								if (var11 < var5) {
									var0.y += var9;
									if (var0.y > var5) {
										var0.y = var5;
									}
								} else if (var11 > var5) {
									var0.y -= var9;
									if (var0.y < var5) {
										var0.y = var5;
									}
								}
							}

							if (var4 == var0.x && var5 == var0.y) {
								--var0.pathLength;
								if (var0.field1022 > 0) {
									--var0.field1022;
								}
							}
						} else {
							var0.x = var4;
							var0.y = var5;
							--var0.pathLength;
							if (var0.field1022 > 0) {
								--var0.field1022;
							}
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method519();
			var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
			var0.y = var0.field976 * 64 + var0.pathY[0] * 128;
			var0.method512();
		}

		if (VarbitComposition.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method519();
			var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
			var0.y = var0.field976 * 64 + var0.pathY[0] * 128;
			var0.method512();
		}

		ClanChannelMember.method777(var0);
		UserComparator5.method680(var0);
	}
}