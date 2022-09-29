import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("gq")
	static String field1164;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1041677133
	)
	@Export("x")
	int x;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 1623549859
	)
	@Export("y")
	int y;
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -853907471
	)
	@Export("rotation")
	int rotation;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1129314889
	)
	int field1131;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1957403439
	)
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -595475907
	)
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1619429821
	)
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1278311795
	)
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 2064937793
	)
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1460692157
	)
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 558080795
	)
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -680657199
	)
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 136397527
	)
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1551823215
	)
	int field1189;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -1469200361
	)
	int field1193;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 27746573
	)
	int field1143;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1804058957
	)
	int field1144;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1345091061
	)
	int field1179;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -807066259
	)
	int field1182;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1619265253
	)
	int field1171;
	@ObfuscatedName("au")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("bg")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("bw")
	boolean field1150;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1333604775
	)
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("bv")
	@ObfuscatedGetter(
		intValue = -664621931
	)
	@Export("overheadTextColor")
	int overheadTextColor;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 1743206661
	)
	@Export("overheadTextEffect")
	int overheadTextEffect;
	@ObfuscatedName("by")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("bz")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("bo")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("br")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("bp")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("bd")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = 1336513003
	)
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("bh")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = -871785757
	)
	int field1163;
	@ObfuscatedName("be")
	boolean field1141;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 276791825
	)
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -1288086573
	)
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = 238768931
	)
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1617908651
	)
	int field1168;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1069042073
	)
	@Export("sequence")
	int sequence;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -579241143
	)
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -1190504043
	)
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		intValue = -162328707
	)
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -1720247151
	)
	int field1173;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = 330017977
	)
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("cv")
	@ObfuscatedGetter(
		intValue = -1153122297
	)
	@Export("spotAnimationFrame")
	int spotAnimationFrame;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = 1830362223
	)
	int field1176;
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = -1632557087
	)
	int field1147;
	@ObfuscatedName("ct")
	@ObfuscatedGetter(
		intValue = 287498913
	)
	int field1145;
	@ObfuscatedName("cj")
	@ObfuscatedGetter(
		intValue = -774122863
	)
	int field1192;
	@ObfuscatedName("cl")
	@ObfuscatedGetter(
		intValue = 1362945189
	)
	int field1180;
	@ObfuscatedName("cw")
	@ObfuscatedGetter(
		intValue = -1883558077
	)
	int field1181;
	@ObfuscatedName("ce")
	@ObfuscatedGetter(
		intValue = 1326253047
	)
	int field1140;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = 127615547
	)
	int field1183;
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -785397471
	)
	int field1136;
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -1761409573
	)
	int field1185;
	@ObfuscatedName("cr")
	@ObfuscatedGetter(
		intValue = -497664845
	)
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("co")
	@ObfuscatedGetter(
		intValue = 1921853011
	)
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("ca")
	@ObfuscatedGetter(
		intValue = 981930685
	)
	int field1188;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = 2012041551
	)
	int field1158;
	@ObfuscatedName("cq")
	byte field1190;
	@ObfuscatedName("cp")
	byte field1191;
	@ObfuscatedName("ck")
	byte field1169;
	@ObfuscatedName("ci")
	byte field1194;
	@ObfuscatedName("cb")
	@ObfuscatedGetter(
		intValue = 572152345
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("cd")
	@ObfuscatedGetter(
		intValue = 743919699
	)
	int field1195;
	@ObfuscatedName("cs")
	@ObfuscatedGetter(
		intValue = 1509004959
	)
	int field1196;
	@ObfuscatedName("ch")
	@ObfuscatedGetter(
		intValue = -157413117
	)
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("cc")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("cm")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		descriptor = "[Lga;"
	)
	@Export("pathTraversed")
	class193[] pathTraversed;
	@ObfuscatedName("df")
	@ObfuscatedGetter(
		intValue = -1377547959
	)
	int field1201;
	@ObfuscatedName("du")
	@ObfuscatedGetter(
		intValue = -614769655
	)
	int field1202;
	@ObfuscatedName("da")
	@ObfuscatedGetter(
		intValue = 1423849969
	)
	int field1203;

	Actor() {
		this.isWalking = false;
		this.field1131 = 1;
		this.idleSequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.field1189 = -1;
		this.field1193 = -1;
		this.field1143 = -1;
		this.field1144 = -1;
		this.field1179 = -1;
		this.field1182 = -1;
		this.field1171 = -1;
		this.overheadText = null;
		this.field1150 = false;
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
		this.field1163 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field1168 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.field1173 = 0;
		this.spotAnimation = -1;
		this.spotAnimationFrame = 0;
		this.field1176 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.field1188 = -1;
		this.field1158 = -1;
		this.field1195 = 0;
		this.field1196 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new class193[10];
		this.field1201 = 0;
		this.field1202 = 0;
		this.field1203 = -1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-77"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-613135881"
	)
	final void method2331() {
		this.pathLength = 0;
		this.field1202 = 0;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "90761703"
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
			HitSplatDefinition var12 = class126.method2973(var1);
			var10 = var12.field2060;
			var11 = var12.field2051;
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

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIB)V",
		garbageValue = "4"
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
			if (var13.definition.field1889 == var8.field1889) {
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

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "27011"
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

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		descriptor = "(Lgd;IIII)V",
		garbageValue = "478596180"
	)
	static void method2348(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Player.clientPreferences.method2474() != 0) {
			if (var0.field2201 != null && var0.field2201.containsKey(var1)) {
				int var4 = (Integer)var0.field2201.get(var1);
				if (var4 != 0) {
					int var7 = var4 >> 8;
					int var8 = var4 >> 4 & 7;
					int var9 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var7;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var8;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var10 = (var2 - 64) / 128;
					int var11 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var9 + (var11 << 8) + (var10 << 16);
					++Client.soundEffectCount;
				}

			}
		}
	}
}
