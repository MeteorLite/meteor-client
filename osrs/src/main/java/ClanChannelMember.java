import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("ClanChannelMember")
public class ClanChannelMember {
	@ObfuscatedName("c")
	@Export("rank")
	public byte rank;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 946209429
	)
	@Export("world")
	public int world;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lqo;"
	)
	@Export("username")
	public Username username;

	ClanChannelMember() {
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(Lai;I)V",
		garbageValue = "-1714454103"
	)
	static void method3026(GameEngine var0) {
		while (class28.isKeyDown()) {
			if (class142.field1665 == 13) {
				Login.worldSelectOpen = false;
				TextureProvider.leftTitleSprite.drawAt(Login.xPadding, 0);
				PcmPlayer.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				MilliClock.logoSprite.drawAt(Login.xPadding + 382 - MilliClock.logoSprite.subWidth / 2, 18);
				return;
			}

			if (class142.field1665 == 96) {
				if (Login.worldSelectPage > 0 && class239.worldSelectLeftSprite != null) {
					--Login.worldSelectPage;
				}
			} else if (class142.field1665 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class13.worldSelectRightSprite != null) {
				++Login.worldSelectPage;
			}
		}

		if (MouseHandler.MouseHandler_lastButton == 1 || !Renderable.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
			int var1 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(0, 1);
				return;
			}

			int var2 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(1, 1);
				return;
			}

			int var3 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(2, 1);
				return;
			}

			int var4 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class434.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
				Login.worldSelectOpen = false;
				TextureProvider.leftTitleSprite.drawAt(Login.xPadding, 0);
				PcmPlayer.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				MilliClock.logoSprite.drawAt(Login.xPadding + 382 - MilliClock.logoSprite.subWidth / 2, 18);
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var5 = World.World_worlds[Login.hoveredWorldIndex];
				class221.changeWorld(var5);
				Login.worldSelectOpen = false;
				TextureProvider.leftTitleSprite.drawAt(Login.xPadding, 0);
				PcmPlayer.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
				MilliClock.logoSprite.drawAt(Login.xPadding + 382 - MilliClock.logoSprite.subWidth / 2, 18);
				return;
			}

			if (Login.worldSelectPage > 0 && class239.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class239.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class166.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class166.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && class13.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= class123.canvasWidth - class13.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= class123.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class166.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class166.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "911196083"
	)
	static int method3025(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3500) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class294.method5768(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3501) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class114.method2806(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3502) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GameObject.method4666(var3) ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
