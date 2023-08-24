import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("gg")
public class class160 {
	@ObfuscatedName("au")
	long field1413;
	@ObfuscatedName("ae")
	public long field1415;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Loc;"
	)
	IterableNodeDeque field1414;

	@ObfuscatedSignature(
		descriptor = "(Ltm;)V"
	)
	public class160(Buffer var1) {
		this.field1415 = -1L;
		this.field1414 = new IterableNodeDeque();
		this.method843(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-2067216516"
	)
	void method843(Buffer var1) {
		this.field1413 = var1.readLong();
		this.field1415 = var1.readLong();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 1) {
				var3 = new class155(this);
			} else if (var2 == 4) {
				var3 = new class166(this);
			} else if (var2 == 3) {
				var3 = new class151(this);
			} else if (var2 == 2) {
				var3 = new class149(this);
			} else {
				if (var2 != 5) {
					throw new RuntimeException("");
				}

				var3 = new class156(this);
			}

			((class159)var3).vmethod3238(var1);
			this.field1414.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lgo;B)V",
		garbageValue = "-40"
	)
	public void method844(ClanChannel var1) {
		if (var1.key == this.field1413 && var1.field1429 == this.field1415) {
			for (class159 var2 = (class159)this.field1414.last(); var2 != null; var2 = (class159)this.field1414.previous()) {
				var2.vmethod3239(var1);
			}

			++var1.field1429;
		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([FI)V",
		garbageValue = "-753212760"
	)
	static void method845(float[] var0) {
		var0[1] = 1.0F - var0[1];
		if (var0[0] < 0.0F) {
			var0[0] = 0.0F;
		}

		if (var0[1] < 0.0F) {
			var0[1] = 0.0F;
		}

		if (var0[0] > 1.0F || var0[1] > 1.0F) {
			float var1 = (float)(1.0D + (double)(var0[0] * (var0[0] - 2.0F + var0[1])) + ((double)var0[1] - 2.0D) * (double)var0[1]);
			if (var1 + class126.field1204 > 0.0F) {
				if (class126.field1204 + var0[0] < 1.3333334F) {
					float var2 = var0[0] - 2.0F;
					float var3 = var0[0] - 1.0F;
					float var4 = (float)Math.sqrt((double)(var2 * var2 - 4.0F * var3 * var3));
					float var5 = 0.5F * (var4 + -var2);
					if (var0[1] + class126.field1204 > var5) {
						var0[1] = var5 - class126.field1204;
					} else {
						var5 = (-var2 - var4) * 0.5F;
						if (var0[1] < var5 + class126.field1204) {
							var0[1] = class126.field1204 + var5;
						}
					}
				} else {
					var0[0] = 1.3333334F - class126.field1204;
					var0[1] = 0.33333334F - class126.field1204;
				}
			}
		}

		var0[1] = 1.0F - var0[1];
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(Lmi;Lmt;ZB)V",
		garbageValue = "0"
	)
	public static void method846(Widget var0, PlayerComposition var1, boolean var2) {
		var0.modelType = 7;
		var0.field3101 = new PlayerComposition(var1);
		if (!var2) {
			var0.field3101.equipment = Arrays.copyOf(var0.field3101.field2913, var0.field3101.field2913.length);
			var0.field3101.method1729();
		}

	}
}