import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("bs")
	@Export("x")
	int x;
	@ObfuscatedName("bp")
	@Export("y")
	int y;
	@ObfuscatedName("bv")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("bq")
	int field976;
	@ObfuscatedName("bo")
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("br")
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("bw")
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("be")
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("bc")
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("bi")
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("bu")
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("bk")
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("bz")
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("bx")
	@Export("runBackSequence")
	int runBackSequence;
	@ObfuscatedName("bh")
	@Export("runLeftSequence")
	int runLeftSequence;
	@ObfuscatedName("bm")
	@Export("runRightSequence")
	int runRightSequence;
	@ObfuscatedName("bl")
	@Export("crawlSequence")
	int crawlSequence;
	@ObfuscatedName("bt")
	@Export("crawlBackSequence")
	int crawlBackSequence;
	@ObfuscatedName("by")
	@Export("crawlLeftSequence")
	int crawlLeftSequence;
	@ObfuscatedName("bg")
	@Export("crawlRightSequence")
	int crawlRightSequence;
	@ObfuscatedName("bj")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("ct")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("cf")
	@Export("showPublicPlayerChat")
	boolean showPublicPlayerChat;
	@ObfuscatedName("cz")
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("cb")
	int field986;
	@ObfuscatedName("cs")
	int field994;
	@ObfuscatedName("cj")
	int[] field1023;
	@ObfuscatedName("cw")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("ce")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("cq")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("cm")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("ca")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("cx")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "Lor;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("cu")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("cr")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("cd")
	@Export("movingOrientation")
	int movingOrientation;
	@ObfuscatedName("cy")
	int field997;
	@ObfuscatedName("ck")
	int field992;
	@ObfuscatedName("cl")
	boolean field958;
	@ObfuscatedName("cp")
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("ch")
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("cg")
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("ci")
	int field991;
	@ObfuscatedName("cv")
	@Export("sequence")
	int sequence;
	@ObfuscatedName("cc")
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("dc")
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("dq")
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("dg")
	@Export("currentSequenceFrameIndex")
	int currentSequenceFrameIndex;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		descriptor = "Lsa;"
	)
	IterableNodeHashTable field1032;
	@ObfuscatedName("dy")
	int field1017;
	@ObfuscatedName("dr")
	int field1013;
	@ObfuscatedName("do")
	int field1011;
	@ObfuscatedName("dk")
	int field1007;
	@ObfuscatedName("dn")
	int field1010;
	@ObfuscatedName("di")
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("de")
	@Export("exactMoveArrive1Cycle")
	int exactMoveArrive1Cycle;
	@ObfuscatedName("dd")
	@Export("exactMoveDirection")
	int exactMoveDirection;
	@ObfuscatedName("dt")
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("df")
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("dm")
	@Export("recolourStartCycle")
	int recolourStartCycle;
	@ObfuscatedName("du")
	@Export("recolourEndCycle")
	int recolourEndCycle;
	@ObfuscatedName("dz")
	@Export("recolourHue")
	byte recolourHue;
	@ObfuscatedName("dx")
	@Export("recolourSaturation")
	byte recolourSaturation;
	@ObfuscatedName("dp")
	@Export("recolourLuminance")
	byte recolourLuminance;
	@ObfuscatedName("ds")
	@Export("recolourAmount")
	byte recolourAmount;
	@ObfuscatedName("da")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("dv")
	int field1016;
	@ObfuscatedName("dh")
	int field1005;
	@ObfuscatedName("dl")
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("db")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("dw")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		descriptor = "[Lio;"
	)
	@Export("pathTraversed")
	MoveSpeed[] pathTraversed;
	@ObfuscatedName("em")
	int field1020;
	@ObfuscatedName("ec")
	int field1018;
	@ObfuscatedName("el")
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
		this.field986 = 0;
		this.field994 = 0;
		this.field1023 = null;
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
		this.field997 = -1;
		this.field992 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field991 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.currentSequenceFrameIndex = 0;
		this.field1032 = new IterableNodeHashTable(4);
		this.field1017 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.recolourStartCycle = -1;
		this.recolourEndCycle = -1;
		this.field1016 = 0;
		this.field1005 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new MoveSpeed[10];
		this.field1020 = 0;
		this.field1018 = 0;
		this.combatLevelChange = -1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "0"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "179353417"
	)
	final void method517() {
		this.pathLength = 0;
		this.field1018 = 0;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIB)V",
		garbageValue = "114"
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
			HitSplatDefinition var12 = class177.method907(var1);
			var10 = var12.field1685;
			var11 = var12.field1687;
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

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "-730054495"
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
			var8.field1541 = var1;
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
			if (var13.definition.field1541 == var8.field1541) {
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

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "281579888"
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
			var3.field1541 = var1;
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

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "921981147"
	)
	void method522(int var1, int var2, int var3, int var4) {
		int var5 = var4 + Client.cycle;
		class536 var6 = (class536)this.field1032.get((long)var1);
		if (var6 != null) {
			var6.remove();
			--this.field1017;
		}

		if (var2 != 65535 && var2 != -1) {
			byte var7 = 0;
			if (var4 > 0) {
				var7 = -1;
			}

			this.field1032.put(new class536(var2, var3, var5, var7), (long)var1);
			++this.field1017;
		}
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)Lsa;",
		garbageValue = "655512297"
	)
	IterableNodeHashTable method523() {
		return this.field1032;
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1776103193"
	)
	void method524() {
		IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.field1032);

		for (class536 var2 = (class536)var1.method2423(); var2 != null; var2 = (class536)var1.next()) {
			var2.remove();
		}

		this.field1017 = 0;
	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(Ljo;I)Ljo;",
		garbageValue = "1288995708"
	)
	Model method525(Model var1) {
		if (this.field1017 == 0) {
			return var1;
		} else {
			IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.field1032);
			int var3 = var1.verticesCount;
			int var4 = var1.indicesCount;
			int var5 = var1.field2216;
			byte var6 = var1.field2211;

			for (class536 var7 = (class536)var2.method2423(); var7 != null; var7 = (class536)var2.next()) {
				if (var7.field4239 != -1) {
					Model var8 = NPCComposition.SpotAnimationDefinition_get(var7.field4238).method985();
					if (var8 != null) {
						var3 += var8.verticesCount;
						var4 += var8.indicesCount;
						var5 += var8.field2216;
					}
				}
			}

			Model var10 = new Model(var3, var4, var5, var6);
			var10.method1285(var1);

			for (class536 var11 = (class536)var2.method2423(); var11 != null; var11 = (class536)var2.next()) {
				if (var11.field4239 != -1) {
					Model var9 = NPCComposition.SpotAnimationDefinition_get(var11.field4238).getModel(var11.field4239);
					if (var9 != null) {
						var9.offsetBy(0, -var11.field4237, 0);
						var10.method1285(var9);
					}
				}
			}

			return var10;
		}
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "110"
	)
	void method526() {
		this.field958 = false;
		this.movingOrientation = -1;
		this.field997 = -1;
		this.field992 = -1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[IIIB)V",
		garbageValue = "-19"
	)
	public static void method516(String[] var0, int[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			int var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					int var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			method516(var0, var1, var2, var5 - 1);
			method516(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
		garbageValue = "-1889"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "101"
	)
	static void method527() {
		class20.field58 = System.getenv("JX_ACCESS_TOKEN");
		Script.field807 = System.getenv("JX_REFRESH_TOKEN");
		class11.field36 = System.getenv("JX_SESSION_ID");
		Login.field766 = System.getenv("JX_CHARACTER_ID");
		String var0 = System.getenv("JX_DISPLAY_NAME");
		String var1;
		if (var0 != null && !var0.isEmpty() && var0.charAt(0) != '#') {
			var1 = var0;
		} else {
			var1 = "";
		}

		Login.field761 = var1;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZI)V",
		garbageValue = "-2105376256"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = class113.fontPlain12.lineWidth(var0, 250);
			int var6 = class113.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
			class113.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			Skeleton.method1209(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
			if (var1) {
				class156.rasterProvider.drawFull(0, 0);
			} else {
				int var7 = var3;
				int var8 = var4;
				int var9 = var5;
				int var10 = var6;

				for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
					if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var7 + var9 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
						Client.field404[var11] = true;
					}
				}
			}

		}
	}

	@ObfuscatedName("md")
	@ObfuscatedSignature(
		descriptor = "(Ldn;ZI)V",
		garbageValue = "1063629203"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1 && var2 != -1 && Widget.Widget_loadedInterfaces[var2]) {
			ArchiveLoader.Widget_archive.clearFilesGroup(var2);
			if (ArchiveLoader.Widget_interfaceComponents[var2] != null) {
				for (int var4 = 0; var4 < ArchiveLoader.Widget_interfaceComponents[var2].length; ++var4) {
					if (ArchiveLoader.Widget_interfaceComponents[var2][var4] != null) {
						ArchiveLoader.Widget_interfaceComponents[var2][var4] = null;
					}
				}

				ArchiveLoader.Widget_interfaceComponents[var2] = null;
				Widget.Widget_loadedInterfaces[var2] = false;
			}
		}

		for (IntegerNode var5 = (IntegerNode)Client.widgetFlags.first(); var5 != null; var5 = (IntegerNode)Client.widgetFlags.next()) {
			if ((var5.key >> 48 & 65535L) == (long)var2) {
				var5.remove();
			}
		}

		Widget var6 = VarbitComposition.getWidget(var3);
		if (var6 != null) {
			class200.invalidateWidget(var6);
		}

		if (Client.rootInterface != -1) {
			ChatChannel.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
