import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("bd")
	@Export("x")
	int x;
	@ObfuscatedName("by")
	@Export("y")
	int y;
	@ObfuscatedName("bs")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("bm")
	int field976;
	@ObfuscatedName("bf")
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("bq")
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("ba")
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("bl")
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("bp")
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("bu")
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("bo")
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("bb")
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("br")
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("be")
	@Export("runBackSequence")
	int runBackSequence;
	@ObfuscatedName("bi")
	@Export("runLeftSequence")
	int runLeftSequence;
	@ObfuscatedName("bz")
	@Export("runRightSequence")
	int runRightSequence;
	@ObfuscatedName("bx")
	@Export("crawlSequence")
	int crawlSequence;
	@ObfuscatedName("bn")
	@Export("crawlBackSequence")
	int crawlBackSequence;
	@ObfuscatedName("bw")
	@Export("crawlLeftSequence")
	int crawlLeftSequence;
	@ObfuscatedName("bc")
	@Export("crawlRightSequence")
	int crawlRightSequence;
	@ObfuscatedName("bg")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("cw")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("cf")
	@Export("showPublicPlayerChat")
	boolean showPublicPlayerChat;
	@ObfuscatedName("cm")
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("cn")
	int field995;
	@ObfuscatedName("cs")
	int field996;
	@ObfuscatedName("cx")
	int[] field1028;
	@ObfuscatedName("cd")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ce")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("cq")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("cp")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("cv")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("co")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "Loc;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("cu")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("ch")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("ci")
	@Export("movingOrientation")
	int movingOrientation;
	@ObfuscatedName("ca")
	int field988;
	@ObfuscatedName("cb")
	int field989;
	@ObfuscatedName("cg")
	boolean field959;
	@ObfuscatedName("cj")
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("cz")
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("ct")
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("cy")
	int field999;
	@ObfuscatedName("ck")
	@Export("sequence")
	int sequence;
	@ObfuscatedName("cc")
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("dh")
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("dj")
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("di")
	@Export("currentSequenceFrameIndex")
	int currentSequenceFrameIndex;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		descriptor = "Lsf;"
	)
	@Export("spotAnimations")
	IterableNodeHashTable spotAnimations;
	@ObfuscatedName("dn")
	int field1011;
	@ObfuscatedName("dg")
	int field1004;
	@ObfuscatedName("dd")
	int field1002;
	@ObfuscatedName("da")
	int field1001;
	@ObfuscatedName("ds")
	int field1014;
	@ObfuscatedName("dy")
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("dt")
	@Export("exactMoveArrive1Cycle")
	int exactMoveArrive1Cycle;
	@ObfuscatedName("dl")
	@Export("exactMoveDirection")
	int exactMoveDirection;
	@ObfuscatedName("dk")
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("df")
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("dz")
	@Export("recolourStartCycle")
	int recolourStartCycle;
	@ObfuscatedName("dw")
	@Export("recolourEndCycle")
	int recolourEndCycle;
	@ObfuscatedName("dv")
	@Export("recolourHue")
	byte recolourHue;
	@ObfuscatedName("dr")
	@Export("recolourSaturation")
	byte recolourSaturation;
	@ObfuscatedName("do")
	@Export("recolourLuminance")
	byte recolourLuminance;
	@ObfuscatedName("db")
	@Export("recolourAmount")
	byte recolourAmount;
	@ObfuscatedName("dp")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("dm")
	int field1010;
	@ObfuscatedName("dx")
	int field1017;
	@ObfuscatedName("dq")
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("de")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("dc")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		descriptor = "[Lin;"
	)
	@Export("pathTraversed")
	MoveSpeed[] pathTraversed;
	@ObfuscatedName("eh")
	int field1021;
	@ObfuscatedName("ey")
	int field1022;
	@ObfuscatedName("ee")
	@Export("combatLevelChange")
	int combatLevelChange;

	Actor() {
		this.isWalking = false;
		this.field976 = 1;
		this.idleSequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.runBackSequence = -1;
		this.runLeftSequence = -1;
		this.runRightSequence = -1;
		this.crawlSequence = -1;
		this.crawlBackSequence = -1;
		this.crawlLeftSequence = -1;
		this.crawlRightSequence = -1;
		this.overheadText = null;
		this.showPublicPlayerChat = false;
		this.overheadTextCyclesRemaining = 100;
		this.field995 = 0;
		this.field996 = 0;
		this.field1028 = null;
		this.hitSplatCount = 0;
		this.hitSplatTypes = new int[4];
		this.hitSplatValues = new int[4];
		this.hitSplatCycles = new int[4];
		this.hitSplatTypes2 = new int[4];
		this.hitSplatValues2 = new int[4];
		this.healthBars = new IterableNodeDeque();
		this.targetIndex = -1;
		this.false0 = false;
		this.movingOrientation = -1;
		this.field988 = -1;
		this.field989 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field999 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.currentSequenceFrameIndex = 0;
		this.spotAnimations = new IterableNodeHashTable(4);
		this.field1011 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.recolourStartCycle = -1;
		this.recolourEndCycle = -1;
		this.field1010 = 0;
		this.field1017 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new MoveSpeed[10];
		this.field1021 = 0;
		this.field1022 = 0;
		this.combatLevelChange = -1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "381940201"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-71"
	)
	final void method512() {
		this.pathLength = 0;
		this.field1022 = 0;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "1923884006"
	)
	@Export("addHitSplat")
	final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		boolean var8 = true;

		int var9;
		for (var9 = 0; var9 < 4; ++var9) {
			if (this.hitSplatCycles[var9] > var5) {
				var7 = false;
			} else {
				var8 = false;
			}
		}

		var9 = -1;
		int var10 = -1;
		int var11 = 0;
		if (var1 >= 0) {
			HitSplatDefinition var12 = WorldMapCacheName.method1564(var1);
			var10 = var12.field1704;
			var11 = var12.field1706;
		}

		int var14;
		if (var8) {
			if (var10 == -1) {
				return;
			}

			var9 = 0;
			var14 = 0;
			if (var10 == 0) {
				var14 = this.hitSplatCycles[0];
			} else if (var10 == 1) {
				var14 = this.hitSplatValues[0];
			}

			for (int var13 = 1; var13 < 4; ++var13) {
				if (var10 == 0) {
					if (this.hitSplatCycles[var13] < var14) {
						var9 = var13;
						var14 = this.hitSplatCycles[var13];
					}
				} else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
					var9 = var13;
					var14 = this.hitSplatValues[var13];
				}
			}

			if (var10 == 1 && var14 >= var2) {
				return;
			}
		} else {
			if (var7) {
				this.hitSplatCount = 0;
			}

			for (var14 = 0; var14 < 4; ++var14) {
				byte var15 = this.hitSplatCount;
				this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
				if (this.hitSplatCycles[var15] <= var5) {
					var9 = var15;
					break;
				}
			}
		}

		if (var9 >= 0) {
			this.hitSplatTypes[var9] = var1;
			this.hitSplatValues[var9] = var2;
			this.hitSplatTypes2[var9] = var3;
			this.hitSplatValues2[var9] = var4;
			this.hitSplatCycles[var9] = var5 + var11 + var6;
		}
	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "1229115524"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var8 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
		HealthBarDefinition var7;
		if (var8 != null) {
			var7 = var8;
		} else {
			byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
			var8 = new HealthBarDefinition();
			var8.field1555 = var1;
			if (var9 != null) {
				var8.decode(new Buffer(var9));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var8, (long)var1);
			var7 = var8;
		}

		var8 = var7;
		HealthBar var14 = null;
		HealthBar var10 = null;
		int var11 = var7.int2;
		int var12 = 0;

		HealthBar var13;
		for (var13 = (HealthBar)this.healthBars.last(); var13 != null; var13 = (HealthBar)this.healthBars.previous()) {
			++var12;
			if (var13.definition.field1555 == var8.field1555) {
				var13.put(var2 + var4, var5, var6, var3);
				return;
			}

			if (var13.definition.int1 <= var8.int1) {
				var14 = var13;
			}

			if (var13.definition.int2 > var11) {
				var10 = var13;
				var11 = var13.definition.int2;
			}
		}

		if (var10 != null || var12 < 4) {
			var13 = new HealthBar(var8);
			if (var14 == null) {
				this.healthBars.addLast(var13);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var13, var14);
			}

			var13.put(var2 + var4, var5, var6, var3);
			if (var12 >= 4) {
				var10.remove();
			}

		}
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-711075108"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var3 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
		HealthBarDefinition var2;
		if (var3 != null) {
			var2 = var3;
		} else {
			byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
			var3 = new HealthBarDefinition();
			var3.field1555 = var1;
			if (var4 != null) {
				var3.decode(new Buffer(var4));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var3, (long)var1);
			var2 = var3;
		}

		var3 = var2;

		for (HealthBar var5 = (HealthBar)this.healthBars.last(); var5 != null; var5 = (HealthBar)this.healthBars.previous()) {
			if (var3 == var5.definition) {
				var5.remove();
				return;
			}
		}

	}

	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "0"
	)
	@Export("updateSpotAnimation")
	void updateSpotAnimation(int var1, int var2, int var3, int var4) {
		int var5 = var4 + Client.cycle;
		SpotAnimation var6 = (SpotAnimation)this.spotAnimations.get((long)var1);
		if (var6 != null) {
			var6.remove();
			--this.field1011;
		}

		if (var2 != 65535 && var2 != -1) {
			byte var7 = 0;
			if (var4 > 0) {
				var7 = -1;
			}

			this.spotAnimations.put(new SpotAnimation(var2, var3, var5, var7), (long)var1);
			++this.field1011;
		}
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(I)Lsf;",
		garbageValue = "-343795604"
	)
	IterableNodeHashTable method518() {
		return this.spotAnimations;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-28624"
	)
	void method519() {
		IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.spotAnimations);

		for (SpotAnimation var2 = (SpotAnimation)var1.method2449(); var2 != null; var2 = (SpotAnimation)var1.next()) {
			var2.remove();
		}

		this.field1011 = 0;
	}

	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "(Ljr;I)Ljr;",
		garbageValue = "-787093925"
	)
	Model method520(Model var1) {
		if (this.field1011 == 0) {
			return var1;
		} else {
			IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.spotAnimations);
			int var3 = var1.verticesCount;
			int var4 = var1.indicesCount;
			int var5 = var1.field2242;
			byte var6 = var1.field2235;

			for (SpotAnimation var7 = (SpotAnimation)var2.method2449(); var7 != null; var7 = (SpotAnimation)var2.next()) {
				if (var7.field4278 != -1) {
					Model var8 = StructComposition.SpotAnimationDefinition_get(var7.field4281).method1002();
					if (var8 != null) {
						var3 += var8.verticesCount;
						var4 += var8.indicesCount;
						var5 += var8.field2242;
					}
				}
			}

			Model var10 = new Model(var3, var4, var5, var6);
			var10.method1314(var1);

			for (SpotAnimation var11 = (SpotAnimation)var2.method2449(); var11 != null; var11 = (SpotAnimation)var2.next()) {
				if (var11.field4278 != -1) {
					Model var9 = StructComposition.SpotAnimationDefinition_get(var11.field4281).getModel(var11.field4278);
					if (var9 != null) {
						var9.offsetBy(0, -var11.field4277, 0);
						var10.method1314(var9);
					}
				}
			}

			return var10;
		}
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-23"
	)
	void method521() {
		this.field959 = false;
		this.movingOrientation = -1;
		this.field988 = -1;
		this.field989 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lto;I)V",
		garbageValue = "-1660235487"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = VarbitComposition.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - UrlRequester.baseX;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - class47.baseY;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		HealthBar.Client_plane = var2.plane = var4;
		if (Players.cachedAppearanceBuffer[var1] != null) {
			var2.read(Players.cachedAppearanceBuffer[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.activityFlags[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var7 != var1) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.activityFlags[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Lon;IB)Lly;",
		garbageValue = "38"
	)
	public static PacketBufferNode method510(int var0, String var1, Language var2, int var3) {
		PacketBufferNode var4 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.MESSAGE_PUBLIC, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeByte(0);
		int var5 = var4.packetBuffer.offset;
		var4.packetBuffer.writeByte(var0);
		String var6 = var1.toLowerCase();
		int var7 = 0;
		byte[] var8 = null;
		if (var6.startsWith("yellow:")) {
			var7 = 0;
			var1 = var1.substring("yellow:".length());
		} else if (var6.startsWith("red:")) {
			var7 = 1;
			var1 = var1.substring("red:".length());
		} else if (var6.startsWith("green:")) {
			var7 = 2;
			var1 = var1.substring("green:".length());
		} else if (var6.startsWith("cyan:")) {
			var7 = 3;
			var1 = var1.substring("cyan:".length());
		} else if (var6.startsWith("purple:")) {
			var7 = 4;
			var1 = var1.substring("purple:".length());
		} else if (var6.startsWith("white:")) {
			var7 = 5;
			var1 = var1.substring("white:".length());
		} else if (var6.startsWith("flash1:")) {
			var7 = 6;
			var1 = var1.substring("flash1:".length());
		} else if (var6.startsWith("flash2:")) {
			var7 = 7;
			var1 = var1.substring("flash2:".length());
		} else if (var6.startsWith("flash3:")) {
			var7 = 8;
			var1 = var1.substring("flash3:".length());
		} else if (var6.startsWith("glow1:")) {
			var7 = 9;
			var1 = var1.substring("glow1:".length());
		} else if (var6.startsWith("glow2:")) {
			var7 = 10;
			var1 = var1.substring("glow2:".length());
		} else if (var6.startsWith("glow3:")) {
			var7 = 11;
			var1 = var1.substring("glow3:".length());
		} else if (var6.startsWith("rainbow:")) {
			var7 = 12;
			var1 = var1.substring("rainbow:".length());
		} else if (var6.startsWith("pattern")) {
			var8 = Interpreter.method418(var6);
			if (var8 != null) {
				var7 = var8.length + 12;
				var1 = var1.substring("pattern".length() + var8.length + 1);
			}
		}

		var6 = var1.toLowerCase();
		byte var9 = 0;
		if (var6.startsWith("wave:")) {
			var9 = 1;
			var1 = var1.substring("wave:".length());
		} else if (var6.startsWith("wave2:")) {
			var9 = 2;
			var1 = var1.substring("wave2:".length());
		} else if (var6.startsWith("shake:")) {
			var9 = 3;
			var1 = var1.substring("shake:".length());
		} else if (var6.startsWith("scroll:")) {
			var9 = 4;
			var1 = var1.substring("scroll:".length());
		} else if (var6.startsWith("slide:")) {
			var9 = 5;
			var1 = var1.substring("slide:".length());
		}

		var4.packetBuffer.writeByte(var7);
		var4.packetBuffer.writeByte(var9);
		if (var8 != null && Client.param25 >= 214) {
			for (int var10 = 0; var10 < var8.length; ++var10) {
				var4.packetBuffer.writeByte(var8[var10]);
			}
		}

		class216.method1127(var4.packetBuffer, var1);
		if (var0 == class339.field3113.rsOrdinal()) {
			var4.packetBuffer.writeByte(var3);
		}

		var4.packetBuffer.method2540(var4.packetBuffer.offset - var5);
		return var4;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(Lmt;I)Z",
		garbageValue = "-1903392375"
	)
	static boolean method522(PlayerComposition var0) {
		if (var0.equipment[0] < 512) {
			return false;
		} else {
			ItemComposition var1 = InvDefinition.ItemDefinition_get(var0.equipment[0] - 512);
			return var1.maleModel1 != class209.field1862.field1871 && var1.maleModel2 != class209.field1862.field1871;
		}
	}
}