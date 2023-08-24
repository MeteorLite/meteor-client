import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("np")
public enum class352 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnp;"
	)
	field3482(-1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnp;"
	)
	field3479(0),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lnp;"
	)
	field3480(1),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnp;"
	)
	field3481(2);

	@ObfuscatedName("ac")
	final int field3483;

	class352(int var3) {
		this.field3483 = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3483;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "1"
	)
	static int method1880(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 4000) {
			SoundCache.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == 4001) {
			SoundCache.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == 4002) {
			SoundCache.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == 4003) {
			SoundCache.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == 4004) {
			var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == 4005) {
			var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else {
			int var5;
			int var6;
			int var7;
			if (var0 == 4006) {
				SoundCache.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 4];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
				return 1;
			} else if (var0 == 4007) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 + var4 * var3 / 100;
				return 1;
			} else if (var0 == 4008) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 | 1 << var4;
				return 1;
			} else if (var0 == 4009) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
				return 1;
			} else if (var0 == 4010) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
				return 1;
			} else if (var0 == 4011) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 % var4;
				return 1;
			} else if (var0 == 4012) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
				} else {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
				}

				return 1;
			} else if (var0 == 4013) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					return 1;
				} else {
					switch(var4) {
					case 0:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
						break;
					case 1:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3;
						break;
					case 2:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
						break;
					case 3:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
						break;
					case 4:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
						break;
					default:
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
					}

					return 1;
				}
			} else if (var0 == 4014) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 & var4;
				return 1;
			} else if (var0 == 4015) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 | var4;
				return 1;
			} else if (var0 == 4016) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 < var4 ? var3 : var4;
				return 1;
			} else if (var0 == 4017) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 > var4 ? var3 : var4;
				return 1;
			} else if (var0 == 4018) {
				SoundCache.Interpreter_intStackSize -= 3;
				long var9 = (long)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				long var11 = (long)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				long var13 = (long)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (int)(var9 * var13 / var11);
				return 1;
			} else if (var0 == 4025) {
				var3 = PacketBufferNode.method1609(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3;
				return 1;
			} else if (var0 == 4026) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 ^ 1 << var4;
				return 1;
			} else if (var0 == 4027) {
				SoundCache.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Widget.method1812(var3, var4, var5);
				return 1;
			} else if (var0 == 4028) {
				SoundCache.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = InvDefinition.method940(var3, var4, var5);
				return 1;
			} else if (var0 == 4029) {
				SoundCache.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				var6 = 31 - var5;
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 << var6 >>> var6 + var4;
				return 1;
			} else if (var0 == 4030) {
				SoundCache.Interpreter_intStackSize -= 4;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
				var3 = InvDefinition.method940(var3, var5, var6);
				var7 = Projectile.method430(var6 - var5 + 1);
				if (var4 > var7) {
					var4 = var7;
				}

				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 | var4 << var5;
				return 1;
			} else if (var0 == 4032) {
				Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = Frames.method1292(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4033) {
				Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = SongTask.method2137(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4034) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				var5 = class350.method1876(var3, var4);
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var5;
				return 1;
			} else if (var0 == 4035) {
				Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = Math.abs(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4036) {
				String var15 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
				var4 = -1;
				if (class218.isNumber(var15)) {
					var4 = HealthBarUpdate.method524(var15);
				}

				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4;
				return 1;
			} else {
				return 2;
			}
		}
	}
}