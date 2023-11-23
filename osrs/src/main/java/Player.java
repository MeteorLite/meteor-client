import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Player")
public final class Player extends Actor {
	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		descriptor = "Liq;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lvj;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	@Export("appearance")
	PlayerComposition appearance;
	@ObfuscatedName("ar")
	@Export("headIconPk")
	int headIconPk;
	@ObfuscatedName("ao")
	@Export("headIconPrayer")
	int headIconPrayer;
	@ObfuscatedName("au")
	@Export("actions")
	String[] actions;
	@ObfuscatedName("aa")
	@Export("combatLevel")
	int combatLevel;
	@ObfuscatedName("ac")
	@Export("skillLevel")
	int skillLevel;
	@ObfuscatedName("al")
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("az")
	@Export("animationCycleStart")
	int animationCycleStart;
	@ObfuscatedName("ap")
	@Export("animationCycleEnd")
	int animationCycleEnd;
	@ObfuscatedName("av")
	int field919;
	@ObfuscatedName("ax")
	@Export("baseTileHeight")
	int baseTileHeight;
	@ObfuscatedName("as")
	int field918;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	@Export("attachedModel")
	Model attachedModel;
	@ObfuscatedName("ak")
	@Export("minX")
	int minX;
	@ObfuscatedName("aj")
	@Export("minY")
	int minY;
	@ObfuscatedName("am")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("aq")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("ai")
	@Export("isUnanimated")
	boolean isUnanimated;
	@ObfuscatedName("aw")
	@Export("team")
	int team;
	@ObfuscatedName("ae")
	@Export("isHidden")
	boolean isHidden;
	@ObfuscatedName("ag")
	@Export("plane")
	int plane;
	@ObfuscatedName("ad")
	@Export("index")
	int index;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	@Export("isFriendTriBool")
	TriBool isFriendTriBool;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	@Export("isInFriendsChat")
	TriBool isInFriendsChat;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lrw;"
	)
	@Export("isInClanChat")
	TriBool isInClanChat;
	@ObfuscatedName("bl")
	@Export("hasMovementPending")
	boolean hasMovementPending;
	@ObfuscatedName("bi")
	@Export("tileX")
	int tileX;
	@ObfuscatedName("bv")
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
		this.hasMovementPending = false;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "722515666"
	)
	@Export("read")
	final void read(Buffer var1) {
		var1.offset = 0;
		int var2 = var1.readUnsignedByte();
		boolean var3 = true;
		this.headIconPk = var1.readByte();
		this.headIconPrayer = var1.readByte();
		int var4 = -1;
		this.team = 0;
		int[] var5 = new int[12];

		int var7;
		int var8;
		int var9;
		for (int var6 = 0; var6 < 12; ++var6) {
			var7 = var1.readUnsignedByte();
			if (var7 == 0) {
				var5[var6] = 0;
			} else {
				var8 = var1.readUnsignedByte();
				var5[var6] = var8 + (var7 << 8);
				if (var6 == 0 && var5[0] == 65535) {
					var4 = var1.readUnsignedShort();
					break;
				}

				if (var5[var6] >= 512) {
					var9 = class214.ItemDefinition_get(var5[var6] - 512).team;
					if (var9 != 0) {
						this.team = var9;
					}
				}
			}
		}

		int[] var13 = null;
		if (Client.param25 >= 213) {
			var13 = new int[12];

			for (var7 = 0; var7 < 12; ++var7) {
				var8 = var1.readUnsignedByte();
				if (var8 == 0) {
					var13[var7] = 0;
				} else {
					var9 = var1.readUnsignedByte();
					var13[var7] = var9 + (var8 << 8);
				}
			}
		}

		int[] var14 = new int[5];

		for (var8 = 0; var8 < 5; ++var8) {
			var9 = var1.readUnsignedByte();
			if (var9 < 0 || var9 >= class90.field892[var8].length) {
				var9 = 0;
			}

			var14[var8] = var9;
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

		this.username = new Username(var1.readStringCp1252NullTerminated(), class89.loginType);
		this.clearIsFriend();
		this.clearIsInFriendsChat();
		this.clearIsInClanChat();
		if (this == class229.localPlayer) {
			class17.field53 = this.username.getName();
		}

		this.combatLevel = var1.readUnsignedByte();
		this.skillLevel = var1.readUnsignedShort();
		this.isHidden = var1.readUnsignedByte() == 1;
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
			this.isHidden = false;
		}

		ObjTypeCustomisation[] var15 = null;
		boolean var17 = false;
		int var10 = var1.readUnsignedShort();
		var17 = (var10 >> 15 & 1) == 1;
		int var11;
		if (var10 > 0 && var10 != 32768) {
			var15 = new ObjTypeCustomisation[12];

			for (var11 = 0; var11 < 12; ++var11) {
				int var12 = var10 >> 12 - var11 & 1;
				if (var12 == 1) {
					var15[var11] = ZoneOperation.method1631(var5[var11] - 512, var1);
				}
			}
		}

		for (var11 = 0; var11 < 3; ++var11) {
			this.actions[var11] = var1.readStringCp1252NullTerminated();
		}

		int var16 = var1.readUnsignedByte();
		if (this.appearance == null) {
			this.appearance = new PlayerComposition();
		}

		this.appearance.method1745(var13, var5, var15, var17, var14, var2, var4, var16);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Lka;",
		garbageValue = "1"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.appearance == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? DynamicObject.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : DynamicObject.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				if (!this.isUnanimated) {
					var3 = this.method514(var3);
				}

				if (!this.isUnanimated && this.attachedModel != null) {
					if (Client.cycle >= this.animationCycleEnd) {
						this.attachedModel = null;
					}

					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
						Model var5 = this.attachedModel;
						var5.offsetBy(this.field919 - super.x, this.baseTileHeight - this.tileHeight, this.field918 - super.y);
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

						Model[] var6 = new Model[]{var3, var5};
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

						var5.offsetBy(super.x - this.field919, this.tileHeight - this.baseTileHeight, super.y - this.field918);
					}
				}

				var3.isSingleTile = true;
				if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
					var3.overrideHue = super.recolourHue;
					var3.overrideSaturation = super.recolourSaturation;
					var3.overrideLuminance = super.recolourLuminance;
					var3.overrideAmount = super.recolourAmount;
					var3.field2423 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1713250919"
	)
	@Export("isFriend")
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) {
			this.checkIsFriend();
		}

		return this.isFriendTriBool == TriBool.TriBool_true;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-81"
	)
	@Export("clearIsFriend")
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-14"
	)
	@Export("checkIsFriend")
	void checkIsFriend() {
		this.isFriendTriBool = class12.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "14"
	)
	@Export("isFriendsChatMember")
	boolean isFriendsChatMember() {
		if (this.isInFriendsChat == TriBool.TriBool_unknown) {
			this.updateIsInFriendsChat();
		}

		return this.isInFriendsChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2089631916"
	)
	@Export("clearIsInFriendsChat")
	void clearIsInFriendsChat() {
		this.isInFriendsChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1196848864"
	)
	@Export("updateIsInFriendsChat")
	void updateIsInFriendsChat() {
		this.isInFriendsChat = class20.friendsChat != null && class20.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "115"
	)
	@Export("updateIsInClanChat")
	void updateIsInClanChat() {
		for (int var1 = 0; var1 < 4; ++var1) {
			if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method800(this.username.getName()) != -1 && var1 != 2) {
				this.isInClanChat = TriBool.TriBool_true;
				return;
			}
		}

		this.isInClanChat = TriBool.TriBool_false;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-73"
	)
	@Export("clearIsInClanChat")
	void clearIsInClanChat() {
		this.isInClanChat = TriBool.TriBool_unknown;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2021409739"
	)
	@Export("isClanMember")
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) {
			this.updateIsInClanChat();
		}

		return this.isInClanChat == TriBool.TriBool_true;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2046405362"
	)
	@Export("transformedSize")
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? VerticalAlignment.getNpcDefinition(this.appearance.npcTransformId).size : 1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IILiz;I)V",
		garbageValue = "2103873992"
	)
	@Export("move")
	final void move(int var1, int var2, MoveSpeed var3) {
		if (super.sequence != -1 && DynamicObject.SequenceDefinition_get(super.sequence).priority == 1) {
			super.sequence = -1;
		}

		this.method515();
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
				if (var3 == MoveSpeed.RUN) {
					WorldMapCacheName.method1355(this, var1, var2, MoveSpeed.RUN);
				}

				this.method495(var1, var2, var3);
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1104771167"
	)
	@Export("resetPath")
	void resetPath(int var1, int var2) {
		super.pathLength = 0;
		super.field1029 = 0;
		super.field1028 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		int var3 = this.transformedSize();
		super.x = super.pathX[0] * 128 + var3 * 64;
		super.y = super.pathY[0] * 128 + var3 * 64;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IILiz;I)V",
		garbageValue = "1624897043"
	)
	final void method495(int var1, int var2, MoveSpeed var3) {
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1221291483"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.appearance != null;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ltz;III)I",
		garbageValue = "319825494"
	)
	static int method478(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IIIZII)J",
		garbageValue = "211437143"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "2"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}
}