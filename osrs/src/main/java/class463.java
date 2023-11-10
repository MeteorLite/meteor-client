import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rj")
public class class463 {
	@ObfuscatedName("at")
	float field3917;
	@ObfuscatedName("ah")
	float field3912;
	@ObfuscatedName("ar")
	float field3916;
	@ObfuscatedName("ao")
	float field3914;
	@ObfuscatedName("ab")
	float field3910;
	@ObfuscatedName("au")
	float field3918;
	@ObfuscatedName("aa")
	float field3909;
	@ObfuscatedName("ac")
	float field3911;
	@ObfuscatedName("al")
	float field3913;
	@ObfuscatedName("az")
	float field3920;
	@ObfuscatedName("ap")
	float field3915;
	@ObfuscatedName("av")
	float field3919;

	static {
		new class463();
	}

	class463() {
		this.method2330();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1136254272"
	)
	void method2330() {
		this.field3919 = 0.0F;
		this.field3915 = 0.0F;
		this.field3920 = 0.0F;
		this.field3911 = 0.0F;
		this.field3909 = 0.0F;
		this.field3918 = 0.0F;
		this.field3914 = 0.0F;
		this.field3916 = 0.0F;
		this.field3912 = 0.0F;
		this.field3913 = 1.0F;
		this.field3910 = 1.0F;
		this.field3917 = 1.0F;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "1766211153"
	)
	void method2331(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3912;
		float var5 = this.field3910;
		float var6 = this.field3911;
		float var7 = this.field3915;
		this.field3912 = var2 * var4 - this.field3916 * var3;
		this.field3916 = var4 * var3 + var2 * this.field3916;
		this.field3910 = var5 * var2 - this.field3918 * var3;
		this.field3918 = this.field3918 * var2 + var5 * var3;
		this.field3911 = var2 * var6 - var3 * this.field3913;
		this.field3913 = this.field3913 * var2 + var3 * var6;
		this.field3915 = var7 * var2 - this.field3919 * var3;
		this.field3919 = var3 * var7 + var2 * this.field3919;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "16"
	)
	void method2332(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3917;
		float var5 = this.field3914;
		float var6 = this.field3909;
		float var7 = this.field3920;
		this.field3917 = var3 * this.field3916 + var2 * var4;
		this.field3916 = var2 * this.field3916 - var3 * var4;
		this.field3914 = var3 * this.field3918 + var5 * var2;
		this.field3918 = this.field3918 * var2 - var3 * var5;
		this.field3909 = var2 * var6 + var3 * this.field3913;
		this.field3913 = var2 * this.field3913 - var3 * var6;
		this.field3920 = var7 * var2 + var3 * this.field3919;
		this.field3919 = var2 * this.field3919 - var7 * var3;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "1612992617"
	)
	void method2333(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3917;
		float var5 = this.field3914;
		float var6 = this.field3909;
		float var7 = this.field3920;
		this.field3917 = var4 * var2 - this.field3912 * var3;
		this.field3912 = this.field3912 * var2 + var4 * var3;
		this.field3914 = var5 * var2 - var3 * this.field3910;
		this.field3910 = var2 * this.field3910 + var3 * var5;
		this.field3909 = var6 * var2 - var3 * this.field3911;
		this.field3911 = var3 * var6 + var2 * this.field3911;
		this.field3920 = var7 * var2 - var3 * this.field3915;
		this.field3915 = var3 * var7 + this.field3915 * var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(FFFB)V",
		garbageValue = "4"
	)
	void method2334(float var1, float var2, float var3) {
		this.field3920 += var1;
		this.field3915 += var2;
		this.field3919 += var3;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3917 + "," + this.field3914 + "," + this.field3909 + "," + this.field3920 + "\n" + this.field3912 + "," + this.field3910 + "," + this.field3911 + "," + this.field3915 + "\n" + this.field3916 + "," + this.field3918 + "," + this.field3913 + "," + this.field3919;
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "-99"
	)
	static int method2335(int var0, Script var1, boolean var2) {
		if (var0 == 3300) {
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == 3301) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ClientPreferences.method535(var3, var4);
				return 1;
			} else if (var0 == 3302) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class182.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == 3303) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class27.method114(var3, var4);
				return 1;
			} else if (var0 == 3304) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = LoginPacket.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == 3305) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == 3306) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == 3307) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == 3308) {
					var3 = ItemLayer.Client_plane;
					var4 = (class229.localPlayer.x >> 7) + NewShit.baseX;
					var5 = (class229.localPlayer.y >> 7) + class101.baseY;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == 3309) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == 3310) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == 3311) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == 3312) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == 3313) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ClientPreferences.method535(var3, var4);
					return 1;
				} else if (var0 == 3314) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class182.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == 3315) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class27.method114(var3, var4);
					return 1;
				} else if (var0 == 3316) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3317) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == 3318) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == 3321) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.runEnergy / 100;
					return 1;
				} else if (var0 == 3322) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == 3323) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3324) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == 3325) {
					DbTableType.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else if (var0 == 3326) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.lastMouseRecordX;
					return 1;
				} else if (var0 == 3327) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.lastMouseRecordY;
					return 1;
				} else if (var0 == 3331) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else if (var0 == 3332) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.field564[var3];
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}