import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qy")
public class class422 {
	@ObfuscatedName("ab")
	static int field3763;
	@ObfuscatedName("at")
	int field3767;
	@ObfuscatedName("ah")
	int field3764;
	@ObfuscatedName("ar")
	int field3766;
	@ObfuscatedName("ao")
	int field3765;

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field3767).length();
		int var3 = 10 - Integer.toString(this.field3766).length();
		int var4 = 10 - Integer.toString(this.field3764).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field3767 + var5 + "Created: " + this.field3764 + var7 + "Total used: " + this.field3766 + var6 + "Max-In-Use: " + this.field3765;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([I[IIII)V",
		garbageValue = "-2144991667"
	)
	public static void method2167(int[] var0, int[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			int var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			int var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;
			int var8 = var6 == Integer.MAX_VALUE ? 0 : 1;

			for (int var9 = var2; var9 < var3; ++var9) {
				if (var0[var9] < (var9 & var8) + var6) {
					int var10 = var0[var9];
					var0[var9] = var0[var5];
					var0[var5] = var10;
					int var11 = var1[var9];
					var1[var9] = var1[var5];
					var1[var5++] = var11;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			method2167(var0, var1, var2, var5 - 1);
			method2167(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "1334389960"
	)
	static int method2168(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == 4000) {
			DbTableType.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == 4001) {
			DbTableType.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == 4002) {
			DbTableType.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 * var3;
			return 1;
		} else if (var0 == 4003) {
			DbTableType.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == 4004) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == 4005) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else {
			int var5;
			int var6;
			int var7;
			if (var0 == 4006) {
				DbTableType.Interpreter_intStackSize -= 5;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
				var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 4];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
				return 1;
			} else if (var0 == 4007) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
				return 1;
			} else if (var0 == 4008) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 | 1 << var4;
				return 1;
			} else if (var0 == 4009) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
				return 1;
			} else if (var0 == 4010) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
				return 1;
			} else if (var0 == 4011) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 % var4;
				return 1;
			} else if (var0 == 4012) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
				}

				return 1;
			} else if (var0 == 4013) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				if (var3 == 0) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					return 1;
				} else {
					switch(var4) {
					case 0:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
						break;
					case 1:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
						break;
					case 2:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
						break;
					case 3:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
						break;
					case 4:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
						break;
					default:
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
					}

					return 1;
				}
			} else if (var0 == 4014) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 & var4;
				return 1;
			} else if (var0 == 4015) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 | var4;
				return 1;
			} else if (var0 == 4016) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 < var4 ? var3 : var4;
				return 1;
			} else if (var0 == 4017) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 > var4 ? var3 : var4;
				return 1;
			} else if (var0 == 4018) {
				DbTableType.Interpreter_intStackSize -= 3;
				long var9 = (long)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				long var11 = (long)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				long var13 = (long)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
				return 1;
			} else if (var0 == 4025) {
				var3 = UserComparator4.method665(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
				return 1;
			} else if (var0 == 4026) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 ^ 1 << var4;
				return 1;
			} else if (var0 == 4027) {
				DbTableType.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class197.method976(var3, var4, var5);
				return 1;
			} else if (var0 == 4028) {
				DbTableType.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class93.method500(var3, var4, var5);
				return 1;
			} else if (var0 == 4029) {
				DbTableType.Interpreter_intStackSize -= 3;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				var6 = 31 - var5;
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 << var6 >>> var6 + var4;
				return 1;
			} else if (var0 == 4030) {
				DbTableType.Interpreter_intStackSize -= 4;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
				var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
				var3 = class93.method500(var3, var5, var6);
				var7 = class214.method1092(var6 - var5 + 1);
				if (var4 > var7) {
					var4 = var7;
				}

				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 | var4 << var5;
				return 1;
			} else if (var0 == 4032) {
				Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = class174.method884(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4033) {
				Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = class195.method973(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4034) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = PacketBufferNode.method1635(var3, var4);
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var5;
				return 1;
			} else if (var0 == 4035) {
				Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = Math.abs(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]);
				return 1;
			} else if (var0 == 4036) {
				String var15 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				var4 = -1;
				if (ClientPacket.isNumber(var15)) {
					var4 = Huffman.method1888(var15);
				}

				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4;
				return 1;
			} else {
				return 2;
			}
		}
	}
}