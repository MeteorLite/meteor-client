import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 2082301251
	)
	@Export("x")
	int x;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 201162729
	)
	@Export("y")
	int y;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -843576201
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -44581457
	)
	int field1201;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 187862823
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 2069657441
	)
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -344103579
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1645061365
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -2128083475
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1087764383
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1509034049
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -938435851
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 684246447
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -749362017
	)
	int field1181;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 433711015
	)
	int field1151;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1396311481
	)
	int field1152;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1631079087
	)
	int field1153;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 1713723467
	)
	int field1209;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -308852591
	)
	int field1184;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 916016745
	)
	int field1156;
	@ObfuscatedName("aa")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("bx")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("bh")
	boolean field1155;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = 2132728057
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 128260117
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = -513565809
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("bg")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("bd")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bq")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("bk")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bc")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bv")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "Lml;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -177989563
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("br")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 1147619093
	)
	int field1203;
	@ObfuscatedName("by")
	boolean field1173;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1935010867
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -454451479
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -974665831
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -188171203
	)
	int field1160;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1963515013
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1749938985
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bz")
	@ObfuscatedGetter(
		intValue = -986209861
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1799281131
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = 94715391
	)
	int field1210;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 358038643
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -1833683875
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 1617465677
	)
	int field1142;
	@ObfuscatedName("ci")
	@ObfuscatedGetter(
		intValue = 801618611
	)
	int field1186;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = -1449841861
	)
	int field1159;
	@ObfuscatedName("ck")
	@ObfuscatedGetter(
		intValue = 201933441
	)
	int field1150;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 1846469473
	)
	int field1189;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 661045753
	)
	int field1190;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = 2028156093
	)
	int field1188;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -2024536551
	)
	int field1192;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = -473772391
	)
	int field1193;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = 1018346863
	)
	int field1194;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = -1150467361
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -500790387
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = 763616681
	)
	int field1197;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = -866481861
	)
	int field1198;
	@ObfuscatedName("cm")
	byte field1199;
	@ObfuscatedName("cc")
	byte field1200;
	@ObfuscatedName("cr")
	byte field1185;
	@ObfuscatedName("ct")
	byte field1202;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 36455077
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = 1135644645
	)
	int field1204;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 1831269937
	)
	int field1205;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = 1973809325
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cx")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cp")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		descriptor = "[Lgo;"
	)
	@Export("pathTraversed")
	class202[] pathTraversed;
	@ObfuscatedName("df")
	@ObfuscatedGetter(
		intValue = 1183618047
	)
	int field1172;
	@ObfuscatedName("dc")
	@ObfuscatedGetter(
		intValue = -220662997
	)
	int field1211;
	@ObfuscatedName("dk")
	@ObfuscatedGetter(
		intValue = 1419553213
	)
	int field1212;

	Actor() {
		this.isWalking = false;
		this.field1201 = 1;
		this.idleSequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.field1181 = -1;
		this.field1151 = -1;
		this.field1152 = -1;
		this.field1153 = -1;
		this.field1209 = -1;
		this.field1184 = -1;
		this.field1156 = -1;
		this.overheadText = null;
		this.field1155 = false;
		this.overheadTextCyclesRemaining = 100;
		this.overheadTextColor = 0;
		this.overheadTextEffect = 0;
		this.hitSplatCount = 0;
		this.hitSplatTypes = new int[4];
		this.hitSplatValues = new int[4];
		this.hitSplatCycles = new int[4];
		this.hitSplatTypes2 = new int[4];
		this.hitSplatValues2 = new int[4];
		this.healthBars = new IterableNodeDeque();
		this.targetIndex = -1;
		this.false0 = false;
		this.field1203 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field1160 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field1210 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.field1142 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field1197 = -1;
		this.field1198 = -1;
		this.field1204 = 0;
		this.field1205 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new class202[10];
		this.field1172 = 0;
		this.field1211 = 0;
		this.field1212 = -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "246357037"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1312167120"
	)
	final void method2316() {
		this.pathLength = 0;
		this.field1211 = 0;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "-1854118366"
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
			HitSplatDefinition var12 = class158.method3241(var1);
			var10 = var12.field2067;
			var11 = var12.field2056;
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

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "-1902970487"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = ModeWhere.method6594(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field1929 == var7.field1929) {
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

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1211388115"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = ModeWhere.method6594(var1);

		for (HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
			if (var2 == var3.definition) {
				var3.remove();
				return;
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(II)Lfd;",
		garbageValue = "-1492294528"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(ILbz;ZB)I",
		garbageValue = "93"
	)
	static int method2332(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 4000) {
			class379.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == 4001) {
			class379.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == 4002) {
			class379.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var4 * var3;
			return 1;
		} else if (var0 == 4003) {
			class379.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == 4004) {
			var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == 4005) {
			var3 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else {
			int var5;
			int var6;
			int var7;
			if (var0 == 4006) {
				class379.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 4];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
				return 1;
			} else if (var0 == 4007) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
				return 1;
			} else if (var0 == 4008) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 | 1 << var4;
				return 1;
			} else if (var0 == 4009) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
				return 1;
			} else if (var0 == 4010) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
				return 1;
			} else if (var0 == 4011) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 % var4;
				return 1;
			} else if (var0 == 4012) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
				} else {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
				}

				return 1;
			} else if (var0 == 4013) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
					return 1;
				} else {
					switch(var4) {
					case 0:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
						break;
					case 1:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3;
						break;
					case 2:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
						break;
					case 3:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
						break;
					case 4:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
						break;
					default:
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
					}

					return 1;
				}
			} else if (var0 == 4014) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 & var4;
				return 1;
			} else if (var0 == 4015) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 | var4;
				return 1;
			} else if (var0 == 4018) {
				class379.Interpreter_intStackSize -= 3;
				long var9 = (long)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				long var11 = (long)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				long var13 = (long)Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
				return 1;
			} else if (var0 == 4025) {
				var3 = Renderable.method4454(Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3;
				return 1;
			} else if (var0 == 4026) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 ^ 1 << var4;
				return 1;
			} else if (var0 == 4027) {
				class379.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = WorldMapDecoration.method5148(var3, var4, var5);
				return 1;
			} else if (var0 == 4028) {
				class379.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class28.method442(var3, var4, var5);
				return 1;
			} else if (var0 == 4029) {
				class379.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				var6 = 31 - var5;
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 << var6 >>> var4 + var6;
				return 1;
			} else if (var0 == 4030) {
				class379.Interpreter_intStackSize -= 4;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 3];
				var3 = class28.method442(var3, var5, var6);
				var7 = Archive.method6338(var6 - var5 + 1);
				if (var4 > var7) {
					var4 = var7;
				}

				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3 | var4 << var5;
				return 1;
			} else if (var0 == 4032) {
				Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1] = class315.method6250(Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4033) {
				Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1] = VarpDefinition.method3429(Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4034) {
				class379.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
				var5 = AbstractWorldMapData.method5137(var3, var4);
				Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var5;
				return 1;
			} else if (var0 == 4035) {
				Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1] = Math.abs(Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize - 1]);
				return 1;
			} else {
				return 2;
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(ILbz;ZI)I",
		garbageValue = "391113383"
	)
	static int method2334(int var0, Script var1, boolean var2) {
		String var3;
		int var10;
		if (var0 == 4100) {
			var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
			var10 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3 + var10;
			return 1;
		} else {
			String var4;
			if (var0 == 4101) {
				class125.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3 + var4;
				return 1;
			} else if (var0 == 4102) {
				var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
				var10 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3 + Canvas.intToString(var10, true);
				return 1;
			} else if (var0 == 4103) {
				var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var11;
				if (var0 == 4104) {
					var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
					long var14 = ((long)var11 + 11745L) * 86400000L;
					Interpreter.Interpreter_calendar.setTime(new Date(var14));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var17 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
					return 1;
				} else if (var0 != 4105) {
					if (var0 == 4106) {
						var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = Integer.toString(var11);
						return 1;
					} else if (var0 == 4107) {
						class125.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class297.method5726(Interpreter.compareStrings(Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1], class103.clientLanguage));
						return 1;
					} else {
						int var9;
						byte[] var12;
						Font var13;
						if (var0 == 4108) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							class379.Interpreter_intStackSize -= 2;
							var10 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
							var9 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
							var12 = class143.archive13.takeFile(var9, 0);
							var13 = new Font(var12);
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var13.lineCount(var3, var10);
							return 1;
						} else if (var0 == 4109) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							class379.Interpreter_intStackSize -= 2;
							var10 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
							var9 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
							var12 = class143.archive13.takeFile(var9, 0);
							var13 = new Font(var12);
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var13.lineWidth(var3, var10);
							return 1;
						} else if (var0 == 4110) {
							class125.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4;
							}

							return 1;
						} else if (var0 == 4111) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == 4112) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							var10 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3 + (char)var10;
							return 1;
						} else if (var0 == 4113) {
							var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = class340.isCharPrintable((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4114) {
							var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = ClanSettings.isAlphaNumeric((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4115) {
							var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = BuddyRankComparator.isCharAlphabetic((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var11 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = GrandExchangeOffer.isDigit((char)var11) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == 4118) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							class379.Interpreter_intStackSize -= 2;
							var10 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
							var9 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3.substring(var10, var9);
							return 1;
						} else if (var0 == 4119) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							StringBuilder var16 = new StringBuilder(var3.length());
							boolean var18 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var18 = true;
								} else if (var7 == '>') {
									var18 = false;
								} else if (!var18) {
									var16.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var16.toString();
							return 1;
						} else if (var0 == 4120) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							var10 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3.indexOf(var10);
							return 1;
						} else if (var0 == 4121) {
							class125.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
							var9 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var3.indexOf(var4, var9);
							return 1;
						} else if (var0 == 4122) {
							var3 = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else if (var0 == 4123) {
							class125.Interpreter_stringStackSize -= 3;
							var3 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
							String var5 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 2];
							if (class296.localPlayer.appearance == null) {
								Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5;
								return 1;
							} else {
								switch(class296.localPlayer.appearance.field3425) {
								case 0:
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3;
									break;
								case 1:
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4;
									break;
								case 2:
								default:
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var5;
								}

								return 1;
							}
						} else {
							return 2;
						}
					}
				} else {
					class125.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_stringStack[class125.Interpreter_stringStackSize + 1];
					if (class296.localPlayer.appearance != null && class296.localPlayer.appearance.field3423 != 0) {
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4;
					} else {
						Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "279996688"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
