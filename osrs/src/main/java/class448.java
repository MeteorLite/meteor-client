import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rj")
public class class448 {
	@ObfuscatedName("au")
	float field3865;
	@ObfuscatedName("ae")
	float field3863;
	@ObfuscatedName("ao")
	float field3864;

	static {
		new class448(0.0F, 0.0F, 0.0F);
		new class448(1.0F, 1.0F, 1.0F);
		new class448(1.0F, 0.0F, 0.0F);
		new class448(0.0F, 1.0F, 0.0F);
		new class448(0.0F, 0.0F, 1.0F);
		WorldMapArea.method1413(100);
	}

	class448(float var1, float var2, float var3) {
		this.field3865 = var1;
		this.field3863 = var2;
		this.field3864 = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)F",
		garbageValue = "36"
	)
	final float method2291() {
		return (float)Math.sqrt((double)(this.field3865 * this.field3865 + this.field3863 * this.field3863 + this.field3864 * this.field3864));
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3865 + ", " + this.field3863 + ", " + this.field3864;
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "853635809"
	)
	static int method2292(int var0, Script var1, boolean var2) {
		if (var0 == 6200) {
			SoundCache.Interpreter_intStackSize -= 2;
			Client.field638 = (short)class155.method829(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize]);
			if (Client.field638 <= 0) {
				Client.field638 = 256;
			}

			Client.field640 = (short)class155.method829(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
			if (Client.field640 <= 0) {
				Client.field640 = 256;
			}

			return 1;
		} else if (var0 == 6201) {
			SoundCache.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == 6202) {
			SoundCache.Interpreter_intStackSize -= 4;
			Client.field635 = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			if (Client.field635 <= 0) {
				Client.field635 = 1;
			}

			Client.field634 = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			if (Client.field634 <= 0) {
				Client.field634 = 32767;
			} else if (Client.field634 < Client.field635) {
				Client.field634 = Client.field635;
			}

			Client.field641 = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
			if (Client.field641 <= 0) {
				Client.field641 = 1;
			}

			Client.field637 = (short)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
			if (Client.field637 <= 0) {
				Client.field637 = 32767;
			} else if (Client.field637 < Client.field641) {
				Client.field637 = Client.field641;
			}

			return 1;
		} else if (var0 == 6203) {
			if (Client.viewportWidget != null) {
				GrandExchangeOfferOwnWorldComparator.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == 6204) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == 6205) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class332.method1850(Client.field638);
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class332.method1850(Client.field640);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class113.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class177.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}