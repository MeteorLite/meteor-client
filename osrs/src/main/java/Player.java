import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("uv")
	@ObfuscatedSignature(
		descriptor = "Lcz;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lqo;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lke;"
	)
	@Export("appearance")
	PlayerComposition appearance;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -735871189
	)
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 146218787
	)
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("w")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -121558489
	)
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -322700721
	)
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1264926313
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 434736947
	)
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1265833721
	)
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -693023053
	)
	int field1106;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -804495425
	)
	@Export("tileHeight2")
	int tileHeight2;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1664895721
	)
	int field1096;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Lha;"
	)
	@Export("model0")
	Model model0;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 990797689
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -238809261
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1079075195
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1370658303
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("e")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1049846371
	)
	@Export("team")
	int team;
	@ObfuscatedName("y")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1679440569
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1338774963
	)
	@Export("index")
	int index;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "Lnt;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "Lnt;"
	)
	@Export("isInFriendsChat")
	TriBool isInFriendsChat;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnt;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("ac")
	boolean field1103;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 1166558487
	)
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1558610431
	)
	@Export("tileY")
	int tileY;

	Player() {
		this.headIconPk = -1;
		this.headIconPrayer = -1;
		this.actions = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.actions[var1] = "";
		}

		this.combatLevel = 0;
		this.skillLevel = 0;
		this.animationCycleStart = 0;
		this.animationCycleEnd = 0;
		this.isUnanimated = false;
		this.team = 0;
		this.isHidden = false;
		this.isFriendTriBool = TriBool.TriBool_unknown;
		this.isInFriendsChat = TriBool.TriBool_unknown;
		this.isInClanChat = TriBool.TriBool_unknown;
		this.field1103 = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;S)V",
		garbageValue = "-25477"
	)
	@Export("read")
	final void read(Buffer var1) {
		var1.offset = 0;
		int var2 = var1.readUnsignedByte();
		this.headIconPk = var1.readByte();
		this.headIconPrayer = var1.readByte();
		int var3 = -1;
		this.team = 0;
		int[] var4 = new int[12];

		int var6;
		int var7;
		int var8;
		for (int var5 = 0; var5 < 12; ++var5) {
			var6 = var1.readUnsignedByte();
			if (var6 == 0) {
				var4[var5] = 0;
			} else {
				var7 = var1.readUnsignedByte();
				var4[var5] = var7 + (var6 << 8);
				if (var5 == 0 && var4[0] == 65535) {
					var3 = var1.readUnsignedShort();
					break;
				}

				if (var4[var5] >= 512) {
					var8 = UserComparator3.ItemDefinition_get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.team = var8;
					}
				}
			}
		}

		int[] var24 = new int[5];

		for (var6 = 0; var6 < 5; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 < 0 || var7 >= class358.field4279[var6].length) {
				var7 = 0;
			}

			var24[var6] = var7;
		}

		super.idleSequence = var1.readUnsignedShort();
		if (super.idleSequence == 65535) {
			super.idleSequence = -1;
		}

		super.turnLeftSequence = var1.readUnsignedShort();
		if (super.turnLeftSequence == 65535) {
			super.turnLeftSequence = -1;
		}

		super.turnRightSequence = super.turnLeftSequence;
		super.walkSequence = var1.readUnsignedShort();
		if (super.walkSequence == 65535) {
			super.walkSequence = -1;
		}

		super.walkBackSequence = var1.readUnsignedShort();
		if (super.walkBackSequence == 65535) {
			super.walkBackSequence = -1;
		}

		super.walkLeftSequence = var1.readUnsignedShort();
		if (super.walkLeftSequence == 65535) {
			super.walkLeftSequence = -1;
		}

		super.walkRightSequence = var1.readUnsignedShort();
		if (super.walkRightSequence == 65535) {
			super.walkRightSequence = -1;
		}

		super.runSequence = var1.readUnsignedShort();
		if (super.runSequence == 65535) {
			super.runSequence = -1;
		}

		this.username = new Username(var1.readStringCp1252NullTerminated(), Players.loginType);
		this.clearIsFriend();
		this.clearIsInFriendsChat();
		this.method2278();
		if (this == class67.localPlayer) {
			RunException.localPlayerName = this.username.getName();
		}

		this.combatLevel = var1.readUnsignedByte();
		this.skillLevel = var1.readUnsignedShort();
		this.isHidden = var1.readUnsignedByte() == 1;
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
			this.isHidden = false;
		}

		class168[] var25 = null;
		boolean var26 = false;
		var8 = var1.readUnsignedShort();
		var26 = (var8 >> 15 & 1) == 1;
		int var9;
		if (var8 > 0 && var8 != 32768) {
			var25 = new class168[12];

			for (var9 = 0; var9 < 12; ++var9) {
				int var10 = var8 >> 12 - var9 & 1;
				if (var10 == 1) {
					int var14 = var4[var9] - 512;
					int var15 = var1.readUnsignedByte();
					boolean var16 = (var15 & 1) != 0;
					boolean var17 = (var15 & 2) != 0;
					class168 var18 = new class168(var14);
					int var19;
					int[] var20;
					boolean var21;
					int var22;
					short var23;
					if (var16) {
						var19 = var1.readUnsignedByte();
						var20 = new int[]{var19 & 15, var19 >> 4 & 15};
						var21 = var18.field1835 != null && var20.length == var18.field1835.length;

						for (var22 = 0; var22 < 2; ++var22) {
							if (var20[var22] != 15) {
								var23 = (short)var1.readUnsignedShort();
								if (var21) {
									var18.field1835[var20[var22]] = var23;
								}
							}
						}
					}

					if (var17) {
						var19 = var1.readUnsignedByte();
						var20 = new int[]{var19 & 15, var19 >> 4 & 15};
						var21 = var18.field1833 != null && var20.length == var18.field1833.length;

						for (var22 = 0; var22 < 2; ++var22) {
							if (var20[var22] != 15) {
								var23 = (short)var1.readUnsignedShort();
								if (var21) {
									var18.field1833[var20[var22]] = var23;
								}
							}
						}
					}

					var25[var9] = var18;
				}
			}
		}

		if (var1.offset < var1.array.length) {
			for (var9 = 0; var9 < 3; ++var9) {
				this.actions[var9] = var1.readStringCp1252NullTerminated();
			}
		}

		if (this.appearance == null) {
			this.appearance = new PlayerComposition();
		}

		this.appearance.method5727(var4, var25, var26, var24, var2 == 1, var3);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)Lha;",
		garbageValue = "13"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class4.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.idleSequence == super.movementSequence && var1 != null ? null : class4.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				Model var5;
				Model[] var6;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					var5 = class308.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var5 != null) {
						var5.offsetBy(0, -super.field1145, 0);
						var6 = new Model[]{var3, var5};
						var3 = new Model(var6, 2);
					}
				}

				if (!this.isUnanimated && this.model0 != null) {
					if (Client.cycle >= this.animationCycleEnd) {
						this.model0 = null;
					}

					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
						var5 = this.model0;
						var5.offsetBy(this.field1106 * 4096 - super.x, this.tileHeight2 - this.tileHeight, this.field1096 * 4096 - super.y);
						if (super.orientation == 512) {
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var5.rotateY90Ccw();
						}

						var6 = new Model[]{var3, var5};
						var3 = new Model(var6, 2);
						if (super.orientation == 512) {
							var5.rotateY90Ccw();
						} else if (super.orientation == 1024) {
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
						} else if (super.orientation == 1536) {
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
							var5.rotateY90Ccw();
						}

						var5.offsetBy(super.x - this.field1106 * 4096, this.tileHeight - this.tileHeight2, super.y - this.field1096 * 4096);
					}
				}

				var3.isSingleTile = true;
				if (super.field1194 != 0 && Client.cycle >= super.field1188 && Client.cycle < super.field1158) {
					var3.overrideHue = super.field1190;
					var3.overrideSaturation = super.field1191;
					var3.overrideLuminance = super.field1169;
					var3.overrideAmount = super.field1194;
					var3.field2618 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2136490279"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-637129255"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = Varps.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1351288382"
	)
	@Export("isFriendsChatMember")
	boolean isFriendsChatMember() {
		if (this.isInFriendsChat == TriBool.TriBool_unknown) {
			this.updateIsInFriendsChat();
		}

		return this.isInFriendsChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-852374348"
	)
	@Export("clearIsInFriendsChat")
	void clearIsInFriendsChat() {
		this.isInFriendsChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-653943417"
	)
	@Export("updateIsInFriendsChat")
	void updateIsInFriendsChat() {
		this.isInFriendsChat = class145.friendsChat != null && class145.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "86"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		for (int var1 = 0; var1 < 4; ++var1) {
			if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method3134(this.username.getName()) != -1 && var1 != 2) {
				this.isInClanChat = TriBool.TriBool_true;
				return;
			}
		}

		this.isInClanChat = TriBool.TriBool_false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "270390520"
	)
	void method2278() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "0"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-940037059"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? class193.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(IILga;B)V",
		garbageValue = "62"
	)
	final void method2282(int var1, int var2, class193 var3) {
		if (super.sequence != -1 && class4.SequenceDefinition_get(super.sequence).field2218 == 1) {
			super.sequence = -1;
		}

		super.field1163 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == class193.field2247) {
					Player var4 = this;
					class193 var5 = class193.field2247;
					int var6 = super.pathX[0];
					int var7 = super.pathY[0];
					int var8 = this.transformedSize();
					if (var6 >= var8 && var6 < 104 - var8 && var7 >= var8 && var7 < 104 - var8 && var1 >= var8 && var1 < 104 - var8 && var2 >= var8 && var2 < 104 - var8) {
						int var10 = this.transformedSize();
						RouteStrategy var11 = Client.method1724(var1, var2);
						CollisionMap var12 = Client.collisionMaps[this.plane];
						int[] var13 = Client.field787;
						int[] var14 = Client.field788;
						int var15 = 0;

						label242:
						while (true) {
							int var16;
							if (var15 >= 128) {
								boolean var34;
								if (var10 == 1) {
									var34 = class19.method287(var6, var7, var11, var12);
								} else if (var10 == 2) {
									var34 = TaskHandler.method3431(var6, var7, var11, var12);
								} else {
									var34 = class271.method5376(var6, var7, var10, var11, var12);
								}

								int var9;
								label263: {
									var16 = var6 - 64;
									int var17 = var7 - 64;
									int var18 = Bounds.field4422;
									int var19 = class347.field4205;
									int var20;
									int var21;
									int var23;
									if (!var34) {
										var20 = Integer.MAX_VALUE;
										var21 = Integer.MAX_VALUE;
										byte var22 = 10;
										var23 = var11.approxDestinationX;
										int var24 = var11.approxDestinationY;
										int var25 = var11.approxDestinationSizeX;
										int var26 = var11.approxDestinationSizeY;

										for (int var27 = var23 - var22; var27 <= var22 + var23; ++var27) {
											for (int var28 = var24 - var22; var28 <= var24 + var22; ++var28) {
												int var29 = var27 - var16;
												int var30 = var28 - var17;
												if (var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class194.distances[var29][var30] < 100) {
													int var31 = 0;
													if (var27 < var23) {
														var31 = var23 - var27;
													} else if (var27 > var23 + var25 - 1) {
														var31 = var27 - (var23 + var25 - 1);
													}

													int var32 = 0;
													if (var28 < var24) {
														var32 = var24 - var28;
													} else if (var28 > var24 + var26 - 1) {
														var32 = var28 - (var26 + var24 - 1);
													}

													int var33 = var32 * var32 + var31 * var31;
													if (var33 < var20 || var33 == var20 && class194.distances[var29][var30] < var21) {
														var20 = var33;
														var21 = class194.distances[var29][var30];
														var18 = var27;
														var19 = var28;
													}
												}
											}
										}

										if (var20 == Integer.MAX_VALUE) {
											var9 = -1;
											break label263;
										}
									}

									if (var6 == var18 && var19 == var7) {
										var13[0] = var18;
										var14[0] = var19;
										var9 = 0;
									} else {
										byte var36 = 0;
										class194.bufferX[var36] = var18;
										var20 = var36 + 1;
										class194.bufferY[var36] = var19;

										int var37;
										for (var21 = var37 = class194.directions[var18 - var16][var19 - var17]; var6 != var18 || var19 != var7; var21 = class194.directions[var18 - var16][var19 - var17]) {
											if (var37 != var21) {
												var37 = var21;
												class194.bufferX[var20] = var18;
												class194.bufferY[var20++] = var19;
											}

											if ((var21 & 2) != 0) {
												++var18;
											} else if ((var21 & 8) != 0) {
												--var18;
											}

											if ((var21 & 1) != 0) {
												++var19;
											} else if ((var21 & 4) != 0) {
												--var19;
											}
										}

										var23 = 0;

										while (var20-- > 0) {
											var13[var23] = class194.bufferX[var20];
											var14[var23++] = class194.bufferY[var20];
											if (var23 >= var13.length) {
												break;
											}
										}

										var9 = var23;
									}
								}

								var15 = var9;
								if (var9 < 1) {
									break;
								}

								var16 = 0;

								while (true) {
									if (var16 >= var15 - 1) {
										break label242;
									}

									var4.method2287(Client.field787[var16], Client.field788[var16], var5);
									++var16;
								}
							}

							for (var16 = 0; var16 < 128; ++var16) {
								class194.directions[var15][var16] = 0;
								class194.distances[var15][var16] = 99999999;
							}

							++var15;
						}
					}
				}

				this.method2287(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-3"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field1202 = 0;
		super.field1201 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = var3 * 64 + super.pathX[0] * 128;
		super.y = var3 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(IILga;B)V",
		garbageValue = "72"
	)
	final void method2287(int var1, int var2, class193 var3) {
		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var4 = super.pathLength; var4 > 0; --var4) {
			super.pathX[var4] = super.pathX[var4 - 1];
			super.pathY[var4] = super.pathY[var4 - 1];
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
		}

		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.pathTraversed[0] = var3;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-77"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/io/File;I)V",
		garbageValue = "-1682167537"
	)
	static void method2324(File var0) {
		FileSystem.FileSystem_cacheDir = var0;
		if (!FileSystem.FileSystem_cacheDir.exists()) {
			throw new RuntimeException("");
		} else {
			FileSystem.FileSystem_hasPermissions = true;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Llv;IS)V",
		garbageValue = "256"
	)
	static void method2322(AbstractArchive var0, int var1) {
		if ((var1 & 536870912) != 0) {
			MilliClock.logoSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", "");
		} else if ((var1 & 1073741824) != 0) {
			MilliClock.logoSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", "");
		} else if ((var1 & 256) != 0) {
			MilliClock.logoSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var0, "logo_speedrunning", "");
		} else {
			MilliClock.logoSprite = WorldMapCacheName.SpriteBuffer_getIndexedSpriteByName(var0, "logo", "");
		}

	}
}
