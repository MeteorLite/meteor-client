import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sk")
public class class477 extends class479 {
	@ObfuscatedName("au")
	int field3967;
	@ObfuscatedName("ae")
	int field3963;
	@ObfuscatedName("ao")
	int field3965;
	@ObfuscatedName("at")
	int field3966;
	@ObfuscatedName("ac")
	int field3962;
	@ObfuscatedName("ai")
	int field3964;

	public class477(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		super(var7, var8);
		this.field3967 = 0;
		this.field3963 = 0;
		this.field3965 = 0;
		this.field3966 = 0;
		this.field3962 = 0;
		this.field3964 = 0;
		this.field3967 = var1;
		this.field3963 = var2;
		this.field3965 = var3;
		this.field3966 = var4;
		this.field3962 = var5;
		this.field3964 = var6;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "818000115"
	)
	public int vmethod2349() {
		double var1 = this.method2377();
		return (int)Math.round((double)(this.field3966 - this.field3967) * var1 + (double)this.field3967);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "363084355"
	)
	public int vmethod2347() {
		double var1 = this.method2377();
		return (int)Math.round(var1 * (double)(this.field3962 - this.field3963) + (double)this.field3963);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1706544959"
	)
	public int vmethod2320() {
		double var1 = this.method2377();
		return (int)Math.round((double)this.field3965 + (double)(this.field3964 - this.field3965) * var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([I[IIII)V",
		garbageValue = "-1387907364"
	)
	public static void method2370(int[] var0, int[] var1, int var2, int var3) {
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
			method2370(var0, var1, var2, var5 - 1);
			method2370(var0, var1, var5 + 1, var3);
		}

	}
}