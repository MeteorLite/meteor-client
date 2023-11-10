import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Callable;

@ObfuscatedName("fe")
class class134 implements Callable {
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	static IndexedSprite[] field1307;
	@ObfuscatedName("uc")
	@Export("cameraLookAtAcceleration")
	static int cameraMoveToAcceleration;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfo;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class139 this$0;
	// $FF: synthetic field
	@Export("val$workStart")
	@ObfuscatedName("val$workStart")
	final int val$workStart;
	// $FF: synthetic field
	@Export("val$workEnd")
	@ObfuscatedName("val$workEnd")
	final int val$workEnd;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "[Lfd;"
	)
	@Export("val$curveLoadJobs")
	@ObfuscatedName("val$curveLoadJobs")
	final class130[] val$curveLoadJobs;

	@ObfuscatedSignature(
		descriptor = "(Lfo;II[Lfd;)V"
	)
	class134(class139 var1, int var2, int var3, class130[] var4) {
		this.this$0 = var1;
		this.val$workStart = var2;
		this.val$workEnd = var3;
		this.val$curveLoadJobs = var4;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		for (int var1 = this.val$workStart; var1 < this.val$workEnd; ++var1) {
			this.val$curveLoadJobs[var1].call();
		}

		return null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "392757608"
	)
	static boolean method730(int var0, int var1, int var2) {
		return var0 >= 0 && var0 < 4 && var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1168679162"
	)
	public static int method731(int var0) {
		return (var0 & class520.field4148) - 1;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1497825445"
	)
	static int method732(int var0, Script var1, boolean var2) {
		if (var0 == 6200) {
			DbTableType.Interpreter_intStackSize -= 2;
			Client.field640 = (short)class354.method1896(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]);
			if (Client.field640 <= 0) {
				Client.field640 = 256;
			}

			Client.field636 = (short)class354.method1896(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
			if (Client.field636 <= 0) {
				Client.field636 = 256;
			}

			return 1;
		} else if (var0 == 6201) {
			DbTableType.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == 6202) {
			DbTableType.Interpreter_intStackSize -= 4;
			Client.field639 = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			if (Client.field639 <= 0) {
				Client.field639 = 1;
			}

			Client.field637 = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			if (Client.field637 <= 0) {
				Client.field637 = 32767;
			} else if (Client.field637 < Client.field639) {
				Client.field637 = Client.field639;
			}

			Client.field638 = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
			if (Client.field638 <= 0) {
				Client.field638 = 1;
			}

			Client.field634 = (short)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
			if (Client.field634 <= 0) {
				Client.field634 = 32767;
			} else if (Client.field634 < Client.field638) {
				Client.field634 = Client.field638;
			}

			return 1;
		} else if (var0 == 6203) {
			if (Client.viewportWidget != null) {
				class348.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == 6204) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == 6205) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class142.method758(Client.field640);
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class142.method758(Client.field636);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Language.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class47.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}