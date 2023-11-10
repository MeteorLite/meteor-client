import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

@ObfuscatedName("df")
@Implements("Actor")
public abstract class Actor extends Renderable {
	@ObfuscatedName("an")
	@Export("isWalking")
	boolean isWalking;
	@ObfuscatedName("bf")
	@Export("x")
	int x;
	@ObfuscatedName("bg")
	@Export("y")
	int y;
	@ObfuscatedName("ba")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("bm")
	int field983;
	@ObfuscatedName("bp")
	@Export("playerCycle")
	int playerCycle;
	@ObfuscatedName("bw")
	@Export("idleSequence")
	int idleSequence;
	@ObfuscatedName("bj")
	@Export("turnLeftSequence")
	int turnLeftSequence;
	@ObfuscatedName("bn")
	@Export("turnRightSequence")
	int turnRightSequence;
	@ObfuscatedName("bo")
	@Export("walkSequence")
	int walkSequence;
	@ObfuscatedName("bt")
	@Export("walkBackSequence")
	int walkBackSequence;
	@ObfuscatedName("bu")
	@Export("walkLeftSequence")
	int walkLeftSequence;
	@ObfuscatedName("by")
	@Export("walkRightSequence")
	int walkRightSequence;
	@ObfuscatedName("bh")
	@Export("runSequence")
	int runSequence;
	@ObfuscatedName("bz")
	@Export("runBackSequence")
	int runBackSequence;
	@ObfuscatedName("bc")
	@Export("runLeftSequence")
	int runLeftSequence;
	@ObfuscatedName("bs")
	@Export("runRightSequence")
	int runRightSequence;
	@ObfuscatedName("bx")
	@Export("crawlSequence")
	int crawlSequence;
	@ObfuscatedName("bb")
	@Export("crawlBackSequence")
	int crawlBackSequence;
	@ObfuscatedName("bk")
	@Export("crawlLeftSequence")
	int crawlLeftSequence;
	@ObfuscatedName("br")
	@Export("crawlRightSequence")
	int crawlRightSequence;
	@ObfuscatedName("bq")
	@Export("overheadText")
	String overheadText;
	@ObfuscatedName("cf")
	@Export("isAutoChatting")
	boolean isAutoChatting;
	@ObfuscatedName("cg")
	@Export("showPublicPlayerChat")
	boolean showPublicPlayerChat;
	@ObfuscatedName("cv")
	@Export("overheadTextCyclesRemaining")
	int overheadTextCyclesRemaining;
	@ObfuscatedName("cx")
	int field1005;
	@ObfuscatedName("cp")
	int field1003;
	@ObfuscatedName("ce")
	int[] field1030;
	@ObfuscatedName("ct")
	@Export("hitSplatCount")
	byte hitSplatCount;
	@ObfuscatedName("cw")
	@Export("hitSplatTypes")
	int[] hitSplatTypes;
	@ObfuscatedName("cq")
	@Export("hitSplatValues")
	int[] hitSplatValues;
	@ObfuscatedName("cl")
	@Export("hitSplatCycles")
	int[] hitSplatCycles;
	@ObfuscatedName("cs")
	@Export("hitSplatTypes2")
	int[] hitSplatTypes2;
	@ObfuscatedName("co")
	@Export("hitSplatValues2")
	int[] hitSplatValues2;
	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("healthBars")
	IterableNodeDeque healthBars;
	@ObfuscatedName("cn")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("cr")
	@Export("false0")
	boolean false0;
	@ObfuscatedName("cj")
	@Export("movingOrientation")
	int movingOrientation;
	@ObfuscatedName("ca")
	int field995;
	@ObfuscatedName("cc")
	int field997;
	@ObfuscatedName("cu")
	boolean field969;
	@ObfuscatedName("ch")
	@Export("movementSequence")
	int movementSequence;
	@ObfuscatedName("cb")
	@Export("movementFrame")
	int movementFrame;
	@ObfuscatedName("cz")
	@Export("movementFrameCycle")
	int movementFrameCycle;
	@ObfuscatedName("cy")
	int field1006;
	@ObfuscatedName("ck")
	@Export("sequence")
	int sequence;
	@ObfuscatedName("cd")
	@Export("sequenceFrame")
	int sequenceFrame;
	@ObfuscatedName("dt")
	@Export("sequenceFrameCycle")
	int sequenceFrameCycle;
	@ObfuscatedName("di")
	@Export("sequenceDelay")
	int sequenceDelay;
	@ObfuscatedName("dk")
	@Export("currentSequenceFrameIndex")
	int currentSequenceFrameIndex;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		descriptor = "Ltz;"
	)
	@Export("spotAnimations")
	IterableNodeHashTable spotAnimations;
	@ObfuscatedName("dx")
	int field1026;
	@ObfuscatedName("dh")
	int field1013;
	@ObfuscatedName("du")
	int field1024;
	@ObfuscatedName("dg")
	int field1012;
	@ObfuscatedName("dc")
	int field1010;
	@ObfuscatedName("do")
	@Export("spotAnimation")
	int spotAnimation;
	@ObfuscatedName("db")
	@Export("exactMoveArrive1Cycle")
	int exactMoveArrive1Cycle;
	@ObfuscatedName("dm")
	@Export("exactMoveDirection")
	int exactMoveDirection;
	@ObfuscatedName("dr")
	@Export("npcCycle")
	int npcCycle;
	@ObfuscatedName("ds")
	@Export("defaultHeight")
	int defaultHeight;
	@ObfuscatedName("da")
	@Export("recolourStartCycle")
	int recolourStartCycle;
	@ObfuscatedName("dw")
	@Export("recolourEndCycle")
	int recolourEndCycle;
	@ObfuscatedName("dp")
	@Export("recolourHue")
	byte recolourHue;
	@ObfuscatedName("df")
	@Export("recolourSaturation")
	byte recolourSaturation;
	@ObfuscatedName("dv")
	@Export("recolourLuminance")
	byte recolourLuminance;
	@ObfuscatedName("dz")
	@Export("recolourAmount")
	byte recolourAmount;
	@ObfuscatedName("dl")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("de")
	int field1011;
	@ObfuscatedName("dn")
	int field1018;
	@ObfuscatedName("dq")
	@Export("pathLength")
	int pathLength;
	@ObfuscatedName("dj")
	@Export("pathX")
	int[] pathX;
	@ObfuscatedName("dy")
	@Export("pathY")
	int[] pathY;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		descriptor = "[Liz;"
	)
	@Export("pathTraversed")
	MoveSpeed[] pathTraversed;
	@ObfuscatedName("ew")
	int field1028;
	@ObfuscatedName("ex")
	int field1029;
	@ObfuscatedName("ev")
	@Export("combatLevelChange")
	int combatLevelChange;

	Actor() {
		this.isWalking = false;
		this.field983 = 1;
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
		this.field1005 = 0;
		this.field1003 = 0;
		this.field1030 = null;
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
		this.field997 = -1;
		this.movementSequence = -1;
		this.movementFrame = 0;
		this.movementFrameCycle = 0;
		this.field1006 = 0;
		this.sequence = -1;
		this.sequenceFrame = 0;
		this.sequenceFrameCycle = 0;
		this.sequenceDelay = 0;
		this.currentSequenceFrameIndex = 0;
		this.spotAnimations = new IterableNodeHashTable(4);
		this.field1026 = 0;
		this.npcCycle = 0;
		this.defaultHeight = 200;
		this.recolourStartCycle = -1;
		this.recolourEndCycle = -1;
		this.field1011 = 0;
		this.field1018 = 32;
		this.pathLength = 0;
		this.pathX = new int[10];
		this.pathY = new int[10];
		this.pathTraversed = new MoveSpeed[10];
		this.field1028 = 0;
		this.field1029 = 0;
		this.combatLevelChange = -1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1221291483"
	)
	@Export("isVisible")
	boolean isVisible() {
		return false;
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "585669071"
	)
	final void method506() {
		this.pathLength = 0;
		this.field1029 = 0;
	}

	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIB)V",
		garbageValue = "31"
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
			HitSplatDefinition var12 = class149.method776(var1);
			var10 = var12.field1656;
			var11 = var12.field1658;
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

	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "(IIIIIII)V",
		garbageValue = "-2108984921"
	)
	@Export("addHealthBar")
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = class92.method497(var1);
		HealthBar var8 = null;
		HealthBar var9 = null;
		int var10 = var7.int2;
		int var11 = 0;

		HealthBar var12;
		for (var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
			++var11;
			if (var12.definition.field1494 == var7.field1494) {
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

	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-875440561"
	)
	@Export("removeHealthBar")
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = class92.method497(var1);

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
		garbageValue = "-702211426"
	)
	@Export("updateSpotAnimation")
	void updateSpotAnimation(int var1, int var2, int var3, int var4) {
		int var5 = var4 + Client.cycle;
		SpotAnimation var6 = (SpotAnimation)this.spotAnimations.get((long)var1);
		if (var6 != null) {
			var6.remove();
			--this.field1026;
		}

		if (var2 != 65535 && var2 != -1) {
			byte var7 = 0;
			if (var4 > 0) {
				var7 = -1;
			}

			this.spotAnimations.put(new SpotAnimation(var2, var3, var5, var7), (long)var1);
			++this.field1026;
		}
	}

	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "(B)Ltz;",
		garbageValue = "-1"
	)
	IterableNodeHashTable method512() {
		return this.spotAnimations;
	}

	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "98"
	)
	void method513() {
		IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.spotAnimations);

		for (SpotAnimation var2 = (SpotAnimation)var1.method2461(); var2 != null; var2 = (SpotAnimation)var1.next()) {
			var2.remove();
		}

		this.field1026 = 0;
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(Lka;I)Lka;",
		garbageValue = "-1145530728"
	)
	Model method514(Model var1) {
		if (this.field1026 == 0) {
			return var1;
		} else {
			IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.spotAnimations);
			int var3 = var1.verticesCount;
			int var4 = var1.indicesCount;
			int var5 = var1.field2421;
			byte var6 = var1.field2415;

			for (SpotAnimation var7 = (SpotAnimation)var2.method2461(); var7 != null; var7 = (SpotAnimation)var2.next()) {
				if (var7.field4310 != -1) {
					Model var8 = Canvas.SpotAnimationDefinition_get(var7.field4313).method966();
					if (var8 != null) {
						var3 += var8.verticesCount;
						var4 += var8.indicesCount;
						var5 += var8.field2421;
					}
				}
			}

			Model var10 = new Model(var3, var4, var5, var6);
			var10.method1532(var1);

			for (SpotAnimation var11 = (SpotAnimation)var2.method2461(); var11 != null; var11 = (SpotAnimation)var2.next()) {
				if (var11.field4310 != -1) {
					Model var9 = Canvas.SpotAnimationDefinition_get(var11.field4313).getModel(var11.field4310);
					if (var9 != null) {
						var9.offsetBy(0, -var11.field4309, 0);
						var10.method1532(var9);
					}
				}
			}

			return var10;
		}
	}

	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	void method515() {
		this.field969 = false;
		this.movingOrientation = -1;
		this.field995 = -1;
		this.field997 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lbm;Lpf;Lpf;I)V",
		garbageValue = "1431524852"
	)
	static void method516(GameEngine var0, Font var1, Font var2) {
		int var6;
		int var78;
		int var79;
		boolean var93;
		if (Login.worldSelectOpen) {
			class223 var76 = Client.keyHandlerInstance;
			class223 var4 = var76;

			while (true) {
				if (!var4.method1128()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (class19.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var77 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var77 && MouseHandler.MouseHandler_lastPressedX <= var77 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var77 + 15 && MouseHandler.MouseHandler_lastPressedX <= var77 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(0, 1);
						break;
					}

					var6 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var6 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var6 + 15 && MouseHandler.MouseHandler_lastPressedX <= var6 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(1, 1);
						break;
					}

					var78 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var78 && MouseHandler.MouseHandler_lastPressedX <= var78 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var78 + 15 && MouseHandler.MouseHandler_lastPressedX <= var78 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(2, 1);
						break;
					}

					var79 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var79 && MouseHandler.MouseHandler_lastPressedX <= var79 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var79 + 15 && MouseHandler.MouseHandler_lastPressedX <= var79 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						VarcInt.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						Login.worldSelectOpen = false;
						class250.leftTitleSprite.drawAt(Login.xPadding, 0);
						Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var80 = class361.World_worlds[Login.hoveredWorldIndex];
						if (var80.isDeadman()) {
							var80.field679 = "beta";
						}

						boolean var10 = false;
						if (var80.properties != Client.worldProperties) {
							var93 = (Client.worldProperties & class522.field4153.rsOrdinal()) != 0;
							boolean var94 = var80.isDeadman();
							if (var93 && !var94 || !var93 && var94) {
								var10 = true;
							}
						}

						class28.changeWorld(var80);
						Login.worldSelectOpen = false;
						class250.leftTitleSprite.drawAt(Login.xPadding, 0);
						Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
						if (var10) {
							ByteArrayPool.reloadJS5();
						}
					} else {
						if (Login.worldSelectPage > 0 && Varps.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= Varps.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class47.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class47.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && class105.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= Language.canvasWidth - class105.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= Language.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class47.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class47.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (var4.field1899 == 13) {
					Login.worldSelectOpen = false;
					class250.leftTitleSprite.drawAt(Login.xPadding, 0);
					Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
					Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
					break;
				}

				if (var4.field1899 == 96) {
					if (Login.worldSelectPage > 0 && Varps.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (var4.field1899 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class105.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				WorldMapIcon_1.clientPreferences.getTitleMusicDisabled(!WorldMapIcon_1.clientPreferences.getTitleMusicDisabled());
				if (!WorldMapIcon_1.clientPreferences.getTitleMusicDisabled()) {
					ArrayList var3 = new ArrayList();
					var3.add(new MusicSong(class514.archive6, "scape main", "", 255, false));
					PendingSpawn.method505(var3, 0, 0, 0, 100, false);
				} else {
					WorldMapManager.method1265(0, 0);
				}

				class472.method2350();
			}

			if (Client.gameState != 5) {
				if (-1L == Login.field774) {
					Login.field774 = SpotAnimationDefinition.method962() + 1000L;
				}

				long var37 = SpotAnimationDefinition.method962();
				boolean var5;
				if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
							var5 = true;
							break;
						}

						ArchiveLoader var39 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
						if (!var39.isLoaded()) {
							var5 = false;
							break;
						}

						++Client.archiveLoadersDone;
					}
				} else {
					var5 = true;
				}

				if (var5 && Login.field773 == -1L) {
					Login.field773 = var37;
					if (Login.field773 > Login.field774) {
						Login.field774 = Login.field773;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (class85.clientLanguage == Language.Language_EN) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var6 = Login.xPadding + 5;
							short var7 = 463;
							byte var8 = 100;
							byte var40 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var6 + var8 && MouseHandler.MouseHandler_lastPressedY >= var7 && MouseHandler.MouseHandler_lastPressedY <= var7 + var40) {
								if (class241.loadWorlds()) {
									Login.worldSelectOpen = true;
									Login.worldSelectPage = 0;
									Login.worldSelectPagesCount = 0;
								}

								return;
							}
						}

						if (class542.World_request != null && class241.loadWorlds()) {
							Login.worldSelectOpen = true;
							Login.worldSelectPage = 0;
							Login.worldSelectPagesCount = 0;
						}
					}

					var6 = MouseHandler.MouseHandler_lastButton;
					var78 = MouseHandler.MouseHandler_lastPressedX;
					var79 = MouseHandler.MouseHandler_lastPressedY;
					if (var6 == 0) {
						var78 = MouseHandler.MouseHandler_x;
						var79 = MouseHandler.MouseHandler_y;
					}

					if (!class19.mouseCam && var6 == 4) {
						var6 = 1;
					}

					class223 var9 = Client.keyHandlerInstance;
					class223 var41 = var9;
					short var82;
					int var83;
					if (Login.loginIndex == 0) {
						var93 = false;

						while (var41.method1128()) {
							if (var41.field1899 == 84) {
								var93 = true;
							}
						}

						var83 = class157.loginBoxCenter - 80;
						var82 = 291;
						if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20) {
							HealthBar.openURL(class251.method1336("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var83 = class157.loginBoxCenter + 80;
						if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20 || var93) {
							if ((Client.worldProperties & class522.field4151.rsOrdinal()) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								UserComparator7.method674(1);
								class150.method785();
							} else if ((Client.worldProperties & class522.field4157.rsOrdinal()) != 0) {
								if ((Client.worldProperties & class522.field4156.rsOrdinal()) != 0) {
									Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other almost everywhere";
									Login.Login_response3 = "and the Protect Item prayer won't work.";
								} else {
									Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other";
									Login.Login_response3 = "almost everywhere.";
								}

								Login.Login_response0 = "Warning!";
								UserComparator7.method674(1);
								class150.method785();
							} else if ((Client.worldProperties & class522.field4156.rsOrdinal()) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								UserComparator7.method674(1);
								class150.method785();
							} else {
								SoundSystem.Login_promptCredentials(false);
							}
						}
					} else {
						int var11;
						short var12;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!var41.method1128()) {
									var11 = class157.loginBoxCenter - 80;
									var12 = 321;
									if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
										SoundSystem.Login_promptCredentials(false);
									}

									var11 = class157.loginBoxCenter + 80;
									if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
										UserComparator7.method674(0);
									}
									break;
								}

								if (var41.field1899 == 84) {
									SoundSystem.Login_promptCredentials(false);
								} else if (var41.field1899 == 13) {
									UserComparator7.method674(0);
								}
							}
						} else {
							int var15;
							short var81;
							if (Login.loginIndex == 2) {
								var81 = 201;
								var11 = var81 + 52;
								if (var6 == 1 && var79 >= var11 - 12 && var79 < var11 + 2) {
									Login.currentLoginField = 0;
								}

								var11 += 15;
								if (var6 == 1 && var79 >= var11 - 12 && var79 < var11 + 2) {
									Login.currentLoginField = 1;
								}

								var11 += 15;
								var81 = 361;
								if (Login.field775 != null) {
									var83 = Login.field775.highX / 2;
									if (var6 == 1 && var78 >= Login.field775.lowX - var83 && var78 <= var83 + Login.field775.lowX && var79 >= var81 - 15 && var79 < var81) {
										switch(Login.field750) {
										case 1:
											HealthBar.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
											return;
										case 2:
											HealthBar.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var83 = class157.loginBoxCenter - 80;
								var82 = 321;
								if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20) {
									class478.method2365();
									return;
								}

								var83 = Login.loginBoxX + 180 + 80;
								if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20) {
									UserComparator7.method674(0);
									Login.Login_username = "";
									Login.Login_password = "";
									class53.field256 = 0;
									NewShit.otp = "";
									Login.field744 = true;
								}

								var83 = class157.loginBoxCenter + -117;
								var82 = 277;
								Login.field743 = var78 >= var83 && var78 < var83 + NPCComposition.field1532 && var79 >= var82 && var79 < var82 + class113.field1178;
								if (var6 == 1 && Login.field743) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && WorldMapIcon_1.clientPreferences.getUsernameToRemember() != null) {
										WorldMapIcon_1.clientPreferences.setUsernameToRemember((String)null);
									}
								}

								var83 = class157.loginBoxCenter + 24;
								var82 = 277;
								Login.field745 = var78 >= var83 && var78 < var83 + NPCComposition.field1532 && var79 >= var82 && var79 < var82 + class113.field1178;
								if (var6 == 1 && Login.field745) {
									WorldMapIcon_1.clientPreferences.setIsUsernameHidden(!WorldMapIcon_1.clientPreferences.getIsUsernameHidden());
									if (!WorldMapIcon_1.clientPreferences.getIsUsernameHidden()) {
										Login.Login_username = "";
										WorldMapIcon_1.clientPreferences.setUsernameToRemember((String)null);
										class150.method785();
									}
								}

								while (true) {
									int var88;
									Transferable var104;
									do {
										while (true) {
											label1419:
											do {
												while (true) {
													while (var41.method1128()) {
														if (var41.field1899 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1419;
															}

															char var87 = var41.field1897;

															for (var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var87 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15); ++var15) {
															}

															if (var41.field1899 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (var41.field1899 == 84 || var41.field1899 == 80) {
																Login.currentLoginField = 1;
															}

															if (WorldMapScaleHandler.method1380(var41.field1897) && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + var41.field1897;
															}
														} else {
															UserComparator7.method674(0);
															Login.Login_username = "";
															Login.Login_password = "";
															class53.field256 = 0;
															NewShit.otp = "";
															Login.field744 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (var41.field1899 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (var41.field1899 == 84 || var41.field1899 == 80) {
												Login.currentLoginField = 0;
												if (var41.field1899 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														class139.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														class139.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													class139.setLoginResponseString("", "Connecting to server...", "");
													VerticalAlignment.method958(false);
													WorldMapSection2.updateGameState(20);
													return;
												}
											}

											if ((var41.getKeyPressed(82) || var41.getKeyPressed(87)) && var41.field1899 == 67) {
												Clipboard var103 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var104 = var103.getContents(SpriteMask.client);
												var88 = 20 - Login.Login_password.length();
												break;
											}

											if (DirectByteArrayCopier.method1884(var41.field1897) && WorldMapScaleHandler.method1380(var41.field1897) && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + var41.field1897;
											}
										}
									} while(var88 <= 0);

									try {
										String var89 = (String)var104.getTransferData(DataFlavor.stringFlavor);
										int var92 = Math.min(var88, var89.length());

										for (int var19 = 0; var19 < var92; ++var19) {
											if (!DirectByteArrayCopier.method1884(var89.charAt(var19)) || !WorldMapScaleHandler.method1380(var89.charAt(var19))) {
												UserComparator7.method674(3);
												return;
											}
										}

										Login.Login_password = Login.Login_password + var89.substring(0, var92);
									} catch (UnsupportedFlavorException var74) {
									} catch (IOException var75) {
									}
								}
							} else {
								Bounds var44;
								if (Login.loginIndex == 3) {
									var11 = Login.loginBoxX + 180;
									var12 = 241;
									var44 = var1.method2105(25, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.".length() - 34, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", var11, var12);
									if (var6 == 1 && var44.method2300(var78, var79)) {
										HealthBar.openURL("https://oldschool.runescape.com/launcher", true, false);
									}

									var11 = Login.loginBoxX + 180;
									var12 = 276;
									if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
										ClientPreferences.method568(false);
									}

									var11 = Login.loginBoxX + 180;
									var12 = 326;
									if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
										HealthBar.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
										return;
									}
								} else {
									int var14;
									if (Login.loginIndex == 4) {
										var11 = Login.loginBoxX + 180 - 80;
										var12 = 321;
										if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
											NewShit.otp.trim();
											if (NewShit.otp.length() != 6) {
												class139.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
												return;
											}

											class53.field256 = Integer.parseInt(NewShit.otp);
											NewShit.otp = "";
											VerticalAlignment.method958(true);
											class139.setLoginResponseString("", "Connecting to server...", "");
											WorldMapSection2.updateGameState(20);
											return;
										}

										if (var6 == 1 && var78 >= Login.loginBoxX + 180 - 9 && var78 <= Login.loginBoxX + 180 + 130 && var79 >= 263 && var79 <= 296) {
											Login.field744 = !Login.field744;
										}

										if (var6 == 1 && var78 >= Login.loginBoxX + 180 - 34 && var78 <= Login.loginBoxX + 34 + 180 && var79 >= 351 && var79 <= 363) {
											HealthBar.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
										}

										var11 = Login.loginBoxX + 180 + 80;
										if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
											UserComparator7.method674(0);
											Login.Login_username = "";
											Login.Login_password = "";
											class53.field256 = 0;
											NewShit.otp = "";
										}

										while (var41.method1128()) {
											boolean var13 = false;

											for (var14 = 0; var14 < "1234567890".length(); ++var14) {
												if (var41.field1897 == "1234567890".charAt(var14)) {
													var13 = true;
													break;
												}
											}

											if (var41.field1899 == 13) {
												UserComparator7.method674(0);
												Login.Login_username = "";
												Login.Login_password = "";
												class53.field256 = 0;
												NewShit.otp = "";
											} else {
												if (var41.field1899 == 85 && NewShit.otp.length() > 0) {
													NewShit.otp = NewShit.otp.substring(0, NewShit.otp.length() - 1);
												}

												if (var41.field1899 == 84) {
													NewShit.otp.trim();
													if (NewShit.otp.length() != 6) {
														class139.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
														return;
													}

													class53.field256 = Integer.parseInt(NewShit.otp);
													NewShit.otp = "";
													VerticalAlignment.method958(true);
													class139.setLoginResponseString("", "Connecting to server...", "");
													WorldMapSection2.updateGameState(20);
													return;
												}

												if (var13 && NewShit.otp.length() < 6) {
													NewShit.otp = NewShit.otp + var41.field1897;
												}
											}
										}
									} else if (Login.loginIndex == 5) {
										var11 = Login.loginBoxX + 180 - 80;
										var12 = 321;
										Buffer var22;
										if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
											Login.Login_username = Login.Login_username.trim();
											if (Login.Login_username.length() == 0) {
												class139.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											} else {
												long var48;
												try {
													URL var45 = new URL(class251.method1336("services", false) + "m=accountappeal/login.ws");
													URLConnection var17 = var45.openConnection();
													var17.setRequestProperty("connection", "close");
													var17.setDoInput(true);
													var17.setDoOutput(true);
													var17.setConnectTimeout(5000);
													OutputStreamWriter var106 = new OutputStreamWriter(var17.getOutputStream());
													var106.write("data1=req");
													var106.flush();
													InputStream var107 = var17.getInputStream();
													Buffer var90 = new Buffer(new byte[1000]);

													while (true) {
														int var21 = var107.read(var90.array, var90.offset, 1000 - var90.offset);
														if (var21 == -1) {
															var90.offset = 0;
															long var50 = var90.readLong();
															var48 = var50;
															break;
														}

														var90.offset += var21;
														if (var90.offset >= 1000) {
															var48 = 0L;
															break;
														}
													}
												} catch (Exception var70) {
													var48 = 0L;
												}

												byte var84;
												if (var48 == 0L) {
													var84 = 5;
												} else {
													String var108 = Login.Login_username;
													Random var91 = new Random();
													Buffer var110 = new Buffer(128);
													var22 = new Buffer(128);
													int[] var96 = new int[]{var91.nextInt(), var91.nextInt(), (int)(var48 >> 32), (int)var48};
													var110.writeByte(10);

													int var24;
													for (var24 = 0; var24 < 4; ++var24) {
														var110.writeInt(var91.nextInt());
													}

													var110.writeInt(var96[0]);
													var110.writeInt(var96[1]);
													var110.writeLong(var48);
													var110.writeLong(0L);

													for (var24 = 0; var24 < 4; ++var24) {
														var110.writeInt(var91.nextInt());
													}

													var110.encryptRsa(class72.field729, class72.field730);
													var22.writeByte(10);

													for (var24 = 0; var24 < 3; ++var24) {
														var22.writeInt(var91.nextInt());
													}

													var22.writeLong(var91.nextLong());
													var22.writeLongMedium(var91.nextLong());
													class354.method1897(var22);
													var22.writeLong(var91.nextLong());
													var22.encryptRsa(class72.field729, class72.field730);
													var24 = ClanChannel.stringCp1252NullTerminatedByteSize(var108);
													if (var24 % 8 != 0) {
														var24 += 8 - var24 % 8;
													}

													Buffer var97 = new Buffer(var24);
													var97.writeStringCp1252NullTerminated(var108);
													var97.offset = var24;
													var97.xteaEncryptAll(var96);
													Buffer var26 = new Buffer(var22.offset + var110.offset + var97.offset + 5);
													var26.writeByte(2);
													var26.writeByte(var110.offset);
													var26.writeBytes(var110.array, 0, var110.offset);
													var26.writeByte(var22.offset);
													var26.writeBytes(var22.array, 0, var22.offset);
													var26.writeShort(var97.offset);
													var26.writeBytes(var97.array, 0, var97.offset);
													String var98 = class415.method2150(var26.array);

													byte var18;
													try {
														URL var99 = new URL(class251.method1336("services", false) + "m=accountappeal/login.ws");
														URLConnection var100 = var99.openConnection();
														var100.setDoInput(true);
														var100.setDoOutput(true);
														var100.setConnectTimeout(5000);
														OutputStreamWriter var101 = new OutputStreamWriter(var100.getOutputStream());
														var101.write("data2=" + WorldMapData_0.method1179(var98) + "&dest=" + WorldMapData_0.method1179("passwordchoice.ws"));
														var101.flush();
														InputStream var102 = var100.getInputStream();
														var26 = new Buffer(new byte[1000]);

														while (true) {
															int var32 = var102.read(var26.array, var26.offset, 1000 - var26.offset);
															if (var32 == -1) {
																var101.close();
																var102.close();
																String var111 = new String(var26.array);
																if (var111.startsWith("OFFLINE")) {
																	var18 = 4;
																} else if (var111.startsWith("WRONG")) {
																	var18 = 7;
																} else if (var111.startsWith("RELOAD")) {
																	var18 = 3;
																} else if (var111.startsWith("Not permitted for social network accounts.")) {
																	var18 = 6;
																} else {
																	var26.xteaDecryptAll(var96);

																	while (var26.offset > 0 && var26.array[var26.offset - 1] == 0) {
																		--var26.offset;
																	}

																	var111 = new String(var26.array, 0, var26.offset);
																	boolean var33;
																	if (var111 == null) {
																		var33 = false;
																	} else {
																		label1588: {
																			try {
																				new URL(var111);
																			} catch (MalformedURLException var68) {
																				var33 = false;
																				break label1588;
																			}

																			var33 = true;
																		}
																	}

																	if (var33) {
																		HealthBar.openURL(var111, true, false);
																		var18 = 2;
																	} else {
																		var18 = 5;
																	}
																}
																break;
															}

															var26.offset += var32;
															if (var26.offset >= 1000) {
																var18 = 5;
																break;
															}
														}
													} catch (Throwable var69) {
														var69.printStackTrace();
														var18 = 5;
													}

													var84 = var18;
												}

												switch(var84) {
												case 2:
													class139.setLoginResponseString(Strings.field3442, Strings.field3443, Strings.field3465);
													UserComparator7.method674(6);
													break;
												case 3:
													class139.setLoginResponseString("", "Error connecting to server.", "");
													break;
												case 4:
													class139.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
													break;
												case 5:
													class139.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
													break;
												case 6:
													class139.setLoginResponseString("", "Error connecting to server.", "");
													break;
												case 7:
													class139.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
												}
											}

											return;
										}

										var11 = Login.loginBoxX + 180 + 80;
										if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
											SoundSystem.Login_promptCredentials(true);
										}

										var82 = 361;
										if (class7.field13 != null) {
											var14 = class7.field13.highX / 2;
											if (var6 == 1 && var78 >= class7.field13.lowX - var14 && var78 <= var14 + class7.field13.lowX && var79 >= var82 - 15 && var79 < var82) {
												HealthBar.openURL(class251.method1336("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
											}
										}

										while (var41.method1128()) {
											boolean var85 = false;

											for (var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var15) {
												if (var41.field1897 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var15)) {
													var85 = true;
													break;
												}
											}

											if (var41.field1899 == 13) {
												SoundSystem.Login_promptCredentials(true);
											} else {
												if (var41.field1899 == 85 && Login.Login_username.length() > 0) {
													Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
												}

												if (var41.field1899 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														class139.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
													} else {
														long var52;
														try {
															URL var46 = new URL(class251.method1336("services", false) + "m=accountappeal/login.ws");
															URLConnection var47 = var46.openConnection();
															var47.setRequestProperty("connection", "close");
															var47.setDoInput(true);
															var47.setDoOutput(true);
															var47.setConnectTimeout(5000);
															OutputStreamWriter var20 = new OutputStreamWriter(var47.getOutputStream());
															var20.write("data1=req");
															var20.flush();
															InputStream var54 = var47.getInputStream();
															var22 = new Buffer(new byte[1000]);

															while (true) {
																int var56 = var54.read(var22.array, var22.offset, 1000 - var22.offset);
																if (var56 == -1) {
																	var22.offset = 0;
																	long var57 = var22.readLong();
																	var52 = var57;
																	break;
																}

																var22.offset += var56;
																if (var22.offset >= 1000) {
																	var52 = 0L;
																	break;
																}
															}
														} catch (Exception var73) {
															var52 = 0L;
														}

														byte var86;
														if (0L == var52) {
															var86 = 5;
														} else {
															String var109 = Login.Login_username;
															Random var95 = new Random();
															Buffer var23 = new Buffer(128);
															Buffer var61 = new Buffer(128);
															int[] var25 = new int[]{var95.nextInt(), var95.nextInt(), (int)(var52 >> 32), (int)var52};
															var23.writeByte(10);

															int var62;
															for (var62 = 0; var62 < 4; ++var62) {
																var23.writeInt(var95.nextInt());
															}

															var23.writeInt(var25[0]);
															var23.writeInt(var25[1]);
															var23.writeLong(var52);
															var23.writeLong(0L);

															for (var62 = 0; var62 < 4; ++var62) {
																var23.writeInt(var95.nextInt());
															}

															var23.encryptRsa(class72.field729, class72.field730);
															var61.writeByte(10);

															for (var62 = 0; var62 < 3; ++var62) {
																var61.writeInt(var95.nextInt());
															}

															var61.writeLong(var95.nextLong());
															var61.writeLongMedium(var95.nextLong());
															class354.method1897(var61);
															var61.writeLong(var95.nextLong());
															var61.encryptRsa(class72.field729, class72.field730);
															var62 = ClanChannel.stringCp1252NullTerminatedByteSize(var109);
															if (var62 % 8 != 0) {
																var62 += 8 - var62 % 8;
															}

															Buffer var27 = new Buffer(var62);
															var27.writeStringCp1252NullTerminated(var109);
															var27.offset = var62;
															var27.xteaEncryptAll(var25);
															Buffer var28 = new Buffer(var27.offset + var61.offset + var23.offset + 5);
															var28.writeByte(2);
															var28.writeByte(var23.offset);
															var28.writeBytes(var23.array, 0, var23.offset);
															var28.writeByte(var61.offset);
															var28.writeBytes(var61.array, 0, var61.offset);
															var28.writeShort(var27.offset);
															var28.writeBytes(var27.array, 0, var27.offset);
															String var29 = class415.method2150(var28.array);

															byte var65;
															try {
																URL var30 = new URL(class251.method1336("services", false) + "m=accountappeal/login.ws");
																URLConnection var31 = var30.openConnection();
																var31.setDoInput(true);
																var31.setDoOutput(true);
																var31.setConnectTimeout(5000);
																OutputStreamWriter var55 = new OutputStreamWriter(var31.getOutputStream());
																var55.write("data2=" + WorldMapData_0.method1179(var29) + "&dest=" + WorldMapData_0.method1179("passwordchoice.ws"));
																var55.flush();
																InputStream var63 = var31.getInputStream();
																var28 = new Buffer(new byte[1000]);

																while (true) {
																	int var64 = var63.read(var28.array, var28.offset, 1000 - var28.offset);
																	if (var64 == -1) {
																		var55.close();
																		var63.close();
																		String var34 = new String(var28.array);
																		if (var34.startsWith("OFFLINE")) {
																			var65 = 4;
																		} else if (var34.startsWith("WRONG")) {
																			var65 = 7;
																		} else if (var34.startsWith("RELOAD")) {
																			var65 = 3;
																		} else if (var34.startsWith("Not permitted for social network accounts.")) {
																			var65 = 6;
																		} else {
																			var28.xteaDecryptAll(var25);

																			while (var28.offset > 0 && var28.array[var28.offset - 1] == 0) {
																				--var28.offset;
																			}

																			var34 = new String(var28.array, 0, var28.offset);
																			boolean var35;
																			if (var34 == null) {
																				var35 = false;
																			} else {
																				label1590: {
																					try {
																						new URL(var34);
																					} catch (MalformedURLException var71) {
																						var35 = false;
																						break label1590;
																					}

																					var35 = true;
																				}
																			}

																			if (var35) {
																				HealthBar.openURL(var34, true, false);
																				var65 = 2;
																			} else {
																				var65 = 5;
																			}
																		}
																		break;
																	}

																	var28.offset += var64;
																	if (var28.offset >= 1000) {
																		var65 = 5;
																		break;
																	}
																}
															} catch (Throwable var72) {
																var72.printStackTrace();
																var65 = 5;
															}

															var86 = var65;
														}

														switch(var86) {
														case 2:
															class139.setLoginResponseString(Strings.field3442, Strings.field3443, Strings.field3465);
															UserComparator7.method674(6);
															break;
														case 3:
															class139.setLoginResponseString("", "Error connecting to server.", "");
															break;
														case 4:
															class139.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
															break;
														case 5:
															class139.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
															break;
														case 6:
															class139.setLoginResponseString("", "Error connecting to server.", "");
															break;
														case 7:
															class139.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
														}
													}

													return;
												}

												if (var85 && Login.Login_username.length() < 320) {
													Login.Login_username = Login.Login_username + var41.field1897;
												}
											}
										}
									} else if (Login.loginIndex != 6) {
										if (Login.loginIndex == 7) {
											if (PendingSpawn.field949 && !Client.onMobile) {
												var11 = class157.loginBoxCenter - 150;
												var83 = var11 + 40 + 240 + 25;
												var82 = 231;
												var14 = var82 + 40;
												if (var6 == 1 && var78 >= var11 && var78 <= var83 && var79 >= var82 && var79 <= var14) {
													Login.field753 = ObjectSound.method423(var11, var78);
												}

												var15 = Login.loginBoxX + 180 - 80;
												short var16 = 321;
												boolean var66;
												if (var6 == 1 && var78 >= var15 - 75 && var78 <= var15 + 75 && var79 >= var16 - 20 && var79 <= var16 + 20) {
													var66 = class36.method184();
													if (var66) {
														WorldMapSection2.updateGameState(50);
														return;
													}
												}

												var15 = Login.loginBoxX + 180 + 80;
												if (var6 == 1 && var78 >= var15 - 75 && var78 <= var15 + 75 && var79 >= var16 - 20 && var79 <= var16 + 20) {
													Login.field769 = new String[8];
													SoundSystem.Login_promptCredentials(true);
												}

												while (var41.method1128()) {
													if (var41.field1899 == 101) {
														Login.field769[Login.field753] = null;
													}

													if (var41.field1899 == 85) {
														if (Login.field769[Login.field753] == null && Login.field753 > 0) {
															--Login.field753;
														}

														Login.field769[Login.field753] = null;
													}

													if (var41.field1897 >= '0' && var41.field1897 <= '9') {
														Login.field769[Login.field753] = "" + var41.field1897;
														if (Login.field753 < 7) {
															++Login.field753;
														}
													}

													if (var41.field1899 == 84) {
														var66 = class36.method184();
														if (var66) {
															WorldMapSection2.updateGameState(50);
														}

														return;
													}
												}
											} else {
												var11 = Login.loginBoxX + 180 - 80;
												var12 = 321;
												if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
													HealthBar.openURL(class251.method1336("secure", true) + "m=dob/set_dob.ws", true, false);
													class139.setLoginResponseString("", "Page has opened in the browser.", "");
													UserComparator7.method674(6);
													return;
												}

												var11 = Login.loginBoxX + 180 + 80;
												if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
													SoundSystem.Login_promptCredentials(true);
												}
											}
										} else if (Login.loginIndex == 8) {
											var11 = Login.loginBoxX + 180 - 80;
											var12 = 321;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												HealthBar.openURL("https://www.jagex.com/terms/privacy", true, false);
												class139.setLoginResponseString("", "Page has opened in the browser.", "");
												UserComparator7.method674(6);
												return;
											}

											var11 = Login.loginBoxX + 180 + 80;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												SoundSystem.Login_promptCredentials(true);
											}
										} else if (Login.loginIndex == 9) {
											var11 = Login.loginBoxX + 180;
											var12 = 311;
											if (var9.field1899 == 84 || var9.field1899 == 13 || var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												ClientPreferences.method568(false);
											}
										} else if (Login.loginIndex == 10) {
											var11 = Login.loginBoxX + 180;
											var12 = 209;
											if (var9.field1899 == 84 || var6 == 1 && var78 >= var11 - 109 && var78 <= var11 + 109 && var79 >= var12 && var79 <= var12 + 68) {
												class139.setLoginResponseString("", "Connecting to server...", "");
												Client.field648 = class531.field4233;
												VerticalAlignment.method958(false);
												WorldMapSection2.updateGameState(20);
											}
										} else if (Login.loginIndex == 12) {
											var11 = class157.loginBoxCenter;
											var12 = 233;
											var44 = var2.method2105(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
											Bounds var42 = var2.method2105(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
											Bounds var43 = var2.method2105(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var11, var12);
											var83 = var12 + 17;
											Bounds var105 = var2.method2105(0, 34, "<col=ffd200>agreement (EULA)</col>.", var11, var83);
											if (var6 == 1) {
												if (var44.method2300(var78, var79)) {
													HealthBar.openURL("https://www.jagex.com/terms", true, false);
												} else if (var42.method2300(var78, var79)) {
													HealthBar.openURL("https://www.jagex.com/terms/privacy", true, false);
												} else if (var43.method2300(var78, var79) || var105.method2300(var78, var79)) {
													HealthBar.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
												}
											}

											var11 = class157.loginBoxCenter - 80;
											var12 = 311;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												WorldMapIcon_1.clientPreferences.method560(Client.param21);
												ClientPreferences.method568(true);
											}

											var11 = class157.loginBoxCenter + 80;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												Login.loginIndex = 13;
											}
										} else if (Login.loginIndex == 13) {
											var11 = class157.loginBoxCenter;
											var12 = 321;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												ClientPreferences.method568(true);
											}
										} else if (Login.loginIndex == 14) {
											String var67 = "";
											switch(Login.field751) {
											case 0:
												var67 = "https://secure.runescape.com/m=offence-appeal/account-history";
												break;
											case 1:
												var67 = "https://secure.runescape.com/m=accountappeal/passwordrecovery";
												break;
											case 2:
												var67 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
												break;
											default:
												SoundSystem.Login_promptCredentials(false);
											}

											var83 = Login.loginBoxX + 180;
											var82 = 276;
											if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20) {
												HealthBar.openURL(var67, true, false);
												class139.setLoginResponseString("", "Page has opened in the browser.", "");
												UserComparator7.method674(6);
												return;
											}

											var83 = Login.loginBoxX + 180;
											var82 = 326;
											if (var6 == 1 && var78 >= var83 - 75 && var78 <= var83 + 75 && var79 >= var82 - 20 && var79 <= var82 + 20) {
												SoundSystem.Login_promptCredentials(false);
											}
										} else if (Login.loginIndex == 24) {
											var11 = Login.loginBoxX + 180;
											var12 = 301;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												ClientPreferences.method568(false);
											}
										} else if (Login.loginIndex == 32) {
											var11 = Login.loginBoxX + 180 - 80;
											var12 = 321;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												HealthBar.openURL(class251.method1336("secure", true) + "m=dob/set_dob.ws", true, false);
												class139.setLoginResponseString("", "Page has opened in the browser.", "");
												UserComparator7.method674(6);
												return;
											}

											var11 = Login.loginBoxX + 180 + 80;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												SoundSystem.Login_promptCredentials(true);
											}
										} else if (Login.loginIndex == 33) {
											var11 = Login.loginBoxX + 180;
											var12 = 276;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												HealthBar.openURL("https://oldschool.runescape.com/launcher", true, false);
											}

											var11 = Login.loginBoxX + 180;
											var12 = 326;
											if (var6 == 1 && var78 >= var11 - 75 && var78 <= var11 + 75 && var79 >= var12 - 20 && var79 <= var12 + 20) {
												SoundSystem.Login_promptCredentials(true);
											}
										}
									} else {
										while (true) {
											do {
												if (!var41.method1128()) {
													var81 = 321;
													if (var6 == 1 && var79 >= var81 - 20 && var79 <= var81 + 20) {
														SoundSystem.Login_promptCredentials(true);
													}

													return;
												}
											} while(var41.field1899 != 84 && var41.field1899 != 13);

											SoundSystem.Login_promptCredentials(true);
										}
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-983398043"
	)
	static int method517(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3903) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == 3904) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == 3905) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == 3906) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == 3907) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == 3908) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == 3910) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == 3911) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == 3912) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == 3913) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == 3914) {
					var13 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					if (class6.grandExchangeEvents != null) {
						class6.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
					}

					return 1;
				} else if (var0 == 3915) {
					var13 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					if (class6.grandExchangeEvents != null) {
						class6.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == 3916) {
					DbTableType.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1] == 1;
					if (class6.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						class6.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == 3917) {
					var13 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					if (class6.grandExchangeEvents != null) {
						class6.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
					}

					return 1;
				} else if (var0 == 3918) {
					var13 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
					if (class6.grandExchangeEvents != null) {
						class6.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == 3919) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class6.grandExchangeEvents == null ? 0 : class6.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == 3920) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == 3921) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var11.getOfferName();
						return 1;
					} else if (var0 == 3922) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
						return 1;
					} else if (var0 == 3923) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						long var5 = SpotAnimationDefinition.method962() - class489.field3990 - var11.age;
						int var7 = (int)(var5 / 3600000L);
						int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
						int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == 3924) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == 3925) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == 3926) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)class6.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
						return 1;
					} else if (var0 == 3939) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).isTradable ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}