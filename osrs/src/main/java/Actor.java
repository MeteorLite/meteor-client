import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("hg")
	static String field959;
	@ObfuscatedName("or")
	static int field958;
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("bv")
	@Export("x")
	int x;
	@ObfuscatedName("ba")
	@Export("y")
	int y;
	@ObfuscatedName("bz")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("bb")
	int field971;
	@ObfuscatedName("bo")
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("bp")
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("bt")
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("bm")
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("br")
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("bs")
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("bc")
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("bu")
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("bf")
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("bh")
	@Export("runBackSequence")
	int runBackSequence;
	@ObfuscatedName("bl")
	@Export("runLeftSequence")
	int runLeftSequence;
	@ObfuscatedName("bg")
	@Export("runRightSequence")
	int runRightSequence;
	@ObfuscatedName("bj")
	@Export("crawlSequence")
	int crawlSequence;
	@ObfuscatedName("bx")
	@Export("crawlBackSequence")
	int crawlBackSequence;
	@ObfuscatedName("bi")
	@Export("crawlLeftSequence")
	int crawlLeftSequence;
	@ObfuscatedName("bq")
	@Export("crawlRightSequence")
	int crawlRightSequence;
	@ObfuscatedName("bw")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("ce")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("cu")
	@Export("showPublicPlayerChat")
	boolean showPublicPlayerChat;
	@ObfuscatedName("cw")
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("co")
	int field998;
	@ObfuscatedName("cc")
	int field991;
	@ObfuscatedName("cg")
	int[] field1026;
	@ObfuscatedName("cy")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("cz")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("cp")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("cb")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("cn")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("ck")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "Lpy;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("cs")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("cm")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("cv")
	@Export("movingOrientation")
	int movingOrientation;
	@ObfuscatedName("ci")
	int field995;
	@ObfuscatedName("cj")
	int field996;
	@ObfuscatedName("cx")
	boolean field964;
	@ObfuscatedName("ch")
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("cd")
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("ct")
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("cf")
	int field993;
	@ObfuscatedName("cl")
	@Export("sequence")
	int sequence;
	@ObfuscatedName("ca")
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("dv")
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("dm")
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("ds")
	@Export("currentSequenceFrameIndex")
	int currentSequenceFrameIndex;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		descriptor = "Ltp;"
	)
	@Export("spotAnimations")
	IterableNodeHashTable spotAnimations;
	@ObfuscatedName("dg")
	int field1007;
	@ObfuscatedName("dq")
	int field1016;
	@ObfuscatedName("dz")
	int field1021;
	@ObfuscatedName("dn")
	int field1013;
	@ObfuscatedName("dk")
	int field1010;
	@ObfuscatedName("df")
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("de")
	@Export("exactMoveArrive1Cycle")
	int exactMoveArrive1Cycle;
	@ObfuscatedName("dl")
	@Export("exactMoveDirection")
	int exactMoveDirection;
	@ObfuscatedName("dp")
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("do")
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("dh")
	@Export("recolourStartCycle")
	int recolourStartCycle;
	@ObfuscatedName("dj")
	@Export("recolourEndCycle")
	int recolourEndCycle;
	@ObfuscatedName("du")
	@Export("recolourHue")
	byte recolourHue;
	@ObfuscatedName("dr")
	@Export("recolourSaturation")
	byte recolourSaturation;
	@ObfuscatedName("dw")
	@Export("recolourLuminance")
	byte recolourLuminance;
	@ObfuscatedName("di")
	@Export("recolourAmount")
	byte recolourAmount;
	@ObfuscatedName("dt")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("dd")
	int field1004;
	@ObfuscatedName("dy")
	int field1020;
	@ObfuscatedName("db")
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("dc")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("da")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		descriptor = "[Lip;"
	)
	@Export("pathTraversed")
	MoveSpeed[] pathTraversed;
	@ObfuscatedName("em")
	int field1024;
	@ObfuscatedName("el")
	int field1023;
	@ObfuscatedName("ec")
	@Export("combatLevelChange")
	int combatLevelChange;

	Actor() {
		this.isWalking = false;
		this.field971 = 1;
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
		this.field998 = 0;
		this.field991 = 0;
		this.field1026 = null;
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
		this.field995 = -1;
		this.field996 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field993 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.currentSequenceFrameIndex = 0;
		this.spotAnimations = new IterableNodeHashTable(4);
		this.field1007 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.recolourStartCycle = -1;
		this.recolourEndCycle = -1;
		this.field1004 = 0;
		this.field1020 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new MoveSpeed[10];
		this.field1024 = 0;
		this.field1023 = 0;
		this.combatLevelChange = -1;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "4"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "188506301"
	)
	final void method512() {
		this.pathLength = 0;
		this.field1023 = 0;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "2011213643"
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
			HitSplatDefinition var12 = class191.method959(var1);
			var10 = var12.field1716;
			var11 = var12.field1715;
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

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "555870749"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = DefaultsGroup.method2315(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field1559 == var7.field1559) {
				var12.put(var2 + var4, var5, var6, var3);
				return;
			}

			if (var12.definition.int1 <= var7.int1) {
				var8 = var12;
			}

			if (var12.definition.int2 > var10) {
				var9 = var12;
				var10 = var12.definition.int2;
			}
		}

		if (var9 != null || var11 < 4) {
			var12 = new HealthBar(var7);
			if (var8 == null) {
				this.healthBars.addLast(var12);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var12, var8);
			}

			var12.put(var2 + var4, var5, var6, var3);
			if (var11 >= 4) {
				var9.remove();
			}

		}
	}

	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1727929675"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = DefaultsGroup.method2315(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1528136211"
	)
	@Export("updateSpotAnimation")
	void updateSpotAnimation(int var1, int var2, int var3, int var4) {
		int var5 = var4 + Client.cycle;
		SpotAnimation var6 = (SpotAnimation)this.spotAnimations.get((long)var1);
		if (var6 != null) {
			var6.remove();
			--this.field1007;
		}

		if (var2 != 65535 && var2 != -1) {
			byte var7 = 0;
			if (var4 > 0) {
				var7 = -1;
			}

			this.spotAnimations.put(new SpotAnimation(var2, var3, var5, var7), (long)var1);
			++this.field1007;
		}
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(B)Ltp;",
		garbageValue = "-113"
	)
	IterableNodeHashTable method518() {
		return this.spotAnimations;
	}

	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "106644167"
	)
	void method519() {
		IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.spotAnimations);

		for (SpotAnimation var2 = (SpotAnimation)var1.method2484(); var2 != null; var2 = (SpotAnimation)var1.next()) {
			var2.remove();
		}

		this.field1007 = 0;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(Ljn;B)Ljn;",
		garbageValue = "5"
	)
	Model method520(Model var1) {
		if (this.field1007 == 0) {
			return var1;
		} else {
			IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.spotAnimations);
			int var3 = var1.verticesCount;
			int var4 = var1.indicesCount;
			int var5 = var1.field2254;
			byte var6 = var1.field2247;

			for (SpotAnimation var7 = (SpotAnimation)var2.method2484(); var7 != null; var7 = (SpotAnimation)var2.next()) {
				if (var7.field4306 != -1) {
					Model var8 = class406.SpotAnimationDefinition_get(var7.field4304).method1037();
					if (var8 != null) {
						var3 += var8.verticesCount;
						var4 += var8.indicesCount;
						var5 += var8.field2254;
					}
				}
			}

			Model var10 = new Model(var3, var4, var5, var6);
			var10.method1355(var1);

			for (SpotAnimation var11 = (SpotAnimation)var2.method2484(); var11 != null; var11 = (SpotAnimation)var2.next()) {
				if (var11.field4306 != -1) {
					Model var9 = class406.SpotAnimationDefinition_get(var11.field4304).getModel(var11.field4306);
					if (var9 != null) {
						var9.offsetBy(0, -var11.field4307, 0);
						var10.method1355(var9);
					}
				}
			}

			return var10;
		}
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-57"
	)
	void method521() {
		this.field964 = false;
		this.movingOrientation = -1;
		this.field995 = -1;
		this.field996 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(CI)B",
		garbageValue = "-1751998077"
	)
	@Export("charToByteCp1252")
	public static byte charToByteCp1252(char var0) {
		byte var1;
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
			if (var0 == 8364) {
				var1 = -128;
			} else if (var0 == 8218) {
				var1 = -126;
			} else if (var0 == 402) {
				var1 = -125;
			} else if (var0 == 8222) {
				var1 = -124;
			} else if (var0 == 8230) {
				var1 = -123;
			} else if (var0 == 8224) {
				var1 = -122;
			} else if (var0 == 8225) {
				var1 = -121;
			} else if (var0 == 710) {
				var1 = -120;
			} else if (var0 == 8240) {
				var1 = -119;
			} else if (var0 == 352) {
				var1 = -118;
			} else if (var0 == 8249) {
				var1 = -117;
			} else if (var0 == 338) {
				var1 = -116;
			} else if (var0 == 381) {
				var1 = -114;
			} else if (var0 == 8216) {
				var1 = -111;
			} else if (var0 == 8217) {
				var1 = -110;
			} else if (var0 == 8220) {
				var1 = -109;
			} else if (var0 == 8221) {
				var1 = -108;
			} else if (var0 == 8226) {
				var1 = -107;
			} else if (var0 == 8211) {
				var1 = -106;
			} else if (var0 == 8212) {
				var1 = -105;
			} else if (var0 == 732) {
				var1 = -104;
			} else if (var0 == 8482) {
				var1 = -103;
			} else if (var0 == 353) {
				var1 = -102;
			} else if (var0 == 8250) {
				var1 = -101;
			} else if (var0 == 339) {
				var1 = -100;
			} else if (var0 == 382) {
				var1 = -98;
			} else if (var0 == 376) {
				var1 = -97;
			} else {
				var1 = 63;
			}
		} else {
			var1 = (byte)var0;
		}

		return var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1768262837"
	)
	public static void method511() {
		StructComposition.StructDefinition_cached.clear();
	}
}