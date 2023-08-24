import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("en")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("vv")
	static int field1180;
	@ObfuscatedName("au")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lqb;Lqb;I)I",
		garbageValue = "-1072568679"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lfh;FZI)F",
		garbageValue = "-229947551"
	)
	static float method669(class130 var0, float var1, boolean var2) {
		float var3 = 0.0F;
		if (var0 != null && var0.method726() != 0) {
			float var4 = (float)var0.field1244[0].field1202;
			float var5 = (float)var0.field1244[var0.method726() - 1].field1202;
			float var6 = var5 - var4;
			if ((double)var6 == 0.0D) {
				return var0.field1244[0].field1198;
			} else {
				float var7 = 0.0F;
				if (var1 > var5) {
					var7 = (var1 - var5) / var6;
				} else {
					var7 = (var1 - var4) / var6;
				}

				double var8 = (double)((int)var7);
				float var10 = Math.abs((float)((double)var7 - var8));
				float var11 = var10 * var6;
				var8 = Math.abs(1.0D + var8);
				double var12 = var8 / 2.0D;
				double var14 = (double)((int)var12);
				var10 = (float)(var12 - var14);
				float var16;
				float var17;
				if (var2) {
					if (var0.field1245 == class128.field1225) {
						if ((double)var10 != 0.0D) {
							var11 += var4;
						} else {
							var11 = var5 - var11;
						}
					} else if (var0.field1245 != class128.field1227 && var0.field1245 != class128.field1228) {
						if (var0.field1245 == class128.field1226) {
							var11 = var4 - var1;
							var16 = var0.field1244[0].field1200;
							var17 = var0.field1244[0].field1201;
							var3 = var0.field1244[0].field1198;
							if (0.0D != (double)var16) {
								var3 -= var11 * var17 / var16;
							}

							return var3;
						}
					} else {
						var11 = var5 - var11;
					}
				} else if (var0.field1246 == class128.field1225) {
					if ((double)var10 != 0.0D) {
						var11 = var5 - var11;
					} else {
						var11 += var4;
					}
				} else if (var0.field1246 != class128.field1227 && var0.field1246 != class128.field1228) {
					if (var0.field1246 == class128.field1226) {
						var11 = var1 - var5;
						var16 = var0.field1244[var0.method726() - 1].field1197;
						var17 = var0.field1244[var0.method726() - 1].field1199;
						var3 = var0.field1244[var0.method726() - 1].field1198;
						if (0.0D != (double)var16) {
							var3 += var17 * var11 / var16;
						}

						return var3;
					}
				} else {
					var11 += var4;
				}

				var3 = Skeleton.method1229(var0, var11);
				float var18;
				if (var2 && var0.field1245 == class128.field1228) {
					var18 = var0.field1244[var0.method726() - 1].field1198 - var0.field1244[0].field1198;
					var3 = (float)((double)var3 - (double)var18 * var8);
				} else if (!var2 && var0.field1246 == class128.field1228) {
					var18 = var0.field1244[var0.method726() - 1].field1198 - var0.field1244[0].field1198;
					var3 = (float)((double)var3 + (double)var18 * var8);
				}

				return var3;
			}
		} else {
			return var3;
		}
	}
}